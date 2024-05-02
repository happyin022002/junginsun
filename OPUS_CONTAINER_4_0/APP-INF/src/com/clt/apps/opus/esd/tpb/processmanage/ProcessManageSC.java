/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProcessManageSC.java
*@FileTitle : ProcessManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.basic.AdjustmentManageBC;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.basic.AdjustmentManageBCImpl;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.event.EsdTpb0113Event;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.event.EsdTpb0114Event;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.event.EsdTpb0804Event;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.integration.AdjustmentManageDBDAO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchROCToOfficeListVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeInquiryVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffInquiryVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.basic.InvoiceManageBC;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.basic.InvoiceManageBCImpl;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0106Event;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0109Event;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0110Event;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0111Event;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0112Event;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0812Event;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchIndiaTaxInfoVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceSettingVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchTPBHandlingVO;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.basic.OutstandinggroupManageBC;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.basic.OutstandinggroupManageBCImpl;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.event.EsdTpb0107Event;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.event.EsdTpb0108Event;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchTPBGroupRemakingVO;
import com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchTPBModificationVO;
import com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.basic.RecoveryActivityManageBC;
import com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.basic.RecoveryActivityManageBCImpl;
import com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.event.EsdTpb0807Event;
import com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.vo.SearchRecoveryActivityListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * -ProcessManage Business Logic ServiceCommand - -ProcessManage business transaction processing
 * 
 * @author 
 * @see AdjustmentManageDBDAO
 * @since J2EE 1.6
 */

