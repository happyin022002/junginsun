/*=========================================================
*Copyright(c) 2017 Hipluscard
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
package com.hanjin.apps.alps.bcm.cms.custmanage.keymaninfo.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.bcm.cms.custmanage.keymaninfo.vo.SamKeyManInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS KeyManInfoManageDBDAO <br>
 * - ALPS-GeneralInfoManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>

 * @author NAMKOONGJINHO
 * @see KeyManInfoManageBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class KeyManInfoDBDAO extends DBDAOSupport {

	 /**
	 * BCM_CMS_0003 : SELECT <br>
	 * Retrieve
	 * @param SearchCustomerVO searchCustomerVO
	 * @return List<SearchCustomerVO>        
	 * @exception DAOException
	 */
	
	@SuppressWarnings("unchecked")
	public List<SamKeyManInfoVO> searchKeyManInfo(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamKeyManInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);
			velParam.put("cust_cnt_cd", custCntCd);
			velParam.put("cust_seq", custSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KeyManInfoDBDAOsearchKeyManInfoRSQL(), param, velParam);
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
		 * BCM_CMS_0003 : SELECT <br>
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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KeyManInfoDBDAOsearchKeyManDetailInfoRSQL(), param, velParam);
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
		 * BCM_CMS_0003 
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
					int result = sqlExe.executeUpdate((ISQLTemplate)new KeyManInfoDBDAOaddKeyManInfoCSQL(), param, velParam);
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
		 * BCM_CMS_0003 
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
					int result = sqlExe.executeUpdate((ISQLTemplate)new KeyManInfoDBDAOmodifyKeyManInfoUSQL(), param, velParam);
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
		 * BCM_CMS_0003 
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
				int result = sqlExe.executeUpdate((ISQLTemplate)new KeyManInfoDBDAOremoveKeyManInfoDSQL(), param, velParam);
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
		 * BCM_CMS_0307 : SELECT <br>
		 * DBClick
		 * 
		 * @param SamKeyManInfoVO samKeyManInfoVO
		 * @return List<SamKeyManInfoVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<SamKeyManInfoVO> searchKeyManList(SamKeyManInfoVO samKeyManInfoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SamKeyManInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			

			try {
				param.put("cust_cnt_cd", samKeyManInfoVO.getCustCntCd());
				param.put("cust_seq", samKeyManInfoVO.getCustSeq());
				velParam.put("cust_cnt_cd", samKeyManInfoVO.getCustCntCd());
				velParam.put("cust_seq", samKeyManInfoVO.getCustSeq());
				
				if (samKeyManInfoVO != null) {
					Map<String, String> mapVO = samKeyManInfoVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new KeyManInfoDBDAOsearchKeyManListRSQL(), param, velParam);
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
}