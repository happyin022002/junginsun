/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : LaneSimulationSC.java
*@FileTitle : 항로 Simulation 마스터 및 W/F 생성/조회/변경
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : eunju park
*@LastVersion : 1.0
* 2006-08-25 eunju park
* 1.0 최초 생성
* =======================================================
* History : 
* 2009.03.31 박은주,임옥영,박상희 S2K-09U-002(Lane Simulation System 개선)
* 2010.02.05 임옥영 소스품질검토 결과 반영(주석들 변경) 
* 2010.02.18 윤진영 소스품질검토 결과 반영(not read항목 삭제)
* 2010.10.08 박은주 CHM-201006307 Session 정보 변경 및 프로그램 오류수정
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2011.07.13 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2013.01.14 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.basic.CommonBC;
import com.clt.apps.opus.esm.coa.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.coa.common.vo.GetCodeSelectVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.basic.LaneSimulationBC;
import com.clt.apps.opus.esm.coa.lanesimulation.basic.LaneSimulationBCImpl;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0051Event;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0052Event;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0053Event;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0054Event;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0150Event;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0151Event;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0164Event;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0165Event;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0166Event;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0167Event;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0168Event;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0169Event;
import com.clt.apps.opus.esm.coa.lanesimulation.integration.LaneSimulationDBDAO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.CreateSimDailyHireVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.MergyVolProjConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.MultiSimSummaryRptVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchBSAbyVVDListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchFileMgmtListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchLaneInfoListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchReportConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimBunkerListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimCalcVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimContiPairListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimDailyHireInfoVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimLaneListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimLaneRPBListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimPortChargeListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimPortListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimReportMasterListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimRtnRowSetVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimVesselListConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimVesselListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimYardListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchTMLOPDysListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchTocHireListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchTsVolumeVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchVesselInfoVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.basic.ProformaScheduleMgtBC;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.basic.ProformaScheduleMgtBCImpl;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaBnkCsmVO;
import com.clt.syscommon.common.table.CoaSimBnkCostVO;
import com.clt.syscommon.common.table.CoaSimCtrbMgnCostVO;
import com.clt.syscommon.common.table.CoaSimDlyHirVO;
import com.clt.syscommon.common.table.CoaSimNonOpExpnVO;
import com.clt.syscommon.common.table.CoaSimPortChgVO;


/**
 * 1. 기능 : ALPS-COA Business Logic ServiceCommand<br> 
 * 2. 처리 개요 :<p>
 *  - ALPS-COA에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 3. 주의사항 :<p>
 * ===================================<br>
 * 4. 작성자/작성일 : 윤진영/2009.08.28<br>
 * ===================================<br>
 * 5. 수정사항<p>
 * 5.1 요구사항 ID :<p>
 *  - 수정자/수정일 :<p>
 * 수정사유/내역 :<p>
 * ===================================<br>
 * <p/>
 * * @author 윤진영
 * @see LaneSimulationDBDAO 참조
 * @since J2EE 1.4
 */
