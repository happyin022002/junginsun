/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireDomesticNewvanScheduleInputDBDAO.java
*@FileTitle : 연간신조 및 L/T 계획 조회 / 수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	jungran yang		2006-09-20		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.29		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.29
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.basic.OnhireDomesticNewvanScheduleInputBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0020ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0021ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0090ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.SearchYearDomesticPlanVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.SearchYearSubleasePlanVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EqrScnrDmstVO;
import com.hanjin.syscommon.common.table.EqrScnrNewVanLongTermVO;


/**
 * ALPS OnhireDomesticNewvanScheduleInputDBDAO <br>
 * - ALPS-ScenarioManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see OnhireDomesticNewvanScheduleInputBCImpl 참조
 * @since J2EE 1.6
 */
public class OnhireDomesticNewvanScheduleInputDBDAO extends DBDAOSupport {
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (하단 Sheet 조회)<br>
	 * 
	 * @param conditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CommonRsVO searchYearNewvanPlan(EesEqr0020ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			
			List arrPerfixMonth = (ArrayList) Utils.replaceStrToList(conditionVO.getPerfixMonth());
			List arrlocation = (ArrayList) Utils.replaceStrToList(conditionVO.getLoctype());
			List arrtpszcd = (ArrayList) Utils.replaceStrToList(conditionVO.getTpsztype());
			String fmPlnYrwk = conditionVO.getStYear()+conditionVO.getStWeekly();
			String toPlnYrwk = conditionVO.getEndYear()+conditionVO.getEndWeekly();
		
			param.putAll(mapVO);
			param.put("fmPlnYrwk", fmPlnYrwk);
			param.put("toPlnYrwk", toPlnYrwk);
			
			velParam.putAll(mapVO);
			velParam.put("arrPerfixMonth", arrPerfixMonth);
			velParam.put("arrlocation", arrlocation);
			velParam.put("arrtpszcd", arrtpszcd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireDomesticNewvanShceduleInputDBDAOSearchYearNewPlanRSQL(), param, velParam);
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
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (상단 Sheet 조회)<br>
	 * 
	 * @param conditionVO
	 * @param pikupVolSearchchk
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CommonRsVO searchWeeklyNewvanPlan(EesEqr0020ConditionVO conditionVO, String pikupVolSearchchk) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			
			List arrPerfixWeekly = (ArrayList) Utils.replaceStrToList(conditionVO.getPerfixWeekly());
			List arrlocation = (ArrayList) Utils.replaceStrToList(conditionVO.getLoctype());
			List arrtpszcd = (ArrayList) Utils.replaceStrToList(conditionVO.getTpsztype());
			String fmPlnYrmo = conditionVO.getStYear()+conditionVO.getStMonth();
			int month = Integer.parseInt(conditionVO.getStMonth());
			String month_key = "";
			String fmPlnYrwk = conditionVO.getStYear()+conditionVO.getStWeekly();
			String toPlnYrwk = conditionVO.getEndYear()+conditionVO.getEndWeekly();
			
			if (month == 1) {
				month_key = Integer.toString(month);
			} else {
		    	month_key = Integer.toString(month -1);
		    	 if (month_key.length() < 2){
		    		 month_key = "0" + month_key;
		    	 }
			}
		
			param.putAll(mapVO);
			param.put("fmPlnYrmo", fmPlnYrmo);
			param.put("month_key", month_key);
			param.put("fmPlnYrwk", fmPlnYrwk);
			param.put("toPlnYrwk", toPlnYrwk);
			
			velParam.putAll(mapVO);
			velParam.put("arrPerfixWeekly", arrPerfixWeekly);
			velParam.put("arrlocation", arrlocation);
			velParam.put("arrtpszcd", arrtpszcd);
			velParam.put("pikupVolSearchchk", pikupVolSearchchk);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireDomesticNewvanShceduleInputDBDAOSearchWeeklyNewPlanRSQL(), param, velParam);
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
	  * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리<br>
	  * 
	  * @param conditionVO
	  * @return CommonRsVO
	  * @exception DAOException
	  */
	public CommonRsVO pikupVolSearchchk(EesEqr0020ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
		
			param.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireDomesticNewvanShceduleInputDBDAOPickupVolSearchchkRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rsVO;
	}
	
