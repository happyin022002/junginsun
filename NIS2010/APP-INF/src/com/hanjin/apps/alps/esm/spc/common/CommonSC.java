/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonSC.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-11
*@LastModifier : 김원섭
*@LastVersion : 1.0
* 2006-10-11 김원섭
* 1.0 최초 생성
* 2011.04.11 김종준 [CHM-201110033-01] ALPS/SPC의 TS booking status 기능보완 요청  - SEARCHLIST02 공통 모듈 적용 
=========================================================*/

package com.hanjin.apps.alps.esm.spc.common;

import com.hanjin.apps.alps.esm.spc.common.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.spc.common.common.basic.CommonBCImpl;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-Common Business Logic ServiceCommand
 * - alps-Common에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author 김원섭
 * @see ComboxEventResponse,CommonDBDAO
 * @since J2EE 1.4
 */

public class CommonSC extends ServiceCommandSupport {

	SignOnUserAccount account = null;

	/**
	 * Common 업무 시나리오 선행작업<br>
	 * Common업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("CommonSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * Common 업무 시나리오 마감작업<br>
	 * Common업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * alps-Common 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsmSpcCodEvent")) {
			if (   e.getFormCommand().isCommand(FormCommand.SEARCHLIST01 )
				|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchCommonCodeList(e);
			}
		}
		return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @param boolean isRepTrade
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSvcLaneComboList(String del, boolean isRepTrade) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchSvcLaneComboList(del, new Boolean(isRepTrade));
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @param boolean isRepTrade
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTradeComboList(String del, boolean isRepTrade) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchTradeComboList(del, new Boolean(isRepTrade));
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @param boolean isRepTrade
	 * @param boolean isAll
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubTradeComboList(String del, boolean isRepTrade, boolean isAll)
			throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchSubTradeComboList(del, new Boolean(isRepTrade),
					new Boolean(isAll));
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRLaneComboList(String del) throws EventException {
		return searchRLaneComboList(del, new Boolean(false));
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param String del
	 * @param Boolean ipc
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRLaneComboList(String del, Boolean ipc) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchRLaneComboList(del, ipc);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param method
	 * @param del
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCodeList(String method, String del) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchCodeList(method, del);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param code
	 * @param del
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommonCodeList(String code, String del) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchCommonCodeList(code, del);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonCodeList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchCommonCodeList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param del
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRHQComboList(String del) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchRHQComboList(del);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param module
	 * @param rhq
	 * @param del
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAQComboList(String module, String rhq, String del)
			throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchAQComboList(module, rhq, del);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param ofc
	 * @param del
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTargetGroupComboList(String ofc, String del) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchTargetGroupComboList(ofc, del);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param module
	 * @param rhq
	 * @param del
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRgnOfcComboList(String module, String rhq, String del)
			throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchRgnOfcComboList(module, rhq, del);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param del
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchKAMerComboList(String del) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchKAMerComboList(del);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

}