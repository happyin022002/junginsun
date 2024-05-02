/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInquiryBC.java
*@FileTitle : Fleet Status
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.basic;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.CondSearchFleetStatusSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.CondSearchFleetStatusVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchCapitalBudgetListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchCapitalBudgetSumListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchFleetStatusListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchFleetStatusSumListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchStatementOfAccountListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchStatementOfAccountSumListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-Timecharterinoutfleetmanagement Business Logic Command Interface<br>
 * - OPUS-Timecharterinoutfleetmanagement Biz Logic Interface<br>
 *
 * @author 
 * @see Esm_fms_0060EventResponse 
 * @since J2EE 1.6
 */

public interface TCharterIOInquiryBC {
	
	/**
	 * Retrieving current Fleet status<br>
	 * 
	 * @param condSearchFleetStatusVO CondSearchFleetStatusVO
	 * @return List<SearchFleetStatusListVO>
	 * @exception EventException
	 */
	public List<SearchFleetStatusListVO> searchFleetStatusList(CondSearchFleetStatusVO condSearchFleetStatusVO) throws EventException;
	
	/**
	 * Calculating Hire Sum of Fleet status by Currency<br>
	 * 
	 * @param condSearchFleetStatusSumVO CondSearchFleetStatusSumVO
	 * @return List<SearchFleetStatusSumListVO>
	 * @exception EventException
	 */
	public List<SearchFleetStatusSumListVO> searchFleetStatusSumList(CondSearchFleetStatusSumVO condSearchFleetStatusSumVO) throws EventException;
	
	/**
	 * Retrieving total summary about Calculating Requirement executed after starting Vessel Charter/Hire Out one by one by Sequence<br>
	 * 
	 * @param fletCtrtNo String
	 * @param hirNo String
	 * @return List<SearchStatementOfAccountListVO>
	 * @exception EventException
	 */
	public List<SearchStatementOfAccountListVO> searchStatementOfAccountList(String fletCtrtNo, String hirNo) throws EventException;

	/**
	 * Retrieving total summary about Calculating Requirement executed after starting Vessel Charter/Hire Out by Sequence and Currency<br>
	 * 
	 * @param fletCtrtNo String
	 * @param hirNo String
	 * @return List<SearchStatementOfAccountSumListVO>
	 * @exception EventException
	 */
	public List<SearchStatementOfAccountSumListVO> searchStatementOfAccountSumList(String fletCtrtNo, String hirNo) throws EventException;
	
	/**
	 * Retrieving Capital Budget data<br>
	 * 
	 * @param effDt String
	 * @param expDt String
	 * @param vslCd String
	 * @return List<SearchCapitalBudgetListVO>
	 * @exception EventException
	 */
	public List<SearchCapitalBudgetListVO> searchCapitalBudgetList(String effDt, String expDt, String vslCd) throws EventException;

	/**
	 * Retrieving Capital Budget Sum by Currency <br>
	 * 
	 * @param effDt String
	 * @param expDt String
	 * @param vslCd String
	 * @return List<SearchCapitalBudgetSumListVO>
	 * @exception EventException
	 */
	public List<SearchCapitalBudgetSumListVO> searchCapitalBudgetSumList(String effDt, String expDt, String vslCd) throws EventException;
	
}