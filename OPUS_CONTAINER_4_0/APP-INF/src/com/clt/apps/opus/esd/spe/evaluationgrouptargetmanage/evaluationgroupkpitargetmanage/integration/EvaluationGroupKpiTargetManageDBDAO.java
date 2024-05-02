/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupKpiTargetManageDBDAO.java
*@FileTitle : KPI Target
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.08.05 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.basic.EvaluationGroupKpiTargetManageBCImpl;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.vo.SearchEGKpiTargetConditionVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.vo.SearchEGKpiTargetManageVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.integration.EvaluationGroupServiceProviderManageDBDAOGetEgIdRSQL;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SpeEvGrpKpiTgtRtoVO;


/**
 * ALPS EvaluationGroupKpiTargetManageDBDAO <br>
 * - ALPS-EvaluationGroupTargetManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author NAMKOONG Jin Ho
 * @see EvaluationGroupKpiTargetManageBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class EvaluationGroupKpiTargetManageDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchEGKpiTargetConditionVO searchEGKpiTargetConditionVO
	 * @return List<SearchEGKpiTargetManageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEGKpiTargetManageVO> searchEGKpiTargetManage(SearchEGKpiTargetConditionVO searchEGKpiTargetConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEGKpiTargetManageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchEGKpiTargetConditionVO != null){
				Map<String, String> mapVO = searchEGKpiTargetConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupKpiTargetManageDBDAOSearchEGKpiTargetManageRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEGKpiTargetManageVO .class);
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
		 * 
		 * @param String egId
		 * @param String spKpiCd
		 * @param String evYr
		 * @return boolean
		 * @throws DAOException
		 */
		public boolean confirmUnique(String egId,String spKpiCd,String evYr) throws DAOException{
			DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			boolean result = false;
						 
			 try{
					param.put("eg_id", egId);			
					param.put("sp_kpi_cd",spKpiCd);
					param.put("ev_yr", evYr);

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupKpiTargetManageDBDAOCofirmUniqueRSQL(), param, velParam);
					
					if(dbRowset.getRowCount() <= 0 )
					result = true;							
					
				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
			return result;
		}
	 
		/**
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 * 
		 * @param String egRhqCd
		 * @param String egCtyCd
		 * @param String svcCateCd
		 * @return String
		 * @throws DAOException
		 */
	public String getEgId(String egRhqCd,String egCtyCd,String svcCateCd)throws DAOException{
		 String eg_id="";
		 DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
//			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(egRhqCd != null){
					
					param.put("eg_rhq_cd", egRhqCd);
					param.put("eg_cty_cd", egCtyCd);
					param.put("svc_cate_cd", svcCateCd);
					
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupServiceProviderManageDBDAOGetEgIdRSQL(), param, null);
				if(dbRowset.getRowCount() > 0 && dbRowset.next())
					eg_id = (String)dbRowset.getString(1);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		 return eg_id;	 
		 }
	
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpeEvGrpKpiTgtRtoVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiEGKpiTargetManageS(List<SpeEvGrpKpiTgtRtoVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupKpiTargetManageDBDAOSpeEvGrpKpiTgtRtoCSQL(), insModels,null);
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
	 * 
	 * @param List<SpeEvGrpKpiTgtRtoVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiEGKpiTargetManageS(List<SpeEvGrpKpiTgtRtoVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupKpiTargetManageDBDAOSpeEvGrpKpiTgtRtoUSQL(), updModels,null);
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
	 * 
	 * @param List<SpeEvGrpKpiTgtRtoVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiEGKpiTargetManageS(List<SpeEvGrpKpiTgtRtoVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupKpiTargetManageDBDAOSpeEvGrpKpiTgtRtoDSQL(), delModels,null);
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
	
}