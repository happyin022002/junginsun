/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupManageDBDAO.java
*@FileTitle : Evaluation Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.07.23 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.basic.EvaluationGroupManageBCImpl;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdListVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEgidConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SpeEvGrpVO;


/**
 * ALPS EvaluationGroupManageDBDAO <br>
 * - ALPS-MasterManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author NAMKOONG Jin Ho
 * @see EvaluationGroupManageBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class EvaluationGroupManageDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchEgidConditionVO searchEgidConditionVO
	 * @return List<SearchEGIdListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEGIdListVO> searchEGIdList(SearchEgidConditionVO searchEgidConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEGIdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchEgidConditionVO != null){
				Map<String, String> mapVO = searchEgidConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupManageDBDAOSearchEGIdListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEGIdListVO .class);
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
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 * 
		 * @return List<SearchEGIdAllListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchEGIdAllListVO> searchEGIdAllList() throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchEGIdAllListVO> list = null;

			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupManageDBDAOSearchEGIdAllListRSQL(), null, null);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEGIdAllListVO .class);
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
	  * ALPS EvaluationGroupManageDBDAO <br>
	  * - ALPS-MasterManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
	  * 
	  * @author NAMKOONG Jin Ho
	  * @see EvaluationGroupManageBCImpl 참조
	  * @since J2EE 1.6
	  * @param String egId
	  * @return String
	  * @throws DAOException
	  */
	 public String getEgIdSeq(String egId) throws DAOException{
		 DBRowSet dbRowset = null;
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		 String eg_id_seq = "";
		 
		 try{
				param.put("eg_id", egId);
								
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupManageDBDAOGetEg_id_seqRSQL(), param, velParam);
				
				dbRowset.next();
				eg_id_seq = dbRowset.getString(1);
						
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		
		 
		 return eg_id_seq;	
	 }
	 

	 /**
		 * checking the unique of data
		 * @param String egId
		 * @param String egIdSeq
		 * @return boolean
		 * @throws DAOException
		 */
		public boolean confirmUnique(String egId,String egIdSeq) throws DAOException{
			DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			boolean result = false;
						 
			 try{
					param.put("eg_id", egId);
					param.put("eg_id_seq", egIdSeq);
									
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupManageDBDAOConfirmUniqueRSQL(), param, velParam);
					
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
		 * checking the EG Choicer 
		 * @param String egRhqCd
		 * @param String egCtyCd
		 * @param String svcCateCd
		 * @return boolean
		 * @throws DAOException
		 */
		public boolean confirmLevels(String egRhqCd,String egCtyCd, String svcCateCd) throws DAOException{
			DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			boolean result = false;
						 
			 try{
					param.put("eg_rhq_cd", egRhqCd);
					param.put("eg_cty_cd", egCtyCd);
					param.put("svc_cate_cd", svcCateCd);
									
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupManageDBDAOConfirmLevelsRSQL(), param, velParam);
					
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
	 * @param List<SpeEvGrpVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addSpeEvGrp(List<SpeEvGrpVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupManageDBDAOSpeEvGrpCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpeEvGrpVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifySpeEvGrp(List<SpeEvGrpVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupManageDBDAOSpeEvGrpUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpeEvGrpVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeSpeEvGrp(List<SpeEvGrpVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupManageDBDAOSpeEvGrpDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
}