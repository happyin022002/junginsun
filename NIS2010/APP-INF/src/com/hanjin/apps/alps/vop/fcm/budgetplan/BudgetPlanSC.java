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

package com.hanjin.apps.alps.vop.fcm.budgetplan;

import java.util.List;

import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.basic.BudgetPlanBC;
import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.basic.BudgetPlanBCImpl;
import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.event.VopFcm0031Event;
import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo.FcmBudTgtVvdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS BudgetPlan ServiceCommand - VesselReport 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Hyuk Ryu
 * @see 
 * @since J2EE 1.6
 */

public class BudgetPlanSC extends ServiceCommandSupport {

	// Login User Information
	protected SignOnUserAccount account = null;

	/**
	 * BudgetPlanSC system 업무 시나리오 선행작업<br>
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
	 * BudgetPlanSC system 업무 시나리오 마감작업<br>
	 */
	public void doEnd() {
		log.debug("VesselReportSC 종료");
	}
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS BudgetPlanSC system 업무에서 발생하는 모든 이벤트의 분기처리<br>
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
		if(e.getEventName().equalsIgnoreCase("VopFcm0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBudTgtVvdList(e);
			}
		}
		return eventResponse;
	}

	/**
	 * VOP_FCM_0031  : Display <br>
	 * Budget Plan 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBudTgtVvdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopFcm0031Event event = (VopFcm0031Event)e;
		BudgetPlanBC command = new BudgetPlanBCImpl();
		
		try {
		
				List<FcmBudTgtVvdVO> fcmBudTgtVvdVOList = command.searchBudTgtVvdList(event.getFcmBudTgtVvdInqVO());
				//List<FcmBudTgtVvdCsmVO> fcmBudTgtVvdCsmVOList = command.searchBudTgtVvdCsmList(event.getFcmBudTgtVvdInqVO());
						
				eventResponse.setRsVoList(fcmBudTgtVvdVOList);
				//eventResponse.setRsVoList(fcmBudTgtVvdCsmVOList);
			
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Budget Plan Report" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
		
}
