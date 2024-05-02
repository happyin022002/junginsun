/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_016SC.java
*@FileTitle : Service Order 생성-Supplement
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-30 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.supplementsomanage;

import java.util.ArrayList;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.esd.trs.supplementsomanage.supplementsomanage.event.EsdTrs0016Event;
import com.hanjin.apps.alps.esd.trs.supplementsomanage.supplementsomanage.basic.SupplementSOManageBC;
import com.hanjin.apps.alps.esd.trs.supplementsomanage.supplementsomanage.basic.SupplementSOManageBCImpl;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author juhyun
 * @see ESD_TRS_016EventResponse,SupplementSOManageDBDAO 참조
 * @since J2EE 1.4
 */
public class SupplementSOManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * TRS 업무 시나리오 선행작업<br>
	 * SupplementSOManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account	= getSignOnUserAccount();
		} catch (Exception e) {
			log.error("ESD_TRS_0016SC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SupplementSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("ESD_TRS_0016SC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-TRS 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
			eventResponse = searchSupplementSOTargetList(e);
		}else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
			eventResponse = addSupplementSOList(e);	
		}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
			eventResponse = searchSupplementSOCorrectionList(e);
		}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
			eventResponse = removeSupplementSOCreatedList(e);
		}

		return eventResponse;
	}


	/**
	 * 조회 이벤트 처리<br>
	 * SupplementSOManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSupplementSOTargetList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0016Event event = (EsdTrs0016Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse 	eventResponse 	= null;
		
		try {
			SupplementSOManageBC command 	= new SupplementSOManageBCImpl();
			eventResponse					= command.searchSupplementSOTargetList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SupplementSOManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSupplementSOCorrectionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0016Event event = (EsdTrs0016Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			SupplementSOManageBC command = new SupplementSOManageBCImpl();
			eventResponse = command.searchSupplementSOCorrectionList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * SupplementSOManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse addSupplementSOList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0016Event 	event 			= (EsdTrs0016Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse 		eventResponse 	= null;
		ArrayList			arrayList		= null;
		
		try {
			begin();
			
			SupplementSOManageBC command = new SupplementSOManageBCImpl();
			arrayList 		= command.addSupplementSOList(event);
			if(arrayList != null)	eventResponse	= command.searchSOCreatedList(arrayList);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}finally{
			commit();
		}
		return eventResponse;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * SupplementSOManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeSupplementSOCreatedList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0016Event 	event 			= (EsdTrs0016Event)e;
		try {
			begin();			
			SupplementSOManageBC command = new SupplementSOManageBCImpl();
			return	command.removeSupplementSOCreatedList(event);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}finally{
			commit();
		}
	}		
}
