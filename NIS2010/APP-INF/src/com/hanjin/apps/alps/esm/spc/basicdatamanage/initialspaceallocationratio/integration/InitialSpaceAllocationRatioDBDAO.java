/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InitialSpaceAllocationRatioDBDAO.java
*@FileTitle : Initial Allocation Ratio Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.07.24 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.basic.InitialSpaceAllocationRatioBCImpl;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.vo.SearchInitialSpaceAllocationRatioListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.SpcInitAlocRtoVO;


/**
 * ALPS InitialSpaceAllocationRatioDBDAO <br>
 * - ALPS-BasicDataManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HJ.LEE
 * @see InitialSpaceAllocationRatioBCImpl 참조
 * @since J2EE 1.6
 */
public class InitialSpaceAllocationRatioDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchInitialSpaceAllocationRatioListVO searchInitialSpaceAllocationRatioListVO
	 * @return List<SearchInitialSpaceAllocationRatioListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchInitialSpaceAllocationRatioListVO> searchInitialSpaceAllocationRatioList(SearchInitialSpaceAllocationRatioListVO searchInitialSpaceAllocationRatioListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInitialSpaceAllocationRatioListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchInitialSpaceAllocationRatioListVO != null){
				Map<String, String> mapVO = searchInitialSpaceAllocationRatioListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InitialSpaceAllocationRatioDBDAOSearchInitialSpaceAllocationRatioListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInitialSpaceAllocationRatioListVO .class);
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
	 * @param SpcInitAlocRtoVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addmultiInitialSpaceAllocationRatio(SpcInitAlocRtoVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InitialSpaceAllocationRatioDBDAORatioInseInitAlogRtoCSQL(), param, velParam);
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
	 * @param SpcInitAlocRtoVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiInitialSpaceAllocationRatio(SpcInitAlocRtoVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InitialSpaceAllocationRatioDBDAORatioInseInitAlogRtoUSQL(), param, velParam);
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
	 * @param SpcInitAlocRtoVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removemultiInitialSpaceAllocationRatio(SpcInitAlocRtoVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InitialSpaceAllocationRatioDBDAORatioInseInitAlogRtoDSQL(), param, velParam);
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
	 * @param List<SpcInitAlocRtoVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiInitialSpaceAllocationRatioS(List<SpcInitAlocRtoVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InitialSpaceAllocationRatioDBDAORatioInseInitAlogRtoCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No "+ i + " SQL");
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
	 * @param List<SpcInitAlocRtoVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiInitialSpaceAllocationRatioS(List<SpcInitAlocRtoVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InitialSpaceAllocationRatioDBDAORatioInseInitAlogRtoUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED) 
						throw new DAOException("Fail to insert No "+ i + " SQL");
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
	 * @param List<SpcInitAlocRtoVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiInitialSpaceAllocationRatioS(List<SpcInitAlocRtoVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new InitialSpaceAllocationRatioDBDAORatioInseInitAlogRtoDSQL(), delModels,null);				
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