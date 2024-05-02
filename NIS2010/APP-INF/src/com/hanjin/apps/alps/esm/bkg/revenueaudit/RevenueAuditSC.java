/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RevenueAuditSC.java
*@FileTitle : RDN Issuance by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.19 이승준
* 1.0 Creation
=========================================================
History
* 2011.01.06 이정수 [CHM-201007610] RAS 기능 보완 및 Logic 보완 6
* 2011.04.13 이일민 [CHM-201109862-01] [BKG/DOC] BKG Creation Charge화면의 Self Audit기능 Transaction Time 변경 요청
* 2011.04.14 이일민 [CHM-201109862-01] [BKG/DOC] BKG Creation Charge화면의 Self Audit기능 Transaction Time 변경 요청 - 원복
* 2011.05.12 이일민 [CHM-201109862-01] [BKG/DOC] BKG Creation Charge화면의 Self Audit기능 Transaction Time 변경 요청 - BackEndJob
* 2012.04.26 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사
* 2012.05.24 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사
* 2012.06.27 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
* 2012.08.29 조정민 [CHM-201219696] [BKG/DOC - Revenue Audit System] RDN Issuance by Auditor 화면에 기능추가
* 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가 
* 2012.11.02 김진주 [CHM-201220005] [BKG/DOC - Revenue Audit System] S/C B/L Surcharge 자동심사 시스템 보완 요청
* 2012.12.24 김진주 [CHM-201220395-04] Add-on management T/F
* 2013.02.04 김진주 [CHM-201322626] [BKG/DOC - Revenue Audit System] SZPBB, HKGBB의 DHF 심사로직 추가
* 2013.02.12 김진주 [CHM-201322816] [BKG/DOC - Revenue Audit System] RDN Status 추가
* 2013.05.03 김진주 [CHM-201323001] [BKG/DOC - Revenud Audit System] S/C 적용 B/L 자동심사기능 개발 :: DHF 예외로직 삭제
* 2013.05.10 김진주 [CHM-201323001] [BKG/DOC - Revenud Audit System] S/C 적용 B/L 자동심사기능 개발 
* 2013.07.30 김진주 [CHM-201325469] [BKG/DOC - Revenue Audit System] COD BKG Inquiry 기능 개발 요청
* 2013.10.01 김진주 [CHM-201326784] [BKG/DOC - Revenue Audit Syste] Error B/L Inquiry 기능의 Manual Settle(OFC) 기능 로직 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBC;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBCImpl;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0426Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0427Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0565Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0712Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg1408Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg5002Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration.RevenueDebitNoteDBDAO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.AttachmentVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RevDrNoteVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrAmtVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNoteVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesPerformanceVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesStatusSummaryVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesStatusVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltSearchRDNIssueMailingListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.UnStlRdnReportVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBC;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBCImpl;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0151Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0256Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0263Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0564Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0569Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0698Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0701Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0705Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1049Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1055Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1079Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1080Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1092Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1129Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1401Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1402Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1403Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1404Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1405Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1406Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1407Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1409Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1420Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1421Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1422Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1423Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1424Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1425Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1426Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1427Event;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.AwkwardBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.BayPlanVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.BKGvsBayPlanVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.CODBookingListOutVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.DiversionCAVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.EqSubErrSchVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IhcBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IndiaDthBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IranDthBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.MultiRateBkgList1VO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.MultiRateBkgListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.OblSurrenderForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.NonAutoratedChargeVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RetroactiveBLStatusListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RlstSearchSelfAuditListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCNTRQtyDiscrepancyListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCommodityAndRouteListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByHangerInstallationListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchChargeFilteringListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchRetroActFilterVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchItemListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchTypeListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchBLListbyAuditorVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchDiffAmountVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchStatusReportVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.ScNoteConversionVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.SearchStopOffBkgListforAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.TxsBkgListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UmchErrBlReportVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchSettlementListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.WscBkgListForAuditSchVO;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBC;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBCImpl;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComBakEndJbVO;

/**
 * NIS2010-RevenueAudit Business Logic ServiceCommand - NIS2010-RevenueAudit 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Seung Jun Lee
 * @see RevenueDebitNoteDBDAO
 * @since J2EE 1.4
 */

