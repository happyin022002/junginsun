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

package com.clt.apps.opus.vop.fcm.performance;

import java.util.List;

import com.clt.apps.opus.vop.fcm.performance.performance.basic.PerformanceBC;
import com.clt.apps.opus.vop.fcm.performance.performance.basic.PerformanceBCImpl;
import com.clt.apps.opus.vop.fcm.performance.performance.event.VopFcm0063Event;
import com.clt.apps.opus.vop.fcm.performance.performance.vo.FcmMasterTableInquiryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

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
		if (e.getEventName().equalsIgnoreCase("VopFcm0063Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFcmMasterTableInquiry(e);
			}
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
