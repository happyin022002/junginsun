/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DailyforecastmanageDBDAO.java
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.21 한상훈
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.08.14 [Trouble shooting] Accum 팝업 내 Period 변경 가능하도록 수정
* 2013.10.24 [선처리] Account Add/Del 과 Mapping 구분자 생성
* 2013.10.28 [CHM-201325350] 영업지원 Application 개발요청 - Others 저장시 Others 안에 있는 다른건 zero로 변경
* 2015.11.19 이혜민 [CHM-201538569] FCST Input > Account Add/Del 사용시 Data 확인 및 팝업처리 요청
* 2016.04.01 이혜민 [CHM-201640539] ALPS Live Out Of Memory Error 확인 및 조치 요청(Sales Rep이 몇 개의 Account를 체크했는지 개수 조회)
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.basic.DailyForecastManageBCImpl;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchAccumulatedGuidePfmcVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchContractForecastManageListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistoryOfcListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistorySrepAcctListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastManageListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastSrepAccountManageListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchLoadOfficeMappingListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchSalesRepInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.SpcCtrtFcastCustVO;
import com.hanjin.syscommon.common.table.SpcCtrtFcastOfcMapgVO;
import com.hanjin.syscommon.common.table.SpcDlyFcastCustVO;
import com.hanjin.syscommon.common.table.SpcSlsRepCustMapgVO;
import com.hanjin.syscommon.common.table.SpcSlsRepCustVO;


/**
 * ALPS DailyforecastmanageDBDAO <br>
 * - ALPS-DailyForecast system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Han Sang Hoon
 * @see DailyForecastManageBCImpl 참조
 * @since J2EE 1.6
 */
public class DailyForecastManageDBDAO extends DBDAOSupport {

