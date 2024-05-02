/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ForecastReportDBDAO.java
*@FileTitle : Forecast Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.Utils;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.basic.ForecastReportBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1048ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1049ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1081ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1082ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1083ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportCommonListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportDummyWeekVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportOptionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.PlannedRepoInVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EqrCtrlPlnRepoInQtyVO;
import com.hanjin.syscommon.common.table.EqrCtrlPlnRepoInVO;


/**
 * ALPS ForecastReportDBDAO <br>
 * - ALPS-MTYWeeklySimulation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see ForecastReportBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class ForecastReportDBDAO extends DBDAOSupport {

	/**
	 *  지점별로 향후 -2~+7 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @return CommonRsVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CommonRsVO searchForecastReportData(ForecastReportOptionVO forecastReportOptionVO) throws DAOException {
		 
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(forecastReportOptionVO != null){
				
				Map<String, String> mapVO = forecastReportOptionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchForecastReportDummyWeekRSQL(), param, velParam);
				List<ForecastReportDummyWeekVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ForecastReportDummyWeekVO.class);
				mapVO = list.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String fcastLocFlag = "";
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOcheckEqrCtrlFcastLocRSQL(), param, velParam);
				while(dbRowset.next()){
					fcastLocFlag = dbRowset.getString(1);
	            }
				velParam.put("fcast_loc_flag", fcastLocFlag);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchForecastReportRSQL(), param, velParam);
				commonRsVO.setDbRowset(dbRowset);
			
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	
	/**
	 *  지점별로 향후 -1~+4 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @return List<MtyWeeklySimulationVO>
	 * @throws DAOException
	 */
