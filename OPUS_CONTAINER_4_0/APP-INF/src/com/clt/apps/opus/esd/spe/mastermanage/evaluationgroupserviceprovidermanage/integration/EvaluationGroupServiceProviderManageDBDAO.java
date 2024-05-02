/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupServiceProviderManageDBDAO.java
*@FileTitle : EG VS S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.08.03 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEgidConditionVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.basic.EvaluationGroupServiceProviderManageBCImpl;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.vo.SearchEGSPManageVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SpeEvGrpSvcProvMtchVO;


/**
 * ALPS EvaluationGroupServiceProviderManageDBDAO <br>
 * - ALPS-MasterManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author NAMKOONG Jin Ho
 * @see EvaluationGroupServiceProviderManageBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class EvaluationGroupServiceProviderManageDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchEgidConditionVO searchEgidConditionVO
	 * @return List<SearchEGSPManageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEGSPManageVO> searchEGSPManage(SearchEgidConditionVO searchEgidConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEGSPManageVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupServiceProviderManageDBDAOSearchEGSPManageRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEGSPManageVO .class);
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
	 * @param String egId
	 * @return List<SearchEGSPManageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEGSPManageVO> getEgChoicer(String egId) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEGSPManageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(egId != null){
				param.put("eg_id",egId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupServiceProviderManageDBDAOGetEgChoiceRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEGSPManageVO .class);
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
		 * checking the unique of data
		 * @param String egId
		 * @param String egIdSeq
		 * @param String vndrSeq
		 * @return boolean
		 * @throws DAOException
		 */
		public boolean confirmUnique(String egId,String egIdSeq,String vndrSeq) throws DAOException{
			DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
//			Map<String, Object> velParam = new HashMap<String, Object>();
			
			boolean result = false;
						 
			 try{
					param.put("eg_id", egId);
					param.put("eg_id_seq", egIdSeq);
					param.put("vndr_seq", vndrSeq);
									
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupServiceProviderManageDBDAOConfirmUniqueRSQL(), param, null);
					
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
		 * checking the unique of data
		 * @param String egId
		 * @param String egIdSeq
		 * @param String vndrSeq
		 * @return boolean
		 * @throws DAOException
		 */
		public boolean confrimData(String egId,String egIdSeq,String vndrSeq) throws DAOException{
			DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
//			Map<String, Object> velParam = new HashMap<String, Object>();
			
			boolean result = true;
						 
			 try{
					param.put("eg_id", egId);	
					param.put("eg_id_seq", egIdSeq);
					param.put("vndr_seq", vndrSeq);
									
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupServiceProviderManageDBDAOConfrimDataRSQL(), param, null);
					
					if(dbRowset.getRowCount() <= 0 )
					result = false;							
					
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
	 * @param List<SpeEvGrpSvcProvMtchVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addSpeEvGrpSvcProvMtch(List<SpeEvGrpSvcProvMtchVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupServiceProviderManageDBDAOSpeEvGrpSvcProvMtchCSQL(), insModels,null);
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
	 * @param List<SpeEvGrpSvcProvMtchVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifySpeEvGrpSvcProvMtch(List<SpeEvGrpSvcProvMtchVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupServiceProviderManageDBDAOSpeEvGrpSvcProvMtchUSQL(), updModels,null);
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
	 * @param List<SpeEvGrpSvcProvMtchVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeSpeEvGrpSvcProvMtch(List<SpeEvGrpSvcProvMtchVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupServiceProviderManageDBDAOSpeEvGrpSvcProvMtchDSQL(), delModels,null);
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