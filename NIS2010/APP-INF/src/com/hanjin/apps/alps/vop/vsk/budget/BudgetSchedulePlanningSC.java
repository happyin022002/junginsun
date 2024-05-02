/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BudgetSchedulePlanningSC.java
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.14
*@LastModifier : YONG JOON LEE
*@LastVersion : 1.0
* 2014.07.14 YONG JOON LEE
* 1.0 Creation
* 
* History
* 2015.07.20 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.basic.ProformaScheduleMgtBC;
import com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.basic.ProformaScheduleMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.event.VopVsk0101Event;
import com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.event.VopVsk0102Event;
import com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.event.VopVsk0108Event;
import com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.event.VopVsk0109Event;
import com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.event.VopVsk0110Event;
import com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.event.VopVsk0111Event;
import com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.integration.ProformaScheduleMgtDBDAO;

import com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event.VopVsk0103Event;
import com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event.VopVsk0104Event;
import com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event.VopVsk0105Event;
import com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event.VopVsk0106Event;
import com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event.VopVsk0107Event;
import com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event.VopVsk0112Event;

import com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event.VopVsk0113Event;
import com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.basic.VesselScheduleMgtBC;
import com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.basic.VesselScheduleMgtBCImpl;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdTypeHelpVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0020Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPortVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PfSkdDetailVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SimulationVvdCheckVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstSkdSimVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdBkgStsVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBC;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserDefinedLanePortGroupVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.SearchDateVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskPfSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdHisVO;


/**
 * ALPS-SchedulePlanningOperation Business Logic ServiceCommand - ALPS-SchedulePlanningOperation 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SEO CHANG YUL 
 * @see ProformaScheduleMgtDBDAO
 * @since J2EE 1.4
 */

public class BudgetSchedulePlanningSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SchedulePlanningOperation system 업무 시나리오 선행작업<br>
	 * UI_VSK-0241업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {log.error(e.getMessage());}
	}

	/**
	 * SchedulePlanningOperation system 업무 시나리오 마감작업<br>
	 * UI_VSK-0241 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("BudgetSchedulePlanningSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SchedulePlanningOperation system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopVsk0101Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			// RETRIEVE
				eventResponse = searchPfSkd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// PORT CODE 변경시
				eventResponse = searchPortInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	// TMNL CODE 변경시
				eventResponse = searchYardList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	// PORT CODE에 해당하는 TMNL CODE 조회
				eventResponse = searchYardListByPort(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) { // M/Calculation - 화면상에 삭제됨
				eventResponse = calPfSkdManual(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) { // A/Calculation - 화면상에 삭제됨
				eventResponse = calPfSkdAuto(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {	// Save 수행
				eventResponse = createRqstSimScnrCfm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {	// Delete 수행
				eventResponse = removePfSkd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) {	// row delete 수행
				eventResponse = calRowDelete(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {		// LANE CODE에 따른 P/F SKD 조회
				eventResponse = searchPfSkd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	// VSL CODE에 따른 Vessel 조회
				eventResponse = searchVslList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// Simulation 처리
				eventResponse = simulateLongRngSkd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	// Phase In 처리
				eventResponse = simulateLongRngSkd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	// Phase In Cancel 처리
				eventResponse = simulateLongRngSkd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {	// Add Calling 처리
				eventResponse = simulateLongRngSkd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {	// Add Calling Cancel 처리
				eventResponse = simulateLongRngSkd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){ // Save
				// Save 클릭
				eventResponse = createLongRngSkd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSvcLaneList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVslList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLongRngSkd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchVslSlanCdListByVessel(e);				
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0105Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByVvd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardListByPort(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPfLaneTypeList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCstSkdByPfSkdUse(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDirectionList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkSvcLaneDir(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkVslCntr(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstSkdByVvd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCstSkdByRmk(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("VopVsk0106Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			// Retrieve
				eventResponse = searchVslSkdListByLane(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){	
				eventResponse = searchSvcLaneList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){		// Delete
				eventResponse = removeCstSkdByVvd(e);
//			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
//				// Manual Close/Open
//				eventResponse = manageVslSkdListByLane(e);
//			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
//				// P/F 등록
//				eventResponse = manageVvdPf(e);
//			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
//				// SKD Activate
//				eventResponse = manageSkdActivate(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){	// 화면상에 삭제됨
				// 입력한 crr_cd 체크
				eventResponse = searchCrrCd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0107Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByVvd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkVslCntr(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0108Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfTpHelp(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = checkSvcLane(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0109Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND17)) {
				eventResponse = searchRsltVvdList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0111Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND18)) {
				eventResponse = searchPfTypeList(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("VopVsk0112Event")) { // Simulation Popup in LRS Creation 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = checkBkgStsByVvd(e);
			}
			
			/**
			 * VOP_VSK_0113 에 대한 Retrieve 기능 - 이용준 추가 2014.07.15
			 * @param Event e
			 * @return EventResponse 
			 * @exception EventException
			 * @author 이용준
			 */
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0113Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkVslCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRhqList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchControlOfficeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchLanePortGroupByUserId(e);
			}
		}
		return eventResponse;
	}
	/**
	 * VOP_VSK_0106 : Retrieve
	 * 
	 * Lane 또는 Vessel에 따른 Vessel Schedule을 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse 
	 * @exception EventException
	 * @author Hyuk Ryu
	 */
	private EventResponse searchVslSkdListByLane(Event e) throws EventException {
		ActivationVvdVO vo = null;
		VopVsk0106Event event = (VopVsk0106Event)e;
		vo = event.getActivationVvdVO();
		VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		List<ActivationVvdVO> list = command.searchVslSkdListByLane(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0106 : Delete
	 * 
	 * 선택한 Vessel Schedule을 삭제합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Hyuk Ryu
	 */
	private EventResponse removeCstSkdByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VesselScheduleMgtBC costalCommand = new VesselScheduleMgtBCImpl();
//		ActualScheduleMgtBC actCommand = new ActualScheduleMgtBCImpl();
		
		try{
			begin();
			
			ActivationVvdVO[] srcVOs = null;
			VopVsk0106Event event = (VopVsk0106Event)e;
			srcVOs = event.getActivationVvdVOS();
				
//			StringBuffer laneData = new StringBuffer();
//			StringBuffer vvdData = new StringBuffer();
//			StringBuffer hisData = new StringBuffer();
//			StringBuffer turnVoyData = new StringBuffer();
//			StringBuffer turnDirData = new StringBuffer();
				
//			for(int i=0; i<srcVOs.length; i++){
					
//				if("BKG".equals(srcVOs[i].getSkdStsCd()) && srcVOs[i].getVirSkdStsCd().startsWith("BKG")){
//					hisData.append("ALL|");	// 해당 VVD와 Virtual Port 모두에 History를 남겨야 하는 경우
//				}else if("BKG".equals(srcVOs[i].getSkdStsCd())){
//					hisData.append("VVD|");	// 해당 VVD에 History를 남겨야 하는 경우
//				}else if(srcVOs[i].getVirSkdStsCd().startsWith("BKG")){
//					hisData.append("VIR|");	// Virtual Port에 History를 남겨야 하는 경우
//				}

				// VOP_VSK_0249 화면에 전송하기 위한 데이터 조립
//				if("BKG".equals(srcVOs[i].getSkdStsCd()) || srcVOs[i].getVirSkdStsCd().startsWith("BKG")){
//					vvdData.append(srcVOs[i].getVslCd() + srcVOs[i].getSkdVoyNo() + srcVOs[i].getSkdDirCd());
//					vvdData.append("|");
//					laneData.append(srcVOs[i].getVslSlanCd() + "|");
//					
//					turnVoyData.append(srcVOs[i].getTurnSkdVoyNo() + "|");
//					turnDirData.append(srcVOs[i].getTurnSkdDirCd() + "|");
//						
//					// Booking이 연결된 VVD는 VOP_VSK_0249 화면에 의해 삭제되어야 하므로 여기서는 삭제되지 않도록 한다.
//					// 따라서 이 VVD 정보를 null 처리해서 costalCommand.removeCstSkdByVvd() 에서 삭제되지 않도록 한다.
//					srcVOs[i] = null;
//				}
					
//			}
				
//			List<VvdVO> vvdVOs = new ArrayList<VvdVO>();
//			List<VvdVO> turnVvdVOs = new ArrayList<VvdVO>();
				
//			if(srcVOs!=null){
//				for(ActivationVvdVO activationVvdVO : srcVOs){
//					// Booking이 연결된 VVD는 VOP_VSK_0249 화면의 동작에의해 처리되도록 null 처리하여 유도
//					if(activationVvdVO==null) continue;
//					
//					VvdVO vo = new VvdVO();
//					vo.setVslSlanCd(activationVvdVO.getVslSlanCd());
//					vo.setVslCd(activationVvdVO.getVslCd());
//					vo.setSkdVoyNo(activationVvdVO.getSkdVoyNo());
//					vo.setSkdDirCd(activationVvdVO.getSkdDirCd());
//					vvdVOs.add(vo);
//						
//					// TURN 정보가 있으면 
//					if(activationVvdVO.getTurnSkdDirCd()!=null && activationVvdVO.getTurnSkdDirCd().length()!=0){
//						VvdVO turnVo = new VvdVO();
//						turnVo.setVslSlanCd(activationVvdVO.getVslSlanCd());
//						turnVo.setVslCd(activationVvdVO.getVslCd());
//						turnVo.setSkdVoyNo(activationVvdVO.getTurnSkdVoyNo());
//						turnVo.setSkdDirCd(activationVvdVO.getTurnSkdDirCd());
//						turnVvdVOs.add(turnVo);
//					}
//				}
//			}
//			actCommand.removeVskActPortSkd(vvdVOs);
			
			costalCommand.removeCstSkdByVvd(srcVOs, null, null, account);
				
//			List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs = costalCommand.searchBkgBdrLog(vvdVOs);
//			sendBkgVvdBdrLog(bkgVvdBdrLogVOs);
			
			// ERP 전송
//			List<VskVslSkdVO> vskVslSkdVOs = new ArrayList<VskVslSkdVO>();
//			for(VvdVO vvdVO : vvdVOs){
//				VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
//				vskVslSkdVO.setVslSlanCd(vvdVO.getVslSlanCd());
//				vskVslSkdVO.setVslCd(vvdVO.getVslCd());
//				vskVslSkdVO.setSkdVoyNo(vvdVO.getSkdVoyNo());
//				vskVslSkdVO.setSkdDirCd(vvdVO.getSkdDirCd());
//				vskVslSkdVOs.add(vskVslSkdVO);
//			}
//			for(VvdVO vvdVO : turnVvdVOs){
//				VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
//				vskVslSkdVO.setVslSlanCd(vvdVO.getVslSlanCd());
//				vskVslSkdVO.setVslCd(vvdVO.getVslCd());
//				vskVslSkdVO.setSkdVoyNo(vvdVO.getSkdVoyNo());
//				vskVslSkdVO.setSkdDirCd(vvdVO.getSkdDirCd());
//				vskVslSkdVOs.add(vskVslSkdVO);
//			}
//			
//			for(VskVslSkdVO vskVslSkdVO : vskVslSkdVOs){
//				vskVslSkdVO.setCreUsrId(account.getUsr_id());
//				vskVslSkdVO.setUpdUsrId(account.getUsr_id());
//			}
//			sendVslSkdErpIf(vskVslSkdVOs);
			
			eventResponse.setUserMessage(new ErrorHandler("VSK10026").getUserMessage());
//			eventResponse.setETCData("lane", laneData.toString());
//			eventResponse.setETCData("vvd", vvdData.toString());	
//			eventResponse.setETCData("his", hisData.toString());
//				
//			eventResponse.setETCData("turn_voy", turnVoyData.toString());
//			eventResponse.setETCData("turn_dir", turnDirData.toString());
			

			commit(); 

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return eventResponse;
	}
		
	/**
	 * VOP_VSK_0101 : P/F Schedule Type Search
	 * VOP_VSK_0102 : P/F Schedule Type Search
	 * VOP_VSK_0103 : P/F Schedule Type 변경
	 * VOP_VSK_0109 
	 * 
	 * Lane 에 해당하는 기본 Proforma Type 혹은 지정된 Proforma Type 정보를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("static-access")
	private EventResponse searchPfSkd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PfSkdVO pfSkdVO =  null;
		VskPfSkdVO vskPfSkdVO = new VskPfSkdVO();
		List<VskPfSkdDtlVO> vskPfSkdDtlVOs = new ArrayList<VskPfSkdDtlVO>();
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		String uiVesselType = null;
		String fdrDivCd = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		if(e instanceof VopVsk0103Event){
			VopVsk0103Event event = (VopVsk0103Event)e;
			pfSkdVO = event.getPfSkdVO();
			uiVesselType = pfSkdVO.getVslSvcTpCd();
		}else if(e instanceof VopVsk0101Event){
			VopVsk0101Event event = (VopVsk0101Event)e;
			pfSkdVO = event.getPfSkdVO();
			pfSkdVO.setVslSvcTpCd("");
			pfSkdVO.setSlanStndFlg("");
		}else if(e instanceof VopVsk0102Event){
			VopVsk0102Event event = (VopVsk0102Event)e;
			pfSkdVO = event.getPfSkdVO();
			pfSkdVO.setVslSvcTpCd("");
			pfSkdVO.setSlanStndFlg("");
		}else if(e instanceof VopVsk0109Event){
			VopVsk0109Event event = (VopVsk0109Event)e;
			pfSkdVO = event.getPfSkdVO();
			pfSkdVO.setSlanStndFlg("");
		}
		
		if(e instanceof VopVsk0103Event){
			
			MdmVslSvcLaneVO vo = new MdmVslSvcLaneVO();
			vo.setVslSlanCd(((VopVsk0103Event)e).getPfSkdVO().getVslSlanCd());
			
			VSKCodeFinderBC combc = new VSKCodeFinderBCImpl();
			List<MdmVslSvcLaneVO> checkList = combc.checkSvcLane(vo);
			
			if(checkList==null || checkList.size()==0){
				eventResponse.setUserMessage(new ErrorHandler("VSK10019").getUserMessage());
				return eventResponse;
			}else{
				MdmVslSvcLaneVO checkVO = checkList.get(0);
				fdrDivCd = checkVO.getFdrDivCd();
				if("F".equals(uiVesselType) && 
						(!"O".equals(checkVO.getVslSvcTpCd()) && !"O".equals(fdrDivCd))
						){
					eventResponse.setUserMessage(new ErrorHandler("VSK10049").getUserMessage());
					return eventResponse;
				}else if("T".equals(uiVesselType) && "O".equals(checkVO.getVslSvcTpCd())){
					eventResponse.setUserMessage(new ErrorHandler("VSK10048").getUserMessage());
					return eventResponse;
				}
			}	
		}
		
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		List<PfSkdVO> list = command.searchPfSkd(pfSkdVO);
		
		if(e instanceof VopVsk0103Event || e instanceof VopVsk0109Event){
		
			int vslCount = 0;
			String vslSlanNm = "";
			
			if(list==null || list.size()==0){
					
				if(pfSkdVO != null && "N".equals(pfSkdVO.getSlanStndFlg())){
					// PF_SVC_TP_CD 가 Standard 타입이 아니라 화면에서 입력한 경우임.
					// 조회결과가 없을때는 해당 PF_SVC_TP_CD이 존재하지 않음.
					// VSK10023 : 입력하신  Proforma Type은 존재하지 않습니다. 다시 확인하세요!
					throw new EventException(new ErrorHandler("VSK10023").getMessage());
				}else{
					// Proforma Schedule이 등록 되지 않았을 경우에 표시
					throw new EventException(new ErrorHandler("VSK10020").getMessage());
				}
			} else {
				if(pfSkdVO != null && ("F".equals(pfSkdVO.getVslSvcTpCd()) || "F".equals(uiVesselType))){
					pfSkdVO = list.get(0);
					if(!"O".equals(pfSkdVO.getVslSvcTpCd())){
						// Lane Type을 Feeder 로 조회했으나
						// 해당 레인의 타입이 Feeder 타입이 아닌경우
						// VSK10049 오류발생
						throw new EventException(new ErrorHandler("VSK10049").getMessage()); 
					}
				}
			}
			
			if(list != null && list.size()>0){
				pfSkdVO = list.get(0);
//				vslCount = Integer.parseInt((!"".equals(Utils.isNotNull(pfSkdVO.getN1stVslClssKnt())))?"0":pfSkdVO.getN1stVslClssKnt())
//							 + Integer.parseInt((!"".equals(Utils.isNotNull(pfSkdVO.getN2ndVslClssKnt())))?"0":pfSkdVO.getN2ndVslClssKnt())
//							 + Integer.parseInt((!"".equals(Utils.isNotNull(pfSkdVO.getN3rdVslClssKnt())))?"0":pfSkdVO.getN3rdVslClssKnt());
				
				vslCount = Integer.parseInt((pfSkdVO.getN1stVslClssKnt()==null || "".equals(pfSkdVO.getN1stVslClssKnt()))?"0":pfSkdVO.getN1stVslClssKnt())
				 + Integer.parseInt((pfSkdVO.getN2ndVslClssKnt()==null || "".equals(pfSkdVO.getN2ndVslClssKnt()))?"0":pfSkdVO.getN2ndVslClssKnt())
				 + Integer.parseInt((pfSkdVO.getN3rdVslClssKnt()==null || "".equals(pfSkdVO.getN3rdVslClssKnt()))?"0":pfSkdVO.getN3rdVslClssKnt());
				
				vslSlanNm = pfSkdVO.getVslSlanNm();
				
				StringBuilder portCdSb = new StringBuilder();
				StringBuilder portDirCdSb = new StringBuilder();
				StringBuilder skdDirCdSb = new StringBuilder();
				StringBuilder etbDyCdSb = new StringBuilder();
				StringBuilder clptSeqSb = new StringBuilder();
				
				for(int i=0; i<list.size(); i++){
					pfSkdVO = list.get(i);
					portCdSb.append("|" + pfSkdVO.getPortCd());
					portDirCdSb.append("|" + pfSkdVO.getPortCd() + " [" + pfSkdVO.getSkdDirCd() + "]");
					skdDirCdSb.append("|" + pfSkdVO.getSkdDirCd());
					etbDyCdSb.append("|" + pfSkdVO.getEtbDyCd());
					clptSeqSb.append("|" + pfSkdVO.getClptSeq());
				}
				
				eventResponse.setETCData("vsl_count", Integer.toString(vslCount));
				eventResponse.setETCData("pf_svc_tp_cd", pfSkdVO.getPfSvcTpCd());
				eventResponse.setETCData("port_cd", portCdSb.toString());
				eventResponse.setETCData("port_dir_cd", portDirCdSb.toString());
				eventResponse.setETCData("skd_dir_cd", skdDirCdSb.toString());
				eventResponse.setETCData("etb_dy_cd", etbDyCdSb.toString());
				eventResponse.setETCData("vsl_slan_nm", vslSlanNm);
				eventResponse.setETCData("brth_itval_dys", pfSkdVO.getBrthItvalDys());
				eventResponse.setETCData("svc_dur_dys", pfSkdVO.getSvcDurDys());
				eventResponse.setETCData("clpt_seq", clptSeqSb.toString());
				
				eventResponse.setRsVoList(list);
			}
		}else if(e instanceof VopVsk0101Event || e instanceof VopVsk0102Event){
			if(list != null && list.size()>0){
				vskPfSkdVO.setVslSlanCd(list.get(0).getVslSlanCd());
				
				vskPfSkdVO.setPfSvcTpCd(list.get(0).getPfSvcTpCd());
				vskPfSkdVO.setSlanStndFlg(list.get(0).getSlanStndFlg());
				vskPfSkdVO.setSvcDurDys(list.get(0).getSvcDurDys());
				vskPfSkdVO.setStndSvcSpd(list.get(0).getStndSvcSpd());
				vskPfSkdVO.setBrthItvalDys(list.get(0).getBrthItvalDys());
				
				vskPfSkdVO.setMmlUsdFlg(list.get(0).getMmlUsdFlg());
				vskPfSkdVO.setSimDt(list.get(0).getSimDt());
				vskPfSkdVO.setSimNo(list.get(0).getSimNo());
				vskPfSkdVO.setN1stVslClssCd(list.get(0).getN1stVslClssCd());
				vskPfSkdVO.setN1stVslClssKnt(list.get(0).getN1stVslClssKnt());
				
				vskPfSkdVO.setN2ndVslClssCd(list.get(0).getN2ndVslClssCd());
				vskPfSkdVO.setN2ndVslClssKnt(list.get(0).getN2ndVslClssKnt());
				vskPfSkdVO.setN3rdVslClssCd(list.get(0).getN3rdVslClssCd());
				vskPfSkdVO.setN3rdVslClssKnt(list.get(0).getN3rdVslClssKnt());
				vskPfSkdVO.setClptKnt(list.get(0).getClptKnt());
				
				vskPfSkdVO.setTtlDist(list.get(0).getTtlDist());
				vskPfSkdVO.setMaxSpd(list.get(0).getMaxSpd());
				vskPfSkdVO.setAvgSpd(list.get(0).getAvgSpd());
				vskPfSkdVO.setDeltFlg(list.get(0).getDeltFlg());
				vskPfSkdVO.setPfSkdRmk(list.get(0).getPfSkdRmk());
				
				vskPfSkdVO.setCreDt(list.get(0).getCreDt());
				vskPfSkdVO.setUpdDt(list.get(0).getUpdDt());

				for(int i=0; i<list.size(); i++){
					VskPfSkdDtlVO vskPfSkdDtlVO = new VskPfSkdDtlVO();
					vskPfSkdDtlVO.setRowSeq(list.get(i).getRowSeq());
					vskPfSkdDtlVO.setVslSlanCd(list.get(i).getVslSlanCd());
					
					vskPfSkdDtlVO.setPfSvcTpCd(list.get(i).getPfSvcTpCd());
					vskPfSkdDtlVO.setPortCd(list.get(i).getPortCd());
					vskPfSkdDtlVO.setSkdDirCd(list.get(i).getSkdDirCd());
					vskPfSkdDtlVO.setClptSeq(list.get(i).getClptSeq());
					vskPfSkdDtlVO.setPortRotnSeq(list.get(i).getPortRotnSeq());
					
					vskPfSkdDtlVO.setYdCd(list.get(i).getTempYdCd());
					vskPfSkdDtlVO.setCallYdIndSeq(list.get(i).getCallYdIndSeq());
					vskPfSkdDtlVO.setTurnPortFlg(list.get(i).getTurnPortFlg());
					vskPfSkdDtlVO.setTurnPortIndCd(list.get(i).getTurnPortIndCd());
					vskPfSkdDtlVO.setEtbDyCd(list.get(i).getEtbDyCd());
					
					vskPfSkdDtlVO.setEtbDyNo(list.get(i).getEtbDyNo());
					vskPfSkdDtlVO.setEtbTmHrmnt(list.get(i).getEtbTmHrmnt());
					vskPfSkdDtlVO.setEtdDyCd(list.get(i).getEtdDyCd());
					vskPfSkdDtlVO.setEtdDyNo(list.get(i).getEtdDyNo());
					vskPfSkdDtlVO.setEtdTmHrmnt(list.get(i).getEtdTmHrmnt());
					
					vskPfSkdDtlVO.setLnkDist(list.get(i).getLnkDist());
					vskPfSkdDtlVO.setLnkSpd(list.get(i).getLnkSpd());
					vskPfSkdDtlVO.setTztmHrs(list.get(i).getTztmHrs());
					vskPfSkdDtlVO.setSeaBufHrs(list.get(i).getSeaBufHrs());
					vskPfSkdDtlVO.setSeaBufSpd(list.get(i).getSeaBufSpd());
					vskPfSkdDtlVO.setAvgSeaBufSpd(list.get(i).getAvgSeaBufSpd());
					
					vskPfSkdDtlVO.setMnvrInHrs(list.get(i).getMnvrInHrs());
					vskPfSkdDtlVO.setMnvrOutHrs(list.get(i).getMnvrOutHrs());
					vskPfSkdDtlVO.setIbIpcgoQty(list.get(i).getIbIpcgoQty());
					vskPfSkdDtlVO.setIbOcnCgoQty(list.get(i).getIbOcnCgoQty());
					vskPfSkdDtlVO.setObIpcgoQty(list.get(i).getObIpcgoQty());
					
					vskPfSkdDtlVO.setObOcnCgoQty(list.get(i).getObOcnCgoQty());
					vskPfSkdDtlVO.setTmlProdQty(list.get(i).getTmlProdQty());
					vskPfSkdDtlVO.setCrnKnt(list.get(i).getCrnKnt());
					vskPfSkdDtlVO.setActWrkHrs(list.get(i).getActWrkHrs());
					vskPfSkdDtlVO.setPortBufHrs(list.get(i).getPortBufHrs());
					
					vskPfSkdDtlVO.setZd(list.get(i).getZd());
					//2009 09 30 임창빈 수석 수정요청 : 
					//Maximum Speed,P/F Speed,Speed (Incl. buffer),Total Buffer Ratio,Sea buffer Ratio,Port buffer Ratio,P/F Speed Ratio,Buffer Speed Ratio
					//기존의 쿼리에서 계산되어서 가져오는 방법에서  화면에 마지막 로우의 숨긴 데이타를 빼고 계산한다
					/*
					vskPfSkdDtlVO.setTotMaxSpd(list.get(i).getTotMaxSpd());
					vskPfSkdDtlVO.setTotAvgSpd(list.get(i).getTotAvgSpd());
					vskPfSkdDtlVO.setBufSpd(list.get(i).getSeaBufSpd());
					
					vskPfSkdDtlVO.setTotBufRat(list.get(i).getTotBufRat());
					vskPfSkdDtlVO.setSeaBufRat(list.get(i).getSeaBufRat());
					vskPfSkdDtlVO.setPortBufRat(list.get(i).getPortBufRat());
					vskPfSkdDtlVO.setPfSpdRat(list.get(i).getPfSpdRat());
					vskPfSkdDtlVO.setBufSpdRat(list.get(i).getBufSpdRat());
*/					
					vskPfSkdDtlVO.setMinMaxSpd(list.get(i).getMinMaxSpd());
					
					vskPfSkdDtlVO.setCheckWkTm(list.get(i).getCheckWkTm());
					vskPfSkdDtlVO.setCraneWkTm(list.get(i).getCraneWkTm());

					vskPfSkdDtlVOs.add(vskPfSkdDtlVO);
					
				}
				
				//2009 09 30 임창빈 수석 수정요청 : 
				//Maximum Speed,P/F Speed,Speed (Incl. buffer),Total Buffer Ratio,Sea buffer Ratio,Port buffer Ratio,P/F Speed Ratio,Buffer Speed Ratio
				//기존의 쿼리에서 계산되어서 가져오는 방법에서  화면에 마지막 로우의 숨긴 데이타를 빼고 계산한다
				//마지막 로우는 계산에서 제한다
				double cnt = list.size()-1;
				//SEA SPEED TOTLAL
				double totLinkSpd = 0;
				//SEA BUFFER SPEED TOTAL
				double totBufSpd = 0;
				//SEA BUFFER TOTAL
				double totSeaBufHrs = 0;
				//SEA TIME TOTAL
				double totSeaTime = 0;
				//MANU IN HRS TOTAL
				double totMnvrInHrs = 0;
				//MANU OUT HRS TOTAL
				double totMnvrOutHrs = 0;
				//WORKING HOUR TOTAL
				double totActWrkHrs = 0;
				//PORT BUFFER HRS TOTLA
				double totPortBufHrs = 0;
				//VSL CALSS MAX SPD
				double dMinMaxSpd = 0;
				//MAX SPEED
				float totMaxSpd = 0;
				//P/F SPEED
				float totAvgSpd = 0;
				// P/F SPEED INCLUDE SEA BUFFER
				double avgSpdIncludeSeaBuf = 0;
				
				BigDecimal bufSpd = null;
				BigDecimal totBufRat = null;
				BigDecimal seaBufRat = null;
				BigDecimal portBufRat = null;
				BigDecimal pfSpdRat = null;
				BigDecimal bufSpdRat = null;

				float max = 0;
				for(int k=0; k<list.size()-1; k++){
					
					if(Float.compare(Float.parseFloat(list.get(k).getLnkSpd()), max)>0){
						max = Float.parseFloat(list.get(k).getLnkSpd());
					}
					
					if(k==0){
						dMinMaxSpd = Double.parseDouble(list.get(0).getMinMaxSpd());
						avgSpdIncludeSeaBuf = Double.parseDouble(list.get(0).getAvgSpd());
					}
					
					if(list.get(k).getLnkSpd() != null && !"".equals(list.get(k).getLnkSpd())){
						totLinkSpd 	+= Float.parseFloat(list.get(k).getLnkSpd());
					}
					if(list.get(k).getSeaBufSpd() != null && !"".equals(list.get(k).getSeaBufSpd())){
						totBufSpd += Float.parseFloat(list.get(k).getSeaBufSpd());
					}
					if(list.get(k).getSeaBufHrs() != null && !"".equals(list.get(k).getSeaBufHrs())){
						totSeaBufHrs += Float.parseFloat(list.get(k).getSeaBufHrs());
					}
					if(list.get(k).getTztmHrs() != null && !"".equals(list.get(k).getTztmHrs())){
						totSeaTime += Float.parseFloat(list.get(k).getTztmHrs());
					}
					if(list.get(k+1).getMnvrInHrs() != null && !"".equals(list.get(k+1).getMnvrInHrs())){
						totMnvrInHrs += Float.parseFloat(list.get(k+1).getMnvrInHrs());
					}
					if(list.get(k).getMnvrOutHrs() != null && !"".equals(list.get(k).getMnvrOutHrs())){
						totMnvrOutHrs += Float.parseFloat(list.get(k).getMnvrOutHrs());
					}
					if(list.get(k).getActWrkHrs() != null && !"".equals(list.get(k).getActWrkHrs())){
						totActWrkHrs += Float.parseFloat(list.get(k).getActWrkHrs());
					}
					if(list.get(k).getPortBufHrs() != null && !"".equals(list.get(k).getPortBufHrs())){
						totPortBufHrs += Float.parseFloat(list.get(k).getPortBufHrs());
					}
					
				}
				//Manu In은  마지막 로우는 보여준다
//				totMnvrInHrs = totMnvrInHrs + Float.parseFloat(list.get(list.size()-1).getMnvrInHrs());
				//Max Speed
				totMaxSpd = max;
				//Avg Speed
				totAvgSpd = Math.round(totLinkSpd/cnt); // <-- P/F Speed
				
				//Vsl Class Min_Max_Speed
//				dMinMaxSpd = totBufSpd/cnt;//Math.round(totBufSpd/cnt);
				
				//Sea Buffer Speed
				double tempBufSpd = Double.parseDouble(list.get(0).getSeaBufSpd());
				BigDecimal bigBufSpd = new BigDecimal(tempBufSpd);
				bufSpd = bigBufSpd.setScale(1,bigBufSpd.ROUND_HALF_UP);
				
				double tempTotBufRat = (totBufSpd+totSeaBufHrs)/(totSeaTime+totSeaBufHrs+totMnvrInHrs+totMnvrOutHrs+totActWrkHrs)*100;
				if(Double.toString(tempTotBufRat).equals("NaN") || Double.toString(tempTotBufRat).equals("Infinity")){
					tempTotBufRat = 0;
		        }
				BigDecimal bigTotBufRat = new BigDecimal(tempTotBufRat);
				totBufRat = bigTotBufRat.setScale(2,bigTotBufRat.ROUND_HALF_UP);
		
		        double tempSeaBufRat = totSeaBufHrs/(totSeaTime+totSeaBufHrs+totMnvrInHrs+totMnvrOutHrs)*100;
		        if(Double.toString(tempSeaBufRat).equals("NaN") || Double.toString(tempSeaBufRat).equals("Infinity")){
		        	tempSeaBufRat = 0;
		        }
		        BigDecimal bigSeaBufRat = new BigDecimal(tempSeaBufRat);
		        seaBufRat = bigSeaBufRat.setScale(2,bigSeaBufRat.ROUND_HALF_UP);
		        
		        double tempPortBufRat = totPortBufHrs/(totActWrkHrs+totPortBufHrs)*100;
		        if(Double.toString(tempPortBufRat).equals("NaN") || Double.toString(tempPortBufRat).equals("Infinity")){
		        	tempPortBufRat = 0;
		        }
		        BigDecimal bigPortBufRat = new BigDecimal(tempPortBufRat);
		        portBufRat = bigPortBufRat.setScale(2,bigPortBufRat.ROUND_HALF_UP);
		
		        double tempPfSpdRat = 0;
		        if(dMinMaxSpd!=0){
		        	// P/F Speed Ratio = P/F Speed / MIN_MAX_SPEED
		        	tempPfSpdRat = totAvgSpd / dMinMaxSpd;
		        }
		        
		        BigDecimal bigPfSpdRat = new BigDecimal(tempPfSpdRat);        
		        pfSpdRat = bigPfSpdRat.setScale(2,bigPfSpdRat.ROUND_HALF_UP);
		        
		        double tempBufSpdRat = 0;
		        if(dMinMaxSpd!=0){
		        	tempBufSpdRat = avgSpdIncludeSeaBuf/dMinMaxSpd*100;	
		        }
		        
		        BigDecimal bigBufSpdRat = new BigDecimal(tempBufSpdRat);
		        bufSpdRat = bigBufSpdRat.setScale(2,bigBufSpdRat.ROUND_HALF_UP);
		
				
		        list.get(0).setTotMaxSpd(Float.toString(totMaxSpd));
		        list.get(0).setTotAvgSpd(Float.toString(totAvgSpd));
		        list.get(0).setSeaBufSpd(bufSpd.toString());
		        list.get(0).setTotBufRat(totBufRat.toString());
		        list.get(0).setSeaBufRat(seaBufRat.toString());
		        list.get(0).setPortBufRat(portBufRat.toString());
		        list.get(0).setPfSpdRat(pfSpdRat.toString());
		        list.get(0).setBufSpdRat(bufSpdRat.toString());	

				sb.append(list.get(0).getTempYdCd());
				for(int i=1; i<list.size(); i++){
					sb.append("|");
					sb.append(list.get(i).getTempYdCd());
				}
				
				sb2.append(list.get(0).getTotMaxSpd());
				sb2.append("|");
				sb2.append(list.get(0).getTotAvgSpd());
				sb2.append("|");
				sb2.append(list.get(0).getSeaBufSpd());
				sb2.append("|");
				sb2.append(list.get(0).getTotBufRat());
				sb2.append("|");
				sb2.append(list.get(0).getSeaBufRat());
				sb2.append("|");
				sb2.append(list.get(0).getPortBufRat());
				sb2.append("|");
				sb2.append(list.get(0).getPfSpdRat());
				sb2.append("|");
				sb2.append(list.get(0).getBufSpdRat());
				sb2.append("|");
				sb2.append(list.get(0).getMinMaxSpd());
				sb2.append("|");
				sb2.append(list.get(0).getVslSvcTpCd());
				sb2.append("|");
				sb2.append(list.get(0).getCheckVslSkd());
				sb2.append("|");
				sb2.append(list.get(0).getCreUsrId());
				sb2.append("|");
				sb2.append(list.get(0).getUpdUsrId());
	
						
				eventResponse.setRsVo(vskPfSkdVO);
				eventResponse.setRsVoList(vskPfSkdDtlVOs);
				eventResponse.setETCData("ydCd", sb.toString());
				eventResponse.setETCData("etcdt", sb2.toString());
			}else{
				eventResponse.setUserMessage(new ErrorHandler("VSK10018",new String[]{"P/F SKD Creation"}).getUserMessage());
			}
		}
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0104 : Vessel Code Input
	 * 
	 * 특정 Port Skd 목록에서 해당 Vessel Code를 가지는 Lane 정보 목록을 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Hyuk Ryu
	 */
	private EventResponse searchVslSlanCdListByVessel(Event e) throws EventException {
		
		try{
			VesselVO vesselVO = new VesselVO();
			VopVsk0104Event event = (VopVsk0104Event)e;
			PortSkdOnLongRangeVO portSkdOnLongRangeVO = event.getPortSkdOnLongRangeVO();
			
			vesselVO.setVslCd(portSkdOnLongRangeVO.getVslCd());
			vesselVO.setIncDelVsl(portSkdOnLongRangeVO.getIncDelVsl());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			VSKCodeFinderBC comCommand = new VSKCodeFinderBCImpl();
			VesselScheduleMgtBC lrsCommand = new VesselScheduleMgtBCImpl();
			
			List<VesselVO> list = comCommand.searchVslList(vesselVO);
			
			if(list!=null && list.size()==1){
				eventResponse.setETCData("vsl_eng_nm", list.get(0).getVslEngNm());
				
				List<PortSkdOnLongRangeVO> portSkdOnLongRangeVOs = lrsCommand.searchPortSkd(portSkdOnLongRangeVO);
				Set<String> vslSlanCdSet = new HashSet<String>();
				String vslSlanCd = null;
				
				// 조회된 스케쥴에서 VSL_SLAN_CD 만 추려낸다.
				for(PortSkdOnLongRangeVO vo : portSkdOnLongRangeVOs){
					vslSlanCd = VSKGeneralUtil.getCheckNullToString(vo.getVslSlanCd());
					if(vslSlanCd.length()!=0){
						vslSlanCdSet.add(vslSlanCd);
					}
				}
				
				if(vslSlanCdSet.size()>0){
					StringBuilder vslSlanCdArr = new StringBuilder().append("");
					for(Iterator<String> i = vslSlanCdSet.iterator(); i.hasNext(); ){
						vslSlanCdArr.append("|").append(i.next());
					}
					eventResponse.setETCData("vsl_slan_cd_arr", vslSlanCdArr.toString());
				}
				
			}
			
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * VOP_VSK_0103 : Vessel Code Input
	 * VOP_VSK_0104 : Vessel Code Input
	 * 
	 * 해당 Vessel Code를 가지는 Vessel 정보를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Hyuk Ryu
	 */
	private EventResponse searchVslList(Event e) throws EventException {
		VesselVO vo = new VesselVO();
		if(e instanceof VopVsk0103Event){
			VopVsk0103Event event = (VopVsk0103Event)e;
			vo.setVslCd((String)event.getAttribute("vsl_cd"));
		}else if(e instanceof VopVsk0104Event){
			VopVsk0104Event event = (VopVsk0104Event)e;
			vo.setVslCd(event.getPortSkdOnLongRangeVO().getVslCd());
			vo.setIncDelVsl(event.getPortSkdOnLongRangeVO().getIncDelVsl());
		}
				
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		List<VesselVO> list = command.searchVslList(vo);
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		
		if(list!=null && list.size()==1){
			eventResponse.setETCData("vsl_eng_nm", list.get(0).getVslEngNm());
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0103 : Save
	 * 
	 * Long Range Schedule 정보를 생성합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @author Hyuk Ryu
	 */
	private EventResponse createLongRngSkd(Event e) throws EventException {
		
		LongRangeSkdGRPVO longRangeSkdGRPVO = null;
		VskVslSkdHisVO vskVslSkdHisVO = null;
		VopVsk0103Event event = (VopVsk0103Event)e;
		longRangeSkdGRPVO = event.getLongRangeSkdGRPVO();
		longRangeSkdGRPVO.setPfSkdVOs(event.getPfSkdVOs());
		vskVslSkdHisVO = event.getVskVslSkdHisVO();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
//			VesselScheduleMgtBC costalCommand = new VesselScheduleMgtBCImpl();
//			ActualScheduleMgtBC actCommand = new ActualScheduleMgtBCImpl();
//			GeneralBookingSplitCombineBC bkgCommand = new GeneralBookingSplitCombineBCImpl();
			
			longRangeSkdGRPVO.setCreUsrId(account.getUsr_id());
			longRangeSkdGRPVO.setUpdUsrId(account.getUsr_id());
			
			// 이미 존재하는 VVD를 삭제한다.
			// Booking이 없는 VVD
			ActivationVvdVO[] nonBkgVOs = longRangeSkdGRPVO.getNonBkgVVDs()==null?new ActivationVvdVO[0]:longRangeSkdGRPVO.getNonBkgVVDs();
			for(int i=0; i<nonBkgVOs.length; i++){
				nonBkgVOs[i].setCreUsrId(account.getUsr_id());
				nonBkgVOs[i].setUpdUsrId(account.getUsr_id());
			}
			
			// Booking이 있는 VVD
			ActivationVvdVO[] bkgVVDs = longRangeSkdGRPVO.getBkgVVDs()==null?new ActivationVvdVO[0]:longRangeSkdGRPVO.getBkgVVDs();
			ActivationVvdVO[] virVVDs = longRangeSkdGRPVO.getVirVVDs()==null?new ActivationVvdVO[0]:longRangeSkdGRPVO.getVirVVDs();
			ActivationVvdVO[] bkgVirVVDs = longRangeSkdGRPVO.getBkgVirVVDs()==null?new ActivationVvdVO[0]:longRangeSkdGRPVO.getBkgVirVVDs();
			ActivationVvdVO[] bkgVOs = new ActivationVvdVO[bkgVVDs.length + virVVDs.length + bkgVirVVDs.length];
			
			int m = 0;
			for(int i=0; i<bkgVVDs.length; i++){
				bkgVOs[m] = new ActivationVvdVO();
				bkgVOs[m].setVslSlanCd(bkgVVDs[i].getVslSlanCd());
				bkgVOs[m].setVslCd(bkgVVDs[i].getVslCd());
				bkgVOs[m].setSkdVoyNo(bkgVVDs[i].getSkdVoyNo());
				bkgVOs[m].setSkdDirCd(bkgVVDs[i].getSkdDirCd());
				bkgVOs[m].setTurnSkdVoyNo(bkgVVDs[i].getSkdVoyNo());
				bkgVOs[m].setTurnSkdDirCd(bkgVVDs[i].getSkdDirCd());
				bkgVOs[m].setHisflag("VVD");
				bkgVOs[m].setCreUsrId(account.getUsr_id());
				bkgVOs[m].setUpdUsrId(account.getUsr_id());
				m++;
			}
			for(int i=0; i<virVVDs.length; i++){
				bkgVOs[m] = new ActivationVvdVO();
				bkgVOs[m].setVslSlanCd(virVVDs[i].getVslSlanCd());
				bkgVOs[m].setVslCd(virVVDs[i].getVslCd());
				bkgVOs[m].setSkdVoyNo(virVVDs[i].getSkdVoyNo());
				bkgVOs[m].setSkdDirCd(virVVDs[i].getSkdDirCd());
				bkgVOs[m].setTurnSkdVoyNo(virVVDs[i].getSkdVoyNo());
				bkgVOs[m].setTurnSkdDirCd(virVVDs[i].getSkdDirCd());
				bkgVOs[m].setHisflag("VIR");
				bkgVOs[m].setCreUsrId(account.getUsr_id());
				bkgVOs[m].setUpdUsrId(account.getUsr_id());
				m++;
			}
			for(int i=0; i<bkgVirVVDs.length; i++){
				bkgVOs[m] = new ActivationVvdVO();
				bkgVOs[m].setVslSlanCd(bkgVirVVDs[i].getVslSlanCd());
				bkgVOs[m].setVslCd(bkgVirVVDs[i].getVslCd());
				bkgVOs[m].setSkdVoyNo(bkgVirVVDs[i].getSkdVoyNo());
				bkgVOs[m].setSkdDirCd(bkgVirVVDs[i].getSkdDirCd());
				bkgVOs[m].setTurnSkdVoyNo(bkgVirVVDs[i].getSkdVoyNo());
				bkgVOs[m].setTurnSkdDirCd(bkgVirVVDs[i].getSkdDirCd());
				bkgVOs[m].setHisflag("ALL");
				bkgVOs[m].setCreUsrId(account.getUsr_id());
				bkgVOs[m].setUpdUsrId(account.getUsr_id());
				m++;
			}
			
			command.removeCstSkdByVvd(nonBkgVOs, bkgVOs, vskVslSkdHisVO, account);
			
//			// Actual Schedule을 삭제하고 Booking 모듈에 VVD 변경 공지를 전송한다.
//			List<VvdVO> vvdVOs = new ArrayList<VvdVO>();
//			List<VvdVO> turnVvdVOs = new ArrayList<VvdVO>();
////			List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs = new ArrayList<VslSkdCngNoticeVO>();
//			
//			if(nonBkgVOs.length!=0){
//				for(ActivationVvdVO activationVvdVO : nonBkgVOs){
//					VvdVO vo = new VvdVO();
//					vo.setVslSlanCd(activationVvdVO.getVslSlanCd());
//					vo.setVslCd(activationVvdVO.getVslCd());
//					vo.setSkdVoyNo(activationVvdVO.getSkdVoyNo());
//					vo.setSkdDirCd(activationVvdVO.getSkdDirCd());
//					vvdVOs.add(vo);
//					
//					// TURN 정보가 있으면 
//					if(activationVvdVO.getTurnSkdDirCd()!=null && activationVvdVO.getTurnSkdDirCd().length()!=0){
//						VvdVO turnVo = new VvdVO();
//						turnVo.setVslSlanCd(activationVvdVO.getVslSlanCd());
//						turnVo.setVslCd(activationVvdVO.getVslCd());
//						turnVo.setSkdVoyNo(activationVvdVO.getTurnSkdVoyNo());
//						turnVo.setSkdDirCd(activationVvdVO.getTurnSkdDirCd());
//						turnVvdVOs.add(turnVo);
//					}
//				}
//			}
//			
//			if(bkgVOs.length!=0){
//				for(ActivationVvdVO activationVvdVO : bkgVOs){
//					VvdVO vo = new VvdVO();
//					vo.setVslSlanCd(activationVvdVO.getVslSlanCd());
//					vo.setVslCd(activationVvdVO.getVslCd());
//					vo.setSkdVoyNo(activationVvdVO.getSkdVoyNo());
//					vo.setSkdDirCd(activationVvdVO.getSkdDirCd());
//					vvdVOs.add(vo);
//					
//					VslSkdCngNoticeVO noticeVO = new VslSkdCngNoticeVO();
//					noticeVO.setVslCd(activationVvdVO.getVslCd());
//					noticeVO.setSkdVoyNo(activationVvdVO.getSkdVoyNo());
//					noticeVO.setSkdDirCd(activationVvdVO.getSkdDirCd());
//					vslSkdCngNoticeVOs.add(noticeVO);
//					
//					// TURN 정보가 있으면 
//					if(activationVvdVO.getTurnSkdDirCd()!=null && activationVvdVO.getTurnSkdDirCd().length()!=0){
//						VvdVO turnVo = new VvdVO();
//						turnVo.setVslSlanCd(activationVvdVO.getVslSlanCd());
//						turnVo.setVslCd(activationVvdVO.getVslCd());
//						turnVo.setSkdVoyNo(activationVvdVO.getTurnSkdVoyNo());
//						turnVo.setSkdDirCd(activationVvdVO.getTurnSkdDirCd());
//						turnVvdVOs.add(turnVo);
//					}
//				}
//			}

//			actCommand.removeVskActPortSkd(vvdVOs);
//			bkgCommand.sendVslSkdCngNotice(vslSkdCngNoticeVOs);
			
			//--------------------------- VVD 정리 끝 ---------------------------
			
			
			//--------------------------- 신규 VVD 생성 시작 ---------------------------
			longRangeSkdGRPVO = command.createLongRngSkd(longRangeSkdGRPVO);
//			List<VskVslSkdVO> createdSkdVOs = longRangeSkdGRPVO.getVskVslSkdList(); // 생성된 VVD 목록
			
			//-------------------------- 외부인터페이스 대상 VO 작업 ---------------------------
			// 삭제된 VVD 목록 생성
//			List<VskVslSkdVO> vskVslSkdVOs = new ArrayList<VskVslSkdVO>();
//			for(VvdVO vvdVO : vvdVOs){
//				VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
//				vskVslSkdVO.setVslSlanCd(vvdVO.getVslSlanCd());
//				vskVslSkdVO.setVslCd(vvdVO.getVslCd());
//				vskVslSkdVO.setSkdVoyNo(vvdVO.getSkdVoyNo());
//				vskVslSkdVO.setSkdDirCd(vvdVO.getSkdDirCd());
//				vskVslSkdVOs.add(vskVslSkdVO);
//			}
//			for(VvdVO vvdVO : turnVvdVOs){
//				VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
//				vskVslSkdVO.setVslSlanCd(vvdVO.getVslSlanCd());
//				vskVslSkdVO.setVslCd(vvdVO.getVslCd());
//				vskVslSkdVO.setSkdVoyNo(vvdVO.getSkdVoyNo());
//				vskVslSkdVO.setSkdDirCd(vvdVO.getSkdDirCd());
//				vskVslSkdVOs.add(vskVslSkdVO);
//			}
			
			// 삭제된 VVD 목록 + 생성된 VVD 목록
//			vskVslSkdVOs.addAll(createdSkdVOs);
			
			//--------------------------- BKG BDR 전송 시작 ------------------------------
//			vvdVOs = new ArrayList<VvdVO>();
//			for(VskVslSkdVO vskVslSkdVO : vskVslSkdVOs){
//				VvdVO vvdVO = new VvdVO();
//				vvdVO.setVslSlanCd(vskVslSkdVO.getVslSlanCd());
//				vvdVO.setVslCd(vskVslSkdVO.getVslCd());
//				vvdVO.setSkdVoyNo(vskVslSkdVO.getSkdVoyNo());
//				vvdVO.setSkdDirCd(vskVslSkdVO.getSkdDirCd());
//				vvdVOs.add(vvdVO);
//			}
			
//			List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs = costalCommand.searchBkgBdrLog(vvdVOs);
//			sendBkgVvdBdrLog(bkgVvdBdrLogVOs);
			
			//--------------------------- ERP 전송 시작 ---------------------------
			// ERP에 전송
//			for(VskVslSkdVO vskVslSkdVO : vskVslSkdVOs){
//				vskVslSkdVO.setCreUsrId(account.getUsr_id());
//				vskVslSkdVO.setUpdUsrId(account.getUsr_id());
//			}
//			sendVslSkdErpIf(vskVslSkdVOs);
			
			//--------------------------- EDI 전송 시작 ---------------------------
			// EDI에는 생성된 VVD 목록만 전송한다.
//			vvdVOs = new ArrayList<VvdVO>();
//			for(VskVslSkdVO vskVslSkdVO : createdSkdVOs){
//				VvdVO vvdVO = new VvdVO();
//				vvdVO.setVslSlanCd(vskVslSkdVO.getVslSlanCd());
//				vvdVO.setVslCd(vskVslSkdVO.getVslCd());
//				vvdVO.setSkdVoyNo(vskVslSkdVO.getSkdVoyNo());
//				vvdVO.setSkdDirCd(vskVslSkdVO.getSkdDirCd());
//				// CHM-201006129-01
//				vvdVO.setCreUsrId(account.getUsr_id());
//				vvdVO.setUpdUsrId(account.getUsr_id());
//				vvdVOs.add(vvdVO);
//			}
//			costalCommand.sendEdiToDLS(vvdVOs); //EDI 전송 막음. 2010.04.06 유혁

			// 성공메시지
			// VSK10016 : 저장 작업이 성공했습니다.
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		}
		return eventResponse;

	}
	
//	/**
//	 * Booking VVD BDR Log 정보를 전송합니다.
//	 * 
//	 * @param List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs
//	 */
//	private void sendBkgVvdBdrLog(List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs){
//		if(bkgVvdBdrLogVOs != null && bkgVvdBdrLogVOs.size()>0){
//			BookingProcessMgtBC bkgPrsCmd = new BookingProcessMgtBCImpl();
//			for(BkgVvdBdrLogVO bkgVvdBdrLogVO : bkgVvdBdrLogVOs){
//				try{
//					bkgPrsCmd.manageBKGBDRLOGBackEndJob(bkgVvdBdrLogVO, account);
//				}catch(Exception ex){
//					// Exception 발생해도 업무는 그냥 진행되도록 처리(2010.06.07 Booking 에서 요청).
//					log.error(ex.getMessage());
//				}
//			}
//		}
//	}
	
//	/**
//	 * Long Range Creation에서 생성된 VVD를 ERP로 송신합니다.<br> 
//	 * 
//	 * @param List<VskVslSkdVO> vskVslSkdVOs
//	 * @throws EventException
//	 * @author Hyuk Ryu
//	 * @date 2009. 11. 4.
//	 */
//	private void sendVslSkdErpIf(List<VskVslSkdVO> vskVslSkdVOs) throws EventException {
//		try{
//			VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
//			List<VvdVO> erpVvdVOs = new ArrayList<VvdVO>();
//			for(VskVslSkdVO vskVslSkdVO : vskVslSkdVOs){
//				VvdVO vvdVO = new VvdVO();
////				vvdVO.setIbflag("I");
//				vvdVO.setVslSlanCd(vskVslSkdVO.getVslSlanCd());
//				vvdVO.setVslCd(vskVslSkdVO.getVslCd());
//				vvdVO.setSkdVoyNo(vskVslSkdVO.getSkdVoyNo());
//				vvdVO.setSkdDirCd(vskVslSkdVO.getSkdDirCd());
//				vvdVO.setCreUsrId(vskVslSkdVO.getCreUsrId());
//				vvdVO.setUpdUsrId(vskVslSkdVO.getUpdUsrId());
//				erpVvdVOs.add(vvdVO);
//			}
//			command.sendVslSkdErpIf(erpVvdVOs);
//		}catch(EventException ex){
//			throw ex;
//		}catch(Exception ex){
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
	/**
	 * VOP_VSK_0103 : Simulation
	 * Long Range SKD Schedule을 simulation 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Hyuk Ryu
	 */
	private EventResponse simulateLongRngSkd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0103Event event = (VopVsk0103Event)e;
		
//		ProformaScheduleMgtBC command1 = new ProformaScheduleMgtBCImpl();
		VesselScheduleMgtBC command2 = new VesselScheduleMgtBCImpl();
		
		LongRangeSkdGRPVO longRangeSkdGRPVO = event.getLongRangeSkdGRPVO();
//		List<PfSkdVO> pfSkdVOList = command1.searchPfSkd(
//				longRangeSkdGRPVO.getVslSlanCd(),
//				longRangeSkdGRPVO.getPfSvcTpCd(),
//				longRangeSkdGRPVO.getVslSvcTpCd());
		
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		if (e.getFormCommand().isCommand(FormCommand.SEARCH02) // Simulation
				|| e.getFormCommand().isCommand(FormCommand.SEARCH03)){  // Phase In

			List<LongRangeSkdVO> longRangeSkdVOList = command2.simulateLongRngSkd(longRangeSkdGRPVO);
			eventResponse.setRsVoList(longRangeSkdVOList);
			
			// simulation 거래는 아직 헤더에 대한 조작이 없는 최초의 상태이므로
			// P/F 만을 가지고 헤더를 생성한다.
				
			// 헤더정보
			StringBuilder headTitle1 = new StringBuilder(); // SKD_DIR_CD
			StringBuilder headTitle2 = new StringBuilder(); // VPS_PORT_CD
			StringBuilder headTitle3 = new StringBuilder(); // ETB_DY_CD/ETD_DY_CD
			StringBuilder headTitle4 = new StringBuilder(); // ETB_TM_HRMNT/ETD_TM_HRMNT
			StringBuilder headTitle5 = new StringBuilder(); // CLPT_SEQ
			StringBuilder headTitle6 = new StringBuilder(); // YARD_CD
			
			for(PfSkdVO vo : longRangeSkdGRPVO.getPfSkdVOs()){
				
				headTitle1.append("|").append(vo.getSkdDirCd()).append("|").append(vo.getSkdDirCd());
				headTitle2.append("|").append(vo.getPortCd()).append("|").append(vo.getPortCd());
				headTitle3.append("|").append(vo.getEtbDyCd()).append("|").append(vo.getEtdDyCd());
				headTitle4.append("|").append(vo.getEtbTmHrmnt().substring(0,2)).append("|").append(vo.getEtdTmHrmnt().substring(0,2));
				headTitle5.append("|").append(vo.getClptSeq()).append("|").append(vo.getClptSeq());
				headTitle6.append("|").append(vo.getYdCd()).append("|").append(vo.getYdCd());
				
			}
			
			eventResponse.setETCData("HeadTitle1", headTitle1.toString());
			eventResponse.setETCData("HeadTitle2", headTitle2.toString());
			eventResponse.setETCData("HeadTitle3", headTitle3.toString());
			eventResponse.setETCData("HeadTitle4", headTitle4.toString());
			eventResponse.setETCData("HeadTitle5", headTitle5.toString());
			eventResponse.setETCData("HeadTitle6", headTitle6.toString());
			
		}
//		else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) // phasein
//		{
//			
//			// phase in 될 vessel 정보 조회
////			List<PfSkdVO>phaseinPortSkdVOList = command1.searchPfSkd(longRangeSkdGRPVO.getVslSlanCd(), longRangeSkdGRPVO.getPfSvcTpCd(), longRangeSkdGRPVO.getVslSvcTpCd());
//			
//			PfSkdVO[] pfSkdVOS = longRangeSkdGRPVO.getPfSkdVOs();
//			List<String[]> phaseInVslInfo = new ArrayList<String[]>();
//			String[] phaseinVslInfo = new String[]{
//					longRangeSkdGRPVO.getPhaseinStartDate(),
//					longRangeSkdGRPVO.getPhaseinVslCd(),
//					longRangeSkdGRPVO.getPhaseinVoyNo()
//			};
//			phaseInVslInfo.add(phaseinVslInfo);
//
//			// PhaseIn 된 Vessel에 대한 스케쥴만 생성. 기존 Vessel 리스트는 백업
//			List<String[]> orgVslInfo = longRangeSkdGRPVO.getVslInfo();
//			longRangeSkdGRPVO.setVslInfo(phaseInVslInfo);
//			List<LongRangeSkdVO> phaseInVOList = command2.simulateLongRngSkd(longRangeSkdGRPVO);
//			
//			longRangeSkdGRPVO.setVslInfo(orgVslInfo);
//			
//			// 화면 스케쥴 정보 획득
//			
//			List<PfSkdVO> simHeaderPortList = loadSimHeaderPortList(longRangeSkdGRPVO);
////			List<LongRangeSkdVO> simDataList = loadSimDataList(simHeaderPortList, longRangeSkdGRPVO);
////			
////			// 화면스케쥴 상의 정보에서 phase in 되어 들어갈 위치에 데이터 삽입
////			int phaseinStartRow = findPhaseinRow(longRangeSkdGRPVO, simHeaderPortList, simDataList);
////			
////			List<List<LongRangeSkdVO>> skdSplitList = new ArrayList<List<LongRangeSkdVO>>();
////			List<List<LongRangeSkdVO>> phaseInSplitList = new ArrayList<List<LongRangeSkdVO>>();
////			List<List<LongRangeSkdVO>> finalList = new ArrayList<List<LongRangeSkdVO>>();
////			
////			int pos = 0;
////			for(int i=0; i<simDataList.size(); i++){
////				// split
////				if(simDataList.get(i).getVslCd()==null){
////					skdSplitList.add(simDataList.subList(pos, i));
////					pos = i+1;
////				}
////			}
////			
////			pos = 0;
////			for(int i=0; i<phaseInVOList.size(); i++){
////				// split
////				if(phaseInVOList.get(i).getVslCd()==null){
////					phaseInSplitList.add(phaseInVOList.subList(pos, i));
////					pos = i+1;
////				}
////			}
////			
////			// 최종 조합
////			
////			List<String[]> vslInfos = longRangeSkdGRPVO.getVslInfo();
////			int m = 0;
////			int k = 0;
////
////			while(m!=skdSplitList.size() || k!=phaseInSplitList.size()){
////				if(m<phaseinStartRow){
////					finalList.add(skdSplitList.get(m++));
////				}else{
////					if(k<phaseInSplitList.size()){
////						finalList.add(phaseInSplitList.get(k++));
////						finalList.add(phaseInSplitList.get(k++));
////						finalList.add(phaseInSplitList.get(k++));
////					}
////					for(int i=0; i<vslInfos.size()*3;i++){
////						if(m<skdSplitList.size()){
////							finalList.add(skdSplitList.get(m++));
////						}
////					}
////				}
////			}
////			
////			List<LongRangeSkdVO> skdList = new ArrayList<LongRangeSkdVO>();
////			
////			for(int i=0; i<finalList.size(); i++){
////				List<LongRangeSkdVO> list = finalList.get(i);
////				for(int j=0; j<list.size(); j++){
////					skdList.add(list.get(j));
////				}
////				skdList.add(new LongRangeSkdVO());
////			}
////			
////			eventResponse.setRsVoList(skdList);
//			
//			eventResponse.setETCData("HeadTitle1", longRangeSkdGRPVO.getHeadTitle1());
//			eventResponse.setETCData("HeadTitle2", longRangeSkdGRPVO.getHeadTitle2());
//			eventResponse.setETCData("HeadTitle3", longRangeSkdGRPVO.getHeadTitle3());
//			eventResponse.setETCData("HeadTitle4", longRangeSkdGRPVO.getHeadTitle4());
//			eventResponse.setETCData("HeadTitle5", longRangeSkdGRPVO.getHeadTitle5());
//			eventResponse.setETCData("HeadTitle6", longRangeSkdGRPVO.getHeadTitle6());
//			return eventResponse;
//			
//		}
		else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) // phasein cancel
		{
			// 화면 스케쥴 정보 획득
			
//			List<PfSkdVO> simHeaderPortList = loadSimHeaderPortList(longRangeSkdGRPVO);
//			List<LongRangeSkdVO> simDataList = loadSimDataList(simHeaderPortList, longRangeSkdGRPVO);
//			
//			eventResponse.setRsVoList(simDataList);
			
			eventResponse.setETCData("HeadTitle1", longRangeSkdGRPVO.getHeadTitle1());
			eventResponse.setETCData("HeadTitle2", longRangeSkdGRPVO.getHeadTitle2());
			eventResponse.setETCData("HeadTitle3", longRangeSkdGRPVO.getHeadTitle3());
			eventResponse.setETCData("HeadTitle4", longRangeSkdGRPVO.getHeadTitle4());
			eventResponse.setETCData("HeadTitle5", longRangeSkdGRPVO.getHeadTitle5());
			eventResponse.setETCData("HeadTitle6", longRangeSkdGRPVO.getHeadTitle6());
			return eventResponse;
			
		}
		else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) // add calling 
		{
			int addCallPos = Integer.parseInt(longRangeSkdGRPVO.getAddCallPoint());
			String addCallPosition = longRangeSkdGRPVO.getAddCallPosition();
			if("before".equals(addCallPosition)){
				addCallPos = addCallPos + 0; 
			}else if("after".equals(addCallPosition)){
				addCallPos = addCallPos + 1;
			}
			
//			int addVvdPos = Integer.parseInt(longRangeSkdGRPVO.getAddVvdPoint());
			String addPortCd = longRangeSkdGRPVO.getAddCallPortCd();
			String addYardCd = longRangeSkdGRPVO.getAddCallYardCd();
			
			// 헤더정보
			String headTitle1 = longRangeSkdGRPVO.getHeadTitle1();
			String headTitle2 = longRangeSkdGRPVO.getHeadTitle2();
			String headTitle3 = longRangeSkdGRPVO.getHeadTitle3();
			String headTitle4 = longRangeSkdGRPVO.getHeadTitle4();
			String headTitle5 = longRangeSkdGRPVO.getHeadTitle5();
			String headTitle6 = longRangeSkdGRPVO.getHeadTitle6();
			
			// 파이프라인(|)은 정규식에서는 특수문자 이므로
			// 일반문자로 인식시키기 위해 \\를 사용한다.
			String[] titles1 = headTitle1.split("\\|");
			String[] titles2 = headTitle2.split("\\|");
			String[] titles3 = headTitle3.split("\\|");
			String[] titles4 = headTitle4.split("\\|");
			String[] titles5 = headTitle5.split("\\|");
			String[] titles6 = headTitle6.split("\\|");
			
			if(!(
					(titles1.length==titles2.length)
					&& (titles2.length==titles3.length)
					&& (titles3.length==titles4.length)
					&& (titles4.length==titles1.length)
			))
			{
				// 헤더 길이가 다르면 오류
				//throw new EventException(new ErrorHandler("VSKXXXXX").getUserMessage());			
				throw new EventException("헤더길이가다름");
			}

			
			// 헤더정보조작
			StringBuilder sbHeadTitle1 = new StringBuilder();
			for(int i=1; i<titles1.length; i++){
				if(i==addCallPos*2-1){
					// Add Port를 시도한 방향을 그대로 유지한다. 예를 들어 W에서 Add Port했으면 W, E에서 Add Port 했으면 E이다.
					if("before".equals(addCallPosition)){
//						sbHeadTitle1.append("|").append(titles1[i+2]).append("|").append(titles1[i+2]); 
						sbHeadTitle1.append("|").append(titles1[i]).append("|").append(titles1[i]);
					}else if("after".equals(addCallPosition)){
						sbHeadTitle1.append("|").append(titles1[i-2]).append("|").append(titles1[i-2]);
					}
				}
				sbHeadTitle1.append("|").append(titles1[i]);
			}
			
			StringBuilder sbHeadTitle2 = new StringBuilder();
			for(int i=1; i<titles2.length; i++){
				if(i==addCallPos*2-1){
					sbHeadTitle2.append("|").append(addPortCd).append("|").append(addPortCd);
				}
				sbHeadTitle2.append("|").append(titles2[i]);
			}
			
			StringBuilder sbHeadTitle3 = new StringBuilder();
			for(int i=1; i<titles3.length; i++){
				if(i==addCallPos*2-1){
					sbHeadTitle3.append("|*|*");
				}
				sbHeadTitle3.append("|").append(titles3[i]);
			}
			
			StringBuilder sbHeadTitle4 = new StringBuilder();
			for(int i=1; i<titles4.length; i++){
				if(i==addCallPos*2-1){
					sbHeadTitle4.append("|*|*");
				}
				sbHeadTitle4.append("|").append(titles4[i]);
			}
			
			StringBuilder sbHeadTitle5 = new StringBuilder();
			for(int i=1; i<titles5.length; i++){
				if(i==addCallPos*2-1){
					sbHeadTitle5.append("|*|*");
				}
				sbHeadTitle5.append("|").append(titles5[i]);
			}
			
			StringBuilder sbHeadTitle6 = new StringBuilder();
			for(int i=1; i<titles6.length; i++){
				if(i==addCallPos*2-1){
					sbHeadTitle6.append("|").append(addYardCd).append("|").append(addYardCd);
				}
				sbHeadTitle6.append("|").append(titles6[i]);
			}
			
			if(titles1.length==addCallPos*2-1){
				sbHeadTitle1.append("|").append(titles1[titles1.length-1]).append("|").append(titles1[titles1.length-1]);
				sbHeadTitle2.append("|").append(addPortCd).append("|").append(addPortCd);
				sbHeadTitle3.append("|*|*");
				sbHeadTitle4.append("|*|*");
				sbHeadTitle5.append("|*|*");
				sbHeadTitle6.append("|").append(addYardCd).append("|").append(addYardCd);
			}
			
			List<LongRangeSkdVO> list = command2.simulateLongRngSkd(longRangeSkdGRPVO);
			eventResponse.setRsVoList(list);
			
			eventResponse.setETCData("HeadTitle1", sbHeadTitle1.toString());
			eventResponse.setETCData("HeadTitle2", sbHeadTitle2.toString());
			eventResponse.setETCData("HeadTitle3", sbHeadTitle3.toString());
			eventResponse.setETCData("HeadTitle4", sbHeadTitle4.toString());
			eventResponse.setETCData("HeadTitle5", sbHeadTitle5.toString());
			eventResponse.setETCData("HeadTitle6", sbHeadTitle6.toString());
			return eventResponse;
			
		}
		else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) // add calling cancel
		{
			int addCallPos = Integer.parseInt(longRangeSkdGRPVO.getAddCallPoint());
//			String addCallPosition = longRangeSkdGRPVO.getAddCallPosition();
//			if("before".equals(addCallPosition)){
//				addCallPos = addCallPos + 0; 
//			}else if("after".equals(addCallPosition)){
//				addCallPos = addCallPos + 1;
//			}
			
//			int addVvdPos = Integer.parseInt(longRangeSkdGRPVO.getAddVvdPoint());
			
			// 화면 스케쥴 정보 획득
			List<PfSkdVO> simHeaderPortList = loadSimHeaderPortList(longRangeSkdGRPVO);
//			List<LongRangeSkdVO> simDataList = loadSimDataList(simHeaderPortList, longRangeSkdGRPVO, addCallPos, addVvdPos, null, true);
			List<LongRangeSkdVO> list = command2.simulateLongRngSkd(longRangeSkdGRPVO);
			
			StringBuilder headTitle1 = new StringBuilder();
			StringBuilder headTitle2 = new StringBuilder();
			StringBuilder headTitle3 = new StringBuilder();
			StringBuilder headTitle4 = new StringBuilder();
			StringBuilder headTitle5 = new StringBuilder();
			StringBuilder headTitle6 = new StringBuilder();
			
			// 헤더정보조작
			for(int i=0; i<simHeaderPortList.size(); i++){
				if(i==addCallPos-1){
					continue;
				}
				headTitle1.append("|").append(simHeaderPortList.get(i).getSkdDirCd()).append("|").append(simHeaderPortList.get(i).getSkdDirCd());
				headTitle2.append("|").append(simHeaderPortList.get(i).getPortCd()).append("|").append(simHeaderPortList.get(i).getPortCd());
				headTitle3.append("|").append(simHeaderPortList.get(i).getEtbDyCd()).append("|").append(simHeaderPortList.get(i).getEtdDyCd());
				headTitle4.append("|").append(simHeaderPortList.get(i).getEtbTmHrmnt()).append("|").append(simHeaderPortList.get(i).getEtdTmHrmnt());
				headTitle5.append("|").append(simHeaderPortList.get(i).getClptSeq()).append("|").append(simHeaderPortList.get(i).getClptSeq());
				headTitle6.append("|").append(simHeaderPortList.get(i).getYdCd()).append("|").append(simHeaderPortList.get(i).getYdCd());
			}
			
			eventResponse.setRsVoList(list);
			
			eventResponse.setETCData("HeadTitle1", headTitle1.toString());
			eventResponse.setETCData("HeadTitle2", headTitle2.toString());
			eventResponse.setETCData("HeadTitle3", headTitle3.toString());
			eventResponse.setETCData("HeadTitle4", headTitle4.toString());
			eventResponse.setETCData("HeadTitle5", headTitle5.toString());
			eventResponse.setETCData("HeadTitle6", headTitle6.toString());
			return eventResponse;
		}
		
		
		return eventResponse;
	}
	
	
	private List<PfSkdVO> loadSimHeaderPortList(LongRangeSkdGRPVO grpvo) throws EventException {
		
		// 헤더정보
		String headTitle1 = grpvo.getHeadTitle1();
		String headTitle2 = grpvo.getHeadTitle2();
		String headTitle3 = grpvo.getHeadTitle3();
		String headTitle4 = grpvo.getHeadTitle4();
		String headTitle5 = grpvo.getHeadTitle5();
		String headTitle6 = grpvo.getHeadTitle6();
		
		// 파이프라인(|)은 정규식에서는 특수문자 이므로
		// 일반문자로 인식시키기 위해 \\를 사용한다.
		String[] titles1 = headTitle1.split("\\|");
		String[] titles2 = headTitle2.split("\\|");
		String[] titles3 = headTitle3.split("\\|");
		String[] titles4 = headTitle4.split("\\|");
		String[] titles5 = headTitle5.split("\\|");
		String[] titles6 = headTitle6.split("\\|");
		
		if(!(
				(titles1.length==titles2.length)
				&& (titles2.length==titles3.length)
				&& (titles3.length==titles4.length)
				&& (titles4.length==titles1.length)
		))
		{
			// 헤더 길이가 다르면 오류
			//throw new EventException(new ErrorHandler("VSKXXXXX").getUserMessage());			
			throw new EventException("헤더길이가다름");
		}
		
		// 헤더정보로 포트스케쥴리스트 구성
		List<PfSkdVO> headerPortList = new ArrayList<PfSkdVO>();
		
		for(int i=1; i<titles1.length; i=i+2){
			
			PfSkdVO portSkdVO = new PfSkdVO();
			portSkdVO.setPortCd(titles2[i]);
			portSkdVO.setEtbDyCd(titles3[i]);
			portSkdVO.setEtdDyCd(titles3[i+1]);
			portSkdVO.setEtbTmHrmnt(titles4[i]);
			portSkdVO.setEtdTmHrmnt(titles4[i+1]);
			portSkdVO.setSkdDirCd(titles1[i]);
			portSkdVO.setClptSeq(titles5[i]);
			portSkdVO.setYdCd(titles6[i]);
			
			headerPortList.add(portSkdVO);
			
		}
		
		return headerPortList;
		
	}
	

	/**
	 * VOP_VSK_0105, VOP_VSK_0107 : Retrieve
	 * 
	 * VVD에 대한 Costal Schedule을 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSkdByVvd(Event e) throws EventException {
		CstSkdByVvdVO paramVO = null;
		PfLaneTypeVO pfLaneTypeVO = new PfLaneTypeVO();
		String vslSlanCd = "";
		String vslSvcTpCd = "";
		String pfSkdTpCd = "";
		String skdRmk = "";
		String bookChk = "";
		
		boolean chkFlag = false;	//Booking, Actual Check.
		
		if(e instanceof VopVsk0107Event){
			VopVsk0107Event event = (VopVsk0107Event)e;
			paramVO = event.getCstSkdByVvdVO();
			paramVO.setVslSlanCd("");
		}else if(e instanceof VopVsk0105Event){
			VopVsk0105Event event = (VopVsk0105Event)e;
			paramVO = event.getCstSkdByVvdVO();
			chkFlag = true;
		}
		
		VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
//		VSKCodeFinderBC codeCommand = new VSKCodeFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<CstSkdByVvdVO> list = null;
		
		if(e instanceof VopVsk0105Event){
			if(chkFlag){
//				int chkCnt = 0;
				
				VvdVO vvdVO = new VvdVO();
				vvdVO.setVslCd(paramVO.getVslCd());
				vvdVO.setSkdVoyNo(paramVO.getSkdVoyNo());
				vvdVO.setSkdDirCd(paramVO.getSkdDirCd());
				
				String chkStr = command.checkReuseVvd(vvdVO);
				if("Y".equals(chkStr)){
					/*
					 * MSG - 2008년 이전 이행 VVD중에 재무 VVD로 사용하고 있을 경우.
					 */
					throw new EventException(new ErrorHandler("VSK10002").getMessage());
				}else{
//					chkCnt = command.checkVvdApplyBooking(vvdVO);
//					if(chkCnt > 0){
						/*
						 * MSG - 이미 Book시스템 해당 VVD를 사용하고 있습니다. Coastal Simulation 화면을 사용해 주세요.
						 */
//						throw new EventException(new ErrorHandler("VSK10029").getMessage());
//						bookChk = "X";
//					}else{
//						chkCnt = command.checkVvdActualSkdInput(vvdVO);
//						if(chkCnt > 0){
							/*
							 * MSG - Actual Schedule 정보가 입력되였습니다. Coastal Simulation 화면을 사용해 주세요.
							 */
//							throw new EventException(new ErrorHandler("VSK10030").getMessage());
//							bookChk = "A";
//						}
//					}
				}
			}
		}

		list = command.searchCstSkdByVvd(paramVO);
		List<PfLaneTypeVO> pfLaneTypeVOList = null;
		
		if(list != null && list.size()>0){
//			if(e instanceof VopVsk0105Event){
//				// ************** Turnning Port 의 Booking 정보 확인 START **************
//				int cnt = list.size();
//				for(int i=0; i<cnt; i++){
//					CstSkdByVvdVO rtnVO = list.get(i);
//					if("Y".equals(rtnVO.getTurnPortFlg())){
//						VvdVO vvdVO = new VvdVO();
//						vvdVO.setVslCd(rtnVO.getVslCd());
//						vvdVO.setSkdVoyNo(rtnVO.getTurnSkdVoyNo());
//						vvdVO.setSkdDirCd(rtnVO.getTurnSkdDirCd());
//						
////						int chkCnt = command.checkVvdApplyBooking(vvdVO);
////						if(chkCnt > 0){
//							/*
//							 * MSG - 이미 Book시스템 해당 VVD를 사용하고 있습니다. Coastal Simulation 화면을 사용해 주세요.
//							 */
////							throw new EventException(new ErrorHandler("VSK10029").getMessage());
////							bookChk = "X";
////						}
//						
//						break;
//					}
//				}
//				// ************** Turnning Port 의 Booking 정보 확인 END **************
//			}
			
			StringBuilder sb = new StringBuilder();
			
			CstSkdByVvdVO vo = list.get(0);
			vslSlanCd = vo.getVslSlanCd();
			pfSkdTpCd = vo.getPfSkdTpCd();
			skdRmk = vo.getSkdRmk();
			
			sb.append(vo.getTmlCd());
			for (int i = 1; i < list.size(); i++) {
				sb.append("|");
				sb.append(list.get(i).getTmlCd());
			}
			
			StringBuilder sb2 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();
			
			pfLaneTypeVO.setVslSlanCd(vslSlanCd);
			
			pfLaneTypeVOList = command.searchPfLaneTypeList(pfLaneTypeVO);

			if(pfLaneTypeVOList != null && pfLaneTypeVOList.size() > 0){
				sb2.append(pfLaneTypeVOList.get(0).getPfSvcTpCd());
				sb3.append(pfLaneTypeVOList.get(0).getSlanStndFlg());

				vslSvcTpCd = pfLaneTypeVOList.get(0).getVslSvcTpCd();
				
				for (int i = 1; i < pfLaneTypeVOList.size(); i++) {
					sb2.append("|");
					sb2.append(pfLaneTypeVOList.get(i).getPfSvcTpCd());
					
					sb3.append("|");
					sb3.append(pfLaneTypeVOList.get(i).getSlanStndFlg());
				}
			}

			eventResponse.setETCData("booking_chk", bookChk);
			eventResponse.setETCData("tml_cd", sb.toString());
			eventResponse.setETCData("vsl_slan_cd", vslSlanCd);
			eventResponse.setETCData("pf_skd_tp_cd", pfSkdTpCd);
			eventResponse.setETCData("vsl_svc_tp_cd", vslSvcTpCd);
			eventResponse.setETCData("skd_rmk", skdRmk.trim());
			eventResponse.setETCData("pf_svc_type_list", sb2.toString());
			eventResponse.setETCData("slan_stnd_flag_list", sb3.toString());
			eventResponse.setETCData("slan_stnd_flag_list", sb3.toString());
			eventResponse.setETCData("call_ind_cd", VSKGeneralUtil.comnCodeList("CD00976", "onlycode"));
			eventResponse.setETCData("call_ind_nm", VSKGeneralUtil.comnCodeList("CD00976", "onlyname"));
		}
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0101, VOP_VSK_0105 : Yard Code Focus<br>
	 * 입력 받은 Port[Location] Code에 대한 등록된 Yard 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardListByPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<YardVO> list = null;
		YardVO yardVO = null;
		String chkPort = null;
		
		if(e instanceof VopVsk0105Event){
			VopVsk0105Event event = (VopVsk0105Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0101Event){
			VopVsk0101Event event = (VopVsk0101Event)e;
			yardVO = event.getYardVO();
		}
		
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		
		if (yardVO != null) {
			chkPort = command.checkPort(yardVO.getLocCd());
		}
		
		if(chkPort != null && !"".equals(chkPort)){				
			list = command.searchYardListByPort(yardVO);
			
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
	
			if(list != null && list.size() > 0){
				if(e instanceof VopVsk0101Event){
					sb.append(" ");
					sb1.append(" ");
					sb2.append(" ");
					for (int i = 0; i < list.size(); i++) {
						sb.append("|");
						sb1.append("|");
						sb2.append("|");
						sb.append(list.get(i).getYdKind());
						sb1.append(list.get(i).getYdCd());
						sb2.append(list.get(i).getYdNm());
					}
				}else{
					sb.append(list.get(0).getYdKind());
					sb1.append(list.get(0).getYdCd());
					sb2.append(list.get(0).getYdNm());
					for (int i = 1; i < list.size(); i++) {
						sb.append("|");
						sb1.append("|");
						sb2.append("|");
						sb.append(list.get(i).getYdKind());
						sb1.append(list.get(i).getYdCd());
						sb2.append(list.get(i).getYdNm());
					}
				}
			}
			
			eventResponse.setETCData("yd_kind", sb.toString());
			eventResponse.setETCData("yd_cd", sb1.toString());
			eventResponse.setETCData("yd_nm", sb2.toString());
		}else{			
			eventResponse.setETCData("yd_kind", "");
			eventResponse.setETCData("yd_cd", "");
			eventResponse.setETCData("yd_nm", "");
		}

		eventResponse.setETCData("check_port", chkPort);
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}

	
	/**
	 * VOP_VSK_0105 : Vsl Slan Cd Button Click<br>
	 * 입력 받은 Lane Code로 생성된 PF SKD Type 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPfLaneTypeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PfLaneTypeVO pfLaneTypeVO = null;
		
		VopVsk0105Event event = (VopVsk0105Event)e;
		pfLaneTypeVO = event.getPfLaneTypeVO();
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		VesselScheduleMgtBC skdcommand = new VesselScheduleMgtBCImpl();
		
		MdmVslSvcLaneVO mdmVslSvcLaneVO = new MdmVslSvcLaneVO();
		mdmVslSvcLaneVO.setVslSlanCd(pfLaneTypeVO.getVslSlanCd());
		List<MdmVslSvcLaneVO> chkList = command.checkSvcLane(mdmVslSvcLaneVO);
		
		if(chkList != null && chkList.size() > 0){
			//0057일 경우 Feeder 만 조회 가능하도록.
			MdmVslSvcLaneVO chkSvcTpVO = chkList.get(0);
			String svcTpCd = chkSvcTpVO.getVslSvcTpCd();
			
			eventResponse.setETCData("svc_tp_cd", svcTpCd);
		}else{
			/*
			 * MSG - Service Lane Code가 등록되여 있지 않을 경우에 표시.
			 */
			throw new EventException(new ErrorHandler("VSK10019").getMessage());
		}
		
		List<PfLaneTypeVO> list = skdcommand.searchPfLaneTypeList(pfLaneTypeVO);
		
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		
		if(list != null && list.size() > 0){
			sb2.append(list.get(0).getPfSvcTpCd());
			sb3.append(list.get(0).getSlanStndFlg());
			
			for (int i = 1; i < list.size(); i++) {
				sb2.append("|");
				sb2.append(list.get(i).getPfSvcTpCd());
				
				sb3.append("|");
				sb3.append(list.get(i).getSlanStndFlg());
			}
		}

		eventResponse.setETCData("pf_svc_type_list", sb2.toString());
		eventResponse.setETCData("slan_stnd_flag_list", sb3.toString());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0105 : VVD Search Button Click<br>
	 * 입력받은 Proforma Schedule에 Service Lane Code, Type, Direction, Port을 이용하여 Coastal Schedule를 작성하기 위해 ETA, ETB, ETD을 반환한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSkdByPfSkdUse(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CstSkdByVvdVO paramVO = null;
		
		VopVsk0105Event event = (VopVsk0105Event)e;
		paramVO = event.getCstSkdByVvdVO();
		
		VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
//		VSKCodeFinderBC codeCommand = new VSKCodeFinderBCImpl();

		List<CstSkdByVvdVO> list = command.searchCstSkdByPfSkdUse(paramVO);
		
		PfLaneTypeVO pfLaneTypeVO = new PfLaneTypeVO();
		pfLaneTypeVO.setVslSlanCd(paramVO.getVslSlanCd());
		List<PfLaneTypeVO> pfLaneTypeVOList = command.searchPfLaneTypeList(pfLaneTypeVO);
		
		eventResponse.setETCData("vsl_svc_tp_cd", getVslSvcTpCd(paramVO.getVslSlanCd()));
		
		if(list != null && list.size()>0){
			StringBuilder sb = new StringBuilder();
			
			sb.append(list.get(0).getTmlCd());
			
			for (int i = 1; i < list.size(); i++) {
				sb.append("|");
				sb.append(list.get(i).getTmlCd());
			}

			eventResponse.setETCData("tml_cd", sb.toString());
		}
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		if(pfLaneTypeVOList != null && pfLaneTypeVOList.size()>0){
			if(pfLaneTypeVOList != null && pfLaneTypeVOList.size() > 0){
				sb.append(pfLaneTypeVOList.get(0).getPfSvcTpCd());
				sb2.append(pfLaneTypeVOList.get(0).getSlanStndFlg());
				
				for (int i = 1; i < pfLaneTypeVOList.size(); i++) {
					sb.append("|");
					sb2.append("|");
					sb.append(pfLaneTypeVOList.get(i).getPfSvcTpCd());
					sb2.append(pfLaneTypeVOList.get(i).getSlanStndFlg());
				}
			}
		}
		eventResponse.setETCData("pf_svc_type_list", sb.toString());
		eventResponse.setETCData("slan_stnd_flag_list", sb2.toString());
		eventResponse.setETCData("call_ind_cd", VSKGeneralUtil.comnCodeList("CD00976", "onlycode"));
		eventResponse.setETCData("call_ind_nm", VSKGeneralUtil.comnCodeList("CD00976", "onlyname"));
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	

	private String getVslSvcTpCd(String vslSlanCd) throws EventException{
		String vslSvcTpCd = "";
		
		PfLaneTypeVO pfLaneTypeVO = new PfLaneTypeVO();
		pfLaneTypeVO.setVslSlanCd(vslSlanCd);
		
		VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
//		VSKCodeFinderBC codeCommand = new VSKCodeFinderBCImpl();
		List<PfLaneTypeVO> pfLaneTypeVOList = command.searchPfLaneTypeList(pfLaneTypeVO);
		
		if(pfLaneTypeVOList != null && pfLaneTypeVOList.size() > 0){
			vslSvcTpCd = pfLaneTypeVOList.get(0).getVslSvcTpCd();
		}
		
		return vslSvcTpCd;
	}
	
	/**
	 * VOP_VSK_0105 : Open<br>
	 * Direction 정보를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDirectionList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("direction_cd", VSKGeneralUtil.comnCodeList("CD00593", "onlycode"));
		return eventResponse;
	}

	
	/**
	 * VOP_VSK_0105 : Save<br>
	 * 입력받은 Vessel Port Schedule 정보를 등록 및 변경한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstSkdByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CstSkdByVvdVO paramVO = null;
		CstSkdByVvdVO[] paramVOs = null;
		SwapCstSkdSimVO swapCstSkdSimVO = null;
		
		VopVsk0105Event event = (VopVsk0105Event)e;
		paramVO = event.getCstSkdByVvdVO();
		paramVOs = event.getCstSkdByVvdVOS();
			
		if(paramVO != null && paramVOs != null){
			if(paramVOs.length > 0){
				for(int i=0; i<paramVOs.length; i++){
//					paramVOs[i].setVslCd(paramVO.getVslCd());
//					paramVOs[i].setSkdVoyNo(paramVO.getSkdVoyNo());
//					paramVOs[i].setSkdDirCd(paramVO.getSkdDirCd());
					paramVOs[i].setVslSlanCd(paramVO.getVslSlanCd());
					paramVOs[i].setSlanCd(paramVO.getVslSlanCd());
					paramVOs[i].setPfSvcTpCd(paramVO.getPfSvcTpCd());
					paramVOs[i].setSkdRmk(paramVO.getSkdRmk());
				}
			}
		}

		VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		
		try{	
			begin();
			
			VvdVO vvdVO = new VvdVO();
			if(paramVO != null){
				vvdVO.setVslCd(paramVO.getVslCd());
				vvdVO.setSkdVoyNo(paramVO.getSkdVoyNo());
				vvdVO.setSkdDirCd(paramVO.getSkdDirCd());
			}else if(swapCstSkdSimVO != null){
				vvdVO.setVslCd(swapCstSkdSimVO.getVslCd());
				vvdVO.setSkdVoyNo(swapCstSkdSimVO.getSkdVoyNo());
				vvdVO.setSkdDirCd(swapCstSkdSimVO.getSkdDirCd());
			}
			
			String chkStr = command.checkReuseVvd(vvdVO);
			if("Y".equals(chkStr)){
				/*
				 * MSG - 2008년 이전 이행 VVD중에 재무 VVD로 사용하고 있을 경우.
				 */
				throw new EventException(new ErrorHandler("VSK10002").getMessage());
			}
