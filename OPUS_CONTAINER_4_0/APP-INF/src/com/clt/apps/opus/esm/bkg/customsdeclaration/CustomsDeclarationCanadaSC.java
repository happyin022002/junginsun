/*=========================================== 
 * Copyright(c) 2009 CyberLogitec
 * @FileName : CustomsDeclarationSC.java
 * @FileTitle : ESM_BKG_0017
 * Open Issues :
 * Change history : 
 * @LastModifyDate : 2011.06.01
 * @LastModifier : 민정호
 * @LastVersion : 1.1
 * 2009.04.21 김승민
 * 1.0 Creation
 */
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchLocationCodeVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.common.Constants;
import com.clt.apps.opus.esm.bkg.common.CountryCode;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.basic.CndCustomsReportBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.basic.CndCustomsReportBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.event.EsmBkg0025Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.event.EsmBkg0401Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.event.EsmBkg1125Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.basic.CndCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.basic.CndCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0002Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0028Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0142Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0431Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0434Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0500Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0501Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.OpusbkgEdiErrCaReceiveEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.UbizcomOpusBkgCancusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndLogDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndVesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.StiDetailCndVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.basic.UsaCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.basic.UsaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg1023Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaCstmsManifestAmendmentVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTmlBlByVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.basic.AncsManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.basic.AncsManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0063Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0551Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.ESM0740001Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0013Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0015Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0016Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0029Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0249Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg1178Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndBlDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlMainVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVslCrnNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndVesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.AvcNoteSetUpInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlTransmitVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.MdmYardVO;

