/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostBatchBC.java
*@FileTitle : Cost Batch
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.05.03 변종건 [CHM-201217633] Inland Cost Batch Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costbatch.costbatch.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.vo.SearchCostCalcListVO;
import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.vo.SearchFdrCostBatchErrorVO;
import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.vo.SearchInlandCostBatchErrorVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see EsdTrs3004EventResponse 참조
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
	 * @param searchInlandCostBatchErrorVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchInlandCostBatchErrorVO> searchInlandCostBatchError(SearchInlandCostBatchErrorVO searchInlandCostBatchErrorVO) throws EventException;
	
	/**
	 * @param searchFdrCostBatchErrorVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchFdrCostBatchErrorVO> searchFdrCostBatchError(SearchFdrCostBatchErrorVO searchFdrCostBatchErrorVO) throws EventException;
	
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