	 /**
	  * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (코드 조회)<br>
	  * 
	  * @param searchword
	  * @return CommonRsVO
	  * @exception DAOException
	  */
	public CommonRsVO codeLocsearch(String searchword) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("ecc_cd", searchword);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireDomesticNewvanShceduleInputDBDAOSearchRCCInfoRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rsVO;
	}
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 멀티 이벤트 처리<br>
	 * 
	 * @param updModels List<EqrScnrNewVanLongTermVO>
	 * @exception DAOException
	 */
	public void modifyYearNewvanPlan(List<EqrScnrNewVanLongTermVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OnhireDomesticNewvanShceduleInputDBDAOMergeYearNewvanPlanCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 멀티 이벤트 처리<br>
	 * 
	 * @param delModels List<EqrScnrNewVanLongTermVO>
	 * @exception DAOException
	 */
	public void deleteYearNewvanPlan(List<EqrScnrNewVanLongTermVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new OnhireDomesticNewvanShceduleInputDBDAODeleteYearNewvanPlanDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	 /**
	  * US Domestic 물량 조회/수정 조회 이벤트 처리 (상단 Sheet 조회)<br>
	  * 
	  * @param conditionVO EesEqr0021ConditionVO
	  * @return List<SearchYearDomesticPlanVO>
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<SearchYearDomesticPlanVO> searchYearDomesticPlan(EesEqr0021ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchYearDomesticPlanVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			
			String fmPlnYrwk = "";
			String toPlnYrwk = "";
			
			if ("1".equals(conditionVO.getFmtoat())) {
				fmPlnYrwk = conditionVO.getFmplnyr() + conditionVO.getFmplnwk();
				toPlnYrwk = conditionVO.getToplnyr()+conditionVO.getToplnwk();
			} else {
		    	fmPlnYrwk = conditionVO.getAtfmplnyr()+conditionVO.getAtfmplnwk();
		    	toPlnYrwk = conditionVO.getAttoplnyr()+conditionVO.getAttoplnwk();
			}
			
			param.put("fmPlnYrwk", fmPlnYrwk);
			param.put("toPlnYrwk", toPlnYrwk);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireDomesticNewvanShceduleInputDBDAOSearchYearDomesticPlanRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchYearDomesticPlanVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}
	
	 /**
	  * US Domestic 물량 조회/수정 조회 이벤트 처리 (하단 Sheet 조회)<br>
	  * 
	  * @param conditionVO EesEqr0021ConditionVO
	  * @return CommonRsVO
	  * @exception DAOException
	  */
	public CommonRsVO searchYearDomesticDetailPlan(EesEqr0021ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			
			String fmPlnYrwk = "";
			String toPlnYrwk = "";
			
			int fmYrwkCnt = 0;
			ArrayList<String> arr = new ArrayList<String>(16);
			String toPlnWk = conditionVO.getToplnwk();
			String fmPlnWk = conditionVO.getFmplnwk();
			String fmPlnYr = conditionVO.getFmplnyr();
			String atToPlnWk = conditionVO.getAttoplnwk();
			String atFmPlnWk = conditionVO.getAtfmplnwk();
			String atFmPlnYr = conditionVO.getAtfmplnyr();
			String toPlnYr = conditionVO.getToplnyr();
			
			ArrayList<String> arrFmEccCd = (ArrayList<String>) Utils.replaceStrToList(conditionVO.getFmecccd());
			ArrayList<String> arrToEccCd = (ArrayList<String>) Utils.replaceStrToList(conditionVO.getToecccd());
			ArrayList<String> arrAtEccCd = (ArrayList<String>) Utils.replaceStrToList(conditionVO.getAtecccd());
			ArrayList<String> arrTpszcd = (ArrayList<String>) Utils.replaceStrToList(conditionVO.getCntrtpszcd());
			
			if ("1".equals(conditionVO.getFmtoat())) {
				fmPlnYrwk = conditionVO.getFmplnyr() + conditionVO.getFmplnwk();
				toPlnYrwk = conditionVO.getToplnyr()+conditionVO.getToplnwk();
				
				if(Integer.parseInt(toPlnWk)- Integer.parseInt(fmPlnWk) < 0){//differ year
					fmYrwkCnt = 16 - Integer.parseInt(toPlnWk);
					
					int k = 0;
					int x = Integer.parseInt(toPlnWk)-1;
					
					for(int j = 0; j < fmYrwkCnt;j++){//3
						arr.add(fmPlnYr + Utils.toLen2(Integer.parseInt(fmPlnWk) + k));	//51+0
						k++;
					}
					
					for(int j = fmYrwkCnt; j < 16;j++){
						arr.add(toPlnYr + Utils.toLen2(Integer.parseInt(toPlnWk) - x));	
						x--;
					}
					
				}else{//same year
					
					int k = Integer.parseInt(fmPlnWk);
					for(int j = 0; j < 16;j++){
						arr.add(fmPlnYr + Utils.toLen2(k));
						k++;
					}
				}
			} else {
		    	fmPlnYrwk = conditionVO.getAtfmplnyr()+conditionVO.getAtfmplnwk();
		    	toPlnYrwk = conditionVO.getAttoplnyr()+conditionVO.getAttoplnwk();
		    	
				if(Integer.parseInt(atToPlnWk)- Integer.parseInt(atFmPlnWk) < 0){
					fmYrwkCnt = 16 - Integer.parseInt(atToPlnWk);
					
					if(Integer.parseInt(atToPlnWk)- Integer.parseInt(atFmPlnWk) < 0){//differ year
						fmYrwkCnt = 16 - Integer.parseInt(atToPlnWk);
						
						int k = 0;
						int x = Integer.parseInt(atToPlnWk)-1;
						
						for(int j = 0; j < fmYrwkCnt;j++){//3
							arr.add(atFmPlnYr + Utils.toLen2(Integer.parseInt(atFmPlnWk) + k));	//51+0
							k++;
						}
						
						for(int j = fmYrwkCnt; j < 16;j++){
							arr.add(toPlnYr + Utils.toLen2(Integer.parseInt(atToPlnWk) - x));	
							x--;
						}
						
					}else{//same year
						
						int k = Integer.parseInt(atFmPlnWk);
						for(int j = 0; j < 16;j++){
							arr.add(atFmPlnYr + Utils.toLen2(k));
							k++;
						}
					}				
				}else{
					int k = Integer.parseInt(atFmPlnWk);
					for(int j = 0; j < 16;j++){
						arr.add(atFmPlnYr + Utils.toLen2(k));
						k++;
					}
				}
			}
			
			param.put("fmPlnYrwk", fmPlnYrwk);
			param.put("toPlnYrwk", toPlnYrwk);
			
			velParam.put("arr", arr);
			velParam.put("arrFmEccCd", arrFmEccCd);
			velParam.put("arrToEccCd", arrToEccCd);
			velParam.put("arrAtEccCd", arrAtEccCd);
			velParam.put("arrTpszcd", arrTpszcd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireDomesticNewvanShceduleInputDBDAOSearchYearDomesticDetailPlanRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rsVO;
	}
	
	/**
	 * US Domestic 물량 조회/수정 Share 이벤트 처리<br>
	 * EQR_SCNR_DMST 테이블의 데이터 삭제<br>
	 * 
	 * @param conditionVO EesEqr0021ConditionVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void deleteDomesticPerformance(EesEqr0021ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			String stYrWk = conditionVO.getFmplnyr() + conditionVO.getFmplnwk();
			String endYrWk = conditionVO.getToplnyr() + conditionVO.getToplnwk();
			String scnr_id = conditionVO.getScnrId();
			
			param.put("stYrWk", stYrWk);
			param.put("endYrWk", endYrWk);
			param.put("scnr_id", scnr_id);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new OnhireDomesticNewvanShceduleInputDBDAODeleteDomesticPerformanceDSQL(), param, velParam);
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
	 * US Domestic 물량 조회/수정 Share 이벤트 처리<br>
	 * EQR_SCNR_DMST 테이블의 데이터 입력<br>
	 * 
	 * @param models List<EqrScnrDmstVO>
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] insertDomesticPerformance(List<EqrScnrDmstVO> models) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OnhireDomesticNewvanShceduleInputDBDAOInsertDomesticPerformanceCSQL(), models,null);
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
	 * US Domestic 물량 조회/수정 Share 이벤트 처리<br>
	 * EQR_SCNR_DMST 테이블의 데이터 수정<br>
	 * 
	 * @param models
	 * @return
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] updateDomesticPerformance(List<EqrScnrDmstVO> models) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OnhireDomesticNewvanShceduleInputDBDAOUpdateDomesticPerformanceUSQL(), models,null);
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
	 * US Domestic 물량 조회/수정 Save 이벤트 처리<br>
	 * EQR_SCNR_DMST 테이블의 데이터 수정/입력<br>
	 * 
	 * @param models
	 * @return
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyYearDomesticPlan(List<EqrScnrDmstVO> models) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OnhireDomesticNewvanShceduleInputDBDAOMergeYearDomesticPlanCSQL(), models,null);
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
	 * US Domestic 물량 조회/수정 Save 이벤트 처리<br>
	 * EQR_SCNR_DMST 테이블의 데이터 삭제<br>
	 * 
	 * @param models
	 * @return
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] deleteYearDomesticPlan(List<EqrScnrDmstVO> models) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OnhireDomesticNewvanShceduleInputDBDAODeleteYearDomesticPlanDSQL(), models,null);
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
	 * OnhireDomesticNewvanScheduleInput의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * EES_EQR_090
	 * @param conditionVO EesEqr0090ConditionVO
	 * @return List<SearchYearSubleasePlanVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchYearSubleasePlanVO> searchYearSubleasePlan(EesEqr0090ConditionVO conditionVO) throws DAOException {
		List<SearchYearSubleasePlanVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	    
	    String fmToAt = conditionVO.getFmtoat();
	    String fmPlnYrwk = "";
	    String toPlnYrwk = "";
	    String scnrId = Constants.SCNR_WORD+conditionVO.getYyyyww()+Constants.SCNR_WEEK+conditionVO.getSeq();
	    
	    if(fmToAt.equals("1")) {
	    	fmPlnYrwk = conditionVO.getFmplnyr()+conditionVO.getFmplnwk();
	    	toPlnYrwk = conditionVO.getToplnyr()+conditionVO.getToplnwk();
	    } else {
	    	fmPlnYrwk = conditionVO.getAtfmplnyr()+conditionVO.getAtfmplnwk();
	    	toPlnYrwk = conditionVO.getAttoplnyr()+conditionVO.getAttoplnwk();
	    }
	    

	    try {
	    	param.put("fmPlnYrwk", fmPlnYrwk);
	    	param.put("toPlnYrwk", toPlnYrwk);
	    	param.put("scnrId", scnrId);
	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireDomesticNewvanScheduleInputDBDAOSearchYearSubleasePlanRSQL(), param, null);
	    	list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchYearSubleasePlanVO .class);
	    } catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    return list;
	}

	/**
	 * OnhireDomesticNewvanScheduleInput의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * EES_EQR_090
	 * @param ConditionVO EesEqr0090ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchYearSubleaseDetailPlan(EesEqr0090ConditionVO conditionVO) throws DAOException {
			   	
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		

		String fmToAt 	= conditionVO.getFmtoat();
				
		
		String fmType       = conditionVO.getFmtype();
		String fmEccCd      = conditionVO.getFmecccd();
		List arrFmEccCd 	= Utils.replaceStrToList(fmEccCd);//fmEccCd.split(",");
		String fmTypeBy     = conditionVO.getFmtypeby();
		String fmPlnYr      = conditionVO.getFmplnyr();
		String fmPlnWk      = conditionVO.getFmplnwk();
		String toPlnYr      = conditionVO.getToplnyr();
		String toPlnWk      = conditionVO.getToplnwk();
		
		String toType       = conditionVO.getTotype();
		String toEccCd      = conditionVO.getToecccd();
		List arrToEccCd 	= Utils.replaceStrToList(toEccCd);//toEccCd.split(",");
		String toTypeBy     = conditionVO.getTotypeby();
		
		String atType       = conditionVO.getAttype();
		String atEccCd      = conditionVO.getAtecccd();
		String[] arrAtEccCd = atEccCd.split(",");
		String atTypeBy     = conditionVO.getAttypeby();
		String atFmPlnYr      = conditionVO.getAtfmplnyr();
		String atFmPlnWk      = conditionVO.getAtfmplnwk();
		String atToPlnYr      = conditionVO.getAttoplnyr();
		String atToPlnWk      = conditionVO.getAttoplnwk();
		
		// TP / SZ
		String cntrTpszCd   = conditionVO.getCntrtpszcd();
		List arrCntrTpszCd 	= Utils.replaceStrToList(cntrTpszCd);//cntrTpszCd.split(",");
		
		//SCNR_ID
		String scnrId = Constants.SCNR_WORD+conditionVO.getYyyyww()+Constants.SCNR_WEEK+conditionVO.getSeq();
	
		//share 후 rowSearch 시 상단 조회조건을 무시.
		//location, viewBy, tpsz 조회조건을 무시하고 share 시 선택한 rcc에 해당하는 ecc를 조건으로 넣는다.

		
		
		int fmYrwkCnt = 0;
//		int toYrwkCnt = 0;
		String[] arr = new String[16]; 
		
		//-------------->
		if(fmToAt.equals("1")) {
			//--------------------
			if(Integer.parseInt(toPlnWk)- Integer.parseInt(fmPlnWk) < 0){//differ year
				fmYrwkCnt = 16 - Integer.parseInt(toPlnWk);
//				toYrwkCnt = Integer.parseInt(toPlnWk);
				
				log.debug("\n fmYrwkCnt="+fmYrwkCnt);//3
				
				int k = 0;
				int x = Integer.parseInt(toPlnWk)-1;
				
				for(int j = 0; j < fmYrwkCnt;j++){//3
					arr[j] = fmPlnYr + Utils.toLen2(Integer.parseInt(fmPlnWk) + k);	//51+0
					k++;
					log.debug("\n <"+j+"> == "+arr[j]);
				}
				
				for(int j = fmYrwkCnt; j < 16;j++){
					arr[j] = toPlnYr + Utils.toLen2(Integer.parseInt(toPlnWk) - x);	
					x--;
					log.debug("\n <<"+j+">> == "+arr[j]);
				}
				
			}else{//same year
				
				int k = Integer.parseInt(fmPlnWk);
				for(int j = 0; j < 16;j++){
					arr[j] = fmPlnYr + Utils.toLen2(k);
					log.debug("\n [["+j+"]] == "+arr[j]+" : "+Utils.toLen2(k));
					k++;
				}
			}
			//-------------------------
			
		}else{//AT
			//--------------------			
			if(Integer.parseInt(atToPlnWk)- Integer.parseInt(atFmPlnWk) < 0){
				fmYrwkCnt = 16 - Integer.parseInt(atToPlnWk);
//				toYrwkCnt = Integer.parseInt(atToPlnWk);
				
				if(Integer.parseInt(atToPlnWk)- Integer.parseInt(atFmPlnWk) < 0){//differ year
					fmYrwkCnt = 16 - Integer.parseInt(atToPlnWk);
//					toYrwkCnt = Integer.parseInt(atToPlnWk);
					
					log.debug("\n fmYrwkCnt="+fmYrwkCnt);//3
					
					int k = 0;
					int x = Integer.parseInt(atToPlnWk)-1;
					
					for(int j = 0; j < fmYrwkCnt;j++){//3
						arr[j] = atFmPlnYr + Utils.toLen2(Integer.parseInt(atFmPlnWk) + k);	//51+0
						k++;
						log.debug("\n <"+j+"> == "+arr[j]);
					}
					
					for(int j = fmYrwkCnt; j < 16;j++){
						arr[j] = toPlnYr + Utils.toLen2(Integer.parseInt(atToPlnWk) - x);	
						x--;
						log.debug("\n <<"+j+">> == "+arr[j]);
					}
					
				}else{//same year
					
					int k = Integer.parseInt(atFmPlnWk);
					for(int j = 0; j < 16;j++){
						arr[j] = atFmPlnYr + Utils.toLen2(k);
						log.debug("\n [["+j+"]] == "+arr[j]+" : "+Utils.toLen2(k));
						k++;
					}
				}				
			}else{
				int k = Integer.parseInt(atFmPlnWk);
				for(int j = 0; j < 16;j++){
					arr[j] = atFmPlnYr + Utils.toLen2(k);
					log.debug("\n [["+j+"]] == "+arr[j]+" : "+Utils.toLen2(k));
					k++;
				}
			}
			//-------------------------
		}
			
	    try {
	       
	        // 쿼리에 변수 세팅.
				if(fmToAt.equals("1")) {
					param.put("fmPln", fmPlnYr+fmPlnWk);
					param.put("toPln", toPlnYr+toPlnWk);
					param.put("scnrId",scnrId);
				} else {
					param.put("fmPln", atFmPlnYr+atFmPlnWk);
					param.put("toPln", atToPlnYr+atToPlnWk);
					param.put("scnrId",scnrId);
				}
				param.put("rcc_cd", conditionVO.getRccCd());
				velParam.put("arr",arr);
				velParam.put("type",conditionVO.getType());
				velParam.put("fmToAt",fmToAt);
				velParam.put("fmTypeBy",fmTypeBy);
				velParam.put("atTypeBy",atTypeBy);
				velParam.put("toTypeBy",toTypeBy);
				velParam.put("atTypeBy",atTypeBy);
				velParam.put("fmEccCd",fmEccCd);
				velParam.put("fmType", fmType);
				velParam.put("arrFmEccCd",arrFmEccCd);
				velParam.put("toEccCd",toEccCd);
				velParam.put("toType",toType);
				velParam.put("arrToEccCd",arrToEccCd);
				velParam.put("atType",atType);
				velParam.put("cntrTpszCd",cntrTpszCd);
				velParam.put("arrCntrTpszCd",arrCntrTpszCd);
				velParam.put("arrAtEccCd",arrAtEccCd);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireDomesticNewvanScheduleInputDBDAOSearchYearSubleaseDetailPlanRSQL(), param, velParam);
				rsVO.setDbRowset(dbRowset);
	    } catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    return rsVO;
	}		

	/**
	 * EES_EQR_090화면의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param insModels List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void insertSubleasePerformance(List insModels) throws DAOException {
		
		int insCnt[] = null;
	    try {
	    	SQLExecuter sqlExe = new SQLExecuter("");
			
			insCnt = sqlExe.executeBatch((ISQLTemplate)new OnhireDomesticNewvanScheduleInputDBDAOInsertSubleaseCSQL(), insModels,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}
	
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(),de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(),e);
	        throw new DAOException(e.getMessage());
	    }
	}

	/**
	 * EES_EQR_090화면의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param updModels List
	 * @exception DAOException
	 * @exception EventException 
	 */
	@SuppressWarnings("unchecked")
	public void modifySubleasePerformance(List updModels) throws DAOException {
		
		int updCnt[] = null;
	    try {
	    	SQLExecuter sqlExe = new SQLExecuter("");
			
	    	updCnt = sqlExe.executeBatch((ISQLTemplate)new OnhireDomesticNewvanScheduleInputDBDAOModifySubleaseUSQL(), updModels,null);
			for(int i = 0; i < updCnt.length; i++){
				if(updCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No"+ i + " SQL");
			}
	
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(),de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(),e);
	        throw new DAOException(e.getMessage());
	    }
	}

	/**
	 * EES_EQR_090화면의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param delModels List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void deleteSubleasePerformance(List delModels) throws DAOException {
		
		int delCnt[] = null;
	    try {
	    	SQLExecuter sqlExe = new SQLExecuter("");
			
	    	delCnt = sqlExe.executeBatch((ISQLTemplate)new OnhireDomesticNewvanScheduleInputDBDAODeleteSubleaseDSQL(), delModels,null);
			for(int i = 0; i < delCnt.length; i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No"+ i + " SQL");
			}
	
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(),de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(),e);
	        throw new DAOException(e.getMessage());
	    }
	}
		 

	/**
	 * OnhireDomesticNewvanScheduleInput의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * EES_EQR_090
	 * @param delModels  List
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void deleteYearSubleasePlan(List delModels) throws DAOException {
		 
        int delCnt[] = null;
        
        try {
        	SQLExecuter sqlExe = new SQLExecuter("");
        	
			delCnt = sqlExe.executeBatch((ISQLTemplate)new OnhireDomesticNewvanScheduleInputDBDAODeleteYearSubleasePlanDSQL(), delModels,null);
			for(int i = 0; i < delCnt.length; i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No"+ i + " SQL");
			}

        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } 
    }	
	 /**
	 * OnhireDomesticNewvanScheduleInput의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * EES_EQR_090
	 * @param insModels  List
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void insertYearSubleasePlan(List insModels) throws DAOException {
		 
        int insCnt[] = null;
        
        try {
        	SQLExecuter sqlExe = new SQLExecuter("");
			insCnt = sqlExe.executeBatch((ISQLTemplate)new OnhireDomesticNewvanScheduleInputDBDAOMergeYearSubleasePlanCSQL(), insModels,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to merge No"+ i + " SQL");
			}

        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } 
    }	
	 
}