/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsDeclarationThailandSC.java
*@FileTitle : CustomsDeclarationThailandSC
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
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.basic.ThailandManifestLIstDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.basic.ThailandManifestLIstDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.event.EsmBkg1147Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
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
 * OPUS-CustomsDeclarationThailand Business Logic ServiceCommand<br>
 * - Process the business transactions for the OPUS-CustomsDeclarationThailand.
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class CustomsDeclarationThailandSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationThailandSC system <br>
	 * ESM_BKG_1147<br>
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
	 * CustomsDeclarationThailandSC system <br>
	 * ESM_BKG_1147 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationThailandSC 종료");
	}

	/**
	 *
	 * CustomsDeclarationThailandSC system <br>
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

		if (e.getEventName().equalsIgnoreCase("EsmBkg1147Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsVvdInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			}
		}
		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}


	/**
	 * ESM_BKG_1147 : SEARCH <br>
	 * 세관 적하 목록 상세 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchCstmsVvdInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ThailandManifestLIstDownloadBC command = null;
		try {
			EsmBkg1147Event event = (EsmBkg1147Event) e;
			command = new ThailandManifestLIstDownloadBCImpl();
			List<ThailandVvdInfoVO> list = (List<ThailandVvdInfoVO>) (Object) (command.searchCstmsVvdInfo((CstmsVvdInfoCondVO) event.getThailandVvdInfoCondVO()));
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * ESM_BKG_1147 : SEARCH01 <br>
	 *
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ThailandManifestLIstDownloadBC command = null;


		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg1147Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1147Event")) {
				EsmBkg1147Event event = (EsmBkg1147Event) e;
				command = new ThailandManifestLIstDownloadBCImpl();

				List<ManifestListDetailVO> manifestListDetailVOs = command.searchManifestList((ManifestListCondVO) event.getThailandManifestListCondVO());

				if (manifestListDetailVOs.size() > 0) {
					ThailandManifestListVO thailandManifestListVO = (ThailandManifestListVO) manifestListDetailVOs.get(0);
					eventResponse.setRsVoList(thailandManifestListVO.getThailandManifestListBlInfoVOs());
					eventResponse.setRsVoList(thailandManifestListVO.getThailandManifestListCntrInfoVOs());
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

}
