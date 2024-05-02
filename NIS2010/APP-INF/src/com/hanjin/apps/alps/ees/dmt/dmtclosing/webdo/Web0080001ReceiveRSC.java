/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Web0080001ReceiveRSC.java
*@FileTitle : Web0080001ReceiveRSC
*Open Issues :
*Change history :
*@LastModifyDate : 2012-01-03
*@LastModifier : Kwon Min 
*@LastVersion : 1.0
* 2012-01-03 Kwon Min
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3003Event;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Web0080001ReceiveRSC ServiceCommand<br>
 * - Web0080001ReceiveRSC 에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author	Kwon Min
 * @see 
 * @since	J2EE 1.4
 */
public class Web0080001ReceiveRSC extends ServiceCommandSupport {
	
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
        if(e.getEventName().equalsIgnoreCase("EesDmt3003Event")) {
            if(e.getFormCommand().isCommand(FormCommand.MODIFY)) {

            	int size	= modifyClockStop(e);
//            	int size = 1; -->>> 테스트시 사용.
            	String msg = size > 0 ? "1" : "0";
            	
            	log.debug("\n  perform(Event e) : Return [" + msg + "]");
            	
                eventResponse.setETCData("RESULT", msg);               
            }
        }
        
        log.debug("\n  ★★★★★   WebDoLink End  ★★★★★" );
        
        return eventResponse;
    }

    /**
     * modifyClockStop 이벤트 처리<br>
     * 
     * @param e Event
     * @exception EventException
     */
    private int modifyClockStop (Event e) throws EventException {
    	int SuccessCount = 0;

    	try {
            log.debug("\n  ★★★★★   WebDoLink  multiUsDo Start  begin,commit,rollback remove  ★★★★★ ");            
            EesDmt3003Event event			= (EesDmt3003Event)e;
            ChargeCalculationContainerVO[] chargeCalculationContainerVOs = event.getChargeCalculationContainerVOS();
            
            ChargeCalculationBC command	= new ChargeCalculationBCImpl();
            
            begin();
            
            for (int i = 0 ; i < chargeCalculationContainerVOs.length ; i++) {
            	
            	ChargeArgumentVO chargeArgumentVO = new ChargeArgumentVO();
            	
            	chargeArgumentVO.setSvrId          ( chargeCalculationContainerVOs[i].getSvrId           ()); 
            	chargeArgumentVO.setCntrNo         ( chargeCalculationContainerVOs[i].getCntrNo          ()); 
            	chargeArgumentVO.setCntrCycNo      ( chargeCalculationContainerVOs[i].getCntrCycNo       ()); 
            	chargeArgumentVO.setDmdtTrfCd      ( chargeCalculationContainerVOs[i].getDmdtTrfCd       ()); 
            	chargeArgumentVO.setDmdtChgLocDivCd( chargeCalculationContainerVOs[i].getDmdtChgLocDivCd ()); 
            	chargeArgumentVO.setChgSeq         ( chargeCalculationContainerVOs[i].getChgSeq          ());
            	chargeArgumentVO.setEstMk          ( "E" ); // "E" 이면 DMT_CHG_BKG_CNTR 테이블 호출. "P" 이면 DMT_CHG_PRE_CALC_BKG_CNTR 테이블 호출
            	
            	ChargeCalculationContainerVO chargeCalculationContainerVO = command.searchBookingNChargeInfo(chargeArgumentVO);
            	
            	if (chargeCalculationContainerVO != null){
            		// 정상 조회시 Home Page 쪽에서 입력 받은 데이터를 할당한다.
            		chargeCalculationContainerVO.setToMvmtStsCd(chargeCalculationContainerVOs[i].getToMvmtStsCd  ());
            		log.debug("\n  A 1");
            		chargeCalculationContainerVO.setToMvmtYdCd (chargeCalculationContainerVO    .getFmMvmtYdCd   ()); // From Yard를 To Yard와 동일 처리 한다.
            		log.debug("\n  A 2");
            		chargeCalculationContainerVO.setToMvmtDt   (chargeCalculationContainerVOs[i].getToMvmtDt     ().replace("-", ""));
            	} else {
            		throw new EventException(new ErrorHandler("DMT00006", new String[]{"DMT Booking, Container and Charge Information Search Error!"}).getMessage());
            	}
            	log.debug("\n  A 3");
            	DmtResultVO resultVO = command.modifyChargeByContainer(chargeCalculationContainerVO, account);
            	log.debug("\n  A 4");
            	if(resultVO.getResultCode() != null) {
            		throw new EventException(new ErrorHandler("DMT00006", new String[]{"DMT Booking, Container and Charge Information Update Error!"}).getMessage());
                }
            	
            	SuccessCount = 1;
            }
            
           	commit();
           
        } catch (EventException de) {
        	rollback();
        	
            log.error("Error : modifyClockStop() " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        
        return SuccessCount;
    }
}
