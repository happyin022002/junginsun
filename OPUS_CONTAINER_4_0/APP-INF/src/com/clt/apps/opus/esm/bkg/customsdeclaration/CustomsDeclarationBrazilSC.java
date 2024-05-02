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
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.basic.BrcsCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.basic.BrcsCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.basic.BrcsManifestDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.basic.BrcsManifestDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.event.EsmBkg0127Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.event.EsmBkg0745Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdDetailVO;
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
 * OPUS-CustomsDeclarationBrazil Business Logic ServiceCommand -
 * OPUS-CustomsDeclarationBrazilSC handling business transaction.
 * 
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationBrazilSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationBrazilSC system <br>
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
	 * CustomsDeclarationBrazilSC system <br>
	 * ESM_BKG-0017 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationBrazilSC 종료");
	}

	/**
	 * 
	 * OPUS-CustomsDeclarationBrazilSC system <br>
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
		if (e.getEventName().equalsIgnoreCase("EsmBkg0745Event") || e.getEventName().equalsIgnoreCase("EsmBkg0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchContainerManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyContainerManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHSCode(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0127Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchContainerManifest(e); // NCM Code 조회
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifyContainerManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = deleteManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// Receiver ID 콤보
				response.setRsVoList(searchComCodeCombo("CD02299"));
				eventResponse = response;
			}
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0745 : SEARCH <br>
	 * ESM_BKG_0127 : SEARCH02 <br>
	 * ESM_BKG_0311 : SEARCH01 <br>
	 * ESM_BKG_0036 : SEARCH, SEARCH01, SEARCH02<BR>
	 * Container Manifest 정보를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BrcsManifestDownloadBC command = null;
		try {
			if ("EsmBkg0745Event".equalsIgnoreCase(e.getEventName()) || "EsmBkg0127Event".equalsIgnoreCase(e.getEventName())) { // brazil
				command = new BrcsManifestDownloadBCImpl();
				List<BrHsCdDetailVO> list = null;
				BrHsCdDetailVO brHsCdDetailVO = null;
				if ("EsmBkg0127Event".equalsIgnoreCase(e.getEventName())) { // 그리드에서
																			// Cell값
																			// 변경시
					EsmBkg0127Event event = (EsmBkg0127Event) e;
					BrHsCdCondVO brHsCdCondVO = new BrHsCdCondVO();
					brHsCdCondVO.setBrzCmdtCd((event.getBrManifestListCondVO()).getBrzCmdtCd());
					brHsCdCondVO.setPageGubun("popup");
					list = command.searchHsCdList(brHsCdCondVO);
					if (list.size() > 0) {
						brHsCdDetailVO = list.get(0);
						eventResponse.setETCData("brz_cmdt_cd", brHsCdDetailVO.getBrzCmdtCd());
						eventResponse.setETCData("cmdt_desc", brHsCdDetailVO.getCmdtDesc());
					} else {
						eventResponse.setETCData("brz_cmdt_cd", "");
						eventResponse.setETCData("cmdt_desc", "");
					}
				} else { // NCM Code 팝업 호출시
					EsmBkg0745Event event = (EsmBkg0745Event) e;
					BrHsCdCondVO brHsCdCondVO = event.getBrHsCdCondVO();
					brHsCdCondVO.setPageGubun("main");
					list = command.searchHsCdList(brHsCdCondVO);
					eventResponse.setRsVoList(list);
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
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyContainerManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BrcsManifestDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0127Event")) { // 브라질
				EsmBkg0127Event event = (EsmBkg0127Event) e;
				command = new BrcsManifestDownloadBCImpl();
				command.modifyContainerManifest(event.getBrCnpiNcmByCntrModiVOs(), account);
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
	 * ESM_BKG_0351 : MULTI <br>
	 * 데이터 확인을 위한 BL List에서 B/L Seq를 수정한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHSCode(Event e) throws EventException {
		BrcsManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0745Event")) {
				EsmBkg0745Event event = (EsmBkg0745Event) e;
				command = new BrcsManifestDownloadBCImpl();
				command.manageHSCode(event.getBrHsCdDetailVOs(), account);
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
	 * ESM_BKG_1098 : SEARCH <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		BrcsManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0210Event searchManifestList ===");
		try {

			if (e.getEventName().equalsIgnoreCase("EsmBkg0127Event")) {
				command = new BrcsManifestDownloadBCImpl();
				List<ManifestListDetailVO> list = null;
				EsmBkg0127Event event = (EsmBkg0127Event) e;
				list = command.searchManifestList(event.getBrManifestListCondVO(),account);
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
	 * ESM_BKG_0127 : delete <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		BrcsManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0127Event deleteManifestList ===");
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0127Event")) {
				command = new BrcsManifestDownloadBCImpl();
				EsmBkg0127Event event = (EsmBkg0127Event) e;
				command.deleteManifest(event.getBrCmModiVOs());
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
		BrcsCustomsTransmissionBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0127Event")) { // 브라질
																		// EDI
																		// FLATFILE
																		// 생성
																		// 및
																		// 전송
				EsmBkg0127Event event = (EsmBkg0127Event) e;
				command = new BrcsCustomsTransmissionBCImpl();

				/*
				 * flatFile =
				 * command.transmitManifest(event.getBrManifestTransmitVOs(),
				 * account); eventResponse.setETCData("flatFile", flatFile);
				 * eventResponse.setETCData(etcData);
				 * eventResponse.setUserMessage(new
				 * ErrorHandler("BKG00218").getUserMessage());
				 */

				// BackEnd
				String key = command.startBackEndJob(account, event.getBrManifestTransmitVOs(), "ESM_BKG_0127");
				eventResponse.setETCData("KEY", key);
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
	/*
	 * private EventResponse downloadManifest(Event e) throws EventException {
	 * //v2.0 확인 후 삭제요 GeneralEventResponse eventResponse = new
	 * GeneralEventResponse(); ManifestListDownloadBC command = null; try {
	 * EsmBkg0234Event event = (EsmBkg0234Event) e; command = new
	 * ManilaManifestListDownloadBCImpl(); String filename =
	 * command.downloadManifest(event .getManifestListDetailVO());
	 * eventResponse.setCustomData("filekey", filename);
	 * eventResponse.setETCData("filename", filename); } catch (EventException
	 * ex) { rollback(); throw ex; } catch (Exception ex) { rollback(); throw
	 * new EventException(new ErrorHandler("BKG06087").getMessage(), ex); }
	 * return eventResponse; }
	 */

	/**
	 * ESM_BKG_0216 : COMMAND01 <br>
	 * ESM_BKG_1046 : MULTI01 <br>
	 * ESM_BKG_1162 : MULTI01 <br>
	 * Container Manifest정보를 업데이트 한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BrcsManifestDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0127Event")) { // 브라질
				EsmBkg0127Event event = (EsmBkg0127Event) e;
				command = new BrcsManifestDownloadBCImpl();
				command.manageManifest(event.getBrCmModiVOs(), account);
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
	/*
	 * private EventResponse searchManifestDtlList(Event e) throws
	 * EventException { //v2.0 화면 호출 확인 후 삭제 요 GeneralEventResponse
	 * eventResponse = new GeneralEventResponse(); CustomsTransmissionBC command
	 * = null; try { command = new CndCustomsTransmissionBCImpl();
	 * EsmBkg0002Event event = (EsmBkg0002Event) e;
	 * eventResponse.setRsVoList(command.searchManifestDtlList(event
	 * .getCstmsManifestCondVO())); } catch (EventException ex) { throw ex; }
	 * catch (Exception ex) { throw new EventException(new
	 * ErrorHandler("BKG06086").getMessage(), ex); } return eventResponse; }
	 */

	/**
	 * ESM_BKG_0431 : SEARCH<BR>
	 * Receive History<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if (e.getEventName().equalsIgnoreCase("EsmBkg0127Event")) {
			EsmBkg0127Event event = (EsmBkg0127Event) e;
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
					// Data Saved Successfully!!
					eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

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
	/*
	 * private EventResponse searchUvi(Event e) throws EventException { //v2.0
	 * 화면 호출 확인후 삭제 요 GeneralEventResponse eventResponse = new
	 * GeneralEventResponse(); CustomsTransmissionBC command = null; try {
	 * EsmBkg0257Event event = (EsmBkg0257Event) e; command = new
	 * EurCustomsTransmissionBCImpl(); String retUvi =
	 * command.searchUvi(event.getVvdCd(), event.getPolCd(), event.getPodCd());
	 * eventResponse.setETCData("uvi", retUvi);
	 * 
	 * } catch (EventException ex) { throw ex; } catch (Exception ex) { throw
	 * new EventException(new ErrorHandler("BKG06086").getMessage(), ex); }
	 * return eventResponse; }
	 */

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
	/*
	 * private EventResponse searchLocation(Event e) throws EventException {
	 * //v2.0 화면 호출 확인 후 삭제 요 GeneralEventResponse eventResponse = new
	 * GeneralEventResponse(); CustomsReportBC command = null; try { // 이벤트별
	 * Impl생성 if ("EsmBkg0152Event".equalsIgnoreCase(e.getEventName())) { } else
	 * if (e.getEventName().equalsIgnoreCase("EsmBkg0540Event")) {} else if
	 * (e.getEventName().equalsIgnoreCase("EsmBkg0257Event")) {} else if
	 * (e.getEventName().equalsIgnoreCase("EsmBkg1144Event")) { EsmBkg1144Event
	 * event = (EsmBkg1144Event) e; BookingUtil bkgUtil = new BookingUtil();
	 * String locNm = bkgUtil.searchMdmLocName(event.getStrLocCd());
	 * 
	 * if (!"".equals(locNm)) { eventResponse.setETCData("result", locNm); } }
	 * 
	 * } catch (EventException ex) { throw ex; } catch (Exception ex) { throw
	 * new EventException(new ErrorHandler("BKG06086").getMessage(), ex); }
	 * return eventResponse; }
	 */

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
	/*
	 * private EventResponse searchEurManifestList(Event e) throws
	 * EventException { //v2.0 화겸 호출 확인후 삭제요 GeneralEventResponse eventResponse
	 * = new GeneralEventResponse(); CustomsTransmissionBC command = null; try {
	 * EsmBkg0257Event event = (EsmBkg0257Event) e; command = new
	 * EurCustomsTransmissionBCImpl(); List<ManifestListDetailVO> list = null;
	 * list = command.searchEurManifestList(event.getManifestListCondVO());
	 * 
	 * // [CHM-201325432] EU customs EDI 화면, RFS lane yard code mandatory //
	 * 설정요청 EurManifestListCondVO eurManifestListCondVO = new
	 * EurManifestListCondVO(); eurManifestListCondVO = (EurManifestListCondVO)
	 * event .getManifestListCondVO();
	 * 
	 * if (list.size() > 0) { EurManifestListVO ovo = (EurManifestListVO)
	 * list.get(0);
	 * 
	 * if ("RFS".equals(ovo.getSlanCd())) { if
	 * ("I".equals(eurManifestListCondVO.getModeType()) &&
	 * "".equals(eurManifestListCondVO.getPodYdCd())) { throw new
	 * EventException( (String) new ErrorHandler("BKG06148", new String[] {
	 * "for RFS" }) .getMessage()); } if
	 * ("O".equals(eurManifestListCondVO.getModeType()) &&
	 * "".equals(eurManifestListCondVO.getPolYdCd())) { throw new
	 * EventException( (String) new ErrorHandler("BKG06148", new String[] {
	 * "for RFS" }) .getMessage()); } }
	 * 
	 * eventResponse.setETCData("vvd_nm", ovo.getVslFullname());
	 * eventResponse.setETCData("vvd_ld", ovo.getVslLloydcode());
	 * eventResponse.setETCData("vvd_call", ovo.getVslCallsign());
	 * eventResponse.setETCData("eta", ovo.getEta());
	 * eventResponse.setETCData("etd", ovo.getEtd()); }
	 * 
	 * eventResponse.setRsVoList(list);
	 * 
	 * } catch (EventException ex) { throw ex; } catch (Exception ex) { throw
	 * new EventException(new ErrorHandler("BKG06086").getMessage(), ex); }
	 * return eventResponse; }
	 */

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
}// end class
