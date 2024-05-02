/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : MonthlyCustomizedConditionDBDAO.java
*@FileTitle      : Customized Conditions
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.basic.MonthlyCustomizedConditionBCImpl;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SaqMonDirConvVO;
import com.clt.syscommon.common.table.SaqMonLodTgtOfcVO;


/**
 * MonthlyCustomizedConditionDBDAO <br>
 * - BasicDataManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author taeho, Kim
 * @see MonthlyCustomizedConditionBCImpl 참조
 * @since J2EE 1.6
 */
public class MonthlyCustomizedConditionDBDAO extends DBDAOSupport {

	/**
	 * MonthlyCustomizedCondition화면에 대한 조회 이벤트 처리.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMonthlyCustomizedConditionTabLoadTarget0163Tab01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTargetVO0163Tab01RSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
		/**
		 * [1tab status]을 [조회] 합니다.<br>
		 * 
		 * @param QuotaConditionVO conditionVO
		 * @return String
		 * @throws DAOException
		 */
		public String getMonthlyCustomizedConditionLodTargetStatus0163Tab01(QuotaConditionVO conditionVO) throws DAOException {
			String status="";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(conditionVO != null){
					Map<String, String> mapVO = conditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyCustomizedConditionDBDAOGetMonthlyCustomizedConditionLodTargetStatus0163Tab01RSQL(), param, velParam);
				while (dbRowset.next()) {
					status = dbRowset.getString("status");
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return status;
		}	 

		/**
		 * [2tab status]을 [조회] 합니다.<br>
		 * 
		 * @param QuotaConditionVO conditionVO
		 * @return String
		 * @throws DAOException
		 */
		public String getMonthlyCustomizedConditionLaneBoundStatus0163Tab02(QuotaConditionVO conditionVO) throws DAOException {
			String status="";
			//query parameter 
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(conditionVO != null){
					Map<String, String> mapVO = conditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyCustomizedConditionDBDAOGetMonthlyCustomizedConditionLaneBoundStatus0163Tab02RSQL(), param, velParam);
				while (dbRowset.next()) {
					status = dbRowset.getString("status");
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return status;
		}	 
		
	/**
	 * [2tab]을 [조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO monthlyCustomizedConditionTabLoadTargetConditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMonthlyCustomizedConditionTabLaneBound0163Tab02(QuotaConditionVO monthlyCustomizedConditionTabLoadTargetConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(monthlyCustomizedConditionTabLoadTargetConditionVO != null){
					Map<String, String> mapVO = monthlyCustomizedConditionTabLoadTargetConditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyCustomizedConditionDBDAOSearchMonthlyCustomizedConditionTabLaneBound0163Tab02RSQL(), param, velParam);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
	
	/**
	 * [1tab copy시 key 값] 정보를 [조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchLodTargetPreviousCheckKey0163Tab01(QuotaConditionVO conditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(conditionVO != null){
					Map<String, String> mapVO = conditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyCustomizedConditionDBDAOSearchLodTargetPreviousCheckKey0163Tab01RSQL(), param, velParam);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}

	/**
	 * [2tab copy시 key 값] 정보를 [조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchLaneBoundPreviousCheckKey0163Tab02(QuotaConditionVO conditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(conditionVO != null){
					Map<String, String> mapVO = conditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyCustomizedConditionDBDAOSearchLaneBoundPreviousCheckKey0163Tab02RSQL(), param, velParam);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}

	
	/**
	 * [1tab] 정보를 [copy전 delete] 합니다.<br>
	 *  
	 * @param QuotaConditionVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiMonthlyCustomizedConditionTabLoadTargetCopy0163Tab01BeforeDel(QuotaConditionVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTargetCopyVO0163Tab01DSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [2tab] 정보를 [copy전 delete] 합니다.<br>
	 *  
	 * @param QuotaConditionVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiMonthlyCustomizedConditionTabLaneBoundCopy0163Tab02BeforeDel(QuotaConditionVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLaneBoundCopyVO0163Tab02DSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [1tab Initial data] 정보를 [copy] 합니다.<br>
	 *  
	 * @param QuotaConditionVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiMonthlyCustomizedConditionTabLoadTargetCopy0163Tab01(QuotaConditionVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTargetCopyVO0163Tab01CSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [1tab Initial data] 정보를 [copy] 합니다.<br>
	 *  
	 * @param QuotaConditionVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiMonthlyCustomizedConditionTabLaneBoundCopy0163Tab02(QuotaConditionVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLaneBoundCopyVO0163Tab02CSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	
	/**
	 * [1tab save] 정보를 [confirm/cancel] 합니다.<br>
	 * SAQ_MON_LOD_TGT_OFC에 Data Merge<br>
	 * @param SaqMonLodTgtOfcVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiMonthlyCustomizedConditionTabLoadTargetSave(SaqMonLodTgtOfcVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTargetSaveVO0163Tab01CSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * [1tab] 정보를 [저장] 합니다.<br>
	 * 
	 * @param List<SaqMonLodTgtOfcVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] multiMonthlyCustomizedConditionTabLoadTargetSaveS0163Tab01(List<SaqMonLodTgtOfcVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTargetSaveVO0163Tab01CSQL(), insModels,null);
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
	 * [1tab] 정보를 [삭제] 합니다.<br>
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeMonthlyCustomizedConditionTabLoadTargetSaveS0163Tab01(List<SaqMonLodTgtOfcVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTargetSaveVO0163Tab01DSQL(), updModels, null);
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
	 * [2tab] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<SaqMonDirConvVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] multiMonthlyCustomizedConditionTabLaneBoundSaveVOD0163Tab02(List<SaqMonDirConvVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLaneBoundSaveVO0163Tab02DSQL(), insModels,null);
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
	 * [2tab] 정보를 [저장] 합니다.<br>
	 * 
	 * @param List<SaqMonDirConvVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] multiMonthlyCustomizedConditionTabLaneBoundSaveVOC0163Tab02(List<SaqMonDirConvVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLaneBoundSaveVO0163Tab02CSQL(), insModels,null);
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
	 * [2tab] 정보를 [confirm/cancel] 합니다.<br>
	 * 
	 * @param QuotaConditionVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateMonthlyCustomizedConditionTabLaneBound0163Tab02(QuotaConditionVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLaneBoundSaveVO0163Tab02USQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
	 * [1tab] 정보를 [confirm/cancel] 합니다.<br>
	 * 
	 * @param QuotaConditionVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateMonthlyCustomizedConditionTabLoadTarget0163Tab01(QuotaConditionVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLoadTarget0163Tab01USQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
}