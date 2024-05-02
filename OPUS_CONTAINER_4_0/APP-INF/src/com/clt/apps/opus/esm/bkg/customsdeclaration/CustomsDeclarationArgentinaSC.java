/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsDeclarationArgentinaSC.java
*@FileTitle : ESM_BKG_1190
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.29
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2014.12.29 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.basic.ArgCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.basic.ArgCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.event.EsmBkg1191Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo.BkgCstmsArgSndLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.basic.ArgManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.basic.ArgManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.event.EsmBkg1190Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.vo.ArgManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.vo.ArgManifestListDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclarationArgentinaSC Business Logic ServiceCommand - OPUS-CustomsDeclarationArgentinaSC handling business transaction.
 * 
 * @author KIM MINJUNG
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationArgentinaSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationArgentinaSC system <br>
	 * ESM_BKG_1190<br>
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
	 * CustomsDeclarationArgentinaSC system <br>
	 * ESM_BKG-0017 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationArgentinaSC 종료");
	}

	/**
	 * 
	 * OPUS-CustomsDeclarationArgentinaSC system <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		log.info("[SC.perform] Start ---------------------------");
		log.info("[SC.perform] e.getEventName() : " + e.getEventName());

		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsmBkg1190Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// Retrieve
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				// Data Download
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				// Transmit
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				// Save
				eventResponse = saveManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				// Data Delete
				eventResponse = deleteManifest(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1191Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// Retrieve
				eventResponse = searchCstmsArgSndLog(e);
			}
		}
		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 *  searching Manifest <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {

		ArgManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1190Event")) {
				EsmBkg1190Event event = (EsmBkg1190Event) e;
				command = new ArgManifestListDownloadBCImpl();
				ArgManifestListCondVO condVO = event.getArgManifestListCondVO();
				List<ArgManifestListDetailVO> manifestListDetailVO = command.searchManifestList(condVO, account);
				eventResponse.setRsVoList(manifestListDetailVO);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 *  deleting Manifest <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteManifest(Event e) throws EventException {

		ArgManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg1190Event")) {
				EsmBkg1190Event event = (EsmBkg1190Event) e;
				command = new ArgManifestListDownloadBCImpl();
				command.deleteManifest(event.getArgManifestListDetailVOs());
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
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
	 * Data Download
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ArgManifestListDownloadBC command = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1190Event")) {
				EsmBkg1190Event event = (EsmBkg1190Event) e;
				command = new ArgManifestListDownloadBCImpl();
				command.manageManifest(event.getArgManifestListDetailVOs(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			}
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
	 * 세관신고 EDI Transmit
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ArgCustomsTransmissionBC command = null;
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg1190Event")) {
				EsmBkg1190Event event = (EsmBkg1190Event) e;
				command = new ArgCustomsTransmissionBCImpl();
				String sFlatFile = command.transmitManifest(event.getArgManifestTransmitVOs(), account);

				/***********************************************************
				 * EDI transmit
				 ***********************************************************/
				if (sFlatFile != null) {
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(sFlatFile);
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMS.IBMMQ.QUEUE"));
					BookingUtil utilCommand = new BookingUtil();
					FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E"))
						throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
				}
				// 성공메시지 세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
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
	 * Data Save
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse saveManifest(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ArgManifestListDownloadBC command = null;
		
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1190Event")) {
				EsmBkg1190Event event = (EsmBkg1190Event) e;
				command = new ArgManifestListDownloadBCImpl();
				command.saveManifest(event.getArgManifestListDetailVOs(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			}
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
	 *  searchCstmsArgSndLog <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsArgSndLog(Event e) throws EventException {

		ArgCustomsTransmissionBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1191Event")) {
				EsmBkg1191Event event = (EsmBkg1191Event) e;
				command = new ArgCustomsTransmissionBCImpl();
				BkgCstmsArgSndLogVO condVO = event.getBkgCstmsArgSndLogVO();
				List<BkgCstmsArgSndLogVO> bkgCstmsArgSndLogVOs = command.searchCstmsArgSndLog(condVO);
				eventResponse.setRsVoList(bkgCstmsArgSndLogVOs);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
}// end class