/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentSlsRHQDBDAO.java
*@FileTitle : Load Target - Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : CHOI.M.C
*@LastVersion : 1.0
* 2007-03-05 byyoo
* 1.0 Creation
* 2008-02-05 Lee Ho Ik : Direction Conversion Logic 적용 
* 2008-02-11 Byeon Young Joo : createMonthlyAdjustmentSlsRhqInfo, createMonthlyAdjustmentSlsRhqRgnInfo ( sls_aq_cd, ofc_add_flg 추가)
* 2008-02-12 Lee Ho Ik : Direction Conversion Logic 적용 
* 2008-02-20 Byeon Young Joo : getCompareRaCmByFinal 추가
* 2008-03-26 Lee Ho Ik : 조회 그리드에 L/F 표시 
* 2009.04.01 Kim MIn Ah : CSR No.R200903270002 - 품질검토 결과조치
* 						  getPreviousCheckKey() - 파라미터중 targetGrp 제거
* 						  searchMonthlyAdjustmentSlsRHQTargetGroupTradeList() - 파라미터중 targetGrp 제거
* 						  searchMonthlyAdjustmentSlsRHQSubTradeList() - 파라미터중 targetGrp 제거
* 						  createMonthlyAdjustmentSlsRhqInfo() - 파라미터중 mqta_mdl_ver_no, gline_ver_no 제거
* 						  modifySAQ_MON_QTA_STEP_VERFinalstatus() - 파라미터중 mqtaStepCd 제거
* 						  modifySAQ_MON_QTA_LOD_TGT_RMKFinalstatus() - 파라미터중 mqtaStepCd 제거
* 						  modifySAQ_MON_QTA_GLINE_VERstatus() - 파라미터중 targetGroup 제거
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.basic.MonthlyQuotaAdjustmentSlsRHQBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.vo.SearchMonthlyQuotaAdjustmentSlsRhqListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.vo.SearchMonthlyQuotaAdjustmentSlsRhqModifyListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.vo.SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.loggable.LoggableStateFactory;
import com.clt.framework.component.util.loggable.LoggableStatement;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SaqMonQtaLodTgtVO;


/**
 * MonthlyQuotaAdjustmentSlsRHQDBDAO <br>
 * - MonthlySalesQuotaManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author ChoiI.M.C
 * @see MonthlyQuotaAdjustmentSlsRHQBCImpl 참조
 * @since J2EE 1.6
 */
public class MonthlyQuotaAdjustmentSlsRHQDBDAO extends DBDAOSupport {

