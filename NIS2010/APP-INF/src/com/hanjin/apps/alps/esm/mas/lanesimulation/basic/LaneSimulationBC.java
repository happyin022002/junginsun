/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : LaneSimulationBC.java
*@FileTitle : 항로 Simulation 마스터 및 W/F 생성/조회/변경
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : eunju park
*@LastVersion : 1.0
* 2006-08-25 eunju park
* 1.0 최초 생성
* 2009.03.31 박은주,박상희 S2K-09U-002(Lane Simulation System 개선)
* 2009.08.21 박은주 Alps전환작업[ESM_MAS_0169]
* 2009.07,20 윤진영 Alps전환작업
* 2010.02.05 임옥영 소스품질검토 결과 반영(주석들 변경) 
* 2011.07.13 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.CreateSimDailyHireVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.LaneInfoListConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.MergyVolProjConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.MultiSimSummaryRptVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchBSAbyVVDListConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchBSAbyVVDListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchFileMgmtListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchLaneInfoListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchReportConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimBunkerListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimContiPairListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimDailyHireInfoVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimLaneListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimLaneRPBListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimPortChargeListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimPortListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimReportMasterListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimRtnRowSetVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimVesselListConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimVesselListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimYardConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimYardListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchTMLOPDysListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchTocHireListVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchTsVolumeVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchVesselInfoConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchVesselInfoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasBnkCsmVO;
import com.hanjin.syscommon.common.table.MasSimBnkCostVO;
import com.hanjin.syscommon.common.table.MasSimCtrbMgnCostVO;
import com.hanjin.syscommon.common.table.MasSimDlyHirVO;
import com.hanjin.syscommon.common.table.MasSimInfoVO;
import com.hanjin.syscommon.common.table.MasSimNonOpExpnVO;
import com.hanjin.syscommon.common.table.MasSimPortChgVO;
import com.hanjin.syscommon.common.table.MasTmChtrOutHirVO;

/**
 * ALPS-MAS Business Logic Command Interface<br>
 * - ALPS-MAS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author eunju park
 * @see ESM_MAS_0051EventResponse 참조
 * @since J2EE 1.4
 */
public interface LaneSimulationBC  {
	/* ====================================================================================
                                           ESM_MAS_0051화면
	  ==================================================================================== */
	/**
	 * ESM_MAS_0051 화면의 Lane Simulation 조회 이벤트를 처리한다.
	 * 
	 * @param SearchSimLaneListConditionVO searchSimLaneListConditionVO
	 * @return List<SearchSimLaneListVO>
	 * @exception EventException
	 */
	public List<SearchSimLaneListVO> searchSimLaneList(SearchSimLaneListConditionVO searchSimLaneListConditionVO) throws EventException;			// Lane Simulation 목록을 조회한다.(051_master)
	/**
	* ESM_MAS_0051 화면의 Lane Simulation 저장 이벤트를 처리한다.
	*   - Lane Simulation의 마스터 테이블과 관련된 테이블의 데이터를 모두 삭제한다.
	 * @param SearchSimLaneListConditionVO[] searchSimLaneListConditionVO
	 * @exception EventException
	 */
	public void removeSimLane(SearchSimLaneListConditionVO[] searchSimLaneListConditionVO) throws EventException;				// Lane Simulation의 마스터 테이블과 관련된 테이블의 데이터를 모두 삭제한다.
	/**
	*  ESM_MAS_0051 화면의 Lane Simulation 저장 이벤트를 처리한다.
	*  
	* @param SearchSimLaneListVO[] searchSimLaneListVO
	* @param SignOnUserAccount account
	* @return String
	* @throws EventException
	*/
	public String multiSimLane(SearchSimLaneListVO[] searchSimLaneListVO,SignOnUserAccount account) throws EventException;				// Lane Simulation IUD(051_master)
	
