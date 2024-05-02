/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TpbMasterDataManageSC.java
*@FileTitle : CodeManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage;

import java.util.List;

import com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.basic.CodeManageBC;
import com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.basic.CodeManageBCImpl;
import com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.event.EsdTpb0101Event;
import com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.event.EsdTpb0131Event;
import com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeInquiryListVO;
import com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeListVO;
import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.basic.OfficeManageBC;
import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.basic.OfficeManageBCImpl;
import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.event.EsdTpb0102Event;
import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.event.EsdTpb0132Event;
import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.integration.OfficeManageDBDAO;
import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListForInquiryVO;
import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * -TpbMasterDataManage Business Logic ServiceCommand - -TpbMasterDataManage business transaction processing
 * 
 * @author 
 * @see OfficeManageDBDAO
 * @since J2EE 1.6
 */

public class MasterDataManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * TpbMasterDataManage system business scenario<br>
	 * calling ESD_TBP_102 business scenario<br>
	 */
	public void doStart() {
		log.debug("TpbMasterDataManageSC 시작");
		try {
			//checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * TpbMasterDataManage system business scenario deadline<br>
	 * ESD_TBP_102 business scenario deadline<br>
	 */
	public void doEnd() {
		log.debug("TpbMasterDataManageSC 종료");
	}

	/**
	 * business scenario processing<br>
	 * -branch processing all event by MasterDataManage system business<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC event
		if (e.getEventName().equalsIgnoreCase("EsdTpb0101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCodeManage(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiOfficeManage(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0131Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCodeInquiryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0132Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeListForInquiry(e);
			}
		}
		
		return eventResponse;
	}
	/**
	 * retrieve event<br>
	 * TpbOfficeManage event list retrieve<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0101Event event = (EsdTpb0101Event)e;
		CodeManageBC command = new CodeManageBCImpl();
		try{
			List<SearchCodeListVO> list = command.searchCodeList(event.getSearchCodeListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * multi event<br>
	 * CodeManage event multi event processing<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCodeManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0101Event event = (EsdTpb0101Event)e;
		CodeManageBC command = new CodeManageBCImpl();
		try{
			begin();
			log.debug("event.getSearchCodeListVOS()==>"+event.getSearchCodeListVOS());
			command.searchCodeList(event.getSearchCodeListVOS(),account);
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
	 * multi event<br>
	 * CodeManage의 event multi event processing<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiOfficeManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0102Event event = (EsdTpb0102Event)e;
		OfficeManageBC command = new OfficeManageBCImpl();
		try{
			begin();
			log.debug("event.getSearchOfficeListVOS()==>"+event.getSearchOfficeListVOS());
			command.searchOfficeList(event.getSearchOfficeListVOS(),account);
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
	 * retrieve event processing<br>
	 * TpbOfficeManage event list retrieve event processing<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0102Event event = (EsdTpb0102Event)e;
		OfficeManageBC command = new OfficeManageBCImpl();
		
		try{
			List<SearchOfficeListVO> list = command.searchOfficeList(event.getSearchOfficeListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * retrieve event processing<br>
	 * TpbCodeManage event list retrieve event processing<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0131Event event = (EsdTpb0131Event)e;
		CodeManageBC command = new CodeManageBCImpl();

		try{
			List<SearchCodeInquiryListVO> list = command.searchCodeInquiryList(event.getSearchCodeInquiryListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * retireve event processing<br>
	 * TpbCodeManage event list retrieve event processing<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeListForInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0132Event event = (EsdTpb0132Event)e;
		OfficeManageBC command = new OfficeManageBCImpl();
		
		try{
			List<SearchOfficeListForInquiryVO> list = command.searchOfficeListForInquiry(event.getSearchOfficeListForInqiuryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
}