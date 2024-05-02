/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DodTariffSC.java
*@FileTitle : DOD Tariff
*Open Issues :
*Change history :
*@LastmanageDate : 2015.10.28
*@LastModifier : YOON, Yong-Sang
*@LastVersion : 1.0
* 2009.07.17 YOON, Yong-Sang
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodtariff;

import java.util.List;
import java.util.Map;
import com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.basic.DropOffTariffBC;
import com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.basic.DropOffTariffBCImpl;
import com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.event.EesDod0005Event;
import com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.event.EesDod0007Event;
import com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.vo.SearchDodTariffListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-DodTariff Business Logic ServiceCommand - ALPS-DodTariff 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author YOON, Yong-Sang
 * @see DodTariffDBDAO
 * @since J2EE 1.6
 */

public class DodTariffSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DodTariff system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("DodTariffSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DodTariff system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DodTariffSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-DodTariff system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("EesDod0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchDodTariffList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = expireDodTariffList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = expireDodTariffList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageDodTariffList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageDodTariffList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDodDuplTariffList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDodDuplTariffList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDodTariffConti(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDodTariffSpecialCustomer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesDod0007Event")) {  
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDodTariffList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageConfirmDodTariffList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = manageConfirmDodTariffList(e);
			}
		} 
		return eventResponse;
	}
	
	/**
	 * EesDod0005 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse expireDodTariffList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DropOffTariffBC command = new DropOffTariffBCImpl();
		try{			
			EesDod0005Event event = (EesDod0005Event)e;
			List<SearchDodTariffListVO> list = command.expireDodTariffData(event.getSearchDodTariffListVOS(), account);
			list = command.searchDodTariffList(event.getSearchDodTariffListVO());
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EesDod0005 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDodTariffList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DropOffTariffBC command = new DropOffTariffBCImpl();
		try{			
			EesDod0005Event event = (EesDod0005Event)e;
			List<SearchDodTariffListVO> list = command.manageDodTariffList(event.getSearchDodTariffListVOS(), account);
			if(!list.isEmpty() && "X".equals(list.get(0).getIbflag())){ // 중복 데이터 존재시								
				eventResponse.setUserMessage("Duplication occurred.");				
			} else {				
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
				list = command.searchDodTariffList(event.getSearchDodTariffListVO());				
			}
			eventResponse.setRsVoList(list);			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EesDod0005 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDodDuplTariffList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DropOffTariffBC command = new DropOffTariffBCImpl();
		
		try{
			EesDod0005Event event = (EesDod0005Event)e;
			List<SearchDodTariffListVO> list = command.searchDodDuplTariffList(event.getSearchDodTariffListVOS());
			if(list.isEmpty()){
				eventResponse.setETCData("DUP_SEQ", null);
			} else {
				eventResponse.setETCData("DUP_SEQ", list.get(0).getDrpOffChgTrfSeq());
			}
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	//
	/**
	 * EesDod0005 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDodTariffConti(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DropOffTariffBC command = new DropOffTariffBCImpl();
		
		try{
			EesDod0005Event event = (EesDod0005Event)e;
			List<SearchDodTariffListVO> list = command.searchDodTariffConti(event.getSearchDodTariffListVO());
			if(!list.isEmpty()){
				eventResponse.setETCData("conti", list.get(0).getPolContiCd());
			}	
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EesDod0005 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDodTariffSpecialCustomer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DropOffTariffBC command = new DropOffTariffBCImpl();
		
		try{
			EesDod0005Event event = (EesDod0005Event)e;
			Map<String, String> map = command.searchDodTariffSpecialCustomer(event.getSearchDodTariffListVO().getRfaNo(), event.getSearchDodTariffListVO().getScNo());
			
			if(!map.isEmpty()){
				eventResponse.setETCData("code", map.get("CODE"));
				eventResponse.setETCData("name", map.get("NAME"));
				eventResponse.setETCData("cust_nm", map.get("CUST_NM"));
			}	
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	
	/**
	 * EesDod0005 : [이벤트]<br>
	 * EesDod0007 : SEARCH <br> 
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDodTariffList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		
		DropOffTariffBC command = new DropOffTariffBCImpl();
		
		try{
			if(e.getEventName().equalsIgnoreCase("EesDod0005Event")){
				EesDod0005Event event = (EesDod0005Event)e;
			List<SearchDodTariffListVO> list = command.searchDodTariffList(event.getSearchDodTariffListVO());
			eventResponse.setRsVoList(list);
			}else if (e.getEventName().equalsIgnoreCase("EesDod0007Event")) {
				EesDod0007Event event = (EesDod0007Event)e;
				List<SearchDodTariffListVO> list = command.searchDodTariffList(event.getSearchDodTariffListVO(),event.getsTrfDivCd());
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 
	 * EesDod0007 : MULTI<br>
	 * 선택한 Drop off Tariff 를 confirm 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
		private EventResponse manageConfirmDodTariffList(Event e) throws EventException{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			DropOffTariffBC command = new DropOffTariffBCImpl();
			try{
				if(e.getEventName().equalsIgnoreCase("EesDod0007Event")){
					EesDod0007Event event = (EesDod0007Event) e;
					command.manageConfirmDodTariffList(event.getSearchDodTariffListVOs(), account.getUsr_id());
					eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
				}
			
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}		
			return eventResponse;
		}
}

