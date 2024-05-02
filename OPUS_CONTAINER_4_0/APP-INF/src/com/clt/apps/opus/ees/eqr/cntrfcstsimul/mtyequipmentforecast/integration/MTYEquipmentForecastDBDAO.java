/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAO.java
*@FileTitle : MTY Balance Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/ 
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.cntrcommon.Utils;
import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.basic.MTYEquipmentForecastBCImpl;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.ForecastAccuracyListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.ForecastAccuracyOptionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.OpmgFcst3AvgVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.OpmgFcstInputVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS MTYEquipmentForecastDBDAO <br>
 * - OPUS-MTYEquipmentForecast system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kim jong jun
 * @see MTYEquipmentForecastBCImpl 참조
 * @since J2EE 1.6 
 */
public class MTYEquipmentForecastDBDAO extends DBDAOSupport {

	/**
	 * 과거 3주 분 실적과 향후 3주 까지의 OPMG Forecast Input data 를 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpmgFcstInputVO> searchOpmgFcstInputData(MtyBalanceOptionVO mtyBalanceOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpmgFcstInputVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchOpmgFcstInputRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpmgFcstInputVO.class);
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
	 * 과거 3주의 평균 OP, MG, Repo Out 을 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<OpmgFcst3AvgVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpmgFcst3AvgVO> searchOpmgFcst3AvgData(MtyBalanceOptionVO mtyBalanceOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpmgFcst3AvgVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchOpmgFcst3AvgRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpmgFcst3AvgVO.class);
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
	 * 직전 주차를 조회한다.<br>
	 * 
	 * @param String week
	 * @return String 
	 * @throws DAOException
	 */
	public String searchBeforeWeekData(String week) throws DAOException {
		DBRowSet dbRowset = null;
		String beforeweek = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(week != null){
				param.put("week", week);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchBeforeWeekRSQL(), param, null);
			
			while(dbRowset.next()){
				beforeweek = dbRowset.getString(1);
            }
			
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return beforeweek;
	}   
	 
