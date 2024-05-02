/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeDBDAO.java
*@FileTitle : Monthly Sales Quota Adjustment Trade Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : CHOI.M.C
*@LastVersion : 1.0
* 2007-02-12 byyoo
* 1.0 Creation
* 2008-02-05 Lee Ho Ik  : Direction Conversion Logic 적용 
* 2008-02-11 Lee Ho Ik  : Recent Quota 조회부분 수정 (saq_mon_qta -> saq_mon_cfm_qta)
* 2008-02-12 Lee Ho Ik  : Direction Conversion Logic 수행
* 2008-04-02 YJBYEON    : CSR No. N200803255636, cfm_qta 표기시 Direction Conversion 적용
* 2008.09.24 Y.S.CHOI   : CSR No. N200809240008
*                         - searchMonthlyQuotaAdjustmentTradeList, searchMonthlyAdjustmentTargetGroupTradeList,
*                           searchMonthlyAdjustmentSubTradeList, searchMonthlyAdjustmentTradeRhqLaneList
*                          ㆍqta_tgt_cd = 'Q' 조건 추가 
* 2008.10.08 Y.S.CHOI   : - searchMonthlyQuotaAdjustmentTradeList, searchMonthlyAdjustmentTargetGroupTradeList,
*                           searchMonthlyAdjustmentSubTradeList, searchMonthlyAdjustmentTradeRhqLaneList
*                          ㆍSAQ_YRY_QTA_RLSE 테이블 qta_tgt_cd = 'Q' 조건 추가.
* 2009.04.01 Kim MIn Ah : CSR No.R200903270002 - 품질검토 결과조치
* 						  createSAQ_MON_QTA_OFC_MOD_MIX() - 파라미터중 bse_mon 제거
* 2010-05-04 Lee Sang Yong : CHM-201003671 Quarterly Quota > Adjustment > Trade Group Vs. Regional Group 에 Excel Import/Export 를 위한 
* 							 updateSaqMonQtaTrd0176, searchMonthlyQuotaAdjustmentTradeForExcel0176List 메소드 추가 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.basic.MonthlyQuotaAdjustmentTradeBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.vo.SearchMonthlyAdjustmentTabTargetGroupListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.vo.SearchMonthlyQuotaAdjustmentTradeListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.vo.SearchMonthlyQuotaAdjustmentTradeModifyListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SaqMonQtaTrdVO;


/**
 * MonthlyQuotaAdjustmentTradeDBDAO <br>
 * - MonthlySalesQuotaManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi.M.C
 * @see MonthlyQuotaAdjustmentTradeBCImpl 참조
 * @since J2EE 1.6
 */
public class MonthlyQuotaAdjustmentTradeDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * CheckKey 조회
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet getPreviousCheckKey0048(QuotaConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOGetPreviousCheckKey0048RSQL(), param, velParam);
			
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
	 * SAQ_MON_QTA_TRD에 sub trade 별로 load가 0인 데이터가 있는지 확인한다.
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchLoadValueSaqMonQtaOfc0048(QuotaConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOSearchLoadValueSaqMonQtaOfc0048RSQL(), param, velParam);
			
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
	 * MonthlyQuotaAdjustmentTab Trade 화면에 대한 상단 TAB 조회 이벤트 처리
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaAdjustmentTradeListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyAdjustmentTabTargetGroupListVO> searchMonthlyAdjustmentTabTrade0048Tab01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyAdjustmentTabTargetGroupListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOSearchMonthlyAdjustmentTabTrade0048Tab01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyAdjustmentTabTargetGroupListVO .class);
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
	 * MonthlyQuotaAdjustmentTrade 상단 TargetGroup/Trade TAB 의 데이타 모델에 해당되는 값을 불러온다.
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyAdjustmentTabTargetGroupListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyAdjustmentTabTargetGroupListVO> searchMonthlyAdjustmentTabTargetGroup0048Tab01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyAdjustmentTabTargetGroupListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOSearchMonthlyAdjustmentTabTrade0048Tab01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyAdjustmentTabTargetGroupListVO .class);
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
	 * MonthlyQuotaAdjustmentTrade 상단 Sub Trade TAB 의 데이타 모델에 해당되는 값을 불러온다.
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyAdjustmentTabTargetGroupListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyAdjustmentTabTargetGroupListVO> searchMonthlyAdjustmentTabTrade0048Tab02(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyAdjustmentTabTargetGroupListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOSearchMonthlyAdjustmentTabTrade0048Tab02RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyAdjustmentTabTargetGroupListVO .class);
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
	 * MonthlyQuotaAdjustmentTrade 상단 TAB RHQ/Lane의 데이타 모델에 해당되는 값을 불러온다.
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyAdjustmentTabTargetGroupListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyAdjustmentTabTargetGroupListVO> searchMonthlyAdjustmentTabTrade0048Tab03(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyAdjustmentTabTargetGroupListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOSearchMonthlyAdjustmentTabTrade0048Tab03RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyAdjustmentTabTargetGroupListVO .class);
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
	 * onthlyQuotaAdjustmentTrade 조정을 위한 조회
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaAdjustmentTradeListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaAdjustmentTradeListVO> searchMonthlyQuotaAdjustmentTrade0048List01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaAdjustmentTradeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("bef_yr_qtr", SAQUtil.getBefYrQtr(conditionVO.getYear()+conditionVO.getBse_quarter()));
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOSearchMonthlyQuotaAdjustmentTrade0048List01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaAdjustmentTradeListVO .class);
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
	 * Remark 목록 조회
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyAdjustmentTabTargetGroupListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyAdjustmentTabTargetGroupListVO> searchMonthlyQuotaAdjustmentTradeRMK0048List01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyAdjustmentTabTargetGroupListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOSearchMonthlyQuotaAdjustmentTradeRMK0048List01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyAdjustmentTabTargetGroupListVO .class);
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
	 * MonthlyQuotaAdjustmentTrade 의 Save 와 Save As New Version 을 처리한다.
	 * @param List<SaqMonQtaTrdVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateMonthlyAdjustmentTrade0048(List<SaqMonQtaTrdVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOUpdateMonthlyAdjustmentTrade0048USQL(), updModels, velParam);
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
	 * MonthlyQuotaAdjustmentTrade 의 01Step 의 Load 와 RPB를 03Step으로 Update한다.
	 * @param conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateMonthlyAdjustmentTradeAll0048(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOUpdateMonthlyAdjustmentTradeAll0048USQL(), param, velParam);
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
	 * saq_mon_qta_step_ver 의 신규 mqta_ver_no 를 구한다.
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String getNewMonthlyQuotaStepVersionNumber0048(QuotaConditionVO conditionVO) throws DAOException {
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
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOGetNewMonthlyQuotaStepVersionNumber0048RSQL(), param, velParam);
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
	public void createMonthlyAdjustmentTradeInfoA0048(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
             
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOCreateMonthlyAdjustmentTradeInfoA0048CSQL(), param, velParam);
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
	public void createMonthlyAdjustmentTradeInfoB0048(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOCreateMonthlyAdjustmentTradeInfoB0048CSQL(), param, velParam);
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
	 * SAQ_MON_QTA_OFC_MOD_MIX 특정 조건의 데이터를 Version을 바꿔 Copy한다.(추가)
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createSaqMonQtaOfcModMix0048(QuotaConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOCreateSaqMonQtaOfcModMix0048CSQL(), param, velParam);
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
	 * 모든 Version이 XX 상태 인지 검사 한다.
	 * @param QuotaConditionVO conditionVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkCancelAllCurrentVersion(QuotaConditionVO conditionVO) throws DAOException {				
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
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOCheckCancelAllCurrentVersion0048RSQL(), param, velParam);
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
	public void modifySaqMonQtaStepVerStatus(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOModifySaqMonQtaStepVerStatus0048USQL(), param, velParam);
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
	 * trd_cd, dir_cd, gline_ver_no 가 같은 STEP 의 특정 상태 진행 건수를 구한다.
	 * @param QuotaConditionVO conditionVO
	 * @return int
	 * @throws DAOException
	 */
	public int getSaqStsCdCount(QuotaConditionVO conditionVO) throws DAOException {				
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
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOGetSaqStsCdCount0048RSQL(), param, velParam);
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
	public String getLoadRoundOffNeedMonth(QuotaConditionVO conditionVO) throws DAOException {
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

				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOGetLoadRoundOffNeedMonth0048RSQL(), param, velParam);
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
	 * MonthlyQuotaAdjustmentTrade 에서 Notify 처리시 SETP '02' (RHQ 정보)를 생성한다.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createMonthlyAdjustmentRhqInfo1(QuotaConditionVO conditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOCreateMonthlyAdjustmentRhqInfoA0048CSQL(), param, velParam);
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
	 * MonthlyQuotaAdjustmentTrade 에서 Notify 처리시 SETP '02' (RHQ 정보)를 생성한다.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createMonthlyAdjustmentRhqInfo2(QuotaConditionVO conditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOCreateMonthlyAdjustmentRhqInfoB0048CSQL(), param, velParam);
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
	 * SAQ_MON_QTA_TRD_RMK 의 상태를 변경한다.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySaqMonQtaTrdRmkStatus(QuotaConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOModifySaqMonQtaTrdRmkStatus0048USQL(), param, velParam);
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
	 * MonthlyQuotaAdjustmentTrade의 데이타를 조회하기 위한 mqta_mdl_ver_no, sls_fcast_pub_no 값을 조회한다.
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchVersionList(QuotaConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOSearchVersion0048ListRSQL(), param, velParam);
			
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
	 * gline_ver_no에 연결된 STEP '02'중 상태별 건수를 체크를 위한 조회
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet getMonthlyQuotaRhqSetpStatus(QuotaConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOGetMonthlyQuotaRhqSetpStatus0048RSQL(), param, velParam);
			
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
	 * modifySAQ_MON_STEP_VER_02
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySaqMonQtaOfcModMix(QuotaConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOModifySaqMonQtaOfcModMix0048CSQL(), param, velParam);
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
	 * saq_mon_qta_step_ver 의 saq_sts_cd, incl_port_flg 변경
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySaqMonQtaStepVERinclPortFlg(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOModifySaqMonQtaStepVERinclPortFlg0048USQL(), param, velParam);
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
	 * trd_cd, dir_cd, mqta_ver_no의 조회키별 Load 합이 0인 월을 체크하여 문자열로 리턴.
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String getListByLoadZero(QuotaConditionVO conditionVO) throws DAOException {
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
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOGetListByLoadZero0048RSQL(), param, velParam);
				
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * trd_cd, dir_cd, mqta_ver_no의 조회키별 Load 합이 0인 월을 체크하여 문자열로 리턴.
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */ 
	public String getListByMonthLoadZero(QuotaConditionVO conditionVO) throws DAOException {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String ret = "";
		int i=0;
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOGetListByMonthLoadZero0048RSQL(), param, velParam);
				
				StringBuffer sb = new StringBuffer(); //소스 품질 수정 요청건
				
				while(dbRowset.next()) {
					if( i > 0 ){
						//ret = ret + ", ";
						sb.append("- ").append(dbRowset.getString("msg")).append(","); //소스 품질 수정 요청건
					}
					//ret = ret +  dbRowset.getString("msg") ;
					sb.append("- ").append(dbRowset.getString("msg")); //소스 품질 수정 요청건
					i++;
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * MonthlyQuotaAdjustmentTrade 세부 조정을 위한 조회
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaAdjustmentTradeModifyListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaAdjustmentTradeModifyListVO> searchMonthlyQuotaAdjustmentTradeModify0147List(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaAdjustmentTradeModifyListVO> list = null;
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
				velParam.put("unit_flag", unit_flag);
				velParam.put("month1", mon);
				velParam.put("month2", mon);
				velParam.put("month3", mon);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOSearchMonthlyQuotaAdjustmentTradeModify0147ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaAdjustmentTradeModifyListVO .class);
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
	public void updateModifySaqMonQtaTrd0147(List<SaqMonQtaTrdVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
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
			
			log.debug("::::::::updModels::::::::"+updModels.toString()+"::::::::size:::::::"+updModels.size());
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOUpdateModifySaqMonQtaTrd0147USQL(), updModels, velParam);
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
	 * MonthlyQuotaAdjustmentTrade 세부 조정을 위한 조회
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @throws DAOException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentTradeForExcel0176List(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		ReturnVO listVO = new ReturnVO();
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
				param.put("mqta_step_cd", conditionVO.getMqta_step_cd());
				param.put("bse_yr", conditionVO.getBse_yr());
				param.put("bse_qtr_cd", conditionVO.getBse_qtr_cd());
				param.put("trd_cd", conditionVO.getTrd_cd());
				param.put("dir_cd", conditionVO.getDir_cd());
				param.put("mqta_ver_no", conditionVO.getMqta_ver_no());
				param.put("gline_ver_no", conditionVO.getGline_ver_no());
				param.put("unit", conditionVO.getUnit());				
				
			}  
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOSearchMonthlyQuotaAdjustmentTradeForExcel0176ListRSQL(), param, velParam);
			listVO.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return listVO;
	}
	
	/**
	 * Excel Upload Save 처리<br>
	 * 
	 * @param List<SaqMonQtaTrdVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateSaqMonQtaTrd0176(List<SaqMonQtaTrdVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				velParam.put("unit_flag"   , unit_flag);
			}
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOUpdateSaqMonQtaTrd0176USQL(), updModels, velParam);
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
	 * 모든 Load, RPB 가 0인 경우를 체크한다.
	 * @param QuotaConditionVO conditionVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkMonthlyAdjustmentTrade0048(QuotaConditionVO conditionVO) throws DAOException {				
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
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentTradeDBDAOCheckMonthlyAdjustmentTrade0048RSQL(), param, velParam);
				if(dbRowset.next()){
					cnt = dbRowset.getInt("lod_qty");
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

	
}