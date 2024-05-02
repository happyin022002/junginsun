/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MotFilingLocationPropertyDBDAO.java
*@FileTitle : MOT Base Port Table Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.04.24 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.motfilinglocationproperty.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.primasterdata.motfilinglocationproperty.basic.MotFilingLocationPropertyBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriMotFileLocPptVO;


/**
 * ALPS MotFilingLocationPropertyDBDAO <br>
 * - ALPS-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SongHoJin
 * @see MotFilingLocationPropertyBCImpl 참조
 * @since J2EE 1.6
 */
public class MotFilingLocationPropertyDBDAO extends DBDAOSupport {

	/**
	 * MOT Filing Location Property 정보를 조회 합니다.<br>
	 * 
	 * @param PriMotFileLocPptVO priMotFileLocPptVO
	 * @return List<PriMotFileLocPptVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriMotFileLocPptVO> searchPriMotFileLocPpt(PriMotFileLocPptVO priMotFileLocPptVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriMotFileLocPptVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priMotFileLocPptVO != null){
				Map<String, String> mapVO = priMotFileLocPptVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MotFilingLocationPropertyDBDAOPriMotFileLocPptVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriMotFileLocPptVO .class);
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
	 * MOT Filing Location Property  정보를 생성 합니다.<br>
	 * 
	 * @param PriMotFileLocPptVO priMotFileLocPptVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addPriMotFileLocPpt(PriMotFileLocPptVO priMotFileLocPptVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priMotFileLocPptVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new MotFilingLocationPropertyDBDAOPriMotFileLocPptVOCSQL(), param, velParam);
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
	 * MOT Filing Location Property  정보를 변경 합니다.<br>
	 * 
	 * @param PriMotFileLocPptVO priMotFileLocPptVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyPriMotFileLocPpt(PriMotFileLocPptVO priMotFileLocPptVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priMotFileLocPptVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new MotFilingLocationPropertyDBDAOPriMotFileLocPptVOUSQL(), param, velParam);
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
	 * MOT Filing Location Property  정보를 삭제 합니다.<br>
	 * 
	 * @param PriMotFileLocPptVO priMotFileLocPptVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int removePriMotFileLocPpt(PriMotFileLocPptVO priMotFileLocPptVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priMotFileLocPptVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new MotFilingLocationPropertyDBDAOPriMotFileLocPptVODSQL(), param, velParam);
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
	 * MOT Filing Location Property 정보를 다건 추가 합니다.<br>
	 * 
	 * @param List<PriMotFileLocPptVO> priMotFileLocPptVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addPriMotFileLocPptS(List<PriMotFileLocPptVO> priMotFileLocPptVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priMotFileLocPptVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MotFilingLocationPropertyDBDAOPriMotFileLocPptVOCSQL(), priMotFileLocPptVO,null);
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
	 * MOT Filing Location Property  정보를 다건 변경  합니다.<br>
	 * 
	 * @param List<PriMotFileLocPptVO> priMotFileLocPptVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyPriMotFileLocPptS(List<PriMotFileLocPptVO> priMotFileLocPptVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priMotFileLocPptVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MotFilingLocationPropertyDBDAOPriMotFileLocPptVOUSQL(), priMotFileLocPptVO,null);
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
	 * MOT Filing Location Property  정보를 다건 삭제 합니다.<br>
	 * 
	 * @param List<PriMotFileLocPptVO> priMotFileLocPptVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removePriMotFileLocPptS(List<PriMotFileLocPptVO> priMotFileLocPptVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priMotFileLocPptVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new MotFilingLocationPropertyDBDAOPriMotFileLocPptVODSQL(), priMotFileLocPptVO,null);
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