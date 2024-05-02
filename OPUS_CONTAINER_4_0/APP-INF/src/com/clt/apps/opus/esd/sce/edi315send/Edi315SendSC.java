/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendSC.java
*@FileTitle :Edi315SendSC
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-09
*@LastModifier : 전병석
*@LastVersion : 1.14
* 2009-10-01 전병석 
* 1.0 Creation
* 2009-11-09 전병석
* 1.14 버전 커밋
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
/**
 * SCE Business Logic ServiceCommand<br>
 * - SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author YJLEE
 * @see Edi315SendBCImpl 참조
 * @since J2EE 1.4
 */
public class Edi315SendSC extends ServiceCommandSupport {
	/**
	 * 화면에 대한 이벤트등 서비스 분기함수
	 * @param  e Event
	 * @return EventResponse
	 * @throws 
	 */
    @Override
	public EventResponse perform(Event e) throws EventException {
		//EventResponse   eventResponse = null; //2015.04.14 Modify Critical
		EventResponse   eventResponse = new GeneralEventResponse();
		return eventResponse;
	}
}