	/**
	* ESM_MAS_0051 화면의 Vessel Info 조회 이벤트를 처리한다.
	* 
	* @param SearchVesselInfoConditionVO searchVesselInfoConditionVO
	* @return List<SearchVesselInfoVO>
	* @throws EventException
	*/
	public List<SearchVesselInfoVO> searchVesselInfo(SearchVesselInfoConditionVO searchVesselInfoConditionVO) throws EventException;			// Vessel Info를 조회한다.
	/**
	* ESM_MAS_0051 화면의 Simulation Vessel 조회 이벤트를 처리한다.
	* 
	* @param SearchSimVesselListConditionVO searchSimVesselListConditionVO
	* @return List<SearchSimVesselListVO>
	* @throws EventException
	*/
	public List<SearchSimVesselListVO> searchSimVesselList(SearchSimVesselListConditionVO searchSimVesselListConditionVO) throws EventException;		// Simulation Vessel 목록을 조회한다.(051_detail)
	
	/**
	* ESM_MAS_0051 화면의 Simulation Vessel 저장 이벤트를 처리한다.
	* 
	* @param SearchSimVesselListVO[] searchSimVesselListVO
	* @param SignOnUserAccount account
	* @throws EventException
	*/
	public void multiSimVesselInfo(SearchSimVesselListVO[] searchSimVesselListVO,SignOnUserAccount account) throws EventException;			// Simulation Vessel IU(051_detail)
	
	/**
	* Lane Info I/F : MDM의 Lane 정보 및 P/F SKD의 frequency 정보 I/F
	* 
	* @param LaneInfoListConditionVO laneInfoListConditionVO
	* @return List<SearchLaneInfoListVO>
	* @throws EventException
	*/
	public List<SearchLaneInfoListVO> searchLaneInfoList(LaneInfoListConditionVO laneInfoListConditionVO) throws EventException;

