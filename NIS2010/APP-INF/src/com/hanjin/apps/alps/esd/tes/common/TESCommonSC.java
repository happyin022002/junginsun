/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESCommonSC.java
*@FileTitle : TES Common 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-31 byungheeyoo
* 1.0 최초 생성
* 2011.08.08 윤태승 [CHM-201111829-1] Split 12-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
* 2011.08.08 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
* 2015.01.20 김영신 [CHM-201430578]TMNL Invoice Manual 입력시 Vol validation 추가 
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common;
 
import com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBC;
import com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.common.tescommon.event.TESCommonEvent;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.event.EsdTes9310Event;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.event.TESInvoiceCommonEvent;
import com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBC;
import com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ENIS-ESD Business Logic ServiceCommand<br>
 * - ENIS-ESD에 대한 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author byungheeyoo
 * @see TESCommonEventResponse,TESCommonDBDAO 참조
 * @since J2EE 1.4
 */
public class TESCommonSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * ESD 업무 시나리오 선행작업<br>
	 * TESCommon업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("TESCommonSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * TESCommon업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("TESCommonSC 종료");
	}


	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ENIS-ESD 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		log.debug("\n\n ### [TESCommonSC] ~~~~~~"+JSPUtil.getNull(e.getEventName())+"~~~~\n");
		log.debug("\n ### [TESCommonSC] f_cmd:"+e.getFormCommand().getCommand()+"~~~~\n");
		
		EventResponse eventResponse = null;
		
		/**
		 * TES 전체 공통
		 */
		if (e.getEventName().equalsIgnoreCase("TESCommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getEDIOriginInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCostOFC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCurrencyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = validateCostOFC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = validateYardCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = getDBdate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = validateVndrCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchYdCostCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = validateYardCodeNsearchYdCostCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchTESCostCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchCntrTPCDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchCntrSZCDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchCntrTPSZCDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchLaneList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchAutoTESTmlSoCostCDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchManualTESTmlSoCostCDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchTESInvoiceCommonCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchAgreementCostCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchLaneCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = validateYardCode2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				eventResponse = searchInvNoDupChk(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
				eventResponse = searchCostCodeChkFlg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH23)) {
				eventResponse = searchClptIndSeq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH24)) {
				eventResponse = searchCallingYardSeqChk(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH25)) {		
				eventResponse = getUserOfcCdChk(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH26)) {
				eventResponse = getIndGstRto(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH27)) {
				eventResponse = validateSacCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = validateVndrCode2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = validateCostOFC2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = validateInvOFC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = getNodeCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = putEDIOriginInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = searchMDMAccount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) {
				eventResponse = searchAuthOfcCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST08)) {
				eventResponse = new GeneralEventResponse();
				eventResponse.setETCData("successFlag","success");
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST09)) {
				eventResponse = searchRhqOfcCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = searchCntrBkgNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {
				eventResponse = searchCntrBkgNoOff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)) {
				eventResponse = checkUsdConvert(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {
				eventResponse = searchTESInvCostCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)) {
				eventResponse = searchCallYdIndSeqList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST15)) {
				eventResponse = searchSubOfficeList(e);
			}
		/**
		 * TES INVOICE 공통
		 */
		} else if (e.getEventName().equalsIgnoreCase("TESInvoiceCommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getAgmtCurrCD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getN3ptyBilCSCD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = isValidErrInvNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = getAgmtSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = getWHTmode(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
//				eventResponse = validateEDIInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {		
				// TPB BillingCase Code
				eventResponse = searchBillingCaseCodeByTES(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {		//MGSet
				eventResponse = getMgstNos(e);
			}
			
		} else if (e.getEventName().equalsIgnoreCase("EsdTes9310Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchOldInvCsrData(e);
			} 
//			[CHM-201111829] Split 12-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
//			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//					eventResponse = searchOldInvCsrChk(e);
//			}
			
		}
		
		return eventResponse;
	}
	
	/**
	 * TESCommon : [이벤트]<br>
	 * [Container Booking No]를 [Select]합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrBkgNo(Event e) throws EventException {
		log.debug("\n\n [TesCommonSC][searchCntrBkgNo] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;
		TESCommonBC command = null;

		try{
			command = new TESCommonBCImpl();
			eventResponse = command.searchCntrBkgNo(event);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * TESCommon : [이벤트]<br>
	 * [Container Booking No]를 [Select]합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrBkgNoOff(Event e) throws EventException {
		log.debug("\n\n [TesCommonSC][searchCntrBkgNoOff] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;
		TESCommonBC command = null;

		try{
			command = new TESCommonBCImpl();
			eventResponse = command.searchCntrBkgNoOff(event);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * 원본 EDI invoice file 정보 구하기
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse getEDIOriginInvoice(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getEDIOriginInvoice] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;
		TESCommonBC command = null;
		
		try {
			command = new TESCommonBCImpl();
			eventResponse = command.getEDIOriginInvoice(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EDI 원본 invoice PDF file 정보를 DB에 입력
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse putEDIOriginInvoice(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][putEDIOriginInvoice] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;
		TESCommonBC command = null;
		
		try {
			command = new TESCommonBCImpl();
			
			begin();
			eventResponse = command.putEDIOriginInvoice(event);
			commit();			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ofc_cd에 따라 Withholding tax입력 mode를 가져온다.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getWHTmode(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getWHTmode] \n");
		TESInvoiceCommonEvent event = (TESInvoiceCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESInvoiceCommonBC command = new TESInvoiceCommonBCImpl();
			eventResponse = command.getWHTmode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * (calc 계산시) agreement의 currency code를 가져온다.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAgmtCurrCD(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getAgmtCurrCD] \n");
		TESInvoiceCommonEvent	event			= (TESInvoiceCommonEvent)e;
		EventResponse			eventResponse	= null;

		try {
			TESInvoiceCommonBC	command	= new TESInvoiceCommonBCImpl();
			eventResponse	= command.getAgmtCurrCD(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * (calc 계산시) agreement의 status를 가져온다.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getAgmtSts(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getAgmtSts] \n");
		TESInvoiceCommonEvent event = (TESInvoiceCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESInvoiceCommonBC command = new TESInvoiceCommonBCImpl();
			eventResponse = command.getAgmtSts(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * (TPB 입력시) COST CODE의 N3PTY_BIL_CS_CD를 가져온다.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getN3ptyBilCSCD(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getN3ptyBilCSCD] \n");
		TESInvoiceCommonEvent event = (TESInvoiceCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESInvoiceCommonBC command = new TESInvoiceCommonBCImpl();
			eventResponse = command.getN3ptyBilCSCD(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse isValidErrInvNo(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][isValidErrInvNo] \n");
		TESInvoiceCommonEvent event = (TESInvoiceCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESInvoiceCommonBC command = new TESInvoiceCommonBCImpl();
			eventResponse = command.isValidErrInvNo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostOFC(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchCostOFC] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCostOFC(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrencyList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchCurrencyList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCurrencyList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateCostOFC(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateCostOFC] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.validateCostOFC(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateCostOFC2(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateCostOFC2] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.validateCostOFC2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateInvOFC(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateInvOFC] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.validateInvOFC(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getNodeCode(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateInvOFC] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.getNodeCode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateYardCode(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateYardCode] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.validateYardCode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateYardCode2(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateYardCode2] \n");
		TESCommonEvent			event			= (TESCommonEvent)e;
		GeneralEventResponse	eventResponse	= null;

		try {
			TESCommonBC		command	= new TESCommonBCImpl();
			eventResponse = (GeneralEventResponse)command.validateYardCode2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getDBdate(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getDBdate] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.getDBdate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateVndrCode(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateVndrCode] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.validateVndrCode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateVndrCode2(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateVndrCode2] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.validateVndrCode2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYdCostCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchYdCostCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchYdCostCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateYardCodeNsearchYdCostCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][validateYardCodeNsearchYdCostCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.validateYardCodeNsearchYdCostCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTESCostCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchTESCostCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchTESCostCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrTPCDList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchCntrTPCDList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCntrTPCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrSZCDList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchCntrSZCDList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCntrSZCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrTPSZCDList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchCntrTPSZCDList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCntrTPSZCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchLaneList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchLaneList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAutoTESTmlSoCostCDList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchAutoTESTmlSoCostCDList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchAutoTESTmlSoCostCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManualTESTmlSoCostCDList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchManualTESTmlSoCostCDList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchManualTESTmlSoCostCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTESInvoiceCommonCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchTESInvoiceCommonCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchTESInvoiceCommonCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementCostCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchAgreementCostCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchAgreementCostCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchLaneCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchLaneCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * EDI Invoice Validation
	 * @param tml_edi_so_ofc_cty_cd
	 * @param tml_edi_so_seq
	 * @exception EventException
	 */
//	private EventResponse validateEDIInvoice(Event e) throws EventException {
//		
//		log.debug("\n\n SC.validateEDIInvoice \n");
//
//		//
//		//
//		
//		com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0013Event event
//		 = (com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0013Event)e;
//		EventResponse eventResponse = null;
//
//		try {
//
//			TESInvoiceCommonBC command = new TESInvoiceCommonBCImpl();
//			command.validateEDIInvoice(event.getEventParams().get("tml_edi_so_ofc_cty_cd").toString(), event.getEventParams().get("tml_edi_so_seq").toString());
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}
	
	
	/**
	 * Third Party BillingCase Code 조회.
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBillingCaseCodeByTES(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchBillingCaseCodeByTES] \n");
		CommonCodeBC			command			= new CommonCodeBCImpl();
		TESInvoiceCommonEvent	event 			= (TESInvoiceCommonEvent)e;
		EventResponse			eventResponse	= null;

		try {
			
			eventResponse	= command.searchBillingCaseCodeByTES();
			eventResponse.setETCData("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}

	
	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse getMgstNos(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getMgstNos] \n");
		
		TESInvoiceCommonEvent event = (TESInvoiceCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESInvoiceCommonBC command = new TESInvoiceCommonBCImpl();
			eventResponse = command.getMgstNos(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}

	/**
	 * MDM_Account 조회
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMDMAccount(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchMDMAccount] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;
		TESCommonBC command = null;
		
		try {
			command = new TESCommonBCImpl();
			
			begin();
			eventResponse = command.searchMDMAccount(event);
			commit();			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * AGMT, INV OFC 별 권한 조회
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthOfcCd(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchAuthOfcCd] ===========>\n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;
		TESCommonBC command = null;
		
		try {
			command = new TESCommonBCImpl();
			eventResponse = command.searchAuthOfcCd(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Invoice나 CSR이 처음 만들어진 후 3개월이 경과한 건들을 조회
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOldInvCsrData(Event e) throws EventException {
		log.debug("\n\n [TESInvoiceCommonBC][searchOldInvCsrData] ===========>\n");
		EsdTes9310Event event = (EsdTes9310Event)e;
		EventResponse eventResponse = null;
		TESInvoiceCommonBC command = null;
		
		try {
			command = new TESInvoiceCommonBCImpl();
			eventResponse = command.searchOldInvCsrData(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Invoice나 CSR이 처음 만들어진 후 3개월이 경과한 건들을 조회
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
//  [CHM-201111829] Split 12-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
//	private EventResponse searchOldInvCsrChk(Event e) throws EventException {
//		
//		EsdTes9310Event event = (EsdTes9310Event)e;
//		EventResponse eventResponse = null;
//		TESInvoiceCommonBC command = null;
//		String retVal = "";
//
//		TesTmlSoHdrVO vo = event.getTesTmlSoHdrVO();
//		try {
//			vo = event.getTesTmlSoHdrVO();
//			command = new TESInvoiceCommonBCImpl();
//			//eventResponse = command.searchOldInvCsrChk(event);
//			retVal = command.searchOldInvCsrChk(vo.getInvOfcCd());
//			
//			eventResponse.setETCData("isPendingCd", retVal);
//			
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}
	
	/**
	 * Regional Head Office 조회
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRhqOfcCd(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchRhqOfcCd] ===========>\n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;
		TESCommonBC command = null;
		
		try {
			command = new TESCommonBCImpl();
			eventResponse = command.searchRhqOfcCd(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 해당 월 환율 적용하여 USD Amt를 구한다.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkUsdConvert(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][checkUsdConvert] ===========>\n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;
		TESCommonBC command = null;
		try {
			command = new TESCommonBCImpl();
			eventResponse = command.checkUsdConvert(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvNoDupChk(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchInvNoDupChk] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchInvNoDupChk(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Manual Input시 mandatory 여부 조회
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCodeChkFlg(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchCostCodeChkFlg] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCostCodeChkFlg(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * TES Invoice Cost Code List Inquiry
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTESInvCostCodeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchTESInvCostCodeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchTESInvCostCodeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * CALLING YARD INDICATOR SEQUENCE List
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCallYdIndSeqList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchCallYdIndSeqList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCallYdIndSeqList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * CALLING PORT INDICATOR SEQUENCE
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchClptIndSeq(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchClptIndSeq] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchClptIndSeq(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	
	/**
	 * CALLING YARD SEQUENCE check
	 * doubling calling 이면 Y, 아니면 N 
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCallingYardSeqChk(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchCallingYardSeqChk] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchCallingYardSeqChk(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Sub Office List
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSubOfficeList(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][searchSubOfficeList] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.searchSubOfficeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * login user의 default office와 login한 office가 같은지 확인한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse getUserOfcCdChk(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getUserOfcCdChk] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();
			eventResponse = command.getUserOfcCdChk(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * 
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse getIndGstRto(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getIndGstRto] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();			
			eventResponse = command.getIndGstRto(event); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse validateSacCd(Event e) throws EventException {
		log.debug("\n\n [TESCommonSC][getIndGstRto] \n");
		TESCommonEvent event = (TESCommonEvent)e;
		EventResponse eventResponse = null;

		try {
			TESCommonBC command = new TESCommonBCImpl();			
			eventResponse = command.validateSacCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}
