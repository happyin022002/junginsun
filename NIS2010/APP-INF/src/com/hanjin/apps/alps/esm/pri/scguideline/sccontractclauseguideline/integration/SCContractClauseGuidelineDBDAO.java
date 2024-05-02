/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractClauseGuidelineDBDAO.java
*@FileTitle : SC Guideline Contract Clause
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.28 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.sccontractclauseguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.scguideline.sccontractclauseguideline.basic.SCContractClauseGuidelineBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriSgCtrtCluzDtlVO;
import com.hanjin.syscommon.common.table.PriSgCtrtCluzVO;
import com.hanjin.syscommon.common.table.PriSgMnVO;


/**
 * NIS2010 SCContractClauseGuidelineDBDAO <br>
 * - NIS2010-SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seung Jun Lee
 * @see SCContractClauseGuidelineBCImpl 참조
 * @since J2EE 1.4
 */
public class SCContractClauseGuidelineDBDAO extends DBDAOSupport {

	/**
	 * contract clause 를 조회한다<br>
	 * 
	 * @param PriSgCtrtCluzVO priSgCtrtCluzVO
	 * @return List<PriSgCtrtCluzVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriSgCtrtCluzVO> searchContractClauseList(PriSgCtrtCluzVO priSgCtrtCluzVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSgCtrtCluzVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSgCtrtCluzVO != null){
				Map<String, String> mapVO = priSgCtrtCluzVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgCtrtCluzVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * contract clause detail을 조회한다<br>
	 * 
	 * @param PriSgCtrtCluzVO priSgCtrtCluzVO
	 * @return List<PriSgCtrtCluzDtlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriSgCtrtCluzDtlVO> searchContractClauseDetailList(PriSgCtrtCluzVO priSgCtrtCluzVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSgCtrtCluzDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSgCtrtCluzVO != null){
				Map<String, String> mapVO = priSgCtrtCluzVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzDtlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgCtrtCluzDtlVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 단건의 Contrac Clause 데이터를 생성한다.(pri_sg_ctrt_cluz)<br>
	 * 
	 * @param PriSgCtrtCluzVO priSgCtrtCluzVO
	 * @exception DAOException
	 */
	public void addContractClause(PriSgCtrtCluzVO priSgCtrtCluzVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSgCtrtCluzVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 단건의 Contrac Clause 데이터를 갱신한다.(pri_sg_ctrt_cluz)<br>
	 * 
	 * @param PriSgCtrtCluzVO priSgCtrtCluzVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyContractClause(PriSgCtrtCluzVO priSgCtrtCluzVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgCtrtCluzVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 단건의 Contrac Clause 데이터를 삭제한다.(pri_sg_ctrt_cluz)<br>
	 * 
	 * @param PriSgCtrtCluzVO priSgCtrtCluzVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeContractClause(PriSgCtrtCluzVO priSgCtrtCluzVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgCtrtCluzVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * 헤더별 Contrac Clause 데이터를 삭제한다.(pri_sg_ctrt_cluz)<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeContractClauseAll(PriSgMnVO priSgMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgMnVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzVO2DSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	

	/**
	 * 다건의 Contrac Clause 데이터를 일괄적으로 생성한다.(pri_sg_ctrt_cluz)<br>
	 * 
	 * @param List<PriSgCtrtCluzVO> insModels
	 * @exception DAOException
	 */
	public void addContractClause(List<PriSgCtrtCluzVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 다건의 Contrac Clause 데이터를 일괄적으로 갱신한다.(pri_sg_ctrt_cluz)<br>
	 * 
	 * @param List<PriSgCtrtCluzVO> updModels
	 * @exception DAOException
	 */
	public void modifyContractClause(List<PriSgCtrtCluzVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 다건의 Contrac Clause 데이터를 일괄적으로 삭제한다.(pri_sg_ctrt_cluz)<br>
	 * 
	 * @param List<PriSgCtrtCluzVO> delModels
	 * @exception DAOException
	 */
	public void removeContractClause(List<PriSgCtrtCluzVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 단건의 Contrac Clause 데이터를 생성한다.(pri_sg_ctrt_cluz_dtl)<br>
	 * 
	 * @param PriSgCtrtCluzDtlVO priSgCtrtCluzDtlVO
	 * @exception DAOException
	 */
	public void addContractClauseDetail(PriSgCtrtCluzDtlVO priSgCtrtCluzDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSgCtrtCluzDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzDtlVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 단건의 Contrac Clause 데이터를 갱신한다.(pri_sg_ctrt_cluz_dtl)<br>
	 * 
	 * @param PriSgCtrtCluzDtlVO priSgCtrtCluzDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyContractClauseDetail(PriSgCtrtCluzDtlVO priSgCtrtCluzDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgCtrtCluzDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzDtlVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 단건의 Contrac Clause 데이터를 삭제한다.(pri_sg_ctrt_cluz_dtl)<br>
	 * 
	 * @param PriSgCtrtCluzDtlVO priSgCtrtCluzDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeContractClauseDetail(PriSgCtrtCluzDtlVO priSgCtrtCluzDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgCtrtCluzDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzDtlVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * 타이틀 별 모든 건의 Contrac Clause 데이터를 삭제한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeContractClauseDetailAll(PriSgMnVO priSgMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgMnVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");       
			result = sqlExe.executeUpdate((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzDtlVO2DSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * 타이틀 별 본문별 모든 건의 Contrac Clause 데이터를 삭제한다.<br>
	 * 
	 * @param PriSgCtrtCluzVO priSgCtrtCluzVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeContractClauseDetailAll(PriSgCtrtCluzVO priSgCtrtCluzVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgCtrtCluzVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");       
			result = sqlExe.executeUpdate((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzDtlVO2DSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	

	/**
	 * 다건의 Contrac Clause 데이터를 일괄적으로 생성한다.(pri_sg_ctrt_cluz_dtl)<br>
	 * 
	 * @param List<PriSgCtrtCluzDtlVO> insModels
	 * @exception DAOException
	 */
	public void addContractClauseDetail(List<PriSgCtrtCluzDtlVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzDtlVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 다건의 Contrac Clause 데이터를 일괄적으로 갱신한다.(pri_sg_ctrt_cluz_dtl)<br>
	 * 
	 * @param List<PriSgCtrtCluzDtlVO> updModels
	 * @exception DAOException
	 */
	public void modifyContractClauseDetail(List<PriSgCtrtCluzDtlVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzDtlVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 다건의 Contrac Clause 데이터를 일괄적으로 삭제한다.(pri_sg_ctrt_cluz_dtl)<br>
	 * 
	 * @param List<PriSgCtrtCluzDtlVO> delModels
	 * @exception DAOException
	 */
	public void removeContractClauseDetail(List<PriSgCtrtCluzDtlVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){						   	
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractClauseGuidelineDBDAOPriSgCtrtCluzDtlVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
}
