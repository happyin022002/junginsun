/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : TrsAdvanceAuditSC.java
*@FileTitle : Equipment Auto Audit 
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : 
*@LastVersion : 1.0
* 2015-04-13 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.basic.TrsAdvanceAuditBC;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.basic.TrsAdvanceAuditBCImpl;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.event.EsdEas0340Event;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.event.EsdEas0342Event;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudCrteCondVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudCrteListVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudDtlListVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * TransportmanageSC PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author 최종혁
 * @see ServiceCommandSupport 참조
 * @since J2EE 1.4
 */
public class TrsAdvanceAuditSC extends ServiceCommandSupport{
	
	// Login User Information
	private SignOnUserAccount account = null;
	
	/**
	 * EAS 업무 시나리오 선행작업<br>
	 * Trsadvanceaudit업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch(Exception e) {
			log.error("TrsAdvanceAudit 선행 작업 시 오류 " + e.toString(), e);
		}
	}
	
	/**
	 * EAS 업무 시나리오 마감작업<br>
	 * Trsadvanceaudit업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("TrsAdvanceAudit 종료");
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Trsadvanceaudit event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("EsdEas0342Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTrsCrteList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
		    	 eventResponse = searchAddOffice(e);
		    }else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = multiTrsCrte(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeTrsCrte(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdEas0340Event")) {
		     if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTrsPreAudList(e);
			 }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
					eventResponse = searchTrsPreAudDtlList(e);
			 }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = confirmTrsPreAudit(e);
			 }else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
					eventResponse = saveReBatchTarget(e);
			 }
	}
		return eventResponse;
	}	
		
	/**
	 * EsdEas0342Event  <br>
	 * TRS Pre-Audit Criterion setting 을 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	public EventResponse searchTrsCrteList(Event e) throws EventException {
		try {
			EsdEas0342Event event = (EsdEas0342Event)e;
			TrsAdvanceAuditBC command = new TrsAdvanceAuditBCImpl();
		
			List<TrsPreAudCrteListVO> list  = command.searchTrsCrteList(event.getTrsPreAudCrteCondVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
     * ESD_EAS_0342 - Save<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse multiTrsCrte(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0342Event event = (EsdEas0342Event)e;
		TrsAdvanceAuditBC command = new TrsAdvanceAuditBCImpl();		
		try {
			begin();
			command.multiTrsCrte(event.getTrsPreAudCrteListVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
     * ESD_EAS_0342 - Delete<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse removeTrsCrte(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0342Event event = (EsdEas0342Event)e;
		TrsAdvanceAuditBC command = new TrsAdvanceAuditBCImpl();		
		try {
			begin();
			command.removeTrsCrte(event.getTrsPreAudCrteCondVO());
			eventResponse.setUserMessage(new ErrorHandler("COM12196", new String[]{"Data"}).getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * EsdEas0340Event  <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	public EventResponse searchTrsPreAudList(Event e) throws EventException {
		try {
			EsdEas0340Event event = (EsdEas0340Event)e;
			TrsAdvanceAuditBC command = new TrsAdvanceAuditBCImpl();
			List<TrsPreAudListVO> list  = command.searchTrsPreAudList(event.getTrsPreAudListVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * EsdEas0340Event  <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	public EventResponse searchAddOffice(Event e) throws EventException {
		try {
			EsdEas0342Event event = (EsdEas0342Event)e;
			TrsAdvanceAuditBC command = new TrsAdvanceAuditBCImpl();
			List<TrsPreAudCrteCondVO> list  = command.searchAddOffice(event.getTrsPreAudCrteCondVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	

	
	/**
	 * EsdEas0340Event  <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	public EventResponse searchTrsPreAudDtlList(Event e) throws EventException {
		try {
			EsdEas0340Event event = (EsdEas0340Event)e;
			TrsAdvanceAuditBC command = new TrsAdvanceAuditBCImpl();
			List<TrsPreAudDtlListVO> list  = command.searchTrsPreAudDtlList(event.getTrsPreAudDtlListVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * EsdEas0340Event  <br>
	 * confirm 기능
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse confirmTrsPreAudit(Event e) throws EventException {
		EsdEas0340Event event = (EsdEas0340Event)e;
		TrsAdvanceAuditBC command = new TrsAdvanceAuditBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			TrsPreAudListVO[] voList  = event.getTrsPreAudListVOs();
			for (int i=0; i<voList.length; i++) {
				voList[i].setCreUsrId(account.getUsr_id());
				voList[i].setUpdUsrId(account.getUsr_id());
				voList[i].setCreOfcCd(account.getOfc_cd());
			}
			command.confirmTrsPreAudit(voList);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"confirmTrsPreAudit"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0340Event  <br>
	 * 실시간 배치 대상을 저장한다.
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */		
	private EventResponse saveReBatchTarget(Event e) throws EventException {
		EsdEas0340Event event = (EsdEas0340Event)e;
		TrsAdvanceAuditBC command = new TrsAdvanceAuditBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			TrsPreAudListVO[] voList  = event.getTrsPreAudListVOs();
			for (int i=0; i<voList.length; i++) {
				voList[i].setCreUsrId(account.getUsr_id());
				voList[i].setUpdUsrId(account.getUsr_id());
				voList[i].setCreOfcCd(account.getOfc_cd());
			}
			command.saveReBatchTarget(voList);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
			return eventResponse;
			} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"saveReBatchTarget"}).getMessage(), ex);
		}
	}
	
}