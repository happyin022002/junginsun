/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupTargetManageSC.java
*@FileTitle : EvaluationGroupTargetManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage;

import java.util.List;

import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.basic.EvaluationGroupKpiTargetManageBC;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.basic.EvaluationGroupKpiTargetManageBCImpl;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.event.EsdSpe0008Event;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.vo.SearchEGKpiTargetManageVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.basic.EvaluationGroupStrategicImportanceManageBC;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.basic.EvaluationGroupStrategicImportanceManageBCImpl;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.event.EsdSpe0003Event;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.vo.SearchEvaluationGroupStrategicImportanceManageListVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.basic.EvaluationGroupTerminalKpiManageBC;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.basic.EvaluationGroupTerminalKpiManageBCImpl;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.event.EsdSpe0009Event;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.integration.EvaluationGroupTerminalKpiManageDBDAO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.vo.SearchEGTerminalKpiManageVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.vo.SearchVndrSeqVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.basic.EvaluationGroupManageBC;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.basic.EvaluationGroupManageBCImpl;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.basic.EvaluationGroupServiceProviderManageBC;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.basic.EvaluationGroupServiceProviderManageBCImpl;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.vo.SearchEGSPManageVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

 
/**
 * Handling the business transaction of ALPS-EvaluationGroupTargetManage Business Logic ServiceCommand - ALPS-EvaluationGroupTargetManage
 * 
 * @author
 * @see EvaluationGroupTerminalKpiManageDBDAO
 * @since J2EE 1.6
 */

public class EvaluationGroupTargetManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Preceding the business scenario of EvaluationGroupTargetManage system<br>
	 * Creating the related objects<br>
	 */
	public void doStart() {
		log.debug("Start of EvaluationGroupTargetManageSC");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Closing the business scenario of EvaluationGroupTargetManage system<br>
	 * Clearing the related objects<br>
	 */
	public void doEnd() {
		log.debug("End of EvaluationGroupTargetManageSC");
	}

	/**
	 * Calling the method by the event name and the form command in ALPS-EvaluationGroupTargetManage system<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsdSpe0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEGTerminalKpiManage(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpeEvGrpTmlKpiTgtRto(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVndrSeq(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdSpe0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEvaluationGroupStrategicImportanceManageList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpeEvGrpStrgImptRslt(e);
			}else{
				eventResponse = searchEGIdAllList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdSpe0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEGKpiTargetManage(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiEGKpiTargetManage(e);
			}else{
				eventResponse = searchEGIdAllList(e);
			}
		}
		return eventResponse;
	}
	/**
	 * Retrieving the data of EGTerminalKpiManage<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEGTerminalKpiManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0009Event event = (EsdSpe0009Event)e;
		EvaluationGroupTerminalKpiManageBC command = new EvaluationGroupTerminalKpiManageBCImpl();
 
		try{
			List< SearchEGTerminalKpiManageVO > list = command.searchEGTerminalKpiManage(event.getSearchEGTerminalKpiManageVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse; 
	}
	/**
	 * Managing the data of SpeEvGrpTmlKpiTgtRto.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpeEvGrpTmlKpiTgtRto(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0009Event event = (EsdSpe0009Event)e;
		EvaluationGroupTerminalKpiManageBC command = new EvaluationGroupTerminalKpiManageBCImpl();
		try{
			begin();
			command.multiSpeEvGrpTmlKpiTgtRto(event.getSpeEvGrpTmlKpiTgtRtoVOs(),account);
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
	 * Retrieving the vendor sequence.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVndrSeq(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0009Event event = (EsdSpe0009Event)e;
		EvaluationGroupTerminalKpiManageBC command = new EvaluationGroupTerminalKpiManageBCImpl();
 
		try{
			List< SearchVndrSeqVO > list = command.searchVndrSeq(event.getSearchVndrSeqVO());
			eventResponse.setRsVoList(list);			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse; 
	}
	
	
	/**
	 * Retrieving the list of Evaluation Group Strategic Importance Manage
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEvaluationGroupStrategicImportanceManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0003Event event = (EsdSpe0003Event)e;
		EvaluationGroupStrategicImportanceManageBC command = new EvaluationGroupStrategicImportanceManageBCImpl();
 
		try{
			List< SearchEvaluationGroupStrategicImportanceManageListVO > list = command.searchEvaluationGroupStrategicImportanceManageList(event.getSearchInputListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse; 
	}
	
	/**
	 * Managing SpeEvGrpStrgImptRslt(inserting, updating, deleting)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpeEvGrpStrgImptRslt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0003Event event = (EsdSpe0003Event)e;
		EvaluationGroupStrategicImportanceManageBC command = new EvaluationGroupStrategicImportanceManageBCImpl();
		try{
			begin();
			command.multiSpeEvGrpStrgImptRslt(event.getSpeEvGrpStrgImptRsltVOs(), account);
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
	 * Retrieving the list of all EGId<br>
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
	 * Retrieving the managing EGKpiTarge<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEGKpiTargetManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0008Event event = (EsdSpe0008Event)e;

		EvaluationGroupKpiTargetManageBC command = new EvaluationGroupKpiTargetManageBCImpl();
		EvaluationGroupServiceProviderManageBC command2 = new EvaluationGroupServiceProviderManageBCImpl();
		try{
			List< SearchEGKpiTargetManageVO > list = command.searchEGKpiTargetManage(event.getSearchEGKpiTargetConditionVO());
			SearchEGSPManageVO rsVo = command2.getEgChoicer(event.getSearchEGKpiTargetConditionVO().getEgId());
			eventResponse.setETCData("eg_rhq_cd",rsVo.getEgRhqCd());
			eventResponse.setETCData("eg_cty_cd",rsVo.getEgCtyCd());
			eventResponse.setETCData("svc_cate_cd",rsVo.getSvcCateCd());
			eventResponse.setETCData("eg_id_db", event.getSearchEGKpiTargetConditionVO().getEgId());	
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse; 
	}
	
	/**
	 * Managing the data of EGKpiTarget<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiEGKpiTargetManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0008Event event = (EsdSpe0008Event)e;
		EvaluationGroupKpiTargetManageBC command = new EvaluationGroupKpiTargetManageBCImpl();
		try{
			begin();
			command.multiEGKpiTargetManage(event.getSpeEvGrpKpiTgtRtoVOS(), account);
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
}