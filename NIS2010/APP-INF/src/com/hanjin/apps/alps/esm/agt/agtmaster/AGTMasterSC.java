/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTMasterSC.java
*@FileTitle : 중국 Outbound 대리점 정보 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.07.28 이호진
* 1.0 Creation
* 1.1 2011.04.22 박성진 [CHM-201109104-01]Customer Vs Vendor for S. America 개발
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster;

import java.util.List;

import com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.basic.AGTCustomerInfoBC;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.basic.AGTCustomerInfoBCImpl;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.event.EsmAgt0025Event;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.event.EsmAgt0026Event;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.event.EsmAgt0030Event;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.event.EsmAgt0058Event;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.basic.AGTOfficeInfoBC;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.basic.AGTOfficeInfoBCImpl;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.event.EsmAgt0022Event;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.event.EsmAgt0023Event;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.event.EsmAgt0024Event;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.integration.AGTOfficeInfoDBDAO;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtsecurity.basic.AGTSecurityBC;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtsecurity.basic.AGTSecurityBCImpl;
import com.hanjin.apps.alps.esm.agt.agtmaster.agtsecurity.event.EsmAgt0038Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.AgtBrogCustIntVO;
import com.hanjin.syscommon.common.table.AgtBrogCustMtchVO;
import com.hanjin.syscommon.common.table.AgtChnLaneAgnVO;
import com.hanjin.syscommon.common.table.AgtChnVslAgnVO;
import com.hanjin.syscommon.common.table.AgtCmpnCustMtchVO;
import com.hanjin.syscommon.common.table.AgtFacCustRltVO;
import com.hanjin.syscommon.common.table.AgtFincOfcInfoVO;
import com.hanjin.syscommon.common.table.BkgChnAgnVO;


/**
 * ALPS-AGTMaster Business Logic ServiceCommand - ALPS-AGTMaster 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Lee Ho Jin
 * @see AGTOfficeInfoDBDAO
 * @since J2EE 1.6
 */

