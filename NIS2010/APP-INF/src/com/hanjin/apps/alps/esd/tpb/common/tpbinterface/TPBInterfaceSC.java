/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBInterfaceSC.java
*@FileTitle : 3자구상 Interface Test 화면 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-20
*@LastModifier : O Wan-Ki
*@LastVersion : 1.0
* 2009-08-20 O Wan-Ki 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.tpbinterface;

import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.basic.TPBInterfaceBC;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.event.TPBInterfaceEvent;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.integration.TPBInterfaceDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ESD Business Logic ServiceCommand - ALPS-CandidateManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sung-Jin Park
 * @see TPBInterfaceDBDAO
 * @since J2EE 1.6
 */ 

public class TPBInterfaceSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * TPBInterfaceSC system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("TPBInterfaceSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * TPBInterfaceSC system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("TPBInterfaceSC 종료");
	}


	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-CandidateManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		TPBInterfaceEvent event = (TPBInterfaceEvent)e;
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("TPBInterfaceEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				log.debug(" event.getBiz_mode_flag() : " + event.getBiz_mode_flag());
				if ( event.getBiz_mode_flag().equals("TESTPB")){
					eventResponse = createTESTPB(e);
				}else if ( event.getBiz_mode_flag().equals("TRSTPB")){
					eventResponse = createTRSTPB(e);
				}else if ( event.getBiz_mode_flag().equals("MNRTPB")){
					eventResponse = createMNRTPB(e);
				}else if ( event.getBiz_mode_flag().equals("TESTPBFLAG")){
					eventResponse = searchTpbTesDltFlg(e);
				}
			}
		} 
		return eventResponse;
	}
	
	/**
	 * TPBInterfaceEvent : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createTESTPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TPBInterfaceEvent event = (TPBInterfaceEvent)e;
		TPBInterfaceBC command = new TPBInterfaceBCImpl();

		try{
			begin();
			boolean isSuccessful = command.createTESTPB(event.getTpbInterfaceVOs());
			event.setSuccessful(isSuccessful);
			
			String successYN = isSuccessful?"Y":"N";
			eventResponse.setETCData("successYN",successYN);
			
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
	 * Receving Data From TRS 처리<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createTRSTPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TPBInterfaceEvent event = (TPBInterfaceEvent)e;
		TPBInterfaceBC command = new TPBInterfaceBCImpl();
		
		try{
			begin();
			boolean isSuccessful = command.createTRSTPB(event.getTpbInterfaceVOs());
			event.setSuccessful(isSuccessful);
			
			String successYN = isSuccessful?"Y":"N";
			eventResponse.setETCData("successYN",successYN);
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
	 * Receving Data From MNR 처리<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createMNRTPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TPBInterfaceEvent event = (TPBInterfaceEvent)e;
		TPBInterfaceBC command = new TPBInterfaceBCImpl();
		
		try{
			begin();
			boolean isSuccessful = command.createMNRTPB(event.getTpbInterfaceVOs());
			event.setSuccessful(isSuccessful);
			
			String successYN = isSuccessful?"Y":"N";
			eventResponse.setETCData("successYN",successYN);
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
	 * TPBInterfaceEvent : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTpbTesDltFlg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TPBInterfaceEvent event = (TPBInterfaceEvent)e;
		TPBInterfaceBC command = new TPBInterfaceBCImpl();

		try{
			begin();
			String reValueAll = "";
			String successYN = "N";
			String[] reValue = command.searchTpbTesDltFlg(event.getTpbInterfaceVOs());
			
			for(int i=0 ; i < reValue.length ; i++){
				reValueAll = reValueAll + reValue[i] + "|";
			}
			if(reValueAll.length()>0){
				successYN = "Y";
			}
			eventResponse.setETCData("successYN",successYN);
			eventResponse.setETCData("reValue",reValueAll);
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
