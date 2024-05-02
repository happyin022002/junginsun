/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CLMInquiryRSC.java
*@FileTitle : ServiceProvicerVisibility Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-02
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.event.SppSce0003Event;
import com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.basic.ClmInquiryBC;
import com.hanjin.apps.alps.esd.sce.servicesio.serviceprovidervisibility.clm.basic.ClmInquiryBCImpl;

/**
 * Business Logic ServiceCommand<br>
 *
 * @author 2007607
 * @see 
 * @since J2EE 1.4
 */
public class ClmInquiryRSC extends ServiceCommandSupport {

	   /**
     * Visibility 업무 시나리오 선행작업<br>
     * Visibility업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
        	//account = getSignOnUserAccount();
        } catch (Exception e) {
            log.error("CLMInquiry 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * Visibility 업무 시나리오 마감작업<br>
     * Visibility업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("CLMInquiry 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * CUP-SCE 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	public EventResponse perform(Event e) throws EventException {
		// TODO Auto-generated method stub
		 EventResponse eventResponse = null;
	        log.debug("CLMInquiryRSC perform event : " + e);
	        
	        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
	        if(e.getEventName().equalsIgnoreCase("SPP_SCE_003Event")) {
	            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	                eventResponse = getCntrClmInquiry(e);
	            }
	        }
	        return eventResponse;
	}
	
    /**
     * 입력 이벤트 처리<br>
     * getCntrClmInquiry 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse getCntrClmInquiry(Event e) throws EventException {
        EventResponse eventResponse = null;
        log.debug("CLMInquiryRSC getCntrClmInquiry : ");
        
        SppSce0003Event event = (SppSce0003Event)e;
        try {
            
            ClmInquiryBC command = new ClmInquiryBCImpl();
            eventResponse = command.getCntrClmInquiry(event);
            
        }catch(EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        log.debug("eventResponse  " + eventResponse);
        return eventResponse;
    }


}
