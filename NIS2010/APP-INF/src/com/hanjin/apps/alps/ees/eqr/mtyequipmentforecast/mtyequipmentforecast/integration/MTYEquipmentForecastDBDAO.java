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
* 2013.02.21 신용찬 [CHM-201323022]    OP/MG FCST HISTORY 화면생성
=========================================================*/ 
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.basic.MTYEquipmentForecastBCImpl;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.ForecastAccuracyListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.ForecastAccuracyOptionVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceCommonListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceReferenceListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS MTYEquipmentForecastDBDAO <br>
 * - ALPS-MTYEquipmentForecast system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
		 *  EQR_MTY_BAL_RPT_HIS 의 RPT_SEQ 컬럼값 결정
		 * 
		 * @param MtyBalanceListVO mtyBalanceListVO
		 * @return int
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
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
	 * ECC내 소속 야드 를 조회한다<br>
	 * 
	 * @param String locGrpCd
	 * @param String locCd
	 * @return List<MtyBalanceCommonListVO>
	 * @exception DAOException
	 */
	public List<MtyBalanceCommonListVO> searchYardList(String locGrpCd, String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyBalanceCommonListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("loc_cd", locCd);
			param.put("loc_grp_cd", locGrpCd);
			velParam.put("loc_cd", locCd);
			velParam.put("loc_grp_cd", locGrpCd);

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
		 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
		 * 
		 * @param MtyBalanceOptionVO mtyBalanceOptionVO
		 * @return List<MtyBalanceRepoListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<MtyBalanceRepoListVO> searchMtyRepoInDeatilList(MtyBalanceOptionVO mtyBalanceOptionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<MtyBalanceRepoListVO> list = null;			
			Map<String, Object> param = new HashMap<String, Object>(); //query parameter			
			Map<String, Object> velParam = new HashMap<String, Object>(); //velocity parameter

			try{
				if(mtyBalanceOptionVO != null){ 
					Map<String, String> mapVO = mtyBalanceOptionVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
//				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchMtyBalanceRepoListRSQL(), param, velParam);
				log.debug(">>>>>>>>>>>>>>> DBDAO : searchMtyRepoInDeatilList 1");
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchMtyRepoInDetailListRSQL(), param, velParam);
				log.debug(">>>>>>>>>>>>>>> DBDAO : searchMtyRepoInDeatilList 2");
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
			mapVO.put("fcast_yrwk",mtyBalanceOptionVO.getFcastYrwk());
		
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
	 @SuppressWarnings("unchecked")
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
	 @SuppressWarnings("unchecked")
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
	 * ForeCast Report 의 Repo In 데이터 입력<br>
	 * 
	 * @param List<MtyBalanceRepoListVO> mtyBalanceRepoListVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addMtyRepoInDetailList(List<MtyBalanceRepoListVO> mtyBalanceRepoListVOs) throws DAOException,Exception {
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
					// duplicate 수행
					
					// insert 수행
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new MTYEquipmentForecastDBDAOaddMtyRepoInDetailListCSQL(), param,null);
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
	 * @param List<MtyBalanceRepoListVO> mtyBalanceRepoListVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyMtyRepoInDetailList(List<MtyBalanceRepoListVO> mtyBalanceRepoListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mtyBalanceRepoListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MTYEquipmentForecastDBDAOmodifyMtyRepoInDetailListUSQL(), mtyBalanceRepoListVOs,null);
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
	 * @param List<MtyBalanceRepoListVO> mtyBalanceRepoListVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyMtyCodRemark(List<MtyBalanceRepoListVO> mtyBalanceRepoListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mtyBalanceRepoListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MTYEquipmentForecastDBDAOmodifyMtyCodRemarkCSQL(), mtyBalanceRepoListVOs,null);
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
	 * @param List<MtyBalanceRepoListVO> mtyBalanceRepoListVOs
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void removeMtyRepoInDetailList(List<MtyBalanceRepoListVO> mtyBalanceRepoListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mtyBalanceRepoListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MTYEquipmentForecastDBDAOremoveMtyRepoInDetailListDSQL(), mtyBalanceRepoListVOs,null);
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
	 @SuppressWarnings("unchecked")
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
	 @SuppressWarnings("unchecked")
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
	 @SuppressWarnings("unchecked")
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
	 
		/**
		 * LCC/ECC/SCC 에 속한 LOCATION<br>
		 * 
		 * @param String locGrpCd
		 * @param String locCd
		 * @return List<MtyBalanceCommonListVO>
		 * @exception DAOException
		 */
		public List<MtyBalanceCommonListVO> searchLocationList(String locGrpCd, String locCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<MtyBalanceCommonListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				param.put("loc_cd", locCd);
				param.put("loc_grp_cd", locGrpCd);
				velParam.put("loc_cd", locCd);
				velParam.put("loc_grp_cd", locGrpCd);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchLocationListRSQL(), param, velParam);
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
	* @param String wk_st_dt
	* @return List<MtyBalanceCommonListVO>
	* @exception DAOException
	*/
	public List<MtyBalanceCommonListVO> searchLocationDateList(String wk_st_dt) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyBalanceCommonListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("wk_st_dt", wk_st_dt);
			velParam.put("wk_st_dt", wk_st_dt);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYEquipmentForecastDBDAOsearchLocationDateListRSQL(), param, velParam);
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
	 
		 
}