    /**
     * Simulation 에서 사용하는 Continent Pair정보를 조회한다.
     * 
     * @param SearchSimContiPairListVO searchSimContiPairList
     * @return List<SearchSimContiPairListVO>
     * @throws EventException
     */
	public List<SearchSimContiPairListVO> searchSimContiPairList(SearchSimContiPairListVO searchSimContiPairList) throws EventException;    
    /**
     * Simulation에서 사용하는 Continent Pair 정보를 Insert/Update/Delete한다.
     * 
     * @param SearchSimContiPairListVO[] searchSimContiPairList
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void multiSimContiPair(SearchSimContiPairListVO[] searchSimContiPairList,SignOnUserAccount account) throws EventException;
	/**
	* ESM_MAS_0165 화면의 Lane Simulation 조회 이벤트를 처리한다.
	* 
	* @param SearchFileMgmtListVO searchFileMgmtListVO
	* @param SignOnUserAccount account
	* @return List<SearchFileMgmtListVO>
	* @throws EventException
	*/
	public List<SearchFileMgmtListVO> searchFileMgmtList(SearchFileMgmtListVO searchFileMgmtListVO,SignOnUserAccount account) throws EventException;	
	/**
	* ESM_MAS_0165 화면의 Lane Simulation 삭제 이벤트를 처리한다.
	* 
	* @param SearchFileMgmtListVO[] vos
	* @throws EventException
	*/
	public void multiFileMgmt(SearchFileMgmtListVO[] vos) throws EventException;
	/**
	* ESM_MAS_0166 화면의 Lane Simulation 조회 이벤트를 처리한다.
	* 
	* @param SearchBSAbyVVDListConditionVO searchBSAbyVVDListConditionVO
	* @return SearchBSAbyVVDListVO
	* @throws EventException
	*/
	public SearchBSAbyVVDListVO searchBSAbyVVDList(SearchBSAbyVVDListConditionVO searchBSAbyVVDListConditionVO) throws EventException;
	/**
	 * 1. 기능 : Step1 :IAS T/S Volume 팝업화면 정보를 조회한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<searchTsVolumeVO
	 * @exception EventException
	 */
	public List<SearchTsVolumeVO> searchTsVolumeList(SearchConditionVO searchConditionVO) throws EventException;
	/**
	 * 1. 기능 : Step1 :IAS T/S Volume 팝업화면 정보를 변경한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SearchTsVolumeVO[] searchTsVolumeVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiTsVolume(SearchConditionVO searchConditionVO,SearchTsVolumeVO[] searchTsVolumeVO,SignOnUserAccount account) throws EventException;
	/**
	 * 1. 기능 : Step1 :NON OPERATING EXPENSE 팝업화면 정보를 조회한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<searchTsVolumeVO
	 * @exception EventException
	 */
	public List<MasSimNonOpExpnVO> searchNonOpExpnList(SearchConditionVO searchConditionVO) throws EventException;
	/**
	 * 1. 기능 : Step1 :NON OPERATING EXPENSE 팝업화면 정보를 변경한다.<br>
	 * 
	 * @param MasSimNonOpExpnVO[] masSimNonOpExpnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiNonOpExpn(MasSimNonOpExpnVO[] masSimNonOpExpnVO,SignOnUserAccount account) throws EventException;	
	/* ====================================================================================
                                           ESM_MAS_0052화면
       ==================================================================================== */
    /**
     * Step2 : Tab1 : Port/TMNL Setting > Port 정보 변경시 해당 Yard Code를 조회한다.<br>
     * 
     * @param  SearchSimYardConditionVO vo
     * @return List<SearchSimYardListVO>
     * @throws EventException
     */
    public List<SearchSimYardListVO> searchSimYardList(SearchSimYardConditionVO vo) throws EventException;
    /**
     * Step2 : Tab1 : Port/TMNL Setting > Retrieve
     * 
     * @param  SearchSimLaneListConditionVO vo
     * @return SearchSimPortListVO
     * @throws EventException
     */
    public SearchSimPortListVO searchSimPortList(SearchSimLaneListConditionVO vo) throws EventException;
    /**
     * Step2 : Tab1 : Port/TMNL Setting > Existing Lane 일 경우 P/F SKD의 Port TMNL 정보를 조회한다.
     * 
     * @param SearchSimLaneListConditionVO vo
     * @param SignOnUserAccount account
     * @return SearchSimPortListVO
     * @throws EventException
     */
    public SearchSimPortListVO multiSimPortGetOpDay(SearchSimLaneListConditionVO vo,SignOnUserAccount account) throws EventException;
    /**
     * Step2 : Tab1 : Port/TMNL Setting > Save 1차
     * 
     * @param SearchSimPortListVO[] vos 
     * @param SearchSimLaneListConditionVO vo
     * @param SignOnUserAccount account
     * @return SearchSimLaneListConditionVO
     * @throws EventException
     */
    public SearchSimLaneListConditionVO multiSimPortInfo(SearchSimPortListVO[] vos , SearchSimLaneListConditionVO vo, SignOnUserAccount account) throws EventException;
    /**
     * Step2 : Tab1 : Port/TMNL Setting > Save 2차
     * 
     * @param SearchSimPortListVO[] vos 
     * @param SearchSimLaneListConditionVO vo
     * @param SignOnUserAccount account
     * @return SearchSimLaneListConditionVO
     * @throws EventException
     */
    public SearchSimLaneListConditionVO multiSimPortInfo2(SearchSimPortListVO[] vos , SearchSimLaneListConditionVO vo, SignOnUserAccount account) throws EventException;
    /**
     * Step2 : Tab1 : Port/TMNL Setting > Calcuration
     * 
     * @param  SearchSimCalcVO vos
     * @return SearchSimCalcVO
     * @throws EventException
     */
//    public SearchSimCalcVO multiSimPortCalc(SearchSimCalcVO vos) throws EventException;    
    
