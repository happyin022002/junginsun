/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsDeclarationMalaysiaSC.java
*@FileTitle : CustomsDeclarationMalaysiaSC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.basic.MalaysiaCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.basic.MalaysiaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.basic.MalaysiaManifestDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.basic.MalaysiaManifestDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.event.EsmBkg1141Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.event.EsmBkg1522Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.event.EsmBkg1523Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.event.EsmBkg1524Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.event.EsmBkg1525Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.ImpStsSpclCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaImpStsVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaVvdVO;
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
 * OPUS-CustomsDeclarationMalaysiaSC Business Logic ServiceCommand -f
 * OPUS-CustomsDeclarationMalaysiaSC 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author
 * @see
 * @since J2EE 1.6
 */
public class CustomsDeclarationMalaysiaSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationMalaysiaSC system <br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch(Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CustomsDeclarationMalaysiaSC system <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationMalaysiaSC 종료");
	}

	/**
	 * CustomsDeclarationMalaysiaSC system <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmBkg1141Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = backEndJobResult(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1522Event")) {
			// Import Status I/F
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				// Sheet Combo initialization
				eventResponse = searchStowageCode4SheetCombo();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchImpSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {    // Get status of Back End Job(SEARCH01/MULTI01/COMMAND01에서 공통으로 호출)
				eventResponse = getBackEndJobStatus(e.getAttribute("backEndJob_Key").toString());
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {     // Start Back End Job(SAVE)
				eventResponse = startBackEndJobManageImpSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {     // Result return(SAVE)
				eventResponse = resultBackEndJobManageImpSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {   // Start Back End Job(TRANSMIT)
				eventResponse = startBackEndJobTransmitImpSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {   // Result return(TRANSMIT)
				eventResponse = resultBackEndJobTransmitImpSts(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1523Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchVslRegist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVVDInfo(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1524Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				// Multi Combo initialization
				eventResponse = searchStowageCode4MultiCombo();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchImpoStsSpclCgo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageImpStsSpclCgo(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1525Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVVD(e);
			}

		}
		return eventResponse;
	}


	/**
	 * Back End Job 공통<br>
	 *  - Back End Job Status 조회
	 *(동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용)
	 *
	 * @param String backEndJobKey
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getBackEndJobStatus(String backEndJobKey) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MalaysiaManifestDownloadBC command = new MalaysiaManifestDownloadBCImpl();
		try {
			String jbStsFlg = command.getBackEndJobStatus(backEndJobKey);
			eventResponse.setETCData("jb_sts_flg", jbStsFlg);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1141 : SEARCH <br>
	 *
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MalaysiaManifestDownloadBC command = new MalaysiaManifestDownloadBCImpl();
		EsmBkg1141Event event = (EsmBkg1141Event) e;
		try {
			MalaysiaManifestListVO malaysiaManifestListVO = command.searchManifestList(event.getMalaysiaManifestListCondVO());
			if (malaysiaManifestListVO != null) {
				eventResponse.setRsVoList(malaysiaManifestListVO.getMalaysiaManifestListBlInfoVOList());
				eventResponse.setRsVoList(malaysiaManifestListVO.getMalaysiaManifestListCntrInfoVOList());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1141 : MULTI <br>
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MalaysiaCustomsTransmissionBC command = new MalaysiaCustomsTransmissionBCImpl();
		EsmBkg1141Event event = (EsmBkg1141Event) e;
		try {
			begin();
			// transmit
			String key = command.startBackEndJob(account, event.getMalaysiaManifestTransmitVO(), "ESM_BKG_1141");
			eventResponse.setETCData("KEY", key);
			eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
			commit();
		} catch(EventException ex) {
			log.error("EventException : " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch(Exception ex) {
			log.error("Exception : " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1141 : SEARCH01<BR>
	 * EXS B/L Inquiry 화면에서 Prev. Doc No Append <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1141Event event = (EsmBkg1141Event) e;
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
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1522 : open <br>
	 * Stowage Combo initialization - Sheet Combo<br>
	 *
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStowageCode4SheetCombo() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<BkgComboVO> bkgComboVOList = new BookingUtil().searchCombo("CD02146");
			StringBuilder comboCode = new StringBuilder();
			StringBuilder comboText = new StringBuilder();
			for (BkgComboVO bkgComboVO : bkgComboVOList) {
				comboCode.append("|").append(bkgComboVO.getVal());
				comboText.append("|").append(bkgComboVO.getVal()).append("\t").append(bkgComboVO.getName());
			}
			eventResponse.setETCData("combo_code", comboCode.toString());
			eventResponse.setETCData("combo_text", comboText.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1522 : Retrive
	 * Import Status I/F 목록 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImpSts(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MalaysiaManifestDownloadBC command = new MalaysiaManifestDownloadBCImpl();
		EsmBkg1522Event event = (EsmBkg1522Event) e;
		String malaysiaVslNm = "";
		String malaysiaVoyDirCd = "";

		try {
			MalaysiaImpStsVO malaysiaImpStsVO = command.searchImpSts(event.getMalaysiaImpStsVO());
			if (malaysiaImpStsVO != null) {
				if (malaysiaImpStsVO.getMalaysiaVvdVO() != null) {
					if (malaysiaImpStsVO.getMalaysiaVvdVO().getPsaVslNm() != null)
						malaysiaVslNm = malaysiaImpStsVO.getMalaysiaVvdVO().getPsaVslNm();
					if (malaysiaImpStsVO.getMalaysiaVvdVO().getMalaysiaVoyDirCd() != null)
						malaysiaVoyDirCd = malaysiaImpStsVO.getMalaysiaVvdVO().getMalaysiaVoyDirCd();
				}
				eventResponse.setETCData("vsl_nm", malaysiaVslNm);
				eventResponse.setETCData("vsl_voyage", malaysiaVoyDirCd);
				eventResponse.setRsVoList(malaysiaImpStsVO.getListMalaysiaImpStsVO());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1522 : Save - Back End Job 시작<br>
	 * Malaysia Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobManageImpSts(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MalaysiaManifestDownloadBC command = new MalaysiaManifestDownloadBCImpl();
		EsmBkg1522Event event = (EsmBkg1522Event) e;

		try {
			MalaysiaImpStsVO[] malaysiaImpStsVOs = event.getMalaysiaImpStsVOs();
			String vslCd = event.getVslCd();
			String skdVoyNo = event.getSkdVoyNo();
			String skdDirCd = event.getSkdDirCd();

			for (MalaysiaImpStsVO malaysiaImpStsVO : malaysiaImpStsVOs) {
				malaysiaImpStsVO.setUserId(account.getUsr_id());
				malaysiaImpStsVO.setVslCd(vslCd);
				malaysiaImpStsVO.setSkdVoyNo(skdVoyNo);
				malaysiaImpStsVO.setSkdDirCd(skdDirCd);
			}

			begin();
			String backEndJobKey = command.startBackEndJobManageImpSts(malaysiaImpStsVOs, account, "ESM_BKG_1522-Save");
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
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
	 * ESM_BKG_1522 : Save - Back End Job 결과<br>
	 * Malaysia Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobManageImpSts(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MalaysiaManifestDownloadBC command = new MalaysiaManifestDownloadBCImpl();
		EsmBkg1522Event event = (EsmBkg1522Event) e;

		try {
			begin();
			command.resultBackEndJobManageImpSts(event.getAttribute("backEndJob_Key").toString());
			commit();
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1522 : Transmit - Back End Job 시작<br>
	 * Malaysia Import Status I/F 의 Transmit
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobTransmitImpSts(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MalaysiaCustomsTransmissionBC command = new MalaysiaCustomsTransmissionBCImpl();
		EsmBkg1522Event event = (EsmBkg1522Event) e;

		try {
			begin();
			String backEndJobKey = command.startBackEndJobTransmitImpSts(event.getMalaysiaImpStsVO(), account, "ESM_BKG_1522-Transmit");
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1522 : Transmit - Back End Job 결과<br>
	 * Malaysia Import Status I/F 의 Transmit
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobTransmitImpSts(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MalaysiaCustomsTransmissionBC command = new MalaysiaCustomsTransmissionBCImpl();
		EsmBkg1522Event event = (EsmBkg1522Event) e;

		try {
			begin();
			command.resultBackEndJobTransmitImpSts(event.getAttribute("backEndJob_Key").toString());
			commit();
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1523 :
	 * Feeder Name, Lloyd No를 조회<Br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslRegist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MalaysiaManifestDownloadBC command = new MalaysiaManifestDownloadBCImpl();
		EsmBkg1523Event event = (EsmBkg1523Event) e;

		try {
			if (event.getFormCommand().isCommand(FormCommand.SEARCH)) {
				MalaysiaVvdVO[] malaysiaVvdVOs = command.searchVslRegist(event.getMalaysiaVvdVO());
				if (malaysiaVvdVOs != null) eventResponse.setRsVoList((List<MalaysiaVvdVO>) Arrays.asList(malaysiaVvdVOs));

			} else if (event.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				String malaysiaVslNm = command.searchVslName(event.getMalaysiaVvdVO());
				if (malaysiaVslNm != null) eventResponse.setETCData("malaysia_vsl_nm", malaysiaVslNm);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1523 :
	 * Malaysia Manifest Vessel Regist 정보 수정<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVVDInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MalaysiaManifestDownloadBC command = new MalaysiaManifestDownloadBCImpl();
		EsmBkg1523Event event = (EsmBkg1523Event) e;

		try {
			begin();
			MalaysiaVvdVO[] malaysiaVvdVOs = event.getMalaysiaVvdVOs();
			for (int i=0; i<malaysiaVvdVOs.length; i++) malaysiaVvdVOs[i].setUserId(account.getUsr_id());
			command.manageVVDInfo(malaysiaVvdVOs);
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
	 * ESM_BKG_1524 : open <br>
	 * Stowage Combo initialization - MUlti Combo<br>
	 *
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStowageCode4MultiCombo() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			eventResponse.setRsVoList(new BookingUtil().searchCombo("CD02146"));
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1524 :
	 * Malaysia Port List 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImpoStsSpclCgo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MalaysiaManifestDownloadBC command = new MalaysiaManifestDownloadBCImpl();

		try {
			EsmBkg1524Event event = (EsmBkg1524Event) e;
			ImpStsSpclCgoVO impStsSpclCgoVO = command.searchImpoStsSpclCgo(event.getImpStsSpclCgoVO());
			eventResponse.setETCData(impStsSpclCgoVO.getColumnValues());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),	ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1524 :
	 * VVD가 출항전에 Container Loading List를 각 Port의 Terminal에 전송하기 위해, 전송 전 자체<br>
	 * Table에 대상 데이터를 저장한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageImpStsSpclCgo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MalaysiaManifestDownloadBC command = new MalaysiaManifestDownloadBCImpl();
		EsmBkg1524Event event = (EsmBkg1524Event) e;

		try {
			begin();
			ImpStsSpclCgoVO impStsSpclCgoVO = event.getImpStsSpclCgoVO();
			impStsSpclCgoVO.setUserId(account.getUsr_id());
			command.manageImpStsSpclCgo(impStsSpclCgoVO);
			if (impStsSpclCgoVO.getTypeCd().equals("D")) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00593").getUserMessage());
			} else {
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
	 * ESM_BKG_0420 :
	 * Malaysia Import Status EDI 전송 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MalaysiaManifestDownloadBC command = new MalaysiaManifestDownloadBCImpl();
		EsmBkg1525Event event = (EsmBkg1525Event) e;

		try {
			MalaysiaVvdVO[] malaysiaVvdVOs = command.searchVVD(event.getPortCd(), event.getEtbDt1(), event.getEtbDt2());
			eventResponse.setRsVoList((List<MalaysiaVvdVO>) Arrays.asList(malaysiaVvdVOs));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

}
