/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : TargetGroupDBDAO.java
*@FileTitle      : TargetGroup
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성                     
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.basic.TargetGroupBCImpl;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration.TargetGroupDBDAOGetCostManagementPreviousCheckKey0170RSQL;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchCostManagement0170ListVO;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchTargetGroup0014ListVO;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchTargetGroupTrade0013ListVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ModelConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SaqCostApplBseVO;
import com.clt.syscommon.common.table.SaqTgtGrpTrdVO;
import com.clt.syscommon.common.table.SaqTgtGrpVO;


/**
 * TargetGroupDBDAO <br>
 * - BasicDataManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jong-Ho Kim
 * @see TargetGroupBCImpl 참조
 * @since J2EE 1.6
 */
public class TargetGroupDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * ESM_SAQ_0014용 VO
	 * 
	 * @return List<SearchTargetGroup0014ListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchTargetGroup0014ListVO> searchTargetGroup0014List() throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTargetGroup0014ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TargetGroupDBDAOSearchTargetGroup0014ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTargetGroup0014ListVO.class);
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
	 * ESM_SAQ_0014용 VO
	 * @param vo SaqTgtGrpVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addMultiSaqTgtGrp0014(SaqTgtGrpVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TargetGroupDBDAOMultiSaqTgtGrp0014CSQL(), param, velParam);
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
	 * ESM_SAQ_0014용 VO
	 * @param vo SaqTgtGrpVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyMultiSaqTgtGrp0014(SaqTgtGrpVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TargetGroupDBDAOMultiSaqTgtGrp0014USQL(), param, velParam);
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
	 * ESM_SAQ_0014용 VO
	 * @param vo SaqTgtGrpVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeMultiSaqTgtGrp0014(SaqTgtGrpVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TargetGroupDBDAOMultiSaqTgtGrp0014DSQL(), param, velParam);
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
	 * ESM_SAQ_0014용 VO
	 * @param List<SaqTgtGrpVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addMultiSaqTgtGrp0014(List<SaqTgtGrpVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TargetGroupDBDAOMultiSaqTgtGrp0014CSQL(), insModels,null);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * ESM_SAQ_0014용 VO
	 * @param List<SaqTgtGrpVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMultiSaqTgtGrp0014(List<SaqTgtGrpVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TargetGroupDBDAOMultiSaqTgtGrp0014USQL(), updModels,null);
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
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * ESM_SAQ_0014용 VO
	 * @param List<SaqTgtGrpVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeMultiSaqTgtGrp0014(List<SaqTgtGrpVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TargetGroupDBDAOMultiSaqTgtGrp0014DSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
		return delCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * ESM_SAQ_0013용 VO
	 * @param modelConditionVO
	 * @return List<SearchTargetGroupTrade0013ListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchTargetGroupTrade0013ListVO> searchTargetGroupTrade0013List(ModelConditionVO modelConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTargetGroupTrade0013ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(modelConditionVO != null){
				Map<String, String> mapVO = modelConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TargetGroupDBDAOSearchTargetGroupTrade0013ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTargetGroupTrade0013ListVO.class);
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
	 * ESM_SAQ_0013용 VO
	 * @param vo SaqTgtGrpTrdVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addMultiTargetGroupTrade0013(SaqTgtGrpTrdVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TargetGroupDBDAOMultiTargetGroupTrade0013CSQL(), param, velParam);
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
	 * ESM_SAQ_0013용 VO
	 * @param vo SaqTgtGrpTrdVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifySaqTgtGrpTrd0013(SaqTgtGrpTrdVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TargetGroupDBDAOMultiTargetGroupTrade0013USQL(), param, velParam);
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
	 * ESM_SAQ_0013용 VO
	 * @param vo SaqTgtGrpTrdVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeMultiTargetGroupTrade0013(SaqTgtGrpTrdVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TargetGroupDBDAOMultiTargetGroupTrade0013DSQL(), param, velParam);
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
	 * ESM_SAQ_0013용 VO
	 * @param List<SaqTgtGrpTrdVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addMultiTargetGroupTrade0013(List<SaqTgtGrpTrdVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TargetGroupDBDAOMultiTargetGroupTrade0013CSQL(), insModels,null);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * ESM_SAQ_0013용 VO
	 * @param List<SaqTgtGrpTrdVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMultiTargetGroupTrade0013(List<SaqTgtGrpTrdVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TargetGroupDBDAOMultiTargetGroupTrade0013USQL(), updModels,null);
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
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * ESM_SAQ_0013용 VO
	 * @param List<SaqTgtGrpTrdVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeMultiTargetGroupTrade0013(List<SaqTgtGrpTrdVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TargetGroupDBDAOMultiTargetGroupTrade0013DSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
		return delCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * ESM_SAQ_0170용 VO
	 * @param bse_yr
	 * @param bse_qtr_cd
	 * @return List<SearchCostManagement0170ListVO>
	 * @throws DAOException
	 */ 
	 @SuppressWarnings("unchecked")
	public List<SearchCostManagement0170ListVO> searchCostManagement0170List(String bse_yr, String bse_qtr_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCostManagement0170ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bse_yr != null && bse_qtr_cd != null){
				param.put("bse_yr",bse_yr);
				param.put("bse_qtr_cd", bse_qtr_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TargetGroupDBDAOSearchCostManagement0170ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostManagement0170ListVO .class);
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
	 * ESM_SAQ_0170용 VO
	 * @param vo SaqCostApplBseVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addMultiCostManagementSave0170(SaqCostApplBseVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TargetGroupDBDAOMultiCostManagementSave0170CSQL(), param, velParam);
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
	 * ESM_SAQ_0170용 VO
	 * @param List<SaqCostApplBseVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addMultiCostManagementSave0170(List<SaqCostApplBseVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TargetGroupDBDAOMultiCostManagementSave0170CSQL(), insModels,null);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * ESM_SAQ_0170용 VO
	 * @param bse_yr
	 * @param bse_qtr_cd
	 * @param cre_usr_id
	 * @param copyBse_yr
	 * @param copyBse_qtr_cd
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addMultiCostManagementCopy0170(String bse_yr, String bse_qtr_cd, String cre_usr_id, String copyBse_yr, String copyBse_qtr_cd) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
//			Map<String, String> mapVO = vo.getColumnValues();
			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
			
			param.put("bse_yr",bse_yr);
			param.put("bse_qtr_cd", bse_qtr_cd);
			param.put("cre_usr_id", cre_usr_id);
			param.put("copyBse_yr", copyBse_yr);
			param.put("copyBse_qtr_cd", copyBse_qtr_cd);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TargetGroupDBDAOMultiCostManagementCopy0170CSQL(), param, velParam);
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
	 * ESM_SAQ_0170용 VO
	 * @param bse_yr
	 * @param bse_qtr_cd
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeMultiCostManagementCopy0170(String bse_yr, String bse_qtr_cd) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			
			param.put("bse_yr", bse_yr);
			param.put("bse_qtr_cd", bse_qtr_cd);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TargetGroupDBDAOMultiCostManagementCopy0170DSQL(), param, velParam);
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
	 * ESM_SAQ_0170용 VO
	 * @param List<SaqCostApplBseVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addMultiCostManagementCopy0170(List<SaqCostApplBseVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TargetGroupDBDAOMultiCostManagementCopy0170CSQL(), insModels,null);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * ESM_SAQ_0170용 VO
	 * @param List<SaqCostApplBseVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeMultiCostManagementCopy0170(List<SaqCostApplBseVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TargetGroupDBDAOMultiCostManagementCopy0170DSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
		return delCnt;
	}
		
	/**
	 * Year/Month set for Cost Management 화면에 조회한 내용의 바로 전 최신 DATA 조회.<br>
	 * ESM_SAQ_0170용 command02를 위해 넣은 메소드 쿼리
	 * @param bse_yr
	 * @param bse_qtr_cd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet getCostManagementPreviousCheckKey0170(String bse_yr, String bse_qtr_cd) throws DAOException {
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			param.put("bse_yr", bse_yr);
			param.put("bse_qtr_cd", bse_qtr_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TargetGroupDBDAOGetCostManagementPreviousCheckKey0170RSQL(), param, velParam);
			
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
	 * [Year/Month Set for Cost Management] Create Initial Data 버튼 활성화 유무에 대한 처리를 위해 해당 테이블에 데이터 존재 유무를 체크. <br>
	 * 
	 * @param bse_yr
	 * @param bse_qtr_cd
	 * @return String
	 * @exception EventException
	 */
	public String searchCostManagementExistCheck0170(String bse_yr ,String bse_qtr_cd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String existChreck = "OK";
		try{
			param.put("bse_yr", bse_yr);
			param.put("bse_qtr_cd", bse_qtr_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TargetGroupDBDAOSearchCostManagementExistCheck0170RSQL(), param, velParam);
			if(!dbRowset.next()){
				existChreck = "NO";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return existChreck;
	}
}