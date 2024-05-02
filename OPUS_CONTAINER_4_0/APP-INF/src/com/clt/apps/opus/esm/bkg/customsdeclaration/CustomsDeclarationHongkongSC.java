/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsDeclarationHongkongSC.java
*@FileTitle : CustomsDeclarationHongkongSC
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
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.basic.HongKongCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.basic.HongKongCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.basic.HongKongManifestLIstDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.basic.HongKongManifestLIstDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.event.EsmBkg0282Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongSearchManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongSearchVesselVO;
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
 * OPUS-CustomsDeclarationHongkong Business Logic ServiceCommand<br>
 * - Process the business transactions for the OPUS-CustomsDeclarationHongkong.
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class CustomsDeclarationHongkongSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationHongkongSC system <br>
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
	 * CustomsDeclarationHongkongSC system <br>
	 * ESM_BKG_1085 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationHongkongSC 종료");
	}

	/**
	 *
	 * CustomsDeclarationHongkongSC system <br>
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

		if (e.getEventName().equalsIgnoreCase("EsmBkg0282Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}



	/**
	 * ESM_BKG_0282 : SEARCH <br>
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
		HongKongManifestLIstDownloadBC command = new HongKongManifestLIstDownloadBCImpl();;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0282Event event = (EsmBkg0282Event) e;

		try {
			List<HongKongContainerVO> hongKongContainerVOs = (List<HongKongContainerVO>) (Object)(command.searchManifestList((ManifestListCondVO) event.getHongKongManifestListCondVO()));
			eventResponse.setETCData("eta_dt", "");
			eventResponse.setETCData("total_bl", "");
			eventResponse.setETCData("etd_dt", "");
			eventResponse.setETCData("vsl_eng_nm", "");
			eventResponse.setETCData("call_sign_no", "");
			if (hongKongContainerVOs.size() > 0) {
				HongKongContainerVO hongKongContainerVO = hongKongContainerVOs.get(0);
				List<HongKongSearchVesselVO> hongKongSearchVesselVOs = hongKongContainerVO.getHongKongSearchVesselVOs();
				HongKongSearchVesselVO hongKongSearchVesselVO = null;
				if (hongKongSearchVesselVOs.size() > 0) {
					hongKongSearchVesselVO = hongKongSearchVesselVOs.get(0);
					if (!event.getPolCd().equalsIgnoreCase(""))
						eventResponse.setETCData("etd_dt", hongKongSearchVesselVO.getEtaDt());
					else
						eventResponse.setETCData("eta_dt", hongKongSearchVesselVO.getEtaDt());
					eventResponse.setETCData("vsl_eng_nm", hongKongSearchVesselVO.getVslEngNm());
					eventResponse.setETCData("call_sign_no", hongKongSearchVesselVO.getCallSgnNo());
					// eventResponse.setUserMessage(new
					// ErrorHandler("BKG00216").getUserMessage());
				} else {
					eventResponse.setETCData("eta_dt", "");
					eventResponse.setETCData("vsl_eng_nm", "");
					eventResponse.setETCData("call_sign_no", "");
					eventResponse.setETCData("etd_dt", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				}
				List<HongKongSearchManifestListVO> hongKongSearchManifestListVOs = hongKongContainerVO.getHongKongSearchManifestListVOs();
				if (hongKongSearchManifestListVOs.size() > 0) {
					HongKongSearchManifestListVO hongKongSearchManifestListVO = null;
					hongKongSearchManifestListVO = hongKongSearchManifestListVOs.get(0);
					eventResponse.setETCData("total_bl", hongKongSearchManifestListVO.getTotalBl());
					// eventResponse.setUserMessage(new
					// ErrorHandler("BKG00216").getUserMessage());
				} else {
					eventResponse.setETCData("total_bl", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				}
				eventResponse.setRsVoList(hongKongSearchManifestListVOs);
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
	 * ESM_BKG_0282 : MULTI <br>
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HongKongCustomsTransmissionBC command = new HongKongCustomsTransmissionBCImpl();;
		EsmBkg0282Event event = (EsmBkg0282Event) e;

		try {
			begin();
			String key = command.startBackEndJob(account, event.getHongKongManifestTransmitVOs(), "ESM_BKG_0282");
			eventResponse.setETCData("KEY", key);
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
	 * ESM_BKG_0282 : SEARCH03<BR>
	 * EXS B/L Inquiry 화면에서 Prev. Doc No Append <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0282Event event = (EsmBkg0282Event) e;
		String sKey = event.getKey();
		String strResult = "";

		try {
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(
					sKey);
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();

			while (rowSet.next()) {
				if ("2".equals(rowSet.getString("JB_STS_FLG"))) {
					// BackEndJob 처리중
					strResult = "PROCESSING";
				} else if ("3".equals(rowSet.getString("JB_STS_FLG"))) {
					// 성공메시지세팅
					// Data Transmitted successufully!
					eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
					strResult = "SUCCESS";
				} else if ("4".equals(rowSet.getString("JB_STS_FLG"))) {
					// 에러메시지세팅
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
					strResult = "FAIL";
				}
			}
			eventResponse.setETCData("jb_sts_flg", strResult);

		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}
}