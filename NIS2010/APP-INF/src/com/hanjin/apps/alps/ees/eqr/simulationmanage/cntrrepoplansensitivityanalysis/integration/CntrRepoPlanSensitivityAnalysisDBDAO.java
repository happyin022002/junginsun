/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisDBDAO.java
*@FileTitle : 민감도 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.18 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.basic.CntrRepoPlanSensitivityAnalysisBCImpl;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0065MultiVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0065ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0088ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CntrRepoPlanSensitivityAnalysisDBDAO <br>
 * - ALPS-SimulationManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Chae Change Ho
 * @see CntrRepoPlanSensitivityAnalysisBCImpl 참조
 * @since J2EE 1.6
 */
public class CntrRepoPlanSensitivityAnalysisDBDAO extends DBDAOSupport {
	 
	/**
	 * 민감도 분석.
	 * @param  conditionVO EesEqr0065ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchPlanSensitivity(EesEqr0065ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = new DBRowSet();
		CommonRsVO returnVO = new CommonRsVO();
						
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repo_pln_id =  Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
		//  String scnr_id = conditionVO.getScnrid();
		String arrFmEccCd = Utils.convertStr(conditionVO.getFmecccd());
		String arrToEccCd = Utils.convertStr(conditionVO.getToecccd());
		String inTypeCntrTpsz = Utils.convertStr(conditionVO.getCntrtpszcd());
		String fmType     = conditionVO.getFmtype();
		String toType     = conditionVO.getTotype();
		String fmStartPrd = conditionVO.getFmstartyear()+ conditionVO.getFmstartweek();
		String fmEndPrd   = conditionVO.getFmendyear() + conditionVO.getFmendweek();
		String toStartPrd = conditionVO.getTostartyear() + conditionVO.getTostartweek();
		String toEndPrd   = conditionVO.getToendyear()   + conditionVO.getToendweek();

		//   String tpszCd     = conditionVO.getCntrtpszcd();	
		//   ArrayList arrCntrTpsz = (ArrayList) Utils.replaceStrToList(conditionVO.getCntrtpszcd());
		//   String[]  arrTpszCd  = tpszCd.split(",");
		log.debug("====getSens===" +conditionVO.getSens() );
		log.debug("====getCostobj()===" +conditionVO.getCostobj() );
		try {
			param.put("repo_pln_id", repo_pln_id);
			param.put("fmstartprd", fmStartPrd);
			param.put("fmendprd", fmEndPrd);
			param.put("tostartprd", toStartPrd);
			param.put("toendprd", toEndPrd);
			param.put("sens_typ", conditionVO.getSenstext());
			param.put("obj_txt", conditionVO.getObjecttext());
			param.put("costobj", conditionVO.getCostobj());
			param.put("limitObj", conditionVO.getLimitobj());
			velParam.put("arrtpszcd", inTypeCntrTpsz);
			velParam.put("fmecccd", arrFmEccCd);
			velParam.put("fmtype", fmType);
			velParam.put("arrfmecccd", arrFmEccCd);
			velParam.put("totype", toType);
			velParam.put("toecccd", arrToEccCd);
			velParam.put("arrtoecccd", arrToEccCd);
			velParam.put("costobj", conditionVO.getCostobj());
			velParam.put("sens_typ", conditionVO.getSenstext());
			velParam.put("obj_txt", conditionVO.getObjecttext());
			velParam.put("limitObj", conditionVO.getLimitobj());
			//Sensitivity의 Cost 시작
			if(conditionVO.getSens().equals("0")){
				//Load/Dicharge
				if(conditionVO.getCostobj().equals("L") || conditionVO.getCostobj().equals("D")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityRSQL(), param, velParam);
					//Rail/Water/Truck   
				}else if (conditionVO.getCostobj().equals("R") || conditionVO.getCostobj().equals("W") || conditionVO.getCostobj().equals("T")) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity01RSQL(), param, velParam);
					//On-Hire/Off-Hire  
				}else if (conditionVO.getCostobj().equals("O") || conditionVO.getCostobj().equals("F") ) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity02RSQL(), param, velParam);
				}else if (conditionVO.getCostobj().equals("P")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity03RSQL(), param, velParam);
				}else if (conditionVO.getCostobj().equals("S")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity04RSQL(), param, velParam);
				}
				// Sensitivity의 Cost 끝  
				//Sensitivity의 limit 시작
			} else if  (conditionVO.getSens().equals("1")){ 
				if(conditionVO.getLimitobj().equals("L") || conditionVO.getLimitobj().equals("D")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityLimitLoadDischargeRSQL(), param, velParam);  
				}else if (conditionVO.getLimitobj().equals("R") || conditionVO.getLimitobj().equals("W") || conditionVO.getLimitobj().equals("T")) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityLimit01RSQL(), param, velParam);
				}else if (conditionVO.getLimitobj().equals("C")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityLimit02RSQL(), param, velParam);
				}else if (conditionVO.getLimitobj().equals("X") || conditionVO.getLimitobj().equals("N")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityLimit03RSQL(), param, velParam);
				}else if (conditionVO.getLimitobj().equals("O") || conditionVO.getLimitobj().equals("F")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityLimit04RSQL(), param, velParam);
				}else if (conditionVO.getLimitobj().equals("K") ){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityLimit05RSQL(), param, velParam);
				}
			}
			//Sensitivity의 limit 끝
			returnVO.setDbRowset(dbRowset);
		   
		   
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	/**
	 * 민감도 분석.
	 * @param mutiVO EesEqr0065MultiVO[]
	 * @param conditonVO EesEqr0065ConditionVO
	 * @param old_sncr_id String
	 * @exception DAOException
	 */
	public void modifyPlanSensitivity(EesEqr0065MultiVO[] mutiVO, EesEqr0065ConditionVO conditonVO, String old_sncr_id) throws DAOException {
		int result = 0;
		int residual_Capa_H     = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		EesEqr0065MultiVO vo = null;

		try{
			for(int i = 0 ; i < mutiVO.length ; i++){
				vo = (EesEqr0065MultiVO)mutiVO[i];
				if (vo.getSensity().equals("Cost")) {
					if (vo.getObj().equals("Load")){ 
						if (vo.getTsType().substring(1,2).equals("2")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_loc" , vo.getFmLoc());
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityEccMst_20QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");					
						}
						if (vo.getTsType().substring(1,2).equals("4")|| vo.getTsType().substring(1,2).equals("5")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_loc" , vo.getFmLoc());
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityEccMst_40QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");					
						}
						if (vo.getTsType().substring(1,2).equals("7")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_loc" , vo.getFmLoc());
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityEccMst_45QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");					
						}
					}
				
					if (vo.getObj().equals("Discharge")){   // Discharge  -- 시작
						if (vo.getTsType().substring(1,2).equals("2")){					
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_loc" , vo.getToLoc());
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityEccMst_20QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");					
						}
						if (vo.getTsType().substring(1,2).equals("4") || vo.getTsType().substring(1,2).equals("5") ){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_loc" , vo.getToLoc());
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityEccMst_40QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("7")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_loc" , vo.getToLoc());
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityEccMst_45QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");					
						}
					}
					if (vo.getObj().equals("Rail")){   // Rail  -- 시작
						if (vo.getTsType().substring(1,2).equals("2")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd", vo.getToLoc());
							param.put("trsp_mod_cd", "R");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_20QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("4") || vo.getTsType().substring(1,2).equals("5")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd", vo.getToLoc());
							param.put("trsp_mod_cd", "R");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_40QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("7")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd", vo.getToLoc());
							param.put("trsp_mod_cd", "R");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_45QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}                 // Rail 끝 
					}
					if (vo.getObj().equals("Water")){   // Water  -- 시작
						if (vo.getTsType().substring(1,2).equals("2")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd", vo.getToLoc());
							param.put("trsp_mod_cd", "W");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_20QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("4") || vo.getTsType().substring(1,2).equals("5")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd", vo.getToLoc());
							param.put("trsp_mod_cd", "W");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_40QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("7")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd", vo.getToLoc());
							param.put("trsp_mod_cd", "W");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_45QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}                 // Water 끝 
					}
					if (vo.getObj().equals("Truck")){   // Truck  -- 시작
						if (vo.getTsType().substring(1,2).equals("2")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd", vo.getToLoc());
							param.put("trsp_mod_cd", "T");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_20QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("4") || vo.getTsType().substring(1,2).equals("5")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd", vo.getToLoc());
							param.put("trsp_mod_cd", "T");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_40QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("7")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd", vo.getToLoc());
							param.put("trsp_mod_cd", "T");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_45QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}                 // Truck 끝 
					}
					if (vo.getObj().equals("Storage")){   // Storage  -- 시작
						if (vo.getTsType().substring(1,2).equals("2")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("ecc_cd" , vo.getFmLoc());
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityEccMst_str20QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("4") || vo.getTsType().substring(1,2).equals("5")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("ecc_cd" , vo.getFmLoc());
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityEccMst_str40QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("7")){
							velParam.put("curr_cost" ,vo.getCurrCost());
							param.put("user_id", conditonVO.getUserId());
							param.put("ecc_cd" , vo.getFmLoc());
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityEccMst_str45QueryUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}// Storage 끝 
					}      
				}else {
					if (vo.getObj().equals("Rail")){   // Rail  -- 시작
						if (vo.getTsType().substring(1,2).equals("2")){
							velParam.put("curr_limit" ,vo.getCurrLimit());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd" , vo.getFmLoc());
							param.put("trsp_mod_cd", "R");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_MaxCapaUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("4") || vo.getTsType().substring(1,2).equals("5")){
							velParam.put("curr_limit" ,vo.getCurrLimit());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd" , vo.getFmLoc());
							param.put("trsp_mod_cd", "R");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_MaxCapaUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("7")){
							velParam.put("curr_limit" ,vo.getCurrLimit());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd" , vo.getFmLoc());
							param.put("trsp_mod_cd", "R");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_MaxCapaUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}                 // Rail 끝 
					}
					if (vo.getObj().equals("Water")){   // Rail  -- 시작
						if (vo.getTsType().substring(1,2).equals("2")){
							velParam.put("curr_limit" ,vo.getCurrLimit());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd" , vo.getFmLoc());
							param.put("trsp_mod_cd", "W");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_MaxCapaUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("4") || vo.getTsType().substring(1,2).equals("5")){
							velParam.put("curr_limit" ,vo.getCurrLimit());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd" , vo.getFmLoc());
							param.put("trsp_mod_cd", "W");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_MaxCapaUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("7")){
							velParam.put("curr_limit" ,vo.getCurrLimit());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd" , vo.getFmLoc());
							param.put("trsp_mod_cd", "W");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_MaxCapaUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}                 // Rail 끝 
					}
					if (vo.getObj().equals("Truck")){   // Rail  -- 시작
						if (vo.getTsType().substring(1,2).equals("2")){
							velParam.put("curr_limit" ,vo.getCurrLimit());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd" , vo.getFmLoc());
							param.put("trsp_mod_cd", "T");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_MaxCapaUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("4") || vo.getTsType().substring(1,2).equals("5")){
							velParam.put("curr_limit" ,vo.getCurrLimit());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd" , vo.getFmLoc());
							param.put("trsp_mod_cd", "T");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_MaxCapaUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}
						if (vo.getTsType().substring(1,2).equals("7")){
							velParam.put("curr_limit" ,vo.getCurrLimit());
							param.put("user_id", conditonVO.getUserId());
							param.put("fm_ecc_cd" , vo.getFmLoc());
							param.put("to_ecc_cd" , vo.getFmLoc());
							param.put("trsp_mod_cd", "T");
							result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityLinkInfo_MaxCapaUSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No SQL");
						}                 // Rail 끝 
					}
					if (vo.getObj().equals("On-Hire")){   // On-Hire  -- 시작
						velParam.put("curr_limit" ,vo.getCurrLimit());
						param.put("user_id", conditonVO.getUserId());
						param.put("ecc_cd" , vo.getToLoc());
						param.put("cntr_tpsz_cd" , vo.getTsType());
						result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivitySTOn_USQL(), param, velParam);
						if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No SQL");
					}
					if (vo.getObj().equals("Safety Stock")){   // Safety Stock  -- 시작
						velParam.put("curr_limit" ,vo.getCurrLimit());
						param.put("user_id", conditonVO.getUserId());
						param.put("ecc_cd" , vo.getFmLoc());
						param.put("cntr_tpsz_cd" , vo.getTsType());
						result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivitySafetyStock_USQL(), param, velParam);
						if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No SQL");
					} 
					if (vo.getObj().equals("Residual Capa")){   // Safety Stock  -- 시작
						residual_Capa_H = residualCapaH(vo.getWeek() ,vo.getFmLoc(), vo.getVvd() , old_sncr_id,vo.getLane() ,vo.getCurrLimit());
						velParam.put("ttl_rsdl_spc" ,residual_Capa_H);
						param.put("user_id", conditonVO.getUserId());
						param.put("fcast_yrwk", vo.getWeek());
						param.put("ecc_cd" , vo.getFmLoc());
						param.put("vvd", vo.getVvd());
						param.put("scnr_id", old_sncr_id);
						param.put("vsl_lane_cd" ,vo.getLane());
						result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOUpdateSensitivityScnrVslRsdl_USQL(), param, velParam);
						if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No SQL");
					} 
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
	 * Residual_Capa의 CO_CD가 H인거 구하기.  
	 * 
	 * @param week String
	 * @param ecc_cd String
	 * @param vvd String
	 * @param scnr_id String
	 * @param lane String
	 * @param curr_limit String
	 * 
	 * @return int
	 * @exception DAOException
	 */
	public int residualCapaH(String week , String ecc_cd , String vvd , String scnr_id , String lane, String curr_limit) throws DAOException {
		DBRowSet dbRowset = null;
		int residual_Capa_H     = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("fcast_yrwk", week);
			param.put("ecc_cd", ecc_cd);
			param.put("vvd", vvd);
			param.put("scnr_id", scnr_id);
			param.put("vsl_lane_cd", lane);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchScnrVslRsdlCapaRSQL(), param, velParam);
	
			if (dbRowset.next()) {
				residual_Capa_H = dbRowset.getInt("TTL_RSDL_SPC") * Integer.parseInt(curr_limit) / 100;
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return residual_Capa_H;
	}

	/**
	 * 민감도 분석. 
	 * 
	 * @param conditionVO EesEqr0088ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchPlanSensitivityCompare(EesEqr0088ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO returnVO = new CommonRsVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repo_pln_id =  Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
		//  String scnr_id = conditionVO.getScnrid();
		String arrFmEccCd = Utils.convertStr(conditionVO.getFmecccd());
		String arrToEccCd = Utils.convertStr(conditionVO.getToecccd());
		String inTypeCntrTpsz = Utils.convertStr(conditionVO.getCntrtpszcd());
		String fmType     = conditionVO.getFmtype();
		String toType     = conditionVO.getTotype();
		String fmStartPrd = conditionVO.getFmstartyear()+ conditionVO.getFmstartweek();
		String fmEndPrd   = conditionVO.getFmendyear() + conditionVO.getFmendweek();
		String toStartPrd = conditionVO.getTostartyear() + conditionVO.getTostartweek();
		String toEndPrd   = conditionVO.getToendyear()   + conditionVO.getToendweek();

		//   String tpszCd     = conditionVO.getCntrtpszcd();	
		//   ArrayList arrCntrTpsz = (ArrayList) Utils.replaceStrToList(conditionVO.getCntrtpszcd());
		//   String[]  arrTpszCd  = tpszCd.split(",");
		log.debug("====getSens===" +conditionVO.getSens() );
		log.debug("====getCostobj()===" +conditionVO.getCostobj() );
		try{

			param.put("repo_pln_id", repo_pln_id);
			param.put("repo_pln_id2" ,conditionVO.getRepoplanid2());
			param.put("fmstartprd", fmStartPrd);
			param.put("fmendprd", fmEndPrd);
			param.put("tostartprd", toStartPrd);
			param.put("toendprd", toEndPrd);
			velParam.put("repo_pln_id2" ,conditionVO.getRepoplanid2());
			velParam.put("arrtpszcd", inTypeCntrTpsz);
			velParam.put("fmecccd", arrFmEccCd);
			velParam.put("fmtype", fmType);
			velParam.put("arrfmecccd", arrFmEccCd);
			velParam.put("totype", toType);
			velParam.put("toecccd", arrToEccCd);
			velParam.put("arrtoecccd", arrToEccCd);
			//	param.put("sens_typ", conditionVO.getSenstext());
			//	param.put("obj_txt", conditionVO.getObjecttext());
			//	param.put("costobj", conditionVO.getCostobj());
			//	param.put("limitObj", conditionVO.getLimitobj());
			//	velParam.put("costobj", conditionVO.getCostobj());
			//	velParam.put("sens_typ", conditionVO.getSenstext());
			//	velParam.put("obj_txt", conditionVO.getObjecttext());
			//	velParam.put("limitObj", conditionVO.getLimitobj());
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityCompareRSQL(), param, velParam);
			returnVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}

	/**
	 * 민감도 분석. 
	 * 
	 * @param conditionVO EesEqr0088ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchUnitCostSensitivityCompare(EesEqr0088ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = new DBRowSet();;
		CommonRsVO returnVO = new CommonRsVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repo_pln_id =  Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
		//  String scnr_id = conditionVO.getScnrid();
		String arrFmEccCd = Utils.convertStr(conditionVO.getFmecccd());
		String arrToEccCd = Utils.convertStr(conditionVO.getToecccd());
		String inTypeCntrTpsz = Utils.convertStr(conditionVO.getCntrtpszcd());
		String fmType     = conditionVO.getFmtype();
		String toType     = conditionVO.getTotype();
		String fmStartPrd = conditionVO.getFmstartyear()+ conditionVO.getFmstartweek();
		String fmEndPrd   = conditionVO.getFmendyear() + conditionVO.getFmendweek();
		String toStartPrd = conditionVO.getTostartyear() + conditionVO.getTostartweek();
		String toEndPrd   = conditionVO.getToendyear()   + conditionVO.getToendweek();
		String sheet1Week = conditionVO.getSheet1week().replaceAll("-","");
		String sheet1CostCd = conditionVO.getSheet1costcd();

		//   String tpszCd     = conditionVO.getCntrtpszcd();	
		//   ArrayList arrCntrTpsz = (ArrayList) Utils.replaceStrToList(conditionVO.getCntrtpszcd());
		//   String[]  arrTpszCd  = tpszCd.split(",");
		log.debug("====getSens===" +sheet1Week );
		log.debug("====getCostobj()===" +sheet1CostCd );
		try{

			param.put("repo_pln_id", repo_pln_id);
			param.put("repo_pln_id2" ,conditionVO.getRepoplanid2());
			param.put("fmstartprd", fmStartPrd);
			param.put("fmendprd", fmEndPrd);
			param.put("tostartprd", toStartPrd);
			param.put("toendprd", toEndPrd);
			param.put("sheet1Week", sheet1Week);
			param.put("sheetcostcd", sheet1CostCd);
			velParam.put("repo_pln_id2" ,conditionVO.getRepoplanid2());
			velParam.put("arrtpszcd", inTypeCntrTpsz);
			velParam.put("fmecccd", arrFmEccCd);
			velParam.put("fmtype", fmType);
			velParam.put("arrfmecccd", arrFmEccCd);
			velParam.put("totype", toType);
			velParam.put("toecccd", arrToEccCd);
			velParam.put("arrtoecccd", arrToEccCd);
			velParam.put("sheet1Week", sheet1Week);
			velParam.put("sheetcostcd", sheet1CostCd);
			// param.put("sens_typ", conditionVO.getSenstext());
			// param.put("obj_txt", conditionVO.getObjecttext());
			// param.put("costobj", conditionVO.getCostobj());
			// param.put("limitObj", conditionVO.getLimitobj());
			// velParam.put("costobj", conditionVO.getCostobj());
			// velParam.put("sens_typ", conditionVO.getSenstext());
			// velParam.put("obj_txt", conditionVO.getObjecttext());
			// velParam.put("limitObj", conditionVO.getLimitobj());
			if (sheet1CostCd.equals("L") || sheet1CostCd.equals("D")){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchUnitCostSensivityCompareRSQL(), param, velParam);
			}else if (sheet1CostCd.equals("R") || sheet1CostCd.equals("W") || sheet1CostCd.equals("T")){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchUnitCostSensivityCompare01RSQL(), param, velParam);	   
			}else if (sheet1CostCd.equals("O") || sheet1CostCd.equals("F")){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchUnitCostSensivityCompare02RSQL(), param, velParam);
			}
			returnVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}

	/**
	 * 민감도 분석. 
	 * 
	 * @param conditionVO EesEqr0088ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchRepoPlanType(EesEqr0088ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO returnVO = new CommonRsVO();
		String[] typeInfo = new String[3];

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("repo_pln_id2" ,conditionVO.getRepoplanid2());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanSensitivityAnalysisDBDAOSearchSensivityTypeRSQL(), param, velParam);
			while(dbRowset.next()){
				typeInfo[0] = dbRowset.getString("SENS");
				typeInfo[1] = dbRowset.getString("OBJ_NAME");
				typeInfo[2] = dbRowset.getString("REPO_PLN_RMK");
			}
			returnVO.setResultStrArray(typeInfo);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
}