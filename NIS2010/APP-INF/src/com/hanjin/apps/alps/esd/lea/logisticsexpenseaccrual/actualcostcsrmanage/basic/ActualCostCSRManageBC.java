/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualCostCSRManageBC.java
*@FileTitle : CSR I/F Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.08.17 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRMonitoringListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchCsrListByGLMonthVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchRVVDChangeActualCostCSRListVO;


/**
 * ALPS-Logisticsexpenseaccrual Business Logic Command Interface<br>
 * - ALPS-Logisticsexpenseaccrual에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jeon Jae Hong
 * @see Esd_lea_0012EventResponse 참조
 * @since J2EE 1.6
 */

public interface ActualCostCSRManageBC {

	/**
	 * CSR LIST 를 조회한다.<br>
	 * 
	 * @param SearchActualCostCSRListVO searchActualCostCSRListVO
	 * @return List<SearchActualCostCSRListVO>
	 * @exception EventException
	 */
	public List<SearchActualCostCSRListVO> searchActualCostCSRList(SearchActualCostCSRListVO searchActualCostCSRListVO) throws EventException;
	
	/**
	 * 수행월별 사전 모니터링 결과를 조회한다..<br>
	 * 
	 * @param SearchActualCostCSRMonitoringListVO searchActualCostCSRMonitoringListVO
	 * @return List<SearchActualCostCSRMonitoringListVO>
	 * @exception EventException
	 */
	public List<SearchActualCostCSRMonitoringListVO> searchActualCostCSRMonitoringList(SearchActualCostCSRMonitoringListVO searchActualCostCSRMonitoringListVO) throws EventException;
	
	/**
	 * Rev.VVD Change 대상 CSR 을 조회한다.<br>
	 * 
	 * @param SearchRVVDChangeActualCostCSRListVO searchRVVDChangeActualCostCSRListVO
	 * @return List<SearchRVVDChangeActualCostCSRListVO>
	 * @exception EventException
	 */
	public List<SearchRVVDChangeActualCostCSRListVO> searchRVVDChangeActualCostCSRList(SearchRVVDChangeActualCostCSRListVO searchRVVDChangeActualCostCSRListVO) throws EventException;
	
	/**
	 * CSR LIST 를 조회한다.<br>
	 * 
	 * @param SearchCsrListByGLMonthVO searchCsrListByGLMonthVO
	 * @return List<SearchCsrListByGLMonthVO>
	 * @exception EventException
	 */
	public List<SearchCsrListByGLMonthVO> searchActualCostCsrListByGLMonth(SearchCsrListByGLMonthVO searchCsrListByGLMonthVO) throws EventException;
	
	
}