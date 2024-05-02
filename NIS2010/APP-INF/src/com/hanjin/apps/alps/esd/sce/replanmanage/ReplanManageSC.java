/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReplanManageSC.java
*@FileTitle : Replan 을 수행하는 공통 class 를 구동한다.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.09.01 김인수
* 1.0 Creation
* 2011.12.01 전준영 [CLT-111121289]Split R4J 소스품질 결함 조치 - Null Dereferencing(객체에 NULL이 배정된 이후 객체에 대한 참조를 하지 말아야 한다
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage;

import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration.ReplanManageDBDAO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ReplanManage Business Logic ServiceCommand - ALPS-ReplanManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim In-soo
 * @see ReplanManageDBDAO
 * @since J2EE 1.6
 */

public class ReplanManageSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * ReplanManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ReplanManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ReplanManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ReplanManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ReplanManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
//		EventResponse eventResponse = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
//		if (e.getEventName().equalsIgnoreCase("EsdSceRplnEvent")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//			}
//		}
		return eventResponse;
	}
}