/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentRHQDBDAO.java
*@FileTitle : Regional Group Vs Regional Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : CHOI.M.C
*@LastVersion : 1.0
* 2007-03-05 byyoo
* 1.0 Creation
* 2008-01-29 Lee Ho Ik  : Excel Upload 기능 구현
* 2008-02-05 Lee Ho Ik  : Direction Conversion Logic 적용
* 2008-02-11 Lee Ho Ik  : Recent Quota 조회부분 수정 (saq_mon_qta -> saq_mon_cfm_qta) 
* 2008-02-11 Byeon Young Joo : createMonthlyAdjustmentRhqInfo, createMonthlyAdjustmentRhqRgnInfo 의 SAQ_MON_QTA_RHQ 초기값 수정 ( ctrt_aq_cd, ofc_add_flg 추가)
* 2008-02-05 Lee Ho Ik  : Direction Conversion Logic 적용 
* 2008-02-12 Y.S.CHOI   : 누락 점소추가 List 조회 기능 구현
* 2008-02-13 Lee Ho Ik  : Direction Conversion Logic 적용
* 2008-03-20 Byeon Young Joo :  2008.03.20. BYEON YOUNG JOO - getCompareLoadRaCmByFinal 을 getCompareRaCmByFinal, getCompareLoadByFinal 로 분리
* 2008-03-24 Y.S.CHOI   : Direction Conversion, year & mon, DEM/DET 로직 추가 (CSR No. R200803245615)
* 2008-04-02 YJBYEON    : CSR - N200803255636, cfm_qta 표기시 Direction Conversion 적용 
* 2008-05-07 Y.S.CHOI   : insertMonthlyQuotaOfficeAddList에 Terminal Volume Incentive amt 로직 추가 
* 2008-05-29 Y.S.CHOI   : CSR No. R200805226856 - Misc Rev amt 로직 추가
* 2008-06-10 Y.S.CHOI   : insertMonthlyQuotaOfficeAddList에 saq_avg_cost_ofc의 Count 로직에 saq_cost_appl_bse의 년도와 월을 추가
* 2008.09.24 Y.S.CHOI   : CSR No. N200809240008
*                         - searchMonthlyAdjustmentRHQTargetGroupTradeList, searchMonthlyAdjustmentRHQSubTradeList, searchMonthlyAdjustmentRHQTabLaneList
*                          ㆍqta_tgt_cd = 'Q' 조건 추가
* 2008.10.08 Y.S.CHOI   : searchMonthlyAdjustmentRHQTargetGroupTradeList, searchMonthlyAdjustmentRHQSubTradeList, searchMonthlyAdjustmentRHQTabLaneList
*                        ㆍSAQ_YRY_QTA_RLSE 테이블 qta_tgt_cd = 'Q' 조건 추가
* 2008.12.29 Y.S.CHOI   : createMonthlyAdjustmentLodTgtInfo - Decode문 추가
* 2009.01.16 Y.S.CHOI   : getMonthlyQuotaOfficeAddLodTgtInsertList - sls_rhq_cd를 sls_aq_cd 수정
* 2009.04.01 Kim MIn Ah : CSR No.R200903270002 - 품질검토 결과조치
* 						  getListByLoadZero() - 파라미터중 glineVerNo, inclPortFlag 제거
* 						  searchMonthlyQuotaForExcelList() - 파라미터중 sub_trd_cd, rlane_cd 제거
* 						  getMonthlyQuotaOfficeAddInsertList() - getMonthlyQuotaOfficeAddLodTgtInsertList()호출 파라미터중 sls_rhq_cd 제거
* 						  getMonthlyQuotaOfficeAddLodTgtInsertList() - 파라미터중 sls_rhq_cd 제거
* 2009-04-21 Kim Min Ah : CSR No. N200904170012 - CM 산식 변경으로 인해 dmdt_ut_amt 제거
*                         - insertMonthlyQuotaOfficeAddList()
* 2010.06.28 Kim Min Ah : [CHM-201004282] 소스 품질검토 결과 적용
* 2010.07.21 Kim Min Ah : [CHM-201004612] IAS Trade Loading Office 생성시 예외처리 적용
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.basic.MonthlyQuotaAdjustmentRHQBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.vo.MonthlyQuotaAdjustmentRhqVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.vo.SearchMonthlyQuotaAdjustmentRhqModifyListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.vo.SearchMonthlyQuotaForExcelListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SaqMonQtaOfcAddVO;
import com.clt.syscommon.common.table.SaqMonQtaRhqVO;


