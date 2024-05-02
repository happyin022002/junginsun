/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CandidateManageSC.java
*@FileTitle : CandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage;

import java.util.List;

import com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.basic.CandidateConfirmBC;
import com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.basic.CandidateConfirmBCImpl;
import com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.event.EsdTpb0105Event;
import com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.integration.CandidateConfirmDBDAO;
import com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.vo.SearchCandidateListVO;
import com.clt.apps.opus.esd.tpb.candidatemanage.interfacedcancel.basic.InterfacedCancelBC;
import com.clt.apps.opus.esd.tpb.candidatemanage.interfacedcancel.basic.InterfacedCancelBCImpl;
import com.clt.apps.opus.esd.tpb.candidatemanage.interfacedcancel.event.EsdTpb0133Event;
import com.clt.apps.opus.esd.tpb.candidatemanage.interfacedcancel.vo.SearchInterfacedCancelListVO;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.basic.ManualRegisterBC;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.basic.ManualRegisterBCImpl;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.event.EsdTpb0103Event;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.event.EsdTpb0104Event;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.event.EsdTpb0801Event;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.event.EsdTpb0811Event;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.event.EsdTpb0813Event;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.SearchContainerInfoVO;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.SearchTPBDuplicationListVO;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.SearchTPBOfficeListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
 

/**
 * -CandidateManage Business Logic ServiceCommand - -CandidateManage Business Logic Interface
 * 
 * @author 
 * @see CandidateConfirmDBDAO
 * @since J2EE 1.6
 */ 

public class CandidateManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CandidateManage system Business scenario process<br>
	 * calling business scenario<br>
	 */
	public void doStart() {
		log.debug("CandidateManageSC 시작");
		try {
			// checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CandidateManage system Business scenario deadline<br>
	 * in case of business scenario deadline<br>
	 */
	public void doEnd() {
		log.debug("CandidateManageSC 종료");
	}

	/**
	 * -branch processing all event by CandidateManage system business<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC event
		if (e.getEventName().equalsIgnoreCase("EsdTpb0103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI) 
					|| e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createTPBCandidate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI) 
					|| e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createEACRegistration(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0105Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCandidateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCandidateConfirm(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0801Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBDuplicationList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0811Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainerInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0133Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCanceledTPB(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				interfacedTPBCancel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0813Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBOfficeList(e);
			}
		}
		return eventResponse;
	}
	/**
	 * EsdTpb0105<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCandidateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0105Event event = (EsdTpb0105Event)e;
		CandidateConfirmBC command = new CandidateConfirmBCImpl();

		try{
			List<SearchCandidateListVO> list = command.searchCandidateList(event.getSearchCandidateListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0801<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBDuplicationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0801Event event = (EsdTpb0801Event)e;
		ManualRegisterBC command = new ManualRegisterBCImpl();
		
		try{
			List<SearchTPBDuplicationListVO> list = command.searchTPBDuplicationList(event.getSearchTPBDuplicationListVO(), account);
			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * EsdTpb0811<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0811Event event = (EsdTpb0811Event)e;
		ManualRegisterBC command = new ManualRegisterBCImpl();
		
		try{
			List<SearchContainerInfoVO> list = command.searchContainerInfo(event.getSearchContainerInfoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb1330<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCanceledTPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0133Event event = (EsdTpb0133Event)e;
		InterfacedCancelBC command = new InterfacedCancelBCImpl();
		
		try{
			List<SearchInterfacedCancelListVO> list = command.searchCanceledTPB(event.getSearchInterfacedCancelListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EsdTpb0103<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createTPBCandidate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0103Event event = (EsdTpb0103Event)e;
		ManualRegisterBC command = new ManualRegisterBCImpl();
		try{
			begin();
			command.createTPBCandidate(event.getCreateTPBCandidateVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EsdTpb0104<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createEACRegistration(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0104Event event = (EsdTpb0104Event)e;
		ManualRegisterBC command = new ManualRegisterBCImpl();
		try{
			begin();
			command.createEACRegistration(event.getCreateEACRegistrationVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EsdTpb0105<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCandidateConfirm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0105Event event = (EsdTpb0105Event)e;
		CandidateConfirmBC command = new CandidateConfirmBCImpl();
		try{
			begin();
			List<SearchCandidateListVO> list =  command.multiCandidateConfirm(event.getSearchCandidateListVOS(),account);
			eventResponse.setRsVoList(list);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EsdTpb0133<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse interfacedTPBCancel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0133Event event = (EsdTpb0133Event)e;
		InterfacedCancelBC command = new InterfacedCancelBCImpl();
		try{
			begin();
			command.interfacedTPBCancel(event.getSearchInterfacedCancelListVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EsdTpb0916<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0813Event event = (EsdTpb0813Event)e;
		ManualRegisterBC command = new ManualRegisterBCImpl();

		try{
			List<SearchTPBOfficeListVO> list = command.searchTPBOfficeList(event.getSearchTPBOfficeListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	
}