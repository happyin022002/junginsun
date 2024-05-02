/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODockScheduleDAO.java
*@FileTitle : D/dock Schedule Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.24 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.basic.TCharIODockScheduleBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.CondDryDockScheduleVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.CustomDckSkdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.SearchDryDockScheduleGraphListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.SearchDryDockScheduleListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 TCharIODockScheduleDAO <br>
 * - NIS2010-TimeCharterInOutFleetManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon Seyeong
 * @see TCharIODockScheduleBCImpl 참조
 * @since J2EE 1.4
 */
public class TCharIODockScheduleDBDAO extends DBDAOSupport {

	/**
	 * D/Dock Estimated Schedules 데이터를 조회한다.<br>
	 * 
	 * @param vslCd String
	 * @param dckSelCd String
	 * @return List<CustomDckSkdVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustomDckSkdVO> searchDockEstimatedScheduleList(String vslCd ,String dckSelCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomDckSkdVO> customDckSkdVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			param.put("vsl_cd", vslCd);
			param.put("dck_sel_cd", dckSelCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharIODockScheduleDAOCustomDckSkdVORSQL(), param, velParam);
			customDckSkdVO = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomDckSkdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return customDckSkdVO;
	}
	 
    /**
	 * Estimated Schedules 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param customDckSkdVO List<CustomDckSkdVO>
	 * @throws DAOException
	 */
	public void addDockEstimatedSchedules(List<CustomDckSkdVO> customDckSkdVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customDckSkdVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharIODockScheduleDAOCustomDckSkdVOCSQL(), customDckSkdVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Estimated Schedules를 일괄적으로 갱신한다.<br>
	 * 
	 * @param customDckSkdVO List<CustomDckSkdVO>
	 * @throws DAOException
	 */
	public void modifyDockEstimatedSchedules(List<CustomDckSkdVO> customDckSkdVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customDckSkdVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharIODockScheduleDAOCustomDckSkdVOUSQL(), customDckSkdVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Estimated Schedules를 일괄적으로 삭제한다.<br>
	 * 
	 * @param customDckSkdVO List<CustomDckSkdVO>
	 * @throws DAOException
	 */
	public void removeDockEstimatedSchedules(List<CustomDckSkdVO> customDckSkdVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customDckSkdVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharIODockScheduleDAOCustomDckSkdVODSQL(), customDckSkdVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Recommend Schedules를 일괄적으로 생성한다.<br>
	 * 
	 * @param customDckSkdVO List<CustomDckSkdVO>
	 * @throws DAOException
	 */
	public void addDockRecommendSchedules(List<CustomDckSkdVO> customDckSkdVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customDckSkdVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharIODockScheduleDAOCustomDckSkdVOCSQL(), customDckSkdVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Recommend Schedules를 일괄적으로 갱신한다.<br>
	 * 
	 * @param customDckSkdVO List<CustomDckSkdVO>
	 * @throws DAOException
	 */
	public void modifyDockRecommendSchedules(List<CustomDckSkdVO> customDckSkdVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customDckSkdVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharIODockScheduleDAOCustomDckSkdVOUSQL(), customDckSkdVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Recommend Schedules를 일괄적으로 삭제한다.<br>
	 * 
	 * @param customDckSkdVO List<CustomDckSkdVO>
	 * @throws DAOException
	 */
	public void removeDockRecommendSchedules(List<CustomDckSkdVO> customDckSkdVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customDckSkdVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharIODockScheduleDAOCustomDckSkdVODSQL(), customDckSkdVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * D/Dock Recommend Schedules 데이터를 조회한다.<br>
	 * 
	 * @param vslCd String
	 * @param dckSelCd String
	 * @return List<CustomDckSkdVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustomDckSkdVO> searchDockRecommendScheduleList(String vslCd ,String dckSelCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomDckSkdVO> customDckSkdVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			
			param.put("vsl_cd", vslCd);
			param.put("dck_sel_cd", dckSelCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharIODockScheduleDAOCustomDckSkdVORSQL(), param, velParam);
			customDckSkdVO = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomDckSkdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return customDckSkdVO;
	}
	 
	/**
	 * Dry Dock Schedule Graph List 데이터를 조회한다.<br>
	 * 
	 * @param condDryDockScheduleVO CondDryDockScheduleVO
	 * @return List<SearchDryDockScheduleGraphListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDryDockScheduleGraphListVO> searchDryDockScheduleGraphList(CondDryDockScheduleVO condDryDockScheduleVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDryDockScheduleGraphListVO> searchDryDockScheduleGraphListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			
			Map<String, String> mapVO = condDryDockScheduleVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int frDuration = Integer.parseInt(condDryDockScheduleVO.getFrDuration());
			int toDuration = Integer.parseInt(condDryDockScheduleVO.getToDuration());
			int k = 1;
	
			velParam.put("snd_year", "");
			velParam.put("trd_year", "");
			
			for (int i=frDuration;i<=toDuration;i++) {
    		
				if (k==1) {
					param.put("fst_year", frDuration);
				} else if (k==2) {
					param.put("snd_year", i);
					velParam.put("snd_year", i);
				} else {
					param.put("trd_year", i);
					velParam.put("trd_year", i);
				}

				k++;
			}	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharIODockScheduleDAOSearchDryDockScheduleGraphListRSQL(), param, velParam);
			searchDryDockScheduleGraphListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDryDockScheduleGraphListVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchDryDockScheduleGraphListVO;
	}
	 
	/**
	 * Dry Dock Schedule List 데이터를 조회한다.<br>
	 * 
	 * @param condDryDockScheduleVO CondDryDockScheduleVO
	 * @return List<SearchDryDockScheduleListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDryDockScheduleListVO> searchDryDockScheduleList(CondDryDockScheduleVO condDryDockScheduleVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDryDockScheduleListVO> searchDryDockScheduleListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			
			Map<String, String> mapVO = condDryDockScheduleVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharIODockScheduleDBDAOSearchDryDockScheduleListVORSQL(), param, velParam);
			searchDryDockScheduleListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDryDockScheduleListVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchDryDockScheduleListVO;
	}
	
}
