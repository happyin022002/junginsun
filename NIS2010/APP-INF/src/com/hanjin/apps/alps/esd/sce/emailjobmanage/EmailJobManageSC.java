/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmailJobManageSC.java
*@FileTitle : VSL SKD e-mailing Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.06
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.06 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.emailjobmanage;

import com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBC;
import com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBCImpl;
import com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.event.EsdSce0119Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-EmailJobManage Business Logic ServiceCommand - ALPS-EmailJobManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Park Jun Yong
 * @see VskEmailSetupDBDAO
 * @since J2EE 1.6
 */

public class EmailJobManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * EmailJobManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("EmailJobManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * EmailJobManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("EmailJobManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-EmailJobManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdSce0119Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVslSkdEmlSetUp();
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = addVslSkdEmlSetUp(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeVslSkdEmlSetUp(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLaneVerify(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPortVerify(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * VSL E-MAIL 대상 조회<br>
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVslSkdEmlSetUp() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
			VskEmailSetupBC command = new VskEmailSetupBCImpl();
			eventResponse = command.searchVslSkdEmlSetUp();
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;		
	}
	
	
	/**
	 * VSL E-MAIL 대상 추가 및 변경<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse addVslSkdEmlSetUp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0119Event event = (EsdSce0119Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			VskEmailSetupBC command = new VskEmailSetupBCImpl();
			command.addVslSkdEmlSetUp(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * VSL E-MAIL 대상 삭제<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeVslSkdEmlSetUp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0119Event event = (EsdSce0119Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			VskEmailSetupBC command = new VskEmailSetupBCImpl();
			command.removeVslSkdEmlSetUp(event); 
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Lane 대상 Verify 조회<br>
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneVerify(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0119Event event = (EsdSce0119Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
			VskEmailSetupBC command = new VskEmailSetupBCImpl();
			eventResponse = command.searchLaneVerify(event);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;		
	}
	
	/**
	 * Port 대상 Verify 조회<br>
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPortVerify(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0119Event event = (EsdSce0119Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			VskEmailSetupBC command = new VskEmailSetupBCImpl();
			eventResponse = command.searchPortVerify(event);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;		
	}
}