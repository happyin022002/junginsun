/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PreAllocationDBDAO.java
*@FileTitle : Pre-Allocation Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.07 주선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.basic.PreAllocationBCImpl;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.vo.SearchPreAllocation0068List01VO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqPreAlocVO;


/**
 * ALPS PreAllocationDBDAO <br>
 * - ALPS-ModelConstraintManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Ju Sun Young
 * @see PreAllocationBCImpl 참조
 * @since J2EE 1.6
 */
public class PreAllocationDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<ConditionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchPreAllocation0068List01VO> searchPreAllocation0068List01(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPreAllocation0068List01VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SAQ_HJSBAT").executeQuery((ISQLTemplate)new PreAllocationDBDAOSearchPreAllocation0068List01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPreAllocation0068List01VO.class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SaqPreAlocVO saqPreAlocVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addmultiSaqPreAloc0067(SaqPreAlocVO saqPreAlocVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = saqPreAlocVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PreAllocationDBDAOAddmultiSaqPreAloc0067CSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SaqPreAlocVO saqPreAlocVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiSaqPreAloc0067(SaqPreAlocVO saqPreAlocVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = saqPreAlocVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new PreAllocationDBDAOModifymultiSaqPreAloc0067USQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SaqPreAlocVO saqPreAlocVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removemultiSaqPreAloc0067(SaqPreAlocVO saqPreAlocVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = saqPreAlocVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new PreAllocationDBDAORemovemultiSaqPreAloc0067DSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SaqPreAlocVO> saqPreAlocVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSaqPreAloc0067S(List<SaqPreAlocVO> saqPreAlocVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");

			if(saqPreAlocVO.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PreAllocationDBDAOAddmultiSaqPreAloc0067CSQL(), saqPreAlocVO,null);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SaqPreAlocVO> saqPreAlocVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSaqPreAloc0067S(List<SaqPreAlocVO> saqPreAlocVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			if(saqPreAlocVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PreAllocationDBDAOModifymultiSaqPreAloc0067USQL(), saqPreAlocVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *  
	 * @param List<SaqPreAlocVO> saqPreAlocVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSaqPreAloc0067S(List<SaqPreAlocVO> saqPreAlocVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SAQ_HJSBAT");
			if(saqPreAlocVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PreAllocationDBDAORemovemultiSaqPreAloc0067DSQL(), saqPreAlocVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
		return delCnt;
	}
	
}