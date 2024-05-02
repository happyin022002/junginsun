/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsDeclarationNewZealandSC.java
*@FileTitle : CustomsDeclarationNewZealandSC
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

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.basic.NewZealandCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.basic.NewZealandCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.event.OpusBkgNzcusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.basic.NewZealandManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.basic.NewZealandManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.event.EsmBkg1518Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdInfoCondVO;
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
 * OPUS-CustomsDeclarationNewZealand Business Logic ServiceCommand<br>
 * - Process the business transactions for the OPUS-CustomsDeclarationNewZealand.
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class CustomsDeclarationNewZealandSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationNewZealandSC system <br>
	 * ESM_BKG-1518<br>
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
	 * CustomsDeclarationNewZealandSC system <br>
	 * ESM_BKG-1518 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationNewZealandSC 종료");
	}

	/**
	 *
	 * CustomsDeclarationNewZealandSC system <br>
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

		if (e.getEventName().equalsIgnoreCase("EsmBkg1518Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsVvdInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchErrorReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsVvdInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = createCstmsVvdRefNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("OpusBkgNzcusAckEvent")) {
			eventResponse = loadCstmsRcvMsg(e);
		}
		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * ESM_BKG_1518 : SEARCH<BR>
	 * VVD Info List<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsVvdInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		NewZealandManifestListDownloadBC command = new NewZealandManifestListDownloadBCImpl();;
		EsmBkg1518Event event = (EsmBkg1518Event) e;

		try {
			command = new NewZealandManifestListDownloadBCImpl();
			List<NewZealandCstmsVvdInfoCondVO> list = command.searchCstmsVvdInfo(event.getNewZealandCstmsVvdInfoCondVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1518 : SEARCH01 <br>
	 *  searching Manifest information(DOR data) .<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		NewZealandManifestListDownloadBC command = new NewZealandManifestListDownloadBCImpl();
		EsmBkg1518Event event = (EsmBkg1518Event) e;

		try {
			// Summary
			eventResponse.setRsVoList(command.searchManifestList(event.getNewZealandCstmsMfDtlCondVO()));
			// Detail
			eventResponse.setRsVoList(command.searchCstmsMfDtlList(event.getNewZealandCstmsMfDtlCondVO()));

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1518 : MULTI<BR>
	 *  VVD managing<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsVvdInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		NewZealandManifestListDownloadBC command = new NewZealandManifestListDownloadBCImpl();
		EsmBkg1518Event event = (EsmBkg1518Event) e;

		try {
			begin();
			command.manageCstmsVvdInfo(event.getNewZealandCstmsVvdInfoVOS(), account);
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
	 * ESM_BKG_1518 : SEARCH11<BR>
	 * creating  Reference No <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCstmsVvdRefNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		NewZealandManifestListDownloadBC command = new NewZealandManifestListDownloadBCImpl();
		EsmBkg1518Event event = (EsmBkg1518Event) e;

		try {
			command = new NewZealandManifestListDownloadBCImpl();
			eventResponse.setETCData("max_cvy_ref_no", command.createCstmsVvdRefNo(event.getNewZealandCstmsVvdRefNoCondVO()).getNewCrn());
			return eventResponse;

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1518 : MULTI03 <br>
	 * creating FlatFile for reporting manifest.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		NewZealandCustomsTransmissionBC command = new NewZealandCustomsTransmissionBCImpl();;
		EsmBkg1518Event event = (EsmBkg1518Event) e;

		try {
			begin();
			String key = command.startBackEndJob(account, event.getNewZealandManifestVO(), "ESM_BKG_1518");
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
	 * ESM_BKG_1518 : MULTI01 <br>
	 * 세관에 적하목록 신고를 EDI를 통해 전송한다.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1518Event event = (EsmBkg1518Event) e;
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
					if (e.getEventName().equalsIgnoreCase("EsmBkg1518Event")) {
						// Data Transmitted successufully!
						eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
					} else {
						// Data Saved Successfully!!
						eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
					}
					strResult = "SUCCESS";
				} else if ("4".equals(rowSet.getString("JB_STS_FLG"))) {
					// 에러메시지세팅
					if (e.getEventName().equalsIgnoreCase("EsmBkg1518Event")) {
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
					} else {
						if (!"".equals(rowSet.getString("JB_USR_ERR_MSG"))) {
							eventResponse.setUserMessage(rowSet.getString("JB_USR_ERR_MSG"));
						} else {
							eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
						}
					} strResult = "FAIL";
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
	 * OpusBkgNzcusAck <br>
	 * OpusBkgNzcusAckEvent <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadCstmsRcvMsg(Event e) throws EventException {
		log.info("SC [loadCstmsRcvMsg] Start---------------------");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		NewZealandCustomsTransmissionBC command = new NewZealandCustomsTransmissionBCImpl();

		try {
			begin();
			OpusBkgNzcusAckEvent event =(OpusBkgNzcusAckEvent) e;
			command.loadCstmsRcvMsg(event.getFlatFile());
			commit();

		} catch(EventException ex) {
			log.error("EventException : " + ex.getMessage());
			rollback();
			throw ex;
		} catch(Exception ex) {
			log.error("Exception : " + ex.getMessage());
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		log.info("SC [loadCstmsRcvMsg] End---------------------");
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1518_01] Retrive<br>
	 * Transmit Result Error Report 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchErrorReport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		NewZealandCustomsTransmissionBC command = new NewZealandCustomsTransmissionBCImpl();
		EsmBkg1518Event event =(EsmBkg1518Event) e;

		try {
			eventResponse.setRsVoList(command.searchErrorReport(event.getNewZealandCstmsMfDtl2VO() ));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

}// end class
