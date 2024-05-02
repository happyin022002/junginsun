/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : PlanningDBDAO.java
*@FileTitle      : Planning
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.21
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.21 CSQ USER
* 1.0 Creation
* 2014.07.28 이혜민 [CHM-201431117] qta set up화면에서 add-creation, add-freezing 로직 추가
* 2014.08.14 이혜민 [CHM-201431421] Target VVD Fix시 PF Skd Group MGMT에서 생성된 PF SKD VER과 다른것이 있는지 조회
* 2014.09.25 이혜민 [CHM-201431754] simulation_v를 RHQ, Office 단으로 나눠서 관리
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.planning.planning.basic.PlanningBCImpl;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaByRhqListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaByRhqResultVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaByRhqSimulationVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaLoadRevForSectorAddListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaLoadRevForSectorListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaLoadRevListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaRhqDistributeResultListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaRhqQtaSummaryListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaSetUpHeadOfficeListVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaSetupForIsaSecByHoSummaryVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchRbcLaneQtaListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CsqQtaLodRevVO;
import com.clt.syscommon.common.table.CsqQtaPotnMgmtVO;
import com.clt.syscommon.common.table.CsqQtaRbcVO;
import com.clt.syscommon.common.table.CsqSctrLodRevVO;

/**
 * ALPS PlanningDBDAO <br>
 * - ALPS-Planning system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CSQ USER
 * @see PlanningBCImpl 참조
 * @since J2EE 1.6
 */
