/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceManageSC.java
*@FileTitle : surcharge 입력/수정/삭제화면
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.19
*@LastModifier : 최 선
*@LastVersion : 1.6
* 2006.11.09 poong_yeon
* 1.0 최초 생성
* N200902240180 [TRS] TPB 대상 건 I/F 가능 시점 추가 요청 
* -------------------------------------------------------
* history
* 2011.07.20 김영철 1.1 [CHM-201111871] [TRS] R4J 소스 품질 조치 내역 수정
* 2011.07.21  손은주 1.2 [CHM-201111573-01]	[TRS] S/O history function 추가 요청
* 2011.12.09 민정호 1.3 [CLT-111121293] R4J 패치 이후 발생한 결함 건 수정(Null dereference)
* 2011.12.26 최 선    1.4 [CHM-201115241] [TRS] Hold invoice 관련 메세지 추가요청
* 2012.02.21 최종혁  1.5 [CHM-201216257] [TRS] S/O history 상 Invoice 처리수단 표기 오류 수정요청
* 2012.03.19 최 선    1.6 [CHM-201216257] [TRS] S/O history 상 Invoice 처리수단 표기 오류 수정요청
* 2012.04.12 김인수 1.47 [CHM-201216040] [TRS] US rail S/O 에 대한 S/O history function 연결 요청
* 2013.02.26 조인영 [CHM-201323086] Invoice Audit시 validation 추가 요청
* 2014.11.26 최종혁 김현화[CHM-201432901]Split 01-비용지급 전표 결재건
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBC;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.hanjin.apps.alps.esd.trs.common.trscommon.vo.TrsSOHistoryVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBC;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0031Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0032Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0034Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0047Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0048Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0960Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.basic.InvoiceAuditBC;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.basic.InvoiceAuditBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0033Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0040Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.basic.InvoiceInquiryCorrectionBC;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.basic.InvoiceInquiryCorrectionBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.event.EsdTrs0030Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.basic.PoolChassisBC;
import com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.basic.PoolChassisBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.event.EsdTrs0041Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.basic.RailInvoiceauditBC;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.basic.RailInvoiceauditBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0038Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0923Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.basic.RailInvoiceInquiryCorrectionBC;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.basic.RailInvoiceInquiryCorrectionBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.event.EsdTrs0046Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.vo.TrsTrspRailInvWrkVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.basic.SurchargeInputInquiryBC;
import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.basic.SurchargeInputInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.event.EsdTrs0918Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBC;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBCImpl;
import com.hanjin.bizcommon.approval.basic.ApprovalBC;
import com.hanjin.bizcommon.approval.basic.ApprovalBCImpl;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TrsTrspInvWrkVO;
import com.hanjin.syscommon.common.table.TrsTrspRailInvDtlVO;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;
/**
 * ESD-InvoiceManage Business Logic ServiceCommand<br>
 * - ESD-InvoiceManage에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author poong_yeon
 * @see ESD_TRS_918EventResponse,SurchargeInputInquiryDBDAO 참조
 * @since J2EE 1.4
 */
