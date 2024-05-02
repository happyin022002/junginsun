/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WebGateRSC.java
*@FileTitle : Web Gate
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-10
*@LastModifier : cho_gilhong@naver.com
*@LastVersion : 1.0
* 2007-07-10 cho_gilhong@naver.com
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.servicesio.newwebgate;
 
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.basic.WebGateBC;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.basic.WebGateBCImpl;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.SppSce0001Event;
import com.clt.apps.opus.esd.sce.servicesio.newwebgate.event.SppSce0002Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
//import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * SPP-SCE Business Logic ServiceCommand<br>
 * - SPP-SCE 에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author cho_gilhong
 * @see SPP_SCE_001EventResponse,WebGateDBDAO 참조
 * @since J2EE 1.4
 */
public class WebGateRSC extends ServiceCommandSupport {
    // serial UID
    //private static final long serialVersionUID = 1L;
	
    // Login User Information
    //private SignOnUserAccount account = null;

    /**
     * WebGate 업무 시나리오 선행작업<br>
     * WebGate 업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            //account = getSignOnUserAccount();
        }catch(Exception e) {
            log.error("WebGate 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * WebGate 업무 시나리오 마감작업<br>
     * WebGate업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("WebGateRSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * SPP-SCE 업무에서 발생하는 모든 이벤트의 분기처리<br>
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
        if(e.getEventName().equalsIgnoreCase("SPP_SCE_001Event")) {
            if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = createMovement(e);
            }
        }else if(e.getEventName().equalsIgnoreCase("SPP_SCE_002Event")) {
        	eventResponse = selectCntrMvmt(e);
        }
        return eventResponse;
    }
    
    /**
     * 입력 이벤트 처리<br>
     * create movement 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse createMovement(Event e) throws EventException {
        EventResponse eventResponse = null;
        
        try {
            begin();
            
            SppSce0001Event event = (SppSce0001Event)e;
            WebGateBC command = new WebGateBCImpl();
            eventResponse = command.createMovement(event);
            
            commit();
        }catch(EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * 입력 이벤트 처리<br>
     * selectCntrMvmt 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse selectCntrMvmt(Event e) throws EventException {
        EventResponse eventResponse = null;
        
        try {
            
            SppSce0002Event event = (SppSce0002Event)e;
            WebGateBC command = new WebGateBCImpl();
            eventResponse = command.selectCntrMvmt(event);
            
        }catch(EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
}