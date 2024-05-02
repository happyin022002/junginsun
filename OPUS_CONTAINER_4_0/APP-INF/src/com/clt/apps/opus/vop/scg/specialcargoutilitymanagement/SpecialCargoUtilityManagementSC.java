/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialCargoUtilityManagementSC.java
*@FileTitle : SpecialCargoUtilityManagement
*Open Issues :
*Change history : 2015.05.14
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement;

import java.util.List;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.basic.EdiTransmitHistoryBC;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.basic.EdiTransmitHistoryBCImpl;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.event.VopScg5011Event;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.event.VopScg5911Event;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.event.VopScg5912Event;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.event.VopScg5991Event;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.vo.EdiTransmitHistoryHdrVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.vo.ImdgItemBkgSummaryVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.basic.PortLimitManagementBC;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.basic.PortLimitManagementBCImpl;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.event.VopScg5021Event;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.event.VopScg5022Event;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.event.VopScg5921Event;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.event.VopScg5922Event;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.event.VopScg5923Event;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsBkgVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsDataVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsDgTotalWeightVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsUnNoVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLmtSubsRskVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.basic.ReceiveEdiFromPartnerLinesMgtBC;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.basic.ReceiveEdiFromPartnerLinesMgtBCImpl;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.event.DgCgoAproRqstEvent;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.FlatFilePartnerLineVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-SpecialCargoUtilityManagement
 * 
 * @author
 * @see 
 * @since J2EE 1.6
 */
public class SpecialCargoUtilityManagementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * creating Object when calling business scenario
	 */
	public void doStart() {
		log.debug("SpecialCargoUtilityManagementSC start");
		try {
			// checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * closing business scenario for SpecialCargoUtilityManagementSC system
	 */
	public void doEnd() {
		log.debug("SpecialCargoUtilityManagementSC end");
	}

	/**
	 * handling all cases for OPUS-EquipmentMovementMgt system 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;		
		
		if (e.getEventName().equalsIgnoreCase("DgCgoAproRqstEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageDGEDIfromPartnerLines(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageAckDGEDIfromPartnerLines(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopScg5011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEdiTransmitHistoryHdr(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("VopScg5911Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEdiTransmitHistoryDtl(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("VopScg5912Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchImdgItemBkgSummary(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("VopScg5913Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEdiTransmitHistoryDtl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopScg5021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPortLimitsData(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = managePortLimitsData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopScg5022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPortLimitsDgTotalWeightCheck(e);
				
			}
		} else if (e.getEventName().equalsIgnoreCase("VopScg5921Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPortLimitsClass(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchPortLimitsUnNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = managePortLimitsClss(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopScg5922Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPortLimitsBkg(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopScg5923Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPortLimitsSubRsk(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = managePortLimitsSubRsk(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("VopScg5991Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEdiTransmitFlatFile(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * MQ Inbound : MQProxy
	 * handling multiple event 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDGEDIfromPartnerLines(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		DgCgoAproRqstEvent dgCgoAproRqstEvent = null;
		
		ReceiveEdiFromPartnerLinesMgtBC command = new ReceiveEdiFromPartnerLinesMgtBCImpl();
		List<FlatFilePartnerLineVO> flatFileVOs = null;
		
		if (e.getEventName().equals("DgCgoAproRqstEvent")) {
			dgCgoAproRqstEvent = (DgCgoAproRqstEvent)e;
			flatFileVOs        = command.manageDGEDIfromPartnerLines(dgCgoAproRqstEvent.getFlatFileText());
		}

		eventResponse.setETCData("success", "success");
		return eventResponse;
	}
	
	/**
	 * MQ Inbound : MQProxy
	 * handling multiple event 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAckDGEDIfromPartnerLines(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		DgCgoAproRqstEvent dgCgoAproRqstEvent = null;
		
		ReceiveEdiFromPartnerLinesMgtBC command = new ReceiveEdiFromPartnerLinesMgtBCImpl();
		
		if (e.getEventName().equals("DgCgoAproRqstEvent")) {
			dgCgoAproRqstEvent = (DgCgoAproRqstEvent)e;
			command.manageAckDGEDIfromPartnerLines(dgCgoAproRqstEvent.getFlatFileText());
		}

		eventResponse.setETCData("success", "success");
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_5011 : Retrieve
	 * 
	 * Retrieving Retrieving DG EDI Booking History
	 * 
	 * @param Event e
	 * @return EventResponse 
	 * @exception EventException
	 */
	private EventResponse searchEdiTransmitHistoryHdr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EdiTransmitHistoryHdrVO vo = null;
		
		if(e instanceof VopScg5011Event){
			VopScg5011Event event = (VopScg5011Event)e;
			vo = event.getEdiTransmitHistoryHdrVO();
			
			EdiTransmitHistoryBC command = new EdiTransmitHistoryBCImpl();
			List<EdiTransmitHistoryHdrVO> list = command.searchEdiTransmitHistoryHdr(vo);
			eventResponse.setRsVoList(list);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_SCG_5012 : Retrieve
	 * 
	 * Retrieving DG EDI Booking History DTL
	 * 
	 * @param Event e
	 * @return EventResponse 
	 * @exception EventException
	 */
	private EventResponse searchEdiTransmitHistoryDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EdiTransmitHistoryHdrVO vo = null;
		
		if(e instanceof VopScg5911Event){
			VopScg5911Event event = (VopScg5911Event)e;
			vo = event.getEdiTransmitHistoryHdrVO();
			
			EdiTransmitHistoryBC command = new EdiTransmitHistoryBCImpl();
			List<EdiTransmitHistoryHdrVO> list = command.searchEdiTransmitHistoryDtl(vo);
			eventResponse.setRsVoList(list);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_SCG_5012 : Retrieve
	 * 
	 * Retrieving DG EDI Booking History DTL
	 * 
	 * @param Event e
	 * @return EventResponse 
	 * @exception EventException
	 */
	private EventResponse searchImdgItemBkgSummary(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		ImdgItemBkgSummaryVO vo = null;
		
		if(e instanceof VopScg5912Event){
			VopScg5912Event event = (VopScg5912Event)e;
			vo = event.getImdgItemBkgSummaryVO();
			
			EdiTransmitHistoryBC command = new EdiTransmitHistoryBCImpl();
			List<ImdgItemBkgSummaryVO> list = command.searchImdgItemBkgSummary(vo);
			eventResponse.setRsVoList(list);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_5021 : Retrieve <br>
	 * Retrieve Port Limit Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortLimitsData(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		VopScg5021Event event = (VopScg5021Event)e;
		PortLimitManagementBC command = new PortLimitManagementBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{		
			List<PortLimitsDataVO> list = command.searchPortLimitsData(event.getPortLimitsDataVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_5021 : Manage <br>
	 * Manage Port Limit Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortLimitsData(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			PortLimitManagementBC command = new PortLimitManagementBCImpl();
			
			VopScg5021Event event = (VopScg5021Event) e;
			PortLimitsDataVO[] portLimitsDataVOs = event.getPortLimitsDataVOs();
			for (PortLimitsDataVO portLimitsDataVO : portLimitsDataVOs) {
				portLimitsDataVO.setCreUsrId(account.getUsr_id());
				portLimitsDataVO.setUpdUsrId(account.getUsr_id());
				portLimitsDataVO.setCreOfcCd(account.getOfc_cd() );
				portLimitsDataVO.setUpdOfcCd(account.getOfc_cd());
			}
			begin();
			command.managePortLimitsData(portLimitsDataVOs, "");
			commit();
			return eventResponse;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("").getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_5921 : Manage <br>
	 * Manage Port Limit Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortLimitsClss(Event e) throws EventException {
		String portLmtSeqStr = "";
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			PortLimitManagementBC command = new PortLimitManagementBCImpl();
			
			VopScg5921Event event = (VopScg5921Event) e;
			PortLimitsDataVO vo = event.getPortLimitsDataVO();
			
			//Master
			PortLimitsDataVO[] portLimitsDataVOMsts = event.getPortLimitsDataVOMsts();
			for (PortLimitsDataVO portLimitsDataVO : portLimitsDataVOMsts) {
				portLimitsDataVO.setPortCd(vo.getPortCd());
				portLimitsDataVO.setLmtWgtTpCd(vo.getLmtWgtTpCd());
				portLimitsDataVO.setPortLmtSeq(vo.getPortLmtSeq());
				
				portLimitsDataVO.setCreUsrId(account.getUsr_id());
				portLimitsDataVO.setUpdUsrId(account.getUsr_id());
				portLimitsDataVO.setCreOfcCd(account.getOfc_cd() );
				portLimitsDataVO.setUpdOfcCd(account.getOfc_cd());
			}
			
			//Detail - Class
			PortLimitsDataVO[] portLimitsDataVOs = event.getPortLimitsDataVOs();
			if(portLimitsDataVOs != null && portLimitsDataVOs.length > 0){
				for (PortLimitsDataVO portLimitsDataVO : portLimitsDataVOs) {
					portLimitsDataVO.setPortCd(vo.getPortCd());
					//portLimitsDataVO.setLmtWgtTpCd(vo.getLmtWgtTpCd());
					portLimitsDataVO.setPortLmtSeq(vo.getPortLmtSeq());
					
					portLimitsDataVO.setCreUsrId(account.getUsr_id());
					portLimitsDataVO.setUpdUsrId(account.getUsr_id());
					portLimitsDataVO.setCreOfcCd(account.getOfc_cd() );
					portLimitsDataVO.setUpdOfcCd(account.getOfc_cd());
				}
			}
			//Detail - UnNo
			PortLimitsUnNoVO[] portLimitsUnNoVOs = event.getPortLimitsUnNoVOs();
			if(portLimitsUnNoVOs != null && portLimitsUnNoVOs.length > 0){
				for (PortLimitsUnNoVO portLimitsUnNoVO : portLimitsUnNoVOs) {
					portLimitsUnNoVO.setPortCd(vo.getPortCd());
					//portLimitsUnNoVO.setLmtWgtTpCd(vo.getLmtWgtTpCd());
					portLimitsUnNoVO.setPortLmtSeq(vo.getPortLmtSeq());
					
					portLimitsUnNoVO.setCreUsrId(account.getUsr_id());
					portLimitsUnNoVO.setUpdUsrId(account.getUsr_id());
					portLimitsUnNoVO.setCreOfcCd(account.getOfc_cd() );
					portLimitsUnNoVO.setUpdOfcCd(account.getOfc_cd());
				}
			}
			
			begin();
			
			//PortLmtSeq 구해오기 -> 1.Master가 Insert라면 셋팅하기 / 2. 
			String portLmtSeqParam = portLimitsDataVOMsts[0].getPortLmtSeq();
			if("".equals(portLmtSeqParam) || portLmtSeqParam == null || Integer.parseInt(portLmtSeqParam) == 0){
				portLmtSeqStr = command.srchPortLmtSeq(portLimitsDataVOMsts[0]);
				
				//Master
				for (PortLimitsDataVO portLimitsDataVO : portLimitsDataVOMsts) {
					portLimitsDataVO.setPortLmtSeq(portLmtSeqStr);
				}
				
				//Detail - Class
				if(portLimitsDataVOs != null && portLimitsDataVOs.length > 0){
					for (PortLimitsDataVO portLimitsDataVO : portLimitsDataVOs) {
						portLimitsDataVO.setPortLmtSeq(portLmtSeqStr);
					}
				}
				//Detail - UnNo
				if(portLimitsUnNoVOs != null && portLimitsUnNoVOs.length > 0){
					for (PortLimitsUnNoVO portLimitsUnNoVO : portLimitsUnNoVOs) {
						portLimitsUnNoVO.setPortLmtSeq(portLmtSeqStr);
					}
				}
			}
			
			//Master Save
			command.managePortLimitsData(portLimitsDataVOMsts, "pop");
			//Detail Save
			//[CWE-476] Null Dereferencing
			if(portLimitsDataVOs != null && portLimitsDataVOs.length > 0 && portLimitsUnNoVOs != null && portLimitsUnNoVOs.length > 0){
				command.managePortLimitsClass(portLimitsDataVOs, portLimitsUnNoVOs);	
			}else if(portLimitsDataVOs != null && portLimitsDataVOs.length > 0 && portLimitsUnNoVOs == null ){
				command.managePortLimitsClass(portLimitsDataVOs, null);	
			}else if(portLimitsDataVOs == null && portLimitsUnNoVOs != null && portLimitsUnNoVOs.length > 0){
				command.managePortLimitsClass(null, portLimitsUnNoVOs);
			}
			commit();
			
			eventResponse.setETCData("portLmtSeq", portLmtSeqStr);
			
			return eventResponse;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("").getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_5921 : Class Retrieve <br>
	 * Retrieve Port Limit Class Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortLimitsClass(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		VopScg5921Event event = (VopScg5921Event)e;
		PortLimitManagementBC command = new PortLimitManagementBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<PortLimitsDataVO> list = command.searchPortLimitsClass(event.getPortLimitsDataVO());
			eventResponse.setRsVoList(list); 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_5922 : BKG Popup Retrieve <br>
	 * Retrieve Port Limit Class Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortLimitsBkg(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		VopScg5922Event event = (VopScg5922Event)e;
		PortLimitManagementBC command = new PortLimitManagementBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<PortLimitsBkgVO> list = command.searchPortLimitsBkg(event.getPortLimitsBkgVO());
			eventResponse.setRsVoList(list); 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_5921 : UN No Retrieve <br>
	 * Retrieve Port Limit UN No Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortLimitsUnNo(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		VopScg5921Event event = (VopScg5921Event)e;
		PortLimitManagementBC command = new PortLimitManagementBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{		
			List<PortLimitsDataVO> list = command.searchPortLimitsUnNo(event.getPortLimitsDataVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_5022 : Retrieve <br>
	 * Retrieve Port Limits DG Total Weight<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortLimitsDgTotalWeightCheck(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		VopScg5022Event event = (VopScg5022Event)e;
		PortLimitManagementBC command = new PortLimitManagementBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{		
			List<PortLimitsDgTotalWeightVO> list = command.searchPortLimitsDgTotalWeightCheck(event.getPortLimitsDgTotalWeightVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_5923 : SubRsk Retrieve <br>
	 * Retrieve Port Limit SubRsk Info<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortLimitsSubRsk(Event e) throws EventException
	{
		// PDTO(Data Transfer Object including Parameters)
		VopScg5923Event event = (VopScg5923Event)e;
		PortLimitManagementBC command = new PortLimitManagementBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<PortLmtSubsRskVO> list = command.searchPortLimitsSubRsk(event.getPortLmtSubsRskVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_SCG_5923 : Manage <br>
	 * Manage Port Limit Info <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortLimitsSubRsk(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			PortLimitManagementBC command = new PortLimitManagementBCImpl();

			VopScg5923Event event = (VopScg5923Event) e;
			PortLmtSubsRskVO vo = event.getPortLmtSubsRskVO();

			//Detail - SubRsk
			PortLmtSubsRskVO[] portLmtSubsRskVOs = event.getPortLmtSubsRskVOs();
			if(portLmtSubsRskVOs != null && portLmtSubsRskVOs.length > 0){
				for (PortLmtSubsRskVO portLmtSubsRskVO : portLmtSubsRskVOs) {
					portLmtSubsRskVO.setPortCd(vo.getPortCd());
					portLmtSubsRskVO.setPortLmtSeq(vo.getPortLmtSeq());
					//portLmtSubsRskVO.setImdgSubsRskLblCd(vo.getLmtWgtTpCd());

					portLmtSubsRskVO.setCreUsrId(account.getUsr_id());
					portLmtSubsRskVO.setUpdUsrId(account.getUsr_id());
				}
				
				begin();
				
				//Detail Save 
				command.managePortLimitsSubRsk(portLmtSubsRskVOs);
				commit();
			}

			eventResponse.setETCData("portLmtSeq", vo.getPortLmtSeq());

			return eventResponse;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("").getMessage(), ex);
		}
	}
	/**
	 * VOP_SCG_5991 : Retrieve
	 * 
	 * Retrieving DG EDI Booking Flat File
	 * 
	 * @param Event e
	 * @return EventResponse 
	 * @exception EventException
	 */
	private EventResponse searchEdiTransmitFlatFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EdiTransmitHistoryHdrVO vo = null;
		
		if(e instanceof VopScg5991Event){
			VopScg5991Event event = (VopScg5991Event)e;
			vo = event.getEdiTransmitHistoryHdrVO();
			
			EdiTransmitHistoryBC command = new EdiTransmitHistoryBCImpl();
			List<EdiTransmitHistoryHdrVO> list = command.searchEdiTransmitFlatFile(vo);
			eventResponse.setRsVoList(list);
		}

		return eventResponse;
	}
}