/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupStrategicImportanceManageDBDAO.java
*@FileTitle : SI Analysis Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 권정화
*@LastVersion : 1.0
* 2009.07.29 권정화
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.basic.EvaluationGroupStrategicImportanceManageBCImpl;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.vo.SearchEvaluationGroupStrategicImportanceManageListVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.vo.SearchInputListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SpeEvGrpStrgImptRsltVO;

/**
 * ALPS EvaluationGroupStrategicImportanceManageDBDAO <br>
 * - ALPS-EvaluationGroupTargetManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kown Jeong hwa
 * @see EvaluationGroupStrategicImportanceManageBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class EvaluationGroupStrategicImportanceManageDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchInputListVO searchInputListVO
	 * @return List<SearchEvaluationGroupStrategicImportanceManageListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEvaluationGroupStrategicImportanceManageListVO> searchEvaluationGroupStrategicImportanceManageList(SearchInputListVO searchInputListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEvaluationGroupStrategicImportanceManageListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchInputListVO != null){
				Map<String, String> mapVO = searchInputListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupStrategicImportanceManageDBDAOSearchEvaluationGroupStrategicImportanceManageListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEvaluationGroupStrategicImportanceManageListVO .class);
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
	 * @param List<SpeEvGrpStrgImptRsltVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addMultiSpeEvGrpStrgImptRslt(List<SpeEvGrpStrgImptRsltVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltCSQL(), insModels,null);
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
	 * @param List<SpeEvGrpStrgImptRsltVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMultiSpeEvGrpStrgImptRslt(List<SpeEvGrpStrgImptRsltVO> updModels) throws DAOException,Exception {
		int updCnt[] = null; 
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltUSQL(), updModels,null);
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
	 * @param List<SpeEvGrpStrgImptRsltVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeMultiSpeEvGrpStrgImptRslt(List<SpeEvGrpStrgImptRsltVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltDSQL(), delModels,null);
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
	
	
		
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpeEvGrpStrgImptRsltVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	
	public int[] modifySpeRltSegmRslt(List<SpeEvGrpStrgImptRsltVO> updModels) throws DAOException,Exception {
		int updCnt[] = null; 
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupStrategicImportanceManageDBDAOModifySpeRltSegmRsltCSQL(), updModels,null);
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
	
	
}