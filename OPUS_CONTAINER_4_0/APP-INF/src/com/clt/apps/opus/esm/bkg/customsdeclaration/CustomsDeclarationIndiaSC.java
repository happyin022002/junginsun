/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsDeclarationIndiaSC.java
*@FileTitle : CustomsDeclarationIndiaSC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.basic.IndiaCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.basic.IndiaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.event.EsmBkg0298Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.event.EsmBkg0302Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.event.EsmBkg0303Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaTransmitCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.basic.SrilankaCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.basic.SrilankaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.basic.IndiaManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.basic.IndiaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0296Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0300Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0304Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0305Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InPrintFormCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.basic.SriLankaManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.basic.SriLankaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event.EsmBkg0493Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BondDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclarationIndia Business Logic ServiceCommand<br>
 * - Process the business transactions for the OPUS-CustomsDeclarationIndia.
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class CustomsDeclarationIndiaSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationIndiaSC system <br>
	 * ESM_BKG_1085<br>
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
	 * CustomsDeclarationIndiaSC system <br>
	 * ESM_BKG_1085 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationIndiaSC 종료");
	}

	/**
	 *
	 * CustomsDeclarationIndiaSC system <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		log.info("[SC.perform] Start ---------------------------");
		log.info("[SC.perform] e.getEventName() : " + e.getEventName());
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmBkg0304Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUiSetUpInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmBkg0296Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			}
		}  else if ( e.getEventName().equalsIgnoreCase("EsmBkg0298Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmBkg0300Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsNtfyAddr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOrganization(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsNtfyAddr(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmBkg0302Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmBkg0303Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmBkg0305Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBondList(e);
			}
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0304 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(CMF 데이터) 를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		IndiaManifestListDownloadBC command = null;
		List<VesselArrivalDetailVO> list = null;
		try {
			if ("EsmBkg0304Event".equalsIgnoreCase(e.getEventName())) { // India
				command = new IndiaManifestListDownloadBCImpl();
				EsmBkg0304Event event = (EsmBkg0304Event) e;
				list = command.searchVesselArrival(event.getInVesselArrivalCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0304 : MULTI <br>
	 * DBF 파일생성해서 로컬로 파일 경로를 반환한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVesselArrival(Event e) throws EventException {
		IndiaManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0304Event")) { // India
				command = new IndiaManifestListDownloadBCImpl();
				EsmBkg0304Event event = (EsmBkg0304Event) e;
				command.manageVesselArrival(event.getInVesselArrivalVO(), account);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0304 : SEARCH01 <br>
	 * Vessel Arrival 정보를 생성 및 수정한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUiSetUpInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// 이벤트별 Impl생성
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0304 : MULTI01<br>
	 * User Auth List 정보수정<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SrilankaCustomsTransmissionBC command = null;
		SriLankaManifestListDownloadBC maniCommand = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		String flatFile = "";
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			begin();
			EsmBkg0493Event event = (EsmBkg0493Event) e;
			command = new SrilankaCustomsTransmissionBCImpl();
			maniCommand = new SriLankaManifestListDownloadBCImpl();
			// 1.FlatFile을 만들고 2.로그테이블에 Insert
			flatFile = command.transmitVesselArrival((VesselArrivalTransmitVO) event.getSriLankaVesselArrivalTransmitVO());
			maniCommand.modifySendDt((VesselArrivalTransmitVO) event.getSriLankaVesselArrivalTransmitVO());
			eventResponse.setETCData("flatFile", flatFile);
			eventResponse.setETCData(etcData);
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
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
	 * ESM_BKG_0296 : SEARCH <br>
	 *
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		IndiaManifestListDownloadBC command = null;


		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0296Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0296Event")) {
				EsmBkg0296Event event = (EsmBkg0296Event) e;
				command = new IndiaManifestListDownloadBCImpl();
				IndiaManifestListDetailVO indiaManifestListDetailVO = null;
				List<IndiaManifestListDetailVO> indiaManifestVslInfoVOList = null;
				List<IndiaManifestListDetailVO> indiaManifestListDetailVOList = null;
				List<IndiaManifestListDetailVO> indiaCntrMfDetailVOList = null;
				IndiaManifestListCondVO indiaManifestListCondVO = (IndiaManifestListCondVO) event.getIndiaManifestListCondVO();
				List<ManifestListDetailVO> manifestListDetailVOs = command.searchManifestList(indiaManifestListCondVO);
				IndiaContainerVO containerVO = null;
				if (manifestListDetailVOs != null
						&& manifestListDetailVOs.size() > 0) {
					containerVO = (IndiaContainerVO) manifestListDetailVOs.get(0);
					// 기본 배정보
					indiaManifestVslInfoVOList = containerVO.getIndiaManifestListVslInfoVOList();
					// B/L 정보
					indiaManifestListDetailVOList = containerVO.getIndiaManifestListDetailVOList();
					// Container 정보
					indiaCntrMfDetailVOList = containerVO.getIndiaCntrMfDetailVOList();
					if (indiaManifestVslInfoVOList != null
							&& indiaManifestVslInfoVOList.size() > 0) {
						indiaManifestListDetailVO = indiaManifestVslInfoVOList.get(0);
						eventResponse.setETCData("masterResult", "success");
						eventResponse.setETCData("igmNo", indiaManifestListDetailVO.getIgmNo());
						eventResponse.setETCData("igmDate", indiaManifestListDetailVO.getIgmDate());
						eventResponse.setETCData("vslNm", indiaManifestListDetailVO.getVslNm());
						eventResponse.setETCData("etaDt", indiaManifestListDetailVO.getEtaDt());
					} else {
						eventResponse.setETCData("masterResult", "fail");
					}
				}
				eventResponse.setRsVoList(indiaManifestListDetailVOList);
				eventResponse.setRsVoList(indiaCntrMfDetailVOList);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0296 : MULTI <br>
	 * Container Manifest정보를 업데이트 한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		IndiaManifestListDownloadBC command = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0296Event")) { // 인도
				EsmBkg0296Event event = (EsmBkg0296Event) e;
				command = new IndiaManifestListDownloadBCImpl();
				command.manageManifest(event.getManifestModificationVOs(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0298 : MULTI <br>
	 * ESM_BKG_0302 : MULTI <br>
	 * ESM_BKG_0303 : MULTI <br>

	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		IndiaCustomsTransmissionBC command = new IndiaCustomsTransmissionBCImpl();
		String flatFile = ""; 

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0298Event")) {
				// 세관에 적하목록 신고를 EDI를 통해 전송한다. - processType=1(India Container
				// List Flat File 생성 및 로컬 pc로 다운로드)
				EsmBkg0298Event event = (EsmBkg0298Event) e;
				flatFile = command.transmitManifest(event.getIndiaTransmitCondVO());
				eventResponse.setETCData("flatFile", flatFile);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0302Event")) {
				// 세관에 적하목록 신고를 EDI를 통해 전송한다. - processType=2(India IGM
				// Generation(EDI) Flat File 생성 및 로컬 pc로 다운로드)
				EsmBkg0302Event event = (EsmBkg0302Event) e;
				flatFile = command.transmitManifest(event.getIndiaTransmitCondVO());
				eventResponse.setETCData("flatFile", flatFile);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0303Event")) {
				// 세관에 적하목록 신고를 EDI를 통해 전송한다. - processType=3(India TP
				// Request(EDI) Flat File 생성 및 로컬 pc로 다운로드)
				EsmBkg0303Event event = (EsmBkg0303Event) e;
				IndiaTransmitCondVO vo = event.getIndiaTransmitCondVO();
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				flatFile = command.transmitManifest(event.getIndiaTransmitCondVO());
				eventResponse.setETCData("flatFile", flatFile);
			}
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
	 * ESM_BKG_0300 : (Customs Manifest) VVD의 등록여부를 조사한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchCstmsNtfyAddr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0300Event")) { // India Form Set
				IndiaManifestListDownloadBC command = new IndiaManifestListDownloadBCImpl();
				EsmBkg0300Event event = (EsmBkg0300Event) e;
				List<CstmsNtfyAddrVO> list = command.searchCstmsNtfyAddr((CstmsNtfyAddrCondVO) event.getInPrintFormCondVO());
				eventResponse.setRsVoList(list);
				eventResponse.setETCData("retExitOrg", "");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0300 : SEARCH01<BR>
	 * Office Code 등록유무 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOrganization(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		IndiaManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			command = new IndiaManifestListDownloadBCImpl();
			EsmBkg0300Event event = (EsmBkg0300Event) e;
			InPrintFormCondVO inPrintFormCondVO = event.getInPrintFormCondVO();
			String ofcCd = "";
			int retExitOrg = 0;
			if (inPrintFormCondVO != null) {
				ofcCd = inPrintFormCondVO.getOfcCd();
			}
			retExitOrg = command.searchExistOrganization(ofcCd);
			if (retExitOrg > 0) {
				eventResponse.setETCData("retExitOrg", "1"); // 등록된 Office
				// Code
			} else {
				eventResponse.setETCData("retExitOrg", "0"); // 미등록된 Office
				// Code
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0300 : MULTI<BR>
	 * ANCS 세관 관련 Notify Address를 관리 한다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsNtfyAddr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		IndiaManifestListDownloadBC command = null;
		try {
			begin();
			EsmBkg0300Event event = (EsmBkg0300Event) e;
			command = new IndiaManifestListDownloadBCImpl();
			command.manageCstmsNtfyAddr(event.getInPrintFormModiVOs(), account);
			eventResponse.setETCData("retExitOrg", "");
			// eventResponse.setUserMessage(new
			// ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0305 : SEARCH<br>
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBondList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		IndiaManifestListDownloadBC command = null;
		List<BondDetailListVO> list = null;
		try {
			command = new IndiaManifestListDownloadBCImpl();
			EsmBkg0305Event event = (EsmBkg0305Event) e;
			list = command.searchBondList(event.getIndiaBondListCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
}