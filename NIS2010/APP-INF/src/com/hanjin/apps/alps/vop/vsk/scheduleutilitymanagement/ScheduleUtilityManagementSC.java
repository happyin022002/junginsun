/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScheduleUtilityManagementSC
*@FileTitle : ETA sending (Auto-fax)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.10
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2012.12.05 진마리아
* 1.0 Creation
* 
* History
* 2015.07.22 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.basic.ScheduleNotificationManagementBC;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.basic.ScheduleNotificationManagementBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.event.VopVsk0080Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.vo.VslSkdCngNotificationSetupVO;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.basic.ScheduleTransmitManagementBC;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.basic.ScheduleTransmitManagementBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVsk0090Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVsk0091Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVsk0092Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVsk0093Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVsk0290Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVsk0292Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVskSPPVSK0006Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVskSPPVSK0007Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVskSPPVSK0008Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVskSPPVSK0011Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVskSPPVSK0012Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo.EtaSendMoniVO;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo.EtaSendTgtVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration.VSKCodeFinderDBDAO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * NIS2010-VSKCommon Business Logic ServiceCommand - NIS2010-VSKCommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SEO CHANG YUL
 * @see VSKCodeFinderDBDAO
 * @since J2EE 1.4
 */

public class ScheduleUtilityManagementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * VSKCommon system 업무 시나리오 선행작업<br>
	 * UI_VSK-0202업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try { 
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {log.error(e.getMessage());}
	}

	/**
	 * ScheduleUtilityManagement system 업무 시나리오 마감작업<br>
	 * UI_VSK-0290 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ScheduleUtilityManagement 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-VSKCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopVsk0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslSkdCngNotificationSetupList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVslSkdCngNotificationSetupList(e);
			}		
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0090Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEtaSendTgtSkdList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkPort(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLane(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchVslList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEtaSendResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0091Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEtaSendMoniList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0290Event")){
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = manageEtaSendTgtSkd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0092Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPrestowageNoticeTgtSkdList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkPort(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLane(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchVslList(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0093Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPrestowageNoticeMoniList(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0292Event")){
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = managePrestowageNoticeSendSkd(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("VopVskSPPVSK0006Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEtaSendTgtSkdList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVskSPPVSK0007Event")){
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEtaSendResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVskSPPVSK0008Event")){
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEtaSendTgtSkd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVskSPPVSK0011Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPrestowageNoticeTgtSkdList(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("VopVskSPPVSK0012Event")){
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePrestowageNoticeSendSkd(e);
			}			
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0090 : Port Change<br>
	 * Port Code 가 존재하는지 여부를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPort(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		VSKCodeFinderBC 		command 		= new VSKCodeFinderBCImpl();
		String					sVpsPortCd		= null;
		try{
			
			if(e instanceof VopVsk0090Event){
				VopVsk0090Event event 	= (VopVsk0090Event)e;
				sVpsPortCd		= event.getEtaSendTgtVO().getVpsPortCd();
			}else if(e instanceof VopVsk0092Event){
				VopVsk0092Event event 	= (VopVsk0092Event)e;
				sVpsPortCd		= event.getEtaSendTgtVO().getVpsPortCd();
			}
			
			String chkPort = command.checkPort(sVpsPortCd);
			eventResponse.setETCData("check_port", chkPort);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0090 : Lane Change<br>
	 * Lane Code 가 존재하는지 여부를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLane(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		VSKCodeFinderBC 		command 		= new VSKCodeFinderBCImpl();
		MdmVslSvcLaneVO 		mdmVslSvcLaneVO = new MdmVslSvcLaneVO();
		String					sSlanCd			= null;
		
		try{
			
			if(e instanceof VopVsk0090Event){
				VopVsk0090Event event 	= (VopVsk0090Event)e;
				sSlanCd					= event.getEtaSendTgtVO().getSlanCd();
			}else if(e instanceof VopVsk0092Event){
				VopVsk0092Event event 	= (VopVsk0092Event)e;
				sSlanCd					= event.getEtaSendTgtVO().getSlanCd();
			}			
			
			mdmVslSvcLaneVO.setVslSlanCd(sSlanCd);
			List<MdmVslSvcLaneVO> list = command.checkSvcLane(mdmVslSvcLaneVO);
			String chkLane = null;
			if(list != null && list.size() > 0){
				chkLane = "X";//사용가능
			}
			eventResponse.setETCData("check_lane", chkLane);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_VSK_0080 : Retrieve
	 * 
	 * Vessel Schedule Notification Setup 데이터를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchVslSkdCngNotificationSetupList(Event e) throws EventException {
		
		GeneralEventResponse 				eventResponse 					= new GeneralEventResponse();
		ScheduleNotificationManagementBC 	command 						= new ScheduleNotificationManagementBCImpl();
		VslSkdCngNotificationSetupVO 		vslSkdCngNotificationSetupVO 	= new VslSkdCngNotificationSetupVO();

		try{
			VopVsk0080Event 	event 		= (VopVsk0080Event)e;
			vslSkdCngNotificationSetupVO 	= event.getVslSkdCngNotificationSetupVO();
			
			List<VslSkdCngNotificationSetupVO> list = null;
			list = command.searchVslSkdCngNotificationSetupList(vslSkdCngNotificationSetupVO);
			eventResponse.setRsVoList(list);

		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_VSK_0080 : Save<br>
	 * Vessel Schedule Notification Setup 데이터를 저장합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVslSkdCngNotificationSetupList(Event e) throws EventException {

		GeneralEventResponse 				eventResponse 					= new GeneralEventResponse();
		ScheduleNotificationManagementBC 	command 						= new ScheduleNotificationManagementBCImpl();
		
		VslSkdCngNotificationSetupVO[] 		vslSkdCngNotificationSetupVOs	= null;
		
		try{
			
			VopVsk0080Event event 			= (VopVsk0080Event)e;
			vslSkdCngNotificationSetupVOs 	= event.getVslSkdCngNotificationSetupVOs();
			
			begin();		
			
			if(vslSkdCngNotificationSetupVOs != null){
			
				for(VslSkdCngNotificationSetupVO tmpVO:vslSkdCngNotificationSetupVOs){
					
					log.debug("  ========= ::manageVslSkdCngNotificationSetupList::ib flag is :: ["+tmpVO.getIbflag()+"]\n");
					
					if("Y".equals(tmpVO.getPkModiFlg())){
						command.modifyVslSkdCngNotificationSetup(tmpVO);
					}else if("D".equals(tmpVO.getIbflag())){
						command.removeVslSkdCngNotificationSetup(tmpVO);
					}else if("I".equals(tmpVO.getIbflag()) || "U".equals(tmpVO.getIbflag())){
						command.manageVslSkdCngNotificationSetup(tmpVO);
					}
				}
			}
				
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * VOP_VSK_0090 : Lane Change<br>
	 * Lane Code 가 존재하는지 여부를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslList(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		VSKCodeFinderBC 		command 		= new VSKCodeFinderBCImpl();
		VesselVO 				vesselVO 		= new VesselVO();
		String					sVslCd			= null;
		
		try{
			
			if(e instanceof VopVsk0090Event){
				VopVsk0090Event event 	= (VopVsk0090Event)e;
				sVslCd					= event.getEtaSendTgtVO().getVslCd();
			}else if(e instanceof VopVsk0092Event){
				VopVsk0092Event event 	= (VopVsk0092Event)e;
				sVslCd					= event.getEtaSendTgtVO().getVslCd();
			}
			
			vesselVO.setVslCd(sVslCd);
			List<VesselVO> 	list 	= command.searchVslList(vesselVO);
			String 			chkVsl 	= null;
			
			if(list != null && list.size() > 0){
				chkVsl = "X";//사용가능
			}
			eventResponse.setETCData("check_vsl", chkVsl);
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}		
		return eventResponse;
	}	
	

	/**
	 * VOP_VSK_0090 : Retrieve
	 * 
	 * ETA Sending(Auto-fax) 대상 SKD을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEtaSendTgtSkdList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ScheduleTransmitManagementBC command = new ScheduleTransmitManagementBCImpl();
		EtaSendTgtVO etaSendTgtVO = new EtaSendTgtVO();

		try{
			if(e instanceof VopVsk0090Event){
				VopVsk0090Event event = (VopVsk0090Event)e;
				etaSendTgtVO = event.getEtaSendTgtVO();
			}else if(e instanceof VopVskSPPVSK0006Event){
				VopVskSPPVSK0006Event event = (VopVskSPPVSK0006Event)e;
				etaSendTgtVO = event.getEtaSendTgtVO();
			}
			
			List<EtaSendTgtVO> list = null;
			list = command.searchTransmitNoticeTgtSkdList(etaSendTgtVO);
			eventResponse.setRsVoList(list);

		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0092 or VopVskSPPVSK0011Event : Retrieve
	 * 
	 * Prestwage Notice Telex 대상SKD을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPrestowageNoticeTgtSkdList(Event e) throws EventException {
		
		GeneralEventResponse 			eventResponse 	= new GeneralEventResponse();
		ScheduleTransmitManagementBC 	command 		= new ScheduleTransmitManagementBCImpl();
		EtaSendTgtVO 					etaSendTgtVO 	= new EtaSendTgtVO();

		try{
			if(e instanceof VopVsk0092Event){
				VopVsk0092Event 	event 	= (VopVsk0092Event)e;
				etaSendTgtVO 				= event.getEtaSendTgtVO();
				etaSendTgtVO.setTrsmPurpCd("STW");
			}else if(e instanceof VopVskSPPVSK0011Event){
				VopVskSPPVSK0011Event event = (VopVskSPPVSK0011Event)e;
				etaSendTgtVO 				= event.getEtaSendTgtVO();
				etaSendTgtVO.setTrsmPurpCd("STW");
			}
			
			List<EtaSendTgtVO> list = null;
			list = command.searchTransmitNoticeTgtSkdList(etaSendTgtVO);
			eventResponse.setRsVoList(list);

		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	
	/**
	 * VOP_VSK_0091 : Save<br>
	 * 기전송된 ETA 정보에 대하여, RPM에 대한 결과값을 저장합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEtaSendResult(Event e) throws EventException {

		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		ScheduleTransmitManagementBC 	command 			= new ScheduleTransmitManagementBCImpl();
		
		EtaSendTgtVO[] 					etaSendTgtVOsOrg	= null;
		EtaSendTgtVO 					etaSendTgtVOTemp 	= null;
		List<EtaSendTgtVO>				etaSendTgtVOsCorr	= new ArrayList<EtaSendTgtVO>();
		
		try{
			
			begin();
			
			if(e instanceof VopVsk0090Event){
				VopVsk0090Event event = (VopVsk0090Event)e;
				etaSendTgtVOsOrg = event.getEtaSendTgtVOs();
			}else if(e instanceof VopVskSPPVSK0007Event){
				VopVskSPPVSK0007Event event = (VopVskSPPVSK0007Event)e;
				etaSendTgtVOsOrg = event.getEtaSendTgtVOs();
			}
			
			log.debug("  ========= ::manageEtaSendResult::start::=========  \n\n");
			
			if (etaSendTgtVOsOrg != null) {
				for(EtaSendTgtVO tmpEtaSendTgtVO:etaSendTgtVOsOrg){
					etaSendTgtVOTemp	= tmpEtaSendTgtVO;
					
					log.debug("  ========= ::manageEtaSendResult::tmpEtaSendTgtVO.getTrsmOwnrCd() ["+tmpEtaSendTgtVO.getTrsmOwnrCd()+"]\n");
					log.debug("  ========= ::manageEtaSendResult::tmpEtaSendTgtVO.getTrsmOwnrCd() == null ["+tmpEtaSendTgtVO.getTrsmOwnrCd() == null+"]\n");
					
					if(tmpEtaSendTgtVO.getTrsmOwnrCd() == null || "".equals(tmpEtaSendTgtVO.getTrsmOwnrCd()) || "ALPS".equals(tmpEtaSendTgtVO.getTrsmOwnrCd())){
						etaSendTgtVOTemp.setUpdUsrId(account.getUpd_usr_id()==null?"test_id":account.getUsr_id());
					}
					etaSendTgtVOsCorr.add(etaSendTgtVOTemp);
				}
			}
			
			log.debug("  ========= ::manageEtaSendResult::finish::=========  \n\n");
			
			command.manageEtaSendResult(etaSendTgtVOsCorr);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			
			commit();
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * VOP_VSK_0290 : Save <br>
	 * 변경된 VSK_VSL_PORT_SKD_TRSM_HIS의 ETA, ETB 정보를 저장하고 FAX 발송
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEtaSendTgtSkd(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 	= new GeneralEventResponse();
		EtaSendTgtVO 					etaSendTgtVO 	= new EtaSendTgtVO();
		ScheduleTransmitManagementBC 	command 		= new ScheduleTransmitManagementBCImpl();
		VSKCodeFinderBC					command2		= new VSKCodeFinderBCImpl();
		
		
		try{
			
			begin();
			if(e instanceof VopVsk0290Event){
				VopVsk0290Event event 		= (VopVsk0290Event)e;
				etaSendTgtVO 				= event.getEtaSendTgtVO();
				
				etaSendTgtVO.setCreUsrId	(account.getUsr_id());
				etaSendTgtVO.setUpdUsrId	(account.getUsr_id());
				etaSendTgtVO.setOfcCd		(account.getOfc_cd());
				
				etaSendTgtVO.setTrsmPurpCd	("ETA");
			
			}else if(e instanceof VopVskSPPVSK0008Event){
				VopVskSPPVSK0008Event event = (VopVskSPPVSK0008Event)e;
				etaSendTgtVO 				= event.getEtaSendTgtVO();
				
				etaSendTgtVO.setTrsmPurpCd	("ETA");
			}				

			etaSendTgtVO.setTrsmLoclDt		(command2.getTimeConvFmLocToLoc(etaSendTgtVO.getVpsPortCd(), "KRSEL", "YYYYMMDD HH24:MI"));
			
			log.debug("\n\n =====:jskjsk:===== getTimeConvFmLocToLoc ["+etaSendTgtVO.getTrsmLoclDt()+"]");
			
			////command.manageEtaSendTgtSkd(etaSendTgtVO);
			command.manageTransmitNoticeTargetSkd(etaSendTgtVO);
			
			commit();
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0292 or VopVskSPPVSK0012Event : Save <br>
	 * Prestowage Notce용의 TELEX 전송
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePrestowageNoticeSendSkd(Event e) throws EventException {
		
		GeneralEventResponse 			eventResponse 	= new GeneralEventResponse();
		EtaSendTgtVO 					etaSendTgtVO 	= new EtaSendTgtVO();
		ScheduleTransmitManagementBC 	command 		= new ScheduleTransmitManagementBCImpl();
		VSKCodeFinderBC					command2		= new VSKCodeFinderBCImpl();
		
		
		try{
			
			begin();
			if(e instanceof VopVsk0292Event){
				VopVsk0292Event event 		= (VopVsk0292Event)e;
				etaSendTgtVO 				= event.getEtaSendTgtVO();
				
				etaSendTgtVO.setCreUsrId	(account.getUsr_id());
				etaSendTgtVO.setUpdUsrId	(account.getUsr_id());
				etaSendTgtVO.setOfcCd		(account.getOfc_cd());
				
				etaSendTgtVO.setTrsmPurpCd	("STW");
				
			}else if(e instanceof VopVskSPPVSK0012Event){
				VopVskSPPVSK0012Event event = (VopVskSPPVSK0012Event)e;
				etaSendTgtVO 				= event.getEtaSendTgtVO();
				
				etaSendTgtVO.setTrsmPurpCd	("STW");
			}
			
			
			etaSendTgtVO.setTrsmLoclDt		(command2.getTimeConvFmLocToLoc(etaSendTgtVO.getVpsPortCd(), "KRSEL", "YYYYMMDD HH24:MI"));
			
			log.debug("\n\n =====:jskjsk:===== getTimeConvFmLocToLoc ["+etaSendTgtVO.getTrsmLoclDt()+"]");
			
			////command.manageEtaSendTgtSkd(etaSendTgtVO);
			command.manageTransmitNoticeTargetSkd(etaSendTgtVO);
			
			commit();
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0091 : Retrieve<br>
	 * ETA Sending(Auto TLX/FAX) 내역을 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEtaSendMoniList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0091Event event = (VopVsk0091Event)e;
		ScheduleTransmitManagementBC command = new ScheduleTransmitManagementBCImpl();
		
		try{
			List<EtaSendMoniVO> list = command.searchTransmitNoticeMoniList(event.getEtaSendMoniVO());

			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_VSK_0093 : Retrieve<br>
	 * Prestowage Notice 발송내역 Monitoring 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrestowageNoticeMoniList(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 	= new GeneralEventResponse();
		VopVsk0093Event 				event 			= (VopVsk0093Event)e;
		ScheduleTransmitManagementBC 	command 		= new ScheduleTransmitManagementBCImpl();
		
		try{
			
			List<EtaSendMoniVO> list = command.searchTransmitNoticeMoniList(event.getEtaSendMoniVO());

			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}		
		return eventResponse;
	}
	
}