/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsDeclarationSrilankaSC.java
*@FileTitle : CustomsDeclarationSrilankaSC
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
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.basic.SrilankaCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.basic.SrilankaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.basic.SriLankaManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.basic.SriLankaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event.EsmBkg0490Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event.EsmBkg0493Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event.EsmBkgSlkcusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchBlListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchCntrListTempVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchEtdDtVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchManifestVpsVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchRegistNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchResponseVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchVsselNameVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaVesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclarationSrilanka Business Logic ServiceCommand<br>
 * - Process the business transactions for the OPUS-CustomsDeclarationSrilanka.
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class CustomsDeclarationSrilankaSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationSrilankaSC system <br>
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
	 * CustomsDeclarationSrilankaSC system <br>
	 * ESM_BKG_1085 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationSrilankaSC 종료");
	}

	/**
	 *
	 * CustomsDeclarationSrilankaSC system <br>
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

		if (e.getEventName().equalsIgnoreCase("EsmBkg0490Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0493Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkgSlkcusAckEvent")) {
			eventResponse = loadCstmsRcvMsg(e);
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0493 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(CMF 데이터) 를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SriLankaManifestListDownloadBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0493Event")) {
				EsmBkg0493Event event = (EsmBkg0493Event) e;
				command = new SriLankaManifestListDownloadBCImpl();
				List<SriLankaVesselArrivalDetailVO> sriLankaVesselArrivalDetailVOs = null;
				SriLankaVesselArrivalDetailVO siLankaVesselArrivalDetailVO = null;
				Map<String, String> etcData = new HashMap<String, String>();
				sriLankaVesselArrivalDetailVOs = (List<SriLankaVesselArrivalDetailVO>) (Object) (command.searchVesselArrival(event.getSriLankaVesselArrivalCondVO()));
				if (sriLankaVesselArrivalDetailVOs.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					eventResponse.setETCData("sr_sts_cd", "");
					eventResponse.setETCData("rgst_dt", "");
					eventResponse.setETCData("rjct_dt", "");
					eventResponse.setETCData("vsl_auth_no", "");
					eventResponse.setETCData("sr_sts_desc", "");
					eventResponse.setETCData("sr_cmt_desc", "");
					eventResponse.setETCData("decl_bl_qty", "");
					return eventResponse;
				}
				// eventResponse.setRsVoList(command.searchVesselArrival2(event.getAncsCstmsVesselArrivalCondVO()));
				eventResponse.setRsVoList(sriLankaVesselArrivalDetailVOs);
				siLankaVesselArrivalDetailVO = sriLankaVesselArrivalDetailVOs.get(0);
				eventResponse.setETCData("sr_sts_cd", siLankaVesselArrivalDetailVO.getSrStsCd());
				eventResponse.setETCData("rgst_dt", siLankaVesselArrivalDetailVO.getRgstDt());
				eventResponse.setETCData("rjct_dt", siLankaVesselArrivalDetailVO.getRjctDt());
				eventResponse.setETCData("vsl_auth_no", siLankaVesselArrivalDetailVO.getVslAuthNo());
				eventResponse.setETCData("sr_sts_desc", siLankaVesselArrivalDetailVO.getSrStsDesc());
				eventResponse.setETCData("sr_cmt_desc", siLankaVesselArrivalDetailVO.getSrCmtDesc());
				eventResponse.setETCData("decl_bl_qty", siLankaVesselArrivalDetailVO.getDeclBlQty());
				eventResponse.setETCData(etcData);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0493 : MULTI <br>
	 * DBF 파일생성해서 로컬로 파일 경로를 반환한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVesselArrival(Event e) throws EventException {
		SriLankaManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0493Event")) {
				EsmBkg0493Event event = (EsmBkg0493Event) e;
				command = new SriLankaManifestListDownloadBCImpl();
				command.manageVesselArrival((VesselArrivalVO) event.getSriLankaVesselArrivalVO(), account);
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
	 * ESM_BKG_0493 : MULTI01<br>
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
	 * ESM_BKG_0490 : SEARCH <br>
	 *
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		SriLankaManifestListDownloadBC command = null;


		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0490Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0490Event")) {
				EsmBkg0490Event event = (EsmBkg0490Event) e;
				List<SriLankaContainerVO> sriLankaContainerVOs = null;
				SriLankaContainerVO sriLankaContainerVO = null;
				command = new SriLankaManifestListDownloadBCImpl();
				sriLankaContainerVOs = (List<SriLankaContainerVO>) (Object) (command.searchManifestList((ManifestListCondVO) event.getSriLankaManifestListCondVO()));
				Map<String, String> etcData = new HashMap<String, String>();
				eventResponse.setETCData("sr_sts_cd", "");
				eventResponse.setETCData("rgst_dt", "");
				eventResponse.setETCData("rjct_dt", "");
				eventResponse.setETCData("vsl_auth_no", "");
				eventResponse.setETCData("sr_sts_desc", "");
				eventResponse.setETCData("sr_cmt_desc", "");
				eventResponse.setETCData("decl_bl_qty", "");
				eventResponse.setETCData("total_bl", "");
				eventResponse.setETCData("total_cntr", "");
				if (sriLankaContainerVOs.size() > 0) {
					sriLankaContainerVO = sriLankaContainerVOs.get(0);
					SriLankaSearchManifestVpsVO sriLankaSearchManifestVpsVO = sriLankaContainerVO.getSriLankaSearchManifestVpsVO();
					if (sriLankaSearchManifestVpsVO != null)
						eventResponse.setETCData("eta_dt", sriLankaSearchManifestVpsVO.getVpsEtsDt());
					else
						eventResponse.setETCData("eta_dt", "");
					SriLankaSearchEtdDtVO sriLankaSearchEtdDtVO = sriLankaContainerVO.getSriLankaSearchEtdDtVO();
					if (sriLankaSearchEtdDtVO != null)
						eventResponse.setETCData("etd_dt", sriLankaSearchEtdDtVO.getVpsEtdDt());
					else
						eventResponse.setETCData("etd_dt", "");
					SriLankaSearchVsselNameVO sriLankaSearchVsselNameVO = sriLankaContainerVO.getSriLankaSearchVsselNameVO();
					if (sriLankaSearchVsselNameVO != null)
						eventResponse.setETCData("vsl_nm", sriLankaSearchVsselNameVO.getVslEngNm());
					else
						eventResponse.setETCData("vsl_nm", "");
					SriLankaSearchRegistNoVO sriLankaSearchRegistNoVO = sriLankaContainerVO.getSriLankaSearchRegistNoVO();
					if (sriLankaSearchRegistNoVO != null) {
						eventResponse.setETCData("auth_no", sriLankaSearchRegistNoVO.getVslAuthNo());
						// eventResponse.setETCData("reg_no",sriLankaSearchRegistNoVO.getVslRgstNo());
					} else {
						eventResponse.setETCData("auth_no", "");
						// eventResponse.setETCData("reg_no","");
					}
					SriLankaSearchResponseVO sriLankaSearchResponseVO = sriLankaContainerVO.getSriLankaSearchResponseVO();
					if (sriLankaSearchResponseVO != null) {
						eventResponse.setETCData("sr_sts_cd", sriLankaSearchResponseVO.getSrStsCd());
						eventResponse.setETCData("rgst_dt", sriLankaSearchResponseVO.getRgstDt());
						eventResponse.setETCData("rjct_dt", sriLankaSearchResponseVO.getRjctDt());
						eventResponse.setETCData("vsl_auth_no", sriLankaSearchResponseVO.getVslAuthNo());
						eventResponse.setETCData("sr_sts_desc", sriLankaSearchResponseVO.getSrStsDesc());
						eventResponse.setETCData("sr_cmt_desc", sriLankaSearchResponseVO.getSrCmtDesc());
						eventResponse.setETCData("decl_bl_qty", sriLankaSearchResponseVO.getDeclBlQty());
					} else {
						eventResponse.setETCData("sr_sts_cd", "");
						eventResponse.setETCData("rgst_dt", "");
						eventResponse.setETCData("rjct_dt", "");
						eventResponse.setETCData("vsl_auth_no", "");
						eventResponse.setETCData("sr_sts_desc", "");
						eventResponse.setETCData("sr_cmt_desc", "");
						eventResponse.setETCData("decl_bl_qty", "");
					}
					List<SriLankaSearchBlListVO> sriLankaSearchBlListVOs = sriLankaContainerVO.getSriLankaSearchBlListVOs();
					List<SriLankaSearchCntrListTempVO> sriLankaSearchCntrListVOs = sriLankaContainerVO.getSriLankaSearchCntrListTempVOs();
					if (sriLankaSearchBlListVOs.size() > 0) {
						SriLankaSearchBlListVO sriLankaSearchBlListVO = (SriLankaSearchBlListVO) sriLankaSearchBlListVOs.get(0);
						eventResponse.setETCData("total_bl", sriLankaSearchBlListVO.getBlTotal());
					}
					if (sriLankaSearchCntrListVOs.size() > 0) {
						SriLankaSearchCntrListTempVO sriLankaSearchCntrListTempVO = (SriLankaSearchCntrListTempVO) sriLankaSearchCntrListVOs.get(0);
						eventResponse.setETCData("total_cntr", sriLankaSearchCntrListTempVO.getBlTotal());
					}
					eventResponse.setRsVoList(sriLankaSearchBlListVOs);
					eventResponse.setRsVoList(sriLankaSearchCntrListVOs);
				} else {
					eventResponse.setETCData("eta_dt", "");
					eventResponse.setETCData("total_cntr", "");
					eventResponse.setETCData("total_bl", "");
					eventResponse.setETCData("etd_dt", "");
					eventResponse.setETCData("vsl_nm", "");
					eventResponse.setETCData("auth_no", "");
					eventResponse.setETCData("reg_no", "");
					eventResponse.setETCData("total_bl", "");
					eventResponse.setETCData("sr_sts_cd", "");
					eventResponse.setETCData("rgst_dt", "");
					eventResponse.setETCData("rjct_dt", "");
					eventResponse.setETCData("vsl_auth_no", "");
					eventResponse.setETCData("sr_sts_desc", "");
					eventResponse.setETCData("sr_cmt_desc", "");
					eventResponse.setETCData("decl_bl_qty", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				}
				eventResponse.setETCData(etcData);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 *
	 * ESM_BKG_0490 : MULTI <br>
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SrilankaCustomsTransmissionBC command = null;

		String flatFile = "";
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0490Event")) {
				EsmBkg0490Event event = (EsmBkg0490Event) e;
				command = new SrilankaCustomsTransmissionBCImpl();
				flatFile = command.transmitManifest(event.getSrilankaManifestTransmitVOs(), account);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
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
	 * ESM_BKG_0013 : MULTI<BR>
	 * 세관 관련 VVD 정보 생성, 수정, 삭제<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadCstmsRcvMsg(Event e) throws EventException {
		log.info("SC [loadCstmsRcvMsg] Start---------------------");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SrilankaCustomsTransmissionBC command = null;
		try {
			begin();
			EsmBkgSlkcusAckEvent event = (EsmBkgSlkcusAckEvent) e;
			command = new SrilankaCustomsTransmissionBCImpl();
			command.loadCstmsRcvMsg(event.getFlatFile(), "");
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


}
