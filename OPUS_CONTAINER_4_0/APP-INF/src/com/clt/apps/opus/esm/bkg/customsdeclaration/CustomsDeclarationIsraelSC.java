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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.basic.IsraelCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.basic.IsraelCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.basic.IsraelManifestDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.basic.IsraelManifestDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.event.EsmBkg1168Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.event.EsmBkg1169Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelManifestListBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelSearchRcvHisVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
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
 * OPUS-CustomsDeclarationIsraelSC Business Logic ServiceCommand - OPUS-CustomsDeclarationIsraelSC handling business transaction.
 * 
 * @author 2012505 
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationIsraelSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationIsraelSC system <br>
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
	 * CustomsDeclarationIsraelSC system <br>
	 * ESM_BKG-0017 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationIsraelSC 종료");
	}

	/**
	 * 
	 * OPUS-CustomsDeclarationIsraelSC system <br>
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
		if (e.getEventName().equalsIgnoreCase("EsmBkg1169Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRcvHis(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1168Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVesselSchedule(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			}
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * ESM_BKG_1169 : SEARCH <br>
	 * 이스라엘 수신 히스토리를 조회한다. <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRcvHis(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		IsraelManifestDownloadBC command = null;
		try {
			EsmBkg1169Event event = (EsmBkg1169Event) e;
			command = new IsraelManifestDownloadBCImpl();
			List<IsraelSearchRcvHisVO> list = command.searchRcvHis(event.getIsraelRcvHisCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0219 : SEARCH <br>
	 * Inbound Domestic T/S Manifest 목록 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		IsraelManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0210Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1168Event")) {

				EsmBkg1168Event event = (EsmBkg1168Event) e;
				command = new IsraelManifestDownloadBCImpl();
				List<IsraelManifestListVO> list = null;
				list = (List<IsraelManifestListVO>) (Object) (command.searchManifestList((ManifestListCondVO) event.getManifestListCondVO()));

				Map<String, String> etcData = new HashMap<String, String>();

				if (list.size() > 0) {
					IsraelManifestListVO ovo = (IsraelManifestListVO) list.get(0);
					List<IsraelManifestListBlInfoVO> israelManifestListBlInfoVOs = ovo.getIsraelManifestListBlInfoVOs();

					if (israelManifestListBlInfoVOs.size() > 0) {
						IsraelManifestListBlInfoVO israelManifestListBlInfoVO = null;
						israelManifestListBlInfoVO = israelManifestListBlInfoVOs.get(0);

						eventResponse.setETCData("vvd_nm", israelManifestListBlInfoVO.getVslFullname());
						eventResponse.setETCData("vvd_ld", israelManifestListBlInfoVO.getVslLloydcode());
						eventResponse.setETCData("vvd_call", israelManifestListBlInfoVO.getVslCallsign());
						eventResponse.setETCData("eta", israelManifestListBlInfoVO.getEta());
						eventResponse.setETCData("etd", israelManifestListBlInfoVO.getEtd());
					} else {
						eventResponse.setETCData("vvd_nm", "");
						eventResponse.setETCData("vvd_ld", "");
						eventResponse.setETCData("vvd_call", "");
						eventResponse.setETCData("eta", "");
						eventResponse.setETCData("etd", "");
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					}
					eventResponse.setRsVoList(israelManifestListBlInfoVOs);
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
	 * ESM_BKG_0462 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(Download 데이터) 를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselSchedule(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		IsraelManifestDownloadBC command = null;
		try {
			EsmBkg1168Event event = (EsmBkg1168Event) e;
			command = new IsraelManifestDownloadBCImpl();
			String skdFlg = command.searchVesselSchedule(event.getManifestListCondVO());
			eventResponse.setETCData("skd_flg", skdFlg);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1169 : SEARCH <br>
	 * 이스라엘 수신 히스토리를 조회한다. <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if (e.getEventName().equalsIgnoreCase("EsmBkg1168Event")) {
			EsmBkg1168Event event = (EsmBkg1168Event) e;
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
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		IsraelCustomsTransmissionBC command = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1168Event")) {
				log.debug("#################EsmBkg1168Event: sendFlatFile Start");
				EsmBkg1168Event event = (EsmBkg1168Event) e;
				command = new IsraelCustomsTransmissionBCImpl();
				// BackEnd
				String key = command.startBackEndJob(account, event.getIsraelManifestTransmitVOs(), "ESM_BKG_1168");
				eventResponse.setETCData("KEY", key);
				log.debug("############################ key:" + key);
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

}// end class