//	 @SuppressWarnings("unchecked")
//	public List<ForecastReportVO> searchMtyWeeklySimulation(ForecastReportOptionVO forecastReportOptionVO) throws DAOException {
//		DBRowSet dbRowset = null;
////		MtyWeeklySimulationVO list = new MtyWeeklySimulationVO();
//		List<ForecastReportVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(forecastReportOptionVO != null){
//				Map<String, String> mapVO = forecastReportOptionVO.getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchMtyWeeklySimulationRSQL(), param, velParam);
////			list.setDbRowset(dbRowset);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ForecastReportVO.class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}
	 
	/**
	 * User의 Office level을 체크
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String checkMtyBalanceRepoOutYard(String ofcCd)  throws DAOException {
		DBRowSet dbRowset = null;
		String levelCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOcheckUserOfficeLevelRSQL(), param, velParam);
            while(dbRowset.next()){
            	levelCd = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return levelCd;
	}
	 
	/**
	 * 해당 셀의 원래 값을 조회<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMtyWeeklySimulationOrigin(ForecastReportOptionVO forecastReportOptionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String cntrQty = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = forecastReportOptionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchMtyWeeklySimulationOriginRSQL(), param, velParam);
            while(dbRowset.next()){
            	cntrQty = dbRowset.getString("CNTR_QTY");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntrQty;
	}
	 
	/**
	 * 기존에 입력된 mty weekly data가 있는지 체크<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @return String
	 * @exception DAOException
	 */
	public int checkMtyWeeklySimulation(ForecastReportOptionVO forecastReportOptionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		int dup = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = forecastReportOptionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOcheckMtyWeeklySimulationRSQL(), param, velParam);
            while(dbRowset.next()){
            	dup = dbRowset.getInt("DUP");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dup;
	}
	 
	/**
	 * 기존에 입력된 mty weekly data를 수정<br>
	 * 
	 * @param List<ForecastReportOptionVO> forecastReportOptionVOs
	 * @exception DAOException
	 */
	public void modifyMtyWeeklySimulation(List<ForecastReportOptionVO> forecastReportOptionVOs)  throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updateCnt[] = null;
			if(forecastReportOptionVOs.size() > 0){
				updateCnt = sqlExe.executeBatch((ISQLTemplate)new ForecastReportDBDAOmodifyMtyWeeklySimulationUSQL(), forecastReportOptionVOs,null);
				for(int i = 0; i < updateCnt.length; i++){ 
					if(updateCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
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
	 * Weekly simulation 신규 사항을 저장<br>
	 * 
	 * @param List<ForecastReportOptionVO> forecastReportOptionVOs
	 * @exception DAOException
	 */
	public void addMtyWeeklySimulation(List<ForecastReportOptionVO> forecastReportOptionVOs)  throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insertCnt[] = null;
			if(forecastReportOptionVOs.size() > 0){
				insertCnt = sqlExe.executeBatch((ISQLTemplate)new ForecastReportDBDAOaddMtyWeeklySimulationCSQL(), forecastReportOptionVOs,null);
				for(int i = 0; i < insertCnt.length; i++){
					if(insertCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
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
	 * 기존에 입력된 mty weekly data를 삭제<br>
	 * 
	 * @param List<ForecastReportOptionVO> forecastReportOptionVOs
	 * @exception DAOException
	 */
	public void removeMtyWeeklySimulation(List<ForecastReportOptionVO> forecastReportOptionVOs)  throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updateCnt[] = null;
			if(forecastReportOptionVOs.size() > 0){
				updateCnt = sqlExe.executeBatch((ISQLTemplate)new ForecastReportDBDAOremoveMtyWeeklySimulationDSQL(), forecastReportOptionVOs,null);
				for(int i = 0; i < updateCnt.length; i++){
					if(updateCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
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
	 * Weekly simulation Report의 시트 헤더 타이틀 조회
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMtyWeeklySimulationReportTitle(ForecastReportOptionVO forecastReportOptionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer rptTtl = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int i = 0;
		try{
			Map<String, String> mapVO = forecastReportOptionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchMtyWeeklySimulationReportTitleRSQL(), param, velParam);
            while(dbRowset.next()){
            	rptTtl.append(((i == 0) ? "" : ",") + dbRowset.getString ("WEEK"));
            	i++;
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rptTtl.toString();
	}
	 
	 /**
	 * 지점별로 이전 수 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchMtyWeeklySimulationReport(ForecastReportOptionVO forecastReportOptionVO, String rptTtl) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(forecastReportOptionVO != null){ 
				Map<String, String> mapVO = forecastReportOptionVO .getColumnValues();
			
				List<String> arrweek = Utils.replaceStrToList(rptTtl);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrweek", arrweek);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchMtyWeeklySimulationReportRSQL(), param, velParam);
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
	
	/**
	 * 입력 받은 rcc/lcc/ecc가 해당 rcc에 속하는지 체크
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkSubLocCd(ForecastReportOptionVO forecastReportOptionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String check = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(forecastReportOptionVO != null){
				Map<String, String> mapVO = forecastReportOptionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOcheckSubLocCdRSQL(), param, velParam);
            while(dbRowset.next()){
            	check = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
	
	
// 1048 (S)

	/**
	 *  조회할 주차의 시작일과 종료일을 구한다.<br>
	 * 
	 * @param EesEqr1048ConditionVO eesEqr1048ConditionVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchWeekStEndDt(EesEqr1048ConditionVO eesEqr1048ConditionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String[] updateAval = new String[2];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String,String> mapVO = eesEqr1048ConditionVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchWeekStEndDtRSQL(), param, velParam);
            while(dbRowset.next()){
            	updateAval[0] = dbRowset.getString("WK_ST_DT");
            	updateAval[1] = dbRowset.getString("WK_END_DT");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updateAval;
	}

	/**
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param EesEqr1048ConditionVO eesEqr1048ConditionVO
	 * @return List<ForecastReportListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ForecastReportListVO> searchMtyRepoInDeatilList(EesEqr1048ConditionVO eesEqr1048ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ForecastReportListVO> list = null;			
		Map<String, Object> param = new HashMap<String, Object>(); //query parameter			
		Map<String, Object> velParam = new HashMap<String, Object>(); //velocity parameter

		try{
			if(eesEqr1048ConditionVO != null){ 
				Map<String, String> mapVO = eesEqr1048ConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
//				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchMtyBalanceRepoListRSQL(), param, velParam);
			log.debug(">>>>>>>>>>>>>>> DBDAO : searchMtyRepoInDeatilList 1");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchMtyRepoInDetailListRSQL(), param, velParam);
			log.debug(">>>>>>>>>>>>>>> DBDAO : searchMtyRepoInDeatilList 2");
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ForecastReportListVO .class);
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
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param EesEqr1048ConditionVO eesEqr1048ConditionVO
	 * @return List<ForecastReportListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ForecastReportListVO> searchMtyBalanceDischargedList(EesEqr1048ConditionVO eesEqr1048ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ForecastReportListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eesEqr1048ConditionVO != null){ 
				Map<String, String> mapVO = eesEqr1048ConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchMtyBalanceDischargedListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ForecastReportListVO .class);
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
	 * VVD를 이용해 slan cd를 조회한다.<br>
	 * 
	 * @param ForecastReportListVO forecastReportListVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMtyBalanceRepoOutSlanCd(ForecastReportListVO forecastReportListVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String slanCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String,String> mapVO = new HashMap<String,String>();
			mapVO.put("vvd",forecastReportListVO.getVvd());
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchMtyBalanceRepoOutSlanCdRSQL(), param, velParam);
            while(dbRowset.next()){
            	slanCd = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return slanCd;
	}

	/**
	* 특정 주차내의 일자 목록을 조회한다.<br>
	* 
	* @param String wk_st_dt
	* @return List<ForecastReportCommonListVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<ForecastReportCommonListVO> searchLocationDateList(String wk_st_dt) throws DAOException {
		DBRowSet dbRowset = null;
		List<ForecastReportCommonListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("wk_st_dt", wk_st_dt);
			velParam.put("wk_st_dt", wk_st_dt);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchLocationDateListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ForecastReportCommonListVO.class);
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
	 * LCC/ECC/SCC 에 속한 LOCATION<br>
	 * 
	 * @param String locGrpCd
	 * @param String locCd
	 * @return List<ForecastReportCommonListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ForecastReportCommonListVO> searchLocationList(String locGrpCd, String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ForecastReportCommonListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("loc_cd", locCd);
			param.put("loc_grp_cd", locGrpCd);
			velParam.put("loc_cd", locCd);
			velParam.put("loc_grp_cd", locGrpCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchLocationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ForecastReportCommonListVO.class);
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
	 *  입력받은 주차가 현재주차인지 확인한다.<br>
	 * 
	 * @param EesEqr1048ConditionVO eesEqr1048ConditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkCurrWeek(EesEqr1048ConditionVO eesEqr1048ConditionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String updateAval = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String,String> mapVO = new HashMap<String,String>();
			mapVO.put("fcast_yrwk",eesEqr1048ConditionVO.getFcastYrwk());
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOcheckCurrWeekRSQL(), param, velParam);
            while(dbRowset.next()){
            	updateAval = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updateAval;
	}	
	
// 1048 multi (S)	
	 /**
	 * ForeCast Report 의 Repo In 데이터 입력<br>
	 * 
	 * @param List<ForecastReportListVO> forecastReportListVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addMtyRepoInDetailList(List<ForecastReportListVO> forecastReportListVOs) throws DAOException,Exception {
		int insCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(forecastReportListVOs.size() > 0){
				Map<String, Object> param = new HashMap<String, Object>();
				
				Map<String, String> mapVO = null; 
				for(int i = 0; i < forecastReportListVOs.size(); i++){
					ForecastReportListVO forecastReportListVO = forecastReportListVOs.get(i);
					
					mapVO = forecastReportListVO.getColumnValues();
					param.putAll(mapVO);
					// duplicate 수행
					
					// insert 수행
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new ForecastReportDBDAOaddMtyRepoInDetailListCSQL(), param,null);
					if(insCnt== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
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
	 * ForeCast Report 의 Repo In 데이터 수정<br>
	 * 
	 * @param List<ForecastReportListVO> forecastReportListVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyMtyRepoInDetailList(List<ForecastReportListVO> forecastReportListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(forecastReportListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ForecastReportDBDAOmodifyMtyRepoInDetailListUSQL(), forecastReportListVOs,null);
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
	 * EQR_MTY_COD_RMK 의 remark 만 수정<br>
	 * 
	 * @param List<ForecastReportListVO> forecastReportListVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyMtyCodRemark(List<ForecastReportListVO> forecastReportListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(forecastReportListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ForecastReportDBDAOmodifyMtyCodRemarkCSQL(), forecastReportListVOs,null);
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
	 * ForeCast Report 의 Repo In 데이터 삭제<br>
	 * 
	 * @param List<ForecastReportListVO> forecastReportListVOs
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void removeMtyRepoInDetailList(List<ForecastReportListVO> forecastReportListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(forecastReportListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ForecastReportDBDAOremoveMtyRepoInDetailListDSQL(), forecastReportListVOs,null);
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
// 1048 multi (E)		
// 1048 (E)	
	
// 1040 (S)
	
	/**
	 *  PLANNED REPO IN 데이터를 조회한다<br>
	 * 
	 * @param EesEqr1048ConditionVO eesEqr1048ConditionVO
	 * @return List<PlannedRepoInVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PlannedRepoInVO> searchPlannedRepoInData(EesEqr1048ConditionVO eesEqr1048ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PlannedRepoInVO> list = null;			
		Map<String, Object> param = new HashMap<String, Object>(); //query parameter			
		Map<String, Object> velParam = new HashMap<String, Object>(); //velocity parameter

		try{
			if(eesEqr1048ConditionVO != null){ 
				Map<String, String> mapVO = eesEqr1048ConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			//ForecastReportDBDAOsearchPlannedRepoInRSQLRSQL
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchPlannedRepoInRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PlannedRepoInVO .class);
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
	 * ForeCast Report 의 PLANNED REPO IN 데이터 입력<br>
	 * 
	 * @param List<EqrCtrlPlnRepoInVO> eqrCtrlPlnRepoInVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPlannedRepoInManualData(List<EqrCtrlPlnRepoInVO> eqrCtrlPlnRepoInVOs) throws DAOException,Exception {
		int insCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlPlnRepoInVOs.size() > 0){
				Map<String, Object> param = new HashMap<String, Object>();
				
				Map<String, String> mapVO = null; 
				for(int i = 0; i < eqrCtrlPlnRepoInVOs.size(); i++){
					EqrCtrlPlnRepoInVO eqrCtrlPlnRepoInVO = eqrCtrlPlnRepoInVOs.get(i);
					
					mapVO = eqrCtrlPlnRepoInVO.getColumnValues();
					param.putAll(mapVO);
					
					// insert 수행
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new ForecastReportDBDAOaddPlannedRepoInManualCSQL(), param,null);
					if(insCnt== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
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
	 * ForeCast Report 의 PLANNED REPO IN 데이터 입력<br>
	 * 
	 * @param List<EqrCtrlPlnRepoInQtyVO> eqrCtrlPlnRepoInQtyVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPlannedRepoInManualQtyData(List<EqrCtrlPlnRepoInQtyVO> eqrCtrlPlnRepoInQtyVOs) throws DAOException,Exception {
		int insCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlPlnRepoInQtyVOs.size() > 0){
				Map<String, Object> param = new HashMap<String, Object>();
				
				Map<String, String> mapVO = null; 
				for(int i = 0; i < eqrCtrlPlnRepoInQtyVOs.size(); i++){
					EqrCtrlPlnRepoInQtyVO eqrCtrlPlnRepoInQtyVO = eqrCtrlPlnRepoInQtyVOs.get(i);
					
					mapVO = eqrCtrlPlnRepoInQtyVO.getColumnValues();
					param.putAll(mapVO);
					
					// insert 수행
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new ForecastReportDBDAOaddPlannedRepoInManualQtyCSQL(), param,null);
					if(insCnt== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
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
	 * Forecast Report 의 PLANNED REPO IN 데이터 수정<br>
	 * 
	 * @param List<EqrCtrlPlnRepoInVO> eqrCtrlPlnRepoInVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyPlannedRepoInManualData(List<EqrCtrlPlnRepoInVO> eqrCtrlPlnRepoInVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlPlnRepoInVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ForecastReportDBDAOmodifyPlannedRepoInManualUSQL(), eqrCtrlPlnRepoInVOs,null);
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
	 * Forecast Report 의 PLANNED REPO IN 데이터 수정<br>
	 * 
	 * @param List<EqrCtrlPlnRepoInQtyVO> eqrCtrlPlnRepoInQtyVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyPlannedRepoInManualQtyData(List<EqrCtrlPlnRepoInQtyVO> eqrCtrlPlnRepoInQtyVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlPlnRepoInQtyVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ForecastReportDBDAOmodifyPlannedRepoInManualQtyUSQL(), eqrCtrlPlnRepoInQtyVOs,null);
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
	 * ForeCast Report 의 PLANNED REPO IN 데이터 삭제<br>
	 * 
	 * @param List<EqrCtrlPlnRepoInVO> eqrCtrlPlnRepoInVOs
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void removePlannedRepoInManualData(List<EqrCtrlPlnRepoInVO> eqrCtrlPlnRepoInVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlPlnRepoInVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ForecastReportDBDAOremovePlannedRepoInManualDSQL(), eqrCtrlPlnRepoInVOs,null);
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
	 * ForeCast Report 의 PLANNED REPO IN 데이터 삭제<br>
	 * 
	 * @param List<EqrCtrlPlnRepoInQtyVO> eqrCtrlPlnRepoInQtyVOs
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void removePlannedRepoInManualQtyData(List<EqrCtrlPlnRepoInQtyVO> eqrCtrlPlnRepoInQtyVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(eqrCtrlPlnRepoInQtyVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ForecastReportDBDAOremovePlannedRepoInManualQtyDSQL(), eqrCtrlPlnRepoInQtyVOs, null);
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
	 * 해당 셀의 원래 값을 조회<br>
	 * 
	 * @param PlannedRepoInVO plannedRepoInVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchPlannedRepoInOriginData(PlannedRepoInVO plannedRepoInVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String cntrQty = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = plannedRepoInVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchPlannedRepoInOriginRSQL(), param, velParam);
            while(dbRowset.next()){
            	cntrQty = dbRowset.getString("CNTR_QTY");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntrQty;
	}
	
	/**
	 * EES_EQR_1040 화면 Yard 유효성 조회<br>
	 * 
	 * @param EesEqr1048ConditionVO eesEqr1048ConditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkPlannedRepoInYardData(EesEqr1048ConditionVO eesEqr1048ConditionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String cntrQty = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = eesEqr1048ConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOcheckPlannedRepoInYardRSQL(), param, velParam);
            while(dbRowset.next()){
            	cntrQty = dbRowset.getString("YARD_CHK");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntrQty;
	}	
	
	/**
	 *  Repo Out 데이터 조회한다<br>
	 * 
	 * @param EesEqr1049ConditionVO eesEqr1049ConditionVO
	 * @return List<ForecastReportListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ForecastReportListVO> searchMtyRepoOutDeatilList(EesEqr1049ConditionVO eesEqr1049ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ForecastReportListVO> list = null;			
		Map<String, Object> param = new HashMap<String, Object>(); //query parameter			
		Map<String, Object> velParam = new HashMap<String, Object>(); //velocity parameter

		try{
			if(eesEqr1049ConditionVO != null){ 
				Map<String, String> mapVO = eesEqr1049ConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchMtyRepoOutDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ForecastReportListVO .class);
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
	*  조회할 주차의 시작일과 종료일을 구한다.<br>
    * 
	* @param EesEqr1049ConditionVO eesEqr1049ConditionVO
	* @return String[]
	* @exception DAOException
	*/
	public String[] searchWeekStEndDt(EesEqr1049ConditionVO eesEqr1049ConditionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String[] updateAval = new String[2];

		Map<String, Object> param = new HashMap<String, Object>();  			//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			//velocity parameter

		try{
			Map<String,String> mapVO = eesEqr1049ConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchWeekStEndDtRSQL(), param, velParam);
		    while(dbRowset.next()){
		        updateAval[0] = dbRowset.getString("WK_ST_DT");
		        updateAval[1] = dbRowset.getString("WK_END_DT");
		    }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updateAval;
	}	 
		
	/**
	* ForeCast Report 의 Repo In 데이터 입력<br>
	* 
	* @param List<ForecastReportListVO> forecastReportListVOs
	* @throws DAOException
	* @throws Exception
	*/
	public void addMtyRepoOutDetailList(List<ForecastReportListVO> forecastReportListVOs) throws DAOException,Exception {
		int insCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(forecastReportListVOs.size() > 0){
				Map<String, Object> param = new HashMap<String, Object>();
					
				Map<String, String> mapVO = null; 
				for(int i = 0; i < forecastReportListVOs.size(); i++){
					ForecastReportListVO forecastReportListVO = forecastReportListVOs.get(i);
						
					mapVO = forecastReportListVO.getColumnValues();
					param.putAll(mapVO);
					// duplicate 수행
						
					// insert 수행
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new ForecastReportDBDAOaddMtyRepoOutDetailListCSQL(), param,null);
					if(insCnt== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
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
	 * ForeCast Report 의 Repo Out 데이터 수정<br>
	 * 
	 * @param List<ForecastReportListVO> forecastReportListVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyMtyRepoOutDetailList(List<ForecastReportListVO> forecastReportListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(forecastReportListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ForecastReportDBDAOmodifyMtyRepoOutDetailListUSQL(), forecastReportListVOs,null);
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
	 * ForeCast Report 의 Repo Out 데이터 삭제<br>
	 * 
	 * @param List<ForecastReportListVO> forecastReportListVOs
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void removeMtyRepoOutDetailList(List<ForecastReportListVO> forecastReportListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(forecastReportListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ForecastReportDBDAOremoveMtyRepoOutDetailListDSQL(), forecastReportListVOs,null);
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
	 *  Reposition In Detail Popup <br>
	 * 
	 * @param EesEqr1081ConditionVO eesEqr1081ConditionVO
	 * @return List<ForecastReportListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ForecastReportListVO> searchMtyRepoInDetailPastList(EesEqr1081ConditionVO eesEqr1081ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ForecastReportListVO> list = null;			
		Map<String, Object> param = new HashMap<String, Object>(); //query parameter			
		Map<String, Object> velParam = new HashMap<String, Object>(); //velocity parameter

		try{
			if(eesEqr1081ConditionVO != null){ 
				Map<String, String> mapVO = eesEqr1081ConditionVO.getColumnValues();
			
				String tp_cd = eesEqr1081ConditionVO.getTpCd();
				log.debug("tp_cd 0122------------- " +tp_cd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchMtyRepoInDetailPastListRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ForecastReportListVO .class);
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
		 *  Reposition Out Detail Popup <br>
		 * 
		 * @param EesEqr1082ConditionVO eesEqr1082ConditionVO
		 * @return List<ForecastReportListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<ForecastReportListVO> searchMtyRepoOutDetailPastList(EesEqr1082ConditionVO eesEqr1082ConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<ForecastReportListVO> list = null;			
			Map<String, Object> param = new HashMap<String, Object>();    //query parameter			
			Map<String, Object> velParam = new HashMap<String, Object>(); //velocity parameter

			try{
				if(eesEqr1082ConditionVO != null){ 
					Map<String, String> mapVO = eesEqr1082ConditionVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchMtyRepoOutDetailPastListRSQL(), param, velParam);

				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ForecastReportListVO .class);
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
		 *  Reposition Other Detail Popup <br>
		 * 
		 * @param EesEqr1083ConditionVO eesEqr1083ConditionVO
		 * @return List<ForecastReportListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<ForecastReportListVO> searchMtyRepoOtherDetailPastList(EesEqr1083ConditionVO eesEqr1083ConditionVO) throws DAOException {
		 	DBRowSet dbRowset = null;
		 	List<ForecastReportListVO> list = null;			
		 	Map<String, Object> param = new HashMap<String, Object>();    //query parameter			
		 	Map<String, Object> velParam = new HashMap<String, Object>(); //velocity parameter

		 	try{
		 		if(eesEqr1083ConditionVO != null){ 
		 			Map<String, String> mapVO = eesEqr1083ConditionVO.getColumnValues();
		 		
		 			param.putAll(mapVO);
		 			velParam.putAll(mapVO);
		 		}
		 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchMtyRepoOtherDetailPastListRSQL(), param, velParam);

		 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, ForecastReportListVO .class);
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
	  *  조회할 주차의 시작일과 종료일을 구한다.<br>
	  * 
	  * @param String fcast_yrwk
	  * @param String tp_cd
	  * @return String[]
	  * @exception DAOException
	  */
	 public String[] searchWeekStEndDtPast(String fcast_yrwk, String tp_cd)  throws DAOException {
	 	DBRowSet dbRowset = null;
	 	String[] updateAval = new String[2];
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try{
			param.put("fcast_yrwk", fcast_yrwk);
			velParam.put("fcast_yrwk", fcast_yrwk);
			velParam.put("tp_cd",      tp_cd);
			
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastReportDBDAOsearchWeekStEndCurrentDtRSQL(), param, velParam);
	         while(dbRowset.next()){
	         	updateAval[0] = dbRowset.getString("WK_ST_DT");
	         	updateAval[1] = dbRowset.getString("WK_END_DT");
	         }
	 	}catch(SQLException se){
	 		log.error(se.getMessage(),se);
	 		throw new DAOException(new ErrorHandler(se).getMessage());
	 	}catch(Exception ex){
	 		log.error(ex.getMessage(),ex);
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
	 	}
	 	return updateAval;
	 }
	 
// 1040 (E)	
}