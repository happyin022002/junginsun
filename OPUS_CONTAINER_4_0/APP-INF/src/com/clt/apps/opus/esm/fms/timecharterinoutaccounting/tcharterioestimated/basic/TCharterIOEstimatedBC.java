/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOEstimatedBC.java
*@FileTitle : Estimated I/F To ERP(RV)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.basic;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.ConditionEstmIfVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.CustomEstmIfVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedHireResultListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedRevenueListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-Timecharterinoutaccounting Business Logic Command Interface<br>
 * - OPUS-Timecharterinoutaccounting Biz Logic Interface<br>
 *
 * @author 
 * @see Esm_fms_0046EventResponse 
 * @since J2EE 1.6
 */

public interface TCharterIOEstimatedBC {
	
	/**
	 * Retrieving data for each voyage by Charter/Hire Out costs, monthly import target voyage<br>
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedRevenueListVO> searchEstimatedRevenueCreList(ConditionEstmIfVO conditionEstmIfVO) throws EventException;

	/**
	 * Retrieving data for each voyage by Charter/Hire Out costs, monthly import target voyage<br>
	 * 2015.10.26 Modify.
	 * 
	 * @param searchEstimatedRevenueListVOs SearchEstimatedRevenueListVO[]
	 * @param slpOfcCd String
	 * @param usrId String
	 * @exception EventException
	 */
	public void createEstimatedHireRevenue(SearchEstimatedRevenueListVO[] searchEstimatedRevenueListVOs, String slpOfcCd, String usrId) throws EventException;
	
		
	/**
	 * Retrieving data for each voyage by Charter/Hire Out costs, monthly import target voyage<br>
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedHireResultListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedHireResultListVO> searchEstimatedHireResultList(ConditionEstmIfVO conditionEstmIfVO) throws EventException ;
	
	/**
	 * Retrieving data for each voyage by Charter/Hire Out costs, monthly import target voyage(RV)<br>
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedRevenueListVO> searchEstimatedResultByHireList(ConditionEstmIfVO conditionEstmIfVO) throws EventException;
	

	/**
	 * Retrieving data for each voyage by Charter/Hire Out costs, monthly import target voyage<br>
	 * 
	 * @param customEstmIfVOs CustomEstmIfVO[]
	 * @param slpOfcCd String
	 * @param usrId String
	 * @exception EventException
	 */
	public void createEstimatedProRevenue(CustomEstmIfVO[] customEstmIfVOs, String slpOfcCd, String usrId) throws EventException;
	
	/**
	 * Retrieving data for each voyage by Charter/Hire Out costs, monthly import target voyage<br>
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedProRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedProRevenueListVO> searchEstimatedProRevenueList(ConditionEstmIfVO conditionEstmIfVO) throws EventException ;
	
	/**
	 * Retrieving data for each voyage by Charter/Hire Out costs, monthly import target voyage(PV)<br>
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedRevenueListVO> searchEstimatedResultByProList(ConditionEstmIfVO conditionEstmIfVO) throws EventException;
}