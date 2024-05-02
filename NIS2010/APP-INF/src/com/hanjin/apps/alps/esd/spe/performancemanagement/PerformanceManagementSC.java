/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceManagementSC.java
*@FileTitle : KPI Target Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement;

import java.util.List;

import com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.basic.KPIPerformanceBC;
import com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.basic.KPIPerformanceBCImpl;
import com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.event.EsdSpe1012Event;
import com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.vo.KpiPerformanceVO;
import com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.basic.KPITargetBC;
import com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.basic.KPITargetBCImpl;
import com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.event.EsdSpe1010Event;
import com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.integration.KPITargetDBDAO;
import com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.vo.KpiPerformanceTargetVO;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.basic.QualitativeEvaluationBC;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.basic.QualitativeEvaluationBCImpl;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.event.EsdSpe1015Event;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.event.EsdSpe1016Event;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.event.EsdSpe1017Event;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.vo.SpeQECreVO;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.vo.SpeSpQualEvVO;
import com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.basic.TerminalProductivityBC;
import com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.basic.TerminalProductivityBCImpl;
import com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.event.EsdSpe1013Event;
import com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.vo.TmlProdTgtInpVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-PerformanceManagement Business Logic ServiceCommand - ALPS-PerformanceManagement 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author HI
 * @see KPITargetDBDAO
 * @since J2EE 1.6
 */

public class PerformanceManagementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PerformanceManagement system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("PerformanceManagementSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PerformanceManagement system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("PerformanceManagementSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-PerformanceManagement system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if(e.getEventName().equalsIgnoreCase("EsdSpe1010Event")){
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // 저장한다
				eventResponse = multiKpiTarget(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //KPI Target 가중치 조회
				eventResponse = searchKpiTarget(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //KPI Cd조회
				eventResponse = searchSpSvcCateKpi(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EsdSpe1011Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //KPI Target 가중치 조회
				eventResponse = searchKpiTarget(e);
			
			}
		}else if(e.getEventName().equalsIgnoreCase("EsdSpe1012Event")){
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // 저장한다
				eventResponse = multiKpiPerformanceCfm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //KPI Performance 조회
				eventResponse = searchKpiPerformanceCfm(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EsdSpe1013Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Terminal Productivity Target Input 을 조회한다.
				eventResponse = selectTmlProdTgtInp(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // 저장한다
				eventResponse = multiTmlProdTgtInp(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdSpe1015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // 저장한다
				eventResponse = multiQualitativeEvaluationCreation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //Qualitative Evaluation 조회
				eventResponse = searchQualitativeEvaluationCreation(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EsdSpe1016Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //S/P Qualitative Evaulation Inquiry 조회
				eventResponse = searchSPQualitativeEv(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EsdSpe1017Event")){
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // 저장한다
				eventResponse = multiQualitativeEvaluation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //S/P Qualitative Evaulation 조회
				eventResponse = searchQualitativeEvaluation(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * SVC Category 목록 조회
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSpSvcCateKpi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1010Event event = (EsdSpe1010Event)e;
		KPITargetBC command = new KPITargetBCImpl();
		
		try{
			List<KpiPerformanceTargetVO> list = command.searchSpSvcCateKpi(event.getKpiPerformanceTargetVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchSpSvcCateKpi"}).getMessage(), ex);
		}	
		return eventResponse;
	}


	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchKpiTarget(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1010Event event = (EsdSpe1010Event)e;
		KPITargetBC command = new KPITargetBCImpl();
		
		try{
			List<KpiPerformanceTargetVO> list = command.searchKpiPerformanceTarget(event.getKpiPerformanceTargetVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchKpiTarget"}).getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 *  KPI Target creation 을 입력/수정/삭제 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiKpiTarget(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1010Event event = (EsdSpe1010Event)e;
		KPITargetBC command = new KPITargetBCImpl();
		try{
			begin();
			command.multiKpiTargetCreation(event.getKpiPerformanceTargetVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * KPI Performance 확인화면 조회
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchKpiPerformanceCfm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1012Event event = (EsdSpe1012Event)e;
		KPIPerformanceBC command = new KPIPerformanceBCImpl();
		
		try{
			List<KpiPerformanceVO> list = command.searchKpiPerformanceCfm(event.getKpiPerformanceVO(),account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchKpiPerformance"}).getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 *  KPI Performance Confirm 을 수정한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiKpiPerformanceCfm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1012Event event = (EsdSpe1012Event)e;
		KPIPerformanceBC command = new KPIPerformanceBCImpl();
		try{
			begin();
			command.multiKpiPerformanceCfm(event.getKpiPerformanceVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * S/P Qualitative Evaulation Inquiry  조회
	 * @param e
	 * @return eventResponse
	 * @throws EventException
	 */
	private EventResponse searchSPQualitativeEv(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1016Event event = (EsdSpe1016Event)e;
		QualitativeEvaluationBC command = new QualitativeEvaluationBCImpl();
		
		try{
			List<SpeSpQualEvVO> list = command.searchSPQualitativeEv(event.getSpeSpQualEvVO(),account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchSPQualitativeEv"}).getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * S/P Qualitative Evaulation 목록 조회
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchQualitativeEvaluation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1017Event event = (EsdSpe1017Event)e;
		QualitativeEvaluationBC command = new QualitativeEvaluationBCImpl();
		
		try{
			List<SpeSpQualEvVO> list = command.searchQualitativeEvaluation(event.getSpeSpQualEvVO(),account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchQualitativeEvaluation"}).getMessage(), ex);
		}	
		return eventResponse;
	}
	/**
	 *  Qualitative Evaluation 을 입력/수정한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiQualitativeEvaluation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1017Event event = (EsdSpe1017Event)e;
		QualitativeEvaluationBC command = new QualitativeEvaluationBCImpl();
		try{
			begin();
			String avgScore = command.multiQualitativeEvaluation(event.getSpeSpQualEvVOs(),account); 
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setETCData("avgScore", avgScore);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * QE 데이터를 입력/수정/삭제한다.<br>
	 *
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiQualitativeEvaluationCreation(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1015Event event = (EsdSpe1015Event) e;
		QualitativeEvaluationBC command = new QualitativeEvaluationBCImpl();
		try {
			begin();
			command.multiQualitativeEvaluationCreation(event.getSpeQECreVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("SPE00063").getUserMessage());
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
	 * QE 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchQualitativeEvaluationCreation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1015Event event = (EsdSpe1015Event)e;
		QualitativeEvaluationBC command = new QualitativeEvaluationBCImpl();
		
		try{
			List<SpeQECreVO> list = command.searchQualitativeEvaluationCreation(event.getSpeQECreVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("SPE00063", new String[]{"searchQualitativeEvaluationCreation"}).getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * Terminal Productivity Target Input 을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse selectTmlProdTgtInp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1013Event event = (EsdSpe1013Event)e;
		TerminalProductivityBC command = new TerminalProductivityBCImpl();
		
		try{
			List<TmlProdTgtInpVO> list = command.selectTmlProdTgtInp(event.getTmlProdTgtInpVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"selectTmlProdTgtInp"}).getMessage(), ex);
		}	
		return eventResponse;
	}		
	
	/**
	 * Terminal Productivity Target Input 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiTmlProdTgtInp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSpe1013Event event = (EsdSpe1013Event)e;
		TerminalProductivityBC command = new TerminalProductivityBCImpl();
		
		
		try{
			begin();
			command.multiTmlProdTgtInp(event.getTmlProdTgtInpVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
		}catch(EventException ex){
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"multiTmlProdTgtInp"}).getMessage(), ex);
		}	
		return eventResponse;
	}		
	
}