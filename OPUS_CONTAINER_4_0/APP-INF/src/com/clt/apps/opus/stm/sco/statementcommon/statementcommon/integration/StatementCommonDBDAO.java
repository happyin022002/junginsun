/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : StatementCommonDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.fin.financemanagement.financecreation.vo.GlEstmRevVvdVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBCImpl;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.APCostActivityInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.AccrualCodeInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.AccrualVerificationVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ApplicationComboVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.CenterListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.CompanyListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.InterCompanyListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LedgerCodeCombinationCondVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LedgerCodeCombinationListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupDetailVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupHeaderVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.MDMOfficeInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfcWrtfTpComboListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfficeComboListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfficeInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.PopAccountListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.RegionListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.RevenuePortEachLaneVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SakuraConversionComboVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SakuraInterfaceCondVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SakuraInterfaceListVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ScoBatHisVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ScoStmtCdConvVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SearchPeriodClosingInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SearchTrsTesAcclDataVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.TesManualCancellationVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.VVDListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * StatementCommonDBDAO <br>
 * - StatementCommon system Business Logic��泥섎━�섍린 �꾪븳 JDBC �묒뾽�섑뻾.<br>
 * 
 * @author 
 * @see StatementCommonBCImpl 李몄“
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class StatementCommonDBDAO extends DBDAOSupport {
	
		private String dataSource = "";
	
		public StatementCommonDBDAO(){}
		
		/** ReceiveQueueCRMDBDAO �앹꽦��br>
		 * DBDAO Object瑜��앹꽦
		 * @param String dataSource
		 */
		public StatementCommonDBDAO(String dataSource){
			this.dataSource = dataSource;
		}
	
		/**
		 * [COMMON Period Closing]
		 * @author yhha
		 * @param String effYrMon
		 * @param String prdApplCd 
		 * @return List<SearchPeriodClosingInfoVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchPeriodClosingInfoVO> searchPeriodClosingList(String effYrMon, String prdApplCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchPeriodClosingInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (effYrMon != null) {
					param.put("eff_yrmon", effYrMon);
					velParam.put("eff_yrmon", effYrMon);
				}
				if (prdApplCd != null) {
					param.put("prd_appl_cd", prdApplCd);
					velParam.put("prd_appl_cd", prdApplCd);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchPeriodClosingInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPeriodClosingInfoVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

		 /**
		 * [COMMON Insert Period Closing Info]
		 * @author yhha
		 * @param SearchPeriodClosingInfoVO searchPeriodClosingInfoVO
		 * @return int
		 * @exception DAOException
		 */	 
		public int insertPeriodClosingInfo(SearchPeriodClosingInfoVO searchPeriodClosingInfoVO) throws DAOException,Exception {
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try{
				if(searchPeriodClosingInfoVO != null){
					Map<String, String> mapVO = searchPeriodClosingInfoVO .getColumnValues();			
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}			
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StatementCommonDBDAOInsertPeriodClosingInfoCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");		
				}			
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
			return result;
		}	 
		
		 /**
		 * [COMMON Remove Period Closing Info]
		 * @author yhha
		 * @param SearchPeriodClosingInfoVO searchPeriodClosingInfoVO
		 * @return int
		 * @exception DAOException
		 */		
		public int removePeriodClosingInfo(SearchPeriodClosingInfoVO searchPeriodClosingInfoVO) throws DAOException,Exception {
		
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try{
				if(searchPeriodClosingInfoVO != null){
					Map<String, String> mapVO = searchPeriodClosingInfoVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}			
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StatementCommonDBDAORemovePeriodClosingInfoDSQL(), param, velParam);			
				if(result == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to delete SQL");		
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
			return result;
		}	
			
		/**
		* [COMMON Modify Period Closing Info]
		* @author yhha
		 * @param SearchPeriodClosingInfoVO searchPeriodClosingInfoVO
		 * @return int
		 * @exception DAOException
		*/	
		public int modifyPeriodClosingInfo(SearchPeriodClosingInfoVO searchPeriodClosingInfoVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try {
				Map<String, String> mapVO = searchPeriodClosingInfoVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StatementCommonDBDAOModifyPeriodClosingInfoUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}


		/**
		 * [COMMON Lookup Code]
		  * [lookup code]- 紐⑸줉��議고쉶<br>
		 *
		 * @param String lu_tp_cd
		 * @return List<LookupInfoVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<LookupInfoVO> searchLookupList(String lu_tp_cd) throws DAOException {
			DBRowSet dbRowset = null;
			List<LookupInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (lu_tp_cd != null) {
					param.put("lu_tp_cd", lu_tp_cd);
					velParam.put("lu_tp_cd", lu_tp_cd);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchLookupListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, LookupInfoVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}	 
	 
		/**
		 * [COMMON Lookup Code]
		 * [lookup code]- 肄ㅻ낫�먯꽌 �ъ슜 <br>
		 *
		 * @param LookupInfoVO lookupInfoVO
		 * @return List<LookupInfoVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<LookupInfoVO> searchLookupComboList(LookupInfoVO lookupInfoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<LookupInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (lookupInfoVO != null) {
					Map<String, String> mapVO = lookupInfoVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchLookupComboListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, LookupInfoVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}	 
		 
			/**
			 * [COMMON Lookup Code]
			 *
			 * @param LookupInfoVO lookupInfoVO
			 * @return List<LookupInfoVO>
			 * @exception DAOException
			 */
			 @SuppressWarnings("unchecked")
			public List<LookupInfoVO> searchLookupComboListWithChkStartEndDate(LookupInfoVO lookupInfoVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<LookupInfoVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if (lookupInfoVO != null) {
						Map<String, String> mapVO = lookupInfoVO.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchLookupComboListWithChkStartEndDateRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, LookupInfoVO.class);
				} catch(SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch(Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return list;
			}		 
		 
		/**
		 * [COMMON Lookup Code]
		 * [lookup code]- 肄ㅻ낫�먯꽌 �ъ슜 <br>
		 *
		 * @param LookupInfoVO lookupInfoVO
		 * @return List<LookupInfoVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<LookupInfoVO> searchEvidenceLookupComboList(LookupInfoVO lookupInfoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<LookupInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (lookupInfoVO != null) {
					Map<String, String> mapVO = lookupInfoVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchEvidenceLookupComboListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, LookupInfoVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}	
		 
		/**
		 * [COMMON Lookup Code]
		 * [lookup code]- 紐⑸줉��議고쉶<br>
		 * by HJPARK
		 * @param String lu_tp_cd
		 * @param String lu_appl_cd
		 * @return List<LookupHeaderVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<LookupHeaderVO> searchLookupHeader(String lu_tp_cd, String lu_appl_cd) throws DAOException {
			DBRowSet dbRowset = null;
			List<LookupHeaderVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (lu_tp_cd != null && !lu_tp_cd.equals("")) {
					param.put("lu_tp_cd", lu_tp_cd);
					velParam.put("lu_tp_cd", lu_tp_cd);
				} else if (lu_appl_cd != null && !lu_appl_cd.equals("")) {
					param.put("lu_appl_cd", lu_appl_cd);
					velParam.put("lu_appl_cd", lu_appl_cd);
				} else {
					if (lu_tp_cd != null){
						param.put("lu_tp_cd", lu_tp_cd);
						velParam.put("lu_tp_cd", lu_tp_cd); 
					}
					if(lu_appl_cd != null){
						param.put("lu_appl_cd", lu_appl_cd);
						velParam.put("lu_appl_cd", lu_appl_cd);
					}
				}
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchLookupHeaderRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, LookupHeaderVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		 
		 
		/**
		 * [COMMON Lookup Code]
		 * [lookup code]- 紐⑸줉��議고쉶<br>
		 * by HJPARK
		 * @param String h_lu_tp_cd
		 * @return List<LookupDetailVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<LookupDetailVO> searchLookupDetail(String h_lu_tp_cd) throws DAOException {
				DBRowSet dbRowset = null;
				List<LookupDetailVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if (h_lu_tp_cd != null) {
						param.put("lu_tp_cd", h_lu_tp_cd);
						velParam.put("lu_tp_cd", h_lu_tp_cd);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchLookupDetailRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, LookupDetailVO.class);
				} catch(SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch(Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return list;
		}
	 
	    /**
	     * [COMMON Lookup Code]
	     * [lookup code]- 紐⑸줉����옣<br>
		 * by HJPARK
		 * @param LookupHeaderVO lookupHeaderVO
		 * @return int
		 * @exception DAOException
		 */
		public int modifyLookupHeader(LookupHeaderVO lookupHeaderVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try {
				Map<String, String> mapVO = lookupHeaderVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StatementCommonDBDAOModifyLookupHeaderUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}
		
		
		 /**
		 * [COMMON Lookup Code]
		 * [lookup code]- 紐⑸줉��異붽�<br>
		 * 
		 * @param LookupHeaderVO lookupHeaderVO
		 * @return int
		 * @exception DAOException
		 */
		public int insertLookupHeader(LookupHeaderVO lookupHeaderVO) throws DAOException,Exception {
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try{
				if(lookupHeaderVO != null){
					Map<String, String> mapVO = lookupHeaderVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}			
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StatementCommonDBDAOInsertLookupHeaderCSQL(), param, velParam);			
				if(result == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");		
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
			return result;
		}
		
		
		 /**
		 * [COMMON Lookup Code]
		 * [lookup code]- 紐⑸줉��異붽�<br>
		 * 
		 * @param LookupHeaderVO lookupHeaderVO
		 * @return int
		 * @exception DAOException
		 */
		public int removeLookupHeader(LookupHeaderVO lookupHeaderVO) throws DAOException,Exception {

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try{
				if(lookupHeaderVO != null){
					Map<String, String> mapVO = lookupHeaderVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}			
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StatementCommonDBDAORemoveLookupHeaderDSQL(), param, velParam);			
				if(result == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to delete SQL");		
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
			return result;
		}
 

	    /**
	     * [COMMON Lookup Code]
	     * [lookup code]- 紐⑸줉����옣<br>
		 * by HJPARK
		 * @param LookupDetailVO lookupDetailVO
		 * @return int
		 * @exception DAOException
		 */
		public int modifyLookupDetail(LookupDetailVO lookupDetailVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try {
				Map<String, String> mapVO = lookupDetailVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StatementCommonDBDAOModifyLookupDetailUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}
			
		/**
		 * [COMMON Lookup Code]
		 * [lookup code]- 紐⑸줉��異붽�<br>
		 * 
		 * @param LookupDetailVO lookupDetailVO
		 * @return int
		 * @exception DAOException
		 */
		public int insertLookupDetail(LookupDetailVO lookupDetailVO) throws DAOException,Exception {
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try{
				if(lookupDetailVO != null){
					Map<String, String> mapVO = lookupDetailVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}			
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StatementCommonDBDAOInsertLookupDetailCSQL(), param, velParam);			
				if(result == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");		
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
			return result;
		}
			
		 /**
		 * [COMMON Lookup Code]
		 * [lookup code]- 紐⑸줉��異붽�<br>
		 * 
		 * @param LookupDetailVO lookupDetailVO
		 * @return int
		 * @exception DAOException
		 */
		public int removeLookupDetail(LookupDetailVO lookupDetailVO) throws DAOException,Exception {

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try{
				if(lookupDetailVO != null){
					Map<String, String> mapVO = lookupDetailVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}			
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StatementCommonDBDAORemoveLookupDetailDSQL(), param, velParam);			
				if(result == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to delete SQL");		
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
			return result;
		}
	 		
		 /**
		 * [COMMON Lookup Code]
		 * [lookup code]- when deleting header, delete all detail<br>
		 * 
		 * @param String lu_tp_cd
		 * @return int
		 * @exception DAOException
		 */
		public int removeLookupDetailAll(String lu_tp_cd) throws DAOException,Exception {

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>(); 
			int result = 0;
			try{
				if(lu_tp_cd != null){
					param.put("lu_tp_cd", lu_tp_cd);
					velParam.put("lu_tp_cd", lu_tp_cd);
				}			
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StatementCommonDBDAORemoveLookupDetailAllDSQL(), param, velParam);			
				if(result == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to delete SQL");		
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
			return result;
		}
		
		/**
	     * Account Popup<br>
	     * 
	     * @author Kyungsam Jo 2015.03.17
	     * @category STM_SCO_0090
	     * @category searchPopAccountCommonList
	     * @param String accountCode
	     * @param String accountType
	     * @param String unsettledFlag
	     * @param String lineType
	     * @param String acctNm
	     * @return
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")
	           
	    public List<PopAccountListVO> searchPopAccountCommonList(String accountCode, String accountType, String unsettledFlag, String lineType, String acctNm) throws DAOException { 
	        DBRowSet dbRowset = null;
	        
	        List<PopAccountListVO> list = null;
	        
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {	

	             param.put("acct_cd", accountCode);
	             param.put("acctg_mng_tp_cd", accountType);
	             param.put("pnd_tgt_flg", unsettledFlag);
	             param.put("line_type", lineType);
	             param.put("acct_eng_nm", acctNm);

	             velParam.put("acct_cd", accountCode);
	             velParam.put("acctg_mng_tp_cd", accountType);
	             velParam.put("pnd_tgt_flg", unsettledFlag);
	             velParam.put("line_type", lineType);
	             velParam.put("acct_eng_nm", acctNm);
	   
	             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchPopAccountCommonListRSQL(), param, velParam);
	             list = (List)RowSetUtil.rowSetToVOs(dbRowset, PopAccountListVO.class);             
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
		 * Search Application Combo List<br>
		 * 
		 * @return List<ApplicationComboVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<ApplicationComboVO> searchApplicationCombo() throws DAOException {
			DBRowSet dbRowset = null;
			List<ApplicationComboVO> list = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = new HashMap<String, String>();
				//mapVO.put("appl_cd", applCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchApplicationComboRSQL(), param, velParam);											
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApplicationComboVO .class);
			
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}	
		
		/**
		 * Search Office Combo List<br>
		 * 
		 * @return List<OfficeComboListVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<OfficeComboListVO> searchOfficeComboList() throws DAOException {
			DBRowSet dbRowset = null;
			List<OfficeComboListVO> list = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = new HashMap<String, String>();
				//mapVO.put("appl_cd", applCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchOfficeComboListRSQL(), param, velParam);											
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeComboListVO .class);
			
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}	
		
		/**
		 * [COMMON Office Information]
		 * [STM Office Information]- 紐⑸줉��議고쉶<br>
		 * by HJPARK
		 * @param String mdm_ofc_cd
		 * @return List<OfficeInfoVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<OfficeInfoVO> searchOfficeInfo(String mdm_ofc_cd) throws DAOException {
			DBRowSet dbRowset = null;
			List<OfficeInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (mdm_ofc_cd != null) {
					param.put("mdm_ofc_cd", mdm_ofc_cd);
					velParam.put("mdm_ofc_cd", mdm_ofc_cd);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchOfficeInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeInfoVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		 
			
	    /**
	     * [COMMON Office Information]
	     * [STM Office Information]- 紐⑸줉����옣<br>
		 * by HJPARK
		 * @param OfficeInfoVO officeInfoVO
		 * @return int
		 * @exception DAOException, Exception
		 */
		public int modifyOfficeInfo(OfficeInfoVO officeInfoVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try {
				Map<String, String> mapVO = officeInfoVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StatementCommonDBDAOModifyOfficeInfoUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}
		
	    /**
	     * [COMMON Office Information]
	     * [STM Office Information]- 紐⑸줉����옣<br>
		 * by HJPARK
		 * @param OfficeInfoVO officeInfoVO
		 * @return int
		 * @exception DAOException,Exception
		 */
		public int insertOfficeInfo(OfficeInfoVO officeInfoVO) throws DAOException,Exception {
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try{
				if(officeInfoVO != null){
					Map<String, String> mapVO = officeInfoVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}			
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StatementCommonDBDAOInsertOfficeInfoCSQL(), param, velParam);			
				if(result == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");		
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
			return result;
		}
		
		/**
	     * Company Popup<br>
	     * 
	     * @author MCJung 2014.04.03
	     * @category STM_SCO_0051
	     * @category searchPopCompanyList
	     * @param String companyCode  
	     * @return List<CompanyListVO>
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<CompanyListVO> searchPopCompanyList(String companyCode) throws DAOException { 
	        DBRowSet dbRowset = null;
	        
	        List<CompanyListVO> list = null;
	        
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {	
	        	
	             param.put("lu_cd", companyCode);
	             velParam.put("lu_cd", companyCode);

	             
	             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOsearchPopCompanyListRSQL(), param, velParam);
	             list = (List)RowSetUtil.rowSetToVOs(dbRowset, CompanyListVO.class);             
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
	     * Region Popup - Retrieve <br>	
	     * 	
	     * @author CYJ	
	     * @category STM_SCO_0052	
	     * @category SearchPopRegionList	
	     * @param String luCd  	 	
	     * @return List<RegionListVO>	
	     * @throws DAOException	
	     */    	
	    @SuppressWarnings("unchecked")	
	    public List<RegionListVO> searchPopRegionList(String luCd) throws DAOException {	
	        DBRowSet dbRowset = null;	
	        	
	        List<RegionListVO> list = null;	
	        	
	        //query parameter	
	        Map<String, Object> param = new HashMap<String, Object>();	
	        	
	        //velocity parameter	
	        Map<String, Object> velParam = new HashMap<String, Object>();	
		
	        try {	
	        	
	             param.put("lu_cd", luCd);	
	         	
	         	 velParam.put("lu_cd", luCd);
	             
	             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOsearchPopRegionListRSQL(), param, velParam);	
	             list = (List)RowSetUtil.rowSetToVOs(dbRowset, RegionListVO.class);             	
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
		* Retrieve Center Popup
		* CENTER LIST 議고쉶<br>
		* @author JKKIL
		* @param CenterListVO centerListVO
		* @return List<CenterListVO>
		* @throws DAOException
		*/
		@SuppressWarnings("unchecked")
		public List<CenterListVO> searchPopCenterList(CenterListVO centerListVO) throws DAOException {
			DBRowSet dbRowset = null;
			
			List<CenterListVO> list = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {	
					if (centerListVO != null) {
						Map<String, String> mapVO = centerListVO.getColumnValues();
			
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
			       dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOsearchPopCenterListRSQL(), param, velParam);
			    list = (List)RowSetUtil.rowSetToVOs(dbRowset, CenterListVO.class);             
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
	     * Account Popup<br>
	     * 
	     * @author MCJung 2014.04.01
	     * @category STM_SCO_0054
	     * @category searchPopAccountList
	     * @param String accountCode 
	     * @param String accountType 
	     * @param String unsettledFlag 
	     * @return List<PopAccountListVO>
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")
	           
	    public List<PopAccountListVO> searchPopAccountList(String accountCode, String accountType, String unsettledFlag) throws DAOException { 
	        DBRowSet dbRowset = null;
	        
	        List<PopAccountListVO> list = null;
	        
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {	
	
	             param.put("acct_cd", accountCode);
	             param.put("acctg_mng_tp_cd", accountType);
	             param.put("pnd_tgt_flg", unsettledFlag);

	             velParam.put("acct_cd", accountCode);
	             velParam.put("acctg_mng_tp_cd", accountType);
	             velParam.put("pnd_tgt_flg", unsettledFlag);
	   
	             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOsearchPopAccountListRSQL(), param, velParam);
	             list = (List)RowSetUtil.rowSetToVOs(dbRowset, PopAccountListVO.class);             
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
		* Inter Company Popup
		* Inter Company LIST 議고쉶<br>
		* @author JKKIL
		* @param InterCompanyListVO interCompanyListVO
		* @return List<InterCompanyListVO>
		* @throws DAOException
		*/
		@SuppressWarnings("unchecked")
		public List<InterCompanyListVO> searchPopInterCompanyList(InterCompanyListVO interCompanyListVO) throws DAOException {
			DBRowSet dbRowset = null;
			
			List<InterCompanyListVO> list = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {	
					if (interCompanyListVO != null) {
						Map<String, String> mapVO = interCompanyListVO.getColumnValues();
			
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
			       dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOsearchPopInterCompanyListRSQL(), param, velParam);
			    list = (List)RowSetUtil.rowSetToVOs(dbRowset, InterCompanyListVO.class);             
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
	     * 議곌굔��湲곗��쇰줈 �щТ ��감���깅줉��VVD �뺣낫 議고쉶<br>
	     * 
	     * @author JISONG
	     * @category STM_SCO_0056
	     * @category searchPopVVDList
	     * @param String vvd_cd      
	     * @return List<VVDListVO>
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<VVDListVO> searchPopVVDList(String vvd_cd) throws DAOException {
	        DBRowSet dbRowset = null;
	        
	        List<VVDListVO> list = null;
	        
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {	
    			param.put("vvd_cd", vvd_cd);
    			velParam.put("vvd_cd", vvd_cd);
	             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOsearchPopVVDListRSQL(), param, velParam);
	             list = (List)RowSetUtil.rowSetToVOs(dbRowset, VVDListVO.class);             
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
		 * [Ledger Code Combination]
		 * [Ledger Code Combination]- 紐⑸줉��議고쉶<br>
		 * by HJPARK
		 * @param LedgerCodeCombinationCondVO ledgerCodeCombinationCondVO
		 * @return List<LedgerCodeCombinationListVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<LedgerCodeCombinationListVO> searchLedgerCodeCombination(LedgerCodeCombinationCondVO ledgerCodeCombinationCondVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<LedgerCodeCombinationListVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
			     	 if(ledgerCodeCombinationCondVO != null){  
			     		 Map<String, String> mapVO = ledgerCodeCombinationCondVO.getColumnValues();
			     	 
			     		 param.putAll(mapVO);        	
			     		 velParam.putAll(mapVO);
			 		 }
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchLedgerCodeCombinationListRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, LedgerCodeCombinationListVO.class);
				} catch(SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch(Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return list;
		}
		 
		/**
		 * get MDM Office Info 
		 * @author jinyoonoh 2014. 5. 30.
		 * @param String ofcCd
		 * @return MDMOfficeInfoVO
		 * @throws DAOException
		 */
		public MDMOfficeInfoVO searchMDMOfficeInfo(String ofcCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<MDMOfficeInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				param.put("ofc_cd", ofcCd);
				velParam.putAll(param);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchMDMOfficeInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MDMOfficeInfoVO.class);				
				if (list != null && !list.isEmpty()) {
					return list.get(0);
				}
				
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return null;
		}
		
		/**
		 * [STM_SCO_0050]
		 * searchLedgerCodeCombinationDupCheck <br>
		 * 
		 * @author ORKIM
		 * @category STM_SCO_0050
		 * @category searchLedgerCodeCombinationDupCheck
		 * @param LedgerCodeCombinationListVO ledgerCodeCombinationListVO
		 * @return String
		 * @throws DAOException
		*/
		 
		public String searchLedgerCodeCombinationDupCheck(LedgerCodeCombinationListVO ledgerCodeCombinationListVO) throws DAOException {
			DBRowSet dbRowset = null;
			String rtnValue = "";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				
				if(ledgerCodeCombinationListVO != null){  
		     		 Map<String, String> mapVO = ledgerCodeCombinationListVO.getColumnValues();
		     	 
		     		 param.putAll(mapVO);        	
		     		 velParam.putAll(mapVO);
		 		}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchLedgerCodeCombinationDupCheckRSQL(), param, velParam);
				if(dbRowset.next()) {
					rtnValue = dbRowset.getString("CNT");
				}     
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtnValue;
		}		
		
		/**
		 * [STM_SCO_0050]
		 * searchLedgerCodeCombinationDupCheck <br>
		 * 
		 * @author ORKIM
		 * @category STM_SCO_0050
		 * @category searchLedgerCodeCombinationNextKey
		 * @return String
		 * @throws DAOException
		*/
		 
		public String searchLedgerCodeCombinationNextKey() throws DAOException {
			DBRowSet dbRowset = null;
			String rtnValue = "";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchLedgerCodeCombinationNextKeyRSQL(), param, velParam);
				if(dbRowset.next()) {
					rtnValue = dbRowset.getString("CD_CMB_SEQ");
				}     
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtnValue;
		}	
		
		/**
		 * [STM_SCO_0050]
		 * 鍮꾩슜 �꾪몴 Line �앹꽦�섎뒗��Input �먮즺濡�SAP_INV_DTL �뚯씠釉붿쓣 �앹꽦<br>
		 * 
		 * @author ORKIM
		 * @category STM_SCO_0050
		 * @category addLedgerCodeCombination
		 * @param List<LedgerCodeCombinationListVO> ledgerCodeCombinationListVOs
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public void addLedgerCodeCombination(List<LedgerCodeCombinationListVO> ledgerCodeCombinationListVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (ledgerCodeCombinationListVOs.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate)new StatementCommonDBDAOAddLedgerCodeCombinationCSQL(), ledgerCodeCombinationListVOs, null);
					for (int i=0; i<insCnt.length; i++) {
						if (insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}	
		 
		 
		/**
		 * [STM_SCO_0050]
		 * SAP_INV_DTL update <br>
		 * 
		 * @author ORKIM
		 * @category STM_SCO_0050
		 * @category modifyLedgerCodeCombination
		 * @param List<LedgerCodeCombinationListVO> ledgerCodeCombinationListVOs
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public void modifyLedgerCodeCombination(List<LedgerCodeCombinationListVO> ledgerCodeCombinationListVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (ledgerCodeCombinationListVOs.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate)new StatementCommonDBDAOModifyLedgerCodeCombinationUSQL(), ledgerCodeCombinationListVOs, null);
					for (int i=0; i<insCnt.length; i++) {
						if (insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}	 
		 
		/**
		 * [STM_SCO_0050]
		 * 鍮꾩슜 �꾪몴 Header���앹꽦�섎뒗��Input �먮즺濡�SAP_INV_DTL �뚯씠釉붿쓣 ��젣 <br>
		 * 
		 * @author ORKIM
		 * @category STM_SCO_0050
		 * @category removeLedgerCodeCombination
		 * @param List<LedgerCodeCombinationListVO> ledgerCodeCombinationListVOs
		 * @throws DAOException
		 */
		public void removeLedgerCodeCombination(List<LedgerCodeCombinationListVO> ledgerCodeCombinationListVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int delCnt[] = null;
				if (ledgerCodeCombinationListVOs.size() > 0) {
					delCnt = sqlExe.executeBatch((ISQLTemplate)new StatementCommonDBDAORemoveLedgerCodeCombinationDSQL(), ledgerCodeCombinationListVOs, null);
					for (int i=0; i<delCnt.length; i++) {
						if (delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
	     * Company Check<br>
	     * 
	     * @author ORKIM
	     * @category common
	     * @category searchCompanyCheck
	     * @param String companyCode  
	     * @return String
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public String searchCompanyCheck(String companyCode) throws DAOException { 
	        DBRowSet dbRowset = null;
	        
	        String rtnValue = null;
	        
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {	
	        	
	             param.put("lu_cd", companyCode);
	             velParam.put("lu_cd", companyCode);

	             
	             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOsearchPopCompanyListRSQL(), param, velParam);
	             if(dbRowset.next()) {
						rtnValue = dbRowset.getString("LU_CD");
				 }         
	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        
	        return rtnValue;
	    } 
	    
		/**
	     * Region Check<br>
	     * 
	     * @author ORKIM
	     * @category common
	     * @category searchRegionCheck
	     * @param String luCd  
	     * @return String
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")	
	    public String searchRegionCheck(String luCd) throws DAOException {	
	        DBRowSet dbRowset = null;	
	        	
	        String rtnValue = null;
	        	
	        //query parameter	
	        Map<String, Object> param = new HashMap<String, Object>();	
	        	
	        //velocity parameter	
	        Map<String, Object> velParam = new HashMap<String, Object>();	
		
	        try {	
	        	
	             param.put("lu_cd", luCd);	
	         	
	         	 velParam.put("lu_cd", luCd);
	             
	             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOsearchPopRegionListRSQL(), param, velParam);	
	             if(dbRowset.next()) {
						rtnValue = dbRowset.getString("lU_CD");
				 }       	
	        }catch(SQLException se){	
	            log.error(se.getMessage(),se);	
	            throw new DAOException(new ErrorHandler(se).getMessage());	
	        }catch(Exception ex){	
	            log.error(ex.getMessage(),ex);	
	            throw new DAOException(new ErrorHandler(ex).getMessage());	
	        }	
	        	
	        return rtnValue;
	    }
	    
		/**
	     * Center Check<br>
	     * 
	     * @author ORKIM
	     * @category common
	     * @category searchCenterCheck
	     * @param String center  
	     * @return String
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")	
		public String searchCenterCheck(String center) throws DAOException {
			DBRowSet dbRowset = null;
			
			String rtnValue = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {
				
				param.put("f_center", center);	
	         	velParam.put("f_center", center);
			    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOsearchPopCenterListRSQL(), param, velParam);
			    if(dbRowset.next()) {
			    	rtnValue = dbRowset.getString("CTR_ERP_NO");
				}     
			}catch(SQLException se){
			   log.error(se.getMessage(),se);
			   throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
			   log.error(ex.getMessage(),ex);
			   throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			
			return rtnValue;
		} 
		
		/**
	     * Account Check<br>
	     * 
	     * @author ORKIM
	     * @category common
	     * @category searchAccountCheck
	     * @param String accountCode  
	     * @return String
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")	
	    public String searchAccountCheck(String accountCode) throws DAOException { 
	        DBRowSet dbRowset = null;
	        
	        String rtnValue = null;
	        
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {	
	
				param.put("acct_cd", accountCode);
				velParam.put("acct_cd", accountCode);
				   
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOsearchPopAccountListRSQL(), param, velParam);
				if(dbRowset.next()) {
					rtnValue = dbRowset.getString("ACCT_CD");
				}             
	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        
	        return rtnValue;
	    }
	    
		/**
	     * Inter Company Check<br>
	     * 
	     * @author ORKIM
	     * @category common
	     * @category searchInterCompanyCheck
	     * @param String interCompany  
	     * @return String
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")	
		public String searchInterCompanyCheck(String interCompany) throws DAOException {
			DBRowSet dbRowset = null;
			
			String rtnValue = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {	
				param.put("f_intercom", interCompany);
				velParam.put("f_intercom", interCompany);
				   
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOsearchPopInterCompanyListRSQL(), param, velParam);
				if(dbRowset.next()) {
					rtnValue = dbRowset.getString("lU_CD");
				}  			    
			}catch(SQLException se){
			   log.error(se.getMessage(),se);
			   throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
			   log.error(ex.getMessage(),ex);
			   throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			
			return rtnValue;
		}
		
		/**
	     * VVD Check<br>
	     * 
	     * @author ORKIM
	     * @category common
	     * @category searchVVDCheck
	     * @param String vvd_cd  
	     * @return String
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")	
	    public String searchVVDCheck(String vvd_cd) throws DAOException {
	        DBRowSet dbRowset = null;

	        String rtnValue = null;
	        
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {	
				param.put("vvd_cd", vvd_cd);
				velParam.put("vvd_cd", vvd_cd);
				   
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOsearchPopVVDListRSQL(), param, velParam);
				if(dbRowset.next()) {
					rtnValue = dbRowset.getString("VVD_CD");
				}	             
	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        
	        return rtnValue;
	    }   
	    
	    /**
		 * Search Bank Office Combo List<br>
		 * 
		 * @param String mdm_ofc_cd
		 * @param String ofcEntrLvlCd
		 * @return List<OfficeComboListVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<OfficeComboListVO> searchBankOfficeComboList(String mdm_ofc_cd, String ofcEntrLvlCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<OfficeComboListVO> list = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (mdm_ofc_cd != null) {
					param.put("mdm_ofc_cd", mdm_ofc_cd);
					param.put("ofc_entr_lvl_cd", ofcEntrLvlCd);
					velParam.put("mdm_ofc_cd", mdm_ofc_cd);
					velParam.put("ofc_entr_lvl_cd", ofcEntrLvlCd);
				}
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchBankOfficeComboListRSQL(), param, velParam);											
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeComboListVO .class);
			
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}	
		
	    /**
		 * Search Office Write-off Type Combo List<br>
		 * 
		 * @return List<OfcWrtfTpComboListVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<OfcWrtfTpComboListVO> searchOfcWrtfTpComboList() throws DAOException {
			DBRowSet dbRowset = null;
			List<OfcWrtfTpComboListVO> list = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchOfcWrtfTpComboListRSQL(), param, velParam);											
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfcWrtfTpComboListVO .class);
			
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}
		
		   
	    /**
	     * [STM_SCO_0200]<br>
	     * 
	     * @author ORKIM
	     * @category searchAPCostActivityInfoList
	     * @param String src_mdl_cd
	     * @param String act_cost_cd
	     * @param String del_flg
	     * @return List<APCostActivityInfoVO>
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<APCostActivityInfoVO> searchAPCostActivityInfoList(String src_mdl_cd, String act_cost_cd, String del_flg) throws DAOException {
	        DBRowSet dbRowset = null;
	        
	        List<APCostActivityInfoVO> list = null;
	        
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try {	
				param.put("src_mdl_cd", src_mdl_cd);
				velParam.put("src_mdl_cd", src_mdl_cd);
				
				param.put("act_cost_cd", act_cost_cd);
				velParam.put("act_cost_cd", act_cost_cd);
				
				param.put("del_flg", del_flg);
				velParam.put("del_flg", del_flg);
				
	             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchAPCostActivityInfoListRSQL(), param, velParam);
	             list = (List)RowSetUtil.rowSetToVOs(dbRowset, APCostActivityInfoVO.class);             
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
		 * [STM_SCO_0200]
		 * 
		 * @author ORKIM
		 * @category addAPCostActivityInfo
		 * @param List<APCostActivityInfoVO> aPCostActivityInfoVOs
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public void addAPCostActivityInfo(List<APCostActivityInfoVO> aPCostActivityInfoVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (aPCostActivityInfoVOs.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate)new StatementCommonDBDAOAddAPCostActivityInfoCSQL(), aPCostActivityInfoVOs, null);
					for (int i=0; i<insCnt.length; i++) {
						if (insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}	   
	    
		/**
		 * [STM_SCO_0200]
		 * 
		 * @author ORKIM
		 * @category modifyAPCostActivityInfo
		 * @param List<APCostActivityInfoVO> aPCostActivityInfoVOs
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public void modifyAPCostActivityInfo(List<APCostActivityInfoVO> aPCostActivityInfoVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int modCnt[] = null;
				if (aPCostActivityInfoVOs.size() > 0) {
					modCnt = sqlExe.executeBatch((ISQLTemplate)new StatementCommonDBDAOModifyAPCostActivityInfoUSQL(), aPCostActivityInfoVOs, null);
					for (int i=0; i<modCnt.length; i++) {
						if (modCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}			
		
		/**
		 * SAKURA Code Conversion ComboBox List<br> 
		 * @author JBLEE
		 * @return List<SakuraConversionComboVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SakuraConversionComboVO> searchSakuraConversionCombo() throws DAOException {
			DBRowSet dbRowset = null;
			List<SakuraConversionComboVO> list = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = new HashMap<String, String>();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchSakuraConversionComboRSQL(), param, velParam);											
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SakuraConversionComboVO .class);
			
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}
		
		/**
		 * SAKURA Code Conversion Info<br> 
		 * @author JBLEE
		 * @param String luTpCd
		 * @param String enblFlg
		 * @return List<ScoStmtCdConvVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<ScoStmtCdConvVO> searchSakuraConversionInfo(String luTpCd, String enblFlg) throws DAOException {
			DBRowSet dbRowset = null;
			List<ScoStmtCdConvVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				param.put("lu_tp_cd", luTpCd);
				param.put("enbl_flg", enblFlg);
				velParam.put("lu_tp_cd", luTpCd);
				velParam.put("enbl_flg", enblFlg);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchSakuraConversionInfoRSQL(), param, velParam);											
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScoStmtCdConvVO .class);
			
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return list;
		}	
		
		/**
		 * SAKURA Code Conversion<br> 
		 * @author JBLEE
		 * @param List<ScoStmtCdConvVO> scoStmtCdConvVOs
		 * @exception DAOException
		*/
		@SuppressWarnings("unchecked")
		public void addSakuraConversionInfo(List<ScoStmtCdConvVO> scoStmtCdConvVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (scoStmtCdConvVOs.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate)new StatementCommonDBDAOAddSakuraConversionInfoCSQL(), scoStmtCdConvVOs, null);
					for (int i=0; i<insCnt.length; i++) {
						if (insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 * SAKURA Code Conversion<br> 
		 * @author JBLEE
		 * @param List<ScoStmtCdConvVO> scoStmtCdConvVOs
		 * @exception DAOException
		*/
		@SuppressWarnings("unchecked")
		public void modifySakuraConversionInfo(List<ScoStmtCdConvVO> scoStmtCdConvVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (scoStmtCdConvVOs.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate)new StatementCommonDBDAOModifySakuraConversionInfoUSQL(), scoStmtCdConvVOs, null);
					for (int i=0; i<insCnt.length; i++) {
						if (insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 * SAKURA Code Conversion<br> 
		 * @author JBLEE
		 * @param List<ScoStmtCdConvVO> scoStmtCdConvVOs
		 * @exception DAOException
		*/
		@SuppressWarnings("unchecked")
		public void removeSakuraConversionInfo(List<ScoStmtCdConvVO> scoStmtCdConvVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (scoStmtCdConvVOs.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate)new StatementCommonDBDAORemoveSakuraConversionInfoDSQL(), scoStmtCdConvVOs, null);
					for (int i=0; i<insCnt.length; i++) {
						if (insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}

		/**
		 * [COMMON Lookup Code]
		 * [lookup code]- �꾠끇�ワ옙癒�퐣 占싼딆뒠 <br>
		 *
		 * @param LookupInfoVO lookupInfoVO
		 * @return List<LookupInfoVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<LookupInfoVO> searchAcctCtnt2LookupComboList(LookupInfoVO lookupInfoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<LookupInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (lookupInfoVO != null) {
					Map<String, String> mapVO = lookupInfoVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchAcctCtnt2LookupComboListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, LookupInfoVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		 }	 
		 
		 /**
		 * [COMMON Lookup Code]
		 * [lookup code]- �꾠끇�ワ옙癒�퐣 占싼딆뒠 <br>
		 *
		 * @param LookupInfoVO lookupInfoVO
		 * @return List<LookupInfoVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<LookupInfoVO> searchAcctCtnt3LookupComboList(LookupInfoVO lookupInfoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<LookupInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (lookupInfoVO != null) {
					Map<String, String> mapVO = lookupInfoVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchAcctCtnt3LookupComboListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, LookupInfoVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		 }	
		 
		 /**
		 * [COMMON Lookup Code]
		 * [lookup code]- �꾠끇�ワ옙癒�퐣 占싼딆뒠 <br>
		 *
		 * @param LookupInfoVO lookupInfoVO
		 * @return List<LookupInfoVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<LookupInfoVO> searchAcctCtnt4LookupComboList(LookupInfoVO lookupInfoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<LookupInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (lookupInfoVO != null) {
					Map<String, String> mapVO = lookupInfoVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchAcctCtnt4LookupComboListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, LookupInfoVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		 }
		 
	 /**
	 * [Search Revenue Port Each Lane List]
	 *
	 * @param String slanCd
	 * @param String rLaneCd
	 * @return List<RevenuePortEachLaneVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<RevenuePortEachLaneVO> searchRevenuePortEachLaneList(String slanCd, String rLaneCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<RevenuePortEachLaneVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 param.put("vsl_slan_cd", slanCd);
			 param.put("rlane_cd", rLaneCd);
			 velParam.putAll(param);
			
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAORevenuePortEachLaneRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenuePortEachLaneVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(), se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(), ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
		 * [Search Revenue Port Each Lane]
		 *
		 * @param RevenuePortEachLaneVO revenuePortEachLaneVO
		 * @return List<RevenuePortEachLaneVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<RevenuePortEachLaneVO> chkRevenuePortEachLaneInfo(RevenuePortEachLaneVO revenuePortEachLaneVO) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<RevenuePortEachLaneVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();

			 try{
				 Map<String, String> mapVO = revenuePortEachLaneVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(param);
				
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOChkRevenuePortEachLaneRSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenuePortEachLaneVO.class);
			 } catch(SQLException se) {
				 log.error(se.getMessage(), se);
				 throw new DAOException(new ErrorHandler(se).getMessage());
			 } catch(Exception ex) {
				 log.error(ex.getMessage(), ex);
				 throw new DAOException(new ErrorHandler(ex).getMessage());
			 }
			 return list;
		 }
	 
	 
	 /**
	 * [Insert Revenue Port Each Lane]
	 *
	 * @param List<RevenuePortEachLaneVO> revenuePortEachLaneVOs
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	 public void addRevenuePortEachLaneList(List<RevenuePortEachLaneVO> revenuePortEachLaneVOs) throws DAOException {
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 int insCnt[] = null;
			 if (revenuePortEachLaneVOs.size() > 0) {
				 insCnt = sqlExe.executeBatch((ISQLTemplate)new StatementCommonDBDAORevenuePortEachLaneCSQL(), revenuePortEachLaneVOs, null);
				 for (int i=0; i<insCnt.length; i++) {
					 if (insCnt[i]== Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to insert No"+ i + " SQL");
				 }
			 }
		 } catch (SQLException se) {
			 log.error(se.getMessage(), se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(), ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	
	/**
	 * [Update Revenue Port Each Lane]
	 *
	 * @param List<RevenuePortEachLaneVO> revenuePortEachLaneVOs
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	 public void modifyRevenuePortEachLaneList(List<RevenuePortEachLaneVO> revenuePortEachLaneVOs) throws DAOException {
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 int insCnt[] = null;
			 if (revenuePortEachLaneVOs.size() > 0) {
				 insCnt = sqlExe.executeBatch((ISQLTemplate)new StatementCommonDBDAORevenuePortEachLaneUSQL(), revenuePortEachLaneVOs, null);
				 for (int i=0; i<insCnt.length; i++) {
					 if (insCnt[i]== Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to insert No"+ i + " SQL");
				 }
			 }
		 } catch (SQLException se) {
			 log.error(se.getMessage(), se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(), ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	
	/**
	 * [Update Revenue Port Each Lane]
	 *
	 * @param List<RevenuePortEachLaneVO> revenuePortEachLaneVOs
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void deleteRevenuePortEachLaneList(List<RevenuePortEachLaneVO> revenuePortEachLaneVOs) throws DAOException {
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 int insCnt[] = null;
			 if (revenuePortEachLaneVOs.size() > 0) {
				 insCnt = sqlExe.executeBatch((ISQLTemplate)new StatementCommonDBDAORevenuePortEachLaneDSQL(), revenuePortEachLaneVOs, null);
				 for (int i=0; i<insCnt.length; i++) {
					 if (insCnt[i]== Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to insert No"+ i + " SQL");
				 }
			 }
		 } catch (SQLException se) {
			 log.error(se.getMessage(), se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(), ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	
	/**
	 * [Search Revenue Port Each Lane]
	 *
	 * @param String revPortCd
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public String searchRevenuePort(String revPortCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String result = "";
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			//query parameter
			 param.put("rev_port_cd", revPortCd);
			 velParam.put("rev_port_cd", revPortCd);
			
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAORevenuePortRSQL(), param, velParam);
			 if(dbRowset.next()){
				 result = dbRowset.getString("LOC_CD");
			 }
		 } catch(SQLException se) {
			 log.error(se.getMessage(), se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(), ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return result;
	 }
	 
	 /**
	 * [Search Revenue Port Each Lane]
	 *
	 * @param String exeYrmon
	 * @param String cancelFlg
	 * @param String vvd
	 * @param String ydCd
	 * @return List<TesManualCancellationVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<TesManualCancellationVO> searchTesMenualCancellation(String exeYrmon, String cancelFlg, String vvd, String ydCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<TesManualCancellationVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 param.put("exe_month", exeYrmon.replaceAll("-", ""));
			 param.put("cancel_flg", cancelFlg);
			 param.put("vvd", vvd);
			 param.put("yd_cd", ydCd);
			 velParam.putAll(param);			
			 dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new StatementCommonDBDAOTesManualCancellationRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, TesManualCancellationVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(), se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(), ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
	 * [Update Revenue Port Each Lane]
	 *
	 * @param List<TesManualCancellationVO> tesManualCancellationVOs
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyTesMenualCancellation(List<TesManualCancellationVO> tesManualCancellationVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			int insCnt[] = null;
			int updCnt[] = null;
			if (tesManualCancellationVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new StatementCommonDBDAOTesManualCancellationUSQL(), tesManualCancellationVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new StatementCommonDBDAOTesManualCancellationInfoUSQL(), tesManualCancellationVOs, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ZeroBalanceRunningList<br> 
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchZeroBalanceRunningList() throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOsearchZeroBalanceRunningListRSQL(), param, velParam);											
			
			while(dbRowset.next()){ 
				String yrmon = dbRowset.getString("YRMON");
				list.add(yrmon);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * INV_AR_STUP_OFC 議고쉶
	 *
	 * @param String OfcCd
	 * @return String
	 * @exception DAOException
	 */
	 public String searchInvArOfc(String OfcCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String result = "N";
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			//query parameter
			 param.put("ofc_cd", OfcCd);
			 velParam.put("ofc_cd", OfcCd);
			
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOsearchInvArOfcRSQL(), param, velParam);
			 if(dbRowset.next()){
				 result = dbRowset.getString("EXIST");
			 }
		 } catch(SQLException se) {
			 log.error(se.getMessage(), se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(), ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return result;
	 }
	
	/**
	 * Create Miss Revenue VVD
	 * 
	 * @param String missDt
	 * @param String missVvd
	 * @param String userId
	 * @param String missSlan
	 * @return GlEstmRevVvdVO
	 * @exception  DAOException
	*/
	@SuppressWarnings("unchecked")
    public GlEstmRevVvdVO manageMissRevVVD(String missDt, String missVvd, String userId, String missSlan) throws DAOException {
		
		GlEstmRevVvdVO glestmRevVvdVO = new GlEstmRevVvdVO();
		
		Map<String, Object> param 	= new HashMap<String, Object>();
		Map<String, Object> rtnMap 	= new HashMap<String, Object>();
		try {
			param.put("pi_miss_dt"	, (	missDt!=null && !missDt.equals("")		)?missDt	:JSPUtil.getKST("yyyy-MM-dd")	);
			param.put("pi_miss_vvd"	, (	missVvd!=null && !missVvd.equals("")	)?missVvd	:""   							);
			param.put("pi_user_id"	, (	userId!=null && !userId.equals("")		)?userId	:"SYSTEM"  						);
			param.put("pi_miss_slan", (	missSlan!=null && !missSlan.equals("")	)?missSlan	:""  							);
		
			rtnMap = new SQLExecuter("DEFAULT").executeSP( (ISQLTemplate)new StatementCommonDBDAOAddMissRevVvdCSQL(), param, null );
			log.debug("rtnMap 		: ---------------------------->" + rtnMap						);
			log.debug("po_result 	: ---------------------------->" + rtnMap.get("po_result"	)	);
			log.debug("po_err_msg 	: ---------------------------->" + rtnMap.get("po_err_msg"	)	);
				
			glestmRevVvdVO.setPoResult((rtnMap!=null && rtnMap.get("po_result"	)!=null)?(String)rtnMap.get("po_result"	):"");
			glestmRevVvdVO.setPoErrMsg((rtnMap!=null && rtnMap.get("po_err_msg"	)!=null)?(String)rtnMap.get("po_err_msg"):"");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	    return glestmRevVvdVO;
    }
	
	/**
	 * Create Migration Revenue VVD
	 * 
	 * @param String migDt
	 * @param String migVvd
	 * @return GlEstmRevVvdVO
	 * @exception  DAOException
	*/
	@SuppressWarnings("unchecked")
    public GlEstmRevVvdVO manageMigRevVVD(String migDt, String migVvd) throws DAOException {
		
		GlEstmRevVvdVO glestmRevVvdVO = new GlEstmRevVvdVO();
		
		Map<String, Object> param 	= new HashMap<String, Object>();
		Map<String, Object> rtnMap 	= new HashMap<String, Object>();
		try {
			param.put("pi_mig_dt"	, (	migDt!=null  && !migDt.equals("")	)?migDt	:JSPUtil.getKST("yyyy-MM-dd")	);
			param.put("pi_mig_vvd"	, (	migVvd!=null && !migVvd.equals("")	)?migVvd	:""   						);
		
			rtnMap = new SQLExecuter("DEFAULT").executeSP( (ISQLTemplate)new StatementCommonDBDAOAddMigRevVvdCSQL(), param, null );
			log.debug("rtnMap 		: ---------------------------->" + rtnMap						);
			log.debug("po_result 	: ---------------------------->" + rtnMap.get("po_result"	)	);
			log.debug("po_err_msg 	: ---------------------------->" + rtnMap.get("po_err_msg"	)	);
				
			glestmRevVvdVO.setPoResult((rtnMap!=null && rtnMap.get("po_result"	)!=null)?(String)rtnMap.get("po_result"	):"");
			glestmRevVvdVO.setPoErrMsg((rtnMap!=null && rtnMap.get("po_err_msg"	)!=null)?(String)rtnMap.get("po_err_msg"):"");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	    return glestmRevVvdVO;
    }
	
	/**
	 * [Yard Name]
	 *
	 * @param String ydCd
	 * @return String
	 * @exception DAOException
	 */
	 public String searchYardName(String ydCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String result = "";
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			//query parameter
			 param.put("yd_cd", ydCd);
			 velParam.put("yd_cd", ydCd);
			
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchYardNameRSQL(), param, velParam);
			 if(dbRowset.next()){
				 result = dbRowset.getString("YD_NM");
			 }
		 } catch(SQLException se) {
			 log.error(se.getMessage(), se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(), ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return result;
	 }
	 
	
	/**
	 * [STM_SCO_9999] Refresh<br>
	 * 
	 * @category searchAcclJobStatus
	 * @param String jobNm
	 * @param String yrMon
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")	
	public String searchAcclJobStatus(String jobNm, String yrMon)  throws DAOException {

        DBRowSet dbRowset = null;

        String rtnValue = "";
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
        	
        	Map<String, String> mapVO = new HashMap<String, String>();			
			
			mapVO.put("job_nm", jobNm);
			mapVO.put("accl_month", yrMon);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			   
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchAcclJobStatusRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("EXEC_STATUS");
			}

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return rtnValue;
	 }
		
	/**
	 * STM_SCO_9999 : DownLoad<br>
	 * TRS/TES Accrual data를 조회합니다.<br>
	 * 
	 * @param String jobNm
	 * @param String yrMon
	 * @return List<SearchTrsTesAcclDataVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Object> manageAcclDataDownLoad(String jobNm, String yrMon) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTrsTesAcclDataVO> list = null;
		List<Object> sList = new ArrayList();
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try{
        	Map<String, String> mapVO = new HashMap<String, String>();			
			
			mapVO.put("job_nm"		, jobNm);
			mapVO.put("accl_month"	, yrMon);		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchTrsTesAcclDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTrsTesAcclDataVO .class);
			
			int colCnt = dbRowset.getMetaData().getColumnCount();
			String[] sColumn = new String[colCnt];
			String[] sTitle = new String[colCnt];
							
			for(int k=1; k<=dbRowset.getMetaData().getColumnCount(); k++){
				sColumn[k-1] 	= dbRowset.getMetaData().getColumnName(k).toLowerCase();
				sTitle[k-1] 	= dbRowset.getMetaData().getColumnName(k);
			}
			
			sList.add( sColumn 	);
			sList.add( sTitle 	);
			sList.add( list 	);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sList;
	}
	
	/**
	 * COMMON : searchLocalSysdate <br>
	 *
	 * @param String ofc_cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchLocalSysdate(String ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofc_cd);         	
        	velParam.put("ofc_cd", ofc_cd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchLocalSysdateRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("LCL_TIME");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	

	/**
	 * SAKURA Interface Inquiry<br>
	 *
	 * @param SakuraInterfaceCondVO sakuraInterfaceCondVO
	 * @return List<SakuraInterfaceListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SakuraInterfaceListVO> searchSakuraInterfaceList(SakuraInterfaceCondVO sakuraInterfaceCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SakuraInterfaceListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sakuraInterfaceCondVO != null){
				 // paging process
				int paseSize    = Integer.parseInt(sakuraInterfaceCondVO.getPagerows());
				int currentPage = Integer.parseInt(sakuraInterfaceCondVO.getIPage());
				int startPart   = paseSize * (currentPage - 1) + 1;
				int endPart     = paseSize * currentPage;
				param.put("startpart", startPart);
				param.put("endpart", endPart);	
				
				Map<String, String> mapVO = sakuraInterfaceCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(new StatementCommonDBDAOSearchSakuraInterfaceInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SakuraInterfaceListVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * Search Office Adjustment Type Combo List<br>
	 * 
	 * @return List<OfcWrtfTpComboListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OfcWrtfTpComboListVO> searchOfcAdjustTpComboList() throws DAOException {
		DBRowSet dbRowset = null;
		List<OfcWrtfTpComboListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchOfcAdjustTpComboListRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfcWrtfTpComboListVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
    /**
   	 * search SCO_BAT_HIS next sequence <br>
   	 * @author KIMOKRYE
   	 * @return String
   	 * @exception DAOException
   	 * @throws DAOException
   	 */
   	 public String searchScoBatHisNextSeq() throws DAOException{
   	 	DBRowSet dbRowset = null;
   	 	String returnVal = "";
   	 	Map<String, Object> param = new HashMap<String, Object>();
   	 	//velocity parameter
   	 	Map<String, Object> velParam = new HashMap<String, Object>();

   	 	try{
   	 		dbRowset = new SQLExecuter("").executeQuery(new StatementCommonDBDAOSearchScoBatHisNextSeqRSQL(), param, velParam);
   	 		if(dbRowset.next()){
   	 			returnVal = dbRowset.getString("SEQ");
   	 		}
   	 	}catch(SQLException se){
   	 		log.error(se.getMessage(),se);
   	 		throw new DAOException(new ErrorHandler(se).getMessage());
   	 	}catch(Exception ex){
   	 		log.error(ex.getMessage(),ex);
   	 		throw new DAOException(new ErrorHandler(ex).getMessage());
   	 	}
   	 	return returnVal;
   	 }	
   	 
	/**
	 * Insert into SCO_BAT_HIS <br>
	 * @author KIMOKRYE
	 * @param ScoBatHisVO paramVO
	 * @throws DAOException
	 */
	public void addScoBatHis(ScoBatHisVO paramVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = paramVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new StatementCommonDBDAOAddScoBatHisCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}  
	
   	/**
     * Select SCO_BAT_HIS by BAT_SEQ (PK)
     *
     * @author KIMOKRYE
     * @param String batSeq
     * @return ScoBatHisVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public ScoBatHisVO searchScoBatHis(String batSeq) throws DAOException {
    	DBRowSet dbRowset = null;

    	List<ScoBatHisVO> list = null;
    	ScoBatHisVO returnVO =  new ScoBatHisVO();

    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	try {
    		param.put("bat_seq",batSeq);
    		dbRowset = new SQLExecuter("").executeQuery(new StatementCommonDBDAOSearchScoBatHisRSQL(), param, velParam);
    		list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScoBatHisVO.class);

    		if(list.size() > 0){
    			returnVO = list.get(0);
    		}
    	}catch(SQLException se){
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage());
    	}catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage());
    	}
    	return returnVO;
    }	
    
   	/**
     * Update SCO_BAT_HIS by BAT_SEQ (PK)
     *
     * @author KIMOKRYE
     * @param ScoBatHisVO scoBatHisVO
     * @return int
     * @exception DAOException
     */
	public int modifyScoBatHis(ScoBatHisVO scoBatHisVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = scoBatHisVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new StatementCommonDBDAOModifyScoBatHisUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}    
	

    
    /**
	* Monthly TES Accrual Verification 조회.
	* 2016.12.21 Add.
	* 
	* @param AccrualVerificationVO accrualVerificationVO
	* @return List<AccrualVerificationVO>
	* @throws DAOException
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AccrualVerificationVO> searchMonthlyTesAccrualVerificationList(AccrualVerificationVO accrualVerificationVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<AccrualVerificationVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
				if (accrualVerificationVO != null) {
					Map<String, String> mapVO = accrualVerificationVO.getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("ACC_OPUSCNTR").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchMonthlyTesAccrualVerificationListRSQL(), param, velParam);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccrualVerificationVO.class);             
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
	* Monthly TRS Accrual Verification 조회.
	* 2016.12.21 Add.
	* 
	* @param AccrualVerificationVO accrualVerificationVO
	* @return List<AccrualVerificationVO>
	* @throws DAOException
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AccrualVerificationVO> searchMonthlyTrsAccrualVerificationList(AccrualVerificationVO accrualVerificationVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<AccrualVerificationVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
				if (accrualVerificationVO != null) {
					Map<String, String> mapVO = accrualVerificationVO.getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("ACC_OPUSCNTR").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchMonthlyTrsAccrualVerificationListRSQL(), param, velParam);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccrualVerificationVO.class);             
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
	* Monthly TES Accrual Verification Summary 조회.
	* 2016.12.21 Add.
	* 
	* @param AccrualVerificationVO accrualVerificationVO
	* @return List<AccrualVerificationVO>
	* @throws DAOException
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AccrualVerificationVO> searchMonthlyTesAccrualVerificationSummaryList(AccrualVerificationVO accrualVerificationVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<AccrualVerificationVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
				if (accrualVerificationVO != null) {
					Map<String, String> mapVO = accrualVerificationVO.getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("ACC_OPUSCNTR").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchMonthlyTesAccrualVerificationSummaryListRSQL(), param, velParam);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccrualVerificationVO.class);             
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
	* Monthly TRS Accrual Verification Summary 조회.
	* 2016.12.21 Add.
	* 
	* @param AccrualVerificationVO accrualVerificationVO
	* @return List<AccrualVerificationVO>
	* @throws DAOException
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AccrualVerificationVO> searchMonthlyTrsAccrualVerificationSummaryList(AccrualVerificationVO accrualVerificationVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<AccrualVerificationVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
				if (accrualVerificationVO != null) {
					Map<String, String> mapVO = accrualVerificationVO.getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("ACC_OPUSCNTR").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchMonthlyTrsAccrualVerificationSummaryListRSQL(), param, velParam);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccrualVerificationVO.class);             
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
	* Monthly Cost Accrual Verification 조회.
	* 2016.12.21 Add.
	* 
	* @param AccrualVerificationVO accrualVerificationVO
	* @return List<AccrualVerificationVO>
	* @throws DAOException
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AccrualVerificationVO> searchMonthlyCostAccrualVerificationList(AccrualVerificationVO accrualVerificationVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<AccrualVerificationVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
				if (accrualVerificationVO != null) {
					Map<String, String> mapVO = accrualVerificationVO.getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("ACC_OPUSCNTR").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchMonthlyCostAccrualVerificationListRSQL(), param, velParam);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccrualVerificationVO.class);             
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
	* Monthly Accrual Trade 조회.
	* 2016.12.21 Add.
	* 
	* @param AccrualVerificationVO accrualVerificationVO
	* @return List<AccrualCodeInfoVO>
	* @throws DAOException
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AccrualCodeInfoVO> searchMonthlyAccrualTradeList(AccrualVerificationVO accrualVerificationVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<AccrualCodeInfoVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
				if (accrualVerificationVO != null) {
					Map<String, String> mapVO = accrualVerificationVO.getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("ACC_OPUSCNTR").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchMonthlyAccrualTradeListRSQL(), param, velParam);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccrualCodeInfoVO.class);             
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
	* Monthly Accrual Account 조회.
	* 2016.12.21 Add.
	* 
	* @param AccrualVerificationVO accrualVerificationVO
	* @return List<AccrualCodeInfoVO>
	* @throws DAOException
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AccrualCodeInfoVO> searchMonthlyAccrualAccountList(AccrualVerificationVO accrualVerificationVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<AccrualCodeInfoVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
				if (accrualVerificationVO != null) {
					Map<String, String> mapVO = accrualVerificationVO.getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("ACC_OPUSCNTR").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchMonthlyAccrualAccountListRSQL(), param, velParam);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccrualCodeInfoVO.class);             
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
	* Monthly Accrual SakuraAccount 조회.
	* 2016.12.21 Add.
	* 
	* @param AccrualVerificationVO accrualVerificationVO
	* @return List<AccrualCodeInfoVO>
	* @throws DAOException
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AccrualCodeInfoVO> searchMonthlyAccrualSakuraAccountList(AccrualVerificationVO accrualVerificationVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<AccrualCodeInfoVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
				if (accrualVerificationVO != null) {
					Map<String, String> mapVO = accrualVerificationVO.getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("ACC_OPUSCNTR").executeQuery((ISQLTemplate)new StatementCommonDBDAOSearchMonthlyAccrualSakuraAccountListRSQL(), param, velParam);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccrualCodeInfoVO.class);             
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
