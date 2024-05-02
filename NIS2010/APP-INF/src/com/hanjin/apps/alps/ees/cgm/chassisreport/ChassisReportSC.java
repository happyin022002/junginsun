/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisReportSC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 최덕우
*@LastVersion : 1.0
*  2014.04.16 최덕우
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassisreport;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration.ChassisMgsetOnOffhireDBDAO;
import com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.basic.ChassisLongStayingReportBC;
import com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.basic.ChassisLongStayingReportBCImpl;
import com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.event.EesCgm1158Event;
import com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.vo.ChassisLongStayingVO;
import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.basic.ChassisReportBC;
import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.basic.ChassisReportBCImpl;
import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.event.EesCgm1157Event;
import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.vo.LandInvMonitoringVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ChassisMgsetMgt Business Logic ServiceCommand - ALPS-ChassisMgsetMgt 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Duk-Woo Choi
 * @see ChassisMgsetOnOffhireDBDAO
 * @since J2EE 1.4
 */
public class ChassisReportSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ChassisMgsetMgt system 업무 시나리오 선행작업<br>
	 * EES_CGM_1002업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ChassisMgsetMgt system 업무 시나리오 마감작업<br>
	 * EES_CGM_1002 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ChassisReportSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-ChassisMgsetMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		try
		{
			// RDTO(Data Transfer Object including Parameters)
			EventResponse eventResponse = null;

			// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
			if (e.getEventName().equalsIgnoreCase("EesCgm1157Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {                 // 1 - Start of Back End Job
					eventResponse = startBackEndJobSearchLandInvMonitoringSummary(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {        // 1 - Start of Back End Job
					eventResponse = startBackEndJobSearchLandInvMonitoringDetail(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {    // 2 - Get status of Back End Job
					eventResponse = getBackEndJobStatus(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {    // 3 - Result return
					eventResponse = resultBackEndJobSearchLandInvMonitoring(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {        // get TpszList
					eventResponse = searchTpszList();
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1158Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {                 // 1 - Start of Back End Job
					log.error(">>>>>>         Retrive1        <<<<<<");
					eventResponse = searchLongStayingChassisList(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {        // get TpszList
					eventResponse = searchTpszList();
				}
			}

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	
	
	/**
	 * [EES_CGM_1157] Summary Tab Retrieve - Back End Job 시작<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobSearchLandInvMonitoringSummary(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1157Event event = (EesCgm1157Event)e;
		ChassisReportBC command = new ChassisReportBCImpl();
		try {
			begin();
			eventResponse.setETCData("backEndJob_Key", command.startBackEndJobSearchLandInvMonitoringSummary(event.getLandInvMonitoringVO(), account));
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
	 * [EES_CGM_1157] Detail Tab Retrieve - Back End Job 시작<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobSearchLandInvMonitoringDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1157Event event = (EesCgm1157Event)e;
		ChassisReportBC command = new ChassisReportBCImpl();
		try {
			begin();
			eventResponse.setETCData("backEndJob_Key", command.startBackEndJobSearchLandInvMonitoringDetail(event.getLandInvMonitoringVO(), account));
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
	 * Back End Job 공통 - Back End Job Status 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1157Event event = (EesCgm1157Event)e;
		ChassisReportBC command = new ChassisReportBCImpl();
		try {
			String jbStsFlg = command.getBackEndJobStatus((String) event.getAttribute("backEndJob_Key"));
			eventResponse.setETCData("jb_sts_flg", jbStsFlg);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1157] Back End Job 결과<br>
	 * Commission Report 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobSearchLandInvMonitoring(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1157Event event = (EesCgm1157Event)e;
		ChassisReportBC command = new ChassisReportBCImpl();
		try {
			List<LandInvMonitoringVO> list = command.resultBackEndJobSearchLandInvMonitoring((String) event.getAttribute("backEndJob_Key"));
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [EES_CGM_1157] : [Retrieve] <br>
	 * TP/SZ List 를 조회한다. Retrieve <br>주1)
	 *
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchTpszList() throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			ChassisReportBC command = new ChassisReportBCImpl();
			
			List<LandInvMonitoringVO> cntrTpSzlist = command.searchTpszList();
			
			StringBuffer sCntrTpSzNm = new StringBuffer();
	
			for ( int i = 0 ; i < cntrTpSzlist.size() ; i++ ) {
				if ( sCntrTpSzNm.toString().equals("") ) {
					sCntrTpSzNm.append(cntrTpSzlist.get(i).getCdId());
				} else {
					sCntrTpSzNm.append("|").append(cntrTpSzlist.get(i).getCdId());
				}
			}
	
			eventResponse.setETCData("cntr_tpsz_nm", sCntrTpSzNm.toString());
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_1158] : [Retrieve] <br>
	 * Chassis L/Staying List 를 조회한다. Retrieve <br>주1)
	 *
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	
	private EventResponse searchLongStayingChassisList(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			EesCgm1158Event event = (EesCgm1158Event)e;
			// PDTO(Data Transfer Object including Parameters)
			ChassisLongStayingReportBC command = new ChassisLongStayingReportBCImpl();
			
			List<ChassisLongStayingVO> ChassisLongStayingList = command.searchLongStayingChassisList(event.getChassisLongStayingVO());
					
			eventResponse.setRsVoList(ChassisLongStayingList);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	
}
