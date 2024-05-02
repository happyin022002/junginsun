/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QualitativeEvaluationDBDAO.java
*@FileTitle : Qualitative Evaluation Sheet Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.basic.QualitativeEvaluationBCImpl;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.vo.SpeSpQualEvVO;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration.QualitativeEvaluationCreationDBDAOSearchQECreCSQL;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration.QualitativeEvaluationCreationDBDAOSearchQECreDSQL;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration.QualitativeEvaluationCreationDBDAOSearchQECreRSQL;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.vo.SpeQECreVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS QualitativeEvaluationDBDAO <br>
 * - ALPS-PerformanceManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see QualitativeEvaluationBCImpl 참조
 * @since J2EE 1.6
 */
public class QualitativeEvaluationDBDAO extends DBDAOSupport {

	/**
	  * QE 테이블에 값을 입력한다.<br>
	  * 
	  * @param SpeQECreVO speQECreVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void addQECre(SpeQECreVO speQECreVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speQECreVO != null){
				 //query parameter
				 Map<String, String> param = speQECreVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new QualitativeEvaluationCreationDBDAOSearchQECreCSQL() , param, null);
				 
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
	  * QE 테이블에 값을 삭제한다.<br>
	  * 
	  * @param SpeQECreVO speQECreVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void removeQECre(SpeQECreVO speQECreVO)throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speQECreVO != null){
				 //query parameter
				 Map<String, String> param = speQECreVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new QualitativeEvaluationCreationDBDAOSearchQECreDSQL(), param, null);
				 
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
	 * QE 데이터를 조회한다.<br>
	 * 
	 * @param SpeQECreVO speQECreVO
	 * @return List<SpeQGCreVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<SpeQECreVO> searchQEData(SpeQECreVO speQECreVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SpeQECreVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(speQECreVO != null){
				 Map<String, String> mapVO = speQECreVO.getColumnValues();				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QualitativeEvaluationCreationDBDAOSearchQECreRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpeQECreVO .class);
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
	 * Qualitative Evaluation 저장된 데이터인지 확인한다.
	 * @param SpeSpQualEvVO speSpQualEvVO
	 * @return String
	 * @throws EventException
	 */
	public String  searchQualitativeEvaluationChk(SpeSpQualEvVO speSpQualEvVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String isFlag = "0";

		try{
			if(speSpQualEvVO != null){
				Map<String, String> mapVO = speSpQualEvVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QualitativeEvaluationDBDAOSearchQualitativeEvaluationChkRSQL(), param, velParam);
			 if(dbRowset.next()){
				 isFlag = dbRowset.getString("isFlag");
			 }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isFlag;
	}

	/**
	 * Qualitative Evaluation 저장후 데이터 목록 조회
	 * @param SpeSpQualEvVO speSpQualEvVO
	 * @return List<SpeSpQualEvVO> 
	 * @throws EventException
	 */
	public List<SpeSpQualEvVO> searchQualitativeEvaluation(SpeSpQualEvVO speSpQualEvVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpeSpQualEvVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(speSpQualEvVO != null){
				Map<String, String> mapVO = speSpQualEvVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QualitativeEvaluationDBDAOSearchQualitativeEvaluationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpeSpQualEvVO .class);
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
	 * S/P Qualitative Evaulation Inquiry 조회
	 * @param SpeSpQualEvVO speSpQualEvVO
	 * @return List<SpeSpQualEvVO> 
	 * @throws EventException
	 */
	public List<SpeSpQualEvVO> searchSPQualitativeEv(SpeSpQualEvVO speSpQualEvVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpeSpQualEvVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(speSpQualEvVO != null){
				Map<String, String> mapVO = speSpQualEvVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QualitativeEvaluationDBDAOSearchSPQualitativeEvRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpeSpQualEvVO .class);
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
	 * Qualitative Evaluation 저장전 데이터 목록 조회
	 * @param SpeSpQualEvVO speSpQualEvVO
	 * @return List<SpeSpQualEvVO>
	 * @throws EventException
	 */
	public List<SpeSpQualEvVO> searchQualitativeEvaluationOrg(SpeSpQualEvVO speSpQualEvVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpeSpQualEvVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(speSpQualEvVO != null){
				Map<String, String> mapVO = speSpQualEvVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QualitativeEvaluationCreationDBDAOSearchQualitativeEvaluationOrgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpeSpQualEvVO .class);
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
	 * Qualitative Evaluation 을 수정한다.<br>
	 * @param SpeSpQualEvVO speSpQualEvVO
	 */
	public void multiQualitativeEvaluation(SpeSpQualEvVO speSpQualEvVO) throws DAOException {
		try {
			
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speSpQualEvVO != null){
				 //query parameter
				 Map<String, String> param = speSpQualEvVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new QualitativeEvaluationDBDAOMultiQualitativeEvaluationUSQL() , param, null);
				 
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
	 * Qualitative Evaluation 신규 입력시 정성평가 내용을 일괄 저장한다.<br>
	 * @param SpeSpQualEvVO speSpQualEvVO
	 */
	public void addQualitativeEvaluation(SpeSpQualEvVO speSpQualEvVO) throws DAOException {
		try {
			
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(speSpQualEvVO != null){
				 //query parameter
				 Map<String, String> param = speSpQualEvVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new QualitativeEvaluationCreationDBDAOAddQualitativeEvaluationCSQL() , param, null);
				 
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
	 * Qualitative Evaluation 저장된 후 score 의 평균값을 리턴한다.
	 * @param SpeSpQualEvVO speSpQualEvVO
	 * @return String
	 * @throws EventException
	 */
	public String  searchQualitativeEvaluationAvgScore(SpeSpQualEvVO speSpQualEvVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String avgScore = "0";

		try{
			if(speSpQualEvVO != null){
				Map<String, String> mapVO = speSpQualEvVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QualitativeEvaluationCreationDBDAOsearchQualitativeEvaluationAvgScoreRSQL(), param, velParam);
			 if(dbRowset.next()){
				 avgScore = dbRowset.getString("avgScore");
			 }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return avgScore;
	}	
}