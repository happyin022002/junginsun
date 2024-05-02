/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_001SC.java
*@FileTitle : Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011-06-10
*@LastModifier : 김종호
*@LastVersion : 1.14
* 2006-10-18 juhyun
* 1.0 최초 생성
*N200901080023 2009-03-04 Expense Summary Report S/P 메뉴개발
*N200901080024 2009-03-04 Report(Expense Summary by Office) 메뉴개발
* 1.10 2010.09.09 이재위 [] [TRS] MTY REPORT 화면 신규개발(ESD_TRS_0120)
* 1.12 2011.02.18 손은주 [CHM-201108834-01][TRS] Rail performance Report 부분의 주 단위 data 조회기능 추가 요청
* 1.14 2011.06.10 김종호 [CHM-201110817] [TRS] US Rail report 기능 보완 / 추가 요청
* 2011.07.26 민정호 [CHM-201112196] Expense Summary Report에 Invoice 상태코드를 조회조건에 추가
* 2012.07.17 변종건 [CHM-201217633] Profit & Loss Report for Europe Inland BIZ 생성
* 2013.04.12 조인영 [CHM-201323766] Report Multiple select 조회 기능 추가
* 2013.05.15 조인영 [CHM-201324500] Rail performance report by SO (NYCNA) domestic data 추가
* 2013.08.22 조인영 [CHM-201326241] [TRS] Report data 개수 표시
* 2013.10.16 조인영 [CHM-201326827] [TRS] Surcharge Report 신규 메뉴 개발
* 2013.12.18 조인영 [CHM-201328014] Inland Trans Mode Comparison 신규메뉴 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsUtil;
import com.hanjin.apps.alps.esd.trs.common.trscommon.vo.TrsComboVO;
import com.hanjin.apps.alps.esd.trs.report.chanalysis.basic.ChAnalysisReportBC;
import com.hanjin.apps.alps.esd.trs.report.chanalysis.basic.ChAnalysisReportBCImpl;
import com.hanjin.apps.alps.esd.trs.report.deliverymonitor.basic.DeliveryMonitorBC;
import com.hanjin.apps.alps.esd.trs.report.deliverymonitor.basic.DeliveryMonitorBCImpl;
import com.hanjin.apps.alps.esd.trs.report.deliverymonitor.event.EsdTrs0260Event;
import com.hanjin.apps.alps.esd.trs.report.deliverymonitor.event.EsdTrs0270Event;
import com.hanjin.apps.alps.esd.trs.report.expensesummary.basic.ExpenseSummaryByOfficeBC;
import com.hanjin.apps.alps.esd.trs.report.expensesummary.basic.ExpenseSummaryByOfficeBCImpl;
import com.hanjin.apps.alps.esd.trs.report.expensesummary.basic.ExpenseSummaryBySpBC;
import com.hanjin.apps.alps.esd.trs.report.expensesummary.basic.ExpenseSummaryBySpBCImpl;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.basic.OptimumRoutePassBC;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.basic.OptimumRoutePassBCImpl;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.event.EsdTrs0108Event;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.event.EsdTrs0109Event;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.event.EsdTrs0110Event;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassBkgDtlVO;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassDtlVO;
import com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo.OptmRoutPassSmryVO;
import com.hanjin.apps.alps.esd.trs.report.pnlreport.basic.PnLReportBC;
import com.hanjin.apps.alps.esd.trs.report.pnlreport.basic.PnLReportBCImpl;
import com.hanjin.apps.alps.esd.trs.report.pnlreport.event.EsdTrs302301Event;
import com.hanjin.apps.alps.esd.trs.report.pnlreport.event.EsdTrs302302Event;
import com.hanjin.apps.alps.esd.trs.report.pnlreport.event.EsdTrs3023Event;
import com.hanjin.apps.alps.esd.trs.report.pnlreport.vo.PnLBkgDtlListVO;
import com.hanjin.apps.alps.esd.trs.report.pnlreport.vo.PnLBkgListVO;
import com.hanjin.apps.alps.esd.trs.report.pnlreport.vo.PnLRptSmryListVO;
import com.hanjin.apps.alps.esd.trs.report.scgreport.basic.ScgReportBC;
import com.hanjin.apps.alps.esd.trs.report.scgreport.basic.ScgReportBCImpl;
import com.hanjin.apps.alps.esd.trs.report.scgreport.event.EsdTrs0111Event;
import com.hanjin.apps.alps.esd.trs.report.scgreport.event.EsdTrs0112Event;
import com.hanjin.apps.alps.esd.trs.report.scgreport.vo.ScgDtlVO;
import com.hanjin.apps.alps.esd.trs.report.scgreport.vo.ScgSmryVO;
import com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.basic.SpPerformanceComparisonBC;
import com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.basic.SpPerformanceComparisonBCImpl;
import com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.event.EsdTrs0114Event;
import com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.vo.SearchComparisonVO;
import com.hanjin.apps.alps.esd.trs.report.transmodecomp.basic.TrnsModCompBC;
import com.hanjin.apps.alps.esd.trs.report.transmodecomp.basic.TrnsModCompBCImpl;
import com.hanjin.apps.alps.esd.trs.report.transmodecomp.event.EsdTrs0113Event;
import com.hanjin.apps.alps.esd.trs.report.transmodecomp.vo.TrnsModCompVO;
import com.hanjin.apps.alps.esd.trs.report.usarailperformance.basic.USARailPerformanceBC;
import com.hanjin.apps.alps.esd.trs.report.usarailperformance.basic.USARailPerformanceBCImpl;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author juhyun
 * @see ESD_TRS_001EventResponse,PendingListDBDAO 참조
 * @since J2EE 1.4
 * history
   2009.02.04 : 퍼퍼먼스 Log 추가
 */
