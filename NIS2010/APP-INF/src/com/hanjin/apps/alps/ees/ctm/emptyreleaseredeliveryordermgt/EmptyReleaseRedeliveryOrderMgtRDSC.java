/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtSC.java
*@FileTitle : Territories Management
*Open Issues :
*Change history : 2009.05.04 (김상수) - EES_CTM_0428 관련업무 최초생성
*                 2009.07.27 (김상수) - EES_CTM_0426 관련업무 추가
*                 2009.08.18 (김상수) - EES_CTM_0429 관련업무 추가
*@LastModifyDate : 2009.08.18
*@LastModifier : 김상수
*@LastVersion : 1.1
* 2009.05.04 김상수
* 1.0 Creation
* 2009.07.27 김상수
* 1.1 Modification
* 2009.08.18 김상수
* 1.3 Modification
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt;

import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBC;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBCImpl;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event.EesCtm0451RdEvent;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration.EmptyReleaseRedeliveryOrderMgtDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;


/**
 * ALPS-EmptyReleaseRedeliveryOrderMgt Business Logic ServiceCommand
 *  - ALPS-EmptyReleaseRedeliveryOrderMgt 대한 비지니스 트랜잭션을 처리한다.
 *
 *  RD Server에서 URL호출시 account가 없기 때문에 로그인 예외처리용 SC
 *
 * @author KIM, Sang Soo
 * @see EmptyReleaseRedeliveryOrderMgtDBDAO
 * @since J2EE 1.6
 */
public class EmptyReleaseRedeliveryOrderMgtRDSC extends ServiceCommandSupport {

	/**
	 * EmptyReleaseRedeliveryOrderMgt RDMail 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("EmptyReleaseRedeliveryOrderMgtRDSC 시작");
	}

	/**
	 * EmptyReleaseRedeliveryOrderMgt RDMail 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("EmptyReleaseRedeliveryOrderMgtRDSC 종료");
	}

	/**
	 * 업무 시나리오 수행<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = searchRDContentForRDSrv(e);
		return eventResponse;
	}

	/**
	 * EES_CTM_0451 : RD서버에 호출 (Account없음)<br>
	 * RD 내용을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDContentForRDSrv(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0451RdEvent event = (EesCtm0451RdEvent)e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try{
			String stringForRD = command.searchCimFaxSndInfo(event.getStkFaxSndNo());
			eventResponse.setCustomData("RD", stringForRD);
		}catch(EventException ex){
			log.error("\n\n[RDSC - searchRDContentForRDSrv] EventException :  " + ex.getMessage(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("\n\n[RDSC - searchRDContentForRDSrv] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

}