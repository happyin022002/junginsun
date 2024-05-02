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

import org.json.simple.JSONObject;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.eur.basic.EurCustomsReportBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.eur.basic.EurCustomsReportBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.eur.event.EsmBkg1032Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.SendLogDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.basic.EurCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.basic.EurCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.event.EsmBkg0257Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.event.EsmBkg0484Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.event.OpusbkgUbizcomEurcusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifesDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifestCondForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProENSDownExcelVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
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
 * OPUS-CustomsDeclarationEurSC Business Logic ServiceCommand -
 * OPUS-CustomsDeclarationEurSC handling business transaction.
 * 
 * @author 2012505
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationEurSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationEurSC system <br>
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
	 * CustomsDeclarationEurSC system <br>
	 * ESM_BKG-0017 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationEurSC 종료");
	}

	/**
	 * 
	 * OPUS-CustomsDeclarationEurSC system <br>
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
		if (e.getEventName().equalsIgnoreCase("EsmBkg0484Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchExistVvdPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchENSDownExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchLDFDownExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = backEndJobResultLdfDown(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0257Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchUvi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchReceiver(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchEurManifestList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("OpusbkgUbizcomEurcusAckEvent")) {
			eventResponse = loadCstmsRcvMsg(e);
		} else if (e.getEventName().equalsIgnoreCase("OpusbkgSpainCRNReceiveEvent")) {
			eventResponse = loadCstmsRcvMsg(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSendLog(e);
			}
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * 화물에 대한 Manifest List를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0210Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0484Event")) {
				EsmBkg0484Event event = (EsmBkg0484Event) e;
				EurCustomsTransmissionBC command2 = new EurCustomsTransmissionBCImpl();
				// BC에 작업 요청
				List<SitProCargoManifesDetailVO> list = command2.searchSitProList(event.getSitProCargoManifestCondForEdiVO());

				// [CHM-201327127] [RFS Lane] Double calling logic 적용 요청 (2)
				// SItpro & Firm BKG
				SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO = new SitProCargoManifestCondForEdiVO();
				sitProCargoManifestCondForEdiVO = event.getSitProCargoManifestCondForEdiVO();

				if (list.size() > 0) {
					SitProCargoManifesDetailVO ovo = (SitProCargoManifesDetailVO) list.get(0);

					if ("RFS".equals(ovo.getSlanCd())) {
						if ("".equals(sitProCargoManifestCondForEdiVO.getPolYdCd()) || "".equals(sitProCargoManifestCondForEdiVO.getPodYdCd())) {
							throw new EventException((String) new ErrorHandler("BKG06148", new String[] { "for RFS" }).getMessage());
						}
					}
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
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EurCustomsTransmissionBC command = null;

		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0257Event")) {
				EsmBkg0257Event event = (EsmBkg0257Event) e;
				command = new EurCustomsTransmissionBCImpl();
				EurManifestTransmitVO[] eurManifestTransmitVOs = event.getEuManifestTransmitVOs();
				String key = command.startBackEndJob(account, eurManifestTransmitVOs, "ESM_BKG_0257");
				eventResponse.setETCData("KEY", key);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0484Event")) {

				// Sitpro FLATFILE 생성 및 전송
				EsmBkg0484Event event = (EsmBkg0484Event) e;
				command = new EurCustomsTransmissionBCImpl();
				EurManifestTransmitVO[] eurManifestTransmitVOs = event.getEuManifestTransmitVOs();
				String key = command.startBackEndJob(account.getUsr_id(), eurManifestTransmitVOs, "ESM_BKG_0484");
				eventResponse.setETCData("KEY", key);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0257Event")) {
				// ENS EDI FLAT FILE 생성 및 전송
				EsmBkg0257Event event = (EsmBkg0257Event) e;
				command = new EurCustomsTransmissionBCImpl();
				command.transmitManifest(event.getEuManifestTransmitVOs(), account);
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
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if (e.getEventName().equalsIgnoreCase("EsmBkg0484Event")) {
			EsmBkg0484Event event = (EsmBkg0484Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0257Event")) {
			EsmBkg0257Event event = (EsmBkg0257Event) e;
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
					if (e.getEventName().equalsIgnoreCase("EsmBkg0484Event")) {
						String flatfile = (String) BackEndJobResult.loadFromFile(sKey);
						String[] flatFileRowArray = flatfile.split("\n");
						List<SendFlatFileVO> flatFileVOList = new ArrayList<SendFlatFileVO>();
						SendFlatFileVO flatFileVO = null;
						for (int i = 0; i < flatFileRowArray.length; i++) {
							flatFileVO = new SendFlatFileVO();
							flatFileVO.setFlatFile(flatFileRowArray[i].replace("\r", ""));
							flatFileVOList.add(flatFileVO);
						}
						eventResponse.setRsVoList(flatFileVOList);
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
	 * ESM_BKG_0484 : SEARCH07 <br>
	 * SitPro LDF DOWNLOAD EXCEL<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResultLdfDown(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		EsmBkg0484Event event = (EsmBkg0484Event) e;
		sKey = event.getKey();
		String strResult = "";
		try {
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
			while (rowSet.next()) {
				if ("2".equals(rowSet.getString("JB_STS_FLG"))) {
					// BackEndJob 처리중
					strResult = "PROCESSING";
				} else if ("3".equals(rowSet.getString("JB_STS_FLG"))) {
					if (e.getEventName().equalsIgnoreCase("EsmBkg0484Event")) {
						HashMap<String, Object> resultMap = (HashMap<String, Object>) BackEndJobResult.loadFromFile(sKey);

						String result = JSONObject.toJSONString(resultMap);

						eventResponse.setETCData("result", result);
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
	private EventResponse searchExistVvdPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EurCustomsTransmissionBC command = null;
		try {
			EsmBkg0484Event event = (EsmBkg0484Event) e;
			command = new EurCustomsTransmissionBCImpl();
			String retVal = command.searchExistVvdPort(event.getSitProCargoManifestCondForEdiVO());
			eventResponse.setETCData("existVvdPortYn", retVal);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1085 : SEARCH02<BR>
	 * ESM_BKG_1086 : SEARCH<BR>
	 * 국가별 Package Unit 조회<BR>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchENSDownExcel(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		EurCustomsTransmissionBC command = null;
		EsmBkg0484Event event = null;
		List<SitProENSDownExcelVO> list = null;
		try {
			eventResponse = new GeneralEventResponse();
			event = (EsmBkg0484Event) e;
			command = new EurCustomsTransmissionBCImpl();
			list = command.searchENSDownExcel(event.getSitProCargoManifestCondForEdiVO(), event.getBkgNos());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0484 : SEARCH06<BR>
	 * ESM_BKG_0484 : LDF DOWNLOAD<BR>
	 * SitPro LDF DOWNLOAD EXCEL<BR>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLDFDownExcel(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EurCustomsTransmissionBC command = null;

		try {
			begin();

			EsmBkg0484Event event = (EsmBkg0484Event) e;
			command = new EurCustomsTransmissionBCImpl();
			EurManifestTransmitVO[] eurManifestTransmitVOs = event.getEuManifestTransmitVOs();
			String key = command.startLdfDownBackEndJob(account.getUsr_id(), eurManifestTransmitVOs, "ESM_BKG_0484");
			eventResponse.setETCData("KEY", key);
			eventResponse.setUserMessage(new ErrorHandler("BKG00218").getMessage());

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
	 * ESM_BKG_0351 : MULTI <br>
	 * 데이터 확인을 위한 BL List에서 B/L Seq를 수정한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUvi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EurCustomsTransmissionBC command = null;
		try {
			EsmBkg0257Event event = (EsmBkg0257Event) e;
			command = new EurCustomsTransmissionBCImpl();
			String retUvi = command.searchUvi(event.getVvdCd(), event.getPolCd(), event.getPodCd());
			eventResponse.setETCData("uvi", retUvi);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0371 : MULTI, REMOVE <br>
	 * 
	 * MRN CREATE 추가<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0257Event")) {
				EsmBkg0257Event event = (EsmBkg0257Event) e;
				BookingUtil bkgUtil = new BookingUtil();

				String polCd = event.getPolCd();
				String podCd = event.getPodCd();
				String polLocNm = "";
				String podLocNm = "";

				if (polCd != null && !polCd.equals("")) {
					polLocNm = bkgUtil.searchMdmLocName(polCd);
				}
				eventResponse.setETCData("polResult", polLocNm);

				if (podCd != null && !podCd.equals("")) {
					podLocNm = bkgUtil.searchMdmLocName(podCd);
				}

				eventResponse.setETCData("podResult", podLocNm);

			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1046 : SEARCH, SEARCH01 <br>
	 * ESM_BKG_1070 : SEARCH <br>
	 * Customer, Container 등의 BL 정보를 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEurManifestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EurCustomsTransmissionBC command = null;
		try {
			EsmBkg0257Event event = (EsmBkg0257Event) e;
			command = new EurCustomsTransmissionBCImpl();
			List<ManifestListDetailVO> list = null;
			list = command.searchEurManifestList(event.getManifestListCondVO());

			// [CHM-201325432] EU customs EDI 화면, RFS lane yard code mandatory
			// 설정요청
			EurManifestListCondVO eurManifestListCondVO = new EurManifestListCondVO();
			eurManifestListCondVO = (EurManifestListCondVO) event.getManifestListCondVO();

			if (list.size() > 0) {
				EurManifestListVO ovo = (EurManifestListVO) list.get(0);

				if ("RFS".equals(ovo.getSlanCd())) {
					if ("I".equals(eurManifestListCondVO.getModeType()) && "".equals(eurManifestListCondVO.getPodYdCd())) {
						throw new EventException((String) new ErrorHandler("BKG06148", new String[] { "for RFS" }).getMessage());
					}
					if ("O".equals(eurManifestListCondVO.getModeType()) && "".equals(eurManifestListCondVO.getPolYdCd())) {
						throw new EventException((String) new ErrorHandler("BKG06148", new String[] { "for RFS" }).getMessage());
					}
				}

				eventResponse.setETCData("vvd_nm", ovo.getVslFullname());
				eventResponse.setETCData("vvd_ld", ovo.getVslLloydcode());
				eventResponse.setETCData("vvd_call", ovo.getVslCallsign());
				eventResponse.setETCData("eta", ovo.getEta());
				eventResponse.setETCData("etd", ovo.getEtd());
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
	 * 2011.12.26 이경원 [SRM-201122521] Australia Customs Manifest 기능 보완 요청
	 * ESM_BKG_0053 : (Australia Customs Manifest) VVD의 등록여부를 조사한다.
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
		EurCustomsTransmissionBC command = null;
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("OpusbkgUbizcomEurcusAckEvent")) {
				OpusbkgUbizcomEurcusAckEvent event = (OpusbkgUbizcomEurcusAckEvent) e;
				command = new EurCustomsTransmissionBCImpl();
				command.loadCstmsRcvMsg(event.getFlatFile(), "");
			} else if (e.getEventName().equalsIgnoreCase("OpusbkgSpainCRNReceiveEvent")) {
				OpusbkgUbizcomEurcusAckEvent event = (OpusbkgUbizcomEurcusAckEvent) e;
				command = new EurCustomsTransmissionBCImpl();
				command.loadCstmsRcvMsg(event.getFlatFile());
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
	 * ESM_BKG_0989 : SEARCH <br>
	 * KOREA에서 입/출항 선박 신고 적하목록 전송 문서의 상세 내역 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSendLog(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EurCustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1032Event")) {
				command = new EurCustomsReportBCImpl();
				List<SendLogDetailVO> list = null;
				EsmBkg1032Event event = (EsmBkg1032Event) e;
				list = command.searchSendLog(event.getSendLogCondVO());
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
	 * Receiver id 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceiver(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsCommonMgtBC command = null;
		try {
			EsmBkg0257Event event = (EsmBkg0257Event) e;
			EurManifestListCondVO condVO = (EurManifestListCondVO) event.getManifestListCondVO();
			command = new CustomsCommonMgtBCImpl();
			CstmsCdConvVO cstmsCdConvVO = new CstmsCdConvVO();
			cstmsCdConvVO.setChkCntCd("EU");
			cstmsCdConvVO.setChkCstmsDivId("YARD_PARTNER");
			String portCd = condVO.getPolCd();
			String yardCd = condVO.getPolYdCd();
			if ("I".equals(condVO.getModeType())) {
				portCd = condVO.getPodCd();
				yardCd = condVO.getPodYdCd();
			}
			cstmsCdConvVO.setAttrCtnt1(portCd);
			cstmsCdConvVO.setAttrCtnt2(yardCd);
			List<CstmsCdConvVO> list = command.searchCstmsCdConvCtntList(cstmsCdConvVO);
			String receiverId = "";
			if (list.size() > 0) {
				receiverId = list.get(0).getAttrCtnt3();
			} else if (!"".equals(yardCd)) {
				cstmsCdConvVO.setAttrCtnt2("");
				List<CstmsCdConvVO> list2 = command.searchCstmsCdConvCtntList(cstmsCdConvVO);
				if (list2.size() > 0) {
					receiverId = list2.get(0).getAttrCtnt3();
				}
			}
			EurCustomsTransmissionBC command2 = new EurCustomsTransmissionBCImpl();
			String retUvi = command2.searchUvi(condVO.getVvdCd(), condVO.getPolCd(), condVO.getPodCd());
			eventResponse.setETCData("receiver_uvi", receiverId + "_" + retUvi);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
}// end class
