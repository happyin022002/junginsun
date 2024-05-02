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

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.basic.MexCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.basic.MexCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.event.EsmBkg0370Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxManifestListByVvdDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CargoManifestListResultForEdiVO;
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
 * OPUS-CustomsDeclarationMexicoSC Business Logic ServiceCommand - OPUS-CustomsDeclarationMexicoSC handling business transaction.
 * 
 * @author 2012505
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationMexicoSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationMexicoSC system <br>
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
	 * CustomsDeclarationMexicoSC system <br>
	 * ESM_BKG-0017 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationMexicoSC 종료");
	}

	/**
	 * 
	 * OPUS-CustomsDeclarationMexicoSC system <br>
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

		if (e.getEventName().equalsIgnoreCase("EsmBkg0370Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchManifestPodList(e);
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
		MexCustomsTransmissionBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0210Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0370Event")) {
				EsmBkg0370Event event = (EsmBkg0370Event) e;
				command = new MexCustomsTransmissionBCImpl();
				// BC에 작업 요청
				CargoManifestListResultForEdiVO vo = command.searchCargoManifestForEdi(event.getCondVO());
				// 결과 처리
				if (vo == null) {
					// 결과값이 없을 경우 오류 리턴
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				} else {
					eventResponse.setRsVoList(vo.getMxManifestListByVvdDetailVOs());
					if (vo.getMxVslResultVO() != null) {
						eventResponse.setETCData("vsl_eng_nm", vo.getMxVslResultVO().getVslEngNm());
						eventResponse.setETCData("call_sign", vo.getMxVslResultVO().getCallSgnNo());
						eventResponse.setETCData("eta", vo.getMxVslResultVO().getEtaDt());
						eventResponse.setETCData("etd", vo.getMxVslResultVO().getEtdDt());
					}
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
		MexCustomsTransmissionBC command = null;
		// ManifestListDownloadBC maniCommand = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		String flatFile = "";
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0370Event")) { // 멕시코
																		// EDI
																		// FLAT
																		// FILE
																		// 생성
																		// 및
																		// 전송
				EsmBkg0370Event event = (EsmBkg0370Event) e;
				command = new MexCustomsTransmissionBCImpl();
				// event로 부터 객체 받기.
				MxManifestListByVvdDetailVO[] vos = event.getDetailVOs();
				// account정보 설정.
				for (int k = 0; k < vos.length; k++) {
					vos[k].setUsrId(account.getUsr_id());
					vos[k].setOfcCd(account.getOfc_cd());
				}
				// BackEnd
				String key = command.startBackEndJob(account, vos, "ESM_BKG_0370");
				eventResponse.setETCData("KEY", key);
				// BC 호출.
				// flatFile = command.transmitManifest(vos);
				// 결과값 셋팅.
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
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
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if (e.getEventName().equalsIgnoreCase("EsmBkg0370Event")) {
			EsmBkg0370Event event = (EsmBkg0370Event) e;
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
	private EventResponse searchManifestPodList(Event e) throws EventException {
		try {
			EsmBkg0370Event event = (EsmBkg0370Event) e;
			// TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			// List<BkgComboVO> list =
			// command.searchManifestPodList(event.getTsVvdFor1st2ndInputVO());

			MexCustomsTransmissionBC command2 = new MexCustomsTransmissionBCImpl();
			// BC에 작업 요청
			List<BkgComboVO> list = command2.searchManifestPodList(event.getCondVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

}// end class
