/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingCommonSC.java
 *@FileTitle : Booking Page
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.23
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.23 김영출
 * 1.0 Creation
 ------------------------------------------------------
 * HISTORY
 * 2011.05.18 김봉균 [CHM-201110697-01] BDR Open 권한 변경(seacrhManualBdrUserCheck 추가)
 * 2011.11.08 전성진 [] booking re-activate 기능 추가
 * 2012.03.14 김경섭 [CHM-201216605] ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회 추가.
 * 2012.03.29 전성진 [CHM-201217014] 악성 화주 선택시 Warning Message 변경 요청
 * 2012.04.24 오요한 [CHM-201216516] BKG/DOC System 보완 요청
 * 2012.07.09 전성진 [] booking re-activate 기능 보완, Container cancel 원복처리 추가 
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.event.EsmBkg0080Event;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.event.EsmBkg0088Event;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.event.EsmBkg0895Event;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.event.EsmBookingUtilEvent;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlckListMntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgCstmsHrdCdgCtntVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgInetBlPrnAuthVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.ReportItemVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchSvcLaneBoundVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingProcessMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingProcessMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.HoldNoticeBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.HoldNoticeBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CstmsHldVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
//import com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
//import com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.framework.component.databasedata.FileDatabaseData;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
//import com.hanjin.syscommon.common.table.CoaBkgComIfVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvSndLogVO;
import com.hanjin.syscommon.common.table.BkgHamoTrfVO;
import com.hanjin.syscommon.common.table.BkgIdaSacMstVO;
import com.hanjin.syscommon.common.table.MasBkgComIfVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
import com.hanjin.syscommon.common.table.MdmYardVO;

import com.hanjin.apps.alps.esm.bkg.common.CountryCode;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.basic.CndCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.UbizhjsAlpsBkgCancusAckEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.basic.KorCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkgUdevhjsAlpsbkgKrcusEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorRcvAckMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.basic.UsaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBCImpl;
import com.hanjin.syscommon.common.table.BkgCstmsAdvIbdVO;

/**
 * NIS2010-BookingCommon Business Logic ServiceCommand - NIS2010-BookingCommon
 * 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Youngchul
 * @see BookingUtilDBDAO
 * @since J2EE 1.4
 */

public class BookingCommonSC extends ServiceCommandSupport {
	// Login User Information
    private SignOnUserAccount account = null;
    
