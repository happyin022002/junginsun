/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCommonSC.java
*@FileTitle : AGT Common
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : junghyung kim
*@LastVersion : 1.0
* 2006-08-25 junghyung kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.common;

import java.util.HashMap;

import com.clt.apps.opus.esm.agt.common.basic.CommonBC;
import com.clt.apps.opus.esm.agt.common.basic.CommonBCImpl;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;

/**
 * 1. 기능 : OPUS-AGT Common ServiceCommand<br> 
 * 2. 처리 개요 :<p>
 *  - OPUS-AGT에 대한 공통 트랜잭션을 처리한다.<br>
 * 3. 주의사항 :<p>
 * ===================================<br>
 * 4. 작성자/작성일 : junghyung kim/2006.09<br>
 * ===================================<br>
 * 5. 수정사항<p>
 * 5.1 요구사항 ID :<p>
 *  - 수정자/수정일 :<p>
 * 수정사유/내역 :<p>
 * ===================================<br>
 * <p/>
 * 
 * @author junghyung kim
 * @see ESM_AGT_CommonEventResponse,AGTCommonDBDAO 참조
 * @since J2EE 1.4
 */
public class AGTCommonSC extends ServiceCommandSupport {
    //Login User Information
	//private SignOnUserAccount account = null;

    /**
     * AGT 업무 시나리오 선행작업<br>
     * AGTCommon업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            //일단 comment --> 로그인 체크 부분
        	//account=getSignOnUserAccount();
            //account.getUsr_id()
        } catch (Exception e) {
            log.error("AGTCommonSC Error " + e.toString(), e);
        }
    }

    /**
     * AGT 업무 시나리오 마감작업<br>
     * AGTCommon업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("AGTCommonSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * OPUS-AGT 업무에서 발생하는 모든 이벤트의 분기처리<br>
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
        //if (e.getEventName().equalsIgnoreCase("CommonEvent")) {
        if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //select Customer Name
            eventResponse = searchCustomerName(e);
        }
        
//        if (e.getEventName().equalsIgnoreCase("ESM_AGT_050Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchCntrList(e);
//			}
//        }
        //}
        
        return eventResponse;
    }

    /**
     * Customer Name을 조회한다.<p>
     * @param e CommonEvent
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCustomerName(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            CommonBC command = new CommonBCImpl();
            HashMap<String, String> rtnMap = command.searchCustomerName(e);
            eventResponse.setETCData(rtnMap);
            
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    

}