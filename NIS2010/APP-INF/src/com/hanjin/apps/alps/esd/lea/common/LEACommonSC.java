/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : LEACommonSC.java
*@FileTitle : LEA Common
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : junghyung kim
*@LastVersion : 1.0
* 2006-08-25 junghyung kim
* 1.0 최초 생성
* @History
* 2011-05-02 이정수 : Office COMBO가 정상적으로 생성되도록 수정
=========================================================*/

package com.hanjin.apps.alps.esd.lea.common;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.lea.common.codecomboutil.basic.CommonBC;
import com.hanjin.apps.alps.esd.lea.common.codecomboutil.basic.CommonBCImpl;
import com.hanjin.apps.alps.esd.lea.common.codecomboutil.event.CommonEvent;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
* ALPS-LEA Business Logic ServiceCommand<br> 
 * - ALPS-LEA에 대한 비지니스 트랜잭션을 처리한다.<br>
* 
 * @author jeongsoo lee
* @see LEACommonDBDAO 참조
* @since J2EE 1.4
*/
public class LEACommonSC extends ServiceCommandSupport {
    //Login User Information
	//private SignOnUserAccount account = null;

    /**
     * LEA 업무 시나리오 선행작업<br>
     * LEACommon업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try { 
        	//일단 comment --> 로그인 체크 부분
        	//account=getSignOnUserAccount();
            //account.getUsr_id()
        } catch (Exception e) {
            log.error("LEACommonSC Error " + e.toString(), e);
        }
    }

    /**
     * LEA 업무 시나리오 마감작업<br>
     * LEACommon업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
    	log.debug("LEACommonSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * ENIS-LEA 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
        
        log.debug("event : " + e.getEventName());
		if (e.getEventName().equalsIgnoreCase("ESD_LEA_Combo")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = dummy(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("LEAEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchLogisticsSubOfficeCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchCtrlOfficeCodeList(e);
			}
		}
       
        return eventResponse;
    }

    /**
     * Customer Name을 조회한다.<p>
     * @param e CommonEvent
     * @return response EventResponse
     * @exception EventException
     */
//    private EventResponse searchCustomerName(Event e) throws EventException {
//        EventResponse eventResponse = null;
//
//        try {
//        	
//            CommonBC command = new CommonBCImpl();
//            eventResponse = command.searchCustomerName(e);
//            
//        } catch (EventException de) {
//            log.error("err " + de.toString(), de);
//            throw new EventException(de.getMessage());
//        }
//        return eventResponse;
//    }
    
    /**
     * Customer Name을 조회한다.<p>
     * @param e CommonEvent
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse dummy(Event e) {
//            eventResponse = command. 
        return null;
    }
    
    
	/**
	 * 해당 Logistics Office 에 대한 Sub Office List 정보를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchLogisticsSubOfficeCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonEvent event = (CommonEvent)e;
		CommonBC command = new CommonBCImpl();

		try{
			String ctrlOfcCd = event.getString("ctrl_ofc_cd");
			
			String subOfcCds = command.searchLogisticsSubOfficeCodeList(ctrlOfcCd);
			
			eventResponse.setETCData("sub_ofc_cd" , subOfcCds);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 해당 RHQ 에 대한 Control Office List 정보를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCtrlOfficeCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonEvent event = (CommonEvent)e;
		CommonBC command = new CommonBCImpl();

		try{
			String rhqCd = event.getString("rhq_cd");
			
			String ofcCds = command.searchCtrlOfficeCodeList(rhqCd);
			
			eventResponse.setETCData("ctrl_ofc_cd" , ofcCds);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

}