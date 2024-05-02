/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : 
*@FileTitle : Common PopUp
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-27
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-27 yujin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.common;

import com.hanjin.apps.alps.esd.eas.common.popup.basic.CommonPopUpManageBC;
import com.hanjin.apps.alps.esd.eas.common.popup.basic.CommonPopUpManageBCImpl;
import com.hanjin.apps.alps.esd.eas.common.popup.event.EsdEasCom0001Event;
import com.hanjin.apps.alps.esd.eas.common.popup.event.EsdEasCom0002Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.DOFChgColInqmanageBC;
import com.hanjin.apps.alps.esd.eas.transportmanage.basic.DOFChgColInqmanageBCImpl;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * ESD-EAS Business Logic ServiceCommand<br>
 * - ESD-EAS에 대한 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author yujin
 * @see 
 * @since J2EE 1.4
 */
public class CommonManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	private String sofficeCd = "";

	/**
	 * EAS 업무 시나리오 선행작업<br>
	 * CommonManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
			sofficeCd = account.getOfc_cd();
		} catch (Exception e) {
			log.error("CommonManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * EAS 업무 시나리오 마감작업<br>
	 * CommonManageSC 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("CommonManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-EAS 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdEasCom0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { 
				eventResponse = searchOfcManage(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdEasCom0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { 
				eventResponse = searchOfcManage2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchTroSubOfc(e);
			}
		} else {
			eventResponse = null;
		}
		
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CommonManageSC event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * Request Corretion Container Check<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEasCom0001Event event = (EsdEasCom0001Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			CommonPopUpManageBC command = new CommonPopUpManageBCImpl();
			eventResponse = command.searchServiceOfficeCodeManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CommonManageSC event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * Request Corretion Container Check<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcManage2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEasCom0002Event event = (EsdEasCom0002Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			CommonPopUpManageBC command = new CommonPopUpManageBCImpl();
			eventResponse = command.searchServiceOfficeCodeManage2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * DOFChgColInqmanageBCImpl의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTroSubOfc(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsdEasCom0002Event event = (EsdEasCom0002Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonPopUpManageBC command = new CommonPopUpManageBCImpl();
			eventResponse = command.searchTroSubOfc(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}
