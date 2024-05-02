/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeRHQDBDAO.java
*@FileTitle : Monthly Sales Quota Adjustment Trade - RHQ
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : CHOI.M.C
*@LastVersion : 1.0
* 2007-02-23 byyoo
* 1.0 Creation
* 2008.01.28 - procAdjustmentLoadRoundOff 함수 추가 - YJ.Byeon 
* 2008-02-11 Lee Ho Ik       : Recent Quota 조회부분 수정 (saq_mon_qta -> saq_mon_cfm_qta)
* 2008-02-11 Byeon Young Joo : createMonthlyAdjustmentRhqRgnInfo, createSaqMonQtaRhq 의 SAQ_MON_QTA_RHQ 초기값 수정 ( ctrt_aq_cd, ofc_add_flg 추가) 
* 2008-02-12 Lee Ho Ik       : Direction Conversion Logic 수행 
* 2008-04-02 YJBYEON         : CSR - N200803255636, cfm_qta 표기시 Direction Conversion 적용 
* 2008.09.24 Y.S.CHOI        : CSR No. N200809240008
*                              - searchMonthlyQuotaAdjustmentTradeRhqList, searchMonthlyAdjustmentTradeRhqTabLaneList
*                              ㆍqta_tgt_cd = 'Q' 조건 추가
* 2008.10.08 Y.S.CHOI        : - searchMonthlyQuotaAdjustmentTradeRhqList, searchMonthlyAdjustmentTradeRhqTabLaneList
*                              ㆍSAQ_YRY_QTA_RLSE 테이블 qta_tgt_cd = 'Q' 조건 추가.
* 2009.04.01 Kim MIn Ah      : CSR No.R200903270002 - 품질검토 결과조치
* 						       createSAQ_MON_QTA_OFC_MOD_MIX() - 파라미터중 bse_mon 제거
* 2010.05.12 Kim Min Ah : 한달 판매목표 수립을 위한 수정
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.basic.MonthlyQuotaAdjustmentTradeRHQBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.vo.SearchMonthlyAdjustmentTradeRhqTabLaneListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.vo.SearchMonthlyQuotaAdjustmentTradeRhqListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.vo.SearchMonthlyQuotaAdjustmentTradeRhqModifyListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SaqMonQtaTrdVO;


/**
 * MonthlyQuotaAdjustmentTradeRHQDBDAO <br>
 * - MonthlySalesQuotaManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author ChoiI.M.C
 * @see MonthlyQuotaAdjustmentTradeRHQBCImpl 참조
 * @since J2EE 1.6
 */
