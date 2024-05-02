/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualCostCSRManageDBDAO.java
*@FileTitle : CSR I/F Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.08.17 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.basic.ActualCostCSRManageBCImpl;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRMonitoringListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchCsrListByGLMonthVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchRVVDChangeActualCostCSRListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ActualCostCSRManageDBDAO <br>
 * - ALPS-LogisticsExpenseAccrual system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jeon Jae Hong
 * @see ActualCostCSRManageBCImpl 참조
 * @since J2EE 1.6
 */

public class ActualCostCSRManageDBDAO extends DBDAOSupport {

	/**
	 * CSR LIST 를 조회한다.<br>
	 * 
	 * @param SearchActualCostCSRListVO searchActualCostCSRListVO
	 * @return List<SearchActualCostCSRListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchActualCostCSRListVO> searchActualCostCSRList(SearchActualCostCSRListVO searchActualCostCSRListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchActualCostCSRListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchActualCostCSRListVO != null){
				Map<String, String> mapVO = searchActualCostCSRListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualCostCSRManageDBDAOSearchActualCostCSRListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchActualCostCSRListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
		 * 수행월별 사전 모니터링 결과를 조회한다..<br>
		 * 
		 * @param SearchActualCostCSRMonitoringListVO searchActualCostCSRMonitoringListVO
		 * @return List<SearchActualCostCSRMonitoringListVO>
		 * @throws DAOException
		 */ 
		 @SuppressWarnings("unchecked")
		public List<SearchActualCostCSRMonitoringListVO> searchActualCostCSRMonitoringList(SearchActualCostCSRMonitoringListVO searchActualCostCSRMonitoringListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchActualCostCSRMonitoringListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchActualCostCSRMonitoringListVO != null){
					Map<String, String> mapVO = searchActualCostCSRMonitoringListVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new ActualCostCSRManageDBDAOSearchActualCostCSRMonitoringListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchActualCostCSRMonitoringListVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		 
	 /**
		 * Rev.VVD Change 대상 CSR을 조회한다.<br>
		 * 
		 * @param SearchRVVDChangeActualCostCSRListVO searchRVVDChangeActualCostCSRListVO
		 * @return List<SearchRVVDChangeActualCostCSRListVO>
		 * @throws DAOException
		 */ 
		 @SuppressWarnings("unchecked")
		public List<SearchRVVDChangeActualCostCSRListVO> searchRVVDChangeActualCostCSRList(SearchRVVDChangeActualCostCSRListVO searchRVVDChangeActualCostCSRListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchRVVDChangeActualCostCSRListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchRVVDChangeActualCostCSRListVO != null){
					Map<String, String> mapVO = searchRVVDChangeActualCostCSRListVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualCostCSRManageDBDAOSearchRVVDChangeActualCostCSRListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRVVDChangeActualCostCSRListVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		 
			/**
			 * CSR LIST 를 조회한다.<br>
			 * 
			 * @param SearchCsrListByGLMonthVO searchCsrListByGLMonthVO
			 * @return List<SearchCsrListByGLMonthVO>
			 * @throws DAOException
			 */
			 @SuppressWarnings("unchecked")
			public List<SearchCsrListByGLMonthVO> searchActualCostCsrListByGLMonth(SearchCsrListByGLMonthVO searchCsrListByGLMonthVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<SearchCsrListByGLMonthVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(searchCsrListByGLMonthVO != null){
						Map<String, String> mapVO = searchCsrListByGLMonthVO .getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualCostCSRManageDBDAOSearchActualCostCsrListByGLMonthRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCsrListByGLMonthVO .class);
				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return list;
			}
	
}