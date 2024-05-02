/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtBC.java
*@FileTitle : Location M/B by Logistics-Wise
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.basic;

import java.util.List;

//import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.LoadFactorByTradeLaneVvdVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionInGereralVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MatchBackByMonthlyWeeklyTrendSetVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.QuantityByTypeSizeVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchBatchJobStatusVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByFromToVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByTradeLaneVvdVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
/**
 * OPUS--Cntroperationperformancemgt Business Logic Command Interface <br>
 *
 * @author
 * @see Ees_cim_1023EventResponse reference
 * @since J2EE 1.6
 */ 

public interface EQMatchBackNLoadFactorMgtBC {
    
    /**
    * retrieving [Terminal MatchBack] <br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchTMLMBByLogisticWiseSummary (MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
    
    /**
    * retrieving [Terminal MatchBack] <br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchTMLMBByLogisticWiseDetail(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
    
    /**
    * retrieving [Lane MatchBack] <br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchLaneMBByLogisticWise(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
	
    /**
    * retrieving [Location MatchBack] <br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchLocationMBByLogisticWiseInSummary(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
	
    /**
    * retrieving [Location MatchBack Detail] <br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchLocationMBByLogisticWiseInDetail(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;

    
    /**
    * retrieving [Load Factory Trade] <br>
    * 
    * @param searchOptionByTradeLaneVvdVO
    * @param account
    * @return String
    * @exception EventException
    */
	public String searchLoadFactorByTrade(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO,SignOnUserAccount account) throws EventException;

    /**
    * retrieving [Location MatchBack Trend] <br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return MatchBackByMonthlyWeeklyTrendSetVO
    * @exception EventException
    */
	public MatchBackByMonthlyWeeklyTrendSetVO searchLocationMBByLogisticWiseByTrend(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
    
    /**
    * retrieving [Service Mode MatchBack] <br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchMBByServiceMode(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
    
    /**
    * retrieving [Location Booking MatchBack] <br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchLocationMBByBKGWiseInSummary(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
    
    /**
    * retrieving [Location Booking MatchBack Detail] <br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchLocationMBByBKGWiseInDetail(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
    
    /**
    * retrieving [Location Booking MatchBack Trend] <br>
    * 
    * @param mBSearchOptionInGereralVO
    * @return MatchBackByMonthlyWeeklyTrendSetVO
    * @exception EventException
    */
	public MatchBackByMonthlyWeeklyTrendSetVO searchLocationMBByBKGWiseByTrend(MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws EventException;
    
    /**
    * retrieving [Cargo Flow Map] <br>
    * 
    * @param searchOptionByFromToVO
    * @return List<QuantityByTypeSizeVO>
    * @exception EventException
    */
	public List<QuantityByTypeSizeVO> searchCargoFlowMap(SearchOptionByFromToVO searchOptionByFromToVO) throws EventException;
    
    /**
    * retrieving [Previous Weeks] <br>
    * 
    * @param searchOptionByFromToVO
    * @return List<SearchBatchJobStatusVO>
    * @exception EventException
    */
	public List<SearchBatchJobStatusVO> searchPreviousWeeks(SearchOptionByFromToVO searchOptionByFromToVO) throws EventException;
    
    /**
    * retrieving [Batch Job Status] <br>
    * 
    * @param searchOptionByFromToVO
    * @return List<SearchBatchJobStatusVO>
    * @exception EventException
    */
	public List<SearchBatchJobStatusVO> searchBatchJobStatus(SearchOptionByFromToVO searchOptionByFromToVO) throws EventException;
    
    /**
    * retrieving [Vessel MatchBack] <br>
    * 
    * @param searchOptionByTradeLaneVvdVO
    * @param account
    * @return String
    * @exception EventException
    */
    public String searchMBByVessel(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO,SignOnUserAccount account) throws EventException;
    
    /**
    * retrieving [Vessel MatchBack Lane List] <br>
    * 
    * @param searchOptionByTradeLaneVvdVO
    * @return String[]
    * @exception EventException
    */
    public String[] searchMBByVesselLaneListByTrade(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO) throws EventException;
    
    /**
    * retrieving [Vessel MatchBack VVD List] <br>
    * 
    * @param searchOptionByTradeLaneVvdVO
    * @return String[]
    * @exception EventException
    */
    public String[] searchMBByVesselVvdListByTradeLane(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO) throws EventException;

    /**
     * retrieving [MatchBack VVD List] <br>
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
 	 * retrieving status value for BackEndJob result <br>
 	 *
 	 * @param String key
 	 * @return String
 	 * @exception EventException
 	 */
 	public String searchComBackEndJobStatusBasic(String key) throws EventException;
     
}