/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EtsSceLinkRSC.java
*@FileTitle : EtsSceLinkRSC
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-16
*@LastModifier : 9009633 
*@LastVersion : 1.0
* 2009-12-16 9009633
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esd.sce.servicesio.etsscelink;

import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBC;
import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.vo.ReplanResultVO;
import com.hanjin.apps.alps.esd.sce.servicesio.etsscelink.event.EtsSceLinkEvent;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * EtsSceLinkRSC ServiceCommand<br>
 * - EtsSceLinkRSC 에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author cho_gilhong
 * @see 
 * @since J2EE 1.4
 */
public class EtsSceLinkRSC extends ServiceCommandSupport {
	
	/**
	 * WebGate 업무 시나리오 선행작업<br>
	 * WebGate 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            //account = getSignOnUserAccount();
        }catch(Exception e) {
            log.error("EtsSceLink 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * EtsLink 업무 시나리오 마감작업<br>
     * EtsLink 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("EtsLinkRSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = new GeneralEventResponse();
        
        log.debug("event : " + e);
        log.debug("\n  ★★★★★   EtsSceLink Start  ★★★★★ ");
        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        if(e.getEventName().equalsIgnoreCase("EtsSceLinkEvent")) {
            if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                String msg = edi315Send(e);
                eventResponse.setUserMessage(msg);
            }else  if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                ReplanResultVO rsltVO = replanCop(e);
//                String msg = flag ? "1" : "0";
//                eventResponse.setUserMessage(msg); 
                eventResponse.setRsVo(rsltVO);
            }else  if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {
            	boolean flag = modifySoList(e);
                String msg = flag ? "1" : "0";            	
                eventResponse.setUserMessage(msg);                 
            }
        }
        log.debug("\n  ★★★★★   EtsSceLink End  ★★★★★ ");        
        return eventResponse;
    }
    
    /**
     * 입력 이벤트 처리<br>
     * eid send 이벤트 처리<br>
     * 
     * @param e Event
     * @return returnMsg String
     * @exception EventException
     */
    private String edi315Send(Event e) throws EventException {
       // EventResponse eventResponse = null;
        String returnMsg = null;
        
        try {
            //begin();
log.debug("\n  ★★★★★   EtsSceLink  edi315Send Start  begin,commit,rollback remove★★★★★ ");            
            EtsSceLinkEvent event = (EtsSceLinkEvent)e;
            Edi315SendVO vo = event.getEdi315Send();
            log.debug("\n Edi315SendVO:"+vo.toString() );
            Edi315SendBC command = new Edi315SendBCImpl();
            returnMsg = command.edi315Send(vo);
log.debug("\n  ★★★★★   EtsSceLink  edi315Send End returnMsg:"+returnMsg+"  ★★★★★ ");            
            //commit();
        }catch(EventException de) {
            //rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return returnMsg;
    }
    /**
     * replan cop 이벤트 처리<br>
     * 
     * @param e Event
     * @return returnMsg String
     * @exception EventException
     */
    private ReplanResultVO replanCop (Event e) throws EventException {
       // EventResponse eventResponse = null;
        boolean returnFlag = false;
        ReplanResultVO rsltVO = null;
        
        try {
            //begin();
log.debug("\n  ★★★★★   EtsSceLink  replanCop Start  begin,commit,rollback remove ★★★★★ ");            
            EtsSceLinkEvent event = (EtsSceLinkEvent)e;
            SingleTransportationVO vo = event.getSingleTransportation();
            ReplanManageBC command = new ReplanManageBCImpl();
            rsltVO = command.replanCop(vo);
log.debug("\n  ★★★★★   EtsSceLink  replanCop End returnFlag:"+returnFlag+"  ★★★★★ ");            
            //commit();
        }catch(EventException de) {
            //rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return rsltVO;
    }
    /**
     * replan cop 이벤트 처리<br>
     * 
     * @param e Event
     * @return returnMsg String
     * @exception EventException
     */
    private boolean modifySoList (Event e) throws EventException {
       // EventResponse eventResponse = null;
        boolean returnFlag = false;
        
        try {
            //begin();
log.debug("\n  ★★★★★   EtsSceLink  modifySoList Start  begin,commit,rollback remove  ★★★★★ ");            
            EtsSceLinkEvent event = (EtsSceLinkEvent)e;
            SingleTransportationVO vo = event.getSingleTransportation();
            ReplanManageBC command = new ReplanManageBCImpl();
            int cnt = command.modifySoList(vo);
            returnFlag = cnt > 0 ? true : false;
log.debug("\n  ★★★★★   EtsSceLink  modifySoList End returnFlag:"+returnFlag+"  ★★★★★ ");            
            //commit();
        }catch(EventException de) {
            //rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return returnFlag;
    }    
    
}
