/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Sap0010001ReceiveRSC.java
*@FileTitle : Sap0010001ReceiveRSC
*Open Issues :
*Change history :
*@LastModifyDate : 2013-09-05
*@LastModifier : Lim Chang Bin
*@LastVersion : 1.0
* 2013-09-05 Lim Chang Bin
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.basic.ChargeAmountDiscountMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.basic.ChargeAmountDiscountMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event.EesDmt2008Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGGRPVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGRequestVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBCImpl;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Sap0010001ReceiveRSC ServiceCommand<br>
 * - Sap0010001ReceiveRSC 에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author	Kwon Min
 * @see 
 * @since	J2EE 1.4
 */
public class Sap0010001ReceiveRSC extends ServiceCommandSupport {
	
	// Login User Information
	private SignOnUserAccount account = null;
	
	/**
	 * WebGate 업무 시나리오 선행작업<br>
	 * WebGate 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
    public void doStart() {
        try {
            //account = getSignOnUserAccount();
        }catch(Exception e) {
            log.error("WebDoLink 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * WebDoLink 업무 시나리오 마감작업<br>
     * WebDoLink 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        log.debug("WebDoLink 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        EventResponse eventResponse = new GeneralEventResponse();
        
        log.debug("event : " + e);
        log.debug("\n  ★★★★★   WebDoLink Start  ★★★★★ ");
        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        if(e.getEventName().equalsIgnoreCase("EesDmt2008Event")) {
            if(e.getFormCommand().isCommand(FormCommand.MODIFY)) {

            	String darNo = createAftefBookingRequest(e);

            	log.debug("\n  perform(Event e) : Return [" + darNo + "]");
            	
                eventResponse.setETCData("RESULT", darNo);               
            }
        }
        
        log.debug("\n  ★★★★★   WebDoLink End  ★★★★★" );
        
        return eventResponse;
    }

    /**
     * createAftefBookingRequest 이벤트 처리<br>
     * 
     * @param Event e
     * @return String
     * @exception EventException
     */
    private String createAftefBookingRequest (Event e) throws EventException {
    	String 	darNo = "";

    	try {
            log.debug("\n  ★★★★★   WebDoLink  multiUsDo Start  begin,commit,rollback remove  ★★★★★ ");            
            EesDmt2008Event event			= (EesDmt2008Event)e;
            
    		AfterProgressVO 			afterProgressVO 		= event.getAfterProgressVO();
    		AfterBKGRequestVO[] 		afterBKGRequestVOS 		= event.getAfterBKGRequestVOS();
    		
    		String usrId = afterProgressVO.getRqstUsrId();
    		String ofcCd = afterProgressVO.getRqstOfcCd();
			
    		RFAExceptionTariffMgtBC command1 = new RFAExceptionTariffMgtBCImpl();
    		
    		darNo = command1.searchNewDAR("A", usrId, ofcCd);	// DAR No. 채번.

    		log.debug("\n[001]darNo = [" + darNo +"]");
    		
    		if (darNo == null)	{
    			// DAR No. 채번 Error시
    			 log.error("Error : Dar No. Generation Error!");
    			throw new EventException("Dar No. Generation Error!");
    		}
    		
    		afterProgressVO.setAftExptDarNo( darNo );
    		for (int i=0; i<afterBKGRequestVOS.length; i++) {
    			afterBKGRequestVOS[i].setAftExptDarNo(darNo);
    		}

    		AfterBKGGRPVO afterBKGGRPVO = new AfterBKGGRPVO();
    		afterBKGGRPVO.setAfterProgressVO(afterProgressVO);
    		afterBKGGRPVO.setAfterBKGRequestVOS(afterBKGRequestVOS);

            begin();
            ChargeAmountDiscountMgtBC command2 = new ChargeAmountDiscountMgtBCImpl();
            log.debug("\n[002]darNo = [" + darNo +"]");
            command2.requestAfterBookingDAR(afterBKGGRPVO, account);
            log.debug("\n[003]darNo = [" + darNo +"]");
           	commit();
        } catch (EventException de) {
        	rollback();
        	
            log.error("Error : createAftefBookingRequest() " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        
        return darNo;
    }
}
