/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingCommonRSC.java
*@FileTitle : Rail Billing Common
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.railbillingcommon;

import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.Constants;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.railbillingcommon.basic.RailBillingCommonBC;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.railbillingcommon.basic.RailBillingCommonBCImpl;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.railbillingcommon.event.ExpPap0019Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS 에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author leebh
 * @see EXP_EventResponse,RailBillingCommonDBDAO 참조
 * @since J2EE 1.4
 */
public class RailBillingCommonRSC extends ServiceCommandSupport {
    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * ESD-TRS 업무 시나리오 선행작업<br>
     * RailBillingInquiry 업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("RailBillingCommonRSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * ESD-TRS 업무 시나리오 마감작업<br>
     * RailBillingRequestCreation 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("RailBillingCommonRSC 종료");
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
        
        //log.debug("event : " + e);

        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        if (e.getEventName().equalsIgnoreCase("ExpPap0019Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRailBillingAckCount(e);
            }
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Potal Main Rail Bill Ack Count 조회  화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRailBillingAckCount(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	ExpPap0019Event event = (ExpPap0019Event)e;
        	RailBillingCommonBC command = new RailBillingCommonBCImpl();
            eventResponse = command.searchRailBillingAckCount(event);
        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
        return eventResponse;
    }
    
}