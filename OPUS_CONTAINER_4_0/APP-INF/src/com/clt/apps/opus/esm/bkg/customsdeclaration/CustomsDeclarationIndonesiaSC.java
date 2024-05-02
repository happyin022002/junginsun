/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsDeclarationIndonesiaSC.java
*@FileTitle : CustomsDeclarationIndonesiaSC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.basic.IndonesiaCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.basic.IndonesiaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.event.EsmBkg0310Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaFFVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.basic.IndonesiaManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.basic.IndonesiaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.event.EsmBkg0311Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaSearchManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.indonesiaBkgDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclarationIndonesia Business Logic ServiceCommand<br>
 * - Process the business transactions for the OPUS-CustomsDeclarationIndonesia.
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class CustomsDeclarationIndonesiaSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationIndonesiaSC system <br>
	 * ESM_BKG_0311<br>
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
	 * CustomsDeclarationIndonesiaSC system <br>
	 * ESM_BKG_0311 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationIndonesiaSC 종료");
	}

	/**
	 *
	 * CustomsDeclarationIndonesiaSC system <br>
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

		if (e.getEventName().equalsIgnoreCase("EsmBkg0310Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmBkg0311Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContainerManifest(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitManifest(e);
			}
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}



	/**
	 * ESM_BKG_0310 : SEARCH <br>
	 * ESM_BKG_0311 : SEARCH <br>
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
		IndonesiaManifestListDownloadBC command = null;


		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0310Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0310Event")) {
				EsmBkg0310Event event = (EsmBkg0310Event) e;
				List<IndonesiaContainerVO> indonesiaContainerVOs = null;
				IndonesiaContainerVO indonesiaContainerVO = null;
				command = new IndonesiaManifestListDownloadBCImpl();
				indonesiaContainerVOs = (List<IndonesiaContainerVO>) (Object) (command.searchManifestList((ManifestListCondVO) event.getIndonesiaManifestListCondVO()));
				if (indonesiaContainerVOs.size() > 0) {
					indonesiaContainerVO = indonesiaContainerVOs.get(0);
					List<IndonesiaSearchManifestListVO> indonesiaSearchManifestListVOs = indonesiaContainerVO.getIndonesiaSearchManifestListVOs();
					if (indonesiaSearchManifestListVOs.size() <= 0) {
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					}
					eventResponse.setRsVoList(indonesiaSearchManifestListVOs);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0311Event")) {
				EsmBkg0311Event event = (EsmBkg0311Event) e;
				List<IndonesiaContainerVO> indonesiaContainerVOs = null;
				IndonesiaContainerVO indonesiaContainerVO = null;
				command = new IndonesiaManifestListDownloadBCImpl();
				indonesiaContainerVOs = (List<IndonesiaContainerVO>) (Object) (command.searchManifestList((ManifestListCondVO) event.getIndonesiaManifestListCondVO()));
				if (indonesiaContainerVOs.size() > 0) {
					indonesiaContainerVO = indonesiaContainerVOs.get(0);
					List<IndonesiaSearchManifestListVO> indonesiaSearchManifestListVOs = indonesiaContainerVO.getIndonesiaSearchManifestListVOs();
					if (indonesiaSearchManifestListVOs.size() <= 0) {
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					}
					eventResponse.setRsVoList(indonesiaSearchManifestListVOs);
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
	 * ESM_BKG_0311 : SEARCH01<BR>
	 * Receive History<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		IndonesiaManifestListDownloadBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0311Event")) {
				command = new IndonesiaManifestListDownloadBCImpl();
				List<indonesiaBkgDetailVO> list = null;
				indonesiaBkgDetailVO indonesiaBkgDetailVO = null;
				EsmBkg0311Event event = (EsmBkg0311Event) e;
				IndonesiaManifestListCondVO indonesiaManifestListCondVO = new IndonesiaManifestListCondVO();
				indonesiaManifestListCondVO.setBkgNo((event.getIndonesiaManifestListCondVO()).getBkgNo());
				list = command.searchBkgInfo(indonesiaManifestListCondVO);
				if (list.size() > 0) {
					indonesiaBkgDetailVO = list.get(0);
					eventResponse.setETCData("bl_no", indonesiaBkgDetailVO.getBlNo());
					eventResponse.setETCData("vvd", indonesiaBkgDetailVO.getVvd());
					eventResponse.setETCData("por_cd", indonesiaBkgDetailVO.getPorCd());
					eventResponse.setETCData("pol_cd", indonesiaBkgDetailVO.getPolCd());
					eventResponse.setETCData("pod_cd", indonesiaBkgDetailVO.getPodCd());
					eventResponse.setETCData("del_cd", indonesiaBkgDetailVO.getDelCd());
				} else {
					eventResponse.setETCData("bl_no", "");
					eventResponse.setETCData("vvd", "");
					eventResponse.setETCData("por_cd", "");
					eventResponse.setETCData("pol_cd", "");
					eventResponse.setETCData("pod_cd", "");
					eventResponse.setETCData("del_cd", "");
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
	 * ESM_BKG_0311 : MULTI <br>
	 * Container Manifest정보를 업데이트 한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLDocumentationBLBC blCommand = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0311Event")) { // Indonesia
				EsmBkg0311Event event = (EsmBkg0311Event) e;
				blCommand = new BLDocumentationBLBCImpl();
				blCommand.manageManifest(event.getIndonesiaManifestModificationVOS(), account);
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
	 * ESM_BKG_0310 : MULTI <br>
	 * ESM_BKG_0311 : MULTI02 <br>
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		IndonesiaCustomsTransmissionBC command = new IndonesiaCustomsTransmissionBCImpl();

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0310Event")) {
				EsmBkg0310Event event = (EsmBkg0310Event) e;
				List<IndonesiaFFVO> indonesiaFFVOs = command.transmitManifestForIndonesia(event.getManifestTransmitVO(), account);
				eventResponse.setRsVoList(indonesiaFFVOs);

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0311Event")) {
				EsmBkg0311Event event = (EsmBkg0311Event) e;
				command = new IndonesiaCustomsTransmissionBCImpl();
				List<IndonesiaFFVO> indonesiaFFVOs = command.transmitManifestForIndonesia(event.getManifestTransmitVO(), account);
				eventResponse.setRsVoList(indonesiaFFVOs);
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


}