    /**
     * Step2 : Tab2 : Route Projection - Lane G.RPB Projection > Retrieve
     * 
     * @param  SearchSimLaneListConditionVO searchSimLaneListConditionVO
     * @return List<SearchSimLaneRPBListVO>
     * @throws EventException
     */
	public List<SearchSimLaneRPBListVO> searchSimLaneRPBList(SearchSimLaneListConditionVO searchSimLaneListConditionVO) throws EventException;    
    /**
     * Step2 : Tab2 : Route Projection - Lane G.RPB Projection > Save
     * 
     * @param SearchSimLaneRPBListVO[] searchSimLaneRPBListVO
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void modifySimGrpb(SearchSimLaneRPBListVO[] searchSimLaneRPBListVO,SignOnUserAccount account) throws EventException;
    /**
     * Step2 : Tab2 : Route Projection - Volume > Retrieve
     * 
     * @param  SearchSimConditionVO searchVO
     * @return SearchSimRtnRowSetVO
     * @throws EventException
     */
	public SearchSimRtnRowSetVO searchSimVolProjList(SearchSimConditionVO searchVO) throws EventException;
    /**
     * Step2 : Tab2 : Route Projection - Volume > Save
     * 
     * @param MergyVolProjConditionVO vo
     * @param MergyVolProjConditionVO[] multiSimVolProjConditionVO
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void multiSimVolProj(MergyVolProjConditionVO vo,MergyVolProjConditionVO[] multiSimVolProjConditionVO,SignOnUserAccount account) throws EventException;
    /**
     * Step2 : Tab2 : Route Projection - Volume > Creation
     * 
     * @param MergyVolProjConditionVO vo
     * @param SearchSimLaneListConditionVO vo2
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void createSimVolProj(MergyVolProjConditionVO vo,SearchSimLaneListConditionVO vo2,SignOnUserAccount account) throws EventException;
    /**
     * Step2 : Tab2 : Route Projection - G.RPB > Retrieve
     * 
     * @param  SearchSimConditionVO searchVO
     * @return SearchSimRtnRowSetVO
     * @throws EventException
     */
    public SearchSimRtnRowSetVO searchSimGrpbProjList(SearchSimConditionVO searchVO) throws EventException;