	/**
	 * BookingCommon system 업무 시나리오 선행작업<br>
	 * UI_Booking_Util업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("BookingCommonSC 시작");
		try {
            // 일단 comment --> 로그인 체크 부분
            account = getSignOnUserAccount();
        } catch(Exception e) {
            log.error(e.getMessage());
        }
	}

	/**
	 * BookingCommon system 업무 시나리오 마감작업<br>
	 * UI_Booking_Util 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("BookingCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-BookingCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		/* EsmBookingUtilEvent */
		if (e.getEventName().equalsIgnoreCase("EsmBookingUtilEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCombo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchBkgNoByBlNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchBkgStatusByBkg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchBkgNoSplitByBkg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = sendFaxEmailByBkgNoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = existCountryCode(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = seacrhMDMCombo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {
				eventResponse = searchFrob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)) {
				eventResponse = searchRfaAvailable(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {
				eventResponse = searchScAvailable(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchTaaAvailable(e);

			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)) {
				// BKG_NO 번호로 OLD ,NEW BKG_NO 번호 구분자($)로 가져오는 함수
				eventResponse = searchBkgNoListByBkgNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST15)) {
				// BL_NO 번호로 OLD ,NEW BL_NO 번호 구분자($)로 가져오는 함수
				eventResponse = searchBlNoListByBlNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST16)) {
				// ChargeCode 코드번호로 존재여부 판단하는 함수
				eventResponse = existChargeCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST17)) {
				// LOC_CD 코드번호로 LOC_NM값을 얻는 함수 
				eventResponse = searchMdmLocName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST18)) {
				// LOC_CD 코드번호로 LOC_NM값을 얻는 함수 
				eventResponse = existCurrencyCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST19)) {
				// Third (Offce cd) 유효성체크 
				eventResponse = existThirdCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST20)) {
				// Payer (custCntCd, custSeq) 유효성체크 
				eventResponse = existPayerCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				// Per (per) 유효성체크 
				eventResponse = existPerCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND10)) {
				eventResponse = exeProcedureTest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				// This customer is blacklisted customer 유효성체크 
				eventResponse = existBlackListedCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				// existNoteButtonColor 유효성체크 
				eventResponse = existNoteButtonColor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				// AutoratingRfaAvailable 유효성체크 
				eventResponse = autoratingRfaAvailable(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				// AutoratingScAvailable 유효성체크 
				eventResponse = autoratingScAvailable(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)){
				// AutoratingTaaAvailable 유효성체크
				eventResponse = autoratingTaaAvailable(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)){
				// repCustomer 유효성체크
				eventResponse = repCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND08)){
				// saveFileExist 파일존재체크
				eventResponse = saveFileExist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				eventResponse = reactivateBooking(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {
				// SpotPricingRfa 유효성 체크 
				eventResponse = rfaSpotPricingAvailable(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND12)) {
				// 3rdParty BL Request Office 유효성 체크
				eventResponse = n3rdPartyBlReqOfcAvailable(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND13)) {
				// 3rdParty BL Request Result 유효성 체크
				eventResponse = n3rdPartyBlReqAvailable(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND14)) {
				// ESM_BKG_0000_1 2015.03.03 양동훈 수정, no rate status 수정
				eventResponse = modifyNoRtStsCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND15)) {
				// ESM_BKG_0000_1 2015.03.06 양동훈 수정, cyc_no 업데이트 수정
				eventResponse = manageCntrCycNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND16)) {
				eventResponse = searchWestAfricaPod(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND17)) {
				eventResponse = searchBkgRoute(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND18)) {
				eventResponse = addBkgBlckListMntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)){
				// ESM_Booking_Util_01 화면에서 입력받은 Sql 실행
					eventResponse = executeQuery(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				// searchCountryName
				eventResponse = searchCountryName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				// searchScNoValidationCheck
				eventResponse = searchScNoValidationCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				// searchBkgVvdCheck
				eventResponse = searchBkgVvdCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				// autoRatingRFACheck
				eventResponse = autoRatingRFACheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)){
				// autoRatingRFACheck
				eventResponse = searchRtAplyDateCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)){
				// doc Perfomance Report User id
				eventResponse = seacrhDocPerformanceUserCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)){
				// 로그인 유저 BDR권한 체크 ESM_BKG_0596에서 사용
				eventResponse = seacrhManualBdrUserCheck();
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)){
				// ESM_BKG_0079_01에서 사용
				eventResponse = searchAmdtSeq(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)){
				// ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회
				eventResponse = searchCstmsHardCodingList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)) { //2012.04.24 B/L Confirm, B/L Issued 체크 로직 추가
				eventResponse = checkBkgIssStatus (e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)){
				// ESM_BKG_0726 B/L Print User 조회
				eventResponse = search0726BlprnUsr(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH14)){
				// ESM_BKG_0726 B/L Print User 조회
				eventResponse = existCustomsEntryCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH15)){
				// ESM_BKG_0079_01
				eventResponse = searchKrCstmsDownload(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH16)){
				// ESM_BKG_0001_1.do //2015/03/05 양동훈 수정
				eventResponse = searchCntrInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH17)){
				// checkBkgBlackCustomer (BKG_BLACK_LIST)
				eventResponse = checkBkgBlackCustomer(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH18)){
				// checkBkgBlackCustomer (WORD_BLACK_LIST)
				eventResponse = checkWordBlackList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH19)){
				eventResponse = searchOfcCombo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH20)){
				eventResponse = searchHtsCodeDesc(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH21)){
				eventResponse = searchYearCombo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH22)){
				eventResponse = checkChaCalHypoBlckList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH23)){
				eventResponse = genOblSerNo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND19)){
				eventResponse = bkgInetBlOblSerNoAdd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH24)){
				eventResponse = searchBkgInetBlOblSerNo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH25)){
				eventResponse = searchBkgInetBlOblSerNoChecked(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND20)){
				eventResponse = bkgInetBlOblSerNoChecked(e);
            }else if(e.getFormCommand().isCommand(FormCommand.COMMAND21)){
                eventResponse = searchIdaSacMasterInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH27)){
				eventResponse = searchPorCdCheck(e);
            }else if(e.getFormCommand().isCommand(FormCommand.COMMAND22)){
            	eventResponse = loadCstmsRcvMsgTest(e);
			}
		} else /* EsmBkg0080Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTypeSize(e);
			}
		} else /* EsmBkg0088Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0088Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchYardCode(e);
			}
		} else /* EsmBkg0895Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0895Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReportItemList(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * searchRtAplyDateChecksearchRtAplyDateCheck 조회 이벤트 처리<br>
	 * event체크 <br>
	 * RtAplyDate 값 유무를 Check 함 <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRtAplyDateCheck(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchRtAplyDateCheck(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * autoRatingRFACheck 조회 이벤트 처리<br>
	 * event체크 <br>
	 * RFA Number 유효성을 검사함  <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse autoRatingRFACheck(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.autoRatingRFACheck(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * searchBkgVvdCheck 조회 이벤트 처리<br>
	 * event체크 <br>
	 * ScNumber 유효성을 검사함  <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVvdCheck(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchBkgVvdCheck(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * searchScNoValidationCheck 조회 이벤트 처리<br>
	 * 79-08 event체크 <br>
	 * ScNumber 유효성을 검사함  <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScNoValidationCheck(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchScNoValidationCheck(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * searchCountryName 조회 이벤트 처리<br>
	 * 79-02C event체크 <br>
	 * MDM_COUNTRY 이름값을 얻어옴  <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCountryName(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchCountryName(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * 파일존재유무판단  
	 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse saveFileExist(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		
		try {
			boolean fileExist = new FileDatabaseData(event.getInputText()).getFile().exists();
			eventResponse.setETCData("output_text", String.valueOf(fileExist));
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * AutoratingRfaAvailable 조회 이벤트 처리<br>
	 * 79-08 event체크 
	 * AutoratingRfaAvailable 유효성체크 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse autoratingRfaAvailable(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.autoratingRfaAvailable(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * AutoratingScAvailable 조회 이벤트 처리<br>
	 * 79-08 event체크 
	 * AutoratingScAvailable 유효성체크 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse autoratingScAvailable(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.autoratingScAvailable(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	

	/**
	 * repCustomer 조회 이벤트 처리<br>
	 * 79-08 event체크 
	 * AutoratingTaaAvailable 유효성체크 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse repCustomer(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try{
			String output_text = command.repCustomer(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex){
			throw ex;
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * AutoratingTaaAvailable 조회 이벤트 처리<br>
	 * 79-08 event체크 
	 * AutoratingTaaAvailable 유효성체크 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse autoratingTaaAvailable(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try{
			String output_text = command.autoratingTaaAvailable(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex){
			throw ex;
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * existNoteButtonColor 조회 이벤트 처리<br>
	 * 79-08 event체크 
	 * note 버튼 색상변경  
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existNoteButtonColor(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existNoteButtonColor(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * existBlackListedCustomer 조회 이벤트 처리<br>
	 * 79-08 event체크 
	 * Per (Per cd) 유효성체크 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existBlackListedCustomer(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BkgCreCustomerVO bkgCreCustomerVO = null;
		
		try {
			bkgCreCustomerVO = command.existBlackListedCustomer(event.getInputText());
			if(null != bkgCreCustomerVO) {
				eventResponse.setETCData("cust_cd", bkgCreCustomerVO.getCustCntCd()+bkgCreCustomerVO.getCustSeq());
				eventResponse.setETCData("rls_ctrl_rsn", bkgCreCustomerVO.getCustRlseCtrlRmk());
				eventResponse.setETCData("ar_ofc", bkgCreCustomerVO.getArOfc());
				eventResponse.setETCData("srep_nm", bkgCreCustomerVO.getSrepNm());
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * existPerCode 조회 이벤트 처리<br>
	 * 79-08 event체크 
	 * Per (Per cd) 유효성체크 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existPerCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existPerCode(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * existCountryCode 조회 이벤트 처리<br>
	 * 79-08 event체크 
	 * Third (COUNTY cd) 유효성체크 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existCountryCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existCountryCode(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * existThirdCode 조회 이벤트 처리<br>
	 * 79-08 event체크 
	 * Third (Offce cd) 유효성체크 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existThirdCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existThirdCode(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * existPayerCode 조회 이벤트 처리<br>
	 * 79-08 event체크 
	 * Payer (custCntCd, custSeq) 유효성체크 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existPayerCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existPayerCode(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * searchMdmLocName 조회 이벤트 처리<br>
	 * LOC_CD 코드번호로 LOC_NM값을 얻는 함수 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmLocName(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchMdmLocName(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * searchBkgNoListByBkgNo 조회 이벤트 처리<br>
	 * BKG_NO 번호로 OLD ,NEW BKG_NO 번호 구분자($)로 가져오는 함수
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgNoListByBkgNo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchBkgNoListByBkgNo(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * searchBlNoListByBlNo 조회 이벤트 처리<br>
	 * BL_NO 번호로 OLD ,NEW BL_NO 번호 구분자($)로 가져오는 함수
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlNoListByBlNo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchBlNoListByBlNo(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * existChargeCode 조회 이벤트 처리<br>
	 * ChargeCode 코드번호로 존재여부 판단하는 함수
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existChargeCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existChargeCode(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * existCurrencyCode 조회 이벤트 처리<br>
	 * CurrencyCode 코드번호로 존재여부 판단하는 함수
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existCurrencyCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existCurrencyCode(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	

	/**
	 * 조회 이벤트 처리<br>
	 * BookingComboUtil의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		try {
			String comboCd = event.getComboCd();

			List<BkgComboVO> list = command.searchCombo(comboCd);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * BookingComboUtil의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgNoByBlNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		try {
			String blNo = "";
			String bkgStsCd = command.searchBkgNoByBlNo(blNo);
			eventResponse.setCustomData("bkg_sts_cd", bkgStsCd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * BookingUtil의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgStatusByBkg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		
		try {
			String bkgStsCd = command.searchBkgStatusByBkg(event.getBkgBlNoVO());
			eventResponse.setCustomData("bkg_sts_cd", bkgStsCd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * BookingComboUtil의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgNoSplitByBkg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		
		String bkgNo = event.getBkgNo();
		if (bkgNo == null || bkgNo.length() == 0) {
			log.info("Bkg No. can't be null!!! ");
			return eventResponse;
		}

		try {
			List<BkgComboVO> list = command.searchBkgNoSplitByBkg(bkgNo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse sendFaxEmailByBkgNoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		// EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		//
		// String bkgNo = event.getBkgNo();
		//
		// try{
		// List<BkgComboVO> list = command.searchBkgNoSplitByBkg(bkgNo);
		// eventResponse.setRsVoList(list);
		// }catch(EventException ex){
		// throw ex;
		// }catch(Exception ex){
		// throw new EventException(ex.getMessage(), ex);
		// }

		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * BookingUtil의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTypeSize(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0080Event event = (EsmBkg0080Event) e;

		BookingUtil command = new BookingUtil();
		try {
			List<MdmCntrTpSzVO> list = command.searchTypeSize(event.getMdmCntrTpSzVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			eventResponse.setRsVoList(list);

			return eventResponse;

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

	}


    /**
     * Return CY Inquiry 목록을 조회한다.
     * @param e Event 
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchYardCode (Event e) throws EventException {
    	EsmBkg0088Event event = (EsmBkg0088Event)e;
    	BookingUtil command = new BookingUtil();
    	MdmYardVO vo = event.getMdmYardVO();
    	try {
    		List <MdmYardVO> list = command.searchYardCode(vo);
        	GeneralEventResponse eventResponse = new GeneralEventResponse();
        	eventResponse.setRsVoList(list);
        	return eventResponse;
        	
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
     * MDM TABLE COMBO LIST을 조회한다.
     * @param e Event 
     * @return EventResponse
     * @throws EventException
     */
	@SuppressWarnings({ "unchecked" })
	private EventResponse seacrhMDMCombo (Event e) throws EventException {
    	EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
    	BookingUtil command = new BookingUtil();
    	Map<String, Object> comboParam = new HashMap<String, Object>();
    	try {
    		DBRowSet dbRowset  = command.seacrhMDMCombo(comboParam,event.getComboCd());
        	GeneralEventResponse eventResponse = new GeneralEventResponse();
        	
        	if (event.getComboCd().equals("MDM0001")){
        		List<SearchSvcLaneBoundVO> list = null;
        		list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchSvcLaneBoundVO.class);
        		SearchSvcLaneBoundVO svo = new SearchSvcLaneBoundVO();
        		svo.setSkdDirCd("*");
        		svo.setVslSlanCd("*	*");
        	    svo.setVslSlanNm("All");
        	    list.add(0,svo);
        	    
        		eventResponse.setRsVoList(list);
    		}
        	
        	return eventResponse;
        	
    	} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
    	} catch (Exception ex){
    		throw new EventException(ex.getMessage(), ex);
		} 
    }

	/**
	 * Return Report Table,Column 목록을 조회한다.
	 * 
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchReportItemList (Event e) throws EventException {
    	
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0895Event event = (EsmBkg0895Event)e;
    	
        String rptId 		= event.getRptId();
        String bkgRptKndCd 	= event.getBkgRptKndCd();
    	
    	BookingUtil command = new BookingUtil();
    	try {
    		List <ReportItemVO> list  = command.searchReportItemList(rptId, bkgRptKndCd);
    		List <ReportItemVO> list2 = command.searchTblColList(rptId, bkgRptKndCd);
        	
    		eventResponse.setRsVoList(list2);
        	eventResponse.setRsVoList(list);        	
        	return eventResponse;
        	
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

	/**
	 * 미주,캐나다 Port 경유 여부 확인
	 * 
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchFrob(Event e) throws EventException {
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		
		try {
			String frob = command.searchFrob(event.getBkgNo(), event.getBkgTrunkVvd(), event.getPolCd(), event.getPodCd());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("frobCode", frob);
			return eventResponse;

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Rfa NO 유효성 검사
	 * 
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRfaAvailable(Event e) throws EventException {
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		try {
			String rfaAvailable = "Y";
			if (!command.searchRfaAvailable(event.getRfaNo(), event.getBkgBlNoVO())) {
				rfaAvailable = "N";
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("rfa_available", rfaAvailable);
			return eventResponse;

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Sc NO 유효성 검사
	 * 
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchScAvailable(Event e) throws EventException {
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		try {
			String scAvailable = "Y";
			if (!command.searchScAvailable(event.getScNo(), event.getBkgBlNoVO())) {
				scAvailable = "N";
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("sc_available", scAvailable);
			return eventResponse;

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	/**
	 * Taa NO 유효성 검사
	 * 
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTaaAvailable(Event e) throws EventException {
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		try {
			String taaAvailable = "Y";
			if (!command.searchTaaAvailable(event.getTaaNo(), event.getBkgBlNoVO())) {
				taaAvailable = "N";
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("taa_available", taaAvailable);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
     * PROCEDURE를 테스트한다.
     * @param e Event 
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse exeProcedureTest (Event e) throws EventException {
    	try {
    		BookingProcessMgtBC bc = new BookingProcessMgtBCImpl();
    		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
			
			//List<BkgVvdBdrLogVO> vos     = new ArrayList<BkgVvdBdrLogVO>();
			//BkgVvdBdrLogVO[] bkgVvdBdrLogVOs = null;
			
			/*BkgVvdBdrLogVO vo = new BkgVvdBdrLogVO();
			vo.setVslCd("YUBT");
			vo.setSkdVoyNo("0011");
			vo.setSkdDirCd("W");
			vo.setIbflag("N");
			vo.setVpsPortCd("CNNBO");
			vo.setPortSkdStsCd("D");
			vo.setClptIndSeq("1");*/
			BkgVvdBdrLogVO vo = event.getBkgVvdBdrLogVO();
			//vos.add(vo);
			begin();
			vo = bc.manageBKGBDRLOG(vo,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			//eventResponse.setETCData(vo.getColumnValues());
			if (vo.getOResult().equals("S")){
				commit();
			}else{ 
				rollback();
			}
			eventResponse.setETCData("o_result",vo.getOResult());
			eventResponse.setETCData("o_err_msg",vo.getOErrMsg());
			
			return eventResponse;
			
    	} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		}
    }
    /**
     * ESM_Booking_Util_01 화면에서 입력받은 Sql 실행.<br>
     * @param e Event 
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse executeQuery (Event e) throws EventException {
    	EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BookingUtil command = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			
			String result =  command.executeQuery(event.getSql());
			eventResponse.setETCData("result", result);
			
			commit();
			

		} catch (EventException ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		} 
		return eventResponse;
    }
    

	/**
	 * seacrhDocPerformanceUserCheck 조회 이벤트 처리<br>
	 * event체크 <br>
	 * DocPerformance User 값 Check 함 <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse seacrhDocPerformanceUserCheck(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
//		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.seacrhDocPerformanceUserCheck(account.getUsr_id());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * seacrhManualBdrUserCheck 조회 이벤트 처리 ESM_BKG_0596<br>
	 * 로그인 User의 BDR권한 여부를 조회한다. 결과값:'Y'혹은 'N'<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse seacrhManualBdrUserCheck() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		try {
			String output_text = command.seacrhManualBdrUserCheck(account.getUsr_id());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 
     * bkg의 Charge화면에 Pricing의 계약 연결 변경 요청(ESM_BKG_0709_08)
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchAmdtSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		String ctrtType =event.getCtrtType();
		String ctrtNo= event.getCtrtNo();
		String bkgNo = event.getBkgNo();
		try {
			String amdt_seq = command.searchAmdtSeq(ctrtType,  ctrtNo, bkgNo);
			eventResponse.setETCData("amdt_seq", amdt_seq);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
     * Cancel BKG를 reactivate 한다..
     * @param e Event 
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse reactivateBooking (Event e) throws EventException {
    	try {
    		EsmBookingUtilEvent event 			= (EsmBookingUtilEvent) e;
			GeneralEventResponse eventResponse 	= new GeneralEventResponse();
    		GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
    		BLDocumentationCMBC blDocCmBC 		= new BLDocumentationCMBCImpl();
    		BkgCopManageBC 			copBC		= new BkgCopManageBCImpl();
    		CostAssignBC masBc 					= new CostAssignBCImpl();	
    		BookingARCreationBC invBc 			= new BookingARCreationBCImpl();
			BookingHistoryMgtBC historyBC 		= new BookingHistoryMgtBCImpl();	
    		BookingUtil command 				= new BookingUtil();
    		BkgBlNoVO bkgBlNoVO 				= new BkgBlNoVO();
			MasBkgComIfVO masBkgComIfVo 		= new MasBkgComIfVO();
			ARBkgInterfaceCreationVO bkgIfVo 	= new ARBkgInterfaceCreationVO();
			String bkgNo = event.getBkgNo();
			log.debug("reactivateBooking:"+bkgNo);    		
    		bkgBlNoVO.setBkgNo(bkgNo);
    		bkgBlNoVO = command.searchBkgBlNoVO(bkgBlNoVO);

    		//Activate Container 
    		blDocCmBC.activateBkgCntr(bkgBlNoVO, account);
    		//COP replan
    		copBC.reviveCopsByBkgRqst(bkgNo);
    		//BKG status change
    		receiptBC.reactBkgStatus(bkgNo);
//    		receiptBC.compFirm(bkgBlNoVO, account);
    		receiptBC.changeBkgStatus("F", bkgBlNoVO, false, account);
			//COA I/F
			masBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			masBkgComIfVo.setCostSrcSysCd("BKG");
			masBkgComIfVo.setIfRmk("reactivate");
			masBkgComIfVo.setCreUsrId(account.getUsr_id());
			masBkgComIfVo.setUpdUsrId(account.getUsr_id());			
			masBc.modifyMasCommonInterface(masBkgComIfVo);
			//INV I/F
			bkgIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			bkgIfVo.setBkgCorrNo(bkgBlNoVO.getCaNo());
			bkgIfVo.setUserId(account.getUsr_id());
			bkgIfVo.setManDivInd("B");
			invBc.interfaceBKGARInvoiceToINV(bkgIfVo);
			//History 추가			
			HistoryLineVO historyLineVO = new HistoryLineVO();
			historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
			historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
			historyLineVO.setBkgDocProcTpCd("BREACT");// booking firm for doc performance
			historyLineVO.setUiId("ESM_BKG_0079_01");
			historyLineVO.setCrntCtnt("Reactivate.");
			historyLineVO.setHisCateNm("Reactivate."); 
			historyBC.createBkgHistoryLine(historyLineVO, account);

			eventResponse.setETCData("isSuccess","Y");
			return eventResponse;
			
    	} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		}
    }
    /**
     * No Rate Status를 Firm 한다.
     * @param e Event 
     * @author Yang dong hun
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse modifyNoRtStsCd (Event e) throws EventException {
    	try{
    		EsmBookingUtilEvent event 			= (EsmBookingUtilEvent) e;
    		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
    		GeneralBookingReceiptBC receiptBC   = new GeneralBookingReceiptBCImpl();
    		BookingUtil command 				= new BookingUtil();
    		BkgBlNoVO bkgBlNoVO 				= new BkgBlNoVO();
    		BookingHistoryMgtBC historyBC 		= new BookingHistoryMgtBCImpl();
    		
    		bkgBlNoVO.setBkgNo(event.getBkgNo());
    		bkgBlNoVO = command.searchBkgBlNoVO(bkgBlNoVO);
    		
    		receiptBC.modifyNoRtStsCd(bkgBlNoVO, "F", account);
    		eventResponse.setETCData("isSuccess","Y");
    		
    		//히스토리 추가
    		HistoryLineVO historyLineVO = new HistoryLineVO();
			historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
			historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
			historyLineVO.setUiId("ESM_BKG_0079_01"); //화면 Booking creation
			historyLineVO.setCrntCtnt("F");
			historyLineVO.setHisCateNm("No Rate Status"); 
			historyBC.createBkgHistoryLine(historyLineVO, account);
    		
    		
    		return eventResponse;
    	} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		}
    }
    //수정 끝
    
	/**
	 * ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsHardCodingList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			List<BkgCstmsHrdCdgCtntVO> list = command.searchCstmsHardCodingList(event.getBkgCstmsHrdCdgCtntVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}    
	
	/**
	 * ESM_BKg_0079_01 : search<br>
	 *  B/L Confirm, B/L Issue 상태를 체크한다.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkBkgIssStatus(Event e) throws EventException {

		try{
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			BookingUtil command = new BookingUtil();
			EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
			
			String ret = command.checkBkgIssStatus(event.getBkgBlNoVO().getBkgNo());
			
			eventResponse.setETCData("BKG_ISS_STATUS",   ret);
			return eventResponse;
			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 *  ESM_BKG_0726 B/L Print User 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search0726BlprnUsr(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		String cfmFlg ="N";
		try {
			cfmFlg = command.search0726BlprnUsr(account);
			eventResponse.setETCData("cfmFlg",cfmFlg);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * existCustomsEntryCode 조회 이벤트 처리<br>
	 * existCustomsEntryCode 존재여부 판단 <br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse existCustomsEntryCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.existCustomsEntryCode(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VVD가 한국세관 Download 된 적 있는 지 조회.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKrCstmsDownload(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String cnt = command.searchKrCstmsDownload(event.getBkgTrunkVvd(),event.getPodCd());
			eventResponse.setETCData("kr_cstms_dl_cnt", cnt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * RfaSpotPricingAvailable 조회 이벤트 처리<br>
	 * 79-08 event 체크 
	 * RfaSpotPricingAvailable 유효성체크 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse rfaSpotPricingAvailable(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.rfaSpotPricingAvailable(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * n3rdPartyBlReqOfcAvailable 조회 이벤트 처리<br>
	 * 79-08 event 체크 
	 * n3rdPartyBlReqOfcAvailable 유효성체크 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse n3rdPartyBlReqOfcAvailable(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.n3rdPartyBlReqOfcAvailable(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * n3rdPartyBlReqAvailable 조회 이벤트 처리<br>
	 * 79-08 event 체크 
	 * n3rdPartyBlReqAvailable 유효성체크 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse n3rdPartyBlReqAvailable(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.n3rdPartyBlReqAvailable(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	
	
	/**
	 * searchCntrInfo 조회 이벤트 처리<br>
	 * ESM_Booking_UtilHTMLAction event 체크 
	 * searchCntrInfo 유효성체크 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			List<CntrInfoVO> list = command.searchCntrInfo(event.getBkgNo(),event.getCtrtNo());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * manageCntrCycNo 업데이트 이벤트 처리<br>
	 * ESM_Booking_UtilHTMLAction event 체크 
	 * manageCntrCycNo 유효성체크 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCntrCycNo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
//			begin();
			command.manageCntrCycNo(event.getCntrInfoVOs());
			eventResponse.setETCData("isSuccess","Y");
//			commit();
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BkgBlackCustomer 조회<br>
	 * BKG_BLACK_LIST 에 등록된 금지 Customer Name 을 포함하는 지 판단 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkBkgBlackCustomer(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.checkBkgBlackCustomer(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * BookingComboUtil의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYearCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		try {

			List<BkgComboVO> list = command.searchYearCombo();
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * BookingComboUtil의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {

			List<BkgComboVO> list = command.searchOfcCombo(event.getOfcCd()); 
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * BookingComboUtil의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHtsCodeDesc(Event e) throws EventException {

		try{
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			BookingUtil command = new BookingUtil();
			EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
			BkgHamoTrfVO bkgHamoTrfVO = new BkgHamoTrfVO();
			
			bkgHamoTrfVO = command.searchHtsCodeDesc(event.getHtsCd(),"H");
			if(bkgHamoTrfVO.getHamoCdDesc()!=null){
				eventResponse.setETCData("cd_desc",   bkgHamoTrfVO.getHamoCdDesc());
			}

			return eventResponse;
			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	
	/**
	 * POD가 West Africa Port 인지 확인<br>
	 * Hard Coding 테이블에 들옥된 Port를 대상으로 서아프리카인지 확인한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWestAfricaPod(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.searchWestAfricaPod(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * POD가 West Africa Port 인지 확인<br>
	 * Hard Coding 테이블에 들옥된 Port를 대상으로 서아프리카인지 확인한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgRoute(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		BkgRouteVO bkgRouteVO = new BkgRouteVO();
		try {
			bkgRouteVO = command.searchBkgRoute(event.getInputText());
			eventResponse.setETCData("por_cd", bkgRouteVO.getPorCd());
			eventResponse.setETCData("pol_cd", bkgRouteVO.getPolCd());
			eventResponse.setETCData("pod_cd", bkgRouteVO.getPodCd());
			eventResponse.setETCData("del_cd", bkgRouteVO.getDelCd());
			eventResponse.setETCData("por_cnt_cd", bkgRouteVO.getPorCd().substring(0, 2));
			eventResponse.setETCData("pol_cnt_cd", bkgRouteVO.getPolCd().substring(0, 2));
			eventResponse.setETCData("pod_cnt_cd", bkgRouteVO.getPodCd().substring(0, 2));
			eventResponse.setETCData("del_cnt_cd", bkgRouteVO.getDelCd().substring(0, 2));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * checkWordBlackList 조회<br>
	 * WORD_BLACK_LIST 에 등록된 금지 단어를 포함하는 지 판단 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkWordBlackList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.checkWordBlackList(event.getInputText1(),event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * checkChaCalHypoBlckList 조회<br>
	 * Charcoal, Calcium Hypochlorite Manufacturer가 있는지 체크 <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkChaCalHypoBlckList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String output_text = command.checkChaCalHypoBlckList(event.getInputText());
			eventResponse.setETCData("output_text", output_text);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse genOblSerNo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String serNo = command.genOblSerNo(event.getBkgNo());
			eventResponse.setETCData("serNo", serNo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse bkgInetBlOblSerNoAdd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			command.bkgInetBlOblSerNoAdd(event.getBkgNo(), event.getSerNo(), account);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchBkgInetBlOblSerNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			List<BkgInetBlPrnAuthVO> list = command.searchOblSerialNumber(event.getBkgNo(), null);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchBkgInetBlOblSerNoChecked(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			List<BkgInetBlPrnAuthVO> list = command.searchOblSerialNumber(event.getBkgNo(), "Y");
			if(list != null && list.size() > 0){
				eventResponse.setETCData("checked", "Y");
			}else{
				eventResponse.setETCData("checked", "N");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	   
 
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse bkgInetBlOblSerNoChecked(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		BookingHistoryMgtBC hisMgt = new BookingHistoryMgtBCImpl();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			begin();
			List<BkgInetBlPrnAuthVO> oldBl = command.bkgInetBlOblSerNoChecked(event.getBkgNo(), event.getSerNo(), account);
			hisMgt.bkgInetBlOblSerNoHistory(oldBl, event.getBkgNo(), event.getUiId(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * bkg_blck_list_mntr 테이블에 데이터 insert한다 <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse addBkgBlckListMntr(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String blckTpCd = event.getBlckTpCd();
			BkgBlckListMntrVO bkgBlckListMntrVO = new BkgBlckListMntrVO();
			bkgBlckListMntrVO.setBkgNo(event.getBkgNo());
			bkgBlckListMntrVO.setBlckKwTpCd(event.getBlckTpCd());
			bkgBlckListMntrVO.setBlckKwNm(event.getBlckKwNm());
			bkgBlckListMntrVO.setBlckKwTpCd(event.getBlckTpCd());
			bkgBlckListMntrVO.setCreUsrId(account.getUsr_id());
			bkgBlckListMntrVO.setUpdUsrId(account.getUsr_id());
			
			//해당 키워드가 어디서 컬럼에서 걸린 것인지 구분하기 위해
			if("BLA_RMK".equalsIgnoreCase(blckTpCd)){
				bkgBlckListMntrVO.setBlckKwTpCd("BLA");
				bkgBlckListMntrVO.setInterXterRmkKwNm(event.getBlckKwNm());
			}
			
			if("SAN_CUST".equalsIgnoreCase(blckTpCd)){
				bkgBlckListMntrVO.setBlckKwTpCd("SAN");
				bkgBlckListMntrVO.setCustDescKwNm(event.getBlckKwNm());
			}
			if("SAN_RMK".equalsIgnoreCase(blckTpCd)){
				bkgBlckListMntrVO.setBlckKwTpCd("SAN");
				bkgBlckListMntrVO.setInterXterRmkKwNm(event.getBlckKwNm());
			}
			if("YEL_RMK".equalsIgnoreCase(blckTpCd)){
				bkgBlckListMntrVO.setBlckKwTpCd("YEL");
				bkgBlckListMntrVO.setInterXterRmkKwNm(event.getBlckKwNm());
			}
			if("YEL_CUST".equalsIgnoreCase(blckTpCd)){
				bkgBlckListMntrVO.setBlckKwTpCd("YEL");
				bkgBlckListMntrVO.setCustDescKwNm(event.getBlckKwNm());
			}
			if("CAL_RMK".equalsIgnoreCase(blckTpCd)){
				bkgBlckListMntrVO.setBlckKwTpCd("CAL");
				bkgBlckListMntrVO.setInterXterRmkKwNm(event.getBlckKwNm());
			}
			if("CAL_CUST".equalsIgnoreCase(blckTpCd)){
				bkgBlckListMntrVO.setBlckKwTpCd("CAL");
				bkgBlckListMntrVO.setCustDescKwNm(event.getBlckKwNm());
			}
			
			begin();
			command.addBkgBlckListMntr(bkgBlckListMntrVO);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	   /**
     *  India SAC 코드 데이터를 조회한다.
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchIdaSacMasterInfo(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
        try {
            BkgIdaSacMstVO data = command.searchIdaSacMasterInfo(event.getIdaSacCd());
            if( data != null ){
                eventResponse.setETCData( data.getColumnValues());
            }
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    

	/**
	 * Por_cd Check
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchPorCdCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		try {
			String checkYN = command.searchPorCdCheck(event.getPorCd());
			eventResponse.setETCData("checkYN", checkYN);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		} 
		return eventResponse;
	}
    
  
	/**
	 * EsmBookingUtilEvent : <br>
	 * EDI 수신 메시징 에 대한 처리 테스트.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadCstmsRcvMsgTest(Event e) throws EventException {
		log.info("SC [loadCstmsRcvMsg] Start---------------------");
		EsmBookingUtilEvent event = (EsmBookingUtilEvent) e;
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		ManifestListDownloadBC command2 = null;
		try {
			begin();
			
			log.debug( "\n  loadCstmsRcvMsgTest: 1 "
			         + "\n  cnt_cd:"    + event.getCntCd()
					 + "\n  commit_yn:" + event.getCommitYn()
					 + "\n  flat_file:" + event.getFlatFile()
					 );
			
			if(event.getFlatFile() == null ||  "".equals(event.getFlatFile()) || event.getFlatFile().toUpperCase().indexOf("TEST") >= 0){
				eventResponse.setETCData("result", "Test OK.");
				return eventResponse;
			}
			// 이벤트별 Impl생성
			if (event.getCntCd().equalsIgnoreCase("US")) {
				
				// 미세관 응답메세지 수신.
				command = new UsaCustomsTransmissionBCImpl();
				UsaRcvMsgVO usaRcvMsgVO = new UsaRcvMsgVO();
				usaRcvMsgVO.setRcvMsg(event.getFlatFile());
				UsaRcvMsgVO rcvVO = (UsaRcvMsgVO) command.loadCstmsRcvMsg(usaRcvMsgVO);
				// try catch 중첩허용 타모듈 호출
				try {
					
					// CFlag가 Y -> N으로 변경시
					List<BkgCstmsAdvIbdVO> bkgCstmsAdvIbdVOs = rcvVO.getBkgCstmsAdvIbdVOs();
					if (bkgCstmsAdvIbdVOs != null) {
						ManifestListDownloadBC manifestBC = new UsaManifestListDownloadBCImpl();
						manifestBC.modifyIbdCstmsClrCngFlg(bkgCstmsAdvIbdVOs);
					}
				} catch (Exception ce) { 
					log.error("CFlag  Y -> N으로 변경");
				}
				// Cargo Release 호출
//				List<CstmsClrVO> cstmsClrs = rcvVO.getCstmsClrVOs();
//				if (cstmsClrs != null) {
//					log.info("Cargo Release Start");
//					CargoReleaseOrderBC command3 = new CargoReleaseOrderBCImpl();
//					for (int k = 0; k < cstmsClrs.size(); k++) {
//						// try catch 중첩허용 타모듈 호출
//						try {
//							command3.setupFocByCstms(cstmsClrs.get(k));
//						} catch (Exception ce) {
//							log.error("Cargo Release Error");
//						}
//					}
//				}
				// Hold Notice('PH', 'CF') 호출
//				List<CstmsHldVO> cstmsHlds = rcvVO.getCstmsHldVOs();
//				if (cstmsHlds != null) {
//					HoldNoticeBC command3 = new HoldNoticeBCImpl();
//					BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
//					for (int k = 0; k < cstmsHlds.size(); k++) {
//						// try catch 중첩허용 타모듈 호출
//						try {
//							// 1. Hold Notice
//							List<BkgNtcHisVO> bkgNtcHisVOs = command3
//									.createCstmsHld(cstmsHlds.get(k));
//							// 2. Register Notice History
//							bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs,
//									"UBIZ2HJS_ALPSBKG_T_AMS_ACK");
//						} catch (Exception ce) {
//							log.error("Hold Notice('PH', 'CF') Error");
//						}
//					}
//				}
				
				// Warning 이벤트 Send
//				List<CstmsHldVO> cstmsHldSends = rcvVO.getCstmsHldSendVOs();
//				if (cstmsHldSends != null) {
//					HoldNoticeBC command3 = new HoldNoticeBCImpl();
//					for (int k = 0; k < cstmsHldSends.size(); k++) {
//						// try catch 중첩허용 타모듈 호출
//						try {
//							// 1. Warning 이벤트 Send
//							String gubun = SubSystemConfigFactory.get("BKG.MFT.SERVICE.MODE");
//							if (gubun == null)gubun = "N";
//							// TEST 일때는 GW, Alert 전송하지 않음. (ACE M1 테스트용)
//							if (!gubun.equals("TEST")) {
//								command3.sendAmsNtcToObStaff(cstmsHldSends.get(k));
//								command3.sendAmsNtcToBkgStaff(cstmsHldSends.get(k));
//							}
//	
//						} catch (Exception ce) {
//							log.error("Warning 이벤트 Send Error");
//						}
//					}
//				}
			} else 	if (event.getCntCd().equalsIgnoreCase("KR")) {
				command = new KorCustomsTransmissionBCImpl();
				KorRcvAckMsgVO korRcvAckMsgVO = new KorRcvAckMsgVO();
				korRcvAckMsgVO.setFlatFile(event.getFlatFile());
				command.loadCstmsRcvMsg(korRcvAckMsgVO);
			} else 	if (event.getCntCd().equalsIgnoreCase("CA")) {

				String sDiv = "";
				if (event.getFlatFile().indexOf("\r\n") != -1)
				{
					sDiv = "\r\n";
				}
				else
				{
					sDiv = "\n";
				}
				
				String sUsrId = "CANCUS_ACK";
				String[] arrRcvMsg = event.getFlatFile().split(sDiv);
				BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO = new BkgCstmsAdvRcvLogVO();
				bkgCstmsAdvRcvLogVO.setCntCd(CountryCode.CA);
				bkgCstmsAdvRcvLogVO.setIoBndCd("I");
				/**
				 * Proxy에서 DAO를 직접 호출할 수 있으면 여기서 사용하면 좋은데...<br>
				 * Proxy는 Action Class로 사용한다고 해서 event에 vo객체를 담는 용도로만 사용함.
				 * 첫라인 샘플 : CANCUSRCV82420100301002405
				 */
				bkgCstmsAdvRcvLogVO.setRcvDt(arrRcvMsg[0].substring(12));
				bkgCstmsAdvRcvLogVO.setRcvMsgTpId(arrRcvMsg[0].substring(9, 12));
				bkgCstmsAdvRcvLogVO.setCreUsrId(sUsrId);
				// 수신로그상세
				List<BkgCstmsAdvRcvLogDtlVO> bkgCstmsAdvRcvLogDtlVOs = new ArrayList<BkgCstmsAdvRcvLogDtlVO>();
				// 송신로그
				BkgCstmsAdvSndLogVO bkgCstmsAdvSndLogVO = new BkgCstmsAdvSndLogVO();
				for (int i = 0; i < arrRcvMsg.length; i++)
				{
					BkgCstmsAdvRcvLogDtlVO bkgCstmsAdvRcvLogDtlVO = new BkgCstmsAdvRcvLogDtlVO();
					bkgCstmsAdvRcvLogDtlVO.setCntCd(CountryCode.CA);
					bkgCstmsAdvRcvLogDtlVO.setIoBndCd("I");
					bkgCstmsAdvRcvLogDtlVO.setRcvDt(bkgCstmsAdvRcvLogVO.getRcvDt());
					bkgCstmsAdvRcvLogDtlVO.setRcvMsgDtlSeq("" + (i + 1));
					bkgCstmsAdvRcvLogDtlVO.setMsgDesc(arrRcvMsg[i]);
					bkgCstmsAdvRcvLogDtlVO.setCreUsrId(sUsrId);
					bkgCstmsAdvRcvLogDtlVOs.add(bkgCstmsAdvRcvLogDtlVO);
					
					//BAPLIE Response 
					if (arrRcvMsg[i].startsWith("$$$MSGSTART"))
					{
						bkgCstmsAdvRcvLogVO.setRcvMsgTpId("BRC");
						break;
					}
					// 
					if (arrRcvMsg[i].startsWith("BKC"))
					{
						// 전송 시 BKG_CSTMS_ADV_SND_LOG의  CRR_BAT_NO
						bkgCstmsAdvRcvLogVO.setCrrBatNo(arrRcvMsg[i]);
					}
					// 컬럼[0]:값[1]
					String[] sValue = arrRcvMsg[i].split(":");
					if (arrRcvMsg[i].startsWith("CONTROL NO:"))
					{
						// BKG_CSTMS_ADV_BL占쏙옙 CSTMS_ACK_KEY_NO
						bkgCstmsAdvRcvLogVO.setCstmsBatNo(sValue[1]);
					}
					if ("997".equals(bkgCstmsAdvRcvLogVO.getRcvMsgTpId()))
					{
						if (arrRcvMsg[i].startsWith("RESPONSE:"))
						{
							bkgCstmsAdvRcvLogVO.setCndAckRcvId(sValue[1].split("-")[0]);
						}
						if (arrRcvMsg[i].startsWith("GROUP RESPONSE:"))
						{
							bkgCstmsAdvSndLogVO.setAckRcvTpId(sValue[1]);
						}
						if (arrRcvMsg[i].startsWith("NO OF INCLUDED:"))
						{
							bkgCstmsAdvSndLogVO.setAckSndKnt(sValue[1]);
						}
						if (arrRcvMsg[i].startsWith("NO OF RECEIVED:"))
						{
							bkgCstmsAdvSndLogVO.setAckRcvKnt(sValue[1]);
						}
						if (arrRcvMsg[i].startsWith("NO OF ACCEPTED:"))
						{
							bkgCstmsAdvSndLogVO.setAckAcptKnt(sValue[1]);
						}
					}
					//997은 A6A,A6,ATA같음 824는 A6A,A6이고 350은 ATA응답(824에 해당함)
					else if ("824".equals(bkgCstmsAdvRcvLogVO.getRcvMsgTpId()) ||"350".equals(bkgCstmsAdvRcvLogVO.getRcvMsgTpId()))
					{
						if (arrRcvMsg[i].startsWith("PURPOSE CODE:"))
						{
							if ("350".equals(bkgCstmsAdvRcvLogVO.getRcvMsgTpId())){
								bkgCstmsAdvRcvLogVO.setCndAckSubCd("06");//350: ATA 긍정 문서 -PURPOSE CODE가 null로 수신 됨.
							}else{
								bkgCstmsAdvRcvLogVO.setCndAckSubCd(sValue[1].split("-")[0]);
							}
						}
						if (arrRcvMsg[i].startsWith("TECHNICAL ERROR:"))
						{
							bkgCstmsAdvRcvLogVO.setCstmsRjctMsg(sValue[1].split("-")[0]);
						}
						if (arrRcvMsg[i].startsWith("ERROR NOTES:"))
						{
							bkgCstmsAdvRcvLogVO.setCndAckErrNoteDesc(sValue[1]);
						}
					}
				}
				// 송신로그 업데이트를 위한 리스트 (원래는 단건인데 모델상으로 파라메터가 List이기 때문에 List로 넘김)
				List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndLogVOs = new ArrayList<BkgCstmsAdvSndLogVO>();
				if (bkgCstmsAdvRcvLogVO.getCrrBatNo() != null && !"".equals(bkgCstmsAdvRcvLogVO.getCrrBatNo()))
				{
					bkgCstmsAdvSndLogVO.setCntCd(CountryCode.CA);
					bkgCstmsAdvSndLogVO.setIoBndCd("I");
					bkgCstmsAdvSndLogVO.setCrrBatNo(bkgCstmsAdvRcvLogVO.getCrrBatNo());
					bkgCstmsAdvSndLogVOs.add(bkgCstmsAdvSndLogVO);
				}
				// 수신로그 등록을 위한 리스트 (원래는 단건인데 모델상으로 파라메터가 List이기 때문에 List로 넘김)
				List<BkgCstmsAdvRcvLogVO> bkgCstmsAdvRcvLogVOs = new ArrayList<BkgCstmsAdvRcvLogVO>();
				bkgCstmsAdvRcvLogVOs.add(bkgCstmsAdvRcvLogVO);
				// VO Object Set
				CndCstmsRcvLogVO cndCstmsRcvLogVO = new CndCstmsRcvLogVO();
				cndCstmsRcvLogVO.setBkgCstmsAdvRcvLogDtlVOs(bkgCstmsAdvRcvLogDtlVOs);
				cndCstmsRcvLogVO.setBkgCstmsAdvRcvLogVOs(bkgCstmsAdvRcvLogVOs);
				cndCstmsRcvLogVO.setBkgCstmsAdvSndLogVOs(bkgCstmsAdvSndLogVOs);
				
				//BAPLIE Response Set
				cndCstmsRcvLogVO.setRcvMsg(event.getFlatFile()); 
				if ( "BRC".equals(bkgCstmsAdvRcvLogVO.getRcvMsgTpId())){
					cndCstmsRcvLogVO.setRcvMsgTpId(bkgCstmsAdvRcvLogVO.getRcvMsgTpId());
				} else {
					cndCstmsRcvLogVO.setRcvMsgTpId("");
				}
				
				// Canada 수신
				command = new CndCustomsTransmissionBCImpl();
				CstmsRcvLogVO cstmsRcvLogVO = cndCstmsRcvLogVO;
				command.loadCstmsRcvMsg(cstmsRcvLogVO);
				//BAPLIE HoldNotice 제외
				if ( !"BRC".equals(((CndCstmsRcvLogVO)cstmsRcvLogVO).getRcvMsgTpId())){				
					command2 = new CndManifestListDownloadBCImpl();
					
					//@결과 업데이트
					CndCstmsRcvLogVO cndCstmsRcvLogVO2 = (CndCstmsRcvLogVO) command2.loadCstmsRcvMsg(cstmsRcvLogVO);
	
					
					/*
					 * Hold Notice 부분
					// Warning 이벤트 Send
					List<CstmsHldVO> cstmsHldSends = cndCstmsRcvLogVO2.getCstmsHldSendVOs();
					if (cstmsHldSends != null) {
						HoldNoticeBC command3 = new HoldNoticeBCImpl();
						for (int k = 0; k < cstmsHldSends.size(); k++) {
							// try catch 중첩허용 타모듈 호출
							try {
								// 1. Warning 이벤트 Send
								command3.sendAmsNtcToObStaff(cstmsHldSends.get(k));
								command3.sendAmsNtcToBkgStaff(cstmsHldSends.get(k));
							} catch (Exception ce) {
								log.error("Warning 이벤트 Send Error");
							}
						}
					}
					 */				
				}
				
				
			}

			if("Y".equals(event.getCommitYn())){
				commit();
			}else{
				rollback();//반복 테스트를 위해 rollback한다.
			}
			
			eventResponse.setETCData("result", "Customs Receive Message successfully processed.");
		} catch (EventException ex) {
			log.error("EventException : " + ex.getMessage());
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("Exception : " + ex.getMessage());
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		log.info("SC [loadCstmsRcvMsg] End---------------------");
		return eventResponse;
	}

    
        
}