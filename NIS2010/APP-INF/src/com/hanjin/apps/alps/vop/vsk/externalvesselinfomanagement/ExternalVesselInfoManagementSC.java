/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ExternalVesselInfoManagementSC.java
*@FileTitle : ExternalVesselInfoManagementSC
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.18
*@LastModifier : LIM YE JI
*@LastVersion : 1.0
* 2014.05.18 LIM YE JI
* 1.0 Creation
* 
* History
* 
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement;

import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.basic.VesselPassagePlanManagementBC;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.basic.VesselPassagePlanManagementBCImpl;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.event.VesselPassagePlanReceiveQueueEvent;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.vo.PassagePlanDtVO;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.basic.VesselPositionPollingManagementBC;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.basic.VesselPositionPollingManagementBCImpl;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.event.UbizhjsAlpsvskPositionPollEvent;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.vo.PositionPollingHeaderVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * External Vessel Information Management Business Logic ServiceCommand - ALPS-ExternalVesselInfoManagement 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author LIM YE-JI
 * @see ExternalVesselInfoManagementSC
 * @since J2EE 1.6
 */
public class ExternalVesselInfoManagementSC  extends ServiceCommandSupport{
	
	// Login User Information
		private SignOnUserAccount account = null;

		/**
		 * ExternalVesselInfoManagement system 업무 시나리오 선행작업<br>
		 */
		public void doStart() {
			try {
				// 일단 comment --> 로그인 체크 부분
				account = getSignOnUserAccount();
			} catch (Exception e) {log.error(e.getMessage());}
		}

		/**
		 * ExternalVesselInfoManagement system 업무 시나리오 선행작업<br>
		 */
		public void doEnd() {
			log.debug("ExternalVesselInfoManagementSC 종료");
		}
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ExternalVesselInfoManagement system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("UbizhjsAlpsvskPositionPollEvent")) {
			
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = receiveEDIToPositionPollingHeader(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VesselPassagePlanReceiveQueueEvent")) {
			
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = receivePassagePlanFromVMS(e);
			}
		}

		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * MQ 메세지 전문 저장 및 체크<br>
	 * Position Polling Flat File을 Header 테이블에 저장한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveEDIToPositionPollingHeader(Event e) throws EventException{
		
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		VesselPositionPollingManagementBC command 		= new VesselPositionPollingManagementBCImpl();
		
		//Event event									= (UbizhjsAlpsvskSkdAllianceEvent)e;
		try{ 
			UbizhjsAlpsvskPositionPollEvent event = (UbizhjsAlpsvskPositionPollEvent)e;
			
//			log.info("################### EDI POSITION POLLING RECEIVE START ###################");
			
			String					sRawFlatFile 		= event.getFlatFile();
//			log.info("################### EDI POSITION POLLING RECEIVE FINISHED ################");
			
			this.begin();
			PositionPollingHeaderVO 	positionPollingHeaderVO = command.createPositionPollingHeaderFromEdi(sRawFlatFile);
			this.commit();
			
			if(positionPollingHeaderVO.getRcvCtnt() != "DUPLICATED"){
				this.receiveEDIToPositionPollingDetail(positionPollingHeaderVO, sRawFlatFile);
			}
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * MQ 메세지 전문 저장 및 체크<br>
	 * Position Polling Flat File을 Detail 테이블에 저장하기 위해 Back End Job을 호출한다.
	 * 
	 * @param PositionPollingHeaderVO positionPollingHeaderVO
	 * @param String sRawFlatFile
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveEDIToPositionPollingDetail(PositionPollingHeaderVO positionPollingHeaderVO, String sRawFlatFile) throws EventException{
		
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		VesselPositionPollingManagementBC command 	= new VesselPositionPollingManagementBCImpl();
		
		//Event event									= (UbizhjsAlpsvskSkdAllianceEvent)e;
		try{ 
			command.createPositionPollingDetailFromEdiBackEndJob(positionPollingHeaderVO, sRawFlatFile);
				
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * 
	 * Create Departure Reports received from VMS.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receivePassagePlanFromVMS(Event e) throws EventException {
		VesselPassagePlanReceiveQueueEvent event = (VesselPassagePlanReceiveQueueEvent)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		PassagePlanDtVO passagePlanDtVO = event.getPassagePlanDtVO();
//		for(PassagePlanDtVO passagePlanDtVO : passagePlanDtVOs){
			managePassagePlan(passagePlanDtVO);
//		}
		return eventResponse;
	}
	
	/**
	 * Create or update passage plan.<br>
	 * 
	 * @param PassagePlanDtVO passagePlanDtVO
	 */
	private void managePassagePlan(PassagePlanDtVO passagePlanDtVO) {
		VesselPassagePlanManagementBC command 	= new VesselPassagePlanManagementBCImpl();
		try{
			begin();
			command.managePassagePlan(passagePlanDtVO);
			commit();
		}catch(Exception ex){
			rollback();
			log.error(ex.getMessage());
		}
	} 
	
	
}