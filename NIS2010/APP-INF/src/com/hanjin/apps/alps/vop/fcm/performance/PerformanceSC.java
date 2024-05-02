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
* 
* History
* 2015.01.23 이병훈 [CHM-201430612] Fuel Consumption Master table 개발
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.performance;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.fcm.fcmcommon.fcmcommon.basic.FCMCommonBC;
import com.hanjin.apps.alps.vop.fcm.fcmcommon.fcmcommon.basic.FCMCommonBCImpl;
import com.hanjin.apps.alps.vop.fcm.performance.performance.basic.PerformanceBC;
import com.hanjin.apps.alps.vop.fcm.performance.performance.basic.PerformanceBCImpl;
import com.hanjin.apps.alps.vop.fcm.performance.performance.event.VopFcm0061Event;
import com.hanjin.apps.alps.vop.fcm.performance.performance.event.VopFcm0062Event;
import com.hanjin.apps.alps.vop.fcm.performance.performance.event.VopFcm0063Event;
import com.hanjin.apps.alps.vop.fcm.performance.performance.vo.FcmMasterTableInquiryVO;
import com.hanjin.apps.alps.vop.fcm.performance.performance.vo.FcmMonFoilSavCostVO;
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

public class PerformanceSC extends ServiceCommandSupport {

	// Login User Information
	protected SignOnUserAccount account = null;

	/**
	 * VesselReportSC system 업무 시나리오 선행작업<br>
	 */
	public void doStart() {
		log.debug("VesselReportSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
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
	
	@Override
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopFcm0061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFcmMonFoilSavCostForCre(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmVslSlanCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFcmMonFoilSavCostList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopFcm0062Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFcmMonFoilSavCost(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmVslSlanCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMdmVslCd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopFcm0063Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFcmMasterTableInquiry(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0062  : Search <br>
	 * 생성된 Monthly Fuel saving Cost 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFcmMonFoilSavCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0062Event event = (VopFcm0062Event)e;
		PerformanceBC command = new PerformanceBCImpl();
		
		try {
			List<FcmMonFoilSavCostVO> fcmMonFoilSavCostVOs = command.searchFcmMonFoilSavCostList(event.getFcmMonFoilSavCostVO());
			eventResponse.setRsVoList(fcmMonFoilSavCostVOs);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Departure Report" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0061  : Search <br>
	 * Monthly Fuel saving Cost 정보를 생성하기 위한 기본 데이터를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFcmMonFoilSavCostForCre(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0061Event event = (VopFcm0061Event)e;
		PerformanceBC command = new PerformanceBCImpl();
		try {
			FcmMonFoilSavCostVO fcmMonFoilSavCostVO = event.getFcmMonFoilSavCostVO();
			fcmMonFoilSavCostVO.setSavCostCreYrmon(fcmMonFoilSavCostVO.getSavCostCreYrmon().replaceAll("-", ""));
			String isExist = command.searchFcmMonFoilSavCostExist(fcmMonFoilSavCostVO);

			List<FcmMonFoilSavCostVO> fcmMonFoilSavCostVOs = new ArrayList<FcmMonFoilSavCostVO>();
			fcmMonFoilSavCostVOs = command.searchFcmMonFoilSavCostForCre(fcmMonFoilSavCostVO);

			eventResponse.setETCData("is_exist", isExist);
			eventResponse.setRsVoList(fcmMonFoilSavCostVOs);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Fuel Saving Cost Creation" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0061  : Lane Code onChange <br>
	 * MDM에 존재하는 lane인지 check합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmVslSlanCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FCMCommonBC comCommand = new FCMCommonBCImpl();
		try {
			String param = null;
			if (e instanceof VopFcm0061Event) {
				VopFcm0061Event event = (VopFcm0061Event) e;
				param = event.getFcmMonFoilSavCostVO().getVslSlanCd();
			}else if (e instanceof VopFcm0062Event) {
				VopFcm0062Event event = (VopFcm0062Event) e;
				param = event.getFcmMonFoilSavCostVO().getVslSlanCd();
			}
			String vslSlanCd = comCommand.searchMdmVslSlanCd(param);
			eventResponse.setETCData("vsl_slan_cd", vslSlanCd);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Lane Code Check" }).getMessage(), eex);			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0062  : Vessel Code onChange <br>
	 * MDM에 존재하는 vsl인지 check합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmVslCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FCMCommonBC comCommand = new FCMCommonBCImpl();
		try {
			String param = null;
			if (e instanceof VopFcm0062Event) {
				VopFcm0062Event event = (VopFcm0062Event) e;
				param = event.getFcmMonFoilSavCostVO().getVslCd();
			}
			String vslCd = comCommand.searchMdmVslCd(param);
			eventResponse.setETCData("vsl_cd", vslCd);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Vessel Code Check" }).getMessage(), eex);			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_FCM_0061  : Save <br>
	 * Monthly Fuel Saving Cost 생성.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFcmMonFoilSavCostList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0061Event event = (VopFcm0061Event)e;
		PerformanceBC command = new PerformanceBCImpl();
		try {
			begin();
			String inqVslSlanCd = event.getFcmMonFoilSavCostVO().getVslSlanCd();
			command.manageFcmMonFoilSavCostList(event.getFcmMonFoilSavCostVOs(), account, inqVslSlanCd);
			commit();
		} catch(EventException eex){
			rollback();
			log.error("err " + eex.toString(), eex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Monthly Fuel Saving Cost Creation" }).getMessage(), eex);			
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Fuel Consumption Master Table Inquiry 정보를 조회합니다.<br>
	 * VOP_FCM_0063  : Search<br>
	 * [CHM-201430612] Fuel Consumption Master table 개발
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFcmMasterTableInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0063Event event = (VopFcm0063Event)e;
		PerformanceBC command = new PerformanceBCImpl();
		try {
			List<FcmMasterTableInquiryVO> fcmMasterTableInquiryVOs = command.searchFcmMasterTableInquiry(event.getFcmMonFoilSavCostVO());
			eventResponse.setRsVoList(fcmMasterTableInquiryVOs);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Fuel Consumption Master Table Inquiry" }).getMessage(), eex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
}
