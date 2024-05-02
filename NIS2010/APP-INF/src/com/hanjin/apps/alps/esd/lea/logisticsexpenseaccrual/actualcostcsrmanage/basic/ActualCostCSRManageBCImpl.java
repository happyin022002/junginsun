/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualCostCSRManageBCImpl.java
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

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.integration.ActualCostCSRManageDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRMonitoringListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchCsrListByGLMonthVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchRVVDChangeActualCostCSRListVO;

/**
 * ALPS-LogisticsExpenseAccrual Business Logic Basic Command implementation<br>
 * - ALPS-LogisticsExpenseAccrual에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0012EventResponse,ActualCostCSRManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ActualCostCSRManageBCImpl extends BasicCommandSupport implements ActualCostCSRManageBC {

	// Database Access Object
	private transient ActualCostCSRManageDBDAO dbDao = null;
	private transient ActualCostCSRManageDBDAO dbDaoNIS2010 = null;

	/**
	 * ActualCostCSRManageBCImpl 객체 생성<br>
	 * ActualCostCSRManageDBDAO를 생성한다.<br>
	 */
	public ActualCostCSRManageBCImpl() {
		dbDao = new ActualCostCSRManageDBDAO();
		dbDaoNIS2010 = new ActualCostCSRManageDBDAO();
		
	}
	/**
	 * 수행월별 사전 모니터링 결과를 조회한다..<br>
	 * 
	 * @param SearchActualCostCSRMonitoringListVO searchActualCostCSRMonitoringListVO
	 * @return List<SearchActualCostCSRMonitoringListVO>
	 * @exception EventException
	 */
	public List<SearchActualCostCSRMonitoringListVO> searchActualCostCSRMonitoringList(SearchActualCostCSRMonitoringListVO searchActualCostCSRMonitoringListVO) throws EventException {
		try {
			return dbDao.searchActualCostCSRMonitoringList(searchActualCostCSRMonitoringListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * CSR LIST 를 조회한다.<br>
	 * 
	 * @param SearchActualCostCSRListVO searchActualCostCSRListVO
	 * @return List<SearchActualCostCSRListVO>
	 * @exception EventException
	 */
	public List<SearchActualCostCSRListVO> searchActualCostCSRList(SearchActualCostCSRListVO searchActualCostCSRListVO) throws EventException {
		try {
			return dbDaoNIS2010.searchActualCostCSRList(searchActualCostCSRListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Rev.VVD Change 대상 CSR을 조회한다.<br>
	 * 
	 * @param SearchRVVDChangeActualCostCSRListVO searchRVVDChangeActualCostCSRListVO
	 * @return List<SearchRVVDChangeActualCostCSRListVO>
	 * @exception EventException
	 */
	public List<SearchRVVDChangeActualCostCSRListVO> searchRVVDChangeActualCostCSRList(SearchRVVDChangeActualCostCSRListVO searchRVVDChangeActualCostCSRListVO) throws EventException {
		try {
			return dbDaoNIS2010.searchRVVDChangeActualCostCSRList(searchRVVDChangeActualCostCSRListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * CSR LIST 를 조회한다.<br>
	 * 
	 * @param SearchCsrListByGLMonthVO searchCsrListByGLMonthVO
	 * @return List<SearchCsrListByGLMonthVO>
	 * @exception EventException
	 */
	public List<SearchCsrListByGLMonthVO> searchActualCostCsrListByGLMonth(SearchCsrListByGLMonthVO searchCsrListByGLMonthVO) throws EventException {
		try {
			return dbDaoNIS2010.searchActualCostCsrListByGLMonth(searchCsrListByGLMonthVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
}