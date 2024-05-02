/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusInquirySC.java
*@FileTitle : StatusInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
* 2010.11.17 손은주 [CHM-201006809-01]	[TPB] TPB Activity기간별 TPB 조회 기능
* 2010-11-18  손은주 [CHM-201006809-01][TPB] TPB Activity기간별 TPB 조회 기능 - office 관련 select box 수정
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.basic.PerformanceInquiryBC;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.basic.PerformanceInquiryBCImpl;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.event.EsdTpb0119Event;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.event.EsdTpb0120Event;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.event.EsdTpb0121Event;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.vo.SearchClosingTPBListVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.vo.SearchEACIssuanceListVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.vo.SearchNonTPBListVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.basic.StatusInquiryBC;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.basic.StatusInquiryBCImpl;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0115Event;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0116Event;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0134Event;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0117Event;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0118Event;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0135Event;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0136Event;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0141Event;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0808Event;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration.StatusInquiryDBDAO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.EmailFaxSentHistVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchActivityByClosingTPBVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchActivityByConfirmedTPBVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchInformationOnPendingTPBVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchStatusByTPBVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchStatusByTPBBKGVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBDetailInfoVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBDetailListVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusSummaryVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBInvoiceListVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-StatusInquiry Business Logic ServiceCommand - ALPS-StatusInquiry 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author GUN-HA HWANG
 * @see StatusInquiryDBDAO
 * @since J2EE 1.6
 */

public class StatusInquirySC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * StatusInquiry system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("StatusInquirySC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * StatusInquiry system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("StatusInquirySC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-StatusInquiry system 업무에서 발생하는 모든 이벤트의 분기처리<br>
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
		}else if (e.getEventName().equalsIgnoreCase("EsdTpb0141Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEmailFaxSentHistoryList(e);
			}
		}
		return eventResponse;
	}
	/**
	 * EsdTpb0115 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
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
	 * EsdTpb0115 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
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
	 * EsdTpb0116 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
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
	 * EsdTpb0116 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
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
	 * EsdTpb0117 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
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
	 * EsdTpb0118 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
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
	 * EsdTpb0808 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInformationOnPendingTPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0808Event event = (EsdTpb0808Event)e;
		StatusInquiryBC command = new StatusInquiryBCImpl();
		
		try{
			List<SearchInformationOnPendingTPBVO> list = command.searchInformationOnPendingTPB(event.getSearchInformationOnPendingTPBVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0119 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
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
	 * EsdTpb0120 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
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
	 * EsdTpb0121 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
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
	 * EsdTpb0135 : [조회]<br>
	 * 해당점소의 조회기간내에 Confirm된 TPB를 조회합니다.<br>
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
	 * EsdTpb0136 : [조회]<br>
	 * 해당점소의 조회기간내에 Close된 TPB를 조회합니다.<br>
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
	 * EsdTpb0135 : [조회]<br>
	 * 해당점소의 Control Office를 조회합니다.<br>
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
	 * EsdTpb0135 : [조회]<br>
	 * RHQ Office 목록을 조회합니다.<br>
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
	 * EsdTpb0135 : [조회]<br>
	 * Control Office 목록을 조회합니다.<br>
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
	 * EsdTpb0135 : [조회]<br>
	 * TPB Office 목록을 조회합니다.<br>
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
	
	/**
	 * EsdTpb0135 : [조회]<br>
	 * TPB Office 목록을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEmailFaxSentHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0141Event event = (EsdTpb0141Event)e;
		StatusInquiryBC command = new StatusInquiryBCImpl();
		
		try{
			List<EmailFaxSentHistVO> list =  command.searchEmailFaxSentHistoryList(event.getEmailFaxSentHistVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
}