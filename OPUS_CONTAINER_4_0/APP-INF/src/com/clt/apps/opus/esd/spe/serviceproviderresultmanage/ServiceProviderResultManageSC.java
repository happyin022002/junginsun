/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceProviderResultManageSC.java
*@FileTitle : RA Analysis Result
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.serviceproviderresultmanage;

import java.util.List;

import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.basic.EvaluationGroupManageBC;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.basic.EvaluationGroupManageBCImpl;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.basic.ServiceProviderRelationshipAttractivenessResultBC;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.basic.ServiceProviderRelationshipAttractivenessResultBCImpl;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.event.EsdSpe0004Event;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.integration.ServiceProviderRelationshipAttractivenessResultDBDAO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo.SearchServiceProviderRelationshipAttractivenessResultListVO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipsegmentationresult.basic.ServiceProviderRelationshipSegmentationResultBC;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipsegmentationresult.basic.ServiceProviderRelationshipSegmentationResultBCImpl;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipsegmentationresult.event.EsdSpe0005Event;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipsegmentationresult.vo.SearchServiceProviderRelationshipSegmentationResultListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * Handling the business transaction of ALPS-ServiceProviderResultManage Business Logic ServiceCommand - ALPS-ServiceProviderResultManage
 * 
 * @author 
 * @see ServiceProviderRelationshipAttractivenessResultDBDAO
 * @since J2EE 1.6
 */

public class ServiceProviderResultManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Preceding the business scenario of ServiceProviderResultManage system<br>
	 * Creating the related objects.<br>
	 */
	public void doStart() {
		log.debug("Start of ServiceProviderResultManageSC");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Closing the business scenario of ServiceProviderResultManage system<br>
	 * Clearing the related objects.<br>
	 */
	public void doEnd() {
		log.debug("End of ServiceProviderResultManageSC");
	}

	/**
	 * Calling the method by the event name and the form command in ALPS-ServiceProviderResultManage system
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsdSpe0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchServiceProviderRelationshipAttractivenessResultList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpeRltAtrcRslt(e);
			}else{
				eventResponse = searchEGIdAllList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdSpe0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchServiceProviderRelationshipSegmentationResultList(e);
			}else{
				eventResponse = searchEGIdAllList(e);
			}
		}
		return eventResponse;
	}
	/**
	 * Retrieving the list of service provider relationship attractiveness activeness result.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceProviderRelationshipAttractivenessResultList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0004Event event = (EsdSpe0004Event)e;
		ServiceProviderRelationshipAttractivenessResultBC command = new ServiceProviderRelationshipAttractivenessResultBCImpl();

		try{
			List<SearchServiceProviderRelationshipAttractivenessResultListVO> list = command.searchServiceProviderRelationshipAttractivenessResultList(event.getSearchInputListVO());
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
	/**
	 * Manage the data of SpeRltAtrcRslt.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpeRltAtrcRslt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0004Event event = (EsdSpe0004Event)e;
		ServiceProviderRelationshipAttractivenessResultBC command = new ServiceProviderRelationshipAttractivenessResultBCImpl();
		try{
			begin();
			command.multiSpeRltAtrcRslt(event.getSpeRltAtrcRsltAddVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Retrieving the list of all EGId.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEGIdAllList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
			try{
				EvaluationGroupManageBC command = new EvaluationGroupManageBCImpl();
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
	 * Retrieving the list of service provider relationship segmentation result
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceProviderRelationshipSegmentationResultList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe0005Event event = (EsdSpe0005Event)e;
		ServiceProviderRelationshipSegmentationResultBC command = new ServiceProviderRelationshipSegmentationResultBCImpl();

		try{
			List<SearchServiceProviderRelationshipSegmentationResultListVO> list = command.searchServiceProviderRelationshipSegmentationResultList(event.getSearchInputListVO());
			
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