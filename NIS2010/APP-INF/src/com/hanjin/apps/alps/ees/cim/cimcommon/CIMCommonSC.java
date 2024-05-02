/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CNTROperatioNPerformanceMgtSC.java
*@FileTitle : Turn Time by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.04.24 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cimcommon;


import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-CNTROperatioNPerformanceMgt Business Logic ServiceCommand - ALPS-CNTROperatioNPerformanceMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Prak Kwang Seok
 * @see ITurnTimePerformanceFinderBCDBDAO
 * @since J2EE 1.4
 */

public class CIMCommonSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * CNTROperatioNPerformanceMgt system 업무 시나리오 선행작업<br>
	 * UI_CIM_1001업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
            log.error(e.getLocalizedMessage());			
		}
	}

	/**
	 * CNTROperatioNPerformanceMgt system 업무 시나리오 마감작업<br>
	 * UI_CIM_1001 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CNTROperatioNPerformanceMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-CNTROperatioNPerformanceMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = new GeneralEventResponse();

		return eventResponse;
	}
}