/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsDeclarationTaiwanSC.java
*@FileTitle : CustomsDeclarationTaiwanSC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.basic.TaiwanCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.basic.TaiwanCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.taiwan.event.EsmBkg0497Event;
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
 * OPUS-CustomsDeclarationTaiwan Business Logic ServiceCommand<br>
 * - Process the business transactions for the OPUS-CustomsDeclarationTaiwan.
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class CustomsDeclarationTaiwanSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationTaiwanSC system <br>
	 * ESM_BKG_0497<br>
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
	 * CustomsDeclarationTaiwanSC system <br>
	 * ESM_BKG_0497 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationTaiwanSC 종료");
	}

	/**
	 *
	 * CustomsDeclarationTaiwanSC system <br>
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

		if (e.getEventName().equalsIgnoreCase("EsmBkg0497Event")) {
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
	 *
	 * ESM_BKG_0497 : MULTI <br>
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TaiwanCustomsTransmissionBC command = new TaiwanCustomsTransmissionBCImpl();
		EsmBkg0497Event event = (EsmBkg0497Event) e;

		try {
			begin();
			// 이벤트별 Impl생성
			String key = "";
			key = command.searchBLGeneralBasic(event.getTaiwanManifestTransmitVOs());
			if (!"EMPTY".equals(key)) { // 전송대상이 있을 경우만 flatfile을 만든다.
				key = command.startBackEndJob(account, event.getTaiwanManifestTransmitVOs(), "ESM_BKG_0497");
			}
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
	 * ESM_BKG_0497 : SEARCH03<BR>
	 * EXS B/L Inquiry 화면에서 Prev. Doc No Append <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0497Event event = (EsmBkg0497Event) e;
		String sKey = event.getKey();
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

