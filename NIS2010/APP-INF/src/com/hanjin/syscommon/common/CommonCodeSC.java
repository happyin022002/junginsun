/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonCodeSC.java
*@FileTitle : 공통코드검색
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-08
*@LastModifier : HOESOO_JANG
*@LastVersion : 1.0
* 2006-09-08 HOESOO_JANG
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.common;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.code.basic.CommonCodePopBC;
import com.hanjin.syscommon.common.code.basic.CommonCodePopBCImpl;
import com.hanjin.syscommon.common.code.event.CommonCodePopEvent;

/**
 * NIS-System Common Business Logic ServiceCommand<br>
 * - NIS-System Common에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author HOESOO_JANG
 * @see CommonCodePopEventResponse,CommonCodePopDBDAO 참조
 * @since J2EE 1.4
 */
public class CommonCodeSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * System Common 업무 시나리오 선행작업<br>
	 * CommonCodePop업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("CommonCodeSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * System Common 업무 시나리오 마감작업<br>
	 * CommonCodePop업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("CommonCodeSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS-System Common 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		//log.debug("event : " + e);

		// SC가 하나의 이벤트만 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("CommonCodePopEvent")) {
			eventResponse = searchCommonCodePop(e);
		}

		return eventResponse;
	}



	/**
	 * 조회 이벤트 처리<br>
	 * CommonCodePop의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonCodePop(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CommonCodePopEvent event = (CommonCodePopEvent)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CommonCodePopBC command = new CommonCodePopBCImpl();
			eventResponse = command.searchCommonCodePop(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
//			de.printStackTrace();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


}
