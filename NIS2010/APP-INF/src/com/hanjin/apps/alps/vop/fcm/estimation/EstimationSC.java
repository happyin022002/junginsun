/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselReportSC.java
*@FileTitle : VesselReport
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.estimation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hanjin.apps.alps.vop.fcm.estimation.estimation.basic.EstimationBC;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.basic.EstimationBCImpl;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.event.VopFcm0041Event;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.event.VopFcm0042Event;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.event.VopFcm0044Event;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo.FcmEstmWkCsmIfVO;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo.FcmRmnOilMonEndRptVO;
import com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo.MonEstmCsmVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS VesselReport ServiceCommand - VesselReport 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Hyuk Ryu
 * @see 
 * @since J2EE 1.6
 */

public class EstimationSC extends ServiceCommandSupport {

	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * VesselReportSC system 업무 시나리오 선행작업<br>
	 */
	public void doStart() {
		log.debug("VesselReportSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
			log.debug(account.getUsr_id());
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * VesselReportSC system 업무 시나리오 마감작업<br>
	 */
	public void doEnd() {
		log.debug("VesselReportSC 종료");
	}
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS VesselReport system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopFcm0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMonEstmTgtVvdList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMonthlyEstmationConsumption(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = searchMonthlyEstmationConsumption(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopFcm0042Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWeekTgtVvdInfo(e);
			}else{
				eventResponse = searchAutoIFStatus(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopFcm0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRemainOilMonthEndReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRemainOilMonthEndReport(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0041 : Retrieve <br>
	 * Search target VVD list for a monthly estimation consumption.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonEstmTgtVvdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0041Event event = (VopFcm0041Event)e;
		MonEstmCsmVO fcmEstmMonCsmIfVO = event.getMonEstmCsmVO();
		EstimationBC command = new EstimationBCImpl();
		
		try {
			List<MonEstmCsmVO> fcmEstmMonCsmIfVOs = new ArrayList<MonEstmCsmVO>();
			fcmEstmMonCsmIfVOs = command.searchMonEstmTgtVvdList(fcmEstmMonCsmIfVO.getBseYrmon().replace("-",""));
			eventResponse.setRsVoList(fcmEstmMonCsmIfVOs);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Estimation" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0041 : Creation<br>
	 * Search a monthly estimation consumption.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyEstmationConsumption(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0041Event event = (VopFcm0041Event)e;
		MonEstmCsmVO[] monEstmCsmVOs = event.getMonEstmCsmVOs();
		EstimationBC command = new EstimationBCImpl();
		try {
			command.searchMonthlyEstmationConsumption(monEstmCsmVOs);
			eventResponse.setRsVoList(Arrays.asList(monEstmCsmVOs));
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "ROB End Month Report List" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0042  : Retrieve <br>
	 * 주간 추정 대상 항차를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeekTgtVvdInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0042Event event = (VopFcm0042Event)e;
		FcmEstmWkCsmIfVO fcmEstmWkCsmIfVO = event.getFcmEstmWkCsmIfVO();
		EstimationBC command = new EstimationBCImpl();
		try {
				List<FcmEstmWkCsmIfVO> fcmEstmWkCsmIfVOs = new ArrayList<FcmEstmWkCsmIfVO>();
				fcmEstmWkCsmIfVOs = command.searchWeekTgtVvdInfo(fcmEstmWkCsmIfVO);
				eventResponse.setRsVoList(fcmEstmWkCsmIfVOs);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Weekly Estimation" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0042  : Window Open<br>
	 * Search auto I/F status.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAutoIFStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EstimationBC command = new EstimationBCImpl();
		try {
				String status = command.searchAutoIFStatus();
				eventResponse.setETCData("AUTO", status); // status ==> "AUTO" OR "NON-AUTO"
		} catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("COM12203", new String[] { "Search auto I/F status" }).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0044 : Open<br>
	 * Revenue Month별 Vessel 월말 잔량 내역을 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRemainOilMonthEndReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0044Event event = (VopFcm0044Event)e;
		FcmRmnOilMonEndRptVO fcmRmnOilMonEndRptVO = event.getFcmRmnOilMonEndRptVO();
		EstimationBC command = new EstimationBCImpl();
		try {
				List<FcmRmnOilMonEndRptVO> fcmRmnOilMonEndRptVOs = new ArrayList<FcmRmnOilMonEndRptVO>();
				fcmRmnOilMonEndRptVOs = command.searchRemainOilMonthEndReport(fcmRmnOilMonEndRptVO);
				eventResponse.setRsVoList(fcmRmnOilMonEndRptVOs);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "ROB End Month Report List" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0044 : Save<br>
	 * Revenue Month별 Vessel 월말 잔량 내역을 변경한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRemainOilMonthEndReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0044Event event = (VopFcm0044Event)e;
		FcmRmnOilMonEndRptVO[] fcmRmnOilMonEndRptVOs = event.getFcmRmnOilMonEndRptVOs();
		EstimationBC command = new EstimationBCImpl();
		try {
			command.manageRemainOilMonthEndReport(fcmRmnOilMonEndRptVOs, account.getUsr_id());
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "ROB End Month Report List" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
}