//			VslSkdChgStsGRPVO vslSkdChgStsGRPVO = 
				command.manageCstSkdByVvd(paramVOs, account);
			
			//Booking 에 변경된 스케줄 전송.
//			sendBkgByVslSkdChg(vslSkdChgStsGRPVO);
			
			//COP 에 변경된 스케줄 전송.
//			sendCopByVslSkdChg(vslSkdChgStsGRPVO);
			
			//EDI 전송
//			if(vslSkdChgStsGRPVO.getEdiVvdVOs() != null && vslSkdChgStsGRPVO.getEdiVvdVOs().size() > 0){
//				command.sendEdiToDLS(vslSkdChgStsGRPVO.getEdiVvdVOs());
//			}

			//ERP 전송
//			if(vslSkdChgStsGRPVO.getErpVvdVOs() != null && vslSkdChgStsGRPVO.getErpVvdVOs().size() > 0){
//				for(VvdVO vo : vslSkdChgStsGRPVO.getErpVvdVOs()){
//					if(account==null){
//						vo.setCreUsrId(paramVOs[0].getUpdUsrId());
//						vo.setUpdUsrId(paramVOs[0].getUpdUsrId());
//					}else{
//						vo.setCreUsrId(account.getUsr_id());
//						vo.setUpdUsrId(account.getUsr_id());
//					}
//				}
//				command.sendVslSkdErpIf(vslSkdChgStsGRPVO.getErpVvdVOs());
//			}
			
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
	
