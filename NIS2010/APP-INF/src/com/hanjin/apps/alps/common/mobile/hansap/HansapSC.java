/**
 * Copyright(c) 2013 CyberLogitec
 * @FileName : HansapSC.java
 * @FileTitle : Hanjin Menu별 접근 권한 지정
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2013.12.17
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.0
 * 2013.12.17 1.0 Sang-Hyun Kim Creation
 */
package com.hanjin.apps.alps.common.mobile.hansap;

import com.hanjin.apps.alps.common.mobile.hansap.basic.MenuAccessBC;
import com.hanjin.apps.alps.common.mobile.hansap.basic.MenuAccessBCImpl;
import com.hanjin.apps.alps.common.mobile.hansap.event.MenuAccessEvent;
import com.hanjin.apps.alps.common.mobile.hansap.vo.MobAuthorityVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * Hansap 메뉴별 접근에 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sang-Hyun Kim
 * @see
 * @since J2EE 1.6
 */
public class HansapSC extends ServiceCommandSupport {

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행
	 * HANSAP Menu별 Logic 분기 처리
	 * 
	 * @param event
	 * @return EventResponse
	 * @exception EventException
	 */
	@Override
	public EventResponse perform(Event event) throws EventException {
		EventResponse eventResponse = null;

		if (event.getEventName().equalsIgnoreCase("MenuAccessEvent")) {
			if (event.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = addAuth(event);
			} else if (event.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeAuth(event);
			}
		}

		return eventResponse;
	}

	/**
	 * Menu별 접근 권한 추가.
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse addAuth(Event event) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MenuAccessEvent menuAccessEvent = (MenuAccessEvent)event;
		MenuAccessBC menuAccessBC = new MenuAccessBCImpl();

		try {
			Integer affectCount = menuAccessBC.addAuth(menuAccessEvent.getMobAuthorityVOs());
			MobAuthorityVO mobAuthorityVO = new MobAuthorityVO();
			mobAuthorityVO.setPagerows(affectCount.toString());
			eventResponse.setRsVo(mobAuthorityVO);
		} catch (EventException e) {
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		}

		return eventResponse;
	}

	/**
	 * Menu별 접근 권한 삭제.
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeAuth(Event event) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MenuAccessEvent menuAccessEvent = (MenuAccessEvent)event;
		MenuAccessBC menuAccessBC = new MenuAccessBCImpl();

		try {
			Integer affectCount = menuAccessBC.removeAuth(menuAccessEvent.getMobAuthorityVOs());
			MobAuthorityVO mobAuthorityVO = new MobAuthorityVO();
			mobAuthorityVO.setPagerows(affectCount.toString());
			eventResponse.setRsVo(mobAuthorityVO);
		} catch (EventException e) {
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		}

		return eventResponse;
	}
}
