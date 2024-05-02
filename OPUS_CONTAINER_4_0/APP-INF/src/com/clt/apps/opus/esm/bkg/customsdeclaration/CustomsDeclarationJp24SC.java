/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : CustomsDeclarationJp24SC.java
 *@FileTitle : CustomsDeclarationJp24SC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.18
 *@LastModifier :
 *@LastVersion : 1.0
 * 2013.10.18
 * 1.0 Creation
=======================================================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.basic.Jp24CustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.basic.Jp24CustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event.BatchForEtdAtdTransmitEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event.BatchForNoResponseEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event.EdiBkgJp24sysAmrAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event.EdiBkgJp24sysAtdAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event.EsmBkg1503Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event.EsmBkg1504Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event.EsmBkg1505Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event.EsmBkg1506Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event.UBizComOpusBkgJpn24Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.DepartureTimeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.basic.Jp24ManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.basic.Jp24ManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1501Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1502Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1526Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.BllSprtCmbnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.GetMdmCustomerVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclarationJp24 Business Logic ServiceCommand<br>
 * - OPUS-CustomsDeclarationJp24에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Sang-Soo
 * @see
 * @since J2EE 1.6
 */
public class CustomsDeclarationJp24SC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationJp24 system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("CustomsDeclarationJp24SC 시작");

		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch(Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CustomsDeclarationJp24 system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationJp24SC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-CustomsDeclarationJp24 system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmBkg1501Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {             // Search Sheet1 Header List(RETRIEVE)
				eventResponse = searchCargoInfoHeader(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {    // Start Back End Job(RETRIEVE)
				eventResponse = startBackEndJobSearchCargoInfoDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {    // Get status of Back End Job(SEARCH01/MULTI01/COMMAND01에서 공통으로 호출)
				eventResponse = getBackEndJobStatus(e.getAttribute("backEndJob_Key").toString());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {    // Result return(RETRIEVE)
				eventResponse = resultBackEndJobSearchCargoInfoDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {     // Start Back End Job(SAVE)
				eventResponse = startBackEndJobManageCargoInfoDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {     // Result return(SAVE)
				eventResponse = resultBackEndJobManageCargoInfoDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {   // TRANSMIT
				eventResponse = transmitCargoInfoDetail(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1502Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBLInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getMdmCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageBLInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = transmitBLInquiry(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1503Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDepartureTime(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = transmitDepartureTimeByUI(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("BatchForEtdAtdTransmitEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.TRANS)) {
				eventResponse = transmitDepartureTimeByBatch(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1504Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchJmsReport(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("UBizComOpusBkgJpn24Event")) {
			if (e.getFormCommand().isCommand(FormCommand.TRANS)) {
				eventResponse = receiveEDIForJapan24HR(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1505Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchErrorReport(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1506Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSendFlatFile(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("BatchForNoResponseEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.TRANS)) {
				eventResponse = sendEmailForNoResponse(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EdiBkgJp24sysAmrAckEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.TRANS)) {
				eventResponse = receiveEDIForJp24SysAmr(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EdiBkgJp24sysAtdAckEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.TRANS)) {
				eventResponse = receiveEDIForJp24SysAtd(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1526Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBllSeparate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchNewBlForBllRowSearch(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBllSeparate(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.TRANS)) {
//				eventResponse = transmitBllSeparate(e);
			}
		}

		return eventResponse;
	}

	/**
	 * Back End Job 공통<br>
	 *  - Back End Job Status 조회
	 * (동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용)
	 *
	 * @param String backEndJobKey
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getBackEndJobStatus(String backEndJobKey) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try {
			String jbStsFlg = command.getBackEndJobStatus(backEndJobKey);
			eventResponse.setETCData("jb_sts_flg", jbStsFlg);
		} catch(EventException ex) {
			log.error("\n\nEventException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1501] Retrive<br>
	 *  - Advance Cargo Information Download & Transmit - Header 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCargoInfoHeader(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();
		EsmBkg1501Event event =(EsmBkg1501Event) e;

		try {
			eventResponse.setRsVoList(command.searchCargoInfoHeader(event.getCargoInfoHeaderVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1501] Retrive(sheet1 Double Click) - Back End Job 시작<br>
	 *  - Advance Cargo Information Download & Transmit - Detail 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobSearchCargoInfoDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();
		EsmBkg1501Event event =(EsmBkg1501Event) e;

		try {
			begin();
			eventResponse.setETCData("backEndJob_Key", command.startBackEndJobSearchCargoInfoDetail(event.getCargoInfoHeaderVO(), account));
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1501] Back End Job 결과<br>
	 *  - Advance Cargo Information Download & Transmit - Detail 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobSearchCargoInfoDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();
		EsmBkg1501Event event =(EsmBkg1501Event) e;

		try {
			eventResponse.setRsVoList(command.resultBackEndJobSearchCargoInfoDetail(event.getAttribute("backEndJob_Key").toString()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1501] Save - Back End Job 시작<br>
	 *  - Advance Cargo Information Download & Transmit - Detail 목록 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobManageCargoInfoDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();
		EsmBkg1501Event event =(EsmBkg1501Event) e;

		try {
			begin();
			String backEndJobKey = command.startBackEndJobManageCargoInfoDetail(event.getCargoInfoHeaderVO(), event.getCargoInfoDetailVOs(), account);
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1501] Back End Job 결과<br>
	 *  - Advance Cargo Information Download & Transmit - Detail 목록 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobManageCargoInfoDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();
		EsmBkg1501Event event =(EsmBkg1501Event) e;

		try {
			begin();
			command.resultBackEndJobManageCargoInfoDetail(event.getAttribute("backEndJob_Key").toString());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1501] Transmit<br>
	 *  - Advance Cargo Information Download & Transmit - Detail 목록 EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitCargoInfoDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24CustomsTransmissionBC command = new Jp24CustomsTransmissionBCImpl();
		EsmBkg1501Event event =(EsmBkg1501Event) e;

		try {
			begin();
			command.transmitCargoInfoDetail(event.getCargoInfoHeaderVO(), event.getCargoInfoDetailVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1502] Retrive<br>
	 *  - B/L Inquiry(Japan 24HR) 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();
		EsmBkg1502Event event =(EsmBkg1502Event) e;

		try {
			List<AdvJpBlVO> list0 = command.searchBLInquiry(event.getAdvJpBlVO());
			// list0을 ETC-DATA로 setting
			if (list0.size() > 0) eventResponse.setETCData(list0.get(0).getColumnValues());
			eventResponse.setETCData("data_rows", String.valueOf(list0.size()));

			eventResponse.setRsVoList(command.searchBLInquiryContainer(event.getAdvJpBlVO()));
			eventResponse.setRsVoList(command.searchBLInquiryMarkDesc(event.getAdvJpBlVO()));

		} catch(EventException ex) {
			log.error("\n\nEventException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1502](Customer입력창) 버튼 Click<br>
	 *  - MDM_CUSTOMER 정보 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMdmCustomer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();
		EsmBkg1502Event event =(EsmBkg1502Event) e;

		try {
			List<GetMdmCustomerVO> list = command.getMdmCustomer(event.getGetMdmCustomerVO());
			// list을 ETC-DATA로 setting
			if (list.size() > 0) eventResponse.setETCData(list.get(0).getColumnValues());

		} catch(EventException ex) {
			log.error("\n\nEventException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1502] Save<br>
	 *  - B/L Inquiry(Japan 24HR) 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBLInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();
		EsmBkg1502Event event =(EsmBkg1502Event) e;

		try {
			begin();
			command.manageBLInquiry(event.getAdvJpBlVO(), event.getAdvJpContainerVOs(), event.getAdvJpMarkDescVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1502] Transmit<br>
	 *  - B/L Inquiry(Japan 24HR) EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitBLInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24CustomsTransmissionBC command = new Jp24CustomsTransmissionBCImpl();
		EsmBkg1502Event event =(EsmBkg1502Event) e;

		try {
			begin();
			command.transmitBLInquiry(event.getAdvJpBlVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1503] Retrive<br>
	 *  - Departure Time Registration 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDepartureTime(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24CustomsTransmissionBC command = new Jp24CustomsTransmissionBCImpl();
		EsmBkg1503Event event =(EsmBkg1503Event) e;

		try {
			List<DepartureTimeVO> list = command.searchDepartureTime(event.getDepartureTimeVO());
			// list을 ETC-DATA로 setting
			if (list.size() > 0) eventResponse.setETCData(list.get(0).getColumnValues());
			eventResponse.setETCData("data_rows", String.valueOf(list.size()));

		} catch(EventException ex) {
			log.error("\n\nEventException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1503]Transmit<br>
	 *  - Departure Time Registration EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitDepartureTimeByUI(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24CustomsTransmissionBC command = new Jp24CustomsTransmissionBCImpl();
		EsmBkg1503Event event =(EsmBkg1503Event) e;

		try {
			event.getDepartureTimeVO().setCntCd(account.getCnt_cd());
			event.getDepartureTimeVO().setOfcCd(account.getOfc_cd());
			event.getDepartureTimeVO().setUsrEml(account.getUsr_eml());
			event.getDepartureTimeVO().setUsrId(account.getUsr_id());

			begin();
			command.transmitDepartureTime(event.getDepartureTimeVO(), event.getEventName());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [BATCH] AtdTransmitForJp24<br>
	 *  - Departure Time Registration EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitDepartureTimeByBatch(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24CustomsTransmissionBC command = new Jp24CustomsTransmissionBCImpl();
		BatchForEtdAtdTransmitEvent event = (BatchForEtdAtdTransmitEvent) e;

		try {
			begin();
			command.transmitDepartureTime(event.getDepartureTimeVO(), event.getEventName());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EDI_T_BKG_T_JP24CUS_ACK]<br>
	 *  - 일본세관에서 송신한 EDI메세지를 수신 처리
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveEDIForJapan24HR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24CustomsTransmissionBC command = new Jp24CustomsTransmissionBCImpl();
		UBizComOpusBkgJpn24Event event =(UBizComOpusBkgJpn24Event) e;

		try {
			begin();
			command.receiveEDIForJapan24HR(event.getFlatFile());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1504] Retrive<br>
	 *  - JMS Report 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchJmsReport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24CustomsTransmissionBC command = new Jp24CustomsTransmissionBCImpl();
		EsmBkg1504Event event =(EsmBkg1504Event) e;

		try {
			eventResponse.setRsVoList(command.searchJmsReport(event.getJmsReportVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1505] Retrive<br>
	 *  - Transmit Result Error Report 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchErrorReport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24CustomsTransmissionBC command = new Jp24CustomsTransmissionBCImpl();
		EsmBkg1505Event event =(EsmBkg1505Event) e;

		try {
			eventResponse.setRsVoList(command.searchErrorReport(event.getErrorReportVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1506] Retrive<br>
	 *  - Send FlatFile 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSendFlatFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24CustomsTransmissionBC command = new Jp24CustomsTransmissionBCImpl();
		EsmBkg1506Event event =(EsmBkg1506Event) e;

		try {
			eventResponse.setRsVoList(command.searchSendFlatFile(event.getFlatFileVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [BATCH] NoResponseForJp24<br>
	 *  - BATCH for No Response E-MAIL
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendEmailForNoResponse(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24CustomsTransmissionBC command = new Jp24CustomsTransmissionBCImpl();
		BatchForNoResponseEvent event = (BatchForNoResponseEvent) e;

		try {
			begin();
			command.sendEmailForNoResponse(event.getAdvJpReceiveLogVO());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EDI_T_BKG_T_JP24SYS_AMR_ACK]<br>
	 *  - 일본세관에서 송신한 EDI메세지를 수신 처리
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveEDIForJp24SysAmr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24CustomsTransmissionBC command = new Jp24CustomsTransmissionBCImpl();
		EdiBkgJp24sysAmrAckEvent event = (EdiBkgJp24sysAmrAckEvent) e;

		try {
			begin();
			command.receiveEDIForJp24SysAck(event.getFlatFile(), "AMR");
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EDI_T_BKG_T_JP24SYS_ATD_ACK]<br>
	 *  - 일본세관에서 송신한 EDI메세지를 수신 처리
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveEDIForJp24SysAtd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24CustomsTransmissionBC command = new Jp24CustomsTransmissionBCImpl();
		EdiBkgJp24sysAtdAckEvent event = (EdiBkgJp24sysAtdAckEvent) e;

		try {
			begin();
			command.receiveEDIForJp24SysAck(event.getFlatFile(), "ATD");
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1526] Retrive<br>
	 *  - Association B/L Separate 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBllSeparate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();
		EsmBkg1526Event event =(EsmBkg1526Event) e;

		try {
			List<BllSprtCmbnVO> list = command.searchOrgBlForBll(event.getBllSprtCmbnVO());
			eventResponse.setRsVoList(list);
			String bllSndStsCd = "";
			if (list.size() > 0) bllSndStsCd = list.get(0).getBllSndStsCd();
			eventResponse.setRsVoList(command.searchNewBlForBll(bllSndStsCd, event.getBllSprtCmbnVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1526] Row Search<br>
	 *  - Association B/L Separate 단건 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNewBlForBllRowSearch(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();
		EsmBkg1526Event event =(EsmBkg1526Event) e;

		try {
			List<BllSprtCmbnVO> list = command.searchNewBlForBllRowSearch(event.getBllSprtCmbnVO());
			String aSType = "0";    // "No data found."
			if (list.size() > 0) {
				if ("".equals(list.get(0).getASType())) {
					aSType = "1";    // "There is no trans data"
				} else {
					aSType = "2";
					eventResponse.setRsVoList(list);
				}
			}
			eventResponse.setETCData("a_s_type", aSType);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1526] Save<br>
	 *  - Association B/L Separate 목록 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBllSeparate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();
		EsmBkg1526Event event =(EsmBkg1526Event) e;

		try {
			begin();
			command.manageBllSeparate(event.getBllSprtCmbnVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1526] Transmit<br>
	 *  - Association B/L Separate 목록 EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
/*
	private EventResponse transmitBllSeparate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24CustomsTransmissionBC command = new Jp24CustomsTransmissionBCImpl();
		EsmBkg1526Event event =(EsmBkg1526Event) e;

		try {
			begin();
			command.transmitBllSeparate(event.getBllSprtCmbnVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
*/	


}
