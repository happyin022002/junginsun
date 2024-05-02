/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RevenueAuditSC.java
*@FileTitle : RDN Issuance by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================
*/
package com.clt.apps.opus.esm.bkg.revenueaudit;

import java.util.ArrayList;
import java.util.List;


import com.asprise.util.tiff.l;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.ScOftAutoRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.ScOftAutoRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.TaaOftAutoRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.TaaOftAutoRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBC;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBCImpl;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0426Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0427Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0565Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0712Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration.RevenueDebitNoteDBDAO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RevDrNoteVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrAmtVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNoteVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesPerformanceVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesStatusVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltSearchRDNIssueMailingListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBC;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBCImpl;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0151Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0256Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0263Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0564Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0698Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0701Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1049Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1055Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1079Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1080Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1092Event;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCNTRQtyDiscrepancyListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCommodityAndRouteListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByHangerInstallationListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchChargeFilteringListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchItemListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchTypeListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchBLListbyAuditorVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchDiffAmountVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchStatusReportVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RlstSearchSelfAuditListVO;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBC;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBCImpl;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.table.ComBakEndJbVO;



/**
 * OPUS-RevenueAudit Business Logic ServiceCommand - NIS2010-RevenueAudit handling business transaction
 * 
 * @author 
 * @see RevenueDebitNoteDBDAO
 * @since J2EE 1.4
 */