    /**
     * Step2 : Tab2 : Route Projection - G.RPB > Save
     * 
     * @param MergyVolProjConditionVO vo
     * @param MergyVolProjConditionVO[] multiSimVolProjConditionVO
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void multiSimGrpbProj(MergyVolProjConditionVO vo,MergyVolProjConditionVO[] multiSimVolProjConditionVO,SignOnUserAccount account) throws EventException;
    /**
     * Step2 : Tab3 : TMNL Transit Time > Retrieve
     * @param SearchTMLOPDysListVO searchTMLOPDysListVO
     * @return List<SearchTMLOPDysListVO>
     * @throws EventException
     */
    public List<SearchTMLOPDysListVO> searchTMLOPDysList(SearchTMLOPDysListVO searchTMLOPDysListVO) throws EventException;
    /**
     * Step2 : Tab3 : TMNL Transit Time > Save
     * @param SearchTMLOPDysListVO searchTMLOPDysListVO
     * @param SearchTMLOPDysListVO[] searchTMLOPDysListVOS
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void modifyTMLOPDys(SearchTMLOPDysListVO searchTMLOPDysListVO,SearchTMLOPDysListVO[] searchTMLOPDysListVOS,SignOnUserAccount account) throws EventException;
    /**
     * Step2 : Tab3 : TMNL Transit Time > Create
     * @param SearchTMLOPDysListVO searchTMLOPDysListVO
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void createTMLOPDys(SearchTMLOPDysListVO searchTMLOPDysListVO,SignOnUserAccount account) throws EventException;
	/* ====================================================================================
                                           ESM_MAS_0053화면
       ==================================================================================== */
    /**
     * Step3 : Tab1 : CM_Lane Summary > Retrieve <p>
     * 
     * @param  SearchSimConditionVO vo
     * @return SearchSimRtnRowSetVO
     * @throws EventException
     */
    public SearchSimRtnRowSetVO searchSimCgoCostList(SearchSimConditionVO vo) throws EventException;
    /**
     * Step3 : Tab1 : CM_Route Summary > Retrieve <p>
     * 
     * @param  SearchSimConditionVO vo
     * @return List<SearchSimRtnRowSetVO>O
     * @throws EventException
     */
    public List<SearchSimRtnRowSetVO> searchSimCMCostList(SearchSimConditionVO vo) throws EventException;
    /**
     * Step3 : Tab1 : CM_Route Summary > Save <p>
     * EsmMas0053Event
     * @param MasSimCtrbMgnCostVO[] vo
     * @param SearchSimConditionVO searchVO
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void modifySimCMCost(MasSimCtrbMgnCostVO[] vo, SearchSimConditionVO searchVO,SignOnUserAccount account) throws EventException;
    /**
     * Step3 : Tab2 : Port Charge > Retrieve <p>
     * EsmMas0053Event
     * @param  SearchSimConditionVO searchVO
     * @return List<SearchSimPortChargeListVO>
     * @throws EventException
     */
    public List<SearchSimPortChargeListVO> searchSimPortChargeList(SearchSimConditionVO searchVO) throws EventException;
    /**
     * Step3 : Tab2 : Port Charge > Save <p>
     *
     * @param MasSimPortChgVO[] vo
     * @param SearchSimConditionVO searchVO
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void multiSimPortCharge(MasSimPortChgVO[] vo, SearchSimConditionVO searchVO, SignOnUserAccount account) throws EventException;
    /**
     * Step3 : Tab2 : Port Charge > Create <p>
     * EsmMas0053Event
     * @param  SearchSimConditionVO searchVO
     * @throws EventException
     */
    public void createSimPortCharge(SearchSimConditionVO searchVO) throws EventException;
    /**
     * Step3 : Tab3 : Bunker Cost > Retrieve <p>
     * 
     * @param  SearchSimConditionVO searchVO
     * @return List<SearchSimBunkerListVO>
     * @throws EventException
     */
    public List<SearchSimBunkerListVO> searchSimBunkerList(SearchSimConditionVO searchVO) throws EventException;
    /**
     * Step3 : Tab3 : Bunker Cost > Basic <p>
     * 
     * @param MasSimBnkCostVO[] vo
     * @param SearchSimConditionVO searchVO
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void createSimBunkerList(MasSimBnkCostVO[] vo,SearchSimConditionVO searchVO, SignOnUserAccount account) throws EventException;
    /**
     * Step3 : Tab3 : Bunker Cost > Save <p>
     * 
     * @param MasSimBnkCostVO[] vo
     * @param SearchSimConditionVO searchVO
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void multiSimBunkerCost(MasSimBnkCostVO[] vo, SearchSimConditionVO searchVO, SignOnUserAccount account) throws EventException;
    /**
     * Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Retrieve
     * 
     * @param  MasSimCtrbMgnCostVO vo
     * @return SearchSimDailyHireInfoVO
     * @throws EventException
     */
     public SearchSimDailyHireInfoVO searchSimDailyHireList(MasSimCtrbMgnCostVO vo) throws EventException;
    /**
     * Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Create
     * 
     * @param CreateSimDailyHireVO vo
     * @param SignOnUserAccount account
     * @throws EventException
     */
     public void createSimDailyHire(CreateSimDailyHireVO vo, SignOnUserAccount account) throws EventException;
    /**
     * Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Save
     * 
     * @param MasSimDlyHirVO[] vos
     * @param CreateSimDailyHireVO vo
     * @param SignOnUserAccount account
     * @throws EventException
     */
     public void multiSimDailyHire(MasSimDlyHirVO[] vos,CreateSimDailyHireVO vo, SignOnUserAccount account) throws EventException;
    /**  
     * Step3 : Tab5 : Network Cost > Retrieve
     * 
     * @param  MasSimCtrbMgnCostVO vo
     * @return SearchSimDailyHireInfoVO
     * @throws EventException
     */
     public SearchSimDailyHireInfoVO searchSimNWCostList(MasSimCtrbMgnCostVO vo) throws EventException;
    /**  
     * Step3 : Tab6 : After Ocean T/S > Retrieve
     * 
     * @param  MasSimCtrbMgnCostVO vo
     * @return SearchSimDailyHireInfoVO
     * @throws EventException
     */
     public SearchSimDailyHireInfoVO searchSimAfterOcenaTSList(MasSimCtrbMgnCostVO vo) throws EventException;
    /**  
     * Step3 : Tab6 : After Ocean T/S > Create
     * 
     * @param MasSimCtrbMgnCostVO vo
     * @param SignOnUserAccount account
     * @return int
     * @throws EventException
     */
    public int createSimNWCost(MasSimCtrbMgnCostVO vo,SignOnUserAccount account) throws EventException;
    /**  
     * Step3 : Tab4 : TO/C Hire Popup ( Hire/TC Rev/Layup(Daily) Open)  > Retrieve<p>
     * 
     * @return List<SearchTocHireListVO>
     * @throws EventException
     */
    public List<SearchTocHireListVO> searchTOCHireList() throws EventException;
    /**  
     * Step3 : Tab4 : TO/C Hire Popup ( Hire/TC Rev/Layup(Daily) Open)  > Save<p>
     * 
     * @param MasTmChtrOutHirVO[] vos
     * @param SearchTocHireListVO[] vo
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void multiTOCHire(MasTmChtrOutHirVO[] vos ,SearchTocHireListVO[] vo,SignOnUserAccount account) throws EventException;
    /**
     * Simulation 에서 사용하는 Consumption Matrix by Class정보를 조회한다.
     * 
     * @param MasBnkCsmVO masBnkCsmVO
     * @return List<MasBnkCsmVO>
     * @throws EventException
     */
    public List<MasBnkCsmVO> searchSimConsumList(MasBnkCsmVO masBnkCsmVO) throws EventException;
    /**
     * Simulation에서 사용하는 Consumption Matrix by Class 정보를 Insert/Update/Delete한다.
     * 
     * @param MasBnkCsmVO[] masBnkCsmVOS
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void multiSimConsum(MasBnkCsmVO[] masBnkCsmVOS,SignOnUserAccount account) throws EventException;
    /*================================================================================================================*/   
    /**
     * Simulation Report의 Header정보를  조회
     * 
     * @param SearchSimLaneListConditionVO vo
     * @return SearchSimLaneListConditionVO
     * @throws EventException
     */
    public SearchSimLaneListConditionVO searchSectionNoList(SearchSimLaneListConditionVO vo) throws EventException;
    /**
     * Simulation Report의 Report No. 멀티콤보 세팅을 위한 데이터 조회
     * 
     * @param SearchSimLaneListConditionVO vo
     * @return SearchSimLaneListConditionVO
     * @throws EventException
     */
    public SearchSimLaneListConditionVO searchSimReportNoList(SearchSimLaneListConditionVO vo) throws EventException;    
    /**
     * Simulation Report 조회 이벤트 처리
     * 
     * @param SearchReportConditionVO vo
     * @return SearchReportConditionVO
     * @throws EventException
     */
    public SearchReportConditionVO searchSimSummaryReportList(SearchReportConditionVO vo) throws EventException;    
    /**
     * Simulation Report의 MAS_SIM_RPT_MST ROW수
     * 
  	 * @param SearchSimLaneListConditionVO vo
  	 * @return int
     * @throws EventException
     */
    public int searchSimReportMasterCount(SearchSimLaneListConditionVO vo) throws EventException;     
    /**
     * Simulation Report의 첫번째 Report 생성
     * 
  	 * @param SearchSimLaneListConditionVO vo
  	 * @param SignOnUserAccount account
  	 * @return List<SearchSimReportMasterListVO>
     * @throws EventException
     */
    public List<SearchSimReportMasterListVO> createDefaultSimReport(SearchSimLaneListConditionVO vo,SignOnUserAccount account) throws EventException; 
    /**
     * Simulation에서 사용하는 Creation (Variant Change)팝업 정보를 조회
     * 
     * @param SearchSimLaneListConditionVO vo
     * @return List<SearchSimReportMasterListVO>
     * @throws EventException
     */
    public List<SearchSimReportMasterListVO> searchSimReportMasterList(SearchSimLaneListConditionVO vo) throws EventException;
    /**
     * Simulation 에서 사용하는 Creation (Variant Change)팝업 정보를 생성
     * 
     * @param vos MultiSimSummaryRptVO[] 
     * @param account SignOnUserAccount 
     * @throws EventException
     */
    public void multiSimReport(MultiSimSummaryRptVO[] vos,SignOnUserAccount account) throws EventException;
    /*================================================================================================================*/
	/**
	 * VSK 모듈에서 데이터를 받아서 Sim 테이블에 저장한다.
	 * 
	 * @param vo PfSkdGRPVO
	 * @param ind Strig [I:신규,U:수정]
	 * @param account
     * @return List<MasSimInfoVO>
	 * @throws EventException
	 */
    public List<MasSimInfoVO> createMasSimRqst(PfSkdGRPVO vo, String ind, SignOnUserAccount account) throws EventException;

    
}