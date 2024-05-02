/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CustomsDeclarationAustraliaSC.java
 *@FileTitle : CustomsDeclarationAustraliaSC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=======================================================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.basic.AustraliaCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.basic.AustraliaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.event.UBizComOpusBkgAusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.basic.AustraliaManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.basic.AustraliaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event.EsmBkg0053Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event.EsmBkg1514Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event.EsmBkg1515Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event.EsmBkg1516Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event.EsmBkg1517Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event.EsmBkg1520Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event.EsmBkg1521Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusDgListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSpecialContainerVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclarationAustralia Business Logic ServiceCommand -
 * OPUS-CustomsDeclarationAustralia 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationAustraliaSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationAustralia system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CustomsDeclarationAustralia system 업무 시나리오 마감작업<br>
	 * ESM_BKG-0017 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationAustraliaSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-CustomsDeclarationAustralia system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmBkg0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1514Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchAusCarlst(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {    // Start Back End Job (TRANSMIT)
				eventResponse = startBackEndJobTransmitCarlst(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {    // (공통) Get status of Back End Job (TRANSMIT)
				String backEndJobKey = e.getAttribute("backEndJob_Key").toString();
				eventResponse = getBackEndJobStatus(backEndJobKey);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {    // Result return(TRANSMIT)
				String backEndJobKey = e.getAttribute("backEndJob_Key").toString();
				eventResponse = resultBackEndJobTransmitCuscar(backEndJobKey);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1517Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchAusUbmreq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {    // Start Back End Job (TRANSMIT)
				eventResponse = startBackEndJobTransmitUbmreq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {    // (공통) Get status of Back End Job (TRANSMIT)
				String backEndJobKey = e.getAttribute("backEndJob_Key").toString();
				eventResponse = getBackEndJobStatus(backEndJobKey);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {    // Result return (TRANSMIT)
				String backEndJobKey = e.getAttribute("backEndJob_Key").toString();
				eventResponse = resultBackEndJobTransmitCuscar(backEndJobKey);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1516Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchAusSeacr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {    // Start Back End Job (TRANSMIT)
				eventResponse = startBackEndJobTransmitSeacr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {    // (공통) Get status of Back End Job (TRANSMIT)
				String backEndJobKey = e.getAttribute("backEndJob_Key").toString();
				eventResponse = getBackEndJobStatus(backEndJobKey);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {    // Result return (TRANSMIT)
				String backEndJobKey = e.getAttribute("backEndJob_Key").toString();
				eventResponse = resultBackEndJobTransmitCuscar(backEndJobKey);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1515Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchErrorReport(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("UBizComOpusBkgAusAckEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.TRANS)) {
				eventResponse = receiveEDIForAusAck(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1520Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAusDgManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {   // Start Back End Job(TRANSMIT)
				eventResponse = startBackEndJobTransmitDgManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {    // Get status of Back End Job(공통으로 호출)
				eventResponse = getBackEndJobStatus(e.getAttribute("backEndJob_Key").toString());
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {   // Result return(TRANSMIT)
				eventResponse = resultBackEndJobTransmitDgManifest(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1521Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAusSendHistory(e);
			}

		}
		log.info("\n\n[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * Back End Job 공통<br>
	 *  - Back End Job Status 조회
	 * (동일 Package에 Back End Job이 여러개일때 공통으로 사용)
	 *
	 * @param String backEndJobKey
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getBackEndJobStatus(String backEndJobKey) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AustraliaCustomsTransmissionBC command = new AustraliaCustomsTransmissionBCImpl();
		try {
			String jbStsFlg = command.getBackEndJobStatus(backEndJobKey);
			eventResponse.setETCData("jb_sts_flg", jbStsFlg);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0053 : MULTI <br>
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0053Event event = (EsmBkg0053Event) e;
		AustraliaCustomsTransmissionBC command = new AustraliaCustomsTransmissionBCImpl();
		try {
			begin();
			String key = command.startBackEndJobManifestTransmit(account, event.getAustraliaManifestTransmitVO());
			eventResponse.setETCData("KEY", key);
			commit();
		} catch (EventException ex) {
			log.error("EventException : " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("Exception : " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0053 : SEARCH03<BR>
	 * EXS B/L Inquiry 화면에서 Prev. Doc No Append <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0053Event event = (EsmBkg0053Event) e;
		String sKey = event.getKey();
		String strResult = "";

		try {
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();

			while (rowSet.next()) {
				if ("2".equals(rowSet.getString("JB_STS_FLG"))) {
					// BackEndJob 처리중
					strResult = "PROCESSING";
				} else if ("3".equals(rowSet.getString("JB_STS_FLG"))) {
					// 성공메시지세팅
					// Data Transmitted successufully!
					eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
					strResult = "SUCCESS";
				} else if ("4".equals(rowSet.getString("JB_STS_FLG"))) {
					// 에러메시지세팅
					if (!"".equals(rowSet.getString("JB_USR_ERR_MSG"))) {
						StringTokenizer st = new StringTokenizer(rowSet.getString("JB_USR_ERR_MSG"), "<||>");
						st.nextToken();
						st.nextToken();
						st.nextToken();
						String strErrMsg = st.nextToken();
						eventResponse.setUserMessage(strErrMsg);
					}
					strResult = "FAIL";
				}
			}
			eventResponse.setETCData("jb_sts_flg", strResult);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1514] Retrive<br>
	 * Australia Cargo List Report - CARLST 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAusCarlst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AustraliaManifestListDownloadBC command = new AustraliaManifestListDownloadBCImpl();
		EsmBkg1514Event event = (EsmBkg1514Event) e;
		try {
			eventResponse.setRsVoList(command.searchAusCarlstUbmreq(event.getAusSearchCuscarVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1514] CARLST Transmit - Back End Job 시작<br>
	 * Australia Cargo List Report - CARLST EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobTransmitCarlst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AustraliaCustomsTransmissionBC command = new AustraliaCustomsTransmissionBCImpl();
		EsmBkg1514Event event = (EsmBkg1514Event) e;
		try {
			begin();
			String backEndJobKey = command.startBackEndJobTransmitCarlst(event.getAusSearchCuscarVO(), event.getAusResultCuscarVOs(), account);
			commit();
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1517] Retrive<br>
	 * Australia Underbond Movement Request - UBMREQ 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAusUbmreq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AustraliaManifestListDownloadBC command = new AustraliaManifestListDownloadBCImpl();
		EsmBkg1517Event event = (EsmBkg1517Event) e;
		try {
			eventResponse.setRsVoList(command.searchAusCarlstUbmreq(event.getAusSearchCuscarVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1517] CARLST Transmit - Back End Job 시작<br>
	 * Australia Underbond Movement Request - UBMREQ EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobTransmitUbmreq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AustraliaCustomsTransmissionBC command = new AustraliaCustomsTransmissionBCImpl();
		EsmBkg1517Event event = (EsmBkg1517Event) e;
		try {
			begin();
			String backEndJobKey = command.startBackEndJobTransmitUbmreq(event.getAusSearchCuscarVO(), event.getAusResultCuscarVOs(), account);
			commit();
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1516] Retrive<br>
	 * Australia Sea Cargo Report - SEACR 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAusSeacr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AustraliaManifestListDownloadBC command = new AustraliaManifestListDownloadBCImpl();
		EsmBkg1516Event event = (EsmBkg1516Event) e;
		try {
			eventResponse.setRsVoList(command.searchAusSeacrSum(event.getAusSearchCuscarVO()));
			eventResponse.setRsVoList(command.searchAusSeacrBl(event.getAusSearchCuscarVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1516] CARLST Transmit - Back End Job 시작<br>
	 * Australia Sea Cargo Report - SEACR EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobTransmitSeacr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AustraliaCustomsTransmissionBC command = new AustraliaCustomsTransmissionBCImpl();
		EsmBkg1516Event event = (EsmBkg1516Event) e;
		try {
			begin();
			String backEndJobKey = command.startBackEndJobTransmitSeacr(event.getAusSearchCuscarVO(), event.getAusResultCuscarVOs(), account);
			commit();
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1514] : CARLST
	 * [ESM_BKG_1517] : UBMREQ
	 * [ESM_BKG_1516] : SEACR
	 *  Transmit - Back End Job 결과<br>
	 * Australia Customs Cargo List - EDI 전송
	 *
	 * @param String backEndJobKey
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobTransmitCuscar(String backEndJobKey) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AustraliaCustomsTransmissionBC command = new AustraliaCustomsTransmissionBCImpl();
		try {
			begin();
			command.resultBackEndJobTransmitCuscar(backEndJobKey);
			commit();
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1515] Retrive<br>
	 * Transmit Result Error Report 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchErrorReport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AustraliaManifestListDownloadBC command = new AustraliaManifestListDownloadBCImpl();
		EsmBkg1515Event event =(EsmBkg1515Event) e;
		try {
			eventResponse.setRsVoList(command.searchErrorReport(event.getErrorReportVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EDI_T_BKG_T_AUCUS_ACK]
	 * Australia ACK EDI메세지를 수신 처리
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveEDIForAusAck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AustraliaCustomsTransmissionBC command = new AustraliaCustomsTransmissionBCImpl();
		UBizComOpusBkgAusAckEvent event = (UBizComOpusBkgAusAckEvent) e;
		try {
			begin();
			command.receiveEDIForAusAck(event.getFlatFile());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1521 :
	 * 송신 내역을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAusSendHistory(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AustraliaManifestListDownloadBC command = new AustraliaManifestListDownloadBCImpl();
		EsmBkg1521Event event = (EsmBkg1521Event)e;
		try {
			eventResponse.setRsVoList(command.searchAusSendHistory(event.getAusSendHistoryCondVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1520 :
	 * 위험물 신고 대상 컨테이너를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAusDgManifestList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AustraliaManifestListDownloadBC command = new AustraliaManifestListDownloadBCImpl();
		EsmBkg1520Event event = (EsmBkg1520Event)e;

		try {
			List<AusDgListDetailVO> list = command.searchAusDgManifestList(event.getAusDgListCondVO());
			if (list != null && list.size() > 0) {
				AusSpecialContainerVO containerVO = (AusSpecialContainerVO)list.get(0);
				// 상단 배정보
				eventResponse.setRsVo(containerVO.getAusVslInfo());
				// 하단 그리드 정보
				eventResponse.setRsVoList(containerVO.getAusDetailList());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1520 : Transmit - Back End Job 시작<br>
	 * DG Cargo Flat File 생성 및 EDI Transmit
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobTransmitDgManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AustraliaCustomsTransmissionBC command = new AustraliaCustomsTransmissionBCImpl();
		EsmBkg1520Event event = (EsmBkg1520Event) e;

		try {
			begin();
			String backEndJobKey = command.startBackEndJobTransmitDgManifest(event.getAusDgEdiVOs(), account, "ESM_BKG_1520-Transmit");
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1520 : Transmit - Back End Job 결과<br>
	 * DG Cargo Flat File 생성 및 EDI Transmit
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobTransmitDgManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AustraliaCustomsTransmissionBC command = new AustraliaCustomsTransmissionBCImpl();
		EsmBkg1520Event event = (EsmBkg1520Event) e;

		try {
			begin();
			List<String> flatFileList = command.resultBackEndJobTransmitDgManifest(event.getAttribute("backEndJob_Key").toString());
			if (flatFileList != null && flatFileList.size() > 0) {
				eventResponse.setETCData("originalFlatFile", flatFileList.get(0));
				eventResponse.setETCData("updateFlatFile", flatFileList.get(1));
				eventResponse.setETCData("cancelFlatFile", flatFileList.get(2));
			} else {
				eventResponse.setETCData("originalFlatFile", "");
				eventResponse.setETCData("updateFlatFile", "");
				eventResponse.setETCData("cancelFlatFile", "");
			}

			commit();
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

}
