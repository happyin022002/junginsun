/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CustomsDeclarationVietnamSC.java
 *@FileTitle : CustomsDeclarationVietnamSC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=======================================================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.basic.VietnamCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.basic.VietnamCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.basic.VietnamManifestDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.basic.VietnamManifestDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.event.EsmBkg1149Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
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
 * OPUS-CustomsDeclarationVietnam Business Logic ServiceCommand -
 * OPUS-CustomsDeclarationVietnam 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationVietnamSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationVietnam system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * CustomsDeclarationVietnam system 업무 시나리오 마감작업<br>
	 * ESM_BKG-0017 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationVietnamSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-CustomsDeclarationVietnam system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmBkg1149Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// Status 콤보
				response.setRsVoList(searchComCodeCombo("CD02996"));
				eventResponse = response;
			}
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1149 : SEARCH <br>
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1149Event event = (EsmBkg1149Event) e;
		VietnamManifestDownloadBC command = new VietnamManifestDownloadBCImpl();

		try {
			List<ManifestListDetailVO> manifestListDetailVOs = command.searchManifestList((ManifestListCondVO) event.getVietnamManifestListCondVO());
			if (manifestListDetailVOs.size() > 0) {
				VietnamManifestListVO vietnamManifestListVO = (VietnamManifestListVO) manifestListDetailVOs.get(0);
				eventResponse.setRsVoList(vietnamManifestListVO.getVietnamManifestListBlInfoVOs());
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
	 * ESM_BKG_1149 : MULTI <br>
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1149Event event = (EsmBkg1149Event) e;
		VietnamCustomsTransmissionBC command = new VietnamCustomsTransmissionBCImpl();

		try {
			begin();
			// Vietnam Flat File 생성)
			String key = command.startBackEndJob(account, event.getVietnamManifestTransmitVO(), "ESM_BKG_1149");
			eventResponse.setETCData("KEY", key);
			eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
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
	 * ESM_BKG_1149 : SEARCH01<BR>
	 * EXS B/L Inquiry 화면에서 Prev. Doc No Append <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1149Event event = (EsmBkg1149Event) e;
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
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1149 : INIT <br>
	 * com_intg_cd_dtl Table 조회<br>
	 *
	 * @param String
	 *            comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private List<BkgComboVO> searchComCodeCombo(String comCode) throws EventException {
		BookingUtil bkgUtil = new BookingUtil();
		List<BkgComboVO> list = bkgUtil.searchCombo(comCode);
		try {
			for (int j = 0; j < list.size(); j++) {
				// 콤보 Text에 value + Name으로 보여주는 경우 사용
				list.get(j).setDesc(list.get(j).getVal() + " " + list.get(j).getName());
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return list;
	}


}