/**
 * MonthlyQuotaAdjustmentRHQDBDAO <br>
 * - MonthlySalesQuotaManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI.M.C
 * @see MonthlyQuotaAdjustmentRHQBCImpl 참조
 * @since J2EE 1.6
 */
public class MonthlyQuotaAdjustmentRHQDBDAO extends DBDAOSupport {

	/**
	 * [Trade List하단]을 [조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyQuotaAdjustmentRHQVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MonthlyQuotaAdjustmentRhqVO> searchMonthlyQuotaAdjustmentRhq0075Tab01Sub01List01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonthlyQuotaAdjustmentRhqVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaAdjustmentRhq0075Tab01Sub01List01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonthlyQuotaAdjustmentRhqVO .class);
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
	 * [Trade List 조회]를 [위한 Key값을 조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyQuotaAdjustmentRHQVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MonthlyQuotaAdjustmentRhqVO> getPreviousCheckKey0075Tab01Sub01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonthlyQuotaAdjustmentRhqVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOGetPreviousCheckKey0075RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonthlyQuotaAdjustmentRhqVO .class);
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
	 * [Trade List상단]을 [조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyQuotaAdjustmentRHQVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MonthlyQuotaAdjustmentRhqVO> searchMonthlyAdjustmentRHQTabTargetGroup0075Tab01List01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonthlyQuotaAdjustmentRhqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				//Set Quarter
				conditionVO.setQuarter(SAQUtil.getBefYrQtr(conditionVO.getYear()+conditionVO.getBse_quarter()));
				
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("pfmc_fr_yr_mon", conditionVO.getPfmc_fr_year()+conditionVO.getPfmc_fr_month());
				param.put("pfmc_to_yr_mon", conditionVO.getPfmc_to_year()+conditionVO.getPfmc_to_month());
				param.put("pfmc_fr_yr_qtr", SAQUtil.getYrMonToYrQtr(conditionVO.getPfmc_fr_year()+conditionVO.getPfmc_fr_month()));
				param.put("pfmc_to_yr_qtr", SAQUtil.getYrMonToYrQtr(conditionVO.getPfmc_to_year()+conditionVO.getPfmc_to_month()));
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyAdjustmentRHQTabTargetGroup0075Tab01List01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonthlyQuotaAdjustmentRhqVO .class);
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
	 * [Sub Trade List상단]을 [조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyQuotaAdjustmentRHQVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MonthlyQuotaAdjustmentRhqVO> searchMonthlyAdjustmentRHQTabSubTrade0075Tab02List01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonthlyQuotaAdjustmentRhqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){

				//Set Quarter
				conditionVO.setQuarter(SAQUtil.getBefYrQtr(conditionVO.getYear()+conditionVO.getBse_quarter()));
				
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
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
				velParam.put("ctrtRgnOfcCd", conditionVO.getCtrt_rhq_cd());
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyAdjustmentRHQTabTargetGroup0075Tab02List01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonthlyQuotaAdjustmentRhqVO .class);
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
	 * [상단 Regional Group/Lane 탭]을 [조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyQuotaAdjustmentRHQVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MonthlyQuotaAdjustmentRhqVO> searchMonthlyAdjustmentRHQTabRhqLane0075Tab03List01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonthlyQuotaAdjustmentRhqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				
				//Set Quarter
				conditionVO.setQuarter(SAQUtil.getBefYrQtr(conditionVO.getYear()+conditionVO.getBse_quarter()));
				
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("pfmc_fr_yr_mon", conditionVO.getPfmc_fr_year()+conditionVO.getPfmc_fr_month());
				param.put("pfmc_to_yr_mon", conditionVO.getPfmc_to_year()+conditionVO.getPfmc_to_month());
				param.put("pfmc_fr_yr_qtr", SAQUtil.getYrMonToYrQtr(conditionVO.getPfmc_fr_year()+conditionVO.getPfmc_fr_month()));
				param.put("pfmc_to_yr_qtr", SAQUtil.getYrMonToYrQtr(conditionVO.getPfmc_to_year()+conditionVO.getPfmc_to_month()));
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyAdjustmentRHQTabRhqLane0075Tab03List01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonthlyQuotaAdjustmentRhqVO .class);
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
	 * [remark]을 [조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyQuotaAdjustmentRHQVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MonthlyQuotaAdjustmentRhqVO> searchMonthlyQuotaAdjustmentRHQRMK0075Tab01Sub01List01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonthlyQuotaAdjustmentRhqVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaAdjustmentRHQRMK0075Tab01Sub01List01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonthlyQuotaAdjustmentRhqVO .class);
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
	 * QuotaForExcel 목록 조회<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @throws DAOException
	 */
	public ReturnVO searchMonthlyQuotaForExcel0161List(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		ReturnVO listVO = new ReturnVO();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				velParam.put("mqtaStepCd", conditionVO.getMqta_step_cd());
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaForExcel0161ListRSQL(), param, velParam);
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
	 * @param List<SaqMonQtaRhqVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateSaqMonQta0161(List<SaqMonQtaRhqVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				velParam.put("mqtaStepCd"  , conditionVO.getMqta_step_cd());
				velParam.put("inclPortFlag", conditionVO.getInclPortFlag());
				
			}
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOUpdateSaqMonQta0161USQL(), updModels, velParam);
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
	 * MonthlyQuotaAdjustmentRHQ 세부 조정을 위한 조회<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaForExcelListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaAdjustmentRhqModifyListVO> searchMonthlyQuotaAdjustmentRhqModify0149List(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaAdjustmentRhqModifyListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int unit_flag = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
		int month = Integer.parseInt(conditionVO.getBseQtrCd().substring(0,1))*3-2;

		String monthTemp = "";
		if(month < 10){
			monthTemp = "0"+month;
		}else{
			monthTemp = ""+month;
		}
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				param.put("unit_flag", unit_flag);
				param.put("month1", monthTemp);
				param.put("month2", monthTemp);
				param.put("month3", monthTemp);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaAdjustmentRhqModify0149ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaAdjustmentRhqModifyListVO .class);
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
	 * SAQ_MON_QTA_RHQ의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param List<SaqMonQtaRhqVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiMonthlyQuotaAdjustmentRhqModify0149(List<SaqMonQtaRhqVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt[] = null;
		
		int unit_flag = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);

		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				velParam.put("unit_flag", unit_flag);
				
			}
			// SAQ_MON_QTA_OFC_ADD Insert
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOMultiMonthlyQuotaAdjustmentRhqModify0149USQL(), updModels, velParam);
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
	 * 누락 점소추가 List 조회<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaForExcelListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaForExcelListVO> searchMonthlyQuotaOfficeAdd0162List(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaForExcelListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyQuotaOfficeAdd0162ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaForExcelListVO .class);
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
	 * MonthlyQuotaAdjustmentRhq <br>
	 * 
	 * @param List<SaqMonQtaOfcAddVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @param String unitCostFlag
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertMonthlyQuotaOfficeAddList0162(List<SaqMonQtaOfcAddVO> updModels, QuotaConditionVO conditionVO, String unitCostFlag) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt[] = null;
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				velParam.putAll(mapVO);
				velParam.put("unit_cost_flag", unitCostFlag);
				
			}
			// SAQ_MON_QTA_OFC_ADD Insert
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOInsertMonthlyQuotaOfficeAddA0162CSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
			updCnt = null;
			// SAQ_MON_QTA_OFC_ADD_MIX Insert
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOInsertMonthlyQuotaOfficeAddB0162CSQL(), updModels, velParam);
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
	 * 누락 점소추가 관련 Data를 SAQ_MON_QTA_LOD_TGT에 Insert<br>
	 * 
	 * @param List<SaqMonQtaOfcAddVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void insertMonthlyQuotaOfficeAddLodTgt0162(List<SaqMonQtaOfcAddVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt[] = null;
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				velParam.putAll(mapVO);
				
			}
			// SAQ_MON_QTA_OFC_ADD Insert
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOInsertMonthlyQuotaOfficeAddLodTgt0162CSQL(), updModels, velParam);
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
	 * 누락 점소추가 관련 Data를 SAQ_MON_QTA_RHQ에 Insert<br>
	 * 
	 * @param List<SaqMonQtaOfcAddVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertMonthlyQuotaOfficeAddRhq0162(List<SaqMonQtaOfcAddVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt[] = null;
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");

			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				velParam.putAll(mapVO);
				
			}
			// SAQ_MON_QTA_OFC_ADD Insert
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOInsertMonthlyQuotaOfficeAddRhq0162CSQL(), updModels, velParam);
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
	 * MonthlyQuotaAdjustmentRhq의 데이타를 조회하기 위한 n1stRlaneCd 값을 조회한다.<br>
	 * @param SaqMonQtaOfcAddVO conditionVO
	 * @return String
	 * @throws DAOException
	 */ 
	public String getMonthlyQuotaOfficeAddDataCnt0162(SaqMonQtaOfcAddVO conditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		DBRowSet dbRowset  = null;
		String n1stRlaneCd = null;
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOGetMonthlyQuotaOfficeAddDataCnt0162RSQL(), param, velParam);
			if(dbRowset.next()){
				n1stRlaneCd = dbRowset.getString("cnt");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return n1stRlaneCd;
	}

	/**
	 * 08 Step 사용 DB에 입력한 List를 문자열로 리턴.
	 * @param SaqMonQtaOfcAddVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String getMonthlyQuotaOfficeAddLodTgtInsertList0162(SaqMonQtaOfcAddVO conditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		DBRowSet dbRowset  = null;
		String ret  = "";
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("slsAqCd", conditionVO.getAqCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOGetMonthlyQuotaOfficeAddLodTgtInsertList0162RSQL(), param, velParam);
			
			StringBuffer sb = new StringBuffer(); //소스 품질 수정 요청건
			
			while(dbRowset.next()){				
				//ret = ret + "- " + dbRowset.getString("msg") + " \n";
				sb.append("- ").append(dbRowset.getString("msg")).append(" \n"); //소스 품질 수정 요청건
			}
			
			ret = sb.toString(); //소스 품질 수정 요청건
			
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
	 * 04 Step 사용 DB에 입력한 List를 문자열로 리턴.
	 * @param SaqMonQtaOfcAddVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String getMonthlyQuotaOfficeAddRhqInsertList0162(SaqMonQtaOfcAddVO conditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		DBRowSet dbRowset  = null;
		String ret  = "";
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("ctrtRhqCd", conditionVO.getRhqCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOGetMonthlyQuotaOfficeAddRhqInsertList0162RSQL(), param, velParam);
				
			StringBuffer sb = new StringBuffer(); //소스 품질 수정 요청건
			
			while(dbRowset.next()){				
				//ret = ret + "- " + dbRowset.getString("msg") + " \n";
				sb.append("- ").append(dbRowset.getString("msg")).append(" \n"); //소스 품질 수정 요청건
			}
			
			ret = sb.toString(); //소스 품질 수정 요청건
			
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
	 * saq_qta_rnd_off_pkg.mon_qta_round_off 를 이용해서  데이터 round off 처리한다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO 
	 * @throws DAOException
	 * @throws Exception
	 */
	public void procAdjustmentLoadRoundOff(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			// param 매핑
			param.put("mQtaStepCd"  , conditionVO.getMQtaStepCd());
			param.put("bseYr"       , conditionVO.getYear());
			param.put("bse_quarter" , conditionVO.getBse_quarter());
			param.put("trade"       , conditionVO.getTrade());
			param.put("bound"       , conditionVO.getBound());
			param.put("mQtaVerNo"   , conditionVO.getMQtaVerNo());
			
			new SQLExecuter("").executeSP((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOCallAdjustmentLoadRoundOffUSQL(), param, null);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * saq_mon_qta_step_ver 의 신규 mqta_ver_no 를 구한다. <br>
	 * @param SaqMonQtaOfcAddVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String getNewMonthlyQuotaStepVersionNumber0075(QuotaConditionVO conditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		DBRowSet dbRowset  = null;
		String n1stRlaneCd = null;
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOGetNewMonthlyQuotaStepVersionNumber0075RSQL(), param, velParam);
			if(dbRowset.next()){
				n1stRlaneCd = dbRowset.getString("new_ver_no");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return n1stRlaneCd;
	}
	 
	/**
	 * MonthlyQuotaAdjustmentRhq 의 Save As New Version 을 처리한다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createMonthlyAdjustmentRhqInfoA0075(QuotaConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				velParam.put("OfcCd", conditionVO.getOfcCd());

				SQLExecuter sqlExe = new SQLExecuter("");
				
				// saq_mon_qta_step_ver Insert
				result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOCreateMonthlyAdjustmentRhqInfoA0075CSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
				
				// saq_mon_qta_rhq Insert
				result = 0;
				result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOCreateMonthlyAdjustmentRhqInfoB0075CSQL(), param, velParam);
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
	 * MonthlyQuotaAdjustmentSlsRhq 의 Save 와 Save As New Version 을 처리한다.<br>
	 * @param List<SaqMonQtaRhqVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateSaqMonQtaRhq0075(List<SaqMonQtaRhqVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOUpdateSaqMonQtaRhq0075USQL(), updModels, velParam);
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
	 * 모든 Version이 XX 상태 인지 검사 한다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @return int
	 * @throws DAOException
	 */ 
	public int checkCancelAllCurrentVersion0075(QuotaConditionVO conditionVO) throws DAOException {				
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
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOCheckCancelAllCurrentVersion0075RSQL(), param, velParam);
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
	 * saq_mon_qta_step_ver 의 saq_sts_cd 변경
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySaqMonQtaStepVerStatus0075(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOModifySaqMonQtaStepVerStatus0075RSQL(), param, velParam);
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
	 * Load에 소수점 이하 자리 존재여부...
	 * 소수점이하 자리수가 있는 월을 String으로 리턴. (/)
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */ 
	public String getLoadRoundOffNeedMonth0075(QuotaConditionVO conditionVO) throws DAOException {
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

				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOGetLoadRoundOffNeedMonth0075RSQL(), param, velParam);
								
				StringBuffer sb = new StringBuffer(); //소스 품질 수정 요청건
				
				while(dbRowset.next()){				
					//ret = ret + dbRowset.getString("mon") + "/";
					sb.append("- ").append(dbRowset.getString("mon")).append("/"); //소스 품질 수정 요청건
				}
				
				ret = sb.toString(); //소스 품질 수정 요청건
				
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
	 * Final 과 현재 버젼의  Load 정보 조회
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	  
	public DBRowSet getCompareLoadByFinal0075(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int unit_flag = (conditionVO.getUnit().equals("F") ? 2 : 1);
			
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				velParam.put("unit_flag", unit_flag);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOGetCompareLoadByFinal0075RSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	 */
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * Final 과 현재 버젼의  RA_CM 정보 조회
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 
	public DBRowSet getCompareRaCmByFinal0075(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int unit_flag = (conditionVO.getUnit().equals("F") ? 2 : 1);
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				velParam.put("unit_flag", unit_flag);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOGetCompareRaCmByFinal0075RSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
*/
	/**
	 * SAQ_MON_QTA_RHQ_RMK 의 상태를 변경한다.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySaqMonQtaRhqRmkStatus0075(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOModifySaqMonQtaRhqRmkStatus0075USQL(), param, velParam);
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
	 * gline_ver_no 에 관련된 모든 STEP의 mqta_ver_no 가 <br>
	 * 마지막 단계이면 TRUE, 아니면 FALSE 리턴.
	 * @param QuotaConditionVO conditionVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean isGuidlineTrdDirAllMqtaVerNoFNFC0075(QuotaConditionVO conditionVO) throws DAOException {
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

				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOIsGuidlineTrdDirAllMqtaVerNoFNFC0075RSQL(), param, velParam);
				if(dbRowset.next()){
					result = (dbRowset.getInt("ret") == 0 ? true : false);
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
	 * (STEP 08) load target 초기 정보 생성
	 * 2010.07.21 Timeout으로 인한 procedure로 실행
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 
	public void createMonthlyAdjustmentLodTgtInfo0075(QuotaConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
			
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				
				// saq_mon_qta_step_ver Insert
				result1 = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOCreateMonthlyAdjustmentLodTgtInfoA0075CSQL(), param, velParam);
				// saq_mon_qta_lod_tgt_cost Insert
				result2 = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOCreateMonthlyAdjustmentLodTgtInfoB0075CSQL(), param, velParam);
				// saq_mon_qta_lod_tgt Insert
				result3 = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOCreateMonthlyAdjustmentLodTgtInfoC0075CSQL(), param, velParam);
				if(result1 == Statement.EXECUTE_FAILED || result2 == Statement.EXECUTE_FAILED || result3 == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert SQL");
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
*/
	/**
	 * (STEP 08) IAS load target 초기 정보 생성
	 * 2010.07.21 [CHM-201004612] IAS Trade Loading Office 생성시 예외처리 적용
	 *            Timeout으로 인한 procedure로 실행
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 
	public void createMonthlyAdjustmentLodTgtInfoEx0075(QuotaConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
			
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				
				// saq_mon_qta_step_ver Insert
				result1 = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOCreateMonthlyAdjustmentLodTgtInfoA0075CSQL(), param, velParam);
				// saq_mon_qta_lod_tgt_cost Insert
				result2 = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOCreateMonthlyAdjustmentLodTgtInfoB20075CSQL(), param, velParam);
				// saq_mon_qta_lod_tgt Insert
				result3 = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOCreateMonthlyAdjustmentLodTgtInfoC0075CSQL(), param, velParam);
				if(result1 == Statement.EXECUTE_FAILED || result2 == Statement.EXECUTE_FAILED || result3 == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert SQL");
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
*/
	/**
	 * (STEP 08) load target 초기 정보 생성
	 * 2010.07.21 Timeout으로 인한 procedure로 실행
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 
	public void createMonthlyAdjustmentLodTgtInitInfo0075(QuotaConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result1 = 0;
		int result2 = 0;
			
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				
				// saq_mon_qta_step_ver Insert
				result1 = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOCreateMonthlyAdjustmentLodTgtInitInfoA0075CSQL(), param, velParam);
				// saq_mon_qta_lod_tgt Insert
				result2 = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOCreateMonthlyAdjustmentLodTgtInitInfoB0075CSQL(), param, velParam);
				if(result1 == Statement.EXECUTE_FAILED || result2 == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
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
*/
	/**
	 * gline_ver_no 에 관련된 모든 STEP의 mqta_ver_no 가 <br>
	 * 마지막 단계이면 TRUE, 아니면 FALSE 리턴.
	 * 2010.07.21 Timeout으로 인한 procedure로 실행
	 * @param QuotaConditionVO conditionVO
	 * @return String[]
	 * @throws DAOException
	 
	public String[] getMonthlyQuotaMqtaVersionNumber0075(QuotaConditionVO conditionVO) throws DAOException {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int idx = 0;
		String[] mQtaVerNo = new String[4];
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOGetMonthlyQuotaMqtaVersionNumber0075RSQL(), param, velParam);
				while(dbRowset.next()) {
					mQtaVerNo[idx] = dbRowset.getString("mqta_ver_no");
					idx++;
				}
				
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mQtaVerNo;
	}
*/
	/**
	 * saq_mon_qta_step_ver 의 saq_sts_cd 변경
	 * 2010.07.21 Timeout으로 인한 procedure로 실행
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 
	public void modifySaqMonQtaStepVerFinalStatus20075(QuotaConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
			
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				
				result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOModifySaqMonQtaStepVerFinalStatus20075USQL(), param, velParam);
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
*/
	/**
	 * STEP 04 에 관련된 STEP 05 의 특정 상태 진행 건수 조회
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return int
	 * @throws DAOException
	 */
	public int getRgnSaqStsCdCount0075(QuotaConditionVO conditionVO) throws DAOException {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOGetRgnSaqStsCdCount0075RSQL(), param, velParam);
				if (dbRowset.next()) {
					result = dbRowset.getInt("sts_cnt");
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
	 * trd_cd, dir_cd, mqta_ver_no의 조회키별 Load 합이 0인 월을 체크하여 문자열로 리턴.
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchAdjustmentRhqLoadZero0075List(QuotaConditionVO conditionVO) throws DAOException {
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
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOSearchAdjustmentRhqLoadZero0075ListRSQL(), param, velParam);
				
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
	 * SAQ_MON_QTA_LOD_TGT_CRE_PRC 를 이용해서  Load Target 데이터를 생성한다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO 
	 * @throws DAOException
	 * @throws Exception
	 */
	public void procSaqMonQtaLodTgtCre(QuotaConditionVO conditionVO) throws DAOException,Exception {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO = conditionVO .getColumnValues();
			param.putAll(mapVO);
			
			new SQLExecuter("").executeSP((ISQLTemplate)new MonthlyQuotaAdjustmentRHQDBDAOProcSaqMonQtaLodTgtCreCSQL(), param, null);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	 
}