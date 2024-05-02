/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCReportSC.java
*@FileTitle : Proposal Amendment Draft Print
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.screport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.bcm.ccd.commoncode.report.basic.ReportBC;
import com.clt.apps.opus.bcm.ccd.commoncode.report.basic.ReportBCImpl;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.CustomerReportVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.screport.screport.basic.SCReportBC;
import com.clt.apps.opus.esm.pri.screport.screport.basic.SCReportBCImpl;
import com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0034Event;
import com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0039Event;
import com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0060Event;
import com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0061Event;
import com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0062Event;
import com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0079Event;
import com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri010801Event;
import com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri010802Event;
import com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0111Event;
import com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0121Event;
import com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0122Event;
import com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0123Event;
import com.clt.apps.opus.esm.pri.screport.screport.integration.SCReportDBDAO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.PriMotChgRtVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltMOTFileHeaderVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltRptPropListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSCPrnVwRDInfoVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSCRetRDInfoVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchNoteCtntVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCBlListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCInfromationVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCMOTFilingListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceBulletListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailSumVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerfromanceVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCRateSearchBulletListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCRateSearchListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCTradeSubTradeLaneListVO;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * handling business transaction about SCReport Business Logic ServiceCommand - SCReport
 * 
 * @author Byeon Young Joo
 * @see SCReportDBDAO
 * @since J2EE 1.6
 */

