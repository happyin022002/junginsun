/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Edi324SendSC.java
*@FileTitle :Edi324SendSC
*Open Issues :
*Change history :
*@LastModifyDate : 2012-02-13
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012-02-13 채창호
* 1.0 Creation
* 2012-02-13 채창호
* 1.0 버전 커밋
=========================================================*/
package com.clt.apps.opus.esd.sce.edi324send;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
/**
 * ENIS-SCE Business Logic ServiceCommand<br>
 * - ENIS-SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author YJLEE
 * @see Edi324SendBCImpl 참조
 * @since J2EE 1.4
 */
public class Edi324SendSC extends ServiceCommandSupport {
	/**
	 * 화면에 대한 이벤트등 서비스 분기함수
	 * @param  e Event
	 * @return EventResponse
	 * @throws 
	 */
    @Override
	public EventResponse perform(Event e) throws EventException {
//		EventResponse   eventResponse = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		return eventResponse;
	}
}
