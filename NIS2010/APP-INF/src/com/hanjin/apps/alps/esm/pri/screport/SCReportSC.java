/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCReportSC.java
*@FileTitle : Proposal Amendment Draft Print
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.28
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.06.25 변영주
* 1.0 Creation
* =========================================================
* History
* 2013.05.28 이혜민 [CHM-201324516-01] Surcharge 종합체계 구축 T/F - Surcharge Summary Report 화면 신규개발 
* 2015.06.15 최성환 [CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한) 
* 2015.09.21 최성환 [CHM-201537786] SC 다운로드 보안 강화_1차 보완
* 2015.09.25 최성환 [CHM-201537788] SC 다운로드 보안 강화_2차 개발
* 2016.05.26 [CHM-201641700] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발
* 2016.09.07 [CHM-201642825] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발 (정식방식)
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.mas.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.basic.SCProposalMainBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.basic.SCProposalMainBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.basic.SCReportBC;
import com.hanjin.apps.alps.esm.pri.screport.screport.basic.SCReportBCImpl;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0039Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0060Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0061Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0062Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0079Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri010801Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri010802Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0111Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0121Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0124Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0125Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri013001Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri013002Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0131Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0140Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0141Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0150Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0151Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri015201Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0152Event;
import com.hanjin.apps.alps.esm.pri.screport.screport.integration.SCReportDBDAO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.PriMofMapgVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptSearchChargeSummaryReportBlInquiryVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptSearchChargeSummaryReportSummaryViewVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltRptPropListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSCPrnVwRDInfoVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSCRetRDInfoVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchKoreaMOTListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOFLaneListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOFListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOTSSEFilingListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCBlListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCInfromationVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCMOTFilingListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCOutOfDateBkgListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceBulletListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailSumVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerfromanceVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchBulletListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCTimelyRateListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCTradeSubTradeLaneListVO;
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
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmChargeVO;

/**
 * NIS2010-SCReport Business Logic ServiceCommand - NIS2010-SCReport 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Byeon Young Joo
 * @see SCReportDBDAO
 * @since J2EE 1.6
 */

