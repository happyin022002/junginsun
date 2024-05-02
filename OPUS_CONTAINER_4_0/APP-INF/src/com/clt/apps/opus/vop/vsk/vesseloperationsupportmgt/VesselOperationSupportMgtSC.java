/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselOperationSupportMgtSC.java
*@FileTitle : Port Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.basic.LaneInformationMgtBC;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.basic.LaneInformationMgtBCImpl;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.event.VopVsk0510Event;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.event.VopVsk0512Event;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.event.VopVsk0702Event;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.LaneInfoConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusDeployedVesselVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusServiceVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusVesselVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.VskPortBnkRfuelRtoSheetVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.basic.PortInformationMgtBC;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.basic.PortInformationMgtBCImpl;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.event.VopVsk0504Event;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.event.VopVsk0704Event;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration.PortInformationMgtDBDAO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmRhqComboVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmYardComboVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationMgtVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlPassCondVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlTrScgListVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDistVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDocBufTmVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortNworkVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortTrspCondVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.basic.SHATideInformationMgtBC;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.basic.SHATideInformationMgtBCImpl;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.event.VopVsk0513Event;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.VskPortTideVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.basic.TerminalInformationMgtBC;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.basic.TerminalInformationMgtBCImpl;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.event.VopVsk0507Event;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortBrthWdoVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortGntrCrnVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.basic.VesselInformationMgtBC;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.basic.VesselInformationMgtBCImpl;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.event.VopVsk0503Event;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.event.VopVsk0518Event;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DockPlanListVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPartIVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DraftWeightListVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.basic.VesselOperationSupportMonitoringBC;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.basic.VesselOperationSupportMonitoringBCImpl;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.event.VopVsk0517Event;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo.VosiUpdateMonitoringVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.basic.InterfaceScheduleToIBISBC;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.basic.InterfaceScheduleToIBISBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPortNworkIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskLanePicVO;
import com.clt.syscommon.common.table.VskPortCnlTrScgVO;
import com.clt.syscommon.common.table.VskPortFltgCrnVO;
import com.clt.syscommon.common.table.VskPortGngStrcVO;

/**
 * VesselOperationSupportMgt Business Logic ServiceCommand 
 * - Handling Business Transaction about VesselOperationSupportMgt
 * 
 * @author
 * @see PortInformationMgtDBDAO
 * @since J2EE 1.6
 */

