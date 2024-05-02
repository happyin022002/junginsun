/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTMasterSC.java
*@FileTitle : China Outbound Agent Information management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster;

import java.util.List;

import com.clt.apps.opus.esm.agt.agtmaster.agtcustomerinfo.basic.AGTCustomerInfoBC;
import com.clt.apps.opus.esm.agt.agtmaster.agtcustomerinfo.basic.AGTCustomerInfoBCImpl;
import com.clt.apps.opus.esm.agt.agtmaster.agtcustomerinfo.event.EsmAgt0025Event;
import com.clt.apps.opus.esm.agt.agtmaster.agtcustomerinfo.event.EsmAgt0026Event;
import com.clt.apps.opus.esm.agt.agtmaster.agtcustomerinfo.event.EsmAgt0030Event;
import com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.basic.AGTOfficeInfoBC;
import com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.basic.AGTOfficeInfoBCImpl;
import com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.event.EsmAgt0022Event;
import com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.event.EsmAgt0023Event;
import com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.event.EsmAgt0024Event;
import com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.integration.AGTOfficeInfoDBDAO;
import com.clt.apps.opus.esm.agt.agtmaster.agtsecurity.basic.AGTSecurityBC;
import com.clt.apps.opus.esm.agt.agtmaster.agtsecurity.basic.AGTSecurityBCImpl;
import com.clt.apps.opus.esm.agt.agtmaster.agtsecurity.event.EsmAgt0038Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AgtBrogCustIntVO;
import com.clt.syscommon.common.table.AgtBrogCustMtchVO;
import com.clt.syscommon.common.table.AgtChnLaneAgnVO;
import com.clt.syscommon.common.table.AgtChnVslAgnVO;
import com.clt.syscommon.common.table.AgtFacCustRltVO;
import com.clt.syscommon.common.table.AgtFincOfcInfoVO;
import com.clt.syscommon.common.table.BkgChnAgnVO;


/**
 * OPUS-AGTMaster Business Logic ServiceCommand - OPUS-AGTMaster handling business transaction 
 * 
 * @author 
 * @see AGTOfficeInfoDBDAO
 * @since J2EE 1.6
 */

public class AGTMasterSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * AGTMaster system preceding process for biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("AGTMasterSC 시작");
		try {
			// checking Login user ID
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * AGTMaster system biz scenario closing<br>
	 * biz scenario closing<br>
	 */
	public void doEnd() {
		log.debug("AGTMasterSC 종료");
	}

	/**
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

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
		return eventResponse;
	}
	
	/**
	 * ESM_AGT_022 : retrieve event process<br>
	 * retrieve event process<br>
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
	 * managing China Booking Agent information<br>
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
	 * (ESM_AGT_0023) retrieving China Inbound Agent information<br>
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
	 * ESM_AGT_0023 multi event process<br>
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
	 * (ESM_AGT_0024) retrieving Inbound China Agent Office Info for Vessel<br>
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
	 * (ESM_AGT_0024) multi event process about Inbound China Agent Office Info for Vessel <br>
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
	 * ESM_AGT_0025 retrieve event process<br>
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
	 * ESM_AGT_0025 multi event process<br>
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
	 * ESM_AGT_026 retrieve event process<br>
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
	 * ESM_AGT_026 multi event process<br>
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
	 * ESM_AGT_0038 : retrieving Security & AR Office <br>
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
	 * ESM_AGT_0038 : Security & AR Office multi event process<br>
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
	
}