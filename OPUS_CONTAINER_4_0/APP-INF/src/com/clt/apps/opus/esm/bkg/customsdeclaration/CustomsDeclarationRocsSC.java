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
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.basic.RocsCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.basic.RocsCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.basic.RocsManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.basic.RocsManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0061Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0351Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0440Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0442Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0443Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0444Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0448Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0450Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg1017Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg1027Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg1094Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg1135Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkgOpusbkgUdevcomEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsContainerSaveVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestConfirmationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchBlCountVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchCRNVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchCargoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchInboundBlListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchPortListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchVesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchVslInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocscrnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlSeqVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CrnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestConfirmationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.RecieveHistLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.TransmitHistVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
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
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;

/**
 * OPUS-CustomsDeclarationRocs Business Logic ServiceCommand -
 * OPUS-CustomsDeclarationRocsSC handling business transaction.
 * 
 * @author 2012505
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationRocsSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationRocsSC system <br>
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
	 * CustomsDeclarationRocsSC system <br>
	 * ESM_BKG-0017 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationRocsSC 종료");
	}

	/**
	 * 
	 * OPUS-CustomsDeclarationRocsSC system <br>
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

		if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = confirmManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = modifyBlPolCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0351Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyBlSeq(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0440Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH02) || e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchVesselArrivalListInRocs(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0442Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestListForRocsBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0443Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH02) || e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchVesselArrivalListInRocs(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0444Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrivalListInRocs(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = addBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0448Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiveHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchHistoryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0450Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmitHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTransmitHistList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = addBl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiveLog(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1094Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCrnNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1135Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRocsLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRocsLane(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkgOpusbkgUdevcomEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = receiveOpusbkgUdevcom(e);
			}
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0296 : SEARCH <br>
	 * ESM_BKG_0017 : SEARCH <br>
	 * ESM_BKG_0127 : SEARCH <br>
	 * ESM_BKG_0234 : SEARCH <br>
	 * ESM_BKG_0061 : SEARCH <br>
	 * ESM_BKG_0444 : SEARCH01 <br>
	 * ESM_BKG_0351 : SEARCH <br>
	 * ESM_BKG_0282 : SEARCH <br>
	 * ESM_BKG_0490 : SEARCH <br>
	 * ESM_BKG_0310 : SEARCH <br>
	 * ESM_BKG_0311 : SEARCH <br>
	 * ESM_BKG_0302 : SEARCH <br>
	 * ESM_BKG_0303 : SEARCH <br>
	 * ESM_BKG_0533 : SEARCH <br>
	 * ESM_BKG_0002 : SEARCH <br>
	 * ESM_BKG_0210 : SEARCH <br>
	 * ESM_BKG_0329 : SEARCH <br>
	 * ESM_BKG_0337 : SEARCH <br>
	 * ESM_BKG_0505 : SEARCH, COMMAND09 <br>
	 * ESM_BKG_0030 : SEARCH, SEARCH03<br>
	 * ESM_BKG_0540 : SEARCH, SEARCH04 <br>
	 * ESM_BKG_1033 : SEARCH01, SEARCH02, SEARCH03, SEARCH04 <br>
	 * ESM_BKG_0613 : SEARCH01 <br>
	 * ESM_BKG_0543 : SEARCH01 <br>
	 * ESM_BKG_0514 : SEARCH01 <br>
	 * ESM_BKG_0233 : SEARCH01 <br>
	 * ESM_BKG_0370 : SEARCH <br>
	 * ESM_BKG_0408 : SEARCH, SEARCH01 <br>
	 * ESM_BKG_0533 : SEARCH <br>
	 * ESM_BKG_1106 : SEARCH <br>
	 * ESM_BKG_1141 : SEARCH <br>
	 * ESM_BKG_1142 : SEARCH <br>
	 * ESM_BKG_1148 : SEARCH <br>
	 * ESM_BKG_1149 : SEARCH <br>
	 * ESM_BKG_1155 : SEARCH <br>
	 * ESM_BKG_1162 : SEARCH <br>
	 * ESM_BKG_1163 : SEARCH <br>
	 * ESM_BKG_1168 : SEARCH <br>
	 * 화물에 대한 Manifest List를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		RocsManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0210Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0351Event")) {
				EsmBkg0351Event event = (EsmBkg0351Event) e;
				List<RocsContainerVO> rocsContainerVOs = null;
				RocsContainerVO rocsContainerVO = null;
				command = new RocsManifestListDownloadBCImpl();
				rocsContainerVOs = (List<RocsContainerVO>) (Object) (command.searchManifestList((ManifestListCondVO) event
						.getRocsManifestListCondVO()));
				if (rocsContainerVOs.size() > 0) {
					rocsContainerVO = rocsContainerVOs.get(0);
					List<RocsSearchInboundBlListVO> rocsSearchInboundBlListVOs = rocsContainerVO.getRocsSearchInboundBlListVOs();
					eventResponse.setRsVoList(rocsSearchInboundBlListVOs);
				} else {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")) {
				EsmBkg0061Event event = (EsmBkg0061Event) e;
				List<RocsContainerVO> rocsContainerVOs = null;
				RocsContainerVO rocsContainerVO = null;
				command = new RocsManifestListDownloadBCImpl();
				rocsContainerVOs = (List<RocsContainerVO>) (Object) (command.searchManifestList((ManifestListCondVO) event
						.getRocsManifestListCondVO()));
				Map<String, String> etcData = new HashMap<String, String>();
				eventResponse.setETCData("eta_dt", "");
				eventResponse.setETCData("etd_dt", "");
				eventResponse.setETCData("eng_nm", "");
				eventResponse.setETCData("vsl_cd", "");
				eventResponse.setETCData("skd_voy_no", "");
				eventResponse.setETCData("skd_dir_cd", "");
				if (rocsContainerVOs.size() > 0) {
					rocsContainerVO = rocsContainerVOs.get(0);
					RocsSearchVslInfoVO rocsSearchVslInfoVO = rocsContainerVO.getRocsSearchVslInfoVO();
					eventResponse.setETCData("eta_dt", rocsSearchVslInfoVO.getVpsEtaDt());
					eventResponse.setETCData("etd_dt", rocsSearchVslInfoVO.getVpsEtdDt());
					eventResponse.setETCData("eng_nm", rocsSearchVslInfoVO.getVslEngNm());
					eventResponse.setETCData("vsl_cd", rocsSearchVslInfoVO.getVslCd());
					eventResponse.setETCData("skd_voy_no", rocsSearchVslInfoVO.getSkdVoyNo());
					eventResponse.setETCData("skd_dir_cd", rocsSearchVslInfoVO.getSkdDirCd());
					eventResponse.setETCData("frm_crn_number", rocsSearchVslInfoVO.getVslCallRefNo());
					List<RocsSearchPortListVO> rocsSearchPortListVOs = rocsContainerVO.getRocsSearchPortListVOs();
					eventResponse.setRsVoList(rocsSearchPortListVOs);
					List<RocsSearchBlCountVO> rocsSearchBlCountVOs = rocsContainerVO.getRocsSearchBlCountVOs();
					eventResponse.setRsVoList(rocsSearchBlCountVOs);
					List<RocsManifestConfirmationVO> rocsManifestConfirmationVOs = rocsContainerVO.getRocsManifestConfirmationVOs();
					eventResponse.setRsVoList(rocsManifestConfirmationVOs);
				} else {
					eventResponse.setETCData("eta_dt", "");
					eventResponse.setETCData("etd_dt", "");
					eventResponse.setETCData("eng_nm", "");
					eventResponse.setETCData("vsl_cd", "");
					eventResponse.setETCData("skd_voy_no", "");
					eventResponse.setETCData("skd_dir_cd", "");
					eventResponse.setETCData("frm_crn_number", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				}
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0444Event")) {
				EsmBkg0444Event event = (EsmBkg0444Event) e;
				command = new RocsManifestListDownloadBCImpl();
				List<ManifestListVO> list = command.searchManifestList(event.getRocsVesselArrivalCondVO());
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
	private EventResponse confirmManifestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RocsManifestListDownloadBC command = null;
		try {
			begin();
			EsmBkg0061Event event = (EsmBkg0061Event) e;
			command = new RocsManifestListDownloadBCImpl();
			command.confirmManifestList((ManifestConfirmationVO[]) event.getRocsManifestConfirmationVOs(), account);
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
	 * ESM_BKG_0127 : MODIFY01<BR>
	 * ESM_BKG_0036 : MODIFY<BR>
	 * Container Manifest정보를 업데이트 한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RocsManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")) {
				EsmBkg0061Event event = (EsmBkg0061Event) e;
				command = new RocsManifestListDownloadBCImpl();
				RocsManifestConfirmationVO[] listVO = event.getRocsManifestConfirmationVOs();
				List<BlKeyVO> rocsBlKeyVOs = new ArrayList<BlKeyVO>();
				if (listVO.length > 0) {
					RocsBlKeyVO tempvo = null;
					for (int i = 0; i < listVO.length; i++) {
						tempvo = new RocsBlKeyVO();
						tempvo.setBlNO(listVO[i].getBlNo());
						tempvo.setBlTpCd(listVO[i].getBlTpCd());
						tempvo.setCrnNumber(listVO[i].getFrmCrnNumber());
						rocsBlKeyVOs.add(tempvo);
					}
				}
				command.removeBl(rocsBlKeyVOs, account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00593").getUserMessage());
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
	 * ESM_BKG_0457 : MULTI01 <br>
	 * ESM_BKG_0034 : SEARCH02 <br>
	 * 세관 신고시 필요한 Manifest B/L 정보를 Active 상태로 업데이트 한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RocsCustomsTransmissionBC command = null;
		// ManifestListDownloadBC maniCommand = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")) {
				EsmBkg0061Event event = (EsmBkg0061Event) e;
				command = new RocsCustomsTransmissionBCImpl();
				// flatFile =
				// command.transmitManifest(event.getRocsManifestTransmitVOs(),account);
				String key = command.startBackEndJob(account, event.getRocsManifestTransmitVOs(), "ESM_BKG_0061");
				eventResponse.setETCData("KEY", key);
				// eventResponse.setETCData("flatFile",flatFile);
				// eventResponse.setETCData(etcData);
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00204").getUserMessage());
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
	private EventResponse modifyBlPolCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RocsManifestListDownloadBC command = null;
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")) {

				EsmBkg0061Event event = (EsmBkg0061Event) e;
				command = new RocsManifestListDownloadBCImpl();
				command.modifyBlPolCd(event.getRocsManifestTransmitVOs(), account);

				// 성공메시지 셋팅
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
	 * ESM_BKG_0462 : MULTI <br>
	 * VVD,Port 등 입력 후 조회한 세관 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")) {
			EsmBkg0061Event event = (EsmBkg0061Event) e;
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
					if (e.getEventName().equalsIgnoreCase("EsmBkg0329Event")) {
						// DOWN LOAD Success
						eventResponse.setUserMessage(new ErrorHandler("BKG01088").getUserMessage());
					} else if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")) {
						// Data Transmitted successufully!
						eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
					} else {
						// Data Saved Successfully!!
						eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
					}
					strResult = "SUCCESS";
				} else if ("4".equals(rowSet.getString("JB_STS_FLG"))) {
					// 에러메시지세팅
					if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")) {
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
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBlSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RocsManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0351Event event = (EsmBkg0351Event) e;
			command = new RocsManifestListDownloadBCImpl();
			command.modifyBlSeq((BlSeqVO[]) event.getRocsBlSeqVOs(), account);
			// 성공메시지세팅
			// eventResponse.setUserMessage("");
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
	 * ESM_BKG_0061 : MULTI02 <br>
	 * ROCS(ROTTERDAM) 세관 POL CD를 변경한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselArrivalListInRocs(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RocsManifestListDownloadBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0444Event") && e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				EsmBkg0444Event event = (EsmBkg0444Event) e;
				command = new RocsManifestListDownloadBCImpl();
				Map<String, String> etcData = new HashMap<String, String>();
				List<VesselArrivalVO> list = command.searchVesselArrival(event.getRocsVesselArrivalCondVO(),account);
				RocsSearchVesselArrivalVO rocsSearchVesselArrivalVO = null;
				if (list.size() == 0) {
					eventResponse.setETCData("vvd_number", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					return eventResponse;
				}
				if (list.size() > 0) {
					rocsSearchVesselArrivalVO = (RocsSearchVesselArrivalVO) list.get(0);
					eventResponse.setRsVoList(list);
					eventResponse.setETCData("vvd_number", rocsSearchVesselArrivalVO.getVvdNumber());
				}
				eventResponse.setETCData(etcData);
			}
			if (e.getEventName().equalsIgnoreCase("EsmBkg0440Event")) {
				EsmBkg0440Event event = (EsmBkg0440Event) e;
				command = new RocsManifestListDownloadBCImpl();
				List<CrnVO> list = command.searchCRN((ManifestListCondVO) event.getRocsManifestListCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					return eventResponse;
				}
				eventResponse.setRsVoList(list);
			}
			if (e.getEventName().equalsIgnoreCase("EsmBkg0443Event") && e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				EsmBkg0443Event event = (EsmBkg0443Event) e;
				command = new RocsManifestListDownloadBCImpl();
				eventResponse.setETCData("frm_vsl_eng_nm", "");
				eventResponse.setETCData("frm_vps_eta_dt", "");
				eventResponse.setETCData("frm_vvd_number", "");
				eventResponse.setETCData("err_msg", "");
				// Vessel Port Schedule에 등록된 VVD가 아닌 경우
				List<CrnVO> list = command.searchCRNInfo(event.getVslCd(), event.getSkdVoyNo(), event.getSkdDirCd());
				RocscrnVO rocscrnVO = null;
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00163").getUserMessage());
					eventResponse.setETCData("frm_vsl_eng_nm", "");
					eventResponse.setETCData("frm_vps_eta_dt", "");
					eventResponse.setETCData("frm_vvd_number", "");
					return eventResponse;
				} else {
					String crn_number = event.getFrm_crn_number();
					event.getRocsManifestListCondVO().setCrnNumber("");
					List<CrnVO> list2 = command.searchCRN((ManifestListCondVO) event.getRocsManifestListCondVO());
					rocscrnVO = (RocscrnVO) list.get(0);
					eventResponse.setETCData("frm_vsl_eng_nm", rocscrnVO.getVslEngNm());
					eventResponse.setETCData("frm_vps_eta_dt", rocscrnVO.getVpsEtaDt());
					eventResponse.setETCData("frm_vvd_number", rocscrnVO.getVvdNumber());
					if (list2.size() > 0) {
						RocsSearchCRNVO vo = (RocsSearchCRNVO) list2.get(0);
						String cn_number = vo.getCrnNumber().toString();
						if (crn_number.length() > 0 && !crn_number.equalsIgnoreCase(cn_number)) {
							eventResponse.setUserMessage(new ErrorHandler("BKG00547").getUserMessage());
							eventResponse.setETCData("err_msg", "BKG00547");
							return eventResponse;
						}
					}
					// eventResponse.setRsVoList(list);
				}
			}
			if (e.getEventName().equalsIgnoreCase("EsmBkg0443Event") && e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				EsmBkg0443Event event = (EsmBkg0443Event) e;
				command = new RocsManifestListDownloadBCImpl();
				List<CrnVO> list = command.searchCRN(event.getFrm_crn_number(), event.getVslCd(), event.getSkdVoyNo(), event.getSkdDirCd());
				eventResponse.setRsVoList(list);
			}
			if (e.getEventName().equalsIgnoreCase("EsmBkg0443Event") && e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				EsmBkg0443Event event = (EsmBkg0443Event) e;
				command = new RocsManifestListDownloadBCImpl();
				List<CrnVO> list = command.searchCRNInfo((ManifestListCondVO) event.getRocsManifestListCondVO());
				if (list.size() > 0) {
					eventResponse.setRsVoList(list);
				}

				if (!event.getRocsManifestListCondVO().getIbflag().equals(event.getRocsManifestListCondVO().getCrnNumber())) {
					/*
					 * in vo 에 crn 값만 남기고 나머지 값은 null
					 */
					String vsl_cd = event.getRocsManifestListCondVO().getVslCd(); // 화면상에서 입력하는 vsl_cd
					String skd_voy_no = event.getRocsManifestListCondVO().getSkdVoyNo(); // 화면상에서 입력하는 skd_voy_no
					event.getRocsManifestListCondVO().setVslCd("");
					event.getRocsManifestListCondVO().setSkdVoyNo("");
					event.getRocsManifestListCondVO().setSkdDirCd("");
					list = command.searchCRNInfo((ManifestListCondVO) event.getRocsManifestListCondVO());
					
					if (list.size() > 0 ) {
						// exception 발생

						RocscrnVO crnVO = (RocscrnVO) list.get(0);
						String arr[] = new String[1];
						arr[0] = crnVO.getVslCd() + crnVO.getSkdVoyNo() + crnVO.getSkdDirCd();
						if(!(vsl_cd+skd_voy_no).equals(crnVO.getVslCd() + crnVO.getSkdVoyNo()) ){ 
							eventResponse.setETCData("err_msg", "BKG06142");
							eventResponse.setUserMessage(new ErrorHandler("BKG06142", arr).getUserMessage());
						}
					}
				}
			}
			if (e.getEventName().equalsIgnoreCase("EsmBkg0443Event") && e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				EsmBkg0443Event event = (EsmBkg0443Event) e;
				command = new RocsManifestListDownloadBCImpl();
				List<CrnVO> list = command.searchCRNInfo((ManifestListCondVO) event.getRocsManifestListCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					return eventResponse;
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
	 * ESM_BKG_0029 : MODIFY<BR>
	 * ESM_BKG_0029 : REMOVE<BR>
	 * ESM_BKG_0045 : MULTI<BR>
	 * 세관 테이블에 Customr, Container, Commodity(CM) 등의 BL 정보를 생성, 수정, 삭제 한다<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVesselArrival(Event e) throws EventException {
		RocsManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0443Event")) { // Rocs
				command = new RocsManifestListDownloadBCImpl();
				EsmBkg0443Event event = (EsmBkg0443Event) e;
				int ret = command.manageCRN(event.getRocscrnVO(), account); 
				if (ret == 8)
					eventResponse.setUserMessage(new ErrorHandler("BKG00163").getUserMessage()); // "VVD is NOT Registered"
				else if (ret == 9)
					eventResponse.setUserMessage(new ErrorHandler("BKG00547").getUserMessage()); // VVD already exist
				else
					eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage()); // "Data Saved Successfully!!"
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
	private EventResponse searchManifestListForRocsBl(Event e) throws EventException {
		RocsManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0442Event event = (EsmBkg0442Event) e;
			List<RocsContainerVO> rocsContainerVOs = null;
			RocsContainerVO rocsContainerVO = null;
			command = new RocsManifestListDownloadBCImpl();
			rocsContainerVOs = (List<RocsContainerVO>) (Object) (command.searchManifestListForRocsBl((ManifestListCondVO) event
					.getRocsManifestListCondVO()));
			RocsSearchCargoDetailVO rocsSearchCargoDetailVO = null;
			Map<String, String> etcData = new HashMap<String, String>();
			double totpackage = 0;
			double totweight = 0;
			if (rocsContainerVOs.size() > 0) {
				rocsContainerVO = rocsContainerVOs.get(0);
				RocsSearchBlInfoVO rocsSearchBlInfoVO = rocsContainerVO.getRocsSearchBlInfoVO();
				eventResponse.setETCData("etc_bkg_no", rocsSearchBlInfoVO.getBkgNo());
				eventResponse.setETCData("bkg_no", rocsSearchBlInfoVO.getBkgNo());
				eventResponse.setETCData("fax_no", rocsSearchBlInfoVO.getFaxNo());
				eventResponse.setETCData("cust_eml", rocsSearchBlInfoVO.getCustEml());
				eventResponse.setETCData("shpr_addr1", rocsSearchBlInfoVO.getShprAddr1());
				eventResponse.setETCData("shpr_addr2", rocsSearchBlInfoVO.getShprAddr2());
				eventResponse.setETCData("cnee_addr1", rocsSearchBlInfoVO.getCneeAddr1());
				eventResponse.setETCData("cnee_addr2", rocsSearchBlInfoVO.getCneeAddr2());
				eventResponse.setETCData("ntfy_addr1", rocsSearchBlInfoVO.getNtfyAddr1());
				eventResponse.setETCData("ntfy_addr2", rocsSearchBlInfoVO.getNtfyAddr2());
				eventResponse.setETCData("shpr_cnt_cd", rocsSearchBlInfoVO.getShprCntCd());
				eventResponse.setETCData("shpr_cust_seq", rocsSearchBlInfoVO.getShprCustSeq());
				eventResponse.setETCData("cnee_cnt_cd", rocsSearchBlInfoVO.getCneeCntCd());
				eventResponse.setETCData("cnee_cust_seq", rocsSearchBlInfoVO.getCneeCustSeq());
				eventResponse.setETCData("ntfy_cnt_cd", rocsSearchBlInfoVO.getNtfyCntCd());
				eventResponse.setETCData("ntfy_cust_seq", rocsSearchBlInfoVO.getNtfyCustSeq());
				eventResponse.setETCData("vsl_cd", rocsSearchBlInfoVO.getVslCd());
				eventResponse.setETCData("vvd_number", rocsSearchBlInfoVO.getVvdNumber());
				eventResponse.setETCData("skd_voy_no", rocsSearchBlInfoVO.getSkdVoyNo());
				eventResponse.setETCData("skd_dir_cd", rocsSearchBlInfoVO.getSkdDirCd());
				eventResponse.setETCData("frt_term_cd", rocsSearchBlInfoVO.getFrtTermCd());
				eventResponse.setETCData("t1_doc_cd", rocsSearchBlInfoVO.getT1DocCd());
				eventResponse.setETCData("shpr_eori_no", rocsSearchBlInfoVO.getShprEoriNo());
				eventResponse.setETCData("shpr_cty_nm", rocsSearchBlInfoVO.getShprCtyNm());
				eventResponse.setETCData("shpr_cstms_decl_cnt_cd", rocsSearchBlInfoVO.getShprCstmsDeclCntCd());
				eventResponse.setETCData("shpr_zip_id", rocsSearchBlInfoVO.getShprZipId());
				eventResponse.setETCData("shpr_st_nm", rocsSearchBlInfoVO.getShprStNm());
				eventResponse.setETCData("cnee_eori_no", rocsSearchBlInfoVO.getCneeEoriNo());
				eventResponse.setETCData("cnee_cty_nm", rocsSearchBlInfoVO.getCneeCtyNm());
				eventResponse.setETCData("cnee_cstms_decl_cnt_cd", rocsSearchBlInfoVO.getCneeCstmsDeclCntCd());
				eventResponse.setETCData("cnee_zip_id", rocsSearchBlInfoVO.getCneeZipId());
				eventResponse.setETCData("cnee_st_nm", rocsSearchBlInfoVO.getCneeStNm());
				eventResponse.setETCData("ntfy_eori_no", rocsSearchBlInfoVO.getNtfyEoriNo());
				eventResponse.setETCData("ntfy_cty_nm", rocsSearchBlInfoVO.getNtfyCtyNm());
				eventResponse.setETCData("ntfy_cstms_decl_cnt_cd", rocsSearchBlInfoVO.getNtfyCstmsDeclCntCd());
				eventResponse.setETCData("ntfy_zip_id", rocsSearchBlInfoVO.getNtfyZipId());
				eventResponse.setETCData("ntfy_st_nm", rocsSearchBlInfoVO.getNtfyStNm());
				List<RocsSearchCntrListVO> rocsSearchCntrListVOs = rocsContainerVO.getRocsSearchCntrListVOs();
				eventResponse.setRsVoList(rocsSearchCntrListVOs);
				List<RocsSearchCargoDetailVO> rocsSearchCargoDetailVOs = rocsContainerVO.getRocsSearchCargoDetailVOs();
				if (rocsSearchCargoDetailVOs != null && rocsSearchCargoDetailVOs.size() > 0) {
					for (int i = 0; i < rocsSearchCargoDetailVOs.size(); i++) {
						rocsSearchCargoDetailVO = rocsSearchCargoDetailVOs.get(i);
						totpackage = totpackage + Double.parseDouble(rocsSearchCargoDetailVO.getPckQty());
						totweight = totweight + Double.parseDouble(rocsSearchCargoDetailVO.getCntrMfWgt());
					}
					// eventResponse.setETCData("tot_package",String.valueOf(totpackage));
					// eventResponse.setETCData("tot_weight",String.valueOf(totweight));
					eventResponse.setRsVoList(rocsSearchCargoDetailVOs);
				}
			} else {
				eventResponse.setETCData("etc_bkg_no", "");
				eventResponse.setETCData("bkg_no_split", "");
				eventResponse.setETCData("fax_no", "");
				eventResponse.setETCData("cust_eml", "");
				eventResponse.setETCData("shpr_addr1", "");
				eventResponse.setETCData("shpr_addr2", "");
				eventResponse.setETCData("cnee_addr1", "");
				eventResponse.setETCData("cnee_addr2", "");
				eventResponse.setETCData("ntfy_addr1", "");
				eventResponse.setETCData("ntfy_addr2", "");
				eventResponse.setETCData("shpr_cnt_cd", "");
				eventResponse.setETCData("shpr_cust_seq", "");
				eventResponse.setETCData("cnee_cnt_cd", "");
				eventResponse.setETCData("cnee_cust_seq", "");
				eventResponse.setETCData("ntfy_cnt_cd", "");
				eventResponse.setETCData("ntfy_cust_seq", "");
				eventResponse.setETCData("vsl_cd", "");
				eventResponse.setETCData("skd_voy_no", "");
				eventResponse.setETCData("skd_dir_cd", "");
				eventResponse.setETCData("frt_term_cd", "");
				eventResponse.setETCData("t1_doc_cd", "");
				eventResponse.setETCData("vvd_number", "");
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			}
			eventResponse.setETCData(etcData);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0300 : SEARCH<BR>
	 * ESM_BKG_0728 : SEARCH<BR>
	 * 세관 신고용 B/L별 Notify Address 정보 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RocsManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0442Event")) { // rocs
				EsmBkg0442Event event = (EsmBkg0442Event) e;
				command = new RocsManifestListDownloadBCImpl();
				command.manageManifest(event.getManifestModificationVOs(), account);

				RocsContainerSaveVO rocsContainerSaveVO = (RocsContainerSaveVO) (event.getManifestModificationVOs()[0]);
				RocsBlModificationVO rocsBlModificationVO = rocsContainerSaveVO.getRocsBlModificationVO();
				GeneralBookingReceiptBC command2 = new GeneralBookingReceiptBCImpl();
				command2.modifyIbCustNmAddr(rocsBlModificationVO.getBkgNo(), rocsBlModificationVO.getNtfyAddr1(),
						rocsBlModificationVO.getNtfyAddr2(), account);

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
	private EventResponse addBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RocsManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0444Event") || e.getEventName().equalsIgnoreCase("EsmBkg1017Event")) {
				begin();
				if (e.getEventName().equalsIgnoreCase("EsmBkg0444Event")) {
					EsmBkg0444Event event = (EsmBkg0444Event) e;
					command = new RocsManifestListDownloadBCImpl();
					command.addBl(event.getBlVO(), account);
				} else {
					EsmBkg1017Event event = (EsmBkg1017Event) e;
					command = new RocsManifestListDownloadBCImpl();
					command.addBl(event.getBlVO(), account);
				}
				commit();
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00574").getUserMessage());
			}
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
	 * ESM_BKG_0456 : SEARCH <br>
	 * 일본세관 신고 대상 Customer 정보를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceiveHist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		RocsManifestListDownloadBCImpl command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0448Event")) {
				EsmBkg0448Event event = (EsmBkg0448Event) e;
				command = new RocsManifestListDownloadBCImpl();
				// List<RocsSearchRocsReceiveListVO> rocsSearchRocsReceiveListVO
				// =
				// command2.searchReceiveHist(event.getRocsRcvHistCondVO());
				List<com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ReceiveLogVO> list = command.searchReceiveHist(event
						.getRocsRcvHistCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
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
	 * ESM_BKG_0448 : SEARCH01 <br>
	 * Rotterdam세관에서 받은 edi 현황정보를 가져온다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0448Event event = (EsmBkg0448Event) e;
			RocsManifestListDownloadBCImpl command2 = new RocsManifestListDownloadBCImpl();
			List<RecieveHistLogVO> rocsSearchRocsRcvHistByBlVO = command2.searchHistoryList(event.getRocsHistoryListCondVO());
			if (rocsSearchRocsRcvHistByBlVO.size() == 0) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			}
			eventResponse.setRsVoList(rocsSearchRocsRcvHistByBlVO);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0471 : MODIFY <br>
	 * 일본세관 Manifest 수신 로그를 수정한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransmitHist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		RocsManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0450Event")) {
				EsmBkg0450Event event = (EsmBkg0450Event) e;
				command = new RocsManifestListDownloadBCImpl();
				// List<RocsSearchRocsReceiveListVO> rocsSearchRocsReceiveListVO
				// =
				// command2.searchReceiveHist(event.getRocsRcvHistCondVO());
				List<TransmitHistVO> list = command.searchTransmitHist(event.getRocsTransmitHistCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
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
	 * ESM_BKG_0471 : SEARCH <br>
	 * ESM_BKG_0448 : SEARCH <br>
	 * ESM_BKG_0917 : SEARCH <br>
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 내역을 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransmitHistList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RocsManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0450Event")) {
				EsmBkg0450Event event = (EsmBkg0450Event) e;
				command = new RocsManifestListDownloadBCImpl();
				// List<RocsSearchRocsReceiveListVO> rocsSearchRocsReceiveListVO
				// =
				// command2.searchReceiveHist(event.getRocsRcvHistCondVO());
				List<TransmitHistVO> list = command.searchTransmitHistList(event.getRocsTransmitHistListCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
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
	 * ESM_BKG_0142 : SEARCH<BR>
	 * ACI Report<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceiveLog(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		RocsManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1027Event")) {
				EsmBkg1027Event event = (EsmBkg1027Event) e;
				command = new RocsManifestListDownloadBCImpl();
				List<com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ReceiveLogVO> list = command.searchReceiveLog(event
						.getRocsReceiveLogCondVO());
				if (list.size() == 0)
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
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
	 * ESM_BKG_0478 : SEARCH <br>
	 * ESM_BKG_1032 : SEARCH <br>
	 * 세관에 적하목록 신고시 생성한 송신 EDI 메시지 내역을 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCrnNo(Event e) throws EventException {
		RocsManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg1094Event")) {
				EsmBkg1094Event event = (EsmBkg1094Event) e;
				command = new RocsManifestListDownloadBCImpl();
//				if(list.size() > 0){ // 변경하려는 CRN에서 중복이 발생
//					String vsl_cd = event.getVvdCd().substring(0,8);
//					RocscrnVO crnVO = (RocscrnVO) list.get(0);
//					if((crnVO.getVslCd()+crnVO.getSkdVoyNo()).equals(vsl_cd)){ // 그런데 중복 CRN의 VSL_CD, SKD_VOY_NO이 같음
//						command.manageCrnNo(event.getVslCallRefNoOld(), event.getVslCallRefNoNew(), account);
//						eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
//					}
//					else{
//						eventResponse.setETCData("err_msg", "BKG06142");
//						eventResponse.setUserMessage(new ErrorHandler("BKG06142").getUserMessage());
//					}
//				}else
//				{
					command.manageCrnNo(event.getVslCallRefNoOld(), event.getVslCallRefNoNew(), account);
					eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
//				}
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
	 * ESM_BKG_0470 : MULTI01 <br>
	 * ESM_BKG_0493 : MULTI01 <br>
	 * ESM_BKG_0494 : MULTI01 <br>
	 * ESM_BKG_0015 : ADD <br>
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRocsLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		RocsManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// EsmBkg1135Event event =(EsmBkg1135Event) e;
			List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = null;
			command = new RocsManifestListDownloadBCImpl();
			bkgHrdCdgCtntVOs = command.searchRocsLane();

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
	 * ESM_BKG_1135 : MULTI<BR>
	 * ROCS 의 CRN List 화면에서 Lane 정보 수정<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRocsLane(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RocsManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1135Event event = (EsmBkg1135Event) e;
			command = new RocsManifestListDownloadBCImpl();

			command.manageRocsLane(event.getBkgHrdCdgCtntVOs(), account);
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
	 * ESM_BKG_0346 : INIT <br>
	 * 한국세관에 대한 Transmit Info 를 초기화 값으로 셋팅<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveOpusbkgUdevcom(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RocsCustomsTransmissionBC command = null;
		RocsManifestListDownloadBC maniCommand = null;
		try {
			begin();
			EsmBkgOpusbkgUdevcomEvent event = (EsmBkgOpusbkgUdevcomEvent) e;
			command = new RocsCustomsTransmissionBCImpl();
			maniCommand = new RocsManifestListDownloadBCImpl();
			RocsManifestTransmitVO rocsManifestTransmitVO = command.receiveOpusbkgUdevcom(event.getFlatFile(), account);
			maniCommand.modifyBlReceivedSts(rocsManifestTransmitVO);
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