public class RevenueAuditSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * RevenueAudit system 업무 시나리오 선행작업<br>
	 * ESM_BKG_0426업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("RevenueAuditSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * RevenueAudit system 업무 시나리오 마감작업<br>
	 * ESM_BKG_0426 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("RevenueAuditSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-RevenueAudit system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		//esm_bkg_0426 RDN Issuance by Regional Group start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg0426Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRDNList(e);
			}
			//search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRDNList(e);
			}
			//search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRDNList(e);
			}
			//search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRDNList(e);
			}
			//search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchRDNList(e);
			}
			// 메일 대상자 정보 가져오기, 2009-10-16  김대호
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchRDNIssueMailingList(e);
			}
			// 메일 일괄 발송, 2009-10-16  김대호
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = doMailRDNIssue(e);
			}
			//create, issue
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createRDNbyIssueOffice(e);
			}
			//modify
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = modifyRDNbyIssueOffice(e);
			}
			//issue
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = issueRDNbyIssueOffice(e);
			}
			//reissue
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = reissueRDNbyIssueOffice(e);
			}
			//revise
			else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = reviseRDNbyIssueOffice(e);
			}
			//cancel
			else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = cancelRDNbyIssueOffice(e);
			}
			//settle
			else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) {
				eventResponse = settleRDNbyIssueOffice(e);
			}
			//cancel(Valid)
			else if (e.getFormCommand().isCommand(FormCommand.MULTI08)) {
				eventResponse = validCancelRDNbyIssueOffice(e);
			}else{
				eventResponse = initRDNIssuanceByAuditor(e);
			}
		}
		//esm_bkg_0426 RDN Issuance by Regional Group end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//esm_bkg_0712 RDN Receipt by Office start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg0712Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRDNReceiptList(e);
			}
			//search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRDNReceiptList(e);
			}
			//search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRDNReceiptList(e);
			}
			//search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRDNReceiptList(e);
			}
			//search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchRDNReceiptList(e);
			}
			//search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchRDNReceiptList(e);
			}
			//modify
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyRDNbyReceiptOffice(e);
			}
			//accept
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = acceptRDNbyReceiptOffice(e);
			}
			//revise request
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = reviseRequestRDNbyReceiptOffice(e);
			}
			//cancel request
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = cancelRequestRDNbyReceiptOffice(e);
			}
			
		}
		//esm_bkg_0712 RDN Receipt by Office end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//esm_bkg_0427 RDN Status Inquery start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg0427Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRDNStatusList(e);
			}else{
				eventResponse = initRDNIssuanceByAuditor(e);
			}
		}
		//esm_bkg_0427 RDN Status Inquery end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//esm_bkg_0565 RDN Performance Report start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg0565Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRDNPerformanceList(e);
			}else{
				eventResponse = initMismatchBLStatusReport(e);
			}
		}
		//esm_bkg_0565 RDN Performance Report end
		//////////////////////////////////////////////////////////////////////////////////
		
		//esm_bkg_0256 Unmatch B/L Inquiry by Regional Group start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg0256Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUnmatchBLListbyAuditor(e);
			// filtered B/L
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // backendjob. 2
				eventResponse = searchFilteredBkgCountbyAuditor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // It gets a status of backendjob. 2
				eventResponse = comBakEndJbVO(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){   // It returns a result. 3
				eventResponse = comBackEndJbGetResult(e);
			}
			//settle
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = settleUnmatchBL(e);
			}
			//modify
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = modifyUnmatchBL(e);
			}
			//re audit
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = reauditUnmatchBL(e);
			}
			//settle
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = settleUnmatchBLByAuditor(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)){	// backendjob status
				eventResponse = searchReauditBackEndJobStatus(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)){  // backendjob result
				eventResponse = searchReauditBackEndJobResult(e);
			} else{
				eventResponse = initMismatchBLInquiryByAuditor(e);
			}
			
		}
		//esm_bkg_0256 Unmatch B/L Inquiry by Regional Group end
		//////////////////////////////////////////////////////////////////////////////////

		
		//esm_bkg_1049 Unmatch Details start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg1049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // 조회
				eventResponse = searchUnmatchItemList(e);
			}
		}
		//esm_bkg_1049 Unmatch Details end
		
		//esm_bkg_1055 Unmatch Description start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg1055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // 조회
				eventResponse = searchUnmatchTypeList(e);
			}
		}
		//esm_bkg_1055 Unmatch Description end

		//esm_bkg_0151 charge filtering start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg0151Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchChargeFilteringList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//It gets a status of backendjob. 2
				eventResponse = comBakEndJbVO(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){//It returns a result. 3
				eventResponse = comBackEndJbSearchList(e);
			}else{
				eventResponse = initChargeFiltering(e);
			}
		}
		//esm_bkg_0151 charge filtering end
		//////////////////////////////////////////////////////////////////////////////////

		//esm_bkg_1092 audit by commodity and route start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg1092Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchAuditByCommodityAndRouteList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//It gets a status of backendjob. 2
				eventResponse = comBakEndJbVO(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){//It returns a result. 3
				eventResponse = comBackEndJbSearchList(e);
			}else{
				eventResponse = initAuditByCommodityAndRoute(e);
			}
		}
		//esm_bkg_1092 audit by commodity and route end
		//////////////////////////////////////////////////////////////////////////////////
		
		//esm_bkg_1079 Audit by CNTR Qty Discrepancy
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg1079Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAuditByCNTRQtyDiscrepancyList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageAuditByCNTRQtyDiscrepancyList(e);
			}else{
				eventResponse = initAuditByCNTRQtyDiscrepancyList(e);
			}
		}
		//esm_bkg_1079 Audit by CNTR Qty Discrepancy
		//////////////////////////////////////////////////////////////////////////////////

		if (e.getEventName().equalsIgnoreCase("EsmBkg1401Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAwkwardBKGListoforAudit(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAwkwardBKGvsBayPlanList(e);
			}else {
				eventResponse = initAwkwardBKGListoforAudit(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmBkg1406Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIhcBKGListforAudit(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
//				eventResponse = manageAwkwardCargoDicrepancyList(e);
			}else{
				eventResponse = initIhcBKGListforAudit(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmBkg1407Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCtrtNoteConversionListByRule(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
//				eventResponse = manageAwkwardCargoDicrepancyList(e);
			}else{
				eventResponse = initCtrtNoteInquiryByRule(e);
			}
		}
		
		//esm_bkg_1402 Retroactive B/L Filtering
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg1402Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRetroactBLFilterList(e);
			}else{
				eventResponse = initRetroactiveBLFiltering(e);
			}
		}
		//esm_bkg_1402 Retroactive B/L Filtering
		//////////////////////////////////////////////////////////////////////////////////
		
		//esm_bkg_1404 TXS BKG List for Audit
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg1404Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTxsBkgListForAudit(e);
			}else{
				eventResponse = initTxsBkgListForAudit(e);
			}
		}
		
		//esm_bkg_1422 WSC BKG List for Audit
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg1422Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWscBkgListForAudit(e);
			}else{
				eventResponse = initWscBkgListForAudit(e);
			}
		}
		
		//esm_bkg_1423 India DTH BKG List for Audit
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg1423Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIndiaDthBKGListforAudit(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
//				eventResponse = manageAwkwardCargoDicrepancyList(e);
			}else{
				eventResponse = initIndiaDthBKGListforAudit(e);
			}
		}
		
		//esm_bkg_1424 Iran DTH BKG List for Audit
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg1424Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIranDthBKGListforAudit(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
//				eventResponse = manageAwkwardCargoDicrepancyList(e);
			}else{
				eventResponse = initIranDthBKGListforAudit(e);
			}
		}
		
		//esm_bkg_1080 Audit by Hanger Installation
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg1080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAuditByHangerInstallationList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageAuditByHangerInstallationList(e);
			}else{
				eventResponse = initAuditByHangerInstallationList(e);
			}
		}
		//esm_bkg_1080 Audit by Hanger Installation
		//////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////
		
		//esm_bkg_0705 COD BKG Inquiry
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg0705Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCODBookingList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDiversionCAList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCodBookingList(e);
			}else{
				eventResponse = initCodBookingList(e);
			}
		}

		//esm_bkg_0263 Freight & Charge Audit start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg0263Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSelfAuditListBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSelfAuditList(e);
	        }
		}
		//esm_bkg_0263 Freight & Charge Audit end
		//////////////////////////////////////////////////////////////////////////////////
		
		//esm_bkg_0701 Unmatch B/L Inquiry by Office start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg0701Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUnmatchBLListbyRegionalOffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {// backendjob. 1
				eventResponse = searchFilteredBkgCountbyRegionalOffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {//It gets a status of backendjob. 2
				eventResponse = comBakEndJbVO(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){//It returns a result. 3
				eventResponse = comBackEndJbGetResult(e);
			}
			//settle
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = settleOfficeUnmatchBL(e);
			}
			//modify
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = modifyUnmatchBLRegionalOffice(e);
			}
			//re audit
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = reauditUnmatchBL(e);
			}
			//settle
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = settleUnmatchBLByOffice(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)){	// backendjob status
				eventResponse = searchReauditBackEndJobStatus(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)){  // backendjob result
				eventResponse = searchReauditBackEndJobResult(e);
			} else{
				eventResponse = initMismatchBLInquiryByAuditor(e);
			}
		}
		//esm_bkg_0701 Unmatch B/L Inquiry by Office end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//esm_bkg_0698 Diff Amount Details start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg0698Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUnmatchItemDetailList(e);
			}
	
		}
		//esm_bkg_0698 Diff Amount Details end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//esm_bkg_0564 Un-match B/L Status Report start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg0564Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUnmatchBLStatusList(e);
			}else{
				eventResponse = initMismatchBLStatusReport(e);
			}
	
		}	
		//esm_bkg_0569 Error B/L Settlement Report start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg0569Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUnmatchBLSettlementList(e);
			}else{
				eventResponse = initMismatchBLStatusReport(e);
			}
	
		}
		//esm_bkg_1403 Retroactive B/L Status Report start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg1403Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRetroactiveBlStatusList(e);
			}else{
				eventResponse = initMismatchBLStatusReport(e);
			}
	
		}
		//esm_bkg_0569 Error B/L Settlement Report end
		//////////////////////////////////////////////////////////////////////////////////
		
		//esm_bkg_1129 EQ. Sub. Inquiry
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg1129Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAuditByEqSubErrList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageAuditByEqSubErrList(e);
			}else{
				eventResponse = initAuditByEqSubErrList(e);
			}
		}
		//esm_bkg_1129 EQ. Sub. Inquiry
		//////////////////////////////////////////////////////////////////////////////////
		
		
		// Stop Off BKG List for Audit 조회 
		if (e.getEventName().equalsIgnoreCase("EsmBkg1405Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStopOffBkgListforAudit(e);
			}
		}
		
		// Evidence (File Attach) Popup
		if(e.getEventName().equalsIgnoreCase("EsmBkg1408Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAttachmentList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAttachment(e);
			}
		}
		
		// Bay Plan Popup
		if(e.getEventName().equalsIgnoreCase("EsmBkg1409Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBayPlanByBooking(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmBkg1420Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOblSurrenderForAudit(e);
			}else {
				eventResponse = initOblSurrenderForAudit(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmBkg1421Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNonAutoratedChargeForAudit(e);
			}else {
				eventResponse = initNonAutoratedChargeForAudit(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmBkg1425Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUnmatchBLAgingList(e);
			}else{
				eventResponse = initUnmatchBLAgingList(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmBkg1426Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMultiRateBkgList(e);
			}else{
				eventResponse = initMultiRateBkgList(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmBkg1427Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMultiRateBkgList_1(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {	// Save
				eventResponse = manageMultiRateBkgList_1(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	// Confirm
				eventResponse = confirmMultiRateBkgList_1(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {	// Release
				eventResponse = releaseMultiRateBkgList_1(e);
			} else {
				eventResponse = initMultiRateBkgList_1(e);
			}
		}
		
		if(e.getEventName().equalsIgnoreCase("EsmBkg5002Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUnSettledRdnAgingList(e);
			}else{
				eventResponse = initUnSettledRdnAgingList(e);
			}
		}
		
		return eventResponse;
	}
	
	//esm_bkg_0426 RDN Issuance by Regional Group start
	//////////////////////////////////////////////////////////////////////////////////
	
    /**
     * ESM_BKG_0426, ESM_BKG_0427 : Open<br>
     * RDN Issuance by Auditor 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initRDNIssuanceByAuditor(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BkgComboVO combovo = null;    
        RASCommonBC command = new RASCommonBCImpl();
        RevenueDebitNoteBC command1 = new RevenueDebitNoteBCImpl();
        RsltCdListVO custVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null; 
        String riss_flg = null;

        try{
            // RHQ
        	//comboUtil = new BookingUtil();
        	combovo = new BkgComboVO();
			combovo.setDesc("All");
			combovo.setVal("All");
        	custVo = new RsltCdListVO();
        	custVo.setEtc2("");
            customData = command.searchRasOrganizationList(custVo);
            eventResponse.setCustomData("rhq", customData);

            // Resp
        	
            custVo.setRhqSet("resp");
            customData = command.searchRasOrganizationList(custVo);
            eventResponse.setCustomData("resp", customData);
            
            if (e.getEventName().equalsIgnoreCase("EsmBkg0426Event")) {
                // Discrepancy Kind 1
                customData = command.searchBkgRevUmchTpList(new RsltCdListVO());
                eventResponse.setCustomData("discrepancyKind", customData);
            	// Discrepancy Kind 3
                codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01567", 0);
                eventResponse.setCustomData("rdnIssRsnCd", codeInfos);
                //Re-issue 기능을 사용 가능한 ID인지 체크
                riss_flg =  command1.checkReissueAvailableUser(account);
                if(riss_flg != null)
                	eventResponse.setETCData("riss_flg",riss_flg);
                else
                	eventResponse.setETCData("riss_flg","N");
            }
        	// Audit Tool 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02371", 0);
            eventResponse.setCustomData("auditTool", codeInfos);
            //Contract Type
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("contractType", codeInfos);
            // Discrepancy Kind 1
            customData = command.searchBkgRevUmchTpList(new RsltCdListVO());
            eventResponse.setCustomData("discrepancyKind", customData);
            // RDN Kind
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD03402", 0);
            eventResponse.setCustomData("rdnKind", codeInfos);
     
            
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_BKG_0426 : Retrieve <br>
	 * RDN Issuance by Regional Group 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDNList(Event e) throws EventException {
			

		EsmBkg0426Event event = (EsmBkg0426Event) e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		
		
		//컨테이너 vo
		RevDrNoteVO cVo = new RevDrNoteVO();
		//searchGubun 1:note, 2:amt
		String searchGubun = event.getRevDrNoteVO().getSearchGubun();
			
		//RDN List 
		List<RsltBkgRevDrNoteVO> rsltBkgRevDrNoteVOList = new ArrayList<RsltBkgRevDrNoteVO>();
		//AMT List
		List<RsltBkgRevDrAmtVO> rsltBkgRevDrAmtVOList 	= new ArrayList<RsltBkgRevDrAmtVO>();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{

			//컨테이너 vo로 조회 결과 리턴
			cVo = command.searchRDNList(event.getRevDrNoteVO());
		
		
			//컨테이너 vo에서 각 조회결과를 뽑아서 response에 세팅
			if("1".equals(searchGubun)) {
				rsltBkgRevDrNoteVOList  = cVo.getRsltBkgRevDrNoteVOList();
				eventResponse.setRsVoList(rsltBkgRevDrNoteVOList);
			}
			else if("2".equals(searchGubun)) {
				rsltBkgRevDrAmtVOList  = cVo.getRsltBkgRevDrAmtVOList();
				eventResponse.setRsVoList(rsltBkgRevDrAmtVOList);
			}
			
			else if("3".equals(searchGubun)) {
				//max regional Remark
				eventResponse.setETCData("regional_rmk", cVo.getRegionalRmk());
				log.debug("*********************************************************");
				log.debug("regional_rmk : " + eventResponse.getETCData("regional_rmk"));
				log.debug("*********************************************************");
				
				//max receipt Remark
				eventResponse.setETCData("receipt_rmk", cVo.getReceiptRmk());
				log.debug("*********************************************************");
				log.debug("receipt_rmk : " + eventResponse.getETCData("receipt_rmk"));
				log.debug("*********************************************************");
			}
			
			else if("5".equals(searchGubun)) {
				//blno bkg 관련 데이터 조회
				rsltBkgRevDrNoteVOList  = cVo.getRsltBkgRevDrNoteVOList();
				eventResponse.setRsVoList(rsltBkgRevDrNoteVOList);
			}

		} catch (EventException ex) {
			throw ex;
		} catch(Exception ex){
		    throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
		
	}

	/**
	 * ESM_BKG_0426 : Save <br>
	 * RDN을 신규 생성한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createRDNbyIssueOffice(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0426Event event = (EsmBkg0426Event)e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();

		try{
			begin();

			String rdnNo = "";
			rdnNo = command.searchExistRevDrNote(event.getRevDrNoteVO());
			if(!rdnNo.equals("")) {
				throw new EventException(new ErrorHandler("BKG95028", new String[]{rdnNo}).getMessage());
			}

			rdnNo = command.createRDNbyIssueOffice(event.getRevDrNoteVO(),account);
			
			eventResponse.setETCData("rdn_no", rdnNo);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0426 : Save <br>
	 * RDN을 수정한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyRDNbyIssueOffice(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0426Event event = (EsmBkg0426Event)e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		String rdnNo = event.getRevDrNoteVO().getBkgRevDrNoteVO().getRdnNo();
		try{
			begin();
			command.modifyRDNbyIssueOffice(event.getRevDrNoteVO(),account);
			eventResponse.setETCData("rdn_no", rdnNo);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_0426 : Issue <br>
	 * RDN을 Issue 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse issueRDNbyIssueOffice(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0426Event event = (EsmBkg0426Event)e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		try{
			begin();
			command.issueRDNbyIssueOffice(event.getRevDrNoteVO(),account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * ESM_BKG_0426 : ReIssue <br>
	 * RDN 를 ReIssue 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reissueRDNbyIssueOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0426Event event = (EsmBkg0426Event)e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		try{
			begin();
			command.reissueRDNbyIssueOffice(event.getRevDrNoteVO(),account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_0426 : Revise <br>
	 * RDN 를 Revise 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reviseRDNbyIssueOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0426Event event = (EsmBkg0426Event)e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		try{
			begin();
			command.reviseRDNbyIssueOffice(event.getRevDrNoteVO(),account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_0426 : Cancel <br>
	 * RDN 를 Cancel 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelRDNbyIssueOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0426Event event = (EsmBkg0426Event)e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		try{
			begin();
			command.cancelRDNbyIssueOffice(event.getRevDrNoteVO(),account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_0426 : Cancel(Valid) <br>
	 * RDN 를 Cancel 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validCancelRDNbyIssueOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0426Event event = (EsmBkg0426Event)e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		try{
			begin();
			command.validCancelRDNbyIssueOffice(event.getRevDrNoteVO(),account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_0426 : Settle <br>
	 * RDN 를 Settle 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse settleRDNbyIssueOffice(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0426Event event = (EsmBkg0426Event)e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		try{
			begin();
			command.settleRDNbyIssueOffice(event.getRevDrNoteVO(),account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	//esm_bkg_0426 RDN Issuance by Regional Group end
	//////////////////////////////////////////////////////////////////////////////////
	

	
	/**
	 * ESM_BKG_1408 : Open <br>
	 * RDN의 첨부파일 목록을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAttachmentList(Event e) throws EventException {
		EsmBkg1408Event event = (EsmBkg1408Event) e;	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		
		//Attachment List 
		List<AttachmentVO> attachmentVOList = new ArrayList<AttachmentVO>();	

		try{

			//컨테이너 vo로 조회 결과 리턴
			attachmentVOList = command.searchAttachmentList(event.getAttachmentVO());
			eventResponse.setRsVoList(attachmentVOList);

		} catch (EventException ex) {
			throw ex;
		} catch(Exception ex){
		    throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
		
	}


	/**
	 * ESM_BKG_1408 저장 이벤트 처리<br>
	 * RDN의 Attachment 정보 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAttachment(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg1408Event event = (EsmBkg1408Event)e;
		
		try{
			//2.로직 처리 실행
			begin();
			command.manageAttachment(event.getAttachmentVOS(), event.getKeys(), account);
			commit();

			//3.로직 처리후 결과처리
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());  //BKG00102 : 저장성공

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
	
	//esm_bkg_0712 RDN Receipt by Office start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_BKG_0712 : Retrieve <br>
	 * RDN 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDNReceiptList(Event e) throws EventException {
			

		EsmBkg0712Event event = (EsmBkg0712Event) e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		
		
		//컨테이너 vo
		RevDrNoteVO cVo = new RevDrNoteVO();
		//searchGubun 1:note, 2:amt
		String searchGubun = event.getRevDrNoteVO().getSearchGubun();
			
		//RDN List 
		List<RsltBkgRevDrNoteVO> rsltBkgRevDrNoteVOList = new ArrayList<RsltBkgRevDrNoteVO>();
		//AMT List
		List<RsltBkgRevDrAmtVO> rsltBkgRevDrAmtVOList 	= new ArrayList<RsltBkgRevDrAmtVO>();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			//컨테이너 vo로 조회 결과 리턴
			cVo = command.searchRDNList(event.getRevDrNoteVO());
		
		
			//컨테이너 vo에서 각 조회결과를 뽑아서 response에 세팅
			if("1".equals(searchGubun)) {
				rsltBkgRevDrNoteVOList  = cVo.getRsltBkgRevDrNoteVOList();
				eventResponse.setRsVoList(rsltBkgRevDrNoteVOList);
			}
			else if("2".equals(searchGubun)) {
				rsltBkgRevDrAmtVOList  = cVo.getRsltBkgRevDrAmtVOList();
				eventResponse.setRsVoList(rsltBkgRevDrAmtVOList);
			}
			
			else if("3".equals(searchGubun)) {
				//max regional Remark
				eventResponse.setETCData("regional_rmk", cVo.getRegionalRmk());
				log.debug("*********************************************************");
				log.debug("regional_rmk : " + eventResponse.getETCData("regional_rmk"));
				log.debug("*********************************************************");
				
				//max receipt Remark
				eventResponse.setETCData("receipt_rmk", cVo.getReceiptRmk());
				log.debug("*********************************************************");
				log.debug("receipt_rmk : " + eventResponse.getETCData("receipt_rmk"));
				log.debug("*********************************************************");
			}
			
			else if("4".equals(searchGubun)) {
				rsltBkgRevDrNoteVOList  = cVo.getRsltBkgRevDrNoteVOList();
				eventResponse.setRsVoList(rsltBkgRevDrNoteVOList);
			}
			//CA NO 존재여부 조회
			else if("6".equals(searchGubun)) {
				//CA NO COUNT
				eventResponse.setETCData("count_bkg_corr_no", cVo.getCntCano());
				log.debug("*********************************************************");
				log.debug("count_bkg_corr_no : " + eventResponse.getETCData("count_bkg_corr_no"));
				log.debug("*********************************************************");
			
			}
			//TPB NO 존재여부 조회
			else if("7".equals(searchGubun)) {
				//TPB NO COUNT
				eventResponse.setETCData("count_tpb_no", cVo.getCntTpbno());
				log.debug("*********************************************************");
				log.debug("count_tpb_no : " + eventResponse.getETCData("count_tpb_no"));
				log.debug("*********************************************************");
			
			}


		} catch (EventException ex) {
			throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
		}
		
		return eventResponse;
		
	}

	
	
	/**
	 * ESM_BKG_0712 : Save <br>
	 * RDN 정보를 수정한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyRDNbyReceiptOffice(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0712Event event = (EsmBkg0712Event)e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		try{
			begin();
			command.modifyRDNbyReceiptOffice(event.getRevDrNoteVO(),account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_0712 : Accept <br>
	 * RDN 을 accept 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptRDNbyReceiptOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0712Event event = (EsmBkg0712Event)e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		try{
			begin();
			command.acceptRDNbyReceiptOffice(event.getRevDrNoteVO(),account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * ESM_BKG_0712 : Revise <br>
	 * RDN 을 Revise 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reviseRequestRDNbyReceiptOffice(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0712Event event = (EsmBkg0712Event)e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		try{
			begin();
			command.reviseRequestRDNbyReceiptOffice(event.getRevDrNoteVO(),account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_0712 : Cancel Request <br>
	 * RDN 을 Cancel Request 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelRequestRDNbyReceiptOffice(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0712Event event = (EsmBkg0712Event)e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		try{
			begin();
			command.cancelRequestRDNbyReceiptOffice(event.getRevDrNoteVO(),account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	//esm_bkg_0712 RDN Receipt by Office end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	
	//esm_bkg_0427 RDN Status Inquery start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_BKG_0427 : Retrieve <br>
	 * RDN Status를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDNStatusList(Event e) throws EventException {

		EsmBkg0427Event event = (EsmBkg0427Event) e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<RsltBkgRevDrNotesStatusVO> list = 
				command.searchRDNStatusList(event.getRsltBkgRevDrNotesStatusVO());	
		
			eventResponse.setRsVoList(list);
			
			List<RsltBkgRevDrNotesStatusSummaryVO> list2 = 
					command.searchRDNStatusSummaryList(event.getRsltBkgRevDrNotesStatusVO());
			eventResponse.setRsVoList(list2);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627").getMessage(),
					ex);
		}	
		return eventResponse;
	}

	//esm_bkg_0427 RDN Status Inquery end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//esm_bkg_0565 RDN Performance Report start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_BKG_0565 : Retrieve <br>
	 * RDN Performance 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDNPerformanceList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0565Event event = (EsmBkg0565Event) e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		try {
			List<RsltBkgRevDrNotesPerformanceVO> list = 
				command.searchRDNPerformanceList(event.getRsltBkgRevDrNotesPerformanceVO());	
			
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627").getMessage(),	ex);
		}	
		return eventResponse;
	}

	//esm_bkg_0565 RDN Performance Report end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//esm_bkg_0256 Unmatch B/L Inquiry by Regional Group start
	//////////////////////////////////////////////////////////////////////////////////
	
    /**
     * ESM_BKG_0256, ESM_BKG_0701  : Open<br>
     * Mismatch B/L Inquiry by Auditor 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initMismatchBLInquiryByAuditor(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO custVo = null;
        RsltCdListVO scpVo = null;
        RsltCdListVO chgVo = null;
        RsltContiListVO contiVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        List<RsltContiListVO> contiData = null;
        try{
            // RHQ
        	custVo = new RsltCdListVO();
        	custVo.setEtc2("");
            customData = command.searchRasOrganizationList(custVo);
            eventResponse.setCustomData("rhq", customData);
            // Service Scope
        	scpVo = new RsltCdListVO();
        	scpVo.setEtc2("");
            customData = command.searchServiceScopeCodeList(scpVo);
            eventResponse.setCustomData("scp", customData);
            
            // Conti Desc
            contiVo = new RsltContiListVO();
            contiData = command.seacrhRasContiList(contiVo);
            eventResponse.setCustomData("contiCd", contiData);
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("contractType", codeInfos);
        	// Error Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02130", 0);
            eventResponse.setCustomData("errorType", codeInfos);
        	// Rating Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02131", 0);
            eventResponse.setCustomData("ratingType", codeInfos);
        	// status1
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01570", 0);
            eventResponse.setCustomData("status1", codeInfos);
        	// status2 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02134", 0);
            eventResponse.setCustomData("status2", codeInfos);
        	// record 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02165", 0);
            eventResponse.setCustomData("record", codeInfos);
            // Charge
        	chgVo = new RsltCdListVO();
        	chgVo.setEtc2("");
            customData = command.searchChargeCodeList(chgVo);
            eventResponse.setCustomData("charge", customData);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_BKG_0256 : Retrieve <br>
	 * Unmatch BL List 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnmatchBLListbyAuditor(Event e) throws EventException {
			
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0256Event event = (EsmBkg0256Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
			
		//Unmatch List 
		List<RsltUnmatchBLListbyAuditorVO> rsltUnmatchBLListbyAuditorVOList = new ArrayList<RsltUnmatchBLListbyAuditorVO>();
		
		try {
			//vo로 조회 결과 리턴
			rsltUnmatchBLListbyAuditorVOList = command.searchUnmatchBLListbyAuditor(event.getRsltUnmatchBLListbyAuditorVO());
			//bkg count
	//		String bkgCnt = command.searchFilterdBkgCount(event.getRsltUnmatchBLListbyAuditorVO());
			//조회결과를 뽑아서 response에 세팅
			eventResponse.setRsVoList(rsltUnmatchBLListbyAuditorVOList);
	//		//bkg count
	//		eventResponse.setETCData("filtered_bkg_count", bkgCnt);
	//		log.debug("*********************************************************");
	//		log.debug("filtered_bkg_count : " + eventResponse.getETCData("filtered_bkg_count"));
	//		log.debug("*********************************************************");
		
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627").getMessage(),
					ex);
		}	
		return eventResponse;
		
	}
	
	/**
	 * ESM_BKG_0256 : Filtered BL <br>
	 * Filtered BL 건수 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFilteredBkgCountbyAuditor(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0256Event event = (EsmBkg0256Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		try{
			eventResponse.setETCData("BackEndJobKey", command.searchFilterdBkgCount(account, event.getRsltUnmatchBLListbyAuditorVO()));
		}catch(EventException ex){																	  
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0256 : Settle <br>
	 * Unmatch Bl 을 Settle시킨다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse settleUnmatchBL(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0256Event event = (EsmBkg0256Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		try{
			begin();
			command.settleUnmatchBL(event.getBkgRevUmchBkgVOS(),account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0256 : Save <br>
	 * Unmatch Bl 을 수정한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyUnmatchBL(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0256Event event = (EsmBkg0256Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		try{
			begin();
			command.modifyUnmatchBL(event.getBkgRevUmchBkgVOS(),account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	//esm_bkg_0256 Unmatch B/L Inquiry by Regional Group end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//esm_bkg_0701 Unmatch B/L Inquiry by Office start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_BKG_0701 : Retrieve <br>
	 * Unmatch Bl 을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnmatchBLListbyRegionalOffice(Event e) throws EventException {
			
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg0701Event event = (EsmBkg0701Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
			
		//Unmatch List 
		List<RsltUnmatchBLListbyAuditorVO> rsltUnmatchBLListbyAuditorVOList = new ArrayList<RsltUnmatchBLListbyAuditorVO>();
		
		try {
			//vo로 조회 결과 리턴
			rsltUnmatchBLListbyAuditorVOList = command.searchUnmatchBLListbyRegionalOffice(event.getRsltUnmatchBLListbyAuditorVO());
			
			//bkg count
	//		String bkgCnt = command.searchFilteredBkgCount(event.getRsltUnmatchBLListbyAuditorVO());
				
			
			
			//조회결과를 뽑아서 response에 세팅
			eventResponse.setRsVoList(rsltUnmatchBLListbyAuditorVOList);
			//bkg count
	//		eventResponse.setETCData("filtered_bkg_count", bkgCnt);
	//		log.debug("*********************************************************");
	//		log.debug("filtered_bkg_count : " + eventResponse.getETCData("filtered_bkg_count"));
	//		log.debug("*********************************************************");
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627").getMessage(),
					ex);
		}

		return eventResponse;
		
	}

	/**
	 * ESM_BKG_0701 : Filtered B/L <br>
	 * Filtered B/L 건수를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFilteredBkgCountbyRegionalOffice(Event e) throws EventException {
			

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0701Event event = (EsmBkg0701Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
			
		try{
			eventResponse.setETCData("BackEndJobKey", command.searchFilterdBkgCount(account, event.getRsltUnmatchBLListbyAuditorVO()));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		
		return eventResponse;
		
	}
	
	/**
	 * ESM_BKG_0701 : Settle <br>
	 * Unmatch Bl 을 Settle시킨다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse settleOfficeUnmatchBL(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0701Event event = (EsmBkg0701Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		try{
			begin();
			command.settleOfficeUnmatchBL(event.getBkgRevUmchBkgVOS(),account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_0701 : Save <br>
	 * Unmatch BL를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyUnmatchBLRegionalOffice(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0701Event event = (EsmBkg0701Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		try{
			begin();
			command.modifyUnmatchBLRegionalOffice(event.getBkgRevUmchBkgVOS(),account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), ex);
		}
		return eventResponse;
	}
	
	//esm_bkg_0701 Unmatch B/L Inquiry by Office end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//esm_bkg_0698 Diff Amount Details start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_BKG_0698 : OnLoad, Retrieve <br>
	 * Diff Amount Details를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnmatchItemDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0698Event event = (EsmBkg0698Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		//Diff List 
		List<RsltUnmatchDiffAmountVO> rsltUnmatchDiffAmountVOList = new ArrayList<RsltUnmatchDiffAmountVO>();
		try {
			//vo로 조회 결과 리턴
			rsltUnmatchDiffAmountVOList = command.searchUnmatchItemDetailList(event.getRsltUnmatchDiffAmountVO());
			//조회결과를 뽑아서 response에 세팅
			eventResponse.setRsVoList(rsltUnmatchDiffAmountVOList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627").getMessage(),	ex);
		}

		
		return eventResponse;
		
	}

	//esm_bkg_0698 Diff Amount Details end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//esm_bkg_0564 Un-match B/L Status Report start
	//////////////////////////////////////////////////////////////////////////////////
	
    /**
     * ESM_BKG_0564, ESM_BKG_0565, 0569 : Open<br>
     * Mismatch B/L Status Report 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initMismatchBLStatusReport(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO custVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        try{
            // RHQ
        	custVo = new RsltCdListVO();
        	custVo.setEtc2("");
            customData = command.searchRasOrganizationList(custVo);
            eventResponse.setCustomData("rhq", customData);
            custVo.setRhqSet("resp");
            // Resp
            customData = command.searchRasOrganizationList(custVo);
            eventResponse.setCustomData("resp", customData);
            if (e.getEventName().equalsIgnoreCase("EsmBkg0564Event") || e.getEventName().equalsIgnoreCase("EsmBkg0569Event") || e.getEventName().equalsIgnoreCase("EsmBkg1403Event")) {
            	// Contract Type 
                codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
                eventResponse.setCustomData("contractType", codeInfos);
            	// Rating Type 
                codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02131", 0);
                eventResponse.setCustomData("ratingType", codeInfos);
            	// Rating Type 
                codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02002", 0);
                eventResponse.setCustomData("officeType", codeInfos);
            }
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }		
	
	/**
	 * ESM_BKG_0564 : Retrieve <br>
	 * Unmatch BL Status를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnmatchBLStatusList(Event e) throws EventException {
			
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg0564Event event = (EsmBkg0564Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
			
		//Diff List 
		List<RsltUnmatchStatusReportVO> rsltUnmatchStatusReportVOList = new ArrayList<RsltUnmatchStatusReportVO>();
		try {
			//vo로 조회 결과 리턴
			rsltUnmatchStatusReportVOList = command.searchUnmatchBLStatusList(event.getRsltUnmatchStatusReportVO());
			//조회결과를 뽑아서 response에 세팅
			eventResponse.setRsVoList(rsltUnmatchStatusReportVOList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627").getMessage(),	ex);
		}

		
		return eventResponse;
		
	}
	
	/**
	 * ESM_BKG_0569 : Retrieve <br>
	 * Unmatch BL Settlement Report를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnmatchBLSettlementList(Event e) throws EventException {
			
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg0569Event event = (EsmBkg0569Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
			
		//Diff List 
		List<UnmatchSettlementListVO> unmatchSettlementListVO = new ArrayList<UnmatchSettlementListVO>();
		try {
			//vo로 조회 결과 리턴
			unmatchSettlementListVO = command.searchUnmatchBLSettlementList(event.getUnmatchSettlementListVO());
			//조회결과를 뽑아서 response에 세팅
			eventResponse.setRsVoList(unmatchSettlementListVO);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627").getMessage(),	ex);
		}

		
		return eventResponse;
		
	}
	
	/**
	 * ESM_BKG_1403 : Retrieve <br>
	 * Retroactive B/L Status Report를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRetroactiveBlStatusList(Event e) throws EventException {
			
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg1403Event event = (EsmBkg1403Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
			
		//Diff List 
		List<RetroactiveBLStatusListVO> retroactiveBLStatusListVO = new ArrayList<RetroactiveBLStatusListVO>();
		try {
			//vo로 조회 결과 리턴
			retroactiveBLStatusListVO = command.searchRetroactiveBlStatusList(event.getRetroactiveBLStatusListVO());
			//조회결과를 뽑아서 response에 세팅
			eventResponse.setRsVoList(retroactiveBLStatusListVO);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627").getMessage(),	ex);
		}

		
		return eventResponse;
		
	}

	//esm_bkg_0564 Un-match B/L Status Report end
	//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * ESM_BKG_1049 : OnLoad <br>
	 * Unmatch Details 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnmatchItemList(Event e) throws EventException {
		List<RsltSearchUnmatchItemListVO> list = new ArrayList<RsltSearchUnmatchItemListVO>();
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1049Event event = (EsmBkg1049Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		String auditResultNm = "";
        CodeUtil cdUtil = CodeUtil.getInstance();
		
		try{
			
			list = command.searchUnmatchItemList(event.getRsltSearchUnmatchItemListVO());
			
    		// 리스트가 조회 건수가 없으면 성공 표시.
    		if(list.size() == 0) {
        		auditResultNm = cdUtil.getCodeName("CD02456", "M"); // 성공 코드명.
    		}else if(list.size() > 0){
    			// 한건의 Error 라도 있으면 Error 표시. 
        		for(int i = 0; i < list.size(); i++) {
        			auditResultNm = list.get(i).getMtchUmchTpDesc();
           			if(list.get(i).getMtchUmchTpCd().equals("U")) { // Error 건 있으면.
        				break;
        			}
        		}
    		}
    		eventResponse.setETCData("auditResultNm", auditResultNm);			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
	        throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * ESM_BKG_1055 : OnLoad <br>
	 * Unmatch Description 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnmatchTypeList(Event e) throws EventException {
		List<RsltSearchUnmatchTypeListVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1055Event event = (EsmBkg1055Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			list = command.searchUnmatchTypeList(event.getRsltSearchUnmatchTypeListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
	        throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	

    /**
     * ESM_BKG_0151 : Open<br>
     * Charge Filtering 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initChargeFiltering(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO pVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        String rhqOfcCd = "";
        try{
        	// RHQ combo
        	pVo = new RsltCdListVO();
        	pVo.setEtc2("");
            customData = command.searchRasOrganizationList(pVo);
            eventResponse.setCustomData("rhq", customData);
            // office, js 와 맞춰준다	 : var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
            rhqOfcCd = JSPUtil.getNull(account.getRhq_ofc_cd());
            if(!rhqOfcCd.equals("")){
            	pVo = new RsltCdListVO();
            	pVo.setEtc2(rhqOfcCd);
            	pVo.setEtc4("");
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("office", customData);                

                pVo.setRhqSet("gso");
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("gso", customData);
            }
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);

            eventResponse.setCustomData("contractType", codeInfos);
            // Cargo Type => 통합코드 REVENUE AUDIT CARGO TYPE CODE ( CD02374 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02374", 0);
            eventResponse.setCustomData("cargoType", codeInfos);
        	// USA Service Mode Cd 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02286", 0);
            eventResponse.setCustomData("usaSvcModCd", codeInfos);
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            // R term 조회 ( 통합코드 : CD00764 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00764", 0);
            eventResponse.setCustomData("rTerm", codeInfos);
            // D term 조회 ( 통합코드 : CD00765 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00765", 0);
            eventResponse.setCustomData("dTerm", codeInfos);

            // BKG Status => 통합코드 BOOKING STATUS CODE ( CD00769 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00769", 0);
            eventResponse.setCustomData("bkgStatuCd", codeInfos);
            // Split Status => 통합코드 REVENUE AUDIT SPLIT STATUS CODE ( CD02376 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02376", 0);
            eventResponse.setCustomData("splitFlg", codeInfos);
            // Charge Status => 통합코드 REVENUE AUDIT CHARGE STATUS CODE ( CD02375 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02375", 0);
            eventResponse.setCustomData("chargeFlg", codeInfos);
        	// Rating Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02131", 0);
            eventResponse.setCustomData("ratingType", codeInfos);

            // Rating Unit
            customData = command.searchRatingUnitCodeList(new RsltCdListVO());
            eventResponse.setCustomData("ratUtCd", customData);
            
        	// Error BL Status 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD03279", 0);
            eventResponse.setCustomData("errBlCd", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_BKG_0151 : Retrieve <br>
	 * Charge Filtering 리스트를 조회하기 위해 BackEndJob 을 실행한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeFilteringList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0151Event event = (EsmBkg0151Event)e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		try{
			eventResponse.setETCData("BackEndJobKey", command.searchChargeFilteringList(account, event.getRsltSearchChargeFilteringListVO()));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
	        throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	

    /**
     * ESM_BKG_0151 : Open<br>
     * Charge Filtering 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initAuditByCommodityAndRoute(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO pVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        String rhqOfcCd = "";
        try{
        	// RHQ combo
        	pVo = new RsltCdListVO();
        	pVo.setEtc2("");
            customData = command.searchRasOrganizationList(pVo);
            eventResponse.setCustomData("rhq", customData);
            // office, js 와 맞춰준다	 : var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
            rhqOfcCd = JSPUtil.getNull(account.getRhq_ofc_cd());
            if(!rhqOfcCd.equals("")){
            	pVo = new RsltCdListVO();
            	pVo.setEtc2(rhqOfcCd);
            	pVo.setEtc4("");
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("office", customData);
            	
            	pVo.setRhqSet("gso");
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("gso", customData);
                
            }
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("contractType", codeInfos);
            // Cargo Type => 통합코드 REVENUE AUDIT CARGO TYPE CODE ( CD02374 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02374", 0);
            eventResponse.setCustomData("cargoType", codeInfos);
        	// USA Service Mode Cd 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02286", 0);
            eventResponse.setCustomData("usaSvcModCd", codeInfos);
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            // R term 조회 ( 통합코드 : CD00764 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00764", 0);
            eventResponse.setCustomData("rTerm", codeInfos);
            // D term 조회 ( 통합코드 : CD00765 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00765", 0);
            eventResponse.setCustomData("dTerm", codeInfos);

            // BKG Status => 통합코드 BOOKING STATUS CODE ( CD00769 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00769", 0);
            eventResponse.setCustomData("bkgStatuCd", codeInfos);
            // Split Status => 통합코드 REVENUE AUDIT SPLIT STATUS CODE ( CD02376 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02376", 0);
            eventResponse.setCustomData("splitFlg", codeInfos);
            // Charge Status => 통합코드 REVENUE AUDIT CHARGE STATUS CODE ( CD02375 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02375", 0);
            eventResponse.setCustomData("chargeFlg", codeInfos);
        	// Rating Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02131", 0);
            eventResponse.setCustomData("ratingType", codeInfos);

            // Rating Unit
            customData = command.searchRatingUnitCodeList(new RsltCdListVO());
            eventResponse.setCustomData("ratUtCd", customData);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	

	/**
	 * ESM_BKG_1092 : Retrieve <br>
	 * Audit by Commodity And Route 리스트를 조회하기 위해 BackEndJob 을 실행한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuditByCommodityAndRouteList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1092Event event = (EsmBkg1092Event)e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		try{
			eventResponse.setETCData("BackEndJobKey", command.searchAuditByCommodityAndRouteList(account, event.getRsltSearchAuditByCommodityAndRouteListVO()));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
	        throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	

	
    /**
     * ESM_BKG_1079 : Open<br>
     * Audit by CNTR Qty Discrepancy 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initAuditByCNTRQtyDiscrepancyList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO pVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        String rhqOfcCd = "";
        try{
            // RHQ combo
        	pVo = new RsltCdListVO();
        	pVo.setEtc2("");
            customData = command.searchRasOrganizationList(pVo);
            eventResponse.setCustomData("rhq", customData);
            // office, js 와 맞춰준다	 : var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
            rhqOfcCd = JSPUtil.getNull(account.getRhq_ofc_cd());
            if(!rhqOfcCd.equals("")){
            	pVo = new RsltCdListVO();
            	pVo.setEtc2(rhqOfcCd);
            	pVo.setEtc4("");
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("office", customData);
                
                pVo.setRhqSet("gso");
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("gso", customData);
            }
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("contractType", codeInfos);
         // split status 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02376", 0);
            eventResponse.setCustomData("splitFlg", codeInfos);
            // charge status 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02375", 0);
            eventResponse.setCustomData("chargeFlg", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }		
	
	/**
	 * ESM_BKG_1079 : Retrieve <br>
	 * Audit by CNTR Qty Discrepancy 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuditByCNTRQtyDiscrepancyList(Event e) throws EventException {
		List<RsltSearchAuditByCNTRQtyDiscrepancyListVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1079Event event = (EsmBkg1079Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			
			list = command.searchAuditByCNTRQtyDiscrepancyList(event.getRsltSearchAuditByCNTRQtyDiscrepancyListVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * ESM_BKG_1079 : Save <br>
	 * Audit by CNTR Qty Discrepancy 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAuditByCNTRQtyDiscrepancyList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1079Event event = (EsmBkg1079Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		try{			
			begin();
			
		     command.manageAuditByCNTRQtyDiscrepancyList(event.getRsltSearchAuditByCNTRQtyDiscrepancyListVOS(),account);
            
            commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return eventResponse;
	}
    
	
    /**
     * ESM_BKG_1080 : Open<br>
     * Audit by Hanger Installation 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initAuditByHangerInstallationList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO pVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        String rhqOfcCd = "";
        try{
            // RHQ combo
        	pVo = new RsltCdListVO();
        	pVo.setEtc2("");
            customData = command.searchRasOrganizationList(pVo);
            eventResponse.setCustomData("rhq", customData);
            // office, js 와 맞춰준다	 : var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
            rhqOfcCd = JSPUtil.getNull(account.getRhq_ofc_cd());
            if(!rhqOfcCd.equals("")){
            	pVo = new RsltCdListVO();
            	pVo.setEtc2(rhqOfcCd);
            	pVo.setEtc4("");
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("office", customData);
            }
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("contractType", codeInfos);
         // split status 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02376", 0);
            eventResponse.setCustomData("splitFlg", codeInfos);
            // charge status 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02375", 0);
            eventResponse.setCustomData("chargeFlg", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_1080 : Retrieve <br>
	 * Audit by Hanger Installation 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuditByHangerInstallationList(Event e) throws EventException {
		List<RsltSearchAuditByHangerInstallationListVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1080Event event = (EsmBkg1080Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			list = command.searchAuditByHangerInstallationList(event.getRsltSearchAuditByHangerInstallationListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * ESM_BKG_1080 : Save <br>
	 * Audit by Hanger Installation 리마크를 save한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAuditByHangerInstallationList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1080Event event = (EsmBkg1080Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		try{			
			begin();
			   
		     command.manageAuditByHangerInstallationList(event.getRsltSearchAuditByHangerInstallationListVOS(),account);
            
            commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
	 * ESM_BKG_0426 : Issue Save End <br>
	 * RDN Issuance by Auditor Issue 발생시 메일 대상자를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDNIssueMailingList(Event e) throws EventException {
		List<RsltSearchRDNIssueMailingListVO> list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0426Event event = (EsmBkg0426Event) e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		try{
			list = command.searchRDNIssueMailingList(event.getRsltSearchRDNIssueMailingListVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
	        throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}		

    /**
	 * 0263 : Retrive <br>
	 * Self Audit 리스트를 조회한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSelfAuditListBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0263Event event = (EsmBkg0263Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		String jobID = null;
		try {
			begin();
			String blNo = JSPUtil.getNullNoTrim((String)event.getAttribute("bl_no"));
			String caFlg = JSPUtil.getNullNoTrim((String)event.getAttribute("ca_flg"));
			jobID = command.searchSelfAuditListBackEndJob(blNo, caFlg, account);
			eventResponse.setETCData("jobID", jobID);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();			
	        throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
	 * 0263 : Retrive <br>
	 * Self Audit 리스트를 조회한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSelfAuditList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UnmatchBLBC command = new UnmatchBLBCImpl();
		RlstSearchSelfAuditListVO rlstSearchSelfAuditListVO = null;
		try {
			rlstSearchSelfAuditListVO = command.searchSelfAuditList(JSPUtil.getNullNoTrim((String)e.getAttribute("key")));
			if (null!=rlstSearchSelfAuditListVO) {
				eventResponse.setRsVoList(rlstSearchSelfAuditListVO.getUnmatchBlVoList());
				eventResponse.setETCData("auditResultNm", rlstSearchSelfAuditListVO.getAuditResultNm());
				eventResponse.setETCData("result", rlstSearchSelfAuditListVO.getResult());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 0256 : Re-audit <br>
	 * 0701 : Re-audit <br>
	 * Re-audit 프로세스를 처리한다. <br>
	 * 수정시 com.hanjin.apps.alps.esm.bkg.batch.auditunmatchbl.basic.RFAAuditUnmatchBl 배치도 수정해준다.<br>
	 * 수정시 com.hanjin.apps.alps.esm.bkg.batch.auditunmatchbl.basic.SCAuditUnmatchBl 배치도 수정해준다.<br>
	 * 수정시 com.hanjin.apps.alps.esm.bkg.batch.auditunmatchbl.basic.TAAAuditUnmatchBl 배치도 수정해준다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reauditUnmatchBL(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		UnmatchBLBC command = null;
		String jobId = null;
		String bkgNoStr = null;
		String[] bkgNoArr = null;
		try{
			begin();
			eventResponse = new GeneralEventResponse();
			command = new UnmatchBLBCImpl();

			bkgNoStr = JSPUtil.getNullNoTrim((String) e.getAttribute("bkgNoArr"));
			bkgNoArr = bkgNoStr.split("\\|");
			jobId = command.reauditUnmatchBL(bkgNoArr, account);
			eventResponse.setETCData("jobID", jobId);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
		
	}
	

	/**
	 * Re-Audit BackEndJob 실행<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchReauditBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = null;
    	List<ComBakEndJbVO> dbRowSetlist = null;
    	DBRowSet rowSet = null;
    	ComBakEndJbVO jobVo = null;
		String key = null;
    	try {    		
    		eventResponse = new GeneralEventResponse();
    		key = JSPUtil.getNullNoTrim((String)e.getAttribute("KEY"));
	    	if (null != key && !"".equals(key)) {
    			// Backend job 완료여부를 검사한다.
		    	backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(key);
		    	rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	if (0==dbRowSetlist.size()) {  // Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
	    	}
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}
    	return eventResponse;
    }

	/**
	 * BackEndJob 결과 확인<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchReauditBackEndJobResult(Event e) throws EventException{
		GeneralEventResponse eventResponse = null;
		UnmatchBLBC command = null;
		String result = null;
		try{
			eventResponse = new GeneralEventResponse();
			command = new UnmatchBLBCImpl();
			result = command.searchReauditBackEndJobResult(JSPUtil.getNullNoTrim((String)e.getAttribute("KEY")));
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}

	


	/**
	 * 0701 : Manual Settle <br>
	 * Manual Settle 프로세스를 처리한다. <br>
	 * Reaudit 후 Fail인 경우 Manual Settle 프로세스를 처리 <br>
	 * 수정시 com.hanjin.apps.alps.esm.bkg.batch.auditunmatchbl.basic.RFAAuditUnmatchBl 배치도 수정해준다.<br>
	 * 수정시 com.hanjin.apps.alps.esm.bkg.batch.auditunmatchbl.basic.SCAuditUnmatchBl 배치도 수정해준다.<br>
	 * 수정시 com.hanjin.apps.alps.esm.bkg.batch.auditunmatchbl.basic.TAAAuditUnmatchBl 배치도 수정해준다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse settleUnmatchBLByOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		UnmatchBLBC command = null;
		String jobId = null;
		String bkgNoStr = null;
		String[] bkgNoArr = null;
		try{
			begin();
			eventResponse = new GeneralEventResponse();
			command = new UnmatchBLBCImpl();

			bkgNoStr = JSPUtil.getNullNoTrim((String) e.getAttribute("bkgNoArr"));
			bkgNoArr = bkgNoStr.split("\\|");
			jobId = command.settleUnmatchBL(bkgNoArr, "O", account);  //Settle Kind : O - Manual Settle(Office)
			eventResponse.setETCData("jobID", jobId);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
		
	}

	


	/**
	 * 0256 : Manual Settle <br>
	 * Manual Settle 프로세스를 처리한다. <br>
	 * Reaudit 후 Fail인 경우 Manual Settle 프로세스를 처리 <br>
	 * 수정시 com.hanjin.apps.alps.esm.bkg.batch.auditunmatchbl.basic.RFAAuditUnmatchBl 배치도 수정해준다.<br>
	 * 수정시 com.hanjin.apps.alps.esm.bkg.batch.auditunmatchbl.basic.SCAuditUnmatchBl 배치도 수정해준다.<br>
	 * 수정시 com.hanjin.apps.alps.esm.bkg.batch.auditunmatchbl.basic.TAAAuditUnmatchBl 배치도 수정해준다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse settleUnmatchBLByAuditor(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		UnmatchBLBC command = null;
		String jobId = null;
		String bkgNoStr = null;
		String[] bkgNoArr = null;
		try{
			begin();
			eventResponse = new GeneralEventResponse();
			command = new UnmatchBLBCImpl();

			bkgNoStr = JSPUtil.getNullNoTrim((String) e.getAttribute("bkgNoArr"));
			bkgNoArr = bkgNoStr.split("\\|");
			jobId = command.settleUnmatchBL(bkgNoArr, "M", account);  //Settle Kind : M - Manual Settle
			eventResponse.setETCData("jobID", jobId);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
		
	}
	
/*************************************************************************************************************/
/* BACK END JOB 관련																							 */
/*************************************************************************************************************/
	
	/**
	 * BackEndJob : interval <br>
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBakEndJbVO(Event e) throws EventException {
		// 필요시 command 분기
		UnmatchBLBC command = new UnmatchBLBCImpl();
		String key = (String)e.getAttribute("KEY");
		String status;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			status = command.comBakEndJbVO(key);
			eventResponse.setETCData("jb_sts_flg", status);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
	        throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * BackEndJob : search <br>
	 * BackEndJob 결과 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")	
	private EventResponse comBackEndJbSearchList(Event e) throws EventException {
		String key = (String)e.getAttribute("KEY");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if(e.getEventName().equalsIgnoreCase("EsmBkg0151Event")) {
				List<RsltSearchChargeFilteringListVO> list = new ArrayList<RsltSearchChargeFilteringListVO>();
				
				list = (List<RsltSearchChargeFilteringListVO>)BackEndJobResult.loadFromFile(key);
				eventResponse.setRsVoList(list);		
			}
			
			else if(e.getEventName().equalsIgnoreCase("EsmBkg1092Event")) {
				List<RsltSearchAuditByCommodityAndRouteListVO> list = new ArrayList<RsltSearchAuditByCommodityAndRouteListVO>();
				list = (List<RsltSearchAuditByCommodityAndRouteListVO>)BackEndJobResult.loadFromFile(key);
				eventResponse.setRsVoList(list);		
			}
		}catch(Exception ex){
	        throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * BackEndJob : search <br>
	 * BackEndJob 결과 값을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBackEndJbGetResult(Event e) throws EventException {
		String key = (String)e.getAttribute("KEY");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setETCData("RESULT",(String)BackEndJobResult.loadFromFile(key));
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

/*************************************************************************************************************/
/* 메일 관련																							 */
/*************************************************************************************************************/
	
	/**
	 * ISSUE : Save End
	 * RDN Issuance by Auditor 메일대상자에게 메일을 일괄 발송한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 */
	private EventResponse doMailRDNIssue(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0426Event event = (EsmBkg0426Event) e;		
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		try {
			begin();
			command.doMailRDNIssue(event.getRsltSearchRDNIssueMailingListVOS(), event.getRsltSearchRDNIssueMailingListVO());
			eventResponse.setETCData("SuccessYn", "Y");			
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;		
	}
	
    /**
     * ESM_BKG_1129 : Open<br>
     * EQ. Sub. Inquiry 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initAuditByEqSubErrList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO pVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        String rhqOfcCd = "";
        try{
            // RHQ combo
        	pVo = new RsltCdListVO();
        	pVo.setEtc2("");
            customData = command.searchRasOrganizationList(pVo);
            eventResponse.setCustomData("rhq", customData);
            // office, js 와 맞춰준다	 : var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
            rhqOfcCd = JSPUtil.getNull(account.getRhq_ofc_cd());
            if(!rhqOfcCd.equals("")){
            	pVo = new RsltCdListVO();
            	pVo.setEtc2(rhqOfcCd);
            	pVo.setEtc4("");
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("office", customData);
            }
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("contractType", codeInfos);
            // split status 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02376", 0);
            eventResponse.setCustomData("splitFlg", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * ESM_BKG_1129 : Retrieve <br>
	 * EQ. Sub. Inquiry 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuditByEqSubErrList(Event e) throws EventException {
		List<EqSubErrSchVO> list = new ArrayList<EqSubErrSchVO>();
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1129Event event = (EsmBkg1129Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			
			int cntrCnt = 0;
			list = command.searchAuditByEqSubErrList(event.getEqSubErrSchVO());
			cntrCnt = list.size();
			
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("cntr_cnt", Integer.toString(cntrCnt));
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * ESM_BKG_1129 : Save <br>
	 * EQ. Sub. Inquiry 리스트의 변경 사항을 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAuditByEqSubErrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1129Event event = (EsmBkg1129Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		try{			
			begin();
			
		    command.manageAuditByEqSubErrList(event.getEqSubErrSchVOs(), account);
            
            commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return eventResponse;
	}
    
	
    /**
     * ESM_BKG_0705 : Open<br>
     * COD BKG Inquiry 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initCodBookingList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO pVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        String rhqOfcCd = "";
        try{
            // RHQ combo
        	pVo = new RsltCdListVO();
        	pVo.setEtc2("");
            customData = command.searchRasOrganizationList(pVo);
            eventResponse.setCustomData("rhq", customData);
            // office, js 와 맞춰준다	 : var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
            rhqOfcCd = JSPUtil.getNull(account.getRhq_ofc_cd());
            if(!rhqOfcCd.equals("")){
            	pVo = new RsltCdListVO();
            	pVo.setEtc2(rhqOfcCd);
            	pVo.setEtc4("");
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("office", customData);
            }
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("contractType", codeInfos);
            // COD Reason
            customData = command.searchCodRequestResonCodeList(new RsltCdListVO());
            eventResponse.setCustomData("codRqstRsnCd", customData);
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0705 : Retrieve <br>
	 * COD BKG Inquiry 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODBookingList(Event e) throws EventException {
		List<CODBookingListOutVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg0705Event event = (EsmBkg0705Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			list = command.searchCODBookingList(event.getCODBookingListInVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0705 : Retrieve <br>
	 * COD BKG Inquiry 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDiversionCAList(Event e) throws EventException {
		List<DiversionCAVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg0705Event event = (EsmBkg0705Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			list = command.searchDiversionCAList(event.getDiversionCAVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0705 : Save <br>
	 * COD BKG Inquiry 리마크를 save한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCodBookingList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0705Event event = (EsmBkg0705Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		try{			
			begin();
			   
		     command.manageCodBookingList(event.getCODBookingListOutVOs(),account);
            
            commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return eventResponse;
	}

	
    /**
     * ESM_BKG_1079 : Open<br>
     * Audit by CNTR Qty Discrepancy 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initAwkwardBKGListoforAudit(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO pVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        String rhqOfcCd = "";
        try{
            // RHQ combo
        	pVo = new RsltCdListVO();
        	pVo.setEtc2("");
            customData = command.searchRasOrganizationList(pVo);
            eventResponse.setCustomData("rhq", customData);
            // office, js 와 맞춰준다	 : var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
            rhqOfcCd = JSPUtil.getNull(account.getRhq_ofc_cd());
            if(!rhqOfcCd.equals("")){
            	pVo = new RsltCdListVO();
            	pVo.setEtc2(rhqOfcCd);
            	pVo.setEtc4("");
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("office", customData);
            }
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("contractType", codeInfos);
            // split status 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02376", 0);
            eventResponse.setCustomData("splitFlg", codeInfos);
            // charge status 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02375", 0);
            eventResponse.setCustomData("chargeFlg", codeInfos);
            // Container Type Size
            customData = command.searchContainerTypeSizeList(new RsltCdListVO());
            eventResponse.setCustomData("cntrTpsz", customData);
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	

	
	/**
	 * ESM_BKG_1401 : Retrieve <br>
	 * Audit by CNTR Qty Discrepancy 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkwardBKGListoforAudit(Event e) throws EventException {
		List<AwkwardBKGListForAuditVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1401Event event = (EsmBkg1401Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			
			list = command.searchAwkwardBKGListforAudit(event.getAwkwardBKGListForAuditVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}

	
	/**
	 * ESM_BKG_1401 : Retrieve <br>
	 * AK Application vs Bay Plan Discrepancy 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkwardBKGvsBayPlanList(Event e) throws EventException {
		List<BKGvsBayPlanVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1401Event event = (EsmBkg1401Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			
			list = command.searchAwkwardBKGvsBayPlanList(event.getBKGvsBayPlanVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}

	
    /**
     * ESM_BKG_1406 : Open<br>
     * IHC BKG List for Audit 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initIhcBKGListforAudit(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO pVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;

        try{
            // RHQ combo
        	pVo = new RsltCdListVO();
        	pVo.setEtc2("");
            customData = command.searchRasOrganizationList(pVo);
            eventResponse.setCustomData("rhq", customData);
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("contractType", codeInfos);
         // split status 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02376", 0);
            eventResponse.setCustomData("splitFlg", codeInfos);
            // charge status 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02375", 0);
            eventResponse.setCustomData("chargeFlg", codeInfos);
            // SO bound
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02997", 0);  
            eventResponse.setCustomData("soBnd", codeInfos);
            // Audit result
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD03279", 0);  
            eventResponse.setCustomData("audStsCd", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_BKG_1406 : Retrieve <br>
	 * Audit by CNTR Qty Discrepancy 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIhcBKGListforAudit(Event e) throws EventException {
		List<IhcBKGListForAuditVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1406Event event = (EsmBkg1406Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			
			list = command.searchIhcBKGListforAudit(event.getIhcBKGListForAuditVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1402 : Retrieve <br>
	 * Retroactive B/L Filtering 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRetroactBLFilterList(Event e) throws EventException {
		List<RsltSearchRetroActFilterVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1402Event event = (EsmBkg1402Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
				
			list = command.searchRetroactBLFilterList(event.getRetroActFilterSchVO());
			eventResponse.setRsVoList(list);
				
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
    /**
     * ESM_BKG_1402 : Open<br>
     * Retroactive B/L Filtering 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initRetroactiveBLFiltering(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO pVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        String rhqOfcCd = "";
        try{
            // RHQ combo
        	pVo = new RsltCdListVO();
        	pVo.setEtc2("");
            customData = command.searchRasOrganizationList(pVo);
            eventResponse.setCustomData("rhq", customData);
            // office, js 와 맞춰준다	 : var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
            rhqOfcCd = JSPUtil.getNull(account.getRhq_ofc_cd());
            if(!rhqOfcCd.equals("")){
            	pVo = new RsltCdListVO();
            	pVo.setEtc2(rhqOfcCd);
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("office", customData);
            }
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("contractType", codeInfos);
        	// Officed Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02002", 0);
            eventResponse.setCustomData("officeType", codeInfos);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * ESM_BKG_1404 : Retrieve <br>
	 * TXS BKG List for Audit 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTxsBkgListForAudit(Event e) throws EventException {
		List<TxsBkgListForAuditVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1404Event event = (EsmBkg1404Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
				
			list = command.searchTxsBkgListForAudit(event.getTxsBkgListForAuditSchVO());
			eventResponse.setRsVoList(list);
				
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
    /**
     * ESM_BKG_1404 : Open<br>
     * TXS BKG List for Audit 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initTxsBkgListForAudit(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;

        try{
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            // R term 조회 ( 통합코드 : CD00764 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00764", 0);
            eventResponse.setCustomData("rTerm", codeInfos);
            // D term 조회 ( 통합코드 : CD00765 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00765", 0);
            eventResponse.setCustomData("dTerm", codeInfos);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
//	/**
//	 * ESM_BKG_1079 : Save <br>
//	 * Audit by CNTR Qty Discrepancy 리스트를 조회한다.<br>
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse manageAwkwardCargoDicrepancyList(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsmBkg1401Event event = (EsmBkg1401Event) e;
//		UnmatchBLBC command = new UnmatchBLBCImpl();
//		try{			
//			begin();
//			
//		     command.manageAuditByCNTRQtyDiscrepancyList(event.getAwkwardBKGListForAuditVO());
//            
//            commit();
//		} catch (EventException ex) {
//			rollback();
//			throw ex;
//		} catch (Exception ex) {
//			rollback();
//			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
//		}
//		return eventResponse;
//	}
    
    
    
    /**
     * ESM_BKG_1405 : 조회 이벤트 처리<br>
     * Stop Off BKG List for Audit 화면의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchStopOffBkgListforAudit(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1405Event event = (EsmBkg1405Event)e;
        UnmatchBLBC command = new UnmatchBLBCImpl();
        try {

            List<SearchStopOffBkgListforAuditVO> list = command.searchStopOffBkgListforAudit(event.getFmDt(), event.getToDt());
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }    
	
    /**
     * ESM_BKG_1407 : Open<br>
     * SC Note Inquiry by Rule Type 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initCtrtNoteInquiryByRule(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        List<RsltCdListVO> customData = null;
        try{
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            
            // Note Conversion Type
            customData = command.searchNoteConversionTypeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("noteConvType", customData);
            
            // Note Conversion Rule
            customData = command.searchNoteConversionRuleCodeList(new RsltCdListVO());
            eventResponse.setCustomData("noteCovRule", customData);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_BKG_1407 : Retrieve <br>
	 * Contract Note Inquiry by Rule Type 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCtrtNoteConversionListByRule(Event e) throws EventException {
		List<ScNoteConversionVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1407Event event = (EsmBkg1407Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			
			list = command.searchCtrtNoteConversionListByRule(event.getScNoteConversionVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_1409 : Retrieve <br>
	 * BKG별 Bay Plan 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBayPlanByBooking(Event e) throws EventException {
		List<BayPlanVO> list = new ArrayList<BayPlanVO>();
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1409Event event = (EsmBkg1409Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			
			list = command.searchBayPlanByBooking(event.getBkgNo());			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}

	
	/**
	 * ESM_BKG_1420 : Retrieve <br>
	 * OB/L Surrender Inquiry for Audit 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOblSurrenderForAudit(Event e) throws EventException {
		List<OblSurrenderForAuditVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1420Event event = (EsmBkg1420Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			
			list = command.searchOblSurrenderForAudit(event.getOblSurrenderForAuditVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	


	
    /**
     * ESM_BKG_1420 : Open<br>
     * OB/L Surrender Inquiry for Audit 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initOblSurrenderForAudit(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO pVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        String rhqOfcCd = "";
        try{
            // RHQ combo
        	pVo = new RsltCdListVO();
        	pVo.setEtc2("");
            customData = command.searchRasOrganizationList(pVo);
            eventResponse.setCustomData("rhq", customData);
            // office, js 와 맞춰준다	 : var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
            rhqOfcCd = JSPUtil.getNull(account.getRhq_ofc_cd());
            if(!rhqOfcCd.equals("")){
            	pVo = new RsltCdListVO();
            	pVo.setEtc2(rhqOfcCd);
            	pVo.setEtc4("");
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("office", customData);
            }
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("contractType", codeInfos);
            // split status 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02376", 0);
            eventResponse.setCustomData("splitFlg", codeInfos);
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	

	
	/**
	 * ESM_BKG_1421 : Retrieve <br>
	 * Non Autorated Charge Inquiry for Audit 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNonAutoratedChargeForAudit(Event e) throws EventException {
		List<NonAutoratedChargeVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1421Event event = (EsmBkg1421Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			
			list = command.searchNonAutoratedChargeForAudit(event.getNonAutoratedChargeVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	


	
    /**
     * ESM_BKG_1421 : Open<br>
     * Non Autorated Charge Inquiry for Audit 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initNonAutoratedChargeForAudit(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO pVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        String rhqOfcCd = "";
        try{
            // RHQ combo
        	pVo = new RsltCdListVO();
        	pVo.setEtc2("");
            customData = command.searchRasOrganizationList(pVo);
            eventResponse.setCustomData("rhq", customData);
            // office, js 와 맞춰준다	 : var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
            rhqOfcCd = JSPUtil.getNull(account.getRhq_ofc_cd());
            if(!rhqOfcCd.equals("")){
            	pVo = new RsltCdListVO();
            	pVo.setEtc2(rhqOfcCd);
            	pVo.setEtc4("");
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("office", customData);
            }
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("contractType", codeInfos);
            // split status 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02376", 0);
            eventResponse.setCustomData("splitFlg", codeInfos);
            // Charge
            customData = command.searchChargeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("charge", customData);
            // autorating status
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02106", 0);
            CodeInfo combovo = new CodeInfo();
            combovo.setCode("X");
			combovo.setName("X");
			codeInfos.add(0,combovo);
            eventResponse.setCustomData("autoRatCd", codeInfos);
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	
    
    
	/**
	 * ESM_BKG_1422 : Retrieve <br>
	 * Wsc BKG List for Audit 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWscBkgListForAudit(Event e) throws EventException {
		List<WscBkgListForAuditSchVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1422Event event = (EsmBkg1422Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
				
			list = command.searchWscBkgListForAudit(event.getWscBkgListForAuditSchVO());
			eventResponse.setRsVoList(list);
				
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
    /**
     * ESM_BKG_1422 : Open<br>
     * Wsc BKG List for Audit 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initWscBkgListForAudit(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;

        try{
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            // R term 조회 ( 통합코드 : CD00764 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00764", 0);
            eventResponse.setCustomData("rTerm", codeInfos);
            // D term 조회 ( 통합코드 : CD00765 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00765", 0);
            eventResponse.setCustomData("dTerm", codeInfos);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_BKG_1423 : Open<br>
     * India DTH BKG List for Audit 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initIndiaDthBKGListforAudit(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO pVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;

        try{
            // RHQ combo
        	pVo = new RsltCdListVO();
        	pVo.setEtc2("");
            customData = command.searchRasOrganizationList(pVo);
            eventResponse.setCustomData("rhq", customData);
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("contractType", codeInfos);
         // split status 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02376", 0);
            eventResponse.setCustomData("splitFlg", codeInfos);
            // charge status 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02375", 0);
            eventResponse.setCustomData("chargeFlg", codeInfos);
            // SO bound
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02997", 0);  
            eventResponse.setCustomData("soBnd", codeInfos);
            // Audit result
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD03279", 0);  
            eventResponse.setCustomData("audStsCd", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_BKG_1423 : Retrieve <br>
	 * India 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIndiaDthBKGListforAudit(Event e) throws EventException {
		List<IndiaDthBKGListForAuditVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1423Event event = (EsmBkg1423Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			
			list = command.searchIndiaDthBKGListforAudit(event.getIndiaDthBKGListForAuditVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	
    /**
     * ESM_BKG_1424 : Open<br>
     * Iran DTH BKG List for Audit 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initIranDthBKGListforAudit(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        RsltCdListVO pVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
 
        try{
            // RHQ combo
        	pVo = new RsltCdListVO();
        	pVo.setEtc2("");
            customData = command.searchRasOrganizationList(pVo);
            eventResponse.setCustomData("rhq", customData);
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            // Audit result
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD03279", 0);  
            eventResponse.setCustomData("audStsCd", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_BKG_1424 : Retrieve <br>
	 * Iran 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIranDthBKGListforAudit(Event e) throws EventException {
		List<IranDthBKGListForAuditVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1424Event event = (EsmBkg1424Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			
			list = command.searchIranDthBKGListforAudit(event.getIranDthBKGListForAuditVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
    
	
	/**
	 * ESM_BKG_1425 : Retrieve <br>
	 * unmatch bl age 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnmatchBLAgingList(Event e) throws EventException {
		List<UmchErrBlReportVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1425Event event = (EsmBkg1425Event)e; 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			
			list = command.searchUnmatchBLAgingList(event.getUmchErrBlReportVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * @param Event e e
	 * @return EventResponse
	 * @throws EventException
	 */
	 @SuppressWarnings("unchecked")
	private EventResponse initUnmatchBLAgingList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        List<RsltCdListVO> customData = null;
 
		try{
			
            // RHQ
        	RsltCdListVO custVo = new RsltCdListVO();
        	custVo.setEtc2("");
            customData = command.searchRasOrganizationList(custVo);
            eventResponse.setCustomData("rhq", customData);
     

		} catch (EventException ex) {
			throw ex;
		} catch(Exception ex){
		    throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
		
	}
	
	
	/**
	 * ESM_BKG_5002 : Open <br>
	 * unsettled rdn aging list를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnSettledRdnAgingList(Event e) throws EventException {
		EsmBkg5002Event event = (EsmBkg5002Event) e;	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
 
		try{
			List<UnStlRdnReportVO> unStlRdnReportVO = command.searchUnSettledRdnAgingList(event.getUnStlRdnReportVO());
			eventResponse.setRsVoList(unStlRdnReportVO);

		} catch (EventException ex) {
			throw ex;
		} catch(Exception ex){
		    throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
		
	}
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	 @SuppressWarnings("unchecked")
	private EventResponse initUnSettledRdnAgingList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonBC command = new RASCommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<CodeInfo> codeInfos = null; 
        List<RsltCdListVO> customData = null;
 
		try{
			
            // RHQ
        	RsltCdListVO custVo = new RsltCdListVO();
        	custVo.setEtc2("");
            customData = command.searchRasOrganizationList(custVo);
            eventResponse.setCustomData("rhq", customData);
            
            // RDN Kind
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD03402", 0);
            eventResponse.setCustomData("rdnKind", codeInfos);
     

		} catch (EventException ex) {
			throw ex;
		} catch(Exception ex){
		    throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
		
	}
	

	    /**
	     * ESM_BKG1426  : Open<br>
	     *  Multi Rate BKG List for Audit 화면의 Combo Item 들을 조회합니다.<br>
	     *
	     * @param Event e
	     * @return EventResponse
	     * @exception EventException
	     */
	    @SuppressWarnings("unchecked")
	    private EventResponse initMultiRateBkgList(Event e) throws EventException {
	        GeneralEventResponse eventResponse = new GeneralEventResponse();
	        RASCommonBC command = new RASCommonBCImpl();
	        RsltCdListVO custVo = null;
	        RsltCdListVO scpVo = null;
	        CodeUtil cdUtil = CodeUtil.getInstance();
	        List<RsltCdListVO> customData = null;
	        List<CodeInfo> codeInfos = null;

	        try{
	            // RHQ
	        	custVo = new RsltCdListVO();
	        	custVo.setEtc2("");
	            customData = command.searchRasOrganizationList(custVo);
	            eventResponse.setCustomData("rhq", customData);
	            // Service Scope
	        	scpVo = new RsltCdListVO();
	        	scpVo.setEtc2("");
	            customData = command.searchServiceScopeCodeList(scpVo);
	            eventResponse.setCustomData("scp", customData);

	        	// Contract Type 
	            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
	            eventResponse.setCustomData("contractType", codeInfos);

	        }catch(EventException ex){
	            throw ex;
	        }catch(Exception ex){
	            throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
	        }
	        return eventResponse;
	    }
	    
	    
		/**
		 * ESM_BKG_1426 : Open <br>
		 * Multi Rate BKG List for Audit를 조회한다.<br>
		 * 
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchMultiRateBkgList(Event e) throws EventException {
			EsmBkg1426Event event = (EsmBkg1426Event) e;	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			UnmatchBLBC command = new UnmatchBLBCImpl();
	 
			try{
				List<MultiRateBkgListVO> multiRateBkgListVO = command.searchMultiRateBkgList(event.getMultiRateBkgListVO());
				eventResponse.setRsVoList(multiRateBkgListVO);

			} catch (EventException ex) {
				throw ex;
			} catch(Exception ex){
			    throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
			}
			return eventResponse;
			
		}
		
		/**
	     * ESM_BKG1427  : Open<br>
	     *  Multi Rate BKG List for Audit 화면의 Combo Item 들을 조회합니다.<br>
	     *
	     * @param Event e
	     * @return EventResponse
	     * @exception EventException
	     */
	    @SuppressWarnings("unchecked")
	    private EventResponse initMultiRateBkgList_1(Event e) throws EventException {
	        GeneralEventResponse eventResponse = new GeneralEventResponse();
	        RASCommonBC command = new RASCommonBCImpl();
	        RsltCdListVO custVo = null;
	        RsltCdListVO scpVo = null;
	        CodeUtil cdUtil = CodeUtil.getInstance();
	        List<RsltCdListVO> customData = null;
	        List<CodeInfo> codeInfos = null;

	        try{
	            // RHQ
	        	custVo = new RsltCdListVO();
	        	custVo.setEtc2("");
	            customData = command.searchRasOrganizationList(custVo);
	            eventResponse.setCustomData("rhq", customData);
	            // Service Scope
	        	scpVo = new RsltCdListVO();
	        	scpVo.setEtc2("");
	            customData = command.searchServiceScopeCodeList(scpVo);
	            eventResponse.setCustomData("scp", customData);

	        	// Contract Type 
	            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
	            eventResponse.setCustomData("contractType", codeInfos);

	        }catch(EventException ex){
	            throw ex;
	        }catch(Exception ex){
	            throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
	        }
	        return eventResponse;
	    }
	    
	    
		/**
		 * ESM_BKG_1427 : Open <br>
		 * Multi Rate BKG List for Audit(1) 조회<br>
		 * 
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchMultiRateBkgList_1(Event e) throws EventException {
			EsmBkg1427Event event = (EsmBkg1427Event) e;	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			UnmatchBLBC command = new UnmatchBLBCImpl();
	 
			try{
				List<MultiRateBkgList1VO> multiRateBkgList1VO = command.searchMultiRateBkgList_1(event.getMultiRateBkgList1VO());
				eventResponse.setRsVoList(multiRateBkgList1VO);

			} catch (EventException ex) {
				throw ex;
			} catch(Exception ex){
			    throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
			}
			return eventResponse;
			
		}
		
		/**
		 * Multi Rate BKG List for Audit(1) 수정(Save 버튼)<br>
		 * @param e
		 * @return
		 * @throws EventException
		 */
		private EventResponse manageMultiRateBkgList_1(Event e) throws EventException {
			EsmBkg1427Event event = (EsmBkg1427Event) e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			UnmatchBLBC command = new UnmatchBLBCImpl();
			
			try {
				command.manageMultiRateBkgList_1(event.getMultiRateBkgList1VOs(), account);
			} catch (EventException ex) {
				throw ex;
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
			}
			
			return eventResponse;
		}
		
		/**
		 * Multi Rate BKG List for Audit(1) 확인(Confirm 버튼)<br>
		 * @param e
		 * @return
		 * @throws EventException
		 */
		private EventResponse confirmMultiRateBkgList_1(Event e) throws EventException {
			EsmBkg1427Event event = (EsmBkg1427Event) e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			UnmatchBLBC command = new UnmatchBLBCImpl();
			
			try {
				command.confirmMultiRateBkgList_1(event.getMultiRateBkgList1VOs(), account);
			} catch (EventException ex) {
				throw ex;
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
			}
			
			return eventResponse;
		}
		
		/**
		 * Multi Rate BKG List for Audit(1) 확인 취소(Release 버튼)
		 * @param e
		 * @return
		 * @throws EventException
		 */
		private EventResponse releaseMultiRateBkgList_1(Event e) throws EventException {
			EsmBkg1427Event event = (EsmBkg1427Event) e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			UnmatchBLBC command = new UnmatchBLBCImpl();
			
			try {
				command.releaseMultiRateBkgList_1(event.getMultiRateBkgList1VOs(), account);
			} catch (EventException ex) {
				throw ex;
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
			}
			
			return eventResponse;
		} 
}