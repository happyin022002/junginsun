/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FillInEquipmentNoRSC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-22
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-10-18 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder;


import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0003Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.basic.FillInEquipmentNoBC;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.basic.FillInEquipmentNoBCImpl;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author doomi
 * @see ExpPap0003EventResponse,PendingListDBDAO 참조
 * @since J2EE 1.4
 */
public class FillInEquipmentNoRSC extends ServiceCommandSupport {
	
	// serial UID
	private static final long serialVersionUID = 1L;
	
    // Login User Information
    private SignOnUserAccount account = null;


    /**
     * TRS 업무 시나리오 선행작업<br>
     * WorkOrder업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("FillInEquipmentNoRSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * TRS 업무 시나리오 마감작업<br>
     * WorkOrder업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("FillInEquipmentNoRSC 종료");
    }    
    
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-TRS 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		log.debug("event : " + e);

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("ExpPap0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFillInEquipmentNoList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchFillInEquipmentNoExcelPrint(e);
			}
		}
		return eventResponse;

	}


	
	/**
	 * 조회 이벤트 처리<br>
	 * WO Detail Inquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	 
	private EventResponse searchFillInEquipmentNoList(Event e) throws EventException {
		
		
		 // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
		 
        // PDTO(Data Transfer Object including Parameters)
		ExpPap0003Event event = (ExpPap0003Event)e;
	 
		try {
			FillInEquipmentNoBC command = new FillInEquipmentNoBCImpl();	
			eventResponse = command.searchFillInEquipmentNoList(event); 
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * 조회 이벤트 처리<br>
	 * WO Detail Inquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	 
	private EventResponse searchFillInEquipmentNoExcelPrint(Event e) throws EventException {
		
		 // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
		 
        // PDTO(Data Transfer Object including Parameters)
		ExpPap0003Event event = (ExpPap0003Event)e;
	 
		try {
			FillInEquipmentNoBC command = new FillInEquipmentNoBCImpl();	
			eventResponse = command.searchFillInEquipmentNoExcelPrint(event); 
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	
}