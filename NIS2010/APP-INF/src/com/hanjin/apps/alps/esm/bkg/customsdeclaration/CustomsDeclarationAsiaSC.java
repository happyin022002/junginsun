/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : CustomsDeclarationAsiaSC.java
 *@FileTitle : CustomsDeclarationAsiaSC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.18
 *@LastModifier : 김상수
 *@LastVersion : 1.0
 * 2013.10.18 김상수
 * 1.0 Creation
 *-------------------------------------------------------
 * History
 *
=======================================================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.basic.Kor24CustomsTransmissionBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.basic.Kor24CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.event.EsmBkg1344Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24AmendManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24DischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24EmpAmdManiTransVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBackEndBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.basic.ChinaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.event.EsmBkg1508Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.basic.Jp24ManifestListDownloadBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.basic.Jp24ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.BatchForEdtAdtTransmitEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1501Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1502Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1503Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1504Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1505Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1506Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.UdevhjsAlpsbkgTJpn24Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpMarkDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.DepartureTimeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.GetMdmCustomerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.basic.Kor24ManifestListDownloadBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.basic.Kor24ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.basic.Kor24ManifestListDownloadBackEndBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.event.EsmBkg1329Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.BkgCstmsKrVvdSmryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BkgCntrQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CorrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24DlContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24EmpAmdManiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManiSumCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestCrsChkInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestSmryCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24VslInfoNManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24VslInfoNManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-CustomsDeclaration Business Logic ServiceCommand<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Sang-Soo
 * @see
 * @since J2EE 1.6
 */
public class CustomsDeclarationAsiaSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclaration system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("CustomsDeclarationSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CustomsDeclaration system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-CustomsDeclaration system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmBkg1329Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode1329(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = downloadCstmsBlList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = manageMsnNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = manageCrossCheck(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1344Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyManifestSummaryInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = manageManifestSummaryInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = backEndJobResult(e.getAttribute("key").toString());
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1501Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {             // Search Sheet1 Header List (RETRIEVE)
				eventResponse = searchCargoInfoHeader(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {    // Start Back End Job (RETRIEVE)
				eventResponse = startBackEndJobSearchCargoInfoDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {    // Get status of Back End Job (SEARCH01/MULTI01/COMMAND01에서 공통으로 호출)
				eventResponse = getBackEndJobStatus(e.getAttribute("backEndJob_Key").toString());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {    // Result return (RETRIEVE)
				eventResponse = resultBackEndJobSearchCargoInfoDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {     // Start Back End Job (SAVE)
				eventResponse = startBackEndJobManageCargoInfoDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {     // Result return (SAVE)
				eventResponse = resultBackEndJobManageCargoInfoDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {   // Start Back End Job (TRANSMIT)
				eventResponse = startBackEndJobTransmitCargoInfoDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {   // Start Back End Job (NEW_TRANSMIT)
				eventResponse = startBackEndJobTransmitCargoInfoDetailRenewal2017(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {   // Result return (TRANSMIT)
				eventResponse = resultBackEndJobTransmitCargoInfoDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REPLY)) {
				eventResponse = manageSendEmailCargoInfoDetail(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1502Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBLInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getMdmCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageBLInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {    // Start Back End Job (TRANSMIT)
				eventResponse = startBackEndJobTransmitBLInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {    // Get status of Back End Job (TRANSMIT)
				eventResponse = getBackEndJobStatus(e.getAttribute("backEndJob_Key").toString());
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {    // Result return (TRANSMIT)
				eventResponse = resultBackEndJobTransmitBLInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {    // Start Back End Job (New_TRANSMIT)
				eventResponse = startBackEndJobTransmitBLInquiryRenewal2017(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1503Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDepartureTime(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = transmitDepartureTimeByUI(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("BatchForEdtAdtTransmitEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.TRANS)) {
				eventResponse = transmitDepartureTimeByBatch(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1504Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchJmsReport(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("UdevhjsAlpsbkgTJpn24Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = receiveEDIForJapan24HR(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1505Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchErrorReport(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1506Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSendFlatFile(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1508Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChinaVslRgst(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageChinaVslRgst(e);
			}
		}
 		return eventResponse;
	}

	/**
	 * Back End Job 공통<br>
	 *  - Back End Job Status 조회
	 *  (동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용)
	 *
	 * @param String key
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(String key) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String strResult = "";

		try {
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(key);
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();

			while (rowSet.next()) {
				if ("2".equals(rowSet.getString("JB_STS_FLG"))) {
					// BackEndJob 처리중
					strResult = "PROCESSING";
				} else if ("3".equals(rowSet.getString("JB_STS_FLG"))) {
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
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1329 조회화면의 COMBO 값 조회(공통 CODE 조회)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode1329(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			BookingUtil comboUtil = new BookingUtil();

			// Upload Status - bkg_upld_sts_cd
			List<BkgComboVO> sc = comboUtil.searchCombo("CD02254");

			List<BkgComboVO> list_sc = new ArrayList<BkgComboVO>();

			BkgComboVO comboVo = new BkgComboVO();
			comboVo.setVal("A");
			comboVo.setName("All");
			comboVo.setDesc("All");
			list_sc.add(comboVo);
			for (int i=0;i<sc.size();i++) {
				list_sc.add(sc.get(i));
			}

			eventResponse.setRsVoList(list_sc);

		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1329 : SEARCH <br>
	 * 화물에 대한 Manifest List를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		Kor24ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1329Event event =(EsmBkg1329Event) e;
			command = new Kor24ManifestListDownloadBCImpl();


			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				Map<String, String> etcData = new HashMap<String, String>();
				Kor24MrnNoVO fromClient = event.getKor24MrnNoVO();
				Kor24ContainerVO container = null;
				container =(Kor24ContainerVO) command.searchManifestInfo((ManifestListCondVO) fromClient);
				if (container != null)
				 {
					eventResponse.setRsVoList(container.getKor24ManifestInfoVOs());
					eventResponse.setRsVoList(container.getKor24BkgCntrQtyInfoVOs());
					eventResponse.setETCData("mrn_nbr", 	fromClient.getMrnNo()		);
					log.debug("*&&&&&&&&&&&&&&&&&&&&&&&"+fromClient.getMrnNo());
					eventResponse.setETCData("mrn_chk_no", 	fromClient.getMrnChkNo()	);
					eventResponse.setETCData("in_bound", 	fromClient.getInBound()		);
					eventResponse.setETCData("in_pol", 		fromClient.getInPol()		);
					eventResponse.setETCData("in_vvd", 		fromClient.getInVvd()		);
					eventResponse.setETCData("in_pod", 		fromClient.getInPod()		);
					eventResponse.setETCData("in_hn", 		fromClient.getInHn()		);
					eventResponse.setETCData("sel_type", 	fromClient.getSelType()		);
					eventResponse.setETCData("bl_dl", 		fromClient.getBlDl()		);
					eventResponse.setETCData("all_err", 	fromClient.getAllErr()		);
					eventResponse.setETCData("in_blno", 	fromClient.getBlNo()		);
					eventResponse.setETCData("bl_type", 	fromClient.getBlType()		);
					eventResponse.setETCData("el_type", 	fromClient.getElType()		);
					eventResponse.setETCData("correction", 	fromClient.getCorrection()	);
					eventResponse.setETCData("cntr_local", 	fromClient.getCntrLocal()	);
					eventResponse.setETCData("cntr_ts", 	fromClient.getCntrTs()		);
					eventResponse.setETCData("cntr_empty", 	fromClient.getCntrEmpty()	);
					eventResponse.setETCData("cntr_total", 	fromClient.getCntrTotal()	);
					eventResponse.setETCData("bl_local", 	fromClient.getBlLocal()		);
					eventResponse.setETCData("bl_ts", 		fromClient.getBlTs()		);
					eventResponse.setETCData("bl_empty", 	fromClient.getBlEmpty()		);
					eventResponse.setETCData("bl_total", 	fromClient.getBlTotal()		);
					eventResponse.setETCData("eta_etd", 	fromClient.getEtaEtd()		);
					eventResponse.setETCData("etb_dt", 		fromClient.getEtbDt()		);

				} else {
					eventResponse.setETCData("mrn_nbr", 	" ");
					eventResponse.setETCData("mrn_chk_no", 	" ");
					eventResponse.setUserMessage(new ErrorHandler("BKG00689").getUserMessage());
				}
				eventResponse.setETCData(etcData);
			}

			if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				List<Kor24ManifestCrsChkInfoVO> container = command.searchManifestCrsChkInfoKorList(event.getKor24MrnNoVO());
				eventResponse.setRsVoList(container);

				Kor24MrnNoVO fromClient = command.searchManifestCrsChkInfoSumKorList(event.getKor24MrnNoVO());

				if (fromClient != null)
				 {
//						eventResponse.setETCData("cntr_local", 	fromClient.getCntrLocal()	);
//						eventResponse.setETCData("cntr_ts", 	fromClient.getCntrTs()		);
//						eventResponse.setETCData("cntr_ts_empty", 	fromClient.getCntrTsEmpty()		);
//						eventResponse.setETCData("cntr_empty", 	fromClient.getCntrEmpty()	);
//						eventResponse.setETCData("cntr_total", 	fromClient.getCntrTotal()	);
//						eventResponse.setETCData("bl_local", 	fromClient.getBlLocal()		);
//						eventResponse.setETCData("bl_ts", 		fromClient.getBlTs()		);
//						eventResponse.setETCData("bl_ts_empty", 		fromClient.getBlTsEmpty()		);
//						eventResponse.setETCData("bl_empty", 	fromClient.getBlEmpty()		);
//						eventResponse.setETCData("bl_total", 	fromClient.getBlTotal()		);

					eventResponse.setETCData("mrn_nbr", 	fromClient.getMrnNo()		);
					eventResponse.setETCData("mrn_chk_no", 	fromClient.getMrnChkNo()	);

					eventResponse.setETCData("eta_etd", 	fromClient.getEtaEtd()		);
					eventResponse.setETCData("etb_dt", 		fromClient.getEtbDt()		);

				}
			}

		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1329 : REMOVE <br>
	 * 세관에 적하목록을 신고하기 위해 필요한 아이템을 저장하는 오퍼레이션<br>
	 * @param Event event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Kor24ManifestListDownloadBC command = new Kor24ManifestListDownloadBCImpl();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1329Event")) {
				EsmBkg1329Event event =(EsmBkg1329Event) e;
				Kor24DlContainerVO cont = new Kor24DlContainerVO();
				Kor24MrnNoVO fromClient = event.getKor24MrnNoVO();
				Kor24ManifestInfoVO[] list = event.getKor24ManifestInfoVOs();
				Kor24BkgCntrQtyInfoVO[] cntrList = event.getKor24BkgCntrQtyInfoVOs();
				cont.setKor24MrnNoVO(fromClient);
				cont.setKor24ManifestInfoVOs(list);
				cont.setKor24BkgCntrQtyInfoVOs(cntrList);
				cont.setUser_id(account.getUsr_id());
				cont.setOffice(account.getOfc_cd());
				int delCount = command.manageManifest(cont);
				eventResponse.setETCData("delcount", Integer.toString(delCount));

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1344Event")) {
				EsmBkg1344Event event =(EsmBkg1344Event) e;
				if (event.getFormCommand().isCommand(FormCommand.MULTI06)) {
					// 한국세관 1344 Transmit Empty Amend 처리
					Kor24EmpAmdManiVO[] kor24EmpAmdManiVOs = event.getKor24EmpAmdManiVOs();
					Kor24AmendManifestTransmitVO kor24AmendManifestTransmitVO= event.getKor24AmendManifestTransmitVO();

					if (kor24EmpAmdManiVOs!=null) {
						// USR_ID 와 RECEIVER 설정
						for (int i=0; i < kor24EmpAmdManiVOs.length; i++) {
							kor24EmpAmdManiVOs[i].setUsrId(account.getUsr_id());
							kor24EmpAmdManiVOs[i].setOfcCd(account.getOfc_cd());
							kor24EmpAmdManiVOs[i].setReceiver(kor24AmendManifestTransmitVO.getReceiver());
						}
						kor24EmpAmdManiVOs = (Kor24EmpAmdManiVO[]) command.manageEmpAmdManifest(kor24EmpAmdManiVOs);

						// Transmit
						this.transmitEmpAmdManifest(kor24EmpAmdManiVOs);

						// 전송일시 UPDATE
						command.transmitEmpAmdManifest(kor24EmpAmdManiVOs);

						// 성공메시지세팅
						eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
					} else {
						// 조회결과 없을 경우
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					}

				} else {
					// 한국세관 1344 Transmit 조회
					Kor24VslInfoNManifestCondVO condVO = event.getKor24VslInfoNManifestCondVO();
					condVO.setUserId(account.getUsr_id());

					Kor24VslInfoNManifestVO kor24VslInfoNManifestVO =(Kor24VslInfoNManifestVO) command.manageVslInfoNManifestList(condVO);
					BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = kor24VslInfoNManifestVO.getBkgCstmsKrVvdSmryVO();
					if (bkgCstmsKrVvdSmryVO != null) {
						eventResponse.setETCData(bkgCstmsKrVvdSmryVO.getColumnValues());
					} else {
						// 조회결과 없을 경우
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					}
				}
			}
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Kor24CustomsTransmissionBC command = null;
		Kor24ManifestListDownloadBC maniCommand = null;

		try {
			begin();
			EsmBkg1344Event event =(EsmBkg1344Event) e;
			command = new Kor24CustomsTransmissionBCImpl();
			maniCommand = new Kor24ManifestListDownloadBCImpl();

			if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				// Trans Discharge 하선신고
				Kor24DischManifestTransmitVO condVO = event.getKor24DischManifestTransmitVO();
				condVO.setUserId(account.getUsr_id());
				condVO.setOfcCd(account.getOfc_cd());
				command.transmitDischManifest(condVO);
				// 신고후 전송시간 UPDATE
				// E Type인 경우는 전송이력을 남기지 않는다.
				if (!condVO.getNoneBlInType().equals("E")) {
					maniCommand.transmitDischManifest(condVO);
				}

			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				// Trans Manifest, Trans per B/L
				Kor24ManifestTransmitVO condVO = event.getKor24ManifestTransmitVO();
				condVO.setUserId(account.getUsr_id());
				condVO.setOfcCd(account.getOfc_cd());
				//command.transmitManifest(condVO);
				String key = command.startBackEndJob(account, condVO, "ESM_BKG_1344");
				eventResponse.setETCData("KEY", key);
				log.debug("############################ key:"+key);
				// 전송후 UPDATE 처리
				// E Type인 경우는 전송이력을 남기지 않는다.
				if (!condVO.getNoneBlInType().equals("E")) {
					maniCommand.transmitManifest(condVO);
				}
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getMessage());

			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				// Trans Amendment To PA, Trans Cancellation To PA
				Kor24AmendManifestTransmitVO condVO = event.getKor24AmendManifestTransmitVO();
				condVO.setUserId(account.getUsr_id());
				condVO.setOfcCd(account.getOfc_cd());
				String subNo = command.transAmendManifest(condVO);

				// Inbound 이고 ETA가 변경된 경우 전송 UPDATE
				if (condVO.getIoBndCd().equals("I") && condVO.getInChgEta().equals("AI")) {

					Kor24CorrInfoVO kor24CorrInfoVO = new Kor24CorrInfoVO();
					kor24CorrInfoVO.setSubNo			(subNo						);
					kor24CorrInfoVO.setBlNo			(condVO.getBlNo()			);
					kor24CorrInfoVO.setCBlNo			(condVO.getBlNo()			);
					kor24CorrInfoVO.setKrCstmsCorrId	("AI"						);
					kor24CorrInfoVO.setCorrRsn		("01"						);
					kor24CorrInfoVO.setUserId			(condVO.getUserId()			);
					kor24CorrInfoVO.setTrnsSeq		("1"						);
					kor24CorrInfoVO.setPortCd			(condVO.getPodCd()			);
					kor24CorrInfoVO.setKrVslCallSgnCd	(condVO.getVslCallSgnCd()	);
					kor24CorrInfoVO.setCallYr			(condVO.getEtaDt().substring(0,4));
					kor24CorrInfoVO.setCallKnt		(condVO.getCallKnt()		);
					kor24CorrInfoVO.setVslNm			(condVO.getVslNm()			);
					kor24CorrInfoVO.setVslRgstCntCd	(condVO.getVslCntCd()		);
					kor24CorrInfoVO.setIoTmlLocCd		(condVO.getIoTmlLocCd()		);
					kor24CorrInfoVO.setDchgMzdCd		(condVO.getDchgMzdCd()		);
					kor24CorrInfoVO.setVvd			(condVO.getVvd()			);

					maniCommand.addSndDtCorrInfo(kor24CorrInfoVO);
				}
			}
			// 성공메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
			commit();

		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1329 : MULTI <br>
	 * B/L List조회후 세관신고DownLoad<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse downloadCstmsBlList(Event e) throws EventException {
		EsmBkg1329Event event =(EsmBkg1329Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			Kor24DlContainerVO cont = new Kor24DlContainerVO();
			Kor24MrnNoVO fromClient = event.getKor24MrnNoVO();
			Kor24ManifestInfoVO[] list = event.getKor24ManifestInfoVOs();
			Kor24BkgCntrQtyInfoVO[] cntrList = event.getKor24BkgCntrQtyInfoVOs();
			cont.setKor24MrnNoVO(fromClient);
			cont.setKor24ManifestInfoVOs(list);
			cont.setKor24BkgCntrQtyInfoVOs(cntrList);
			// BACKEND JOB 으로 처리
			ManifestListDownloadBackEndBC backEndBC = new Kor24ManifestListDownloadBackEndBCImpl();
			((Kor24ManifestListDownloadBackEndBCImpl) backEndBC).setAccount(account);
			((Kor24ManifestListDownloadBackEndBCImpl) backEndBC).setKor24DlContainerVO(cont);
			((Kor24ManifestListDownloadBackEndBCImpl) backEndBC).setPgmNo("ESM_BKG_1329");
			String key = backEndBC.startBackEndBC(account.getUsr_id());
			eventResponse.setETCData("KEY", key);

		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1344 : MODIFY<BR>
	 * Manifest Transmission 관련해서<br>
	 * Save,
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyManifestSummaryInfo(Event e) throws EventException {
		EsmBkg1344Event event =(EsmBkg1344Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			Kor24ManifestListDownloadBC command = new Kor24ManifestListDownloadBCImpl();
			Kor24ManifestSmryCondVO condVO = event.getKor24ManifestSmryCondVO();
			// USERID
			condVO.setUserId(account.getUsr_id());
			// BC에 작업 요청
			command.modifyManifestSummaryInfo(condVO);
			commit();
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1344 : REMOVE<BR>
	 * Manifest Transmission 관련해서 Delete<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifestSummaryInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try
		 {
			begin();
			EsmBkg1344Event event =(EsmBkg1344Event) e;
			Kor24ManifestListDownloadBC command = new Kor24ManifestListDownloadBCImpl();
			// 파라메터
			Kor24ManiSumCondVO condVO = event.getKor24ManiSumCondVO();
			// ID, OFC_CD 넣기
			condVO.setUserId(account.getUsr_id());
			condVO.setOfcCd(account.getOfc_cd());
			// BC 에 작업 요청
			command.manageManifestSummaryInfo(condVO);
			commit();
			// 성공메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00593").getUserMessage());
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1329 : SEARCH03 <br>
	 * BackEndJob 실행 후 결과코드 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		EsmBkg1329Event event =(EsmBkg1329Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
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
					if (e.getEventName().equalsIgnoreCase("EsmBkg1329Event")) {
						// DOWN LOAD Success
						eventResponse.setUserMessage(new ErrorHandler("BKG01088").getUserMessage());
					}
					strResult = "SUCCESS";
				}
			}
			eventResponse.setETCData("jb_sts_flg", strResult);

		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 한국세관 Inbound Empty BL MSN 추가
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageMsnNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Kor24ManifestListDownloadBC command = null;
		try
		 {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1329Event event =(EsmBkg1329Event) e;
			command = new Kor24ManifestListDownloadBCImpl();
			command.manageMsnNo(event.getKor24MsnNoCondVOs());
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1329 : SAVE <br>
	 *  cross check 관련 result remark 저장
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCrossCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		Kor24ManifestListDownloadBC command = null;
		try {
			begin();

				command = new Kor24ManifestListDownloadBCImpl();
				EsmBkg1329Event event =(EsmBkg1329Event) e;
				command.manageCrossCheck(event.getKor24ManifestCrsChkInfoVOs(), account);


			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 한국세관 InBound Empty Amend 전송
	 * @param Kor24EmpAmdManiVO[] kor24EmpAmdManiVOs
	 * @throws EventException
	 */
	private void transmitEmpAmdManifest(Kor24EmpAmdManiVO[] kor24EmpAmdManiVOs) throws EventException {
		try {
			Kor24CustomsTransmissionBC command = new Kor24CustomsTransmissionBCImpl();
			// 파라메터 복사
			Kor24EmpAmdManiTransVO[] kor24EmpAmdManiTransVOs = new Kor24EmpAmdManiTransVO[kor24EmpAmdManiVOs.length];

			for (int i=0; i < kor24EmpAmdManiVOs.length; i++) {
				kor24EmpAmdManiTransVOs[i] = new Kor24EmpAmdManiTransVO();
				ObjectCloner.build(kor24EmpAmdManiVOs[i], kor24EmpAmdManiTransVOs[i]);
			}

			// 전송
			command.transmitEmpAmdManifest(kor24EmpAmdManiTransVOs);

		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
	}

	/**
	 * JP24 : Back End Job 공통<br>
	 *  - Back End Job Status 조회
	 *  (동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용)
	 *
	 * @param String backEndJobKey
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse getBackEndJobStatus(String backEndJobKey) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try {
			String jbStsFlg = command.getBackEndJobStatus(backEndJobKey);
			eventResponse.setETCData("jb_sts_flg", jbStsFlg);
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1501] Retrive<br>
	 * Advance Cargo Information Download & Transmit - Header 목록 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchCargoInfoHeader(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1501Event event = (EsmBkg1501Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try{
			eventResponse.setRsVoList(command.searchCargoInfoHeader(event.getCargoInfoHeaderVO()));
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1501] Retrive (sheet1 Double Click) - Back End Job 시작<br>
	 * Advance Cargo Information Download & Transmit - Detail 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse startBackEndJobSearchCargoInfoDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1501Event event = (EsmBkg1501Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try {
			eventResponse.setETCData("call_sgn_no", command.getCallSignByVsl(event.getCargoInfoHeaderVO().getVvd().substring(0, 4)));
			begin();
			eventResponse.setETCData("backEndJob_Key", command.startBackEndJobSearchCargoInfoDetail(event.getCargoInfoHeaderVO(), account));
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 결과<br>
	 * Advance Cargo Information Download & Transmit - Detail 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse resultBackEndJobSearchCargoInfoDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1501Event event = (EsmBkg1501Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try {
			eventResponse.setRsVoList(command.resultBackEndJobSearchCargoInfoDetail(event.getAttribute("backEndJob_Key").toString()));
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1501] Save - Back End Job 시작<br>
	 * Advance Cargo Information Download & Transmit - Detail 목록 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse startBackEndJobManageCargoInfoDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1501Event event = (EsmBkg1501Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try {
			begin();
			String backEndJobKey = command.startBackEndJobManageCargoInfoDetail(event.getCargoInfoHeaderVO(), event.getCargoInfoDetailVOs(), account);
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 결과<br>
	 * Advance Cargo Information Download & Transmit - Detail 목록 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse resultBackEndJobManageCargoInfoDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1501Event event = (EsmBkg1501Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try {
			begin();
			command.resultBackEndJobManageCargoInfoDetail(event.getAttribute("backEndJob_Key").toString());
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1501] Transmit - Back End Job 시작<br>
	 * Advance Cargo Information Download & Transmit - Detail 목록 EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse startBackEndJobTransmitCargoInfoDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1501Event event = (EsmBkg1501Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try {
			begin();
			String backEndJobKey = command.startBackEndJobTransmitCargoInfoDetail(event.getCargoInfoHeaderVO(), event.getCargoInfoDetailVOs(), account);
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * JP24 : [ESM_BKG_1501] New_Transmit - Back End Job 시작<br>
	 * Advance Cargo Information Download & New_Transmit - Detail 목록 EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse startBackEndJobTransmitCargoInfoDetailRenewal2017(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1501Event event = (EsmBkg1501Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try {
			begin();
			String backEndJobKey = command.startBackEndJobTransmitCargoInfoDetailRenewal2017(event.getCargoInfoHeaderVO(), event.getCargoInfoDetailVOs(), account);
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 결과<br>
	 * Advance Cargo Information Download & Transmit - Detail 목록 EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse resultBackEndJobTransmitCargoInfoDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1501Event event = (EsmBkg1501Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try {
			begin();
			command.resultBackEndJobTransmitCargoInfoDetail(event.getAttribute("backEndJob_Key").toString());
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1501] Mail Send<br>
	 * E-Mail전송과 ADV_JP_BL테이블의 USR_EML컬럼정보 수정
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse manageSendEmailCargoInfoDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1501Event event = (EsmBkg1501Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try {
			begin();
			command.manageSendEmailCargoInfoDetail(event.getCargoInfoHeaderVO(), event.getCargoInfoDetailVOs(), account);
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1502] Retrive<br>
	 * B/L Inquiry(Japan 24HR) 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchBLInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1502Event event = (EsmBkg1502Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try{
			List<AdvJpBlVO> list0 = command.searchBLInquiry(event.getAdvJpBlVO());
			// list0을 ETC-DATA로 setting
			if (list0.size() > 0) eventResponse.setETCData(list0.get(0).getColumnValues());
			eventResponse.setETCData("data_rows", String.valueOf(list0.size()));

			List<AdvJpContainerVO> list1 = command.searchBLInquiryContainer(event.getAdvJpBlVO());
			eventResponse.setRsVoList(list1);
			List<AdvJpMarkDescVO> list2 = command.searchBLInquiryMarkDesc(event.getAdvJpBlVO());
			eventResponse.setRsVoList(list2);

		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1502] (Customer입력창) 버튼 Click<br>
	 * MDM_CUSTOMER 정보 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse getMdmCustomer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1502Event event = (EsmBkg1502Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try{
			List<GetMdmCustomerVO> list = command.getMdmCustomer(event.getGetMdmCustomerVO());
			// list을 ETC-DATA로 setting
			if (list.size() > 0) eventResponse.setETCData(list.get(0).getColumnValues());
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1502] Save<br>
	 * B/L Inquiry(Japan 24HR) 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse manageBLInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1502Event event = (EsmBkg1502Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try{
			begin();
			command.manageBLInquiry(event.getAdvJpBlVO(), event.getAdvJpContainerVOs(), event.getAdvJpMarkDescVOs(), account);
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1502] Transmit - Back End Job 시작<br>
	 * B/L Inquiry(Japan 24HR) EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse startBackEndJobTransmitBLInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1502Event event = (EsmBkg1502Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try {
			begin();
			String backEndJobKey = command.startBackEndJobTransmitBLInquiry(event.getAdvJpBlVO(), account);
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * JP24 : [ESM_BKG_1502] New_Transmit - Back End Job 시작<br>
	 * B/L Inquiry(Japan 24HR) EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse startBackEndJobTransmitBLInquiryRenewal2017(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1502Event event = (EsmBkg1502Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try {
			begin();
			String backEndJobKey = command.startBackEndJobTransmitBLInquiryRenewal2017(event.getAdvJpBlVO(), account);
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1502] Back End Job 결과<br>
	 * B/L Inquiry(Japan 24HR) EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse resultBackEndJobTransmitBLInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1502Event event = (EsmBkg1502Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try {
			begin();
			command.resultBackEndJobTransmitBLInquiry(event.getAttribute("backEndJob_Key").toString());
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1503] Retrive<br>
	 * Departure Time Registration 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchDepartureTime(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1503Event event = (EsmBkg1503Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try{
			List<DepartureTimeVO> list = command.searchDepartureTime(event.getDepartureTimeVO());
			// list을 ETC-DATA로 setting
			if (list.size() > 0) eventResponse.setETCData(list.get(0).getColumnValues());
			eventResponse.setETCData("data_rows", String.valueOf(list.size()));

		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1503]
	 * Departure Time Registration EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse transmitDepartureTimeByUI(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1503Event event = (EsmBkg1503Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try{
			event.getDepartureTimeVO().setCntCd(account.getCnt_cd());
			event.getDepartureTimeVO().setOfcCd(account.getOfc_cd());
			event.getDepartureTimeVO().setUsrEml(account.getUsr_eml());
			event.getDepartureTimeVO().setUsrId(account.getUsr_id());

			begin();
			command.transmitDepartureTime(event.getDepartureTimeVO());
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [BATCH]
	 * Departure Time Registration EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse transmitDepartureTimeByBatch(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BatchForEdtAdtTransmitEvent event = (BatchForEdtAdtTransmitEvent)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try{
			begin();
			for (DepartureTimeVO departureTimeVO : event.getDepartureTimeVOs()) {
				command.transmitDepartureTime(departureTimeVO);
			}
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [UDEV_ALPSBKG_T_JPN24]
	 * 일본세관에서 송신한 EDI메세지를 수신 처리
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse receiveEDIForJapan24HR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UdevhjsAlpsbkgTJpn24Event event = (UdevhjsAlpsbkgTJpn24Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try{
			begin();
			command.receiveEDIForJapan24HR(event.getFlatFile());
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1504] Retrive<br>
	 * JMS Report 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchJmsReport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1504Event event = (EsmBkg1504Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try{
			eventResponse.setRsVoList(command.searchJmsReport(event.getJmsReportVO()));
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1505] Retrive<br>
	 * Transmit Result Error Report 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchErrorReport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1505Event event = (EsmBkg1505Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try{
			eventResponse.setRsVoList(command.searchErrorReport(event.getErrorReportVO()));
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JP24 : [ESM_BKG_1506] Retrive<br>
	 * Send FlatFile 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchSendFlatFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1506Event event = (EsmBkg1506Event)e;
		Jp24ManifestListDownloadBC command = new Jp24ManifestListDownloadBCImpl();

		try{
			eventResponse.setRsVoList(command.searchSendFlatFile(event.getFlatFileVO()));
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * CHINA 24HR : [ESM_BKG_1508] Retrive<br>
	 * Vessel Registration 목록 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChinaVslRgst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1508Event event = (EsmBkg1508Event)e;
		ManifestListDownloadBC command = new ChinaManifestListDownloadBCImpl();

		try{
			eventResponse.setRsVoList(command.searchChinaVslRgst(event.getChinaVslRgstVO()));
		} catch(EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * CHINA 24HR : [ESM_BKG_1508] Save<br>
	 * Vessel Registration 목록 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageChinaVslRgst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1508Event event = (EsmBkg1508Event)e;
		ManifestListDownloadBC command = new ChinaManifestListDownloadBCImpl();

		try{
			begin();
			command.manageChinaVslRgst(event.getChinaVslRgstVO(), event.getChinaVslRgstVOs(), account);
			commit();
		} catch (EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

}
