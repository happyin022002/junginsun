/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupMappingDBDAO.java
*@FileTitle : Evaluation Group Mapping & Basic Evaluation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.basic.EvaluationGroupMappingBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.vo.EGAndBEMappingVO;




/**
 * ALPS EvaluationGroupMappingDBDAO <br>
 * - ALPS-EGMapping system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see EvaluationGroupMappingBCImpl 참조
 * @since J2EE 1.6
 */
public class EvaluationGroupMappingDBDAO extends DBDAOSupport {

	/**
	 * Evaluation Group Mapping & Basic Evaluation 화면을 조회한다.<br>
	 * 
	 * @param EGAndBEMappingVO	egAndBEMappingVO
	 * @return List<EGAndBEMappingVO>
	 * @exception EventException
	 */
	public List<EGAndBEMappingVO> searchEGBEMapping(EGAndBEMappingVO egAndBEMappingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EGAndBEMappingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(egAndBEMappingVO != null){
				Map<String, String> mapVO = egAndBEMappingVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupMappingDBDAOSearchEGBEMappingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EGAndBEMappingVO .class);
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
	 * Basic Evaluation 데이터가 저장가능 한지 확인한다.<br>
	 * 
	 * @param EGAndBEMappingVO	egAndBEMappingVO
	 * @return List<EGAndBEMappingVO>
	 * @exception EventException
	 */
	public List<EGAndBEMappingVO> searchEGBEMappingChk(EGAndBEMappingVO egAndBEMappingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EGAndBEMappingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(egAndBEMappingVO != null){
				Map<String, String> mapVO = egAndBEMappingVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupMappingDBDAOSearchEGBEMappingChkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EGAndBEMappingVO .class);
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
	 * Basic Evaluation 데이터를 조회한다.<br>
	 * 
	 * @param EGAndBEMappingVO	egAndBEMappingVO
	 * @return List<EGAndBEMappingVO>
	 * @exception EventException
	 */
	public List<EGAndBEMappingVO> searchBECode(EGAndBEMappingVO egAndBEMappingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EGAndBEMappingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(egAndBEMappingVO != null){
				Map<String, String> mapVO = egAndBEMappingVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupMappingDBDAOSearchBECodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EGAndBEMappingVO .class);
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
	 * EG vs Evalulator Mapping 데이터를 입력 한다.<br>
	 * 
	 * @param EGAndBEMappingVO	egAndBEMappingVO
	 * @exception EventException
	 */
	public void addEGBEMapping(EGAndBEMappingVO egAndBEMappingVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(egAndBEMappingVO != null){
				 //query parameter
				 Map<String, String> param = egAndBEMappingVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EvaluationGroupMappingDBDAOAddEGBEMappingCSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
			 }	
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	}
	
	/**
	 * EG vs Evalulator Mapping 데이터를 수정 한다.<br>
	 * 
	 * @param EGAndBEMappingVO	egAndBEMappingVO
	 * @exception EventException
	 */
	public void modifyEGBEMapping(EGAndBEMappingVO egAndBEMappingVO) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(egAndBEMappingVO != null){
				//query parameter
				Map<String, String> param = egAndBEMappingVO.getColumnValues();
				int result = sqlExe.executeUpdate((ISQLTemplate) new EvaluationGroupMappingDBDAOModifyEGBEMappingUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
			}	
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EG vs Evalulator Mapping 데이터를 삭제 한다.<br>
	 * 
	 * @param EGAndBEMappingVO	egAndBEMappingVO
	 * @exception EventException
	 */
	public void removeEGBEMapping(EGAndBEMappingVO egAndBEMappingVO) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(egAndBEMappingVO != null){
				//query parameter
				Map<String, String> param = egAndBEMappingVO.getColumnValues();
				int result = sqlExe.executeUpdate((ISQLTemplate) new EvaluationGroupMappingDBDAORemoveEGBEMappingDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				
			}	
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}