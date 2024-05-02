/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NoShowReflectionDBDAO.java
*@FileTitle : No-Show Ratio Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.09.07 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.basic.NoShowReflectionBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.SpcNshwRfltVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.vo.SearchNoShowReflectionListVO;


/**
 * ALPS NoShowReflectionDBDAO <br>
 * - ALPS-ModelConstraintManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HJ.LEE
 * @see NoShowReflectionBCImpl 참조
 * @since J2EE 1.6
 */
public class NoShowReflectionDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchNoShowReflectionListVO searchNoShowReflectionListVO
	 * @return List<SearchNoShowReflectionListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchNoShowReflectionListVO> searchNoShowReflectionList(SearchNoShowReflectionListVO searchNoShowReflectionListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchNoShowReflectionListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchNoShowReflectionListVO != null){
				Map<String, String> mapVO = searchNoShowReflectionListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NoShowReflectionDBDAOSearchNoShowReflectionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNoShowReflectionListVO .class);
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
	 * @param SpcNshwRfltVO spcNshwRfltVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addmultiNoShowReflection(SpcNshwRfltVO spcNshwRfltVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = spcNshwRfltVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new NoShowReflectionDBDAOMultiSpcNshwRfltCSQL(), param, velParam);
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
	 * @param SpcNshwRfltVO spcNshwRfltVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiNoShowReflection(SpcNshwRfltVO spcNshwRfltVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = spcNshwRfltVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new NoShowReflectionDBDAOMultiSpcNshwRfltUSQL(), param, velParam);
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
	 * @param SpcNshwRfltVO spcNshwRfltVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removemultiNoShowReflection(SpcNshwRfltVO spcNshwRfltVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = spcNshwRfltVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new NoShowReflectionDBDAOMultiSpcNshwRfltDSQL(), param, velParam);
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
	 * @param List<SpcNshwRfltVO> spcNshwRfltVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiNoShowReflectionS(List<SpcNshwRfltVO> spcNshwRfltVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(spcNshwRfltVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new NoShowReflectionDBDAOMultiSpcNshwRfltCSQL(), spcNshwRfltVO,null);
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
	 * @param List<SpcNshwRfltVO> spcNshwRfltVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiNoShowReflectionS(List<SpcNshwRfltVO> spcNshwRfltVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(spcNshwRfltVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new NoShowReflectionDBDAOMultiSpcNshwRfltUSQL(), spcNshwRfltVO,null);
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
	 * @param List<SpcNshwRfltVO> spcNshwRfltVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiNoShowReflectionS(List<SpcNshwRfltVO> spcNshwRfltVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(spcNshwRfltVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new NoShowReflectionDBDAOMultiSpcNshwRfltDSQL(), spcNshwRfltVO,null);
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