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
 *-------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.basic.RussiaManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.basic.RussiaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.event.EsmBkg1163Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.event.EsmBkg1164Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.FdrBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.RussiaManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclarationRussiaSC Business Logic ServiceCommand - OPUS-CustomsDeclarationRussiaSC handling business transaction.
 * 
 * @author 2012505
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationRussiaSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationRussiaSC system <br>
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
	 * CustomsDeclarationRussiaSC system <br>
	 * ESM_BKG-0017 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationRussiaSC 종료");
	}

	/**
	 * 
	 * OPUS-CustomsDeclarationRussiaSC system <br>
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
		if (e.getEventName().equalsIgnoreCase("EsmBkg1163Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageRussiaCntrInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1164Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgListForFdrBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCustInfoBkgCstmsRuCust(e);
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
		RussiaManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0210Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1163Event")) {

				EsmBkg1163Event event = (EsmBkg1163Event) e;
				command = new RussiaManifestListDownloadBCImpl();

				List<ManifestListDetailVO> list = command.searchManifestList((ManifestListCondVO) event.getRussiaManifestListCondVO());

				if (list.size() > 0) {
					RussiaManifestListDetailVO russiaManifestListDetailVO = (RussiaManifestListDetailVO) list.get(0);

					eventResponse.setETCData("hd_vvd_cd", russiaManifestListDetailVO.getHdVvdCd());
					eventResponse.setETCData("hd_pol_pod", russiaManifestListDetailVO.getHdPolPod());
					eventResponse.setETCData("hd_pol_pod_cd", russiaManifestListDetailVO.getHdPolPodCd());
					eventResponse.setETCData("hd_eta_etd", russiaManifestListDetailVO.getHdEtaEtd());
					eventResponse.setETCData("hd_eta_etd_cd", russiaManifestListDetailVO.getHdEtaEtdCd());
					eventResponse.setETCData("hd_mode_type", russiaManifestListDetailVO.getHdModeType());
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
	@SuppressWarnings({ "unchecked" })
	private EventResponse manageRussiaCntrInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RussiaManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1163Event event = (EsmBkg1163Event) e;
			command = new RussiaManifestListDownloadBCImpl();

			command.manageRussiaCntrInfo(event.getModifyCntrInfoVOs(), account);
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
	 * ESM_BKG_1171 : SEARCH <br>
	 * 세관에 신고할 대상 VesselArrival 정보 데이터를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchBkgListForFdrBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1164Event event = (EsmBkg1164Event) e;
		RussiaManifestListDownloadBC command = null;

		try {

			command = new RussiaManifestListDownloadBCImpl();
			List<FdrBlVO> list = command.searchBkgListForFdrBl(event.getFdrBlInVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1164: save<br>
	 * customer 정보를 변경한다.
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCustInfoBkgCstmsRuCust(Event e) throws EventException {
		RussiaManifestListDownloadBC command = null;
		try {
			begin();

			EsmBkg1164Event event = (EsmBkg1164Event) e;
			command = new RussiaManifestListDownloadBCImpl();
			command.manageCustInfoBkgCstmsRuCust(event.getFdrBlVOS(), account);

			commit();

			// 저장후 결과처리
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage()); // BKG00166 : 저장성공
			return eventResponse;

		} catch (EventException ex) {
			rollback();
			log.error("err" + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

}// end class
