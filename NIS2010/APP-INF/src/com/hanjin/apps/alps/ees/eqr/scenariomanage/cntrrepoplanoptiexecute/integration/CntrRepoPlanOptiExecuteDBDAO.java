/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanOptiExecuteDBDAO.java
*@FileTitle : run_optimizer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.28 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.basic.CntrRepoPlanOptiExecuteBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.CntrRepoPlanOptiExecuteRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.EesEqr0049ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CntrRepoPlanOptiExecuteDBDAO <br>
 * - ALPS-ScenarioManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Chae Change Ho
 * @see CntrRepoPlanOptiExecuteBCImpl 참조
 * @since J2EE 1.6
 */
public class CntrRepoPlanOptiExecuteDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param EesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @return CntrRepoPlanOptiExecuteRsVO
	 * @exception DAOException
	 */
	public CntrRepoPlanOptiExecuteRsVO searchScenarioList(EesEqr0049ConditionVO eesEqr0049ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CntrRepoPlanOptiExecuteRsVO rsVO = new CntrRepoPlanOptiExecuteRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//if(searchScenarioList != null){
			//	Map<String, String> mapVO = searchScenarioList .getColumnValues();
			//    param.put(arg0, arg1);
			//	param.putAll(mapVO);
			//	velParam.putAll(mapVO);
			//}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOGetScenarioListRSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, searchScenarioList .class);
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param run_sts_cd String
	 * @return CntrRepoPlanOptiExecuteRsVO
	 * @exception DAOException,Exception
	 */
	public CntrRepoPlanOptiExecuteRsVO selectEnginCheck(String run_sts_cd) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		CntrRepoPlanOptiExecuteRsVO rsVO = new CntrRepoPlanOptiExecuteRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			//Map<String, String> mapVO = vo.getColumnValues();
			
			//param.putAll(mapVO);
			//velParam.putAll(mapVO);
			param.put("run_sts_cd",run_sts_cd);
			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOGetEngineCheckRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param EesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException,Exception
	 */
	public CommonRsVO searchMaxPlanID(EesEqr0049ConditionVO EesEqr0049ConditionVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			//Map<String, String> mapVO = vo.getColumnValues();
			
			//param.putAll(mapVO);
			//velParam.putAll(mapVO);
			param.put("scnr_yrwk",EesEqr0049ConditionVO.getScnrYrWk());
			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOGetMaxPlanIDRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @param incl_onh_flg 			String
	 * @param incl_offh_flg			String
	 * @param repo_auto_gen_flg		String
	 * @param sold_flg				String
	 * @param repo_pln_rmk			String
	 * @param user_id				String
	 * @return int
	 * @exception DAOException, Exception
	 */
	public int insertRepoPlanId(EesEqr0049ConditionVO eesEqr0049ConditionVO, String incl_onh_flg , String incl_offh_flg ,String repo_auto_gen_flg ,String sold_flg ,String repo_pln_rmk ,String user_id) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		String fmWk              = eesEqr0049ConditionVO.getStyear()  + eesEqr0049ConditionVO.getStweekly();
		String toWk              = eesEqr0049ConditionVO.getEndyear()  + eesEqr0049ConditionVO.getEndweekly();
		
		try {
			//Map<String, String> mapVO = vo.getColumnValues();
			
			//param.putAll(mapVO);
			//velParam.putAll(mapVO);
			 param.put("repo_plan_id"			, eesEqr0049ConditionVO.getRepo_plan_id());
			 param.put("scnr_id"				, eesEqr0049ConditionVO.getScnrid());
			 param.put("incl_onh_flg" 			, incl_onh_flg);
			 param.put("incl_offh_flg"			, incl_offh_flg);
			 param.put("repo_plan_auto_gen_flg" , repo_auto_gen_flg);
			 param.put("sim_plan_id"			, eesEqr0049ConditionVO.getSim_pln_id());
			 param.put("repo_plan_rmk"			, repo_pln_rmk);
			 param.put("cre_usr_id" 			, user_id);
			 param.put("upd_usr_id"				, user_id);
			 param.put("incl_tpsz_ctnt"         , eesEqr0049ConditionVO.getCntrTpszCd());
			 param.put("eng_run_st_yrwk"        , fmWk);
			 param.put("eng_run_end_yrwk"		, toWk);
			 param.put("sim_pln_sns_cd"			, eesEqr0049ConditionVO.getSensitivity_code());
			 param.put("sim_pln_sns_obj_cd"		, eesEqr0049ConditionVO.getObject_code());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOInsertRepoPlanIdCSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @param weekStdt			String
	 * @param incl_onh_flg		String
	 * @param incl_offh_flg		String
	 * @param repo_auto_gen_flg	String
	 * @param sold_flg			String
	 * @param repo_pln_rmk		String
	 * @param user_id			String
	 * @return int
	 * @exception DAOException,Exception
	 */
	public int insertEqrEngRun(EesEqr0049ConditionVO eesEqr0049ConditionVO, String weekStdt ,String incl_onh_flg , String incl_offh_flg ,String repo_auto_gen_flg ,String sold_flg ,String repo_pln_rmk ,String user_id) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		String repo_pln_id       = eesEqr0049ConditionVO.getRepo_plan_id();
		//String fmWk              = eesEqr0049ConditionVO.getStyear()  + eesEqr0049ConditionVO.getStweekly();
		//String toWk              = eesEqr0049ConditionVO.getEndyear()  + eesEqr0049ConditionVO.getEndweekly();
		String run_id   = repo_pln_id.substring(4,10) + repo_pln_id.substring(11,14);
		String duration = eesEqr0049ConditionVO.getDuration();
	
		try {
			//Map<String, String> mapVO = vo.getColumnValues();
			
			//param.putAll(mapVO);
			//velParam.putAll(mapVO);
			 param.put("run_id_no"			    , run_id);
			 param.put("st_dt"					, weekStdt);
			 param.put("dur_wks" 			    , duration);
			 param.put("onh_flg"				, incl_onh_flg);
			 param.put("offh_flg"				, incl_offh_flg);
			 param.put("sold_flg" 				, sold_flg);
			 param.put("cre_usr_id"			    , user_id);
			 param.put("upd_usr_id"             ,  user_id);
			// param.put("run_desc"	 			, TEST);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOInsertEqrEngRunCSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param repo_plan_id String
	 * @return int
	 * @exception DAOException,Exception
	 */
	public int deleteRepoPlanId(String repo_plan_id) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		
		try {
			//Map<String, String> mapVO = vo.getColumnValues();
			
			//param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			 param.put("repo_plan_id"			, repo_plan_id);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAODeleteRepoPlanIdDSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param run_id String
	 * @return int
	 * @exception DAOException,Exception
	 */
	public int deleteEqrEngRun(String run_id) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		
		try {
			//Map<String, String> mapVO = vo.getColumnValues();
			
			//param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			 param.put("run_id_no", run_id);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAODeleteEqrEngRunDSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @param user_id String
	 * @exception DAOException,Exception
	 */
	@SuppressWarnings("unchecked")
	public void createNewScenarioID1(EesEqr0049ConditionVO eesEqr0049ConditionVO ,String user_id) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map resultMap = null;
		String result = "";
		
		try {
			//Map<String, String> mapVO = vo.getColumnValues();
			//param.putAll(mapVO);
			//velParam.putAll(mapVO);
			 param.put("new_scnr_id" , eesEqr0049ConditionVO.getScnrid());
			 param.put("old_scnr_id", eesEqr0049ConditionVO.getOld_scnr_id());
			 param.put("user_id", user_id);
			 param.put("run_id_no", eesEqr0049ConditionVO.getRun_id_no());
			 
			 log.debug ("=====>"  + eesEqr0049ConditionVO.getScnrid());
			 log.debug ("=====>"  + eesEqr0049ConditionVO.getOld_scnr_id());
			
			//SQLExecuter sqlExe = new SQLExecuter("");
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOScenarioCopyPrcCSQL(), param, velParam);
			//result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOScenarioCopyPrcCSQL(), param, velParam);
			result = (String) resultMap.get("out_pram");
			if("99".equals(result))
							throw new DAOException("Fail to update SQL");
	//		if(result == Statement.EXECUTE_FAILED)
	//				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @param user_id String
	 * @return int
	 * @exception DAOException,Exception
	 */
	public int createEqrIfRepoPlanPrcExecute(EesEqr0049ConditionVO eesEqr0049ConditionVO ,String user_id) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		//Map resultMap = null;
		//String resultNo = null;
		
		String scnr_id           = eesEqr0049ConditionVO.getScnrid();
		String old_scnr_id       = eesEqr0049ConditionVO.getOld_scnr_id();
		String repo_plan_id      = eesEqr0049ConditionVO.getRepo_plan_id();
		String seq               = repo_plan_id.substring(11,14);		
		String fmWk              = eesEqr0049ConditionVO.getStyear()  + eesEqr0049ConditionVO.getStweekly();
		String toWk              = eesEqr0049ConditionVO.getEndyear() + eesEqr0049ConditionVO.getEndweekly();
		String yearMon           = eesEqr0049ConditionVO.getStyear()  + eesEqr0049ConditionVO.getStmonth();
		String run_id            = repo_plan_id.substring(4,10) + seq;
		String repo_pln_rmk_flg	 = eesEqr0049ConditionVO.getRepo_pln_rmk();
		
		int result = 0;
		
		try {
			log.debug("=====scnr_id===" + scnr_id);
			log.debug("=====old_scnr_id===" + old_scnr_id);
			param.put("sncr_id" , scnr_id);
			param.put("old_scnr_id", old_scnr_id);
			param.put("repo_plan_id", repo_plan_id);
			param.put("fm_wk", fmWk);
			param.put("to_wk", toWk);
			param.put("year_month", yearMon);
			param.put("repo_pln_rmk_flg",repo_pln_rmk_flg);
			param.put("run_id_no", run_id);
			param.put("user_id", user_id);
		 	if(repo_pln_rmk_flg.equals("V")){
				 new SQLExecuter("").executeSP((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOEqrVlsdPlanPrcRSQL(), param, velParam);
			} else if(repo_pln_rmk_flg.equals("O")){  //OnewayOffer 시 사용 
				 new SQLExecuter("").executeSP((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOEqrMainPlanPrcRSQL(), param, velParam);
			} else if(repo_pln_rmk_flg.equals("R")){ // vesel plan
				 new SQLExecuter("").executeSP((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOEqrMainPlanPrcRSQL(), param, velParam);
			} else if(repo_pln_rmk_flg.equals("S")){ // 
				 new SQLExecuter("").executeSP((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOEqrMainPlanPrcRSQL(), param, velParam);
			}
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param run_id_no String
	 * @return int
	 * @exception DAOException,Exception
	 */
	public int updateEqrEngOutPut(String run_id_no) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;	
		try {
		
			 param.put("run_id_no" , run_id_no);
			 	
			 SQLExecuter sqlExe = new SQLExecuter("");
			 result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOUpdateEqrEngOutPutRSQL(), param, velParam);
			 if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update SQL");
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param run_id_no String
	 * @param cancel String
	 * @return int
	 * @exception DAOException,Exception
	 */
	public int updateEqrEngCancel(String run_id_no ,String cancel) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;	
		try {
			 param.put("run_id_no" , run_id_no);
			 param.put("cancel_flg", cancel);
			 	
			 SQLExecuter sqlExe = new SQLExecuter("");
			 result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOUpdateEqrEngCancelUSQL(), param, velParam);
			 if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update SQL");
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param run_id_no	String
	 * @param cancel	String
	 * @return CommonRsVO
	 * @exception DAOException,Exception
	 */
	public CommonRsVO searchMonitor(String run_id_no ,String cancel) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			 param.put("run_id_no" , run_id_no);
			 param.put("cancel_flg", cancel);
			 	
			 SQLExecuter sqlExe = new SQLExecuter("");
			 dbRowset = sqlExe.executeQuery((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOSearchMonitorRSQL(), param, velParam);
			 rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param run_id_no		String
	 * @param repo_pln_id	String
	 * @param user_id		String
	 * @exception DAOException,Exception
	 */
	@SuppressWarnings("unchecked")
	public void createEqrEngOutPutRepoPrc(String run_id_no ,String repo_pln_id ,String user_id) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map resultMap = null;
		String result = "";	
		
		try {
			 param.put("run_id_no" , run_id_no);
			 param.put("repo_pln_id", repo_pln_id);
			 param.put("user_id", user_id);
			 	
			 resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOCreateEqrEngOutPutRepoPrcCSQL(), param, velParam);
			 result = (String) resultMap.get("out3");
			 if("99".equals(result))
							throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
	 * [ EES_EQR_0127 : Scenario Copy Monitoring ]<br>
	 * 
	 * @param scnr_id String
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO scnrCopysearchMonitor (String scnr_id) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scnr_id != null){			
				param.put("scnr_id", scnr_id);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanOptiExecuteDBDAOScnrCopysearchMonitorRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
}
