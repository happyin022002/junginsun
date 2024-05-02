/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInquiryBC.java
*@FileTitle : Fleet Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.26 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.CondSearchFleetStatusSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.CondSearchFleetStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchCapitalBudgetListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchCapitalBudgetSumListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchFleetStatusListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchFleetStatusSumListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchStatementOfAccountListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchStatementOfAccountSumListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchRfStatusListVO;

/**
 * NIS2010-Timecharterinoutfleetmanagement Business Logic Command Interface<br>
 * - NIS2010-Timecharterinoutfleetmanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Choi Woo-Seok
 * @see Esm_fms_0060EventResponse 참조
 * @since J2EE 1.6
 */

public interface TCharterIOInquiryBC {
	
	/**
	 * 선박 현황을 조회한다<br>
	 * 
	 * @param condSearchFleetStatusVO CondSearchFleetStatusVO
	 * @return List<SearchFleetStatusListVO>
	 * @exception EventException
	 */
	public List<SearchFleetStatusListVO> searchFleetStatusList(CondSearchFleetStatusVO condSearchFleetStatusVO) throws EventException;
	
	/**
	 * 선박 현황을 Currency 별로 Hire 금액을 산출한다<br>
	 * 
	 * @param condSearchFleetStatusSumVO CondSearchFleetStatusSumVO
	 * @return List<SearchFleetStatusSumListVO>
	 * @exception EventException
	 */
	public List<SearchFleetStatusSumListVO> searchFleetStatusSumList(CondSearchFleetStatusSumVO condSearchFleetStatusSumVO) throws EventException;
	
	/**
	 * 선박 용/대선 시작 이후 집행된 정산 요건에 대한 전체 정리 및 회차 별 개별 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param hirNo String
	 * @return List<SearchStatementOfAccountListVO>
	 * @exception EventException
	 */
	public List<SearchStatementOfAccountListVO> searchStatementOfAccountList(String fletCtrtNo, String hirNo) throws EventException;

	/**
	 * 선박 용/대선 시작 이후 집행된 정산 요건에 대한 전체 정리 및 회차 별 통화별로 합계 금액을 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param hirNo String
	 * @return List<SearchStatementOfAccountSumListVO>
	 * @exception EventException
	 */
	public List<SearchStatementOfAccountSumListVO> searchStatementOfAccountSumList(String fletCtrtNo, String hirNo) throws EventException;
	
	/**
	 * Capital Budget 자료를 조회한다<br>
	 * 
	 * @param effDt String
	 * @param expDt String
	 * @param vslCd String
	 * @return List<SearchCapitalBudgetListVO>
	 * @exception EventException
	 */
	public List<SearchCapitalBudgetListVO> searchCapitalBudgetList(String effDt, String expDt, String vslCd) throws EventException;

	/**
	 * 통화별 Total 금액 조회한다<br>
	 * 
	 * @param effDt String
	 * @param expDt String
	 * @param vslCd String
	 * @return List<SearchCapitalBudgetSumListVO>
	 * @exception EventException
	 */
	public List<SearchCapitalBudgetSumListVO> searchCapitalBudgetSumList(String effDt, String expDt, String vslCd) throws EventException;
	
	
	/**
	 * VVD로 RF 상태를 요약 조회한다.  <br>
	 * 
	 * @param vvd String
	 * @return List<SearchRfStatusListVO>
	 * @exception EventException
	 */
	public List<SearchRfStatusListVO> searchRfStatusInquiryByVvdSummaryList(String vvd) throws EventException;

	/**
	 * VVD로 RF 상태를 상세 조회한다.<br>
	 * 
	 * @param vvd String
	 * @return List<SearchRfStatusListVO>
	 * @exception EventException
	 */
	public List<SearchRfStatusListVO> searchRfStatusInquiryByVvdDetailList(String vvd) throws EventException;	
	
}