//	/**
//	 * manageCstSkdByVvd, manageCstSkdBerthWdo : Call
//	 * Schedule 이 변경되면 Booking 에 해당 내용을 전송한다.
//	 * 
//	 * @param VslSkdChgStsGRPVO vslSkdCngStsGRPVO
//	 * @throws EventException
//	 */
//	private void sendBkgByVslSkdChg(VslSkdChgStsGRPVO vslSkdChgStsGRPVO) throws EventException {
//		GeneralBookingSplitCombineBC bkgScbCmd = new GeneralBookingSplitCombineBCImpl();
//		GeneralBookingReceiptBC bkgRctCmd = new GeneralBookingReceiptBCImpl();
//		
//		log.debug("=================== Booking START ===================");
//		List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs = vslSkdChgStsGRPVO.getVslSkdCngNoticeVOs();
//		if(vslSkdCngNoticeVOs != null && vslSkdCngNoticeVOs.size()>0){
//			try{
//				bkgScbCmd.sendVslSkdCngNotice(vslSkdCngNoticeVOs);
//			}catch(Exception ex){
//				throw new EventException(new ErrorHandler("VSK10045").getMessage());
//			}
//		}
//		
//		List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs = vslSkdChgStsGRPVO.getVslSkdCngUpdateVOs();
//		if(vslSkdCngUpdateVOs != null && vslSkdCngUpdateVOs.size()>0){
//			try{
//				bkgRctCmd.modifyBkgVvdForVslSkdCng(vslSkdCngUpdateVOs, account);
//			}catch(Exception ex){
//				throw new EventException(new ErrorHandler("VSK10047").getMessage());
//			}
//		}
//		
////		List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs = vslSkdChgStsGRPVO.getBkgVvdBdrLogVOs();
////		if(bkgVvdBdrLogVOs != null && bkgVvdBdrLogVOs.size()>0){
////			try{
////				for(BkgVvdBdrLogVO bkgVvdBdrLogVO : bkgVvdBdrLogVOs){
////					bkgPrsCmd.manageBKGBDRLOG(bkgVvdBdrLogVO, account);
////				}
////			}catch(Exception ex){
////				throw new EventException(new ErrorHandler("VSK10014").getMessage());
////			}
////		}
//		
//		List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs = vslSkdChgStsGRPVO.getBkgVvdBdrLogVOs();
//		sendBkgVvdBdrLog(bkgVvdBdrLogVOs);
//		
//		log.debug("=================== Booking END ===================");
//	}
	
