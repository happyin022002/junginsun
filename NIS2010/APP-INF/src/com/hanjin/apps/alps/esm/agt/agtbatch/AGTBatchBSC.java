/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : AGTBatchBSC.java
*@FileTitle : Closing Batch Service Command
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-31
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-31 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtbatch;

import com.hanjin.apps.alps.esm.agt.agtbatch.agtbatch.basic.AGTBatchBC;
import com.hanjin.apps.alps.esm.agt.agtbatch.agtbatch.basic.AGTBatchBCImpl;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;


/**
 * eNIS-agt Business Logic ServiceCommand<br>
 * - eNIS-agt에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author Junghyung_kim
 * @see ESM_AGT_0xxEventResponse,AGTClosingDBDAO 참조
 * @since J2EE 1.4
 */
public class AGTBatchBSC extends ServiceCommandSupport {

	/**
	 * agt 업무 시나리오 선행작업<br>
	 * AGTClosing업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		// command.doStart();
		log.debug("AGTBatchBSC 시작");
	}

	/**
	 * agt 업무 시나리오 마감작업<br>
	 * AGTClosing업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("AGTBatchBSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * eNIS-agt 업무에서 발생하는 모든 이벤트의 분기처리<br>
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
		if(e.getEventName().equalsIgnoreCase("ESM_AGT_019Event")) {
			eventResponse = dummy(e);
		}

		return eventResponse;
	}

	/**
	 * 추정결산 배치 처리<br>
	 * Scheduler에 의한 추정결산 배치 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse dummy(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;

        try {

        	AGTBatchBC command = new AGTBatchBCImpl();
            eventResponse = command.processAGTBatchBC(e);
        } catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
        }

        return eventResponse;
	}
	
	
	
	

//	/**
//	 * 추정결산 배치 처리<br>
//	 * Scheduler에 의한 추정결산 배치 처리<br>
//	 * 
//	 * @param e Event
//	 * @return response EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse processAGTBatchBC(Event e) throws EventException {
//        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
//        EventResponse eventResponse = null;
//
//        try {
//
//        	AGTBatchBC command = new AGTBatchBCImpl();
//            eventResponse = command.processAGTBatchBC(e);
//        } catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//        }
//
//        return eventResponse;
//	}
}
