/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : SpclPlanningDBDAO.java
*@FileTitle      : Planning
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.08
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.08 이혜민
* 1.0 Creation
* 2015.11.27 김용습 [CHM-201538495] [CSR 전환건] Basic CMCB 화면 보완 (Row Add 기능 추가)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.basic.SpclPlanningBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.SqmSpclLaneOfcCostVO;
import com.hanjin.syscommon.common.table.SqmSpclLodRevVO;

/**
 * ALPS SpclSpclPlanningDBDAO <br>
 * - ALPS-Planning system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 이혜민
 * @see SpclPlanningBCImpl 참조
 * @since J2EE 1.6
 */
public class SpclPlanningDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_SQM_0501 : [SEARCH]<br>
	 * [KPI Input by Head Office]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SqmSpclLodRevVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SqmSpclLodRevVO> searchKpiInputbyHeadOffice(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SqmSpclLodRevVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new SpclPlanningDBDAOSearchKpiInputbyHeadOfficeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SqmSpclLodRevVO .class);
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
	 * ESM_SQM_0501 : [SEARCH]<br>
	 * [KPI Input by Head Office]을 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchKpiInputbyHeadOfficeCnt(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dataCnt = "0";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new SpclPlanningDBDAOSearchKpiInputbyHeadOfficeCntRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					dataCnt = dbRowset.getString(1);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dataCnt;
	}
	
	/**
	 * ESM_SQM_0501 : [MULTI01]<br>
	 * [KPI Input by Head Office]을 [생성] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String createKpiInputbyHeadOffice(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		String istCnt = null;
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new SpclPlanningDBDAOCreateKpiInputbyHeadOfficeCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			istCnt = Integer.toString(result); 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return istCnt;
	}
	
	/**
	 * ESM_SQM_0501 : [MULTI]<br>
	 * [KPI Input by Head Office]을 [Insert] 합니다.
	 * 
	 * @param List<SqmSpclLodRevVO> insertVoList
	 * @throws DAOException
	 */
	public void insertKpiInputbyHeadOffice(List<SqmSpclLodRevVO> insertVoList) throws DAOException,Exception {
		int istCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(insertVoList.size() > 0){
				istCnt = sqlExe.executeBatch((ISQLTemplate)new SpclPlanningDBDAOAddKpiInputbyHeadOfficeCSQL(), insertVoList, null, null);
				for(int i = 0; i < istCnt.length; i++){
					if(istCnt[i]== Statement.EXECUTE_FAILED)
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
	}
	
	/**
	 * ESM_SQM_0501 : [MULTI]<br>
	 * [KPI Input by Head Office]를 [Update] 합니다.
	 * 
	 * @param List<SqmSpclLodRevVO> updateVoList
	 * @throws DAOException
	 */
	public void updateKpiInputbyHeadOffice(List<SqmSpclLodRevVO> updateVoList) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpclPlanningDBDAOUpdateKpiInputbyHeadOfficeUSQL(), updateVoList, null, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
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
	 * ESM_SQM_0502 : [SEARCH]<br>
	 * [Basic CMCB]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SqmSpclLaneOfcCostVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SqmSpclLaneOfcCostVO> searchBasicCmcb(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SqmSpclLaneOfcCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new SpclPlanningDBDAOSearchBasicCmcbRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SqmSpclLaneOfcCostVO .class);
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
	 * ESM_SQM_0502 : [SEARCH]<br>
	 * [Basic CMCB]을 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBasicCmcbCnt(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dataCnt = "0";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new SpclPlanningDBDAOSearchBasicCmcbCntRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					dataCnt = dbRowset.getString(1);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dataCnt;
	}
	
	/**
	 * ESM_SQM_0502 : [MULTI01]<br>
	 * [Basic CMCB]을 [생성] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String createBasicCmcb(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		String istCnt = null;
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new SpclPlanningDBDAOCreateBasicCmcbCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			istCnt = Integer.toString(result); 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return istCnt;
	}
	
	/**
	 * ESM_SQM_0502 : [MULTI]<br>
	 * [Basic CMCB]를 [Update] 합니다.
	 * 
	 * @param List<SqmSpclLaneOfcCostVO> updateVoList
	 * @throws DAOException
	 */
	public void updateBasicCmcb(List<SqmSpclLaneOfcCostVO> updateVoList) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpclPlanningDBDAOUpdateBasicCmcbUSQL(), updateVoList, null, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
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
	 * ESM_SQM_0502 : [MULTI]<br>
	 * [KPI Input by Head Office]을 [Insert] 합니다.
	 * 
	 * @param List<SqmSpclLodRevVO> insertVoList
	 * @throws DAOException
	 */
	public void insertBasicCmcb(List<SqmSpclLaneOfcCostVO> insertVoList) throws DAOException,Exception {
		int istCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(insertVoList.size() > 0){
				istCnt = sqlExe.executeBatch((ISQLTemplate)new SpclPlanningDBDAOInsertBasicCmcbCSQL(), insertVoList, null, null);
				for(int i = 0; i < istCnt.length; i++){
					if(istCnt[i]== Statement.EXECUTE_FAILED)
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
	}
	
	/**
	 * ESM_SQM_0503 : [MULTI]<br>
	 * [Basic CMCB New Lane]을 [생성] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String createBasicCmcbNewLane(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		String istCnt = null;
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new SpclPlanningDBDAOCreateBasicCmcbNewLaneCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			istCnt = Integer.toString(result); 

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return istCnt;
	}
	
	
}