public class RevenueAuditSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * RevenueAudit system preceding process for biz scenario<br>
	 * ESM_BKG_0426 related objects creation<br>
	 */
	public void doStart() {
		log.debug("RevenueAuditSC start");
		try {
			// comment --> Login Check
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * RevenueAudit system biz scenario closing<br>
	 * ESM_BKG_0426 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("RevenueAuditSC End");
	}

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// If the SC is to handle multiple events
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
			//search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchRDNIssueMailingList(e);
			}
			// Send bulk mail 
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
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // retrieve
				eventResponse = searchUnmatchItemList(e);
			}
		}
		//esm_bkg_1049 Unmatch Details end
		
		//esm_bkg_1055 Unmatch Description start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmBkg1055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // retrieve
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
			}else{
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
		//esm_bkg_0564 Un-match B/L Status Report end
		//////////////////////////////////////////////////////////////////////////////////
		
		return eventResponse;
	}
	
	//esm_bkg_0426 RDN Issuance by Regional Group start
	//////////////////////////////////////////////////////////////////////////////////
	
    /**
     * ESM_BKG_0426, ESM_BKG_0427 : Open<br>
     * initRDNIssuanceByAuditor the screen Combo Item retrieving for.<br>
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
        RsltCdListVO custVo = null;
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;   
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
     
            
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_BKG_0426 : Retrieve <br>
	 * RDN Issuance by Regional Group to look up information<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDNList(Event e) throws EventException {
			

		EsmBkg0426Event event = (EsmBkg0426Event) e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		
		RevDrNoteVO cVo = new RevDrNoteVO();
		//searchGubun 1:note, 2:amt
		String searchGubun = event.getRevDrNoteVO().getSearchGubun();
			
		//RDN List 
		List<RsltBkgRevDrNoteVO> rsltBkgRevDrNoteVOList = new ArrayList<RsltBkgRevDrNoteVO>();
		//AMT List
		List<RsltBkgRevDrAmtVO> rsltBkgRevDrAmtVOList 	= new ArrayList<RsltBkgRevDrAmtVO>();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{

			//Returns the query results
			cVo = command.searchRDNList(event.getRevDrNoteVO());
		
		
			//Vo container in response to each query result set by casting
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
				//blno, bkg Query the relevant data
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
	 * Create a new RDN​​.<br>
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

			command.createRDNbyIssueOffice(event.getRevDrNoteVO(),account);

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
	 * Modify RDN.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyRDNbyIssueOffice(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0426Event event = (EsmBkg0426Event)e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		try{
			begin();
			command.modifyRDNbyIssueOffice(event.getRevDrNoteVO(),account);
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
	 * Issue handling .<br>
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
	 * Issue handling<br>
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
	 * RDN is the Revise handling.<br>
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
	 * RDN ->Cancel <br>
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
	 * ESM_BKG_0426 : Settle <br>
	 * RDN.Settle-> modify<br>
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
	
	
	//esm_bkg_0712 RDN Receipt by Office start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_BKG_0712 : Retrieve <br>
	 * RDN -> search <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDNReceiptList(Event e) throws EventException {
			

		EsmBkg0712Event event = (EsmBkg0712Event) e;
		RevenueDebitNoteBC command = new RevenueDebitNoteBCImpl();
		
		
		//Container vo
		RevDrNoteVO cVo = new RevDrNoteVO();
		//searchGubun 1:note, 2:amt
		String searchGubun = event.getRevDrNoteVO().getSearchGubun();
			
		//RDN List 
		List<RsltBkgRevDrNoteVO> rsltBkgRevDrNoteVOList = new ArrayList<RsltBkgRevDrNoteVO>();
		//AMT List
		List<RsltBkgRevDrAmtVO> rsltBkgRevDrAmtVOList 	= new ArrayList<RsltBkgRevDrAmtVO>();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			//Container vo -> Returns the query results
			cVo = command.searchRDNList(event.getRevDrNoteVO());
		
		
			//Container vo -> Query results->response setting
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
			//CA NO -> Presence of lookup
			else if("6".equals(searchGubun)) {
				//CA NO COUNT
				eventResponse.setETCData("count_bkg_corr_no", cVo.getCntCano());
				log.debug("*********************************************************");
				log.debug("count_bkg_corr_no : " + eventResponse.getETCData("count_bkg_corr_no"));
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
	 * Modify RDN information.<br>
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
	 * RDN -> acceptRDNbyReceiptOffice to handle<br>
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
	 * RDN-> reviseRequestRDNbyReceiptOffice to handle<br>
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
	 * RDN-> cancelRequestRDNbyReceiptOffice to handle<br>
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
	 * RDN Status -> Retrieve<br>
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
	 * RDN Performance -> Retrieve<br>
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
     * (Mismatch B/L Inquiry by Auditor) Of the screen Combo Item List -> Retrieve<br>
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
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_BKG_0256 : Retrieve <br>
	 * Unmatch BL List -> Retrieve<br>
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
			//vo <- Returns the query results
			rsltUnmatchBLListbyAuditorVOList = command.searchUnmatchBLListbyAuditor(event.getRsltUnmatchBLListbyAuditorVO());
			//bkg count
	//		String bkgCnt = command.searchFilterdBkgCount(event.getRsltUnmatchBLListbyAuditorVO());
			//Query results->response setting
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
	 * Filtered BL Count-> Retrieve.<br>
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
	 * Unmatch Bl-> To handle<br>
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
	 * Unmatch Bl-> modify<br>
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
	 * Unmatch Bl -> Retrieve.<br>
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
			//vo <- Returns the query results
			rsltUnmatchBLListbyAuditorVOList = command.searchUnmatchBLListbyRegionalOffice(event.getRsltUnmatchBLListbyAuditorVO());
			
			//bkg count
	//		String bkgCnt = command.searchFilteredBkgCount(event.getRsltUnmatchBLListbyAuditorVO());
				
			
			
			//Query results->response setting
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
	 * Filtered B/L Count -> Retrieve<br>
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
	 * Unmatch Bl -> settle modify <br>
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
	 * Unmatch BL -> Save <br>
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
	 * Diff Amount Details-> Retrieve.<br>
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
			//vo <- Returns the query results
			rsltUnmatchDiffAmountVOList = command.searchUnmatchItemDetailList(event.getRsltUnmatchDiffAmountVO());
			//Query results->response setting
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
     * ESM_BKG_0564, ESM_BKG_0565 : Open<br>
     * (Mismatch B/L Status Report)  Of the screen Combo Item List -> Retrieve<br>
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
            if (e.getEventName().equalsIgnoreCase("EsmBkg0564Event")) {
            	// Contract Type 
                codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
                eventResponse.setCustomData("contractType", codeInfos);
            	// Rating Type 
                codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02131", 0);
                eventResponse.setCustomData("ratingType", codeInfos);
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
	 * Unmatch BL Status -> Retrieve.<br>
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
			//vo <- Returns the query results
			rsltUnmatchStatusReportVOList = command.searchUnmatchBLStatusList(event.getRsltUnmatchStatusReportVO());
			//Query results->response setting
			eventResponse.setRsVoList(rsltUnmatchStatusReportVOList);
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
	 * Unmatch Details List -> Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnmatchItemList(Event e) throws EventException {
		List<RsltSearchUnmatchItemListVO> list = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		EsmBkg1049Event event = (EsmBkg1049Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		String auditResultNm = "";
        CodeUtil cdUtil = CodeUtil.getInstance();
		
		try{
			
			list = command.searchUnmatchItemList(event.getRsltSearchUnmatchItemListVO());
			
    		// list count =0 ->Success
    		if(null != list && list.size() == 0) {
        		auditResultNm = cdUtil.getCodeName("CD02456", "M"); // Success, codenamed
    		}else if(null != list && list.size() > 0){
    			// list count > 0 ->Error
        		for(int i = 0; i < list.size(); i++) {
        			auditResultNm = list.get(i).getMtchUmchTpDesc();
           			if(list.get(i).getMtchUmchTpCd().equals("U")) { // Error 
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
	 * Unmatch Description List -> Retrieve<br>
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
     * (Charge Filtering) Of the screen Combo Item List -> Retrieve<br>
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
            // (office, js) and are adjusted : var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
            rhqOfcCd = JSPUtil.getNull(account.getRhq_ofc_cd());
            if(!rhqOfcCd.equals("")){
            	pVo = new RsltCdListVO();
            	pVo.setEtc2(rhqOfcCd);
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("office", customData);
            }
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);

            eventResponse.setCustomData("contractType", codeInfos);
            // Cargo Type => (Integration code) REVENUE AUDIT CARGO TYPE CODE ( CD02374 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02374", 0);
            eventResponse.setCustomData("cargoType", codeInfos);
        	// USA Service Mode Cd 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02286", 0);
            eventResponse.setCustomData("usaSvcModCd", codeInfos);
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            // R term -> Retrieve ( Integration code : CD00764 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00764", 0);
            eventResponse.setCustomData("rTerm", codeInfos);
            // D term -> Retrieve ( Integration code  : CD00765 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00765", 0);
            eventResponse.setCustomData("dTerm", codeInfos);

            // BKG Status => (Integration code)  BOOKING STATUS CODE ( CD00769 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00769", 0);
            eventResponse.setCustomData("bkgStatuCd", codeInfos);
            // Split Status => (Integration code) REVENUE AUDIT SPLIT STATUS CODE ( CD02376 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02376", 0);
            eventResponse.setCustomData("splitFlg", codeInfos);
            // Charge Status => (Integration code) REVENUE AUDIT CHARGE STATUS CODE ( CD02375 )
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
	 * ESM_BKG_0151 : Retrieve <br>
	 * Charge Filtering List search -> BackEndJob Execution<br>
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
     * (Charge Filtering) Of the screen Combo Item List -> Retrieve<br>
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
            //(office, js) and are adjusted	 : var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
            rhqOfcCd = JSPUtil.getNull(account.getRhq_ofc_cd());
            if(!rhqOfcCd.equals("")){
            	pVo = new RsltCdListVO();
            	pVo.setEtc2(rhqOfcCd);
                customData = command.searchRasOrganizationList(pVo);
                eventResponse.setCustomData("office", customData);
            }
        	// Contract Type 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("contractType", codeInfos);
            // Cargo Type => (Integration code) REVENUE AUDIT CARGO TYPE CODE ( CD02374 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02374", 0);
            eventResponse.setCustomData("cargoType", codeInfos);
        	// USA Service Mode Cd 
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02286", 0);
            eventResponse.setCustomData("usaSvcModCd", codeInfos);
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            // R term retrieve ( Integration code : CD00764 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00764", 0);
            eventResponse.setCustomData("rTerm", codeInfos);
            // D term retrieve ( Integration code : CD00765 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00765", 0);
            eventResponse.setCustomData("dTerm", codeInfos);

            // BKG Status => (Integration code) BOOKING STATUS CODE ( CD00769 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00769", 0);
            eventResponse.setCustomData("bkgStatuCd", codeInfos);
            // Split Status => (Integration code) REVENUE AUDIT SPLIT STATUS CODE ( CD02376 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02376", 0);
            eventResponse.setCustomData("splitFlg", codeInfos);
            // Charge Status => (Integration code) REVENUE AUDIT CHARGE STATUS CODE ( CD02375 )
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
	 * Audit by Commodity And Route List search -> BackEndJob Execution<br>
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
     * (Audit by CNTR Qty Discrepancy) Of the screen Combo Item List -> Retrieve<br>
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
            //(office, js) and are adjusted	 : var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
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
	 * Audit by CNTR Qty Discrepancy List -> Retrieve<br>
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
	 * Audit by CNTR Qty Discrepancy List -> Retrieve<br>
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
     * (Audit by Hanger Installation) Of the screen Combo Item List -> Retrieve<br>
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
            //(office, js) and are adjusted	 : var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
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
	 * Audit by Hanger Installation List -> Retrieve<br>
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
	 * Audit by Hanger Installation  save<br>
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
	 * RDN Issuance by Auditor Issue ->Subjects to be viewed.<br>
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
	
//    /**
//	 * 0263 : Retrive <br>
//	 * Self Audit List -> Retrieve<br>
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchSelfAuditList(Event e) throws EventException {
//		String blNo, bkgNo, svcScpCd, ctrtTpCd, caFlg;
//		List<UnmatchBLVO> listBkgCaFlgTp = null;
//		List<UnmatchBLVO> list = null;
//		EsmBkg0263Event event = (EsmBkg0263Event) e;
//		UnmatchBLBC command = new UnmatchBLBCImpl();
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		// RFA
//		RfaOftAutoRatingBC rfaOftCmd = new RfaOftAutoRatingBCImpl();
//		List<SearchRfaOftAutoratingListVO> rfaOftList = null;
//		// TAA
//		TaaOftAutoRatingBC taaOftCmd = new TaaOftAutoRatingBCImpl();
//		List<SearchTaaOftAutoratingListVO> taaOftList = null;
//		//
//		ScOftAutoRatingBC surCmd = new ScOftAutoRatingBCImpl();
//		List<SearchScOftAutoratingListVO> surList = null;
//		// AUD_STS_CD Update : 'CD02456' => M, Y 
//		// M (Success) => Y, U (Error) => E 
//		String auditResultNm = "";
//		String audSts = "";
//        CodeUtil cdUtil = CodeUtil.getInstance();
//		BlRatingBC blRateCmd = new BlRatingBCImpl();
//		
//		String rtAplyDt = ""; // YYYYMMDD 
//		
//		try {
//			
//			blNo = ""; bkgNo = ""; svcScpCd = ""; ctrtTpCd = ""; caFlg = "";
//			
//			blNo = JSPUtil.getNullNoTrim((String) event.getAttribute("bl_no"));
//			
//			//B/L No ->BkgNo,ctrt_tp_cd,caFlg
//			listBkgCaFlgTp = command.searchBkgCaFlg(blNo);
//            if (listBkgCaFlgTp != null && listBkgCaFlgTp.size() !=0 && listBkgCaFlgTp.get(0) != null){	     
//            	bkgNo    = listBkgCaFlgTp.get(0).getBkgNo().toString();
//            	ctrtTpCd = listBkgCaFlgTp.get(0).getCtrtTpCd().toString();
//            	svcScpCd = listBkgCaFlgTp.get(0).getSvcScpCd().toString();
//            	caFlg    = listBkgCaFlgTp.get(0).getCaFlg().toString();
//            }
//            
//            if(ctrtTpCd.equals("R") || ctrtTpCd.equals("S") || ctrtTpCd.equals("T")){
//            	
//            	begin();
//            	
//            	// AutoratingList, SurchargeAutoratingList -> rtAplyDt Retrieve
//            	rtAplyDt = command.searchAuditRtAplyDt(bkgNo, caFlg);
//            	
//        		if(ctrtTpCd.equals("R")) { // RFA
//
//            		// RFA Temp
//        			// searchRfaOftAutoratingList (String bkgNo, String caFlag,String rfaNo, String Rtaplydt, String scpCd, String cmdtCd) throws EventException;
//        			rfaOftList = rfaOftCmd.searchRfaOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");
//        			// RFA Surcharge Generation : The number of cases BKG_AUTO_RT_OCN_FRT_TMP Generation
//            		command.createRfaSurchargeInput(bkgNo, rfaOftList, account);
//            		// RFA RevenueAuditOft Generation : BKG_AUTO_RT_OCN_FRT_TMP => BKG_REV_AUD_CHG_TMP Input
//            		command.createRevenueAuditOft();
//        			
//            		ScOftAutoratingListVO surCmdVo = new ScOftAutoratingListVO();
//            		surCmdVo.setBkgNo(bkgNo);
//            		surCmdVo.setCaFlg(caFlg);
//            		surCmdVo.setRtAplyDt(rtAplyDt);
//            		surCmdVo.setsvcScpCd(svcScpCd);
//            		surCmdVo.setCtrtTpCd(ctrtTpCd);
//            		surCmdVo.setRtAudTpCd("A");
//            		// surchargeautorating-> Register
//            		surList = surCmd.searchSurchargeAutoratingList(surCmdVo);
//        			// BKG_REV_AUD_CHG_TMP ->Generation
//            		command.createRevenueAuditSurcharge(surList, account);
//            		
//            		// Self Audit RFA List - All( A ~ F)
//                	list = command.checkRfaUnmatchBLbyBooking(bkgNo, caFlg, "S"); // S : Of the screen detail hide 
//                	
//        		}else if(ctrtTpCd.equals("S")){ 
//        			
//        			// Self Audit SC List - All( A ~ D)
//                	list = command.checkScUnmatchBLbyBooking(bkgNo, caFlg, "S"); // S : Of the screen detail hide 
//                	
//        		}else if(ctrtTpCd.equals("T")){ 
//        			
//        			// TAA Temp
//        			// searchTaaOftAutoratingList (String bkgNo, String caFlag, String taaNo, String rtaplydt, String scpCd, String cmdtCd) throws EventException;
//        			taaOftList = taaOftCmd.searchTaaOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");    
//        			// TAA Surcharge->Generation :  BKG_AUTO_RT_OCN_FRT_TMP Generation,  TAA is no Data('OAR', 'DAR')
//            		command.createTaaSurchargeInput(bkgNo, taaOftList, account);
//            		// TAA RevenueAuditOft->Generation : BKG_AUTO_RT_OCN_FRT_TMP => BKG_REV_AUD_CHG_TMP Input
//            		// RFA is the same as
//            		command.createRevenueAuditOft();
//            		
//            		ScOftAutoratingListVO surCmdVo = new ScOftAutoratingListVO();
//            		surCmdVo.setBkgNo(bkgNo);
//            		surCmdVo.setCaFlg(caFlg);
//            		surCmdVo.setRtAplyDt(rtAplyDt);
//            		surCmdVo.setsvcScpCd(svcScpCd);
//            		surCmdVo.setCtrtTpCd(ctrtTpCd);
//            		surCmdVo.setRtAudTpCd("A");
//            		// surchargeautorating Register            		
//            		// RFA is the same as
//            		surList = surCmd.searchSurchargeAutoratingList(surCmdVo); 
//        			// BKG_REV_AUD_CHG_TMP Generation
//            		// RFA is the same as
//            		command.createRevenueAuditSurcharge(surList, account); 
//
//        			// (Self Audit TAA) List - All( A ~ F)
//                	list = command.checkTaaUnmatchBLbyBooking(bkgNo, caFlg, "S"); // S :  Of the screen detail hide 
//                	
//        		}
//        		
//        		// list count =0 ->Success
//        		if(null != list && list.size() == 0) {
//            		audSts = "Y";
//            		auditResultNm = cdUtil.getCodeName("CD02456", "M"); // Success, codenamed
//        		}else if(null != list && list.size() > 0){
//        			// list count > 0 ->Error 
//            		for(int i = 0; i < list.size(); i++) {
//            			audSts = "Y";
//            			auditResultNm = list.get(i).getMtchUmchTpDesc();
//            			log.debug("###########"+(i)+list.get(i).getMtchUmchTpDesc());
//               			if(list.get(i).getMtchUmchTpCd().equals("U")) { // Error
//            				audSts = "E";
//            				break;
//            			}
//            		}
//        		}
//        		
//        		// BKG_RATE.AUD_STS_CD Update
//        		blRateCmd.modifyAudSts(bkgNo, audSts, account, caFlg);
//        		
//        		commit(); 
//        		
//        		eventResponse.setETCData("auditResultNm", auditResultNm);
//    			eventResponse.setRsVoList(list);
//            
//            } else {
//            	eventResponse.setETCData("result", "Contract Type Code Not Exist");				
//			}
//
//		}catch(EventException ex) {
//			rollback();			
//			throw ex;			
//		}catch(Exception ex) {
//			rollback();			
//	        throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
//		}
//		return eventResponse;
//	}
	
  /**
	 * 0263 : Retrive <br>
	 * Self Audit List -> Retrieve<br>
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
	 * Re-audit Process to handle. <br>
	 * Modify->com.clt.apps.opus.esm.bkg.batch.auditunmatchbl.basic.RFAAuditUnmatchBl ->Modify a Deployment<br>
	 * Modify->com.clt.apps.opus.esm.bkg.batch.auditunmatchbl.basic.SCAuditUnmatchBl  ->Modify a Deployment<br>
	 * Modify->com.clt.apps.opus.esm.bkg.batch.auditunmatchbl.basic.TAAAuditUnmatchBl ->Modify a Deployment<br>
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
	 * BackEndJob : interval <br>
	 * BackEndJob-> Retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBakEndJbVO(Event e) throws EventException {
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
	 * BackEndJob List -> Retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")	
	private EventResponse comBackEndJbSearchList(Event e) throws EventException {
		List list = null;		
		String key = (String)e.getAttribute("KEY");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if(e.getEventName().equalsIgnoreCase("EsmBkg0151Event")) {
				list = (List<RsltSearchChargeFilteringListVO>)BackEndJobResult.loadFromFile(key);
			}
			else if(e.getEventName().equalsIgnoreCase("EsmBkg1092Event")) {
				list = (List<RsltSearchAuditByCommodityAndRouteListVO>)BackEndJobResult.loadFromFile(key);
			}
			eventResponse.setRsVoList(list);		
		}catch(Exception ex){
	        throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * BackEndJob : search <br>
	 * BackEndJob -> Retrieve<br>
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
/* Mail																						 */
/*************************************************************************************************************/
	
	/**
	 * ISSUE : Save End
	 * RDN Issuance by Auditor :Bulk mail will be sent an email to participants <br>
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
	 * 0263 : Retrive <br>
	 * Self Audit BackendJob -> Retrieve<br>
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
}