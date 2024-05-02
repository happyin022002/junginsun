/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonSC.java
*@FileTitle : ESD_SPE_COM
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common;

import java.util.List;

import com.hanjin.apps.alps.esd.spe.common.popup.basic.PopupBC;
import com.hanjin.apps.alps.esd.spe.common.popup.basic.PopupBCImpl;
import com.hanjin.apps.alps.esd.spe.common.popup.event.EsdSpe1022Event;
import com.hanjin.apps.alps.esd.spe.common.popup.event.EsdSpe1023Event;
import com.hanjin.apps.alps.esd.spe.common.popup.vo.SpePopupVO;
import com.hanjin.apps.alps.esd.spe.common.util.basic.UtilBC;
import com.hanjin.apps.alps.esd.spe.common.util.basic.UtilBCImpl;
import com.hanjin.apps.alps.esd.spe.common.util.event.EsdSpeComEvent;
import com.hanjin.apps.alps.esd.spe.common.util.integration.UtilDBDAO;
import com.hanjin.apps.alps.esd.spe.common.util.vo.UtillVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Common Business Logic ServiceCommand - ALPS-Common 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author HI
 * @see UtilDBDAO
 * @since J2EE 1.6
 */

public class CommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Common system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("CommonSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Common system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-Common system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdSpeComEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) { // rhq 조회
				eventResponse = searchRhqOfc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) { // 지역 office 조회
				eventResponse = searchOfc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // 공통코드 조회 코드와 명을 붙여서 조회한다.
				eventResponse = searchComCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // 공통코드 값을 조회한다 구분자를 텝 으로 코드와 명을 붙여온다.
				eventResponse = searchComCode2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // 공통코드 조회
				eventResponse = searchComCode3(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) { // 사용자가 입력한 Control Office 코드가 존재하는 값인지 조회한다.
				eventResponse = searchOfcChk(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) { // vender 조회
				eventResponse = searchVender(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) { // USER_ID 조회
				eventResponse = searchUser(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) { // Terminal 조회
				eventResponse = searchTerminal(e);
			}
						
		}else if (e.getEventName().equalsIgnoreCase("EsdSpe1022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // rhq 조회
				eventResponse = searchSPList(e);
			}
						
    	}else if (e.getEventName().equalsIgnoreCase("EsdSpe1023Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //  조직트리 조회
		    	eventResponse = searchDeptList(e);
		}
		
	}
		return eventResponse;
	}

	
	
	/**
	 * RHQ Office 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRhqOfc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpeComEvent event = (EsdSpeComEvent)e;
		UtilBC command = new UtilBCImpl();

		try{
			List<UtillVO> list = command.searchRhqOfc(event.getUtillVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}


	/**
	 * 지역 Office 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpeComEvent event = (EsdSpeComEvent)e;
		UtilBC command = new UtilBCImpl();
		
		try{
			List<UtillVO> list = command.searchOfc(event.getUtillVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchOfc"}).getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * 공통코드 값을 조회한다 코드와 명을 붙여서 조회한다..<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpeComEvent event = (EsdSpeComEvent)e;
		UtilBC command = new UtilBCImpl();
		
		try{
			List<UtillVO> list = command.searchComCode(event.getUtillVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchComCode"}).getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * 공통코드 값을 조회한다 구분자를 텝 으로 코드와 명을 붙여온다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpeComEvent event = (EsdSpeComEvent)e;
		UtilBC command = new UtilBCImpl();
		
		try{
			List<UtillVO> list = command.searchComCode2(event.getUtillVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchComCode"}).getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * 공통코드 값을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode3(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpeComEvent event = (EsdSpeComEvent)e;
		UtilBC command = new UtilBCImpl();
		
		try{
			List<UtillVO> list = command.searchComCode3(event.getUtillVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchComCode"}).getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 * 공통코드 값을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcChk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpeComEvent event = (EsdSpeComEvent)e;
		UtilBC command = new UtilBCImpl();
		
		try{
			List<UtillVO> list = command.searchOfcChk(event.getUtillVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchComCode"}).getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * 사용자가 입력한 Vender 코드로 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVender(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpeComEvent event = (EsdSpeComEvent)e;
		UtilBC command = new UtilBCImpl();
		
		try{
			List<UtillVO> list = command.searchVender(event.getUtillVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}		
	
	/**
	 * 사용자가 입력한 USER 코드로 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUser(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpeComEvent event = (EsdSpeComEvent)e;
		UtilBC command = new UtilBCImpl();
		
		try{
			List<UtillVO> list = command.searchUser(event.getUtillVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}	
	/**
	 * 사용자가 입력한 Terminal 코드로 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpeComEvent event = (EsdSpeComEvent)e;
		UtilBC command = new UtilBCImpl();
		
		try{
			List<UtillVO> list = command.searchTerminal(event.getUtillVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * 사용자가 입력한 USER 코드로 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSPList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1022Event event = (EsdSpe1022Event)e;
		PopupBC command = new PopupBCImpl();
		
		try{
			List<SpePopupVO> list = command.searchSPList(event.getSpePopupVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * 조직트리 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeptList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1023Event event = (EsdSpe1023Event)e;
		PopupBC command = new PopupBCImpl();
		
		try{
			eventResponse.setRsVoList(command.searchDeptList(event.getSpePopupVO()));
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEGCre"}).getMessage(), ex);
		}	
		return eventResponse;
	}	
}