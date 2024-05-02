/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselOperationSupportMgtSC.java
*@FileTitle : Port Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.26 김종옥
* 1.0 Creation
* 
* History
* 2011.04.28 진마리아 [CHM-201110229-01] Lane informtion내 PIC의 Vessel 칼럼을 Carrier로 변경 요청건 - Carrier 입력시 체크로직 생성
* 2012.04.02 진마리아 [CHM-201217105-01] Local Vessel name 칼럼 추가 요청건
* 2014.03.17 박다은 	 [CHM-201428939-01] vessel particular - performance
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.basic.LaneInformationMgtBC;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.basic.LaneInformationMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.event.VopVsk0510Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.event.VopVsk0512Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.event.VopVsk0702Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.LaneInfoConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusDeployedVesselVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusHJSVesselVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusServiceVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.VskPortBnkRfuelRtoSheetVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.basic.OptimizeddistancemgtBC;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.basic.OptimizeddistancemgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.event.VopVsk0515Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.event.VopVsk9515Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.event.VopVsk9004Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo.OptimizedDistanceVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo.YardGroupVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.basic.PortInformationMgtBC;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.basic.PortInformationMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.event.VopVsk0504Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration.PortInformationMgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmRhqComboVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmYardComboVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationMgtVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlPassCondVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlTrScgListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDistVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDocBufTmVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortNworkVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortTrspCondVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.basic.SHATideInformationMgtBC;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.basic.SHATideInformationMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.event.VopVsk0513Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.VskPortTideVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.basic.TerminalInformationMgtBC;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.basic.TerminalInformationMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.event.VopVsk0507Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.event.VopVsk2507Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.TerminalHandlingInfoAttachFileVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortBrthWdoVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortGntrCrnVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.basic.VesselInformationMgtBC;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.basic.VesselInformationMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.event.VopVsk0503Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.event.VopVsk0519Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.event.VopVsk9503Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DockPlanListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.LoadableListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.LowestListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPartIVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPerformanceVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselInformationMgtConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselLoadableInfoVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.basic.VesselOperationSupportMonitoringBC;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.basic.VesselOperationSupportMonitoringBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.event.VopVsk0517Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo.VosiUpdateMonitoringVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.basic.VoyagePerformanceMgtBC;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.basic.VoyagePerformanceMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.event.VopVsk0516Event;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.vo.VoyagePerformanceVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CarrierVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskLanePicVO;
import com.hanjin.syscommon.common.table.VskPortCnlTrScgVO;
import com.hanjin.syscommon.common.table.VskPortFltgCrnVO;
import com.hanjin.syscommon.common.table.VskPortGngStrcVO;
 
/**
 * NIS2010-VesselOperationSupportMgt Business Logic ServiceCommand - NIS2010-VesselOperationSupportMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Jong Ock
 * @see PortInformationMgtDBDAO
 * @since J2EE 1.6
 */

