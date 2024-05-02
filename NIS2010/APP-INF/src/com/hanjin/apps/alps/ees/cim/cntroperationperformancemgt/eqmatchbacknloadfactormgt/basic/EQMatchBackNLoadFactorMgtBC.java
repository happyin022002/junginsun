/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtBC.java
*@FileTitle : Location M/B by Logistics-Wise
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.20 박광석
* 1.0 Creation
* ------------------------------------------------------------
* History
* 2012.03.26 신자영 [CHM-201216788-01] M/B 기능 보완 요청
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBDResultCOABKGVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionCOABKGVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionInGereralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBTResultCOABKGVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MatchBackByMonthlyWeeklyTrendSetVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.QuantityByTypeSizeVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.ResultByLocationVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchBatchJobStatusVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchCargoFlowMapDetailVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByFromToVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByLocationVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByOTRVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByTradeLaneVvdVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Cntroperationperformancemgt Business Logic Command Interface<br>
 * - ALPS-Cntroperationperformancemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Prak Kwang Seok
 * @see Ees_cim_1023EventResponse 참조
 * @since J2EE 1.6
 */ 

public interface EQMatchBackNLoadFactorMgtBC {
    
    /**
    * [Terminal MatchBack]을 [조회] 합니다.<br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchTMLMBByLogisticWiseSummary (MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
    
    /**
    * [Terminal MatchBack]을 [조회] 합니다.<br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchTMLMBByLogisticWiseDetail(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
    
    /**
    * [Lane MatchBack]을 [조회] 합니다.<br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchLaneMBByLogisticWise(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
	
    /**
    * [Location MatchBack]을 [조회] 합니다.<br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchLocationMBByLogisticWiseInSummary(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
	
    /**
    * [Location MatchBack Detail]을 [조회] 합니다.<br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchLocationMBByLogisticWiseInDetail(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;

    
    /**
    * [Load Factory Trade]을 [조회] 합니다.<br>
    * 
    * @param searchOptionByTradeLaneVvdVO
    * @param account
    * @return String
    * @exception EventException
    */
	public String searchLoadFactorByTrade(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO,SignOnUserAccount account) throws EventException;

