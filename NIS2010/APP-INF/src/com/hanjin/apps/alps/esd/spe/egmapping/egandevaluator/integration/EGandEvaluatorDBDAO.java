/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EGandEvaluatorDBDAO.java
*@FileTitle : EG vs Evaluator Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.basic.EGandEvaluatorBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.vo.SpeEGEVMappingVO;


/**
 * ALPS EGandEvaluatorDBDAO <br>
 * - ALPS-EGMapping system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see EGandEvaluatorBCImpl 참조
 * @since J2EE 1.6
 */
public class EGandEvaluatorDBDAO extends DBDAOSupport {


	
	/**
	 * Basic Evaluator 를 조회한다.<br>
	 * 
	 * @param SpeEGEVMappingVO speEGEVMappingVO
	 * @return List<SpeEGEVMappingVO>
	 * @exception EventException
	 */
	public List<SpeEGEVMappingVO> searchEGEVBasic(SpeEGEVMappingVO speEGEVMappingVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SpeEGEVMappingVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(speEGEVMappingVO != null){
				 Map<String, String> mapVO = speEGEVMappingVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EGandEvaluatorDBDAOSearchEGEVBasicRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpeEGEVMappingVO .class);
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
	 * EG vs Evalulator Mapping 데이터를 조회한다.<br>
	 * 
	 * @param SpeEGEVMappingVO speEGEVMappingVO
	 * @return List<SpeEGEVMappingVO>
	 * @exception EventException
	 */
	public List<SpeEGEVMappingVO> searchEGEVPerformance(SpeEGEVMappingVO speEGEVMappingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpeEGEVMappingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(speEGEVMappingVO != null){
				Map<String, String> mapVO = speEGEVMappingVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EGandEvaluatorDBDAOSearchEGEVPerformanceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpeEGEVMappingVO .class);
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
	 * Basic Evaluator ID 를 조회 하여 기 입력된 데이터 인지 확인한다.<br>
	 * 
	 * @param SpeEGEVMappingVO speEGEVMappingVO
	 * @return String
	 * @exception EventException
	 */
	public String searchEGEVMChking(SpeEGEVMappingVO speEGEVMappingVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String chk = "";
		try{
			if(speEGEVMappingVO != null){
				Map<String, String> mapVO = speEGEVMappingVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EGandEvaluatorDBDAOSearchEGEVMChkingRSQL(), param, velParam);
			 if(dbRowset.next()){
				 chk = dbRowset.getString("chk");
			 }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chk;
	}
	
	
	 
	 /**
	  * EG vs Evalulator Mapping 값을 입력한다.<br>
	  * 
	  * @param SpeEGEVMappingVO speEGEVMappingVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void addEGEVMapping(SpeEGEVMappingVO speEGEVMappingVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speEGEVMappingVO != null){
				 //query parameter
				 Map<String, String> param = speEGEVMappingVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EGandEvaluatorDBDAOaddEGEVMappingCSQL() , param, null);
				 
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
	  * EG vs Evalulator Mapping 값을 수정한다.<br>
	  * 
	  * @param SpeEGEVMappingVO speEGEVMappingVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void modifyEGEVMapping(SpeEGEVMappingVO speEGEVMappingVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speEGEVMappingVO != null){
				 //query parameter
				 Map<String, String> param = speEGEVMappingVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EGandEvaluatorDBDAOModifyEGEVMappingUSQL() , param, null);
				 
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
	  * EG vs Evalulator Mapping 값을 삭제한다.<br>
	  * 
	  * @param SpeEGEVMappingVO speEGEVMappingVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void removeEGEVMapping(SpeEGEVMappingVO speEGEVMappingVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speEGEVMappingVO != null){
				 //query parameter
				 Map<String, String> param = speEGEVMappingVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EGandEvaluatorDBDAORemoveEGEVMappingDSQL() , param, null);
				 
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
	  * EG vs Evalulator Mapping 데이터의 히스토리 정보를 입력 한다.<br>
	  * 
	  * @param SpeEGEVMappingVO speEGEVMappingVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void addEGEVMappingHis(SpeEGEVMappingVO speEGEVMappingVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speEGEVMappingVO != null){
				 //query parameter
				 Map<String, String> param = speEGEVMappingVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EGandEvaluatorDBDAOAddEGEVMappingHisCSQL() , param, null);
				 
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