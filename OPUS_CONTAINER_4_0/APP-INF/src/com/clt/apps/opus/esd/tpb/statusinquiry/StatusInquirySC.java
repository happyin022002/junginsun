/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusInquirySC.java
*@FileTitle : StatusInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry;

import java.util.List;

import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.basic.PerformanceInquiryBC;
import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.basic.PerformanceInquiryBCImpl;
import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.event.EsdTpb0119Event;
import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.event.EsdTpb0120Event;
import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.event.EsdTpb0121Event;
import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.vo.SearchClosingTPBListVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.vo.SearchEACIssuanceListVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.vo.SearchNonTPBListVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.basic.StatusInquiryBC;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.basic.StatusInquiryBCImpl;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0115Event;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0116Event;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0117Event;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0118Event;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0134Event;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0135Event;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0136Event;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0137Event;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0808Event;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.integration.StatusInquiryDBDAO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchActivityByClosingTPBVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchActivityByConfirmedTPBVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchInformationOnPendingTPBVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchStatusByTPBBKGVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchStatusByTPBVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBDetailInfoVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBDetailListVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBInvoiceListVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusSummaryVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * -StatusInquiry Business Logic ServiceCommand - -StatusInquiry business transaction processing
 * 
 * @author 
 * @see StatusInquiryDBDAO
 * @since J2EE 1.6
 */

