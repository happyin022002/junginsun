/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportSC.java
*@FileTitle : SD Analysis Report
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport;

import java.util.List;

import com.hanjin.apps.alps.esd.spe.performancereport.kpidetailreportbykpi.basic.KPIDetailReportbyKPIBC;
import com.hanjin.apps.alps.esd.spe.performancereport.kpidetailreportbykpi.basic.KPIDetailReportbyKPIBCImpl;
import com.hanjin.apps.alps.esd.spe.performancereport.kpidetailreportbykpi.event.EsdSpe1021Event;
import com.hanjin.apps.alps.esd.spe.performancereport.kpidetailreportbykpi.vo.KPIDetailReportVO;
import com.hanjin.apps.alps.esd.spe.performancereport.paresultdetaibysp.basic.PAResultDetaibySPBC;
import com.hanjin.apps.alps.esd.spe.performancereport.paresultdetaibysp.basic.PAResultDetaibySPBCImpl;
import com.hanjin.apps.alps.esd.spe.performancereport.paresultdetaibysp.event.EsdSpe1020Event;
import com.hanjin.apps.alps.esd.spe.performancereport.paresultdetaibysp.vo.PAResultDetaibySPVO;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.basic.SDAnalysisReportBC;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.basic.SDAnalysisReportBCImpl;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.event.EsdSpe1018Event;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.vo.SpeSDAnalysisVO;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.basic.SDAnalysisResultDetailBC;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.basic.SDAnalysisResultDetailBCImpl;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.event.EsdSpe1019Event;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.vo.SpeSDAnalysisDtlVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-PerformanceReport Business Logic ServiceCommand - ALPS-PerformanceReport 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author HI
 * @see SDAnalysisReportDBDAO
 * @since J2EE 1.6
 */

public class PerformanceReportSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PerformanceReport system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("PerformanceReportSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PerformanceReport system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("PerformanceReportSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-PerformanceReport system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdSpe1018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSDAnalysis(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdSpe1019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSDAnalysisDtl(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdSpe1020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPaResultDetaiSP(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdSpe1021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchKPIDetailReport(e);
			}
		}
		return eventResponse;
	}
	
	
	/**
	 * SD Analysis Report 목록 조회
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSDAnalysis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1018Event event = (EsdSpe1018Event)e;
		SDAnalysisReportBC command = new SDAnalysisReportBCImpl();

		try{
			List<SpeSDAnalysisVO> list = command.searchSDAnalysis(event.getSpeSDAnalysisVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * SD Analysis Result Detail 조회
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSDAnalysisDtl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1019Event event = (EsdSpe1019Event)e;
		SDAnalysisResultDetailBC command = new SDAnalysisResultDetailBCImpl();
		
		try{
			List<SpeSDAnalysisDtlVO> list = command.searchSDAnalysisDtl(event.getSpeSDAnalysisDtlVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * Quantitative Analysis : PA Result Detail by S/P 조회
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchPaResultDetaiSP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1020Event event = (EsdSpe1020Event)e;
		PAResultDetaibySPBC command = new PAResultDetaibySPBCImpl();
		
		try{
			List<PAResultDetaibySPVO> list = command.searchPaResultDetaiSP(event.getpAResultDetaibySPVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * KPI Detail Report by KPI 조회
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchKPIDetailReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1021Event event = (EsdSpe1021Event)e;
		KPIDetailReportbyKPIBC command = new KPIDetailReportbyKPIBCImpl();
		
		try{
			List<KPIDetailReportVO> list = command.searchKPIDetailReport(event.getkPIDetailReportVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
}