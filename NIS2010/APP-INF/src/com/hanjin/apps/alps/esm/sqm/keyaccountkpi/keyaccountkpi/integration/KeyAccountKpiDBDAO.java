/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : KeyAccountKpiDBDAO.java
*@FileTitle      : KeyAccountKpi
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.08.13
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.08.13 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.basic.KeyAccountKpiBCImpl;
import com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.vo.SearchKpiUploadVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.SqmKeyAcctCfmQtaVO;

/**
 * ALPS KeyAccountKpiDBDAO <br>
 * - ALPS-KeyAccountKpi system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 이혜민
 * @see KeyAccountKpiBCImpl 참조
 * @since J2EE 1.6
 */
public class KeyAccountKpiDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * ESM_SQM_0601 : [SEARCH]<br>
	 * [KPI Upload]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchKpiUploadVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchKpiUploadVO> searchKpiUpload(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchKpiUploadVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new KeyAccountKpiDBDAOSearchKpiUploadRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchKpiUploadVO .class);
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
	 * ESM_SQM_0601 : [SEARCH]<br>
	 * [KPI Upload]을 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchKpiUploadCnt(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dataCnt = "0";
		
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new KeyAccountKpiDBDAOSearchKpiUploadCntRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					dataCnt = dbRowset.getString(1);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dataCnt;
	}
	
	/**
	 * ESM_SQM_0601 : [SEARCH01]<br>
	 * [KPI Upload]화면에서 Yearly 조회 후 Quarterly 1Q 데이터가 있는지 없는지 [확인]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String search1QTransferDataCnt(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dataCnt = "0";
		
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new KeyAccountKpiDBDAOSearch1QTransferDataCntRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					dataCnt = dbRowset.getString(1);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dataCnt;
	}

	/**
	 * ESM_SQM_0601 : [MULTI]<br>
	 * [KPI Upload]을 [modify] 합니다.<br>
	 * @param List<SqmKeyAcctCfmQtaVO> insUpdVoList
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyKpiUpload(List<SqmKeyAcctCfmQtaVO> insUpdVoList) throws DAOException,Exception {
		int istCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(insUpdVoList.size() > 0){
				istCnt = sqlExe.executeBatch((ISQLTemplate)new KeyAccountKpiDBDAOModifyKpiUploadUSQL(), insUpdVoList, null);
				for(int i = 0; i < istCnt.length; i++){
					if(istCnt[i]== Statement.EXECUTE_FAILED)
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
	 * ESM_SQM_0601 : [MULTI01]<br>
	 * [KPI Upload]화면에서 [1Q Data]을 [Transfer] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String create1QTransferData(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		String istCnt = null;
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new KeyAccountKpiDBDAOCreate1QTransferDataCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			istCnt = Integer.toString(result); 

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return istCnt;
	}
	
}