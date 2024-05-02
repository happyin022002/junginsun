/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SpacecontrolinquirySC.java
*@FileTitle      : Spacecontrolinquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 

=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.spc.common.common.basic.CommonBC;
import com.clt.apps.opus.esm.spc.common.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.basic.SpacecontrolinquiryBC;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.basic.SpacecontrolinquiryBCImpl;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0021Event;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0022Event;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0024Event;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0026Event;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0028Event;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0056Event;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0080Event;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0081Event;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0082Event;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0083Event;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration.SpacecontrolinquiryDBDAO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchWeeklyLfByPolPodListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Spacecontrolinquiry Business Logic ServiceCommand - handling business transaction for Spacecontrolinquiry 
 * 
 * @author 
 * @see SpacecontrolinquiryDBDAO
 * @since J2EE 1.6
 */

public class SpacecontrolinquirySC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;


	/**
	 * Spacecontrolinquiry system preceding process for biz scenario<br>
	 * Creating related object by calling work scenario<br>
	 */	
	public void doStart() {
		log.debug("SpacecontrolinquirySC Start");
		try {
			
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Handling for the end of Spacecontrolinquiry system working scenario<br>
	 * Romoving object by the end of work scenario<br>
	 */	
	public void doEnd() {
		log.debug("SpacecontrolinquirySC End");
	}

	/**
	 *  Handling working scenario of each event<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// the part being used in case of handling a few events in SC
		if (e.getEventName().equalsIgnoreCase("EsmSpc0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceControlInquiry021FcastPortViewList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchSpaceControlInquiry021AllocPortViewList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchSpaceControlInquiry021AllocPortViewList2(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceControlInquiryTradeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceControlInquirySalesOrgList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchSpaceControlInquiryPolPodList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchSpaceControlInquiryCustomerList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchSpaceControlInquiryContractor(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceControlInquiryNoShowSummaryList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceControlInquiryNoShowTradeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchSpaceControlInquiryNoShowOfficeLaneList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchSpaceControlInquiryNoShowLaneOfficeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchSpaceControlInquiryNoShowSubOfficeList(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceControlInquiryOfficeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceControlInquiryOfficeSalesOrgList(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSpaceControlTsVolumnList(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0026Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceControlInquiryList(e);
			}
			
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0080Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceControlRDRSummaryList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceControlRDRSummaryDown(e);
			}else{
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}	
			
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0081Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSpaceControlInquiryRDRDetailList(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0082Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceControlLFSummaryList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceControlLFSummaryDown(e);
			}else{
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}	
			
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0083Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchWeeklyLfByPolPodList(e);
			} else if  (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMonthWeekList(e);
			}
		}
		return eventResponse;
	}
	
	
	/**
	 * EsmSpc0021Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse searchSpaceControlInquiry021FcastPortViewList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0021Event event = (EsmSpc0021Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiry021FcastPortViewList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST01");
			}
			eventResponse.setRsVoList(rsVoList);
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
	 * EsmSpc0021Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */			
	private EventResponse searchSpaceControlInquiry021AllocPortViewList2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0021Event event = (EsmSpc0021Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();

		try{			
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiry021AllocPortViewList2(event.getSearchSpaceControlInquiryConditionVO(), account);
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST05");
			}
			eventResponse.setRsVoList(rsVoList);
			
			
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
	 * EsmSpc0021Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceControlInquiry021AllocPortViewList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0021Event event = (EsmSpc0021Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiry021AllocPortViewList(event.getSearchSpaceControlInquiryConditionVO(), account);
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST03");
			}
			eventResponse.setRsVoList(rsVoList);
			
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
	 * EsmSpc0022Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceControlInquiryTradeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0022Event event = (EsmSpc0022Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryTradeList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST01");
			}
			eventResponse.setRsVoList(rsVoList);
			
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
	 * EsmSpc0022Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceControlInquirySalesOrgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0022Event event = (EsmSpc0022Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquirySalesOrgList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST02");
			}
			eventResponse.setRsVoList(rsVoList);
			
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
	 * EsmSpc0022Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceControlInquiryPolPodList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0022Event event = (EsmSpc0022Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryPolPodList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST03");
			}
			eventResponse.setRsVoList(rsVoList);
			
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
	 * EsmSpc0022Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceControlInquiryCustomerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0022Event event = (EsmSpc0022Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryCustomerList(event.getSearchSpaceControlInquiryConditionVO(), account);
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST04");
			}
			eventResponse.setRsVoList(rsVoList);
			
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
	 * EsmSpc0022Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceControlInquiryContractor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0022Event event = (EsmSpc0022Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryContractor(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST05");
			}
			eventResponse.setRsVoList(rsVoList);
			
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
	 * EsmSpc0024Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceControlInquiryNoShowSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0024Event event = (EsmSpc0024Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryNoShowSummaryList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST01");
			}
			
			eventResponse.setRsVoList(rsVoList);
			
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
	 * EsmSpc0024Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceControlInquiryNoShowTradeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0024Event event = (EsmSpc0024Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryNoShowTradeList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST02");
			}
			eventResponse.setRsVoList(rsVoList);
			
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
	 * EsmSpc0024Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceControlInquiryNoShowOfficeLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0024Event event = (EsmSpc0024Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryNoShowOfficeLaneList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST03");
			}
			eventResponse.setRsVoList(rsVoList);
			
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
	 * EsmSpc0024Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceControlInquiryNoShowLaneOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0024Event event = (EsmSpc0024Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryNoShowLaneOfficeList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST04");
			}
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * EsmSpc0024Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceControlInquiryNoShowSubOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0024Event event = (EsmSpc0024Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryNoShowSubOfficeList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST05");
			}
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * EsmSpc0028Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceControlInquiryOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0028Event event = (EsmSpc0028Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryOfficeList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST01");
			}
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * EsmSpc0028Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceControlInquiryOfficeSalesOrgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0028Event event = (EsmSpc0028Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryOfficeSalesOrgList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST02");
			}
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * EsmSpc0026Event retrieve event process<br>
	 * space control info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceControlInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0026Event event = (EsmSpc0026Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{

			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryList(event.getConditionVO());
	
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST02");
			}
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("sataus", "OK");
		
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	
	/**
	 * ESM_SPC_0080 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * 2010.08.25 CHOI.Y.S - Ticket ID : CHM-201005492 - RDR 실적 Summary 기능 개발 - 메소드 추가
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlRDRSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0080Event event = (EsmSpc0080Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try{

			List<ComplexMainVO> rsVoList = command.searchSpaceControlRDRSummaryList(event.getConditionVO());
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("sataus", "OK");
		
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0080 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * 2010.08.25 CHOI.Y.S - Ticket ID : CHM-201005492 - RDR 실적 Summary 기능 개발 - 메소드 추가
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlRDRSummaryDown(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0080Event event = (EsmSpc0080Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try{

			List<ComplexMainVO> rsVoList = command.searchSpaceControlRDRSummaryDown(event.getConditionVO());
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("sataus", "OK");
		
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0081 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiryRDRDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0081Event event = (EsmSpc0081Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{

			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryRDRDetailList(event.getConditionVO());
	
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST");
			}
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("sataus", "OK");
		
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	private EventResponse searchSpaceControlLFSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0082Event event = (EsmSpc0082Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try{

			List<ComplexMainVO> rsVoList = command.searchSpaceControlLFSummaryList(event.getConditionVO());
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("sataus", "OK");
		
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	private EventResponse searchSpaceControlLFSummaryDown(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0082Event event = (EsmSpc0082Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try{

			List<ComplexMainVO> rsVoList = command.searchSpaceControlLFSummaryDown(event.getConditionVO());
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("sataus", "OK");
		
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	private EventResponse searchWeeklyLfByPolPodList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0083Event event = (EsmSpc0083Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{

			List<ComplexMainVO> rsVoList = command.searchWeeklyLfByPolPodList(event.getConditionVO());
	
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST");
			}
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("sataus", "OK");
		
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	private EventResponse searchMonthWeekList(Event e) throws EventException {
		EsmSpc0083Event event = (EsmSpc0083Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();

		List<SearchWeeklyLfByPolPodListVO> searchWeeklyLfByPolPodListVOS = command.searchMonthWeekList(event.getConditionVO() );
		String totBaseDt = "";
		if(searchWeeklyLfByPolPodListVOS.size() > 0) {
			for ( int i=0; i<searchWeeklyLfByPolPodListVOS.size(); i++) {	//헤더 주차를 만든다.
				if ( i == searchWeeklyLfByPolPodListVOS.size()-1) {
					totBaseDt = totBaseDt+searchWeeklyLfByPolPodListVOS.get(i).getCostYrwk().substring(0, 4)+searchWeeklyLfByPolPodListVOS.get(i).getCostYrwk().substring(4, 6);
				} else {
					totBaseDt = totBaseDt+searchWeeklyLfByPolPodListVOS.get(i).getCostYrwk().substring(0, 4)+searchWeeklyLfByPolPodListVOS.get(i).getCostYrwk().substring(4, 6)+"|";
				}
			}
		}
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("bse_dt",totBaseDt);
		
		eventResponse.setETCData(etcData);
		return eventResponse;
		
	}
	
	/**
	 * ESM_SPC_0056 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlTsVolumnList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0056Event event = (EsmSpc0056Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlTsVolumnList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST");
			}
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	
	private EventResponse searchSpaceAllocationOfficeCond(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();
		
		try{
			List<SearchOfficeCondVO> list = command.searchOfficeCond(e, account);
			if(list.size() > 0){
				SearchOfficeCondVO searchOfficeCondVO = list.get(0);
				eventResponse.setETCData(searchOfficeCondVO.getColumnValues());
			}
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
}