public class SCReportSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for SCReport system biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("SCReportSC starting");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SCReport system biz scenario closing<br>
	 *  clearing related objects about ESM_PRI_0039<br>
	 */
	public void doEnd() {
		log.debug("SCReportSC closing");
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
		if (e.getEventName().equalsIgnoreCase("EsmPri0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchReportProposalList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchReportProposalInfo(e);				
			}			
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSCRetrievalRDInfo(e);
			}
		// Day-Hoh Kim - Start
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0062Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCList(e);
			}else{
				eventResponse = initSCListInquiry(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri010801Event")) {
			if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//It starts a job of backend. 1
				eventResponse = searchSCPerformanceSummaryList(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//It gets a status of backendjob. 2
				eventResponse = comBakEndJbVOs(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){//It returns a result. 3
				eventResponse = comBackEndJbSearchListGetResult(e);
			}else{
				eventResponse = initSCPerformanceSummary(e);				
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0111Event")) {//It starts a job of backend. 1
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchSCBlList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//It gets a status of backendjob. 2
				eventResponse = comBakEndJbVOs(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){//It returns a result. 3
				eventResponse = comBackEndJbSearchListGetResult(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri010802Event")) {
			if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//It starts a job of backend. 1
				eventResponse = searchSCPerformanceDetailList(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//It gets a status of backendjob. 2
				eventResponse = comBakEndJbVOs(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){//It returns a result. 3
				eventResponse = comBackEndJbSearchListGetResult(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // trade, sub trade, lane combo
				eventResponse = searchSCTradeSubTradeLaneList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // sc 기본내용
				eventResponse = searchSCInfromation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // Commodity, actual combo
				eventResponse = searchSCPerformanceBulletList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // detail sum
				eventResponse = searchSCPerformanceDetailSum(e);
			}else{
				eventResponse = initSCPerformanceDetail(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0060Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchSCRateSearchList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//It gets a status of backendjob. 2
				eventResponse = comBakEndJbVOs(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){//It returns a result. 3
				eventResponse = comBackEndJbSearchListGetResult(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Commodity, actual combo
				eventResponse = searchSCRateSearchBulletList(e);
			}else{
				eventResponse = initSCRateSearch(e);				
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0079Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSCPrintViewRDInfo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0121Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCMOTFilingList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0122Event")) {
			//2024.11.18 ADD start----------------
			//COMMAND01 	: GET CUSTERMER NAME
			//SEARCHLIST01 	: GET INFO ABOUT COMMISSION HEADER INFO AND DETAIL INFO
			//MULTI01		: SAVE COMMISSION INFO (INSERT, UPDATE, DELETE)
			
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchCustomerNameInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchPriMotChgInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = managePriMotChgInfo(e);
			} else {
				eventResponse = initFilingCommissionInquiry(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0123Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMOTFilingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchMOTFileHead(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//				eventResponse = searchMOTFilingListForExcel(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNoteCtnt(e);
			} 
		}
		return eventResponse;
	}
	/**
	 * ESM_PRI_0039 : Retrieve <br>
	 * Retrieving S/C list of SCReport<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportProposalList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0039Event event = (EsmPri0039Event)e;
		SCReportBC command = new SCReportBCImpl();

		try{
			List<RsltRptPropListVO> list = command.searchReportProposalList(event.getRptParaVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0039 : Retrieve <br>
	 * Retrieving a specific S/C information of SCReport<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportProposalInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0039Event event = (EsmPri0039Event)e;
		SCReportBC command = new SCReportBCImpl();

		try{
			List<RsltRptPropListVO> list = command.searchReportProposalInfo(event.getPriSpHdrVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_0061 : Retrieve <br>
	 * Retrieving a specific report information of SCReport<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCRetrievalRDInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0061Event event = (EsmPri0061Event)e;
		SCReportBC command = new SCReportBCImpl();

		try{
			List<RsltSCRetRDInfoVO> list = command.searchSCRetrievalRDInfo(event.getPriSpMnVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_0079 : Retrieve <br>
	 * Retrieving a specific PrintView information of SCReport<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCPrintViewRDInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0079Event event = (EsmPri0079Event)e;
		SCReportBC command = new SCReportBCImpl();

		try{
			List<RsltSCPrnVwRDInfoVO> list = command.searchSCPrintViewRDInfo(event.getPriSpMnVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}		
	
	/**
	 * ESM_PRI_0121 : Retrieve <br>
	 * Retrieving a report information in MOT Filing inquiry screen of SCReport<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCMOTFilingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0121Event event = (EsmPri0121Event)e;
		SCReportBC command = new SCReportBCImpl();

		try{
			List<RsltSearchSCMOTFilingListVO> list = command.searchSCMOTFilingList(event.getRsltSearchSCMOTFilingListVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}		
	
    /**
     * ESM_PRI_0062 : Open<br>
     * Retrieving Combo item<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initSCListInquiry(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        try{
            // Service Scope Code List
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            // S/C No prefix
            customData = command.searchScPrefixList(new RsltCdListVO());
            eventResponse.setCustomData("scNoPrefix", customData);
            // Customer Type Code
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01714", 0);
            eventResponse.setCustomData("custTpCd", codeInfos);
            // Approval Office Code
            customData = command.searchApprovalOfficeList(new RsltCdListVO());
            eventResponse.setCustomData("aproOfcCd", customData);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_PRI_0062 : Retrvie <br>
	 * Retrieving  S/C List Inquiry list<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0062Event event = (EsmPri0062Event)e;
		SCReportBC command = new SCReportBCImpl();
		List<RsltSearchSCListVO> list = null;
		List<RsltSearchSCListVO> listSum = null;
		String totalMqc = "0";
		String numberOfSc = "0";
		try{
			list = command.searchSCList(event.getRsltSearchSCListVO());
			listSum = command.searchSCSumList(event.getRsltSearchSCListVO());
			if(null != listSum && listSum.size() > 0){
				totalMqc = listSum.get(0).getFnlMqcQty(); 
				numberOfSc = listSum.get(0).getScNo(); 
			}
			eventResponse.setRsVoList(list);	
			eventResponse.setETCData("totalMqc", totalMqc);
			eventResponse.setETCData("numberOfSc", numberOfSc);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
    /**
     * ESM_PRI_0108_01 : Open<br>
     * Retrieving combo item of S/C Performance Summary screen.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initSCPerformanceSummary(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        try{
            //  RHQ combo
            customData = command.searchRHQList(new RsltCdListVO());
            eventResponse.setCustomData("rhq", customData);
            // Approval Office combo
            customData = command.searchApprovalOfficeList(new RsltCdListVO());
            eventResponse.setCustomData("aproOfcCd", customData);
            // S/C No prefix combo
            customData = command.searchScPrefixList(new RsltCdListVO());
            eventResponse.setCustomData("scNoPrefix", customData);
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            // Customer Type Code
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01714", 0);
            eventResponse.setCustomData("custTpCd", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_PRI_0108_01 : Retrieve <br>
	 * Execute BackendJob for retrieving S/C Performance Summary<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCPerformanceSummaryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri010801Event event = (EsmPri010801Event)e;
		SCReportBC command = new SCReportBCImpl();
		List<RsltSearchSCPerfromanceVO> list = null;
		String scopeCnt = "0";
		//RsltSearchSCPerfromanceVO pVo = new RsltSearchSCPerfromanceVO();
		try{
            //ObjectCloner.build(event.getRsltSearchSCPerfromanceVO(), pVo);         
			if(event.getRsltSearchSCPerfromanceVO().getByScope().equals("Y")){
				list = command.searchSCPerformanceSummaryListScopeCnt(event.getRsltSearchSCPerfromanceVO());
	            if (list != null && list.size() !=0 && list.get(0) != null){	     
	            	scopeCnt = list.get(0).getCnt().toString();
	            }
	            //pVo.setCnt(scopeCnt);
	            event.getRsltSearchSCPerfromanceVO().setCnt(scopeCnt);
			}
			//eventResponse.setETCData("BackEndJobKey", command.searchSCPerformanceSummaryListDoStart(account, pVo));
			eventResponse.setETCData("BackEndJobKey", command.searchSCPerformanceSummaryListDoStart(account, event.getRsltSearchSCPerfromanceVO()));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * ESM_PRI_0111 : Retrieve <br>
	 * Execute BackendJob for retrieving SC Performance Summary - View BL list<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCBlList(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri0111Event event = (EsmPri0111Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try{
			eventResponse.setETCData("BackEndJobKey", command.searchSCBlListDoStart(account, event.getRsltSearchSCBlListVO()));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	

    /**
     * ESM_PRI_0108_02 : Open<br>
     * Retrieving combo item of S/C Performance Detail screen<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initSCPerformanceDetail(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        try{
            // S/C No prefix combo
            customData = command.searchScPrefixList(new RsltCdListVO());
            eventResponse.setCustomData("scNoPrefix", customData);
            // Scope combo
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            // direction combo
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00593", 0);
            eventResponse.setCustomData("skdDirCd", codeInfos);
            //  rate type combo
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01705", 0);
            eventResponse.setCustomData("rtTpCd", codeInfos);
            //  us mode, US SVC MODE => PRCING USA SERVICE MODE CODE ( Commob Code :  )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02286", 0);
            eventResponse.setCustomData("usModCd", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_PRI_0108_02 : Retrieve <br>
	 * Execute BackendJob for retrieving S/C Performance Summary - Detail <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCPerformanceDetailList(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri010802Event event = (EsmPri010802Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			eventResponse.setETCData("BackEndJobKey", command.searchSCPerformanceDetailListDoStart(account, event.getRsltSearchSCPerformanceDetailListVO()));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0108_02 :  Init <br>
	 * Retrieving trade, sub trade, lane combo data of S/C Performance Summary - Detail<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCTradeSubTradeLaneList(Event e) throws EventException {
		List<RsltSearchSCTradeSubTradeLaneListVO> list = null;
		SCReportBC command = new SCReportBCImpl();
		EsmPri010802Event event = (EsmPri010802Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			list = command.searchSCTradeSubTradeLaneList(event.getRsltSearchSCTradeSubTradeLaneListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	

	
	/**
	 * ESM_PRI_0108_02 :  SC NO Change <br>
	 * Retrieving basic information about S/C no<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCInfromation(Event e) throws EventException {
		List<RsltSearchSCInfromationVO> list = null;
		SCReportBC command = new SCReportBCImpl();
		EsmPri010802Event event = (EsmPri010802Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String custCntCd        = "";                                                                                                                                 
		String custSeq          = "";  
		String ctrtPtyNm        = "";
		String prcCtrtCustTpCd  = "";
		String ctrtCustSlsOfcCd = "";
		String ctrtCustSrepCd   = "";
		String srepNm           = "";   
		String ctrtEffDt        = "";
		String ctrtExpDt        = "";		
		try{
			list = command.searchSCInfromation(event.getRsltSearchSCInfromationVO());
			if(null != list && list.size() > 0){
				custCntCd        = list.get(0).getCustCntCd();                                                                                                                                        
				custSeq          = list.get(0).getCustSeq();           
				ctrtPtyNm        = list.get(0).getCtrtPtyNm();       
				prcCtrtCustTpCd  = list.get(0).getPrcCtrtCustTpCd(); 
				ctrtCustSlsOfcCd = list.get(0).getCtrtCustSlsOfcCd();
				ctrtCustSrepCd   = list.get(0).getCtrtCustSrepCd();  
				srepNm           = list.get(0).getSrepNm();             
				ctrtEffDt        = list.get(0).getCtrtEffDt();       
				ctrtExpDt        = list.get(0).getCtrtExpDt();       
			}
			eventResponse.setETCData("custCntCd",        custCntCd       );
			eventResponse.setETCData("custSeq",          custSeq         );
			eventResponse.setETCData("ctrtPtyNm",        ctrtPtyNm       );
			eventResponse.setETCData("prcCtrtCustTpCd",  prcCtrtCustTpCd );
			eventResponse.setETCData("ctrtCustSlsOfcCd", ctrtCustSlsOfcCd);
			eventResponse.setETCData("ctrtCustSrepCd",   ctrtCustSrepCd  );
			eventResponse.setETCData("srepNm",           srepNm          );
			eventResponse.setETCData("ctrtEffDt",        ctrtEffDt       );
			eventResponse.setETCData("ctrtExpDt",        ctrtExpDt       );
			//eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	

	/**
	 * ESM_PRI_0108_02 :  Scope or Rate Type Change <br>
	 * Retrieving Commodity, actual combo data<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCPerformanceBulletList(Event e) throws EventException {
		List<RsltSearchSCPerformanceBulletListVO> list = null;
		SCReportBC command = new SCReportBCImpl();
		EsmPri010802Event event = (EsmPri010802Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			list = command.searchSCPerformanceBulletList(event.getRsltSearchSCPerformanceBulletListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	

	/**
	 * ESM_PRI_0108_02 :  Detail SearchEnd <br>
	 * Retrieving S/C total summation information of S/C Performance Summary<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCPerformanceDetailSum(Event e) throws EventException {
		List<RsltSearchSCPerformanceDetailSumVO> list = null;
		SCReportBC command = new SCReportBCImpl();
		EsmPri010802Event event = (EsmPri010802Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String fnlMqcQty    = "";                                                                                                                                 
		String opCntrQty    = "";  
		String mqcPerf      = "";
		String proRtMqcPerf = "";
		try{
			list = command.searchSCPerformanceDetailSum(event.getRsltSearchSCPerformanceDetailSumVO());
			if(null != list && list.size() > 0){
				fnlMqcQty    = list.get(0).getFnlMqcQty();                                                                                                                                        
				opCntrQty    = list.get(0).getOpCntrQty();           
				mqcPerf      = list.get(0).getMqcPerf();       
				proRtMqcPerf = list.get(0).getProRtMqcPerf(); 
			}
			eventResponse.setETCData("fnlMqcQty",    fnlMqcQty    );
			eventResponse.setETCData("opCntrQty",    opCntrQty    );
			eventResponse.setETCData("mqcPerf",      mqcPerf      );
			eventResponse.setETCData("proRtMqcPerf", proRtMqcPerf );
			//eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
    /**
     * ESM_PRI_0060 : Open<br>
     * Retrieving combo item of S/C Rate Search screen<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initSCRateSearch(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        try{
            // charge S/C RATE SEARCH CHARGE CODE ( United code : CD02293 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02293", 0);
            eventResponse.setCustomData("charge", codeInfos);
        	// Customer Type combo PRICING CUSTOMER TYPE CODE ( United code : CD01714 ) 	( Refer to UI_PRI_0005)
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01714", 0);
            eventResponse.setCustomData("customerType", codeInfos);
            // TP/SZ => PRICommonSC.searchAllPerCodeList()
            customData = command.searchAllPerCodeList(new RsltCdListVO());
            eventResponse.setCustomData("tpSz", customData);
            // Cargo Type => S/C CARGO TYPE CODE  ( United code : CD02202 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02202", 0);
            eventResponse.setCustomData("cargoType", codeInfos);
            // Rate  => S/C REPORT OPERATION CODE, S/C REPORT OPERATION CODE  ( Uniform code : CD02280 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02280", 0);
            eventResponse.setCustomData("rate", codeInfos);
            // S/C No prefix
            customData = command.searchScPrefixList(new RsltCdListVO());
            eventResponse.setCustomData("scNoPrefix", customData);
            // Service Scope Code List
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            // rate type combo CD01705
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01705", 0);
            eventResponse.setCustomData("rateType", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * ESM_PRI_0060 : Retrieve <br>
	 * Excute BackEndJob for retrieving Rate Search list<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCRateSearchList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SCReportBC command = new SCReportBCImpl();
		EsmPri0060Event event = (EsmPri0060Event)e;
		try{
			eventResponse.setETCData("BackEndJobKey", command.searchSCRateSearchListDoStart(account, event.getRsltSearchSCRateSearchListVO()));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_0060 : SC NO, Scope, Rate Type Change <br>
	 * Retrieving Commodity, actual combo data<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCRateSearchBulletList(Event e) throws EventException {
		List<RsltSearchSCRateSearchBulletListVO> list = null;
		SCReportBC command = new SCReportBCImpl();		
		EsmPri0060Event event = (EsmPri0060Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			 list = command.searchSCRateSearchBulletList(event.getRsltSearchSCRateSearchBulletListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}		

/*************************************************************************************************/
/*	BACK END JOB 																			 */
/*************************************************************************************************/
	/**
	 * BackEndJob : interval <br>
	 * Retrieving BackEndJob's status<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBakEndJbVOs(Event e) throws EventException {
		String key = (String)e.getAttribute("KEY");
		String status = null;
		SCReportBC command = new SCReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			status = command.comBakEndJbVOs(key);			
			eventResponse.setETCData("jb_sts_flg", status);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/*
	private EventResponse comBackEndJbSearchListGetResult(Event e) throws EventException {
		String key = (String)e.getAttribute("KEY");
		BackEndJobResult backEndJobResult = new BackEndJobResult();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DBRowSet> rowSets = new ArrayList<DBRowSet>();
		try {
			rowSets.add((DBRowSet)backEndJobResult.loadFromFile(key));
			//eventResponse.setETCData("RESULT",(String)BackEndJobResult.loadFromFile(key));
			eventResponse.setRsVoList(rowSets);		
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	*/
	/**
	 * BackEndJob : search <br>
	 * Retrieving a result list of BackEndJob<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse comBackEndJbSearchListGetResult(Event e) throws EventException {
		List list = null;
		String key = (String)e.getAttribute("KEY");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if(e.getEventName().equalsIgnoreCase("EsmPri0060Event")) {
				list = (List<RsltSearchSCRateSearchListVO>)BackEndJobResult.loadFromFile(key);
			}else if(e.getEventName().equalsIgnoreCase("EsmPri010801Event")){
				list = (List<RsltSearchSCPerfromanceVO>)BackEndJobResult.loadFromFile(key);				
			}else if(e.getEventName().equalsIgnoreCase("EsmPri010802Event")){
				list = (List<RsltSearchSCPerformanceDetailListVO>)BackEndJobResult.loadFromFile(key);				
			}else if(e.getEventName().equalsIgnoreCase("EsmPri0111Event")){
				list = (List<RsltSearchSCBlListVO>)BackEndJobResult.loadFromFile(key);				
			}
			if( list != null ) {
				eventResponse.setRsVoList(list);
			}
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
     * ESM_PRI_0122 : OPEN <br>
     * retrive the Combo Info when MOT Base Port Table Creation is loaded<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse initFilingCommissionInquiry(Event e) throws EventException {

        PRICommonBC command = new PRICommonBCImpl();
        SCReportBC cmdSCReport = new SCReportBCImpl();

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        CodeUtil cdUtil = CodeUtil.getInstance();
        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
        List<CodeInfo> codeInfos = null;
        try {
            ////////////////////COMMON - START/////////////////////


            //CURRENCY
            list = command.searchAllCurrencyCodeList(vo);
            eventResponse.setCustomData("CURR_CD", list);
            
            //charge code
            list = cmdSCReport.searchMotChargeCdList(new RsltCdListVO());
			eventResponse.setCustomData("CHG_CD", list);
			
			//SOC_FLG
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00912", 0);
	        eventResponse.setCustomData("SOC_FLG", codeInfos);
	        
	        //PRC_CGO_TP_CD
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02141", 0);
	        eventResponse.setCustomData("CGO_TP_CD", codeInfos);
	        
	        //MOT_FILE_CNTR_TP_CD
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD03268", 0);
	        eventResponse.setCustomData("CNTR_TP_CD", codeInfos);
	        
	        //MOT_FILE_LANE_CD
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD03269", 0);
	        eventResponse.setCustomData("LANE_CD", codeInfos);
	        
	        //PAY_TERM_CD
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01713", 0);
			//Ocean Freight 제거
			Iterator<CodeInfo> it = codeInfos.iterator();
			int rowIdx = -1; 
			while (it.hasNext()) {
				rowIdx += 1;
				CodeInfo obj = (CodeInfo)it.next();
			 	String sCode = obj.getCode();
			 	if(sCode.equals("O")) {
			 		break;
			 	}
			 }
			codeInfos.remove(rowIdx);
	        eventResponse.setCustomData("PAY_TERM_CD", codeInfos);

            ////////////////////COMMON - END/////////////////////	

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
    
    /**
     * ESM_PRI_0122 <br>
     * get Customer Name<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCustomerNameInquiry(Event e) throws EventException {
        EsmPri0122Event event = (EsmPri0122Event) e;
        ReportBC command = new ReportBCImpl();
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        List<CustomerReportVO> list = new ArrayList<CustomerReportVO>();

        try {
            ////////////////////COMMON - START/////////////////////


            //CUSTMER NAME
        	list = command.searchCustomerReportList(event.getCustomerReportVO());
        	String custLglEngNm = list.get(0).getCustLglEngNm();
            eventResponse.setETCData("CUST_NAME", custLglEngNm);

            ////////////////////COMMON - END/////////////////////	

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
	 * ESM_PRI_0122 : MOT Surcharge Creation
	 * Mot Surcharge Info 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchPriMotChgInfo(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri0122Event event = (EsmPri0122Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		

		List<PriMotChgRtVO> list = new ArrayList<PriMotChgRtVO>();
		try{
			
			list = command.searchPriMotChgRt(event.getRsltPriMotChgRtVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
    
	/**
	 * ESM_PRI_0122 : MOT Surcharge Creation <br>
	 * save MOT Surcharge Creation Info<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePriMotChgInfo(Event e) throws EventException {
	    EsmPri0122Event event = (EsmPri0122Event) e;
	    SCReportBC command = new SCReportBCImpl();
	    
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try {
	         begin();
	         command.managePriMotChgInfo(event.getPriMotChgRtVOs(), account);
	         commit();
	    } catch (EventException ex) {
	         rollback();
	         throw ex;
	    } catch (Exception ex) {
	         rollback();
	         throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
	    }

	    return eventResponse;
	 }
    
    /**
	 * ESM_PRI_0123 : Filing List Inquiry
	 * Filing List 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchMOTFileHead(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri0123Event event = (EsmPri0123Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		

		List<RsltMOTFileHeaderVO> list = new ArrayList<RsltMOTFileHeaderVO>();
		try{
			
			list = command.searchChargesForHead(event.getSearchMOTFileVO());
			eventResponse.setRsVoList(list);
		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
    
    /**
	 * ESM_PRI_0123 : Filing List Inquiry
	 * Filing List 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMOTFilingList(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri0123Event event = (EsmPri0123Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		

		List<RsltMOTFileHeaderVO> list = new ArrayList<RsltMOTFileHeaderVO>();
		try{
			
			list = command.searchChargesForHead(event.getSearchMOTFileVO());
			DBRowSet rs = command.searchPriMotFilingList(event.getSearchMOTFileVO());
			eventResponse.setRsVoList(list);
			eventResponse.setRs(rs);
			
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_0123 : Search For Excel <br>
	 * Retrieving Filing List<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchMOTFilingListForExcel(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsmPri0123Event event = (EsmPri0123Event)e;
//		SCReportBC command = new SCReportBCImpl();
//		
//		String fileName = "";
//
//		try{
//			List<MotFilingExclVO>  oList = command.searchPriMotFilingListForExcel(event.getSearchMOTFileVO());
//			String sDate = event.getSearchMOTFileVO().getFrFileDt().replace("-", "");
//			if(event.getSearchMOTFileVO().getInqTpCd().equals("1")) {
//				fileName = "MOT_DAILY_LOG_"+ sDate + ".xls";
//			} else if(event.getSearchMOTFileVO().getInqTpCd().equals("2")) {
//				fileName = "MOT_DAILY_LOG_BKG_"+ sDate + ".xls";
//			} else if(event.getSearchMOTFileVO().getInqTpCd().equals("3")) {
//				fileName = "MOT_FILE_"+ sDate + ".xls";
//			}
//
//			String[] sTitleArr = event.getSearchMOTFileVO().getColTitle().split("\\|");
//			String[] sColArr = event.getSearchMOTFileVO().getColNm().split("\\|");
//
//			eventResponse.setCustomData("vos", oList);
//			eventResponse.setCustomData("title", sTitleArr);
//			eventResponse.setCustomData("columns", sColArr);
//			eventResponse.setCustomData("fileName", fileName);
//			eventResponse.setCustomData("isZip", false);
//			
//		}catch(EventException ex){
//            throw ex;
//        }catch(Exception ex){
//            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
//        }
//		return eventResponse;
//	}
	
	/**
	 * ESM_PRI_0034 : retrive RFA/SC 's Commodity Note/Rate Note/Special Note.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteCtnt(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri0034Event event = (EsmPri0034Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		

		RsltSearchNoteCtntVO vo = new RsltSearchNoteCtntVO();
		try{
			
			String noteCtnt = command.searchNoteCtnt(event.getRsltSearchNoteCtntVO());
			vo.setNoteCtnt(noteCtnt);

			eventResponse.setETCData("NOTE_CTNT", vo.getNoteCtnt());
			
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
}