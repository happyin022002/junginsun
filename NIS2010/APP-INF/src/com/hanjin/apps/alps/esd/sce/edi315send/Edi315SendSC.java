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
* 2011.12.01 전준영 [CLT-111121289]Split R4J 소스품질 결함 조치 - Null Dereferencing(객체에 NULL이 배정된 이후 객체에 대한 참조를 하지 말아야 한다
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
/**
 * ENIS-SCE Business Logic ServiceCommand<br>
 * - ENIS-SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
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
//		EventResponse   eventResponse = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		return eventResponse;
	}
}
