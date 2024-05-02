/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolChassisHistoryDBDAO.java
*@FileTitle : Pool Chassis Comparison Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.04 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.basic.PoolChassisHistoryBCImpl;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolCoChssUseHisMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolExpenseTrendMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMaintRprHisMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMnrHistoryINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMnrHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtCompareSmryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolUseddysINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolUseddysMGTVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS PoolChassisHistoryDBDAO <br>
 * - OPUS-MovementMnrHistory system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI MIN HOI
 * @see PoolChassisHistoryBCImpl 참조
 * @since J2EE 1.6
 */
public class PoolChassisHistoryDBDAO extends DBDAOSupport {

	/**
	 * Pool movement & Movement 비교, match/unmatch summary  정보 조회  [EES_CGM_1142]  <br>
	 * 
	 * @param poolMvmtINVO PoolMvmtINVO 
	 * @return List<PoolMvmtCompareSmryMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PoolMvmtCompareSmryMGTVO> searchPoolMvmtCompareDtlData(PoolMvmtINVO poolMvmtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PoolMvmtCompareSmryMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(poolMvmtINVO != null){
				Map<String, String> mapVO = poolMvmtINVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PoolChassisHistoryDBDAOsearchPoolMvmtCompareDtlDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoolMvmtCompareSmryMGTVO .class);
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
	 * Pool movement & Movement 비교, match/unmatch summary 조회 조회 [EES_CGM_1141] <br>
	 * 
	 * @param poolMvmtINVO PoolMvmtINVO 
	 * @return List<PoolMvmtCompareSmryMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<PoolMvmtCompareSmryMGTVO> searchPoolMvmtCompareSmryData(PoolMvmtINVO poolMvmtINVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PoolMvmtCompareSmryMGTVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(poolMvmtINVO != null){
					Map<String, String> mapVO = poolMvmtINVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PoolChassisHistoryDBDAOsearchPoolMvmtCompareSmryDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoolMvmtCompareSmryMGTVO .class);
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
	 * Pool movement & Movement 비교, match/unmatch summary 조회 조회 [EES_CGM_1141] <br>
	 * 
	 * @param poolMvmtINVO PoolMvmtINVO 
	 * @return List<PoolMvmtCompareSmryMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<PoolMvmtCompareSmryMGTVO> searchPoolMvmtCompareMatchingSmryData(PoolMvmtINVO poolMvmtINVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PoolMvmtCompareSmryMGTVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(poolMvmtINVO != null){
					Map<String, String> mapVO = poolMvmtINVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PoolChassisHistoryDBDAOsearchPoolMvmtCompareMatchingSmryDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoolMvmtCompareSmryMGTVO .class);
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
	 * Company (Pool 관리업체, Flexivan/Seacastle)별CGM_CHS_POOL 테이블에 POOL 별 관리 회사(Pool_mgmt_cmpny_cd) 정보 이용 [EES_CGM_1143] <br>
	 * 
	 * @param poolMvmtINVO PoolMvmtINVO 
	 * @return List<PoolMvmtCompareSmryMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<PoolExpenseTrendMGTVO> searchPoolMvmtExpenseListData(PoolMvmtINVO poolMvmtINVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PoolExpenseTrendMGTVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(poolMvmtINVO != null){
					Map<String, String> mapVO = poolMvmtINVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PoolChassisHistoryDBDAOsearchPoolMvmtExpenseListDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoolExpenseTrendMGTVO .class);
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
		 *  Pool 단위, Sort by 옵션에 따라 월 단위로 Invoice date, repair date 기준으로 조회 [EES_CGM_1144] <br>
		 * 
		 * @param poolMnrHistoryINVO PoolMnrHistoryINVO 
		 * @return List<PoolMnrHistoryMGTVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<PoolMnrHistoryMGTVO> searchPoolMnrHistorySummaryData(PoolMnrHistoryINVO poolMnrHistoryINVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PoolMnrHistoryMGTVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(poolMnrHistoryINVO != null){
					Map<String, String> mapVO = poolMnrHistoryINVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PoolChassisHistoryDBDAOsearchPoolMnrHistorySummaryDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoolMnrHistoryMGTVO .class);
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
	 *  Pool 단위, Sort by 옵션에 따라 월 단위로 Invoice date, repair date 기준으로 조회 [EES_CGM_1144] <br>
	 * 
	 * @param poolMnrHistoryINVO PoolMnrHistoryINVO 
	 * @return List<PoolMnrHistoryMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<PoolMnrHistoryMGTVO> searchPoolMnrHistoryData(PoolMnrHistoryINVO poolMnrHistoryINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PoolMnrHistoryMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(poolMnrHistoryINVO != null){
				Map<String, String> mapVO = poolMnrHistoryINVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PoolChassisHistoryDBDAOsearchPoolMnrHistoryDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoolMnrHistoryMGTVO .class);
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
	  * CGM_POOL_MVMT 테이블에서  동 EQ_NO, MVMT_DT 을 가진 ROW 를 찾아여부를 반환한다.
	  * 
	  * @param poolMvmtHistoryMGTVO PoolMvmtHistoryMGTVO
	  * @return PoolMvmtHistoryMGTVO
	  * @exception DAOException
	  */
	 public PoolMvmtHistoryMGTVO searchPoolMovementData(PoolMvmtHistoryMGTVO poolMvmtHistoryMGTVO) throws DAOException {
			DBRowSet dbRowset = null;
			PoolMvmtHistoryMGTVO list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(poolMvmtHistoryMGTVO != null){
					Map<String, String> mapVO = poolMvmtHistoryMGTVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PoolChassisHistoryDBDAOsearchPoolMovementDataRSQL(), param, velParam);
					if(dbRowset.next()){
						list = new PoolMvmtHistoryMGTVO();
						list.setChssNo(dbRowset.getString("chss_no"));
					}	
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
		 *  CCGM_POOL_MVMT 테이블에 EDI 데이터를 INSERT 처리한다 .<br>
		 * 
		 * @param poolMvmtHistoryMGTVO PoolMvmtHistoryMGTVO
		 * @exception DAOException
		 */
		public void addPoolMovementData(PoolMvmtHistoryMGTVO poolMvmtHistoryMGTVO) throws DAOException, Exception {

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = 0;
			try {
				Map<String, String> mapVO = poolMvmtHistoryMGTVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new PoolChassisHistoryDBDAOaddPoolMovementDataCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 *  CCGM_POOL_MVMT 테이블에 EDI 데이터를 Update 처리한다.<br>
		 * 
		 * @param poolMvmtHistoryMGTVO PoolMvmtHistoryMGTVO
		 * @exception DAOException
		 */
		public void modifyPoolMovementData(PoolMvmtHistoryMGTVO poolMvmtHistoryMGTVO) throws DAOException, Exception {

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = 0;
			try {
				Map<String, String> mapVO = poolMvmtHistoryMGTVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new PoolChassisHistoryDBDAOmodifyPoolMovementDataUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		 
	 /**
	  * CGM_POOL_MAINT_RPR_HIS 테이블에서  동 EQ_NO, sys_seq 을 가진 ROW 를 찾아여부를 반환한다.
	  * 
	  * @param poolMaintRprHisMGTVO PoolMaintRprHisMGTVO
	  * @return PoolMaintRprHisMGTVO
	  * @exception DAOException
	  */
	 public PoolMaintRprHisMGTVO searchPoolMovementImportData(PoolMaintRprHisMGTVO  poolMaintRprHisMGTVO) throws DAOException {
			DBRowSet dbRowset = null;
			PoolMaintRprHisMGTVO list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(poolMaintRprHisMGTVO != null){
					Map<String, String> mapVO = poolMaintRprHisMGTVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PoolChassisHistoryDBDAOsearchPoolMovementImportDataRSQL(), param, velParam);
					if(dbRowset.next()){
						list = new PoolMaintRprHisMGTVO();
						list.setChssNo(dbRowset.getString("chss_no"));
					}	
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
		 *  CGM_POOL_MAINT_RPR_HIS 테이블에 EDI 데이터를 INSERT 처리한다 .<br>
		 * 
		 * @param poolMaintRprHisMGTVO PoolMaintRprHisMGTVO
		 * @exception DAOException
		 */
		public void addPoolMnrInvoiceImportData(PoolMaintRprHisMGTVO  poolMaintRprHisMGTVO ) throws DAOException, Exception {

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = 0;
			try {
				Map<String, String> mapVO = poolMaintRprHisMGTVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new PoolChassisHistoryDBDAOaddPoolMnrInvoiceImportDataCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/**
		 *  CGM_POOL_MAINT_RPR_HIS 테이블에 EDI 데이터를 INSERT 처리한다 .<br>
		 * 
		 * @param poolMaintRprHisMGTVO PoolMaintRprHisMGTVO
		 * @exception DAOException
		 */
		public void addPoolMnrInvoiceImportSeacasData(PoolMaintRprHisMGTVO  poolMaintRprHisMGTVO ) throws DAOException, Exception {

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = 0;
			try {
				Map<String, String> mapVO = poolMaintRprHisMGTVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new PoolChassisHistoryDBDAOaddPoolMnrInvoiceImportSeacasDataCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 *  CGM_POOL_MAINT_RPR_HIS 테이블에 EDI 데이터를 update 처리한다 .<br>
		 * 
		 * @param poolMaintRprHisMGTVO PoolMaintRprHisMGTVO
		 * @exception DAOException
		 */
		public void modifyPoolMnrInvoiceImportData(PoolMaintRprHisMGTVO  poolMaintRprHisMGTVO) throws DAOException, Exception {

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = 0;
			try {
				Map<String, String> mapVO = poolMaintRprHisMGTVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new PoolChassisHistoryDBDAOmodifyPoolMnrInvoiceImportDataUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		
		/** Company (Pool 관리업체, Flexivan/Seacastle)별 CGM_CHS_POOL 테이블에 POOL 별 관리 회사(Pool_mgmt_cmpny_cd) 정보 이용
		 *  poolUseddysINVO 조회 [EES_CGM_1145] <br>
		 * 
		 * @param poolUseddysINVO PoolUseddysINVO 
		 * @return List<PoolUseddysMGTVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<PoolUseddysMGTVO> searchPoolChsUseddaysFileStatusData(PoolUseddysINVO poolUseddysINVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PoolUseddysMGTVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(poolUseddysINVO != null){
					Map<String, String> mapVO = poolUseddysINVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PoolChassisHistoryDBDAOsearchPoolChsUseddaysFileStatusDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoolUseddysMGTVO .class);
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
		 *  CGM_POOL_CHSS_IMP_FILE 데이터를 INSERT 처리한다 .<br>
		 * 
		 * @param poolUseddysMGTVOs List<PoolUseddysMGTVO> 
		 * @exception DAOException
		 */
		public void addPoolChsFileImportData(List<PoolUseddysMGTVO>  poolUseddysMGTVOs ) throws DAOException, Exception {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			PoolUseddysMGTVO chass = new PoolUseddysMGTVO();
			int result=0;
			SQLExecuter sqlExe = new SQLExecuter("");
			try {
				if (poolUseddysMGTVOs.size() > 0) {
					log.debug("addPoolChsFileImportData===========");
					for (int i = 0; i < poolUseddysMGTVOs.size(); i++) {
						chass = new PoolUseddysMGTVO();
						chass = poolUseddysMGTVOs.get(i);
				 
						Map<String, String> mapVO = chass.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);		
						result = sqlExe.executeUpdate((ISQLTemplate)new PoolChassisHistoryDBDAOaddPoolChsFileImportDataCSQL(), param, velParam);
						if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert SQL");
						
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 *  CGM_POOL_CHSS_IMP_FILE 데이터를 delete 처리한다 .<br>
		 * 
		 * @param poolUseddysMGTVOs List<PoolUseddysMGTVO> 
		 * @exception DAOException
		 */
		public void removePoolChsFileImportData(List<PoolUseddysMGTVO>  poolUseddysMGTVOs ) throws DAOException, Exception {

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			PoolUseddysMGTVO chass = new PoolUseddysMGTVO();
			int result=0;
			SQLExecuter sqlExe = new SQLExecuter("");
			try {
				if (poolUseddysMGTVOs.size() > 0) {
					log.debug("addPoolChsFileImportData===========");
					for (int i = 0; i < poolUseddysMGTVOs.size(); i++) {
						chass = new PoolUseddysMGTVO();
						chass = poolUseddysMGTVOs.get(i);
				 
						Map<String, String> mapVO = chass.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);		
						result = sqlExe.executeUpdate((ISQLTemplate)new PoolChassisHistoryDBDAOremovePoolChsFileImportDataDSQL(), param, velParam);
						if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert SQL");
						
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 *  CGM_POOL_CHSS_IMP_FILE 데이터를 delete 처리한다 .<br>
		 * 
		 * @param poolUseddysMGTVOs List<PoolUseddysMGTVO> 
		 * @exception DAOException
		 */
		public void removePoolChsPoolCoUseData(List<PoolUseddysMGTVO>  poolUseddysMGTVOs ) throws DAOException, Exception {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			PoolUseddysMGTVO chass = new PoolUseddysMGTVO();
			int result=0;
			SQLExecuter sqlExe = new SQLExecuter("");
			try {
				if (poolUseddysMGTVOs.size() > 0) {
					log.debug("addPoolChsFileImportData===========");
					for (int i = 0; i < poolUseddysMGTVOs.size(); i++) {
						chass = new PoolUseddysMGTVO();
						chass = poolUseddysMGTVOs.get(i);
				 
						Map<String, String> mapVO = chass.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);		
						result = sqlExe.executeUpdate((ISQLTemplate)new PoolChassisHistoryDBDAOremovePoolChsPoolCoUseDataDSQL(), param, velParam);
						if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert SQL");
						
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 *  CGM_POOL_CHSS_IMP_FILE 데이터를 delete 처리한다 .<br>
		 * 
		 * @param poolUseddysMGTVOs List<PoolUseddysMGTVO> 
		 * @exception DAOException
		 */
		public void removePoolChsUseImpErrData(List<PoolUseddysMGTVO>  poolUseddysMGTVOs ) throws DAOException, Exception {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			PoolUseddysMGTVO chass = new PoolUseddysMGTVO();
			int result=0;
			SQLExecuter sqlExe = new SQLExecuter("");
			try {
				if (poolUseddysMGTVOs.size() > 0) {
					log.debug("removePoolChsUseImpErrData===========");
					for (int i = 0; i < poolUseddysMGTVOs.size(); i++) {
						chass = new PoolUseddysMGTVO();
						chass = poolUseddysMGTVOs.get(i);
				 
						Map<String, String> mapVO = chass.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);		
						result = sqlExe.executeUpdate((ISQLTemplate)new PoolChassisHistoryDBDAOremovePoolChsUseImpErrDataDSQL(), param, velParam);
						if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert SQL");
						
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
	 	 *  CGM_POOL_CO_CHSS_USE_HIS 데이터가 있나 체크  .<br>
	 	 * 
	 	 * @param poolCoChssUseHisMGTVO PoolCoChssUseHisMGTVO 
	 	 * @return String 
	 	 * @exception SQLException
		 * @exception Exception
	 	 */
		public String searchPoolChsUseHisFlexiData(PoolCoChssUseHisMGTVO poolCoChssUseHisMGTVO) throws DAOException {
			DBRowSet dbRowset = null;
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
            String result = "";
			try {
				if (poolCoChssUseHisMGTVO != null) {
					Map<String, String> mapVO = poolCoChssUseHisMGTVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PoolChassisHistoryDBDAOsearchPoolChsUseHisFlexiDataRSQL(), param, velParam);
					if(dbRowset.next()){
						result = dbRowset.getString("cnt");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}
		
		/**
	 	 *  CGM_POOL_CO_CHSS_USE_HIS 데이터가 있나 체크  .<br>
	 	 * 
	 	 * @param poolCoChssUseHisMGTVO PoolCoChssUseHisMGTVO 
	 	 * @return String 
	 	 * @exception SQLException
		 * @exception Exception
	 	 */
		public String searchPoolChsUseHisSeacasData(PoolCoChssUseHisMGTVO poolCoChssUseHisMGTVO) throws DAOException {
			DBRowSet dbRowset = null;
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
            String result = "";
			try {
				if (poolCoChssUseHisMGTVO != null) {
					Map<String, String> mapVO = poolCoChssUseHisMGTVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PoolChassisHistoryDBDAOsearchPoolChsUseHisSeacasDataRSQL(), param, velParam);
					if(dbRowset.next()){
						result = dbRowset.getString("cnt");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}
		
        /**
         * CGM_POOL_CO_CHSS_USE_HIS  입력 
         * @param poolCoChssUseHisMGTVO PoolCoChssUseHisMGTVO
         * @return int 
         * @throws DAOException
         * @throws Exception
         */
		public int addPoolChsUseHisFlexiData(PoolCoChssUseHisMGTVO poolCoChssUseHisMGTVO) throws DAOException, Exception {

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = 0;
			try {
				Map<String, String> mapVO = poolCoChssUseHisMGTVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new PoolChassisHistoryDBDAOaddPoolChsUseHisFlexiDataCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}
		
		/**
         * CGM_POOL_CO_CHSS_USE_HIS  입력 
         * @param poolCoChssUseHisMGTVO PoolCoChssUseHisMGTVO
         * @return int 
         * @throws DAOException
         * @throws Exception
         */
		public int addPoolChsUseHisSeacasData(PoolCoChssUseHisMGTVO poolCoChssUseHisMGTVO) throws DAOException, Exception {

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = 0;
			try {
				Map<String, String> mapVO = poolCoChssUseHisMGTVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new PoolChassisHistoryDBDAOaddPoolChsUseHisSeacasDataCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}
		
		/**
         * CGM_POOL_CO_CHSS_USE_HIS  수정 
         * @param poolCoChssUseHisMGTVO PoolCoChssUseHisMGTVO
         * @return int 
         * @throws DAOException
         * @throws Exception
         */
		public int modifyPoolChsUseHisFlexiData(PoolCoChssUseHisMGTVO poolCoChssUseHisMGTVO) throws DAOException, Exception {

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = 0;
			try {
				Map<String, String> mapVO = poolCoChssUseHisMGTVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new PoolChassisHistoryDBDAOmodifyPoolChsUseHisFlexiDataUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}
		
		/**
         * CGM_POOL_CO_CHSS_USE_HIS  수정 
         * @param poolCoChssUseHisMGTVO PoolCoChssUseHisMGTVO
         * @return int 
         * @throws DAOException
         * @throws Exception
         */
		public int modifyPoolChsUseHisSeacasData(PoolCoChssUseHisMGTVO poolCoChssUseHisMGTVO) throws DAOException, Exception {

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = 0;
			try {
				Map<String, String> mapVO = poolCoChssUseHisMGTVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new PoolChassisHistoryDBDAOmodifyPoolChsUseHisSeacasDataUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}
		
		/** Company (Pool 관리업체, Flexivan/Seacastle)별 CGM_CHS_POOL 테이블에 POOL 별 관리 회사(Pool_mgmt_cmpny_cd) 정보 이용
		 *  poolUseddysINVO 조회 [EES_CGM_1149] <br>
		 * 
		 * @param poolUseddysMGTVO PoolUseddysMGTVO 
		 * @return List<PoolUseddysMGTVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<PoolUseddysMGTVO> searchPoolChsFileImportErrorListData(PoolUseddysMGTVO poolUseddysMGTVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PoolUseddysMGTVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(poolUseddysMGTVO != null){
					Map<String, String> mapVO = poolUseddysMGTVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PoolChassisHistoryDBDAOsearchPoolChsFileImportErrorListDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PoolUseddysMGTVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		
}