/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KeyManInfoManageDBDAO.java
*@FileTitle : KeyMan Info Management
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 이창원
*@LastVersion : 1.0
* 2011.05.09 이창원
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.basic.KeyManInfoManageBCImpl;
import com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.vo.SamKeyManInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS KeyManInfoManageDBDAO <br>
 * - ALPS-GeneralInfoManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author NAMKOONGJINHO
 * @see KeyManInfoManageBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class KeyManInfoManageDBDAO extends DBDAOSupport {

	 /**
	 * ESM_SAM_0003 : SELECT <br>
	 * Retrieve
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return List<SearchCustomerVO>        
	 * @exception DAOException
	 */
	
	@SuppressWarnings("unchecked")
	public List<SearchCustomerVO> searchKeyManInfo(SearchCustomerVO searchCustomerVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCustomerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchCustomerVO != null) {
				Map<String, String> mapVO = searchCustomerVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KeyManInfoManageDBDAOsearchKeyManInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCustomerVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 /**
		 * ESM_SAM_0003 : SELECT <br>
		 * DBClick
		 * 
		 * @param SamKeyManInfoVO samKeyManInfoVO
		 * @return List<SamKeyManInfoVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SamKeyManInfoVO> searchKeyManDetailInfo(SamKeyManInfoVO samKeyManInfoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SamKeyManInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (samKeyManInfoVO != null) {
					Map<String, String> mapVO = samKeyManInfoVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KeyManInfoManageDBDAOsearchKeyManDetailInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SamKeyManInfoVO .class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
	 
	
		/**
		 * ESM_SAM_0003 
		 * 신규 KeyManInfo를[추가]합니다.<br>
		 * 
		 * @param SamKeyManInfoVO samKeyManInfoVO
		 * @exception DAOException
		 */
		public void addKeyManInfo(SamKeyManInfoVO samKeyManInfoVO) throws DAOException {
				SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {
				if(samKeyManInfoVO != null){
					
					Map<String, String> mapVO = samKeyManInfoVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					int result = sqlExe.executeUpdate((ISQLTemplate)new KeyManInfoManageDBDAOaddKeyManInfoCSQL(), param, velParam);
						if(result == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		/**
		 * ESM_SAM_0003 
		 * KeyManInfo를[수정]합니다<br>
		 * 
		 * @param SamKeyManInfoVO samKeyManInfoVO
		 * @exception DAOException
		 */
		public void modifyKeyManInfo(SamKeyManInfoVO samKeyManInfoVO) throws DAOException {
				SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {
				if(samKeyManInfoVO != null){
					
					Map<String, String> mapVO = samKeyManInfoVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					int result = sqlExe.executeUpdate((ISQLTemplate)new KeyManInfoManageDBDAOmodifyKeyManInfoUSQL(), param, velParam);
						if(result == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
		/**
		 * ESM_SAM_0003 
		 * KeyManInfo를[삭제]합니다<br>
		 * 
		 * @param SamKeyManInfoVO samKeyManInfoVO
		 * @exception DAOException
		 */
		public void removeKeyManInfo(SamKeyManInfoVO samKeyManInfoVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(samKeyManInfoVO != null){
				
				Map<String, String> mapVO = samKeyManInfoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new KeyManInfoManageDBDAOremoveKeyManInfoDSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}