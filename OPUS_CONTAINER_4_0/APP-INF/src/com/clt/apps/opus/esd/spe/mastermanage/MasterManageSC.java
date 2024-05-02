/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MasterManageSC.java
*@FileTitle : Evaluation Group
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage;

import java.util.List;

import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.basic.EvaluationGroupManageBC;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.basic.EvaluationGroupManageBCImpl;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.event.EsdSpe0001Event;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.integration.EvaluationGroupManageDBDAO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdListVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.basic.EvaluationGroupServiceProviderManageBC;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.basic.EvaluationGroupServiceProviderManageBCImpl;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.event.EsdSpe0014Event;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.vo.SearchEGSPManageVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.basic.ServiceProviderCategoryManageBC;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.basic.ServiceProviderCategoryManageBCImpl;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.event.EsdSpe0002Event;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchOfficeCodeAllListVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchSPCategoryManageVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchVndrSeqVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * Handling the business transaction of ALPS-MasterManage Business Logic ServiceCommand.
 * 
 * @author 
 * @see EvaluationGroupManageDBDAO
 * @since J2EE 1.6
 */

public class MasterManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Preceding the business scenario of MasterManage system
	 * Creating the related objects<br>
	 */
	public void doStart() {
		log.debug("Start of MasterManageSC");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Closing the business scenario of MasterManage system<br>
	 * Clearing the related objects<br>
	 */
	public void doEnd() {
		log.debug("End of MasterManageSC");
	}

	/**
	 * Calling the method by the event name and the form command in ALPS-MasterManage system<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsdSpe0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEGIdList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiEGManage(e);
			}else{
				eventResponse = searchEGIdAllList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdSpe0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchSPCategoryManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSPCategoryManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVndrSeq(e);
			} else {
				eventResponse = searchOfficeCodeAllList();
			} 	
		}else if (e.getEventName().equalsIgnoreCase("EsdSpe0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchEGSPManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiEGSPManage(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVndrSeq(e);
			} else {
				eventResponse = searchEGIdAllList(e);
			} 	
		}
		return eventResponse;
	}


	/**
	 * Retrieving the list of EGId.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEGIdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0001Event event = (EsdSpe0001Event)e;
		EvaluationGroupManageBC command = new EvaluationGroupManageBCImpl();

		try{
			List<SearchEGIdListVO> list = command.searchEGIdList(event.getSearchEgidConditionVO());
			eventResponse.setETCData("eg_rhq_cd",event.getSearchEgidConditionVO().getEgRhqCd());
			eventResponse.setETCData("eg_cty_cd",event.getSearchEgidConditionVO().getEgCtyCd());
			eventResponse.setETCData("svc_cate_cd",event.getSearchEgidConditionVO().getSvcCateCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Retrieving the list of all EGId
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEGIdAllList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EvaluationGroupManageBC command = new EvaluationGroupManageBCImpl();
			try{
				List<SearchEGIdAllListVO> list = command.searchEGIdAllList();
				eventResponse.setRsVoList(list);
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
		return eventResponse;
	}
	/**
	 * Managing the data of EG
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiEGManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0001Event event = (EsdSpe0001Event)e;
		EvaluationGroupManageBC command = new EvaluationGroupManageBCImpl();
		try{
			begin();
			command.multiEGManage(event.getSpeEvGrpVOS(),account);
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
	 * Retrieving the managing SP category
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSPCategoryManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0002Event event = (EsdSpe0002Event)e;
		ServiceProviderCategoryManageBC command = new ServiceProviderCategoryManageBCImpl();

		try{
			List<SearchSPCategoryManageVO> list = command.searchSPCategoryManage(event.getSearchSPCategoryManageConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Retrieving the list of all office code
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeCodeAllList() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ServiceProviderCategoryManageBC command = new ServiceProviderCategoryManageBCImpl();

		try{
			List<SearchOfficeCodeAllListVO> list = command.searchOfficeCodeAllList();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Retrieving the vendor sequence
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVndrSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ServiceProviderCategoryManageBC command = new ServiceProviderCategoryManageBCImpl();
		try {
			if(e.getEventName().equalsIgnoreCase("EsdSpe0002Event")){
				EsdSpe0002Event event = (EsdSpe0002Event)e;
				
				List<SearchVndrSeqVO> list = command.searchVndrSeq(event.getSearchVndrSeqVO());
				eventResponse.setRsVoList(list);
			}else if(e.getEventName().equalsIgnoreCase("EsdSpe0014Event")){
				EsdSpe0014Event event = (EsdSpe0014Event)e;
				
				List<SearchVndrSeqVO> list = command.searchVndrSeq(event.getSearchVndrSeqVO());
				eventResponse.setRsVoList(list);
			}
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * Managing the managing SP Category
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSPCategoryManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0002Event event = (EsdSpe0002Event)e;
		ServiceProviderCategoryManageBC command = new ServiceProviderCategoryManageBCImpl();
		try{
			begin();
			command.multiSPCategoryManage(event.getSpeSvcProvSvcCateMtchVOS(),account);
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
	 * Retrieving the managing EGSP
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEGSPManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0014Event event = (EsdSpe0014Event)e;
		EvaluationGroupServiceProviderManageBC command = new EvaluationGroupServiceProviderManageBCImpl();

		try{
			List<SearchEGSPManageVO> list = command.searchEGSPManage(event.getSearchEgidConditionVO());
			SearchEGSPManageVO rsVo = command.getEgChoicer(event.getSearchEgidConditionVO().getEgId());
			eventResponse.setETCData("eg_rhq_cd",rsVo.getEgRhqCd());
			eventResponse.setETCData("eg_cty_cd",rsVo.getEgCtyCd());
			eventResponse.setETCData("svc_cate_cd",rsVo.getSvcCateCd());
			eventResponse.setETCData("eg_id_db", event.getSearchEgidConditionVO().getEgId());
			eventResponse.setETCData("r_flg","SUCCESS");			
			eventResponse.setRsVoList(list);			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Managing the managing EGSP
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiEGSPManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0014Event event = (EsdSpe0014Event)e;
		EvaluationGroupServiceProviderManageBC command = new EvaluationGroupServiceProviderManageBCImpl();
		try{			
			begin();			
			String result=command.multiEGSPManage(event.getSpeEvGrpSvcProvMtchVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setETCData("result",result);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}