public class StatusInquirySC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * StatusInquiry system business scenario<br>
	 * calling business scenario<br>
	 */
	public void doStart() {
		log.debug("StatusInquirySC 시작");
		try {
			//checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * StatusInquiry system business scenario deadline<br>
	 * business scenario deadline<br>
	 */
	public void doEnd() {
		log.debug("StatusInquirySC 종료");
	}

	/**
	 * business scenario processing<br>
	 * -branch processing all event by StatusInquiry system business<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("EsdTpb0115Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBDetailInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTPBDetailList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0116Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStatusByTPB(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0134Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStatusByTPBBKG(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0117Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBStatusSummary(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0118Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0808Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInformationOnPendingTPB(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0119Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchClosingTPBList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0120Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNonTPBList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0121Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEACIssuanceList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTpb0135Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchActivityByConfirmedTPB(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchControlOffice(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchHandleRHQList(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchControlOfficeList(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchTPBOfficeList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTpb0136Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchActivityByClosingTPB(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTpb0137Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInformationOnPendingTPB(e);
			}
		}
		return eventResponse;
	}
	/**
	 * EsdTpb0115<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBDetailInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0115Event event = (EsdTpb0115Event)e;
		StatusInquiryBC command = new StatusInquiryBCImpl();
		
		try{
			List<SearchTPBDetailInfoVO> list = command.searchTPBDetailInfo(event.getSearchTPBDetailInfoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0115<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0115Event event = (EsdTpb0115Event)e;
		StatusInquiryBC command = new StatusInquiryBCImpl();
		
		try{
			List<SearchTPBDetailListVO> list = command.searchTPBDetailList(event.getSearchTPBDetailListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0116<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStatusByTPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0116Event event = (EsdTpb0116Event)e;
		StatusInquiryBC command = new StatusInquiryBCImpl();
		
		try{
			List<SearchStatusByTPBVO> list = command.searchStatusByTPB(event.getSearchStatusByTPBVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0116<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStatusByTPBBKG(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0134Event event = (EsdTpb0134Event)e;
		StatusInquiryBC command = new StatusInquiryBCImpl();
		
		try{
			List<SearchStatusByTPBBKGVO> list = command.searchStatusByTPBBKG(event.getSearchStatusByTPBBKGVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0117<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBStatusSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0117Event event = (EsdTpb0117Event)e;
		StatusInquiryBC command = new StatusInquiryBCImpl();

		try{
			List<SearchTPBStatusSummaryVO> list = command.searchTPBStatusSummary(event.getSearchTPBStatusSummaryVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0118<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0118Event event = (EsdTpb0118Event)e;
		StatusInquiryBC command = new StatusInquiryBCImpl();
		
		try{
			List<SearchTPBInvoiceListVO> list = command.searchInvoiceList(event.getSearchTpbInvoiceListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0808<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInformationOnPendingTPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StatusInquiryBC command = new StatusInquiryBCImpl();
		
		try{
			SearchInformationOnPendingTPBVO searchInformationOnPendingTPBVO = null;
			
			if(e instanceof EsdTpb0808Event) {
				searchInformationOnPendingTPBVO = ((EsdTpb0808Event)e).getSearchInformationOnPendingTPBVO();
			} else if(e instanceof EsdTpb0137Event) {
				searchInformationOnPendingTPBVO = ((EsdTpb0137Event)e).getSearchInformationOnPendingTPBVO();
			}
			
			List<SearchInformationOnPendingTPBVO> list = command.searchInformationOnPendingTPB(searchInformationOnPendingTPBVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0119<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchClosingTPBList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0119Event event = (EsdTpb0119Event)e;
		PerformanceInquiryBC command = new PerformanceInquiryBCImpl();
		
		try{
			List<SearchClosingTPBListVO> list = command.searchClosingTPBList(event.getSearchClosingTPBListVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0120<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNonTPBList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0120Event event = (EsdTpb0120Event)e;
		PerformanceInquiryBC command = new PerformanceInquiryBCImpl();
		
		try{
			List<SearchNonTPBListVO> list = command.searchNonTPBList(event.getSearchNonTPBListVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0121<br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEACIssuanceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0121Event event = (EsdTpb0121Event)e;
		PerformanceInquiryBC command = new PerformanceInquiryBCImpl();
		
		try{
			List<SearchEACIssuanceListVO> list = command.searchEACIssuanceList(event.getSearchEACIssuanceListVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EsdTpb0135 : [retrieve]<br>
	 * retrieving Confirmed TPB<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActivityByConfirmedTPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0135Event event = (EsdTpb0135Event)e;
		StatusInquiryBC command = new StatusInquiryBCImpl();
		
		try{
			List<SearchActivityByConfirmedTPBVO> list = command.searchActivityByConfirmedTPB(event.getSearchActivityByConfirmedTPBVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EsdTpb0136 : [retrieve]<br>
	 * retrieving Closed TPB<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActivityByClosingTPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0136Event event = (EsdTpb0136Event)e;
		StatusInquiryBC command = new StatusInquiryBCImpl();
		
		try{
			List<SearchActivityByClosingTPBVO> list = command.searchActivityByClosingTPB(event.getSearchActivityByClosingTPBVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EsdTpb0135 : [retrieve]<br>
	 * retrieving Control Office<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchControlOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0135Event event = (EsdTpb0135Event)e;
		StatusInquiryBC command = new StatusInquiryBCImpl();
		
		try{
			eventResponse = (GeneralEventResponse) command.searchControlOffice(event);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0135 : [retrieve]<br>
	 * retrieving RHQ Office list<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHandleRHQList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0135Event event = (EsdTpb0135Event)e;
		StatusInquiryBC command = new StatusInquiryBCImpl();
		
		try{
			eventResponse = (GeneralEventResponse) command.searchHandleRHQList(event);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0135 : [retrieve]<br>
	 * retrieving Control Office list<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchControlOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0135Event event = (EsdTpb0135Event)e;
		StatusInquiryBC command = new StatusInquiryBCImpl();
		
		try{
			eventResponse = (GeneralEventResponse) command.searchControlOfficeList(event);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0135 : [retrieve]<br>
	 * retrieving TPB Office list<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0135Event event = (EsdTpb0135Event)e;
		StatusInquiryBC command = new StatusInquiryBCImpl();
		
		try{
			eventResponse = (GeneralEventResponse) command.searchTPBOfficeList(event);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
}