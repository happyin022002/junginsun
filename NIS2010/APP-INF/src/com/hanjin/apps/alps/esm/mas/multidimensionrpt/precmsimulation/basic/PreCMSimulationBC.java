/*=========================================================

*Copyright(c) 2009 CyberLogitec
*@FileName : PreCMSimulationBC.java
*@FileTitle : Pre CM/OP Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.15 송호진
* 1.0 Creation
* History
* 2008-05-16 Ari
* 1.0 최초 생성 CSR No.N200804140004, N200804146015, N200804146018
* 2009.06.10 박상희 CSR No. N200905110270 MAS_Pre CM/OP Simulation : Temp T/S Route 입력기능[153]
* 2010.09.28 박은주 OPMS 결함 복구작업 [메소드명 변경]
*                  createMasCostPkgPreCMAbc => createMasCostPkgPreCMAbcStp
* 2012.02.20 김종준 [CHM-201216268-01] [MAS] Pre CM/OP 화면 Backandjob로 조회로  로직 변경         
* 2013.12.04 김수정 [CHM-201327857] [MAS] Pre CM 조회시 에러 메세지 관련 - Backend Job으로 변경         
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.CommonMasRsVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo.PreCMRemarkVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo.RevenueDetailCondVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo.RevenueDetailVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo.SearchCondition0153VO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * ALPS-Multidimensionrpt Business Logic Command Interface<br>
 * - ALPS-Multidimensionrpt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Song Ho Jin
 * @see ESM_MAS_051EventResponse 참조
 * @since J2EE 1.6
 */

public interface PreCMSimulationBC {

	/**
	 * 기본정보(PARA DATA) 생성
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO 
	 * @return String
	 * @throws EventException
	 */
	public String createCostAssignPreCM(SearchCondition0153VO searchCondition0153VO) throws EventException;

	/**
	 * 기준년월 조회
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String searchBzcCostYrmon() throws EventException;

	/**
	 * TRS 비용 생성
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO 
	 * @return String
	 * @throws EventException
	 */
	public String createTrsAgmtApplyToMas(SearchCondition0153VO searchCondition0153VO) throws EventException;


	/**
	 * TES 비용 생성
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO 
	 * @return String
	 * @throws EventException
	 */
	public String createTesMasRate(SearchCondition0153VO searchCondition0153VO) throws EventException;


	/**
	 * MAS 평균단가를 이용한 비용 생성
	 * 
	 * @param  SearchCondition0153VO searchCondition0153VO
	 * @return String
	 * @throws EventException
	 */
	public String createMasCostPkgMainPreCMAvg(SearchCondition0153VO searchCondition0153VO) throws EventException;


	/**
	 * MAS ABC 비용 생성
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO 
	 * @return String
	 * @throws EventException
	 */
	public String createMasCostPkgPreCMAbcStp(SearchCondition0153VO searchCondition0153VO) throws EventException;


	/**
	 * Total 비용 계산 및 USD환산
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO 
	 * @return String
	 * @throws EventException
	 */
	public String createMasCostPkgMainComTtl(SearchCondition0153VO searchCondition0153VO) throws EventException;

	/**
	 * 비용 조회
	 * 
	 * @param SearchCondition0153VO searchCondition0153VO
	 * @return CommonMasRsVO
	 * @exception EventException
	 */
	public CommonMasRsVO searchPreCMSimulationCostList(SearchCondition0153VO searchCondition0153VO) throws EventException;
	/**
	 * 비용 RMK 상세조회
	 * 
	 * @param SearchCondition0153VO searchCondition0153VO
	 * @return List<PreCMRemarkVO>
	 * @exception EventException
	 */
	public List<PreCMRemarkVO> searchPreCMRemarkList(SearchCondition0153VO searchCondition0153VO) throws EventException;
	

	/**
     * ESM_MAS_0153 비용 생성<br>
     * 
     * @param SearchCondition0153VO searchCondition0153VO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
	public String createPreCMSimulation(SearchCondition0153VO searchCondition0153VO, SignOnUserAccount account) throws EventException;
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String object
	 * @return String
	 * @exception EventException
	 */
	public String searchBackEndJobStatus(String object) throws EventException;

	/**
	 * PRD Route BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchPrdBackEndJobStatus(String key) throws EventException;
	
	/**
	 * PRD Route 정보 조회 에러 메시지를 조회한다.
	 * 
	 * @param String key
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchPrdBackEndJob(String key) throws EventException;
	
	/**                                                                                                                 
	 * Sucharge의 전체 List를 조회합니다. <br>                                                                          
	 *                                                                                                                  
	 * @param RevenueDetailCondVO revenueDetailCondVO
	 * @return List<RevenueDetailVO>                                                                                         
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public List<RevenueDetailVO> searchRevenueDetailList(RevenueDetailCondVO revenueDetailCondVO) throws EventException;
}