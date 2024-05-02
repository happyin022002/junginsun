/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ApplicationDateRuleDBDAO.java
*@FileTitle : Surcharge Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.vo.RoutLocCdVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.basic.SurchargeGroupLocationBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 *  SurchargeGroupLocationDAO <br>
 * - Surcharge system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see SurchargeGroupLocationBCImpl 
 * @since J2EE 1.4
 */
	public class ApplicationDateRuleDBDAO extends DBDAOSupport {
	
		/**Route Location conversion List select<br>
		 * @param routLocCdVO
		 * @return List<RoutLocCdVO>
		 * @throws DAOException
		 */
		public List<RoutLocCdVO> searchLocationInfo(RoutLocCdVO routLocCdVO) throws DAOException {
			
			DBRowSet dbRowset = null;
			List<RoutLocCdVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(routLocCdVO != null){
					Map<String, String> mapVO = routLocCdVO.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApplicationDateRuleDBDAOsearchLocationInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RoutLocCdVO.class);
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
		 * Scope code select from Route Location conversion
		 * @return String
		 * @throws DAOException
		 */
		public String[] searchScpCd() throws DAOException {
			DBRowSet dbRowset = null;
			String[] scp = null;
			
			try{

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApplicationDateRuleDBDAOsearchScpCdRSQL(), null, null);
				int i=0;
				while (dbRowset.next()) {
					if (i == 0) {
						scp = new String[dbRowset.getRowCount()];
					}
					scp[i] = dbRowset.getString(1);
					i++;
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return scp;
		}
		
		/**
		 * Route Location conversion List Insert<br>
		 * @param routLocCdVO
		 * @param account
		 * @throws DAOException
		 */
		public void addLocationInfo(RoutLocCdVO routLocCdVO, SignOnUserAccount account) throws DAOException {
			//query parameter
			Map<String, String> mapVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(routLocCdVO != null){
					mapVO = routLocCdVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.put("upd_usr_id", account.getUsr_id());
					param.put("cre_usr_id", account.getUsr_id());
				}
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new ApplicationDateRuleDBDAOaddLocationInfoCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert No"+ " SQL");
				}
						
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**Route Location conversion List Delete.<br>
		 * @param routLocCdVO
		 * @param account
		 * @throws DAOException
		 */
		public void removeLocationInfo(RoutLocCdVO routLocCdVO, SignOnUserAccount account) throws DAOException {
			//query parameter
			Map<String, String> mapVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(routLocCdVO != null){
					mapVO = routLocCdVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new ApplicationDateRuleDBDAOremoveLocationInfoDSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to delete No"+ " SQL");
				}
						
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**Route Location conversion List Update<br>
		 * @param routLocCdVO
		 * @param account
		 * @throws DAOException
		 */
		public void modifyLocationInfo(RoutLocCdVO routLocCdVO, SignOnUserAccount account) throws DAOException {
			Map<String, String> mapVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(routLocCdVO != null){
					mapVO = routLocCdVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.put("upd_usr_id", account.getUsr_id());
				}
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new ApplicationDateRuleDBDAOmodifyLocationInfoUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update No"+ " SQL");
				}
						
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**check if there is the same data in Route Location conversion List
		 * @param chkScpCd
		 * @param chkOrgCd
		 * @param chkConvCd
		 * @return DBRowSet
		 * @throws DAOException
		 */
		public DBRowSet checkLocationInfo(String chkScpCd,String chkOrgCd,String chkConvCd) throws DAOException {
			DBRowSet dbRowset = null; 
			Map<String, Object> param = new HashMap<String, Object>();//parameter	
				try {
					
					if(chkScpCd != null && chkOrgCd != null &&chkConvCd != null){
						param.put("chk_scp_cd",chkScpCd);	
						param.put("chk_org_cd",chkOrgCd);
						param.put("chk_conv_cd",chkConvCd);
					}
								
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApplicationDateRuleDBDAOcheckLocationInfoRSQL(), param, null);
				} catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());			
				} catch(Exception ex){
					log.error(ex.getMessage(),ex);			
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}

				return dbRowset;
		}
		
		
		/**check if there is Location code
		 * @param chkLocation
		 * @return DBRowSet
		 * @throws DAOException
		 */
		public DBRowSet checkLocationName(String chkLocation) throws DAOException {
			DBRowSet dbRowset = null; 
			Map<String, Object> param = new HashMap<String, Object>();//parameter	
				try {
					
					if(chkLocation != null){
						param.put("chk_location",chkLocation);	

					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApplicationDateRuleDBDAOcheckLocationNameRSQL(), param, null);
				} catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());			
				} catch(Exception ex){
					log.error(ex.getMessage(),ex);			
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}

				return dbRowset;
		}
		
		/**check if there are the same data in DB
		 * @param chkLocation
		 * @param check_flg
		 * @param chk_scp_cd
		 * @return DBRowSet
		 * @throws DAOException
		 */
		public DBRowSet checkForScp(String chkLocation,String check_flg,String chk_scp_cd) throws DAOException {
			DBRowSet dbRowset = null; 
			Map<String, Object> param = new HashMap<String, Object>();//parameter	
				try {
					
					if(chkLocation != null && check_flg != null &&chk_scp_cd != null){
						param.put("chk_location",chkLocation);	
						param.put("chk_flg",check_flg);
						param.put("chk_scp_cd",chk_scp_cd);
					}
								
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApplicationDateRuleDBDAOcheckForScpRSQL(), param, null);
				} catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());			
				} catch(Exception ex){
					log.error(ex.getMessage(),ex);			
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}

				return dbRowset;
		}
}
