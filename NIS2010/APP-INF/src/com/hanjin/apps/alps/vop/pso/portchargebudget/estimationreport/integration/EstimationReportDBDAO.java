/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EstimationReportDBDAO.java
*@FileTitle : EstimationReport
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.18
*@LastModifier : S.K.Y
*@LastVersion : 1.0
* 2013.03.18 S.K.Y
* 1.0 Creation
* 2013.03.18 S.K.Y  CHM-201323211 월 추정 Report 개발 (진행항차)
* 2013.03.18 S.K.Y  CHM-201323212 월 추정 Report 개발 (대상항차)
* 2013.04.26 조정민    CHM-201323376 Monthly Estimation Comparison (raw date 다운 포함)
* 2013.06.10 S.K.Y  CHM-201323634 Budget Summary 조회 기능
* 2013.09.03 SKY    CHM-201326398 Monthly Estimation Comparision 검색 조건(Scenario CD) 추가
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.basic.EstimationReportBCImpl;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.BudgetSmryByVvdVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.EstimationByVvdVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.MonEstmCompVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.MonEstmRawDataForBudVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.MonEstmRawDataVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;



/**
 * ALPS EstimationReportDBDAO <br>
 * - ALPS-EstimationReport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author S.K.Y
 * @see EstimationReportBCImpl 참조
 * @since J2EE 1.6
 */
public class EstimationReportDBDAO extends DBDAOSupport {

	private String dataSource = "";
	private static final long serialVersionUID = 1L;
	
	/**
	 * defalt constructor
	 */
	public EstimationReportDBDAO() {
		this.dataSource = "";
	}
	
