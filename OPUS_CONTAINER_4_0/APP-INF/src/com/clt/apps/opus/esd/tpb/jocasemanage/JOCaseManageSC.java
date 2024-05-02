/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOCaseManageSC.java
*@FileTitle : JOStatusInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tpb.jocasemanage.jocandidateconfirm.basic.JOCandidateConfirmBC;
import com.clt.apps.opus.esd.tpb.jocasemanage.jocandidateconfirm.basic.JOCandidateConfirmBCImpl;
import com.clt.apps.opus.esd.tpb.jocasemanage.jocandidateconfirm.event.EsdTpb0122Event;
import com.clt.apps.opus.esd.tpb.jocasemanage.jocandidateconfirm.vo.SearchJOCandidateConfirmListVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.basic.JOInvoiceManageBC;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.basic.JOInvoiceManageBCImpl;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0123Event;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0124Event;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0126Event;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0127Event;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.InvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSheetSetVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchTPBHandlingListVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.jooutstandinggroupmanage.basic.JOOutstandinggroupManageBC;
import com.clt.apps.opus.esd.tpb.jocasemanage.jooutstandinggroupmanage.basic.JOOutstandinggroupManageBCImpl;
import com.clt.apps.opus.esd.tpb.jocasemanage.jooutstandinggroupmanage.event.EsdTpb0125Event;
import com.clt.apps.opus.esd.tpb.jocasemanage.jooutstandinggroupmanage.vo.SearchTPBGroupModifyListVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.basic.JOStatusInquiryBC;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.basic.JOStatusInquiryBCImpl;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.event.EsdTpb0128Event;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.event.EsdTpb0129Event;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.event.EsdTpb0130Event;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.integration.JOStatusInquiryDBDAO;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOInvoiceListVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOTPBDetailInfoVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOTPBDetailListVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchProcessListVO;
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
 * -CandidateManage Business Logic ServiceCommand - -CandidateManage business transaction processing
 * 
 * @author 
 * @see JOStatusInquiryDBDAO
 * @since J2EE 1.6
 */

