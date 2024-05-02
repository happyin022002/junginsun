/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DctionarySC.java
*@FileTitle : Dctionary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.12.07 정인선
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps;

import java.util.List;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.syscommon.management.alps.dctionary.basic.DctionaryBC;
import com.hanjin.syscommon.management.alps.dctionary.basic.DctionaryBCImpl;
import com.hanjin.syscommon.management.alps.dctionary.event.DctionaryEvent;
import com.hanjin.syscommon.management.alps.dctionary.integration.DctionaryDBDAO;
import com.hanjin.syscommon.management.alps.dctionary.vo.DctionaryVO;

/**
 * ALPS-Dctionary 대한
 * 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sun JungIn
 * @see DctionaryDBDAO
 * @since J2EE 1.6
 */
public class DctionarySC extends ServiceCommandSupport {
	/**
	 * Dctionar system 업무 시나리오 선행작업<br>
	 * Dctionar업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			getSignOnUserAccount();
		} catch (Exception e) {
			log.error("DctionarySC doStart error!");
		}
	}

	/**
	 * Dctionar system 업무 시나리오 마감작업<br>
	 * Dctionar업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DctionarySC doEnd");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-Dctionar system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			eventResponse = searchDctionary(e);
		}
		return eventResponse;
	}


	/**
	 * 조회 이벤트 처리<br>
	 * Dctionary의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchDctionary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DctionaryEvent event = (DctionaryEvent)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			DctionaryBC command = new DctionaryBCImpl();
			List<DctionaryVO> list = command.searchDctionary(event.getAbbr_cd());
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			throw new EventException(new ErrorHandler(de).getMessage());
		}
		return eventResponse;
	}

}
