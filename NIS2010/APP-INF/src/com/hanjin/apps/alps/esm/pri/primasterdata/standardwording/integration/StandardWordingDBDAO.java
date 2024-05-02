/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StandardWordingDBDAO.java
*@FileTitle : Standard Wording for S/C Notes
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.13 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.standardwording.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.primasterdata.standardwording.basic.StandardWordingBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriScStndWdgVO;


/**
 * NIS2010 StandardWordingDBDAO <br>
 * - NIS2010-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Moon Dong Gyu
 * @see StandardWordingBCImpl 참조
 * @since J2EE 1.4
 */
public class StandardWordingDBDAO extends DBDAOSupport {

	/**
	 * Standard Wording for S/C Notes 를 조회합니다.<br>
	 * 
	 * @param PriScStndWdgVO priScStndWdgVO
	 * @return List<PriScStndWdgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriScStndWdgVO> searchStandardWordingList(PriScStndWdgVO priScStndWdgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScStndWdgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScStndWdgVO != null){
				Map<String, String> mapVO = priScStndWdgVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StandardWordingDBDAOPriScStndWdgVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScStndWdgVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Standard Wording for S/C Notes 를 생성합니다.<br>
	 * 
	 * @param PriScStndWdgVO priScStndWdgVO
	 * @exception DAOException
	 */
	public void addmanageStandardWording(PriScStndWdgVO priScStndWdgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScStndWdgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new StandardWordingDBDAOPriScStndWdgVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Standard Wording for S/C Notes 를 수정합니다.<br>
	 * 
	 * @param PriScStndWdgVO priScStndWdgVO
	 * @exception DAOException
	 */
	public void modifymanageStandardWording(PriScStndWdgVO priScStndWdgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScStndWdgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new StandardWordingDBDAOPriScStndWdgVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Standard Wording for S/C Notes 를 삭제합니다.<br>
	 * 
	 * @param PriScStndWdgVO priScStndWdgVO
	 * @exception DAOException
	 */
	public void removemanageStandardWording(PriScStndWdgVO priScStndWdgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScStndWdgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new StandardWordingDBDAOPriScStndWdgVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}
