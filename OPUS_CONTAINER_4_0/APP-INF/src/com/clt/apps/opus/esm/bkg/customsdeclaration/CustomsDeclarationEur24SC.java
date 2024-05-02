/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CustomsDeclarationSC.java
 *@FileTitle : ESM_BKG-0017
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.06.01
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2009.04.21 김승민
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCrnRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.basic.Eur24CustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.basic.Eur24CustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.basic.OpusbkgUbizcomEur24cusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.event.OpusbkgEdiErrEur24ReceiveEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.basic.Eur24ManifestDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.basic.Eur24ManifestDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1104Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1105Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1106Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1107Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1108Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1109Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1112Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1113Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1115Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1120Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1121Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1124Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1126Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1127Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1128Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1146Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1152Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1171Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1172Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.CustomsSetupVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24RcvErrorCodeTableVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24CountryListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EXSListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EnsListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ExsListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ManifestOBListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalNoticeDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselFIArrivalNoticeDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrListRsltVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListRsltVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
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
 * OPUS-CustomsDeclarationEur24SC Business Logic ServiceCommand -
 * OPUS-CustomsDeclarationEur24SC handling business transaction.
 * 
 * @author 2012505
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationEur24SC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationEur24SC system <br>
	 * ESM_BKG-0017<br>
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
	 * CustomsDeclarationEur24SC system <br>
	 * ESM_BKG-0017 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationEur24SC 종료");
	}

	/**
	 * 
	 * OPUS-CustomsDeclarationEur24SC system <br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		log.info("[SC.perform] Start ---------------------------");
		log.info("[SC.perform] e.getEventName() : " + e.getEventName());
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		String eventName = e.getEventName();
		FormCommand formCommand = e.getFormCommand();
		if (e.getEventName().equalsIgnoreCase("EsmBkg1172Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEU24EDIHistory(e);
			}
		} else if (eventName.equalsIgnoreCase("EsmBkg1171Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI)) {
				eventResponse = manageFIVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitFiBlArrival(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBlArrival(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEu1stPortByVvd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1152Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEXSMonitoring(e);
			}
		}
		// ---------------------------------------------------------------------------
		// WebService EAI [WEB_001_0001] 2011.09.27 추가
		// ---------------------------------------------------------------------------
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1146Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPrevDocNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01) || e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = managePrevDocNo(e); // append Prev. Doc No
			}
		} else if (eventName.equalsIgnoreCase("EsmBkg1128Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsRcvMsgOB(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1127Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEU24EDIHistoryOB(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1126Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEXSReportOB(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEXSSvcLaneByVvdOB(e);
			}
		} else if (eventName.equalsIgnoreCase("EsmBkg1124Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlInfo(e); // 1124
			} else if (formCommand.isCommand(FormCommand.SEARCH01) || formCommand.isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchContainerList(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVesselArrival(e); // 1124
			} else if (formCommand.isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlInfo(e); // 1124
			} else if (formCommand.isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMdmCust(e); // 1124
			} else if (formCommand.isCommand(FormCommand.MULTI02)) {
				eventResponse = managePrevDocNo(e); // append Prev. Doc No
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEu1stPortByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = transmitManifestEXS(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = deleteManifestEXS(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchEuOBVvdByBL(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchEU24CountryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1120Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchENSMonitoring(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode1120(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1115Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEU24RcvErrorCodeTable(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1113Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEU24EDIHistory(e);
			}
		} else if (eventName.equalsIgnoreCase("EsmBkg1112Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsRcvMsg(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1109Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomsSetupList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmLocationPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMdmYardTmlcode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEU24CustomsSetup(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1108Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchENSReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSvcLaneByVvd(e);
			}
		} else if (eventName.equalsIgnoreCase("EsmBkg1107Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlInfo(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH01) || formCommand.isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchContainerList(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlInfo(e);
			} else if (formCommand.isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI02)) {
				eventResponse = manageMrnNo(e);
			} else if (formCommand.isCommand(FormCommand.MULTI03)) {
				eventResponse = reactivateMrnNo(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMdmCust(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEu1stPortByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = transmitManifestENS(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = deleteManifestENS(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = search1stEUvvdByBL(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchEU24CountryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchPreEUportByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchPreEUvvdByBL(e);
			}
		} else if (eventName.equalsIgnoreCase("EsmBkg1105Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCstmsENSPofeList(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCstmsOfficeIdByPort(e);
			}
		} else if (eventName.equalsIgnoreCase("EsmBkg1104Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI02)) {
				eventResponse = deleteAllMrn(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEu1stPortByVvd(e);
			}
		} else if (eventName.equalsIgnoreCase("OpusbkgUbizcomEur24cusAckEvent")) {
			eventResponse = loadCstmsRcvMsg(e);
		} else if (eventName.equalsIgnoreCase("OpusbkgEdiErrEur24ReceiveEvent")) {
			eventResponse = loadEdiErr(e);
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse loadEdiErr(Event e) throws EventException {
		log.info("SC [loadEdiErr] Start---------------------");

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Eur24CustomsTransmissionBC command = null;

		try {
			begin();

			// Canada 수신
			OpusbkgEdiErrEur24ReceiveEvent event = (OpusbkgEdiErrEur24ReceiveEvent) e;
			command = new Eur24CustomsTransmissionBCImpl();
			String strFlatFile = event.getFlatFile();
			command.loadEdiErr(strFlatFile);
			commit();

		} catch (EventException ex) {
			log.error("EventException : " + ex.getMessage());
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("Exception : " + ex.getMessage());
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1113 : SEARCH<BR>
	 * Transmit / Receive History 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEU24EDIHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1113Event")) {
				EsmBkg1113Event event = (EsmBkg1113Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				List<EU24EDIHistoryVO> list = command.searchEU24EDIHistory(event.getEU24EDIHistoryVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1172Event")) {
				EsmBkg1172Event event = (EsmBkg1172Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				List<EU24EDIHistoryVO> list = command.searchEU24EDIFIHistory(event.getEU24EDIHistoryVO());
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
	 * ESM_BKG_1106 : SEARCH05<BR>
	 * EU Port조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	 * private EventResponse searchInboundTSManifest(Event e) //v2.0 확인 후 삭제
	 * throws EventException { GeneralEventResponse eventResponse = new
	 * GeneralEventResponse(); EsmBkg0219Event event = (EsmBkg0219Event) e;
	 * ChinaCustomsTransmissionBC command = new
	 * ChinaCustomsTransmissionBCImpl();
	 * 
	 * try { InboundTSGRPVO inboundTSGRPVO = command
	 * .searchInboundTSManifest(event.getInboundTSInfoBLVO()); // 순서에 주의 if
	 * (inboundTSGRPVO.getInboundTSCustVO() != null)
	 * eventResponse.setETCData(inboundTSGRPVO.getInboundTSCustVO()
	 * .getColumnValues()); if (inboundTSGRPVO.getInboundTSInfoSKDVO() != null)
	 * eventResponse.setETCData(inboundTSGRPVO.getInboundTSInfoSKDVO()
	 * .getColumnValues()); if (inboundTSGRPVO.getInboundTSInfoBLVO() != null)
	 * eventResponse.setETCData(inboundTSGRPVO.getInboundTSInfoBLVO()
	 * .getColumnValues());
	 * eventResponse.setRsVoList(inboundTSGRPVO.getInboundTSCntrVOList());
	 * eventResponse.setRsVoList(inboundTSGRPVO .getInboundTSDownExcelVOList());
	 * 
	 * } catch (EventException ex) { throw ex; } catch (Exception ex) { throw
	 * new EventException(new ErrorHandler("BKG06086").getMessage(), ex); }
	 * return eventResponse; }
	 */
	/**
	 * ESM_BKG_1163 SAVE 시 CNTR WGT 정보 저장
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1104Event")) {
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				List<Eur24VesselArrivalNoticeDetailVO> voList = null;
				EsmBkg1104Event event = (EsmBkg1104Event) e;
				voList = command2.searchVesselArrival((Eur24VesselArrivalCondVO) event.getVesselArrivalCondVO(), account);
				eventResponse.setRsVoList(voList);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1105Event")) {
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				List<Eur24VesselArrivalNoticeDetailVO> voList = null;
				EsmBkg1105Event event = (EsmBkg1105Event) e;
				voList = command2.searchVesselArrival((Eur24VesselArrivalCondVO) event.getVesselArrivalCondVO(), account);
				eventResponse.setRsVoList(voList);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1107Event")) {
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				List<Eur24VesselArrivalNoticeDetailVO> voList = null;
				EsmBkg1107Event event = (EsmBkg1107Event) e;
				voList = command2.searchVesselByBL(event.getEur24VesselArrivalCondVO());
				eventResponse.setRsVoList(voList);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1124Event")) {
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				List<Eur24VesselArrivalNoticeDetailVO> voList = null;
				EsmBkg1124Event event = (EsmBkg1124Event) e;
				voList = command2.searchVesselByBLOB(event.getEur24VesselArrivalCondVO());
				eventResponse.setRsVoList(voList);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1171Event")) {
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				List<Eur24VesselFIArrivalNoticeDetailVO> voList = null;
				EsmBkg1171Event event = (EsmBkg1171Event) e;
				voList = command2.searchVesselFIArrival((Eur24VesselArrivalCondVO) event.getVesselArrivalCondVO());
				eventResponse.setRsVoList(voList);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0234 : MULTI01 <br>
	 * DBF 파일생성해서 로컬로 파일 경로를 반환한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFIVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();

			EsmBkg1171Event event = (EsmBkg1171Event) e;
			Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
			command2.manageFIVesselArrival((Eur24VesselFIArrivalNoticeDetailVO) event.getVesselArrivalDetailVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

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
	 * ESM_BKG_2001 : IBSEARCH searching Country Code, Customs Division ID,
	 * Customs Code Description
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse transmitFiBlArrival(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Eur24CustomsTransmissionBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1171Event")) {
				// ENS EDI FLAT FILE 생성 및 전송
				EsmBkg1171Event event = (EsmBkg1171Event) e;
				command = new Eur24CustomsTransmissionBCImpl();

				for (int i = 0; i < event.getVesselArrivalDetailVOS().length; i++) {

					command.transmitFiBlArrival(event.getVesselArrivalDetailVOS()[i],
							(VesselArrivalTransmitVO) event.getEur24VesselArrivalTransmitVO(), account);
					log.debug("SC_EUR24________________transmit");
				}
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
	 * ESM_BKG_1171 : MULTI <br>
	 * Finland 세관 신고 대상 Vessel Arrival Notice, Port net No를 저장한다.
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// ManifestListDownloadBC command = null;
		// List<VesselArrivalDetailVO> list = null;
		try {
			log.error("SC_EUR24________________retrieve");

			Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
			List<Eur24VesselFIArrivalNoticeDetailVO> voList = null;
			EsmBkg1171Event event = (EsmBkg1171Event) e;
			voList = command2.searchBlFIArrival((Eur24VesselArrivalCondVO) event.getVesselArrivalCondVO());
			eventResponse.setRsVoList(voList);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 
	 * ESM_BKG_1171 : MULTI01 <br>
	 * 단건씩 전송 Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEu1stPortByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<ManifestListDetailVO> list = null;
		try {
			String eventName = e.getEventName();
			if (eventName.equalsIgnoreCase("EsmBkg1106Event")) {
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchEu1stPortByVvd(event.getManifestListCondVO());
				eventResponse.setRsVoList(list);
			} else if (eventName.equalsIgnoreCase("EsmBkg1104Event")) {
				EsmBkg1104Event event = (EsmBkg1104Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchEu1stPortByVvdForAN(event.getManifestListCondVO());
				eventResponse.setRsVoList(list);
			} else if (eventName.equalsIgnoreCase("EsmBkg1105Event")) {
				EsmBkg1105Event event = (EsmBkg1105Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchEu1stPortByVvd(event.getManifestListCondVO());
				eventResponse.setRsVoList(list);
			} else if (eventName.equalsIgnoreCase("EsmBkg1121Event")) {
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchEuPolByVvd(event.getManifestListCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1106 : SEARCH01<BR>
	 * VVD FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEXSMonitoring(Event e) throws EventException {
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1152Event event = (EsmBkg1152Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<Eu24EXSListVO> list = command.searchEXSMonitoring(event.getEu24EXSListVO());
			if (list.size() > 0) {
				Eu24EXSListVO ovo = (Eu24EXSListVO) list.get(0);
				eventResponse.setETCData("sent_bl_cnt", ovo.getSentBlCnt());
				eventResponse.setETCData("acc_bl_cnt", ovo.getAccBlCnt());
				eventResponse.setETCData("rej_bl_cnt", ovo.getRejBlCnt());
				eventResponse.setETCData("nrcv_bl_cnt", ovo.getNrcvBlCnt());
				eventResponse.setETCData("donld_bl_cnt", ovo.getDonldBlCnt());
				eventResponse.setETCData("hold_bl_cnt", ovo.getHoldBlCnt());
				eventResponse.setETCData("rels_bl_cnt", ovo.getRelsBlCnt());
				eventResponse.setETCData("total_bl_cnt", ovo.getTotalBlCnt());
				eventResponse.setETCData("total_vvd_cnt", ovo.getTotalVvdCnt());
				eventResponse.setETCData("total_amd_cnt", ovo.getTotalAmdCnt());

			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0370:bkg0370_blur<br>
	 * 화면에서 POD를 drop down으로 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrevDocNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		Eur24ManifestDownloadBC command = null;

		try {
			EsmBkg1146Event event = (EsmBkg1146Event) e;
			command = new Eur24ManifestDownloadBCImpl();

			if (event.getEurCrnRcvMsgVO() != null) {
				List<EurCrnRcvMsgVO> list = command.searchPrevDocNo(event.getEurCrnRcvMsgVO());
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
	 * ESM_BKG_0329 : SAVE <br>
	 * cross check 관련 result remark 저장
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePrevDocNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Eur24ManifestDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1146Event event = (EsmBkg1146Event) e;
			command = new Eur24ManifestDownloadBCImpl();

			command.managePrevDocNo(event.getEurCrnRcvMsgVOs(), account);
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
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
	 * 2012.03.12 조원주 [CHM-201216099] Sea-NACCS 프로젝트 ESM_BKG_0479
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEU24EDIHistoryOB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1127Event event = (EsmBkg1127Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<EU24EDIHistoryOBVO> list = command.searchEU24EDIHistoryOB(event.getEU24EDIHistoryOBVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1128 : SEARCH<BR>
	 * Receive History<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsRcvMsgOB(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// EUR24 - 구주세관 ACK 수신
			Eur24ManifestDownloadBCImpl command3 = new Eur24ManifestDownloadBCImpl();
			List<Eur24RcvMsgVO> voList = null;
			EsmBkg1128Event event = (EsmBkg1128Event) e;
			voList = command3.searchCstmsRcvMsgOB((Eur24VesselArrivalCondVO) event.getVesselArrivalCondVO());
			eventResponse.setRsVoList(voList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 
	 * ESM_BKG_1046 : MULTI04 <br>
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEXSReportOB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1126Event event = (EsmBkg1126Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<Eu24ExsListOBVO> list = command.searchEXSReportOB(event.getEu24ExsListOBVO());
			if (list.size() > 0) {
				Eu24ExsListOBVO ovo = (Eu24ExsListOBVO) list.get(0);
				eventResponse.setETCData("total_bl_cnt", ovo.getTotalBlCnt());
				eventResponse.setETCData("sent_bl_cnt", ovo.getSentBlCnt());
				eventResponse.setETCData("unsent_bl_cnt", ovo.getUnsentBlCnt());
				// eventResponse.setETCData("sent_success_cnt",ovo.getSentSuccessCnt());
				// eventResponse.setETCData("sent_fail_cnt",ovo.getSentFailCnt());
				eventResponse.setETCData("a_cnt", ovo.getACnt());
				eventResponse.setETCData("r_cnt", ovo.getRCnt());
				eventResponse.setETCData("dnl_cnt", ovo.getDnlCnt());
				eventResponse.setETCData("h_cnt", ovo.getHCnt());
				eventResponse.setETCData("l_cnt", ovo.getLCnt());
				eventResponse.setETCData("nr_cnt", ovo.getNrCnt());

			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1126 : SEARCH01<BR>
	 * VVD FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEXSSvcLaneByVvdOB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1126Event event = (EsmBkg1126Event) e;
			String result = command.searchSvcLaneByVvd(event.getEu24ExsListOBVO().getPVvd());
			if (result != null && !result.equals("")) {
				eventResponse.setETCData("p_lane", result);
			} else {
				eventResponse.setETCData("p_lane", "");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_1125 : SEARCH<BR>
	 * CANADA ACI : ACI Monitoring 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String eventName = e.getEventName();
			// 이벤트별 Impl생성
			if (eventName.equalsIgnoreCase("EsmBkg1107Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					EsmBkg1107Event event = (EsmBkg1107Event) e;
					Eur24BlInfoCondVO eur24BlInfoCondVO = event.getEur24BlInfoCondVO();
					Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
					Eur24BlInfoVO eur24BlInfoVO = (Eur24BlInfoVO) command2.searchBlInfo(eur24BlInfoCondVO,account);
//					if(eur24BlInfoVO.getEur24BlGeneralInfoVO().getEuStfFlg().equals("Y")){
//						eventResponse.setETCData("eu_stf_flg",eur24BlInfoVO.getEur24BlGeneralInfoVO().getEuStfFlg());
//					}else{
//						eventResponse.setETCData("eu_stf_flg",eur24BlInfoVO.getEur24BlGeneralInfoVO().getEuStfFlg());
//					}
					if (eur24BlInfoVO.getEur24BlGeneralInfoVO() != null)
						eventResponse.setETCData(eur24BlInfoVO.getEur24BlGeneralInfoVO().getColumnValues());
					if (eur24BlInfoVO.getEur24BlCustVO() != null)
						eventResponse.setETCData(eur24BlInfoVO.getEur24BlCustVO().getColumnValues());
					eventResponse.setRsVoList(eur24BlInfoVO.getEur24BlCntrListVOs());
					eventResponse.setRsVoList(eur24BlInfoVO.getEur24BlDangerCntrListVOs());
					eventResponse.setRsVoList(eur24BlInfoVO.getEur24BlCntrMFListVOs());
					eventResponse.setRsVoList(eur24BlInfoVO.getEur24BlCntrSealNoListVOs());
					// 2010.11.30 김영철 [] R4J - 빈 Block문자들를 점검함.
					// }else
					// if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
					// EsmBkg1107Event event =(EsmBkg1107Event) e;
					// Eur24BlInfoCondVO eur24BlInfoCondVO =
					// event.getEur24BlInfoCondVO();
					// Eur24ManifestDownloadBCImpl command2 = new
					// Eur24ManifestDownloadBCImpl();
					// Eur24BlInfoVO eur24BlInfoVO =(Eur24BlInfoVO)
					// command2.searchBlInfo(eur24BlInfoCondVO);
				}
			} else if (eventName.equalsIgnoreCase("EsmBkg1124Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					EsmBkg1124Event event = (EsmBkg1124Event) e;
					Eur24BlInfoCondVO eur24BlInfoCondVO = event.getEur24BlInfoCondVO();
					Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
					Eur24BlInfoVO eur24BlInfoVO = (Eur24BlInfoVO) command2.searchBlInfoOB(eur24BlInfoCondVO);

					if (eur24BlInfoVO.getEur24BlGeneralInfoVO() != null)
						eventResponse.setETCData(eur24BlInfoVO.getEur24BlGeneralInfoVO().getColumnValues());
					if (eur24BlInfoVO.getEur24BlCustVO() != null)
						eventResponse.setETCData(eur24BlInfoVO.getEur24BlCustVO().getColumnValues());
					eventResponse.setRsVoList(eur24BlInfoVO.getEur24BlCntrListVOs());
					eventResponse.setRsVoList(eur24BlInfoVO.getEur24BlDangerCntrListVOs());
					eventResponse.setRsVoList(eur24BlInfoVO.getEur24BlCntrMFListVOs());
					eventResponse.setRsVoList(eur24BlInfoVO.getEur24BlCntrSealNoListVOs());
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0212 : SEARCH<br>
	 * DG Cargo Manifest List 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		UsaManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			command = new UsaManifestListDownloadBCImpl();
			if (e.getEventName().equalsIgnoreCase("EsmBkg1107Event")) {
				EsmBkg1107Event event = (EsmBkg1107Event) e;
				List<ContainerListRsltVO> list = command.searchContainerList(event.getContainerListCondVO());
				if (event.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					eventResponse.setRsVoList(list);
				} else if (event.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					if (list != null && list.size() > 0) {
						UsaCntrListRsltVO vo = (UsaCntrListRsltVO) list.get(0);
						eventResponse.setETCData("cntr_no", vo.getCntrNo());
						eventResponse.setETCData("cntr_tpsz_cd", vo.getCntrTpszCd());
					}
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1124Event")) {
				EsmBkg1124Event event = (EsmBkg1124Event) e;
				List<ContainerListRsltVO> list = command.searchContainerList(event.getContainerListCondVO());
				if (event.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					eventResponse.setRsVoList(list);
				} else if (event.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					if (list != null && list.size() > 0) {
						UsaCntrListRsltVO vo = (UsaCntrListRsltVO) list.get(0);
						eventResponse.setETCData("cntr_no", vo.getCntrNo());
						eventResponse.setETCData("cntr_tpsz_cd", vo.getCntrTpszCd());
					}
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0037 : MULTI<BR>
	 * Container 정보를 저장한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBlInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			String eventName = e.getEventName();
			if (eventName.equals("EsmBkg1107Event")) {
				EsmBkg1107Event event = (EsmBkg1107Event) e;
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				command2.manageBlInfo((Eur24BlInfoVO) event.getEur24BlInfoVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			} else if (eventName.equals("EsmBkg1124Event")) {
				EsmBkg1124Event event = (EsmBkg1124Event) e;
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				command2.manageBlInfoOB((Eur24BlInfoVO) event.getEur24BlInfoVO(), account);
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
	 * ESM_BKG_0540 : SEARCH02 <br>
	 * DG Cargo Manifest 정보 수정<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Eur24CustomsTransmissionBC command = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		String flatFile = "";
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1104Event")) {
				EsmBkg1104Event event = (EsmBkg1104Event) e;
				command = new Eur24CustomsTransmissionBCImpl();
				// 1.FlatFile을 만들고 2.로그테이블에 Insert
				flatFile = command.transmitVesselArrival((VesselArrivalTransmitVO) event.getEur24VesselArrivalTransmitVO(), account);
				log.info("flatFile : " + flatFile);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1105Event")) {
				EsmBkg1105Event event = (EsmBkg1105Event) e;
				Eur24CustomsTransmissionBCImpl command2 = new Eur24CustomsTransmissionBCImpl();
				// 1.FlatFile을 만들고 2.로그테이블에 Insert
				flatFile = command2.transmitDiversionRequest((VesselArrivalTransmitVO) event.getEur24VesselArrivalTransmitVO(), account);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
			}
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
	 * ESM_BKG_0015 : MULTI01 <br>
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		MdmCustVO mdmCustVO = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1107Event")) {
				EsmBkg1107Event event = (EsmBkg1107Event) e;
				mdmCustVO = command.searchMdmCust(event.getCustCntCd(), event.getCustSeq(), "N");
				String custType = event.getCustType().toLowerCase();
				eventResponse.setETCData(custType + "_cust_nm", mdmCustVO.getName());
				eventResponse.setETCData(custType + "_cust_addr", mdmCustVO.getAddress());
				if (mdmCustVO == null)
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1124Event")) {
				EsmBkg1124Event event = (EsmBkg1124Event) e;
				mdmCustVO = command.searchMdmCust(event.getCustCntCd(), event.getCustSeq(), "N");
				String custType = event.getCustType().toLowerCase();
				eventResponse.setETCData(custType + "_cust_nm", mdmCustVO.getName());
				eventResponse.setETCData(custType + "_cust_addr", mdmCustVO.getAddress());
				if (mdmCustVO == null)
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0029 : SEARCH02<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0210Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
				command = new Eur24ManifestDownloadBCImpl();
				List<ManifestListDetailVO> list = null;
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				list = command.searchManifestList(event.getManifestListCondVO(), account);
				if (list.size() > 0) {
					Eu24ManifestListVO ovo = (Eu24ManifestListVO) list.get(0);
					eventResponse.setETCData("ttl_bl", ovo.getTtlBl());
					eventResponse.setETCData("ttl_err_bl", ovo.getTtlErrBl());
					eventResponse.setETCData("ttl_cntr", ovo.getTtlCntr());
					eventResponse.setETCData("div_pol", ovo.getPol());
					eventResponse.setETCData("div_pod", ovo.getPod());
					eventResponse.setETCData("vps_etd_dt", ovo.getVpsEtdDt());
					eventResponse.setETCData("eu_1st_port", ovo.getEu1stPort());
					eventResponse.setETCData("vps_eta_dt", ovo.getVpsEtaDt());
					eventResponse.setETCData("port_ofc_cd", ovo.getPortOfcCd());

					eventResponse.setETCData("sent_bl_cnt", ovo.getSentBlCnt());
					eventResponse.setETCData("unsent_bl_cnt", ovo.getUnsentBlCnt());
					eventResponse.setETCData("a_cnt", ovo.getACnt());
					eventResponse.setETCData("r_cnt", ovo.getRCnt());
					eventResponse.setETCData("dnl_cnt", ovo.getDnlCnt());
					eventResponse.setETCData("nr_cnt", ovo.getNrCnt());
					eventResponse.setETCData("ata_yn", ovo.getAtaYn());
					eventResponse.setETCData("arn_yn", ovo.getArnYn());
					eventResponse.setETCData("dr_yn", ovo.getDrYn());
					eventResponse.setETCData("trsm_val", ovo.getTrsmVal());
					eventResponse.setETCData("nl_err_msg", ovo.getNlErrMsg());
					eventResponse.setETCData("eta_err_msg", ovo.getEtaErrMsg());
					eventResponse.setETCData("ens_edi_svc_flg", ovo.getEnsEdiSvcFlg());

					eventResponse.setETCData("down_yn_first_of_multi_pofe", ovo.getDownYnFirstOfMultiPofe());
				}
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
				command = new Eur24ManifestDownloadBCImpl();
				List<ManifestListDetailVO> list = null;
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				list = command.searchManifestOBList(event.getManifestListCondVO());
				if (list.size() > 0) {
					Eu24ManifestOBListVO ovo = (Eu24ManifestOBListVO) list.get(0);
					eventResponse.setETCData("ttl_bl", ovo.getTtlBl());
					eventResponse.setETCData("ttl_err_bl", ovo.getTtlErrBl());
					eventResponse.setETCData("ttl_cntr", ovo.getTtlCntr());
					eventResponse.setETCData("div_pol", ovo.getPol());
					eventResponse.setETCData("vps_etd_dt", ovo.getVpsEtdDt());
					eventResponse.setETCData("eu_1st_port", ovo.getEu1stPort());
					eventResponse.setETCData("vps_eta_dt", ovo.getVpsEtaDt());
					eventResponse.setETCData("port_ofc_cd", ovo.getPortOfcCd());

					eventResponse.setETCData("sent_bl_cnt", ovo.getSentBlCnt());
					eventResponse.setETCData("unsent_bl_cnt", ovo.getUnsentBlCnt());
					eventResponse.setETCData("a_cnt", ovo.getACnt());
					eventResponse.setETCData("r_cnt", ovo.getRCnt());
					eventResponse.setETCData("dnl_cnt", ovo.getDnlCnt());
					eventResponse.setETCData("h_cnt", ovo.getHCnt());
					eventResponse.setETCData("l_cnt", ovo.getLCnt());
					eventResponse.setETCData("nr_cnt", ovo.getNrCnt());
					eventResponse.setETCData("ata_yn", ovo.getAtaYn());
					eventResponse.setETCData("arn_yn", ovo.getArnYn());
					eventResponse.setETCData("dr_yn", ovo.getDrYn());

					// eventResponse.setETCData("ens_edi_svc_flg",ovo.getEnsEdiSvcFlg());
					eventResponse.setETCData("exs_edi_svc_flg", ovo.getExsEdiSvcFlg());
				}
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
	 * ESM_BKG_0462 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(Download 데이터) 를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Eur24ManifestDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
				command = new Eur24ManifestDownloadBCImpl();
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command.manageManifest(event.getEu24ManifestListVOs(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
				command = new Eur24ManifestDownloadBCImpl();
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				command.manageManifestOB(event.getEu24ManifestListVOs(), account);
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
	 * ESM_BKG_0061 : MULTI <br>
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm
	 * Indicator를 업데이트 한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Eur24CustomsTransmissionBC command = null;

		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
				log.debug("#################EsmBkg1106Event: sendFlatFile Start");
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24CustomsTransmissionBCImpl();
				// BackEnd
				String key = command.startBackEndJob(account, event.getEu24ManifestTransmitVOs(), "ESM_BKG_1106");
				eventResponse.setETCData("KEY", key);
				log.debug("############################ key:" + key);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
				log.debug("#################EsmBkg1121Event: sendFlatFile Start");
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				command = new Eur24CustomsTransmissionBCImpl();
				// BackEnd
				String key = command.startBackEndJob(account, event.getEu24ManifestTransmitOBVOs(), "ESM_BKG_1121");
				eventResponse.setETCData("KEY", key);
				log.debug("############################ key:" + key);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getMessage());
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
	 * ESM_BKG_0730 : MULTI01 <br>
	 * ESM_BKG_0991 : MULTI <br>
	 * 세관에 적하목록 신고를 EDI를 통해 전송한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifestEXS(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Eur24CustomsTransmissionBC command = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
				// ENS EDI FLAT FILE 생성 및 전송
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				command = new Eur24CustomsTransmissionBCImpl();
				command.transmitManifestOB(event.getEu24ManifestTransmitOBVOs(), account);

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
	 * ESM_BKG_0508 : SEARCH03 <br>
	 * Rotterdam세관에 보낸 edi History 현황정보를 가져온다<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
			EsmBkg1106Event event = (EsmBkg1106Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
			EsmBkg1121Event event = (EsmBkg1121Event) e;
			sKey = event.getKey();
		}
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
					if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
						// Data Transmitted successufully!
						eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
						// eventResponse.setETCData("RESULT",(String)BackEndJobResult.loadFromFile(sKey));

					} else {
						// Data Saved Successfully!!
						eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
					}
					strResult = "SUCCESS";
				} else if ("4".equals(rowSet.getString("JB_STS_FLG"))) {
					// 에러메시지세팅
					if (!"".equals(rowSet.getString("JB_USR_ERR_MSG"))) {
						eventResponse.setUserMessage(rowSet.getString("JB_USR_ERR_MSG"));
					} else {
						eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
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
	 * ESM_BKG_0340 : SEARCH <br>
	 * ESM_BKG_0340 : SEARCH03 <br>
	 * ESM_BKG_0341 : SEARCH <br>
	 * ESM_BKG_0341 : SEARCH03 <br>
	 * 
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEuOBVvdByBL(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<ManifestListDetailVO> list = null;
		try {
			// String eventName = e.getEventName();
			EsmBkg1121Event event = (EsmBkg1121Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			list = command.searchEuOBVvdByBL(event.getManifestListCondVO());

			eventResponse.setETCData("pol_cnt", list.size() + "");
			if (list.size() > 0) {
				Eu24ManifestListVO vo = (Eu24ManifestListVO) list.get(0);
				eventResponse.setETCData("vvd_cnt", vo.getVvdCnt());
				eventResponse.setETCData("vvd", vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd());
				eventResponse.setETCData("pol", vo.getPol());
				eventResponse.setETCData("pol_yd", vo.getPolYdCd());
				eventResponse.setETCData("pod", vo.getPod());
				eventResponse.setETCData("pod_yd", vo.getPodYdCd());
			} else {
				eventResponse.setETCData("vvd_cnt", "0");
				eventResponse.setETCData("vvd", "");
				eventResponse.setETCData("pol", "");
				eventResponse.setETCData("pol_yd", "");
				eventResponse.setETCData("pod", "");
				eventResponse.setETCData("pod_yd", "");
			}
			eventResponse.setRsVoList(list);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	// searchCstmsENSPofeList
	/**
	 * ESM_BKG_1106 : SEARCH01<BR>
	 * VVD FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEU24CountryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				List<Eu24CountryListVO> list = command.searchEU24CountryList(event.getEu24CountryListVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				List<Eu24CountryListVO> list = command.searchEU24CountryList(event.getEu24CountryListVO());
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
	 * ESM_BKG_1115 : SEARCH<BR>
	 * Europe Advanced Manifest-Error Code Table 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchENSMonitoring(Event e) throws EventException {
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1120Event event = (EsmBkg1120Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<Eu24EnsListVO> list = command.searchENSMonitoring(event.getEu24EnsListVO());
			if (list.size() > 0) {
				Eu24EnsListVO ovo = (Eu24EnsListVO) list.get(0);
				eventResponse.setETCData("total_bl_cnt", ovo.getTotalBlCnt());
				eventResponse.setETCData("acc_bl_cnt", ovo.getAccBlCnt());
				eventResponse.setETCData("rej_bl_cnt", ovo.getRejBlCnt());
				eventResponse.setETCData("nrcv_bl_cnt", ovo.getNrcvBlCnt());
				eventResponse.setETCData("donld_bl_cnt", ovo.getDonldBlCnt());
				eventResponse.setETCData("unsent_bl_cnt", ovo.getUnsentBlCnt());
				eventResponse.setETCData("total_amd_cnt", ovo.getTotalAmdCnt());
				eventResponse.setETCData("total_ens_amt", ovo.getTotalEnsAmt());
				eventResponse.setETCData("total_shaas_ens", ovo.getTotalShaasEns());
				eventResponse.setETCData("total_nycna_ens", ovo.getTotalNycnaEns());
				eventResponse.setETCData("total_hamur_ens", ovo.getTotalHamurEns());
				eventResponse.setETCData("total_sinwa_ens", ovo.getTotalSinwaEns());
				eventResponse.setETCData("total_mcf_amt", ovo.getTotalMcfAmt());
				eventResponse.setETCData("total_shaas_mcf", ovo.getTotalShaasMcf());
				eventResponse.setETCData("total_nycna_mcf", ovo.getTotalNycnaMcf());
				eventResponse.setETCData("total_hamur_mcf", ovo.getTotalHamurMcf());
				eventResponse.setETCData("total_sinwa_mcf", ovo.getTotalSinwaMcf());
				eventResponse.setETCData("total_vvd_cnt", ovo.getTotalVvdCnt());

			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1120 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode1120(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		// RHQ
		List<BkgComboVO> list = command.searchRgnOfficeCd();
		List<BkgComboVO> list2 = new ArrayList<BkgComboVO>();
		BkgComboVO vo = new BkgComboVO();

		// default
		vo.setVal("");
		vo.setDesc("");
		vo.setName("");
		list2.add(vo);
		for (int j = 0; j < list.size(); j++) {
			list2.add(list.get(j));
		}

		eventResponse.setRsVoList(list2);
		return eventResponse;
	}

	/**
	 * ESM_BKG_1113 : SEARCH<BR>
	 * Transmit / Receive History 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEU24RcvErrorCodeTable(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1115Event event = (EsmBkg1115Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<EU24RcvErrorCodeTableVO> list = command.searchEU24RcvErrorCodeTable(event.getEU24RcvErrorCodeTableVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1108 : SEARCH01<BR>
	 * VVD FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomsSetupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1109Event event = (EsmBkg1109Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<CustomsSetupVO> list = command.searchCustomsSetupList(event.getCustomsSetupVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1109 : SEARCH<BR>
	 * Europe Advanced Manifest - MDM LOCATION 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmLocationPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1109Event event = (EsmBkg1109Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<CustomsSetupVO> list = command.searchMdmLocationPort(event.getCustomsSetupVO().getPCntCd());
			CustomsSetupVO combovo = new CustomsSetupVO();
			combovo.setPortCd("All");
			list.add(0, combovo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1109 : SEARCH<BR>
	 * Europe Advanced Manifest - MDM YARD 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmYardTmlcode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1109Event event = (EsmBkg1109Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<CustomsSetupVO> list = command.searchMdmYardTmlcode(event.getCustomsSetupVO().getPPort());
			CustomsSetupVO combovo = new CustomsSetupVO();
			combovo.setYdCd("All");
			list.add(0, combovo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1109 : SAVE <br>
	 * Europe Customs 코드관리
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEU24CustomsSetup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Eur24ManifestDownloadBC command = null;
		try {
			command = new Eur24ManifestDownloadBCImpl();
			EsmBkg1109Event event = (EsmBkg1109Event) e;
			begin();
			command.manageEU24CustomsSetup(event.getCustomsSetupVOs(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0503 : Retrieve<br>
	 * Transmit Cross-Check 조회
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageVesselArrival(Event e) throws EventException {
		Eur24ManifestDownloadBCImpl command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			String eventName = e.getEventName();
			if (eventName.equalsIgnoreCase("EsmBkg1104Event")) {
				EsmBkg1104Event event = (EsmBkg1104Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				command.manageVesselArrival((Eur24VesselArrivalNoticeDetailVO) event.getVesselArrivalDetailVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			} else if (eventName.equalsIgnoreCase("EsmBkg1105Event")) {
				EsmBkg1105Event event = (EsmBkg1105Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				command.manageVesselArrival((Eur24VesselArrivalNoticeDetailVO) event.getVesselArrivalDetailVO(), account);
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
	 * ESM_BKG_1094 : MULTI <br>
	 * Vessel Arrival 정보를 생성 및 수정한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteAllMrn(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();

			EsmBkg1104Event event = (EsmBkg1104Event) e;
			Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
			command2.deleteAllMrn((Eur24VesselArrivalNoticeDetailVO) event.getVesselArrivalDetailVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

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
	 * ESM_BKG_1178 : IBSEARCH <br>
	 * CRN 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsENSPofeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<ManifestListDetailVO> list = null;
		try {
			String eventName = e.getEventName();
			if (eventName.equalsIgnoreCase("EsmBkg1105Event")) {
				EsmBkg1105Event event = (EsmBkg1105Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchCstmsENSPofeList(event.getManifestListCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1108 : SEARCH<BR>
	 * Europe Advanced Manifest - ENS REPORT 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsOfficeIdByPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1105Event")) { // EUR24
																		// -
																		// Original
																		// port에
																		// 따른
																		// Yard/Office조회
				Eur24ManifestDownloadBCImpl command3 = new Eur24ManifestDownloadBCImpl();
				List<Eur24VesselArrivalNoticeDetailVO> voList = null;
				EsmBkg1105Event event = (EsmBkg1105Event) e;
				voList = command3.searchCstmsOfficeIdByPort((String) event.getRvis_n1st_clpt_cd());
				eventResponse.setRsVoList(voList);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0063 : SEARCH <br>
	 * ESM_BKG_0186 : SEARCH01 <br>
	 * ESM_BKG_0613 : SEARCH <br>
	 * ESM_BKG_0013 : SEARCH<BR>
	 * 세관 신고용 VVD 정보 조회<br>
	 * 
	 * @param Event
	 *            event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMrnNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			String eventName = e.getEventName();
			if (eventName.equals("EsmBkg1107Event")) {
				EsmBkg1107Event event = (EsmBkg1107Event) e;
				Eur24ManifestDownloadBCImpl command = new Eur24ManifestDownloadBCImpl();

				Eur24BlInfoCondVO vo = event.getEur24BlInfoCondVO();
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				vo.setMrnFlg("D");
				command.manageMrnNo(vo);
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
	 * ESM_BKG_1107 : MULTI03 <br>
	 * 메뉴얼 MRN 재입력<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reactivateMrnNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			String eventName = e.getEventName();
			if (eventName.equals("EsmBkg1107Event")) {
				EsmBkg1107Event event = (EsmBkg1107Event) e;
				Eur24ManifestDownloadBCImpl command = new Eur24ManifestDownloadBCImpl();

				Eur24BlInfoCondVO vo = event.getEur24BlInfoCondVO();
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				vo.setMrnFlg("A");
				command.reactivateMrnNo(vo);
				// command.reactivateMrnNo((Eur24BlInfoCondVO)
				// event.getEur24BlInfoCondVO());
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
	 * ESM_BKG_1135 : SEARCH <br>
	 * ROCS 의 CRN List 화면에서 Lane 을 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsRcvMsg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1112Event")) { // EUR24
																		// -
																		// 구주세관
																		// ACK
																		// 수신
				Eur24ManifestDownloadBCImpl command3 = new Eur24ManifestDownloadBCImpl();
				List<Eur24RcvMsgVO> voList = null;
				EsmBkg1112Event event = (EsmBkg1112Event) e;
				voList = command3.searchCstmsRcvMsg((Eur24VesselArrivalCondVO) event.getVesselArrivalCondVO());
				eventResponse.setRsVoList(voList);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0215 : SEARCH<BR>
	 * 한국세관 BKG_CSTMS_KR_BL table에 Data가 Insert되거나 Delete 될 경우에, <Br>
	 * BKG_CSTMS_KR_DL_HIS Table에 History를 조회한다.<Br>
	 * 
	 * @param Event
	 *            event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchENSReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1108Event event = (EsmBkg1108Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<Eu24EnsListVO> list = command.searchENSReport(event.getEu24EnsListVO());
			if (list.size() > 0) {
				Eu24EnsListVO ovo = (Eu24EnsListVO) list.get(0);
				eventResponse.setETCData("total_bl_cnt", ovo.getTotalBlCnt());
				eventResponse.setETCData("sent_bl_cnt", ovo.getSentBlCnt());
				eventResponse.setETCData("unsent_bl_cnt", ovo.getUnsentBlCnt());
				// eventResponse.setETCData("sent_success_cnt",ovo.getSentSuccessCnt());
				// eventResponse.setETCData("sent_fail_cnt",ovo.getSentFailCnt());
				eventResponse.setETCData("a_cnt", ovo.getACnt());
				eventResponse.setETCData("r_cnt", ovo.getRCnt());
				eventResponse.setETCData("dnl_cnt", ovo.getDnlCnt());
				eventResponse.setETCData("nr_cnt", ovo.getNrCnt());

			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1120 : SEARCH<BR>
	 * Europe Advanced Manifest - ENS MONITORING 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcLaneByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1108Event event = (EsmBkg1108Event) e;
			String result = command.searchSvcLaneByVvd(event.getEu24EnsListVO().getPVvd());
			if (result != null && !result.equals("")) {
				eventResponse.setETCData("p_lane", result);
			} else {
				eventResponse.setETCData("p_lane", "");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_1109 : SEARCH<BR>
	 * Europe Advanced Manifest - Europe Customs 등록 코드 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifestENS(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Eur24CustomsTransmissionBC command = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
				// ENS EDI FLAT FILE 생성 및 전송
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24CustomsTransmissionBCImpl();
				command.transmitManifest(event.getEu24ManifestTransmitVOs(), account);

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
	 * ESM_BKG_1106 : DELETE<BR>
	 * Europe Advanced Manifest - Manifest 삭제<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteManifestENS(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Eur24ManifestDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성 
			if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
				// ENS EDI FLAT FILE 생성 및 전송
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				command.deleteManifest( event.getEu24ManifestListVOs());
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
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
	 * ESM_BKG_1121 : DELETE<BR>
	 * Europe Advanced Manifest - Manifest 삭제<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteManifestEXS(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Eur24ManifestDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
				// ENS EDI FLAT FILE 생성 및 전송
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				command.deleteManifestEXS( event.getEu24ManifestListVOs());
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
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
	 * 
	 * ESM_BKG_1121 : MULTI03 <br>
	 * 단건씩 전송 Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse search1stEUvvdByBL(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<ManifestListDetailVO> list = null;
		try {
			String eventName = e.getEventName();
			if (eventName.equalsIgnoreCase("EsmBkg1106Event")) {
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.search1stEUvvdByBL(event.getManifestListCondVO());
			} else if (eventName.equalsIgnoreCase("EsmBkg1121Event")) {
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchEuPolByVvd(event.getManifestListCondVO());
			}
			if (list != null) {
				eventResponse.setETCData("bl_cnt", list.size() + "");
				if (list.size() > 0) {
					Eu24ManifestListVO vo = (Eu24ManifestListVO) list.get(0);
					eventResponse.setETCData("vvd", vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd());
					eventResponse.setETCData("pol", vo.getPol());
					eventResponse.setETCData("pol_yd", vo.getPolYdCd());
				} else {
					eventResponse.setETCData("vvd", "");
					eventResponse.setETCData("pol", "");
					eventResponse.setETCData("pol_yd", "");
				}
				eventResponse.setRsVoList(list);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1106 : SEARCH01<BR>
	 * VVD FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreEUportByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<ManifestListDetailVO> list = null;
		try {
			String eventName = e.getEventName();
			if (eventName.equalsIgnoreCase("EsmBkg1106Event")) {
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchPreEUportByVvd(event.getManifestListCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1106 : SEARCH07<BR>
	 * Finland (IE344) / VVD FocusOut 시, 해당하는 vvd 의 pre EU Port 를 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreEUvvdByBL(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Eur24ManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<ManifestListDetailVO> list = null;
		try {
			String eventName = e.getEventName();
			if (eventName.equalsIgnoreCase("EsmBkg1106Event")) {
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchPreEUvvdByBL(event.getManifestListCondVO());
			}
			if (list != null) {
				eventResponse.setETCData("bl_cnt", list.size() + "");
				if (list.size() > 0) {
					Eu24ManifestListVO vo = (Eu24ManifestListVO) list.get(0);
					eventResponse.setETCData("vvd", vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd());
					eventResponse.setETCData("pol", vo.getPol());
					eventResponse.setETCData("pol_yd", vo.getPolYdCd());
					eventResponse.setETCData("pod", vo.getPod());
					eventResponse.setETCData("pod_yd", vo.getPodYdCd());
				} else {
					eventResponse.setETCData("vvd", "");
					eventResponse.setETCData("pol", "");
					eventResponse.setETCData("pol_yd", "");
					eventResponse.setETCData("pod", "");
					eventResponse.setETCData("pod_yd", "");
				}
				eventResponse.setRsVoList(list);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1164 : Retrieve<br>
	 * Draft BL 및 Waybill 전송을 위한 Outbound booking list를 조회한다.(ESM_BKG_1164)<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */

	/**
	 * OpusbkgUbizcomEur24cusAck : <br>
	 * OpusbkgUbizcomEur24cusAckEvent : <br>
	 * ANCS EDI loging ACk.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadCstmsRcvMsg(Event e) throws EventException {
		log.info("SC [loadCstmsRcvMsg] Start---------------------");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Eur24CustomsTransmissionBC command = null;
		try {
			// if(!e.getEventName().equalsIgnoreCase("Ubiz2comOpusbkgAmsAckEvent")){
			begin();
			// }
			// creating Impl each event
			if (e.getEventName().equalsIgnoreCase("OpusbkgUbizcomEur24cusAckEvent")) { // Eur
																						// -
																						// ETA
				OpusbkgUbizcomEur24cusAckEvent event = (OpusbkgUbizcomEur24cusAckEvent) e;
				command = new Eur24CustomsTransmissionBCImpl();
				command.loadCstmsRcvMsg(event.getFlatFile(), "");
			}
			commit();
		} catch (EventException ex) {
			log.error("EventException : " + ex.getMessage());
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("Exception : " + ex.getMessage());
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		log.info("SC [loadCstmsRcvMsg] End---------------------");
		return eventResponse;
	}

}// end class
