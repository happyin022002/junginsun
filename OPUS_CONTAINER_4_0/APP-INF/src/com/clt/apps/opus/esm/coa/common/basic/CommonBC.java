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
=========================================================*/
package com.clt.apps.opus.esm.coa.common.basic;

import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.AverageCostVO;
import com.clt.apps.opus.esm.coa.common.vo.BkgSokeupVO;				//SJH.20140818.ADD
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.GetCodeSelectVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchSimNoDescVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;		//SJH.20140818.ADD

/**
 * OPUS-COA Business Logic Command Interface<br>
 * - OPUS-COA에 대한 비지니스 로직에 대한 인터페이스<br>
 * 2017.01.11 ESM_COA_4013 삭제처리(createOperationDays method) Defect 소스와 싱크를 맞춤.
 * 
 * @author eunju park
 * @see ESM_COA_051EventResponse 참조
 * @since J2EE 1.4
 */ 
public interface CommonBC  {
    
	/**
	 * 기간을 리턴한다.
	 * 
	 * @param SearchConditionVO vo
	 * @return String
	 * @throws EventException
	 */
    public String searchDatePeriod(SearchConditionVO vo) throws EventException;
    
    /**
     * 전주를 리턴한다
     * @param year
     * @param week
     * @return
     * @throws EventException
     */
    public String searchPreWeek(String year, String week) throws EventException;
    
	/**
	 * 전주를 반환한다.
	 * 
	 * @return
	 * @throws EventException
	 * @author SJH.20150106.ADD
	 */
	public String[] searchPrevWkPrdYW() throws EventException;    
    
    /**
     * Vessel Sub Trade 목록을 조회한다.
     * 
     * @return DBRowSet
     * @throws EventException
     */
    public DBRowSet searchVSLSubTradeList() throws EventException;
    
    /**
     * Booking Number 유효성 체크
     * 
	 * @param bkg_no
     * @return
     * @throws EventException
     */
    public boolean checkBKGNo(String bkg_no) throws EventException;
    
    /**
     * Location Code 유효성 체크 
     * 
     * @param loc_cd
     * @return
     * @throws EventException
     */
    public boolean checkLocationCode(String loc_cd) throws EventException; 
    
    /**
     * Vessel code 유효성 체크 
     * 
     * @param vsl_cd String
     * @return
     * @throws EventException
     */
    public boolean checkVesselCode(String vsl_cd) throws EventException; 
    
    /**
     * VVD Code 유효성 체크
     * 
	 * @param vsl_cd
	 * @param skd_voy_no
	 * @param dir_cd
     * @return
     * @throws EventException
     */
    public boolean checkVVDCode(String vsl_cd, String skd_voy_no, String dir_cd) throws EventException;
    
    /**
     * Office Code 유효성 체크
     * 
     * @param ofc_cd
     * @return
     * @throws EventException
     */
    public boolean checkOfficeCode(String ofc_cd) throws EventException; 
    
    /**
     * Revenue Lane Code 유효성 체크
     * 
     * @param rlane_cd
     * @return
     * @throws EventException
     */
    public boolean checkRevLaneCode(String rlane_cd) throws EventException;
    
    /**
     * Service Lane code 유효성 체크
     * 
     * @param slane_cd
     * @return
     * @throws EventException
     */
    public boolean checkSLaneCode(String slane_cd) throws EventException;
    
    /**
     * Node Code 유효성 체크
     * 
     * @param node_cd
     * @return
     * @throws EventException
     */
    public boolean checkNodeCode(String node_cd) throws EventException;				// Node Code 유효성 체크

	/**
	 * VVD에 해당하는 ETD date를 반환한다.
	 * 
	 * @param vsl_cd
	 * @param skd_voy_no
	 * @param skd_dir_cd
	 * @return
	 * @throws EventException
	 */
	public String searchFirstEtd(String vsl_cd, String skd_voy_no, String skd_dir_cd) throws EventException;

	/**
	 * 전주를 반환한다.
	 * 
	 * @return
	 * @throws EventException
	 */
	public String searchPrevWkPrd() throws EventException;
	
	/**
	 * office code에 해당하는 Level를 반환한다.
	 * 
	 * @param ofc_cd
	 * @return
	 * @throws EventException
	 */
	public String searchOFCLevel(String ofc_cd) throws EventException;