public class JOCaseManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CandidateManage system business scenario process<br>
	 * calling business scenario<br>
	 */
	public void doStart() {
		log.debug("CandidateManageSC 시작");
		try {
			//checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CandidateManage system business scenario deadline<br>
	 * business scenario deadline<br>
	 */
	public void doEnd() {
		log.debug("CandidateManageSC 종료");
	}

	/**
	 * business scenario<br>
	 * -branch processing all event by JOCaseManage system business<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		
		if (e.getEventName().equalsIgnoreCase("EsdTpb0122Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCandidateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCandidateConfirm(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0124Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBHandlingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createERPInterface(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0123Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceSheetSet(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createInvoiceSheetSet(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0125Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBGroupModifyList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiTPBGroupModify(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = updateJOTPBCancel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0126Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceCreation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createInvoice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createERPInterface(e);
			}else{
				eventResponse = searchInvoiceInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0127Event")) { 
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
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0128Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBDetailInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01 )) {
				eventResponse = searchTPBDetailList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0129Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0130Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProcessList(e);
			}
		} 
		return eventResponse;
	}
	/**
	 * EsdTpb0122<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCandidateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0122Event event = (EsdTpb0122Event)e;
		JOCandidateConfirmBC command = new JOCandidateConfirmBCImpl();

		try{
			List<SearchJOCandidateConfirmListVO> list = command.searchCandidateList(event.getSearchJOCandidateConfirmListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0122<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCandidateConfirm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0122Event event = (EsdTpb0122Event)e;
		JOCandidateConfirmBC command = new JOCandidateConfirmBCImpl();
		try{
			begin();
			List<SearchJOCandidateConfirmListVO> list = command.multiCandidateConfirm(event.getSearchJOCandidateConfirmListVOS(),account);
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
	 * EsdTpb0124<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBHandlingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0124Event event = (EsdTpb0124Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();

		try{
			List<SearchTPBHandlingListVO> list = command.searchTPBHandlingList(event.getSearchTPBHandlingListVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0124<br>
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
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
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
				log.error("JO_createERPInterface_arReturnVal>>>>>>>>>>>>>>>>>>>>>>>>>>"+arReturnVal);
				if(arReturnVal != null && !arReturnVal.equals("")){
					eventResponse.setETCData("ARReturnVal", arReturnVal);
					String[] arReturnVals =  arReturnVal.split("::");
					log.error("JO_createERPInterface_arReturnVals[0]>>>>>>>>>>>>>>>>>>>>>>>>>>"+arReturnVals[0]);
					log.error("JO_createERPInterface_arReturnVals[1]>>>>>>>>>>>>>>>>>>>>>>>>>>"+arReturnVals[1]);
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
	 * EsdTpb0123<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceSheetSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0123Event event = (EsdTpb0123Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
		
		try{
			List<SearchInvoiceSheetSetVO> list = command.searchInvoiceSheetSet(event.getSearchInvoiceSheetSetVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0123<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createInvoiceSheetSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0123Event event = (EsdTpb0123Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
		try{
			begin();
			command.createInvoiceSheetSet(event.getSearchInvoiceSheetSetVOS(),account);
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
	 * EsdTpb0125<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBGroupModifyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0125Event event = (EsdTpb0125Event)e;
		JOOutstandinggroupManageBC command = new JOOutstandinggroupManageBCImpl();
		
		try{
			List<SearchTPBGroupModifyListVO> list = command.searchTPBGroupModifyList(event.getSearchTPBGroupModifyListVO(),account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0125<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiTPBGroupModify(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0125Event event = (EsdTpb0125Event)e;
		JOOutstandinggroupManageBC command = new JOOutstandinggroupManageBCImpl();
		try{
			begin();
			List<SearchTPBGroupModifyListVO> list = command.multiTPBGroupModify(event.getSearchTPBGroupModifyListVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setRsVoList(list);
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
	 * EsdTpb0125<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse updateJOTPBCancel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0125Event event = (EsdTpb0125Event)e;
		JOOutstandinggroupManageBC command = new JOOutstandinggroupManageBCImpl();
		try{
			begin();
			List<SearchTPBGroupModifyListVO> list = command.updateJOTPBCancel(event.getSearchTPBGroupModifyListVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setRsVoList(list);
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
	* EsdTpb0126<br>
	* <br>
	* 
	* @param Event e
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchInvoiceCreation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0126Event event = (EsdTpb0126Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
		
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
	 * ESD_TPB_0126<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0126Event event = (EsdTpb0126Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
		
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
	 * EsdTpb0126<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0126Event event = (EsdTpb0126Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
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
	 * EsdTpb0127<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceDetailListForRevision(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0127Event event = (EsdTpb0127Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
		
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
	 * EsdTpb0127<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceDefaultData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0127Event event = (EsdTpb0127Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
		
		try{
			eventResponse = command.searchInvoiceDefaultData(event.getSearchInvoiceDefaultDataVO(), eventResponse, account);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EsdTpb0127<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0127Event event = (EsdTpb0127Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
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
	 * EsdTpb0128<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBDetailInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0128Event event = (EsdTpb0128Event)e;
		JOStatusInquiryBC command = new JOStatusInquiryBCImpl();
		
		try{
			List<SearchJOTPBDetailInfoVO> list = command.searchTPBDetailInfo(event.getSearchJOTpbDetailInfoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0128<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0128Event event = (EsdTpb0128Event)e;
		JOStatusInquiryBC command = new JOStatusInquiryBCImpl();
		
		try{
			List<SearchJOTPBDetailListVO> list = command.searchTPBDetailList(event.getSearchJOTpbDetailListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0127<br>
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
		EsdTpb0127Event event = (EsdTpb0127Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
		GeneralARInvoiceCreationBCImpl arInterFace = new GeneralARInvoiceCreationBCImpl();
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
				log.error("JO_removeInvoice_arReturnVal>>>>>>>>>>>>>>>>>>>>>>>>>>"+arReturnVal);
				if(arReturnVal != null && !arReturnVal.equals("")){		
					eventResponse.setETCData("ARReturnVal", arReturnVal);
					String[] arReturnVals =  arReturnVal.split("::");
					log.error("JO_removeInvoice_arReturnVals[0]>>>>>>>>>>>>>>>>>>>>>>>>>>"+arReturnVals[0]);
					log.error("JO_removeInvoice_arReturnVals[1]>>>>>>>>>>>>>>>>>>>>>>>>>>"+arReturnVals[1]);
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
	 * EsdTpb0129<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0129Event event = (EsdTpb0129Event)e;
		JOStatusInquiryBC command = new JOStatusInquiryBCImpl();
		
		try{
			List<SearchJOInvoiceListVO> list = command.searchInvoiceList(event.getSearchJOInvoiceListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EsdTpb0130<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProcessList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0130Event event = (EsdTpb0130Event)e;
		JOStatusInquiryBC command = new JOStatusInquiryBCImpl();
		
		try{
			List<SearchProcessListVO> list = command.searchProcessList(event.getSearchProcessListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
}