/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostBatchBC.java
*@FileTitle : Cost Batch
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.vo.SearchCostCalcListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-AOC Business Logic Command Interface<br>
 * - ESD-AOC에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see BC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public interface CostBatchBC  {
	
	/**
	 * @param searchCostCalcListVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public List<SearchCostCalcListVO> searchCostCalcList(SearchCostCalcListVO searchCostCalcListVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param searchCostCalcListVOs
	 * @param account
	 * @throws EventException
	 */
	public void insertBatchQueue(SearchCostCalcListVO[] searchCostCalcListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param searchCostCalcListVOs
	 * @param account
	 * @throws EventException
	 */
	public void modifyBatchSeq(SearchCostCalcListVO[] searchCostCalcListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param searchCostCalcListVOs
	 * @param account
	 * @throws EventException
	 */
	public void modifyUsaBatchDtlSeq(SearchCostCalcListVO[] searchCostCalcListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param searchCostCalcListVOs
	 * @return
	 * @throws EventException
	 */
	public String monitorBatchExec(SearchCostCalcListVO[] searchCostCalcListVOs) throws EventException;
	
	/**
	 * @param searchCostCalcListVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchCostCalcListVO> searchFeederCostCalcList(SearchCostCalcListVO searchCostCalcListVO) throws EventException;
	
	/**
	 * @param searchCostCalcListVOs
	 * @param account
	 * @throws EventException
	 */
	public void insertFeederBatchQueue(SearchCostCalcListVO[] searchCostCalcListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param searchCostCalcListVOs
	 * @return
	 * @throws EventException
	 */
	public String monitorFeederBatchExec(SearchCostCalcListVO[] searchCostCalcListVOs) throws EventException;
	
	/**
	 * @param searchCostCalcListVOs
	 * @param account
	 * @throws EventException
	 */
	public void modifyBatchCancel(SearchCostCalcListVO[] searchCostCalcListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param searchCostCalcListVOs
	 * @param account
	 * @throws EventException
	 */
	public void modifyInlandCostCfm(SearchCostCalcListVO[] searchCostCalcListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param searchCostCalcListVOs
	 * @param account
	 * @throws EventException
	 */
	public void modifyInlandCostCfmCxl(SearchCostCalcListVO[] searchCostCalcListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param searchCostCalcListVOs
	 * @return
	 * @throws EventException
	 */
	public String monitorWaitingSts(SearchCostCalcListVO[] searchCostCalcListVOs) throws EventException;
	
	/**
	 * @param searchCostCalcListVOs
	 * @return
	 * @throws EventException
	 */
	public String searchGuidelineExist(SearchCostCalcListVO[] searchCostCalcListVOs) throws EventException;
}