	/**
	 * 특정조건에 만족하는 경우 office code에 변경하여 반환한다.
	 * (HQ 산하의 조직이면서 Area가 아닌경우 HQ레벨의 office code를 리턴한다.)
	 * @param ofc_cd
	 * @return
	 * @throws EventException
	 */
	public String searchChgOffice(String ofc_cd) throws EventException;
	
	/**
	 * 환율 변환 
	 * 
	 * @param cost_yrmon
	 * @param locl_curr_cd
	 * @param lcl_amt
	 * @return usd_amt
	 * @throws EventException
	 */
	public float getUSDAmt(String cost_yrmon, String locl_curr_cd, float lcl_amt) throws EventException;		
	
	/**
	 * 환율 변환 
	 * 
	 * @param cost_yrmon
	 * @param locl_curr_cd
	 * @param lcl_amt
	 * @return usd_amt
	 * @throws EventException
	 */
	public float getUSDAmt2(String cost_yrmon, String locl_curr_cd, float lcl_amt) throws EventException;		
	
	/**
	 * Location Code를 이용해서 Office Code를 반환한다
	 * 
	 * @param loc_cd
	 * @return ofc_cd
	 * @throws EventException
	 */	
	public String getLocationToOffice(String loc_cd) throws EventException;
	
	/**
     * 1. 기능 : default combo,ibsheet codelist를 return <p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * 
     * @param codeItem      	Where절에 들어갈 코드그룹
     * @param code      	    Where절에 들어갈 코드조건값
     * @return List<GetCodeSelectVO>
     * @throws EventException
     */
	public List<GetCodeSelectVO> getCodeSelectList(String codeItem, String code) throws EventException ;
	
	/**
     * 기능 : default combo,ibsheet codelist를 return <p>
     * 
     * @param GeneralEventResponse eventResponse
     * @param String[][] array
     * @return GeneralEventResponse
     * @throws EventException
     */
	public GeneralEventResponse getMakeCodeSelectList(GeneralEventResponse eventResponse,String[][] array) throws EventException ;
	
	/**
	 * IBSheet의 동적 콤보가 있을경우 Retrieve시 각각의 콤보를 세팅해 주어야 할때 사용한다.
	 * 
	 * @param tagName       Select List Box의 name
	 * @param codeItem      반환할 업무 대상
	 *                      01. Sub Trade List         	: subTrade
	 *                      02. COA Main Group          : mnGroup
	 *                      03. COA Sub Group          	: subGroup
	 *                      04. Service Lane List		: sLane2
	 *                      05. Revenue Lane List		: rLane2
	 *                      06. 점소단위의 Office List	: office2
	 *                      07. RA SubGroup 			:raSubGrp
	 *                      08. Stndard Cost Code List  : coaCode
	 *                      09. Revenue Lane List		: rLane4 (IP 제외)
	 *                      
	 * @param searchCode
	 * @param rtnType       name  : name을 리턴
	 *                      code  : code를 리턴
	 * @return
	 * @throws EventException
	 */
	public HashMap<String, String> getCodeCombo(String tagName, String codeItem, String searchCode, String rtnType) throws EventException ;
	
	/**
	 * IBSheet의 동적 콤보가 있을경우 Retrieve시 각각의 콤보를 세팅해 주어야 할때 사용한다.
	 * 
	 * @param tagName       Select List Box의 name
	 * @param codeItem      반환할 업무 대상
	 *                      01. Sub Trade List         	: subTrade
	 *                      02. COA Main Group          : mnGroup
	 *                      03. COA Sub Group          	: subGroup
	 *                      04. Service Lane List		: sLane2
	 *                      05. Revenue Lane List		: rLane2
	 *                      06. 점소단위의 Office List	: office2
	 *                      07. RA SubGroup 			:raSubGrp
	 *                      08. Stndard Cost Code List  : coaCode
	 *                      09. Revenue Lane List		: rLane4 (IP 제외)
	 *                      
	 * @param searchCode
	 * @param rtnType       name  : name을 리턴
	 *                      code  : code를 리턴
	 * @throws EventException
	 */
	public String getIbCodeCombo(String tagName, String codeItem, String searchCode, String rtnType) throws EventException;
	
	
	/**
	 * 사용자 office level을 리턴한다.(가공된)
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getUserLevel(String ofc_cd) throws EventException;
	
	
	/**
	 * 사용자 office code 을 리턴한다.(가공된)
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getUserOffice2(String ofc_cd) throws EventException;
	
	/**
	 * [년도, 월] 혹은 [년도, 주]를 받아서 기간을 리턴하는 함수
	 * 
	 * @param year		년도
	 * @param date		월(09), 주(23) 가 들어올수 있음
	 * @param type		date 인자에 들어오는 값이 어떤것인지를 알려준다.
	 * 					month
	 * 					week
	 * @return	String
	 * @exception EventException
	 */
	public String getDatePeriod(String year, String date, String type) throws EventException;
	
