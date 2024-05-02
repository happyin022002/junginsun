/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsDeclarationPhilippineSC.java
*@FileTitle : CustomsDeclarationPhilippineSC
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

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.basic.ManilaManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.basic.ManilaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.event.EsmBkg0234Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckPodVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckPolVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgDescTempVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgMarkTempVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchVvdDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclarationPhilippine Business Logic ServiceCommand<br>
 * - Process the business transactions for the OPUS-CustomsDeclarationPhilippine.
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class CustomsDeclarationPhilippineSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationPhilippineSC system <br>
	 * ESM_BKG_0234<br>
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
	 * CustomsDeclarationPhilippineSC system <br>
	 * ESM_BKG_0234 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationPhilippineSC 종료");
	}

	/**
	 *
	 * CustomsDeclarationPhilippineSC system <br>
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

		if (e.getEventName().equalsIgnoreCase("EsmBkg0234Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = downloadManifest(e);
			}
		}
		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}



	/**
	 * ESM_BKG_0234 : SEARCH <br>
	 *
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManilaManifestListDownloadBC command = null;


		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0234Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0234Event")) {
				EsmBkg0234Event event = (EsmBkg0234Event) e;
				List<ManilaContainerVO> manilaContainerVOs = null;
				ManilaContainerVO manilaContainerVO = null;
				command = new ManilaManifestListDownloadBCImpl();
				manilaContainerVOs = (List<ManilaContainerVO>) (Object) (command.searchManifestList((ManifestListCondVO) event.getManilaManifestListCondVO()));
				Map<String, String> etcData = new HashMap<String, String>();
				if (manilaContainerVOs.size() > 0) {
					manilaContainerVO = manilaContainerVOs.get(0);
					List<ManilaSearchCheckPodVO> manilaSearchCheckPodVOs = manilaContainerVO.getManilaSearchCheckPodVOs();
					List<ManilaSearchCheckPolVO> manilaSearchCheckPolVOs = manilaContainerVO.getManilaSearchCheckPolVOs();
					List<ManilaSearchCheckVvdVO> manilaSearchCheckVvdVOs = manilaContainerVO.getManilaSearchCheckVvdVOs();
					if (manilaSearchCheckVvdVOs.size() == 0) {
						eventResponse.setUserMessage(new ErrorHandler("BKG00163").getUserMessage());
						return eventResponse;
					} else {
						if (manilaSearchCheckPodVOs != null
								&& manilaSearchCheckPodVOs.size() == 0) {
							eventResponse.setUserMessage(new ErrorHandler("BKG00165").getUserMessage());
							return eventResponse;
						}
						if (manilaSearchCheckPolVOs != null
								&& manilaSearchCheckPolVOs.size() == 0) {
							eventResponse.setUserMessage(new ErrorHandler("BKG00164").getUserMessage());
							return eventResponse;
						}
					}
					if (manilaContainerVO.getManilasearchVvdDtlVOs() != null) {
						List<ManilaSearchVvdDtlVO> manilasearchVvdDtlVOs = manilaContainerVO.getManilasearchVvdDtlVOs();
						eventResponse.setRsVoList(manilasearchVvdDtlVOs);
					}
					if (manilaContainerVO.getManilaSearchBlInfoVOs() != null) {
						List<ManilaSearchBlInfoVO> manilaSearchBlInfoVOs = manilaContainerVO.getManilaSearchBlInfoVOs();
						eventResponse.setRsVoList(manilaSearchBlInfoVOs);
					}
					if (manilaContainerVO.getManilaSearchCntrInfoVOs() != null) {
						List<ManilaSearchCntrInfoVO> manilaSearchCntrInfoVOs = manilaContainerVO.getManilaSearchCntrInfoVOs();
						eventResponse.setRsVoList(manilaSearchCntrInfoVOs);
					}
					if (manilaContainerVO.getManilaSearchPkgDescTempVOs() != null) {
						List<ManilaSearchPkgDescTempVO> manilaSearchPkgDescTempVOs = manilaContainerVO.getManilaSearchPkgDescTempVOs();
						eventResponse.setRsVoList(manilaSearchPkgDescTempVOs);
					}
					if (manilaContainerVO.getManilaSearchPkgMarkTempVOs() != null) {
						List<ManilaSearchPkgMarkTempVO> manilaSearchPkgMarkTempVOs = manilaContainerVO.getManilaSearchPkgMarkTempVOs();
						eventResponse.setRsVoList(manilaSearchPkgMarkTempVOs);
					}
				} else {
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
	 * ESM_BKG_0234 : MULTI01 <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(Download 데이터) 를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse downloadManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManilaManifestListDownloadBC command = null;
		try {
			EsmBkg0234Event event = (EsmBkg0234Event) e;
			command = new ManilaManifestListDownloadBCImpl();
			String filename = command.downloadManifest(event.getManifestListDetailVO());
			eventResponse.setCustomData("filekey", filename);
			eventResponse.setETCData("filename", filename);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

}
