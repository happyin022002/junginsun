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
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage;

import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration.ReplanManageDBDAO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * ReplanManage Business Logic ServiceCommand - ReplanManage 대한 비지니스 트랜잭션을 처리한다.
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
	 * ReplanManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
//		if (e.getEventName().equalsIgnoreCase("EsdSceRplnEvent")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//			}
//		}
		return eventResponse;
	}
}