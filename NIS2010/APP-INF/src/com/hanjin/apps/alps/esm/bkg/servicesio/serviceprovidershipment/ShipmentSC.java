/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ShipmentSC.java
*@FileTitle : WebGate Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2012-04-06
*@LastModifier : tae-kyoung.kim
*@LastVersion : 1.0
* 2012-04-06 tae-kyoung.kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0001Event;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0002Event;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0003Event;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.basic.BangladeshOdcyReqBC;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.basic.BangladeshOdcyReqBCImpl;
/**
 * ESM-BKG Business Logic ServiceCommand<br>
 * - ESM-BKG 에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author SEO MI JIN
 * @see EventResponse,BangladeshOdcyReqDBDAO 참조
 * @since J2EE 1.4
 */
public class ShipmentSC extends ServiceCommandSupport {
	  // Login User Information
    private SignOnUserAccount account = null;

    
    /**
     * 업무 시나리오 선행작업<br>
     * ShipmentSC 업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("ShipmentSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * 업무 시나리오 마감작업<br>
     * ShipmentSC 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("ShipmentSC 종료");
    }
    
    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * Shippment 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
        
        //log.debug("event : " + e);

        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        if (e.getEventName().equalsIgnoreCase("SppBkg0001Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchShippingInstruction(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("SppBkg0002Event")){
        	if(e.getFormCommand().isCommand(FormCommand.MULTI)){
        		eventResponse = manageShippingRequest(e);
        	}
        }else if (e.getEventName().equalsIgnoreCase("SppBkg0003Event")){
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
        		eventResponse = searchShippingRequest(e);
        	}
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * searchShippingInstruction Search (Full)의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    
    private EventResponse searchShippingInstruction(Event e) throws EventException {
    	 // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try{
        	SppBkg0001Event event = (SppBkg0001Event)e;
        	BangladeshOdcyReqBC command = new BangladeshOdcyReqBCImpl();
        	eventResponse = command.verifyShipmentReq(event);
        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException("");
        }
        
        return eventResponse;
    }
    
    /**
     * 입력 이벤트 처리<br>
     * manageShippingRequest 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return manageShippingRequest EventResponse
     * @exception EventException
     */
    
    private EventResponse manageShippingRequest(Event e) throws EventException {
   	 // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try{
//        	SppBkg0002Event event = new SppBkg0002Event();
        	SppBkg0002Event event = (SppBkg0002Event)e;
        	BangladeshOdcyReqBC command = new BangladeshOdcyReqBCImpl();
        	eventResponse = command.manageShippingRequest(event);
        	
        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException("");
        }
        
        return eventResponse;
    }
    
    /**
     * 입력 이벤트 처리<br>
     * searchShippingRequest 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchShippingRequest(Event e) throws EventException {
        EventResponse eventResponse = null;
        
        try {
            
            SppBkg0003Event event = (SppBkg0003Event)e;
            BangladeshOdcyReqBC command = new BangladeshOdcyReqBCImpl();
            eventResponse = command.searchShippingRequest(event);
            
        }catch(EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }    
}