public class AGTMasterSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * AGTMaster system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("AGTMasterSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * AGTMaster system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("AGTMasterSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-AGTMaster system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmAgt0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChinaBKGAgentList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageChinaAgentCode(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmAgt0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneInboundAgentList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = multiLaneInboundAgentList(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmAgt0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInboundChinaOfficeInfoForVessel(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = multiInboundChinaOfficeInfoForVessel(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmAgt0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFForwarderVendorMatchingInfoForBrokerage(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = multiFForwarderVendorMatchingInfoForBrokerage(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmAgt0026Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBRKGCustomerToShipperInterestList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = multiBRKGCustomerToShipperInterestInfo(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmAgt0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFACCustomerToShipperInterestList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = multiFACCustomerToShipperInterestList(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmAgt0038Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAROfficeInfoList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiAROfficeInfobyOffice(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmAgt0058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchShipperVendorMatchingInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = multiShipperVendorMatchingInfo(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_AGT_022 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChinaBKGAgentList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0022Event event = (EsmAgt0022Event)e;
		AGTOfficeInfoBC command = new AGTOfficeInfoBCImpl();

		try{
			List<BkgChnAgnVO> list = command.searchChinaBKGAgentList(event.getBkgChnAgnVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
    /**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * 중국 Booking Agent 정보 등록 화면 관리한다.<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageChinaAgentCode(Event e) throws EventException {
		//GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0022Event event = (EsmAgt0022Event)e;
		AGTOfficeInfoBC command = new AGTOfficeInfoBCImpl();
		try {
			begin(); 
			command.multiChinaBKGAgentList(event.getBKGChinaAgentVOs(), account);
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return searchChinaBKGAgentList(e);
		//return eventResponse;
	}

	/**
	 * (ESM_AGT_0023) 중국 Inbound 대리점 정보 관리의 모든 목록을 가져온다.<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchLaneInboundAgentList(Event e) throws EventException{
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0023Event event = (EsmAgt0023Event)e;
		AGTOfficeInfoBC command = new AGTOfficeInfoBCImpl();

		try{
			List<AgtChnLaneAgnVO> list = command.searchLaneInboundAgentList(event.getAgtChnLaneAgnVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}
	/**
	 * ESM_AGT_0023 화면에 대한 멀티 이벤트 처리<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiLaneInboundAgentList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0023Event event = (EsmAgt0023Event)e;
		AGTOfficeInfoBC command = new AGTOfficeInfoBCImpl();
		try{
			begin();
			command.multiLaneInboundAgentList(event.getAgtChnLaneAgnVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	/**
	 * (ESM_AGT_0024) Inbound China Agent Office Info for Vessel 의 정보를 가져온다.<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchInboundChinaOfficeInfoForVessel(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0024Event event = (EsmAgt0024Event)e;
		AGTOfficeInfoBC command = new AGTOfficeInfoBCImpl();
		try{
			List<AgtChnVslAgnVO> list = command.searchInboundChinaOfficeInfoForVessel(event.getAgtChnVslAgnVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * (ESM_AGT_0024) Inbound China Agent Office Info for Vessel 의 멀티이벤드<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiInboundChinaOfficeInfoForVessel(Event e) throws EventException{
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0024Event event = (EsmAgt0024Event)e;
		AGTOfficeInfoBC command = new AGTOfficeInfoBCImpl();
		try{
			begin();
			command.multiInboundChinaOfficeInfoForVessel(event.getAgtChnVslAgnVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	/**
	 * ESM_AGT_0025 화면에 대한 조회 이벤트 처리<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchFForwarderVendorMatchingInfoForBrokerage(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0025Event event = (EsmAgt0025Event)e;
		AGTCustomerInfoBC command = new AGTCustomerInfoBCImpl();
		try{
			List<AgtBrogCustMtchVO> list = command.searchFForwarderVendorMatchingInfoForBrokerage(event.getAgtBrogCustMtchVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
    }
	/**
	 * ESM_AGT_0025 화면에 대한 멀티 이벤트 처리<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiFForwarderVendorMatchingInfoForBrokerage(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0025Event event = (EsmAgt0025Event)e;
		AGTCustomerInfoBC command = new AGTCustomerInfoBCImpl();
		try{
			begin();
			command.multiFForwarderVendorMatchingInfoForBrokerage(event.getAgtBrogCustMtchVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
    }
	/**
	 * ESM_AGT_026 화면 조회<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchBRKGCustomerToShipperInterestList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0026Event event = (EsmAgt0026Event)e;
		AGTCustomerInfoBC command = new AGTCustomerInfoBCImpl();
		try{
			List<AgtBrogCustIntVO> list = command.searchBRKGCustomerToShipperInterestList(event.getAgtBrogCustIntVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
    }
	/**
	 * ESM_AGT_026 화면 Multi<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiBRKGCustomerToShipperInterestInfo(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0026Event event = (EsmAgt0026Event)e;
		AGTCustomerInfoBC command = new AGTCustomerInfoBCImpl();
		try{
			begin();
			command.multiBRKGCustomerToShipperInterestInfo(event.getAgtBrogCustIntVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
    }
	
	private EventResponse searchFACCustomerToShipperInterestList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0030Event event = (EsmAgt0030Event)e;
		AGTCustomerInfoBC command = new AGTCustomerInfoBCImpl();
		try{
			List<AgtFacCustRltVO> list = command.searchFACCustomerToShipperInterestList(event.getAgtFacCustRltVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
    }

	private EventResponse multiFACCustomerToShipperInterestList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0030Event event = (EsmAgt0030Event)e;
		AGTCustomerInfoBC command = new AGTCustomerInfoBCImpl();
		try{
			begin();
			command.multiFACCustomerToShipperInterestList(event.getAgtFacCustRltVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
    }
	
	/**
	 * ESM_AGT_0038 : [Security & AR Office 이벤트]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAROfficeInfoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0038Event event = (EsmAgt0038Event)e;
		AGTSecurityBC command = new AGTSecurityBCImpl();

		try{
			List<AgtFincOfcInfoVO> list = command.searchAROfficeInfoList(event.getAgtFincOfcInfoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * ESM_AGT_0038 : [Security & AR Office 멀티 이벤트]<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiAROfficeInfobyOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0038Event event = (EsmAgt0038Event)e;
		AGTSecurityBC command = new AGTSecurityBCImpl();
		try{
			begin();
			command.multiAROfficeInfobyOffice(event.getAgtFincOfcInfoVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			List<AgtFincOfcInfoVO> list = command.searchAROfficeInfoList(event.getAgtFincOfcInfoVO());
			eventResponse.setRsVoList(list);
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
	 * ESM_AGT_0025 화면에 대한 조회 이벤트 처리<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchShipperVendorMatchingInfo(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0058Event event = (EsmAgt0058Event)e;
		AGTCustomerInfoBC command = new AGTCustomerInfoBCImpl();
		try{
			List<AgtCmpnCustMtchVO> list = command.searchShipperVendorMatchingInfo(event.getAgtCmpnCustMtchVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
    }

	/**
	 * ESM_AGT_0025 화면에 대한 멀티 이벤트 처리<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiShipperVendorMatchingInfo(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0058Event event = (EsmAgt0058Event)e;
		AGTCustomerInfoBC command = new AGTCustomerInfoBCImpl();
		try{
			begin();
			command.multiShipperVendorMatchingInfo(event.getAgtCmpnCustMtchVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
    }
	
}