public class VesselOperationSupportMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
 
	/**
	 * VesselOperationSupportMgt system 업무 시나리오 선행작업<br>
	 * VOP_VSK_0504업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("VesselOperationSupportMgtSC 시작");
		try {  
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}  

	/**
	 * VesselOperationSupportMgt system 업무 시나리오 마감작업<br>
	 * VOP_VSK_0504 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("VesselOperationSupportMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-VesselOperationSupportMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
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
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //소스 검색후 사용 안하는것 같아 주석처리함.10.05.06
//				eventResponse = searchPortComboList(e);
//			}else
			if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {//COMMAND01-> SEARCH05
				eventResponse = searchMaxFCraneSeqList(e);
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
			
		//*** Terminal Handling Information Attach File UPLOAD ***//
		}else if (e.getEventName().equalsIgnoreCase("VopVsk2507Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse 	= searchTerminalHandlingInfoAttachFileList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse	= manageTerminalHandlingInfoAttachFileList(e);
			}
		////////////////////////////////////////////////////////////
			
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
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {//Carrier Code Check
				eventResponse = checkCarrier(e);
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
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchVslEngLoclNm(e);
			}			
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				eventResponse = searchVSLPerformance(e);
			}			
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)){
				eventResponse = searchLowestList(e);
			}			
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)){
				eventResponse = searchLoadableList(e);
			}			
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)){
				eventResponse = searchVSLPerformanceDetail(e);
			}			
			else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = managePerformanceInfo(e);
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
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//COMMAND01-> SEARCH01
				eventResponse= searchMdmRhqCombo(e);
			}		
		} else if (e.getEventName().equalsIgnoreCase("VopVsk9503Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselLoadableInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse= searchLoadableInfoList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk9515Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchYardGroupList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse= checkPort(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse= manageYardGroupList(e);
			}			
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0515Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOptimizedDistance(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse= checkPort(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse= searchYardGroupCombo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse= searchSlipForOptimizedDistance(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse= searchToPortDistance(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse= searchYardGroupCombo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse= searchYardGroupCombo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse= sheetToCheckPort(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse= searchYardGroupCombo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse= checkLane(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse= searchTargetVmsShort(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse= manageOptimizedDistance(e);
			}		
			
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0516Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVoyagePerformance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVesselList();
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLanelList();
			}   else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {		// VVD 유효성 체크
				eventResponse = checkVvdInvalid(e);
			}   else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {		// VVD Port to Port 가져오기
				eventResponse = searchPortToPort(e);
			}	
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0519Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselSummary(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01) ||
					e.getFormCommand().isCommand(FormCommand.SEARCH02) ||
					e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				eventResponse = searchValidation(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk9004Event")) {
            eventResponse = this.searchVmsShortPltStnDesc(e);
        }
		return eventResponse;
	}
	
	/* ==============================================
	 * 김종옥수석  VopVsk0504Event Service Area Start
	 * ==============================================
	 */
	
	/**
	 * VOP_VSK_0504 : Retrieve <br>
	 * Maneuvering 을 조회 합니다.<br>
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
	 * Terminal Non-Working 을 조회 합니다.<br>
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
	 * Distance 을 조회 합니다.<br>
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
	 * Doc.&Dead Hrs 을 조회 합니다.<br>
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
	 * Canal 을 조회 합니다.<br>
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
	 * Trucking 을 조회 합니다.<br>
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
	 * Railroad 을 조회 합니다.<br>
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
	 * Maneuvering에 등록 가능한 TMNL Code을 조회(콤보생성) 합니다.<br>
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
	 * 조회 조건에서 Port Code에 해당하는 RHQ를 조회 합니다.<br>
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
	 * Doc.&Dead Hrs 등록 가능한 Port 을 조회(콤보생성) 합니다.<br>
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
	 * 등록 가능한 Port Code 을 조회(콤보생성) 합니다.<br>
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
	 * 등록 가능한 Port 을 조회(콤보생성) 합니다.<br>
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
	 * RHQ Code 을 조회 합니다.<br>
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
	 * Maneuvering 을 저장 합니다.<br>
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
	 * Terminal Non-Working 을 저장 합니다.<br>
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
	 * Distance 을 저장 합니다.<br>
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
	 * Doc.&Dead Hrs 을 저장 합니다.<br>
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
	 * Canal 을 저장 합니다.<br>
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
	 * Trucking 을 저장 합니다.<br>
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
	 * Railroad 을 저장 합니다.<br>
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

	
	/* ==============================================
	 * 김종옥수석  VopVsk0504Event Service Area End
	 * ==============================================
	 */
	
	/* ==============================================
	 * 장석현수석  VopVsk0507Event Service Area Start
	 * ==============================================
	 */
//	/**
//	 * VOP_VSK_0507 : Retrieve <br>
//	 * Port List를 조회 합니다.<br>
//	 * 
//	 * @param e Event
//	 * @return response EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchPortComboList(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		try{
//			VSKCodeFinderBC comboUtil = new VSKCodeFinderBCImpl();
//			//TerminalInformationMgtBC command = new TerminalInformationMgtBCImpl();
//			//List<VskComboVO> list = command.searchPortComboList();
//			List<VskComboVO> list2 = comboUtil.searchCombo("CD00593");
//			List<VskComboVO> list3 = comboUtil.searchCombo("CD02121");
//			
//			GeneralEventResponse eventResponse = new GeneralEventResponse();
//			//eventResponse.setRsVoList(list);
//			eventResponse.setRsVoList(list2);
//			eventResponse.setRsVoList(list3);
//
//	        return eventResponse;
//		}catch(EventException ex){
//			throw ex;
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//			if (e.getEventName().equalsIgnoreCase("VopVsk0507Event")) {
//				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation Port Combo"}).getMessage(), ex);
//			}else{
//				throw new EventException(new ErrorHandler("COM12203", new String[]{"TerminalInformation Port Combo"}).getMessage(), ex);				
//			}
//		}		
//	}
	
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Terminal Code를 조회 합니다.<br>
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
	 * Max Sequece를 조회 합니다.<br>
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
	 * Port List를 조회 합니다.<br>
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
	 * G/Crane List를 조회 합니다.<br>
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
			}
			
			eventResponse.setRsVoList(list);
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
	 * TerminalInformation G/Crane, F/Crane, Gang Structure, Berth Window 의 수정내용을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTerminalInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		VopVsk0507Event 			event 			= (VopVsk0507Event)e;
		TerminalInformationMgtBC 	command 		= new TerminalInformationMgtBCImpl();
		
		try{
			
			begin();
			command.manageTerminalInfoGcrane(event.getVskPortGntrCrnVOS(),account);
			command.manageTerminalInfoFcrane(event.getVskPortFltgCrnVOS(),account);
			command.manageTerminalInfoGang	(event.getVskPortGngStrcVOS(),account);
			command.manageTerminalInfoBerth	(event.getVskPortBrthWdoVOS(),account);
			
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
	 * F/Crane List를 조회 합니다.<br>
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
	 * Gang Structure를 조회 합니다.<br>
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
	 * Berth Window를 조회 합니다.<br>
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
	
	/* ==============================================
	 * 장석현수석  VopVsk0507Event Service Area End
	 * ==============================================
	 */
	
	
	/**
	 * VOP_VSK_2507 : Retrieve <br>
	 * Terminal Handling Information Attach File List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalHandlingInfoAttachFileList(Event e) throws EventException {

		VopVsk2507Event 			event 			= (VopVsk2507Event)e;
		TerminalInformationMgtBC 	command 		= new TerminalInformationMgtBCImpl	();
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse			();
		
		try{
			List<TerminalHandlingInfoAttachFileVO> 	list 	= command.searchTerminalHandlingInfoAttachFileList(event.getTerminalHandlingInfoAttachFileVO());

			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
	    }catch (Exception ex){
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk2507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Terminal Handling Information Attach File"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Terminal Handling Information Attach File"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}	
	
	/**
	 * VOP_VSK_2507 : Save <br>
	 * Terminal Handling Information Attach File List를 저장 합니다.<br>
	 * 
	 * @param e Event
	 * @return 
	 * @exception EventException
	 */
	private EventResponse manageTerminalHandlingInfoAttachFileList(Event e) throws EventException {

		VopVsk2507Event 			event 			= (VopVsk2507Event)e;
		TerminalInformationMgtBC 	command 		= new TerminalInformationMgtBCImpl	();
		GeneralEventResponse 		eventResponse	= new GeneralEventResponse();
		
		try{
				begin();
				command.manageTerminalHandlingInfoAttachFileList(event.getTerminalHandlingInfoAttachFileVOS(), account);
				eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
				commit();	
				
		}catch(EventException ex){
			throw ex;
	    }catch (Exception ex){
	        log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopVsk2507Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Terminal Handling Information Attach File"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Terminal Handling Information Attach File"}).getMessage(), ex);				
			}
		}		
		
	    return eventResponse;
	}		
	
	
	/* ==============================================
	 * 장석현수석  VopVsk0510Event Service Area Start
	 * ==============================================
	 */
	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * LaneInformation Combo/Lane Group를 조회 합니다.<br>
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
			
			//전체면... CD02121를 검색해서. 줌...
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
	 * LaneInformation PIC를 조회 합니다.<br>
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
			
			//전체면... CD02121를 검색해서. 줌...
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
	 * LaneInformation Bunkering Port Header를 조회 합니다.<br>
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
	 * LaneInformation Bunkering Port를 조회 합니다.<br>
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
	 * LaneInformation Bunkering Port Header를 조회 합니다.<br>
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
	 * LaneInformation Status를 조회 합니다.<br>
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
			List<StatusHJSVesselVO> list3 = command.searchLaneStatusHJSVesselList(laneInfoConditionVO);
	
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
	 * VSK PORT BUNKER REFUELING의 수정내용을 저장 합니다. <br>
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
	 * VOP_VSK_0510 : Carrier Code에 대해 공통 모듈을 이용하여 validation 체크합니다.
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCarrier(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0510Event event = (VopVsk0510Event)e;
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		
		CarrierVO vo = new CarrierVO();
		vo.setCrrCd(event.getCrrCd());
		List<CarrierVO> list = command.checkCarrier(vo);
		if(list.size()>0){
			if(list.get(0).getDeltFlg().equals("N")){
				eventResponse.setETCData("crr_cd", list.get(0).getCrrCd());
			}
		}
		return eventResponse;
	}
	/* ==============================================
	 * 장석현수석  VopVsk0510Event Service Area End
	 * ==============================================
	 */
	
	/* ==============================================
	 * 장석현수석  VopVsk0702Event Service Area Start
	 * ==============================================
	 */
	/**
	 * VOP_VSK_0702 : Retrieve <br>
	 * LaneInformation Group를 조회 합니다. <br>
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
	
			//빈값을 준다... ㅋㅋ 선택 되지않은 놈만 들고 올려구...
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
	 * LaneInformation Group를 조회 합니다. <br>
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
	
			//빈값을 준다... 선택 되지않은 놈만 들고 올려구...
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
	 * MDM VSL SVC LANE의 수정내용을 저장 합니다. <br>
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
	/* ==============================================
	 * 장석현수석  VopVsk0702Event Service Area End
	 * ==============================================
	 */
	
		
	/* ==============================================
	 * 김종옥수석  VopVsk0503Event Service Area Start
	 * ==============================================
	 */
	/**
	 * VOP_VSK_0503 : Retrieve <br>
	 * Particular I, Particular II 을 조회 합니다.<br>
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
	 * Dock Plan 을 조회 합니다.<br>
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
	/* ==============================================
	 * 김종옥수석  VopVsk0503Event Service Area End
	 * ==============================================
	 */	
	
	/* ==============================================
	 * 김종옥수석  VopVsk0513Event Service Area Start
	 * ==============================================
	 */
	/**
	 * VOP_VSK_0513 : Retrieve <br>
	 * SHA Tide Information Creation 및 SHA Tide Information Inquiry 을 조회 합니다.<br>
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
	 * SHA Tide Information Creation 을 저장 합니다.<br>
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
	 * Port Code 유효성(체크) 을 조회 합니다.<br>
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
	
	/* ==============================================
	 * 김종옥수석  VopVsk0513Event Service Area End
	 * ==============================================
	 */
	
	/* ==============================================
	 * 김종옥수석  VopVsk0517Event Service Area Start
	 * ==============================================
	 */
	/**
	 * VOP_VSK_0517 : Retrieve <br>
	 * VOSI Update Monitoring 을 조회 합니다.<br>
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
	 * 조회조건에 Port Code 유효성 체크 및 해당 Rhq을 조회 합니다.<br>
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
	
	/* ==============================================
	 * 김종옥수석  VopVsk0517Event Service Area End
	 * ==============================================
	 */	
	
	/**
	 * VOP_VSK_0503 : Vessel Code change <br>
	 * Vessel의 ENG / LOCL Name을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslEngLoclNm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0503Event event = (VopVsk0503Event)e;
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();

		try{
			List<VesselVO> list = command.searchVslList(event.getVesselVO());
			if(list.size()==1){
				eventResponse.setETCData("vsl_eng_nm", list.get(0).getVslEngNm());
				eventResponse.setETCData("vsl_locl_nm", list.get(0).getVslLoclNm());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Particular"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/* ==============================================
	 * 정운사원  VopVsk9515Event Service Area Start
	 * ==============================================
	 */
	/**
	 * VOP_VSK_9515 : Retrieve <br>
	 * Yard Group을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardGroupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk9515Event event = (VopVsk9515Event)e;
		OptimizeddistancemgtBC command = new OptimizeddistancemgtBCImpl();

		try{
			List<YardGroupVO> list = command.searchYardGroupList(event.getYardGroupVO());
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
	 * VOP_VSK_9515 : Save <br>
	 * Yard Group를 저장합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageYardGroupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk9515Event event = (VopVsk9515Event)e;
		OptimizeddistancemgtBC command = new OptimizeddistancemgtBCImpl();
	    try {
            begin();
            command.manageYardGroupList(event.getYardGroupVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit(); 
        } catch(EventException ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }		
		return eventResponse;
	} 	
	
	/**
	 * VOP_VSK_0503 : Retrieve <br>
	 * Performance 를 조회 합니다.<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVSLPerformance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0503Event event = (VopVsk0503Event)e;
		VesselInformationMgtBC command = new VesselInformationMgtBCImpl();

		try{
			VSLPerformanceVO vo = command.searchVSLPerformance(event.getVesselInformationMgtConditionVO());
			eventResponse.setETCData(vo.getColumnValues());
			eventResponse.setRsVoList(vo.getLoadFactorListVOl());

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
	 * Performance 를 조회 합니다.<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVSLPerformanceDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0503Event event = (VopVsk0503Event)e;
		VesselInformationMgtBC command = new VesselInformationMgtBCImpl();
		
		try{
			VSLPerformanceVO vo = command.searchVSLPerformanceDetail(event.getVesselInformationMgtConditionVO());
			eventResponse.setETCData(vo.getColumnValues());
//			eventResponse.setRsVoList(vo.getLoadFactorListVOl());
			
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
	 * Lowest Plan 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLowestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0503Event event = (VopVsk0503Event)e;
		VesselInformationMgtBC command = new VesselInformationMgtBCImpl();

		try{
			List<LowestListVO> list = command.searchLowestList(event.getVesselInformationMgtConditionVO());
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
	 * VOP_VSK_0503 : Retrieve <br>
	 * Loadable 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoadableList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0503Event event = (VopVsk0503Event)e;
		VesselInformationMgtBC command = new VesselInformationMgtBCImpl();
		
		try{
			List<LoadableListVO> list = command.searchLoadableList(event.getVesselInformationMgtConditionVO());
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
	 * VOP_VSK_9503 : Retrieve <br>
	 * Loadable 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoadableInfoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk9503Event event = (VopVsk9503Event)e;
		VesselInformationMgtBC command = new VesselInformationMgtBCImpl();
		
		try{
			List<VesselLoadableInfoVO> list = command.searchLoadableInfoList(event.getVesselLoadableInfoVO());
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
	 * VOP_VSK_0503 : Save <br>
	 * 
     * @param e
     * @return
     * @throws EventException
     */
    public EventResponse managePerformanceInfo(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0503Event event = (VopVsk0503Event)e;
		VesselInformationMgtBC command = new VesselInformationMgtBCImpl();
        try {
            begin();
            command.managePerformanceInfo(event.getPerformanceInfoVO(), account);
            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit(); 
        } catch(EventException ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
        
        return eventResponse;
    }
    

	/**
	 * VOP_VSK_9503 Save
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse manageVesselLoadableInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk9503Event event = (VopVsk9503Event)e;
		VesselInformationMgtBC command = new VesselInformationMgtBCImpl();

		try{
			begin();
			command.manageVesselLoadableInfo(event.getVesselLoadableInfoVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * VOP_VSK_0515 : Port Change<br>
	 * Port Code 가 존재하는지 여부를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPort(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		VSKCodeFinderBC 		command 		= new VSKCodeFinderBCImpl();
		String					sPortCd			= null;
		try{
			
			if(e instanceof VopVsk9515Event){
				VopVsk9515Event event 	= (VopVsk9515Event)e;
				sPortCd		= event.getYardGroupVO().getPortCd();
				
			} else if(e instanceof VopVsk0515Event){
				VopVsk0515Event event 	= (VopVsk0515Event)e;
				if(event.getOptimizedDistanceVO().getToPortCd() == ""){
					sPortCd	= event.getOptimizedDistanceVO().getFmPortCd();
				} else if(event.getOptimizedDistanceVO().getToPortCd() != ""){
					sPortCd	= event.getOptimizedDistanceVO().getToPortCd();
				} 
			}
			
			String chkPort = command.checkPort(sPortCd);
			eventResponse.setETCData("check_port", chkPort);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_9515 : Retrieve <br>
	 * Yard Group Combo List를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardGroupCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0515Event event = (VopVsk0515Event)e;
		OptimizeddistancemgtBC command = new OptimizeddistancemgtBCImpl();

		try{
			List<OptimizedDistanceVO> list = command.searchYardGroupCombo(event.getOptimizedDistanceVO());
			
			
			if(list != null && list.size()>0){
				
				StringBuilder sb = new StringBuilder();
				StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				StringBuilder sb3 = new StringBuilder();
				OptimizedDistanceVO vo = list.get(0);
				
				sb.append(vo.getFmYdGrpCd());
				sb1.append(vo.getToYdGrpCd());
				sb2.append(vo.getSheetToYdGrpCd());
				sb3.append(vo.getSheetFmYdGrpCd());
				
				for (int i = 1; i < list.size(); i++) {
					sb.append("|");
					sb1.append("|");
					sb2.append("|");
					sb3.append("|");
					sb.append(list.get(i).getFmYdGrpCd());
					sb1.append(list.get(i).getToYdGrpCd());
					sb2.append(list.get(i).getSheetToYdGrpCd());
					sb3.append(list.get(i).getSheetFmYdGrpCd());
				}

				eventResponse.setETCData("fm_yd_grp_cd", sb.toString());
				eventResponse.setETCData("to_yd_grp_cd", sb.toString());
				eventResponse.setETCData("sheet_to_yd_grp_cd", sb.toString());
				eventResponse.setETCData("sheet_fm_yd_grp_cd", sb.toString());
				
			}
			
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
	 * VOP_VSK_0515 : Retrieve <br>
	 * 해당 Port에 따른 Optimized Distance 정보를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOptimizedDistance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0515Event event = (VopVsk0515Event)e;
		OptimizeddistancemgtBC command = new OptimizeddistancemgtBCImpl();

		try{
			List<OptimizedDistanceVO> list = command.searchOptimizedDistance(event.getOptimizedDistanceVO());
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
	 * VOP_VSK_0515 : Save <br>
	 * Optimized Distance 정보를 저장합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOptimizedDistance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0515Event event = (VopVsk0515Event)e;
		OptimizeddistancemgtBC command = new OptimizeddistancemgtBCImpl();
				
	    try {
            begin();
            command.manageOptimizedDistance(event.getOptimizedDistanceVOs(), event.getKeys(), account);
            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit(); 
        } catch(EventException ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0515 : Retrieve <br>
	 * 해당 Port의 Distance정보를 이용하여 Slip 데이터를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSlipForOptimizedDistance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0515Event event = (VopVsk0515Event)e;
		OptimizeddistancemgtBC command = new OptimizeddistancemgtBCImpl();

		try{
			List<OptimizedDistanceVO> list = command.searchSlipForOptimizedDistance(event.getOptimizedDistanceVO());
	
				eventResponse.setETCData("avg_slp_rt", list.get(0).getAvgSlpRt());
				eventResponse.setETCData("slp_knt", list.get(0).getSlpKnt());
				eventResponse.setETCData("var_slp_rt", list.get(0).getVarSlpRt());
				
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"VOSI Update Monitoring"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0515 : Retrieve <br>
	 * To Port입력 시에 해당 Distance 정보를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchToPortDistance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0515Event event = (VopVsk0515Event)e;
		OptimizeddistancemgtBC command = new OptimizeddistancemgtBCImpl();
 
		try{
			List<OptimizedDistanceVO> list = command.searchToPortDistance(event.getOptimizedDistanceVO());
			
			eventResponse.setETCData("gmt_td_hrs", list.get(0).getGmtTdHrs());
			eventResponse.setETCData("stnd_dist", list.get(0).getStndDist());
			eventResponse.setETCData("vms_avg_dist", list.get(0).getVmsAvgDist());
			eventResponse.setETCData("vms_shtg_dist", list.get(0).getVmsShtgDist());
			eventResponse.setETCData("sheet_fm_port_cd", list.get(0).getSheetFmPortCd());
			eventResponse.setETCData("sheet_fm_yd_grp_cd", list.get(0).getSheetFmYdGrpCd());

			
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
	 * VOP_VSK_0515 : Sheet To Port Change<br>
	 * Sheet안에있는 To Port Code 가 존재하는지 여부를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sheetToCheckPort(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		VSKCodeFinderBC 		command 		= new VSKCodeFinderBCImpl();
		String					sPortCd			= null;
		try{
			
			if(e instanceof VopVsk0515Event){
				VopVsk0515Event event 	= (VopVsk0515Event)e;
				sPortCd		= event.getOptimizedDistanceVO().getSheetToPortCd();
				
			}
			
			String chkPort = command.checkPort(sPortCd);
			eventResponse.setETCData("check_port", chkPort);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0515 : Lane Check<br>
	 * Sheet안에있는 To Port Code 가 존재하는지 여부를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */	
    private EventResponse checkLane(Event e) throws EventException {
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            VopVsk0515Event event = (VopVsk0515Event)e;
            VesselInformationMgtConditionVO vesselInformationMgtConditionVO = event.getVesselInformationMgtConditionVO();
            VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
            
            if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) 
            {
                MdmVslSvcLaneVO vo = new MdmVslSvcLaneVO();
                vo.setVslSlanCd(vesselInformationMgtConditionVO.getVslSlanCd());
                List list = command.checkSvcLane(vo);
                if(list.size() > 0)
                    eventResponse.setETCData("vsl_slan_cd", ((MdmVslSvcLaneVO)list.get(0)).getVslSlanCd());
            }
            return eventResponse;
        }

    /**
	 * VOP_VSK_9004 : Retrieve <br>
	 * VMS short 더블 클릭시 해당되는 VVD 정보 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
     private EventResponse searchTargetVmsShort(Event e) 
            throws EventException
        {
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            VopVsk0515Event event = (VopVsk0515Event)e;
            OptimizeddistancemgtBC command = new OptimizeddistancemgtBCImpl();
            try
            {
                List list = command.searchTargetVmsShort(event.getOptimizedDistanceVO());
                eventResponse.setETCData("vms_shtg_vsl_cd", ((OptimizedDistanceVO)list.get(0)).getVslCd());
                eventResponse.setETCData("vms_shtg_skd_voy_no", ((OptimizedDistanceVO)list.get(0)).getSkdVoyNo());
                eventResponse.setETCData("vms_shtg_skd_dir_cd", ((OptimizedDistanceVO)list.get(0)).getSkdDirCd());
                eventResponse.setETCData("vms_shtg_pasg_pln_dt", ((OptimizedDistanceVO)list.get(0)).getPasgPlnDt());
                eventResponse.setETCData("vms_shtg_dep_port_cd", ((OptimizedDistanceVO)list.get(0)).getDepPortCd());
                eventResponse.setETCData("vms_shtg_arr_port_cd", ((OptimizedDistanceVO)list.get(0)).getArrPortCd());
                eventResponse.setETCData("vms_shtg_vps_eta_dt", ((OptimizedDistanceVO)list.get(0)).getVpsEtaDt());
                eventResponse.setRsVoList(list);
            }
            catch(EventException ex)
            {
                throw ex;
            }
            catch(Exception ex)
            {
                log.error((new StringBuilder("err ")).append(ex.toString()).toString(), ex);
                throw new EventException((new ErrorHandler("COM12203", new String[] {"Port to Port distance"})).getMessage(), ex);
            }
            return eventResponse;
        }

     /**
 	 * VOP_VSK_9004 : Retrieve <br>
 	 * VMS short 더블 클릭시 해당되는 vvd, port의 plt_stn_desc를 조회<br>
 	 * 
 	 * @param e Event
 	 * @return response EventResponse
 	 * @exception EventException
 	 */
     private EventResponse searchVmsShortPltStnDesc(Event e)
            throws EventException
        {
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            VopVsk9004Event event = (VopVsk9004Event)e;
            OptimizeddistancemgtBC command = new OptimizeddistancemgtBCImpl();
            try
            {
                List list = command.searchVmsShortPltStnDesc(event.getOptimizedDistanceVO());
                log.debug((new StringBuilder("----------------------------------[")).append(((OptimizedDistanceVO)list.get(0)).getPltStnDesc()).append("]-----------------").toString());
                eventResponse.setETCData("plt_stn_desc", ((OptimizedDistanceVO)list.get(0)).getPltStnDesc());
                eventResponse.setRsVoList(list);
            }
            catch(EventException ex)
            {
                throw ex;
            }
            catch(Exception ex)
            {
                log.error((new StringBuilder("err ")).append(ex.toString()).toString(), ex);
                throw new EventException((new ErrorHandler("COM12203", new String[] {"Port to Port distance"})).getMessage(), ex);
            }
            return eventResponse;
        }

	
	/**
	 * VOP_VSK_0516 : Retrieve <br>
	 * Voyage Performance 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVoyagePerformance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0516Event event = (VopVsk0516Event)e;
		VoyagePerformanceMgtBC command = new VoyagePerformanceMgtBCImpl();

		try{
			List<VoyagePerformanceVO> list = command.searchVoyagePerformance(event.getVoyagePerformanceVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
		}		
		return eventResponse;
	} 	
	
	/**
	 * VOP_VSK_0516 : Retrieve <br>
	 * Vessel List 을 조회 합니다.<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselList() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VoyagePerformanceMgtBC command = new VoyagePerformanceMgtBCImpl();

		try{
			List<VoyagePerformanceVO> list = command.searchVesselList();
			
			StringBuffer data = new StringBuffer();
			
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
	
					data.append(list.get(i).getVslCd());
					if (i < list.size() - 1)
						data.append("|");	
				}
			}
			eventResponse.setETCData("vsl_class", data.toString());
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
		}		
	} 
	
	/**
	 * VOP_VSK_0516 : Retrieve <br>
	 * Lane List 을 조회 합니다.<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLanelList() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VoyagePerformanceMgtBC command = new VoyagePerformanceMgtBCImpl();

		try{
			List<VoyagePerformanceVO> list = command.searchLanelList();
			
			StringBuffer data = new StringBuffer();
			
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
	
					data.append(list.get(i).getVslSlanCd());
					if (i < list.size() - 1)
						data.append("|");	
				}
			}
			eventResponse.setETCData("vsl_slan_cd", data.toString());
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
		}		
	} 
	
	/**
	 * VOP_VSK_0516 : Retrieve <br>
	 * VVD 유효성을 체크 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVvdInvalid(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0516Event event = (VopVsk0516Event)e;
		VoyagePerformanceMgtBC command = new VoyagePerformanceMgtBCImpl();

		try{
			List<VoyagePerformanceVO> list = command.checkVvdInvalid(event.getVoyagePerformanceVO());
			if (list.size() > 0) {
				eventResponse.setETCData("vvd_rtn", list.get(0).getVvdRtn());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
		}		
		return eventResponse;
	} 
	
	/**
	 * VOP_VSK_0516 : Retrieve <br>
	 * VVD Port to Port 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortToPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0516Event event = (VopVsk0516Event)e;
		VoyagePerformanceMgtBC command = new VoyagePerformanceMgtBCImpl();

		try{
			StringBuffer data = new StringBuffer();
			List<VoyagePerformanceVO> list = command.searchPortToPort(event.getVoyagePerformanceVO());
			
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {	
					data.append(list.get(i).getPairPortCd());
					if (i < list.size() - 1)
						data.append("|");
				}
			}	
			eventResponse.setETCData("port_to_port", data.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
		}		
		return eventResponse;
	} 	
	
	
	
	/**
	 * VOP_VSK_0519 : Retrieve <br>
	 * Vessel Summary info를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0519Event event = (VopVsk0519Event)e;
		VesselInformationMgtBC command = new VesselInformationMgtBCImpl();

		try{
			List<VSLPartIVO> list = command.searchVesselSummary(event.getVesselInformationMgtConditionVO());
			
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
	 * VOP_VSK_0519 : Lane Code, Vessel Code, Port Code, Carrier Code
	 * 각 코드에 대해 공통 모듈을 이용하여 validation 체크합니다.
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchValidation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0519Event event = (VopVsk0519Event)e;
		VesselInformationMgtConditionVO vesselInformationMgtConditionVO = event.getVesselInformationMgtConditionVO();
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		
		if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Lane Code 조회
			
			MdmVslSvcLaneVO vo = new MdmVslSvcLaneVO();
			vo.setVslSlanCd(vesselInformationMgtConditionVO.getVslSlanCd());
			List<MdmVslSvcLaneVO> list = command.checkSvcLane(vo);
			if(list.size()>0){
				eventResponse.setETCData("vsl_slan_cd",  list.get(0).getVslSlanCd());
			}
			
		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // Vessel Code 조회
			
			VesselVO vo = new VesselVO();
			vo.setVslCd(vesselInformationMgtConditionVO.getVslCd());
			//vo.setIncDelVsl(vesselInformationMgtConditionVO.getIncDelVsl());
			List<VesselVO> list = command.searchVslList(vo);
			if(list.size()>0){
				eventResponse.setETCData("vsl_cd", list.get(0).getVslCd());
			}
			
		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // Carrier Code 조회
			
			CarrierVO vo = new CarrierVO();
			vo.setCrrCd(vesselInformationMgtConditionVO.getCrrCd());
			List<CarrierVO> list = command.checkCarrier(vo);
			if(list.size()>0){
				eventResponse.setETCData("crr_cd", list.get(0).getCrrCd());
			}
			
		}
		return eventResponse;
	}
}