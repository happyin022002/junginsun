/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : MonthlyTargetVVDDBDAO.java
*@FileTitle      : Target VVD/Supply Inquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.basic.MonthlyTargetVVDBCImpl;
import com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.vo.MonthlyTargetVVDInquiryVO;
import com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.vo.MonthlyTargetVVDManagementVO;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SaqMonTgtVvdVO;


/**
 * MonthlyTargetVVDDBDAO <br>
 * - BasicDataManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author taeho, Kim
 * @see MonthlyTargetVVDBCImpl 참조
 * @since J2EE 1.6
 */
public class MonthlyTargetVVDDBDAO extends DBDAOSupport {

	/**
	 * [MonthlyTargetVVDInquiry]을 [조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyTargetVVDInquiryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MonthlyTargetVVDInquiryVO> searchMonthlyTargetVVDInquiry0154List01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonthlyTargetVVDInquiryVO> returnVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0154RSQL(), param, velParam);
			returnVO = (List)RowSetUtil.rowSetToVOs(dbRowset, MonthlyTargetVVDInquiryVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}	 

	/**
	 * ESM_SAQ_0040 : [이벤트]<br>
	 * [Target VVD/Supply Management  save 가능여부 체크 ]을 [조회]합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyTargetVVDManagementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchMonthlyTargetVVD0040Tab01SaveChk(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String retval = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0040Tab01SaveChkRSQL(), param, velParam);
			
			if (dbRowset.next()){
				retval = dbRowset.getString("CHK_YN");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}	
	
	/**
	 * ESM_SAQ_0040 : [이벤트]<br>
	 * [Target VVD/Supply Management 1tab Information]을 [조회]합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyTargetVVDManagementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MonthlyTargetVVDManagementVO> searchMonthlyTargetVVD0040Tab01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonthlyTargetVVDManagementVO> returnVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyTargetVVDDBDAOSearchMonthlyTargetVVD0040Tab01RSQL(), param, velParam);
			returnVO = (List)RowSetUtil.rowSetToVOs(dbRowset, MonthlyTargetVVDManagementVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}	

	/**
	 * ESM_SAQ_0040 : [이벤트]<br>
	 * [Target VVD/Supply Management 1tab Information의 Org]을 [조회]합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyTargetVVDManagementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MonthlyTargetVVDManagementVO> searchMonthlyTargetVVDOrg0040Tab01(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonthlyTargetVVDManagementVO> returnVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			int month;
			int month2;
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				int quarter2 = Integer.parseInt(mapVO.get("quarter").substring(0,1));
				month = (quarter2-1)*3 + 1;
				month2 = month + 2;
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("month", (month<10?"0":"")+month);
				param.put("month2", (month2<10?"0":"")+month2);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyTargetVVDDBDAOSearchMonthlyTargetVVDOrg0040Tab01RSQL(), param, velParam);
			returnVO = (List)RowSetUtil.rowSetToVOs(dbRowset, MonthlyTargetVVDManagementVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}	

	/**
	 * ESM_SAQ_0040 : [이벤트]<br>
	 * [Target VVD/Supply Management 2tab Group]을 [조회]합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyTargetVVDManagementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MonthlyTargetVVDManagementVO> searchMonthlyTargetVVDGroup0040Tab02(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonthlyTargetVVDManagementVO> returnVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyTargetVVDDBDAOSearchMonthlyTargetVVDGroup0040Tab02RSQL(), param, velParam);
			returnVO = (List)RowSetUtil.rowSetToVOs(dbRowset, MonthlyTargetVVDManagementVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
	/**
	 * ESM_SAQ_0040 : [Save]<br>
	 * [Target VVD/Supply Management ]을 [등록]합니다.<br>
	 * 
	 * @param List<SaqMonTgtVvdVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] multiMonthlyTargetVVDInsert0040(List<SaqMonTgtVvdVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyTargetVVDDBDAOMultiMonthlyTargetVVDInsert0040CSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
		return insCnt;
	}	

	/**
	 * ESM_SAQ_0040 : [Save]<br>
	 * [Target VVD/Supply Management ]을 [수정]합니다.<br>
	 * 
	 * @param List<SaqMonTgtVvdVO> uptModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] multiMonthlyTargetVVDUpdate0040(List<SaqMonTgtVvdVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(uptModels.size() > 0){
				uptCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyTargetVVDDBDAOMultiMonthlyTargetVVDUpdate0040USQL(), uptModels,null);
				for(int i = 0; i < uptCnt.length; i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return uptCnt;
	}	
	
	/**
	 * ESM_SAQ_0040 : [Save]<br>
	 * [Target VVD/Supply Management ]을 [삭제]합니다.<br>
	 * 
	 * @param  List<SaqMonTgtVvdVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] multiMonthlyTargetVVDDelete0040(List<SaqMonTgtVvdVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyTargetVVDDBDAOMultiMonthlyTargetVVDDelete0040DSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}	
	
	/**
	 * ESM_SAQ_0040 : [Cancel SKD Copy]<br>
	 * [Target VVD/Supply Management ]을 [Cancel SKD Copy]합니다.<br>
	 * skd copy가 가능한 상태인지 확인하기위해 상태값조회
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyTargetVVDManagementVO> 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MonthlyTargetVVDManagementVO> searchTgtVVDStsCdCopy0040(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonthlyTargetVVDManagementVO> returnVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyTargetVVDDBDAOSearchTgtVVDStsCdCopy0040RSQL(), param, velParam);
			returnVO = (List)RowSetUtil.rowSetToVOs(dbRowset, MonthlyTargetVVDManagementVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}	
	
	/**
	 * ESM_SAQ_0040 : [Cancel SKD Copy]<br>
	 * [Target VVD/Supply Management ]을 [Cancel SKD Copy]합니다.<br>
	 * 
	 * @param String stsCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchComIntgCdDtl0040(String stsCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("stsCd", stsCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyTargetVVDDBDAOSearchComIntgCdDtl0040RSQL(), param, velParam);
			while (dbRowset.next()) {
				stsCd = dbRowset.getString("sts_text");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return stsCd;
	}	


	
	/**
	 * ESM_SAQ_0040 : [Cancel SKD Copy]<br>
	 * [Target VVD/Supply Management ]을 [Cancel SKD Copy]합니다.<br>
	 * cancel skd copy가 가능한지 확인한다.
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTgtVVDStsCdCancel0040(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyTargetVVDDBDAOSearchTgtVVDStsCdCancel0040RSQL(), param, velParam);
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
	 * ESM_SAQ_0040 : [Cancel SKD Copy Message]<br>
	 * [Target VVD/Supply Management ]을 [Cancel SKD Copy Message생성]합니다.<br>
	 * Copy Message생성
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSKDCopyMessage0040(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyTargetVVDDBDAOSearchSKDCopyMessage0040RSQL(), param, velParam);
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
	 * ESM_SAQ_0040 : [Cancel SKD Copy]<br>
	 * [Target VVD/Supply Management ]을 [Cancel SKD Copy]합니다.<br>
	 *  SAQ_MON_TGT_VVD의 tgt_vvd_sts_cd를 수정<br>
	 *  
	 * @param QuotaConditionVO vo
	 * @param String sts
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySaqMonTgtVvd0040(QuotaConditionVO vo,String sts) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("tgt_vvd_sts_cd", sts);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyTargetVVDDBDAOModifySaqMonTgtVvd0040USQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * ESM_SAQ_0040 : [Confirm]<br>
	 * [Target VVD/Supply Management]을 [Confirm]합니다.<br>
	 *  SAQ_MON_TGT_VVD의 tgt_vvd_sts_cd를 C로 수정<br>
	 *  
	 * @param QuotaConditionVO vo
	 * @param String sts
	 * @throws DAOException
	 * @throws Exception
	 */
	public void processConfirm0040(QuotaConditionVO vo,String sts) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("tgt_vvd_sts_cd", sts);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyTargetVVDDBDAOProcessConfirm0040USQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

}