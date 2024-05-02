/*========================================================= 
 *Copyright(c) 2013 CyberLogitec
 *@FileName : CustomsDeclarationJapanSC.java
 *@FileTitle : CustomsDeclarationJapanSC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.18
 *@LastModifier :
 *@LastVersion : 1.0
 * 2013.10.18
 * 1.0 Creation
=======================================================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.basic.JapanCustomsReportBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.basic.JapanCustomsReportBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.event.EsmBkg0471Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.event.EsmBkg0472Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.event.EsmBkg0477Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.event.EsmBkg0478Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListReceiveHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListTransmitHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.basic.JapanCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.basic.JapanCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListTransmitDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.basic.JapanManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.basic.JapanManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0455Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0456Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0457Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0458Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0462Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0466Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0470Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0730Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0990Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0991Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg1510Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg1511Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg1512Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkgUbizComOpusBkgNaccsEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgDetail2VO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCmfDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCntrDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListDorListInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListEtcVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCustInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfsDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListVslPortSkdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanVesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCntrModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCustModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrMndModificationVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorEdiTransVO;
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
import com.clt.syscommon.common.table.BkgCstmsJpBlVO;
import com.clt.syscommon.common.table.BkgCstmsJpRcvLogVO;
import com.clt.syscommon.common.table.BkgCstmsJpSndLogVO;


/**
 * OPUS-CustomsDeclarationJapan Business Logic ServiceCommand<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Sang-Soo
 * @see
 * @since J2EE 1.6
 */
public class CustomsDeclarationJapanSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationJapan system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("CustomsDeclarationJapanSC 시작");

		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch(Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CustomsDeclarationJapan system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationJapanSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-CustomsDeclarationJapan system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmBkg0471Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiveHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyReceiveLog(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0472Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiveLog(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0477Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmitHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifestForResend(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0478Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSendLog(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0455Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMfrCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMfrCntr(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0456Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMfrCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMfrCust(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0457Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestListForCmf(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifestForCmf(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = reactivateBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMdmCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMdmCust(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0458Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMfrMnd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMfrMnd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0462Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestListForDl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifestForDl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0466Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestListForDor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifestForDor(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0470Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0730Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestListForMfs(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifestForMfs(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0990Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = manageBkgReferenceNumberGeneration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = addBl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0991Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifestList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkgUbizComOpusBkgNaccsEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = receiveUbizComOpusBkgNaccs(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1510Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsCdByBnd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsCdByBnd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1511Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsJpWh(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsJpWh(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1512Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getComboCstmsCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsJpWhRout(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsJpWhRout(e);
			}
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0471 : SEARCH <br>
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 내역을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchReceiveHist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanCustomsReportBC command = new JapanCustomsReportBCImpl();
		EsmBkg0471Event event =(EsmBkg0471Event) e;

		try {
			List<JapanManifestListReceiveHistDetailVO> japanManifestListReceiveHistDetailVOs =(List<JapanManifestListReceiveHistDetailVO>) (Object) (command.searchReceiveHist((RcvHistCondVO) event.getJapanRcvHistCondVO()));
			if (japanManifestListReceiveHistDetailVOs.size() == 0) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			} else {
				japanManifestListReceiveHistDetailVOs.get(0).setMaxRows(Integer.parseInt(japanManifestListReceiveHistDetailVOs.get(0).getTotal()));
			}
			eventResponse.setRsVoList(japanManifestListReceiveHistDetailVOs);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0471 : MODIFY <br>
	 * 세관에서 받은 edi 현황정보를 가져온다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyReceiveLog(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanCustomsTransmissionBC command = new JapanCustomsTransmissionBCImpl();
		EsmBkg0471Event event =(EsmBkg0471Event) e;

		try {
			begin();
			// 성공메시지세팅
			command.modifyReceiveLog((ReceiveLogVO) event.getJapanReceiveLogVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0472 : SEARCH<BR>
	 * EDI수신 FLATFILE 내용 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceiveLog(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanCustomsReportBC command = new JapanCustomsReportBCImpl();
		EsmBkg0472Event event =(EsmBkg0472Event) e;

		try {
			List<BkgCstmsJpRcvLogVO> bkgCstmsJpRcvLogVOList = command.searchReceiveLog(event.getJapanReceiveLogCondVO());
			if (bkgCstmsJpRcvLogVOList.size() < 1) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			} else {
				eventResponse.setRsVoList(bkgCstmsJpRcvLogVOList);
			}

		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0477 : SEARCH <br>
	 * 세관에 적하목록 신고시 생성한 송신 EDI 메시지 내역을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchTransmitHist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanCustomsReportBC command = new JapanCustomsReportBCImpl();
		EsmBkg0477Event event =(EsmBkg0477Event) e;

		try {
			List<JapanManifestListTransmitHistDetailVO> japanManifestListTransmitHistDetailVOs =(List<JapanManifestListTransmitHistDetailVO>) (Object) (command.searchTransmitHist((TransmitHistCondVO) event.getJapanTransmitHistCondVO()));
			if (japanManifestListTransmitHistDetailVOs.size() == 0) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			} else {
				japanManifestListTransmitHistDetailVOs.get(0).setMaxRows(Integer.parseInt(japanManifestListTransmitHistDetailVOs.get(0).getTotal()));
			}
			eventResponse.setRsVoList(japanManifestListTransmitHistDetailVOs);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0477 : MULTI <br>
	 * 세관에 EDI 전송데이터를 재전송한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifestForResend(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanCustomsTransmissionBC command = new JapanCustomsTransmissionBCImpl();
		EsmBkg0477Event event =(EsmBkg0477Event) e;
		String flatFile = "";

		try {
			begin();
			flatFile = command.transmitManifestForResend((ManifestTransmitVO) event.getJapanManifestTransmitForReVO(), account);
			eventResponse.setETCData("flatFile", flatFile);
			eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0478 : SEARCH<br>
	 * EDI수신 FLATFILE 내용 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSendLog(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanCustomsReportBC command = new JapanCustomsReportBCImpl();
		EsmBkg0478Event event =(EsmBkg0478Event) e;

		try {
			List<BkgCstmsJpSndLogVO> bkgCstmsJpSndLogVOList = command.searchSendLog(event.getJapanSendLogCondVO());
			if (bkgCstmsJpSndLogVOList.size() < 1) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			} else {
				eventResponse.setRsVoList(bkgCstmsJpSndLogVOList);
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0455 : SEARCH01 <br>
	 * NACCS_EDI_OPUSBKG_SEANACCS 연동<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchMfrCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg0455Event event =(EsmBkg0455Event) e;

		try {
			List<JapanManifestListMfrCntrInfoVO> japanManifestListMfrCntrInfoVOs = null;
			japanManifestListMfrCntrInfoVOs =(List<JapanManifestListMfrCntrInfoVO>) (Object) command.searchMfrCntr((ManifestListCondVO) event.getJapanManifestListMfrCondVO());
			eventResponse.setRsVoList(japanManifestListMfrCntrInfoVOs);
			// 성공메시지세팅
			if (japanManifestListMfrCntrInfoVOs.size() == 0) eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0455 : MULTI <br>
	 * 일본세관 신고 대상 Container 정보를 세관 테이블 내에 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMfrCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg0455Event event =(EsmBkg0455Event) e;

		try {
			begin();
			command.manageMfrCntr((MfrCntrModificationVO[]) event.getJapanMfrCntrModificationVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0456 : SEARCH <br>
	 * searchUserAuthority 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMfrCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg0456Event event =(EsmBkg0456Event) e;

		try {
			// 이벤트별 Impl생성
			JapanManifestListMfrCustInfoVO japanManifestListMfrCustInfoVO = new JapanManifestListMfrCustInfoVO();
			japanManifestListMfrCustInfoVO =(JapanManifestListMfrCustInfoVO) command.searchMfrCust((ManifestListCondVO) event.getJapanManifestListMfrCondVO());
			eventResponse.setRsVo(japanManifestListMfrCustInfoVO);
			if (japanManifestListMfrCustInfoVO.getBlNumber().equals("") || japanManifestListMfrCustInfoVO.getBlNumber() == null)
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0456 : MULTI <br>
	 * 일본세관 신고 대상 Customer 정보를 세관 테이블 내에 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMfrCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg0456Event event =(EsmBkg0456Event) e;

		try {
			// 이벤트별 Impl생성
			begin();
			command.manageMfrCust((MfrCustModificationVO) event.getJapanMfrCustModificationVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0457 : SEARCH <br>
	 * 일본세관 신고 대상 Container 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestListForCmf(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC manifestCommand = new JapanManifestListDownloadBCImpl();
		JapanCustomsTransmissionBC transmissionCommand = new JapanCustomsTransmissionBCImpl();
		EsmBkg0457Event event =(EsmBkg0457Event) e;

		try {
			JapanManifestListCmfDetailVO japanManifestListCmfDetailVO = null;
			japanManifestListCmfDetailVO = (JapanManifestListCmfDetailVO)manifestCommand.searchManifestListForCmf((ManifestListCondVO) event.getJapanManifestListCondVO());
			if (japanManifestListCmfDetailVO != null) {
				eventResponse.setRsVo(japanManifestListCmfDetailVO);

				JapanManifestTransmitVO japanManifestTransmitVO = new JapanManifestTransmitVO();
				japanManifestTransmitVO.setInVslCd(japanManifestListCmfDetailVO.getVvdCd().substring(0, 4));
				japanManifestTransmitVO.setInSkdVoyNo(japanManifestListCmfDetailVO.getVvdCd().substring(4, 8));
				japanManifestTransmitVO.setInSkdDirCd(japanManifestListCmfDetailVO.getVvdCd().substring(8));
				japanManifestTransmitVO.setInPodCd(japanManifestListCmfDetailVO.getPodCd());
				if (transmissionCommand.searchDmfSendLog(japanManifestTransmitVO) < 1) {
					eventResponse.setETCData("send_yn", "N");
				} else {
					eventResponse.setETCData("send_yn", "Y");
				}

			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0457 : MULTI <br>
	 * Mdm Customer 정보 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifestForCmf(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg0457Event event =(EsmBkg0457Event) e;

		try {
			begin();
			command.manageManifestForCmf((ManifestModificationVO) event.getJapanCmfModificationVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0457 : MULTI01 <br>
	 * B/L List조회후 세관신고DownLoad<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reactivateBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg0457Event event =(EsmBkg0457Event) e;

		try {
			begin();
			command.reactivateBl((BlKeyVO) event.getJapanBlKeyVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0457 : INIT <br>
	 * com_intg_cd_dtl Table 조회<br>
	 *
	 * @param String comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private EventResponse searchMdmCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBkg0457Event event =(EsmBkg0457Event) e;

		try {
			MdmCustVO mdmCustVO = command.searchMdmCust(event.getForm1CustCntCd(), event.getForm1CustSeq(), "N");
			if (event.getCustType().equals("S")) {
				eventResponse.setETCData("form1_cust_nm", mdmCustVO.getName());
				eventResponse.setETCData("form1_cust_addr", mdmCustVO.getAddress());
			} else if (event.getCustType().equals("C")) {
				eventResponse.setETCData("form1_cust_nm2", mdmCustVO.getName());
				eventResponse.setETCData("form1_cust_addr2", mdmCustVO.getAddress());
			} else if (event.getCustType().equals("N")) {
				eventResponse.setETCData("form1_cust_nm3", mdmCustVO.getName());
				eventResponse.setETCData("form1_cust_addr3", mdmCustVO.getAddress());
			}
			if (mdmCustVO == null) eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0458 : SEARCH02<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMfrMnd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg0458Event event =(EsmBkg0458Event) e;

		try {
			// 이벤트별 Impl생성
			JapanContainerVO japanContainerVO = command.searchMfrMnd((ManifestListCondVO) event.getJapanManifestListMfrCondVO());
			eventResponse.setRsVoList(japanContainerVO.getBkgCstmsJpBlMkVOs());
			BkgCstmsJpBlVO bkgCstmsJpBlVO = japanContainerVO.getBkgCstmsJpBlVO();
			if (bkgCstmsJpBlVO != null) {
				eventResponse.setETCData("pck_qty", bkgCstmsJpBlVO.getPckQty());
				eventResponse.setETCData("pck_tp_cd", bkgCstmsJpBlVO.getPckTpCd());
				eventResponse.setETCData("grs_wgt", bkgCstmsJpBlVO.getGrsWgt());
				eventResponse.setETCData("wgt_ut_cd", bkgCstmsJpBlVO.getWgtUtCd());
				eventResponse.setETCData("meas_qty", bkgCstmsJpBlVO.getMeasQty());
				eventResponse.setETCData("meas_ut_cd", bkgCstmsJpBlVO.getMeasUtCd());
				eventResponse.setETCData("locl_ts_flg", bkgCstmsJpBlVO.getLoclTsIndCd());
				eventResponse.setETCData("jp_cstms_trns_cd", bkgCstmsJpBlVO.getJpCstmsTrnsCd());
				eventResponse.setETCData("lmt_no", bkgCstmsJpBlVO.getLmtNo());
				eventResponse.setETCData("cy_opr_cd", bkgCstmsJpBlVO.getCyOprId());
			} else {
				eventResponse.setETCData("pck_qty", "");
				eventResponse.setETCData("pck_tp_cd", "");
				eventResponse.setETCData("grs_wgt", "");
				eventResponse.setETCData("wgt_ut_cd", "");
				eventResponse.setETCData("meas_qty", "");
				eventResponse.setETCData("meas_ut_cd", "");
				eventResponse.setETCData("locl_ts_flg", "");
				eventResponse.setETCData("jp_cstms_trns_cd", "");
				eventResponse.setETCData("lmt_no", "");
				eventResponse.setETCData("cy_opr_cd", "");
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0458 : MULTI <br>
	 * 일본세관 신고 대상 Marks & Description 정보를 세관 테이블 내에 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMfrMnd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg0458Event event =(EsmBkg0458Event) e;

		try {
			// 이벤트별 Impl생성
			begin();
			command.manageMfrMnd((MfrMndModificationVO) event.getMfrMndModificationVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0462 : SEARCH <br>
	 * Manifest Registration(MFR) 에서 Cust 정보 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestListForDl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg0462Event event = (EsmBkg0462Event) e;

		try {
			JapanContainerVO japanContainerVO = command.searchManifestListForDl((ManifestListCondVO) event.getJapanManifestListCondVO());
			if (japanContainerVO != null) {
				List<JapanManifestListVslPortSkdVO> japanManifestListVslPortSkdVOs = japanContainerVO.getJapanManifestListVslPortSkdVOs();
				eventResponse.setRsVoList(japanManifestListVslPortSkdVOs);
				List<JapanManifestListBkgDetailVO> japanManifestListBkgDetailVOs = japanContainerVO.getJapanManifestListBkgDetailVOs();
				eventResponse.setRsVoList(japanManifestListBkgDetailVOs);
				List<JapanManifestListCntrDetailVO> japanManifestListCntrDetailVOs = japanContainerVO.getJapanManifestListCntrDetailVOs();
				eventResponse.setRsVoList(japanManifestListCntrDetailVOs);
				List<JapanManifestListBkgDetail2VO> japanManifestListBkgDetail2VOs = japanContainerVO.getJapanManifestListBkgDetail2VOs();
				eventResponse.setRsVoList(japanManifestListBkgDetail2VOs);

				int totalSize = 0;
				for (int i = 0; i < japanManifestListBkgDetailVOs.size(); i++) {
					if (japanManifestListBkgDetailVOs.get(i).getSeq() != null) totalSize++;
				}
				eventResponse.setETCData("total_count", totalSize + "");
				if (japanManifestListVslPortSkdVOs.size() == 0 && japanManifestListBkgDetailVOs.size() == 0 && japanManifestListCntrDetailVOs.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				}
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0462 : MULTI <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(MFS 데이터) 를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifestForDl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg0462Event event =(EsmBkg0462Event) e;

		try {
			begin();
			command.manageManifestForDl(event.getJapanManifestModificationVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0466 : SEARCH <br>
	 * VVD, Port 등 입력 후 조회한 세관 MFR 신고 대상 List조회.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchManifestListForDor(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();

		try {
			List<JapanManifestListDorListInfoVO> japanManifestListDorListInfoVOs =(List<JapanManifestListDorListInfoVO>) (Object) (command.searchManifestListForDor());
			if (japanManifestListDorListInfoVOs.size() == 0) eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			eventResponse.setRsVoList(japanManifestListDorListInfoVOs);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0466 : MULTI <br>
	 * 세관에 EDI를 통해 메시지를 전송한다.(DOR) <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifestForDor(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		EsmBkg0466Event event =(EsmBkg0466Event) e;

		try {
			begin();
			// BackEnd
			JapDorEdiTransVO[] japDorEdiTransVOs = event.getJapDorEdiTransVOs();
			for (int i = 0; i < 1; i++) {
				japDorEdiTransVOs[i].setUpdUsrId(account.getUsr_id());
				japDorEdiTransVOs[i].setCreUsrId(account.getUsr_id());
				japDorEdiTransVOs[i].setUsrId(account.getUsr_id());
				japDorEdiTransVOs[i].setEvntUsrId(account.getUsr_id());
				japDorEdiTransVOs[i].setEvntOfcCd(account.getOfc_cd());
				japDorEdiTransVOs[i].setOfcCd(account.getOfc_cd());
				japDorEdiTransVOs[i].setDoCngEvntCd("DF");
				japDorEdiTransVOs[i].setSvcCd("C");
				japDorEdiTransVOs[i].setRlseSeq("1");
				japDorEdiTransVOs[i].setEvntCd("9");
				command.transmitEdiByJapDor(japDorEdiTransVOs[i]);
			}
			eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0470 : SEARCH01 <br>
	 * CUSTOMER NAME 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg0470Event event =(EsmBkg0470Event) e;

		try {
			List<JapanVesselArrivalVO> list = command.searchVesselArrival(event.getJapanVesselArrivalVO());
			if (list.size() == 0) eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0470 : MULTI <br>
	 * Vessel Arrival 정보를 생성 및 수정한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg0470Event event =(EsmBkg0470Event) e;

		try {
			begin();
			command.manageVesselArrival(event.getJapanVesselArrivalVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0470 : MULTI01 <br>
	 * DBF 파일생성해서 로컬로 파일 경로를 반환한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanCustomsTransmissionBC command = new JapanCustomsTransmissionBCImpl();
		EsmBkg0470Event event =(EsmBkg0470Event) e;

		try {
			begin();
			command.transmitVesselArrival(event.getJapanVesselArrivalVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0730 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(MFS 데이터)를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestListForMfs(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC manifestCommand = new JapanManifestListDownloadBCImpl();
		JapanCustomsTransmissionBC transmissionCommand = new JapanCustomsTransmissionBCImpl();
		EsmBkg0730Event event =(EsmBkg0730Event) e;

		try {
			JapanContainerVO japanContainerVO = manifestCommand.searchManifestListForMfs((ManifestListCondVO) event.getJapanManifestListCondVO());
			JapanManifestListEtcVO japanManifestListEtcVO = japanContainerVO.getJapanManifestListEtcVO();
			if (japanManifestListEtcVO.getCallSgnNo() != null && !japanManifestListEtcVO.getCallSgnNo().equals("")) {
				eventResponse.setETCData("in_call_sgn_no", japanManifestListEtcVO.getCallSgnNo());
				eventResponse.setETCData("in_vps_eta_dt", japanManifestListEtcVO.getEtaDt());
				eventResponse.setETCData("in_cy_opr_cd", japanManifestListEtcVO.getCyOprId());
				eventResponse.setETCData("in_pod_split_cd", japanManifestListEtcVO.getCstmsMfId());
				eventResponse.setETCData("in_voyage_no", japanManifestListEtcVO.getIbCssmVoyNo());
				eventResponse.setETCData("in_download_yn", japanManifestListEtcVO.getDownloadYn());

				List<JapanManifestListMfsDetailVO> japanManifestListMfsDetailVOs = japanContainerVO.getJapanManifestListMfsDetailVOs();
				if (japanManifestListMfsDetailVOs.size() > 0) {
					eventResponse.setRsVoList(japanManifestListMfsDetailVOs);
				} else {
					eventResponse.setETCData("in_call_sgn_no", "");
					eventResponse.setETCData("in_vps_eta_dt", "");
					eventResponse.setETCData("in_cy_opr_cd", "");
					eventResponse.setETCData("in_pod_split_cd", "");
					eventResponse.setETCData("in_voyage_no", "");
					eventResponse.setETCData("in_download_yn", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				}

			} else {
				eventResponse.setETCData("in_call_sgn_no", "");
				eventResponse.setETCData("in_vps_eta_dt", "");
				eventResponse.setETCData("in_cy_opr_cd", "");
				eventResponse.setETCData("in_pod_split_cd", "");
				eventResponse.setETCData("in_voyage_no", "");
				eventResponse.setETCData("in_download_yn", "");
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			}

			JapanManifestTransmitVO japanManifestTransmitVO = new JapanManifestTransmitVO();
			japanManifestTransmitVO.setInVslCd(event.getJapanManifestListCondVO().getInVvdCd().substring(0, 4));
			japanManifestTransmitVO.setInSkdVoyNo(event.getJapanManifestListCondVO().getInVvdCd().substring(4, 8));
			japanManifestTransmitVO.setInSkdDirCd(event.getJapanManifestListCondVO().getInVvdCd().substring(8));
			japanManifestTransmitVO.setInPodCd(event.getJapanManifestListCondVO().getInPodCd());
			if (transmissionCommand.searchDmfSendLog(japanManifestTransmitVO) < 1) {
				eventResponse.setETCData("send_yn", "N");
			} else {
				eventResponse.setETCData("send_yn", "Y");
			}

		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0730 : MULTI <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(MFS 데이터)를 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifestForMfs(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg0730Event event =(EsmBkg0730Event) e;

		try {
			begin();
			command.manageManifestForMfs(event.getJapanManifestModificationVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0730 : MULTI01 <br>
	 * ESM_BKG_0991 : MULTI <BR>
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanCustomsTransmissionBC command = new JapanCustomsTransmissionBCImpl();

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0730Event")) {
				EsmBkg0730Event event =(EsmBkg0730Event) e;
				String key = command.startBackEndJob(account, event.getJapanManifestTransmitContainerVO(), "ESM_BKG_0730");
				eventResponse.setETCData("KEY", key);

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0991Event")) {
				JapanManifestListDownloadBC maniCommand = new JapanManifestListDownloadBCImpl();
				EsmBkg0991Event event =(EsmBkg0991Event) e;
				JapanManifestListTransmitDetailVO japanManifestListTransmitDetailVO = (JapanManifestListTransmitDetailVO) command.transmitManifestList(event.getManifestTransmitVO(), account);
				maniCommand.modifyMsgStatus(japanManifestListTransmitDetailVO.getJapanBlKeyVOs());
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
			}
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0730 : SEARCH03 <br>
	 * BackEndJob 결과를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0730Event event =(EsmBkg0730Event) e;
		String sKey = event.getKey();
		String strResult = "";

		try {
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();

			while(rowSet.next()) {
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
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0990 : SEARCH <br>
	 *
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBkgReferenceNumberGeneration(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil utilBC = new BookingUtil();

		try {
			begin();
			BkgReferenceNoGenerationVO bkgReferenceNoGenerationVO = utilBC.manageBkgReferenceNumberGeneration("JPD", account.getOfc_cd(), account.getUsr_id());
			eventResponse.setETCData("dummy_bl_no", bkgReferenceNoGenerationVO.getJpdNo());
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0990 : MULTI <br>
	 * BL정보를 저장한다.<br>
	 *
	 * @return String
	 * @exception EventException
	 */
	private EventResponse addBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg0990Event event =(EsmBkg0990Event) e;

		try {
			begin();
			command.addBl((BlVO) event.getJapanBlVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EsmBkgUbizComOpusBkgNaccsEvent<br>
	 * NACCS EDI수신데이터를 처리한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveUbizComOpusBkgNaccs(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanCustomsTransmissionBC command = new JapanCustomsTransmissionBCImpl();
		EsmBkgUbizComOpusBkgNaccsEvent event =(EsmBkgUbizComOpusBkgNaccsEvent) e;

		try {
			begin();
			command.receiveUbizcomOpusBkgNaccs(event.getFlatFile(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1510] Retrive<br>
	 * Approval Number and Place of Arrival 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsCdByBnd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg1510Event event = (EsmBkg1510Event) e;

		try {
			eventResponse.setRsVoList(command.searchAproNoFromWhRout(event.getApprovalCstmsCdVO()));
			eventResponse.setRsVoList(command.searchAproNoFromJpBl(event.getApprovalCstmsCdVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1510] Save<br>
	 * Approval Number and Place of Arrival 목록 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsCdByBnd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg1510Event event = (EsmBkg1510Event) e;

		try {
			begin();
			command.manageApprovalCstmsCd(event.getApprovalCstmsCdVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1511] Retrive<br>
	 * Manifest e-Maiil Notification 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsJpWh(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg1511Event event = (EsmBkg1511Event) e;

		try {
			eventResponse.setRsVoList(command.searchCstmsJpWh(event.getCstmsJpWhVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1511] Save<br>
	 * Bonded Place Code 목록 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsJpWh(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg1511Event event = (EsmBkg1511Event) e;

		try {
			begin();
			command.manageCstmsJpWh(event.getCstmsJpWhVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1512] Retrive<br>
	 * CSTMS_CD Combo Item 목록 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getComboCstmsCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg1512Event event = (EsmBkg1512Event) e;

		try {
			eventResponse.setRsVoList(command.getComboCstmsCd(event.getCstmsJpWhRoutVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1512] Retrive<br>
	 * Approval Number and Place of Arrival 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsJpWhRout(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg1512Event event = (EsmBkg1512Event) e;

		try {
			eventResponse.setRsVoList(command.searchCstmsJpWhRout(event.getCstmsJpWhRoutVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1512] Save<br>
	 * Approval Number and Place of Arrival 목록 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsJpWhRout(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanManifestListDownloadBC command = new JapanManifestListDownloadBCImpl();
		EsmBkg1512Event event = (EsmBkg1512Event) e;

		try {
			begin();
			command.manageCstmsJpWhRout(event.getCstmsJpWhRoutVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}


}

