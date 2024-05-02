/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DodCommonSC.java
*@FileTitle : Dod Common SC
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.18
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.11.18 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon;

import java.util.List;

import com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.basic.DodFileUploadBC;
import com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.basic.DodFileUploadBCImpl;
import com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.event.EesDod0015Event;
import com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.vo.FileUploadListVO;
import com.hanjin.apps.alps.ees.dod.dodcommon.validation.basic.DodValidationBC;
import com.hanjin.apps.alps.ees.dod.dodcommon.validation.basic.DodValidationBCImpl;
import com.hanjin.apps.alps.ees.dod.dodcommon.validation.event.EesDodValidEvent;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-DodCommon Business Logic ServiceCommand - ALPS-DodCommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jeong-Min, Park
 * @see DodCommonDBDAO
 * @since J2EE 1.6
 */

public class DodCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DodCommon system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("DodCommonSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DodCommon system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DodCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-DodDropOff system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesDodValidEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				// OFFICE CODE VALIDATION
				eventResponse = checkOfficeCode(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH02)) {		// CUSTOMER CODE VALIDATION
				eventResponse = checkCustomerCode(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH03)) {		// BKG_NO VALIDATION
				eventResponse = checkBkgNo(e);
        	} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH04)) {		// CNTR_NO VALIDATION
				eventResponse = checkCntrNo(e);
        	} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH05)) {		// RFA NO VALIDATION
				eventResponse = checkRfaNo(e);
        	} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH06)) {		// SC NO VALIDATION
				eventResponse = checkScNo(e);
        	} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH07)) {		// TP SZ VALIDATION
				eventResponse = checkTpSz(e);
        	} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH08)) {		// LOC_CD VALIDATION
				eventResponse = checkLocCd(e);
        	} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH09)) {		// YD_CD VALIDATION
				eventResponse = checkYdCd(e);
        	} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH10)) {		// AREA_CD(RCC, LCC, ECC, SCC) VALIDATION
				eventResponse = checkAreaCd(e);
        	} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH11)) {		// CNT_CD VALIDATION
				eventResponse = checkCntCd(e);
        	} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH12)) {		// 로그인한 사용자가 Invoicd Issue화면 접근권한이 있는지 확인한다.
        		eventResponse = checkIssueUser(e);
        	}
		} else if (e.getEventName().equalsIgnoreCase("EesDod0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				// FileUploadList
				eventResponse = searchDodFileUploadList(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDodFileUpload(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * EES_DOD_VALID : [SEARCH01]<br>
	 * [OFFICE CODE]의 적합여부를 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkOfficeCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDodValidEvent event = (EesDodValidEvent)e;
		DodValidationBC command = new DodValidationBCImpl();

		try{
			// 면제 대상을 조회하고 DOD_DRP_OFF_CHG 테이블에 저장합니다.
			int count = command.checkOfficeCode(event.getDodValidationINVO());
			
			eventResponse.setETCData("count",String.valueOf(count));
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	/**
	 * EES_DOD_VALID : [SEARCH02]<br>
	 * [CUSTOMER CODE]의 적합여부를 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCustomerCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDodValidEvent event = (EesDodValidEvent)e;
		DodValidationBC command = new DodValidationBCImpl();

		try{
			int count = command.checkCustomer(event.getDodValidationINVO());
			
			eventResponse.setETCData("count",String.valueOf(count));
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	/**
	 * EES_DOD_VALID : [SEARCH03]<br>
	 * [BKG NO]의 적합여부를 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkBkgNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDodValidEvent event = (EesDodValidEvent)e;
		DodValidationBC command = new DodValidationBCImpl();

		try{
			int count = command.checkBkgNo(event.getDodValidationINVO());
			
			eventResponse.setETCData("count",String.valueOf(count));
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	/**
	 * EES_DOD_VALID : [SEARCH04]<br>
	 * [CNTR NO]의 적합여부를 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCntrNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDodValidEvent event = (EesDodValidEvent)e;
		DodValidationBC command = new DodValidationBCImpl();

		try{
			int count = command.checkCntrNo(event.getDodValidationINVO());
			
			eventResponse.setETCData("count",String.valueOf(count));
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_VALID : [SEARCH05]<br>
	 * [RFA NO]의 적합여부를 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRfaNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDodValidEvent event = (EesDodValidEvent)e;
		DodValidationBC command = new DodValidationBCImpl();

		try{
			int count = command.checkRfaNo(event.getDodValidationINVO());
			
			eventResponse.setETCData("count",String.valueOf(count));
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_VALID : [SEARCH06]<br>
	 * [SC NO]의 적합여부를 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkScNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDodValidEvent event = (EesDodValidEvent)e;
		DodValidationBC command = new DodValidationBCImpl();

		try{
			int count = command.checkScNo(event.getDodValidationINVO());
			
			eventResponse.setETCData("count",String.valueOf(count));
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_VALID : [SEARCH07]<br>
	 * [TP/SZ]의 적합여부를 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkTpSz(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDodValidEvent event = (EesDodValidEvent)e;
		DodValidationBC command = new DodValidationBCImpl();

		try{
			int count = command.checkTpSz(event.getDodValidationINVO());
			
			eventResponse.setETCData("count",String.valueOf(count));
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_VALID : [SEARCH08]<br>
	 * [LOC CD]의 적합여부를 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDodValidEvent event = (EesDodValidEvent)e;
		DodValidationBC command = new DodValidationBCImpl();

		try{
			int count = command.checkLocCd(event.getDodValidationINVO());
			
			eventResponse.setETCData("count",String.valueOf(count));
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_VALID : [SEARCH09]<br>
	 * [YD CD]의 적합여부를 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkYdCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDodValidEvent event = (EesDodValidEvent)e;
		DodValidationBC command = new DodValidationBCImpl();

		try{
			int count = command.checkYdCd(event.getDodValidationINVO());
			
			eventResponse.setETCData("count",String.valueOf(count));
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_VALID : [SEARCH10]<br>
	 * [AREA CD : RCC, LCC, ECC, SCC]의 적합여부를 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkAreaCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDodValidEvent event = (EesDodValidEvent)e;
		DodValidationBC command = new DodValidationBCImpl();

		try{
			int count = command.checkAreaCd(event.getDodValidationINVO());
			
			eventResponse.setETCData("count",String.valueOf(count));
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_VALID : [SEARCH11]<br>
	 * [CNT_CD]의 적합여부를 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCntCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDodValidEvent event = (EesDodValidEvent)e;
		DodValidationBC command = new DodValidationBCImpl();

		try{
			int count = command.checkCntCd(event.getDodValidationINVO());
			
			eventResponse.setETCData("count",String.valueOf(count));
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_VALID : [SEARCH12]<br>
	 * [Login한 사용자]의 AR Invoice화면 접근 권한여부를 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkIssueUser(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDodValidEvent event = (EesDodValidEvent)e;
		DodValidationBC command = new DodValidationBCImpl();

		try{
			int count = command.checkIssueUser(event.getDodValidationINVO());
			
			eventResponse.setETCData("count",String.valueOf(count));
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0015 : [SEARCH01]<br>
	 * [DOD Remark]의 File Attach [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDodFileUploadList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			
			DodFileUploadBC command = new DodFileUploadBCImpl();
			EesDod0015Event event = (EesDod0015Event)e;
			
			String bkgNo = event.getBkgNo();
			String cntrNo = event.getCntrNo();
			String drpOffChgSeq = event.getDrpOffChgSeq();
			String drpOffChgTrfSeq = event.getDrpOffChgTrfSeq();
			String caller = event.getCaller();
			String atchFileLnkId = event.getAtchFileLnkId();

			List<FileUploadListVO> list = command.searchDodFileUploadList(bkgNo, cntrNo, drpOffChgSeq, drpOffChgTrfSeq, caller, atchFileLnkId);
			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0015 : [MULTI]<br>
	 * [DOD Remark]의 File Attach [입력, 수정, 삭제]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDodFileUpload(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			
			begin();
			
			DodFileUploadBC command = new DodFileUploadBCImpl();
			EesDod0015Event event = (EesDod0015Event)e;
			
			FileUploadListVO[] fileUploadListVOs = event.getFileUploadListVOs();
			
			String bkgNo = event.getBkgNo();
			String cntrNo = event.getCntrNo();
			String drpOffChgSeq = event.getDrpOffChgSeq();
			String drpOffChgTrfSeq = event.getDrpOffChgTrfSeq();
			String caller = event.getCaller();
			String tmpAtchFileLnkId = event.getAtchFileLnkId(); // DOD File Popup에서 넘겨준 링크 아이디
			
			String atchFileLnkId = command.manageDodFileUpload(fileUploadListVOs, bkgNo, cntrNo, drpOffChgSeq, drpOffChgTrfSeq, caller, tmpAtchFileLnkId, account);
			
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			eventResponse.setETCData("ATCH_FILE_LNK_ID", atchFileLnkId);
			eventResponse.setETCData("ERROR_YN", "N");
			
			commit();
			
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	
		return eventResponse;
	}
	
}