public class InvoiceManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * InvoiceManage 업무 시나리오 선행작업<br>
	 * SurchargeInputInquiry업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {     
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("InvoiceManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * InvoiceManage 업무 시나리오 마감작업<br>
	 * SurchargeInputInquiry업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("InvoiceManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-InvoiceManage 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse 	eventResponse 	= null;
		String			sCsrNo			= null;
		
		//log.debug("event : " + e);

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0918Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSurchargeInputInquiryList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSurchargeCodeNameList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchTPBIfFlag(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = addTempSurchargeList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0033Event")) { // Invoice
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInvoiceAuditList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPaymentSP(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDupChkInvoice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchInvoiceAuditListByInvoiceNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = verifyEqNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchInvOfcCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = rejectInvoice(e); 
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchMdmOrganization(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = calculateExchangeRate(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = saveInvoiceAudit(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = confirmInvoiceAudit(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = confirmInvoiceAuditForNoTranjection(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = verifyTruckInvoiceFileImport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchTruckInvoiceFileImport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchInvoiceImportDuplicateCheckByDate2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchN3ptyCurrCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchIdaTaxRto(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = verifySacNo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0038Event")) { // US Rail Invoice
			if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchPaymentVndrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRailinvoiceauditList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) { // save - confirm
				eventResponse = modifyRailinvoiceaudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchContainerInfo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0923Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = verifyRailInvoiceFileImportEqNo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0929Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPaymentHistoryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0925Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReAuditInfoList(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdTrs0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceInquiryCorrectionList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmInvoice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = confirmCancelInvoice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = saveHold(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = modifyInvOfcCdForSPP(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = saveUpdUsrId(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = deleteInvoice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInvoiceConfrimAmt(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchInvoiceInquirySecondExcelForm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchInvoiceEdiPdfFile(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchInvoiceInquiryIdaList(e);
			}
		}
			
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0031Event")) {
			
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		    	
				eventResponse = searchCSRSummary(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		    	
				eventResponse = checkASANO(e);	
			}
		}	
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0032Event")) {
			EsdTrs0032Event	event	= (EsdTrs0032Event)e;
			
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSummaryDetail(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {	
				eventResponse	= approvalRequest	(event	);					/** ++ approvalRequest, ++ updateCSRSOHDRsts */
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		  
				eventResponse	= approvalPreview	(event	);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {		
				eventResponse	= searchCheckHoldInvoice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {		
				eventResponse	= searchCheckGLMonth(e);	
			}
		}
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0034Event")) {
			
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		    	
				eventResponse = searchTAXInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {	
				EsdTrs0032Event	event	= (EsdTrs0032Event)e;
				
				approvalRequest						(event	);					/** ++ approvalRequest, ++ updateCSRSOHDRsts */		
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		    	
				eventResponse = searchApEviNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {		    	
				eventResponse = searchTAXCode(e);					
			}
		}	

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0037Event")) {
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSummaryDetail(e);
				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				EsdTrs0032Event	event	= (EsdTrs0032Event)e;
				correctCsrAmt						(event	);					/** CORRECTION INVOICE AMOUNT FOR CSR	*/
				sCsrNo	= generateNewCsrNo			(event);
				event.setCsr_no						(sCsrNo	);

				createApInvHdrDtrb					(event	);
				checkApInvDtrbValidation			(sCsrNo	);
				
				updateApInvDtrbLineNo				(sCsrNo	);
				createApInvIF						(event	);					/** ++ approvalRequest, ++ updateCSRSOHDRsts */
			}
		}
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0036Event")) {
			
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		    	
				eventResponse = searchCSRSummaryDetail(e);
				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {	
				EsdTrs0032Event	event	= (EsdTrs0032Event)e;
				correctCsrAmt						(event	);					/** CORRECTION INVOICE AMOUNT FOR CSR	*/
				sCsrNo	= generateNewCsrNo			(event);
				event.setCsr_no						(sCsrNo	);

				createApInvHdrDtrb					(event	);
				checkApInvDtrbValidation			(sCsrNo	);
				updateApInvDtrbLineNo				(sCsrNo	);
				createApInvIF						(event	);					/** ++ approvalRequest, ++ updateCSRSOHDRsts */
			}
		}		
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0040Event")) {
			
		    if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		    	
				eventResponse = searchPaymentVnder(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {		    	
				eventResponse = searchInvoiceNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {		    	
				eventResponse = searchVendor(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		    	
				eventResponse = multiInvoiceAuditRefund(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		    	
				eventResponse = searchRefundList(e);
			}
		}	
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0046Event")) { // US Rail Invoice Inquiry
			
		    if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {		    	
				eventResponse = searchRailInvoiceInquiryCorrectionList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		    	
				eventResponse = multiRailInvoiceHold(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {	// invoice delete	    	
				eventResponse = removeRailInvoiceInquiryCorrection(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {	// invoice confirm cancel	    	
				eventResponse = multiRailInvoiceConfirmCancel(e);
			}
		}	
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0047Event")) {
			
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		    	
				eventResponse = searchCSRAPiflist(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		    	
				eventResponse = searchCsrPreVeiw(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI19)) {		    	
				eventResponse = cancelCSRAPifError(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI20)) {		    	
				eventResponse = cancelCSRApprovalRequest(e);
			}
		}
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0048Event")) {
			
			 if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {		    	
				eventResponse = searchCsrCancel(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		    	
				eventResponse = cancelCSRAPif(e);
			}
		}
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0960Event")) {
			
		    if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {		    	
				eventResponse = searchInvoiceListInquiry(e);
			}
		}	
		
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0041Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInvoicePoolChassisList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = dupChkPoolChassisInvoiceNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {				
				insertInvoicePoolChassis(e);  
				eventResponse = searchInvoicePoolChassisList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				updateInvoicePoolChassis(e);
				eventResponse = searchInvoicePoolChassisList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				confirmInsertInvoicePoolChassis(e);
				eventResponse = searchInvoicePoolChassisList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				confirmUpdateInvoicePoolChassis(e);
				eventResponse = searchInvoicePoolChassisList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				confirmInvoicePoolChassis(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				confirmCancelInvoicePoolChassis(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				deleteInvoicePoolChassis(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = getPaymentSPList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = getPoolList(e);
			}
		}
		
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			begin();
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			TrsCommonBC commCommand =  new TrsCommonBCImpl();
			TrsTrspInvWrkVO[]  TrsTrspInvWrkVOs = event.getTrsTrspInvWrkVOs();
			for(int i=0; i<TrsTrspInvWrkVOs.length; i++){
				//TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력
				TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();  
				soHisVo.setTrspSoOfcCtyCd("");
				soHisVo.setInvNo(TrsTrspInvWrkVOs[i].getInvNo());
				soHisVo.setInvVndrSeq(TrsTrspInvWrkVOs[i].getInvVndrSeq());
				soHisVo.setTrspSoEvntCd("ID");
				soHisVo.setCreUsrId(account.getUsr_id());
				soHisVo.setCreOfcCd(account.getOfc_cd());
				commCommand.multiSoHistory(soHisVo);
			}
			eventResponse = command.deleteInvoice(event);
			
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			begin();
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.confirmInvoice(event);
			TrsCommonBC commCommand =  new TrsCommonBCImpl();
  
			TrsTrspInvWrkVO[]  TrsTrspInvWrkVOs = event.getTrsTrspInvWrkVOs();
			for(int i=0; i<TrsTrspInvWrkVOs.length; i++){
				//TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력
				TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();  
				soHisVo.setTrspSoOfcCtyCd("");
				soHisVo.setInvNo(TrsTrspInvWrkVOs[i].getInvNo());
				soHisVo.setInvVndrSeq(TrsTrspInvWrkVOs[i].getInvVndrSeq());
				soHisVo.setTrspSoEvntCd("II");
				if (TrsTrspInvWrkVOs[i].getIfSysKndCd().equals("I")) {
					soHisVo.setTrspSoHisDesc("EDI Confirmed");
				} else if (TrsTrspInvWrkVOs[i].getIfSysKndCd().equals("W")) {
					soHisVo.setTrspSoHisDesc("SPP Confirmed");
				}
				soHisVo.setCreUsrId(account.getUsr_id());
				soHisVo.setCreOfcCd(account.getOfc_cd());
				commCommand.multiSoHistory(soHisVo);
			}
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmCancelInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			begin();
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			TrsCommonBC commCommand =  new TrsCommonBCImpl();
			
			TrsTrspInvWrkVO[]  TrsTrspInvWrkVOs = event.getTrsTrspInvWrkVOs();
			for(int i=0; i<TrsTrspInvWrkVOs.length; i++){
				//TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력
				TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();  
				soHisVo.setTrspSoOfcCtyCd("");
				soHisVo.setInvNo(TrsTrspInvWrkVOs[i].getInvNo());
				soHisVo.setInvVndrSeq(TrsTrspInvWrkVOs[i].getInvVndrSeq());
				soHisVo.setTrspSoEvntCd("IX");
				soHisVo.setCreUsrId(account.getUsr_id());
				soHisVo.setCreOfcCd(account.getOfc_cd());
				commCommand.multiSoHistory(soHisVo);
			}
			
			eventResponse = command.confirmCancelInvoice(event);
		
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse saveHold(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			begin();
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.saveHold(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse saveUpdUsrId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			begin();
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.saveUpdUsrId(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceConfrimAmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.searchInvoiceConfrimAmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceEdiPdfFile(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.searchInvoiceEdiPdfFile(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceInquirySecondExcelForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.searchInvoiceInquirySecondExcelForm(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceInquiryCorrectionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.searchInvoiceInquiryCorrectionList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * invoice 리스트 가져오기<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse saveInvoiceAudit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			TrsCommonBC commCommand =  new TrsCommonBCImpl();
			ArrayList woScgArr = command.searchWoSurcharge(event);
			
			SurchargeVO[] scgArr = new SurchargeVO[woScgArr.size()];
			if( woScgArr != null){
				for( int i=0; i<woScgArr.size(); i++){
					if(i==0)
						scgArr = new SurchargeVO[woScgArr.size()];
					scgArr[i] = (SurchargeVO)woScgArr.get(i);
				}
			}
		    event.setSurchargeVOs(scgArr);
			begin();
			
			/**
			 * 2013.02.18 조인영 [CHM-201323086] Invoice Audit시 validation 추가 요청
			 * Save 시점에 W/O Rate 와 비교하여 값이 다르면 Save 불가
			 */
			TrsTrspSvcOrdVO[] soArr	= event.getTrsTrspSvcOrdVOS();
			ArrayList<TrsTrspSvcOrdVO> srcList 				= new ArrayList<TrsTrspSvcOrdVO>(); //(ArrayList) event.getTrsTrspSvcOrdVoList();
			
			if( soArr!= null){
				for(int i=0; i<soArr.length; i++){
					srcList.add(soArr[i]);
				}
			}
			DBRowSet rs = null;
			GeneralEventResponse eventResponse1 = new GeneralEventResponse();		
			int checkAmt = 0;
			for(int i=0; srcList != null && i<srcList.size(); i++){
				TrsTrspSvcOrdVO model 		= (TrsTrspSvcOrdVO) 	srcList.get(i);
				rs = command.searchSOAmt(model);
				DBRowSet tmpRs = (DBRowSet) rs.clone();
				if(tmpRs.next()){
					if (tmpRs.getString("BZC_DIFF").equals("DIFF") || tmpRs.getString("ETC_DIFF").equals("DIFF") || tmpRs.getString("NEGO_DIFF").equals("DIFF")
						|| tmpRs.getString("SCG_DIFF").equals("DIFF") || tmpRs.getString("SCG_VAT_DIFF").equals("DIFF")){
						eventResponse1.setETCData("bzc_diff", tmpRs.getString("BZC_DIFF"));
						eventResponse1.setETCData("etc_diff", tmpRs.getString("ETC_DIFF"));
						eventResponse1.setETCData("nego_diff", tmpRs.getString("NEGO_DIFF"));
						eventResponse1.setETCData("scg_diff", tmpRs.getString("SCG_DIFF"));
						eventResponse1.setETCData("scg_vat_diff", tmpRs.getString("SCG_VAT_DIFF"));
						eventResponse = eventResponse1;
						checkAmt ++;
						break;
						}
					}
			}
			if(checkAmt == 0){
				eventResponse = command.saveInvoiceAudit(event);
				
				TrsTrspSvcOrdVO[]  TrsTrspSvcOrdVOs = event.getTrsTrspSvcOrdVOS();
				for(int i=0; i<TrsTrspSvcOrdVOs.length; i++){
					//TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력
					TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();
					soHisVo.setTrspSoOfcCtyCd(TrsTrspSvcOrdVOs[i].getTrspSoOfcCtyCd());
					soHisVo.setTrspSoSeq(TrsTrspSvcOrdVOs[i].getTrspSoSeq());
					soHisVo.setTrspSoEvntCd("IS");
					soHisVo.setCreUsrId(account.getUsr_id());
					soHisVo.setCreOfcCd(account.getOfc_cd());
					commCommand.multiSoHistory(soHisVo);
				}
			}
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * invoice 리스트 가져오기<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmInvoiceAudit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		DateFormat dateFormat = new SimpleDateFormat("mm");
		long tranjectionTime = 0;
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			ArrayList woScgArr = command.searchWoSurcharge(event);
		    
			SurchargeVO[] scgArr = new SurchargeVO[woScgArr.size()];
			if( woScgArr != null){
				for( int i=0; i<woScgArr.size(); i++){
					if(i==0)
						scgArr = new SurchargeVO[woScgArr.size()];
					scgArr[i] = (SurchargeVO)woScgArr.get(i);
				}
			}
		    event.setSurchargeVOs(scgArr);
			begin();
			tranjectionTime = System.currentTimeMillis();
			
			/**
			 * 2013.02.18 조인영 [CHM-201323086] Invoice Audit시 validation 추가 요청
			 * Confirm 시점에 W/O Rate 와 비교하여 값이 다르면 Save 불가
			 */
			TrsTrspSvcOrdVO[] soArr	= event.getTrsTrspSvcOrdVOS();
			ArrayList<TrsTrspSvcOrdVO> srcList 				= new ArrayList<TrsTrspSvcOrdVO>(); //(ArrayList) event.getTrsTrspSvcOrdVoList();
			if( soArr!= null){
				for(int i=0; i<soArr.length; i++){
					srcList.add(soArr[i]);
				}
			}
			DBRowSet rs = null;
			GeneralEventResponse eventResponse1 = new GeneralEventResponse();		
			int checkAmt = 0;
			for(int i=0; srcList != null && i<srcList.size(); i++){
				TrsTrspSvcOrdVO model 		= (TrsTrspSvcOrdVO) 	srcList.get(i);
				rs = command.searchSOAmt(model);
				DBRowSet tmpRs = (DBRowSet) rs.clone();
				if(tmpRs.next()){
					if (tmpRs.getString("BZC_DIFF").equals("DIFF") || tmpRs.getString("ETC_DIFF").equals("DIFF") || tmpRs.getString("NEGO_DIFF").equals("DIFF")
						|| tmpRs.getString("SCG_DIFF").equals("DIFF") || tmpRs.getString("SCG_VAT_DIFF").equals("DIFF")){
						eventResponse1.setETCData("bzc_diff", tmpRs.getString("BZC_DIFF"));
						eventResponse1.setETCData("etc_diff", tmpRs.getString("ETC_DIFF"));
						eventResponse1.setETCData("nego_diff", tmpRs.getString("NEGO_DIFF"));
						eventResponse1.setETCData("scg_diff", tmpRs.getString("SCG_DIFF"));
						eventResponse1.setETCData("scg_vat_diff", tmpRs.getString("SCG_VAT_DIFF"));
						eventResponse = eventResponse1;
						checkAmt ++;
						break;
						}
					}
			}
			if(checkAmt == 0){
				eventResponse = command.confirmInvoiceAudit(event);
				
				TrsCommonBC commCommand =  new TrsCommonBCImpl();			
				TrsTrspSvcOrdVO[]  TrsTrspSvcOrdVOs = event.getTrsTrspSvcOrdVOS();
				for(int i=0; i<TrsTrspSvcOrdVOs.length; i++){
					if( TrsTrspSvcOrdVOs[i].getTrspInvActStsCd() != null && "C".equals(TrsTrspSvcOrdVOs[i].getTrspInvActStsCd())){
						//TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력
						TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();  
						soHisVo.setTrspSoOfcCtyCd(TrsTrspSvcOrdVOs[i].getTrspSoOfcCtyCd());
						soHisVo.setTrspSoSeq(TrsTrspSvcOrdVOs[i].getTrspSoSeq());
						soHisVo.setTrspSoEvntCd("II");
						soHisVo.setCreUsrId(account.getUsr_id());
						soHisVo.setCreOfcCd(account.getOfc_cd());
						commCommand.multiSoHistory(soHisVo);
					}
				}
			}
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			int tTime = Integer.parseInt(dateFormat.format(new Date(System.currentTimeMillis()- tranjectionTime)));
			log.error("invoice confirm trajectionTime=" + tTime);
			if(tTime>=2){
				eventResponse = confirmInvoiceAuditForNoTranjection(e);
			}else{
				throw new EventException(de.getMessage());
			}
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * BPM Interface 를 위한 method 로 203.246.151.29 에 설치된 Oracle 에 Connection 해서
	 * Procedure 호출로 AQ 에 DATA 를 넣는 기능을 처리한다. ( BPM POC 이후 삭제 필요 )
	 * 
	 * @param correlation String
	 * @param msgXml String
	 * @return void
	 * @exception EventException
	 */
//	private void bpmInterface(String correlation, String msgXml) {
//		java.sql.Connection   connection = null;
//		java.sql.CallableStatement statement = null;
//
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			java.sql.DriverManager.setLoginTimeout(10);  // Login Timeout 설정
//			String url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=203.246.151.29)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SID=ORASOA)))";
//
//			connection = java.sql.DriverManager.getConnection(url, "orabpm", "orabpm");
//			statement = connection.prepareCall("{ CALL BPM_ALPS_IF_PRC(?,?)}");
//
//			statement.setString(1, correlation); // Correlation
//			statement.setString(2, msgXml);   // Message XML
//
//			statement.setQueryTimeout(20);   // Login Timeout 설정
//			statement.execute();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally{
//			if(statement  != null) {try {statement.close(); } catch (Exception e) {}}
//			if(connection != null) {try {connection.close();} catch (Exception e) {}}
//		}
//	}

	/**
	 * invoice 리스트 가져오기<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmInvoiceAuditForNoTranjection(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		InvoiceAuditBC command = new InvoiceAuditBCImpl();
		try {
			
			begin();
			ArrayList woScgArr = command.searchWoSurcharge(event);
		    
			SurchargeVO[] scgArr = new SurchargeVO[woScgArr.size()];
			if( woScgArr != null){
				for( int i=0; i<woScgArr.size(); i++){
					if(i==0)
						scgArr = new SurchargeVO[woScgArr.size()];
					scgArr[i] = (SurchargeVO)woScgArr.get(i);
				}
			}
		    event.setSurchargeVOs(scgArr);
			commit();

			command.checkConfirmInvoice(event);

			TrsTrspSvcOrdVO[] soArr = event.getTrsTrspSvcOrdVOS();

			begin();
			eventResponse = command.confirmInvoiceAuditForMain(event);
			commit();

			 for(int k=0; soArr!= null &&  k<soArr.length; k++){
			 	begin();
			 	command.confirmInvoiceAuditForSvcOrd(event, k);
			 	commit();
			 }
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			
			// NO TRANJECTION으로 CONFIRM도중 문제가 발생되면 INV SAVE 상태로 저장한다.
			command.rollbackInvoiceAuditForMain(event);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * invoice 리스트 가져오기<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceAuditList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = new GeneralEventResponse();	
		int i =1;
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			WorkOrderIssueBC command023 = new WorkOrderIssueBCImpl();
			eventResponse = command.searchInvoiceAuditList(event);
			DBRowSet rs = eventResponse.getRs();
			DBRowSet cloneRs = (DBRowSet) rs.clone();
			if( cloneRs != null ){
				ArrayList scgArr = command023.searchSurchargeList(cloneRs);
				if( scgArr != null ){
					if(scgArr.size()>0){
						DBRowSet scgRs = (DBRowSet) scgArr.get(0);
						String[] colValue = null;
						String scgXml = null;
						StringBuffer colOrder = new StringBuffer();
						StringBuffer sbScgXml = new StringBuffer();
						
						if( scgRs != null ){
							colValue = new String[scgRs.getMetaData().getColumnCount()];
							for(int k=1; k<scgRs.getMetaData().getColumnCount()+1 ; k++) {
								colOrder.append("surcharge_"+scgRs.getMetaData().getColumnName(k));
								
								if(k != scgRs.getMetaData().getColumnCount()) colOrder.append("|");
							}
						}
						
						//소스품질 결함 사항 수정 2014.05.22 신동일
						//scgXml = "<SHEET>";
						//scgXml = scgXml + "<DATA COLORDER='"+colOrder+"'>";
						sbScgXml.append("<SHEET>");
						sbScgXml.append("<DATA COLORDER='"+colOrder+"'>");
						for(int k=0; k<scgArr.size(); k++){
							scgRs = (DBRowSet) scgArr.get(k);
							while (scgRs!=null && scgRs.next()) {
								i = 1;
								//scgXml = scgXml + "<TR>";
								sbScgXml.append("<TR>");
								for (int j = 0 ; j < scgRs.getMetaData().getColumnCount() ; j++) {
									//scgXml = scgXml + "<TD>"+JSPUtil.getNull(scgRs.getString(i++))+"</TD>";	
									sbScgXml.append("<TD>"+JSPUtil.getNull(scgRs.getString(i++))+"</TD>");
								}
								//scgXml = scgXml + "</TR>";
								sbScgXml.append("</TR>");
							}
						}
						//scgXml = scgXml + "</DATA></SHEET>";
						sbScgXml.append("</DATA></SHEET>");
						scgXml = sbScgXml.toString();
						
						eventResponse.setETCData("scgXml", scgXml);
					}
				}
			}
			

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception f){
			log.error("err " + f.toString(), f);
			throw new EventException(f.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * invoice 리스트 가져오기<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceAuditListByInvoiceNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = new GeneralEventResponse();	
		int i =1;
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			WorkOrderIssueBC command023 = new WorkOrderIssueBCImpl();
			eventResponse = command.searchInvoiceAuditListByInvoiceNo(event);
			DBRowSet rs = eventResponse.getRs();
			DBRowSet cloneRs = (DBRowSet) rs.clone();
			
			if( cloneRs != null ){
				ArrayList scgArr = command023.searchSurchargeList(cloneRs);
				if(scgArr!= null){
					if(scgArr.size()>0){
						DBRowSet scgRs = (DBRowSet) scgArr.get(0);
						String[] colValue = null;
						String scgXml = null;
						StringBuffer sbScgXml = new StringBuffer();
						StringBuffer colOrder = new StringBuffer();
						
						if( scgRs != null ){
							colValue = new String[scgRs.getMetaData().getColumnCount()];
							for(int k=1; k<scgRs.getMetaData().getColumnCount()+1 ; k++) {
								colOrder.append("surcharge_"+(scgRs.getMetaData().getColumnName(k)).toLowerCase());
								
								if(k != scgRs.getMetaData().getColumnCount()) colOrder.append("|");
							}
						}
//						소스품질 결함 수정 2014.05.22 신동일
//						scgXml = "<SHEET>";
//						scgXml = scgXml + "<DATA COLORDER='"+colOrder+"'>";
						sbScgXml.append("<SHEET>");
						sbScgXml.append("<DATA COLORDER='"+colOrder+"'>");
						
						for(int k=0; k<scgArr.size(); k++){
							scgRs = (DBRowSet) scgArr.get(k);
							while (scgRs!=null && scgRs.next()) {
								i = 1;
//								scgXml = scgXml + "<TR>";
								sbScgXml.append("<TR>");
								for (int j = 0 ; j < scgRs.getMetaData().getColumnCount() ; j++) {
//									scgXml = scgXml + "<TD>"+JSPUtil.getNull(scgRs.getString(i++))+"</TD>";
									sbScgXml.append("<TD>"+JSPUtil.getNull(scgRs.getString(i++))+"</TD>");
								}
//								scgXml = scgXml + "</TR>";
								sbScgXml.append("</TR>");
							}
						}
//						scgXml = scgXml + "</DATA></SHEET>";
						sbScgXml.append("</DATA></SHEET>");
						scgXml = sbScgXml.toString();
						
						eventResponse.setETCData("scgXml", scgXml);
					}
				}
			}
			
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception f){
			log.error("err " + f.toString(), f);
			throw new EventException(f.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDupChkInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchDupChkInvoice(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyEqNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.verifyEqNo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyInvOfcCdForSPP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.modifyInvOfcCdForSPP(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvOfcCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchInvOfcCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmOrganization(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchMdmOrganization(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse calculateExchangeRate(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.calculateExchangeRate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
				
		try {
			begin();
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.rejectInvoice(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentSP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchPaymentSP(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SurchargeInputInquiry 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeInputInquiryList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0918Event event = (EsdTrs0918Event)e;
		
		try {
			SurchargeInputInquiryBC command = new SurchargeInputInquiryBCImpl();
			eventResponse = command.searchSurchargeInputInquiryList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * insert 처리<br>
	 * Surcharge Temp Table에 insert 처리<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse addTempSurchargeList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0918Event event = (EsdTrs0918Event)e;
		
		try {
			SurchargeInputInquiryBC command = new SurchargeInputInquiryBCImpl();
			eventResponse = command.addTempSurchargeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SurchargeInputInquiry 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeCodeNameList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0918Event event = (EsdTrs0918Event)e;
		
		try {
			SurchargeInputInquiryBC command = new SurchargeInputInquiryBCImpl();
			eventResponse = command.searchSurchargeCodeNameList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * SurchargeInputInquiry 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBIfFlag(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0918Event event = (EsdTrs0918Event)e;
		
		try {
			SurchargeInputInquiryBC command = new SurchargeInputInquiryBCImpl();
			eventResponse = command.searchTPBIfFlag(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * invoiceaudit의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentVndrList(Event e) throws EventException {

		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			RailInvoiceauditBC command = new RailInvoiceauditBCImpl();
			eventResponse = command.searchPaymentVndrList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EQ NO가 비어있는 WO를 채우기<br>
	 * INVOICE FILE IMPORT SUB METHOD<br>
	 * 
	 * @param TrsTrspSvcOrdVO model, ArrayList emptyWoList
	 * @return TrsTrspSvcOrdVO
	 * @exception EventException
	 */
	private TrsTrspSvcOrdVO fillEqNo(TrsTrspSvcOrdVO model, ArrayList emptyWoList, ArrayList childVndrList) throws EventException {
		TrsTrspSvcOrdVO svcModel			= null;
		String bkgBkgCntr					= null;
		InvoiceAuditBCImpl command 			= new InvoiceAuditBCImpl();
		try{
			for(int i=0; emptyWoList != null && i < emptyWoList.size(); i++){
				svcModel					= (TrsTrspSvcOrdVO)	emptyWoList.get(i);

				if(svcModel != null
						&& model.getTrspWoOfcCtyCd().equals(svcModel.getTrspWoOfcCtyCd())
						&& model.getTrspWoSeq().equals(svcModel.getTrspWoSeq())
						) {
					/** CY/Door O/D 이면 BKG_CNTR에서 부합되는 CNTR이 있는지 확인 **/					
					if( svcModel.getTrspSoTpCd().equals("Y")
							&& svcModel.getTrspBndCd().equals("O")
							&& svcModel.getTrspCostDtlModCd().equals("DR")){
						bkgBkgCntr = command.searchInvoiceImportBkgBkgCntr2(svcModel, model);
						if(bkgBkgCntr == null){
							model.			setEdiRcvRsltMsg("BKG CNTR Mismatch");
							model.			setDtnUseFlg("0");
						}else{
							model.			setTrspSoOfcCtyCd(svcModel.getTrspSoOfcCtyCd());
							model.			setTrspSoSeq(svcModel.getTrspSoSeq());
							model.			setCntrSubFlg("Y");
							model 			= fillCommon(model, svcModel, childVndrList);
							model.			setCreDt(svcModel.getCreDt()); /** DATE에 의한 duplicate check를 위한 column **/
							model.			setFmNodCd(svcModel.getFmNodCd()); /** DATE에 의한 duplicate check를 위한 column **/
							emptyWoList.	remove(i);
						}
						break;
					}else if(model.getEqTpszCd().equals(svcModel.getEqTpszCd()))
					{
						model.			setTrspSoOfcCtyCd(svcModel.getTrspSoOfcCtyCd());
						model.			setTrspSoSeq(svcModel.getTrspSoSeq());
						model.			setCreDt(svcModel.getCreDt());
						model.			setFmNodCd(svcModel.getFmNodCd());
						model 			= fillCommon(model, svcModel, childVndrList);
						model.			setCreDt(svcModel.getCreDt()); /** DATE에 의한 duplicate check를 위한 column **/
						model.			setFmNodCd(svcModel.getFmNodCd()); /** DATE에 의한 duplicate check를 위한 column **/
						emptyWoList.	remove(i);
						break;
					}
				}
			}
		}catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return model;
	}
	
	/**
	 * @param childVndrList
	 * @param srcVndrSeq
	 * @return
	 */
	private boolean isVndrSeq(ArrayList childVndrList, String srcVndrSeq){
		boolean returnFlag = false;
		String rsVndrSeq = null;
		for(int i=0; childVndrList != null && i < childVndrList.size(); i++){
			rsVndrSeq = (String) childVndrList.get(i);
			if( rsVndrSeq != null && rsVndrSeq.equals(srcVndrSeq)){
				returnFlag = true;
				break;
			}
		}
		return returnFlag;
	}
	
	
	/**
	 * 공통 VERIFY<br>
	 * INVOICE FILE IMPORT SUB METHOD<br>
	 * 
	 * @param TrsTrspSvcOrdVO model, DBRowSet rsValue
	 * @return TrsTrspSvcOrdVO
	 * @exception EventException
	 */
	private TrsTrspSvcOrdVO fillCommon(TrsTrspSvcOrdVO model, TrsTrspSvcOrdVO svcModel, ArrayList childVndrList) throws EventException {
		try{
			if(svcModel != null){
				if(svcModel.getCreOfcCd().equals("") ||
						!svcModel.getCreOfcCd().equals(model.getCreOfcCd())){
					model.					setEdiRcvRsltMsg("Unauthorized office");
					model.					setDtnUseFlg("0");
				}else if(!isVndrSeq(childVndrList, svcModel.getVndrSeq())){
					model.					setEdiRcvRsltMsg("W/O S/P Mismatch");
					model.					setDtnUseFlg("0");
				}else if(!svcModel.getTrspSoStsCd().equals("I")){
					model.				setEdiRcvRsltMsg("W/O Status ["+svcModel.getTrspSoStsCd()+"]");
					model.				setDtnUseFlg("0");
				}else if(!svcModel.getInvNo().equals("")){
					model.				setEdiRcvRsltMsg("Already Invoiced ["+svcModel.getInvNo()+"]");
					model.				setDtnUseFlg("0");
				}else if(!model.getInvBzcAmt().equals("")){
					if(validateNumberFormat(model.getInvBzcAmt(), svcModel.getInvBzcAmt())){
						BigDecimal modelInvBzcAmt = new BigDecimal(model.getInvBzcAmt());
						BigDecimal rsInvBzcAmt = new BigDecimal(svcModel.getInvBzcAmt());
						if(modelInvBzcAmt.compareTo(rsInvBzcAmt) != 0) {
							model.setEdiRcvRsltMsg("Amount Diff "+"("+modelInvBzcAmt.subtract(rsInvBzcAmt).toString()+")");
							model.setDtnUseFlg("1");
						}
					} else {
						BigDecimal modelInvBzcAmt = new BigDecimal("0");
						BigDecimal rsInvBzcAmt = new BigDecimal(svcModel.getInvBzcAmt());
						if(modelInvBzcAmt.compareTo(rsInvBzcAmt) != 0 ){
							model.setEdiRcvRsltMsg("Amount Diff "+"(-"+modelInvBzcAmt.subtract(rsInvBzcAmt).toString()+")");
							model.setDtnUseFlg("1");
						}
					}
				}
			}
		}catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return model;
	}

	/**
	 * R4J 예외처리를 위해 만든 고육지계 메소드
	 * 
	 * @param model
	 * @param svcModel
	 * @return
	 */
	private boolean validateNumberFormat(String str1, String str2){
		boolean returnFlag = true;
		try{
			 new BigDecimal(str1);
			 new BigDecimal(str2);
		}catch(NumberFormatException nfe){
			log.error("err " + nfe.toString(), nfe);
			returnFlag = false;
		}
		return returnFlag;
	}
	
	/**
	 * R4J 예외처리를 위해 만든 고육지계 메소드2
	 * 
	 * @param model
	 * @param svcModel
	 * @return
	 */
	private boolean validateNumberFormat2(String str1){
		boolean returnFlag = true;
		try{
			Integer.parseInt(str1);
		}catch(NumberFormatException nfe){
			log.error("err " + nfe.toString(), nfe);
			returnFlag = false;
		}
		return returnFlag;
	}
	
	
	/**
	 * 공통 VERIFY<br>
	 * INVOICE FILE IMPORT SUB METHOD<br>
	 * 
	 * @param TrsTrspSvcOrdVO model, DBRowSet rsValue
	 * @return TrsTrspSvcOrdVO
	 * @exception EventException
	 */
	private TrsTrspSvcOrdVO fillCommon(TrsTrspSvcOrdVO model, DBRowSet rsValue, ArrayList childVndrList) throws EventException {
		DBRowSet rs 						= null;
		try{
			rs	 							= rsValue;

			if(rs != null){
				if(rs.getString("INV_OFC_CD") == null ||
						!rs.getString("INV_OFC_CD").equals(model.getCreOfcCd())){
					model.					setEdiRcvRsltMsg("Unauthorized office");
					model.					setDtnUseFlg("0");
				}else if(rs.getString("VNDR_SEQ") == null ||
						!isVndrSeq(childVndrList, rs.getString("VNDR_SEQ"))){
					model.					setEdiRcvRsltMsg("W/O S/P Mismatch");
					model.					setDtnUseFlg("0");
				}else if(!rs.getString("TRSP_SO_STS_CD").equals("I")){
					model.				setEdiRcvRsltMsg("W/O Status ["+rs.getString("TRSP_SO_STS_CD")+"]");
					model.				setDtnUseFlg("0");
				}else if(!rs.getString("INV_NO").equals("")){
					model.				setEdiRcvRsltMsg("Already Invoiced ["+rs.getString("INV_NO")+"]");
					model.				setDtnUseFlg("0");
				}else if(!model.getInvBzcAmt().equals("")){
					if(validateNumberFormat(model.getInvBzcAmt(),rs.getString("WO_TOT_AMT"))){
						BigDecimal modelInvBzcAmt = new BigDecimal(model.getInvBzcAmt());
						BigDecimal rsInvBzcAmt = new BigDecimal(rs.getString("WO_TOT_AMT"));
						if(modelInvBzcAmt.compareTo(rsInvBzcAmt) != 0) {
							model.setEdiRcvRsltMsg("Amount Diff "+"("+modelInvBzcAmt.subtract(rsInvBzcAmt).toString()+")");
							model.setDtnUseFlg("1");
						}
					}else{
						BigDecimal modelInvBzcAmt = new BigDecimal("0");
						BigDecimal rsInvBzcAmt = new BigDecimal(rs.getString("WO_TOT_AMT"));
						if(modelInvBzcAmt.compareTo(rsInvBzcAmt) != 0 ){
							model.setEdiRcvRsltMsg("Amount Diff "+"(-"+modelInvBzcAmt.subtract(rsInvBzcAmt).toString()+")");
							model.setDtnUseFlg("1");
						}
					}
				}
				
				if(model.getDtnUseFlg().equals("1")){
					model.			setCreDt(rs.getString("CRE_DT")); /** DATE에 의한 duplicate check를 위한 column **/
					model.			setFmNodCd(rs.getString("FM_NOD_CD")); /** DATE에 의한 duplicate check를 위한 column **/
				}
			}
		}catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return model;
	}
	
	/**
	 * SO, WO,EQNO Duplication verify<br>
	 * INVOICE FILE IMPORT SUB METHOD<br>
	 * 
	 * @param ArrayList srcList
	 * @return ArrayList
	 * @exception EventException
	 */
	private ArrayList checkDupSoWoEqNo(ArrayList srcList){
		
		ArrayList tgtList = (ArrayList) srcList.clone();
		String src_trsp_so_seq = null;
		String src_trsp_wo_seq = null;
		String src_eq_no = null;
		String tgt_trsp_so_seq = null;
		String tgt_trsp_wo_seq = null;
		String tgt_eq_no = null;
		
		for(int i=0;srcList != null && i<srcList.size(); i++){
			TrsTrspSvcOrdVO srcModel 		= (TrsTrspSvcOrdVO) 	srcList.get(i);
			src_trsp_so_seq					= srcModel.getTrspSoOfcCtyCd()+srcModel.getTrspSoSeq();
			if(!src_trsp_so_seq.equals("") && srcModel.getDtnUseFlg().equals("1")){
				for(int k=i+1; tgtList != null && k<tgtList.size(); k++){
					TrsTrspSvcOrdVO tgtModel 		= (TrsTrspSvcOrdVO) 	tgtList.get(k);
					if(tgtModel != null){
						tgt_trsp_so_seq 	= tgtModel.getTrspSoOfcCtyCd()+tgtModel.getTrspSoSeq();
						if(tgtModel.getDtnUseFlg().equals("1") && !tgt_trsp_so_seq.equals("")
								&& tgt_trsp_so_seq.equals(src_trsp_so_seq)){
							tgtModel.setEdiRcvRsltMsg("Duplicated S/O No");
							tgtModel.setDtnUseFlg("0");
							srcList.set(k, tgtModel);
							tgtList.set(k, null);
						}
					}
				}
			}
		}
		
		for(int i=0;srcList != null && i<srcList.size(); i++){
			TrsTrspSvcOrdVO srcModel 		= (TrsTrspSvcOrdVO) 	srcList.get(i);
			src_trsp_wo_seq					= srcModel.getTrspWoOfcCtyCd()+srcModel.getTrspWoSeq();
			src_eq_no						= srcModel.getEqNo();
			if(!src_trsp_wo_seq.equals("") && !src_eq_no.equals("") && srcModel.getDtnUseFlg().equals("1")){
				for(int k=i+1; tgtList != null && k<tgtList.size(); k++){
					TrsTrspSvcOrdVO tgtModel 		= (TrsTrspSvcOrdVO) 	tgtList.get(k);
					if(tgtModel != null){
						tgt_trsp_wo_seq 	= tgtModel.getTrspWoOfcCtyCd()+tgtModel.getTrspWoSeq();
						tgt_eq_no			= tgtModel.getEqNo();
						if(tgtModel.getDtnUseFlg().equals("1") 
								&& !tgt_trsp_wo_seq.equals("")
								&& !tgt_eq_no.equals("")
								&& tgt_trsp_wo_seq.equals(src_trsp_wo_seq)
								&& tgt_eq_no.equals(src_eq_no)){
							tgtModel.setEdiRcvRsltMsg("Duplicated W/O No, CNTR No");
							tgtModel.setDtnUseFlg("0");
							srcList.set(k, tgtModel);
							tgtList.set(k, null);
						}
					}
				}
			}
		}
		
		return srcList;
	}
	
	/**
	 * SO, WO,EQNO Duplication verify<br>
	 * INVOICE FILE IMPORT SUB METHOD<br>
	 * 
	 * @param ArrayList srcList
	 * @return ArrayList
	 * @exception EventException
	 */
	private ArrayList checkDupOpenerSoWoEqNo(ArrayList srcList, ArrayList tgtList){
		
		String src_trsp_so_seq = null;
		String src_trsp_wo_seq = null;
		String src_eq_no = null;
		String tgt_trsp_so_seq = null;
		String tgt_trsp_wo_seq = null;
		String tgt_eq_no = null;
		/* srcList - popup List, tgtList - main window List */
		for(int i=0;srcList != null && i<srcList.size(); i++){
			TrsTrspSvcOrdVO srcModel 		= (TrsTrspSvcOrdVO) 	srcList.get(i);
			src_trsp_so_seq					= srcModel.getTrspSoOfcCtyCd()+srcModel.getTrspSoSeq();
			if(!src_trsp_so_seq.equals("") && srcModel.getDtnUseFlg().equals("1")){
				for(int k=0; tgtList != null && k<tgtList.size(); k++){
					TrsTrspSvcOrdVO tgtModel 		= (TrsTrspSvcOrdVO) 	tgtList.get(k);
					if(tgtModel != null){
						tgt_trsp_so_seq 	= tgtModel.getTrspSoOfcCtyCd()+tgtModel.getTrspSoSeq();
						if(!tgt_trsp_so_seq.equals("")
								&& tgt_trsp_so_seq.equals(src_trsp_so_seq)){
							srcModel.setEdiRcvRsltMsg("Duplicated S/O No w/ Main Window");
							srcModel.setDtnUseFlg("0");
							srcList.set(i, srcModel);
							tgtList.set(k, null);
						}
					}
				}
			}
		}
		
		for(int i=0;srcList != null && i<srcList.size(); i++){
			TrsTrspSvcOrdVO srcModel 		= (TrsTrspSvcOrdVO) 	srcList.get(i);
			src_trsp_wo_seq					= srcModel.getTrspWoOfcCtyCd()+srcModel.getTrspWoSeq();
			src_eq_no						= srcModel.getEqNo();
			if(!src_trsp_wo_seq.equals("") && !src_eq_no.equals("") && srcModel.getDtnUseFlg().equals("1")){
				for(int k=0; tgtList != null && k<tgtList.size(); k++){
					TrsTrspSvcOrdVO tgtModel 		= (TrsTrspSvcOrdVO) 	tgtList.get(k);
					if(tgtModel != null){
						tgt_trsp_wo_seq 	= tgtModel.getTrspWoOfcCtyCd()+tgtModel.getTrspWoSeq();
						tgt_eq_no			= tgtModel.getEqNo();
						if(!tgt_trsp_wo_seq.equals("")
								&& !tgt_eq_no.equals("")
								&& tgt_trsp_wo_seq.equals(src_trsp_wo_seq)
								&& tgt_eq_no.equals(src_eq_no)){
							srcModel.setEdiRcvRsltMsg("Duplicated W/O No, CNTR No w/ Main Window");
							srcModel.setDtnUseFlg("0");
							srcList.set(i, srcModel);
							tgtList.set(k, null);
						}
					}
				}
			}
		}
		
		return srcList;
	}
	
	/**
	 * Invoice file import verify<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyTruckInvoiceFileImport(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0033Event event				= (EsdTrs0033Event)e;
			
		String invCurrCd	= event.getApply_currency();
		String creOfcCd		= event.getFORM_USR_OFC_CD();
		String vndrSeq		= event.getWo_vndr_cd();
		String paymentVndrSeq = event.getPayment_vndr_cd();

		/*
		 * EDI_RCV_RSLT_MSG : verify_result
		 * DTN_USE_FLG : ibcheck
		 * EDI_RCV_RSLT_CD : NIS
		 */
		try{
			TrsTrspSvcOrdVO[] soArr	= event.getTrsTrspSvcOrdVOS();
			TrsTrspSvcOrdVO[] opSoArr = event.getOPENER_TrsTrspSvcOrdVOS();
			InvoiceAuditBCImpl command 		= new InvoiceAuditBCImpl();
			ArrayList<TrsTrspSvcOrdVO> srcList 				= new ArrayList<TrsTrspSvcOrdVO>(); //(ArrayList) event.getTrsTrspSvcOrdVoList();
			ArrayList<TrsTrspSvcOrdVO> openerList 			= new ArrayList<TrsTrspSvcOrdVO>(); //(ArrayList) event.getOpener_TrsTrspSvcOrdVoList();
			
			if( soArr!= null){
				for(int i=0; i<soArr.length; i++){
					srcList.add(soArr[i]);
				}
			}
			
			if( opSoArr!= null){
				for(int i=0; i<opSoArr.length; i++){
					openerList.add(opSoArr[i]);
				}
			}
			
			ArrayList soList 				= null;
			ArrayList woList 				= null;
			ArrayList emptyWoList 			= null;
			ArrayList childVndrList 		= null;
			DBRowSet rs = null;
			String eqNo = null;
			String eqTpSzCd = null;
			String eqTpSzCdInput = null;
			String bkgBkgCntr = null;
			String currCd = null;
			
			/** model 초기값 설정 **/
			for(int i=0; srcList != null && i<srcList.size(); i++){
				TrsTrspSvcOrdVO model 		= (TrsTrspSvcOrdVO) 	srcList.get(i);
				model.setDtnUseFlg("1");
				model.setInvCurrCd(invCurrCd);
				model.setCreOfcCd(creOfcCd);
				model.setVndrSeq(vndrSeq);
				
				/** so seq 분리 **/
				/**
				 * 2013.02.27 조인영 [CHM-201323073] Inv audit & confirm Validation rule 추가
				 * S/O Length가 3자리 이하이면 Validation check
				 */
				if(!"".equals(model.getPrntTrspSoOfcCtyCd())){
					if(model.getPrntTrspSoOfcCtyCd().length() > 3){
						if(validateNumberFormat2(model.getPrntTrspSoOfcCtyCd().substring(3))){
							model.setTrspSoOfcCtyCd(model.getPrntTrspSoOfcCtyCd().substring(0,3).toUpperCase());
							model.setTrspSoSeq(model.getPrntTrspSoOfcCtyCd().substring(3));
						} else {
							model.	setEdiRcvRsltMsg("Invalid S/O No");
							model.	setDtnUseFlg("0");
						}
					} else {
						model.setEdiRcvRsltMsg("Invalid S/O No");
						model.setDtnUseFlg("0");
					}
				}
				
				/** wo seq 분리 **/
				/**
				 * 2013.02.27 조인영 [CHM-201323073] Inv audit & confirm Validation rule 추가
				 * W/O Length가 3자리 이하이면 Validation check
				 */
				if(!"".equals(model.getPrntTrspSoSeq())){
					if( model.getPrntTrspSoSeq().length() > 3){
						if(validateNumberFormat2(model.getPrntTrspSoSeq().substring(3))){
							model.setTrspWoOfcCtyCd(model.getPrntTrspSoSeq().substring(0,3).toUpperCase());
							model.setTrspWoSeq(model.getPrntTrspSoSeq().substring(3));
						} else {
							model.setEdiRcvRsltMsg("Invalid W/O No");
							model.setDtnUseFlg("0");
						}
					} else{
						model.setEdiRcvRsltMsg("Invalid W/O No");
						model.setDtnUseFlg("0");
					}
				}
				
				if(!"".equals(model.getEqNo())){
					model.setEqNo(model.getEqNo().toUpperCase());
				}
				
				srcList.set(i, model);
				event.setTrsTrspSvcOrdVoList(srcList);
			}
			
			woList 							= command.searchInvoiceImportWO(event);
			emptyWoList 					= command.searchInvoiceImportEmptyWO(event);
			soList 							= command.searchInvoiceImportSO(event);
			childVndrList					= command.searchPaymentChildVnder(paymentVndrSeq);
			/** WO LIST 처리 **/
			for(int i=0; srcList!= null && i<srcList.size(); i++){
				TrsTrspSvcOrdVO model 		= (TrsTrspSvcOrdVO) 	srcList.get(i);
				if("".equals(model.getTrspSoSeq()) && !"".equals(model.getTrspWoSeq()) &&"1".equals( model.getDtnUseFlg())){
					if(woList.get(i) != null){
						rs 						= (DBRowSet) 			((DBRowSet)woList.get(i)).clone();
					}else{
						rs						= null;
					}
					if(rs == null || !rs.next()){
						/** 비어있는 eqno를 채운다. **/
						if( !"".equals(model.getEqNo())){
							eqTpSzCdInput 				= command.verifyEqNo(model.getEqNo());
							if(eqTpSzCdInput == null){
								model.		setEdiRcvRsltMsg("EQ No Not Exist");
								model.		setDtnUseFlg("0");
							}else{
								model.		setEqTpszCd(eqTpSzCdInput);
								model 		= fillEqNo(model, emptyWoList, childVndrList);
								if("".equals(model.getEqNo())
										|| "".equals(model.getTrspSoSeq())){
									model.	setEdiRcvRsltMsg("No corresponding EQ No - W/O No");
									model.	setDtnUseFlg("0");
								}else{
									ArrayList dupList = command.searchInvoiceImportDuplicateCheckByDate(model);
									String dupStr = getDuplicateCheckByDateString(dupList);
									
									if( dupStr.length()>0){
										if(model.getEdiRcvRsltMsg().length()>0){
											dupStr = model.getEdiRcvRsltMsg() + " / " + dupStr;
										}
										model.	setEdiRcvRsltMsg(dupStr);
									}
								}
							}
						}else{
							model.			setEdiRcvRsltMsg("No corresponding EQ No - W/O No");
							model.			setDtnUseFlg("0");
						}
					}else{
						model.				setDtnUseFlg("1");
						model.				setTrspSoOfcCtyCd(rs.getString("TRSP_SO_OFC_CTY_CD"));
						model.				setTrspSoSeq(rs.getString("TRSP_SO_SEQ"));
						model.				setEqTpszCd(rs.getString("EQ_TPSZ_CD"));
						model				= fillCommon(model, rs, childVndrList);
						
						if(currCd == null || "".equals(currCd.trim())){
							currCd = rs.getString("CURR_CD");
						}else if(!currCd.equals(rs.getString("CURR_CD"))
								&& model.getDtnUseFlg().equals("1")){
							model.				setEdiRcvRsltMsg("Currency Mismatch ["+rs.getString("CURR_CD")+"]");
							model.				setDtnUseFlg("0");
						}
					}
					srcList.set(i, model);
				} else if(!"".equals(model.getTrspSoSeq()) &&"1".equals( model.getDtnUseFlg())){  
				/** SO LIST 처리 **/
					if(soList.get(i) != null ){
						rs 						= (DBRowSet) 			((DBRowSet)soList.get(i)).clone();
					}else{
						rs						= null;
					}
					if(rs == null || !rs.next()){
						model.					setEdiRcvRsltMsg("S/O No Not Exist");
						model.					setDtnUseFlg("0");
						model.					setEdiRcvRsltCd("1");
					}else{
						eqNo 					= rs.getString("EQ_NO");
						eqTpSzCd				= rs.getString("EQ_TPSZ_CD");
						
						if(eqNo == null || eqNo.equals("")){
							if(!model.getEqNo().equals("")){
								/** EQ NO Check **/
								
								eqTpSzCdInput = command.verifyEqNo(model.getEqNo());
								if(eqTpSzCdInput == null){
									model.		setEdiRcvRsltMsg("EQ No Not Exist");
									model.		setEdiRcvRsltCd("1");
									model.		setDtnUseFlg("0");
								}else if(!eqTpSzCdInput.equals(eqTpSzCd) &&
										!("Y".equals(rs.getString("TRSP_SO_TP_CD"))
										&& "O".equals(rs.getString("TRSP_BND_CD"))
										&& "DR".equals(rs.getString("TRSP_COST_DTL_MOD_CD"))) ){
									model.		setEdiRcvRsltMsg("EQ TP/SZ Mismatch");
									model.		setDtnUseFlg("0");
								}else if(eqTpSzCdInput.equals(eqTpSzCd) &&
										!("Y".equals(rs.getString("TRSP_SO_TP_CD"))
												&& "O".equals(rs.getString("TRSP_BND_CD"))
												&& "DR".equals(rs.getString("TRSP_COST_DTL_MOD_CD"))) ){
									model.		setEqTpszCd(eqTpSzCd);
									model 	= fillCommon(model, rs, childVndrList);
									if(!model.getEqNo().equals("")){
										ArrayList dupList = command.searchInvoiceImportDuplicateCheckByDate(model);
										String dupStr = getDuplicateCheckByDateString(dupList);
										if( dupStr.length()>0){
											if(model.getEdiRcvRsltMsg().length()>0){
												dupStr = model.getEdiRcvRsltMsg() + " / " + dupStr;
											}
											model.	setEdiRcvRsltMsg(dupStr);
										}
									}
								}else if("Y".equals(rs.getString("TRSP_SO_TP_CD"))
										&& "O".equals(rs.getString("TRSP_BND_CD"))
										&& "DR".equals(rs.getString("TRSP_COST_DTL_MOD_CD"))){
									model.		setEqTpszCd(eqTpSzCdInput);
									/** Bkg CNTR Check **/
									bkgBkgCntr 	= command.searchInvoiceImportBkgBkgCntr(rs, model);
									if(bkgBkgCntr == null){
										model.			setEdiRcvRsltMsg("BKG CNTR Mismatch");
										model.			setDtnUseFlg("0");
									}else{
										model = fillCommon(model, rs, childVndrList);
									}
									
								}
							}
						}else{
							model.				setEqNo(eqNo);
							model.				setEqTpszCd(eqTpSzCd);
							model				= fillCommon(model, rs, childVndrList);
						}
						model.					setTrspWoOfcCtyCd(rs.getString("TRSP_WO_OFC_CTY_CD"));
						model.					setTrspWoSeq(rs.getString("TRSP_WO_SEQ"));
						
						if(currCd == null || currCd.trim().equals("")){
							currCd = rs.getString("CURR_CD");
						}else if(!currCd.equals(rs.getString("CURR_CD"))
								&& model.getDtnUseFlg().equals("1")){
							model.				setEdiRcvRsltMsg("Currency Mismatch ["+rs.getString("CURR_CD")+"]");
							model.				setDtnUseFlg("0");
						}
					}
					srcList.set(i, model);
				}
			}
			
			/** SO, WO/EQ NO 중복체크 **/
			srcList = checkDupSoWoEqNo(srcList);
			
			/** OPENER SHEET의 SO, WO/EQ NO 중복체크 **/
			srcList = checkDupOpenerSoWoEqNo(srcList, openerList);
			//resultHashMap.put("resultList", srcList);
			//eventResponse =  new GeneralEventResponse(resultHashMap,"SUCCESS");
			eventResponse =  new GeneralEventResponse();
			eventResponse.setRsVo(srcList);
			
		
				
		}catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Duplicate 리스트를 String으로 변환한다.<br>
	 * @param ArrayList rsList 
	 * @return String
	 * @exception
	 */
	private String getDuplicateCheckByDateString(ArrayList rsList){
		
		StringBuffer returnStr = new StringBuffer();
		if(rsList != null && rsList.size()>0){
			for(int i=0; i<rsList.size(); i++){
				TrsTrspSvcOrdVO model = (TrsTrspSvcOrdVO) rsList.get(i);
				
				if(i>0)	returnStr.append(" / ");
				returnStr.append(model.getTrspSoOfcCtyCd());
				returnStr.append(model.getTrspSoSeq());
				returnStr.append(" , ");
				returnStr.append(model.getCreDt());
				returnStr.append(" , ");
				returnStr.append(model.getFmNodCd());
				returnStr.append("-");
				returnStr.append(model.getToNodCd());
				returnStr.append(" , ");
				returnStr.append(model.getTrspCostDtlModCd());
				returnStr.append(" , ");
				returnStr.append(model.getTrspCrrModCd());
			}
		}
		return returnStr.toString();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SurchargeInputInquiry 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTruckInvoiceFileImport(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse 		= null;
		EsdTrs0033Event event 				= (EsdTrs0033Event)e;
		
		try{
			InvoiceAuditBCImpl command 		= new InvoiceAuditBCImpl();
			eventResponse = command.searchTruckInvoiceFileImport(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SurchargeInputInquiry 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceImportDuplicateCheckByDate2(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0033Event event 				= (EsdTrs0033Event)e;
		
		try{
			InvoiceAuditBCImpl command 		= new InvoiceAuditBCImpl();
			eventResponse = command.searchInvoiceImportDuplicateCheckByDate2(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchN3ptyCurrCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchN3ptyCurrCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * invoiceaudit의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyRailInvoiceFileImportEqNo(Event e) throws EventException {

		EsdTrs0923Event event=(EsdTrs0923Event)e;
		GeneralEventResponse eventResponseReturn = new GeneralEventResponse();
		
		String invNo				= null;
		String result				= null;
		String tabType				= null;
		
		ArrayList seqList			= event.getSeqNoList();
		ArrayList eqNoList			= event.getCntrNoList();
		ArrayList wbl_dtList		= event.getWblDtList();
		ArrayList invBilAmtList		= event.getInvBilAmtList();
		
		ArrayList resultList		= event.getResultList();
		ArrayList hashList			= new ArrayList();
		ArrayList rsltSetList		= new ArrayList();
		ArrayList eqtpszList		= new ArrayList();
		ArrayList railAudCdList		= new ArrayList();
		HashMap resultHashMap		= new HashMap();
		
		ArrayList vndrSetList		= null;
		ArrayList soIFList			= null;
		DBRowSet rowSet				= null;
		
	
		try {
			RailInvoiceauditBC command = new RailInvoiceauditBCImpl();
			ArrayList eqNoListClon = command.verifyInvoiceFileImportEqNo(event);
			
			for(int i=0; i<seqList.size(); i++){
				hashList.add(null);
				rsltSetList.add(null);
				eqtpszList.add(null);
				railAudCdList.add(null);
			}
			
			ArrayList eqNoListTemp = (ArrayList) eqNoList.clone();
			resultList = getDupEqNoList(eqNoListTemp, resultList);
			
			
			/* eq_no가 존재하지 않는건 결과 표시 */
			for(int idx = 0; idx < eqNoListClon.size(); idx++){
				rowSet = (DBRowSet) eqNoListClon.get(idx);
				if(rowSet!= null && rowSet.next()){
					eqtpszList.set(idx, rowSet.getString("CNTR_TPSZ_CD"));
				}else{
					resultList.set(idx, "Incorrect CNTR NO");
				}
			}

			event.setResultList(resultList);
			/* container no 존재여부 확인 완료 */

			/* inv_no가 존재하는 건 결과표시 */
			ArrayList invNoList	= command.verifyInvoiceFileImportInvNo(event);
			
			for(int idx=0; idx < invNoList.size(); idx++){
				rowSet = (DBRowSet) invNoList.get(idx);
				while(rowSet!=null && rowSet.next()){
					invNo = rowSet.getString("INV_NO");
					resultList.set(idx, "Already Exists Invoice NO("+invNo+")");
				}
			}
			
			event.setResultList(resultList);
			
			/* vndr set table, so if table List 검색 */
			vndrSetList = command.verifyInvoiceFileImportVndrSetList(event);
			soIFList = command.verifyInvoiceFileImportSoIFList(event);
			
			DBRowSet vndrSetRowSet	= null;
			DBRowSet soIFRowSet		= null;
			
			int vndrSetSize			= 0;
			int soIFSize			= 0;
			for (int k=0; k<seqList.size(); k++){
				
				HashMap tempMap		= new HashMap();
				DBRowSet resultRow	= null;
				result = (String) resultList.get(k);
				
				vndrSetRowSet 	= (DBRowSet) vndrSetList	.get(k);
				soIFRowSet 		= (DBRowSet) soIFList		.get(k);
				vndrSetSize		= getRsltSize(vndrSetRowSet);
				soIFSize		= getRsltSize(soIFRowSet);
				
				if(result == null || result.trim().equals("")){
					
					/* NIS Hanjin이 존재하는지 여부 확인 */
					if(checkIsNis(soIFRowSet)){
						tempMap.put("for_nis_check", "1");
					}
					
					/* 양쪽 table 모두 존재하지 않으면 Invoice Only  */
					if(vndrSetSize == 0 && soIFSize == 0){
						resultList.set(k, "Invoice Only");
						tempMap	.put("inv_only_check", "1");
						railAudCdList.set(k, "I");
					/* vndr만 1개 존재할때 */
					}else if(vndrSetSize == 1 && soIFSize == 0){
						// 9/7 TEST 때문에 추가
						if (!checkCurrency(vndrSetRowSet, event.getCurrency())){
							resultList.set(k, "Currency Differ");
						}else{
							tabType = getString(vndrSetRowSet, "TRSP_RAIL_INV_AUD_CD");
							if(tabType.equals("C")){
								tempMap.put("coincidence_check", "1");
								railAudCdList.set(k, "C");
							}else if(tabType.equals("D")){
								tempMap.put("descrepancy_check", "1");
								railAudCdList.set(k, "D");
							}
							resultList.set(k, "SML");
							resultRow = vndrSetRowSet;
						}
						
					/* SO IF만 1개 존재할때 */
					}else if(vndrSetSize == 0 && soIFSize == 1){
						if (!checkCurrency(soIFRowSet, event.getCurrency())){
							resultList.set(k, "Currency Differ");
						}else{
							tabType = getString(soIFRowSet, "TRSP_INV_CO_IND_CD");
							if(tabType.equals("DOM")){
								tabType = getString(soIFRowSet, "TRSP_RAIL_INV_AUD_CD");
								if(tabType.equals("C")){
									tempMap.put("coincidence_check", "1");
									railAudCdList.set(k, "C");
								}else if(tabType.equals("D")){
									tempMap.put("descrepancy_check", "1");
									railAudCdList.set(k, "D");
								}
								resultList.set(k, "Domestic");
							}
							resultRow = soIFRowSet;
						}
					}else if((vndrSetSize == 1 && soIFSize == 1) || vndrSetSize > 1 ){
						if (!checkCurrency(vndrSetRowSet, event.getCurrency())){
							resultList.set(k, "Currency Differ/Multiple SO");
						}else{
							tempMap.put("inv_only_check", "1");
							resultList.set(k, "Multiple SO");
							resultRow = vndrSetRowSet;
							railAudCdList.set(k, "I");
						}
					}else if(vndrSetSize == 0 && soIFSize > 1){
						if (!checkCurrency(soIFRowSet, event.getCurrency())){
							resultList.set(k, "Currency Differ/Multiple SO");
						}else{
							tempMap.put("inv_only_check", "1");
							resultList.set(k, "Multiple SO");
							resultRow = soIFRowSet;
							railAudCdList.set(k, "I");
						}
					}
				}else if(result.equals("Duplicated  CNTR")){
					tempMap.put("inv_only_check", "1");
					if(soIFSize == 0) 
						resultRow = vndrSetRowSet;
					else 
						resultRow = soIFRowSet;
				}
				hashList.set(k, tempMap);
				if(resultRow == null) resultRow = vndrSetRowSet;
				rsltSetList.set(k, resultRow);
			}
			
			resultHashMap.put("hashList"				, hashList);
			resultHashMap.put("seqList"					, seqList);
			resultHashMap.put("eqNoList"				, eqNoList);
			resultHashMap.put("resultList"				, resultList);
			resultHashMap.put("rsltSetList"				, rsltSetList);
			resultHashMap.put("eqtpszList"				, eqtpszList);
			resultHashMap.put("railAudCdList"			, railAudCdList);
			resultHashMap.put("wbl_dtList"				, wbl_dtList);
			resultHashMap.put("invBilAmtList"			, invBilAmtList);
			resultHashMap.put("hashParam"				, event.getColumnValues());
			
			/* 결과를 return */
			event.setHashParam(resultHashMap);
			eventResponseReturn.setRsVo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponseReturn;
	}

	/**
	 * result set size 가져오기<br>
	 * invoiceaudit의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param src DBRowSet
	 * @return int result set size
	 * @exception Exception
	 */
	private ArrayList getDupEqNoList(ArrayList eqNoList, ArrayList resultList) throws Exception {
		
		String curEqNo = null;
		int findIdx = -1;
		
		for(int i=0; i< eqNoList.size(); i++){
			curEqNo = (String) eqNoList.get(i);
			if(curEqNo != null){
				eqNoList.set(i, null);
				while( (findIdx=eqNoList.indexOf(curEqNo)) != -1 ){
					eqNoList.set(findIdx, null);
					resultList.set(findIdx, "Duplicated  CNTR");
				}
			}
		}
		return resultList;
	}
	
	/**
	 * result set size 가져오기<br>
	 * invoiceaudit의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param src DBRowSet
	 * @return int result set size
	 * @exception Exception
	 */
	private int getRsltSize(DBRowSet src) throws Exception {
		int size					= 0;
		
		if(src == null) return 0;
		DBRowSet tgt				= (DBRowSet) src.clone();
		while(tgt.next()){
			size++;
		}
		return size;
	}
	
	/**
	 * result set size 가져오기<br>
	 * invoiceaudit의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param src DBRowSet
	 * @return int result set size
	 * @exception Exception
	 */
	private boolean checkIsNis(DBRowSet src) throws Exception {
		boolean isNis = false;
		if(src == null) return false;
		DBRowSet tgt				= (DBRowSet) src.clone();
		String coIndCd				= null;
		while(tgt.next()){
			coIndCd = tgt.getString("TRSP_INV_CO_IND_CD");
			if(coIndCd != null && coIndCd.equals("NIS")){
				isNis = true;
				break;
			}
		}
		return isNis;
	}
	
	/**
	 * result set size 가져오기<br>
	 * invoiceaudit의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param src DBRowSet
	 * @return int result set size
	 * @exception Exception
	 */
	private String getString(DBRowSet src,String colName) throws Exception {
		if(src == null) return null;
		DBRowSet tgt				= (DBRowSet) src.clone();
		String tabCd				= null;
		if(tgt.next()){
			tabCd = tgt.getString(colName);
		}
		return tabCd;
	}
	
	/**
	 * result set size 가져오기<br>
	 * invoiceaudit의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param src DBRowSet
	 * @return int result set size
	 * @exception Exception
	 */
	private boolean checkCurrency(DBRowSet src, String cur) throws Exception {
		boolean equalsCur = false;
		if(src == null) return false;
		DBRowSet tgt				= (DBRowSet) src.clone();
		String invCur				= null;
		if(tgt.next()){
			invCur = tgt.getString("CURR_CD");
			if( (invCur != null && invCur.equals(cur)) || invCur==null || (invCur != null && invCur.equals(""))){
				equalsCur = true;
			}
		}
		return equalsCur;
	}
	

	/**
	 * 조회 이벤트 처리<br>
	 * Railinvoiceaudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailinvoiceauditList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			RailInvoiceauditBC command = new RailInvoiceauditBCImpl();
			eventResponse = command.searchRailinvoiceauditList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Container History  화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentHistoryList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			RailInvoiceauditBC command = new RailInvoiceauditBCImpl();
			eventResponse = command.searchPaymentHistoryList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * 멀티 이벤트 처리<br>
	 * Railinvoiceaudit의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyRailinvoiceaudit(Event e) throws EventException {
		
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0038Event event=(EsdTrs0038Event)e;
		TrsTrspRailInvDtlVO[] model = event.getTrsTrspRailInvDtlVos();
		
		List ibflagArr = new ArrayList();
		
		for(int i = 0; i < model.length; i++){
			ibflagArr.add(model[i].getIbflag());
		}
		
		String[] ibflag = (String[])ibflagArr.toArray(new String[ibflagArr.size()]);
		
	    DBRowSet rowSet[] ;
	    
		try {
			RailInvoiceauditBC command = new RailInvoiceauditBCImpl();
			TrsCommonBC commCommand =  new TrsCommonBCImpl();
			if ( ibflag != null)
		    {
				rowSet = command.searchReAuditVerify(event);
		    	
				begin();
				command.modifyRailinvoiceaudit(e);
				
				TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();
				soHisVo.setInvNo(event.getInvNo());
				soHisVo.setInvVndrSeq(event.getInvVndrSeq());
				
				soHisVo.setTrspSoEvntCd("CF".equals(event.getSStsCd()) ? "II" : "IS");		
				
				soHisVo.setSrcCd("USRAIL");
				soHisVo.setCreUsrId(event.getSignOnUserAccount().getUsr_id());	
				soHisVo.setCreOfcCd(event.getSignOnUserAccount().getOfc_cd());
				commCommand.multiSoHistory(soHisVo);

				commit();
		    }
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Re Audit History  화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReAuditInfoList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			RailInvoiceauditBC command = new RailInvoiceauditBCImpl();
			eventResponse = command.searchReAuditInfoList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Re Audit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerInfo(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			RailInvoiceauditBC command = new RailInvoiceauditBCImpl();
			eventResponse = command.searchContainerInfo(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * searchCSRSummary<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCSRSummary(Event e) throws EventException {

		EsdTrs0031Event event = (EsdTrs0031Event)e;

		EventResponse eventResponse = null;
		
		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();

			eventResponse = command.searchCSRSummary(event);			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * checkASANO<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse checkASANO(Event e) throws EventException {

		EsdTrs0031Event event = (EsdTrs0031Event)e;

		EventResponse eventResponse = null;
		
		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.checkASANO(event);			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * searchCSRSummaryDetail<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCSRSummaryDetail(Event e) throws EventException {

		EsdTrs0032Event event = (EsdTrs0032Event)e;

		EventResponse eventResponse = null;
		
		try {
			//begin();
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSummaryDetail(event);	
			//commit();
		} catch (EventException de) {
			//rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * correctCsrAmt<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse correctCsrAmt(Event e) throws EventException {

		EsdTrs0032Event event = (EsdTrs0032Event)e;

		EventResponse eventResponse = null;
		
		try {
			begin();
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.correctCsrAmt(event);	
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err [correctCsrAmt] " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * generateNewCsrNo<BR>
	 * 
	 * @param e ESD_TRS_032Event
	 * @param sCsrType String 
	 * @param sPreviewIndicator String
	 * @return sCsrNo String 
	 * @throws EventException
	 */
	private String generateNewCsrNo(EsdTrs0032Event e) throws EventException {

		EsdTrs0032Event 	event 	= (EsdTrs0032Event)e;
		String				sCsrNo	= null;

		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			sCsrNo	= command.generateNewCsrNo(event);
		} catch (EventException de) {
			log.error("err [generateNewCsrNo] " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return sCsrNo;
	}	
	/**
	 * createApInvHdrDtrb<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse createApInvHdrDtrb(Event e) throws EventException {

		EsdTrs0032Event 	event 	= (EsdTrs0032Event)e;
		EventResponse eventResponse = null;

		try {
			begin();
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse	= command.createApInvHdrDtrb(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err [createApInvHdrDtrb] " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * createApInvIF<BR>
	 * 
	 * @param e Event
	 * @throws EventException
	 */
	private void createApInvIF(Event e) throws EventException {

		CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
		
		EsdTrs0032Event 	event 	= (EsdTrs0032Event)e;

		try {
			begin();
			command.createApInvIF(event);
			commit();
		} catch (EventException de) {
			rollback();					
			log.error("err [createApInvIF] " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * checkApInvDtrbValidation<BR>
	 * 
	 * @param sCsrNo String
	 * @throws EventException
	 */
	private void checkApInvDtrbValidation(String sCsrNo) throws EventException {

		try {
			begin();
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			command.checkApInvDtrbValidation(sCsrNo);	
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err [checkApInvDtrbValidation] " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * updateApInvDtrbLineNo<BR>
	 * 
	 * @param sCsrNo String 
	 * @throws EventException
	 */
	private void updateApInvDtrbLineNo(String sCsrNo) throws EventException {
		
		CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
		
		try {
			begin();
			String ofcCd = account.getOfc_cd();
			command.updateApInvDtrbLineNo(sCsrNo, ofcCd);	
			commit();
		} catch (EventException de) {
			rollback();
			
			try{
				begin();
				command.deleteInvHdrDtrbList	(sCsrNo	);
				commit();
			}catch(EventException de2){
				rollback();
				log.error("err [inner deleteInvHdrDtrbList] " + de.toString(), de2);
				throw new EventException(de2.getMessage());
			}
			
			log.error("err [updatePreviewInvDtrbLineNo] " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * selectApInvHdrDtrbList<BR>
	 * 
	 * @param sCsrNo String
	 * @param sPreviewIndicator String
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse selectApInvHdrDtrbList(String sCsrNo, String sPreviewIndicator) throws EventException {
		
		EventResponse eventResponse = null;
		
		try {
			begin();
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse	= command.selectApInvHdrDtrbList(sCsrNo, sPreviewIndicator);	
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err [selectPreviewInvHdrDtrbList] " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchTAXInfo<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTAXInfo(Event e) throws EventException {

		EsdTrs0034Event event = (EsdTrs0034Event)e;

		EventResponse eventResponse = null;
		
		try {
			
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchTAXInfo(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * searchApEviNo<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchApEviNo(Event e) throws EventException {

		EsdTrs0034Event event = (EsdTrs0034Event)e;

		EventResponse eventResponse = null;
		
		try {
			begin();
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchApEviNo(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * searchTAXCode<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTAXCode(Event e) throws EventException {

		EsdTrs0034Event event = (EsdTrs0034Event)e;

		EventResponse eventResponse = null;
		
		try {			
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchTAXCode(event);			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * multiInvoiceAuditRefund<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse multiInvoiceAuditRefund(Event e) throws EventException{
		EsdTrs0040Event evnet = (EsdTrs0040Event) e;
		EventResponse eventResponse = null;
		
		try {
			begin();
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.multiInvoiceAuditRefund(evnet);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * searchPaymentVnder<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPaymentVnder(Event e) throws EventException{
		EsdTrs0040Event evnet = (EsdTrs0040Event) e;
		EventResponse eventResponse = null;
		
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchPaymentVnder(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * searchInvoiceNo<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchInvoiceNo(Event e) throws EventException{
		EsdTrs0040Event evnet = (EsdTrs0040Event) e;
		EventResponse eventResponse = null;
		
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchInvoiceNo(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * searchRefundList<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRefundList(Event e) throws EventException{
		EsdTrs0040Event evnet = (EsdTrs0040Event) e;
		EventResponse eventResponse = null;
		
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchRefundList(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * searchRailInvoiceInquiryCorrectionList<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRailInvoiceInquiryCorrectionList(Event e) throws EventException{
		EsdTrs0046Event evnet = (EsdTrs0046Event) e;
		EventResponse eventResponse = null;
		
		try {
			RailInvoiceInquiryCorrectionBC command = new RailInvoiceInquiryCorrectionBCImpl();
			eventResponse = command.searchRailInvoiceInquiryCorrectionList(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * multiRailInvoiceHold<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse multiRailInvoiceHold(Event e) throws EventException{
		EsdTrs0046Event evnet = (EsdTrs0046Event) e;
		EventResponse eventResponse = null;
		
		try {
			begin();
			RailInvoiceInquiryCorrectionBC command = new RailInvoiceInquiryCorrectionBCImpl();
			eventResponse = command.multiRailInvoiceHold(evnet);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * removeRailInvoiceInquiryCorrection<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse removeRailInvoiceInquiryCorrection(Event e) throws EventException{
		EsdTrs0046Event event = (EsdTrs0046Event) e;
		EventResponse eventResponse = null;
		
		try {
			begin();
			RailInvoiceInquiryCorrectionBC command = new RailInvoiceInquiryCorrectionBCImpl();
			TrsCommonBC commCommand =  new TrsCommonBCImpl();

			TrsTrspRailInvWrkVO[]       multiVos  = event.getTrsTrspRailInvWrkVOs();
			if (multiVos != null) {
				String usrId    = event.getInquiryConditionVO().getUsrId();
				String usrOfcCd = event.getInquiryConditionVO().getUsrOfcCd();
				
				for (int i = 0 ; i < multiVos.length ; i ++) {
					TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();  
					soHisVo.setTrspSoOfcCtyCd("");
					soHisVo.setInvNo(multiVos[i].getInvNo());
					soHisVo.setInvVndrSeq(multiVos[i].getInvVndrSeq());
					soHisVo.setTrspSoEvntCd("ID");
					soHisVo.setSrcCd("USRAIL");
					soHisVo.setCreUsrId(usrId);
					soHisVo.setCreOfcCd(usrOfcCd);
					commCommand.multiSoHistory(soHisVo);
				}	
			}
			
			eventResponse = command.removeRailInvoiceInquiryCorrection(event);
			
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


	/**
	 * multiRailInvoiceConfirmCancel<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse multiRailInvoiceConfirmCancel(Event e) throws EventException{
		EsdTrs0046Event event = (EsdTrs0046Event) e;
		EventResponse eventResponse = null;
		
		try {
			begin();
			RailInvoiceInquiryCorrectionBC command = new RailInvoiceInquiryCorrectionBCImpl();
			TrsCommonBC commCommand =  new TrsCommonBCImpl();
			
			eventResponse = command.multiRailInvoiceConfirmCancel(event);
			
			TrsTrspRailInvWrkVO[]       multiVos  = event.getTrsTrspRailInvWrkVOs();
			if (multiVos != null) {
				String usrId    = event.getInquiryConditionVO().getUsrId();
				String usrOfcCd = event.getInquiryConditionVO().getUsrOfcCd();
				
				for (int i = 0 ; i < multiVos.length ; i ++) {
					TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();  
					soHisVo.setTrspSoOfcCtyCd("");
					soHisVo.setInvNo(multiVos[i].getInvNo());
					soHisVo.setInvVndrSeq(multiVos[i].getInvVndrSeq());
					soHisVo.setTrspSoEvntCd("IX");
					soHisVo.setSrcCd("USRAIL");
					soHisVo.setCreUsrId(usrId);
					soHisVo.setCreOfcCd(usrOfcCd);
					commCommand.multiSoHistory(soHisVo);
				}	
			}
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * searchInvoiceListInquiry <BR>
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchInvoiceListInquiry(Event e) throws EventException{
		EsdTrs0960Event evnet = (EsdTrs0960Event) e;
		EventResponse eventResponse = null;
		
		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchInvoiceListInquiry(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * searchCSRAPiflist <BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCSRAPiflist(Event e) throws EventException {

		log.debug("\n\n SC - searchCSRAPiflist() \n\n");

		EsdTrs0047Event event = (EsdTrs0047Event)e;

		EventResponse eventResponse = null;

		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRAPiflist(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * cancelCSRAPifError <BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse cancelCSRAPifError(Event e) throws EventException {

		log.debug("\n\n SC - cancelCSRAPif() \n\n");

		EsdTrs0047Event event = (EsdTrs0047Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			command.cancelCSRAPifError(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
	/**
	 * cancelCSRApprovalRequest <BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse cancelCSRApprovalRequest(Event e) throws EventException {

		log.debug("\n\n SC - cancelCSRApprovalRequest() \n\n");

		EsdTrs0047Event event = (EsdTrs0047Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String csrNo = event.getCsrNo();
		try {
			begin();
			ApprovalBC apCommand = new ApprovalBCImpl();
			apCommand.cancelApproval(csrNo);
			
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			//CHM-201534969 CSR Cancel 이력 관리 2015.04.16
			command.cancelCSRApprovalRequest(event);
			
			//CSR Cancel 처리시 USR_APRO_STEP_FLG = ''으로 업데이트
			ComCsrInfoVO comCsrInfoVO =new ComCsrInfoVO();		
			ApprovalUtil aproUtil = new ApprovalUtil();
			
			comCsrInfoVO.setCsrNo(JSPUtil.getNull(event.getCsrNo()));
			comCsrInfoVO.setCsrAproTpCd(event.getCsrTpCd());
			aproUtil.updateAproGwDt(comCsrInfoVO);
			
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			// TODO Auto-generated catch block
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
	
	/**
	 * cancelCSRAPif <BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse cancelCSRAPif(Event e) throws EventException {

		log.debug("\n\n SC - cancelCSRAPif() \n\n");

		EsdTrs0048Event event = (EsdTrs0048Event)e;
		EventResponse eventResponse = null;
		try {
			begin();
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
//			command.cancelCSRAPif(event);
			eventResponse = command.cancelCSRAPif(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * modifyTrsInvHdr <br>
	 * 
	 * @param e Event
	 * @throws EventException
	 */
	public void modifyTrsInvHdr(Object e) throws EventException {

		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			command.modifyTrsInvHdr(e);	
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * searchCsrCancel 이벤트<br> 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCsrCancel(Event e) throws EventException{
		EsdTrs0048Event evnet = (EsdTrs0048Event) e;
		EventResponse eventResponse = null;
		
		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCsrCancel(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * searchCsrPreVeiw 이벤트<br>>	 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCsrPreVeiw(Event e) throws EventException {

		EsdTrs0047Event 	event 		= (EsdTrs0047Event)e;
//		HashMap				hashParam	= event.getHashParam();
		String				sCsrNo		= event.getCsrNo();
		
		EventResponse eventResponse = null;
		
		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCsrPreVeiw(sCsrNo);	
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	
	/**
	 * approval Request이벤트<br>>	 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse approvalRequest(Event e) throws EventException {

		String			sCsrNo				= null;
		EsdTrs0032Event	event				= (EsdTrs0032Event)e;
		DBRowSet[]		oApDtrbRowSetArr	= null;	
		EventResponse 	eventResponse 		= null;
		
		CSRIssueTransferSlipManageBC command	= new CSRIssueTransferSlipManageBCImpl();
		
		try{
			
			begin();
			command.correctCsrAmt(event);
			commit();
			
		}catch(EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		sCsrNo	= command.generateNewCsrNo(event);
		event.setCsr_no(sCsrNo);
		
		/** 2008.04.14:jsk Container Finc VVD Update	Logic Append */
		try{
			
			begin();
			command.updateCntrFincVVD(event);	/* 2008.04.14:jsk Container Finc VVD Update	Logic Append */
			commit();
			
		}catch(EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}			
		
		oApDtrbRowSetArr = command.generateApInvDTRB(event);
		event.setApDtrbRowSetArr(oApDtrbRowSetArr);

		try{
			
			begin();
			eventResponse	= command.createApInvHdrDtrb	(event);
			command.updateApInvDtrbLineNo					(sCsrNo, account.getOfc_cd());
			command.checkApInvDtrbValidation				(sCsrNo);
			command.createApInvIF							(event);
			commit();
			
		}catch(EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		String sMstInvFileFlg = event.getMstInvFileFlg();
		String sVndrSeq = event.getVndrSeq();
		String sUsrId = event.getCreUsrId();

		if (sMstInvFileFlg.equals("Y") ) {
			begin();
			command.createInvPdfFile(sCsrNo, sVndrSeq, sUsrId); // PDF 파일 생성
			commit();
		}
		
		return eventResponse;
	}
	
	/**
	 * approval preview 이벤트<br>>	 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse approvalPreview(Event e) throws EventException {

		String				sCsrNo				= null;
		EsdTrs0032Event	event				= (EsdTrs0032Event)e;
		DBRowSet[]			oApDtrbRowSetArr	= null;	
		EventResponse 		eventResponse 		= null;
		
		CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
		
		try{
			
			begin();
			command.correctCsrAmt							(event)				;
			commit();
			
		}catch(EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		/** 2008.04.14:jsk Container Finc VVD Update	Logic Append */
		try{
			
			begin();
			command.updateCntrFincVVD						(event)				;	/* 2008.04.14:jsk Container Finc VVD Update	Logic Append */
			commit();
			
		}catch(EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}			
		
		sCsrNo	= command.generateNewCsrNo(event);
		event.setCsr_no(sCsrNo);
		
		oApDtrbRowSetArr = command.generateApInvDTRB(event);
		event.setApDtrbRowSetArr(oApDtrbRowSetArr);

		try{
			
			begin();
			command.createApInvHdrDtrb(event);
			command.updateApInvDtrbLineNo(sCsrNo, account.getOfc_cd());
			commit();
			
			eventResponse	= selectApInvHdrDtrbList(sCsrNo, "PREVIEW");
			command.deleteInvHdrDtrbList(sCsrNo);

		}catch(EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		
		return eventResponse;
	}
	
	
	
	/**
	 * Invoice Pool 샤시를 임시적으로 저장시 추가하는 이벤트처리<br>>	 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	
	private EventResponse insertInvoicePoolChassis(Event e) throws EventException{
		EsdTrs0041Event evnet = (EsdTrs0041Event) e;
		EventResponse eventResponse = null;
		
		try {
			begin();
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.insertInvoicePoolChassis(evnet);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * Invoice Pool 샤시를 임시적으로 저장시 업데이트하는 이벤트처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse updateInvoicePoolChassis(Event e) throws EventException{
		EsdTrs0041Event evnet = (EsdTrs0041Event) e;
		EventResponse eventResponse = null;
		
		try {
			begin();
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.updateInvoicePoolChassis(evnet);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * Invoice Pool 샤시를 confirm 및 저장 추가 이벤트처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	
	private EventResponse confirmInsertInvoicePoolChassis(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event = (EsdTrs0041Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;		
		
		try {
			begin();
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.confirmInsertInvoicePoolChassis(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * Invoice Pool 샤시를 confirm 및 저장 업데이트 이벤트처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmUpdateInvoicePoolChassis(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event = (EsdTrs0041Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			begin();
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.confirmUpdateInvoicePoolChassis(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}		
	
	/**
	 * PoolChassis화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoicePoolChassisList(Event e) throws EventException{
		EsdTrs0041Event evnet = (EsdTrs0041Event) e;
		EventResponse eventResponse = null;
		
		try {
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.searchInvoicePoolChassisList(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * 샤시 Pool에 대해 매핑된 Payment S/P 를 조회한다.<br>	 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getPaymentSPList(Event e) throws EventException {

		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.getPaymentSPList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**	 
	 * Invoice No에 대하여 중복체크를 한다.<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse dupChkPoolChassisInvoiceNo(Event e) throws EventException{
		EsdTrs0041Event evnet = (EsdTrs0041Event) e;
		EventResponse eventResponse = null;
		
		try {
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.dupChkPoolChassisInvoiceNo(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * Invoice No에 다한 Confirm 처리하는 이벤트 <br>		
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmInvoicePoolChassis(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event = (EsdTrs0041Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;		
		
		try {
			begin();		
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.confirmInvoicePoolChassis(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);			
			rollback();	
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**	 
	 * Invoice No에 다한 Confirm 을 Cancel 처리하는 이벤트 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmCancelInvoicePoolChassis(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event = (EsdTrs0041Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;		
		
		try {
			begin();
			PoolChassisBC command = new PoolChassisBCImpl();			
			eventResponse = command.confirmCancelInvoicePoolChassis(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}		
	
	/**
	 *  Invoice Pool 샤시를 삭제하는 이벤트 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteInvoicePoolChassis(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event = (EsdTrs0041Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			begin();
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.deleteInvoicePoolChassis(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceAudit 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0040Event event = (EsdTrs0040Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchVendor(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 샤시 Pool 목록을 조회한다.<br>	 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getPoolList(Event e) throws EventException {

		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.getPoolList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**	 
	 * Hold Invoice No에 대하여 체크 한다.<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckHoldInvoice(Event e) throws EventException{
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		EventResponse eventResponse = null;
		
		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCheckHoldInvoice(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**	 
	 * G/L month와 ASA month일치 여부에 대하여 체크 한다.<br>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckGLMonth(Event e) throws EventException{
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		EventResponse eventResponse = null;
		
		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCheckGLMonth(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
    private EventResponse searchIdaTaxRto(Event e) throws EventException {    	
    	EventResponse eventResponse = null;
    	try {
    	InvoiceAuditBC command = new InvoiceAuditBCImpl();
    	eventResponse = command.searchIdaTaxRto(e);
    	} catch (EventException ex) {
    		log.error("err " + e.toString(), ex);
    		throw new EventException(ex.getMessage());
    	}    	
    	return eventResponse;
    }
    
    private EventResponse verifySacNo(Event e) throws EventException {
    	EventResponse eventResponse = null;
    	EsdTrs0033Event event = (EsdTrs0033Event)e;
    	InvoiceAuditBC command = new InvoiceAuditBCImpl();
    	try {
    		eventResponse = command.verifySacNo(event);
    	} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
    	return eventResponse;
    }
    
    private EventResponse searchInvoiceInquiryIdaList(Event e) throws EventException {
    	EsdTrs0030Event event = (EsdTrs0030Event)e;
    	EventResponse eventResponse = null;
    	
    	try {
    		InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
    		eventResponse = command.searchInvoiceInquiryIdaList(event);
    	} catch (EventException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(de.getMessage());
    	}
    	return eventResponse;
    }
	
}