	/**
	 * parameterized constructor
	 * @param dataSource
	 */
	public EstimationReportDBDAO(String dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * Monthly Estimation by VVD 정보를 조회한다.
	 * @category VOP_PSO_0100_RetrieveButtonClick (SKY)
	 * @param EstimationByVvdVO estimationByVvdVO
	 * @return List<EstimationByVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EstimationByVvdVO> searchMonthlyByVvd(EstimationByVvdVO estimationByVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstimationByVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(estimationByVvdVO != null) {
				
				estimationByVvdVO.setRevYrmon(estimationByVvdVO.getRevYrmon().replaceAll("-", ""));
				Map<String, String> mapVO = estimationByVvdVO.getColumnValues();
				
				
				param.putAll(mapVO);
			    velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EstimationReportDBDAOByVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EstimationByVvdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * revYrmon 의 Monthly Estimation Retrieve
	 * @param String revYrmon
	 * @param String chkRdo
	 * @return List<MonEstmCompVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MonEstmCompVO> searchMonEstmCompList(String revYrmon, String chkRdo) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonEstmCompVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(!"".equals(revYrmon)){
	            Map<String, String> mapVO = new HashMap();
	            mapVO.put("rev_yrmon", revYrmon);
	            mapVO.put("chk_rdo", chkRdo);

	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EstimationReportDBDAOsearchMonEstmCompListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonEstmCompVO.class);
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
	 * Monthly Estimation간의 차이를 Retrieve
	 * @param String revYrmon
	 * @param String chkRdo
	 * @return List<MonEstmCompVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MonEstmCompVO> searchMonEstmCompDiffList(String revYrmon, String chkRdo) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonEstmCompVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(!"".equals(revYrmon)){
	            Map<String, String> mapVO = new HashMap();
	            mapVO.put("rev_yrmon", revYrmon);
	            mapVO.put("chk_rdo", chkRdo);

	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EstimationReportDBDAOsearchMonEstmCompDiffListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonEstmCompVO.class);
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
	 * Raw data : 추정결산 VVD별 집계 
	 * @param String revYrmon
	 * @param String rawFlg
	 * @return List<MonEstmRawDataVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MonEstmRawDataVO> searchMonEstmRawDataListByVvd(String revYrmon, String rawFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonEstmRawDataVO> list = null;
		// parameters
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (!"".equals(revYrmon)) {
				Map<String, String> mapVO = new HashMap();
				mapVO.put("rev_yrmon", revYrmon);
				mapVO.put("raw_flg", rawFlg);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EstimationReportDBDAOsearchMonEstmRawDataListByVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonEstmRawDataVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Raw data : 추정결산 ACCT별 집계 
	 * @param String revYrmon
	 * @param String rawFlg
	 * @return List<MonEstmRawDataVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MonEstmRawDataVO> searchMonEstmRawDataListByAcct(String revYrmon, String rawFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonEstmRawDataVO> list = null;
		// parameters
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (!"".equals(revYrmon)) {
	            Map<String, String> mapVO = new HashMap();
	            mapVO.put("rev_yrmon", revYrmon);
	            mapVO.put("raw_flg", rawFlg);
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EstimationReportDBDAOsearchMonEstmRawDataListByAcctRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonEstmRawDataVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Raw data : 추정결산 YD별 집계 
	 * @param String revYrmon
	 * @param String rawFlg
	 * @return List<MonEstmRawDataVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MonEstmRawDataVO> searchMonEstmRawDataListByYd(String revYrmon, String rawFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonEstmRawDataVO> list = null;
		// parameters
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (!"".equals(revYrmon)) {
				Map<String, String> mapVO = new HashMap();
				mapVO.put("rev_yrmon", revYrmon);
				mapVO.put("raw_flg", rawFlg);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EstimationReportDBDAOsearchMonEstmRawDataListByYdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonEstmRawDataVO.class);
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
	 * 사업계획 추정치 select
	 * @param String revYrmon
	 * @param String scnCd
	 * @return List<MonEstmCompVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MonEstmCompVO> searchMonEstmCompListForBudget(String revYrmon, String scnCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonEstmCompVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(!"".equals(revYrmon) && !"".equals(scnCd)){
	            Map<String, String> mapVO = new HashMap();
	            mapVO.put("rev_yrmon", revYrmon);
	            mapVO.put("bud_str", scnCd);

	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EstimationReportDBDAOsearchMonEstmCompListForBudgetRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonEstmCompVO.class);
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
	 * 당월과 사업계획 추정치의 차를 구한다.
	 * @param String revYrmon
	 * @param String scnCd
	 * @return List<MonEstmCompVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MonEstmCompVO> searchMonEstmCompDiffListWithBudget(String revYrmon, String scnCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonEstmCompVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(!"".equals(revYrmon) && !"".equals(scnCd)){
	            Map<String, String> mapVO = new HashMap();
	            mapVO.put("rev_yrmon", revYrmon);
	            mapVO.put("bud_str", scnCd);

	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EstimationReportDBDAOsearchMonEstmCompDiffListWithBudgetRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonEstmCompVO.class);
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
	 * Raw data for budget : 추정결산 VBP별 집계
	 * @param String revYrmon
	 * @param String scnCd
	 * @return List<MonEstmRawDataForBudVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<MonEstmRawDataForBudVO> searchRawDataByVBPForBudget(String revYrmon, String scnCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonEstmRawDataForBudVO> list = null;
		// parameters
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (!"".equals(revYrmon) && !"".equals(scnCd)) {
				Map<String, String> mapVO = new HashMap();
				mapVO.put("rev_yrmon", revYrmon);
				mapVO.put("bud_str", scnCd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EstimationReportDBDAOsearchRawDataByVBPForBudgetRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonEstmRawDataForBudVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}
	
	/**
	 * Raw data for budget : 추정결산 VVD별 집계
	 * @param String revYrmon
	 * @param String scnCd
	 * @return List<MonEstmRawDataForBudVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<MonEstmRawDataForBudVO> searchRawDataByVvdForBudget(String revYrmon, String scnCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonEstmRawDataForBudVO> list = null;
		// parameters
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (!"".equals(revYrmon) && !"".equals(scnCd)) {
				Map<String, String> mapVO = new HashMap();
				mapVO.put("rev_yrmon", revYrmon);
				mapVO.put("bud_str", scnCd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EstimationReportDBDAOsearchRawDataByVvdForBudgetRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonEstmRawDataForBudVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * Raw data for budget : 추정결산 YD별 집계
	 * @param String revYrmon
	 * @param String scnCd
	 * @return List<MonEstmRawDataForBudVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<MonEstmRawDataForBudVO> searchRawDataByYdForBudget(String revYrmon, String scnCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonEstmRawDataForBudVO> list = null;
		// parameterS
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (!"".equals(revYrmon) && !"".equals(scnCd)) {
				Map<String, String> mapVO = new HashMap();
				mapVO.put("rev_yrmon", revYrmon);
				mapVO.put("bud_str", scnCd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EstimationReportDBDAOsearchRawDataByYdForBudgetRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonEstmRawDataForBudVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * Raw data for budget : 추정결산 ACCT별 집계
	 * @param String revYrmon
	 * @param String scnCd
	 * @return List<MonEstmRawDataForBudVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<MonEstmRawDataForBudVO> searchRawDataByAcctForBudget(String revYrmon, String scnCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonEstmRawDataForBudVO> list = null;
		// parameters
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (!"".equals(revYrmon) && !"".equals(scnCd)) {
				Map<String, String> mapVO = new HashMap();
				mapVO.put("rev_yrmon", revYrmon);
				mapVO.put("bud_str", scnCd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EstimationReportDBDAOsearchRawDataByAcctForBudgetRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MonEstmRawDataForBudVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * 사업계획 select
	 * @param BudgetSmryByVvdVO budgetSmryByVvdVO
	 * @return List<BudgetSmryByVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BudgetSmryByVvdVO> searchBudgetSmryByVvd(BudgetSmryByVvdVO budgetSmryByVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BudgetSmryByVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
			
            if(budgetSmryByVvdVO != null) {
				
			
				Map<String, String> mapVO = budgetSmryByVvdVO.getColumnValues();
			
				param.putAll(mapVO);
			    velParam.putAll(mapVO);
			}

			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EstimationReportDBDAOsearchBudgetSmryByVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BudgetSmryByVvdVO.class);
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
	 * 사업계획 select
	 * @param BudgetSmryByVvdVO budgetSmryByVvdVO
	 * @return List<BudgetSmryByVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BudgetSmryByVvdVO> budgetSmryByMonth(BudgetSmryByVvdVO budgetSmryByVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BudgetSmryByVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
			
            if(budgetSmryByVvdVO != null) {
				
			
				Map<String, String> mapVO = budgetSmryByVvdVO.getColumnValues();
			
				param.putAll(mapVO);
			    velParam.putAll(mapVO);
			}

			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EstimationReportDBDAObudgetSmryByMonthRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BudgetSmryByVvdVO.class);
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