    /**
    * [Location MatchBack Trend]을 [조회] 합니다.<br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return MatchBackByMonthlyWeeklyTrendSetVO
    * @exception EventException
    */
	public MatchBackByMonthlyWeeklyTrendSetVO searchLocationMBByLogisticWiseByTrend(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
    
	
	/**
	* [TMNL MatchBack Trend]을 [조회] 합니다.<br>
	* 
	* @param mBSearchOptionInGereralVO
	* @return MatchBackByMonthlyWeeklyTrendSetVO
	* @exception EventException
	*/
	public MatchBackByMonthlyWeeklyTrendSetVO searchTmnlMBByLogiticWiseByTrend(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
	    
    /**
    * [Service Mode MatchBack]을 [조회] 합니다.<br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchMBByServiceMode(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
    
    /**
    * [Location Booking MatchBack]을 [조회] 합니다.<br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchLocationMBByBKGWiseInSummary(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
    
    /**
    * [Location Booking MatchBack Detail]을 [조회] 합니다.<br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchLocationMBByBKGWiseInDetail(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
    
    /**
    * [Location Booking MatchBack Trend]을 [조회] 합니다.<br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return MatchBackByMonthlyWeeklyTrendSetVO
    * @exception EventException
    */
	public MatchBackByMonthlyWeeklyTrendSetVO searchLocationMBByBKGWiseByTrend(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
    
    /**
    * [Cargo Flow Map]을 [조회] 합니다.<br>
    * 
    * @param searchOptionByFromToVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchCargoFlowMap(SearchOptionByFromToVO searchOptionByFromToVO) throws EventException;

    /**
    * [Cargo Flow Map]을 [조회] 합니다.<br>
    * 
    * @param searchOptionByFromToVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchCargoFlowMapTrend(SearchOptionByFromToVO searchOptionByFromToVO) throws EventException;

	
    /**
    * [Previous Weeks]을 [조회] 합니다.<br>
    * 
    * @param searchOptionByFromToVO
    * @return List<SearchBatchJobStatusVO>
    * @exception EventException
    */
	public List<SearchBatchJobStatusVO> searchPreviousWeeks(SearchOptionByFromToVO searchOptionByFromToVO) throws EventException;
    
    /**
    * [Batch Job Status]을 [조회] 합니다.<br>
    * 
    * @param searchOptionByFromToVO
    * @return List<SearchBatchJobStatusVO>
    * @exception EventException
    */
	public List<SearchBatchJobStatusVO> searchBatchJobStatus(SearchOptionByFromToVO searchOptionByFromToVO) throws EventException;
    
    /**
    * [Vessel MatchBack]을 [조회] 합니다.<br>
    * 
    * @param searchOptionByTradeLaneVvdVO
    * @param account
    * @return String
    * @exception EventException
    */
    public String searchMBByVessel(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO,SignOnUserAccount account) throws EventException;
    
    /**
    * [Vessel MatchBack Lane List]을 [조회] 합니다.<br>
    * 
    * @param searchOptionByTradeLaneVvdVO
    * @return String[]
    * @exception EventException
    */
    public String[] searchMBByVesselLaneListByTrade(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO) throws EventException;
    
    /**
    * [Vessel MatchBack VVD List]을 [조회] 합니다.<br>
    * 
    * @param searchOptionByTradeLaneVvdVO
    * @return String[]
    * @exception EventException
    */
    public String[] searchMBByVesselVvdListByTradeLane(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO) throws EventException;

    /**
     * [MatchBack VVD List]을 [조회] 합니다.<br>
     * 
     * @param period
     * @param from
     * @param to
     * @param pol
     * @param lane
     * @return String[]
     * @exception EventException
     */
     public String[] searchPortMBVVDList (String period,String from,String to,String pol,String lane) throws EventException;
     
 	/**
 	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
 	 *
 	 * @param String key
 	 * @return String
 	 * @exception EventException
 	 */
 	public String searchComBackEndJobStatusBasic(String key) throws EventException;
     
 	/**
	 * [EES_CIM_1061] Location M/B by COA BKG 를 조회합니다.<br>
	 * 	
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return List<MBDResultCOABKGVO> 
	 * @exception EventException
	 */		
	public List<MBDResultCOABKGVO> searchLocationMBByCOABKGBasic(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws EventException;
	
	/**
	 * [EES_CIM_1061] Location M/B by COA BKG 를 조회합니다.<br>
	 * 탭별 헤더 리스트 조회
	 * 
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return String
	 * @exception EventException
	 */			
	public String searchMBTPeriodListBasic(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws EventException;
	
	/**
	 * [EES_CIM_1061] Location M/B by COA BKG 를 조회합니다.<br>
	 * 	MBT 탭		 
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return List<MBTResultCOABKGVO>
	 * @exception EventException	
	 */	
	public List<MBTResultCOABKGVO> searchLocationMBTByCOABKGBasic(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws EventException;
	
	/**
	 * [EES_CIM_1062] Location POP 를 조회합니다.<br>
	 * 		 
	 * @param SearchOptionByLocationVO searchOptionByLocationVO
	 * @return List<ResultByLocationVO>
	 * @exception EventException	
	 */				
	public List<ResultByLocationVO> searchLocationPOPBasic(SearchOptionByLocationVO searchOptionByLocationVO) throws EventException;
	
	/**
	 * [EES_CIM_1062] Location POP 를 저장합니다 .<br>
	 *
	 * @param ResultByLocationVO[] resultByLocationVOS
	 * @exception EventException				
	 */  
	public void manageLocationPOPBasic(ResultByLocationVO[] resultByLocationVOS) throws EventException;
	
	/**
	 * EES_CIM_1061 : COMMAND02(IBCLEAR) <br>
	 * Location M/B by COA-BKG <br>
	 * Location POP을 초기화 함 New 버튼	
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @exception EventException		
	 */	  
	public void clearLocationPOPBasic(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws EventException;
	
	/**
	 * [EES_CIM_1061] Location M/B by COA BKG [COMMAND03]<br>
	 * Location 선택 여부를 체크하기 위한 Count 조회
	 * 
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return String
	 * @exception EventException
	 */	
	public String checkLocationPOPBasic(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws EventException;
	
	/**
	 * EES_CIM_1061 : COMMAND04(SaveFormat) <br>
	 * Location M/B by COA-BKG <br>
	 * OTR 조회 옵션을 저장함
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @exception EventException			
	 */	  
	public void manageFormatMBByCOABKGBasic(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws EventException;
	
	/**
	 * [EES_CIM_1061] : COMMAND05,RecallFormat <br>
	 * Location M/B by COA-BKG <br>
	 * FORMAT SAVE한 데이타를 조회해온다. 
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return SearchOptionByOTRVO
	 * @exception EventException
	 */		
	public SearchOptionByOTRVO searchFormatMBByCOABKGBasic(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws EventException;
	
	/**
	 * EES_CIM_1030 (Cargo Flow Map Detail)
	 * @param SearchOptionByFromToVO searchOptionByFromToVO
	 * @return List<SearchCargoFlowMapDetailVO>
	 * @exception EventException
	 */
	public List<SearchCargoFlowMapDetailVO> searchCargoFlowMapDetail(SearchOptionByFromToVO searchOptionByFromToVO) throws EventException;
}