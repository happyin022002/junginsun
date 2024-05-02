/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBFileUploadSC.java
*@FileTitle : 3자구상 파일업로드 공통팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-02
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2009-08-20 O Wan-Ki  1.0 최초 생성
* 2009-12-02 Sun, CHOI 1.1 ALPS Migration
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.fileupload;

import java.util.HashMap;

import com.clt.apps.opus.esd.tpb.common.fileupload.basic.TPBFileUploadBC;
import com.clt.apps.opus.esd.tpb.common.fileupload.basic.TPBFileUploadBCImpl;
import com.clt.apps.opus.esd.tpb.common.fileupload.event.TPBFileUploadEvent;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS-3rd Party Billing Business Logic ServiceCommand<br>
 * - NIS-3rd Party Billing에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author Sun, CHOI
 * @see TPBFileUploadEventResponse,commonDBDAO 참조
 * @since J2EE 1.4
 */
public class TPBFileUploadSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * 3rd Party Billing 업무 시나리오 선행작업<br>
	 * common업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("TPBFileUploadSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * 3rd Party Billing 업무 시나리오 마감작업<br>
	 * common업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("TPBFileUploadSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS-3rd Party Billing 업무에서 발생하는 모든 이벤트의 분기처리<br>
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
		if (e.getEventName().equalsIgnoreCase("TPBFileUploadEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUploadFileInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createUploadFileInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeUploadFiles(e);
			}
		}
		return eventResponse;
	}


	/**
	 * 해당 fileNo의 업로드된 파일정보 조회 이벤트 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUploadFileInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TPBFileUploadEvent event = (TPBFileUploadEvent)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			TPBFileUploadBC command = new TPBFileUploadBCImpl();
			eventResponse = command.searchUploadFileInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * FileUpload 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse createUploadFileInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// TPBFileUploadEvent event = (TPBFileUploadEvent)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
//		EventResponse eventResponse = null;
		String fileNo = "";
		HashMap hm = new HashMap();

		try {
			begin();
			TPBFileUploadBC command = new TPBFileUploadBCImpl();
			fileNo = command.createUploadFileInfo(e);
			hm.put("fileNo", fileNo);
			((TPBFileUploadEvent)e).setEventParams(hm);	
			commit();
			
			command.selectUploadFileCnt(e);
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return searchUploadFileInfo(e); 
	}

	/**
	 * 업로드된 파일들 삭제 처리(물리 디스크, 데이터베이스)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse removeUploadFiles(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// TPBFileUploadEvent event = (TPBFileUploadEvent)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			begin();
			TPBFileUploadBC command = new TPBFileUploadBCImpl();
			eventResponse = command.removeUploadFiles(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse; 
	}
	
}
