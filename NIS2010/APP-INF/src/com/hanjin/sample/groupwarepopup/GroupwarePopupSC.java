/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GroupwarePopupSC.java
*@FileTitle : GROUPWARE_POPUP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김정훈
*@LastVersion : 1.0
* 2009.06.04 김정훈
* 1.0 Creation
=========================================================*/
package com.hanjin.sample.groupwarepopup;

import java.util.List;
import com.hanjin.sample.groupwarepopup.groupwarepopup.basic.GroupwarePopupBC;
import com.hanjin.sample.groupwarepopup.groupwarepopup.basic.GroupwarePopupBCImpl;
import com.hanjin.sample.groupwarepopup.groupwarepopup.event.GroupwarePopupEvent;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComEmlSndInfoVO;


/**
 * NIS2010-GroupwarePopup Business Logic ServiceCommand - NIS2010-GroupwarePopup 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jeong-Hoon, Kim
 * @see GroupwarePopupDBDAO
 * @since J2EE 1.6
 */

public class GroupwarePopupSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * GroupwarePopup system 업무 시나리오 선행작업<br>
	 * GROUPWARE_POPUP업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("GroupwarePopupSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * GroupwarePopup system 업무 시나리오 마감작업<br>
	 * GROUPWARE_POPUP 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("GroupwarePopupSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-GroupwarePopup system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("GroupwarePopupEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = comEmlSndInfoVO(e);
			}
		}
		return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * GroupwarePopup의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse comEmlSndInfoVO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GroupwarePopupEvent event = (GroupwarePopupEvent)e;
		GroupwarePopupBC command = new GroupwarePopupBCImpl();

		try{
			List<ComEmlSndInfoVO> list = command.comEmlSndInfoVO(event.getComEmlSndInfoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
}