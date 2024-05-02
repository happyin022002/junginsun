/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCPrefixDBDAO.java
*@FileTitle : S/C Prefix Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.04.16 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.scprefix.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.primasterdata.scprefix.basic.SCPrefixBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.scprefix.vo.PriScPfxMapgListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriScPfxMapgVO;
import com.clt.syscommon.common.table.PriScPfxVO;


/**
 *  SCPrefixDAO <br>
 * - PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Moon Dong Gyu
 * @see SCPrefixBCImpl 참조
 * @since J2EE 1.4
 */
public class SCPrefixDBDAO extends DBDAOSupport {

	/**
	 * S/C Prefix and Scope Mapping 정보를 조회합니다.<br>
	 * 
	 * @param PriScPfxMapgVO priScPfxMapgVO
	 * @return List<PriScPfxMapgListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriScPfxMapgListVO> searchSCPrefixMappingList(PriScPfxMapgVO priScPfxMapgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScPfxMapgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScPfxMapgVO != null){
				Map<String, String> mapVO = priScPfxMapgVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCPrefixDBDAOPriScPfxMapgVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScPfxMapgListVO .class);
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
	 * S/C Prefix 정보를 조회합니다.<br>
	 * 
	 * @param PriScPfxVO priScPfxVO
	 * @return List<PriScPfxVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<PriScPfxVO> searchSCPrefixList(PriScPfxVO priScPfxVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScPfxVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScPfxVO != null){
				Map<String, String> mapVO = priScPfxVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCPrefixDBDAOPriScPfxVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScPfxVO .class);
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
	 * S/C Prefix and Scope Mapping 정보를 생성합니다.<br>
	 * 
	 * @param PriScPfxMapgVO priScPfxMapgVO
	 * @exception DAOException
	 */
	public void addSCPrefixMapping(PriScPfxMapgVO priScPfxMapgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScPfxMapgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCPrefixDBDAOPriScPfxMapgVOCSQL(), param, velParam);
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
	 * S/C Prefix and Scope Mapping 정보를 수정합니다.<br>
	 * 
	 * @param PriScPfxMapgVO priScPfxMapgVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifySCPrefixMapping(PriScPfxMapgVO priScPfxMapgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScPfxMapgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCPrefixDBDAOPriScPfxMapgVOUSQL(), param, velParam);
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
	 * S/C Prefix and Scope Mapping 정보를 삭제합니다.<br>
	 * 
	 * @param PriScPfxMapgVO priScPfxMapgVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeSCPrefixMapping(PriScPfxMapgVO priScPfxMapgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScPfxMapgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCPrefixDBDAOPriScPfxMapgVODSQL(), param, velParam);
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
	 * S/C Prefix 정보를 생성합니다.<br>
	 * 
	 * @param PriScPfxVO priScPfxVO
	 * @exception DAOException
	 */
	public void addSCPrefix(PriScPfxVO priScPfxVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = priScPfxVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCPrefixDBDAOPriScPfxVOCSQL(), param, velParam);
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
	 * S/C Prefix 정보를 수정합니다.<br>
	 * 
	 * @param PriScPfxVO priScPfxVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifySCPrefix(PriScPfxVO priScPfxVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScPfxVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCPrefixDBDAOPriScPfxVOUSQL(), param, velParam);
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
	 * S/C Prefix 정보를 삭제합니다.<br>
	 * 
	 * @param PriScPfxVO priScPfxVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeSCPrefix(PriScPfxVO priScPfxVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScPfxVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCPrefixDBDAOPriScPfxVODSQL(), param, velParam);
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
     * S/C Prefix and Scope Mapping 에서 사용하는 Prefix 인지 여부를 조회합니다.<br>
     * 
     * @param PriScPfxVO priScPfxVO
     * @return boolean
     * @exception DAOException
     */
    public boolean searchUsedPrefix(PriScPfxVO priScPfxVO) throws DAOException,Exception {
        DBRowSet dbRowset = null;
        boolean b = false;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priScPfxVO != null){
                Map<String, String> mapVO = priScPfxVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCPrefixDBDAOCheckUsedPrefixRSQL(), param, velParam);
            if (dbRowset.next()) {
                b = true;
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return b;
    }
}