public class VesselOperationSupportMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * VesselOperationSupportMgt system preceding process for biz scenario<br>
	 * VOP_VSK_0504 related objects creation<br>
	 */
	public void doStart() {
		log.debug("VesselOperationSupportMgtSC START");
		try {  
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * VesselOperationSupportMgt system biz scenario closing<br>
	 * VOP_VSK_0504 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("VesselOperationSupportMgtSC END");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("VopVsk0504Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManueveringList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse= searchNonWorkingList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse= searchDistanceList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse= searchDocHourList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse= searchCanelList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse= searchTruckingList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse= searchRailLoadList(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {//COMMAND01-> SEARCH07
				eventResponse= searchMdmYardCdList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {//COMMAND02-> SEARCH08
				eventResponse= searchMdmRhqCdList(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {//COMMAND03-> SEARCH09
				eventResponse= searchMdmRhqLocList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {//COMMAND04-> SEARCH10
				eventResponse= searchMdmLocCdList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {//COMMAND05-> SEARCH11
				eventResponse= searchMdmTrspLocList(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {//COMMAND06-> SEARCH12
				eventResponse= searchMdmRhqDocLocList(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePortInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageNonWorking(e);	
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = managePortDistance(e);	
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = managePortDocHour(e);	
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = managePortCanel(e);	
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = managePortTrucking(e);	
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = managePortRailLoad(e);	
			}			
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {//COMMAND01-> SEARCH05
				eventResponse = searchMaxFCraneSeqList(e);
			}
            // By Hwang
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchMaxGngSeqList(e); 
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {//COMMAND02-> SEARCH06
				eventResponse = searchPortInfoList(e); 
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {//COMMAND11-> SEARCH07
				eventResponse = searchTermialComboList(e); 
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGCraneList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFCraneList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGangStructureList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchBerthWindowList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTerminalInfo(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0510Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLaneGroupList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPicList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchBunkeringPortList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//COMMAND01-> SEARCH04
				eventResponse = searchPicRsoList(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageLaneInfo(e);
			}else{
				eventResponse = searchBunkeringPortHeader(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0702Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneGroupPopUp(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLaneGroupPopUpTP(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyLaneGroup(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0503Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVSLPartI(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = searchDockPlanList(e);
			}			
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0512Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchLaneStatusList(e);
			}else{
				eventResponse = searchBunkeringPortHeader(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0513Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTideInfoList(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageTideInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//COMMAND01-> SEARCH01
				eventResponse= searchPortCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0517Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVOSIUpdateList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//COMMAND01-> SEARCH01
				eventResponse= searchMdmRhqCombo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0518Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDraftWeightList(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageDraftWeightList(e);
			}	
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0704Event")) {
				if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageTierSurcharge(e);
				}
		}
		return eventResponse;
	}
	
	
	/**
	 * VOP_VSK_0504 : Retrieve <br>
	 * Retrieving Maneuvering<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManueveringList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();

		try{
			List<PortInformationMgtVO> list = command.searchManueveringList(event.getPortInformationConditionVO());
			List<MdmYardComboVO> list2 = command.searchMdmYardCombo(event.getPortInformationConditionVO());
			
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);			

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}		
		return eventResponse;
	} 

	/**
	 * VOP_VSK_0504 : Retrieve <br>
	 * Retrieving Terminal Non-Working<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNonWorkingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();

		try{
			List<VskPortNworkVO> list = command.searchNonWorkingList(event.getPortInformationConditionVO());
			List<MdmYardComboVO> list2 = command.searchMdmRhqLocCombo(event.getPortInformationConditionVO());
			
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);			

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}		
		return eventResponse;
	} 	
	
	/**
	 * VOP_VSK_0504 : Retrieve <br>
	 * Retrieving Distance<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDistanceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();

		try{
			List<VskPortDistVO> list = command.searchDistanceList(event.getPortInformationConditionVO());
			List<MdmYardComboVO> list2 = command.searchMdmLocCdCombo(event.getPortInformationConditionVO());
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_VSK_0504 : Retrieve <br>
	 * Retrieving Doc.&Dead Hrs<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDocHourList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();

		try{
			List<VskPortDocBufTmVO> list = command.searchDocHourList(event.getPortInformationConditionVO());
			List<MdmYardComboVO> list2   = command.searchMdmRhqDocLocCombo(event.getPortInformationConditionVO());
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0504 : Retrieve <br>
	 * Retrieving Canal<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCanelList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();

		try{
			List<VskPortCnlPassCondVO> list = command.searchCanelList(event.getPortInformationConditionVO());
			List<VskPortCnlTrScgListVO> list2 = command.searchPortCnlTrScgList(event.getPortInformationConditionVO());
			List<VskPortCnlTrScgVO> list3 = command.searchPortCnlTrScg(event.getPortInformationConditionVO());
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
			eventResponse.setRsVoList(list3);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_VSK_0504 : Retrieve <br>
	 * Retrieving Trucking<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTruckingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();

		try{

			List<VskPortTrspCondVO> list = command.searchTruckingList(event.getPortInformationConditionVO());
			List<MdmYardComboVO> list2 = command.searchMdmTrspLocCombo(event.getPortInformationConditionVO());
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_VSK_0504 : Retrieve <br>
	 * Retrieving Railroad<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailLoadList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();

		try{
			List<VskPortTrspCondVO> list = command.searchRailLoadList(event.getPortInformationConditionVO());
			List<MdmYardComboVO> list2 = command.searchMdmTrspLocCombo(event.getPortInformationConditionVO());
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_VSK_0504 : Retrieve <br>
	 * Retrieving TMNL Code for Maneuvering
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmYardCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();

		try{
			List<MdmYardComboVO> list = command.searchMdmYardCombo(event.getPortInformationConditionVO());
			
			StringBuffer strVal = new StringBuffer();
			StringBuffer strName = new StringBuffer();

			for(int i=0;i<list.size();i++){
				if(i == 0 )
				{
					strVal.append(((MdmYardComboVO)list.get(i)).getVal());
					strName.append(((MdmYardComboVO)list.get(i)).getName());
				}
				else
				{
					strVal.append("|" + ((MdmYardComboVO)list.get(i)).getVal());
					strName.append("|" + ((MdmYardComboVO)list.get(i)).getName());
				}
			}
	 
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("cmbVal", strVal.toString() );
			etcData.put("cmbName", strName.toString() );
			eventResponse.setETCData(etcData);

			if(list.size() <= 0) {
				eventResponse.setUserMessage(new ErrorHandler("COM10001").getUserMessage());
	        }
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
		}		
		return eventResponse;
		
	} 

	/**
	 * VOP_VSK_0504 : Retrieve <br>
	 * Retrieving RHQ of Port Code
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmRhqLocList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();

		try{
			List<MdmYardComboVO> list = command.searchMdmRhqLocCombo(event.getPortInformationConditionVO());
			
			StringBuffer strVal = new StringBuffer();
			StringBuffer strName = new StringBuffer();

			for(int i=0;i<list.size();i++){
				if(i == 0 )
				{
					strVal.append(((MdmYardComboVO)list.get(i)).getVal());
					strName.append(((MdmYardComboVO)list.get(i)).getName());
				}
				else
				{
					strVal.append("|" + ((MdmYardComboVO)list.get(i)).getVal());
					strName.append("|" + ((MdmYardComboVO)list.get(i)).getName());
				}
			}
	 
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("cmbVal", strVal.toString() );
			etcData.put("cmbName", strName.toString() );
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
		}		
		return eventResponse;
	} 

	/**
	 * VOP_VSK_0504 : Retrieve <br>
	 * Retrieving Port for Doc.&Dead Hrs
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmRhqDocLocList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();

		try{
			List<MdmYardComboVO> list = command.searchMdmRhqDocLocCombo(event.getPortInformationConditionVO());
			
			StringBuffer strVal = new StringBuffer();
			StringBuffer strName = new StringBuffer();

			for(int i=0;i<list.size();i++){
				if(i == 0 )
				{
					strVal.append(((MdmYardComboVO)list.get(i)).getVal());
					strName.append(((MdmYardComboVO)list.get(i)).getName());
				}
				else
				{
					strVal.append("|" + ((MdmYardComboVO)list.get(i)).getVal());
					strName.append("|" + ((MdmYardComboVO)list.get(i)).getName());
				}
			}
	 
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("cmbVal", strVal.toString() );
			etcData.put("cmbName", strName.toString() );
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}		
		return eventResponse;
	} 
	
	/**
	 * VOP_VSK_0504 : Retrieve <br>
	 * Retrieving Port Code
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmTrspLocList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();

		try{
			List<MdmYardComboVO> list = command.searchMdmTrspLocCombo(event.getPortInformationConditionVO());
			
			StringBuffer strVal = new StringBuffer();
			StringBuffer strName = new StringBuffer();

			for(int i=0;i<list.size();i++){
				if(i == 0 )
				{
					strVal.append(((MdmYardComboVO)list.get(i)).getVal());
					strName.append(((MdmYardComboVO)list.get(i)).getName());
				}
				else
				{
					strVal.append("|" + ((MdmYardComboVO)list.get(i)).getVal());
					strName.append("|" + ((MdmYardComboVO)list.get(i)).getName());
				}
			}
	 
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("cmbVal", strVal.toString() );
			etcData.put("cmbName", strName.toString() );
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_VSK_0504 : Retrieve <br>
	 * Retrieving Port<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmLocCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();
		try{
			List<MdmYardComboVO> list = command.searchMdmLocCdCombo(event.getPortInformationConditionVO());
			
			StringBuffer strVal = new StringBuffer();
			StringBuffer strName = new StringBuffer();
			StringBuffer strDf = new StringBuffer();

			for(int i=0;i<list.size();i++){
				if(i == 0 )
				{
					strVal.append(((MdmYardComboVO)list.get(i)).getVal());
					strName.append(((MdmYardComboVO)list.get(i)).getName());
					strDf.append(((MdmYardComboVO)list.get(i)).getDf());
				}
				else
				{
					strVal.append("|" + ((MdmYardComboVO)list.get(i)).getVal());
					strName.append("|" + ((MdmYardComboVO)list.get(i)).getName());
					strDf.append("|" + ((MdmYardComboVO)list.get(i)).getDf());
				}
			}
	 
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("cmbVal", strVal.toString() );
			etcData.put("cmbName", strName.toString() );
			etcData.put("cmbDf", strDf.toString() );
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
		}		
		return eventResponse;
		
	}	
	/**
	 * VOP_VSK_0504 : Retrieve <br>
	 * Retrieving RHQ Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmRhqCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();

		try{
			List<MdmRhqComboVO> list = command.searchMdmRhqCombo(event.getPortInformationConditionVO());
			
			StringBuffer strVal = new StringBuffer();
			StringBuffer strName = new StringBuffer();

			for(int i=0;i<list.size();i++){
				if(i == 0 )
				{
					strVal.append(((MdmRhqComboVO)list.get(i)).getVal());
					strName.append(((MdmRhqComboVO)list.get(i)).getName());
				}
				else
				{
					strVal.append("|" + ((MdmRhqComboVO)list.get(i)).getVal());
					strName.append("|" + ((MdmRhqComboVO)list.get(i)).getName());
				}
			}
	 
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("cmbVal", strVal.toString() );
			etcData.put("cmbName", strName.toString() );
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
		}		
		return eventResponse;
		
	} 	
	
	/**
	 * VOP_VSK_0504 : Save <br>
	 * Saving Maneuvering<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();
		try{
			begin();
			command.managePortInfo(event.getPortInformationMgtVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information Creation"}).getMessage(), ex);
        }
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0504 : Save <br>
	 * Saving Terminal Non-Working<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageNonWorking(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();
		try{
			begin();
			command.manageNonWorking(event.getVskPortNworkVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
			
			// :: IBIS START ::
			InterfaceScheduleToIBISBC ibisIfCommand = new InterfaceScheduleToIBISBCImpl();
			List<VskPortNworkIbisIfVO> items = new ArrayList<VskPortNworkIbisIfVO>();
			List<String> locCds = new ArrayList<String>();
			VskPortNworkVO[] vskPortNworkVOs = event.getVskPortNworkVOS();
			
			for ( int i=0; i<vskPortNworkVOs.length; i++ ) {
				
				String locCd = vskPortNworkVOs[i].getLocCd();
				if(!locCds.contains(locCd)) {
					VskPortNworkIbisIfVO vskPortNworkIbisIfVO = new VskPortNworkIbisIfVO();

					vskPortNworkIbisIfVO.setCreUsrId(account.getUsr_id());
					vskPortNworkIbisIfVO.setIbflag  (vskPortNworkVOs[i].getIbflag());
					vskPortNworkIbisIfVO.setLocCd   (vskPortNworkVOs[i].getLocCd());
					vskPortNworkIbisIfVO.setUpdUsrId(account.getUsr_id());
					items.add(vskPortNworkIbisIfVO);
					
					locCds.add(vskPortNworkVOs[i].getLocCd());
				}
			}
			
			ibisIfCommand.createVskPortNworkIbisIfBackEndJob(items, "VskPortNwork");
			// :: IBIS END ::
        } catch (EventException ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0504 : Save<br>
	 * Saving Distance<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortDistance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();
		try{
			begin();
			command.managePortDistance(event.getVskPortDistVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_VSK_0504 : Save<br>
	 * Saving Doc.&Dead Hrs<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortDocHour(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();
		try{
			begin();
			command.managePortDocHour(event.getVskPortDocBufTmVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_VSK_0504 : Save<br>
	 * Saving Canal<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortCanel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();
		try{
			begin();
			command.managePortCanel(event.getVskPortCnlPassCondVOS(),account);
			command.managePortCnlTrScg(event.getVskPortCnlTrScgVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0504 : Save<br>
	 * Saving Trucking<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortTrucking(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();
		try{
			begin();
			command.managePortTrucking(event.getVskPortTrspCondVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_VSK_0504 : Save<br>
	 * Saving Railroad<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortRailLoad(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0504Event event = (VopVsk0504Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();
		try{
			begin();
			command.managePortRailLoad(event.getVskPortTrspCondVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving Terminal Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTermialComboList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0507Event event = (VopVsk0507Event)e;
		TerminalInformationMgtBC command = new TerminalInformationMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<VskComboVO> list = command.searchTermialComboList(event.getTerminalInfoConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation Port Max Sequence"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation Port Max Sequence"}).getMessage(), ex);
			}
		}		
		return eventResponse;
	}
		
	
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving Max F/CRANE Sequece<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMaxFCraneSeqList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0507Event event = (VopVsk0507Event)e;
		TerminalInformationMgtBC command = new TerminalInformationMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<VskComboVO> list = command.searchMaxFCraneSeqList(event.getTerminalInfoConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation Port Max Sequence"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation Port Max Sequence"}).getMessage(), ex);
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving Max GANG STRUCTURE Sequece<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMaxGngSeqList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0507Event event = (VopVsk0507Event)e;
		TerminalInformationMgtBC command = new TerminalInformationMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<VskComboVO> list = command.searchMaxGngSeqList(event.getTerminalInfoConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Gang Structure Max Sequence"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Gang Structure Max Sequence"}).getMessage(), ex);
			}
		}		
		return eventResponse;
	}
	
	
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving Port List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortInfoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0507Event event = (VopVsk0507Event)e;
		TerminalInformationMgtBC command = new TerminalInformationMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<VskComboVO> list = command.searchPortInfoList(event.getTerminalInfoConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation Port Combo"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation Port Combo"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}	
		
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving G/Crane List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGCraneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		List<VskPortGntrCrnVO> list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			if(e.getEventName().equalsIgnoreCase("VopVsk0507Event")){
				VopVsk0507Event event = (VopVsk0507Event)e;
				TerminalInformationMgtBC command = new TerminalInformationMgtBCImpl();
				
				list = command.searchGCraneList(event.getTerminalInfoConditionVO());
				
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			throw ex;
	    }catch (Exception ex){
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation G/Crane"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation G/Crane"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	/**
	 * VOP_VSK_0507 : Save <br>
	 * Saving TerminalInformation G/Crane, F/Crane, Gang Structure, Berth Window<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTerminalInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0507Event event = (VopVsk0507Event)e;
		TerminalInformationMgtBC command = new TerminalInformationMgtBCImpl();
		try{
			begin();
			command.manageTerminalInfoGcrane(event.getVskPortGntrCrnVOS(),account);
			command.manageTerminalInfoFcrane(event.getVskPortFltgCrnVOS(),account);
			command.manageTerminalInfoGang(event.getVskPortGngStrcVOS(),account);
			command.manageTerminalInfoBerth(event.getVskPortBrthWdoVOS(),account);
			
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Information Creation"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving F/Crane List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFCraneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0507Event event = (VopVsk0507Event)e;
		TerminalInformationMgtBC command = new TerminalInformationMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<VskPortFltgCrnVO> list = command.searchFCraneList(event.getTerminalInfoConditionVO());
			List<VskComboVO> list2 = command.searchPortComboList(event.getTerminalInfoConditionVO());

			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
	    }catch (Exception ex){
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation F/Crane"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation F/Crane"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving Gang Structure<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGangStructureList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0507Event event = (VopVsk0507Event)e;
		TerminalInformationMgtBC command = new TerminalInformationMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<VskPortGngStrcVO> list = command.searchGangStructureList(event.getTerminalInfoConditionVO());
			List<VskComboVO> list2 = command.searchPortComboList(event.getTerminalInfoConditionVO());
			
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
	    }catch (Exception ex){
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation Gang Structure"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation Gang Structure"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	
	
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving Berth Window<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBerthWindowList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0507Event event = (VopVsk0507Event)e;
		TerminalInformationMgtBC command = new TerminalInformationMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<VskPortBrthWdoVO> list = command.searchBerthWindowList(event.getTerminalInfoConditionVO());
			//List<VskComboVO> list2 = command.searchTermialComboList(event.getTerminalInfoConditionVO());
			
			eventResponse.setRsVoList(list);
			//eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
	    }catch (Exception ex){
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation Berth Window"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation Berth Window"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving LaneInformation Combo/Lane Group<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneGroupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0510Event event = (VopVsk0510Event)e;
		LaneInformationMgtBC command = new LaneInformationMgtBCImpl();
		VSKCodeFinderBC comboUtil = new VSKCodeFinderBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			MdmVslSvcLaneVO mdmVslSvcLaneVO = event.getMdmVslSvcLaneVO();
			List<MdmVslSvcLaneVO> list = null;
			
			if(mdmVslSvcLaneVO.getVskdFletGrpCd().equals("%")){
				List<VskComboVO> list2 = comboUtil.searchCombo("CD02121");
				
				if(list2 != null){
					for(int cnt = 0; cnt < list2.size(); cnt++){
						VskComboVO opComboVo = (VskComboVO)list2.get(cnt);
						mdmVslSvcLaneVO.setVskdFletGrpCd(opComboVo.getVal());
						
						list = command.searchLaneGroupList(mdmVslSvcLaneVO);
						eventResponse.setRsVoList(list);
					}
				}
			}else{
				list = command.searchLaneGroupList(mdmVslSvcLaneVO);
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			throw ex;
	    }catch (Exception ex){
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation Lane Group"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation Lane Group"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving LaneInformation PIC<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPicList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0510Event event = (VopVsk0510Event)e;
		LaneInformationMgtBC command = new LaneInformationMgtBCImpl();

		String[] lanePicTpCd = new String[3];
		lanePicTpCd[0] = "I";
		lanePicTpCd[1] = "J";
		lanePicTpCd[2] = "S";
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			VskLanePicVO vskLanePicVO = event.getVskLanePicVO();
			List<VskLanePicVO> list = null;
			
			for(int cnt = 0; cnt < lanePicTpCd.length; cnt++){
				vskLanePicVO.setLanePicTpCd(lanePicTpCd[cnt]);
				
				list = command.searchPicList(vskLanePicVO);
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			throw ex;
	    }catch (Exception ex){
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation PIC"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation PIC"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving LaneInformation Bunkering Port Header<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBunkeringPortHeader(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		LaneInformationMgtBC command = new LaneInformationMgtBCImpl();
		VSKCodeFinderBC command2 = new VSKCodeFinderBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MdmVslSvcLaneVO condi = new MdmVslSvcLaneVO();
		try{
			condi.setVskdFletGrpCd("M");
			
			List<VskComboVO> list = command.searchBunkeringPortHeader();
			List<MdmVslSvcLaneVO> list2 = command2.searchLane(condi);
	
			eventResponse.setCustomData("BunkerPort", list);
			eventResponse.setCustomData("LaneCd", list2);
		}catch(EventException ex){
			throw ex;
	    }catch (Exception ex){
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation Bunkering Port Header"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation Bunkering Port Header"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving LaneInformation Bunkering Port<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBunkeringPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0510Event event = (VopVsk0510Event)e;
		LaneInformationMgtBC command = new LaneInformationMgtBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			VskLanePicVO vskLanePicVO = event.getVskLanePicVO();
			List<VskPortBnkRfuelRtoSheetVO> list = command.searchBunkeringPortList(vskLanePicVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    }catch (Exception ex){
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation Bunkering Port"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation Bunkering Port"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving LaneInformation Bunkering Port Header<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPicRsoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		LaneInformationMgtBC command = new LaneInformationMgtBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MdmVslSvcLaneVO condi = new MdmVslSvcLaneVO();
		try{
			condi.setVskdFletGrpCd("M");
			
			List<VskComboVO> list = command.searchPicRsoList();
	
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    }catch (Exception ex){
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation Bunkering Port Header"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation Bunkering Port Header"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}	
	/**
	 * VOP_VSK_0512 : Retrieve <br>
	 * Retrieving LaneInformation Status<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneStatusList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0512Event event = (VopVsk0512Event)e;
		LaneInformationMgtBC command = new LaneInformationMgtBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			LaneInfoConditionVO laneInfoConditionVO = event.getLaneInfoConditionVO();
			List<StatusServiceVO> list1 = command.searchLaneStatusSearviceList(laneInfoConditionVO);
			List<StatusDeployedVesselVO> list2 = command.searchLaneStatusDeployedVesselList(laneInfoConditionVO);
			List<StatusVesselVO> list3 = command.searchLaneStatusVesselList(laneInfoConditionVO);
	
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			eventResponse.setRsVoList(list3);
		}catch(EventException ex){
			throw ex;
	    }catch (Exception ex){
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0512Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation Status"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation Status"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	} 
	
	/**
	 * VOP_VSK_0510 : Save <br>
	 * Saving VSK PORT BUNKER REFUELING<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLaneInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0510Event event = (VopVsk0510Event)e;
		LaneInformationMgtBC command = new LaneInformationMgtBCImpl();
		try{
			begin();
			List<VskLanePicVO> list = command.manageLaneInfoPic(event.getVskLanePicVOS(), account);
			command.manageLaneInfoBunkeringPort(event.getVskPortBnkRfuelRtoSheetVOS(), account);
			
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"VSK PORT BUNKER REFUELING"}).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * VOP_VSK_0702 : Retrieve <br>
	 * Retrieving LaneInformation Group<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneGroupPopUp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0702Event event = (VopVsk0702Event)e;
		LaneInformationMgtBC command = new LaneInformationMgtBCImpl();
		VSKCodeFinderBC comboUtil = new VSKCodeFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			MdmVslSvcLaneVO mdmVslSvcLaneVO = event.getMdmVslSvcLaneVO();
			List<MdmVslSvcLaneVO> list = null;
	
			mdmVslSvcLaneVO.setVskdFletGrpCd("");
			
			list = command.searchLaneGroupList(mdmVslSvcLaneVO);
			eventResponse.setRsVoList(list);
			
			List<VskComboVO> list2 = comboUtil.searchCombo("CD02121");
			
			if(list2 != null){
				for(int cnt = 0; cnt < list2.size(); cnt++){
					VskComboVO opComboVo = (VskComboVO)list2.get(cnt);
					mdmVslSvcLaneVO.setVskdFletGrpCd(opComboVo.getVal());
					
					list = command.searchLaneGroupList(mdmVslSvcLaneVO);
					eventResponse.setRsVoList(list);
				}
			}
		}catch(EventException ex){
			throw ex;
	    }catch (Exception ex){
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0702Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation Lane Group"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation Lane Group"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0702 : Retrieve <br>
	 * Retrieving LaneInformation Group<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneGroupPopUpTP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0702Event event = (VopVsk0702Event)e;
		LaneInformationMgtBC command = new LaneInformationMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			MdmVslSvcLaneVO mdmVslSvcLaneVO = event.getMdmVslSvcLaneVO();
			List<MdmVslSvcLaneVO> list = null;
	
			mdmVslSvcLaneVO.setVskdFletGrpCd("");
			
			list = command.searchLaneGroupList(mdmVslSvcLaneVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    }catch (Exception ex){
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk0702Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation Lane Group"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"LaneInformation Lane Group"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_VSK_0702 : Save <br>
	 * Saving MDM VSL SVC LANE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyLaneGroup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0702Event event = (VopVsk0702Event)e;
		LaneInformationMgtBC command = new LaneInformationMgtBCImpl();
		try{
			begin();
			command.modifyLaneGroupS(event.getMdmVslSvcLaneVOS(), account);
			
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"MDM VSL SVC LANE"}).getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * VOP_VSK_0503 : Retrieve <br>
	 * Retrieving Particular I, Particular II<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVSLPartI(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0503Event event = (VopVsk0503Event)e;
		VesselInformationMgtBC command = new VesselInformationMgtBCImpl();

		try{
			VSLPartIVO vo = command.searchVSLPartI(event.getVesselInformationMgtConditionVO());

			//if(vo.getMdmVslCntrExcelVOL() == null) {
			//if(vo.getVslCd() == null){
				//eventResponse.setUserMessage(new ErrorHandler("COM10001").getUserMessage());
				//eventResponse.setUserMessage(new ErrorHandler("VSK10018", new String[]{"Particular"}).getUserMessage());
			//}

			eventResponse.setETCData(vo.getColumnValues());
			eventResponse.setRsVoList(vo.getMdmVslCntrExcelVOL());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Information Inquiry"}).getMessage(), ex);
		}		
		return eventResponse;
	} 
		
	/**
	 * VOP_VSK_0503 : Retrieve <br>
	 * Retrieving Dock Plan<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDockPlanList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0503Event event = (VopVsk0503Event)e;
		VesselInformationMgtBC command = new VesselInformationMgtBCImpl();

		try{
			List<DockPlanListVO> list = command.searchDockPlanList(event.getVesselInformationMgtConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Information Inquiry"}).getMessage(), ex);
		}		
		return eventResponse;
	} 	

	/**
	 * VOP_VSK_0513 : Retrieve <br>
	 * Retrieving SHA Tide Information Creation and SHA Tide Information Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTideInfoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0513Event event = (VopVsk0513Event)e;
		SHATideInformationMgtBC command = new SHATideInformationMgtBCImpl();

		try{
			List<VskPortTideVO> list = command.searchTideInfoList(event.getSHATideInformationMgtConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SHA Tide Information"}).getMessage(), ex);
		}		
		return eventResponse;
	} 	

	
	/**
	 * VOP_VSK_0513 : Save <br>
	 * Saving SHA Tide Information Creation<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTideInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0513Event event = (VopVsk0513Event)e;
		SHATideInformationMgtBC command = new SHATideInformationMgtBCImpl();
		try{
			begin();
			command.manageTideInfo(event.getVskPortTideVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SHA Tide Information Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}	
	
	
	/**
	 * VOP_VSK_0513 : Retrieve <br>
	 * Retrieving Port Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0513Event event = (VopVsk0513Event)e;
		SHATideInformationMgtBC command = new SHATideInformationMgtBCImpl();

		try{
			//List<VskPortTideVO> list = command.searchPortCode(event.getSHATideInformationMgtConditionVO());
			//eventResponse.setRsVoList(list);			
			VskPortTideVO vo = command.searchPortCode(event.getSHATideInformationMgtConditionVO());
			eventResponse.setETCData(vo.getColumnValues());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
		}		
		return eventResponse;
	} 	
	
	/**
	 * VOP_VSK_0517 : Retrieve <br>
	 * Retrieving VOSI Update Monitoring<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVOSIUpdateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0517Event event = (VopVsk0517Event)e;
		VesselOperationSupportMonitoringBC command = new VesselOperationSupportMonitoringBCImpl();

		try{
			List<VosiUpdateMonitoringVO> list = command.searchVOSIUpdateList(event.getVosiUpdateMonitoringConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"VOSI Update Monitoring"}).getMessage(), ex);
		}		
		return eventResponse;
	} 	

	/**
	 * VOP_VSK_0517 : Port Code Change <br>
	 * Retrieving Port Code and RHQ
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmRhqCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0517Event event = (VopVsk0517Event)e;
		VesselOperationSupportMonitoringBC command = new VesselOperationSupportMonitoringBCImpl();

		try{
			List<MdmRhqComboVO> list = command.searchMdmRhqCombo(event.getVosiUpdateMonitoringConditionVO());
			
			StringBuffer strVal = new StringBuffer();
			StringBuffer strName = new StringBuffer();

			for(int i=0;i<list.size();i++){
				if(i == 0 )
				{
					strVal.append(((MdmRhqComboVO)list.get(i)).getVal());
					strName.append(((MdmRhqComboVO)list.get(i)).getName());
				}
				else
				{
					strVal.append("|" + ((MdmRhqComboVO)list.get(i)).getVal());
					strName.append("|" + ((MdmRhqComboVO)list.get(i)).getName());
				}
			}
	 
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("cmbVal", strVal.toString() );
			etcData.put("cmbName", strName.toString() );
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
		}		
		return eventResponse;
		
	}
	
	/**
	 * VOP_VSK_0518 : Retrieve <br>
	 * Retrieve Draft Weight <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDraftWeightList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VesselInformationMgtBC command = new VesselInformationMgtBCImpl();

		try{
			List<DraftWeightListVO> list = command.searchDraftWeightList();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Draft Weight"}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Draft Weight"}).getMessage(), ex);
		}		
		return eventResponse;
	} 	

	/**
	 * VOP_VSK_0518 : Save <br>
	 * Save Draft Weight <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDraftWeightList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0518Event event = (VopVsk0518Event)e;
		VesselInformationMgtBC command = new VesselInformationMgtBCImpl();
		try{
			begin();
			List<String> list = command.manageDraftWeightList(event.getDraftWeightListVOS(),account);
			StringBuffer data = new StringBuffer();
			if(list != null && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					data.append(list.get(i));

					if (i < list.size()-1)
						data.append(",");
				}

				eventResponse.setETCData("ErrVslCd", data.toString());
			}
			commit();
		}catch(EventException ex){
			rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Draft Weight"}).getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Draft Weight"}).getMessage(), ex);
        }
        
		return eventResponse;

	}	
	
	/**
	 * VOP_VSK_0704 : OK <br>
	 * Save Tier Surcharge <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTierSurcharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0704Event event = (VopVsk0704Event)e;
		PortInformationMgtBC command = new PortInformationMgtBCImpl();
		try{
			begin();
			command.manageTierSurcharge(event.getVskPortCnlTrScgVOS(),account);
			commit();
        } catch (EventException ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Tier Surcharge"}).getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Tier Surcharge"}).getMessage(), ex);
        }
		return eventResponse;
	}	
}