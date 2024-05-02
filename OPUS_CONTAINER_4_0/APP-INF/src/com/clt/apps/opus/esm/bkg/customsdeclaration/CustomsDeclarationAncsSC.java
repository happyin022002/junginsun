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

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.basic.AncsCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.basic.AncsCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.event.EsmBkg0183Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.event.EsmBkg0184Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.event.EsmBkgUbizcomOpusbkgAnrackEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsLogDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.basic.AncsManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.basic.AncsManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0044Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0045Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0063Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0186Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0494Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0551Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0728Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg1095Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsBkgCstmsAnrCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsAnrBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlCVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlNtfyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsVesselInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0013Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.basic.DubaiManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.basic.DubaiManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event.EsmBkg1087Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.basic.IndiaManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.basic.IndiaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0300Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InPrintFormCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;

/**
 * OPUS-CustomsDeclarationAncsSC Business Logic ServiceCommand -
 * OPUS-CustomsDeclarationAncsSC handling business transaction.
 * 
 * @author c9014874
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationAncsSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationAncsSC system <br>
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
	 * CustomsDeclarationAncsSC system <br>
	 * ESM_BKG-0017 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationSC 종료");
	}

	/**
	 * 
	 * OPUS-CustomsDeclarationAncsSC system <br>
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
		if (e.getEventName().equalsIgnoreCase("EsmBkg0183Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsSndHisList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCstmsVvdInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0184Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsLogDtl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkgUbizcomOpusbkgAnrackEvent")) {
			eventResponse = loadCstmsRcvMsg(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0044Event")) {
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
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = inquiryBlData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0063Event")) {
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
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0186Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsSndHisList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCstmsVvdInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0494Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUiSetUpInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0551Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCstmsVvdDtlList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = deleteCstmsAncsManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0728Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsNtfyAddr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOrganization(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsNtfyAddr(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1095Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAncsLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAncsLane(e);
			}
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0183 : SEARCH<BR>
	 * ESM_BKG_0186 : SEARCH<BR>
	 * ESM_BKG_0500 : SEARCH<BR>
	 * SendLog History Detail<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsSndHisList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsCustomsTransmissionBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0186Event")) {
				EsmBkg0186Event event = (EsmBkg0186Event) e;
				command = new AncsCustomsTransmissionBCImpl();
				List<CstmsSndHisVO> list = command.searchCstmsSndHisList(event.getAncsCstmsSndHisListCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0183Event")) {
				EsmBkg0183Event event = (EsmBkg0183Event) e;
				command = new AncsCustomsTransmissionBCImpl();
				List<CstmsSndHisVO> list = command.searchCstmsSndHisList(event.getAncsCstmsSndHisListCondVO());
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
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsVvdInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0063Event")) {
				EsmBkg0063Event event = (EsmBkg0063Event) e;
				command = new AncsManifestListDownloadBCImpl();
				List<CstmsVvdInfoVO> list = command.searchCstmsVvdInfo(event.getAncsCstmsVvdInfoCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0186Event")) {
				EsmBkg0186Event event = (EsmBkg0186Event) e;
				command = new AncsManifestListDownloadBCImpl();
				List<CstmsVvdInfoVO> list = command.searchCstmsVvdInfo(event.getAncsCstmsVvdInfoCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0044Event")) {
				EsmBkg0044Event event = (EsmBkg0044Event) e;
				command = new AncsManifestListDownloadBCImpl();
				List<CstmsVvdInfoVO> list = command.searchCstmsVvdInfo(event.getAncsCstmsVvdInfoCondVO());
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
	 * ESM_BKG_0184 : SEARCH <br>
	 * searching Cust information from Manifest Registration(MFR)<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsLogDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsCustomsTransmissionBCImpl command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0184Event event = (EsmBkg0184Event) e;
			List<AncsCstmsLogDtlVO> ancsCstmsLogDtlVOs = null;
			command = new AncsCustomsTransmissionBCImpl();
			ancsCstmsLogDtlVOs = command.searchCstmsLogDtl(event.getAncsCstmsLogDtlCondVO());
			eventResponse.setRsVoList(ancsCstmsLogDtlVOs);
			// 성공메시지세팅
			// eventResponse.setUserMessage("");
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EsmBkgUdevcomOpusbkgEntry : <br>
	 * EsmBkgUdevcomOpusbkgKrcusEvent : <br>
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
		AncsCustomsTransmissionBC command = null;
		AncsManifestListDownloadBC command2 = null;
		try {
			// if(!e.getEventName().equalsIgnoreCase("Ubiz2comOpusbkgAmsAckEvent")){
			begin();
			// }
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkgUbizcomOpusbkgAnrackEvent")) {
				EsmBkgUbizcomOpusbkgAnrackEvent event = (EsmBkgUbizcomOpusbkgAnrackEvent) e;
				command = new AncsCustomsTransmissionBCImpl();
				command2 = new AncsManifestListDownloadBCImpl();
				// 1단계
				AncsRcvMsgVO ancsRcvMsgVO = (AncsRcvMsgVO) command.loadCstmsRcvMsg(event.getFlatFile(), account);
				// String sRcvSts = ancsRcvMsgVO.getRcvSts();
				String sMsgId = ancsRcvMsgVO.getMsgId();
				if ("CUSREP".equals(sMsgId))
					sMsgId = "R";
				else
					sMsgId = "C";
				String sAnrMsgStsCd = "N";
				if ("44".equals(ancsRcvMsgVO.getRcvSts())) {
					sAnrMsgStsCd = "A";
				} else {
					sAnrMsgStsCd = "N";
				}
				// 2단계
				if ("R".equals(sMsgId)) {
					AncsVesselInfoVO[] ancsVesselInfoVOs = new AncsVesselInfoVO[1];
					AncsVesselInfoVO ancsVesselInfoVO = new AncsVesselInfoVO();
					ancsVesselInfoVO.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
					ancsVesselInfoVO.setRefSeq(ancsRcvMsgVO.getRefSeq());
					ancsVesselInfoVO.setAnrMsgStsCd(sAnrMsgStsCd);
					ancsVesselInfoVOs[0] = ancsVesselInfoVO;
					command2.manageCstmsVesselInfo(ancsVesselInfoVOs, account);
				} else if ("C".equals(sMsgId)) {
					AncsCstmsAnrBlVO ancsCstmsAnrBlVO = new AncsCstmsAnrBlVO();
					AncsBkgCstmsAnrCntrVO ancsBkgCstmsAnrCntrVO = new AncsBkgCstmsAnrCntrVO();
					ancsCstmsAnrBlVO.setAnrMsgStsCd("A");
					ancsCstmsAnrBlVO.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
					ancsCstmsAnrBlVO.setMsgTpCd(sMsgId);
					ancsCstmsAnrBlVO.setRefSeq(ancsRcvMsgVO.getRefSeq());
					ancsBkgCstmsAnrCntrVO.setAnrMsgStsCd(sAnrMsgStsCd);
					ancsBkgCstmsAnrCntrVO.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
					ancsBkgCstmsAnrCntrVO.setMsgTpCd(sMsgId);
					ancsBkgCstmsAnrCntrVO.setRefSeq(ancsRcvMsgVO.getRefSeq());
					AncsCstmsBlContainerVO[] ancsCstmsBlContainerVOs = new AncsCstmsBlContainerVO[1];
					ancsCstmsBlContainerVOs[0] = new AncsCstmsBlContainerVO();
					ancsCstmsBlContainerVOs[0].setRcv("Y");
					ancsCstmsBlContainerVOs[0].setAncsCstmsAnrBlVO(ancsCstmsAnrBlVO);
					ancsCstmsBlContainerVOs[0].setAncsBkgCstmsAnrCntrVO(ancsBkgCstmsAnrCntrVO);
					command2.manageCstmsBl(ancsCstmsBlContainerVOs, account);
				}
				// eventResponse.setETCData( etcData );
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

	/**
	 * ESM_BKG_1008 : SEARCH01<BR>
	 * ESM_BKG_0013 : INIT<BR>
	 * ESM_BKG_0029 : INIT<BR>
	 * User name, office searching<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUiSetUpInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0494Event")) {
				BookingUtil command2 = null;
				EsmBkg0494Event event = (EsmBkg0494Event) e;
				command2 = new BookingUtil();
				List<BkgHrdCdgCtntVO> list = command2.searchHardCoding(event.getBkgHrdCdgCtntListCondVO());
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
	 * ESM_BKG_0466 : SEARCH <br>
	 * searching Manifest information(DOR data) .<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		AncsManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0210Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0063Event")) {
				EsmBkg0063Event event = (EsmBkg0063Event) e;
				command = new AncsManifestListDownloadBCImpl();
				AncsCstmsMfListCondVO ancsCondVO = (AncsCstmsMfListCondVO) event.getAncsCstmsMfListCondVO();
				List<ManifestListDetailVO> manifestListDetailVO = command.searchManifestList(ancsCondVO);
				eventResponse.setRsVoList(manifestListDetailVO);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0063 : SEARCH02 <br>
	 * searching<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsMfDtlList(Event e) throws EventException {
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
	 * ESM_BKG_0013 : MULTI<BR>
	 * VVD managing<br>
	 * 
	 * @param Event
	 *            e
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
	 * creating Reference No <br>
	 * 
	 * @param Event
	 *            e
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
	 * creating FlatFile for reporting manifest.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsCustomsTransmissionBC command = null;
		// ManifestListDownloadBC maniCommand = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0063Event")) {
				EsmBkg0063Event event = (EsmBkg0063Event) e;
				command = new AncsCustomsTransmissionBCImpl();
				command.transmitManifest((ManifestTransmitVO[]) event.getAncsManifestTransmitVOs(), account);
				// eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0045Event")) {
				EsmBkg0045Event event = (EsmBkg0045Event) e;
				command = new AncsCustomsTransmissionBCImpl();
				command.transmitManifest((ManifestTransmitVO[]) event.getAncsManifestTransmitVOs(), account);
				// eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
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
	 * ESM_BKG_0029 : SEARCH<BR>
	 * ESM_BKG_0034 : SEARCH01 <br>
	 * ESM_BKG_0045 : SEARCH <br>
	 * setup information searching<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse inquiryBlData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		AncsManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// 이벤트별 Impl 생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0045Event")) {
				EsmBkg0045Event event = (EsmBkg0045Event) e;
				command = new AncsManifestListDownloadBCImpl();
				AncsCstmsBlCVO ancsCstmsBlCVO = command.inquiryBlData(event.getAncsCstmsBlCondVO());

				eventResponse.setRsVoList(ancsCstmsBlCVO.getAncsCstmsBlInfoVOs());
				eventResponse.setRsVoList(ancsCstmsBlCVO.getAncsCstmsCntrVOs());
				eventResponse.setRsVoList(ancsCstmsBlCVO.getAncsCstmsCmdtVOs());

			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0029 : MODIFY<BR>
	 * ESM_BKG_0029 : REMOVE<BR>
	 * ESM_BKG_0045 : MULTI<BR>
	 * managing Customr, Container, Commodity(CM) <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsManifestListDownloadBC command = null;
		DubaiManifestListDownloadBC commandDubai = null;
		// DubaiManifestListDownloadBC command = null; v2.0 김상수 수석님 변경 처리후 적용
		// 해야함

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0045Event")) {
				EsmBkg0045Event event = (EsmBkg0045Event) e;
				command = new AncsManifestListDownloadBCImpl();
				AncsCstmsBlContainerVO ancsCstmsBlContainerVO = new AncsCstmsBlContainerVO();
				AncsCstmsBlContainerVO[] ancsCstmsBlContainerVOs = new AncsCstmsBlContainerVO[1];
				AncsCstmsBlVO[] ancsCstmsBlVOs = event.getAncsCstmsBlVOs();
				AncsCstmsBlNtfyVO[] ancsCstmsBlNtfyVOs = event.getAncsCstmsBlNtfyVOs();
				if (ancsCstmsBlVOs != null && ancsCstmsBlVOs.length > 0)
					ancsCstmsBlContainerVO.setAncsCstmsBlVO(ancsCstmsBlVOs[0]);
				if (ancsCstmsBlNtfyVOs != null && ancsCstmsBlNtfyVOs.length > 0)
					ancsCstmsBlContainerVO.setAncsCstmsBlNtfyVO(ancsCstmsBlNtfyVOs[0]);
				ancsCstmsBlContainerVO.setAncsCstmsCntrVOArrys(event.getAncsCstmsCntrVOs());
				ancsCstmsBlContainerVO.setBkgCstmsAnrCmdtVOs(event.getBkgCstmsAnrCmdtVOs());
				ancsCstmsBlContainerVOs[0] = ancsCstmsBlContainerVO;
				command.manageCstmsBl(ancsCstmsBlContainerVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1087Event")) {
				EsmBkg1087Event event = (EsmBkg1087Event) e;
				commandDubai = new DubaiManifestListDownloadBCImpl();
				commandDubai.manageCstmsBl(event.getCstmsBlVOs(), account);
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
	 * ESM_BKG_0063 : SEARCH02 <br>
	 * Manifests to Customs to store items required to report operations<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0551Event")) {
				EsmBkg0551Event event = (EsmBkg0551Event) e;
				command = new AncsManifestListDownloadBCImpl();
				command.manageManifest(event.getAncsManifestModificationVO(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0045Event")) {
				EsmBkg0045Event event = (EsmBkg0045Event) e;
				command = new AncsManifestListDownloadBCImpl();
				command.manageManifest(event.getAncsManifestModificationVO(), account);
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
	 * ESM_BKG_0551 : MULTI05 <br>
	 * Delete saved manifest Information
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteCstmsAncsManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0551Event")) {
				EsmBkg0551Event event = (EsmBkg0551Event) e;
				command = new AncsManifestListDownloadBCImpl();
				command.deleteCstmsAncsManifest(event.getAncsCstmsVvdListCondVO());
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
	 * ESM_BKG_0304 : SEARCH <br>
	 * ESM_BKG_0470 : SEARCH <br>
	 * ESM_BKG_0493 : SEARCH <br>
	 * ESM_BKG_0494 : SEARCH <br>
	 * ESM_BKG_0015 : SEARCH <br>
	 * ESM_BKG_0359 : INIT <br>
	 * ESM_BKG_1104 : SEARCH <br>
	 * searching VesselArrival information .<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsManifestListDownloadBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0494Event")) {
				EsmBkg0494Event event = (EsmBkg0494Event) e;
				command = new AncsManifestListDownloadBCImpl();
				// eventResponse.setRsVoList(command.searchVesselArrival2(event.getAncsCstmsVesselArrivalCondVO()));
				VesselArrivalVO vesselArrivalVO = command.searchVesselArrival2(event.getAncsCstmsVesselArrivalCondVO());
				if (vesselArrivalVO == null)
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				else
					eventResponse.setRsVo(command.searchVesselArrival2(event.getAncsCstmsVesselArrivalCondVO()));
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
	private EventResponse manageVesselArrival(Event e) throws EventException {
		AncsManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0494Event")) { // India
				command = new AncsManifestListDownloadBCImpl();
				EsmBkg0494Event event = (EsmBkg0494Event) e;
				command.manageVesselArrival(event.getAncsVesselArrivalVO(), account);
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
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsCustomsTransmissionBC command = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0494Event")) {
				EsmBkg0494Event event = (EsmBkg0494Event) e;
				command = new AncsCustomsTransmissionBCImpl();
				// 1.FlatFile을 만들고 2.로그테이블에 Insert
				command.transmitVesselArrival((VesselArrivalTransmitVO) event.getAncsVesselArrivalTransmitVO(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
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
	private EventResponse searchCstmsVvdList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0551Event")) {
				EsmBkg0551Event event = (EsmBkg0551Event) e;
				begin();
				command = new AncsManifestListDownloadBCImpl();
				List<CstmsVvdVO> list = command.searchCstmsVvdList(event.getAncsCstmsVvdListCondVO(), account);
				commit();
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
	 * ESM_BKG_0470 : MULTI <br>
	 * ESM_BKG_0443 : MULTI <br>
	 * ESM_BKG_0493 : MULTI <br>
	 * ESM_BKG_0494 : MULTI <br>
	 * ESM_BKG_0015 : MULTI <br>
	 * Vessel Arrival 정보를 생성 및 수정한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsVvdDtlList(Event e) throws EventException {
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
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsNtfyAddr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0728Event")) {
				// begin();
				EsmBkg0728Event event = (EsmBkg0728Event) e;
				List<CstmsNtfyAddrVO> cstmsNtfyAddrVOs = null;
				command = new AncsManifestListDownloadBCImpl();
				cstmsNtfyAddrVOs = (List<CstmsNtfyAddrVO>) (Object) command.searchCstmsNtfyAddr(
						(CstmsNtfyAddrCondVO) event.getBkgCstmsNtfyAddrCondVO(), account);
				eventResponse.setRsVoList(cstmsNtfyAddrVOs);
				// commit();
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
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOrganization(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// ManifestListDownloadBC command = null;
		IndiaManifestListDownloadBC command = null; // v2.0 김상수 수석님 변경 처리후 적용
													// 해야함

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
	 * ESM_BKG_0728 : MULTI<BR>
	 * ANCS 세관 관련 Notify Address를 관리 한다<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsNtfyAddr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0728Event")) {
				EsmBkg0728Event event = (EsmBkg0728Event) e;
				command = new AncsManifestListDownloadBCImpl();
				command.manageCstmsNtfyAddr((CstmsNtfyAddrVO[]) event.getBkgCstmsNtfyAddrVOs(), account); // removeJpcusBlMd((MfrMndModificationVO)event.getMfrMndModificationVO(),account);
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
	 * ESM_BKG_0457 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(CMF 데이터) 를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAncsLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		AncsManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// EsmBkg1095Event event =(EsmBkg1095Event) e;
			List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = null;
			command = new AncsManifestListDownloadBCImpl();
			bkgHrdCdgCtntVOs = command.searchAncsLane();

			if (bkgHrdCdgCtntVOs.size() == 0) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			}

			eventResponse.setRsVoList(bkgHrdCdgCtntVOs);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 
	 * ESM_BKG_0017 : MULTI <br>
	 * ESM_BKG_0045 : MULTI02 <br>
	 * ESM_BKG_0063 : MULTI03 <br>
	 * ESM_BKG_0127 : MULTI <br>
	 * ESM_BKG_0991 : MULTI <br>
	 * ESM_BKG_0061 : MULTI01 <br>
	 * ESM_BKG_0282 : MULTI <br>
	 * ESM_BKG_0497 : MULTI <br>
	 * ESM_BKG_0490 : MULTI <br>
	 * ESM_BKG_0053 : MULTI <br>
	 * ESM_BKG_0310 : MULTI <br>
	 * ESM_BKG_0311 : MULTI02 <br>
	 * ESM_BKG_0298 : MODIFY <br>
	 * ESM_BKG_0300 : MODIFY <br>
	 * ESM_BKG_0302 : MULTI <br>
	 * ESM_BKG_0302 : MULTI <br>
	 * ESM_BKG_0303 : MULTI <br>
	 * ESM_BKG_0257 : MULTI <br>
	 * ESM_BKG_0543 : MULTI01 <br>
	 * ESM_BKG_0533 : MULTI01, MULTI02 <br>
	 * ESM_BKG_0408 : MULTI02 <br>
	 * ESM_BKG_0002 : MULTI <br>
	 * ESM_BKG_0029 : MODIFY02 <br>
	 * ESM_BKG_0337 : COMMAND02 <br>
	 * ESM_BKG_0212 : MULTI01 <br>
	 * ESM_BKG_0212 : MULTI02 <br>
	 * ESM_BKG_0034 : COMMAND01 <br>
	 * ESM_BKG_0217 : COMMAND01 <br>
	 * ESM_BKG_1046 : MULTI02 <br>
	 * ESM_BKG_1070 : COMMAND01 <br>
	 * ESM_BKG_0613 : MULTI01 <br>
	 * ESM_BKG_0543 : MULTI01 <br>
	 * ESM_BKG_0514 : MULTI01 <br>
	 * ESM_BKG_0233 : MULTI01 <br>
	 * ESM_BKG_0370 : MULTI <br>
	 * ESM_BKG_1106 : MULTI01 <br>
	 * ESM_BKG_1121 : MULTI01 <br>
	 * ESM_BKG_1141 : MULTI <br>
	 * ESM_BKG_1155 : MULTI <br>
	 * ESM_BKG_1168 : MULTI <br>
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse manageAncsLane(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1095Event event = (EsmBkg1095Event) e;
			command = new AncsManifestListDownloadBCImpl();

			command.manageAncsLane(event.getBkgHrdCdgCtntVOs(), account);
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

}// end class
