/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPIPerformanceDBDAO.java
*@FileTitle : KPI Performance Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.basic.KPIPerformanceBCImpl;
import com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.vo.KpiPerformanceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS KPIPerformanceDBDAO <br>
 * - ALPS-PerformanceManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see KPIPerformanceBCImpl 참조
 * @since J2EE 1.6
 */
public class KPIPerformanceDBDAO extends DBDAOSupport {

	
	/**
	 * KPI Performance 내용 조회.<br>
	 * 
	 * @param KpiPerformanceVO kpiPerformanceVO
	 * @return List<KpiPerformanceVO>
	 * @exception EventException
	 */
	public List<KpiPerformanceVO> searchKpiPerformanceCfm(KpiPerformanceVO kpiPerformanceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KpiPerformanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(kpiPerformanceVO != null){
				Map<String, String> mapVO = kpiPerformanceVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KPIPerformanceDBDAOsearchKpiPerformanceCfmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KpiPerformanceVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * KPI Performance Confirm 을 수정한다.
	 * @param KpiPerformanceVO kpiPerformanceVO
	 * @throws DAOException
	 */
	public void modifyKpiPerformanceCfm(KpiPerformanceVO kpiPerformanceVO) throws DAOException{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(kpiPerformanceVO != null){
				Map<String, String> param = kpiPerformanceVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new KPIPerformanceDBDAOmultiKpiPerformanceCfmUSQL() , param, null);				
				
				 if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Insert SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	
	}
	
	/**
	 * KPI Performance Confirm 을 저장한다.
	 * @param KpiPerformanceVO kpiPerformanceVO
	 * @throws DAOException
	 */
	public void addKpiPerformanceCfm(KpiPerformanceVO kpiPerformanceVO) throws DAOException{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(kpiPerformanceVO != null){
				Map<String, String> param = kpiPerformanceVO.getColumnValues();
				int result = sqlExe.executeUpdate((ISQLTemplate) new KPIPerformanceDBDAOAddKpiPerformanceCfmCSQL() , param, null);				
				
				if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Insert SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
}