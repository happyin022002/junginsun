/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualCostCSRManageBC.java
*@FileTitle : CSR I/F Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRMonitoringListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchRVVDChangeActualCostCSRListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-LogisticsExpenseAccrual Business Logic Command Interface<br>
 * - The interface of the business logic about ALPS-LogisticsExpenseAccrual<br>
 *
 * @author
 * @see Esd_lea_0012EventResponse 
 * @since J2EE 1.6
 */

public interface ActualCostCSRManageBC {

	/**
	 * Inquiring the CSR list.<br>
	 * 
	 * @param SearchActualCostCSRListVO searchActualCostCSRListVO
	 * @return List<SearchActualCostCSRListVO>
	 * @exception EventException
	 */
	public List<SearchActualCostCSRListVO> searchActualCostCSRList(SearchActualCostCSRListVO searchActualCostCSRListVO) throws EventException;
	
	/**
	 * Inquiring the CSR monitoring list by the actual cost.<br>
	 * 
	 * @param SearchActualCostCSRMonitoringListVO searchActualCostCSRMonitoringListVO
	 * @return List<SearchActualCostCSRMonitoringListVO>
	 * @exception EventException
	 */
	public List<SearchActualCostCSRMonitoringListVO> searchActualCostCSRMonitoringList(SearchActualCostCSRMonitoringListVO searchActualCostCSRMonitoringListVO) throws EventException;
	
	/**
	 * Inquiring the actual cost CSR list by the changing RVVD <br>
	 * 
	 * @param SearchRVVDChangeActualCostCSRListVO searchRVVDChangeActualCostCSRListVO
	 * @return List<SearchRVVDChangeActualCostCSRListVO>
	 * @exception EventException
	 */
	public List<SearchRVVDChangeActualCostCSRListVO> searchRVVDChangeActualCostCSRList(SearchRVVDChangeActualCostCSRListVO searchRVVDChangeActualCostCSRListVO) throws EventException;
	
}