public class PlanningDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_CSQ_0020 : [이벤트]<br>
	 * [QTA Set up by Head Office (L/F & G.RPB)]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaLoadRevListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaLoadRevListVO> searchQtaLoadRevList(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaLoadRevListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.put("ofc_cd", account.getOfc_cd()); 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchQtaLoadRevListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaLoadRevListVO .class);
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
	 * ESM_CSQ_0020 : [이벤트]<br>
	 * [QTA Set up by Head Office (L/F & G.RPB)]을 [업데이트] 합니다.<br>
	 * 
	 * @param List<CsqQtaLodRevVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateQtaLoadRev(List<CsqQtaLodRevVO> updModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PlanningDBDAOUpdateQtaLoadRevUSQL(), updModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * ESM_CSQ_0020 : [이벤트]<br>
	 * [QTA_VER_STS]테이블을 [업데이트] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @param String sts
	 * @throws DAOException
	 */
	public void updateQtaVerStatus(ConditionVO conditionVO, SignOnUserAccount account, String sts) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			param.put("ofc_cd", account.getOfc_cd());
			param.put("usr_id", account.getUsr_id());
			param.put("csq_ver_sts_cd", sts);
			velParam.put("csq_ver_sts_cd", sts);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PlanningDBDAOUpdateQtaVerStatusUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * ESM_CSQ_0020 : [이벤트]<br>
	 * [QTA_VER_STS]테이블의 상태를 체크합니다<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @param String sts
	 * @return int
	 * @throws DAOException
	 */
	public int searchQtaVerStatusCnt(ConditionVO conditionVO, SignOnUserAccount account, String sts) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.put("ofc_cd", account.getOfc_cd());
				param.put("csq_ver_sts_cd", sts);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchQtaVerStatusCntRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					cnt = dbRowset.getInt(1);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * ESM_CSQ_0021 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQTASetUpHeadOfficeListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaSetUpHeadOfficeListVO> searchQtaSetUpHeadOfficeList(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaSetUpHeadOfficeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.put("f_ofc_cd", account.getOfc_cd());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchQtaSetUpHeadOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaSetUpHeadOfficeListVO .class);
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
	 * ESM_CSQ_0021 : [이벤트]<br>
	 * [QTA Set-up by Head Office]을 [수정] 합니다.<br>
	 * 
	 * @param List<CsqQtaPotnMgmtVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateQtaSetUpHeadOffice(List<CsqQtaPotnMgmtVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PlanningDBDAOUpdateQtaSetUpHeadOfficeUSQL(), updModels, null);
				
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
	 * ESM_CSQ_0022 : [이벤트]<br>
	 * [QTA Set up by Head Office RHQ Distribute Result]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaRhqDistributeResultListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaRhqDistributeResultListVO> searchQtaRhqDistributeResultList(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaRhqDistributeResultListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.put("f_usr_ofc_cd", account.getOfc_cd());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchQtaByHOResultRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaRhqDistributeResultListVO .class);
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
	 * ESM_CSQ_0023 : [이벤트]<br>
	 * [QTA Set up by Head Office RHQ QTA Summary]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaRhqQtaSummaryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaRhqQtaSummaryListVO> searchQtaRhqQtaSummaryList(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaRhqQtaSummaryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.put("f_usr_ofc_cd", account.getOfc_cd());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchQtaByHOSummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaRhqQtaSummaryListVO .class);
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
	 * ESM_CSQ_0024 : [이벤트]<br>
	 * [QTA Set up by RHQ]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaByRhqListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaByRhqListVO> searchQtaByRhqList(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaByRhqListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.put("ofc_cd", account.getOfc_cd()); 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchQtaByRhqListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaByRhqListVO .class);
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
	 * ESM_CSQ_0024 : [이벤트]<br>
	 * [QTA Set up by RHQ]을 [업데이트] 합니다.<br>
	 * 
	 * @param List<CsqQtaPotnMgmtVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateQtaByRhq(List<CsqQtaPotnMgmtVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PlanningDBDAOUpdateQtaByRhqUSQL(), updModels,null);
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
	 * ESM_CSQ_0025 : [이벤트]<br>
	 * [ QTA Set-up by RHQ_Office Distribute Result]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaByRhqResultVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaByRhqResultVO> searchQtaByRhqResult(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaByRhqResultVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.put("ofc_cd", account.getOfc_cd()); 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchQtaByRhqResultRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaByRhqResultVO .class);
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
	 * ESM_CSQ_0026 : [이벤트]<br>
	 * [QTA Set-up by RHQ _Office QTA Summary]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaByRhqResultVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaByRhqSimulationVO> searchQtaByRhqSimulation(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaByRhqSimulationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.put("ofc_cd", account.getOfc_cd()); 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchQtaByRhqSummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaByRhqSimulationVO .class);
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
	 * ESM_CSQ_0213 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaLoadRevForSectorListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaLoadRevForSectorListVO> searchQtaLoadRevForSectorList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaLoadRevForSectorListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchQtaLoadRevForSectorListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaLoadRevForSectorListVO .class);
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
	 * ESM_CSQ_0213 : [이벤트]<br>
	 * [QTA Set up for IAS Sector by Head Office] 테이블의 상태를 체크합니다<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchQtaLoadRevForSectorListCnt(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchQtaLoadRevForSectorListCntRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnValue = dbRowset.getString("p_cnt") + "|" + dbRowset.getString("c_cnt") + "|" + dbRowset.getString("t_cnt");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * ESM_CSQ_0213 : [Save]<br>
	 * [QTA Set up for IAS Sector by Head Office]을 [저장] 합니다.<br>
	 * 
	 * @param List<CsqSctrLodRevVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateQtaLoadRevForSector(List<CsqSctrLodRevVO> updModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PlanningDBDAOUpdateQtaLoadRevForSectorUSQL(), updModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * ESM_CSQ_0213 : [Creation, Freezing, Add-Creation, Add-Freezing]<br>
	 * [QTA Set up for IAS Sector by Head Office]화면에서 Creation, Freezing, Add-Creation, Add-Freezing 시 Basic data 중 누락된것 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String addFlg
	 * @param String freezingFlg
	 * @throws DAOException
	 */
	public void searchMissingBasicDataList(ConditionVO conditionVO, String addFlg, String freezingFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> mBasicDataList = new ArrayList<String>();
		StringBuffer msg = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("add_flg", addFlg);
				velParam.put("freezing_flg", freezingFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchMissingBasicDataListRSQL(), param, velParam);
			if(dbRowset != null){
				while(dbRowset.next()){
					mBasicDataList.add(dbRowset.getString(1));
				}
				log.debug("===================mBasicDataList.size():"+mBasicDataList.size());
				if(mBasicDataList.size() > 0){
					for ( int i=0; i < mBasicDataList.size(); i++ ) {
						msg.append(mBasicDataList.get(i));
						msg.append("\n");
					}
					throw new EventException(new ErrorHandler("CSQ00008", new String[]{msg.toString()}).getMessage());
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
	 * ESM_CSQ_0213 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office]의 [생성] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createQtaLoadRevForSector(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			conditionVO.setFUsrId(account.getUsr_id());
			
			Map<String, String> mapVO = conditionVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PlanningDBDAOCreateQtaLoadRevForSectorCSQL(), param, velParam);
			if(result == 0){							
				throw new EventException((String)new ErrorHandler("CSQ00003", new String[]{}).getMessage());
			}
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
	 * ESM_CSQ_0213 : [Freezing]<br>
	 * [확정] 데이터를 [생성] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createQtaLoadRevForSectorFreezing(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			conditionVO.setFUsrId(account.getUsr_id());
			
			Map<String, String> mapVO = conditionVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PlanningDBDAOCreateQtaLoadRevForSectorFreezingCSQL(), param, velParam);
			if(result == 0){							
				throw new EventException((String)new ErrorHandler("CSQ00003", new String[]{}).getMessage());
			}
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
	 * ESM_CSQ_0213 : [1Q Transfer]<br>
	 * [CSQ_SCTR_PF_GRP] [1Q] 데이터를 [복사] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createTransferCsqSctrPfGrp(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			conditionVO.setFUsrId(account.getUsr_id());
			Map<String, String> mapVO = conditionVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PlanningDBDAOCreateTransferCsqSctrPfGrpCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_CSQ_0213 : [1Q Transfer]<br>
	 * [CSQ_SCTR_PAIR_MGMT] [1Q] 데이터를 [복사] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createTransferCsqSctrPairMgmt(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			conditionVO.setFUsrId(account.getUsr_id());
			Map<String, String> mapVO = conditionVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PlanningDBDAOCreateTransferCsqSctrPairMgmtCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_CSQ_0213 : [1Q Transfer]<br>
	 * [CSQ_SCTR_LANE_OFC] [1Q] 데이터를 [복사] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createTransferCsqSctrLaneOfc(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			conditionVO.setFUsrId(account.getUsr_id());
			Map<String, String> mapVO = conditionVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PlanningDBDAOCreateTransferCsqSctrLaneOfcCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_CSQ_0213 : [1Q Transfer]<br>
	 * [CSQ_SCTR_PAIR_COST] [1Q] 데이터를 [복사] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createTransferCsqSctrPairCost(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			conditionVO.setFUsrId(account.getUsr_id());
			Map<String, String> mapVO = conditionVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PlanningDBDAOCreateTransferCsqSctrPairCostCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_CSQ_0213 : [1Q Transfer]<br>
	 * [CSQ_SCTR_PERF_IF] [1Q] 데이터를 [복사] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createTransferCsqSctrPerfIf(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			conditionVO.setFUsrId(account.getUsr_id());
			Map<String, String> mapVO = conditionVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PlanningDBDAOCreateTransferCsqSctrPerfIfCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_CSQ_0213 : [1Q Transfer]<br>
	 * [CSQ_SCTR_LOD_REV] [1Q] 데이터를 [복사] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createTransferCsqSctrLodRev(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			conditionVO.setFUsrId(account.getUsr_id());
			Map<String, String> mapVO = conditionVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PlanningDBDAOCreateTransferCsqSctrLodRevCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_CSQ_0214 : [Retrieve]<br>
	 * Retrieve시 Target VVD Fix를 하는데 PF Skd Group MGMT에서 생성된 PF SKD VER과 다른것이 있는지 조회한다. <br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void searchDiffPfVerAddTargetVVD(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> diffPfVerList = new ArrayList<String>();
		StringBuffer msg = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchDiffPfVerAddTargetVVDRSQL(), param, null);
			if(dbRowset != null){
				while(dbRowset.next()){
					diffPfVerList.add(dbRowset.getString(1));
				}
				log.debug("===================diffPfVerList.size():"+diffPfVerList.size());
				if(diffPfVerList.size() > 0){
					for ( int i=0; i < diffPfVerList.size(); i++ ) {
						msg.append(diffPfVerList.get(i));
						msg.append("\n");
					}
					throw new EventException(new ErrorHandler("CSQ00011", new String[]{msg.toString()}).getMessage());
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
	 * ESM_CSQ_0214 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Creation]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaLoadRevForSectorAddListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaLoadRevForSectorAddListVO> searchQtaLoadRevForSectorAddCreationList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaLoadRevForSectorAddListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchQtaLoadRevForSectorAddCreationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaLoadRevForSectorAddListVO .class);
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
	 * ESM_CSQ_0214 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Creatin] : [Target VVD]를  [Fix] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param List<SearchQtaLoadRevForSectorAddListVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createQtaLoadRevForSectorAddTargetVVD(ConditionVO conditionVO, List<SearchQtaLoadRevForSectorAddListVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = conditionVO.getColumnValues();
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanningDBDAOCreateQtaLoadRevForSectorAddTargetVVDCSQL(), updModels,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * ESM_CSQ_0214 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Creation] : [BSA Group CAPA]를  [입력] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param List<SearchQtaLoadRevForSectorAddListVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateQtaLoadRevForSectorAddBSAGroup(ConditionVO conditionVO, List<SearchQtaLoadRevForSectorAddListVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = conditionVO.getColumnValues();
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanningDBDAOUpdateQtaLoadRevForSectorAddBSAGroupUSQL(), updModels,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * ESM_CSQ_0214 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Creation]의 [생성] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param List<SearchQtaLoadRevForSectorAddListVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createQtaLoadRevForSectorAddCreation(ConditionVO conditionVO, List<SearchQtaLoadRevForSectorAddListVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = conditionVO.getColumnValues();
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanningDBDAOCreateQtaLoadRevForSectorAddCreationCSQL(), updModels,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
					if (insCnt[i] == 0)
						throw new EventException(new ErrorHandler("CSQ00003").getMessage());
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
	 * ESM_CSQ_0215 : [Retrieve]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Freezing]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaLoadRevForSectorAddListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaLoadRevForSectorAddListVO> searchQtaLoadRevForSectorAddFreezingList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaLoadRevForSectorAddListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchQtaLoadRevForSectorAddFreezingListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaLoadRevForSectorAddListVO .class);
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
	 * ESM_CSQ_0215 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Freezing] : [확정데이터]를  [삭제] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param List<SearchQtaLoadRevForSectorAddListVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeQtaLoadRevForSectorAddFreezing(ConditionVO conditionVO, List<SearchQtaLoadRevForSectorAddListVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = conditionVO.getColumnValues();
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanningDBDAORemoveQtaLoadRevForSectorAddFreezingDSQL(), updModels,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * ESM_CSQ_0215 : [Creation]<br>
	 * [QTA Set up for IAS Sector by Head Office_Add Freezing] : [확정데이터]를  [생성] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param List<SearchQtaLoadRevForSectorAddListVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createQtaLoadRevForSectorAddFreezing(ConditionVO conditionVO, List<SearchQtaLoadRevForSectorAddListVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = conditionVO.getColumnValues();
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanningDBDAOCreateQtaLoadRevForSectorAddFreezingCSQL(), updModels,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
					if (insCnt[i] == 0)
						throw new EventException(new ErrorHandler("CSQ00003").getMessage());
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
	 * ESM_CSQ_0215 : [Creation]<br>
	 * [CSQ_CFM_TGT_VVD] 를  [삭제] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param List<SearchQtaLoadRevForSectorAddListVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCfmTgtVvdForAddFreezing(ConditionVO conditionVO, List<SearchQtaLoadRevForSectorAddListVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = conditionVO.getColumnValues();
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanningDBDAORemoveCfmTgtVvdForAddFreezingDSQL(), updModels,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * ESM_CSQ_0215 : [Creation]<br>
	 * [CSQ_CFM_TGT_VVD]를  [생성] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param List<SearchQtaLoadRevForSectorAddListVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertCfmTgtVvdForFreezing(ConditionVO conditionVO, List<SearchQtaLoadRevForSectorAddListVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = conditionVO.getColumnValues();
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanningDBDAOInsertCfmTgtVvdForAddFreezingCSQL(), updModels,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
					if (insCnt[i] == 0)
						throw new EventException(new ErrorHandler("CSQ00003").getMessage());
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
	 * ESM_CSQ_0215 : [Creation]<br>
	 * [CSQ_CFM_QTA]를  [생성] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param List<SearchQtaLoadRevForSectorAddListVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertCfmQtaSyncForFreezing(ConditionVO conditionVO, List<SearchQtaLoadRevForSectorAddListVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = conditionVO.getColumnValues();
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanningDBDAOInsertCfmQtaSyncForFreezingCSQL(), updModels,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * ESM_CSQ_0215 : [Creation]<br>
	 * [CSQ_CFM_QTA]를  [삭제] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param List<SearchQtaLoadRevForSectorAddListVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCfmQtaForFreezing(ConditionVO conditionVO, List<SearchQtaLoadRevForSectorAddListVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = conditionVO.getColumnValues();
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanningDBDAORemoveCfmQtaForFreezingDSQL(), updModels,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * ESM_CSQ_0216 : [Retrieve]<br>
	 * [QTA Set Up for IAS Sector by Head Office_Summary]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaSetupForIsaSecByHoSummaryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaSetupForIsaSecByHoSummaryVO> searchQtaSetupForIsaSecByHoSummary(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaSetupForIsaSecByHoSummaryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
	               if (!JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("") && !JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("All")) {
	            	   conditionVO.setFRlaneCd("'" + conditionVO.getFRlaneCd().replaceAll("," ,"','") +"'");
					}
					Map<String, String> mapVO = conditionVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningDBDAOSearchQtaSetupForIsaSecByHoSummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaSetupForIsaSecByHoSummaryVO .class);
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