	/**
	 * OPMG Forecast 화면의 Reference 2 데이터를 조회한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @param String kind
	 * @return CommonRsVO
	 * @throws DAOException
	 */
	 public CommonRsVO searchOpmgFcstReference2Data(MtyBalanceOptionVO mtyBalanceOptionVO, String kind) throws DAOException {
		 
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String w1 = "";
		String w2 = "";
		String w3 = "";
		String w4 = "";		
		String w1_f = "";
		String w2_f = "";
		String w3_f = "";
		String w4_f = "";		
		try{
			if(mtyBalanceOptionVO != null){

				Map<String, String> mapVO = mtyBalanceOptionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchOpmgFcstReference2TitleWeekRSQL(), param, velParam);
				while(dbRowset.next()){
	            	w1   = dbRowset.getString("w1");
	            	w2   = dbRowset.getString("w2");
	            	w3   = dbRowset.getString("w3");
	            	w4   = dbRowset.getString("w4");	            	
	            	w1_f = dbRowset.getString("w1_f");
	            	w2_f = dbRowset.getString("w2_f");
	            	w3_f = dbRowset.getString("w3_f");
	            	w4_f = dbRowset.getString("w4_f");	            	
	            }
				param.put("w1", w1);
				param.put("w2", w2);
				param.put("w3", w3);
				param.put("w4", w4);
				param.put("w1_f", w1_f);
				param.put("w2_f", w2_f);
				param.put("w3_f", w3_f);
				param.put("w4_f", w4_f);
				
				if(kind.equals("BKG"))
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchOpmgFcstReference2BkgRSQL(), param, velParam);
				else if(kind.equals("COP"))
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchOpmgFcstReference2CopRSQL(), param, velParam);
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
	 *  OP Forecast, MG Forecast 의 Log를 조회<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MtyBalanceListVO> searchMtyBalanceListLog(MtyBalanceOptionVO mtyBalanceOptionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchMtyBalanceLogRSQL(), param, velParam);
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
	 *  지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 생성,수정 여부 체크.<br>
	 * 
	 * @param MtyBalanceListVO mtyBalanceListVO
	 * @return int
	 * @exception DAOException
	 */
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
		 *  EQR_CTRL_MTY_BAL_RPT_HIS 의 RPT_SEQ 컬럼값 결정
		 * 
		 * @param MtyBalanceListVO mtyBalanceListVO
		 * @return int
		 * @exception DAOException
		 */
		public int checkMtyBalanceLogSeq(MtyBalanceListVO mtyBalanceListVO)  throws DAOException {
			DBRowSet dbRowset = null;
			int logSeq = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = mtyBalanceListVO.getColumnValues();
			 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOcheckMtyBalanceLogSeqRSQL(), param, velParam);
	            while(dbRowset.next()){
	            	logSeq = dbRowset.getInt(1);
	            }
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return logSeq;
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
	 *지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용의 로그<br>
	 * 
	 * @param List<MtyBalanceListVO> mtyBalanceListVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addMtyBalanceLog(List<MtyBalanceListVO> mtyBalanceListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mtyBalanceListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MTYEquipmentForecastDBDAOaddMtyBalanceLogCSQL(), mtyBalanceListVOs, null);
				
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
				String tpszText =  Utils.convertStr(forecastAccuracyOptionVO.getTpsztype());
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("tpszText", tpszText);
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
				String tpszText =  Utils.convertStr(forecastAccuracyOptionVO.getTpsztype());
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("tpszText", tpszText);
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
	 
//	/**
//	 *  repo_pln_id 값을 구한다.<br>
//	 * 
//	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
//	 * @return String
//	 * @exception DAOException
//	 */
//	public String searchRepoPlnId(MtyBalanceOptionVO mtyBalanceOptionVO)  throws DAOException {
//		DBRowSet dbRowset = null;
//		String updateAval = "";
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			Map<String,String> mapVO = new HashMap<String,String>();
//			mapVO.put("fcast_yrwk",mtyBalanceOptionVO.getFcastYrwk());
//		
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchRepoPlnIdRSQL(), param, velParam);
//            while(dbRowset.next()){
//            	updateAval = dbRowset.getString(1);
//            }
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return updateAval;
//	}		 
	
	/**
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return List<MtyBalanceRepoListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MtyBalanceRepoListVO> searchMtyBalanceRepoOut(MtyBalanceRepoListVO mtyBalanceRepoListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyBalanceRepoListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyBalanceRepoListVO != null){ 
				Map<String, String> mapVO = mtyBalanceRepoListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutRSQL(), param, velParam);
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
	 * VVD를 이용해 slan cd를 조회한다.<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMtyBalanceRepoOutSlanCd(MtyBalanceRepoListVO mtyBalanceRepoListVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String slanCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String,String> mapVO = new HashMap<String,String>();
			mapVO.put("vvd",mtyBalanceRepoListVO.getVvd());
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutSlanCdRSQL(), param, velParam);
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
	 *  VVD를 이용해 from yard list 및 etd dt를 조회한다.<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return List<MtyBalanceRepoListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MtyBalanceRepoListVO> searchMtyBalanceRepoOutFrYdList(MtyBalanceRepoListVO mtyBalanceRepoListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyBalanceRepoListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyBalanceRepoListVO != null){ 
				Map<String, String> mapVO = mtyBalanceRepoListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutFrYdListRSQL(), param, velParam);
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
	 *  VVD를 이용해 to yard list 및 etd dt를 조회한다.<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return List<MtyBalanceRepoListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MtyBalanceRepoListVO> searchMtyBalanceRepoOutToYdList(MtyBalanceRepoListVO mtyBalanceRepoListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyBalanceRepoListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyBalanceRepoListVO != null){ 
				Map<String, String> mapVO = mtyBalanceRepoListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchMtyBalanceRepoOutToYdListRSQL(), param, velParam);
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
	 * T/D VVD가 아닌 경우 입력된 yard cd가 해당 ecc/lcc/scc에 속하는지 체크<br>
	 * 
	 * @param MtyBalanceRepoListVO mtyBalanceRepoListVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkMtyBalanceRepoOutYard(MtyBalanceRepoListVO mtyBalanceRepoListVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String ydCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = mtyBalanceRepoListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOcheckMtyBalanceRepoOutYardRSQL(), param, velParam);
            while(dbRowset.next()){
            	ydCd = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ydCd;
	}
	 
	 /**
	 * EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 생성<br>
	 * 
	 * @param List<MtyBalanceRepoListVO> mtyBalanceRepoListVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addMtyBalanceRepoOut(List<MtyBalanceRepoListVO> mtyBalanceRepoListVOs) throws DAOException,Exception {
		int insCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mtyBalanceRepoListVOs.size() > 0){
				Map<String, Object> param = new HashMap<String, Object>();
				
				Map<String, String> mapVO = null; 
				for(int i = 0; i < mtyBalanceRepoListVOs.size(); i++){
					MtyBalanceRepoListVO mtyBalanceRepoListVO = mtyBalanceRepoListVOs.get(i);
					
					mapVO = mtyBalanceRepoListVO.getColumnValues();
					param.putAll(mapVO);
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new MTYEquipmentForecastDBDAOaddMtyBalanceRepoOutCSQL(), param,null);
					if(insCnt== Statement.EXECUTE_FAILED)
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
	 * EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 수정<br>
	 * 
	 * @param List<MtyBalanceRepoListVO> mtyBalanceRepoListVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyMtyBalanceRepoOut(List<MtyBalanceRepoListVO> mtyBalanceRepoListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mtyBalanceRepoListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MTYEquipmentForecastDBDAOmodifyMtyBalanceRepoOutUSQL(), mtyBalanceRepoListVOs,null);
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
	 * EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 삭제<br>
	 * 
	 * @param List<MtyBalanceRepoListVO> mtyBalanceRepoListVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeMtyBalanceRepoOut(List<MtyBalanceRepoListVO> mtyBalanceRepoListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mtyBalanceRepoListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MTYEquipmentForecastDBDAOremoveMtyBalanceRepoOutDSQL(), mtyBalanceRepoListVOs,null);
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
	 *  조회할 주차의 시작일과 종료일을 구한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchWeekStEndDt(MtyBalanceOptionVO mtyBalanceOptionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String[] updateAval = new String[2];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String,String> mapVO = mtyBalanceOptionVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchWeekStEndDtRSQL(), param, velParam);
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
	 * ECC 조회 시점, 해당 REPO ID 포함 4주치에 대한 O/B FCST D.TTL(Dry TTL)이 0 이상인지 체크<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkMtyBalanceLCCSave(MtyBalanceOptionVO mtyBalanceOptionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String saveFlag = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = mtyBalanceOptionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOcheckMtyBalanceLCCSaveRSQL(), param, velParam);
            while(dbRowset.next()){
            	saveFlag = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return saveFlag;
	}
	 
 /**
	 *  입력받은 주차가 현재주차인지 확인한다.<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkCurrWeek(MtyBalanceOptionVO mtyBalanceOptionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String updateAval = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String,String> mapVO = new HashMap<String,String>();
			mapVO.put("fcast_yrwk",mtyBalanceOptionVO.getFcastYrwk());
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOcheckCurrWeekRSQL(), param, velParam);
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
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceRepoListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MtyBalanceRepoListVO> searchMtyBalanceDischargedList(MtyBalanceOptionVO mtyBalanceOptionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchMtyBalanceDischargedListRSQL(), param, velParam);
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
		 
}