	/**
	 * [년도, 시작월~종료월] 혹은 [년도, 시작주~종료주] 혹은 [년도, 월, 주]를 받아서 기간을 리턴하는 함수
	 * 
	 * @param year		년도
	 * @param frmDate	시작 월, 시작 주
	 * @param toDate	종료 월, 종료 주
	 * @param type		date의 인자에 들어오는 값이 어떤 것이 있는 지 알려준다.
	 * 					month, week, monthWeek
	 * @return	String
	 * @exception EventException
	 */
	public String getDatePeriod(String year, String frmDate, String toDate, String type) throws EventException;
		
	/**
	 * [년도, 시작월~종료월, 시작주~종료주] 를 받아서 기간을 리턴하는 함수
	 * 
	 * @param year			년도
	 * @param frmMonth		시작 월
	 * @param toMonth		종료 월
	 * @param frmWeek		시작 주
	 * @param toWeek		종료 주
	 * @return String
	 * @exception EventException
	 */
	public String getDatePeriod(String year, String frmMonth, String toMonth, String frmWeek, String toWeek) throws EventException;
	

	/**
	 * 날짜에 대한 Max Simulation No를 조회한다.
	 * 
	 * @return
	 * @throws EventException
	 */
	public String searchMaxSimNo() throws EventException;
	

    /**
     * 전주 년도를 리턴한다
     * @return String
     * @throws EventException
     */
    public String searchPrevYearPrd() throws EventException;

    /**
     * Simulation number의 설명을 조회한다.
     * 
     * @param vo
     * @return
     * @throws EventException
     */
	public List<SearchSimNoDescVO> searchSimNoDesc(SearchConditionVO vo) throws EventException;
	
    /**
     * ESM_COA_9000 : BKG 소급 리스트 조회<br>
	 * 
	 * @param BkgSokeupVO bkgSokeupVO
	 * @return List<BkgSokeupVO>
	 * @exception EventException
	 * @author SJH.20140818.ADD
     */
	public List<BkgSokeupVO> searchBkgSokeupStatus(BkgSokeupVO bkgSokeupVO) throws EventException ;
	
	/**
	 * ESM_COA_9000 : BKG 소급<br>
	 * @param BkgSokeupVO[] bkgSokeupVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author SJH.20140818.ADD
	 */
	public void manageBkgSokeup(BkgSokeupVO[] bkgSokeupVOS, SignOnUserAccount account) throws EventException;	

	/**
	 * [ESM_COA_4004]
	 * Mass Calculation Batch List 조회<br>
	 *
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 */
	public CommonCoaRsVO searchBatchManagement(SearchConditionVO searchVO) throws EventException;

	/**
	 * [ESM_COA_4004]
	 * Simulation Batch List 조회<br>
	 *
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 */
	public CommonCoaRsVO searchSimBatchManagement(SearchConditionVO searchVO) throws EventException;
	
	/**
	 * Target YRMON 에 대해 AverageRPB 배치가 실행 되었는지 확인한다.
	 * 
	 * @param String fTargetYrMon
	 * @param String fCostTypeCd
	 * @return String
	 * @throws EventException
	 */
	public String searchAverageCostStatus(String fTargetYrMon, String fCostTypeCd) throws EventException ; 
	/**
	 * Average RPB BATCH 가 실행중인지를 check 한다.
	 * @param AverageCostVO averageCostVO
	 * @return String
	 * @throws EventException
	 */
	public String checkAverageCostCreateBatchStatus(AverageCostVO averageCostVO) throws EventException ;
	
	/**
	 * Week 단위로 Average RPB BATCH 를 수행한다. <br>
	 * 
	 * @param AverageCostVO averageCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createAverageCost(AverageCostVO averageCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Average RPB BATCH status 를 생성한다. <br>
	 * 
	 * @param AverageCostVO averageCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAverageCostStatus(AverageCostVO averageCostVO, SignOnUserAccount account) throws EventException;
	
}