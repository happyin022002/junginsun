/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OtherSOManageSCSC.java
*@FileTitle : Other SO 생성화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 2009-10-01 kimjin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.othersomanage;

import java.util.ArrayList;

import com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.basic.OtherSOManageBC;
import com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.basic.OtherSOManageBCImpl;
import com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.event.EsdTrs0018Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-OtherSOManage Business Logic ServiceCommand<br>
 * - ESD-OtherSOManage에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author kimjin
 * @see ESD_TRS_018EventResponse,OtherSOManageDBDAO 참조
 * @since J2EE 1.6
 */
public class OtherSOManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * OtherSOManage 업무 시나리오 선행작업<br>
	 * OtherSOManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("OtherSOManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * OtherSOManage 업무 시나리오 마감작업<br>
	 * OtherSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("OtherSOManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-OtherSOManage 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		//log.debug("event : " + e);

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = addOtherSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyOtherSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeOtherSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContainerEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchChassisEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGensetEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchContainerEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchChassisEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchGensetEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchOtherSOCorrectionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchContainerEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchChassisEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchGensetEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchRateApplyList(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateApplyList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0018Event event = (EsdTrs0018Event)e;
		
		try {
			OtherSOManageBC command = new OtherSOManageBCImpl();
			eventResponse = command.searchRateApplyList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOtherSOCorrectionList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0018Event event = (EsdTrs0018Event)e;
		
		try {
			OtherSOManageBC command = new OtherSOManageBCImpl();
			eventResponse = command.searchOtherSOCorrectionList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}



	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerEqNo(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0018Event event = (EsdTrs0018Event)e;
		
		try {
			OtherSOManageBC command = new OtherSOManageBCImpl();
			eventResponse = command.searchContainerEqNo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChassisEqNo(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0018Event event = (EsdTrs0018Event)e;
		
		try {
			OtherSOManageBC command = new OtherSOManageBCImpl();
			eventResponse = command.searchChassisEqNo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGensetEqNo(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0018Event event = (EsdTrs0018Event)e;
		
		try {
			OtherSOManageBC command = new OtherSOManageBCImpl();
			eventResponse = command.searchGensetEqNo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 추가 이벤트 처리<br>
	 * OtherSOManage의 event에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse addOtherSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0018Event event = (EsdTrs0018Event)e;
		EventResponse eventResponse = null;	
		try {
			begin();
			OtherSOManageBC command = new OtherSOManageBCImpl();
			ArrayList returnV 		= command.addOtherSOManage(event);
			eventResponse 			= command.searchTrspSvcOrdList(returnV);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 수정 이벤트 처리<br>
	 * OtherSOManage의 event에 대한 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOtherSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0018Event event = (EsdTrs0018Event)e;

		try {
			begin();
			OtherSOManageBC command = new OtherSOManageBCImpl();
			command.modifyOtherSOManage(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return null;
	}

	/**
	 * 삭제 이벤트 처리<br>
	 * OtherSOManage의 event에 대한 삭제 이벤트 처리<br>
	 * 
	 * @param e Event4
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOtherSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0018Event event = (EsdTrs0018Event)e;

		try {
			begin();
			OtherSOManageBC command = new OtherSOManageBCImpl();
			command.removeOtherSOManage(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return null;
	}
}