/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualCostCSRManageBCImpl.java
*@FileTitle : CSR I/F Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.integration.ActualCostCSRManageDBDAO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRMonitoringListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchRVVDChangeActualCostCSRListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-LogisticsExpenseAccrual Business Logic Basic Command implementation<br>
 * - Handling the business logic about ALPS-LogisticsExpenseAccrual<br>
 *
 * @author 
 * @see ESD_LEA_0012EventResponse,ActualCostCSRManageBC
 * @since J2EE 1.6
 */
public class ActualCostCSRManageBCImpl extends BasicCommandSupport implements ActualCostCSRManageBC {

	// Database Access Object
	private transient ActualCostCSRManageDBDAO dbDao = null;
	private transient ActualCostCSRManageDBDAO dbDaoNIS2010 = null;

	/**
	 * Creating ActualCostCSRManageBCImpl <br>
	 * Creating ActualCostCSRManageDBDAO<br>
	 */
	public ActualCostCSRManageBCImpl() {
		dbDao = new ActualCostCSRManageDBDAO();
		dbDaoNIS2010 = new ActualCostCSRManageDBDAO();
		
	}
	/**
	 * Inquiring the CSR monitoring list by the actual cost.<br>
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
	 * Inquiring the CSR list.<br>
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
	 * Inquiring the actual cost CSR list by the changing RVVD <br>
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
	
}