/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SppCommonSC.java
*@FileTitle : SPP Module Common Service
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2012.03.07 박연진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.sppcommon;

import java.util.List;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * ALPS-SppCommon Business Logic ServiceCommand - ALPS-SppCommon 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Nho Jung Yong
 * @see ...
 * @since J2EE 1.4
 */

public class SppCommonSC extends ServiceCommandSupport {
	// Login User Information
	//private SignOnUserAccount account = null;

	/**
	 * LseCommon system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	@Override
	public void doStart() {
		/*
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		*/
		log.debug("SppCommonSC 시작");
	}

	/**
	 * SppCommonSC system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	@Override
	public void doEnd() {
		log.debug("SppCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SppCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("SppFileUploadEvent")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = manageFileUploadService(e);
			}
		}
		return eventResponse;
	}

	/**
	 * 파일 업로드의 event에 대한 처리<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse manageFileUploadService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String strFileName = "";
			List<String> keys = (List<String>)e.getAttribute("KEYS");
			strFileName = keys.get(0);
			log.debug("strFileName : "+strFileName);
			eventResponse.setETCData("filename", strFileName);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12224",new String[]{"File"}).getMessage(), ex);
		}

		return eventResponse;
	}
}