	/**
	 * [ESM_SPC_0104] 정보를 [행위] 합니다.<br>
	 * 
	 * @param DailyforecastmanageConditionVO dailyforecastmanageConditionVO
	 * @return List<SearchDailyForecastHistoryOfcListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDailyForecastHistoryOfcListVO> searchDailyForecastHistoryOfcList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws DAOException {
	 	DBRowSet dbRowset = null;
		List<SearchDailyForecastHistoryOfcListVO> list = null;
	 	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dailyforecastmanageConditionVO != null){
				Map<String, String> mapVO = dailyforecastmanageConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchDailyForecastHistoryOfcListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDailyForecastHistoryOfcListVO .class);
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
	 * [ESM_SPC_0104] 정보를 [행위] 합니다.<br>
	 * 
	 * @param DailyforecastmanageConditionVO dailyforecastmanageConditionVO
	 * @return List<SearchDailyForecastHistorySrepAcctListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDailyForecastHistorySrepAcctListVO> searchDailyForecastHistorySrepAcctList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws DAOException {
	 	DBRowSet dbRowset = null;
		List<SearchDailyForecastHistorySrepAcctListVO> list = null;
	 	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dailyforecastmanageConditionVO != null){
				String multi_cust = dailyforecastmanageConditionVO.getCustomer();
				if(multi_cust != null && !multi_cust.equals("")){
					multi_cust = "'"+multi_cust.replaceAll(",", "','")+"'";
					dailyforecastmanageConditionVO.setCustomer(multi_cust);
				}
				
				Map<String, String> mapVO = dailyforecastmanageConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchDailyForecastHistorySrepAcctListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDailyForecastHistorySrepAcctListVO .class);
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
	 * [ESM_SPC_0103] 정보를 [행위] 합니다.<br>
	 * 
	 * @param DailyforecastmanageConditionVO dailyforecastmanageConditionVO
	 * @return List<SearchDailyForecastSrepAccountManageListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDailyForecastSrepAccountManageListVO> searchDailyForecastSrepAccountManageList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws DAOException {
	 	DBRowSet dbRowset = null;
		List<SearchDailyForecastSrepAccountManageListVO> list = null;
	 	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dailyforecastmanageConditionVO != null){
				Map<String, String> mapVO = dailyforecastmanageConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchDailyForecastSrepAccountManageListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDailyForecastSrepAccountManageListVO .class);
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
	 * [ESM_SPC_0103] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SpcSlsRepCustMapgVO spcSlsRepCustMapgVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addmultiDailyForecastSrepAccountManage(SpcSlsRepCustMapgVO spcSlsRepCustMapgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = spcSlsRepCustMapgVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DailyForecastManageDBDAOSpcSlsRepCustMapgCSQL(), param, velParam);
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
	 * [ESM_SPC_0103] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SpcSlsRepCustMapgVO spcSlsRepCustMapgVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiDailyForecastSrepAccountManage(SpcSlsRepCustMapgVO spcSlsRepCustMapgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = spcSlsRepCustMapgVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new DailyForecastManageDBDAOSpcSlsRepCustMapgUSQL(), param, velParam);
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
	 * [ESM_SPC_0103] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SpcSlsRepCustMapgVO spcSlsRepCustMapgVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removemultiDailyForecastSrepAccountManage(SpcSlsRepCustMapgVO spcSlsRepCustMapgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = spcSlsRepCustMapgVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new DailyForecastManageDBDAOSpcSlsRepCustMapgDSQL(), param, velParam);
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
	 * [ESM_SPC_0103] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcSlsRepCustMapgVO> spcSlsRepCustMapgVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiDailyForecastSrepAccountManageS(List<SpcSlsRepCustMapgVO> spcSlsRepCustMapgVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(spcSlsRepCustMapgVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcSlsRepCustMapgCSQL(), spcSlsRepCustMapgVO,null);
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
	 * [ESM_SPC_0103] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcSlsRepCustMapgVO> spcSlsRepCustMapgVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiDailyForecastSrepAccountManageS(List<SpcSlsRepCustMapgVO> spcSlsRepCustMapgVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(spcSlsRepCustMapgVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcSlsRepCustMapgUSQL(), spcSlsRepCustMapgVO,null);
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
	 * [ESM_SPC_0103] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcSlsRepCustMapgVO> spcSlsRepCustMapgVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiDailyForecastSrepAccountManageS(List<SpcSlsRepCustMapgVO> spcSlsRepCustMapgVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(spcSlsRepCustMapgVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcSlsRepCustMapgDSQL(), spcSlsRepCustMapgVO,null);
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
	 * [ESM_SPC_0102] 정보를 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchDailyForecastManageListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDailyForecastManageListVO> searchDailyForecastManage2List(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyForecastManageListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("suboffice_size", conditionVO.getSuboffice().length());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchDailyForecastManageListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDailyForecastManageListVO .class);
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
	 * [ESM_SPC_0102] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcDlyFcastCustVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpcDlyFcastCustS(List<SpcDlyFcastCustVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcDlyFcastCustCSQL(), insModels,null);
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
	 * [ESM_SPC_0102] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcDlyFcastCustVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpcDlyFcastCustS(List<SpcDlyFcastCustVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcDlyFcastCustUSQL(), updModels,null);
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
		return updCnt;
	}
	
	/**
	 * [ESM_SPC_0102] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcDlyFcastCustVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSpcDlyFcastCustS(List<SpcDlyFcastCustVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcDlyFcastCustDSQL(), delModels,null);
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
	 * [ESM_SPC_0102] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcDlyFcastCustVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpcDlyFcastCust2(List<SpcDlyFcastCustVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcDlyFcastCust2USQL(), updModels,null);
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
		return updCnt;
	}

	/**
	 * ESM_SPC_0106 : [이벤트]
	 * 한국지점 - Sales Rep 정보를 조회한다.
	 * 
	 * @param SearchSalesRepInfoVO searchSalesRepInfoVO
	 * @return List<SearchSalesRepInfoVO>
	 * @throws EventException
	 */
	public List<SearchSalesRepInfoVO> searchSalesRepList(SearchSalesRepInfoVO searchSalesRepInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSalesRepInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchSalesRepInfoVO != null){
				Map<String, String> mapVO = searchSalesRepInfoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchSlsRepInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSalesRepInfoVO .class);
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
	 * ESM_SPC_0106 : [이벤트]
	 * 한국지점 - Sales Rep별 Account 정보를 조회한다.
	 * 
	 * @param SearchSalesRepInfoVO searchSalesRepInfoVO
	 * @return List<SearchSalesRepInfoVO>
	 * @throws DAOException
	 */
	public List<SearchSalesRepInfoVO> searchSalesRepAccountList(SearchSalesRepInfoVO searchSalesRepInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSalesRepInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchSalesRepInfoVO != null){
							
				Map<String, String> mapVO = searchSalesRepInfoVO .getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchSlsRepAcctListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSalesRepInfoVO .class);
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
	 * ESM_SPC_0106 : SEARCHLIST03
	 * Individual 을 언체크 할경우 해당 S.Rep, 화주, S.office 에 이번주 이후에 물량을 준게 있는지 확인한다.
	 * 
	 * @param SearchSalesRepInfoVO searchSalesRepInfoVO
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> searchSalesRepVolExistList(SearchSalesRepInfoVO searchSalesRepInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> rsList = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchSalesRepInfoVO != null){
							
				Map<String, String> mapVO = searchSalesRepInfoVO .getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchSalesRepVolExistListRSQL(), param, velParam);
			if(dbRowset != null){
				while(dbRowset.next()){
					rsList.add(dbRowset.getString(1));
				}
			}		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsList;
	}
	
	/**
	 * ESM_SPC_0106 : [이벤트]
	 * 한국지점 - Sales Rep별 Account 정보를 관리한다.
	 * 
	 * @param List<SpcSlsRepCustVO> updateVoList
	 * @throws DAOException,Exception
	 */
	public void addmultiSalesRepAccountManageS(List<SpcSlsRepCustVO> updateVoList) throws DAOException,Exception {
		int insCnt[] = null;

		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList .size() > 0){
				velParam.put("sls_ofc_cd", updateVoList.get(0).getSlsOfcCd());
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcSlsRepCustCSQL(), updateVoList,velParam);
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
	}
	
	
	/**
	 * [ESM_SPC_0107] 정보를 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchDailyForecastManageListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDailyForecastManageListVO> searchDailyForecastManageListByKor(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyForecastManageListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				
				String multi_rlane = conditionVO.getLane();
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
					conditionVO.setLane(multi_rlane);
				}
				
				Map<String, String> mapVO = conditionVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
				velParam.put("suboffice_size", conditionVO.getSuboffice().length());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchDailyForecastManageListForKorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDailyForecastManageListVO .class);
			
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
	 * [ESM_SPC_0107] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcDlyFcastCustVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpcDlyFcastCustSForKor(List<SpcDlyFcastCustVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcDlyFcastCustForKorCSQL(), insModels,null);
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
	 * [ESM_SPC_0107] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcDlyFcastCustVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpcDlyFcastCustSForKor(List<SpcDlyFcastCustVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcDlyFcastCustForKorUSQL(), updModels,null);
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
		return updCnt;
	}

	/**
	 * ESM_SPC_0102 : [Retreive 전]<br>
	 * 해당 Sales Rep이 몇 개의 Account를 체크했는지 개수를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchSrepAccountCnt(ConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchSrepAccountCntRSQL(), param, velParam);
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
	 * [ESM_SPC_0109] 정보를 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchDailyForecastManageListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchContractForecastManageListVO> searchContractForecastManageList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchContractForecastManageListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				
				String multi_rlane = conditionVO.getLane();
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
					conditionVO.setLane(multi_rlane);
				}
				
				Map<String, String> mapVO = conditionVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
				velParam.put("suboffice_size", conditionVO.getSuboffice().length());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchContractForecastManageListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchContractForecastManageListVO .class);
			
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
	 * [ESM_SPC_0109] 정보를 [행위] 합니다.<br>
	 * Forecast Input(Contract) 정보를 입력 합니다.
	 * 
	 * @param List<SpcCtrtFcastCustVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiContractForecast(List<SpcCtrtFcastCustVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOContractForecastCSQL(), insModels,null);
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
	 * [ESM_SPC_0109] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcCtrtFcastCustVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiContractForecastHis(List<SpcCtrtFcastCustVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOContractForecastHisCSQL(), insModels,null);
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
	 * [ESM_SPC_0109] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcCtrtFcastCustVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiContractForecast(List<SpcCtrtFcastCustVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOContractForecastUSQL(), updModels,null);
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
		return updCnt;
	}
	
	/**
	 * [ESM_SPC_0110]을 [조회] 합니다.
	 *  
	 * @param ConditionVO conditionVO
	 * @return List<SearchDailyForecastHistorySrepAcctListVO>
	 * @exception EventException
	 */
	public List<SearchDailyForecastHistorySrepAcctListVO> searchPreviousSalesRepList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyForecastHistorySrepAcctListVO> list = null;
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchPreSrepListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDailyForecastHistorySrepAcctListVO .class);
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
	 * [ESM_SPC_0110]을 [저장] 합니다.
	 * 
	 * @param List<SearchDailyForecastManageListVO> updateVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception EventException
	 */
	public int[] addDailyForecastManageSwitch(List<SearchDailyForecastManageListVO> updateVoList)  throws DAOException,Exception {
		int insCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(updateVoList.size() > 0){
				String multi_rlane = updateVoList.get(0).getRlaneCd();
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
				}
				
				velParam.put("rlane_cd", multi_rlane);
				velParam.put("sub_trd_cd", updateVoList.get(0).getSubTrdCd());
				velParam.put("dir_cd", updateVoList.get(0).getDirCd());
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcDlyFcastCustSwitchCSQL(), updateVoList, velParam);
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
	 * [ESM_SPC_0110]을 [삭제] 합니다.
	 * 
	 * @param List<SearchDailyForecastManageListVO> deleteVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception EventException
	 */
	public int[] removePreSrepDailyForecastManage(List<SearchDailyForecastManageListVO> deleteVoList) throws DAOException,Exception {
		int delCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(deleteVoList.size() > 0){
				String multi_rlane = deleteVoList.get(0).getRlaneCd();
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
				}
				
				velParam.put("rlane_cd", multi_rlane);
				velParam.put("sub_trd_cd", deleteVoList.get(0).getSubTrdCd());
				velParam.put("dir_cd", deleteVoList.get(0).getDirCd());
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcDlyFcastCustSwitchUSQL(), deleteVoList,velParam);
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
	 * [ESM_SPC_0111] 정보를 [조회] 합니다.<br>
	 * 
	 * @param DailyforecastmanageConditionVO dailyforecastmanageConditionVO
	 * @return List<SearchLoadOfficeMappingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchLoadOfficeMappingListVO> searchLoadOfficeMappingList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLoadOfficeMappingListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(dailyforecastmanageConditionVO != null){
				
				Map<String, String> mapVO = dailyforecastmanageConditionVO .getColumnValues();
				
				String multi_rlane = dailyforecastmanageConditionVO.getLane();
				if(multi_rlane != null && !multi_rlane.equals("")){
					multi_rlane = "'"+multi_rlane.replaceAll(",", "','")+"'";
				}
				
				velParam.put("rlane_cd", multi_rlane);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchLoadOfficeMappingListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLoadOfficeMappingListVO .class);
			
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
	 * [ESM_SPC_0111]을 [저장] 합니다.
	 * 
	 * @param List<SpcCtrtFcastOfcMapgVO> insertVoList
	 * @throws DAOException,Exception
	 */
	public void addmultiLoadOfficeMappingList(List<SpcCtrtFcastOfcMapgVO> insertVoList) throws DAOException,Exception {
		int insCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(insertVoList.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcCtrtFcastOfcMapgCSQL(), insertVoList,velParam);
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
	}
	
	/**
	 * [ESM_SPC_0111]을 [저장] 합니다.
	 * 
	 * @param List<SpcCtrtFcastOfcMapgVO> deleteVoList
	 * @throws DAOException,Exception
	 */
	public void removemultiLoadOfficeMappingList(List<SpcCtrtFcastOfcMapgVO> deleteVoList) throws DAOException,Exception {
		int delCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(deleteVoList.size() > 0){
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcCtrtFcastOfcMapgDSQL(), deleteVoList,velParam);
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
	}
	
	/**
	 * [ESM_SPC_0112]을 [조회] 합니다.
	 * 본사에서 내려주는 Account 에 대한 S.REP 을 조회한다.
	 * 
	 * @param SearchSalesRepInfoVO searchSalesRepInfoVO
	 * @return List<SearchSalesRepInfoVO>
	 * @throws DAOException
	 */
	public List<SearchSalesRepInfoVO> searchAccountSrepList(SearchSalesRepInfoVO searchSalesRepInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSalesRepInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchSalesRepInfoVO != null){
							
				Map<String, String> mapVO = searchSalesRepInfoVO .getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchAccountSrepListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSalesRepInfoVO .class);
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
	 * [ESM_SPC_0112]을 [저장] 합니다.
	 * 본사에서 내려주는 Account 별 S.REP을 등록한다.
	 * 
	 * @param List<SpcSlsRepCustVO> updateVoList
	 * @throws DAOException,Exception
	 */
	public void addmultiAccountSrepList(List<SpcSlsRepCustVO> updateVoList) throws DAOException,Exception {
		int insCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(updateVoList.size() > 0){

				velParam.put("sls_ofc_cd", updateVoList.get(0).getSlsOfcCd());
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcSlsRepCustCSQL(), updateVoList,velParam);
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
	}
	
	/**
	 * [ESM_SPC_0112]을 [저장] 합니다.
	 * 본사에서 내려주는 Account 별 S.REP을 삭제한다.
	 * 
	 * @param List<SpcSlsRepCustVO> deleteVoList
	 * @param String pageName
	 * @throws DAOException,Exception
	 */
	public void removemultiAccountSrepList(List<SpcSlsRepCustVO> deleteVoList, String pageName) throws DAOException,Exception {
		int delCnt[] = null;
		
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(deleteVoList.size() > 0){
				
				if(pageName.equals("ESM_SPC_0112")){
					velParam.put("ui_title", "account_mapping");
				} else {					
					velParam.put("ui_title", "account_adddel");
				}
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOSpcSlsRepCustDSQL(), deleteVoList, velParam);
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
	}
	
	/**
	 * [ESM_SPC_0108] 정보를 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAccumulatedGuidePfmcVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchAccumulatedGuidePfmcVO> searchAccumulatedGuidePfmcList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAccumulatedGuidePfmcVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchAccumulatedGuidePfmcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAccumulatedGuidePfmcVO .class);
			
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
	 * Accum 화면에서 사용할 Season의 기초정보를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return ConditionVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ConditionVO searchSeasonPeriod(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ConditionVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchSeasonPeriodRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ConditionVO .class);
			if(list!=null && list.size()==1){
				return list.get(0);
			}else{
				return null;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Account Add/Del 저장시 기존에 mapping을 통해 저장된 데이터를 걸러내어 저장시 mapg_flg를 유지하도록 한다.<br>
	 * 
	 * @param SpcSlsRepCustVO spcSlsRepCustVO
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchOrgMapgFlg(SpcSlsRepCustVO spcSlsRepCustVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtn = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(spcSlsRepCustVO != null){
				
				Map<String, String> mapVO = spcSlsRepCustVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastManageDBDAOSearchOrgMapgFlgRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtn = dbRowset.getString(1);
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}
	
	/**
	 * [모바일] others fcast 입력시 내부에 존재하는 fcast를 0으로 update (alps는 화면내에서 control함)<br>
	 * 
	 * @param List<SpcDlyFcastCustVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyOthersFcastToZero(List<SpcDlyFcastCustVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DailyForecastManageDBDAOModifyOthersFcastToZeroUSQL(), updModels,null);
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
		return updCnt;
	}
	
};