public class TRSReportSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;
	//private String soffice_cd = "";
	//private String usrid = "";
	/**
	 * TRS 업무 시나리오 선행작업<br>
	 * PendingList업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
			//soffice_cd = account.getOfc_cd();
			//usrid = account.getUsr_id();
		} catch (Exception e) {
			log.error("ESD_TRS_001SC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * PendingList업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("ESD_TRS_001SC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-TRS 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChAnalysis(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = search_vvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = search_ofc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = weekDate(e);
			} else {
				//eventResponse = searchPendingListList(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdTrs0102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchENISInvRailPerformance(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchENISInvRailPerformanceByLaneVvd(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdTrs0103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchENISSOCRailPerformance(e); //By Rail Company, Lane/VVD Unchecked
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchENISSORRailPerformance(e); //By Entire Route, Lane/VVD Unchecked
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchENISSOCRailPerformanceByLaneVvd(e); //By Rail Company, Lane/VVD Checked
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchENISSORRailPerformanceByLaneVvd(e); //By Entire Route, Lane/VVD Checked
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchNISSOCRailPerformance(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchNISSORRailPerformance(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchALLSORRailPerformanceByLaneVvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchALLSOCRailPerformanceByLaneVvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchALLSOCRailPerformance(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchALLSORRailPerformance(e);
			} else {
				//eventResponse = searchPendingListList(e);
			}
		}		
		
		if (e.getEventName().equalsIgnoreCase("EsdTrs0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchExpenseSummaryByOffice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOfficeCount(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCodeCombo(e);					
			}
		}		

		if (e.getEventName().equalsIgnoreCase("EsdTrs0105Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchExpenseSummaryBySP(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchParentSP(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSummaryCount(e);			
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCodeCombo(e);				
			}else{
				//eventResponse = searchPendingListList(e);
			}			
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdTrs0107Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchExpenseDetailBySP(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDetailCount(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCodeCombo(e);				
			} else {
				//eventResponse = searchPendingListList(e);
			}
		}
		
		if( e.getEventName().equalsIgnoreCase("EsdTrs3023Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchPnLRptList(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH01) ){
				eventResponse = searchCombo3023(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){
				eventResponse = searchCustomerInfo(e);
			}
		}
		
		if( e.getEventName().equalsIgnoreCase("EsdTrs302301Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchPnLBkgList(e);
			}
		}
		
		if( e.getEventName().equalsIgnoreCase("EsdTrs302302Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchPnLBkgDtlList(e);
			}
		}
		
	  if (e.getEventName().equalsIgnoreCase("EsdTrs0108Event")) {
		if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			eventResponse = searchOptmRoutPassSmry(e);
		}
	  }
	  if (e.getEventName().equalsIgnoreCase("EsdTrs0109Event")) {
		if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			eventResponse = searchOptmRoutPassDtl(e);
		}
	}
	  if (e.getEventName().equalsIgnoreCase("EsdTrs0110Event")) {
		if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			eventResponse = searchOptmRoutPassBkgDtl(e);
		}
	}
	  if (e.getEventName().equalsIgnoreCase("EsdTrs0111Event")) {
		if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			eventResponse = searchScgSmry(e);
		}
	  }
	  if (e.getEventName().equalsIgnoreCase("EsdTrs0112Event")) {
		if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			eventResponse = searchScgDtl(e);
		}
	  }
	  if (e.getEventName().equalsIgnoreCase("EsdTrs0113Event")) {
		if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			eventResponse = searchTrnsModComp(e);
		}
	  }
	  
	  if (e.getEventName().equalsIgnoreCase("EsdTrs0260Event")) {
		  if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
			  eventResponse = searchDelivery(e);			
		  }			
	  }
	  
	  if (e.getEventName().equalsIgnoreCase("EsdTrs0270Event")) {
		  if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
			  eventResponse = searchDeliveryDetail(e);
		  }			
	  }
	  
		if (e.getEventName().equalsIgnoreCase("EsdTrs0114Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComparison(e);
			}
		}
	  
		return eventResponse;

	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * PendingList 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChAnalysis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//ESD_TRS_001Event event = (ESD_TRS_001Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			ChAnalysisReportBC command = new ChAnalysisReportBCImpl();
			eventResponse = command.searchChAnalysis(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * VVD체크 이벤트 처리<br>
	 * PendingList 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search_vvd(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			ChAnalysisReportBC command = new ChAnalysisReportBCImpl();
			eventResponse = command.search_vvd(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * ofc체크 이벤트 처리<br>
	 * PendingList 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search_ofc(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			ChAnalysisReportBC command = new ChAnalysisReportBCImpl();
			eventResponse = command.search_ofc(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * ofc체크 이벤트 처리<br>
	 * PendingList 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse weekDate(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			ChAnalysisReportBC command = new ChAnalysisReportBCImpl();
			eventResponse = command.weekDate(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - USA Rail Performance 화면에 대한 조회 이벤트 처리<br>
	 * ENIS - Inv기준, Lane/VVD checked
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchENISInvRailPerformanceByLaneVvd(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			USARailPerformanceBC command = new USARailPerformanceBCImpl();
			eventResponse = command.searchENISInvRailPerformanceByLaneVvd(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - USA Rail Performance 화면에 대한 조회 이벤트 처리<br>
	 * ENIS - Inv기준, Lane/VVD Unchecked
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchENISInvRailPerformance(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			USARailPerformanceBC command = new USARailPerformanceBCImpl();
			eventResponse = command.searchENISInvRailPerformance(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - USA Rail Performance 화면에 대한 조회 이벤트 처리<br>
	 * ENIS - SO기준 (철도회사별), Lane/VVD checked
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchENISSOCRailPerformanceByLaneVvd(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			USARailPerformanceBC command = new USARailPerformanceBCImpl();
			eventResponse = command.searchENISSOCRailPerformanceByLaneVvd(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - USA Rail Performance 화면에 대한 조회 이벤트 처리<br>
	 * ENIS - SO기준 (철도회사 구분없이), Lane/VVD checked
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchENISSORRailPerformanceByLaneVvd(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			USARailPerformanceBC command = new USARailPerformanceBCImpl();
			eventResponse = command.searchENISSORRailPerformanceByLaneVvd(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - USA Rail Performance 화면에 대한 조회 이벤트 처리<br>
	 * ENIS - SO기준 (철도회사별), Lane/VVD Unchecked
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchENISSOCRailPerformance(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			USARailPerformanceBC command = new USARailPerformanceBCImpl();
			eventResponse = command.searchENISSOCRailPerformance(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - USA Rail Performance 화면에 대한 조회 이벤트 처리<br>
	 * ENIS - SO기준 (철도회사 구분없이), Lane/VVD Unchecked
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchENISSORRailPerformance(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			USARailPerformanceBC command = new USARailPerformanceBCImpl();
			eventResponse = command.searchENISSORRailPerformance(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - USA Rail Performance 화면에 대한 조회 이벤트 처리<br>
	 * NIS - SO기준 (철도회사별)
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNISSOCRailPerformance(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			USARailPerformanceBC command = new USARailPerformanceBCImpl();
			eventResponse = command.searchNISSOCRailPerformance(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - USA Rail Performance 화면에 대한 조회 이벤트 처리<br>
	 * NIS - SO기준 (철도회사 구분없이)
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNISSORRailPerformance(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			USARailPerformanceBC command = new USARailPerformanceBCImpl();
			eventResponse = command.searchNISSORRailPerformance(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Report - USA Rail Performance 화면에 대한 조회 이벤트 처리<br>
	 * ALL - SO기준 (철도회사 구분없이), Lane/VVD checked
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchALLSORRailPerformanceByLaneVvd(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			USARailPerformanceBC command = new USARailPerformanceBCImpl();
			eventResponse = command.searchALLSORRailPerformanceByLaneVvd(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - USA Rail Performance 화면에 대한 조회 이벤트 처리<br>
	 * ALL - SO기준 (철도회사 구분없이), Lane/VVD unchecked
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchALLSORRailPerformance(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			USARailPerformanceBC command = new USARailPerformanceBCImpl();
			eventResponse = command.searchALLSORRailPerformance(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - USA Rail Performance 화면에 대한 조회 이벤트 처리<br>
	 * ALL - SO기준 (철도회사별), Lane/VVD checked
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchALLSOCRailPerformanceByLaneVvd(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			USARailPerformanceBC command = new USARailPerformanceBCImpl();
			eventResponse = command.searchALLSOCRailPerformanceByLaneVvd(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - USA Rail Performance 화면에 대한 조회 이벤트 처리<br>
	 * ALL - SO기준 (철도회사별), Lane/VVD checked
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchALLSOCRailPerformance(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			USARailPerformanceBC command = new USARailPerformanceBCImpl();
			eventResponse = command.searchALLSOCRailPerformance(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * PendingList 화면에 대한 조회 이벤트 처리<br>
     * N200901080024 2009-03-04 Report(Expense Summary by Office) 메뉴개발
     * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpenseSummaryByOffice(Event e) throws EventException {
		EventResponse eventResponse = null;
//	    EsdTrs0104Event 	event 			= (EsdTrs0104Event)e;
	    
		try {			
			ExpenseSummaryByOfficeBC command = new ExpenseSummaryByOfficeBCImpl();
			eventResponse = command.searchExpenseSummaryByOffice(e);
			
		} catch (EventException de) {  
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Report - ExpenseSummary by S/P 화면에 대한 조회 이벤트 처리<br>
	 * ENIS - Inv기준
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 * @history
	 * *N200901080023 2009-03-04 Expense Summary Report S/P 메뉴개발
	 */
	private EventResponse searchExpenseSummaryBySP(Event e) throws EventException {
		EventResponse eventResponse = null;
//	    EsdTrs0105Event 	event 			= (EsdTrs0105Event)e;
	    
		try {			
			ExpenseSummaryBySpBC command = new ExpenseSummaryBySpBCImpl();
			eventResponse = command.searchExpenseSummary(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - Parent SP 조회 이벤트 처리<br>
	 * ENIS - Inv기준
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 * @history
	 * *N200901080023 2009-03-04 Expense Summary Report S/P 메뉴개발
	 */
	private EventResponse searchParentSP(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			ExpenseSummaryBySpBC command = new ExpenseSummaryBySpBCImpl();
			eventResponse = command.searchParentSP(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - ExpenseDetail by S/P 화면에 대한 조회 이벤트 처리<br>
	 * ENIS - Inv기준
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 * @history
	 * *N200901080023 2009-03-04 Expense Summary Report S/P 메뉴개발
	 */
	private EventResponse searchExpenseDetailBySP(Event e) throws EventException {
		EventResponse eventResponse = null;
//	    EsdTrs0107Event event = (EsdTrs0107Event)e;
	    
		try {			
			ExpenseSummaryBySpBC command = new ExpenseSummaryBySpBCImpl();
			eventResponse = command.searchExpenseDetail(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Invoice Status 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 * @history
	 */	        
    private EventResponse searchComCodeCombo(Event e) throws EventException
	{
	    GeneralEventResponse eventResponse = new GeneralEventResponse();

		TrsUtil trsUtil = new TrsUtil();
		List<TrsComboVO> list = new ArrayList<TrsComboVO>();
		TrsComboVO combovo = new TrsComboVO();
		TrsComboVO combovo2 = new TrsComboVO();
		TrsComboVO combovo3 = new TrsComboVO();
		
		try {
			/* Invoice Status Combo List */
			list = trsUtil.searchCombo("CD00824");
			combovo.setVal("");
			combovo.setDesc("");
			combovo.setName("");
		    list.add(0, combovo);
		    combovo2.setVal("INV");
		    combovo2.setDesc("Invoice All");
		    combovo2.setName("Invoice All");
		    list.add(1, combovo2);
		    eventResponse.setRsVoList(list);
			
			/* Cost mode Combo List */
			list = trsUtil.searchCombo("CD00958");
			combovo3.setVal("");
			combovo3.setName("ALL");
			list.add(0,combovo3);
			eventResponse.setRsVoList(list);
			
			/* Trans mode Combo List */
			list = trsUtil.searchCombo("CD00283");
			list.add(0,combovo3);
			eventResponse.setRsVoList(list);
			
			/* SO Type Combo List */
			list = trsUtil.searchCombo("CD00279");
			list.add(0,combovo3);
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Invoice Status 조회 이벤트 처리<br>
	 * 
	 * @param String
	 * @return List
	 * @exception EventException
	 * @history
	 */	    
    private List searchComCodeCombo(String comCode) throws EventException{
	    TrsUtil trsUtil = new TrsUtil();
	    List list = trsUtil.searchCombo(comCode);
	    try
	    {
	        for(int j = 0; j < list.size(); j++)
	            ((TrsComboVO)list.get(j)).setDesc((new StringBuilder(String.valueOf(((TrsComboVO)list.get(j)).getVal()))).append(" ").append(((TrsComboVO)list.get(j)).getName()).toString());
	
	    }
	    catch(Exception ex)
	    {
	        throw new EventException(ex.getMessage());
	    }
	    return list;
    }
    
    /**
	 * 조회 이벤트 처리<br>
	 * Profit & Loss Report for Europe Inland BIZ 조회 이벤트 처리<br>
	 * 
	 * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchPnLRptList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
	    EsdTrs3023Event event = (EsdTrs3023Event)e;
	    PnLReportBC command = new PnLReportBCImpl();
	    
	    String[] ctrtOfcCd1Arr	= null;
		String[] ctrtOfcCd2Arr 	= null;
		String[] woOfcCd1Arr 	= null;
		String[] woOfcCd2Arr 	= null;
		String ctrtOfcCd1 		= "";
		String ctrtOfcCd2 		= "";
		String woOfcCd1 		= "";
		String woOfcCd2 		= "";
		
		try {
			//Contract Office Code #1
			ctrtOfcCd1Arr = event.getPnLRptOptionVO().getSCtrtOfcCd1().split(",");
			for( int idx=0; idx<ctrtOfcCd1Arr.length; idx++ ){
				if( idx == 0 && !ctrtOfcCd1Arr[idx].equals("") ){
					ctrtOfcCd1 = "'" + ctrtOfcCd1Arr[idx] + "'";
				} else if( idx > 0 ){
					ctrtOfcCd1 = ctrtOfcCd1 + ",'" + ctrtOfcCd1Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSCtrtOfcCd1(ctrtOfcCd1);
			
			
			//Contract Office Code #2
			ctrtOfcCd2Arr = event.getPnLRptOptionVO().getSCtrtOfcCd2().split(",");
			for( int idx=0; idx<ctrtOfcCd2Arr.length; idx++ ){
				if( idx == 0 && !ctrtOfcCd2Arr[idx].equals("") ){
					ctrtOfcCd2 = "'" + ctrtOfcCd2Arr[idx] + "'";
				} else if( idx > 0 ){
					ctrtOfcCd2 = ctrtOfcCd2 + ",'" + ctrtOfcCd2Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSCtrtOfcCd2(ctrtOfcCd2);
			
			
			//W/O Office Code #1
			woOfcCd1Arr = event.getPnLRptOptionVO().getSWoOfcCd1().split(",");
			for( int idx=0; idx<woOfcCd1Arr.length; idx++ ){
				if( idx == 0 && !woOfcCd1Arr[idx].equals("") ){
					woOfcCd1 = "'" + woOfcCd1Arr[idx] + "'";
				} else if( idx > 0 ){
					woOfcCd1 = woOfcCd1 + ",'" + woOfcCd1Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSWoOfcCd1(woOfcCd1);
			
			
			//W/O Office Code #2
			woOfcCd2Arr = event.getPnLRptOptionVO().getSWoOfcCd2().split(",");
			for( int idx=0; idx<woOfcCd2Arr.length; idx++ ){
				if( idx == 0 && !woOfcCd2Arr[idx].equals("") ){
					woOfcCd2 = "'" + woOfcCd2Arr[idx] + "'";
				} else if( idx > 0 ){
					woOfcCd2 = woOfcCd2 + ",'" + woOfcCd2Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSWoOfcCd2(woOfcCd2);
			
			
			List<PnLRptSmryListVO> slsVwlist = command.searchPnLSlsVwList(event.getPnLRptOptionVO());
			List<PnLRptSmryListVO> opVwList = command.searchPnLOpVwList(event.getPnLRptOptionVO());
			
			eventResponse.setRsVoList(slsVwlist);
			eventResponse.setRsVoList(opVwList);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    
    /**
	 * 조회 이벤트 처리<br>
	 * Profit & Loss Report for Europe Inland BIZ - BKG List 조회 이벤트 처리<br>
	 * 
	 * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchPnLBkgList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
	    EsdTrs302301Event event = (EsdTrs302301Event)e;
	    PnLReportBC command = new PnLReportBCImpl();
	    String[] ctrtOfcCd1Arr	= null;
		String[] ctrtOfcCd2Arr 	= null;
		String[] woOfcCd1Arr 	= null;
		String[] woOfcCd2Arr 	= null;
		String ctrtOfcCd1 		= "";
		String ctrtOfcCd2 		= "";
		String woOfcCd1 		= "";
		String woOfcCd2 		= "";
		
		try {
			//Contract Office Code #1
			ctrtOfcCd1Arr = event.getPnLRptOptionVO().getSCtrtOfcCd1().split(",");
			for( int idx=0; idx<ctrtOfcCd1Arr.length; idx++ ){
				if( idx == 0 && !ctrtOfcCd1Arr[idx].equals("") ){
					ctrtOfcCd1 = "'" + ctrtOfcCd1Arr[idx] + "'";
				} else if( idx > 0 ){
					ctrtOfcCd1 = ctrtOfcCd1 + ",'" + ctrtOfcCd1Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSCtrtOfcCd1(ctrtOfcCd1);
			
			
			//Contract Office Code #2
			ctrtOfcCd2Arr = event.getPnLRptOptionVO().getSCtrtOfcCd2().split(",");
			for( int idx=0; idx<ctrtOfcCd2Arr.length; idx++ ){
				if( idx == 0 && !ctrtOfcCd2Arr[idx].equals("") ){
					ctrtOfcCd2 = "'" + ctrtOfcCd2Arr[idx] + "'";
				} else if( idx > 0 ){
					ctrtOfcCd2 = ctrtOfcCd2 + ",'" + ctrtOfcCd2Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSCtrtOfcCd2(ctrtOfcCd2);
			
			
			//W/O Office Code #1
			woOfcCd1Arr = event.getPnLRptOptionVO().getSWoOfcCd1().split(",");
			for( int idx=0; idx<woOfcCd1Arr.length; idx++ ){
				if( idx == 0 && !woOfcCd1Arr[idx].equals("") ){
					woOfcCd1 = "'" + woOfcCd1Arr[idx] + "'";
				} else if( idx > 0 ){
					woOfcCd1 = woOfcCd1 + ",'" + woOfcCd1Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSWoOfcCd1(woOfcCd1);
			
			
			//W/O Office Code #2
			woOfcCd2Arr = event.getPnLRptOptionVO().getSWoOfcCd2().split(",");
			for( int idx=0; idx<woOfcCd2Arr.length; idx++ ){
				if( idx == 0 && !woOfcCd2Arr[idx].equals("") ){
					woOfcCd2 = "'" + woOfcCd2Arr[idx] + "'";
				} else if( idx > 0 ){
					woOfcCd2 = woOfcCd2 + ",'" + woOfcCd2Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSWoOfcCd2(woOfcCd2);
			
			
			List<PnLBkgListVO> pnlBkglist = command.searchPnLBkgList(event.getPnLRptOptionVO());
			eventResponse.setRsVoList(pnlBkglist);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    
    /**
	 * 조회 이벤트 처리<br>
	 * Profit & Loss Report for Europe Inland BIZ - BKG Detail List 조회 이벤트 처리<br>
	 * 
	 * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchPnLBkgDtlList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
	    EsdTrs302302Event event = (EsdTrs302302Event)e;
		try {
			PnLReportBC command = new PnLReportBCImpl();
			List<PnLBkgDtlListVO> pnlBkgDtllist = command.searchPnLBkgDtlList(event.getPnLBkgDtlListVO());
			eventResponse.setRsVoList(pnlBkgDtllist);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    
    /**
	 * ESD_TRS_3023 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo3023(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		TrsUtil trsUtil = new TrsUtil();
		List<TrsComboVO> list1 = new ArrayList<TrsComboVO>();
		List<TrsComboVO> list2 = new ArrayList<TrsComboVO>();
		List<TrsComboVO> list3 = new ArrayList<TrsComboVO>();
		List<TrsComboVO> list4 = new ArrayList<TrsComboVO>();
		List<TrsComboVO> list5 = new ArrayList<TrsComboVO>();
		TrsComboVO combovo = new TrsComboVO();
		
		try {
			PnLReportBC command = new PnLReportBCImpl();
			
			/* Service Scope Combo List */
			String svcScp[] = command.searchSvcScp();
			combovo.setVal("");
			combovo.setName("All");
			list1.add(0,combovo);
			
			for( int idx = 0; idx < svcScp.length; idx++ ){
				combovo = new TrsComboVO();
				combovo.setVal(svcScp[idx]);
				combovo.setName(svcScp[idx]);
				list1.add(idx+1,combovo);
			}
			eventResponse.setRsVoList(list1);
			
			
			/* Customer Type Combo List */
			combovo = new TrsComboVO();
			list2 = trsUtil.searchCombo("CD00697");
			combovo.setVal("");
			combovo.setName("All");
			list2.add(0,combovo);
			eventResponse.setRsVoList(list2);
			
			
			/* P&L Result Type Combo List */
			list3 = trsUtil.searchCombo("CD03092");
			eventResponse.setRsVoList(list3);
			
			
			/* P&L Result Type Combo List */
			combovo = new TrsComboVO();
			list4 = trsUtil.searchCombo("CD03090");
			combovo.setVal("");
			combovo.setName("Profit & Loss");
			list4.add(0,combovo);
			eventResponse.setRsVoList(list4);
			
			
			/* Revenue Type Combo List */
			combovo = new TrsComboVO();
			list5 = trsUtil.searchCombo("CD03089");
			combovo.setVal("");
			combovo.setName("All");
			list5.add(0,combovo);
			eventResponse.setRsVoList(list5);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCustomerInfo(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3023Event event = (EsdTrs3023Event)e;
		PnLReportBC command = new PnLReportBCImpl();

		try {
			/* Customer Code, Name */
			eventResponse = command.searchCustomerInfo(event.getPnLRptOptionVO());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * Optimum Route Pass - Summary<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOptmRoutPassSmry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0108Event event = (EsdTrs0108Event)e;
		OptimumRoutePassBC command = new OptimumRoutePassBCImpl();

		try{
			List<OptmRoutPassSmryVO> list = command.searchOptmRoutPassSmry(event.getOptmRoutPassCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Optimum Route Pass - Detail<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOptmRoutPassDtl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0109Event event = (EsdTrs0109Event)e;
		OptimumRoutePassBC command = new OptimumRoutePassBCImpl();

		try{
			List<OptmRoutPassDtlVO> list = command.searchOptmRoutPassDtl(event.getOptmRoutPassCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Optimum Route Pass - BKG Detail<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOptmRoutPassBkgDtl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0110Event event = (EsdTrs0110Event)e;
		OptimumRoutePassBC command = new OptimumRoutePassBCImpl();

		try{
			List<OptmRoutPassBkgDtlVO> list = command.searchOptmRoutPassBkgDtl(event.getOptmRoutPassCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - ExpenseDetail by S/P 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 * @history
	 */
	private EventResponse searchDetailCount(Event e) throws EventException {
		EventResponse eventResponse = null;
	    
		try {			
			ExpenseSummaryBySpBC command = new ExpenseSummaryBySpBCImpl();
			eventResponse = command.searchDetailCount(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - Expense Summary by S/P 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 * @history
	 */
	private EventResponse searchSummaryCount(Event e) throws EventException {
		EventResponse eventResponse = null;
	    
		try {			
			ExpenseSummaryBySpBC command = new ExpenseSummaryBySpBCImpl();
			eventResponse = command.searchSummaryCount(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - ExpenseSummary by Office 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 * @history
	 */
	private EventResponse searchOfficeCount(Event e) throws EventException {
		EventResponse eventResponse = null;
	    
		try {			
			ExpenseSummaryByOfficeBC command = new ExpenseSummaryByOfficeBCImpl();
			eventResponse = command.searchOfficeCount(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Surcharge Report - Summary<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgSmry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0111Event event = (EsdTrs0111Event)e;
		ScgReportBC command = new ScgReportBCImpl();

		try{
			List<ScgSmryVO> list = command.searchScgSmry(event.getScgCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Surcharge Report - Detail<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgDtl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0112Event event = (EsdTrs0112Event)e;
		ScgReportBC command = new ScgReportBCImpl();

		try{
			List<ScgDtlVO> list = command.searchScgDtl(event.getScgCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	/**
	 * Inland Transmode Comparison<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrnsModComp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0113Event event = (EsdTrs0113Event)e;
		TrnsModCompBC command = new TrnsModCompBCImpl();

		try{
			List<TrnsModCompVO> list = command.searchTrnsModComp(event.getTrnsModCompCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Delivery Monitor Summary 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDelivery(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0260Event event = (EsdTrs0260Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;		
		try {			
			DeliveryMonitorBC command = new DeliveryMonitorBCImpl();
			eventResponse = command.searchDelivery(event);			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Delivery Monitor Detail 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeliveryDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0270Event event = (EsdTrs0270Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;		
		try {			
			DeliveryMonitorBC command = new DeliveryMonitorBCImpl();
			eventResponse = command.searchDeliveryDetail(event);			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Report - S/P Performace Comparison Report<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComparison(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0114Event event = (EsdTrs0114Event)e;
		SpPerformanceComparisonBC command = new SpPerformanceComparisonBCImpl();

		try{
			List<SearchComparisonVO> list = command.searchComparison(event.getComparisonCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
}