	/**
	 * MonthlyQuotaAdjustmentRhq의 데이타를 조회하기 위한 mqta_mdl_ver_no, sls_fcast_pub_no 값을 조회한다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet getPreviousCheckKey0156(QuotaConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOGetPreviousCheckKey0156RSQL(), param, velParam);
			
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
	 * MonthlyQuotaAdjustmentRhq의 데이타를 조회하기 위한 n1stRlaneCd 값을 조회한다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String getN1stRlaneCd0156(QuotaConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOGetN1stRlaneCd0156RSQL(), param, velParam);
			if(dbRowset.next()){
				n1stRlaneCd = dbRowset.getString("n1stRlaneCd");
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
	 * MonthlyQuotaAdjustmentSlsRhq 조정을 위한 조회.<br>
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaAdjustmentSlsRhqListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> searchMonthlyQuotaAdjustmentSlsRhq0156List01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> list = null;
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
				param.put("bef_yr_qtr", SAQUtil.getBefYrQtr(conditionVO.getYear()+conditionVO.getBse_qtr_cd()));

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOSearchMonthlyQuotaAdjustmentSlsRhq0156List01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaAdjustmentSlsRhqListVO .class);
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
	 * MonthlyQuotaAdjustmentSlsRhq 조정을 위한 조회.<br>
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaAdjustmentSlsRhqListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
		public List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> searchMonthlyAdjustmentSlsRHQTabTargetGroup0156Tab01(QuotaConditionVO conditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> list = null;
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
					param.put("bef_yr_qtr", SAQUtil.getBefYrQtr(conditionVO.getYear()+conditionVO.getBse_qtr_cd()));
					param.put("bef_yr_mon", SAQUtil.getYrQtrToYrMon(conditionVO.getYear()+conditionVO.getBse_qtr_cd()));
					param.put("add1_yr_mon", SAQUtil.getYrQtrToYrMon(conditionVO.getYear()+conditionVO.getBse_qtr_cd()));
					param.put("add2_yr_mon", SAQUtil.getYrQtrToYrMon(conditionVO.getYear()+conditionVO.getBse_qtr_cd()));
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
					velParam.put("slsRgnOfcCd", conditionVO.getSlsRgnOfcCd());

				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOSearchMonthlyAdjustmentSlsRHQTabTargetGroup0156Tab01RSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaAdjustmentSlsRhqListVO .class);
			
				
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
	 * MonthlyQuotaAdjustmentSlsRHQ 상단 Sub Trade TAB 의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaAdjustmentSlsRhqListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> searchMonthlyAdjustmentSlsRHQTabTrade0156Tab02(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				param.put("bef_yr_qtr", SAQUtil.getBefYrQtr(conditionVO.getYear()+conditionVO.getBse_qtr_cd()));
				param.put("bef_yr_mon", SAQUtil.getYrQtrToYrMon(conditionVO.getYear()+conditionVO.getBse_qtr_cd()));
				param.put("add1_yr_mon", SAQUtil.getYrQtrToYrMon(conditionVO.getYear()+conditionVO.getBse_qtr_cd()));
				param.put("add2_yr_mon", SAQUtil.getYrQtrToYrMon(conditionVO.getYear()+conditionVO.getBse_qtr_cd()));
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
				velParam.put("slsRgnOfcCd", conditionVO.getSlsRgnOfcCd());
				
				log.debug("conditionVO.getSlsRgnOfcCd() :"+conditionVO.getSlsRgnOfcCd());
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOSearchMonthlyAdjustmentSlsRHQTabTrade0156Tab02RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaAdjustmentSlsRhqListVO .class);
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
	 * MonthlyQuotaAdjustmentSlsRHQ의 상단 TAB Lane의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaAdjustmentSlsRhqListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> searchMonthlyAdjustmentSlsRHQTabTrade0156Tab03(QuotaConditionVO conditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> list = null;
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
					param.put("bef_yr_qtr", SAQUtil.getBefYrQtr(conditionVO.getYear()+conditionVO.getBse_qtr_cd()));
					param.put("bef_yr_mon", SAQUtil.getYrQtrToYrMon(conditionVO.getYear()+conditionVO.getBse_qtr_cd()));
					param.put("add1_yr_mon", SAQUtil.getYrQtrToYrMon(conditionVO.getYear()+conditionVO.getBse_qtr_cd()));
					param.put("add2_yr_mon", SAQUtil.getYrQtrToYrMon(conditionVO.getYear()+conditionVO.getBse_qtr_cd()));
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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOSearchMonthlyAdjustmentSlsRHQTabTrade0156Tab03RSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaAdjustmentSlsRhqListVO .class);
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
	 * Remark 목록 조회<br>
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO> searchMonthlyQuotaAdjustmentSlsRHQRMK0156List01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOSearchMonthlyQuotaAdjustmentSlsRHQRMK0156List01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO .class);
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
	 * MonthlyQuotaAdjustmentSlsRhq 의 Save 와 Save As New Version 을 처리한다.<br>
	 * @param List<SaqMonQtaLodTgtVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateMonthlyAdjustmentSlsRhq0156(List<SaqMonQtaLodTgtVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOUpdateMonthlyAdjustmentSlsRhq0156USQL(), updModels, velParam);
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
	 * saq_mon_qta_step_ver 의 신규 mqta_ver_no 를 구한다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String getNewMonthlyQuotaStepVersionNumber0156(QuotaConditionVO conditionVO) throws DAOException {
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
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOGetNewMonthlyQuotaStepVersionNumber0156RSQL(), param, velParam);
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
	 * MonthlyQuotaAdjustmentSlsRhq 의 Save As New Version 을 처리한다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */	 
	public void createMonthlyAdjustmentSlsRhqInfoA0156(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
             
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOCreateMonthlyAdjustmentSlsRhqInfoA0156CSQL(), param, velParam);
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
	 * MonthlyQuotaAdjustmentSlsRhq 의 Save As New Version 을 처리한다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createMonthlyAdjustmentSlsRhqInfoB0156(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
             
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOCreateMonthlyAdjustmentSlsRhqInfoB0156CSQL(), param, velParam);
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
	 * MonthlyQuotaAdjustmentSlsRhq 의 Save As New Version 을 처리한다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createMonthlyAdjustmentSlsRhqInfoC0156(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
             
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOCreateMonthlyAdjustmentSlsRhqInfoC0156CSQL(), param, velParam);
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
	 * MonthlyQuotaAdjustmentSlsRhq 의 Save As New Version 을 처리한다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createMonthlyAdjustmentSlsRhqInfoD0156(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
             
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOCreateMonthlyAdjustmentSlsRhqInfoD0156CSQL(), param, velParam);
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
	 * 모든 Version이 XX 상태 인지 검사 한다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @return int
	 * @throws DAOException
	 */ 
	public int checkCancelAllCurrentVersion0156(QuotaConditionVO conditionVO) throws DAOException {				
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
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOCheckCancelAllCurrentVersion0156RSQL(), param, velParam);
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
	public void modifySaqMonQtaStepVerStatus0156(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOModifySaqMonQtaStepVerStatus0156USQL(), param, velParam);
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
	public int getSaqStsCdCount0156(QuotaConditionVO conditionVO) throws DAOException {				
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
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOGetSaqStsCdCount0156RSQL(), param, velParam);
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
	 * Load에 소수점 이하 자리 존재여부...
	 * 소수점이하 자리수가 있는 월을 String으로 리턴. (/)
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String getLoadRoundOffNeedMonth0156(QuotaConditionVO conditionVO) throws DAOException {
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

				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOGetSlsLoadRoundOffNeedMonth0156RSQL(), param, velParam);
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
	 * Final 과 현재 버젼의  Load 와 RA_CM 정보 조회
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 
	public DBRowSet getCompareLoadByFinal0156(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String unit_flag = (conditionVO.getUnit().equals("F") ? "2" : "1");
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				param.put("unit_flag", unit_flag);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOGetCompareLoadByFinal0156RSQL(), param, velParam);
			
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
	 * Final 과 현재 버젼의  Load 와 RA_CM 정보 조회
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 
	public DBRowSet getCompareRaCmByFinal0156(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String unit_flag = (conditionVO.getUnit().equals("F") ? "2" : "1");
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				param.put("unit_flag", unit_flag);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOGetCompareRaCmByFinal0156RSQL(), param, velParam);
			
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
	public void modifySaqMonQtaLodTgtRmkStatus0156(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOModifySaqMonQtaLodTgtRmkStatus0156USQL(), param, velParam);
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
	 * 마지막 단계이면 TRUE, 아니면 FALSE 리턴
	 * @param QuotaConditionVO conditionVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean isGuidlineAllMqtaVerNoFNFC0156(QuotaConditionVO conditionVO) throws DAOException {
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		boolean ret = false;
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOIsGuidlineAllMqtaVerNoFNFC0156RSQL(), param, velParam);
				if (dbRowset.next()) {
					ret = (dbRowset.getInt("ret") == 0 ? true : false);
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
	 * trd_cd, dir_cd, glie_ver_no 에 해당하는 모든 STEP의 진행상태를 QN으로 변경.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyAllStepStatusQN0156(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOModifyAllStepStatusQN0156USQL(), param, velParam);
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
	 * saq_mon_qta_step_ver 의 glie_ver_no 진행상태를 QN으로 변경.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySaqMonQtaGlineVerStatus0156(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOModifySaqMonQtaGlineVerStatus0156USQL(), param, velParam);
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
	 * gline_ver_no STEP '04'에 연결된 STEP '05'중 상태별 건수를 체크를 위한 조회<br>
	 * "00" 건수와, ("00","XX") 이외의 건수 조회 <br>  
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet getMonthlyQuotaSlsRgnStepStatus0156(QuotaConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOGetMonthlyQuotaSlsRgnStepStatus0156RSQL(), param, velParam);
			
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
	 * STEP 04 mqtaVerNo에 관련된 STEP 05 의 상태 변경.
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySlsRgnSaqMonQtaStePVerStatus0156(QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOModifySlsRgnSaqMonQtaStePVerStatus0156USQL(), param, velParam);
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
	public String searchAdjustmentSlsRhqLoadZero0156List(QuotaConditionVO conditionVO) throws DAOException {
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
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOSearchAdjustmentSlsRhqLoadZero0156ListRSQL(), param, velParam);
		
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
	 * MonthlyQuotaAdjustmentSlsRHQ 세부 조정을 위한 조회<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQuotaForExcelListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaAdjustmentSlsRhqModifyListVO> searchMonthlyQuotaAdjustmentSlsRhqModify0158List(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaAdjustmentSlsRhqModifyListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int unit_flag = (conditionVO.getUnit().compareTo("F")==0 ? 2 : 1);
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				param.put("unit_flag", unit_flag);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOSearchMonthlyQuotaAdjustmentSlsRhqModify0158ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaAdjustmentSlsRhqModifyListVO .class);
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
	 *  SAQ_MON_QTA_LOD_TGT의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param List<SaqMonQtaLodTgtVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiMonthlyQuotaAdjustmentSlsRhqModify0158(List<SaqMonQtaLodTgtVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
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
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaAdjustmentSlsRHQDBDAOMultiMonthlyQuotaAdjustmentSlsRhqModify0158USQL(), updModels, velParam);
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