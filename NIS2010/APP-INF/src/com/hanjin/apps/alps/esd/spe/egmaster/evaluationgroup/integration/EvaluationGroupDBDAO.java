/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupDBDAO.java
*@FileTitle : Evaluation Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.basic.EvaluationGroupBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.vo.SpeEGCreVO;


/**
 * ALPS EvaluationGroupDBDAO <br>
 * - ALPS-EGMaster system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see EvaluationGroupBCImpl 참조
 * @since J2EE 1.6
 */
public class EvaluationGroupDBDAO extends DBDAOSupport {

	 /**
	  * EG테이블에 값을 입력한다.<br>
	  * 
	  * @param SpeEGCreVO speEGCreVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void addEGCre(SpeEGCreVO speEGCreVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speEGCreVO != null){
				 //query parameter
				 Map<String, String> param = speEGCreVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EvaluationGroupDBDAOAddEGCreCSQL() , param, null);
				 
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
	  * EG테이블에 값을 수정한다.<br>
	  * 
	  * @param SpeEGCreVO speEGCreVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void modifyEGCre(SpeEGCreVO speEGCreVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speEGCreVO != null){
				 //query parameter
				 Map<String, String> param = speEGCreVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EvaluationGroupDBDAOModifyEGCreUSQL() , param, null);
				 
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
	  * EG테이블에 값을 삭제한다.<br>
	  * 
	  * @param SpeEGCreVO speEGCreVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void removeEGCre(SpeEGCreVO speEGCreVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speEGCreVO != null){
				 //query parameter
				 Map<String, String> param = speEGCreVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EvaluationGroupDBDAORemoveEGCreUSQL() , param, null);
				 
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
	 * EG 데이터를 조회한다.<br>
	 * 
	 * @param SpeEGCreVO speEGCreVO
	 * @return List<SpeEGCreVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<SpeEGCreVO> searchEGData(SpeEGCreVO speEGCreVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SpeEGCreVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(speEGCreVO != null){
				 Map<String, String> mapVO = speEGCreVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupDBDAOSearchEGCreRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpeEGCreVO .class);
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
	 * 저장전 저장할수 있는 데이터 인지 확인한다..<br>
	 * 
	 * @param SpeEGCreVO speEGCreVO
	 * @return List<SpeEGCreVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<SpeEGCreVO> searchEGDataChk(SpeEGCreVO speEGCreVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SpeEGCreVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(speEGCreVO != null){
				 Map<String, String> mapVO = speEGCreVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupDBDAOSearchEGDataChkRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpeEGCreVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
}