/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTClosingSC.java
*@FileTitle : Monthly Target VVD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.07 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtclosing;

import java.util.List;

import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.basic.AGTClosingBC;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.basic.AGTClosingBCImpl;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.event.EsmAgt0019Event;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.event.EsmAgt0032Event;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.event.EsmAgt0052Event;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.event.EsmAgt0053Event;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.event.EsmAgt0055Event;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration.AGTClosingDBDAO;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo.EstmPerfRptListVO;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo.SearchCSRInquiryDetailVO;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo.SearchCSRInquiryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.GlEstmRevVvdVO;


/**
 * ALPS-AGTClosing Business Logic ServiceCommand - ALPS-AGTClosing 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kyung-won Chu
 * @see AGTClosingDBDAO
 * @since J2EE 1.6
 */

public class AGTClosingSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * AGTClosing system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("AGTClosingSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * AGTClosing system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("AGTClosingSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-AGTClosing system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("Esmagt0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCommTargetVVD(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsmAgt0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAfterClosingList(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsmAgt0052Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCSRIquiry(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsmAgt0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCSRIquiryDetail(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsmAgt0055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstmPerfRptByRvvd(e);
			}
		}
		return eventResponse;
	}
	/**
	 * EsmAgt019 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommTargetVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0019Event event = (EsmAgt0019Event)e;
		AGTClosingBC command = new AGTClosingBCImpl();

		try{
			List<GlEstmRevVvdVO> list = command.searchCommTargetVVD(event.getGlEstmRevVvdVO());
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
	 * ESM_AGT_0032 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAfterClosingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0032Event event = (EsmAgt0032Event)e;
		AGTClosingBC command = new AGTClosingBCImpl();

		try{
			List<GlEstmRevVvdVO> list = command.searchAfterClosingList(event.getGlEstmRevVvdVO());
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
	 * ESM_AGT_0052 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRIquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0052Event event = (EsmAgt0052Event)e;
		AGTClosingBC command = new AGTClosingBCImpl();

		try{
			List<SearchCSRInquiryVO> list = command.searchCSRIquiry(event.getSearchCSRInquiryVO());
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
	 * ESM_AGT_0053 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRIquiryDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0053Event event = (EsmAgt0053Event)e;
		AGTClosingBC command = new AGTClosingBCImpl();

		try{
			List<SearchCSRInquiryDetailVO> list = command.searchCSRIquiryDetail(event.getSearchCSRInquiryDetailVO());
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
	 * ESM_AGT_0055 : [Retrieve]<br>
	 * [AGT commission의 추정실적]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEstmPerfRptByRvvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0055Event event = (EsmAgt0055Event)e;
		AGTClosingBC command = new AGTClosingBCImpl();

		try{
			List<EstmPerfRptListVO> list = command.searchEstmPerfRptByRvvd(event.getEstmPerfRptListVO());
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