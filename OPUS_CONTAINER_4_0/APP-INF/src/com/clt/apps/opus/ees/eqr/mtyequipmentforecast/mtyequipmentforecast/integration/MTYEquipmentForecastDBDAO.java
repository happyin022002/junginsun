/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAO.java
*@FileTitle : MTY Balance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.23 김종준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.basic.MTYEquipmentForecastBCImpl;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.ForecastAccuracyListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.ForecastAccuracyOptionVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceCommonListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceReferenceListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 *  MTYEquipmentForecastDBDAO <br>
 * - -MTYEquipmentForecast system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kim jong jun
 * @see MTYEquipmentForecastBCImpl 참조
 * @since J2EE 1.6
 */
public class MTYEquipmentForecastDBDAO extends DBDAOSupport {

	/**
	 *  지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MtyBalanceListVO> searchMtyBalanceList(MtyBalanceOptionVO mtyBalanceOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyBalanceListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyBalanceOptionVO != null){
				Map<String, String> mapVO = mtyBalanceOptionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchMtyBalanceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyBalanceListVO .class);
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
	 * 지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance의 Referential Data를 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceReferenceListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MtyBalanceReferenceListVO> searchMtyBalanceReferenceList(MtyBalanceOptionVO mtyBalanceOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyBalanceReferenceListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyBalanceOptionVO != null){
				Map<String, String> mapVO = mtyBalanceOptionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchMtyBalanceReferenceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyBalanceReferenceListVO .class);
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
	 *  지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 생성,수정 여부 체크.<br>
	 * 
	 * @param MtyBalanceListVO mtyBalanceListVO
	 * @return int
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public int checkAddModifyMtyBalance(MtyBalanceListVO mtyBalanceListVO)  throws DAOException {
		DBRowSet dbRowset = null;
		int checkAddModifyMtyCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = mtyBalanceListVO.getColumnValues();
		 
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOcheckAddModifyMtyBalanceRSQL(), param, velParam);
            while(dbRowset.next()){
            	checkAddModifyMtyCnt = dbRowset.getInt(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkAddModifyMtyCnt;
	}	 
	 
	/**
	 *지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 생성<br>
	 * 
	 * @param List<MtyBalanceListVO> mtyBalanceListVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addMtyBalance(List<MtyBalanceListVO> mtyBalanceListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mtyBalanceListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MTYEquipmentForecastDBDAOaddMtyBalanceCSQL(), mtyBalanceListVOs,null);
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
	 *지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 수정<br>
	 * 
	 * @param List<MtyBalanceListVO> mtyBalanceListVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMtyBalance(List<MtyBalanceListVO> mtyBalanceListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mtyBalanceListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MTYEquipmentForecastDBDAOmodifyMtyBalanceUSQL(), mtyBalanceListVOs,null);
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
	 *  해당 Yard 의 장비인수 및 임차계획 수량,장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 입력한 내용을 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalRptOtrVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MtyBalRptOtrVO> searchMtyBalanceOtherList(MtyBalanceOptionVO mtyBalanceOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyBalRptOtrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyBalanceOptionVO != null){
				Map<String, String> mapVO = mtyBalanceOptionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchMtyBalanceOtherListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyBalRptOtrVO .class);
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
	 * ECC내 소속 야드 를 조회한다<br>
	 * 
	 * @param String eccCd
	 * @return List<MtyBalanceCommonListVO>
	 * @exception DAOException
	 */
	public List<MtyBalanceCommonListVO> searchYardList(String eccCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyBalanceCommonListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("ecc_cd", eccCd);
			velParam.put("ecc_cd", eccCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchYardListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyBalanceCommonListVO.class);
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
	 * 특정 주차내의 일자 목록을 조회한다.<br>
	 * 
	 * @param String yearWeek
	 * @return List<MtyBalanceCommonListVO>
	 * @exception DAOException
	 */
	public List<MtyBalanceCommonListVO> searchDateListByWeek(String yearWeek) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyBalanceCommonListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("year_week", yearWeek);
			velParam.put("year_week", yearWeek);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchDateListByWeekRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyBalanceCommonListVO.class);
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
	 * 해당 Yard 의 장비인수 및 임차계획 수량, 장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 생성<br>
	 * 
	 * @param List<MtyBalRptOtrVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addMtyBalanceOther(List<MtyBalRptOtrVO> insModels) throws DAOException,Exception 
	{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MTYEquipmentForecastDBDAOaddMtyBalanceOtherCSQL(), insModels,null);
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
	 * 해당 Yard 의 장비인수 및 임차계획 수량,장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 수정<br>
	 * 
	 * @param List<MtyBalRptOtrVO> updateModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyEqStatusCodeData(List<MtyBalRptOtrVO> updateModels) throws DAOException,Exception 
	{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updateCnt[] = null;
			if(updateModels.size() > 0){
				updateCnt = sqlExe.executeBatch((ISQLTemplate)new MTYEquipmentForecastDBDAOmodifyMtyBalanceOtherUSQL(), updateModels,null);
				for(int i = 0; i < updateCnt.length; i++){
					if(updateCnt[i]== Statement.EXECUTE_FAILED)
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
	 * 해당 Yard 의 장비인수 및 임차계획 수량,장비수급에 영향을 미치는 EQ Demand & Supply의 기타항목들을 Manual로 삭제한다<br>
	 * 
	 * @param List<MtyBalRptOtrVO> deleteModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeMtyBalanceOther(List<MtyBalRptOtrVO> deleteModels) throws DAOException,Exception 
	{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int deleteCnt[] = null;
			if(deleteModels.size() > 0){
				deleteCnt = sqlExe.executeBatch((ISQLTemplate)new MTYEquipmentForecastDBDAOremoveMtyBalanceOtherDSQL(), deleteModels,null);
				for(int i = 0; i < deleteCnt.length; i++){
					if(deleteCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceRepoListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MtyBalanceRepoListVO> searchMtyBalanceRepoList(MtyBalanceOptionVO mtyBalanceOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyBalanceRepoListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyBalanceOptionVO != null){ 
				Map<String, String> mapVO = mtyBalanceOptionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchMtyBalanceRepoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyBalanceRepoListVO .class);
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
	 *  주차와 입력 시간에 따라 업데이트 불가 여부를 체크한다.<br>
	 * 
	 * @param String locCd
	 * @param String inputYearWeek
	 * @param String chkTypeCd
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String validationUpdateAval(String locCd,String inputYearWeek,String chkTypeCd)  throws DAOException {
		DBRowSet dbRowset = null;
		String updateAval = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String,String> mapVO = new HashMap<String,String>();
			mapVO.put("loc_cd",locCd);
			mapVO.put("input_year_week",inputYearWeek);
			mapVO.put("chk_tp_cd",chkTypeCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOvalidationUpdateAvalRSQL(), param, velParam);
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
	 
	/**
	 *  MTY Balance Report의 In&Out Bound FCST Data의 정확도를 WEEK별로 조회<br>
	 * 
	 * @param ForecastAccuracyOptionVO forecastAccuracyOptionVO
	 * @return List<ForecastAccuracyListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ForecastAccuracyListVO> searcForecastAccuracyListByWeek(ForecastAccuracyOptionVO forecastAccuracyOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ForecastAccuracyListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(forecastAccuracyOptionVO != null){
				Map<String, String> mapVO = forecastAccuracyOptionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearcForecastAccuracyListByWeekRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ForecastAccuracyListVO .class);
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
	 *  MTY Balance Report의 In&Out Bound FCST Data의 정확도를 FACTOR별로 조회<br>
	 * 
	 * @param ForecastAccuracyOptionVO forecastAccuracyOptionVO
	 * @return List<ForecastAccuracyListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ForecastAccuracyListVO> searcForecastAccuracyListByFactor(ForecastAccuracyOptionVO forecastAccuracyOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ForecastAccuracyListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(forecastAccuracyOptionVO != null){
				Map<String, String> mapVO = forecastAccuracyOptionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearcForecastAccuracyListByFactorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ForecastAccuracyListVO .class);
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
	 *  repo_pln_id 값을 구한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchRepoPlnId(MtyBalanceOptionVO mtyBalanceOptionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String updateAval = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String,String> mapVO = new HashMap<String,String>();
			mapVO.put("fcast_yrwk",mtyBalanceOptionVO.getRepoPlnYrwk());
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchRepoPlnIdRSQL(), param, velParam);
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
	 
		 
}