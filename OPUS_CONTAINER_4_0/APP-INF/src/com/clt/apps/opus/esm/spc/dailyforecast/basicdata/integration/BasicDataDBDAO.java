/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : BasicDataDBDAO.java
*@FileTitle      : BasicData
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.07.23
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.07.23
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.basicdata.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.basic.BasicDataBCImpl;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByVvdListConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByVvdListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByWeekListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SpcFcastOfcPolMapgConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SpcFcastOfcPolMapgVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SpcIrrFcastOfcPolMapgVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * BasicDataDBDAO <br>
 * - DailyForecast system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Han Sang Hoon
 * @see BasicDataBCImpl 참조
 * @since J2EE 1.6
 */
public class BasicDataDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchDailyForcastManageByVvdListConditionVO searchDailyForcastManageByVvdListConditionVO
	 * @return List<SearchDailyForcastManageByVvdListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDailyForcastManageByVvdListVO> searchDailyForcastManageByVvdList(SearchDailyForcastManageByVvdListConditionVO searchDailyForcastManageByVvdListConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyForcastManageByVvdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchDailyForcastManageByVvdListConditionVO != null){
				Map<String, String> mapVO = searchDailyForcastManageByVvdListConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SearchDailyForcastManageByVvdListDAOSqlNameRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDailyForcastManageByVvdListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SpcFcastOfcPolMapgConditionVO spcFcastOfcPolMapgConditionVO
	 * @return List<SearchDailyForcastManageByWeekListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDailyForcastManageByWeekListVO> searchDailyForcastManageByWeekList(SpcFcastOfcPolMapgConditionVO spcFcastOfcPolMapgConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyForcastManageByWeekListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(spcFcastOfcPolMapgConditionVO != null){
				Map<String, String> mapVO = spcFcastOfcPolMapgConditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSpcFcastOfcPolMapgVORSQL(), param, velParam);
						
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDailyForcastManageByWeekListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcIrrFcastOfcPolMapgVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiDailyForcastVvdManageS(List<SpcIrrFcastOfcPolMapgVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BasicDataDBDAOmultiSpcIrrFcastOfcPolMapgCSQL(), insModels,null);
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
		return insCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcIrrFcastOfcPolMapgVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiDailyForcastVvdManageS(List<SpcIrrFcastOfcPolMapgVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BasicDataDBDAOmultiSpcIrrFcastOfcPolMapgDSQL(), delModels,null);
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
		return delCnt;
	}

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcFcastOfcPolMapgVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiDailyForcastManageS(List<SpcFcastOfcPolMapgVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BasicDataDBDAOSpcFcastOfcPolMapgVOCSQL(), insModels,null);
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
		return insCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcFcastOfcPolMapgVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiDailyForcastManageS(List<SpcFcastOfcPolMapgVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BasicDataDBDAOSpcFcastOfcPolMapgVODSQL(), delModels,null);
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
		return delCnt;
	}
	
	/**
	 * Lane, Bound 에 등록 가능한 Port인지 체크합니다.<br>
	 * 
	 * @param SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkLanePortValid(SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtn = "N";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(spcFcastOfcPolMapgVO != null){
				Map<String, String> mapVO = spcFcastOfcPolMapgVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOCheckLanePortValidRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					String trdCd = dbRowset.getString(1);
					String subTrdCd = dbRowset.getString(2);
					if(trdCd != null && subTrdCd != null){
						rtn = "Y";
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
		return rtn;
	} 
	 
	 /**
	  * 입력한 Office가 Region Office 체크합니다.<br>
	  * 
	  * @param SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO
	  * @return String
	  * @exception DAOException
	  */
	 public String checkOfficeValid(SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String rtn = "N";
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(spcFcastOfcPolMapgVO != null){
				 Map<String, String> mapVO = spcFcastOfcPolMapgVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOCheckOfficeValidRSQL(), param, velParam);
			 if(dbRowset != null){
				 if(dbRowset.next()){
					 String ofc = dbRowset.getString(1);
					 if(!"".equals(ofc)){
						 rtn = "Y";
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
		 return rtn;
	 }
	
	 /**
	  * 입력한 vvd가 valid한지 체크합니다.<br>
	  * 
	  * @param SpcIrrFcastOfcPolMapgVO spcIrrFcastOfcPolMapgVO
	  * @return String
	  * @exception DAOException
	  */
	 public String checkVvdValid(SpcIrrFcastOfcPolMapgVO spcIrrFcastOfcPolMapgVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String rtn = "N";
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(spcIrrFcastOfcPolMapgVO != null){
				 Map<String, String> mapVO = spcIrrFcastOfcPolMapgVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOCheckVvdValidRSQL(), param, velParam);
			 if(dbRowset != null){
				 if(dbRowset.next()){
					 String cnt = dbRowset.getString(1);
					 if(!"0".equals(cnt)){
						 rtn = "Y";
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
		 return rtn;
	 }
	
	
	
}