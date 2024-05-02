/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MqcRangeCMPBGuidelineDBDAO.java
*@FileTitle : CMPB Guideline- MQC Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.22 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.mqcrangecmpbguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltDurationCreationOfficeVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.mqcrangecmpbguideline.basic.MqcRangeCMPBGuidelineBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriCmpbGlineMnVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineMqcRngVO;


/**
 * ALPS MqcRangeCMPBGuidelineDBDAO <br>
 * - ALPS-ProfitabilitySimulation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seung-Jun,Lee
 * @see MqcRangeCMPBGuidelineBCImpl 참조
 * @since J2EE 1.6
 */
public class MqcRangeCMPBGuidelineDBDAO extends DBDAOSupport {

	/**
	 * MQC RNG를 조회한다.(PRI_CMPB_GLINE_MQC_RNG)<br>
	 * 
	 * @param PriCmpbGlineMqcRngVO priCmpbGlineMqcRngVO
	 * @return List<PriCmpbGlineMqcRngVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriCmpbGlineMqcRngVO> searchCmpbGlineMqcRangeList(PriCmpbGlineMqcRngVO priCmpbGlineMqcRngVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriCmpbGlineMqcRngVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGlineMqcRngVO != null){
				Map<String, String> mapVO = priCmpbGlineMqcRngVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MqcRangeCMPBGuidelineDBDAOPriCmpbGlineMqcRngVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriCmpbGlineMqcRngVO .class);
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
	 * MQC RNG를 등록 수정 삭제 한다.(PRI_CMPB_GLINE_MQC_RNG)<br>
	 * 
	 * @param PriCmpbGlineMqcRngVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addMqcRangeCmpbGuideline(PriCmpbGlineMqcRngVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new MqcRangeCMPBGuidelineDBDAOPriCmpbGlineMqcRngVOCSQL(), param, velParam);
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
	 * PRI_CMPB_GLINE_MQC_RNG 테이블을 카피하여 등록한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO vo  
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyMqcRangeCmpbGuideline(RsltDurationCreationOfficeVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new MqcRangeCMPBGuidelineDBDAOPriCmpbGlineMqcRngVOAddCopyCSQL(), param, velParam);
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
	 * PRI_CMPB_GLINE_MQC_RNG 테이블을 갱신한다.<br>
	 * 
	 * @param PriCmpbGlineMqcRngVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyMqcRangeCmpbGuideline(PriCmpbGlineMqcRngVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new MqcRangeCMPBGuidelineDBDAOPriCmpbGlineMqcRngVOUSQL(), param, velParam);
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
	 * PRI_CMPB_GLINE_MQC_RNG 테이블을 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineMqcRngVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeMqcRangeCmpbGuideline(PriCmpbGlineMqcRngVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new MqcRangeCMPBGuidelineDBDAOPriCmpbGlineMqcRngVODSQL(), param, velParam);
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
	 * PRI_CMPB_GLINE_MQC_RNG 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriCmpbGlineMqcRngVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addMqcRangeCmpbGuidelineS(List<PriCmpbGlineMqcRngVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MqcRangeCMPBGuidelineDBDAOPriCmpbGlineMqcRngVOCSQL(), insModels,null);
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
		return insCnt;
	}
	/**
	 * PRI_CMPB_GLINE_MQC_RNG 테이블을 일괄 갱신한다.<br>
	 * 
	 * @param List<PriCmpbGlineMqcRngVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMqcRangeCmpbGuidelineS(List<PriCmpbGlineMqcRngVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MqcRangeCMPBGuidelineDBDAOPriCmpbGlineMqcRngVOUSQL(), updModels,null);
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
		return updCnt;
	}
	
	/**
	 * PRI_CMPB_GLINE_MQC_RNG 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriCmpbGlineMqcRngVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeMqcRangeCmpbGuidelineS(List<PriCmpbGlineMqcRngVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new MqcRangeCMPBGuidelineDBDAOPriCmpbGlineMqcRngVODSQL(), delModels,null);
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
		return delCnt;
	}
	
	
	/**
	 * PRI_CMPB_GLINE_MQC_RNG 테이블을 헤더별로 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineMnVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeMqcRangeCmpbGuideline(PriCmpbGlineMnVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new MqcRangeCMPBGuidelineDBDAOPriCmpbGlineMqcRngVOAllDSQL(), param, velParam);
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
	
}