public class LaneSimulationSC extends ServiceCommandSupport {
    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * COA 업무 시나리오 선행작업<br>
     * LaneSimulation업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    @Override
	public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
          	account=getSignOnUserAccount();
            //account.getUsr_id()
        } catch (Exception e) {
            log.error("LaneSimulationSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }
    /**
     * COA 업무 시나리오 마감작업<br>
     * LaneSimulation업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    @Override
	public void doEnd() {
        // command.doEnd();
        log.debug("LaneSimulationSC 종료");
    }
    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * ENIS-COA 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        EventResponse eventResponse = null;
        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        if (e.getEventName().equalsIgnoreCase("EsmCoa0051Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {			//select master
                eventResponse = searchSimLaneList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
            	eventResponse = removeSimLane(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 		// master I/U/D
            	eventResponse = multiSimLane(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { 	// select detail
                eventResponse = searchSimVesselList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 		// detail I/U
            	eventResponse = multiSimVesselInfo(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { 	// Lane Info I/F
            	eventResponse = searchLaneInfoList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH01) 
               	   || e.getFormCommand().isCommand(FormCommand.SEARCH02)){			// select Vessel Info
            	eventResponse = searchVesselInfo(e);            	
            } else {
				eventResponse =  searchComBoCdList0051(e);	
			}
        }else if(e.getEventName().equalsIgnoreCase("EsmCoa0052Event")){
        	if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){				// Tab1 : Port/TMNL Settion Retrieve
        		eventResponse = searchSimPortList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { 	// Tab1 : port에 해당하는 yard code를 조회한다.	
            	eventResponse = searchSimYardList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)){		// Tab1 : P/F SKD 로 부터 Port TMNL 정보를 조회한다.
            	eventResponse = multiSimPortGetOpDay(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 		// Tab1 : Port/TMNL Settion 1차 Save
                eventResponse = multiSimPortInfo(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) { 		// Tab1 : Port/TMNL Settion 최종 Save
                eventResponse = multiSimPortInfo2(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI09)){			// Tab1 : Port/TMNL Calcuration
               	eventResponse = multiSimPortCalc(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { 	// Tab2 : Lane G.RPB Projection Retrieve
            	eventResponse = searchSimLaneRPBList(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){			// Tab2 : Lane G.RPB Projection Save
        		eventResponse = modifySimGrpb(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {	// Tab2 : Route Projection - Volume Retrieve
                eventResponse = searchSimVolProjList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { 		// Tab2 : Route Projection - Volume Save
                eventResponse = multiSimVolProj(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI07)){		// Tab2 : Route Projection - Volume Create
        		eventResponse = createSimVolProj(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {	// Tab2 : Route Projection - G.RPB Retrieve
                eventResponse = searchSimGrpbProjList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { 		// Tab2 : Route Projection - G.RPB Save
                eventResponse = multiSimGrpbProj(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)){		// Tab3 : TMNL Transit Time Retrieve
            	eventResponse = searchTMLOPDysList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI05)){			// Tab3 : TMNL Transit Time Save
            	eventResponse = modifiyTMLOPDys(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI08)){			// 운항일수를 생성한다.
            	eventResponse = createTMLOPDys(e);
            } else {
				eventResponse =  searchComBoCdList0052(e);	
			}
        }else if(e.getEventName().equalsIgnoreCase("EsmCoa0053Event")){
        	if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){ 			//Step3: Tab1 : CM_Lane Summary Retrieve
        		eventResponse = searchSimCgoCostList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { 	//Step3: Tab1 : CM_Route Summary Retrieve	
                eventResponse = searchSimCMCostList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 		//Step3: Tab1 : CM_Route Summary Save
                eventResponse = modifySimCMCost(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)){		//Step3: Tab2 : Port Charge Retrieve
        		eventResponse = searchSimPortChargeList(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.MULTI05)){			//Step3: Tab2 : Port Charge Create
        		eventResponse = createSimPortCharge(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){			//Step3: Tab2 : Port Charge Save
        		eventResponse = multiSimPortCharge(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)){		//Step3: Tab3 : Bunker Cost Retrieve
        		eventResponse = searchSimBunkerList(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.MULTI06)){			//Step3: Tab3 : Bunker Cost Basic
        		eventResponse = createSimBunkerList(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){			//Step3: Tab3 : Bunker Cost Save
        		eventResponse = multiSimBunkerCost(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)){		//Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Retrieve
        		eventResponse = searchSimDailyHireList(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.MULTI07)){	    	//Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Create
        		eventResponse = createSimDailyHire(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.MULTI04)){			//Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Save
        		eventResponse = multiSimDailyHire(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.MULTI08)){			//Step3 : Tab5 : Network Cost > Create
        		eventResponse = createSimNWCost(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)){		//Step3 : Tab5 : Network Cost > Retrieve
        		eventResponse = searchSimNWCostList(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)){		//Step3 : Tab6 : After Ocean T/S > Retrieve
        		eventResponse = searchSimAfterOcenaTSList(e);
        	}else{
        		eventResponse = searchComBoCdList0053(e);
        	}
        } else if(e.getEventName().equalsIgnoreCase("EsmCoa0054Event")){
        	if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){//조회시
        		eventResponse = searchSimSummaryReportList(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){//ReportNo 콤보 리스트용 데이터 조회
        		eventResponse = searchSimReportNoList(e);
        	}else{
        		eventResponse = searchComBoCdList0054(e);
        	} 	
        } else if(e.getEventName().equalsIgnoreCase("EsmCoa0150Event")){ //Create Continent Pair Table
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
        		eventResponse = searchSimContiPairList(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
        		eventResponse = multiSimContiPair(e);
        	}else{
        		eventResponse = searchComBoCdList0150(e);
        	}
        } else if(e.getEventName().equalsIgnoreCase("EsmCoa0151Event")){ //Create Consumption Matrix by Class
        	if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){
        		eventResponse = searchSimConsumList(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
        		eventResponse = multiSimConsum(e);
        	} else {
				eventResponse =  searchComBoCdList0151(e);	
			}
        }else if(e.getEventName().equalsIgnoreCase("EsmCoa0164Event")){ //IAS T/S Volume                         
        	if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){                                                                 
        		eventResponse = searchNonOpExpnList(e);                                                                                    
        	}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){                                                                
        		eventResponse = multiNonOpExpn(e);                                                                                         
        	}                                                                                                                           
        }else if(e.getEventName().equalsIgnoreCase("EsmCoa0165Event")){ //File Mgmt
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
        		eventResponse = searchFileMgmtList(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
        		eventResponse = multiFileMgmt(e);
        	}else {
				eventResponse =  searchComBoCdList0165(e);
        	}
        }else if(e.getEventName().equalsIgnoreCase("EsmCoa0166Event")){ //BSA by VVD
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
        		eventResponse = searchBSAbyVVDList(e);
        	}else{
        		eventResponse = searchComBoCdList0166(e);
        	}            	
        }else if(e.getEventName().equalsIgnoreCase("EsmCoa0167Event")){
	    	if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){				//TC/O HIre (Hire/TC Rev/Layup(Daily) Open Popup) > Retrieve
	    		eventResponse = searchTOCHireList(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){			//TC/O HIre (Hire/TC Rev/Layup(Daily) Open Popup) > Save
	    		eventResponse = multiTOCHire(e);
	    	} 
        } else if(e.getEventName().equalsIgnoreCase("EsmCoa0168Event")){//Creation (Variant Change)
        	if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){//화면로딩시 조회
        		eventResponse = searchSimReportMasterList(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){//COMMAND01 화면로딩시 신규레포트 생성 + 조회
        		eventResponse = createDefaultSimReport(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){//Creation버튼 클릭시 생성
        		eventResponse = multiSimReport(e);
        	} else {//화면로딩시 기존 레포트가 있는지 확인
        		eventResponse = searchSimReportMasterCount(e);
        	}
        }else if(e.getEventName().equalsIgnoreCase("EsmCoa0169Event")){ //IAS T/S Volume                         
        	if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){                                                                 
        		eventResponse = searchTSVolumeList(e);                                                                                    
        	}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){                                                                
        		eventResponse = multiTSVolume(e);                                                                                         
        	}else{
        		eventResponse = searchComBoCdList0169(e);
        	}                                                                                                                          
        }
        return eventResponse;
    }
    
    /**
     * 1. 기능 : Step1에서 Lane Info I/F 조회 이벤트 처리 <p>
     * 2. 처리개요 :  <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : park sang hee/2009.02.18<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
    private EventResponse searchLaneInfoList(Event e) throws EventException {
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0051Event event = (EsmCoa0051Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
    
    try {
    	List<SearchLaneInfoListVO> list = command.searchLaneInfoList(event.getLaneInfoListConditionVO());
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
     * 1. 기능 : master sheet 조회 이벤트 처리<p>
     * 2. 처리개요 :  <p>
     *    - LaneSimulation대한 Sheet1 리스트 조회 이벤트 처리<p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : parkeunju/2006.08.28<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
  	 * <p/>
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchSimLaneList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0051Event event = (EsmCoa0051Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
	    try {
	    	SearchSimLaneListConditionVO vo = event.getSearchSimLaneListConditionVO();
	    	vo.setFSimDt(vo.getFSimDt().replaceAll("-",""));
	    	List<SearchSimLaneListVO> list = command.searchSimLaneList(event.getSearchSimLaneListConditionVO());
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
	 * 1. 기능 : master sheet row delet 이벤트 처리(ESM_COA_051)
   	 * <p>
   	 * 2. 처리개요 :  <p>
   	 *    - LaneSimulation대한 Sheet1 리스트 조회 이벤트 처리<p>
   	 * 3. 주의사항 : <p>
   	 * ===================================<br>
   	 * 4. 작성자/작성일 : parkeunju/2006.08.28<br>
   	 * ===================================<br>
   	 * 5. 수정사항<p>
   	 * 5.1 요구사항 ID :<p>
   	 * - 수정자/수정일 :<p>
   	 * - 수정사유/내역 :<p>
   	 * ===================================<br>
   	 * <p/>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse removeSimLane(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0051Event event = (EsmCoa0051Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
		try {
			begin();
	    	SearchSimLaneListConditionVO[] vos = event.getSearchSimLaneListConditionVOS();
	    	for(int i=0;i<vos.length;i++) {
	    		vos[i].setFSimDt(vos[i].getFSimDt().replaceAll("-",""));
	    	}
			command.removeSimLane(event.getSearchSimLaneListConditionVOS());
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
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
	 * 1. 기능 : master sheet multi 이벤트 처리(ESM_COA_051)
   	 * <p>
   	 * 2. 처리개요 :  <p>
   	 *    - LaneSimulation대한 Sheet1 리스트 조회 이벤트 처리<p>
   	 * 3. 주의사항 : <p>
   	 * ===================================<br>
   	 * 4. 작성자/작성일 : parkeunju/2006.08.28<br>
   	 * ===================================<br>
   	 * 5. 수정사항<p>
   	 * 5.1 요구사항 ID :<p>
   	 * - 수정자/수정일 :<p>
   	 * - 수정사유/내역 :<p>
   	 * ===================================<br>
   	 * <p/>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiSimLane(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0051Event event = (EsmCoa0051Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
		try {
			begin();
			SearchSimLaneListVO[] vos = event.getSearchSimLaneListVOS();
	    	for(int i=0;i<vos.length;i++) {
	    		vos[i].setSimDt(vos[i].getSimDt().replaceAll("-",""));
	    	}
			String return_val = command.multiSimLane(event.getSearchSimLaneListVOS(), account);
			String rtnVal1 = return_val.substring(0,return_val.indexOf("|", 0));
			String rtnVal2 = return_val.substring(return_val.indexOf("|",0)+1,return_val.length());
			
			eventResponse.setETCData("newLane",rtnVal1);
			eventResponse.setETCData("sim_no",rtnVal2);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
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
     * 1. 기능 : detail sheet 조회 이벤트 처리(ESM_COA_051)<p>
     * 2. 처리개요 :  <p>
     *    - LaneSimulation대한 Sheet2 리스트 조회 이벤트 처리<p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : parkeunju/2006.08.28<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
  	 * <p/>
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchSimVesselList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0051Event event = (EsmCoa0051Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
        
	    try {
	    	SearchSimVesselListConditionVO vo = event.getSearchSimVesselListConditionVO();
     		vo.setFSimDt(vo.getFSimDt().replace("-",""));
	    	List<SearchSimVesselListVO> list = command.searchSimVesselList(event.getSearchSimVesselListConditionVO());
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
     * 1. 기능 : Vessel Info 조회 이벤트 처리<p>
     * 2. 처리개요 :  <p>
     *    - LaneSimulation대한 Sheet2 리스트 중 조회 이벤트 처리<p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : parkeunju/2006.08.28<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
  	 * <p/>
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchVesselInfo(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0051Event event = (EsmCoa0051Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
		String srow = "";
	    try {
	    	srow = event.getSearchVesselInfoConditionVO().getSrow();
	    	List<SearchVesselInfoVO> list = command.searchVesselInfo(event.getSearchVesselInfoConditionVO());
	    	if(list.size()==0) {
	    		SearchVesselInfoVO vo = new SearchVesselInfoVO();
	    		vo.setMdmVslYn("N");
	    		vo.setProcgb("");
	    		vo.setSrow(srow);
	    		list.add(vo);
	    	}
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
	 * 1. 기능 : detail sheet multi 이벤트 처리(ESM_COA_051)
   	 * <p>
   	 * 2. 처리개요 :  <p>
   	 *    - LaneSimulation대한 Sheet2 multi 이벤트 처리<p>
   	 * 3. 주의사항 : <p>
   	 * ===================================<br>
   	 * 4. 작성자/작성일 : parkeunju/2006.08.28<br>
   	 * ===================================<br>
   	 * 5. 수정사항<p>
   	 * 5.1 요구사항 ID :<p>
   	 * - 수정자/수정일 :<p>
   	 * - 수정사유/내역 :<p>
   	 * ===================================<br>
   	 * <p/>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiSimVesselInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0051Event event = (EsmCoa0051Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
		CommonBC commonBC = new CommonBCImpl();
		SearchSimVesselListVO[] vos = event.getSearchSimVesselListVOS();
		String ibVessel = "";
		try {
			begin();
			for(int i=0;i<vos.length;i++) {
				vos[i].setHjsBfrBsaCapa(vos[i].getHjsBfrBsaCapa().replace(",", ""));
				vos[i].setSimDt(vos[i].getSimDt().replace("-", ""));
			}
			command.multiSimVesselInfo(vos, account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
		    ibVessel = commonBC.getIbCodeCombo("vessel","simVsl", "", "code");
			eventResponse.setETCData("vessel", ibVessel);
			eventResponse.setETCData("Result", "OK");
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * ESM_COA_0169 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0169(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		try {
				String array[][] = {
					/*1.IOC*/
						{"CD00206", "000020: : ", ""}
					
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
    /**                                                                                                                               
     * 1. 기능 : Step1에서 Continent Pair 조회 이벤트 처리<p>                                                                         
     * 4. 작성자/작성일 : jongyeolkim/2009.03.11<br>                                                                                   
     * <p/>                                                                                                                           
     * @param e Event                                                                                                                 
     * @return response GeneralEventResponse                                                                                      
     * @exception EventException                                                                                                      
     */                                                                                                                               
    private EventResponse searchTSVolumeList(Event e) throws EventException {                                                         
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체                                                                   
    	GeneralEventResponse eventResponse = new GeneralEventResponse();                                                                                             
    	EsmCoa0169Event event = (EsmCoa0169Event)e;
    	try {                                                                                                                           
    		LaneSimulationBC command = new LaneSimulationBCImpl();                             
    		SearchConditionVO vo = event.getSearchConditionVO();
    		vo.setFSimDt(vo.getFSimDt().replaceAll("-",""));
    		List<SearchTsVolumeVO> list = command.searchTsVolumeList(event.getSearchConditionVO());
    		eventResponse.setRsVoList(list);                                                                                
    	} catch (EventException de) {                                                                                                   
    		log.error("err " + de.toString(), de);                                                                                        
    		throw new EventException(de.getMessage());                                                                                    
    	}                                                                                                                               
    	return eventResponse;                                                                                                         
    }                                                                                                                                 
    /**                                                                                                                               
     * 1. 기능 :  Step1에서 Continent Pair multi 이벤트 처리<p>                                                                       
     * 4. 작성자/작성일 : jongyeolkim/2009.03.11<br>                                                                                    
     * <p/>                                                                                                                           
     * @param e Event                                                                                                                 
     * @return response GeneralEventResponse                                                                                      
     * @exception EventException                                                                                                      
     */                                                                                                                               
    private EventResponse multiTSVolume(Event e) throws EventException {                                                              
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체                                                                   
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmCoa0169Event event = (EsmCoa0169Event)e;
    	try {                                                                                                                           
    		begin();                                                 
    		LaneSimulationBC command = new LaneSimulationBCImpl();                                                                        
    		command.multiTsVolume(event.getSearchConditionVO(),event.getSearchTsVolumeVOS(),account);  
    		commit();                                                                                                                     
    	} catch (EventException de) {                                                                                                   
    		rollback();                                                                                                                   
    		log.error("err " + de.toString(), de);                                                                                        
    		throw new EventException(de.getMessage());                                                                                    
    	}                                                                                                                               
    	return eventResponse;                                                                                                  
    }       
    /**
     * 1. 기능 : Step1에서 File Mgmt 조회 이벤트 처리 <p>
     * 4. 작성자/작성일 : Bae jin hwan/2009.02.18<br>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
    private EventResponse searchFileMgmtList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0165Event event = (EsmCoa0165Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
		try {
			SearchFileMgmtListVO vo = event.getSearchFileMgmtListVO();
			vo.setSimDt(vo.getSimDt().replace("-",""));
			List<SearchFileMgmtListVO> list = command.searchFileMgmtList(event.getSearchFileMgmtListVO(),account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
    }
    /**
     * 1. 기능 : Step1에서 File Mgmt 삭제 이벤트 처리 <p>
     * 4. 작성자/작성일 : Bae jin hwan/2009.02.18<br>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
	public EventResponse multiFileMgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsmCoa0165Event event = (EsmCoa0165Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
		try {
			begin();
			SearchFileMgmtListVO[] vos = event.getSearchFileMgmtListVOS();
			for(int i=0;i<vos.length;i++) {
				vos[i].setSimDt(vos[i].getSimDt().replace("-",""));
			}
			command.multiFileMgmt(event.getSearchFileMgmtListVOS());
			commit();
			
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}   
	/**
	 * ESM_COA_0166 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0166(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		try {
			String prevWeek = commonBC.searchPrevWkPrd();
	       	eventResponse.setETCData("prevWeek", prevWeek);
	       	
	       	String fYear = commonBC.searchPrevYearPrd();
	       	eventResponse.setETCData("fYear", fYear);
	       	
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
     * 1. 기능 : Step1에서 BSA by VVD 조회 이벤트 처리 <p>
     * 4. 작성자/작성일 : Bae jin hwan/2009.02.18<br>
     * <p/>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
	private EventResponse searchBSAbyVVDList(Event e) throws EventException {
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0166Event event = (EsmCoa0166Event)e;
    	try {
    		LaneSimulationBC command = new LaneSimulationBCImpl();    		
    		SearchBSAbyVVDListVO rtnVo = command.searchBSAbyVVDList(event.getSearchBSAbyVVDListConditionVO());
    		List<SearchBSAbyVVDListVO> list = new ArrayList<SearchBSAbyVVDListVO>();
    		list.add(rtnVo);
//    		eventResponse.setRsVoList(list);
			eventResponse.setRs(list.get(0).getRowSet());
    		eventResponse.setCustomData("rtnVo",rtnVo);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
    }
	/* ====================================================================================
	 	ESM_COA_0052화면
       ==================================================================================== */
    
    /**
     * 1. 기능 : Step2 : Tab1 : Port/TMNL Setting > Port 정보 변경시 해당 Yard Code를 조회한다.<p>
     * 2. 작성자/작성일 : parkeunju/2006.09.08<br>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
    private EventResponse searchSimYardList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0052Event event = (EsmCoa0052Event)e;
    	try {
    		LaneSimulationBC command = new LaneSimulationBCImpl();    		
    		List<SearchSimYardListVO> list = command.searchSimYardList(event.getSearchSimYardConditionVO());
    		eventResponse.setRsVoList(list);
    		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
    }
    /**
     * 1. 기능 : Step2 : Tab1 : Port/TMNL Setting > Retrieve<p>
     * 2. 작성자/작성일 : parkeunju/2006.09.06<br>
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
	private EventResponse searchSimPortList(Event e) throws EventException {
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0052Event event = (EsmCoa0052Event)e;

    	try {
    		LaneSimulationBC command = new LaneSimulationBCImpl();
    		SearchSimPortListVO vo = new SearchSimPortListVO();
    		List<SearchSimPortListVO> list = null;
    		SearchSimLaneListConditionVO conVo = event.getSearchSimLaneListConditionVO();
    		conVo.setFSimDt(conVo.getFSimDt().replace("-",""));
    		vo = command.searchSimPortList(event.getSearchSimLaneListConditionVO());
    		list = vo.getListSet();
   			eventResponse.setRsVoList(list);	
    		if(list != null && list.size() > 0) {
    			eventResponse.setETCData("extd_lane_flg", list.get(0).getExtdLaneFlg());
    			eventResponse.setETCData("vsl_clss_capa", list.get(0).getVslClssCapa());
    			eventResponse.setETCData("vsl_cnt",       list.get(0).getVslCnt());
    			eventResponse.setETCData("max_speed",    list.get(0).getMaxSpeed());
    			eventResponse.setETCData("min_speed",     list.get(0).getMinSpeed());
    			eventResponse.setETCData("svc_dur_dys",   list.get(0).getSvcDurDys());
    			eventResponse.setETCData("brth_itval_dys",list.get(0).getBrthItvalDys());
    		}
		} catch(EventException ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
    }
    /**
     * 1. 기능 : Step2 : Tab1 : Port/TMNL Setting > Existing Lane 일 경우 P/F SKD의 Port TMNL 정보를 조회한다.<p>
     * 4. 작성자/작성일 : parkeunju/2009.02.16<br>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
    private EventResponse multiSimPortGetOpDay(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0052Event event = (EsmCoa0052Event)e;
		SearchSimPortListVO vo = null;
		List<SearchSimPortListVO> list = null;
    	LaneSimulationBC command = new LaneSimulationBCImpl();
    	try {
    		SearchSimLaneListConditionVO conVo = event.getSearchSimLaneListConditionVO();
    		conVo.setFSimDt(conVo.getFSimDt().replace("-", ""));
    		vo = command.multiSimPortGetOpDay(event.getSearchSimLaneListConditionVO(),account);
    		list = vo.getListSet();
    		eventResponse.setRsVoList(list);
    	} catch (EventException de) {
    		rollback();
    		log.error("err " + de.toString(), de);
    		throw new EventException(de.getMessage());
    	}
    	return eventResponse;
    }
    /**
	 * 1. 기능 : Step2 : Tab1 : Port/TMNL Setting > Save
   	 * 4. 작성자/작성일 : parkeunju/2006.09.06<br>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiSimPortInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0052Event event = (EsmCoa0052Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
		SearchSimLaneListConditionVO vo = new SearchSimLaneListConditionVO();
		SearchSimPortListVO[] vos = event.getSearchSimPortListVOS();
		try {
			begin();
			//2010-03-17 윤진영추가 1차SAVE 재시도시 CALCULATION관련 값들 RESET처리
//			for(int i=0;i<vos.length;i++) {
//				vos[i].setEtbDyCd("");
//				vos[i].setEtbDyNo("");
//				vos[i].setEtbTmHrmnt("");
//				vos[i].setEtdDyCd("");
//				vos[i].setEtdDyNo("");
//				vos[i].setEtdTmHrmnt("");
//				vos[i].setTztmHrs("");
//				vos[i].setSeaBufHrs("");
//				vos[i].setIbIpcgoQty("");
//				vos[i].setIbOcnCgoQty("");
//				vos[i].setObOcnCgoQty("");
//				vos[i].setObIpcgoQty("");
//				vos[i].setSeaBufSpd("");
//				vos[i].setActWrkHrs("");
//			}
			//-------------------------------------------------------------
			//vo = command.multiSimPortInfo(event.getSearchSimPortListVOS(),event.getSearchSimLaneListConditionVO(),account);
			//2010-03-17 윤진영추가 1차SAVE 재시도시 CALCULATION관련 값들 RESET처리-------------------
			for(int i=0;i<vos.length;i++) {
				vos[i].setSimDt(vos[i].getSimDt().replace("-",""));
			}
			vo = event.getSearchSimLaneListConditionVO();
			vo.setFSimDt(vo.getFSimDt().replace("-", ""));
			vo = null;
			vo = command.multiSimPortInfo(vos,event.getSearchSimLaneListConditionVO(),account);
			//---------------------------------------------------------------------------------
			eventResponse.setETCData("max_speed",vo.getMaxSpeed());
			eventResponse.setETCData("min_speed",vo.getMinSpeed());
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
    /**
	 * 1. 기능 : Step2 : Tab1 : Port/TMNL Setting > 2차 Save
   	 * 4. 작성자/작성일 : parkeunju/2006.09.06<br>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */	
	public EventResponse multiSimPortInfo2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0052Event event = (EsmCoa0052Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
		try {
			begin();
			SearchSimLaneListConditionVO vo = event.getSearchSimLaneListConditionVO();
			vo.setFSimDt(vo.getFSimDt().replace("-",""));
			SearchSimPortListVO[] vos = event.getSearchSimPortListVOS();
			for(int i=0;i<vos.length;i++) {
				vos[i].setSimDt(vos[i].getSimDt().replace("-",""));
			}
			command.multiSimPortInfo2(event.getSearchSimPortListVOS(),event.getSearchSimLaneListConditionVO(),account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
//  Local calcu logic 사용시####################################################################################
//	public EventResponse multiSimPortCalc(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsmCoa0052Event event = (EsmCoa0052Event)e;
//		LaneSimulationBC command = new LaneSimulationBCImpl();
//		//SearchSimCalcVO vo = new SearchSimCalcVO();
//		try {
//			System.out.println("aaaaaaaaaaaaaa=="+event.getCoaSimTmlInfoVOS().length);
//			
//			//vo = command.multiSimPortInfo(event.getCoaSimTmlInfoVOS());
//			//eventResponse.setETCData("max_spd",vo.getMaxSpeed());
//			//eventResponse.setETCData("min_spd",vo.getMinSpeed());
//			//commit();
//		} catch (Exception de) {
//			//rollback();
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;	
//	}
//	public EventResponse multiSimPortCalc(Event e) throws EventException {
//		
//		log.debug("##################### SC multiSimPortCalc [START]############### ");
//		
//		SearchSimCalcVO grpVO = null;
//		List<SearchSimPortListVO> searchSimPortListVOs = null;
//		EsmCoa0052Event event = (EsmCoa0052Event)e;
//		grpVO = event.getSearchSimCalcVO();
//		searchSimPortListVOs = grpVO.getSearchSimPortListVOs();
////		CoaSimTmlInfoVO coaSimTmlInfoVO = coaSimTmlInfoVOs.get(0);
////		coaSimTmlInfoVOs.set(0, coaSimTmlInfoVO);
////		grpVO.setCoaSimTmlInfoVOs(event.getCoaSimTmlInfoVOs);
//		
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		LaneSimulationBC command = new LaneSimulationBCImpl();
//		try {
//			SearchSimCalcVO rtnVo = command.multiSimPortCalc(grpVO);
//			//CoaSimTmlInfoVO masterVO = rtnVo.getCoaSimTmlInfoVO();
//			List<SearchSimPortListVO> detailVOs  = rtnVo.getSearchSimPortListVOs();
//
//			//eventResponse.setRsVo(masterVO);
//			eventResponse.setRsVoList(detailVOs);
//			//eventResponse.setETCData("max_spd",vo.getMaxSpeed());
//			//eventResponse.setETCData("min_spd",vo.getMinSpeed());
//		} catch (EventException de) {
//			rollback();
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		log.debug("##################### SC multiSimPortCalc [END]############### ");		
//		return eventResponse;
//	}	
//###########################################################################################################	
    /**
	 * 1. 기능 : Step2 : Tab1 : Port/TMNL Setting > Calculation
   * 4. 작성자/작성일 : parkeunju/2009.11.04<br>
   * VSK BC 사용...
   * 
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiSimPortCalc(Event e) throws EventException {
		PfSkdGRPVO grpVO = null;
		EsmCoa0052Event event = (EsmCoa0052Event)e;
		grpVO = event.getPfSkdGRPVO();
		SearchSimCalcVO tmpVO = null;
		List<SearchSimPortListVO> tmpVOs = null;
		tmpVO = event.getSearchSimCalcVO();
		tmpVOs = tmpVO.getSearchSimPortListVOs();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		try {
			PfSkdGRPVO pfSkdGRPVO = command.calPfSkdManual(grpVO);
			//VskPfSkdVO masterVO = pfSkdGRPVO.getVskPfSkdVO();
			List<VskPfSkdDtlVO> detailVOs  = pfSkdGRPVO.getVskPfSkdDtlVOs();
			for(int i=0;i<tmpVOs.size();i++) {
				tmpVOs.get(i).setEtbDyNo(detailVOs.get(i).getEtbDyNo());
				tmpVOs.get(i).setEtbDyCd(detailVOs.get(i).getEtbDyCd());
				tmpVOs.get(i).setEtbTmHrmnt(detailVOs.get(i).getEtbTmHrmnt());
				tmpVOs.get(i).setEtdDyNo(detailVOs.get(i).getEtdDyNo());
				tmpVOs.get(i).setEtdDyCd(detailVOs.get(i).getEtdDyCd());
				tmpVOs.get(i).setEtdTmHrmnt(detailVOs.get(i).getEtdTmHrmnt());
				tmpVOs.get(i).setLnkDist(detailVOs.get(i).getLnkDist());
				tmpVOs.get(i).setTztmHrs(detailVOs.get(i).getTztmHrs());
				tmpVOs.get(i).setSeaBufHrs(detailVOs.get(i).getSeaBufHrs());
				tmpVOs.get(i).setActWrkHrs(detailVOs.get(i).getActWrkHrs());
				tmpVOs.get(i).setPortBufHrs(detailVOs.get(i).getPortBufHrs());
				tmpVOs.get(i).setIbIpcgoQty(detailVOs.get(i).getIbIpcgoQty());
				tmpVOs.get(i).setIbOcnCgoQty(detailVOs.get(i).getIbOcnCgoQty());
				tmpVOs.get(i).setObIpcgoQty(detailVOs.get(i).getObIpcgoQty());
				tmpVOs.get(i).setObOcnCgoQty(detailVOs.get(i).getObOcnCgoQty());
				tmpVOs.get(i).setSimDt(tmpVOs.get(i).getSimDt().replace("-", ""));
				//tmpVOs.get(i).setCrnKnt(detailVOs.get(i).getCrnKnt());
				//tmpVOs.get(i).setTmlProdQty(detailVOs.get(i).getTmlProdQty());
			}
			//eventResponse.setRsVoList(detailVOs);
			eventResponse.setRsVoList(tmpVOs);
			eventResponse.setETCData("max_speed",tmpVOs.get(0).getMaxSpeed());
			eventResponse.setETCData("min_speed",tmpVOs.get(0).getMinSpeed());
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	/**
     * 1. 기능 : Step2 : Tab2 : Route Projection - Lane G.RPB Projection > Retrieve<p>
     * 4. 작성자/작성일 : parkeunju/2006.09.08<br>
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchSimLaneRPBList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0052Event event = (EsmCoa0052Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
    	try {
    		SearchSimLaneListConditionVO conVo = event.getSearchSimLaneListConditionVO();
    		conVo.setFSimDt(conVo.getFSimDt().replace("-", ""));
    		List<SearchSimLaneRPBListVO> list = command.searchSimLaneRPBList(event.getSearchSimLaneListConditionVO());
    		eventResponse.setRsVoList(list);
    		eventResponse.setETCData("result","OK");
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
    }
    /**
	 * 1. 기능 : Step2 : Tab2 : Route Projection - Lane G.RPB Projection > Save
   	 * 4. 작성자/작성일 : parkeunju/2006.09.08<br>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse modifySimGrpb(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0052Event event = (EsmCoa0052Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
		try {
			begin();
			SearchSimLaneRPBListVO[] vos = event.getSearchSimLaneRPBListVOS();
			for(int i=0;i<vos.length;i++) {
				vos[i].setSimDt(vos[i].getSimDt().replace("-",""));
			}			
			command.modifySimGrpb(event.getSearchSimLaneRPBListVOS(),account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
     * 1. 기능 : Step2 : Tab2 : Route Projection - Volume > Retrieve<p>
     * 4. 작성자/작성일 : parkeunju/2006.09.08<br>
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
	private EventResponse searchSimVolProjList(Event e) throws EventException {
		EsmCoa0052Event event = (EsmCoa0052Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			SearchSimConditionVO conVo = event.getSearchSimConditionVO();
    		conVo.setFSimDt(conVo.getFSimDt().replace("-", ""));
			LaneSimulationBC command = new LaneSimulationBCImpl();
			SearchSimRtnRowSetVO rtnVo = command.searchSimVolProjList(event.getSearchSimConditionVO());
			List<SearchSimRtnRowSetVO> list = new ArrayList<SearchSimRtnRowSetVO>();
			list.add(rtnVo);
			eventResponse.setRsVoList(list);
			eventResponse.setCustomData("rtnVo", rtnVo);
			eventResponse.setETCData("header", event.getSearchSimConditionVO().getFHeader());
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}			
    /**
	 * 1. 기능 : Step2 : Tab2 : Route Projection - Volume > Save
   	 * 4. 작성자/작성일 : parkeunju/2006.09.08<br>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiSimVolProj(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0052Event event = (EsmCoa0052Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
		try {
			begin();
	    	MergyVolProjConditionVO vo = event.getMergyVolProjConditionVO();
	    	vo.setSimDt(vo.getSimDt().replaceAll("-",""));
	    	MergyVolProjConditionVO[] vos = event.getMergyVolProjConditionVOS();
	    	for(int i=0;i<vos.length;i++) {
	    		vos[i].setSimDt(vos[i].getSimDt().replaceAll("-",""));
	    	}			
			command.multiSimVolProj(event.getMergyVolProjConditionVO(),event.getMergyVolProjConditionVOS(),account);
			commit();
			eventResponse.setETCData("result", "OK");
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 1. 기능 : Step2 : Tab2 : Route Projection - Volume > Creation
   	 * 4. 작성자/작성일 : parkeunju/2007.01.18<br>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse createSimVolProj(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0052Event event = (EsmCoa0052Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
		try {
			begin();
	    	MergyVolProjConditionVO vo = event.getMergyVolProjConditionVO();
	    	vo.setSimDt(vo.getSimDt().replaceAll("-",""));
	    	SearchSimLaneListConditionVO convo = event.getSearchSimLaneListConditionVO();
	    	convo.setFSimDt(convo.getFSimDt().replaceAll("-",""));
			command.createSimVolProj(event.getMergyVolProjConditionVO(),event.getSearchSimLaneListConditionVO(),account);
			commit();
			eventResponse.setETCData("result", "OK");
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
     * 1. 기능 : Step2 : Tab2 : Route Projection - G.RPB > Retrieve<p>
     * 4. 작성자/작성일 : 윤진영/2009.09.02<br>
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
	private EventResponse searchSimGrpbProjList(Event e) throws EventException {
        EsmCoa0052Event event = (EsmCoa0052Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            LaneSimulationBC command = new LaneSimulationBCImpl();
            SearchSimConditionVO vo = event.getSearchSimConditionVO();
	    	vo.setFSimDt(vo.getFSimDt().replaceAll("-",""));
            //####################################################################################################
            SearchSimRtnRowSetVO rtnVo = command.searchSimGrpbProjList(event.getSearchSimConditionVO());		
            // detail sheet 조회
            //####################################################################################################
            List<SearchSimRtnRowSetVO> list = new ArrayList<SearchSimRtnRowSetVO>();
            list.add(rtnVo);
            eventResponse.setRsVoList(list);
            eventResponse.setCustomData("rtnVo", rtnVo);
            eventResponse.setETCData("header", event.getSearchSimConditionVO().getFHeader());
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    /**
	 * 1. 기능 : Step2 : Tab2 : Route Projection - G.RPB > Save
   	 * 4. 작성자/작성일 : parkeunju/2006.09.08<br>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiSimGrpbProj(Event e) throws EventException {
        EsmCoa0052Event event = (EsmCoa0052Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			LaneSimulationBC command = new LaneSimulationBCImpl();
			begin();
	    	MergyVolProjConditionVO vo = event.getMergyVolProjConditionVO();
	    	vo.setSimDt(vo.getSimDt().replace("-",""));
	    	MergyVolProjConditionVO[] vos = event.getMergyVolProjConditionVOS();
	    	for(int i=0;i<vos.length;i++) {
	    		vos[i].setSimDt(vos[i].getSimDt().replace("-",""));
	    	}			
			command.multiSimGrpbProj(event.getMergyVolProjConditionVO(),event.getMergyVolProjConditionVOS(),account);
			eventResponse.setETCData("result","OK");
			commit();
		} catch (EventException de) {
			rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
        	throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * 1. 기능 : Step2 : Tab3 : TMNL Transit Time > Retrieve
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @throws EventException
	 */
    private EventResponse searchTMLOPDysList(Event e) throws EventException {
        EsmCoa0052Event event = (EsmCoa0052Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        List<SearchTMLOPDysListVO> list = new ArrayList<SearchTMLOPDysListVO>();
        try {
            LaneSimulationBC command = new LaneSimulationBCImpl();
            SearchTMLOPDysListVO vo = event.getSearchTMLOPDysListVO();
	    	vo.setSimDt(vo.getSimDt().replace("-",""));
    		list = command.searchTMLOPDysList(event.getSearchTMLOPDysListVO());
    		eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * 1. 기능 : Step2 : Tab3 : TMNL Transit Time > Save<br>
     * @param e Event
     * @return response GeneralEventResponse
     * @throws EventException
     */
	public EventResponse modifiyTMLOPDys(Event e) throws EventException {
        EsmCoa0052Event event = (EsmCoa0052Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			LaneSimulationBC command = new LaneSimulationBCImpl();
			begin();
	    	SearchTMLOPDysListVO vo = event.getSearchTMLOPDysListVO();
	    	vo.setSimDt(vo.getSimDt().replace("-",""));
	    	SearchTMLOPDysListVO[] vos = event.getSearchTMLOPDysListVOS();
	    	for(int i=0;i<vos.length;i++) {
	    		vos[i].setSimDt(vos[i].getSimDt().replace("-",""));
	    	}
			command.modifyTMLOPDys(event.getSearchTMLOPDysListVO(),event.getSearchTMLOPDysListVOS(),account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 1. 기능 : Step2 : Tab3 : TMNL Transit Time > Create
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @throws EventException
	 */
	public EventResponse createTMLOPDys(Event e) throws EventException {
        EsmCoa0052Event event = (EsmCoa0052Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			LaneSimulationBC command = new LaneSimulationBCImpl();
			begin();
			SearchTMLOPDysListVO vo = event.getSearchTMLOPDysListVO();
	    	vo.setSimDt(vo.getSimDt().replace("-",""));
			command.createTMLOPDys(event.getSearchTMLOPDysListVO(),account);
			eventResponse.setETCData("result","OK");
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/* ====================================================================================
 	   ESM_COA_0053화면
       ==================================================================================== */
    /**
     * 1. 기능 : Step3 : Tab1 : CM_Lane Summary > Retrieve <p>
     * 4. 작성자/작성일 : parkeunju/2006.09.13<br>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
    private EventResponse searchSimCgoCostList(Event e) throws EventException {
    	EsmCoa0053Event event = (EsmCoa0053Event)e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try {
    		LaneSimulationBC command = new LaneSimulationBCImpl();
    		SearchSimConditionVO vo = event.getSearchSimConditionVO();
	    	vo.setFSimDt(vo.getFSimDt().replace("-",""));
    		SearchSimRtnRowSetVO rtnVo = command.searchSimCgoCostList(event.getSearchSimConditionVO());
    		eventResponse.setRs(rtnVo.getRowSet());
    		return eventResponse;
    	}catch(EventException ex){
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(ex.getMessage());
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}	
    }
    /**
     * 1. 기능 : Step3 : Tab1 : CM_Route Summary > Retrieve <p>
     * 4. 작성자/작성일 : parkeunju/2006.09.13<br>
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchSimCMCostList(Event e) throws EventException {
        EsmCoa0053Event event = (EsmCoa0053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            LaneSimulationBC command = new LaneSimulationBCImpl();
            SearchSimConditionVO vo = event.getSearchSimConditionVO();
	    	vo.setFSimDt(vo.getFSimDt().replace("-",""));            
            List<SearchSimRtnRowSetVO> list = command.searchSimCMCostList(event.getSearchSimConditionVO());
            eventResponse.setRsVoList(list);
            eventResponse.setETCData("header", event.getSearchSimConditionVO().getFHeader());
            return eventResponse;
        }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
    }
	/**
	 * 1. 기능 : Step3 : Tab1 : CM_Route Summary > Save <p>
   	 * 4. 작성자/작성일 : parkeunju/2006.09.13<br>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse modifySimCMCost(Event e) throws EventException {
        EsmCoa0053Event event = (EsmCoa0053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
            LaneSimulationBC command = new LaneSimulationBCImpl();
            begin();
            SearchSimConditionVO vo = event.getSearchSimConditionVO();
	    	vo.setFSimDt(vo.getFSimDt().replace("-",""));
	    	CoaSimCtrbMgnCostVO[] vos = event.getSimCtrbMgnCostVOS();
	    	for(int i=0;i<vos.length;i++) {
	    		vos[i].setSimDt(vos[i].getSimDt().replace("-",""));
	    	}	    	
            command.modifySimCMCost(event.getSimCtrbMgnCostVOS(),event.getSearchSimConditionVO(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
    /**
     * 1. 기능 :  Step3 : Tab2 : Port Charge > Retrieve <p>
     * 4. 작성자/작성일 : parkeunju/2006.09.15<br>
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchSimPortChargeList(Event e) throws EventException {
        EsmCoa0053Event event = (EsmCoa0053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            LaneSimulationBC command = new LaneSimulationBCImpl();
            SearchSimConditionVO vo = event.getSearchSimConditionVO();
	    	vo.setFSimDt(vo.getFSimDt().replace("-",""));
            List<SearchSimPortChargeListVO> list = command.searchSimPortChargeList(event.getSearchSimConditionVO());
            eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
	/**
	 * 1. 기능 : Step3 : Tab2 : Port Charge > Save <p>
   	 * 4. 작성자/작성일 : parkeunju/2006.09.15<br>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiSimPortCharge(Event e) throws EventException {
        EsmCoa0053Event event = (EsmCoa0053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			LaneSimulationBC command = new LaneSimulationBCImpl();
			begin();
	    	SearchSimConditionVO vo = event.getSearchSimConditionVO();
	    	vo.setFSimDt(vo.getFSimDt().replace("-",""));
	    	CoaSimPortChgVO[] vos = event.getSimPortChgVOS();
	    	for(int i=0;i<vos.length;i++) {
	    		vos[i].setSimDt(vos[i].getSimDt().replace("-",""));
	    	}
			command.multiSimPortCharge(event.getSimPortChgVOS(),event.getSearchSimConditionVO(),account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 1. 기능 : Step3 : Tab2 : Port Charge > Create <p>
	 * 4. 작성자/작성일 : parkeunju/2006.09.15<br>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse createSimPortCharge(Event e) throws EventException {
        EsmCoa0053Event event = (EsmCoa0053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			LaneSimulationBC command = new LaneSimulationBCImpl();
			begin();
			SearchSimConditionVO vo = event.getSearchSimConditionVO();
			vo.setFSimDt(vo.getFSimDt().replace("-",""));
			vo.setUsrId(account.getUsr_id());
			command.createSimPortCharge(vo);
			commit();
			eventResponse.setETCData("result", "OK");
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    /**
     * 1. 기능 : Step3 : Tab3 : Bunker Cost > Retrieve<p>
     * 2. 작성자/작성일 : parkeunju/2006.09.15<br>
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchSimBunkerList(Event e) throws EventException {
        EsmCoa0053Event event = (EsmCoa0053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            LaneSimulationBC command = new LaneSimulationBCImpl();
            SearchSimConditionVO vo = event.getSearchSimConditionVO();
	    	vo.setFSimDt(vo.getFSimDt().replace("-",""));
            List<SearchSimBunkerListVO> list = command.searchSimBunkerList(event.getSearchSimConditionVO());
            eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    /**
     * 1. 기능 : Step3 : Tab3 : Bunker Cost > Basic<p>
     * 2. 작성자/작성일 : parkeunju/2006.09.15<br>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
    private EventResponse createSimBunkerList(Event e) throws EventException {
        EsmCoa0053Event event = (EsmCoa0053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			LaneSimulationBC command = new LaneSimulationBCImpl();
			begin();
			SearchSimConditionVO vo = event.getSearchSimConditionVO();
	    	vo.setFSimDt(vo.getFSimDt().replace("-",""));
	    	CoaSimBnkCostVO[] vos = event.getSimBnkCostVOS();
	    	for(int i=0;i<vos.length;i++) {
	    		vos[i].setSimDt(vos[i].getSimDt().replace("-",""));
	    	}
			command.createSimBunkerList(event.getSimBnkCostVOS(),event.getSearchSimConditionVO(), account);
			commit();
			eventResponse.setETCData("result", "OK");
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
    	return eventResponse;
    }
	/**
	 * 1. 기능 : Step3 : Tab3 : Bunker Cost > Save<p>
   	 * 2. 작성자/작성일 : parkeunju/2006.09.15<br>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiSimBunkerCost(Event e) throws EventException {
        EsmCoa0053Event event = (EsmCoa0053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			LaneSimulationBC command = new LaneSimulationBCImpl();
			begin();
			SearchSimConditionVO vo = event.getSearchSimConditionVO();
	    	vo.setFSimDt(vo.getFSimDt().replace("-",""));
	    	CoaSimBnkCostVO[] vos = event.getSimBnkCostVOS();
	    	for(int i=0;i<vos.length;i++) {
	    		vos[i].setSimDt(vos[i].getSimDt().replace("-",""));
	    	}
			command.multiSimBunkerCost(event.getSimBnkCostVOS(), event.getSearchSimConditionVO(), account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
     * 1. 기능 : Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Header<p>
     * 2. 작성자/작성일 : parkeunju/2006.09.20<br>
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
	public EventResponse searchSimDailyHireList(Event e) throws EventException {
        EsmCoa0053Event event = (EsmCoa0053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			LaneSimulationBC command = new LaneSimulationBCImpl();
			CoaSimCtrbMgnCostVO convo = event.getCoaSimCtrbMgnCostVO();
	    	convo.setSimDt(convo.getSimDt().replace("-",""));			
			SearchSimDailyHireInfoVO vo = command.searchSimDailyHireList(event.getCoaSimCtrbMgnCostVO());
			eventResponse.setRs(vo.getDbRowset());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
     * 1. 기능 : Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Creation<p>
     * 2. 작성자/작성일 : parkeunju/2006.09.20<br>
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */	
    private EventResponse createSimDailyHire(Event e) throws EventException {
        EsmCoa0053Event event = (EsmCoa0053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			LaneSimulationBC command = new LaneSimulationBCImpl();
			CreateSimDailyHireVO vo = event.getCreateSimDailyHireVO();
	    	vo.setFSimDt(vo.getFSimDt().replace("-",""));
			command.createSimDailyHire(event.getCreateSimDailyHireVO(),account);
			eventResponse.setETCData("result", "OK");
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 1. 기능 : Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Save
   	 * 2. 작성자/작성일 : parkeunju/2006.09.20<br>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiSimDailyHire(Event e) throws EventException {
        EsmCoa0053Event event = (EsmCoa0053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			LaneSimulationBC command = new LaneSimulationBCImpl();
			CreateSimDailyHireVO vo = event.getCreateSimDailyHireVO();
	    	vo.setFSimDt(vo.getFSimDt().replace("-",""));
	    	CoaSimDlyHirVO[] vos = event.getSimDlyHirVOS();
	    	for(int i=0;i<vos.length;i++) {
	    		vos[i].setSimDt(vos[i].getSimDt().replace("-",""));
	    	}
			command.multiSimDailyHire(event.getSimDlyHirVOS(),event.getCreateSimDailyHireVO(),account);
			eventResponse.setETCData("result", "OK");
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 1. 기능 : Step3 : Tab5 : Network Cost > Create<p>
	 * 2. 작성자/작성일 : parkeunju/2006.09.20<br>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse createSimNWCost(Event e) throws EventException {
        EsmCoa0053Event event = (EsmCoa0053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			LaneSimulationBC command = new LaneSimulationBCImpl();
			begin();
			CoaSimCtrbMgnCostVO vo = event.getCoaSimCtrbMgnCostVO();
	    	vo.setSimDt(vo.getSimDt().replace("-",""));
			int rtnVal = command.createSimNWCost(event.getCoaSimCtrbMgnCostVO(),account);
			if(rtnVal > 0) {
				eventResponse.setETCData("result", "OK");
			}
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    /**
     * 1. 기능 : Step3 : Tab5 : Network Cost > Retrieve<p>
     * 4. 작성자/작성일 : parkeunju/2006.09.25<br>
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchSimNWCostList(Event e) throws EventException {
        EsmCoa0053Event event = (EsmCoa0053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			LaneSimulationBC command = new LaneSimulationBCImpl();
			CoaSimCtrbMgnCostVO convo = event.getCoaSimCtrbMgnCostVO();
	    	convo.setSimDt(convo.getSimDt().replace("-",""));
			SearchSimDailyHireInfoVO vo = command.searchSimNWCostList(event.getCoaSimCtrbMgnCostVO());
			eventResponse.setRs(vo.getDbRowset());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
    }
    /**
     * 1. 기능 : Step3 : Tab6 : After Ocean T/S > Retrieve<p>
     * 4. 작성자/작성일 : parkeunju/2006.09.25<br>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
    private EventResponse searchSimAfterOcenaTSList(Event e) throws EventException {
        EsmCoa0053Event event = (EsmCoa0053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			LaneSimulationBC command = new LaneSimulationBCImpl();
			CoaSimCtrbMgnCostVO convo = event.getCoaSimCtrbMgnCostVO();
	    	convo.setSimDt(convo.getSimDt().replace("-",""));
			SearchSimDailyHireInfoVO vo = command.searchSimAfterOcenaTSList(event.getCoaSimCtrbMgnCostVO());
			eventResponse.setRs(vo.getDbRowset());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
    }
    /**
     * 1. 기능 : Step3 : Tab4 : TO/C Hire Popup ( Hire/TC Rev/Layup(Daily) Open)  > Retrieve<p>
     * 4. 작성자/작성일 : <br>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
    private EventResponse searchTOCHireList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			LaneSimulationBC command = new LaneSimulationBCImpl();
			List<SearchTocHireListVO> list = command.searchTOCHireList();
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 1. 기능 : Step3 : Tab4 : TO/C Hire Popup ( Hire/TC Rev/Layup(Daily) Open)  > Save<p>
	 * 2. 작성자/작성일 : parkeunju/2006.09.20<br>
	 * @param e Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiTOCHire(Event e) throws EventException {
    	EsmCoa0167Event event = (EsmCoa0167Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			LaneSimulationBC command = new LaneSimulationBCImpl();
			command.multiTOCHire(event.getTmChtrOutHirVos(),event.getSearchTocHireListVOs(),account);
			eventResponse.setETCData("result", "OK");
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}   
	/**
	 * ESM_COA_0150 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0150(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		try {
				String array[][] = {
					/*1.IOC*/
					{"CD00593", "000020: : ", ""},	
					/*2.dir_cd*/
					{"CD00206", "000020: : ", ""}
					
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
    /**
     * 1. 기능 : Step1에서 Continent Pair 조회 이벤트 처리<p>
     * 2. 처리개요 :  <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : parkeunju/2007.12.20<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
    private EventResponse searchSimContiPairList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0150Event event = (EsmCoa0150Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
		try {
			SearchSimContiPairListVO vo = event.getSearchSimContiPairListVO();
			vo.setSimDt(vo.getSimDt().replace("-", ""));
			List<SearchSimContiPairListVO> list = command.searchSimContiPairList(event.getSearchSimContiPairListVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
    }
    /**
     * 1. 기능 :  Step1에서 Continent Pair multi 이벤트 처리<p>
     * 2. 처리개요 :  <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : parkeunju/2007.12.20<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
    private EventResponse multiSimContiPair(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0150Event event = (EsmCoa0150Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
		try {
			SearchSimContiPairListVO[] vos = event.getSearchSimContiPairListVOS();
			for(int i=0;i<vos.length;i++) {
				vos[i].setSimDt(vos[i].getSimDt().replace("-",""));
			}
			command.multiSimContiPair(event.getSearchSimContiPairListVOS(), account);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;    	
    }
    /**
     * 1. 기능 : Step1에서 Continent Pair 조회 이벤트 처리<p>
     * 2. 처리개요 :  <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : parkeunju/2007.12.20<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
    private EventResponse searchSimConsumList(Event e) throws EventException {
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0151Event event = (EsmCoa0151Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
    	try {
    		List<CoaBnkCsmVO> list = command.searchSimConsumList(event.getCoaBnkCsmVO());
    		eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
    }
    /**
     * 1. 기능 :  Step1에서 Continent Pair multi 이벤트 처리<p>
     * 2. 처리개요 :  <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : parkeunju/2007.12.20<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return response GeneralEventResponse
     * @exception EventException
     */
    private EventResponse multiSimConsum(Event e) throws EventException {
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmCoa0151Event event = (EsmCoa0151Event)e;
    	LaneSimulationBC command = new LaneSimulationBCImpl();
    	try {
    		begin();
    		command.multiSimConsum(event.getCoaBnkCsmVOS(), account);
    		commit();
    	} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
    }    
/*====================================================================================================================================*/	
    
    /**
     * Simulation Report의 Report No. 멀티콤보 세팅을 위한 데이터 조회
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchSimReportNoList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmCoa0054Event event = (EsmCoa0054Event)e;
    	LaneSimulationBC command = new LaneSimulationBCImpl();
    	SearchSimLaneListConditionVO vo = null;
    	DBRowSet dbRowSet = null;
        try {        	
        	SearchSimLaneListConditionVO convo = event.getSearchSimLaneListConditionVO();
        	convo.setFSimDt(convo.getFSimDt().replace("-",""));
            vo = command.searchSimReportNoList(event.getSearchSimLaneListConditionVO());
            dbRowSet = vo.getDbRowSet();
            eventResponse.setCustomData("result", dbRowSet);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    /**
     * 1. 기능 : Simulation Report 조회 이벤트 처리<p>
     * 2. 처리개요 :  <p>
     *    - LaneSimulation대한 Sheet1 리스트 중 조회 이벤트 처리<p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : parkeunju/2006.09.28<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
  	 * <p/>
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchSimSummaryReportList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmCoa0054Event event = (EsmCoa0054Event)e;
    	LaneSimulationBC command = new LaneSimulationBCImpl();
    	SearchReportConditionVO vo = null;
    	DBRowSet dbRowSet = null;
        try {        	
        	SearchReportConditionVO convo = event.getSearchReportConditionVO();
        	convo.setFSimDt(convo.getFSimDt().replace("-",""));
            vo = command.searchSimSummaryReportList(event.getSearchReportConditionVO());
            dbRowSet = vo.getDbRowSet();
            eventResponse.setETCData("header",vo.getHeader());
            eventResponse.setRs(dbRowSet);
            
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
   /**
     * Simulation Report의 COA_SIM_RPT_MST ROW수
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchSimReportMasterCount(Event e) throws EventException{
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmCoa0168Event event = (EsmCoa0168Event)e;
    	LaneSimulationBC command = new LaneSimulationBCImpl();
    	int cnt = 0;
        try {        	
        	SearchSimLaneListConditionVO convo = event.getSearchSimLaneListConditionVO();
        	convo.setFSimDt(convo.getFSimDt().replace("-",""));
        	cnt = command.searchSimReportMasterCount(event.getSearchSimLaneListConditionVO());
        	eventResponse.setETCData("cnt", String.valueOf(cnt));
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    /**
     * Simulation Report의 첫번째 Report 생성
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
    private EventResponse createDefaultSimReport(Event e) throws EventException{
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmCoa0168Event event = (EsmCoa0168Event)e;
    	LaneSimulationBC command = new LaneSimulationBCImpl();
    	List<SearchSimReportMasterListVO> list = null;
    	int cnt = 0;
        try {        	
        	SearchSimLaneListConditionVO convo = event.getSearchSimLaneListConditionVO();
        	convo.setFSimDt(convo.getFSimDt().replace("-",""));        	
        	list = command.createDefaultSimReport(event.getSearchSimLaneListConditionVO(),account);
        	eventResponse.setRsVoList(list);
        	eventResponse.setETCData("cnt", String.valueOf(cnt));
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    	return eventResponse;
    }
   /**
     * Simulation Report의 Popup 조회
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchSimReportMasterList(Event e) throws EventException{
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmCoa0168Event event = (EsmCoa0168Event)e;
    	LaneSimulationBC command = new LaneSimulationBCImpl();
        try {     
        	SearchSimLaneListConditionVO convo = event.getSearchSimLaneListConditionVO();
        	convo.setFSimDt(convo.getFSimDt().replace("-",""));
            List<SearchSimReportMasterListVO> list = command.searchSimReportMasterList(event.getSearchSimLaneListConditionVO());
            eventResponse.setRsVoList(list);
            
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    /**
     * Simulation Report의 Popup 레포트 추가
  	 * @param e Event
  	 * @return response GeneralEventResponse
  	 * @exception EventException
  	 */
    private EventResponse multiSimReport(Event e) throws EventException{
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmCoa0168Event event = (EsmCoa0168Event)e;
    	LaneSimulationBC command = new LaneSimulationBCImpl();
    	try {
    		begin();
    		MultiSimSummaryRptVO[] vos = event.getMultiSimSummaryRptVOS();
    		for(int i=0;i<vos.length;i++) {
    			vos[i].setSimDt(vos[i].getSimDt().replace("-", ""));
    		}
    		command.multiSimReport(event.getMultiSimSummaryRptVOS(),account);
    		commit();
    	} catch (EventException de) {
    		rollback();
    		log.error("err " + de.toString(), de);
    		throw new EventException(de.getMessage());
    	}
    	return eventResponse;
    }
    /**                                                                                                                               
     * 1. 기능 : Step1에서 Non Operating Expense 조회 이벤트 처리<p>                                                                         
     * 4. 작성자/작성일 : jinyoungYoon/2010.01.12<br>                                                                                   
     * <p/>                                                                                                                           
     * @param e Event                                                                                                                 
     * @return response GeneralEventResponse                                                                                      
     * @exception EventException                                                                                                      
     */                                                                                                                               
    private EventResponse searchNonOpExpnList(Event e) throws EventException {                                                         
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체                                                                   
    	GeneralEventResponse eventResponse = new GeneralEventResponse();                                                                                             
    	EsmCoa0164Event event = (EsmCoa0164Event)e;
    	try {                                                                                                                           
    		LaneSimulationBC command = new LaneSimulationBCImpl();     
    		SearchConditionVO vo = event.getSearchConditionVO();
    		vo.setFSimDt(vo.getFSimDt().replace("-",""));
    		List<CoaSimNonOpExpnVO> list = command.searchNonOpExpnList(event.getSearchConditionVO());
    		eventResponse.setRsVoList(list);                                                                                
    	} catch (EventException de) {                                                                                                   
    		log.error("err " + de.toString(), de);                                                                                        
    		throw new EventException(de.getMessage());                                                                                    
    	}                                                                                                                               
    	return eventResponse;                                                                                                         
    }                                                                                                                                 
    /**                                                                                                                               
     * 1. 기능 :  Step1에서 Non Operating Expense 이벤트 처리<p>                                                                       
     * 4. 작성자/작성일 : jinyoungYoon/2010.01.12<br>                                                                                    
     * <p/>                                                                                                                           
     * @param e Event                                                                                                                 
     * @return response GeneralEventResponse                                                                                      
     * @exception EventException                                                                                                      
     */                                                                                                                               
    private EventResponse multiNonOpExpn(Event e) throws EventException {                                                              
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체                                                                   
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmCoa0164Event event = (EsmCoa0164Event)e;
    	try {                                                                                                                           
    		begin();                                                                                                                      
    		LaneSimulationBC command = new LaneSimulationBCImpl();
    		command.multiNonOpExpn(event.getCoaSimNonOpExpnVOS(),account);  
    		commit();                                                                                                                     
    	} catch (EventException de) {                                                                                                   
    		rollback();                                                                                                                   
    		log.error("err " + de.toString(), de);                                                                                        
    		throw new EventException(de.getMessage());                                                                                    
    	}                                                                                                                               
    	return eventResponse;                                                                                                  
    }   
    /**
	 * ESM_COA_0051 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0051(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		EsmCoa0051Event event = (EsmCoa0051Event)e;
		String f_slan_cd = JSPUtil.getNull(event.getSearchSimLaneListConditionVO().getFSlanCd());
		String f_dept_cd = JSPUtil.getNull(event.getSearchSimLaneListConditionVO().getFDeptCd());
		String f_dept_cd2 = JSPUtil.getNull(event.getSearchSimLaneListConditionVO().getFDeptCd2());
		try {
			if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
    		    String array[][] = { {"SimInfo",f_slan_cd+ "|" +f_dept_cd2,"Blank"},
    		    					};
    		    eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { 
 						 {"rLane2",event.getSearchSimLaneListConditionVO().getFTrdCd(),""}
 						};
			 	;
			 	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else /*if   (e.getFormCommand().isCommand(FormCommand.INIT))*/{

	   		    if (f_dept_cd.equals("")) {
	   		    	if(account.getOfc_cd().length() == 5) f_dept_cd = account.getOfc_cd().substring(2,5);
	               	else f_dept_cd = account.getOfc_cd().substring(3,6);
	   		    	event.getSearchSimLaneListConditionVO().setFDeptCd(f_dept_cd);
	   		    }else{
	   		    	if (f_dept_cd2.equals("") && !e.getFormCommand().isCommand(FormCommand.INIT))
		   		    	event.getSearchSimLaneListConditionVO().setFDeptCd2(f_dept_cd);
		   		    
	   		    }
	   		   
	   		    
	   		    String f_sim_dt = JSPUtil.getNull(event.getSearchSimLaneListConditionVO().getFSimDt());
	   		    String f_sim_no = JSPUtil.getNull(event.getSearchSimLaneListConditionVO().getFSimNo());
	   		    String sim = f_dept_cd + "|" + f_sim_dt.replaceAll("-", "") +"|" +  f_sim_no;
	   		    
	   		    event.getSearchSimLaneListConditionVO().setFSim(sim);
	   		    event.getSearchSimLaneListConditionVO().setFSimDt(JSPUtil.getNull(event.getSearchSimLaneListConditionVO().getFSimDt(),DateTime.getShortDateString()));
	   		    event.getSearchSimLaneListConditionVO().setFUsrId(JSPUtil.getNull(event.getSearchSimLaneListConditionVO().getFUsrId(),account.getUsr_id()));
	   		    
				String array[][] = {
					/*1.f_slan_cd*/	
					{"simLane", "", "Blank"},
					/*2.f_dept_cd2*/
					{"dept", "", "Blank"},
					/*3.f_sim*/
					{"SimInfo", f_slan_cd+ "|" +f_dept_cd2, "Blank"},
					/*4.trade*/
					{"trade", "", ""},
					/*5.subTrade*/
					{"subTrade", "AES", ""},
					/*6.IOC*/
					{"IOC", "", ""},
					/*7.dir_cd*/
					{"Dir", "", ""},
					/*8.vessel*/
					{"simVsl", "", ""},
					/*9.ownerShip*/
					{"CD00230", "000001: : ", ""},
					/*10.vslOpr*/
					{"CD00231", "000001: : ", ""}
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
				eventResponse.setETCData(event.getSearchSimLaneListConditionVO().getColumnValues());
    	   }	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * ESM_COA_0051 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0052(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		EsmCoa0052Event event = (EsmCoa0052Event)e;
		String f_slan_cd = JSPUtil.getNull(event.getSearchSimLaneListConditionVO().getFSlanCd());
		String f_dept_cd = JSPUtil.getNull(event.getSearchSimLaneListConditionVO().getFDeptCd());
		String f_dept_cd2 = JSPUtil.getNull(event.getSearchSimLaneListConditionVO().getFDeptCd2());
		try {
			if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
    		    String array[][] = { {"SimInfo",f_slan_cd+ "|" +f_dept_cd2,"Blank"},
    		    					};
    		    eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { 
 						 {"rLane",event.getSearchSimLaneListConditionVO().getFTrdCd(),""}
 						};
			 	;
			 	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else /*if   (e.getFormCommand().isCommand(FormCommand.INIT))*/{
    		   
    		    if (f_dept_cd.equals("")) {
    		    	if(account.getOfc_cd().length() == 5) f_dept_cd = account.getOfc_cd().substring(2,5);
                	else f_dept_cd = account.getOfc_cd().substring(3,6);
    		    	event.getSearchSimLaneListConditionVO().setFDeptCd(f_dept_cd);
    		    }
    		    
    		    if (f_dept_cd2.equals("")) 
    		    	event.getSearchSimLaneListConditionVO().setFDeptCd2(f_dept_cd);
    		    
    		    String f_sim_dt = JSPUtil.getNull(event.getSearchSimLaneListConditionVO().getFSimDt());
    		    String f_sim_no = JSPUtil.getNull(event.getSearchSimLaneListConditionVO().getFSimNo());
    		    String sim  = f_dept_cd + "|" + f_sim_dt.replaceAll("-", "") +"|" +  f_sim_no;
    		    
    		    event.getSearchSimLaneListConditionVO().setFSim(sim);
    		    event.getSearchSimLaneListConditionVO().setFSimDt(JSPUtil.getNull(event.getSearchSimLaneListConditionVO().getFSimDt(),DateTime.getShortDateString()));
    		    event.getSearchSimLaneListConditionVO().setFUsrId(JSPUtil.getNull(event.getSearchSimLaneListConditionVO().getFUsrId(),account.getUsr_id()));
    		    
				String array[][] = {
					/*1.f_slan_cd*/	
					{"simLane", "", "Blank"},
					/*2.f_dept_cd2*/
					{"dept", "", "Blank"},
					/*3.f_sim*/
					{"SimInfo", f_slan_cd+ "|" +f_dept_cd, "Blank"},
					/*4.Trade*/
					{"trade","",""},
					/*5.R/Lane*/
					{"rLane","",""},
					/*6.Dir.*/
					{"CD00593","",""},
					/*7.dir_cd*/
					{"Dir", "", ""}
					
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
				eventResponse.setETCData(event.getSearchSimLaneListConditionVO().getColumnValues()); 
    	   }	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
    /**
	 * ESM_COA_0053 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0053(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		EsmCoa0053Event event = (EsmCoa0053Event)e;
		SearchSimLaneListConditionVO convo = event.getSearchSimLaneListConditionVO();
		String f_slan_cd = JSPUtil.getNull(convo.getFSlanCd());
		String f_dept_cd = JSPUtil.getNull(convo.getFDeptCd());
		String f_dept_cd2 = JSPUtil.getNull(convo.getFDeptCd2());
		try {
			if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
    		    String array[][] = { {"SimInfo",f_slan_cd+ "|" +f_dept_cd2,"Blank"},
    		    					};
    		    eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { 
 						 {"rLane2",convo.getFTrdCd(),""}
 						};
			 	;
			 	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else /*if   (e.getFormCommand().isCommand(FormCommand.INIT))*/{
	   		    if (f_dept_cd.equals("")) {
	   		    	if(account.getOfc_cd().length() == 5) f_dept_cd = account.getOfc_cd().substring(2,5);
	               	else f_dept_cd = account.getOfc_cd().substring(3,6);
	   		    	convo.setFDeptCd(f_dept_cd);
	   		    }
	   		    
	   		    if (f_dept_cd2.equals("")) 
	   		    	convo.setFDeptCd2(f_dept_cd);
	   		    
	   		    String f_sim_dt = JSPUtil.getNull(convo.getFSimDt());
	   		    String f_sim_no = JSPUtil.getNull(convo.getFSimNo());
	   		    String sim = f_dept_cd + "|" + f_sim_dt.replaceAll("-", "") +"|" +  f_sim_no;
	   		    
	   		    convo.setFSim(sim);
	   		    convo.setFSimDt(JSPUtil.getNull(convo.getFSimDt(),DateTime.getShortDateString()));
	   		    convo.setFUsrId(JSPUtil.getNull(convo.getFUsrId(),account.getUsr_id()));
	   		    eventResponse.setETCData(event.getSearchSimLaneListConditionVO().getColumnValues());
	   		 
				String array[][] = {
					/*1.f_slan_cd*/	
					{"simLane", "", "Blank"},
					/*2.f_dept_cd2*/
					{"dept", "", "Blank"},
					/*3.f_sim*/
					{"SimInfo", f_slan_cd+ "|" +f_dept_cd2, "Blank"},
					{"codeItem", "", ""},
					{"simOpAcct", "", ""}
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
				
				String cm_header_cd = "";
	            String cm_header_nm = "";
	            String op_header_cd = "";
	            String op_header_nm = "";
	            
    			CommonBC commonBC = new CommonBCImpl();
    			cm_header_cd = commonBC.getIbCodeCombo("cm_header", "codeItem", "", "code");
    			cm_header_nm = commonBC.getIbCodeCombo("cm_header", "codeItem", "", "name");
    			op_header_cd = commonBC.getIbCodeCombo("cm_header", "simOpAcct", "", "code");
    			op_header_nm = commonBC.getIbCodeCombo("cm_header", "simOpAcct", "", "name");
    			
    			if(cm_header_cd.indexOf('|') > 0) cm_header_cd = cm_header_cd.substring(2, cm_header_cd.length());
    			if(cm_header_nm.indexOf('|') > 0) cm_header_nm = cm_header_nm.substring(2, cm_header_nm.length());
    			if(op_header_cd.indexOf('|') > 0) op_header_cd = op_header_cd.substring(2, op_header_cd.length());
    			if(op_header_nm.indexOf('|') > 0) op_header_nm = op_header_nm.substring(2, op_header_nm.length());
    			
				eventResponse.setETCData("cm_header_cd",cm_header_cd);
				eventResponse.setETCData("cm_header_nm",cm_header_nm);
				eventResponse.setETCData("op_header_cd",op_header_cd);
				eventResponse.setETCData("op_header_nm",op_header_nm);
				
    	   }	
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
    /**
	 * ESM_COA_0054 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchComBoCdList0054(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		EsmCoa0054Event event = (EsmCoa0054Event)e;
		LaneSimulationBC command = new LaneSimulationBCImpl();
		SearchSimLaneListConditionVO convo = event.getSearchSimLaneListConditionVO();
		String f_slan_cd = JSPUtil.getNull(convo.getFSlanCd());
		String f_dept_cd = JSPUtil.getNull(convo.getFDeptCd());
		String f_dept_cd2 = JSPUtil.getNull(convo.getFDeptCd2());
		try {
			if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
    		    String array[][] = { {"SimInfo",f_slan_cd+ "|" +f_dept_cd2,"Blank"},
    		    					};
    		    eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { 
 						 {"rLane2",convo.getFTrdCd(),""}
 						};
			 	;
			 	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)){
    		    convo.setFSimDt(convo.getFSimDt().replace("-",""));
    		    SearchSimLaneListConditionVO vo = null;
	        	vo = command.searchSimReportNoList(event.getSearchSimLaneListConditionVO());
	        	eventResponse.setRsVoList((List) RowSetUtil.rowSetToVOs(vo.getDbRowSet(), GetCodeSelectVO.class));
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
    		    convo.setFSimDt(convo.getFSimDt().replace("-",""));
    		    String array[][] = { 
						 {"simVessel", convo.getFSimDt()+"|"+convo.getFSimNo(),"Blank"}
						};
			 	;
			 	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else /*if   (e.getFormCommand().isCommand(FormCommand.INIT))*/{
	   		    if (f_dept_cd.equals("")) {
	   		    	if(account.getOfc_cd().length() == 5) f_dept_cd = account.getOfc_cd().substring(2,5);
	               	else f_dept_cd = account.getOfc_cd().substring(3,6);
	   		    	convo.setFDeptCd(f_dept_cd);
	   		    }
	   		    
	   		    if (f_dept_cd2.equals("")) 
	   		    	convo.setFDeptCd2(f_dept_cd);
	   		    
	   		    String f_sim_dt = JSPUtil.getNull(convo.getFSimDt());
	   		    String f_sim_no = JSPUtil.getNull(convo.getFSimNo());
	   		    String sim = f_dept_cd + "|" + f_sim_dt.replaceAll("-", "") +"|" +  f_sim_no;
	   		    
	   		    convo.setFSim(sim);
	   		    convo.setFSimDt(JSPUtil.getNull(convo.getFSimDt(),DateTime.getShortDateString()));
	   		    convo.setFUsrId(JSPUtil.getNull(convo.getFUsrId(),account.getUsr_id()));
	   		    eventResponse.setETCData(event.getSearchSimLaneListConditionVO().getColumnValues());
	   		 
				String array[][] = {
					/*1.f_slan_cd*/	
					{"simLane", "", "Blank"},
					/*2.f_dept_cd2*/
					{"dept", "", "Blank"},
					/*3.f_sim*/
					{"SimInfo", f_slan_cd+ "|" +f_dept_cd2, "Blank"},
					/*4.trade*/
					{"trade", "", ""},
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
	        	convo.setFSimDt(convo.getFSimDt().replace("-",""));
	        	
	        	SearchSimLaneListConditionVO rtnVo = null;
	        	rtnVo = command.searchSimReportNoList(event.getSearchSimLaneListConditionVO());
	        	eventResponse.setRsVoList((List) RowSetUtil.rowSetToVOs(rtnVo.getDbRowSet(), GetCodeSelectVO.class));
	        	
	        	rtnVo = command.searchSectionNoList(convo);
	        	eventResponse.setRsVoList((List) RowSetUtil.rowSetToVOs(rtnVo.getDbRowSet(), GetCodeSelectVO.class));
	        	String headerCD = "";
	            String headerNM = "";
	            StringBuffer headerCD2 = new StringBuffer();
	            StringBuffer headerNM2 = new StringBuffer();
				if(rtnVo.getDbRowSet() != null){
					 while(rtnVo.getDbRowSet().next()){
						 headerCD2 = headerCD2.append(JSPUtil.getNull(rtnVo.getDbRowSet().getString("code"))).append("|");
						 headerNM2 = headerNM2.append(JSPUtil.getNull(rtnVo.getDbRowSet().getString("name"))).append("|");
					 }
				} // end if

				headerCD = headerCD2.toString();
				headerNM = headerNM2.toString();
				if(headerCD.lastIndexOf('|') > 0) headerCD = headerCD.substring(0, headerCD.lastIndexOf('|'));
				if(headerNM.lastIndexOf('|') > 0) headerNM = headerNM.substring(0, headerNM.lastIndexOf('|'));
				eventResponse.setETCData("headerCD",headerCD);
				eventResponse.setETCData("headerNM",headerNM);
				
    	   }	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * ESM_COA_0151 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0151(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		EsmCoa0151Event event = (EsmCoa0151Event)e;
		SearchSimLaneListConditionVO convo = event.getSearchSimLaneListConditionVO();
		String codeValue = "";
		try {
			codeValue = JSPUtil.getNull(convo.getFSlanCd())
			            +"|"+JSPUtil.getNull(convo.getFSimDt())
			            +"|"+JSPUtil.getNull(convo.getFSimNo());
						
				String array[][] = {
					/*1.Vessel Class*/
					{"simVslCls", codeValue, ""}
					
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * ESM_COA_0165 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0165(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		try {
				String array[][] = {
					/*1.S/Lane*/
					{"simLane", "", "Blank"}
					
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
    /*================================================================================================================*/ 
}