//	/**
//	 * manageCstSkdByVvd, manageCstSkdBerthWdo : Call
//	 * Schedule 이 변경되면 COP 에 해당 내용을 전송한다.
//	 * 
//	 * @param vslSkdChgStsGRPVO vslSkdCngStsGRPVO
//	 * @throws EventException
//	 */
//	private void sendCopByVslSkdChg(VslSkdChgStsGRPVO vslSkdChgStsGRPVO) throws EventException {
//		CopDetailReceiveBC command = new CopDetailReceiveBCImpl();
//		
//		log.debug("=================== COP START ===================");
//		List<SceActRcvIfVO> sceActRcvIfVOs = vslSkdChgStsGRPVO.getSceActRcvIfVOs();
//		if(sceActRcvIfVOs != null && sceActRcvIfVOs.size()>0){
//			try{
//				log.debug(">>> Notice Size : " + sceActRcvIfVOs.size());
//				for(SceActRcvIfVO sceActRcvIfVO : sceActRcvIfVOs){
//					command.sendVslSkdSceIf(sceActRcvIfVO);
//				}
//			}catch(Exception ex){
//				/*
//				 * MSG - SCE 시스템과 통신 중 에러가 발생했습니다.
//				 */
//				throw new EventException(new ErrorHandler("VSK10051").getMessage());
//			}
//		}
//		log.debug("=================== COP END ===================");
//	}
	
	/**
	 * VOP_VSK_0105 : Save<br>
	 * Remark를 저장합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstSkdByRmk(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		CstSkdByVvdVO paramVO = null;
		
		VopVsk0105Event event = (VopVsk0105Event)e;
		paramVO = event.getCstSkdByVvdVO();
		
		try{
			begin();
			command.manageCstSkdByRmk(paramVO, account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	

	
	/**
	 * VOP_VSK_0104 : Retrieve
	 * VOP_VSK_0106 : 
	 * 
	 * Service Lane 리스트 정보를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcLaneList(Event e) throws EventException {
		MdmVslSvcLaneVO vo = null;
		if(e instanceof VopVsk0104Event){
			VopVsk0104Event event = (VopVsk0104Event)e;
			vo = new MdmVslSvcLaneVO();
			vo.setVslSlanCd(event.getPortSkdOnLongRangeVO().getVslSlanCd());
		}else if(e instanceof VopVsk0106Event){
			VopVsk0106Event event = (VopVsk0106Event)e;
			vo = new MdmVslSvcLaneVO();
			vo.setVslSlanCd(event.getActivationVvdVO().getVslSlanCd());
		}
		
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		List<MdmVslSvcLaneVO> list = command.searchSvcLaneList(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		if(list!=null && list.size()==1){
			
			if(e instanceof VopVsk0106Event){
				eventResponse.setETCData("vsl_slan_nm", list.get(0).getVslSlanNm());
			}else{
				eventResponse.setETCData("vsl_slan_nm", list.get(0).getVslSlanNm());
			}
		}
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0105, VOP_VSK_0107, VOP_VSK_0113 : Vessel Code Change<br>
	 * MDM_VSL_CNTR 에 Vessel Code가 존재하는지 확인한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVslCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		VvdVO paramVO = null;
		VesselVO vesselVO = null;
		
		if(e instanceof VopVsk0105Event){
			VopVsk0105Event event = (VopVsk0105Event)e;
			paramVO = event.getVvdVO();
		}else if(e instanceof VopVsk0107Event){
			VopVsk0107Event event = (VopVsk0107Event)e;
			paramVO = event.getVvdVO();
		}else if(e instanceof VopVsk0113Event){ //2014.07.15 추가 이용준
			VopVsk0113Event event = (VopVsk0113Event)e;
			paramVO = event.getVvdVO();
		}
		
		int chkCnt = 0;
			
		if (paramVO != null) {
			if(paramVO.getVslCd() == null){
				log.debug("paramVO.getVslCd() == null");
	//			throw new EventException(new ErrorHandler("VSK10028").getMessage());
			}else{
				vesselVO = new VesselVO();
				vesselVO.setVslCd(paramVO.getVslCd());
				vesselVO.setIncDelVsl(paramVO.getIncDelVsl());
				chkCnt = command.checkVslCntr(vesselVO);
			}
		}
		
		if(chkCnt > 0){
			eventResponse.setETCData("vsl_chk", "Y");
		}else{
			eventResponse.setETCData("vsl_chk", "N");
			/*
			 * MSG - Vessel Code가 존재하지 않습니다. MDM 시스템에서 Vessel Code를 등록해 주세요.
			 */
			throw new EventException(new ErrorHandler("VSK10028").getMessage());
		}
		
		return eventResponse;
	}
	
	
	/**
	 * VOP_VSK_0105 : Direction Code Change<br>
	 * 등록된 LANE CODE, DIRECTION이 있는지 확인한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSvcLaneDir(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		MdmVslSvcLaneDirVO paramVO = null;
		
		VopVsk0105Event event = (VopVsk0105Event)e;
		paramVO = event.getMdmVslSvcLaneDirVO();
		
		int laneCnt = command.checkSvcLaneDir(paramVO);
		
		if(laneCnt > 0){
			eventResponse.setETCData("lane_chk", "Y");
		}else{
			eventResponse.setETCData("lane_chk", "N");
		}

		return eventResponse;
	}
	
	
	/**
	 * VOP_VSK_0101 : M/Calculation<br>
	 * P/F Schedule 을 Manual로 계산합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calPfSkdManual(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PfSkdGRPVO grpVO = null;
		List<VskPfSkdDtlVO> vskPfSkdDtlVOs = null;
		
		try{
			VopVsk0101Event event = (VopVsk0101Event)e;
			grpVO = event.getPfSkdGRPVO();
			vskPfSkdDtlVOs = grpVO.getVskPfSkdDtlVOs();
			VskPfSkdDtlVO vskPfSkdDtlVO = vskPfSkdDtlVOs.get(0);
			vskPfSkdDtlVO.setEventNav("A");
			vskPfSkdDtlVOs.set(0, vskPfSkdDtlVO);			
			grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
			
			ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
			PfSkdGRPVO pfSkdGRPVO = command.calPfSkdManual(grpVO);
			
			VskPfSkdVO masterVO = pfSkdGRPVO.getVskPfSkdVO();
			List<VskPfSkdDtlVO> detailVOs  = pfSkdGRPVO.getVskPfSkdDtlVOs();
	
			StringBuffer sb = new StringBuffer();
			StringBuffer sb2 = new StringBuffer();
			StringBuffer sb3 = new StringBuffer();
			
			if(detailVOs.size() > 0 && detailVOs != null){
				sb.append(detailVOs.get(0).getYdCd());
				for(int i=1; i<detailVOs.size(); i++){
					sb.append("|");
					sb.append(detailVOs.get(i).getYdCd());
				}
				
				sb2.append(detailVOs.get(0).getTotMaxSpd());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getTotAvgSpd());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getBufSpd());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getTotBufRat());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getSeaBufRat());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getPortBufRat());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getPfSpdRat());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getBufSpdRat());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getMinMaxSpd());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getVslSvcTpCd());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getCheckVslSkd());
				
				sb3.append(detailVOs.get(0).getCurrPos());
			}
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVo(masterVO);
			eventResponse.setRsVoList(detailVOs);
			eventResponse.setETCData("ydCd", sb.toString());
			eventResponse.setETCData("etcdt", sb2.toString());
			eventResponse.setETCData("currPos", sb3.toString());
			eventResponse.setUserMessage(new ErrorHandler("VSK09001").getUserMessage());
			return eventResponse;
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * VOP_VSK_0101 : Save<br>
	 * P/F Simulation 정보를 생성합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createRqstSimScnrCfm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PfSkdGRPVO grpVO = null;

		VopVsk0101Event event = (VopVsk0101Event)e;
		grpVO = event.getPfSkdGRPVO();
		List<VskPfSkdDtlVO> vskPfSkdDtlVOs = grpVO.getVskPfSkdDtlVOs();
		vskPfSkdDtlVOs.get(0).setPfSkdStsCd("B");
		vskPfSkdDtlVOs.get(0).setUiEvent("0003");
		grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
		
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		
		try{
			begin();
			command.confirmSimScnr(grpVO, account);
			//VSK 저장 성공 메시지가 없기에 임시로 대체  
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();		
			throw ex;
		}
		return eventResponse;
	}
	
	
	/**
	 * VOP_VSK_0101 : A/Calculation<br>
	 * P/F Schedule을 Auto Simulation 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calPfSkdAuto(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0101Event event = (VopVsk0101Event)e;
		
		PfSkdGRPVO grpVO = event.getPfSkdGRPVO();
		List<VskPfSkdDtlVO> vskPfSkdDtlVOs = grpVO.getVskPfSkdDtlVOs();
		VskPfSkdDtlVO vskPfSkdDtlVO = vskPfSkdDtlVOs.get(0);
		//같은 Method(M/Calculation)을 호출하지만 Feeder에서는 Calling Port등은 계산하지 않기 때문에
		//0053에서는 B로 셋팅, 0001,0003은 A로 셋팅
		vskPfSkdDtlVO.setEventNav("A");
		vskPfSkdDtlVOs.set(0, vskPfSkdDtlVO);
		grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
		
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		PfSkdGRPVO pfSkdGRPVO = command.calPfSkdAuto(grpVO);
		
		VskPfSkdVO masterVO = pfSkdGRPVO.getVskPfSkdVO();
		List<VskPfSkdDtlVO> detailVOs  = pfSkdGRPVO.getVskPfSkdDtlVOs();
		
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		if(detailVOs.size() > 0 && detailVOs != null){
			sb.append(detailVOs.get(0).getYdCd());
			for(int i=1; i<detailVOs.size(); i++){
				sb.append("|");
				sb.append(detailVOs.get(i).getYdCd());
			}
			
			sb2.append(detailVOs.get(0).getTotMaxSpd());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getTotAvgSpd());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getBufSpd());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getTotBufRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getSeaBufRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getPortBufRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getPfSpdRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getBufSpdRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getMinMaxSpd());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getVslSvcTpCd());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getCheckVslSkd());
		}
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		eventResponse.setRsVo(masterVO);
		eventResponse.setRsVoList(detailVOs);
		eventResponse.setETCData("ydCd", sb.toString());
		eventResponse.setETCData("etcdt", sb2.toString());
		eventResponse.setUserMessage(new ErrorHandler("VSK09001").getUserMessage());
		return eventResponse;
	}
	
	/**
	 * 화면에 표현될 그리드의 헤더 정보를 생성한다.
	 * 
	 * @param List<PfSkdDetailVO> pfSkdDetailVOs
	 * @param int headerIdx
	 * @param GeneralEventResponse eventResponse
	 * @exception EventException
	 */
	private void makeHeader(List<PfSkdDetailVO> pfSkdDetailVOs, int headerIdx, GeneralEventResponse eventResponse) throws EventException {
		try {
			StringBuilder headTitle1 = null; // SKD_DIR_CD
			StringBuilder headTitle2 = null; // VPS_PORT_CD
			StringBuilder headTitle3 = null; // ETB_DY_CD
			StringBuilder headTitle4 = null; // ETB_TM_HRMNT
			StringBuilder headTitle5 = null; // CLPT_IND_SEQ	
			StringBuilder headTitle6 = null; // YD_CD
			StringBuilder headTitle7 = null; // CALL_YD_IND_SEQ
			
			headTitle1 = new StringBuilder();
			headTitle2 = new StringBuilder();
			headTitle3 = new StringBuilder();
			headTitle4 = new StringBuilder();
			headTitle5 = new StringBuilder();
			headTitle6 = new StringBuilder();
			headTitle7 = new StringBuilder();
			
			for(PfSkdDetailVO vo : pfSkdDetailVOs){
				headTitle1.append("|").append(vo.getSkdDirCd()).append("|").append(vo.getSkdDirCd());
				headTitle2.append("|").append(vo.getPortCd()).append("|").append(vo.getPortCd());
				headTitle3.append("|").append(vo.getEtbDyCd()).append("|").append(vo.getEtdDyCd());
				if(vo.getEtbTmHrmnt().length()>2){
					headTitle4.append("|").append(vo.getEtbTmHrmnt().substring(0, 2)).append("|").append(vo.getEtdTmHrmnt().substring(0, 2));
				}else{
					headTitle4.append("|").append(vo.getEtbTmHrmnt()).append("|").append(vo.getEtdTmHrmnt());
				}
				headTitle5.append("|").append(vo.getClptSeq()).append("|").append(vo.getClptSeq());	
				headTitle6.append("|").append(vo.getYdCd()).append("|").append(vo.getYdCd());
				headTitle7.append("|").append(vo.getCallYdIndSeq()).append("|").append(vo.getCallYdIndSeq());
				
				// UI에서는 두개의 컬럼이 하나의 포트 정보로 표시된다.
				// UI의 원할한 성능을 위해 두개의 컬럼 이후에 pseudo 컬럼을 둔다.
				headTitle1.append("|").append(vo.getSkdDirCd());
				headTitle2.append("|");
				headTitle3.append("|");
				headTitle4.append("|");
				headTitle5.append("|");
				headTitle6.append("|");
				headTitle7.append("|");
			}
			
			eventResponse.setETCData("HeadTitle1_" + headerIdx, headTitle1.toString());
			eventResponse.setETCData("HeadTitle2_" + headerIdx, headTitle2.toString());
			eventResponse.setETCData("HeadTitle3_" + headerIdx, headTitle3.toString());
			eventResponse.setETCData("HeadTitle4_" + headerIdx, headTitle4.toString());
			eventResponse.setETCData("HeadTitle5_" + headerIdx, headTitle5.toString());
			eventResponse.setETCData("HeadTitle6_" + headerIdx, headTitle6.toString());
			eventResponse.setETCData("HeadTitle7_" + headerIdx, headTitle7.toString());	
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * VOP_VSK_0104 : Retrieve<br>
	 * Long Range Schedule을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLongRngSkd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//VopVsk0012_1Event event = (VopVsk0012_1Event)e;
		VopVsk0104Event event = (VopVsk0104Event)e;
		
		VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();

		try{
			PortSkdOnLongRangeVO portSkdOnLongRangeVO = event.getPortSkdOnLongRangeVO();
			
			LongRangeSkdInqGRPVO longRangeSkdInqGRPVO = command.searchPortSkdOnLongRange(portSkdOnLongRangeVO);
			//Map<String, List<PfSkdDetailVO>> pfSkdDetails = longRangeSkdInqGRPVO.getPfSkdDetails();
			Map<String, List<PfSkdDetailVO>> pfSkdDetailsByGroup = longRangeSkdInqGRPVO.getPfSkdDetailsByGroup();
			List<List<PortSkdOnLongRangeVO>> portSkdOnLongRangeVOs = longRangeSkdInqGRPVO.getPortSkdVOs();
			
			if(portSkdOnLongRangeVOs==null || portSkdOnLongRangeVOs.size()==0){
				eventResponse.setUserMessage(new ErrorHandler("VSK10018", new String[]{"Schedule"}).getMessage());				
			}else{

				// EventResponse에 Remark 정보 등록
				eventResponse.setRsVoList(longRangeSkdInqGRPVO.getRemarks());
				
				PortSkdOnLongRangeVO portSkdVO = null;
				List<List<List<PortSkdOnLongRangeVO>>> groupByPf = longRangeSkdInqGRPVO.getPortSkdVOsByPf();
				
				// portSkdByPf ( List<PortSkdOnLongRangeVO> 타입 ) ==> 그리드에서 한 Row에 해당 ==> rowData( List<LongRangeSkdInqVO> 타입 ) 으로 변환
				// sameGroupData ( List<List<PortSkdOnLongRangeVO>> 타입) ==> 하나의 그리드에 해당  ==> gridData ( rowData + rowData ...  타입 ) 으로 변환
				int pfGroupCnt = 1;
				for(List<List<PortSkdOnLongRangeVO>> sameGroupData : groupByPf){
					
					List<PortSkdOnLongRangeVO> portSkdByPf = null;
					List<LongRangeSkdInqVO> rowData = null; 
					List<LongRangeSkdInqVO> gridData = new ArrayList<LongRangeSkdInqVO>();
					List<PfSkdDetailVO> pfSkds = null;
					LongRangeSkdInqVO inqVO = null;
					
					for(int i=0; i<sameGroupData.get(0).size(); i++){
						portSkdVO = sameGroupData.get(0).get(i);
						if(!portSkdVO.isEmptySkd()){
							break;
						}
					}
					
					for(int i=0; i<sameGroupData.size(); i++){
						
						portSkdByPf = sameGroupData.get(i); //new ArrayList<PortSkdOnLongRangeVO>();
						if(i==0){
							if (portSkdVO != null) {
								pfSkds = pfSkdDetailsByGroup.get(portSkdVO.getVslSlanCd() + portSkdVO.getPfSkdTpCd() + portSkdVO.getVslCd() + portSkdVO.getSkdVoyNo());
							}
							makeHeader(pfSkds, pfGroupCnt++, eventResponse);
						}
						
						// 앞선 로직에서 헤더부(P/F SKD) 와 데이터부(PORT SKD)의 사이즈를 맞췄기 때문에
						// list와 pfSkds의 size는 동일하다.
						rowData = new ArrayList<LongRangeSkdInqVO>();
						
						confirmCreUsrInfo(portSkdByPf);
						
						if (pfSkds != null) {
							for(int m=0; m<pfSkds.size(); m++){
								inqVO = new LongRangeSkdInqVO();
								portSkdVO = portSkdByPf.get(m);
								
								inqVO.setVslSlanCd(portSkdVO.getVslSlanCd());
								inqVO.setPfSkdTpCd(portSkdVO.getPfSkdTpCd());
								inqVO.setVslCd(portSkdVO.getVslCd());
								inqVO.setSkdVoyNo(portSkdVO.getSkdVoyNo());
								inqVO.setSkdDirCd(portSkdVO.getSkdDirCd());
								inqVO.setVpsPortCd(portSkdVO.getVpsPortCd());
								inqVO.setClptSeq(portSkdVO.getClptSeq());
								
								inqVO.setVpsEtaDt(portSkdVO.getVpsEtaDt());
								inqVO.setVpsEtbDt(portSkdVO.getVpsEtbDt());
								inqVO.setVpsEtdDt(portSkdVO.getVpsEtdDt());
								inqVO.setPfEtaDt(portSkdVO.getPfEtaDt());
								inqVO.setPfEtbDt(portSkdVO.getPfEtbDt());
								inqVO.setPfEtdDt(portSkdVO.getPfEtdDt());
								inqVO.setInitEtaDt(portSkdVO.getInitEtaDt());
								inqVO.setInitEtbDt(portSkdVO.getInitEtbDt());
								inqVO.setInitEtdDt(portSkdVO.getInitEtdDt());
								
								inqVO.setSkdCngStsCd(portSkdVO.getSkdCngStsCd());
								inqVO.setVpsRmk(portSkdVO.getVpsRmk());
								inqVO.setCreDt(portSkdVO.getCreDt());
								inqVO.setCreUsrId(portSkdVO.getCreUsrId());
								inqVO.setUpdDt(portSkdVO.getUpdDt());
								inqVO.setUpdUsrId(portSkdVO.getUpdUsrId());
								inqVO.setEmptySkd(portSkdVO.isEmptySkd());
								inqVO.setAddingSkd(portSkdVO.isAddingSkd());
								inqVO.setReverse(portSkdVO.isReverse());
								rowData.add(inqVO);
							}
						}
						
						gridData.addAll(rowData);
						if(i!=sameGroupData.size()-1){
							gridData.add(null); // Row 구분자로 활용하기 위해 NULL 추가. LongRangeInqViewAdapter에서 활용함.
						}
					}
					eventResponse.setRsVoList(gridData);
				}
				
				/*
				 * CHM-201007036-01 Port 정보와 Vseel 정보도 조회
				 */
				Map<String, String> portNms = longRangeSkdInqGRPVO.getPortNms();
				Map<String, String> vslEngNms = longRangeSkdInqGRPVO.getVslEngNms();
				
				StringBuffer portNmEtcData = new StringBuffer();
				StringBuffer vslEngNmEtcData = new StringBuffer();
				
				if(portNms!=null){
					for(Iterator<String> i = portNms.keySet().iterator(); i.hasNext(); ){
						String key = i.next();
						portNmEtcData.append(key).append("|").append(portNms.get(key));
						if(i.hasNext()){
							portNmEtcData.append(";");
						}
					}
				}
				
				if(vslEngNms!=null){
					for(Iterator<String> i = vslEngNms.keySet().iterator(); i.hasNext(); ){
						String key = i.next();
						vslEngNmEtcData.append(key).append("|").append(vslEngNms.get(key));
						if(i.hasNext()){
							vslEngNmEtcData.append(";");
						}
					}
				}
				
				if(portNmEtcData.length()>0){
					eventResponse.setETCData("port_nms", portNmEtcData.toString());	
				}
				
				if(vslEngNmEtcData.length()>0){
					eventResponse.setETCData("vsl_eng_nms", vslEngNmEtcData.toString());	
				}
				
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 스케쥴 리스트에서 가장 오래된 Create 정보와, 가장 최근의 Update 정보를 구한후에
	 * 해당 리스트의 모든 스케쥴 정보에 반영한다.
	 * 
	 * @param portSkdOnLongRangeVOs
	 */
	private void confirmCreUsrInfo(List<PortSkdOnLongRangeVO> portSkdOnLongRangeVOs){
		
		String creDt = null;
		String creUsrId = null;
		String updDt = null;
		String updUsrId = null;
		
		
		PortSkdOnLongRangeVO vo = null;
		
		for(int i=0; i<portSkdOnLongRangeVOs.size(); i++){
			vo = portSkdOnLongRangeVOs.get(i);
			if(vo.isEmptySkd()){
				continue;
			}
			if(creDt==null || creDt.compareTo(vo.getCreDt()) < 0){
				creDt = vo.getCreDt();
				creUsrId = vo.getCreUsrId();
			}
			if(updDt==null || updDt.compareTo(vo.getUpdDt()) > 0){
				updDt = vo.getUpdDt();
				updUsrId = vo.getUpdUsrId();
			}
		}
		
		for(int i=0; i<portSkdOnLongRangeVOs.size(); i++){
			vo = portSkdOnLongRangeVOs.get(i);
			vo.setCreDt(creDt);
			vo.setCreUsrId(creUsrId);
			vo.setUpdDt(updDt);
			vo.setUpdUsrId(updUsrId);
		}
		
	}
	
	
//	/**
//	 * VOP_VSK_0106 : SKD Closing
//	 * 
//	 * 해당 Vessel Schedule을 수동 Close 처리합니다.
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse manageVslSkdListByLane(Event e) throws EventException {
//		ActivationVvdVO[] vos = null;
//		VopVsk0106Event event = (VopVsk0106Event)e;
//		vos = event.getActivationVvdVOS();
//
//		VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		try{
//			begin();
//			command.manageVslSkdListByLane(vos, account);
//			// Close 성공
//			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
//			commit();
//		}catch(EventException ex){
//			rollback();
//			// Close 실패
//			eventResponse.setUserMessage(new ErrorHandler("VSK09003").getUserMessage());
//			throw ex;
//		}
//		return eventResponse;
//	}
	
//	/**
//	 * VOP_VSK_0106 : SKD Activate
//	 * 
//	 * 해당 Vessel Schedule을 Activate 처리합니다.
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse manageSkdActivate(Event e) throws EventException {
//		ActivationVvdVO activationVvdVO = null;
//		VopVsk0106Event event = (VopVsk0106Event)e;
//		activationVvdVO = event.getActivationVvdVO();
//
//		VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		try{
//			begin();
//			command.manageSkdActivate(activationVvdVO, account);
//			// Activate 성공
//			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
//			commit();
//		}catch(EventException ex){
//			rollback();
//			// Activate 실패
//			eventResponse.setUserMessage(new ErrorHandler("VSK09003").getUserMessage());
//			throw ex;
//		}
//		return eventResponse;
//	}
	
	
	/**
	 * VOP_VSK_0101 : Retrieve<br>
	 * Port 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<YardVO> list = null;
		YardVO yardVO = null;
		PfSkdVO pfSkdVO = null;
		
		VopVsk0101Event event = (VopVsk0101Event)e;
		pfSkdVO = event.getPfSkdVO();
		yardVO = new YardVO();
		yardVO.setLocCd(pfSkdVO.getLocCd());
		
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		ProformaScheduleMgtBC proformaCommand = new ProformaScheduleMgtBCImpl();
		
		String chkPort = command.checkPort(pfSkdVO.getLocCd());
		
		if(chkPort != null && !"".equals(chkPort)){
			list = command.searchYardListByPort(yardVO);
			
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
	
			if(list != null && list.size() > 0){
				sb.append(" ");
				sb1.append(" ");
				sb2.append(" ");
				for (int i = 0; i < list.size(); i++) {
					sb.append("|");
					sb1.append("|");
					sb2.append("|");
					sb.append(list.get(i).getYdKind());
					sb1.append(list.get(i).getYdCd());
					sb2.append(list.get(i).getYdNm());
				}
			}
			
			List<PfSkdVO> pfSkdVOs = new ArrayList<PfSkdVO>();
			int portCnt = Integer.parseInt(pfSkdVO.getPortInfoCnt());
			String dataPos = pfSkdVO.getDataPos();

			if(portCnt == 1){
				PfSkdVO paramVO = new PfSkdVO();
				if("S".equals(dataPos)){
					paramVO.setPortCd(pfSkdVO.getFirstPortCd());
					paramVO.setPodLocCd(pfSkdVO.getSecondPortCd());
					paramVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				}else if("T".equals(dataPos)){
					paramVO.setPortCd(pfSkdVO.getSecondPortCd());
					paramVO.setPodLocCd(pfSkdVO.getThirdPortCd());
					paramVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				}else if("F".equals(dataPos)){
					paramVO.setPortCd(pfSkdVO.getFirstPortCd());
					paramVO.setPodLocCd(pfSkdVO.getSecondPortCd());
					paramVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				}else if("E".equals(dataPos)){
					paramVO.setPortCd(pfSkdVO.getFirstPortCd());
					paramVO.setPodLocCd(pfSkdVO.getSecondPortCd());
					paramVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				}
				pfSkdVOs.add(paramVO);
			}else if(portCnt > 1){
				PfSkdVO firstParamVO = new PfSkdVO();
				firstParamVO.setPortCd(pfSkdVO.getFirstPortCd());
				firstParamVO.setPodLocCd(pfSkdVO.getSecondPortCd());
				firstParamVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				pfSkdVOs.add(firstParamVO);
				PfSkdVO secondParamVO = new PfSkdVO();
				secondParamVO.setPortCd(pfSkdVO.getSecondPortCd());
				secondParamVO.setPodLocCd(pfSkdVO.getThirdPortCd());
				secondParamVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				pfSkdVOs.add(secondParamVO);
			}
			
			List<PfSkdVO> profomaList = proformaCommand.searchPortInfo(pfSkdVOs);
			if(profomaList != null && profomaList.size() > 0){
				if(profomaList.size() == 1){
					//ONE_ROW_DATA : LNK_DIST,FM_ZD,TO_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY
					eventResponse.setETCData("one_row", profomaList.get(0).getLnkDist()+"|"+profomaList.get(0).getFmZd()+"|"+profomaList.get(0).getToZd()+"|"+profomaList.get(0).getPortBufHrs()+"|"+profomaList.get(0).getCrnKnt()+"|"+profomaList.get(0).getTmlProdQty());
				}else{
					//ONE_ROW_DATA : LNK_DIST,FM_ZD,TO_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY
					eventResponse.setETCData("one_row", profomaList.get(0).getLnkDist()+"|"+profomaList.get(0).getFmZd()+"|"+profomaList.get(0).getToZd()+"|"+profomaList.get(0).getPortBufHrs()+"|"+profomaList.get(0).getCrnKnt()+"|"+profomaList.get(0).getTmlProdQty());
					//TWO_ROW_DATA : LNK_DIST,FM_ZD,TO_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY
					eventResponse.setETCData("two_row", profomaList.get(1).getLnkDist()+"|"+profomaList.get(1).getFmZd()+"|"+profomaList.get(1).getToZd()+"|"+profomaList.get(1).getPortBufHrs()+"|"+profomaList.get(1).getCrnKnt()+"|"+profomaList.get(1).getTmlProdQty());
				}
				
				//그리드에 데이타를 출력한 로우 갯수
				eventResponse.setETCData("portInfoCnt", pfSkdVO.getPortInfoCnt());
				//현재 port의 몇번째 로우를  파라미터로 보내서 response시 해당 로우에 데이타를 삽입한다
				eventResponse.setETCData("currPos", pfSkdVO.getCurrPos());
				//전 포트가 존재 하지 않기때문에 자기 자신의 현재 포트에 데이타를 출력한다 S = SELF
				eventResponse.setETCData("dataPos", pfSkdVO.getDataPos());
			}
			
		eventResponse.setETCData("yd_kind", sb.toString());
			eventResponse.setETCData("yd_cd", sb1.toString());
			eventResponse.setETCData("yd_nm", sb2.toString());
		}else{			
			eventResponse.setETCData("yd_kind", "");
			eventResponse.setETCData("yd_cd", "");
			eventResponse.setETCData("yd_nm", "");
		}

		eventResponse.setETCData("check_port", chkPort);
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0101 : Retrieve
	 * Yard 정보를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<YardVO> list = null;
		YardVO yardVO = null;
		
		VopVsk0101Event event = (VopVsk0101Event)e;
		yardVO = event.getYardVO();
		
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();		
		list = command.searchYardList(yardVO);
		
		if(list != null && list.size() > 0){
			eventResponse.setETCData("mnvr_in_hrs", list.get(0).getMnvrInHrs());
			eventResponse.setETCData("mnvr_out_hrs", list.get(0).getMnvrOutHrs());
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0101 : Delete<br>
	 * P/F Schedule 정보를 삭제합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removePfSkd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VskPfSkdVO vskPfSkdVO = null;
		VopVsk0101Event event = (VopVsk0101Event)e;
		vskPfSkdVO = event.getVskPfSkdVO();

		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		
		try{
			begin();
			command.removePfSkd(vskPfSkdVO, account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10026").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();		
			throw ex;
		}
		return eventResponse;
	}
	
	
//	/**
//	 * VOP_VSK_0106 : Save<br>
//	 * 해당 VVD의 P/F Type 정보를 수정한다.<br>
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 * @author Hyuk Ryu
//	 * @date 2009. 11. 11.
//	 */
//	private EventResponse manageVvdPf(Event e) throws EventException {
//		try{
//			GeneralEventResponse eventResponse = new GeneralEventResponse();
//			List<ActivationVvdVO> activationVvdVOs = null;  
//			if(e instanceof VopVsk0106Event){
//				VopVsk0106Event event = (VopVsk0106Event)e;
//				activationVvdVOs = Arrays.asList(event.getActivationVvdVOS());
//			}
//			
//			for(ActivationVvdVO vo : activationVvdVOs){
//				vo.setUpdUsrId(account.getUsr_id());
//			}
//			
//			VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
//			command.manageVvdPf(activationVvdVOs);
//			
//			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
//			return eventResponse;
//		}catch(EventException ex){
//			rollback();
//			log.error("err " + e.toString(), ex);
//			throw ex;
//		}catch(Exception ex){
//			rollback();
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
//		}
//	}
	
	/**
	 * VOP_VSK_0101 : Row Delete<br>
	 * 선택한 로우(들)을 삭제하고 존재하는 포트에 대한 정보를 재 조합한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calRowDelete(Event e) throws EventException {
		PfSkdGRPVO grpVO = null;
		VskPfSkdVO masterVO = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
				VopVsk0101Event event = (VopVsk0101Event)e;
				grpVO = event.getPfSkdGRPVO();
				masterVO = grpVO.getVskPfSkdVO();
			
			ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
			List<VskPfSkdDtlVO> dtlVOs = command.calRowDelete(grpVO);
			StringBuffer sb = new StringBuffer();
			
			if(dtlVOs.size() > 0 && dtlVOs != null){
				sb.append(dtlVOs.get(0).getYdCd());
				for(int i=1; i<dtlVOs.size(); i++){
					sb.append("|");
					sb.append(dtlVOs.get(i).getYdCd());
				}
				
				eventResponse.setRsVo(masterVO);
				eventResponse.setRsVoList(dtlVOs);
				eventResponse.setETCData("ydCd", sb.toString());
			}
			
			return eventResponse;
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * VOP_VSK_0106 : crr_cd 입력<br>
	 * @param  e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCrrCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		VopVsk0106Event event = (VopVsk0106Event)e;
		try{
			String strRet = command.searchCrrCd(event.getCrrCd());
			eventResponse.setETCData("crr_cd", strRet);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0108 : Retrieve
	 * 
	 * Proforma Type 정보를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse 
	 * @exception EventException
	 */
	private EventResponse searchPfTpHelp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0108Event event = (VopVsk0108Event)e;
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		List<PfSkdTypeHelpVO> list = command.searchPfTpHelp(event.getPfSkdTypeHelpVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * VOP_VSk_0108 : Retrieve<br>
	 * Lane Code가 유효한지 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSvcLane(Event e) throws EventException {	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VskPfSkdVO vskPfSkdVO = null;
		MdmVslSvcLaneVO vo = new MdmVslSvcLaneVO();
		if(e instanceof VopVsk0108Event){
			VopVsk0108Event event = (VopVsk0108Event)e;
			vskPfSkdVO = event.getVskPfSkdVO();
			vo.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
		}
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		List<MdmVslSvcLaneVO> list = command.checkSvcLane(vo);
		StringBuffer data = new StringBuffer();
		String vslSvcTpCd = "";

		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				data.append(list.get(i).getVslSlanNm());
				vslSvcTpCd = list.get(i).getVslSvcTpCd();
				if (i < list.size()-1)
					data.append("|");
			}
			eventResponse.setETCData("checkLane", data.toString());
			eventResponse.setETCData("checkLaneTpCd", vslSvcTpCd);
		}else{	 
			eventResponse.setUserMessage(new ErrorHandler("VSK10019").getUserMessage());
		}

		return eventResponse;
	}
	
	/**
	 * 정시 VVD 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRsltVvdList(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			VopVsk0110Event event = (VopVsk0110Event) e;
	
			ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
			List<VvdPortLaneOtherVO> list = null;
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
//			if ("RSLT".equals(event.getVvdPortLaneOtherVO().getCtrlCd())) {
////				list = command.searchRsltVvdList(event.getVvdPortLaneOtherVO().getVslCd());
//				if(list!=null && list.size()>0){
//					// 화면에서 VVD를 입력했을시 해당 VVD가 존재하는지 체크한다.
//					eventResponse.setETCData("vvd", list.get(0).getVslCd() + list.get(0).getSkdVoyNo() + list.get(0).getSkdDirCd());
//				}
//			} else 
			if(event.getVvdPortLaneOtherVO() != null){
				if ("NORL".equals(event.getVvdPortLaneOtherVO().getCtrlCd())) {
					list = command.searchEstVvdList(event.getVvdPortLaneOtherVO()
							.getVslCd());
				}
				eventResponse.setRsVoList(list);
			}
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * VOP_VSK_0111 : open<br>
	 * 입력 받은 Lane Code로 생성된 PF SKD Type 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPfTypeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0111Event event = (VopVsk0111Event)e;
		VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		
		List<PfLaneTypeVO> list = command.searchPfLaneTypeList(event.getPfLaneTypeVO());
		eventResponse.setRsVoList(list);

		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0112 : open
	 * VVD를 Simulation 한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkBkgStsByVvd(Event e) throws EventException {
		VopVsk0112Event event = (VopVsk0112Event)e;
		
		SimulationVvdCheckVO simulationVvdCheckVO = event.getSimulationVvdCheckVO();
		VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		
		List<VvdBkgStsVO> list = command.checkBkgStsByVvd(simulationVvdCheckVO);
		
		boolean bkgStatus = false;
		boolean virBkgStatus = false;
		boolean ruseProhiFlg = false;
		
		for(VvdBkgStsVO vvdBkgStsVO: list){
			if("Booking".equals(vvdBkgStsVO.getBkgStatus())){
				bkgStatus = true;
			}
			if("BKG".equals(vvdBkgStsVO.getVirBkgStatus()) || "BKGNOD".equals(vvdBkgStsVO.getVirBkgStatus())){
				virBkgStatus = true;
			}
			if("Y".equals(vvdBkgStsVO.getRuseProhiFlg())){
				ruseProhiFlg = true;
			}
		}
		
		StringBuilder remark = new StringBuilder("");
		if(bkgStatus){
			//remark.append("Booking 상태를 가지는 VVD가 존재합니다.");
			remark.append("Booking data already exists on Creating VVD and User have to record delete history.");
		}
		if(virBkgStatus){
			if(remark.length()>0){
				remark.append("\n");
			}
			//remark.append("Virtual Port가 Booking 상태인 VVD가 존재합니다.");
			remark.append("Booking data already exists on Virtual calling port  and User have to record delete history.");
		}
		if(ruseProhiFlg){
			if(remark.length()>0){
				remark.append("\n");
			}
			//remark.append("재무 VVD에 등록된 VVD가 존재합니다.");
			remark.append("VVD of creating LRS already exists on financial system and can’t create vessel SKD.");
		}
				
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		eventResponse.setETCData("remark", remark.toString());
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0113 : Retrieve<br>
	 * 기간별 Por에 기항하는 Coastal 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSkdByPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CstSkdByPortVO cstSkdByPortVO = null;
		List<YardVO> yardList = null;
		YardVO yardVO = new YardVO();

		if(e instanceof VopVsk0113Event){
			VopVsk0113Event event = (VopVsk0113Event)e;
			cstSkdByPortVO = event.getCstSkdByPortVO();
		}
		VesselScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		List<CstSkdByPortVO> list = command.searchCstSkdByPort(cstSkdByPortVO);

		//====================================================================
		VSKCodeFinderBC vskCodeFinderBC = new VSKCodeFinderBCImpl();
		
		if (cstSkdByPortVO != null) {
			yardVO.setLocCd(cstSkdByPortVO.getVpsPortCd());
		}
		
		yardList = vskCodeFinderBC.searchYardListByPort(yardVO);

		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		if(yardList != null && yardList.size() > 0){
			sb.append(yardList.get(0).getYdKind());
			sb2.append(yardList.get(0).getYdNm());
			for (int i = 1; i < yardList.size(); i++) {
				sb.append("|");
				sb2.append("|");
				sb.append(yardList.get(i).getYdKind());
				sb2.append(yardList.get(i).getYdNm());
			}
		}
		eventResponse.setETCData("yd_kind", sb.toString());
		eventResponse.setETCData("yd_nm", sb2.toString());
		//====================================================================

		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0020, VOP_VSK_0113 : Port Change<br>
	 * Port Code 존재유무를 확인한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MdmLocationVO mdmLocationVO = null;
		String chkPort = null;

		if(e instanceof VopVsk0020Event){
			VopVsk0020Event event = (VopVsk0020Event)e;
			mdmLocationVO = event.getMdmLocationVO();
		}else if(e instanceof VopVsk0113Event){
			VopVsk0113Event event = (VopVsk0113Event)e;
			mdmLocationVO = event.getMdmLocationVO();
		}

		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		
		if (mdmLocationVO != null) {
			chkPort = command.checkPort(mdmLocationVO.getLocCd());
		}

		eventResponse.setETCData("check_port", chkPort);

		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0113 : Open<BR>
	 * Port 정보를 관리하는 상위 Office 정보를 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRhqList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		List<OfficeVO> list = null;

		list = command.searchRhqList();

		StringBuilder sb = new StringBuilder();
		if(list != null){
			sb.append(list.get(0).getPrntOfcCd());
			for(int i=1; i<list.size(); i++){
				sb.append("|"+list.get(i).getPrntOfcCd());
			}
		}
		eventResponse.setETCData("rhq_list", sb.toString());
		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/** 
	 * VOP_VSK_0113 : CTRL H/Q 선택시<br>
	 * RHQ산하에 있는 Control Office Code 정보를 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchControlOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		MdmLocationVO paramVO = null;
		List<LocationVO> list = null;

		if(e instanceof VopVsk0113Event){
			VopVsk0113Event event = (VopVsk0113Event)e;
			paramVO = event.getMdmLocationVO();
		}

		if (paramVO != null) {
			list = command.searchYardCtrlOfficeList(paramVO.getVskdPortRhqCd());
		}

		StringBuilder sb = new StringBuilder();
		if(list != null){
			sb.append(list.get(0).getVopPortCtrlOfcCd());
			for(int i=1; i<list.size(); i++){
				sb.append("|"+list.get(i).getVopPortCtrlOfcCd());
			}
		}
		eventResponse.setETCData("ctrl_ofc_list", sb.toString());
		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0113 : Retrieve<br>
	 * 입력된 Month/Week에 해당하는 날짜를 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		SearchDateVO dateVO = null;
		List<SearchDateVO> list = null;

		if(e instanceof VopVsk0113Event){
			VopVsk0113Event event = (VopVsk0113Event)e;
			dateVO = event.getSearchDateVO();
		}

		list = command.searchDate(dateVO);

		StringBuilder sb = new StringBuilder();
		if(list != null){
			sb.append(list.get(0).getRtnDate());
			for(int i=1; i<list.size(); i++){
				sb.append("|"+list.get(i).getRtnDate());
			}
		}
		eventResponse.setETCData("rtn_date", sb.toString());
		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0113 : Group을 Setting한 User가 화면을 오픈했을 경우<br>
	 * User별 Group을 조회 한다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLanePortGroupByUserId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0113Event event = (VopVsk0113Event)e;
		VesselScheduleMasterDataBC command = new VesselScheduleMasterDataBCImpl();

		try{
			UserDefinedLanePortGroupVO userDefinedLanePortGroupVO = event.getUserDefinedLanePortGroupVO();
			String usr_id = userDefinedLanePortGroupVO.getUsrId();

			List<UserDefinedLanePortGroupVO> list = command.searchLanePortGroupByUserId(usr_id);
			StringBuffer sb = new StringBuffer();

			if(list != null && list.size() > 0){
				sb.append(list.get(0).getUsrDefGrpNm());
				for(int i=1; i<list.size(); i++){
					sb.append("|"+list.get(i).getUsrDefGrpNm());
				}
			}

			eventResponse.setETCData("grp_nm", sb.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}