public class MonthlyQuotaAdjustmentTradeRHQDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * CheckKey 조회
	 * @param EsmSaq0076ConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet getPreviousCheckKey0085(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOGetPreviousCheckKey0085RSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * saq_mon_qta_step_ver 의 신규 mqta_ver_no 를 구한다.
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSaqMonQtaStepTrdLane0085List(QuotaConditionVO conditionVO) throws DAOException {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String rlaneCd = "";
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOSearchSaqMonQtaStepTrdLane0085ListRSQL(), param, velParam);
				if(dbRowset.next()){
					rlaneCd = dbRowset.getString(1);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rlaneCd;
	}
	 
	/**
	 * MonthlyQuotaAdjustmentTradeRHQ 조정을 위한 조회
	 * 2008.1.25 : 조회조건 추가 관련 sub_trd_cd 추가. Y.S.CHOI
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaAdjustmentTradeRhqListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaAdjustmentTradeRhqListVO> searchMonthlyQuotaAdjustmentTradeRhq0085List01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaAdjustmentTradeRhqListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				param.put("bef_yr_qtr", SAQUtil.getBefYrQtr(conditionVO.getYear()+conditionVO.getBse_quarter()));
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOSearchMonthlyQuotaAdjustmentTradeRhq0085List01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaAdjustmentTradeRhqListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * MonthlyQuotaAdjustmentTradeRHQ의 상단 TAB Lane의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyAdjustmentTradeRhqTabLaneListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyAdjustmentTradeRhqTabLaneListVO> searchMonthlyAdjustmentTradeRhq0085Tab03(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyAdjustmentTradeRhqTabLaneListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				param.put("bef_yr_qtr", SAQUtil.getBefYrQtr(conditionVO.getYear()+conditionVO.getBse_quarter()));
				param.put("pfmc_fr_yr_mon", conditionVO.getPfmc_fr_year()+conditionVO.getPfmc_fr_month());
				param.put("pfmc_to_yr_mon", conditionVO.getPfmc_to_year()+conditionVO.getPfmc_to_month());
				param.put("pfmc_fr_yr_qtr", SAQUtil.getYrMonToYrQtr(conditionVO.getPfmc_fr_year()+conditionVO.getPfmc_fr_month()));
				param.put("pfmc_to_yr_qtr", SAQUtil.getYrMonToYrQtr(conditionVO.getPfmc_to_year()+conditionVO.getPfmc_to_month()));
				
				//Foreach문에서 쓰일 velocity 변수 선언 및 value 셋팅
				List<String> cols = new ArrayList();
				cols.add("1");
				cols.add("2");
				cols.add("3");
				
				velParam.put("monthseq", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOSearchMonthlyAdjustmentTradeRhq0085Tab03RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyAdjustmentTradeRhqTabLaneListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * MonthlyQuotaAdjustmentTradeRHQ 의 Save 와 Save As New Version 을 처리한다.<br>
	 * @param List<SaqMonQtaTrdVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateMonthlyAdjustmentTradeRhq0085(List<SaqMonQtaTrdVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt[] = null;
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int unit_flag = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				velParam.put("unit_flag", unit_flag);
			}
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOUpdateMonthlyAdjustmentTradeRhq0085USQL(), updModels, velParam);
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
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * saq_mon_qta_step_ver 의 신규 mqta_ver_no 를 구한다.
	 * @param EsmSaq0048ConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */	 
	public String getNewMonthlyQuotaStepVersionNumber0085(QuotaConditionVO conditionVO) throws DAOException {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String newVersionNo = "";
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOGetNewMonthlyQuotaStepVersionNumber0085RSQL(), param, velParam);
				if(dbRowset.next()){
					newVersionNo = dbRowset.getString("new_ver_no");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return newVersionNo;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * MonthlyQuotaAdjustmentTrade 의 Save As New Version 을 처리한다.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createMonthlyAdjustmentTradeRhqInfoA0085(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
             
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOCreateMonthlyAdjustmentTradeRhqInfoA0085CSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * MonthlyQuotaAdjustmentTrade 의 Save As New Version 을 처리한다.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createMonthlyAdjustmentTradeRhqInfoB0085(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOCreateMonthlyAdjustmentTradeRhqInfoB0085CSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * MonthlyQuotaAdjustmentTrade 의 Save As New Version 을 처리한다.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createSaqMonQtaOfcModMix0085(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOCreateSaqMonQtaOfcModMix0085CSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 모든 Version이 XX 상태 인지 검사 한다.
	 * @param QuotaConditionVO conditionVO
	 * @return int
	 * @throws DAOException
	 */ 
	public int checkCancelAllCurrentVersion0085(QuotaConditionVO conditionVO) throws DAOException {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int cnt = 0;
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOCheckCancelAllCurrentVersion0085RSQL(), param, velParam);
				if(dbRowset.next()){
					cnt = dbRowset.getInt("cnt");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	 
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * saq_mon_qta_step_ver 의 saq_sts_cd 변경
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySaqMonQtaStepVerStatus0085(QuotaConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				velParam.put("newSaqStsCd", conditionVO.getStatusCd());

				SQLExecuter sqlExe = new SQLExecuter("");
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOModifySaqMonQtaStepVerStatus0085USQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int getSaqStsCdIngCount0085(QuotaConditionVO conditionVO) throws DAOException {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int cnt = 0;
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOGetSaqStsCdIngCount0085RSQL(), param, velParam);
				if(dbRowset.next()){
					cnt = dbRowset.getInt("sts_cnt");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * Load에 소수점 이하 자리 존재여부
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String getLoadRoundOffNeedMonth0085(QuotaConditionVO conditionVO) throws DAOException {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String ret = "";
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOGetLoadRoundOffNeedMonth0085RSQL(), param, velParam);
				if(dbRowset.next()){
					ret = ret + dbRowset.getString("mon") + "/";
				}
				
				if (ret.length() > 0) {
					ret = ret.substring(0, ret.length()-1);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ret;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * MonthlyQuotaAdjustmentTrade 의 Save As New Version 을 처리한다.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createSaqMonFxMdlSmry0085(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOCreateSaqMonFxMdlSmry0085CSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * MonthlyQuotaAdjustmentTrade 의 Save As New Version 을 처리한다.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createMonthlyAdjustmentRhqRgnInfoA0085(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOCreateMonthlyAdjustmentRhqRgnInfoA0085CSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * MonthlyQuotaAdjustmentTrade 의 Save As New Version 을 처리한다.
	 * @param QuotaConditionVO conditionVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createMonthlyAdjustmentRhqRgnInfoB0085(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOCreateMonthlyAdjustmentRhqRgnInfoB0085CSQL(), param, velParam);
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
	 * Load에 소수점 이하 자리 존재여부
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String getMonthlyQuotaStepVersionNumber0085(QuotaConditionVO conditionVO) throws DAOException {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String mqtaVerNo = "";
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOGetMonthlyQuotaStepVersionNumber0085RSQL(), param, velParam);
				if(dbRowset.next()){
					mqtaVerNo = dbRowset.getString("mqta_ver_no");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mqtaVerNo;
	}
	 
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 기존 version을 delete한다.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */ 
	public void deleteSaqMonQtaStepVer0085(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAODeleteSaqMonQtaStepVer0085DSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * MonthlyQuotaAdjustmentTrade 의 Save As New Version 을 처리한다.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */ 
	public void createSaqMonQtaStepVer0085(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOCreateSaqMonQtaStepVer0085CSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * MonthlyQuotaAdjustmentTrade 의 Save As New Version 을 처리한다.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createSaqMonQtaRhq0085(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOCreateSaqMonQtaRhq0085CSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * saq_qta_rnd_off_pkg.mon_qta_round_off() 호출
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void procAdjustmentLoadRoundOff(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
			
		try{

//			Map<String, String> mapVO = conditionVO .getColumnValues();
//			param.putAll(mapVO);

			// param 매핑

			param.put("mqtaStepCd", conditionVO.getMQtaStepCd());
			param.put("bseYr"     , conditionVO.getYear());
			param.put("bseQtrCd"  , conditionVO.getBse_quarter());
			param.put("trdCd"     , conditionVO.getTrade());
			param.put("dirCd"     , conditionVO.getBound());
			param.put("mQtaVerNo" , conditionVO.getMQtaVerNo());

			new SQLExecuter("").executeSP((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOCallMonQtaRoundOffUSQL(), param, null);
			
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
	 * MonthlyQuotaAdjustmentTrade 의 Save As New Version 을 처리한다.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */ 
	public void modifySaqMonQtaTrdRmkStatus0085(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOModifySaqMonQtaTrdRmkStatus0085USQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * Load에 소수점 이하 자리 존재여부
	 * @param QuotaConditionVO conditionVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean isAllNotifyRhq0085(QuotaConditionVO conditionVO) throws DAOException {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		boolean result = false;
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOIsAllNotifyRhq0085RSQL(), param, velParam);
				if(dbRowset.next()){
					result = (dbRowset.getString(1).equals("T") ? true : false);
				}
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
	 * Load에 소수점 이하 자리 존재여부
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSaqMonQtaStepVer020085(QuotaConditionVO conditionVO) throws DAOException {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String newVersion = "";
		String loginOfcCd = "";
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부조건 셋팅
				velParam.put("loginOfcCd", loginOfcCd);

				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOSearchSaqMonQtaStepVer020085RSQL(), param, velParam);
				if(dbRowset.next()){
					newVersion = dbRowset.getString("mqta_ver_no");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return newVersion;
	}

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * Final (STEP 03) 초기 정보 생성1
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createMonthlyAdjustmentTradeFinalInfoA0085(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOCreateMonthlyAdjustmentTradeFinalInfoA0085CSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * Final (STEP 03) 초기 정보 생성2
	 * @param QuotaConditionVO conditionVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createMonthlyAdjustmentTradeFinalInfoB0085(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOCreateMonthlyAdjustmentTradeFinalInfoB0085CSQL(), param, velParam);
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
	 * trd_cd, dir_cd, gline_ver_no 가 같은 STEP 의 특정 상태 진행 건수를 구한다.
	 * @param QuotaConditionVO conditionVO
	 * @return int
	 * @throws DAOException
	 */
	public int getSaqStsCdCount0085(QuotaConditionVO conditionVO) throws DAOException {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int cnt = 0;
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOGetSaqStsCdCount0085RSQL(), param, velParam);
				if(dbRowset.next()){
					cnt = dbRowset.getInt("sts_cnt");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * trd_cd, dir_cd, mqta_ver_no의 조회키별 Load 합이 0인 월을 체크하여 문자열로 리턴.
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String getListByLoadZero0085(QuotaConditionVO conditionVO) throws DAOException {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String ret = "";
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOGetListByLoadZero0085RSQL(), param, velParam);
				
				StringBuffer sb = new StringBuffer(); //소스 품질 수정 요청건
				
				while(dbRowset.next()){				
					//ret = ret + "- " + dbRowset.getString("msg") + " \n";
					sb.append("- ").append(dbRowset.getString("msg")).append(" \n"); //소스 품질 수정 요청건
				}
				
				ret = sb.toString(); //소스 품질 수정 요청건
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ret;
	}
	
	/**
	 * SAQ_MON_QTA_ADJ_CRE_PRC() 호출
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createMonthlyAdjustmentSummaryInfo(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
//			Map<String, String> mapVO = conditionVO .getColumnValues();
//			param.putAll(mapVO);

			/**
			PACKAGE BODY saq_mon_qta_adj_cre_pkg AS
				PROCEDURE main_saq_mon_qta_adj_smry(   
					    in_mqta_step_cd  IN VARCHAR2,
					    in_bse_yr        IN VARCHAR2,
					    in_bse_qtr_cd    IN VARCHAR2,
					    in_trd_cd        IN VARCHAR2,
					    in_dir_cd        IN VARCHAR2,
					    in_mqta_ver_no   IN VARCHAR2,
					    in_usr_id        IN VARCHAR2,
					    out_ret         OUT VARCHAR2
				)		 
			*/
			
			// param 매핑
			param.put("mqtaStepCd", conditionVO.getMQtaStepCd());
			param.put("bseYr"     , conditionVO.getYear());
			param.put("bseQtrCd"  , conditionVO.getBse_quarter());
			param.put("trdCd"     , conditionVO.getTrade());
			param.put("dirCd"     , conditionVO.getBound());
			param.put("mQtaVerNo" , conditionVO.getMQtaVerNo());
			param.put("userId"    , conditionVO.getUserId());
			param.put("outParam"  , "");
			
			new SQLExecuter("").executeSP((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOCallMainSaqMonQtaAdjSmryCSQL(), param, null);
			
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
	 * MonthlyQuotaAdjustmentTrade 세부 조정을 위한 조회
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaAdjustmentTradeRhqModifyListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaAdjustmentTradeRhqModifyListVO> searchMonthlyQuotaAdjustmentTradeRhqModify0148List(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaAdjustmentTradeRhqModifyListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				
				int unit_flag = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
				int month = Integer.parseInt(conditionVO.getBse_qtr_cd().substring(0,1))*3-2;
				String mon = "";
				if(month < 10) {
					mon = "0" + month;
				}else {
					mon = "" + month;;
				}

				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				param.put("unit_flag", unit_flag);
				param.put("month1", mon);
				param.put("month2", mon);
				param.put("month3", mon);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOSearchMonthlyQuotaAdjustmentTradeRhqModify0148ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaAdjustmentTradeRhqModifyListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * SAQ_MON_QTA_TRD의 지정된 ibflag 값에 따라 DB에 반영한다.
	 * @param List<SaqMonQtaTrdVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiMonthlyQuotaAdjustmentTradeRhqModify0148(List<SaqMonQtaTrdVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int updCnt[] = null;
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int unit_flag = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				velParam.put("unit_flag", unit_flag);

			}
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaAdjustmentTradeRHQDBDAOMultiMonthlyQuotaAdjustmentTradeRhqModify0148USQL(), updModels, velParam);
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
	}
		
}