public class ProcessManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ProcessManage system business scenario<br>
	 * calling business scenario<br>
	 */
	public void doStart() {
		log.debug("ProcessManageSC 시작");
		try {
			//checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ProcessManage system business scenario deadliine<br>
	 * business scenario deadliine<br>
	 */
	public void doEnd() {
		log.debug("ProcessManageSC 종료");
	}

	/**
	 * business scenario processing<br>
	 * -branch processing all event by ProcessManage system business<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("EsdTpb0106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBHandling(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createERPInterface(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = cancelTPBHandling(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0107Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBGroupRemaking(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyTPBGroupRemaking(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0108Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBModification(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyTPBModification(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0109Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceSheetSet(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createInvoiceSheetSet(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceCreation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createInvoice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createERPInterface(e);
			}else{
				eventResponse = searchInvoiceInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0111Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceDetailListForRevision(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchInvoiceDefaultData(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyInvoice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeInvoice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createERPInterface(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0112Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceStatus(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = updateInvoiceIssue(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCntCdbyOfcCd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0113Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchResponsibleOfficeChangeInquiry(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchResponsibleOfficeChange(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 
				eventResponse = createResponsibleOfficeChangeRequest(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 
				eventResponse = createResponsibleOfficeChangeApprove(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				removeResponsibleOfficeChangeRequest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0114Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchWriteOffInquiry(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchWriteOff(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 
				eventResponse = createWriteOffRequest(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 
				eventResponse = createWriteOffApprove(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				removeWriteOffRequest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0804Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchROCToOfficeList(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0807Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRecoveryActivity(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01) ){
				eventResponse = multiRecoveryActivity(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0812Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIndiaTaxInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01) ){
				eventResponse = searchIndiaTaxInfoByEffDate(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI) ){
				eventResponse = multiIndiaTaxInfo(e);
			}
		}
		return eventResponse;
	}
	
	
	/**
	 * ESD_TPB_0106<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBHandling(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0106Event event = (EsdTpb0106Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
		try{
			List<SearchTPBHandlingVO> list = command.searchTPBHandling(event.getSearchTPBHandlingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0109<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceSheetSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0109Event event = (EsdTpb0109Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
		try{
			List<SearchInvoiceSettingVO> list = command.searchInvoiceSheetSet(event.getSearchInvoiceSettingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0107<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBGroupRemaking(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0107Event event = (EsdTpb0107Event)e;
		OutstandinggroupManageBC command = new OutstandinggroupManageBCImpl();
		
		try{
			List<SearchTPBGroupRemakingVO> list = command.searchTPBGroupRemaking(event.getSearchTPBGroupRemakingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0108<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBModification(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0108Event event = (EsdTpb0108Event)e;
		OutstandinggroupManageBC command = new OutstandinggroupManageBCImpl();
		
		try{
			List<SearchTPBModificationVO> list = command.searchTPBModification(event.getSearchTPBModificationVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0110<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceCreation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0110Event event = (EsdTpb0110Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
		try{
			eventResponse = command.searchInvoiceCreation(event, eventResponse);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0110<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0110Event event = (EsdTpb0110Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
		try{
			List<InvoiceCreationVO> list = command.searchInvoiceInfo(event.getInvoiceCreationVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0111<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceDetailListForRevision(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0111Event event = (EsdTpb0111Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
		try{
			eventResponse = command.searchInvoiceDetailListForRevision(event, eventResponse);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0111<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceDefaultData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0111Event event = (EsdTpb0111Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
//		log.debug("searchInvoiceDefaultDataSC");
		try{
			eventResponse = command.searchInvoiceDefaultData(event.getSearchInvoiceDefaultDataVO(), eventResponse, account);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0112<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceStatus(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0112Event event = (EsdTpb0112Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
		try{
			eventResponse = command.searchInvoiceStatus(event, eventResponse);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0112<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	private EventResponse updateInvoiceIssue(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0112Event event = (EsdTpb0112Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();

		String fax_eml_snd_no = null;
		
		try{
			begin();
			fax_eml_snd_no = command.updateInvoiceIssue(event.getSearchInvoiceStatusVO(),account);
			//eventResponse.setCustomData(SubSystemConfigFactory.get("COM.MAIL.KEYS"), mailInvoice.send2(vo1));
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return this.searchInvoiceStatus(e);
	}
	
	/**
	 * ESD_TPB_0112<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntCdbyOfcCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0112Event event = (EsdTpb0112Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
		try{
			eventResponse = command.searchCntCdbyOfcCd(event, eventResponse);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_TPB_0113<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchResponsibleOfficeChange(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0113Event event = (EsdTpb0113Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		
		try{
			List<SearchResponsibleOfficeChangeVO> list = command.searchResponsibleOfficeChange(event.getSearchResponsibleOfficeChangeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0113<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchResponsibleOfficeChangeInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0113Event event = (EsdTpb0113Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		
		try{
			List<SearchResponsibleOfficeChangeInquiryVO> list = command.searchResponsibleOfficeChangeInquiry(event.getSearchResponsibleOfficeChangeInquiryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0114<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWriteOff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0114Event event = (EsdTpb0114Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		
		try{
			List<SearchWriteOffVO> list = command.searchWriteOff(event.getSearchWriteOffVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0114<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWriteOffInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0114Event event = (EsdTpb0114Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		
		try{
			List<SearchWriteOffInquiryVO> list = command.searchWriteOffInquiry(event.getSearchWriteOffInquiryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0804<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchROCToOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0804Event event = (EsdTpb0804Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		
		try{
			List<SearchROCToOfficeListVO> list = command.searchROCToOfficeList(event.getSearchROCToOfficeListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0807<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRecoveryActivity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0807Event event = (EsdTpb0807Event)e;
		RecoveryActivityManageBC command = new RecoveryActivityManageBCImpl();
		
		try{
			List<SearchRecoveryActivityListVO> list = command.searchRecoveryActivity(event.getSearchRecoveryActivityListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0812<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIndiaTaxInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0812Event event = (EsdTpb0812Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
		try{
			List<SearchIndiaTaxInfoVO> list = command.searchIndiaTaxInfo(event.getSearchIndiaTaxInfoVO(),account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0812<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */ 
	private EventResponse searchIndiaTaxInfoByEffDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0812Event event = (EsdTpb0812Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
		try{
			List<SearchIndiaTaxInfoVO> list = command.searchIndiaTaxInfoByEffDate(event.getSearchIndiaTaxInfoVO(),account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESD_TPB_0107<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTPBGroupRemaking(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0107Event event = (EsdTpb0107Event)e;
		OutstandinggroupManageBC command = new OutstandinggroupManageBCImpl();
		try{
			begin();
			command.modifyTPBGroupRemaking(event.getModifyTPBGroupRemakingVOS(),account);
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
	 * ESD_TPB_0106<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse createERPInterface(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceManageBC command = new InvoiceManageBCImpl();
		GeneralARInvoiceCreationBC arInterFace = new GeneralARInvoiceCreationBCImpl();
		List<ARInterfaceCreationVO> rGenIfVOs = new ArrayList<ARInterfaceCreationVO>();
		try{
			begin();
			eventResponse = command.createERPInterface(e);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			List<ARInterfaceCreationVO> genIfVOs = (List<ARInterfaceCreationVO>)eventResponse.getRsVoList();
			if(genIfVOs.size() > 0){
				rGenIfVOs = arInterFace.interfaceGeneralARInvoiceToIF(genIfVOs);
			}
			if(rGenIfVOs.size() > 0){
				String arReturnVal = arInterFace.interfaceGeneralARInvoiceToINV(rGenIfVOs);
				log.error("createERPInterface_arReturnVal>>>>>>>>>>>>>>>>>>>>>>>>>>"+arReturnVal);
				if(arReturnVal != null && !arReturnVal.equals("")){
					eventResponse.setETCData("ARReturnVal", arReturnVal);
					String[] arReturnVals =  arReturnVal.split("::");
					log.error("createERPInterface_arReturnVals[0]>>>>>>>>>>>>>>>>>>>>>>>>>>"+arReturnVals[0]);
					log.error("createERPInterface_arReturnVals[1]>>>>>>>>>>>>>>>>>>>>>>>>>>"+arReturnVals[1]);
					if(arReturnVals[0].equals("E")){
						eventResponse.setUserMessage(arReturnVal);
						throw new EventException(new ErrorHandler("TPB00040",new String[]{arReturnVals[1]}).getMessage());
					}
				}
			}
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
	 * ESD_TPB_0108<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTPBModification(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0108Event event = (EsdTpb0108Event)e;
		OutstandinggroupManageBC command = new OutstandinggroupManageBCImpl();
		try{
			begin();
			command.modifyTPBModification(event.getModifyTPBModificationVOS(),account);
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
	 * ESD_TPB_0109<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createInvoiceSheetSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0109Event event = (EsdTpb0109Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		try{
			begin();
			command.createInvoiceSheetSet(event.getSearchInvoiceSettingVOS(),account);
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
	 * ESD_TPB_0110<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0110Event event = (EsdTpb0110Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		try{
			begin();
			eventResponse = command.createInvoice(event.getInvoiceCreationVOs(), eventResponse,  account);
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
	 * ESD_TPB_0111<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0111Event event = (EsdTpb0111Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		try{
			begin();
			eventResponse = command.modifyInvoice(event.getInvoiceCreationVOs(),account, eventResponse);
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
	 * ESD_TPB_0111<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse removeInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0111Event event = (EsdTpb0111Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		GeneralARInvoiceCreationBC arInterFace = new GeneralARInvoiceCreationBCImpl();
		List<ARInterfaceCreationVO> rGenIfVOs = new ArrayList<ARInterfaceCreationVO>();
		try{
			begin();
			eventResponse = command.removeInvoice(event.getInvoiceCreationVO(),account, eventResponse);
			List<ARInterfaceCreationVO> genIfVOs = (List<ARInterfaceCreationVO>)eventResponse.getRsVoList();
			if(genIfVOs.size() > 0){
				rGenIfVOs = arInterFace.interfaceGeneralARInvoiceToIF(genIfVOs);
			}
			if(rGenIfVOs.size() > 0){
				String arReturnVal = arInterFace.interfaceGeneralARInvoiceToINV(rGenIfVOs);
				log.error("removeInvoice_arReturnVal>>>>>>>>>>>>>>>>>>>>>>>>>>"+arReturnVal);
				if(arReturnVal != null && !arReturnVal.equals("")){		
					eventResponse.setETCData("ARReturnVal", arReturnVal);
					String[] arReturnVals =  arReturnVal.split("::");
					log.error("removeInvoice_arReturnVals[0]>>>>>>>>>>>>>>>>>>>>>>>>>>"+arReturnVals[0]);
					log.error("removeInvoice_arReturnVals[1]>>>>>>>>>>>>>>>>>>>>>>>>>>"+arReturnVals[1]);
					if(arReturnVals[0].equals("E")){
						eventResponse.setUserMessage(arReturnVal);
						throw new EventException(new ErrorHandler("TPB00040",new String[]{arReturnVals[1]}).getMessage());
					}
				}
			}
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
	 * ESD_TPB_0113<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createResponsibleOfficeChangeRequest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0113Event event = (EsdTpb0113Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.createResponsibleOfficeChangeRequest(event.getCreateResponsibleOfficeChangeRequestVOS(),account);
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
	 * ESD_TPB_0113<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createResponsibleOfficeChangeApprove(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0113Event event = (EsdTpb0113Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.createResponsibleOfficeChangeApprove(event.getCreateResponsibleOfficeChangeApproveVOS(),account);
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
	 * ESD_TPB_0113<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeResponsibleOfficeChangeRequest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0113Event event = (EsdTpb0113Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.removeResponsibleOfficeChangeRequest(event.getDeleteResponsibleOfficeChangeRequestVOS(),account);
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
	 * ESD_TPB_0114<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createWriteOffRequest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0114Event event = (EsdTpb0114Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.createWriteOffRequest(event.getCreateWriteOffRequestVOS(),account);
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
	 * ESD_TPB_0114<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createWriteOffApprove(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0114Event event = (EsdTpb0114Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.createWriteOffApprove(event.getCreateWriteOffApproveVOS(),account);
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
	 * ESD_TPB_0114<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeWriteOffRequest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0114Event event = (EsdTpb0114Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.removeWriteOffRequest(event.getDeleteWriteOffRequestVOS(),account);
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
	 * ESD_TPB_0807<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiRecoveryActivity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0807Event event = (EsdTpb0807Event)e;
		RecoveryActivityManageBC command = new RecoveryActivityManageBCImpl();
		try{
			begin();
			command.multiRecoveryActivity(event.getSearchRecoveryActivityListVOS(),account);
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
	 * ESD_TPB_0812<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiIndiaTaxInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0812Event event = (EsdTpb0812Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		try{
			begin();
			command.multiIndiaTaxInfo(event.getSearchIndiaTaxInfoVOs(),account);
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
	 * ESD_TPB_0106<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelTPBHandling(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceManageBC command = new InvoiceManageBCImpl();
		EsdTpb0106Event event = (EsdTpb0106Event)e;
		try{
			begin();
			command.cancelTPBHandling(event.getSearchTPBHandlingVOS(), account);
			commit();
			
//			List<SearchTPBHandlingVO> list = command.searchTPBHandling(event.getSearchTPBHandlingVO());
//			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}