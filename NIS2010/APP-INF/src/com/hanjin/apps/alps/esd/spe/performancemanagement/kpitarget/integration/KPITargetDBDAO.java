/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPITargetDBDAO.java
*@FileTitle : KPI Target Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.basic.KPITargetBCImpl;
import com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.vo.KpiPerformanceTargetVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS KPITargetDBDAO <br>
 * - ALPS-PerformanceManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see KPITargetBCImpl 참조
 * @since J2EE 1.6
 */
public class KPITargetDBDAO extends DBDAOSupport {



	 /**
	  * Level3 목록 조회
	  * @param KpiPerformanceTargetVO
	  * @return List<KpiPerformanceTargetVO>
	  * @throws DAOException
	  */
    public List<KpiPerformanceTargetVO> searchSpSvcCateKpi(KpiPerformanceTargetVO kpiPerformanceTargetVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KpiPerformanceTargetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(kpiPerformanceTargetVO != null){
				Map<String, String> mapVO = kpiPerformanceTargetVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KpiTargetDBDAOSearchKpiSpSvcCateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KpiPerformanceTargetVO .class);
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
     * KPI Target 가중치 조회
     * @param KpiPerformanceTargetVO
     * @return
     * @throws DAOException
     */
	public List<KpiPerformanceTargetVO> searchKpiPerformanceTarget(
			KpiPerformanceTargetVO kpiPerformanceTargetVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<KpiPerformanceTargetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(kpiPerformanceTargetVO != null){
				Map<String, String> mapVO = kpiPerformanceTargetVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KpiTargetDBDAOSearchKPIPerformanceTargetRSQL(), param, velParam);
			if( dbRowset != null){
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, KpiPerformanceTargetVO .class);
			}
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
	 * KPI Target 가중치 입력
	 * @param insertVoList
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpeGrpKpiTargetCreation(
			List<KpiPerformanceTargetVO> insertVoList) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new KpiTargetDBDAOMultiSpeGrpKpiTargetCSQL(), insertVoList,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * KPI Target 가중치 수정
	 * @param updateVoList
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpeGrpKpiTargetCreation(
			List<KpiPerformanceTargetVO> updateVoList) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new KpiTargetDBDAOMultiSpeGrpKpiTargetUSQL(), updateVoList,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * KPI Target 가중치 삭제
	 * @param deleteVoList
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSpeGrpKpiTargetCreation(
			List<KpiPerformanceTargetVO> deleteVoList) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new KpiTargetDBDAOMultiSpeGrpKpiTargetDSQL(), deleteVoList,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	 

}