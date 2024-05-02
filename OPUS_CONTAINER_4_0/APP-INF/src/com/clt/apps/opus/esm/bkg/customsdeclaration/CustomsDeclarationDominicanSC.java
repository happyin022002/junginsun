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

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.basic.DominicanManifestDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.basic.DominicanManifestDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.event.EsmBkg1162Event;
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
 * OPUS-CustomsDeclarationDominicanSC Business Logic ServiceCommand - OPUS-CustomsDeclarationDominicanSC handling business transaction.
 * 
 * @author KIM SEUNG MIN 
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationDominicanSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationDominicanSC system <br>
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
	 * CustomsDeclarationDominicanSC system <br>
	 * ESM_BKG-0017 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationDominicanSC 종료");
	}

	/**
	 * 
	 * OPUS-CustomsDeclarationDominicanSC system <br>
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
		
		 	if (e.getEventName().equalsIgnoreCase("EsmBkg1162Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchManifestList(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = backEndJobResult(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = downloadManifestList(e); // xml로 다운로드
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
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DominicanManifestDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0210Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1162Event")) {

				EsmBkg1162Event event = (EsmBkg1162Event) e;
				command = new DominicanManifestDownloadBCImpl();

				String key = command.startBackEndJob(account.getUsr_id(),
						event.getManifestListCondVO(), "ESM_BKG_1162");
				eventResponse.setETCData("KEY", key);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
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
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if (e.getEventName().equalsIgnoreCase("EsmBkg1162Event")) {
			EsmBkg1162Event event = (EsmBkg1162Event) e;
			sKey = event.getKey();
		}
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
					 if (e.getEventName().equalsIgnoreCase(
							"EsmBkg1162Event")) {
						List<ManifestListDetailVO> manifestListDetailVOs = (List<ManifestListDetailVO>) BackEndJobResult
								.loadFromFile(sKey);
						eventResponse.setRsVoList(manifestListDetailVOs);
					} else {
						// Data Saved Successfully!!
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00166").getUserMessage());
					}
					strResult = "SUCCESS";
				} else if ("4".equals(rowSet.getString("JB_STS_FLG"))) {
					// 에러메시지세팅
					 if (e.getEventName().equalsIgnoreCase(
							"EsmBkg1162Event")) {
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG06086").getUserMessage());
					} else {
						if (!"".equals(rowSet.getString("JB_USR_ERR_MSG"))) {
							eventResponse.setUserMessage(rowSet
									.getString("JB_USR_ERR_MSG"));
						} else {
							eventResponse.setUserMessage(new ErrorHandler(
									"BKG00167").getUserMessage());
						}
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
	private EventResponse downloadManifestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1162Event")) {
				EsmBkg1162Event event = (EsmBkg1162Event) e;
				DominicanManifestDownloadBC command = new DominicanManifestDownloadBCImpl();
				String downXml = command.downloadManifestList(event
						.getManifestListCondVO());
				eventResponse.setETCData("down_xml", downXml);
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

 
 
}// end class
