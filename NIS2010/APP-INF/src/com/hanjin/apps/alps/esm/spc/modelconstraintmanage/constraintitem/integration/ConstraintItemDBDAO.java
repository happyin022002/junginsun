/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ConstraintItemDBDAO.java
*@FileTitle : Constraints List Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.07.30 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.basic.ConstraintItemBCImpl;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.vo.SearchConstraintItem063LoadableListVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.vo.SearchConstraintItemListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqMdlCnstVO;


/**
 * ALPS ConstraintItemDBDAO <br>
 * - ALPS-ModelConstraintManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HJ.LEE
 * @see ConstraintItemBCImpl 참조
 * @since J2EE 1.6
 */
public class ConstraintItemDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchConstraintItemListVO searchConstraintItemListVO
	 * @return List<SearchConstraintItemListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchConstraintItemListVO> searchConstraintItemList(SearchConstraintItemListVO searchConstraintItemListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchConstraintItemListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConstraintItemListVO != null){
				Map<String, String> mapVO = searchConstraintItemListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SAQ_HJSBAT").executeQuery((ISQLTemplate)new ConstraintItemDBDAOSearchConstraintItemListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchConstraintItemListVO .class);
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
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 * 
		 * @param ConditionVO conditionVO
		 * @return List<SearchConstraintItem063LoadableListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchConstraintItem063LoadableListVO> searchConstraintItem063LoadableList(ConditionVO conditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchConstraintItem063LoadableListVO> list = null;
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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConstraintItemDBDAOSearchConstraintItem063LoadableListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchConstraintItem063LoadableListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SaqMdlCnstVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addmultiConstraintItem(SaqMdlCnstVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ConstraintItemDBDAOMultiConstraintItemCSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SaqMdlCnstVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiConstraintItem(SaqMdlCnstVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new ConstraintItemDBDAOMultiConstraintItemUSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SaqMdlCnstVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removemultiConstraintItem(SaqMdlCnstVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new ConstraintItemDBDAOMultiConstraintItemDSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SaqMdlCnstVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiConstraintItemS(List<SaqMdlCnstVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintItemDBDAOMultiConstraintItemCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SaqMdlCnstVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiConstraintItemS(List<SaqMdlCnstVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintItemDBDAOMultiConstraintItemUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SaqMdlCnstVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiConstraintItemS(List<SaqMdlCnstVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ConstraintItemDBDAOMultiConstraintItemDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
}