/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MonthlyQuotaCfmAdjustmentDBDAO.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.basic.MonthlyQuotaCfmAdjustmentBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.vo.SearchMonthlyQtaEditListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SaqMonCfmQtaOfcAddVO;
import com.clt.syscommon.common.table.SaqMonCfmQtaVO;
import com.clt.syscommon.common.table.SaqMonCfmTgtVvdVO;


/**
 * MonthlyQuotaCfmAdjustmentDBDAO <br>
 * - MonthlySalesQuotaManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Ju Sun Young
 * @see MonthlyQuotaCfmAdjustmentBCImpl 참조
 * @since J2EE 1.6
 */
public class MonthlyQuotaCfmAdjustmentDBDAO extends DBDAOSupport {
    
	/**
	 * MonthlyTargetVVD의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQtaEditListVO>
	 * @throws DAOException
	 * 
	 * 2008-05-06 : with절 삭제, AND의 OR부분 삭제
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMonthlyQtaEditListVO> searchMonthlyTargetVVDMapping0164List(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<SearchMonthlyQtaEditListVO> list = null;
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyTargetVVDMapping0164ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQtaEditListVO .class);
			
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
	 * MonthlyTargetVVD의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQtaEditListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMonthlyQtaEditListVO> searchMonthlyTargetVVDMappingOrg0164List(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<SearchMonthlyQtaEditListVO> list = null;
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				int mon1 = 0;
				int mon2 = 0;
				int quarter = Integer.parseInt(conditionVO.getQuarter().substring(0,1));
				
				mon1 = (quarter-1)*3 + 1;
				mon2 = mon1 + 2;
				
				String month1 = (mon1<10?"0":"")+mon1;
				String month2 = (mon2<10?"0":"")+mon2;
				
				param.put("month1", month1);
				param.put("month2", month2);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyTargetVVDMappingOrg0164ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQtaEditListVO .class);
			
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
	 * 주차별 대상 항차/운항리수를 구한다.<br>
	 * 
	 * @param List<SaqMonCfmTgtVvdVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void updateSaqMonCfmTgtVvd0164(List<SaqMonCfmTgtVvdVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Map resultMap  = null;
		
		String outCode = "";
		String outMsg  = "";
		
		SaqMonCfmTgtVvdVO saqMonCfmVO =  null;
		
		try {
			
			for(int i=0; i < updModels.size(); i++){
				
				saqMonCfmVO = new SaqMonCfmTgtVvdVO();
				saqMonCfmVO = updModels.get(i);
				
				Map<String, String> mapVO = saqMonCfmVO .getColumnValues();
				
				param.putAll(mapVO);
				
				param.put("out_code" , ""); // (!주의) 파라메터 추가시 체크
				param.put("out_msg"  , "");
				
				resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOCallSaqMonCfmQtaAdjPkg0164CSQL(), param, velParam);
				
				outCode = (String) resultMap.get("out_code");
				outMsg  = (String) resultMap.get("out_msg");
				
				if(!"00000".equals(outCode)) {
					log.debug(" error code    : " + outCode);
					log.debug(" error message : " + outMsg);
					break;
				}
				
			}
			
			if(!outCode.equals("00000")){
				throw new EventException(new ErrorHandler("SAQ00099", new String[]{ outMsg}).getMessage());
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
	 * searchMonthlyQtaEditList 조회<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQtaEditListVO>
	 * @throws DAOException
	 * 
	 * 2008-04-10 Lee Ho Ik  - QTA Editing 조회 
	 * 2009-10-19 Kim Min Ah - 권한에 따른 파라미터 추가 (CSR No. CHM-200901271)
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMonthlyQtaEditListVO> searchMonthlyQtaEdit0165List(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<SearchMonthlyQtaEditListVO> list = null;
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				velParam.put("ofcTpCd", conditionVO.getOfcTpCd());
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQtaEditList0165RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQtaEditListVO .class);
			
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
	 * QTA Editing Upload Save 처리<br>
	 * cost_upd_flg의 의미를 변경하여 사용.
	 * @param List<SaqMonCfmQtaVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateSaqMonCfmQta0165A(List<SaqMonCfmQtaVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt[] = null;
		
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			// saq_mon_cfm_qta update
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOUpdateSaqMonCfmQtaA0165USQL(), updModels, velParam);
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
	 * QTA Editing Upload Save 처리<br>
	 * cost_upd_flg의 의미를 변경하여 사용.
	 * @param List<SaqMonCfmQtaVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateSaqMonCfmQta0165B(List<SaqMonCfmQtaVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int updCnt[] = null;
		
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			// saq_mon_cfm_qta update
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOUpdateSaqMonCfmQtaB0165USQL(), updModels, velParam);
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
	 * VVD Select Popup화면에 대한 조회 <br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQtaEditListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMonthlyQtaEditListVO> searchMonthlyVVD0166List(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<SearchMonthlyQtaEditListVO> list = null;
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyVVDList0166RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQtaEditListVO .class);
			
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
	 * Quota Editing - Office Add Popup List 조회<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQtaEditListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMonthlyQtaEditListVO> searchMonthlyQuotaEditOfficeAdd0167List(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<SearchMonthlyQtaEditListVO> list = null;
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditOfficeAdd0167ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQtaEditListVO .class);
			
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
	 * Quota Editing - Office Add Popup 새로 추가할 Office List 조회<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQtaEditListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMonthlyQtaEditListVO> searchMonthlyQuotaEditOfficeAddNew0167List(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<SearchMonthlyQtaEditListVO> list = null;
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditOfficeAddNew0167ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQtaEditListVO .class);
			
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
	 * Quota Editing - Lane Add Popup 새로 추가할 Lane에 해당하는 Office List 조회<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<SearchMonthlyQtaEditListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMonthlyQtaEditListVO> searchMonthlyQuotaEditLaneOfficeAddNew0167List(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<SearchMonthlyQtaEditListVO> list = null;
		String mon = null;
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				mon = SAQUtil.getYrQtrToYrMon(conditionVO.getBse_yr()+conditionVO.getBse_qtr_cd()).substring(4, 6);
				
				param.put("mon", mon);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditLaneOfficeAddNew0167ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQtaEditListVO .class);
			
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
	 * Quota Editing - Office Add Popup 관련 Data 처리<br>
	 * @param List<SaqMonCfmQtaOfcAddVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 * 
	 * 2008-05-29 Y.S.CHOI   : CSR No. R200805226856 - Misc Rev amt 로직 추가
	 * 2009-04-21 Kim Min Ah : CSR No. N200904170012 - CM 산식 변경으로 인해 dmdt_ut_amt 제거
	 */
	public void multiMonthlyQuotaEditOfficeAddA0167(List<SaqMonCfmQtaOfcAddVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt[] = null;
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmQtaOfcAdd0167CSQL(), updModels, velParam);
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
	 * Quota Editing - Office Add Popup 관련 Data 처리<br>
	 * @param List<SaqMonCfmQtaOfcAddVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 * 
	 * 2008-05-29 Y.S.CHOI   : CSR No. R200805226856 - Misc Rev amt 로직 추가
	 * 2009-04-21 Kim Min Ah : CSR No. N200904170012 - CM 산식 변경으로 인해 dmdt_ut_amt 제거
	 */
	public void multiMonthlyQuotaEditOfficeAddB0167(List<SaqMonCfmQtaOfcAddVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt[] = null;
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				velParam.putAll(mapVO);
				
			}
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOUpdateSaqMonCfmQtaOfcAdd0167USQL(), updModels, velParam);
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
	 * Quota Editing - Office Add Popup 관련 Data 처리<br>
	 * @param List<SaqMonCfmQtaOfcAddVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 * 
	 * 2008-05-29 Y.S.CHOI   : CSR No. R200805226856 - Misc Rev amt 로직 추가
	 * 2009-04-21 Kim Min Ah : CSR No. N200904170012 - CM 산식 변경으로 인해 dmdt_ut_amt 제거
	 */
	public void multiMonthlyQuotaEditOfficeAddC0167(List<SaqMonCfmQtaOfcAddVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt[] = null;
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmTgtVvd0167CSQL(), updModels, velParam);
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
	 * Quota Editing - Office Add Popup 관련 Data 처리<br>
	 * @param List<SaqMonCfmQtaOfcAddVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @param String unitCostFlag
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiMonthlyQuotaEditOfficeAddD0167(List<SaqMonCfmQtaOfcAddVO> updModels, QuotaConditionVO conditionVO, String unitCostFlag) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("unit_cost_flag", unitCostFlag);
		velParam.put("add_tp_cd", updModels.get(0).getAddTpCd());
		int updCnt[] = null;
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmQta0167CSQL(), updModels, velParam);
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
	 * Quota Editing - Office Add Popup 관련 Data 처리<br>
	 * @param List<SaqMonCfmQtaOfcAddVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 * 
	 * 2008-05-29 Y.S.CHOI   : CSR No. R200805226856 - Misc Rev amt 로직 추가
	 * 2009-04-21 Kim Min Ah : CSR No. N200904170012 - CM 산식 변경으로 인해 dmdt_ut_amt 제거
	 */
	public void multiMonthlyQuotaEditOfficeAddE0167(List<SaqMonCfmQtaOfcAddVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt[] = null;
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				velParam.putAll(mapVO);
				
			}
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAODeleteSaqMonCfmQta0167DSQL(), updModels, velParam);
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
	 * Quota Editing - Office Add Popup 관련 Data 처리<br>
	 * @param List<SaqMonCfmQtaOfcAddVO> updModels
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception	
	 */
	public void multiMonthlyQuotaEditOfficeAddF0167(List<SaqMonCfmQtaOfcAddVO> updModels, QuotaConditionVO conditionVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt[] = null;
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				velParam.putAll(mapVO);
				
			}
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAODeleteSaqOfcAdd0167DSQL(), updModels, velParam);
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
	 * Check SAQ_AVG_COST_OFC Count<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkAvgCostOfcCnt(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "N";
		
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaCfmAdjustmentDBDAOCheckAvgCostOfcCntRSQL(), param, velParam);
			if(dbRowset!=null) {
				if(dbRowset.next()) {
					if(dbRowset.getInt("cnt") > 0) {
						rtnVal = "Y";
					}
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}
	
}