/**
 * OPUS-CustomsDeclarationCanadaSC Business Logic ServiceCommand
 * - OPUS-CustomsDeclarationCanadaSC handling business transaction.
 *
 * @author KIM MINJUNG
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationCanadaSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationCanadaSC system <br>
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
	 * CustomsDeclarationCanadaSC system <br>
	 * ESM_BKG-0017 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationCanadaSC 종료");
	}

	/**
	 *
	 * OPUS-CustomsDeclarationCanadaSC system <br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		log.info("[SC.perform] Start ---------------------------");
		log.info("[SC.perform] e.getEventName() : " + e.getEventName());
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmBkg1178Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgCstmsCndVslCrnNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = removeBkgCstmsCndVslCrnNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0249Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCstmsVvdDtlList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchUiSetUpInfo(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = inquiryBlData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY) || e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = manageCstmsBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE) || e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = manageCstmsBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02) || e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = manageBkgReferenceNumberGeneration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				// DEL_CD 입력후 HUB, Location of Goods조회
				eventResponse = searchHubInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				// DEL_CD 입력후 HUB, Location of Goods조회
				eventResponse = searchMdmCust(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVessel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVessel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = transmitVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitActualVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitVesselArrival(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchUiSetUpInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsVvdInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCstmsMfDtlList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsVvdInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = createCstmsVvdRefNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("ESM0740001Event")) {
			eventResponse = loadVslCertiExpDt(e);
		} else if (e.getEventName().equalsIgnoreCase("UbizcomOpusBkgCancusAckEvent")) {
			eventResponse = loadCstmsRcvMsg(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0501Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsSndLogDtl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0500Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsSndHisList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0434Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsRcvLogDtl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0431Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsRcvHisList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0142Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				response.setRsVoList(searchHardCoding(Constants.HrdCdgId.CND_RESULT_CODE));
				eventResponse = response;
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsTrsmRsltList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCstmsDoNotLoadAndRemoveList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCstmsHoldAndRemoveList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {            // Retrieve
				eventResponse = searchCstmsManifestAmendment(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {    // Transmit - Start AI
				eventResponse = transAmendManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {    // Transmit -Immediate Delete & AI
				eventResponse = transDelAmendManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {    // Save
				eventResponse = manageCstmsAmendManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestDtlList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// Receiver ID 콤보
				response.setRsVoList(searchComCodeCombo("CD02299"));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1125Event")) { // 2011.07.13 추가
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchACIMonitor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode1125(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0401Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfcSetInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageOfcSetInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeOfcSetInfo(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmBkg1023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStowageManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLastForeignPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitStowageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCrnNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				response.setRsVoList(searchHardCoding(Constants.HrdCdgId.CND_AN_TP_CD));
				eventResponse = response;
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageAvcNoteSetUpInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = manageAvcNoteSetUpInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = manageAvcNoteSetUpInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmCust(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchCstmsAvcNotesPrnTpList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("OpusbkgEdiErrCaReceiveEvent")) {
			eventResponse = loadEdiErr(e);
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 *
	 *
	 * @param Event e
	 * @throws EventException
	 */
	private EventResponse loadEdiErr(Event e) throws EventException {
		log.info("SC [loadEdiErr] Start---------------------");

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = null;

		try {
			begin();

			// Canada 수신
			OpusbkgEdiErrCaReceiveEvent event = (OpusbkgEdiErrCaReceiveEvent) e;
			command = new CndCustomsTransmissionBCImpl();
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
	 * ESM_BKG_1178 : IBSEARCH <br>
	 * CRN<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchBkgCstmsCndVslCrnNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CndManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1178Event")) {
				EsmBkg1178Event event = (EsmBkg1178Event) e;
				command = new CndManifestListDownloadBCImpl();
				List<CndCstmsVslCrnNoVO> cndCstmsVslCrnNoVO = (List<CndCstmsVslCrnNoVO>) (Object) (command.searchBkgCstmsCndVslCrnNo((CndCstmsVslCrnNoVO) event.getCndCstmsVslCrnNoVO()));
				// if (cndCstmsVslCrnNoVO.size() == 0)
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00889").getUserMessage());
				eventResponse.setRsVoList(cndCstmsVslCrnNoVO);
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EsmBkg1178Event management event process<br>
	 * CRN Information Delete<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeBkgCstmsCndVslCrnNo(Event e) throws EventException {
		EsmBkg1178Event event = (EsmBkg1178Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndManifestListDownloadBC command = new CndManifestListDownloadBCImpl();

		try {
			begin();

			command.removeBkgCstmsCndVslCrnNo(event.getCndCstmsVslCrnNoVO());
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());

			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0249 : SEARCH<BR>
	 * ESM_BKG_0551 : SEARCH<BR>
	 * searching VVD list<br>
	 *
	 * @param cstmsVvdInfoCondVO
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsVvdList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0249Event")) {
				EsmBkg0249Event event = (EsmBkg0249Event) e;
				command = new CndManifestListDownloadBCImpl();
				List<CstmsVvdVO> list = command.searchCstmsVvdList(event.getCstmsVvdListCondVO());
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
	 * ESM_BKG_0551 : SEARCH01<BR>
	 * searching VVD list<br>
	 *
	 * @param cstmsVvdInfoCondVO
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsVvdDtlList(Event e) throws EventException { // v2.0
																					// 지울지
																					// 말지
																					// 확인
																					// 해봐야
																					// 할듯
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsManifestListDownloadBC command = null;
		try {
			EsmBkg0551Event event = (EsmBkg0551Event) e;
			command = new AncsManifestListDownloadBCImpl();
			List<CstmsVvdDtlVO> list = command.searchCstmsVvdDtlList(event.getAncsCstmsVvdDtlListCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0434 : SEARCH<BR>
	 * Receive History Detail<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndManifestListDownloadBC command = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0002Event")) {
				EsmBkg0002Event event = (EsmBkg0002Event) e;
				command = new CndManifestListDownloadBCImpl();
				event.getCstmsBlVOs()[0].setPgmNo("ESM_BKG_0002");
				command.manageCstmsBl(event.getCstmsBlVOs(), account);
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
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm Indicator를 업데이트 한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUiSetUpInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0013Event")) {
				// 하드코딩 테이블 정보조회(Util이 만들어지면 교체)
				BookingUtil bkgUtil = new BookingUtil();
				BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
				hrdCdgVO.setHrdCdgId(Constants.HrdCdgId.CND_CSTMS_CRR_CD);
				List<BkgHrdCdgCtntVO> listUtil = bkgUtil.searchHardCoding(hrdCdgVO);
				for (int i = 0; i < listUtil.size(); i++) {
					BkgHrdCdgCtntVO vo = (BkgHrdCdgCtntVO) listUtil.get(i);
					eventResponse.setETCData(vo.getAttrCtnt1(), vo.getAttrCtnt2());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0029Event")) {
				// WGT 단위콤보
				eventResponse.setRsVoList(searchComCodeCombo("CD00775"));
				// trsp_tp_id 콤보
				eventResponse.setRsVoList(searchHardCoding(Constants.HrdCdgId.TRSPT_TP_ID));
				// 개발자 User Id 조회(Stage 수정권한)
				BookingUtil bkgUtil = new BookingUtil();
				BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
				hrdCdgVO.setHrdCdgId(Constants.HrdCdgId.SCR_ROLE_DEF);
				hrdCdgVO.setAttrCtnt1("CND_CSTMS_BL_INQ_STS_UPD");
				hrdCdgVO.setAttrCtnt2("USR_ID");
				hrdCdgVO.setAttrCtnt3(account.getUsr_id());
				hrdCdgVO.setAttrCtnt4("Y");
				eventResponse.setRsVoList(bkgUtil.searchHardCoding(hrdCdgVO));

			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1008 : MULTI<BR>
	 * User Auth List 정보수정<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse inquiryBlData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CndManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// 이벤트별 Impl 생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0029Event")) {
				EsmBkg0029Event event = (EsmBkg0029Event) e;
				command = new CndManifestListDownloadBCImpl();
				List<BlDetailVO> list = command.inquiryBlData(event.getCndCstmsBlCondVO());
				if (list.size() > 0) {
					CndBlDetailVO vo = (CndBlDetailVO) list.get(0);
					eventResponse.setRsVo(vo.getCndCstmsBlMainVO());
					eventResponse.setRsVo(vo.getCndCstmsBlCustVO());
					eventResponse.setRsVoList(vo.getCndCstmsBlCstmsRsltVOs());
					eventResponse.setRsVoList(vo.getCndCstmsBlHblListVOs());
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
	 * ESM_BKG_0018 : MULTI <br>
	 * ESM_BKG_0016 : MULTI <br>
	 * Panama를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해 사전 VVD INFORMATION을 입력한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0029Event")) {
				EsmBkg0029Event event = (EsmBkg0029Event) e;
				command = new CndManifestListDownloadBCImpl();
				String msgCd = "BKG00166";
				if (e.getFormCommand().isCommand(FormCommand.REMOVE) || e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
					/*************************************************
					 * ESM_BKG_0002 : MF_STS_CD 수정 ESM_BKG_0029 : MF_STS_CD, CSTMS_TRSM_STS_CD 수정
					 *************************************************/
					event.getCstmsBlVOs()[0].setPgmNo("ESM_BKG_0002");
					if ("D".equals(((CndCstmsBlVO) (event.getCstmsBlVOs()[0])).getMfStsCd())) {
						msgCd = "BKG00593";
					}
				}
				// 수정
				command.manageCstmsBl(event.getCstmsBlVOs(), account);
				// 저장성공메시지
				eventResponse.setUserMessage(new ErrorHandler(msgCd).getUserMessage());
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
	 * ESM_BKG_0063 : SEARCH02 <br>
	 * 세관 적하 목록 상세 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = null;
		// ManifestListDownloadBC maniCommand = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0002Event")) {
				EsmBkg0002Event event = (EsmBkg0002Event) e;
				// BackEnd
				command = new CndCustomsTransmissionBCImpl();
				event.getManifestTransmitVO().setPgmNo("ESM_BKG_0002");
				String key = command.transmitManifest(event.getManifestTransmitVO(), account);
				eventResponse.setETCData("KEY", key);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0029Event")) {
				EsmBkg0029Event event = (EsmBkg0029Event) e;
				String sFlatFile = null;
				if (event.getFormCommand().isCommand(FormCommand.MODIFY02)) {
					/***********************************************************
					 * BKG_CSTMS_ADV_BL 테이블 수정
					 ***********************************************************/
					CndCstmsBlMainVO cndCstmsBlMainVO = event.getCndCstmsBlMainVO();
					CndManifestModificationVO[] cndManifestListDetailVO = new CndManifestModificationVO[1];
					cndManifestListDetailVO[0] = new CndManifestModificationVO();
					cndManifestListDetailVO[0].setPgmNo("ESM_BKG_0029");
					cndManifestListDetailVO[0].setBlNo(cndCstmsBlMainVO.getBlNo());
					if ("D".equals(cndCstmsBlMainVO.getMfStsCd())) {
						cndManifestListDetailVO[0].setCstmsTrsmStsCd("03");
					} else if ("".equals(cndCstmsBlMainVO.getCstmsTrsmStsCd())) {
						cndManifestListDetailVO[0].setCstmsTrsmStsCd("00");
					} else {
						cndManifestListDetailVO[0].setCstmsTrsmStsCd("04");
					}
					//new CndManifestListDownloadBCImpl().manageManifest(cndManifestListDetailVO, account);    // 2016.08.23 중복호출로 인한 주석처리
					/***********************************************************
					 * FlatFile 만들기, 로그테이블 저장
					 ***********************************************************/
					command = new CndCustomsTransmissionBCImpl();
					CndCstmsManifestVO cndCstmsManifestVO = (CndCstmsManifestVO) event.getManifestTransmitVO();
					cndCstmsManifestVO.setMiSndDt(cndManifestListDetailVO[0].getEdiSndDt());
					sFlatFile = command.transmitManifest(cndCstmsManifestVO, account);    // 내부에서 command1.manageManifest() 호출
				} else if (event.getFormCommand().isCommand(FormCommand.MODIFY03)) {
					// 현재날짜를 가져오기 위해서
					CndManifestListDownloadBC command1 = new CndManifestListDownloadBCImpl();
					CndManifestModificationVO[] cndManifestListDetailVO = new CndManifestModificationVO[1];
					cndManifestListDetailVO[0] = new CndManifestModificationVO();
					cndManifestListDetailVO[0].setPgmNo("Terminal_Trans");
					command1.manageManifest(cndManifestListDetailVO, account);
					/***********************************************************
					 * FlatFile 만들기, 로그테이블 저장
					 ***********************************************************/
					command = new CndCustomsTransmissionBCImpl();
					CndCstmsManifestVO cndCstmsManifestVO = (CndCstmsManifestVO) event.getManifestTransmitVO();
					cndCstmsManifestVO.setMiSndDt(cndManifestListDetailVO[0].getEdiSndDt());
					cndCstmsManifestVO.setIbflag("Terminal");
					sFlatFile = command.transmitManifest(cndCstmsManifestVO, account);
				}
				/***********************************************************
				 * EDI transmitting START
				 ***********************************************************/
				if (sFlatFile != null) {
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(sFlatFile);
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CANCUS.IBMMQ.QUEUE"));
					BookingUtil utilCommand = new BookingUtil();
					FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E"))
						throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
				}
				// 성공메시지 세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
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
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBkgReferenceNumberGeneration(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0029Event")) {
				BookingUtil utilBC = new BookingUtil();
				BkgReferenceNoGenerationVO bkgReferenceNoGenerationVO = utilBC.manageBkgReferenceNumberGeneration("CAD", account.getOfc_cd(), account.getUsr_id());
				eventResponse.setETCData("dummy_bl_no", bkgReferenceNoGenerationVO.getCadNo());
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
	 * ESM_BKG_0428 <br>
	 * 미국 현재 날짜 가져오기<br>
	 *
	 * @return String
	 * @exception EventException
	 */
	private EventResponse searchHubInfo(Event e) throws EventException {
		CndManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0029Event event = (EsmBkg0029Event) e;
			command = new CndManifestListDownloadBCImpl();
			String[] arrHubInfo = command.searchHubInfo(event.getPodCd(), event.getDelCd(), event.getPodNodCd());
			eventResponse.setETCData("hub_loc_cd", arrHubInfo[0]);
			eventResponse.setETCData("ibd_loc_gds_desc", arrHubInfo[1]);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0457 : MULTI <br>
	 * VVD,Port 등 입력 후 조회한 세관 CMF 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		MdmCustVO mdmCustVO = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0025Event")) {
				EsmBkg0025Event event = (EsmBkg0025Event) e;
				mdmCustVO = command.searchMdmCust(event.getCndCstmsReportVO().getCustSeq().substring(0, 2), event.getCndCstmsReportVO().getCustSeq().substring(2), "Y");
				if (mdmCustVO != null) {
					eventResponse.setETCData("cust_nm", mdmCustVO.getName());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0029Event")) {
				EsmBkg0029Event event = (EsmBkg0029Event) e;
				if ("D".equals(event.getCustTp())) {
					// Delivery의 경우 Yard 와 Location정보
					MdmYardVO mdmYardVO = new MdmYardVO();
					mdmYardVO.setYdCd(event.getCustCntCd() + event.getCustSeq());
					List<MdmYardVO> listYard = command.searchYardCode(mdmYardVO);
					if (listYard.size() > 0) {
						eventResponse.setETCData("cust_nm", listYard.get(0).getYdNm());
						eventResponse.setETCData("cust_addr", listYard.get(0).getYdAddr());
						SearchLocationCodeVO locVO = command.searchLocationCode(listYard.get(0).getLocCd());
						if (locVO != null) {
							eventResponse.setETCData("loc_nm", locVO.getLocNm());
							eventResponse.setETCData("ste_cd", locVO.getSteCd());
							eventResponse.setETCData("cnt_cd", locVO.getCntCd());
							eventResponse.setETCData("zip_cd", listYard.get(0).getZipCd());
						}
					} else {
						throw new EventException(new ErrorHandler("BKG00651", new String[] { "Location or Node code" }).getMessage());
					}
				} else {
					mdmCustVO = command.searchMdmCust(event.getCustCntCd(), event.getCustSeq(), "N");
					if (mdmCustVO != null) {
						eventResponse.setETCData("cust_nm", mdmCustVO.getName());
						eventResponse.setETCData("cust_addr", mdmCustVO.getAddress());
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
	 * ESM_BKG_0029 : SEARCH02<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CndManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0016Event")) {
				EsmBkg0016Event event = (EsmBkg0016Event) e;
				command = new CndManifestListDownloadBCImpl();
				List<VesselVO> list = command.searchVessel(event.getVesselCondVO());
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
	 * ESM_BKG_0249 : SEARCH<BR>
	 * ESM_BKG_0551 : SEARCH<BR>
	 * 세관 신고용 VVD 목록 조회<br>
	 *
	 * @param cstmsVvdInfoCondVO
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CndManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0016Event")) {
				EsmBkg0016Event event = (EsmBkg0016Event) e;
				command = new CndManifestListDownloadBCImpl();
				command.manageCstmsVesselInfo(event.getVesselInfoVOs(), account);
				eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
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
	 * ESM_BKG_0018 : SEARCH <br>
	 * ESM_BKG_0016 : SEARCH <br>
	 * Panama를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해 등록했던 Vessel 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndManifestListDownloadBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0015Event")) {
				EsmBkg0015Event event = (EsmBkg0015Event) e;
				command = new CndManifestListDownloadBCImpl();
				eventResponse.setRsVoList(command.searchVesselArrival(event.getVesselArrivalCondVO()));
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
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVesselArrival(Event e) throws EventException {
		CndManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0015Event")) {
				EsmBkg0015Event event = (EsmBkg0015Event) e;
				command = new CndManifestListDownloadBCImpl();
				command.manageVesselArrival(event.getVeseelArrivalVO(), account);
				eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
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
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0015Event")) {
				EsmBkg0015Event event = (EsmBkg0015Event) e;
				command = new CndCustomsTransmissionBCImpl();
				CndVesselArrivalTransmitVO vo = (CndVesselArrivalTransmitVO) event.getVesselArrivalTransmitVO();
				/***********************************************************
				 * VesselArrival에 send date 수정
				 ***********************************************************/
				CndManifestListDownloadBC vslBC = new CndManifestListDownloadBCImpl();
				CndVesselArrivalVO vslVO = new CndVesselArrivalVO();
				vslVO.setVslCd(vo.getVslCd());
				vslVO.setSkdVoyNo(vo.getSkdVoyNo());
				vslVO.setSkdDirCd(vo.getSkdDirCd());
				vslVO.setCapNm(vo.getCapNm());
				vslVO.setVpsEtaDt(vo.getVpsEtaDt());
				vslVO.setVpsPortCd(vo.getVpsPortCd()); // CRN 관련 로직 추가
				// vslVO.setVslArrRptSndDt(); //GMT 시간 세팅은
				// manageVesselArrival안에서 함
				vslBC.manageVesselArrival(vslVO, account);
				/***********************************************************
				 * 1.FlatFile을 만들고 2.EDI 전송 3.로그테이블에 Insert
				 ***********************************************************/
				vo.setVslArrRptSndDt(vslVO.getVslArrRptSndDt());
				String sFlatFile = command.transmitVesselArrival(vo, account);
				/***********************************************************
				 * EDI 전송 START
				 ***********************************************************/
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(sFlatFile);
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CANCUS.IBMMQ.QUEUE"));
				BookingUtil utilCommand = new BookingUtil();
				FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
				if (flatFileAckVO.getAckStsCd().equals("E"))
					throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
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
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitActualVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0015Event")) {
				EsmBkg0015Event event = (EsmBkg0015Event) e;
				command = new CndCustomsTransmissionBCImpl();
				CndVesselArrivalTransmitVO vo = (CndVesselArrivalTransmitVO) event.getVesselArrivalTransmitVO();
				/***********************************************************
				 * VesselArrival에 send date 수정
				 ***********************************************************/
				CndManifestListDownloadBC vslBC = new CndManifestListDownloadBCImpl();
				CndVesselArrivalVO vslVO = new CndVesselArrivalVO();
				vslVO.setVslCd(vo.getVslCd());
				vslVO.setSkdVoyNo(vo.getSkdVoyNo());
				vslVO.setSkdDirCd(vo.getSkdDirCd());
				vslVO.setCapNm(vo.getCapNm());
				vslVO.setActArrDt(vo.getActArrDt());
				// vslVO.setVslArrRptSndDt(); //GMT 시간 세팅은
				// manageVesselArrival안에서 함
				vslBC.manageVesselArrival(vslVO, account);
				/***********************************************************
				 * 1.FlatFile을 만들고 2.EDI 전송 3.로그테이블에 Insert
				 ***********************************************************/
				vo.setVslArrRptSndDt(vslVO.getVslArrRptSndDt());
				String sFlatFile = command.transmitActualVesselArrival(vo, account);
				/***********************************************************
				 * EDI 전송 START
				 ***********************************************************/
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(sFlatFile);
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CANCUS.IBMMQ.QUEUE"));
				BookingUtil utilCommand = new BookingUtil();
				FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
				if (flatFileAckVO.getAckStsCd().equals("E"))
					throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
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
	 * ESM_BKG_0745 : SEARCH <br>
	 * ESM_BKG_0127 : SEARCH02 <br>
	 * ESM_BKG_0311 : SEARCH01 <br>
	 * ESM_BKG_0036 : SEARCH, SEARCH01, SEARCH02<BR>
	 * Container Manifest 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsVvdInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0013Event")) {
				EsmBkg0013Event event = (EsmBkg0013Event) e;
				command = new CndManifestListDownloadBCImpl();
				List<CstmsVvdInfoVO> list = command.searchCstmsVvdInfo(event.getCstmsVvdInfoCondVO());
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
	 * ESM_BKG_0013 : MULTI<BR>
	 * 세관 관련 VVD 정보 생성, 수정, 삭제<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CndCustomsTransmissionBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0002Event")) {
				EsmBkg0002Event event = (EsmBkg0002Event) e;
				command = new CndCustomsTransmissionBCImpl();
				eventResponse.setRsVoList(command.searchManifestList(event.getCstmsManifestCondVO()));
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
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsMfDtlList(Event e) throws EventException { // v2.0
																				// 확인필요
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0063Event event = (EsmBkg0063Event) e;
			command = new AncsManifestListDownloadBCImpl();
			eventResponse.setRsVoList(command.searchCstmsMfDtlList(event.getAncsCstmsMfDtlCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0217 : <br>
	 * ESM_BKG_1046 : <br>
	 * ESM_BKG_0494 : <br>
	 * HardCoding Table 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsVvdInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0013Event event = (EsmBkg0013Event) e;
			command = new CndManifestListDownloadBCImpl();
			begin();
			command.manageCstmsVvdInfo(event.getCstmsVvdInfoVOS(), account);
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
	 * ESM_BKG_0013 : SEARCH11<BR>
	 * 세관 신고용 VVD별 Reference No 생성<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCstmsVvdRefNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0013Event event = (EsmBkg0013Event) e;
			command = new CndManifestListDownloadBCImpl();
			eventResponse.setETCData("max_cvy_ref_no", command.createCstmsVvdRefNo(event.getCstmsVvdRefNoCondVO()).getNewCrn());
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * 화물에 대한 Manifest List를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadVslCertiExpDt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			ESM0740001Event event = (ESM0740001Event) e;
			command = new CndManifestListDownloadBCImpl();
			command.loadVslCertiExpDt(event.getCndCstmsVesselInfoVO());
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
	 * ESM_BKG_0359 : SEARCH <br>
	 * Manifest Status Cross-Check 조회.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadCstmsRcvMsg(Event e) throws EventException {
		log.info("SC [loadCstmsRcvMsg] Start---------------------");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = null;
		CndManifestListDownloadBC command2 = null;

		if (e.getEventName().equalsIgnoreCase("UbizcomOpusBkgCancusAckEvent")) {

			begin();

			log.info("<<<<<<<<<< SC UbizcomOpusBkgCancusAckEvent Start >>>>>>>>>>>>>>>>");
			// Canada 수신
			UbizcomOpusBkgCancusAckEvent event = (UbizcomOpusBkgCancusAckEvent) e;
			command  = new CndCustomsTransmissionBCImpl();
			command2 = new CndManifestListDownloadBCImpl();

			try {
				CstmsRcvLogVO cstmsRcvLogVO = event.getCstmsRcvLogVO();

				command.loadCstmsRcvMsg(cstmsRcvLogVO);

				command2.loadCstmsRcvMsg(cstmsRcvLogVO);

				log.info("<<<<<<<<<< SC UbizcomOpusBkgCancusAckEvent End >>>>>>>>>>>>>>>>");

			} catch (Exception ex) {
				log.error("Exception : UbizcomOpusBkgCancusAckEvent " + ex.getMessage());
			}
			commit();
		}

		log.info("SC [loadCstmsRcvMsg] End---------------------");
		return eventResponse;
	}

	/**
	 * Send Log Detail 조회
	 *
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCstmsSndLogDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = null;
		try {
			EsmBkg0501Event event = (EsmBkg0501Event) e;
			command = new CndCustomsTransmissionBCImpl();
			List<CndCstmsSndLogDtlVO> list = command.searchCstmsSndLogDtl(event.getCstmsSndLogDtlCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0819 : SEARCH<BR>
	 * ESM_BKG_0041 : SEARCH<BR>
	 * ESM_BKG_0428 : SEARCH <br>
	 * ESM_BKG_0429 : SEARCH <br>
	 * Mi Transmit/Receive History 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsSndHisList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0500Event")) {
				EsmBkg0500Event event = (EsmBkg0500Event) e;
				command = new CndCustomsTransmissionBCImpl();
				List<CstmsSndHisVO> list = command.searchCstmsSndHisList(event.getCstmsSndHisListCondVO());
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
	 * ESM_BKG_0501 : SEARCH<BR>
	 * SendLog History Detail<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsRcvLogDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = null;
		try {
			EsmBkg0434Event event = (EsmBkg0434Event) e;
			command = new CndCustomsTransmissionBCImpl();
			List<CstmsRcvLogDtlVO> list = command.searchCstmsRcvLogDtl(event.getCstmsRcvLogDtlCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0183 : SEARCH<BR>
	 * ESM_BKG_0186 : SEARCH<BR>
	 * ESM_BKG_0500 : SEARCH<BR>
	 * SendLog History Detail<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsRcvHisList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = null;
		List<CstmsRcvHisVO> list = null;
		try {
			command = new CndCustomsTransmissionBCImpl();
			EsmBkg0431Event event = (EsmBkg0431Event) e;
			list = command.searchCstmsRcvHisList(event.getCstmsRcvHisListCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0431 : SEARCH<BR>
	 * Receive History<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsTrsmRsltList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0142Event event = (EsmBkg0142Event) e;
			command = new CndCustomsTransmissionBCImpl();
			eventResponse.setRsVoList(command.searchCstmsTrsmRsltList(event.getCstmsTrsmRsltListCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0142 : SEARCH01<BR>
	 * ACI Report<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsDoNotLoadAndRemoveList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = null;
		try {
			EsmBkg0142Event event = (EsmBkg0142Event) e;
			command = new CndCustomsTransmissionBCImpl();
			eventResponse.setRsVoList(command.searchCstmsTrsmRsltList(event.getCstmsTrsmRsltListCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0142 : SEARCH02<BR>
	 * ACI Report<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsHoldAndRemoveList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0142Event event = (EsmBkg0142Event) e;
			command = new CndCustomsTransmissionBCImpl();
			eventResponse.setRsVoList(command.searchCstmsTrsmRsltList(event.getCstmsTrsmRsltListCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0028 : SEARCH<br>
	 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 조회하는 오퍼레이션<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsManifestAmendment(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0028Event event = (EsmBkg0028Event) e;
		try {
			// Canada와 US 동일한 화면 사용
			if (CountryCode.CA.equals(event.getCntCd())) {
				CndCustomsTransmissionBC command = new CndCustomsTransmissionBCImpl();
				eventResponse.setRsVoList(command.searchCstmsManifestAmendment(event.getCstmsManifestAmendmentCondVO(), event.getAiDiv()));
			} else if (CountryCode.US.equals(event.getCntCd())) {
				UsaCustomsTransmissionBC command = new UsaCustomsTransmissionBCImpl();
				eventResponse.setRsVoList(command.searchCstmsManifestAmendment(event.getCstmsManifestAmendmentCondVO(), event.getAiDiv()));
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0028 : COMMAND01<BR>
	 * 세관에 수정된 적하목록 내역을 EDI를 통해 전송한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transAmendManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0028Event event = (EsmBkg0028Event) e;

		try {
			begin();
			if (CountryCode.US.equals(event.getCntCd())) {
				UsaCustomsTransmissionBC command = new UsaCustomsTransmissionBCImpl();
				UsaCstmsManifestAmendmentVO usaVO = (UsaCstmsManifestAmendmentVO) event.getCstmsManifestAmendmentVO();
				/*************************************************************
				 * Action Code에 따라 기능 수행
				 *************************************************************/
				for (int j = 0; j < usaVO.getActionCode().length(); j = j + 2) {
					if ("DN".equals(usaVO.getActionCode().substring(j, j + 2))) {
						// Download의 경우 Customs Data Download 화면과 동일하기 때문에
						// ManifestListDownloadBC를 호출함.
						UsaManifestListDownloadBC manifestListDownloadBC = new UsaManifestListDownloadBCImpl();
						UsaManifestListDetailVO[] usaDetailVOs = new UsaManifestListDetailVO[1];
						usaDetailVOs[0] = new UsaManifestListDetailVO();
						usaDetailVOs[0].setBkgNo(usaVO.getBkgNo());
						usaDetailVOs[0].setVslCd(usaVO.getTVvdCd().substring(0, 4));
						usaDetailVOs[0].setSkdVoyNo(usaVO.getTVvdCd().substring(4, 8));
						usaDetailVOs[0].setSkdDirCd(usaVO.getTVvdCd().substring(8, 9));
						usaDetailVOs[0].setPodCd(usaVO.getPodCd());
						usaDetailVOs[0].setPolCd(usaVO.getPolCd());
						usaDetailVOs[0].setVPod(usaVO.getPodCd());
						usaDetailVOs[0].setVPol(usaVO.getPolCd());
						if (usaVO.getBVvdCd() == null || usaVO.getBVvdCd().equals("")) {
							usaDetailVOs[0].setIfFlg("N");
						} else {
							usaDetailVOs[0].setIfFlg("Y");
						}
						usaDetailVOs[0].setBlType(usaVO.getMh());
						usaDetailVOs[0].setBlNos(usaVO.getBlNo());
						usaDetailVOs[0].setPgmNo("ESM_BKG_0028_DN");
						manifestListDownloadBC.manageManifest(usaDetailVOs, account);
					} else if ("DA".equals(usaVO.getActionCode().substring(j, j + 2))) {
						UsaManifestListDownloadBC manifestListDownloadBC = new UsaManifestListDownloadBCImpl();
						UsaManifestListDetailVO[] usaDetailVOs = new UsaManifestListDetailVO[1];
						usaDetailVOs[0] = new UsaManifestListDetailVO();
						usaDetailVOs[0].setBlNo(usaVO.getBlNo());
						usaDetailVOs[0].setPgmNo("ESM_BKG_0028");
						usaDetailVOs[0].setMfStsCd("D");
						manifestListDownloadBC.manageManifest(usaDetailVOs, account);
					} else if ("RA".equals(usaVO.getActionCode().substring(j, j + 2))) {
						UsaManifestListDownloadBC manifestListDownloadBC = new UsaManifestListDownloadBCImpl();
						UsaManifestListDetailVO[] usaDetailVOs = new UsaManifestListDetailVO[1];
						usaDetailVOs[0] = new UsaManifestListDetailVO();
						usaDetailVOs[0].setBlNo(usaVO.getBlNo());
						usaDetailVOs[0].setMfStsCd("A");
						usaDetailVOs[0].setPgmNo("ESM_BKG_0028");
						manifestListDownloadBC.manageManifest(usaDetailVOs, account);
					} else if ("AC".equals(usaVO.getActionCode().substring(j, j + 2)) || "DC".equals(usaVO.getActionCode().substring(j, j + 2))) {
						// Download가 아닌 경우
						UsaManifestListDownloadBC manifestListDownloadBC = new UsaManifestListDownloadBCImpl();
						UsaManifestListDetailVO[] usaDetailVOs = new UsaManifestListDetailVO[1];
						usaDetailVOs[0] = new UsaManifestListDetailVO();
						usaDetailVOs[0].setBlNo(usaVO.getBlNo());
						/***********************************************************
						 * 00:최초전송, 04:수정전송, 03:Cancel 전송
						 **********************************************************/
						usaDetailVOs[0].setCstmsMfTpCd("AI");
						if ("DC".equals(usaVO.getActionCode().substring(j, j + 2))) {
							usaDetailVOs[0].setCstmsTrsmStsCd("03");
						} else {
							usaDetailVOs[0].setCstmsTrsmStsCd("04");
						}
						usaDetailVOs[0].setPgmNo("ESM_BKG_0028");
						// 원래는 여기에 있어야 하는데 MI, BL inquiry도 수정해야하므로 일단 코멘트
						manifestListDownloadBC.manageManifest(usaDetailVOs, account);

						// 미 세관 AI 전송 로직 호출
						UsaManifestSearchDetailVO[] usaDetailVO2s = new UsaManifestSearchDetailVO[1];
						usaDetailVO2s[0] = new UsaManifestSearchDetailVO();
						usaDetailVO2s[0].setBlNo(usaVO.getBlNo());
						usaDetailVO2s[0].setVvd(usaVO.getTVvdCd());
						usaDetailVO2s[0].setPol(usaVO.getPolCd());
						usaDetailVO2s[0].setPod(usaVO.getPodCd());
						usaDetailVO2s[0].setTransmitCd("AI");
						usaDetailVO2s[0].setUsrId(account.getUsr_id());
						usaDetailVO2s[0].setOfcCd(account.getOfc_cd());
						command.transmitManifest(usaDetailVO2s);

					}
				}
				/*************************************************************
				 * 화면에서 체크는 여러건 하지만 내부적으로 1건씩 SC를 호출한다. AI 성공하면 BL No.를 세팅해서 화면으로 전달하고 같은 BL No.의 경우 체크를 해제하고 다음 BL No.에 대한 AI를 시작한다.
				 *************************************************************/
				UsaCstmsManifestAmendmentVO vo = new UsaCstmsManifestAmendmentVO();
				vo.setBlNo(((UsaCstmsManifestAmendmentVO) event.getCstmsManifestAmendmentVO()).getBlNo());
				List<UsaCstmsManifestAmendmentVO> listOkBlNo = new ArrayList<UsaCstmsManifestAmendmentVO>();
				listOkBlNo.add(vo);
				eventResponse.setRsVoList(listOkBlNo);
				commit();
				begin();
				// CDL 자동전송
				this.transmitCdlEdi(vo.getBlNo());


			} else if (CountryCode.CA.equals(event.getCntCd())) {
				// Transmit
				CndCustomsTransmissionBC command = new CndCustomsTransmissionBCImpl();
				// ManifestListDownloadBC
				CndManifestListDownloadBC command2 = new CndManifestListDownloadBCImpl();
				// 파라메터
				CndCstmsManifestAmendmentVO cndVO = (CndCstmsManifestAmendmentVO) event.getCstmsManifestAmendmentVO();


				/*************************************************************
				 * Action Code에 따라 기능 수행
				 *************************************************************/
				for (int j = 0; j < cndVO.getActionCode().length(); j = j + 2) {
					if ("DN".equals(cndVO.getActionCode().substring(j, j + 2))) {
						// Download의 경우 Customs Data Download 화면과 동일하기 때문에
						CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
						cndManifestModificationVOs[0] = new CndManifestModificationVO();
						cndManifestModificationVOs[0].setBkgNo(cndVO.getBkgNo());
						cndManifestModificationVOs[0].setVslCd(cndVO.getTVvdCd().substring(0, 4));
						cndManifestModificationVOs[0].setSkdVoyNo(cndVO.getTVvdCd().substring(4, 8));
						cndManifestModificationVOs[0].setSkdDirCd(cndVO.getTVvdCd().substring(8, 9));
						if (cndVO.getBVvdCd() == null || cndVO.getBVvdCd().equals("")) {
							cndManifestModificationVOs[0].setIfFlg("N");
						} else {
							cndManifestModificationVOs[0].setIfFlg("Y");
						}
						cndManifestModificationVOs[0].setBlType(cndVO.getMh());
						cndManifestModificationVOs[0].setBlNos(cndVO.getBlNo());
						cndManifestModificationVOs[0].setPgmNo("ESM_BKG_0028");
						cndManifestModificationVOs[0].setBkgPodCd(cndVO.getBkgPodCd());
						cndManifestModificationVOs[0].setBkgDelCd(cndVO.getBkgDelCd());
						cndManifestModificationVOs[0].setPodCd(cndVO.getPodCd());
						cndManifestModificationVOs[0].setPolCd(cndVO.getPolCd());
						cndManifestModificationVOs[0].setHubLocCd(cndVO.getHubLocCd());
						cndManifestModificationVOs[0].setIbdLocGdsDesc(cndVO.getIbdLocGdsDesc());
						command2.manageManifest(cndManifestModificationVOs, account);
					} else if ("DA".equals(cndVO.getActionCode().substring(j, j + 2))) {
						CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
						cndManifestModificationVOs[0] = new CndManifestModificationVO();
						cndManifestModificationVOs[0].setBlNo(cndVO.getBlNo());
						cndManifestModificationVOs[0].setMfStsCd("D");
						cndManifestModificationVOs[0].setHubLocCd(cndVO.getHubLocCd());
						cndManifestModificationVOs[0].setIbdLocGdsDesc(cndVO.getIbdLocGdsDesc());
						command2.manageManifest(cndManifestModificationVOs, account);
					} else if ("RA".equals(cndVO.getActionCode().substring(j, j + 2))) {
						CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
						cndManifestModificationVOs[0] = new CndManifestModificationVO();
						cndManifestModificationVOs[0].setBlNo(cndVO.getBlNo());
						cndManifestModificationVOs[0].setMfStsCd("A");
						cndManifestModificationVOs[0].setHubLocCd(cndVO.getHubLocCd());
						cndManifestModificationVOs[0].setIbdLocGdsDesc(cndVO.getIbdLocGdsDesc());
						command2.manageManifest(cndManifestModificationVOs, account);
					} else if ("AC".equals(cndVO.getActionCode().substring(j, j + 2)) || "DC".equals(cndVO.getActionCode().substring(j, j + 2))) {
						CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
						cndManifestModificationVOs[0] = new CndManifestModificationVO();
						cndManifestModificationVOs[0].setBlNo(cndVO.getBlNo());

						/***********************************************************
						 * A6A:Manifest, S10:HB/L Manifest, E10:Empty B/L
						 **********************************************************/
						if ("M".equals(cndVO.getMh())) {
							cndManifestModificationVOs[0].setCstmsMfTpCd("A6A");
							if ("M".equals(cndVO.getFullMtyCd())) {
								cndManifestModificationVOs[0].setCstmsMfTpCd("E10");
							}
						} else {
							cndManifestModificationVOs[0].setCstmsMfTpCd("S10");
						}
						/***********************************************************
						 * 00:최초전송, 04:수정전송, 03:Cancel 전송
						 **********************************************************/
						if ("DC".equals(cndVO.getActionCode().substring(j, j + 2))) {
							cndManifestModificationVOs[0].setCstmsTrsmStsCd("03");
						} else {
							if ("".equals(cndVO.getCstmsTrsmStsCd())) {
								cndManifestModificationVOs[0].setCstmsTrsmStsCd("00");
							} else {
								cndManifestModificationVOs[0].setCstmsTrsmStsCd("04");
							}
						}
						cndManifestModificationVOs[0].setHubLocCd(cndVO.getHubLocCd());
						cndManifestModificationVOs[0].setIbdLocGdsDesc(cndVO.getIbdLocGdsDesc());
						command2.manageManifest(cndManifestModificationVOs, account);
						/***********************************************************
						 * 전송 FlatFile 만들어서 로그테이블에 등록
						 **********************************************************/
						// �꾩넚�쒓컙�명똿
						cndVO.setMiSndDt(cndManifestModificationVOs[0].getEdiSndDt());
						command.transAmendManifest(cndVO, account);
					}
				}
				/*************************************************************
				 * 화면에서 체크는 여러건 하지만 내부적으로 1건씩 SC를 호출한다.<br>
				 * AI 성공하면 BL No.를 세팅해서 화면으로 전달하고 같은 BL No.의 경우 체크를 해제하고<br>
				 * 다음 BL No.에 대한 AI를 시작한다.
				 *************************************************************/
				CndCstmsManifestAmendmentVO vo = new CndCstmsManifestAmendmentVO();
				vo.setBlNo(((CndCstmsManifestAmendmentVO) event.getCstmsManifestAmendmentVO()).getBlNo());
				List<CndCstmsManifestAmendmentVO> listOkBlNo = new ArrayList<CndCstmsManifestAmendmentVO>();
				listOkBlNo.add(vo);
				eventResponse.setRsVoList(listOkBlNo);

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
	 * ESM_BKG_0028 : COMMAND02<BR>
	 * 세관에 수정된 적하목록 내역을 EDI를 통해 전송한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transDelAmendManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0028Event event = (EsmBkg0028Event) e;
		String strBlNo = "";

		try {

			if (CountryCode.US.equals(event.getCntCd())) {
				UsaCstmsManifestAmendmentVO usaCstmsManifestAmendmentVO = (UsaCstmsManifestAmendmentVO) event.getCstmsManifestAmendmentVO();
				UsaManifestListDownloadBC manifastCommand = new UsaManifestListDownloadBCImpl();
				UsaCustomsTransmissionBC tranmitCommand = new UsaCustomsTransmissionBCImpl();
				UsaBlKeyVO usaBlKeyVO = new UsaBlKeyVO();

				begin();

				/*************************************************************
				 * 화면에서 체크는 여러건 하지만 내부적으로 1건씩 SC를 호출한다.
				 * 삭제하면 BL No.의 경우 체크를 해제하고 다음 BL No.에 대한 삭제를 한다.
				 *************************************************************/
				strBlNo = usaCstmsManifestAmendmentVO.getBlNo();

				//BKG_CSTMS_ADV_BL 테이블 수정 : ADV_BL delete
				usaBlKeyVO.setBlKey(CountryCode.US + strBlNo);
				manifastCommand.removeBl((BlKeyVO) usaBlKeyVO, account);

				//03:Cancel
				UsaManifestListDetailVO[] usaManifestListDetailVOs = new UsaManifestListDetailVO[1];
				usaManifestListDetailVOs[0] = new UsaManifestListDetailVO();
				usaManifestListDetailVOs[0].setBlNo(strBlNo);
				usaManifestListDetailVOs[0].setCstmsMfTpCd("AI");
				usaManifestListDetailVOs[0].setCstmsTrsmStsCd("03");
				usaManifestListDetailVOs[0].setPgmNo("ESM_BKG_0028");
				manifastCommand.manageManifest(usaManifestListDetailVOs, account);

				 //삭제전송
				UsaManifestSearchDetailVO[] usaDetailVO2s = new UsaManifestSearchDetailVO[1];
				usaDetailVO2s[0] = new UsaManifestSearchDetailVO();
				usaDetailVO2s[0].setBlNo(strBlNo);
				usaDetailVO2s[0].setVvd(usaCstmsManifestAmendmentVO.getTVvdCd());
				usaDetailVO2s[0].setPol(usaCstmsManifestAmendmentVO.getPolCd());
				usaDetailVO2s[0].setPod(usaCstmsManifestAmendmentVO.getPodCd());
				usaDetailVO2s[0].setTransmitCd("AI");
				usaDetailVO2s[0].setUsrId(account.getUsr_id());
				usaDetailVO2s[0].setOfcCd(account.getOfc_cd());
				tranmitCommand.transmitManifest(usaDetailVO2s);

				commit();

			} else if (CountryCode.CA.equals(event.getCntCd())) {

				CndCstmsManifestAmendmentVO cndCstmsManifestAmendmentVO = (CndCstmsManifestAmendmentVO) event.getCstmsManifestAmendmentVO();
				CndManifestListDownloadBC manifastCommand = new CndManifestListDownloadBCImpl();
				CndCustomsTransmissionBC tranmitCommand = new CndCustomsTransmissionBCImpl();

				begin();

				strBlNo = cndCstmsManifestAmendmentVO.getBlNo();

				//BKG_CSTMS_ADV_BL 테이블 수정 : ADV_BL delete
				CstmsBlVO[] cstmsBlVOs = new CstmsBlVO[1];
				CndCstmsBlVO cndCstmsBlVOs = new CndCstmsBlVO();
				cndCstmsBlVOs.setPgmNo("ESM_BKG_0002");
				cndCstmsBlVOs.setBlNo(strBlNo);
				cndCstmsBlVOs.setMfStsCd("D");
				cstmsBlVOs[0] = cndCstmsBlVOs;
				manifastCommand.manageCstmsBl(cstmsBlVOs, account);

				//03:Cancel
				ManifestListDetailVO[] manifestListDetailVOs = new ManifestListDetailVO[1];
				CndManifestModificationVO cndManifestModificationVO = new CndManifestModificationVO();
				cndManifestModificationVO.setBlNo(strBlNo);
				cndManifestModificationVO.setMfStsCd("D");
				cndManifestModificationVO.setCstmsTrsmStsCd("03");
				cndManifestModificationVO.setPgmNo("ESM_BKG_0029");
				manifestListDetailVOs[0] = cndManifestModificationVO;
				manifastCommand.manageManifest(manifestListDetailVOs, account);
				CndManifestModificationVO cndVoX = (CndManifestModificationVO) manifestListDetailVOs[0];

				 //삭제전송
				CndCstmsManifestVO cndCstmsManifestVO = new CndCstmsManifestVO();
				cndCstmsManifestVO.setBlNo(strBlNo);
				cndCstmsManifestVO.setMiSndDt(cndVoX.getEdiSndDt());
				cndCstmsManifestVO.setIbflag("R");
				tranmitCommand.transmitManifest(cndCstmsManifestVO, account);

				commit();

			}
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

		} catch (EventException ex) {
			throw new EventException((String) new ErrorHandler("BKG40110",new String[] {"(BL:"+strBlNo+")"}).getMessage());
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("BKG40110",new String[] {"(BL:"+strBlNo+")"}).getMessage());
		}
		return eventResponse;
}

	/**
	 * ESM_BKG_0028 : Save<br>
	 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 수정 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsAmendManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndManifestListDownloadBC command = new CndManifestListDownloadBCImpl();
		EsmBkg0028Event event =(EsmBkg0028Event) e;

		// Canada와 US 동일한 화면 사용
		try {
			command.manageCstmsAmendManifest(event.getCstmsManifestAmendmentVOs(), account, event.getCntCd(), event.getAiDiv());
			begin();
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
	 * ESM_BKG_0574 : SEARCH<BR>
	 * Scac Report 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	 * private EventResponse downloadManifest(Event e) throws EventException { //v2.0 호출 확인 필요 GeneralEventResponse eventResponse = new GeneralEventResponse(); ManifestListDownloadBC command = null;
	 * try { EsmBkg0234Event event = (EsmBkg0234Event) e; command = new ManilaManifestListDownloadBCImpl(); String filename = command.downloadManifest(event .getManifestListDetailVO());
	 * eventResponse.setCustomData("filekey", filename); eventResponse.setETCData("filename", filename); } catch (EventException ex) { rollback(); throw ex; } catch (Exception ex) { rollback(); throw
	 * new EventException(new ErrorHandler("BKG06087").getMessage(), ex); } return eventResponse; }
	 */

	/**
	 * ESM_BKG_0216 : COMMAND01 <br>
	 * ESM_BKG_1046 : MULTI01 <br>
	 * ESM_BKG_1162 : MULTI01 <br>
	 * Container Manifest정보를 업데이트 한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestDtlList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = null;
		try {
			command = new CndCustomsTransmissionBCImpl();
			EsmBkg0002Event event = (EsmBkg0002Event) e;
			eventResponse.setRsVoList(command.searchManifestDtlList(event.getCstmsManifestCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0431 : SEARCH<BR>
	 * Receive History<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	 * private EventResponse searchContainerManifest(Event e) throws EventException { // v2.0 호출 확인 필 GeneralEventResponse eventResponse = new GeneralEventResponse(); //ManifestListDownloadBC command
	 * = null; try {
	 *
	 * if ("EsmBkg0745Event".equalsIgnoreCase(e.getEventName()) || "EsmBkg0127Event".equalsIgnoreCase(e.getEventName())) { // brazil command = new BrcsManifestDownloadBCImpl(); List<BrHsCdDetailVO>
	 * list = null; BrHsCdDetailVO brHsCdDetailVO = null; if ("EsmBkg0127Event".equalsIgnoreCase(e.getEventName())) { // 그리드에서 // Cell값 // 변경시 EsmBkg0127Event event = (EsmBkg0127Event) e; BrHsCdCondVO
	 * brHsCdCondVO = new BrHsCdCondVO(); brHsCdCondVO.setBrzCmdtCd((event.getBrManifestListCondVO()) .getBrzCmdtCd()); brHsCdCondVO.setPageGubun("popup"); list = command.searchHsCdList(brHsCdCondVO);
	 * if (list.size() > 0) { brHsCdDetailVO = list.get(0); eventResponse.setETCData("brz_cmdt_cd", brHsCdDetailVO.getBrzCmdtCd()); eventResponse.setETCData("cmdt_desc", brHsCdDetailVO.getCmdtDesc());
	 * } else { eventResponse.setETCData("brz_cmdt_cd", ""); eventResponse.setETCData("cmdt_desc", ""); } } else { // NCM Code 팝업 호출시 EsmBkg0745Event event = (EsmBkg0745Event) e; BrHsCdCondVO
	 * brHsCdCondVO = event.getBrHsCdCondVO(); brHsCdCondVO.setPageGubun("main"); list = command.searchHsCdList(brHsCdCondVO); eventResponse.setRsVoList(list); } } else if
	 * (e.getEventName().equalsIgnoreCase("EsmBkg0036Event")) { EsmBkg0036Event event = (EsmBkg0036Event) e; command = new UsaManifestListDownloadBCImpl(); UsaContainerManifestDetailVO detailVO =
	 * (UsaContainerManifestDetailVO) command .searchContainerManifest(event .getContainerManifestCondVO());
	 *
	 * eventResponse.setRsVoList(detailVO.getUsaContainerListVOs()); eventResponse.setRsVoList(detailVO.getUsaCntrManifestListVOs()); eventResponse.setRsVoList(detailVO.getUsaCntrManifestInfoVOs());
	 * if (detailVO.getUsaCntrManifestInfoVOs().size() > 0) { eventResponse.setETCData(detailVO .getUsaCntrManifestInfoVOs().get(0) .getColumnValues()); } } else if
	 * (e.getEventName().equalsIgnoreCase("EsmBkg0311Event")) { command = new IndonesiaManifestListDownloadBCImpl(); List<indonesiaBkgDetailVO> list = null; indonesiaBkgDetailVO indonesiaBkgDetailVO =
	 * null; if ("EsmBkg0311Event".equalsIgnoreCase(e.getEventName())) { // 그리드에서 // Cell값 // 변경시 EsmBkg0311Event event = (EsmBkg0311Event) e; IndonesiaManifestListCondVO indonesiaManifestListCondVO =
	 * new IndonesiaManifestListCondVO(); indonesiaManifestListCondVO.setBkgNo((event .getIndonesiaManifestListCondVO()).getBkgNo()); list = command.searchBkgInfo(indonesiaManifestListCondVO); if
	 * (list.size() > 0) { indonesiaBkgDetailVO = list.get(0); eventResponse.setETCData("bl_no", indonesiaBkgDetailVO.getBlNo()); eventResponse.setETCData("vvd", indonesiaBkgDetailVO.getVvd());
	 * eventResponse.setETCData("por_cd", indonesiaBkgDetailVO.getPorCd()); eventResponse.setETCData("pol_cd", indonesiaBkgDetailVO.getPolCd()); eventResponse.setETCData("pod_cd",
	 * indonesiaBkgDetailVO.getPodCd()); eventResponse.setETCData("del_cd", indonesiaBkgDetailVO.getDelCd()); } else { eventResponse.setETCData("bl_no", ""); eventResponse.setETCData("vvd", "");
	 * eventResponse.setETCData("por_cd", ""); eventResponse.setETCData("pol_cd", ""); eventResponse.setETCData("pod_cd", ""); eventResponse.setETCData("del_cd", ""); } } } } catch (EventException ex)
	 * { throw ex; } catch (Exception ex) { throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex); }
	 *
	 * return eventResponse; }
	 */
	/**
	 * ESM_BKG_0304 : SEARCH <br>
	 * ESM_BKG_0470 : SEARCH <br>
	 * ESM_BKG_0493 : SEARCH <br>
	 * ESM_BKG_0494 : SEARCH <br>
	 * ESM_BKG_0015 : SEARCH <br>
	 * ESM_BKG_0359 : INIT <br>
	 * ESM_BKG_1104 : SEARCH <br>
	 * ESM_BKG_1171 : SEARCH <br>
	 * 세관에 신고할 대상 VesselArrival 정보 데이터를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	 * @SuppressWarnings("unchecked") private EventResponse modifyContainerManifest(Event e) throws EventException { GeneralEventResponse eventResponse = new GeneralEventResponse();
	 * ManifestListDownloadBC command = null; try { begin(); // 이벤트별 Impl생성 if (e.getEventName().equalsIgnoreCase("EsmBkg0127Event")) { // 브라질 EsmBkg0127Event event = (EsmBkg0127Event) e; command =
	 * new BrcsManifestDownloadBCImpl(); command.modifyContainerManifest( event.getBrCnpiNcmByCntrModiVOs(), account); // 성공메시지세팅 eventResponse.setUserMessage(new ErrorHandler("BKG00166")
	 * .getUserMessage()); } else if (e.getEventName().equalsIgnoreCase("EsmBkg0036Event")) { // 미국 EsmBkg0036Event event = (EsmBkg0036Event) e; command = new UsaManifestListDownloadBCImpl();
	 * command.modifyContainerManifest( event.getContainerManifestListVOs(), account); // 성공메시지세팅 // eventResponse.setUserMessage(new // ErrorHandler("BKG00166").getUserMessage()); } commit(); } catch
	 * (EventException ex) { rollback(); throw ex; } catch (Exception ex) { rollback(); throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex); } return eventResponse; }
	 */
	/**
	 * ESM_BKG_0351 : MULTI <br>
	 * 데이터 확인을 위한 BL List에서 B/L Seq를 수정한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if (e.getEventName().equalsIgnoreCase("EsmBkg0002Event")) {
			EsmBkg0002Event event = (EsmBkg0002Event) e;
			sKey = event.getKey();
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1023Event")) {
			EsmBkg1023Event event = (EsmBkg1023Event) e;
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
					if (e.getEventName().equalsIgnoreCase("EsmBkg0002Event")) {
						// Data Transmitted successufully!
						eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
					} else {
						// Data Saved Successfully!!
						eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
					}
					strResult = "SUCCESS";
				} else if ("4".equals(rowSet.getString("JB_STS_FLG"))) {
					// 에러메시지세팅
					if (e.getEventName().equalsIgnoreCase("EsmBkg0002Event")) {
						if (!"".equals(rowSet.getString("JB_USR_ERR_MSG"))) {
							StringTokenizer st = new StringTokenizer(rowSet.getString("JB_USR_ERR_MSG"), "<||>");
							st.nextToken();
							st.nextToken();
							st.nextToken();
							String strErrMsg = st.nextToken();
							eventResponse.setUserMessage(strErrMsg);
						} else {
							eventResponse.setUserMessage(new ErrorHandler("BKG00205").getUserMessage());
						}
					} else {
						if (!"".equals(rowSet.getString("JB_USR_ERR_MSG"))) {
							eventResponse.setUserMessage(rowSet.getString("JB_USR_ERR_MSG"));
						} else {
							eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
						}
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
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	 * private EventResponse searchUvi(Event e) throws EventException { //v2.0 확인후 삭제요 GeneralEventResponse eventResponse = new GeneralEventResponse(); CustomsTransmissionBC command = null; try {
	 * EsmBkg0257Event event = (EsmBkg0257Event) e; command = new EurCustomsTransmissionBCImpl(); String retUvi = command.searchUvi(event.getVvdCd(), event.getPolCd(), event.getPodCd());
	 * eventResponse.setETCData("uvi", retUvi);
	 *
	 * } catch (EventException ex) { throw ex; } catch (Exception ex) { throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex); } return eventResponse; }
	 */

	/**
	 * ESM_BKG_0371 : MULTI, REMOVE <br>
	 *
	 * MRN CREATE 추가<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	 * private EventResponse searchLocation(Event e) throws EventException { //v2.0 사용 하지 않아 삭제 GeneralEventResponse eventResponse = new GeneralEventResponse(); CustomsReportBC command = null; try {
	 * // 이벤트별 Impl생성 if ("EsmBkg0152Event".equalsIgnoreCase(e.getEventName())) { EsmBkg0152Event event = (EsmBkg0152Event) e; command = new ChinaCustomsReportBCImpl(); String locCd =
	 * command.searchLocation(event .getSearchLocationVO()); if (locCd != null) { eventResponse.setETCData("locCd", locCd); } // 성공 메시지 셋팅 // eventResponse.setUserMessage(new //
	 * ErrorHandler("BKG00101").getUserMessage()); } else if (e.getEventName().equalsIgnoreCase("EsmBkg0540Event")) { EsmBkg0540Event event = (EsmBkg0540Event) e; BookingUtil bkgUtil = new
	 * BookingUtil(); String locNm = bkgUtil.searchMdmLocName(event.getStrLocCd()); if (!"".equals(locNm)) { eventResponse.setETCData("result", locNm); } } else if
	 * (e.getEventName().equalsIgnoreCase("EsmBkg0257Event")) { EsmBkg0257Event event = (EsmBkg0257Event) e; BookingUtil bkgUtil = new BookingUtil();
	 *
	 * String polCd = event.getPolCd(); String podCd = event.getPodCd(); String polLocNm = ""; String podLocNm = "";
	 *
	 * if (polCd != null && !polCd.equals("")) { polLocNm = bkgUtil.searchMdmLocName(polCd); } eventResponse.setETCData("polResult", polLocNm);
	 *
	 * if (podCd != null && !podCd.equals("")) { podLocNm = bkgUtil.searchMdmLocName(podCd); }
	 *
	 * eventResponse.setETCData("podResult", podLocNm);
	 *
	 * } else if (e.getEventName().equalsIgnoreCase("EsmBkg1144Event")) { EsmBkg1144Event event = (EsmBkg1144Event) e; BookingUtil bkgUtil = new BookingUtil(); String locNm =
	 * bkgUtil.searchMdmLocName(event.getStrLocCd());
	 *
	 * if (!"".equals(locNm)) { eventResponse.setETCData("result", locNm); } }
	 *
	 * } catch (EventException ex) { throw ex; } catch (Exception ex) { throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex); } return eventResponse; }
	 */

	/**
	 * ESM_BKG_1046 : SEARCH, SEARCH01 <br>
	 * ESM_BKG_1070 : SEARCH <br>
	 * Customer, Container 등의 BL 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	 * private EventResponse searchEurManifestList(Event e) throws EventException { //v2.0 실행 확인후 삭제요 GeneralEventResponse eventResponse = new GeneralEventResponse(); CustomsTransmissionBC command =
	 * null; try { EsmBkg0257Event event = (EsmBkg0257Event) e; command = new EurCustomsTransmissionBCImpl(); List<ManifestListDetailVO> list = null; list =
	 * command.searchEurManifestList(event.getManifestListCondVO());
	 *
	 * // [CHM-201325432] EU customs EDI 화면, RFS lane yard code mandatory // 설정요청 EurManifestListCondVO eurManifestListCondVO = new EurManifestListCondVO(); eurManifestListCondVO =
	 * (EurManifestListCondVO) event .getManifestListCondVO();
	 *
	 * if (list.size() > 0) { EurManifestListVO ovo = (EurManifestListVO) list.get(0);
	 *
	 * if ("RFS".equals(ovo.getSlanCd())) { if ("I".equals(eurManifestListCondVO.getModeType()) && "".equals(eurManifestListCondVO.getPodYdCd())) { throw new EventException( (String) new
	 * ErrorHandler("BKG06148", new String[] { "for RFS" }) .getMessage()); } if ("O".equals(eurManifestListCondVO.getModeType()) && "".equals(eurManifestListCondVO.getPolYdCd())) { throw new
	 * EventException( (String) new ErrorHandler("BKG06148", new String[] { "for RFS" }) .getMessage()); } }
	 *
	 * eventResponse.setETCData("vvd_nm", ovo.getVslFullname()); eventResponse.setETCData("vvd_ld", ovo.getVslLloydcode()); eventResponse.setETCData("vvd_call", ovo.getVslCallsign());
	 * eventResponse.setETCData("eta", ovo.getEta()); eventResponse.setETCData("etd", ovo.getEtd()); }
	 *
	 * eventResponse.setRsVoList(list);
	 *
	 * } catch (EventException ex) { throw ex; } catch (Exception ex) { throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex); } return eventResponse; }
	 */
	/**
	 * 2011.12.26 이경원 [SRM-201122521] Australia Customs Manifest 기능 보완 요청 ESM_BKG_0053 : (Australia Customs Manifest) VVD의 등록여부를 조사한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchACIMonitor(Event e) throws EventException {
		CndCustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1125Event event = (EsmBkg1125Event) e;
			command = new CndCustomsReportBCImpl();
			List<ACIMonitorListVO> list = command.searchACIMonitor(event.getACIMonitorCondVO());
			if (list.size() > 0) {
				ACIMonitorListVO ovo = (ACIMonitorListVO) list.get(0);
				eventResponse.setETCData("total_bl_cnt", ovo.getBlCnt());
				eventResponse.setETCData("acc_bl_cnt", ovo.getAcceptedCnt());
				eventResponse.setETCData("rej_bl_cnt", ovo.getRejectedCnt());
				eventResponse.setETCData("nrcv_bl_cnt", ovo.getNotReceivedCnt());
				eventResponse.setETCData("donld_bl_cnt", ovo.getDnlCnt());
				eventResponse.setETCData("rlse_bl_cnt", ovo.getReleaseCnt());
				eventResponse.setETCData("unsent_bl_cnt", ovo.getUnsentCnt());
				eventResponse.setETCData("podirr_bl_cnt", Integer.toString(Integer.parseInt(ovo.getPodHoldCnt()) + Integer.parseInt(ovo.getDoNotUnloadCnt())));

				eventResponse.setETCData("total_cms_cnt", ovo.getTotalCmsSmcAmt());
				eventResponse.setETCData("total_shaas_ens", ovo.getTotalShaasEns());
				eventResponse.setETCData("total_nycna_ens", ovo.getTotalNycnaEns());
				eventResponse.setETCData("total_hamur_ens", ovo.getTotalHamurEns());
				eventResponse.setETCData("total_sinwa_ens", ovo.getTotalSinwaEns());
				eventResponse.setETCData("total_vvd_cnt", ovo.getTotalVvdCnt());

				eventResponse.setETCData("total_mcf_amt", ovo.getTotalMcfAmt());
				eventResponse.setETCData("total_shaas_mcf", ovo.getTotalShaasMcf());
				eventResponse.setETCData("total_nycna_mcf", ovo.getTotalNycnaMcf());
				eventResponse.setETCData("total_hamur_mcf", ovo.getTotalHamurMcf());
				eventResponse.setETCData("total_sinwa_mcf", ovo.getTotalSinwaMcf());
				eventResponse.setETCData("total_amd_cnt", ovo.getAmendCnt2());
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
	 * ESM_BKG_1125 : 화면에 대한 콤보리스트 조회.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode1125(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// RHQ List
		List<BkgComboVO> list = searchComCodeCombo("CD00961");
		BkgComboVO vo = new BkgComboVO();

		// default
		vo.setVal("");
		vo.setDesc("");
		vo.setName("");
		list.add(0, vo);

		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * ESM_BKG_1126 : SEARCH<BR>
	 * Europe Advanced Manifest - EXS REPORT 조회.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcSetInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0401Event event = (EsmBkg0401Event) e;
			BookingUtil bkgUtil = new BookingUtil();
			// Office가 미주 대률 내 Office가 아닌 경우 Error
			MdmOrganizationVO org = bkgUtil.searchMdmOrzByOfcCd(event.getBkgHrdCdgCtntListCondVO().getAttrCtnt1());
			if (org == null || (!org.getLocCd().startsWith("CA") && !org.getLocCd().startsWith("US"))) {
				throw new EventException(new ErrorHandler("BKG01067", new String[] {}).getMessage());
			}
			List<BkgHrdCdgCtntVO> list = bkgUtil.searchHardCoding(event.getBkgHrdCdgCtntListCondVO());
			if (list.size() > 0) {
				list.get(0).setAttrCtnt2(list.get(0).getAttrCtnt2() + list.get(0).getAttrCtnt3());
			} else {
				list = new ArrayList<BkgHrdCdgCtntVO>();
				BkgHrdCdgCtntVO vo = new BkgHrdCdgCtntVO();
				vo.setHrdCdgId(Constants.HrdCdgId.CND_AVCNTC_OFC_SET);
				vo.setAttrCtnt2("");
				list.add(vo);
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
	 * ESM_BKG_0401 : MODIFY<BR>
	 * bkg_hrd_cdg 테이블을 수정한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOfcSetInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			EsmBkg0401Event event = (EsmBkg0401Event) e;
			BookingUtil bkgUtil = new BookingUtil();
			bkgUtil.manageHardCoding(event.getBkgHrdCdgCtntVOs());
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
	 * ESM_BKG_0025 : SEARCH<br>
	 * Arrive Notice 전송<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOfcSetInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			EsmBkg0401Event event = (EsmBkg0401Event) e;
			BookingUtil bkgUtil = new BookingUtil();
			bkgUtil.manageHardCoding(event.getBkgHrdCdgCtntVOs());
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00593").getUserMessage());
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
	 * ESM_BKG_0408 : INIT <br>
	 * hub수정권한을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsReport(Event e) throws EventException {
		CndCustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0025Event event = (EsmBkg0025Event) e;
			command = new CndCustomsReportBCImpl();
			eventResponse.setRsVoList(command.searchCstmsReport(event.getCndCstmsReportCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0466 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(DOR 데이터) 를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAvcNoteSetUpInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndManifestListDownloadBC command = null;
		try {
			begin();
			EsmBkg0025Event event = (EsmBkg0025Event) e;
			if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				command = new CndManifestListDownloadBCImpl();
				AvcNoteSetUpInfoVO[] vos = event.getAvcNoteSetUpInfoVOs();
				command.manageAvcNoteSetUpInfo(vos, account);
				// ArrivalNotice 수정
				CndCstmsReportVO[] params = event.getCndCstmsReportVOs();
				ArrivalNoticeBC ibcommand = new ArrivalNoticeBCImpl();
				ArrNtcCustListVO[] arrNtcCustListVOs = new ArrNtcCustListVO[params.length];
				for (int i = 0; i < event.getCndCstmsReportVOs().length; i++) {
					arrNtcCustListVOs[i] = new ArrNtcCustListVO();
					arrNtcCustListVOs[i].setBkgNo(params[i].getBkgNo());
					arrNtcCustListVOs[i].setBkgCustTpCd(params[i].getBkgCustTpCd());
					arrNtcCustListVOs[i].setFax1(params[i].getFaxNo1());
					arrNtcCustListVOs[i].setEml1(params[i].getNtcEml1());
					arrNtcCustListVOs[i].setFax2(params[i].getFaxNo2());
					arrNtcCustListVOs[i].setEml2(params[i].getNtcEml2());
					arrNtcCustListVOs[i].setFax3(params[i].getFaxNo3());
					arrNtcCustListVOs[i].setEml3(params[i].getNtcEml3());
					arrNtcCustListVOs[i].setFax4(params[i].getFaxNo4());
					arrNtcCustListVOs[i].setEml4(params[i].getNtcEml4());
					arrNtcCustListVOs[i].setFax5(params[i].getFaxNo5());
					arrNtcCustListVOs[i].setEml5(params[i].getNtcEml5());
				}
				ibcommand.modifyArrNtcCustList(arrNtcCustListVOs, account);
				// 성공메시지
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				// Fax
				CndCustomsReportBC reportCom = new CndCustomsReportBCImpl();
				List<BkgNtcHisVO> bkgNtcHisVOs = reportCom.sendAvcNoteFax(event.getCndCstmsReportVOs(), account);
				// History Table 등록
				BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
				eventResponse.setUserMessage(new ErrorHandler("BKG40053").getUserMessage());
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				// Email
				CndCustomsReportBC reportCom = new CndCustomsReportBCImpl();
				List<BkgNtcHisVO> bkgNtcHisVOs = reportCom.sendAvcNoteEmail(event.getCndCstmsReportVOs(), account);
				// History Table 등록
				BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
				eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
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
	 * ESM_BKG_0472 : SEARCH <br>
	 * ESM_BKG_1027 : SEARCH <br>
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 내역을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsAvcNotesPrnTpList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			BookingUtil bkgUtil = new BookingUtil();
			BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
			hrdCdgVO.setHrdCdgId(Constants.HrdCdgId.CND_AN_TP_CD);
			eventResponse.setRsVoList(bkgUtil.searchHardCoding(hrdCdgVO));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * CDL 자동전송
	 *
	 * @param blNo
	 */
	private void transmitCdlEdi(String blNo) throws Exception {
		try {
			UsaCustomsTransmissionBC command = new UsaCustomsTransmissionBCImpl();
			BlInfoCondVO blInfoCondVO = new BlInfoCondVO();
			blInfoCondVO.setBlNo(blNo);
			List<BlInfoVO> blInfos = command.searchTmlBlByVvd(blInfoCondVO);
			if (blInfos.size() > 0) {
				CllCdlTransmitVO[] cllCdlTransmitVOs = new CllCdlTransmitVO[blInfos.size()];
				for (int i = 0; i < blInfos.size(); i++) {
					UsaTmlBlByVvdVO usaTmlBlByVvdVO = (UsaTmlBlByVvdVO) blInfos.get(i);
					cllCdlTransmitVOs[i] = new CllCdlTransmitVO();
					cllCdlTransmitVOs[i].setBkgNo(usaTmlBlByVvdVO.getBkgNo());
					cllCdlTransmitVOs[i].setBlNo(usaTmlBlByVvdVO.getBlNo());
					cllCdlTransmitVOs[i].setCntrNo(usaTmlBlByVvdVO.getCntrNo());
					cllCdlTransmitVOs[i].setBkgCgoTpCd(usaTmlBlByVvdVO.getBkgCgoTpCd());
					cllCdlTransmitVOs[i].setInListType("D");
					cllCdlTransmitVOs[i].setInVvdCd(usaTmlBlByVvdVO.getVslCd() + usaTmlBlByVvdVO.getSkdVoyNo() + usaTmlBlByVvdVO.getSkdDirCd());
					cllCdlTransmitVOs[i].setInPolCd(usaTmlBlByVvdVO.getCstmsPolCd());
					cllCdlTransmitVOs[i].setInPodCd(usaTmlBlByVvdVO.getCstmsPodCd());
					cllCdlTransmitVOs[i].setInSndId(usaTmlBlByVvdVO.getSndId());
					cllCdlTransmitVOs[i].setInRcvId(usaTmlBlByVvdVO.getRcvId());
					cllCdlTransmitVOs[i].setInYdCd(usaTmlBlByVvdVO.getYdCd());
					cllCdlTransmitVOs[i].setInAreaId("USA");
					cllCdlTransmitVOs[i].setInDestSvrCd("USA");
					cllCdlTransmitVOs[i].setInWhereGubun("DL");
					if ("D".equals(usaTmlBlByVvdVO.getMfStsCd())) {
						cllCdlTransmitVOs[i].setInEdiMsgFunc("CANCEL");
					} else {
						cllCdlTransmitVOs[i].setInEdiMsgFunc("REPLACE");
					}
				}
				CLLCDLManifestBC cLLCDLManifestBC = new CLLCDLManifestBCImpl();
				cLLCDLManifestBC.transmitCllCdl(cllCdlTransmitVOs, account);
			}
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler("BKG40110", new String[] { "Terminal" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG40110", new String[] { "Terminal" }).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0142 : INIT <br>
	 * ESM_BKG_0025 : INIT <br>
	 * HardCoding Table 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private List<BkgHrdCdgCtntVO> searchHardCoding(String hrdCdgId) throws EventException {
		try {
			BookingUtil bkgUtil = new BookingUtil();
			BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
			hrdCdgVO.setHrdCdgId(hrdCdgId);
			return bkgUtil.searchHardCoding(hrdCdgVO);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0152 : INIT <br>
	 * ESM_BKG_1033 : INIT <br>
	 * com_intg_cd_dtl Table 조회<br>
	 *
	 * @param String
	 *            comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private List<BkgComboVO> searchComCodeCombo(String comCode) throws EventException {
		BookingUtil bkgUtil = new BookingUtil();
		List<BkgComboVO> list = bkgUtil.searchCombo(comCode);
		try {
			for (int j = 0; j < list.size(); j++) {
				// 콤보 Text에 value + Name으로 보여주는 경우 사용
				list.get(j).setDesc(list.get(j).getVal() + " " + list.get(j).getName());
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_BKG_1023 : SEARCH <br>
	 * Vessel Stowage Plan Transmit 화면을 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStowageManifestList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = new CndCustomsTransmissionBCImpl();
		try {
			// 이벤트별 Impl생성
			EsmBkg1023Event event = (EsmBkg1023Event) e;
			List<ManifestTransmitVO> list = command.searchStowageManifestList(event.getUsaStowageManifestCondVO());
			// 결과 셋업.
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1023 : SEARCH01 <br>
	 * Vessel Stowage Plan Transmit 화면에서 VVD를 입력하면 캐나다 입항 직전 포트를 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLastForeignPort(Event e) 
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = new CndCustomsTransmissionBCImpl();
		try {
			// 이벤트별 Impl생성
			EsmBkg1023Event event = (EsmBkg1023Event) e;
			List<ManifestTransmitVO> list = command.searchLastForeignPort(event.getUsaStowageManifestCondVO());
			// 결과 셋업.
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1023 : SEARCH04 <br>
	 * Select CRN for Baplie 화면에서 CRN No.를 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCrnNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = new CndCustomsTransmissionBCImpl();
		try {
			// 이벤트별 Impl생성
			EsmBkg1023Event event = (EsmBkg1023Event) e;
			List<ManifestTransmitVO> list = command.searchCrnNo(event.getUsaStowageManifestCondVO());
			// 결과 셋업.
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1023 : MULTI <BR>
	 * Vessel Stowage Plan Transmit 실행.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitStowageManifest(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndCustomsTransmissionBC command = new CndCustomsTransmissionBCImpl();
		String key = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1023Event event = (EsmBkg1023Event) e;
			// BackEnd
				StiDetailCndVO[] detailVOs = event.getCndStowageManifestDetailVOs();
				if (detailVOs != null) {
					for (int i = 0; i < detailVOs.length; i++) {
						detailVOs[i].setTmp1(account.getUsr_id());
						detailVOs[i].setTmp2(account.getOfc_cd());
					}
				}
				key = command.startBackEndJob(account, detailVOs,"ESM_BKG_1023");
			eventResponse.setETCData("KEY", key);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}
	
	
	
	
}// end class
