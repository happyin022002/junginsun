/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CommonBC.java
*@FileTitle      : Common
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.06
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.06 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.common;

import com.hanjin.apps.alps.esm.sqm.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.sqm.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.sqm.common.event.CommonEvent;
import com.hanjin.apps.alps.esm.sqm.common.integration.CommonDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Common Business Logic ServiceCommand - ALPS-Common 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author SQM USER
 * @see CommonDBDAO
 * @since J2EE 1.6
 */

public class CommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	
	/**
	 * Common system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("CommonSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Common system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CommonSC 종료");
	}
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-Common system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("CommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getCommonCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getCommonCodeListForPlanning(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * 공통 : Trade 목록을 조회<br>
	 * IBMultiCombo / HTML Select 생성용<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getCommonCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonEvent event = (CommonEvent)e;
		CommonBC codeUtil = new CommonBCImpl();
		log.debug("event.getCommonVO().getCodeParam()"+event.getCommonVO().getCodeParam());
		
		String[] codeNameArr  = event.getCommonVO().getCodeName().split(",");
		String[] codeParamArr = event.getCommonVO().getCodeParam().split(",");
		log.debug("codeParamArr"+codeParamArr);
		String[] allFlagArr   = event.getCommonVO().getAllFlag().split(",");

		String array[][] = new String[codeNameArr.length][3];
		
		try{
			for ( int i=0; i<codeNameArr.length; i++ ) {
				array[i][0] = codeNameArr[i];
				array[i][1] = codeParamArr[i].equals("null")?"":codeParamArr[i];
				array[i][2] = allFlagArr[i].equals("null")?"":allFlagArr[i];
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 공통 : Planning콤보 목록을 조회<br>
	 * IBMultiCombo / HTML Select 생성용<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getCommonCodeListForPlanning(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonEvent event = (CommonEvent)e;
		CommonBC codeUtil = new CommonBCImpl();
		
		String[] codeNameArr  = event.getCommonVO().getCodeName().split(",");
		String[] codeParamArr = event.getCommonVO().getCodeParam().split(",");
		String[] allFlagArr   = event.getCommonVO().getAllFlag().split(",");

		String array[][] = new String[codeNameArr.length][3];
		
		try{
			for ( int i=0; i<codeNameArr.length; i++ ) {
				array[i][0] = codeNameArr[i];
				array[i][1] = codeParamArr[i].equals("null")?"":codeParamArr[i];
				array[i][2] = allFlagArr[i].equals("null")?"":allFlagArr[i];
			};
			
			eventResponse = codeUtil.getMakeCodeSelectListForPlanning(event.getConditionVO(),account, array);

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
}