public class SCReportSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SCReport system 업무 시나리오 선행작업<br>
	 * ESM_PRI_0039업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("SCReportSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SCReport system 업무 시나리오 마감작업<br>
	 * ESM_PRI_0039 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SCReportSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-SCReport system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmPri0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchReportProposalList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchReportProposalInfo(e);				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				//프린트 파일 오픈시 권한 확인
				eventResponse = searchPrintOpenAuthInfo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSCRetrievalRDInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				//[CHM-201537788] SC 다운로드 보안 강화_2차 개발
				eventResponse = manageDownloadRecord(e);
			} 
		// Day-Hoh Kim - Start
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0062Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				//프린트 파일 오픈시 권한 확인
				eventResponse = searchPrintOpenAuthInfo(e);
			} else{
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
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // trade, sub trade, lane 콤보
				eventResponse = searchSCTradeSubTradeLaneList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // sc 기본내용
				eventResponse = searchSCInfromation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // Commodity, actual 콤보
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
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Commodity, actual 콤보
				eventResponse = searchSCRateSearchBulletList(e);
			}else{
				eventResponse = initSCRateSearch(e);				
			}
		// Day-Hoh Kim - End
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0079Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSCPrintViewRDInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				//[CHM-201537788] SC 다운로드 보안 강화_2차 개발
				eventResponse = manageDownloadRecord(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0121Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCMOTFilingList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0124Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTimelyRateCreationReport(e);
			}else {
				eventResponse = initTimelyRateCreationReport(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0125Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTimelyOutOfDateBookingList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri013001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchChargeSummaryReportSummaryView(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//It gets a status of backendjob. 2
				eventResponse = comBakEndJbVOs(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){//It returns a result. 3
				eventResponse = comBackEndJbSearchListGetResult(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchChargeList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOfcValid(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPrevWkPrd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchDatePeriod(e);
			}else {
				eventResponse = initChargeSummaryReport(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri013002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchChargeSummaryReportDetailView(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//It gets a status of backendjob. 2
				eventResponse = comBakEndJbVOs(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){//It returns a result. 3
				eventResponse = comBackEndJbSearchListGetResult(e);
			}else {
				eventResponse = initChargeSummaryReport(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0131Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchChargeSummaryBlInquiry(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//It gets a status of backendjob. 2
				eventResponse = excelDownChargeSummaryBlInquiry(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//It gets a status of backendjob. 2
				eventResponse = comBakEndJbVOs(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){//It returns a result. 3
				eventResponse = comBackEndJbSearchListGetResult(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0140Event")) {//It starts a job of backend. 1
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMOTSSEFilingList(e);
			} else {
				eventResponse = initMOTSSEFilingInquiry(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0141Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMOTSSETariffList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMotTrfSvcScpCdList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMotTrfScopeEffectiveDateList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMOTSSETariffList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = removeMOTSSETariff(e);
			}
			else {
				eventResponse = initMotTrfComboData(e);
			}
		// [CHM-201641700] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0150Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKoreaMOTFilingList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = multiKoreaMOTFilingList(e);
			}
		// [CHM-201642825] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발 (정식방식) start
		} else if (e.getEventName().equalsIgnoreCase("EsmPri0151Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//It starts a job of backend. 1
				eventResponse = searchMOFFilingList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//It gets a status of backendjob. 2
				eventResponse = comBakEndJbVOs(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){//It returns a result. 3
				eventResponse = comBackEndJbSearchListGetResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri0152Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPriMofMapgList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = managePriMofMapg(e);
		}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri015201Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPriMofLaneList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = managePriMofLaneList(e);
			} else {
				eventResponse = initMOFLocationPropertyComboData(e);
			}
		// [CHM-201642825] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발 (정식방식) end
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_0039 : Retrieve <br>
	 * SCReport의 SC LIST 정보 조회 처리<br>
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
	 * SCReport의 특정 sc에 대한 정보 조회<br>
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
	 * SCReport의 특정 레포트에 대한 정보 조회 <br>
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
	 * SCReport의 PrintView 화면의 레포트 정보 조회<br>
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
	 * SCReport의 MOT Filing Inquiry 화면의 레포트 정보 조회<br>
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
     * S/C List Inquiry 화면의 Combo Item 들을 조회합니다.<br>
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
            // Approval Office 생성 Code
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
	 * S/C List Inquiry 리스트를 조회.<br>
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
     * S/C Performance Summary 화면의 Combo Item 들을 조회합니다.<br>
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
	 * S/C Performance Summary 리스트 조회를 위해 BackEndJob을 실행한다. <br>
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
	 * SC Performance Summary - View BL 리스트를 조회하기 위해 BackEndJob 을 실행한다.<br>
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
     * S/C Performance Detail 화면의 Combo Item 들을 조회합니다.<br>
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
            //  us mode, US SVC MODE => PRCING USA SERVICE MODE CODE ( 공통코드 :  )
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
	 * S/C Performance Summary - Detail 리스트 조회를 위해 BackEndJob을 실행한다. <br>
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
	 * S/C Performance Summary - Detail 의 trade, sub trade, lane 콤보 데이터를 조회한다. <br>
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
	 * 해당 SC NO 에 대한 기본 내용을 조회한다. <br>
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
	 * Commodity, actual 콤보 데이터를 조회한다. <br>
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
	 * S/C Performance Summary - S/C TOTAL 합계내용을 조회한다. <br>
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
     * S/C Rate Search 화면의 Combo Item 들을 조회합니다.<br>
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
            // charge S/C RATE SEARCH CHARGE CODE ( 통합코드 : CD02293 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02293", 0);
            eventResponse.setCustomData("charge", codeInfos);
        	// Customer Type combo PRICING CUSTOMER TYPE CODE ( 통합코드 : CD01714 ) 	( UI_PRI_0005 참조 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01714", 0);
            eventResponse.setCustomData("customerType", codeInfos);
            // TP/SZ => PRICommonSC.searchAllPerCodeList()
            customData = command.searchAllPerCodeList(new RsltCdListVO());
            eventResponse.setCustomData("tpSz", customData);
            // Cargo Type => S/C CARGO TYPE CODE  ( 통합코드 : CD02202 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02202", 0);
            eventResponse.setCustomData("cargoType", codeInfos);
            // Rate  => S/C REPORT OPERATION CODE, S/C REPORT OPERATION CODE  ( 통합코드 : CD02280 )
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
	 * Rate Search 리스트를 조회하기 위해 BackEndJob 을 실행한다.<br>
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
	 * Commodity, actual 콤보 데이터를 조회한다.<br>
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
/*	BACK END JOB 관련																			 */
/*************************************************************************************************/
	/**
	 * BackEndJob : interval <br>
	 * BackEndJob의 상태값을 조회한다.<br>
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
	 * BackEndJob 결과 리스트를 조회한다.<br>
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
			}else if(e.getEventName().equalsIgnoreCase("EsmPri013001Event")){
				list = (List<RptSearchChargeSummaryReportSummaryViewVO>)BackEndJobResult.loadFromFile(key);				
			}else if(e.getEventName().equalsIgnoreCase("EsmPri013002Event")){
				list = (List<RptSearchChargeSummaryReportSummaryViewVO>)BackEndJobResult.loadFromFile(key);				
			}else if(e.getEventName().equalsIgnoreCase("EsmPri0131Event")){
				list = (List<RptSearchChargeSummaryReportBlInquiryVO>)BackEndJobResult.loadFromFile(key);				
			}else if(e.getEventName().equalsIgnoreCase("EsmPri0151Event")){ // [CHM-201642825] [해수부 운임공표 및 신고제] 
				list = (List<RsltSearchMOFListVO>)BackEndJobResult.loadFromFile(key);
			}
			eventResponse.setRsVoList(list);		
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0124 : Timely Rate Creation Report
	 * RHQ 콤보 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse initTimelyRateCreationReport(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        List<RsltCdListVO> customData = null;
        
        try{
            //  RHQ combo
            customData = command.searchRHQList(new RsltCdListVO());
            eventResponse.setCustomData("rhq", customData);
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * ESM_PRI_0124 : Timely Rate Creation Report <br>
	 * Office /  S’rep 별로  적기 계약  생성에 대한  결과 값을 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTimelyRateCreationReport(Event e) throws EventException {
		List<RsltSearchSCTimelyRateListVO> list = null;
		SCReportBC command = new SCReportBCImpl();		
		EsmPri0124Event event = (EsmPri0124Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			 list = command.searchTimelyRateCreationReport(event.getRsltSearchSCTimelyRateListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_0124 : Out of Date BKG  <br>
	 * 전체 대상 BKG 중 Batch Result 가 E (Error) 인 목록조회 <br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTimelyOutOfDateBookingList(Event e) throws EventException {
		List<RsltSearchSCOutOfDateBkgListVO> list = null;
		SCReportBC command = new SCReportBCImpl();		
		EsmPri0125Event event = (EsmPri0125Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			 list = command.searchTimelyOutOfDateBookingList(event.getRsltSearchSCOutOfDateBkgListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0130_01 : Charge Summary Report - Summary View 조회
	 * Charge Summary Report - Summary View Tab을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeSummaryReportSummaryView(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri013001Event event = (EsmPri013001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try{
			eventResponse.setETCData("BackEndJobKey", command.searchChargeSummaryReportSummaryViewDoStart(event.getRptSearchChargeSummaryReportSummaryViewVO(), account));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0130_01 : Charge Summary Report - Summary View Combo 조회
	 * 콤보 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    @SuppressWarnings("unchecked")
	private EventResponse initChargeSummaryReport(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        
        try{
        	//Rep. Charge Code 
			customData = command.searchRepChargeCodeList(new RsltCdListVO());
			eventResponse.setCustomData("repChgCd", customData);
			
            //RHQ combo
            customData = command.searchRHQList(new RsltCdListVO());
            eventResponse.setCustomData("rhq", customData);
            
            // Service Scope Code List
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            
            //Customer Type
		    
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00697", 0);
            eventResponse.setCustomData("custTpCd", codeInfos);
        }catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
        return eventResponse;
    }
    
	/**
	 * ESM_PRI_0130_01,02 : Charge Summary Report 
	 * Charge 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri013001Event event = (EsmPri013001Event)e;
		List<MdmChargeVO> list = null;
		SCReportBC command = new SCReportBCImpl();
		try {
			list = command.searchChargeList(event.getMdmChargeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0130_01 : Charge Summary Report - Summary View
	 * 입력한 OFC 유효성을 검증한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcValid(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri013001Event event = (EsmPri013001Event)e;
		SCReportBC command = new SCReportBCImpl();
		String ofcList = null;
		try {
			ofcList = command.searchOfcValid(event.getOfcCd());
			ofcList = JSPUtil.getNull(ofcList);
			eventResponse.setETCData("ofcList", ofcList);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0130_01,02 : Charge Summary Report 
	 * WEEK 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrevWkPrd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();
		String cost_wk = null;
		try {
			cost_wk = command.searchPrevWkPrd();
			eventResponse.setETCData("prevWeek", cost_wk);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0130_01,02 : Charge Summary Report
	 * 기간을 리턴한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDatePeriod(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri013001Event event = (EsmPri013001Event)e;
		CommonBC command = new CommonBCImpl();
		String rtn_date = null;
		try {
			rtn_date = command.searchDatePeriod(event.getSearchConditionVO());
			eventResponse.setETCData("period", rtn_date);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0130_02 : Charge Summary Report - Detail View 조회
	 * Charge Summary Report - Detail View Tab을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeSummaryReportDetailView(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri013002Event event = (EsmPri013002Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try{
			eventResponse.setETCData("BackEndJobKey", command.searchChargeSummaryReportDetailViewDoStart(event.getRptSearchChargeSummaryReportSummaryViewVO(), account));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0131 
	 * Charge Summary Report - BL Inquiry을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeSummaryBlInquiry(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri0131Event event = (EsmPri0131Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try{
			eventResponse.setETCData("BackEndJobKey", command.searchChargeSummaryBlInquiryDoStart(event.getRptSearchChargeSummaryReportBlInquiryVO(), account));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0131: BackEndJob 결과 - Account별 엑셀다운 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownChargeSummaryBlInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SCReportBC command = new SCReportBCImpl();
		try{
			List<Object> oList = command.excelDownChargeSummaryBlInquiry((String) e.getAttribute("KEY"));					
			
			eventResponse.setCustomData("rowset", (DBRowSet)oList.get(0));
			eventResponse.setCustomData("title", (String[])oList.get(1));
			eventResponse.setCustomData("columns", (String[])oList.get(2));
			eventResponse.setCustomData("fileName", "BLInquiry.xls");
			eventResponse.setCustomData("isZip", false);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * ESM_PRI_0140 : MOT/SSE Filing Inquiry 조회
	 * MOT/SSE Filing Inquiry 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMOTSSEFilingList(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri0140Event event = (EsmPri0140Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		List<RsltSearchMOTSSEFilingListVO> list = null;
		try{
			list = command.searchMOTSSEFilingList(event.getRsltSearchMOTSSEFilingListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0140 : MOT/SSE Filing List Inquiry 
	 * 콤보 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    @SuppressWarnings("unchecked")
	private EventResponse initMOTSSEFilingInquiry(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<CodeInfo> codeInfos = null;
        
        try{
            //BKG Source Type
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD03281", 0);
            eventResponse.setCustomData("BkgSrcTpCd", codeInfos);
        }catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
        return eventResponse;
    }

	/**
	 * ESM_PRI_0141 : SEARCH <br>
	 * MOT Tariff List 를  조회 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMOTSSETariffList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0141Event event = (EsmPri0141Event)e;
		SCReportBC command = new SCReportBCImpl();

		try{
			List<RsltSearchMOTSSEFilingListVO> list = command.searchMOTSSETariffList(event.getRsltSearchMOTSSEFilingListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	/**
	 * ESM_PRI_0141 : MULTI <br>
	 * MOT Tariff List 를  관리 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMOTSSETariffList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0141Event event = (EsmPri0141Event)e;
		SCReportBC command = new SCReportBCImpl();
		try{
			begin();
			command.manageMOTSSETariffList(event.getPriMotTrfMnVO(), event.getRsltSearchMOTSSEFilingListVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0141 : SVC_SCP_CD.Change<br>
	 * 선택된 Service Scope에 등록된 MOT Tariff 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMotTrfScopeEffectiveDateList(Event e) throws EventException {
		EsmPri0141Event event = (EsmPri0141Event) e;
		SCReportBC command = new SCReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltSearchMOTSSEFilingListVO> list = command.searchMotTrfScopeEffectiveDateList(event.getRsltSearchMOTSSEFilingListVO());
			List<RsltCdListVO> motDstBsePortCd = command.searchMotBsePortList(event.getRsltSearchMOTSSEFilingListVO().getSvcScpCd(), "D");
			List<RsltCdListVO> motLaneCd = command.searchMotTrfLaneCdList(event.getRsltSearchMOTSSEFilingListVO().getSvcScpCd());
			
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(motDstBsePortCd);
			eventResponse.setRsVoList(motLaneCd);
			
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0141 : OPEN<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initMotTrfComboData(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			
			List<RsltCdListVO> motOrgBsePortCd = command.searchMotBsePortList("", "O");
			
			ArrayList<CodeInfo> motFileCntrTpCd = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD03268", 0);
			ArrayList<CodeInfo> motFileCmdtTpCd = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD03275", 0);
			ArrayList<CodeInfo> motFileCntrSzCd = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD03274", 0);
			
			eventResponse.setCustomData("motOrgBsePortCdList", motOrgBsePortCd);

			eventResponse.setCustomData("motFileCntrTpCdList", motFileCntrTpCd);
			eventResponse.setCustomData("motFileCmdtTpCdList", motFileCmdtTpCd);
			eventResponse.setCustomData("motFileCntrSzCdList", motFileCntrSzCd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * PRI MOT Tariff 내용을 전체 삭제 한다. <br>
	 * 작성했던 BoilerPlate 를 삭제한다.
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse removeMOTSSETariff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0141Event event = (EsmPri0141Event) e;
		SCReportBC command = new SCReportBCImpl();
		try {
			begin();
			command.removeMOTSSETariff(event.getPriMotTrfMnVO());
			commit();
		}  catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Service Scope Code List 전체를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMotTrfSvcScpCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		SCReportBC command = new SCReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltCdListVO> list = command.searchMotTrfSvcScpCdList();
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한)
	 * [CHM-201537786] SC 다운로드 보안 강화_1차 보완
	 * 
	 * S/C Proposal Master Creation의 데이터를 조회합니다.의 RD Print 파일 오픈 권한 정보 조회를 한다. <br>
	 * 대상 : ESM_PRI_0039, ESM_PRI_0062 (SCProposalSC참조)
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrintOpenAuthInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SCProposalMainBC command = new SCProposalMainBCImpl();
		RsltPropListVO vo = null;
		EsmPri0039Event esmPri0039Event = null;
		EsmPri0062Event esmPri0062Event = null;
		
		
		try{
			
			if(e.getEventName().equalsIgnoreCase("EsmPri0039Event")){
				esmPri0039Event = (EsmPri0039Event)e;
				vo = command.searchProposalMainPrintAuthInfo(esmPri0039Event.getPriSpHdrVO(), account); 
			} else if(e.getEventName().equalsIgnoreCase("EsmPri0062Event")){
				esmPri0062Event = (EsmPri0062Event)e;
				vo = command.searchProposalMainPrintAuthInfo(esmPri0062Event.getPriSpHdrVO(), account);
			}
			
			if(vo != null){
				eventResponse.setETCData("stsCd",        	vo.getRsltPropMnVOs().get(0).getPropStsCd() );
				eventResponse.setETCData("reqUsrFlg",       vo.getRsltPropMnVOs().get(0).getReqUsrFlg());
				eventResponse.setETCData("aproUsrFlg",     vo.getRsltPropMnVOs().get(0).getAproUsrFlg());
				eventResponse.setETCData("allUsrFlg",        vo.getRsltPropMnVOs().get(0).getAllUsrFlg());
				eventResponse.setETCData("maxPropUsrId", vo.getRsltPropMnVOs().get(0).getMaxPropUsrId() );
				
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				log.debug("\n[e.getEventName()]"+e.getEventName());
				log.debug("\n[account]"+account);
				log.debug("\n[stsCd]	"+eventResponse.getETCData("stsCd"));
				log.debug("\n[reqUsrFlg]"+eventResponse.getETCData("reqUsrFlg"));
				log.debug("\n[aproUsrFlg]"+eventResponse.getETCData("aproUsrFlg"));
				log.debug("\n[allUsrFlg]"+eventResponse.getETCData("allUsrFlg"));
				log.debug("\n[maxPropUsrId]"+eventResponse.getETCData("maxPropUsrId"));
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			}
			
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * [CHM-201537788] SC 다운로드 보안 강화_2차 개발
	 * 사용자의 RD 리포트 사용 내역(파일오픈, 저장, 닫기등)을 관리합니다.<br>
	 * RD 화면에서 RECORD 되는 이벤트를 구분하는 코드 <br>
	 * O : Screen Open Event , S : Screen Save Event , C : Screen Close Event <br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageDownloadRecord(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0079Event esmPri0079Event = null;
		EsmPri0061Event esmPri0061Event = null;
		SCProposalMainBC command = new SCProposalMainBCImpl();
		String scrnEvntSeq = "";
		try {
			
			begin();
			//1. sequence 생성
			scrnEvntSeq = command.searchScreenEventSeq();
			if(e.getEventName().equalsIgnoreCase("EsmPri0079Event")){
				 esmPri0079Event = (EsmPri0079Event) e;
				//2. sequence -> vo 에 저장
				esmPri0079Event.getRsltPropMnDlRecVO().setScrnEvntSeq(scrnEvntSeq);
				//3. sequence -> PrntScrnEvntSeq vo 에 저장
				if( "O".equals(esmPri0079Event.getRsltPropMnDlRecVO().getSpPrnEvntTpCd())){
					//Screen Open 시에만 scrn_evnt_seq 생성 값을 리턴함
					esmPri0079Event.getRsltPropMnDlRecVO().setPrntScrnEvntSeq(scrnEvntSeq);
				}
				//4. User IP 저장
				esmPri0079Event.getRsltPropMnDlRecVO().setLginUsrIp(InetAddress.getLocalHost().getHostAddress());
				//5. 이벤트 저장
				command.manageDownloadRecord(esmPri0079Event.getRsltPropMnDlRecVO(), account); 
				//6. prnt_scrn_evnt_seq 화면으로 리턴
				eventResponse.setETCData("prnt_scrn_evnt_seq",        esmPri0079Event.getRsltPropMnDlRecVO().getPrntScrnEvntSeq() );
			} else if(e.getEventName().equalsIgnoreCase("EsmPri0061Event")){
				 esmPri0061Event = (EsmPri0061Event) e;
				//2. sequence -> vo 에 저장
				esmPri0061Event.getRsltPropMnDlRecVO().setScrnEvntSeq(scrnEvntSeq);
				//3. sequence -> PrntScrnEvntSeq vo 에 저장
				if( "O".equals(esmPri0061Event.getRsltPropMnDlRecVO().getSpPrnEvntTpCd())){
					//Screen Open 시에만 scrn_evnt_seq 생성 값을 리턴함
					esmPri0061Event.getRsltPropMnDlRecVO().setPrntScrnEvntSeq(scrnEvntSeq);
				}
				//4. User IP 저장
				esmPri0061Event.getRsltPropMnDlRecVO().setLginUsrIp(InetAddress.getLocalHost().getHostAddress());
				//5. 이벤트 저장
				command.manageDownloadRecord(esmPri0061Event.getRsltPropMnDlRecVO(), account); 
				//6. prnt_scrn_evnt_seq 화면으로 리턴
				eventResponse.setETCData("prnt_scrn_evnt_seq",        esmPri0061Event.getRsltPropMnDlRecVO().getPrntScrnEvntSeq() );
			}	
			commit();
			
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("\n[e.getEventName()]"+e.getEventName());
			log.debug("\n[account]"+account);
			log.debug("\n[scrnEvntSeq]"+scrnEvntSeq);
			log.debug("\n[prnt_scrn_evnt_seq]"+eventResponse.getETCData("prnt_scrn_evnt_seq"));
			log.debug("\n[InetAddress]"+InetAddress.getLocalHost().getHostAddress());
			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		}  catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00205").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0150 : Korea MOF Filing (by Upload) 조회
	 * Korea MOF Filing (by Upload) Inquiry 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKoreaMOTFilingList(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri0150Event event = (EsmPri0150Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		List<RsltSearchKoreaMOTListVO> list = null;
		try{
			list = command.searchKoreaMOTFilingList(event.getRsltSearchKoreaMOTListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0150 : Korea MOF Filing (by Upload) Send Email
	 * Korea MOF Filing (by Upload) Send Email <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiKoreaMOTFilingList(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri0150Event event = (EsmPri0150Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			String key = command.multiKoreaMOTFilingList(event.getRsltSearchKoreaMOTListVO(), event.getRsltSearchKoreaMOTListVOS(), account);
			eventResponse.setETCData("JOB_KEY", key);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("PRI0150",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/** [CHM-201642825] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발 (정식방식) start **/
	/**
	 * ESM_PRI_0151 : Retrieve
	 * Korea MOF Filing (Formatted) 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMOFFilingList(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri0151Event event = (EsmPri0151Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			eventResponse.setETCData("BackEndJobKey", command.searchMOFFilingList(event.getRsltSearchKoreaMOTListVO(), account));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0152_01 : Retrieve
	 * Korea MOF Filing (Base Table) - Scope & Location 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriMofLaneList(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri015201Event event = (EsmPri015201Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		List<RsltSearchMOFLaneListVO> list = null;
		try {
			list = command.searchPriMofLaneList(event.getRsltSearchMOFLaneListVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0152_01 : Save
	 * Korea MOF Filing (Base Table) - Scope & Location 정보를  관리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePriMofLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri015201Event event = (EsmPri015201Event)e;
		SCReportBC command = new SCReportBCImpl();
		try {
			begin();
			command.managePriMofLaneList(event.getRsltSearchKoreaMOFListVOS(), account);
			commit();
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESM_PRI_0152_02,03,04,05 : Retrieve
	 * Korea MOF Filing (Base Table) - Mapping 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriMofMapgList(Event e) throws EventException {
		SCReportBC command = new SCReportBCImpl();
		EsmPri0152Event event = (EsmPri0152Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		List<PriMofMapgVO> list = null;
		try {
			list = command.searchPriMofMapgList(event.getPriMofMapgVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0152_02,03,04,05 : Save
	 * Korea MOF Filing (Base Table) - Mapping 정보를  관리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePriMofMapg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0152Event event = (EsmPri0152Event)e;
		SCReportBC command = new SCReportBCImpl();
		try {
			begin();
			command.managePriMofMapg(event.getPriMofMapgVOs(),event.getPriMofMapgHisVOs(), account);
			commit();
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0152_01 : Korea MOF Filing (Base Table) - Scope & Location 
	 * 콤보 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initMOFLocationPropertyComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CodeUtil cdUtil = CodeUtil.getInstance();
		List<CodeInfo> oriDst = null;
		List<CodeInfo> mofLane = null;
		
		try {
			mofLane = (List<CodeInfo>)cdUtil.getCodeSelect("CD03541", 0);
			eventResponse.setCustomData("mofFileLaneCdList", mofLane);
			
			oriDst = (List<CodeInfo>)cdUtil.getCodeSelect("CD00139", 0);
			eventResponse.setCustomData("orgDestList", oriDst);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/** [CHM-201642825] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발 (정식방식) end **/
	
	
}