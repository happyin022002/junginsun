/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USDomesticBC.java
*@FileTitle : US domestic cost/credit 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 김보배
*@LastVersion : 1.0 
* 2012.10.16 김보배
* 1.0 Creation
*=========================================================
* History
* 2013.05.10 최성민 [CHM-201324573-01] [MAS] Domestic Saving Credit 화면 버튼 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.vo.AverageRPBVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Stdunitcost Business Logic Command Interface<br>
 * - ALPS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author BOBAE KIM
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.5
 */

public interface AverageRPBBC {
	
	/**
	 * searchRouteRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws EventException
	 */
	public List<AverageRPBVO> searchRouteRPBList(AverageRPBVO averageRPBVO) throws EventException;
	
	/**
	 * searchCustomerRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws EventException
	 */
	public List<AverageRPBVO> searchCustomerRPBList(AverageRPBVO averageRPBVO) throws EventException;
	
	/**
	 * searchSCCRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws EventException
	 */
	public List<AverageRPBVO> searchSCCRPBList(AverageRPBVO averageRPBVO) throws EventException;
	
	/**
	 * searchLaneRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws EventException
	 */
	public List<AverageRPBVO> searchLaneRPBList(AverageRPBVO averageRPBVO) throws EventException;
	
	/**
	 * searchTradeRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws EventException
	 */
	public List<AverageRPBVO> searchTradeRPBList(AverageRPBVO averageRPBVO) throws EventException;
	
	/**
	 * ESM_MAS_0183 : CREATE 된 기간 조회
	 *
	 * @param String fRpbYrmon
	 * @return String
	 * @throws EventException
	 */
	public String searchAverageRPBCreationStatus(String fRpbYrmon) throws EventException;
	
	/**
	 * Target YRMON 에 대해 AverageRPB 배치가 실행 되었는지 확인한다.
	 * 
	 * @param String fTargetYrMon
	 * @return String
	 * @throws EventException
	 */
	public String searchRPBStatus(String fTargetYrMon) throws EventException ;
	
	/**
	 * Average RPB BATCH 가 실행중인지를 check 한다.
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String checkAverageRPBCreateBatchStatus() throws EventException ;
	
	/**
	 * Week 단위로 Average RPB BATCH 를 수행한다. <br>
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return String
	 * @exception EventException
	 */
	public String createAverageRPB(AverageRPBVO averageRPBVO) throws EventException;

	/**
	 * Average RPB BATCH status 를 생성한다. <br>
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAverageRPBStatus(AverageRPBVO averageRPBVO, SignOnUserAccount account) throws EventException;
	
}